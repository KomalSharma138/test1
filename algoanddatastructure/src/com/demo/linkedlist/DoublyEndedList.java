package com.demo.linkedlist;

public class DoublyEndedList {
	
	private Node head;
	private Node tail;
	
	public void insertTail(int data)
	{
		Node newNode = new Node(data);
		if(this.head == null)
		{
			this.head = newNode;
		}
		
		if(this.tail !=null)
		{
		this.tail.setNextNode(newNode);
		}
		this.tail = newNode;
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
