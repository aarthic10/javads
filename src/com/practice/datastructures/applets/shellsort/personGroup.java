package com.practice.datastructures.applets.shellsort;
import java.awt.Color;
import java.awt.Graphics;

class personGroup
{
  private final int appletWidth = 370;
  private final int appletHeight = 320;
  private final int maxHeight = 200;
  private final int topMargin = 30;
  private final int leftMargin = 10;
  private final int barLeftMargin = 35;
  private final int textHeight = 13;
  private int aSize;
  private person[] theArray;
  private int barWidth;
  private int barSeparation;
  private int Outer;
  private int Inner;
  private int outerOld;
  private int innerOld;
  private int h;
  private boolean doneFlag;
  private int codePart;
  private int comps;
  private int copies;
  private int initOrder;
  private String note;
  private int drawMode;
  
  public personGroup(int paramInt1, int paramInt2)
  {
    this.aSize = paramInt1;
    this.initOrder = paramInt2;
    this.theArray = new person[this.aSize + 2];
    if (this.aSize == 100)
    {
      this.barWidth = 2;this.barSeparation = 1;
    }
    else
    {
      this.barWidth = 18;this.barSeparation = 7;
    }
    this.h = 1;
    while (this.h <= this.aSize / 3) {
      this.h = (this.h * 3 + 1);
    }
    this.Inner = (this.Outer = this.h);
    this.innerOld = (this.outerOld = this.h);
    this.comps = 0;
    this.copies = 0;
    this.doneFlag = false;
    this.note = "Press any button";
    this.codePart = 1;
    Color localColor = new Color(0, 0, 0);
    int i;
    int j;
    int k;
    int m;
    int n;
    if (this.initOrder == 1) {
      for (i = 0; i < this.aSize; i++)
      {
        j = 20 + (int)(Math.random() * 175.0D);
        
        k = (int)(Math.random() * 254.0D);
        m = (int)(Math.random() * 254.0D);
        n = (int)(Math.random() * 254.0D);
        localColor = new Color(k, m, n);
        
        this.theArray[i] = new person(j, localColor);
      }
    } else {
      for (i = 0; i < this.aSize; i++)
      {
        j = 195 - 175 * i / this.aSize;
        k = 255 - j;
        m = 85 * (i % 3);
        n = j;
        localColor = new Color(k, m, n);
        
        this.theArray[i] = new person(j, localColor);
      }
    }
    this.theArray[(this.aSize + 1)] = new person(0, localColor);
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
    int i;
    if (this.theArray[paramInt] == null)
    {
      i = 35 + 
        paramInt * (this.barWidth + this.barSeparation);
      
      paramGraphics.setColor(Color.lightGray);
      paramGraphics.fillRect(i, 30, this.barWidth, 200);
    }
    else
    {
      if ((paramInt < 0) || (paramInt > this.aSize + 1)) {
        return;
      }
      i = this.theArray[paramInt].getHeight();
      if (i < 5) {
        return;
      }
      int j = 35 + 
        paramInt * (this.barWidth + this.barSeparation);
      int k = 230 - i;
      Color localColor = this.theArray[paramInt].getColor();
      
      paramGraphics.setColor(Color.lightGray);
      paramGraphics.fillRect(j, 30, this.barWidth, 200);
      paramGraphics.setColor(localColor);
      paramGraphics.fill3DRect(j, k, this.barWidth, i, true);
    }
  }
  
  public void draw(Graphics paramGraphics)
  {
    if (this.drawMode != 2) {}
    switch (this.codePart)
    {
    case 3: 
    case 6: 
      drawOneBar(paramGraphics, this.aSize + 1);
      drawOneBar(paramGraphics, this.innerOld);
      drawOneBar(paramGraphics, this.Inner);
      break;
    case 2: 
    case 5: 
      drawOneBar(paramGraphics, this.innerOld);
      drawOneBar(paramGraphics, this.Inner);
      drawOneBar(paramGraphics, this.aSize + 1);
      break;
      
      
    }
    
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 0, 370, 320);
    for (int i = 0; i < this.aSize; i++) {
      drawOneBar(paramGraphics, i);
    }
    drawOneBar(paramGraphics, this.aSize + 1);
    
    arrowText(paramGraphics, Color.magenta, "xxx", this.aSize + 1, 3, true, 
      false);
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 0, 120, 32);
    paramGraphics.setColor(Color.black);
    paramGraphics.drawString("Comparisons = " + this.comps, 10, 
      28);
    paramGraphics.drawString("Copies = " + this.copies, 10, 
      15);
    
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 230, 
      370, 78);
    
    arrowText(paramGraphics, Color.black, "h=" + this.h, 8, 5, false, true);
    if (this.aSize == 10)
    {
      arrowText(paramGraphics, Color.red, "outer", this.Outer, 1, true, true);
      arrowText(paramGraphics, Color.blue, "inner", this.Inner, 2, true, true);
      if (this.Inner - this.h >= 0) {
        arrowText(paramGraphics, Color.blue, "inner-h", this.Inner - this.h, 3, 
          true, true);
      }
      arrowText(paramGraphics, Color.magenta, "temp", this.aSize + 1, 1, 
        true, true);
      
      arrowText(paramGraphics, Color.black, this.note, 0, 4, false, true);
    }
    else
    {
      arrowText(paramGraphics, Color.red, "xxx", this.Outer, 1, true, false);
      arrowText(paramGraphics, Color.blue, "xxx", this.Inner, 2, true, false);
      arrowText(paramGraphics, Color.blue, "xxx", this.Inner - this.h, 2, true, 
        false);
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
      this.note = 
        (this.h + "-sorting array; will copy outer to temp");
      this.codePart = 2;
      return;
    case 2: 
      this.copies += 1;
      this.theArray[(this.aSize + 1)] = this.theArray[this.Outer];
      this.theArray[this.Outer] = null;
      this.innerOld = this.Inner;
      this.Inner = this.Outer;
      if (this.Inner > this.h - 1) {
        this.note = "Will compare inner-h and temp";
      } else {
        this.note = "There is no inner-h";
      }
      this.codePart = 3;
      return;
    case 3: 
      if (this.Inner > this.h - 1)
      {
        this.comps += 1;
        if (this.theArray[(this.Inner - this.h)].getHeight() >= 
          this.theArray[(this.aSize + 1)].getHeight())
        {
          this.note = 
            "inner-h >= temp; will copy inner-h to inner";
          this.codePart = 4;
        }
        else
        {
          this.note = 
            "inner-h < temp; will copy temp to inner";
          this.codePart = 5;
        }
      }
      else
      {
        this.note = "Will copy temp to inner";
        this.codePart = 5; return;
      }
      break;
    case 4: 
      this.theArray[this.Inner] = this.theArray[(this.Inner - this.h)];
      this.theArray[(this.Inner - this.h)] = null;
      this.copies += 1;
      this.innerOld = this.Inner;
      this.Inner -= this.h;
      if (this.Inner > this.h - 1) {
        this.note = "Will compare inner-h and temp";
      } else {
        this.note = "There is no inner-h";
      }
      this.codePart = 3;
      return;
    case 5: 
      this.theArray[this.Inner] = this.theArray[(this.aSize + 1)];
      this.theArray[(this.aSize + 1)] = null;
      this.copies += 1;
      
      this.outerOld = this.Outer;
      this.Outer += 1;
      if (this.Outer < this.aSize)
      {
        this.note = "Will copy outer to temp";
        this.codePart = 2;
      }
      else
      {
        this.h = ((this.h - 1) / 3);
        if (this.h > 0)
        {
          this.Inner = (this.Outer = this.h);
          this.note = 
            (this.h + "-sorting array. Will copy outer to temp");
          this.codePart = 2;
        }
        else
        {
          this.note = "Sort is complete";
          this.codePart = 6; return;
        }
      }
      break;
    case 6: 
      this.doneFlag = true;
      this.note = "Sort is complete";
      this.codePart = 6; return;
    }
  }
}
