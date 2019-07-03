package com.demo.linkedlist;

public class LinkedList {
   private Node head;
   
   public void insertAtHead(int data)
   {
	   Node newNode = new Node(data);
	   newNode.setNextNode(head);
	   this.head = newNode;
   }
   public int length()
   {
	   int length = 0;
	   Node current = this.head;
	   while(current!=null)
	   {
		   length++;
		   current = current.getNextNode();
	   }
	   return length;
   }
   
   public void deleteHeadNode()
   {
	   this.head = this.head.getNextNode();
   }
   
   public Node find(int data)
   {
	   Node current = this.head;
	   while(current!=null)
	   {
		   if(current.getData() == data)
		   {
			   return current;
		   }
		   current = current.getNextNode();
	   }
	   
	   return null;
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
