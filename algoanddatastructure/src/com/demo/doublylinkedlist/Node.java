package com.demo.doublylinkedlist;

public class Node {

	private int data;
	private Node nextNode;
	private Node prevNode;
	
	public Node(int data)
	{
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public Node getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
	
	@Override
	public String toString()
	{
		return "Data "+this.data;
	}
}
