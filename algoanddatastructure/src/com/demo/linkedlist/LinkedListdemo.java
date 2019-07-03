package com.demo.linkedlist;

public class LinkedListdemo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(5);
		list.insertAtHead(12);
		list.insertAtHead(19);
		list.insertAtHead(8);
		System.out.println(list);
		/*System.out.println("length " + list.length());
        list.deleteHeadNode();
    	System.out.println(list);
		System.out.println("length " + list.length());
		
		System.out.println(list.find(12));
		
		System.out.println("found "+list.find(0));*/
	}

}
