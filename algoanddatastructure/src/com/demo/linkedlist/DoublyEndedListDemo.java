package com.demo.linkedlist;

public class DoublyEndedListDemo {

	public static void main(String[] args) {
		
		DoublyEndedList dList = new DoublyEndedList();
		dList.insertTail(5);
		dList.insertTail(10);
		dList.insertTail(4);
		dList.insertTail(9);
		System.out.println(dList);
	}

}
