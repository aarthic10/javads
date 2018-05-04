package com.practice.datastructures.applets.quicksort1;
import java.awt.Color;
import java.awt.Graphics;

class personGroup
{
  private final int appletWidth = 370;
  private final int appletHeight = 300;
  private final int maxHeight = 200;
  private final int topMargin = 30;
  private final int leftMargin = 10;
  private final int barLeftMargin = 35;
  private final int textHeight = 13;
  private int aSize;
  private person[] theArray;
  private int barWidth;
  private int barSeparation;
  private boolean doneFlag;
  private int codePart;
  private int comps;
  private int swaps;
  private int initOrder;
  private int left;
  private int right;
  private int pivot;
  private int leftScan;
  private int rightScan;
  private int phonyLeft;
  private stack leftStack;
  private stack rightStack;
  private String note;
  private int drawMode;
  
  public personGroup(int paramInt1, int paramInt2)
  {
    this.aSize = paramInt1;
    this.initOrder = paramInt2;
    this.theArray = new person[this.aSize];
    if (this.aSize == 100)
    {
      this.barWidth = 2;this.barSeparation = 1;
    }
    else
    {
      this.barWidth = 18;this.barSeparation = 7;
    }
    this.comps = 0;
    this.swaps = 0;
    this.doneFlag = false;
    this.left = 0;
    this.right = (this.aSize - 1);
    this.pivot = this.right;
    this.leftScan = this.left;
    this.rightScan = (this.right - 1);
    this.codePart = 1;
    this.leftStack = new stack();
    this.rightStack = new stack();
    Color localColor = new Color(0, 0, 0);
    this.note = "Press any button";
    int i;
    int j;
    int k;
    int m;
    int n;
    if (this.initOrder == 1) {
      for (i = 0; i < this.aSize; i++)
      {
        j = (int)(Math.random() * 195.0D);
        
        k = (int)(Math.random() * 254.0D);
        m = (int)(Math.random() * 254.0D);
        n = (int)(Math.random() * 254.0D);
        localColor = new Color(k, m, n);
        
        this.theArray[i] = new person(j, localColor);
      }
    } else {
      for (i = 0; i < this.aSize; i++)
      {
        j = 195 - 195 * i / this.aSize;
        k = 255 - j;
        m = 85 * (i % 3);
        n = j;
        localColor = new Color(k, m, n);
        
        this.theArray[i] = new person(j, localColor);
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
    return 300;
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
    if ((paramInt < 0) || (paramInt > this.aSize - 1)) {
      return;
    }
    int i = this.theArray[paramInt].getHeight();
    int j = 35 + 
      paramInt * (this.barWidth + this.barSeparation);
    int k = 230 - i;
    Color localColor = this.theArray[paramInt].getColor();
    
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(j, 30, this.barWidth, 200);
    
    paramGraphics.setColor(localColor);
    paramGraphics.fill3DRect(j, k, this.barWidth, i, true);
    if (this.aSize == 12)
    {
      paramGraphics.setColor(Color.black);
      int m = paramInt > 9 ? j + 2 : j + 5;
      paramGraphics.drawString(String.valueOf(paramInt), m, 
        228);
    }
  }
  
  public void drawHorizSubArrayLine(Graphics paramGraphics)
  {
    int i = 33 + 
      this.leftScan * (this.barWidth + this.barSeparation);
    int j = 37 + 
      (this.rightScan + 1) * (this.barWidth + this.barSeparation) + this.barWidth;
    int k = this.theArray[this.pivot].getHeight();
    int m = 230 - k;
    paramGraphics.setColor(Color.black);
    paramGraphics.drawLine(i, m, j, m);
  }
  
  public void draw(Graphics paramGraphics)
  {
    int i;
    if (this.drawMode != 2)
    {
      drawOneBar(paramGraphics, this.leftScan);
      drawOneBar(paramGraphics, this.rightScan);
      drawOneBar(paramGraphics, this.pivot);
    }
    else
    {
      paramGraphics.setColor(Color.lightGray);
      paramGraphics.fillRect(0, 0, 370, 300);
      for (i = 0; i < this.aSize; i++) {
        drawOneBar(paramGraphics, i);
      }
    }
    if (this.codePart == 2) {
      drawHorizSubArrayLine(paramGraphics);
    }
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 0, 140, 32);
    paramGraphics.setColor(Color.black);
    paramGraphics.drawString("Comparisons = " + this.comps, 10, 
      28);
    paramGraphics.drawString("Swaps = " + this.swaps, 10, 
      15);
    
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 230, 
      370, 78);
    if (this.aSize == 12)
    {
      arrowText(paramGraphics, Color.red, "left", this.left, 1, true, true);
      arrowText(paramGraphics, Color.red, "right", this.right, 1, true, true);
      arrowText(paramGraphics, Color.blue, "leftScan", this.leftScan, 2, 
        true, true);
      arrowText(paramGraphics, Color.blue, "rightScan", this.rightScan, 3, 
        true, true);
      i = this.right - this.pivot < 2 ? 2 : 1;
      arrowText(paramGraphics, Color.magenta, "pivot", this.pivot, i, 
        true, true);
      
      arrowText(paramGraphics, Color.black, this.note, 0, 4, false, true);
    }
    else
    {
      arrowText(paramGraphics, Color.red, "xxx", this.left, 1, true, false);
      arrowText(paramGraphics, Color.red, "xxx", this.right, 1, true, false);
      arrowText(paramGraphics, Color.blue, "xxx", this.leftScan, 2, 
        true, false);
      arrowText(paramGraphics, Color.blue, "xxx", this.rightScan, 2, 
        true, false);
      arrowText(paramGraphics, Color.magenta, "xxx", this.pivot, 3, 
        true, false);
    }
    this.drawMode = 2;
  }
  
  public void sortStep()
  {
    if (this.doneFlag == true) {
      return;
    }
    switch (this.codePart)
    {
    case 1: 
      int i = this.right - this.left + 1;
      if (i <= 1)
      {
        this.note = 
          ("Entering quickSort(); partition (" + this.left + "-" + this.right + ") too small to sort");
        this.codePart = 7;
      }
      else
      {
        this.pivot = this.right;
        this.note = 
          ("Entering quickSort(); will partition (" + this.left + "-" + this.right + ")");
        this.codePart = 2; return;
      }
      break;
    case 2: 
      this.leftScan = (this.left - 1);
      this.rightScan = this.right;
      this.note = 
        ("leftScan=" + this.leftScan + ", rightScan=" + this.rightScan + "; will scan");
      this.codePart = 3;
      return;
    case 3: 
      this.comps += 1;
      while (this.theArray[(++this.leftScan)].getHeight() < 
        this.theArray[this.pivot].getHeight()) {
        this.comps += 1;
      }
      if (this.rightScan > this.left) {
        this.comps += 1;
      }
      while ((this.rightScan > this.left) && 
        (this.theArray[(--this.rightScan)].getHeight() > 
        this.theArray[this.pivot].getHeight())) {
        if (this.rightScan > this.left) {
          this.comps += 1;
        }
      }
      if (this.leftScan >= this.rightScan)
      {
        this.note = 
          "Scans have met; will swap pivot and leftScan";
        this.codePart = 5;
      }
      else
      {
        this.note = "Will swap leftScan and rightScan";
        this.codePart = 4; return;
      }
      break;
    case 4: 
      swap(this.leftScan, this.rightScan);
      this.note = "Will scan again";
      this.codePart = 3;
      return;
    case 5: 
      swap(this.leftScan, this.pivot);
      this.codePart = 6;
      this.note = 
      
        ("Array partitioned: left (" + this.left + "-" + (this.leftScan - 1) + "), right (" + (this.leftScan + 1) + "-" + this.right + ")");
      return;
    case 6: 
      this.leftStack.push(this.leftScan + 1);
      this.rightStack.push(this.right);
      this.note = 
        ("Will sort left partition (" + this.left + "-" + (this.leftScan - 1) + ")");
      this.right = (this.leftScan - 1);
      this.leftScan = this.left;
      this.rightScan = (this.right - 1);
      this.pivot = this.right;
      this.codePart = 1;
      return;
    case 7: 
      if (this.leftStack.isEmpty())
      {
        this.doneFlag = true;
        this.note = "Sort is complete";
        this.codePart = 8;
      }
      else
      {
        this.left = this.leftStack.pop();
        this.right = this.rightStack.pop();
        this.leftScan = this.left;
        this.rightScan = (this.right - 1);
        this.pivot = this.right;
        this.note = 
          ("Will sort right partition (" + this.left + "-" + this.right + ")");
        this.codePart = 1; return;
      }
      break;
    case 8: 
      this.codePart = 8;
      this.note = "Press any button"; return;
    }
  }
  
  public void swap(int paramInt1, int paramInt2)
  {
    person localperson = this.theArray[paramInt1];
    this.theArray[paramInt1] = this.theArray[paramInt2];
    this.theArray[paramInt2] = localperson;
    this.swaps += 1;
  }
}
