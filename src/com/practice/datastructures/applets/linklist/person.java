package com.practice.datastructures.applets.linklist;
import java.awt.Color;

class person
{
  private int height;
  private Color color;
  
  public person(int paramInt, Color paramColor)
  {
    this.height = paramInt;this.color = paramColor;
  }
  
  public Color getColor()
  {
    return this.color;
  }
  
  public int getHeight()
  {
    return this.height;
  }
}
