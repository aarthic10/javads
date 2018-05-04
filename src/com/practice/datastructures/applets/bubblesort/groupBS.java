package com.practice.datastructures.applets.bubblesort;
import java.awt.Color;
import java.awt.Graphics;

class groupBS
{
  private final int appletWidth = 370;
  private final int appletHeight = 320;
  private final int maxHeight = 200;
  private final int topMargin = 30;
  private final int leftMargin = 10;
  private final int barLeftMargin = 35;
  private final int textHeight = 13;
  private int aSize;
  private personBS[] theArray;
  private int barWidth;
  private int barSeparation;
  private int outer;
  private int inner;
  private int innerOld;
  private boolean swapFlag;
  private boolean doneFlag;
  private int comps;
  private int swaps;
  private int initOrder;
  Color newColor;
  private int drawMode;
  
  public groupBS(int paramInt1, int paramInt2)
  {
    this.aSize = paramInt1;
    this.initOrder = paramInt2;
    this.theArray = new personBS[this.aSize];
    if (this.aSize == 100)
    {
      this.barWidth = 2;this.barSeparation = 1;
    }
    else
    {
      this.barWidth = 20;this.barSeparation = 10;
    }
    this.outer = (this.aSize - 1);
    this.inner = 0;
    this.comps = 0;
    this.swaps = 0;
    this.swapFlag = false;
    this.doneFlag = false;
    this.drawMode = 2;
    int i;
    int j;
    int k;
    int m;
    int n;
    if (this.initOrder == 1) {
      for (i = 0; i < this.aSize; i++)
      {
        j = (int)(Math.random() * 199.0D);
        
        k = (int)(Math.random() * 254.0D);
        m = (int)(Math.random() * 254.0D);
        n = (int)(Math.random() * 254.0D);
        this.newColor = new Color(k, m, n);
        
        this.theArray[i] = new personBS(j, this.newColor);
      }
    } else {
      for (i = 0; i < this.aSize; i++)
      {
        j = 199 - 199 * i / this.aSize;
        k = 255 - j;
        m = 85 * (i % 3);
        n = j;
        this.newColor = new Color(k, m, n);
        
        this.theArray[i] = new personBS(j, this.newColor);
      }
    }
  }
  
  public void setDrawMode(int paramInt)
  {
    this.drawMode = paramInt;
  }
  
  public int getAppletWidth()
  {
    return 370;
  }
  
  public int getAppletHeight()
  {
    return 320;
  }
  
  public boolean getDone()
  {
    return this.doneFlag;
  }
  
  public void arrowText(Graphics paramGraphics, Color paramColor, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 35 + paramInt1 * (this.barWidth + this.barSeparation);
    int j = 230 + (paramInt2 + 1) * 13;
    paramGraphics.setColor(paramColor);
    if (paramBoolean2) {
      paramGraphics.drawString(paramString, i, j);
    }
    if (paramBoolean1)
    {
      paramGraphics.drawLine(i + this.barWidth / 2, 232, 
        i + this.barWidth / 2, j - 13);
      
      paramGraphics.drawLine(i + this.barWidth / 2, 232, 
        i + this.barWidth / 2 - 3, 237);
      paramGraphics.drawLine(i + this.barWidth / 2, 232, 
        i + this.barWidth / 2 + 3, 237);
    }
  }
  
  public void drawOneBar(Graphics paramGraphics, int paramInt)
  {
    int i = this.theArray[paramInt].getHeight();
    int j = 35 + 
      paramInt * (this.barWidth + this.barSeparation);
    int k = 230 - i;
    Color localColor = this.theArray[paramInt].getColor();
    
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(j, 30, this.barWidth, 200);
    paramGraphics.setColor(localColor);
    paramGraphics.fill3DRect(j, k, this.barWidth, i, true);
  }
  
  public void draw(Graphics paramGraphics)
  {
    if (this.drawMode != 2)
    {
      if (this.swapFlag == true)
      {
        drawOneBar(paramGraphics, this.innerOld);
        drawOneBar(paramGraphics, this.innerOld + 1);
        this.swapFlag = false;
      }
    }
    else
    {
      paramGraphics.setColor(Color.lightGray);
      paramGraphics.fillRect(0, 0, 370, 320);
      for (int i = 0; i < this.aSize; i++) {
        drawOneBar(paramGraphics, i);
      }
    }
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 0, 150, 32);
    paramGraphics.setColor(Color.black);
    paramGraphics.drawString("Comparisons = " + this.comps, 10, 
      28);
    paramGraphics.drawString("Swaps = " + this.swaps, 10, 
      15);
    
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 230, 
      370, 65);
    if (this.aSize == 10)
    {
      arrowText(paramGraphics, Color.red, "outer", this.outer, 3, true, true);
      arrowText(paramGraphics, Color.blue, "inner", this.inner, 1, true, true);
      arrowText(paramGraphics, Color.blue, "inner+1", this.inner + 1, 1, true, 
        true);
      if (this.doneFlag == true) {
        arrowText(paramGraphics, Color.black, "Sort is complete", 
          this.inner, 2, false, true);
      } else if (this.theArray[this.inner].getHeight() > 
        this.theArray[(this.inner + 1)].getHeight()) {
        arrowText(paramGraphics, Color.blue, "Will be swapped", 
          this.inner, 2, false, true);
      } else {
        arrowText(paramGraphics, Color.blue, "Will not be swapped", 
          this.inner, 2, false, true);
      }
    }
    else
    {
      arrowText(paramGraphics, Color.red, "xxx", this.outer, 3, true, false);
      arrowText(paramGraphics, Color.blue, "xxx", this.inner, 1, true, false);
      arrowText(paramGraphics, Color.blue, "xxx", this.inner + 1, 1, true, false);
    }
    this.drawMode = 2;
  }
  
  public void sortStep()
  {
    if (this.doneFlag == true) {
      return;
    }
    this.comps += 1;
    if (this.theArray[this.inner].getHeight() > 
      this.theArray[(this.inner + 1)].getHeight())
    {
      swap(this.inner, this.inner + 1);
      this.swapFlag = true;
      this.swaps += 1;
    }
    this.innerOld = this.inner;
    this.inner += 1;
    if (this.inner > this.outer - 1)
    {
      this.inner = 0;
      this.outer -= 1;
      if (this.outer == 0) {
        this.doneFlag = true;
      }
    }
  }
  
  public void swap(int paramInt1, int paramInt2)
  {
    personBS localpersonBS = this.theArray[paramInt1];
    this.theArray[paramInt1] = this.theArray[paramInt2];
    this.theArray[paramInt2] = localpersonBS;
  }
}
