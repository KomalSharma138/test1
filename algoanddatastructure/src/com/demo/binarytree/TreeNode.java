package com.demo.binarytree;

public class TreeNode {

	private Integer data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int data)
	{
		this.data = data;
	}
	
	public TreeNode find(Integer data)
	{
		if(this.data == data)
			return this;
		if(data < this.data && left!=null)
		{
			return left.find(data);
		}
		if(right!=null)
		{
			return right.find(data);
		}
		return null;
	}
	
   public void insert(Integer data)
   {
	   if(data >= this.data)
	   {
		  if(this.right == null)
		  {
			  this.right = 	new TreeNode(data);
		  }
		  else 
			  this.right.insert(data);
	   }
	   else
	   {
		if(this.left==null)
		{
			this.left = new TreeNode(data);
		}
		else
			this.left.insert(data);
	   }
   }

	public Integer getData() {
		return data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public Integer smallest()
	{
		if(this.left == null)
			return this.data;
		return this.left.smallest();
	}
	
	public Integer largest()
	{
		if(this.right==null)
			return this.data;
		return this.right.largest();
	}
}
