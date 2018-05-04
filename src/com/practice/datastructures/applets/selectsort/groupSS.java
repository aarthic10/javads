package com.practice.datastructures.applets.selectsort;
import java.awt.Color;
import java.awt.Graphics;

class groupSS
{
  private final int appletWidth = 370;
  private final int appletHeight = 320;
  private final int maxHeight = 200;
  private final int topMargin = 30;
  private final int leftMargin = 10;
  private final int barLeftMargin = 35;
  private final int textHeight = 13;
  private int aSize;
  private personSS[] theArray;
  private int barWidth;
  private int barSeparation;
  private int outer;
  private int inner;
  private int min;
  private int outerOld;
  private int minOld;
  private boolean searchFlag;
  private boolean swapFlag;
  private boolean doneFlag;
  private int comps;
  private int swaps;
  private int initOrder;
  private Color newColor;
  private int drawMode;
  
  public groupSS(int paramInt1, int paramInt2)
  {
    this.aSize = paramInt1;
    this.initOrder = paramInt2;
    this.theArray = new personSS[this.aSize];
    if (this.aSize == 100)
    {
      this.barWidth = 2;this.barSeparation = 1;
    }
    else
    {
      this.barWidth = 20;this.barSeparation = 10;
    }
    this.outer = 0;
    this.inner = 1;
    this.min = 0;
    this.searchFlag = true;
    this.comps = 0;
    this.swaps = 0;
    this.swapFlag = false;
    this.doneFlag = false;
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
        
        this.theArray[i] = new personSS(j, this.newColor);
      }
    } else {
      for (i = 0; i < this.aSize; i++)
      {
        j = 199 - 199 * i / this.aSize;
        k = 255 - j;
        m = 85 * (i % 3);
        n = j;
        this.newColor = new Color(k, m, n);
        
        this.theArray[i] = new personSS(j, this.newColor);
      }
    }
    this.drawMode = 2;
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
        drawOneBar(paramGraphics, this.outerOld);
        drawOneBar(paramGraphics, this.minOld);
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
      370, 68);
    if (this.aSize == 10)
    {
      arrowText(paramGraphics, Color.red, "outer", this.outer, 1, true, true);
      arrowText(paramGraphics, Color.blue, "inner", this.inner, 2, true, true);
      arrowText(paramGraphics, Color.magenta, "min", this.min, 3, true, true);
      if (this.doneFlag == true) {
        arrowText(paramGraphics, Color.black, "Sort is complete", 
          0, 4, false, true);
      } else if (this.searchFlag == true) {
        arrowText(paramGraphics, Color.black, "Searching for minimum", 
          0, 4, false, true);
      } else if (this.outer == this.min) {
        arrowText(paramGraphics, Color.black, "No swap necessary", 
          0, 4, false, true);
      } else {
        arrowText(paramGraphics, Color.black, "Will swap outer & min", 
          0, 4, false, true);
      }
    }
    else
    {
      arrowText(paramGraphics, Color.red, "xxx", this.outer, 1, true, false);
      arrowText(paramGraphics, Color.blue, "xxx", this.inner, 2, true, false);
      arrowText(paramGraphics, Color.magenta, "xxx", this.min, 3, true, false);
    }
    this.drawMode = 2;
  }
  
  public void sortStep()
  {
    if (this.doneFlag == true) {
      return;
    }
    if ((this.inner > this.aSize - 1) && (this.searchFlag == true)) {
      return;
    }
    if (this.searchFlag == true)
    {
      this.comps += 1;
      if (this.theArray[this.inner].getHeight() < 
        this.theArray[this.min].getHeight())
      {
        this.minOld = this.min;
        this.min = this.inner;
      }
      this.inner += 1;
      if (this.inner > this.aSize - 1) {
        this.searchFlag = false;
      }
    }
    else
    {
      if (this.min != this.outer)
      {
        swap(this.outer, this.min);
        this.swapFlag = true;
        this.swaps += 1;
      }
      this.outerOld = this.outer;
      this.outer += 1;
      this.inner = (this.outer + 1);
      this.minOld = this.min;
      this.min = this.outer;
      this.searchFlag = true;
      if (this.outer > this.aSize - 2) {
        this.doneFlag = true;
      }
    }
  }
  
  public void swap(int paramInt1, int paramInt2)
  {
    personSS localpersonSS = this.theArray[paramInt1];
    this.theArray[paramInt1] = this.theArray[paramInt2];
    this.theArray[paramInt2] = localpersonSS;
  }
}
