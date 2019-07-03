package com.demo.towerofhanoi;

public class TowerOfHanoi {
	
	public void move(int n , char from , char to , char inter)
	{
		if(n == 1)
		{
		System.out.println("moving 1 disc from "+ from+" to "+ to);	
		}
		else
		{
		move(n-1 , from , inter , to);
		System.out.println("moving  "+ n +" disc from "+ from+" to "+ to);
		move(n-1 , inter , to , from);
		}
	}
   
	public static void main(String[] args) {
		
		TowerOfHanoi t = new TowerOfHanoi();
		t.move(5, 'A', 'C', 'B');
	}
}
