package com.practice.datastructures.applets.partition;
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
  private int oldCodePart;
  private int comps;
  private int swaps;
  private int initOrder;
  private int center;
  private int pivot;
  private int leftScan;
  private int rightScan;
  private int partition;
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
    this.leftScan = -1;
    this.rightScan = this.aSize;
    this.codePart = 1;
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
        j = (int)(Math.random() * 199.0D);
        
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
    if ((paramInt1 < 0) || (paramInt1 > this.aSize - 1)) {
      return;
    }
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
  }
  
  public void draw(Graphics paramGraphics)
  {
    if (this.drawMode != 2)
    {
      drawOneBar(paramGraphics, this.leftScan);
      drawOneBar(paramGraphics, this.rightScan);
    }
    else
    {
      paramGraphics.setColor(Color.lightGray);
      paramGraphics.fillRect(0, 0, 370, 300);
      for (int i = 0; i < this.aSize; i++) {
        drawOneBar(paramGraphics, i);
      }
    }
    paramGraphics.setColor(Color.black);
    int i = 230 - this.pivot;
    paramGraphics.drawLine(5, i, 350, i);
    
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 0, 120, 32);
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
      if ((this.oldCodePart == 7) || (this.oldCodePart == 8))
      {
        arrowText(paramGraphics, Color.magenta, "partition", this.partition, 
          1, true, true);
      }
      else
      {
        arrowText(paramGraphics, Color.blue, "leftScan", this.leftScan, 2, 
          true, true);
        arrowText(paramGraphics, Color.blue, "rightScan", this.rightScan, 3, 
          true, true);
      }
      arrowText(paramGraphics, Color.black, this.note, 0, 4, false, true);
    }
    else if ((this.oldCodePart == 7) || (this.oldCodePart == 8))
    {
      arrowText(paramGraphics, Color.magenta, "xxx", this.partition, 3, 
        true, false);
    }
    else
    {
      arrowText(paramGraphics, Color.blue, "xxx", this.leftScan, 2, 
        true, false);
      arrowText(paramGraphics, Color.blue, "xxx", this.rightScan, 2, 
        true, false);
    }
    this.drawMode = 2;
  }
  
  public void partStep()
  {
    if (this.doneFlag == true) {
      return;
    }
    switch (this.codePart)
    {
    case 1: 
      this.pivot = (70 + (int)(Math.random() * 60.0D));
      
      this.note = ("Pivot value is " + this.pivot);
      this.oldCodePart = this.codePart;
      this.codePart = 3;
      return;
    case 3: 
      this.note = "Will scan from left";
      this.oldCodePart = this.codePart;
      this.codePart = 4;
      return;
    case 4: 
      this.oldCodePart = this.codePart;
      this.comps += 1;
      if (this.theArray[(++this.leftScan)].getHeight() < this.pivot)
      {
        this.note = "Continuing left scan";
        this.codePart = 4;
      }
      else if (this.leftScan >= this.rightScan)
      {
        this.note = "Scans have met";
        this.codePart = 7;
      }
      else
      {
        this.note = "Will scan from right";
        this.codePart = 5; return;
      }
      break;
    case 5: 
      this.oldCodePart = this.codePart;
      this.comps += 1;
      if (this.theArray[(--this.rightScan)].getHeight() > this.pivot)
      {
        this.note = "Continuing right scan";
        this.codePart = 5;
      }
      else if (this.leftScan >= this.rightScan)
      {
        this.note = "Scans have met";
        this.codePart = 7;
      }
      else
      {
        this.note = "Will swap leftScan and rightScan";
        this.codePart = 6; return;
      }
      break;
    case 6: 
      swap(this.leftScan, this.rightScan);
      this.note = "Will scan again from left";
      this.oldCodePart = this.codePart;
      this.codePart = 4;
      return;
    case 7: 
      this.partition = this.leftScan;
      this.note = "Arrow shows partition";
      this.oldCodePart = this.codePart;
      this.codePart = 8;
      return;
    case 8: 
      this.doneFlag = true;
      this.leftScan = 0;
      this.rightScan = (this.aSize - 1);
      this.note = "Partition is complete";
      this.oldCodePart = this.codePart;
      this.codePart = 1; return;
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
