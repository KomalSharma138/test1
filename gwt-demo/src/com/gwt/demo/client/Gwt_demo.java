package com.gwt.demo.client;

import com.gwt.demo.shared.FieldVerifier;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.state.client.GridStateHandler;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Resizable;
import com.sencha.gxt.widget.core.client.Resizable.Dir;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.grid.CellSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.GridSelectionModel;
import com.sencha.gxt.widget.core.client.selection.CellSelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.CellSelectionChangedEvent.CellSelectionChangedHandler;
import com.sencha.gxt.widget.core.client.tips.QuickTip;
import com.sencha.gxt.widget.core.client.tips.ToolTipConfig;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

import com.sencha.gxt.widget.core.client.grid.Grid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.canvas.dom.client.Context;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
//import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt_demo implements IsWidget,  EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";
    
	 protected static final int MAX_HEIGHT = 600;
	  protected static final int MAX_WIDTH = 800;
	  protected static final int MIN_HEIGHT = 320;
	  protected static final int MIN_WIDTH = 480;
	 private ContentPanel panel;
	
	 private static final StockProperties props = GWT.create(StockProperties.class);
	/**
	 * This is the entry point method.
	 */
	
	TextBox normalText;
	Label label ;
	public void onModuleLoad() {
		
		
		VerticalPanel vPanel = new VerticalPanel();
        this.label = new Label(" Enter your Name:  ");
        this.normalText = new TextBox();
        vPanel.add(label);
        vPanel.add(normalText);
        Button normalButton = new Button();
        normalButton.setText("Submit");
        normalButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String text = normalText.getText();
				label.setText(text);
			}
		});
     /*   Grid grid = new Grid(2, 2);

            // Add images to the grid
            int numRows = grid.getRowCount();
            int numColumns = grid.getColumnCount();
            for (int row = 0; row < numRows; row++) {
              for (int col = 0; col < numColumns; col++) {
                grid.setWidget(0, 0, label);
                grid.setWidget(0, 1, normalText);
                
                grid.setWidget(1, 0, new Label(" Submit your Details:  "));
                grid.setWidget(1, 1, normalButton);
                
              }
            }
                vPanel.add(grid);
                RootPanel.get().add(vPanel);*/
                RootPanel.get().add(asWidget());

	}
	@Override
	public Widget asWidget() {
		if(panel == null)
		{

		      final NumberFormat number = NumberFormat.getFormat("0.00");
			  ColumnConfig<Stock, String> nameCol = new ColumnConfig<Stock, String>(props.name(), 50, "Company");
		      ColumnConfig<Stock, String> symbolCol = new ColumnConfig<Stock, String>(props.symbol(), 75, "Symbol");
		      ColumnConfig<Stock, Double> lastCol = new ColumnConfig<Stock, Double>(props.last(), 75, "Last");
		      ColumnConfig<Stock, Double> changeCol = new ColumnConfig<Stock, Double>(props.change(), 75, "Change");
		      changeCol.setCell(new AbstractCell<Double>() {
		    	  
		          @Override
		          public void render(Context context, Double value, SafeHtmlBuilder sb) {
		            String style = "style='color: " + (value < 0 ? "red" : "green") + "'";
		            String v = number.format(value);
		            sb.appendHtmlConstant("<span " + style + " qtitle='Change' qtip='" + v + "'>" + v + "</span>");
		          }
		        });
		   
		        ColumnConfig<Stock, Date> lastTransCol = new ColumnConfig<Stock, Date>(props.lastTrans(), 100, "Last Updated");
		        lastTransCol.setCell(new DateCell(DateTimeFormat.getFormat("MM/dd/yyyy")));
		   
		        List<ColumnConfig<Stock, ?>> l = new ArrayList<ColumnConfig<Stock, ?>>();
		        l.add(nameCol);
		        l.add(symbolCol);
		        l.add(lastCol);
		        l.add(changeCol);
		        l.add(lastTransCol);
		        ColumnModel<Stock> cm = new ColumnModel<Stock>(l);
		   
		        ListStore<Stock> store = new ListStore<Stock>(props.key());
		      
		        store.addAll(TestData.getStocks());
		        panel = new ContentPanel();
		        panel.setHeading("Basic Grid");
		      //  panel.getHeader().setIcon(ExampleImages.INSTANCE.table());
		        panel.setPixelSize(600, 300);
		        panel.addStyleName("margin-10");
		         
		        ToolButton info = new ToolButton(ToolButton.QUESTION);
		        ToolTipConfig config = new ToolTipConfig("Example Info", "This examples includes resizable panel, reorderable columns and grid state.");
		        config.setMaxWidth(225);
		        info.setToolTipConfig(config);
		        panel.addTool(info);
		         
		        new Resizable(panel, Dir.E, Dir.SE, Dir.S);
		   
		        final Grid<Stock> grid = new Grid<Stock>(store, cm);
		        grid.getView().setAutoExpandColumn(nameCol);
		        grid.getView().setStripeRows(true);
		        grid.getView().setColumnLines(true);
		        grid.setBorders(false);
		   
		        grid.setColumnReordering(true);
		        grid.setStateful(true);
		        grid.setStateId("gridExample");
		   
		        GridStateHandler<Stock> state = new GridStateHandler<Stock>(grid);
		        state.loadState();
		   
		        ToolBar toolBar = new ToolBar();
		        toolBar.add(new LabelToolItem("Selection Mode: "));
		   
		        SimpleComboBox<String> type = new SimpleComboBox<String>(new StringLabelProvider<String>());
		        type.setTriggerAction(TriggerAction.ALL);
		        type.setEditable(false);
		        type.setWidth(100);
		        type.add("Row");
		        type.add("Cell");
		        type.setValue("Row");
		        // we want to change selection model on select, not value change which fires on blur
		        type.addSelectionHandler(new SelectionHandler<String>() {
		   
		          @Override
		          public void onSelection(SelectionEvent<String> event) {
		            boolean cell = event.getSelectedItem().equals("Cell");
		            if (cell) {
		              CellSelectionModel<Stock> c = new CellSelectionModel<Stock>();
		              c.addCellSelectionChangedHandler(new CellSelectionChangedHandler<Stock>() {
		   
		                @Override
		                public void onCellSelectionChanged(CellSelectionChangedEvent<Stock> event) {
		   
		                }
		              });
		   
		              grid.setSelectionModel(c);
		            } else {
		              grid.setSelectionModel(new GridSelectionModel<Stock>());
		            }
		          }
		        });
		        type.addValueChangeHandler(new ValueChangeHandler<String>() {
		   
		          @Override
		          public void onValueChange(ValueChangeEvent<String> event) {
		   
		          }
		        });
		        toolBar.add(type);
		   
		        VerticalLayoutContainer con = new VerticalLayoutContainer();
		        panel.setWidget(con);
		   
		        con.add(toolBar, new VerticalLayoutData(1, -1));
		        con.add(grid, new VerticalLayoutData(1, 1));
		   
		        // needed to enable quicktips (qtitle for the heading and qtip for the
		        // content) that are setup in the change GridCellRenderer
		        new QuickTip(grid);
		      }
		   
		      return panel;
		}
		
}
