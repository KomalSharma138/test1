package com.demo.binarytree;

public class BinarySearchTree {
	
	private TreeNode root;
	
	public void insert(Integer data)
	{
		TreeNode newNode = new TreeNode(data);
		if(root == null)
			this.root = new TreeNode(data);
		else
			this.root.insert(data);
	}
	
	public TreeNode find(Integer data)
	{
		if(root!=null)
			root.find(data);
		
		return null;
	}
	
	public void delete(Integer data)
	{
		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;
		
		if(current == null) //tree is empty
			return;
		while(current!=null && current.getData()!=data)
		{
			parent = current;
			 if(data< current.getData())
			 {
				 current = current.getLeft();
				 isLeftChild = true;
			 }
			 else
			 {
				 current = current.getRight();
				 isLeftChild = false;
			 }
			  
		}
		
		if(current == null)
			return;
		if(current.getLeft()==null && current.getRight()==null)
		{
			if(current==root)
			{
				this.root=null;
			}
			else{
			if(isLeftChild)
			{
				parent.setLeft(null);
			}
			else
			{
				parent.setRight(null);
			}
			}
		}
		else if(current.getRight()==null)
		{
			if(current == root)
			{
				root = current.getLeft();
			}
			else if(isLeftChild)
			{
				parent.setLeft(current.getLeft());
			}
			else
			{
				parent.setRight(current.getLeft());
			}
		}
		else if(current.getLeft()==null)
		{
			if(current == root)
			{
				root = current.getRight();
			}
			else if(isLeftChild)
			{
				parent.setLeft(current.getRight());
			}
			else
			{
				parent.setRight(current.getRight());
			}
		}
		
	}
	
	public Integer smallest()
	{
		if(this.root!=null)
			return root.smallest();
		return null;
	}
   
	public Integer largest()
	{
		if(this.root!=null)
			return root.largest();
		return null;
	}
}
