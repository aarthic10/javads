package com.practice.datastructures.applets.quicksort1;
class stack
{
  private int[] st = new int[50];
  private int top = -1;
  
  public void push(int paramInt)
  {
    this.st[(++this.top)] = paramInt;
  }
  
  public int pop()
  {
    return this.st[(this.top--)];
  }
  
  public boolean isEmpty()
  {
    return this.top == -1;
  }
}
