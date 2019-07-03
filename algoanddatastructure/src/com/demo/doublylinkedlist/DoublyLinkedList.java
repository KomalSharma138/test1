package com.demo.doublylinkedlist;

import com.demo.doublylinkedlist.Node;

public class DoublyLinkedList {
	
	private Node head;
	
	public void insrtatHead(int data)
	{
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		if(this.head !=null)
		{
		this.head.setPrevNode(newNode);
		}
		this.head = newNode;
	}
	
	@Override
	public String toString()
	{
		  String result = "{";
		   Node current = this.head;
		   while(current!=null)
		   {
			   result+=current+",";
			   current = current.getNextNode();
		   }
		   
		   result+="}";
		   return result;
	}

}
