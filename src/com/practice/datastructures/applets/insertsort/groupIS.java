package com.practice.datastructures.applets.insertsort;
import java.awt.Color;
import java.awt.Graphics;

class groupIS
{
  private final int appletWidth = 370;
  private final int appletHeight = 320;
  private final int maxHeight = 200;
  private final int topMargin = 30;
  private final int leftMargin = 10;
  private final int barLeftMargin = 35;
  private final int textHeight = 13;
  private int aSize;
  private personIS[] theArray;
  private int barWidth;
  private int barSeparation;
  private int outer;
  private int inner;
  private int outerOld;
  private int innerOld;
  private boolean doneFlag;
  private int codePart;
  private int comps;
  private int copies;
  private int initOrder;
  private Color newColor;
  private int drawMode;
  
  public groupIS(int paramInt1, int paramInt2)
  {
    this.aSize = paramInt1;
    this.initOrder = paramInt2;
    this.theArray = new personIS[this.aSize + 2];
    if (this.aSize == 100)
    {
      this.barWidth = 2;this.barSeparation = 1;
    }
    else
    {
      this.barWidth = 18;this.barSeparation = 7;
    }
    this.inner = (this.outer = 1);
    this.innerOld = (this.outerOld = 1);
    this.comps = 0;
    this.copies = 0;
    this.doneFlag = false;
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
        j = 10 + (int)(Math.random() * 189.0D);
        
        k = (int)(Math.random() * 254.0D);
        m = (int)(Math.random() * 254.0D);
        n = (int)(Math.random() * 254.0D);
        localColor = new Color(k, m, n);
        
        this.theArray[i] = new personIS(j, localColor);
      }
    } else {
      for (i = 0; i < this.aSize; i++)
      {
        j = 195 - 195 * i / this.aSize;
        k = 255 - j;
        m = 85 * (i % 3);
        n = j;
        localColor = new Color(k, m, n);
        
        this.theArray[i] = new personIS(j, localColor);
      }
    }
    this.theArray[(this.aSize + 1)] = new personIS(0, Color.lightGray);
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
      i = this.theArray[paramInt].getHeight();
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
    case 1: 
      drawOneBar(paramGraphics, this.inner);
      drawOneBar(paramGraphics, this.aSize + 1);
      break;
    case 2: 
      drawOneBar(paramGraphics, this.aSize + 1);
      drawOneBar(paramGraphics, this.innerOld);
      drawOneBar(paramGraphics, this.inner);
      break;
    case 3: 
      drawOneBar(paramGraphics, this.inner);
      drawOneBar(paramGraphics, this.aSize + 1);
      break;
      
      
    }
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 0, 370, 320);
    for (int i = 0; i < this.aSize; i++) {
      drawOneBar(paramGraphics, i);
    }
    drawOneBar(paramGraphics, this.aSize + 1);
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 0, 135, 32);
    paramGraphics.setColor(Color.black);
    paramGraphics.drawString("Comparisons = " + this.comps, 10, 
      28);
    paramGraphics.drawString("Copies = " + this.copies, 10, 
      15);
    
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(0, 230, 
      370, 78);
    if (this.aSize == 10)
    {
      arrowText(paramGraphics, Color.red, "outer", this.outer, 1, true, true);
      arrowText(paramGraphics, Color.blue, "inner", this.inner, 2, true, true);
      arrowText(paramGraphics, Color.magenta, "temp", this.aSize + 1, 1, true, 
        true);
    }
    switch (this.codePart)
    {
    case 1: 
      if (this.doneFlag == true) {
        arrowText(paramGraphics, Color.black, 
          "Sort is complete", 
          0, 3, false, true);
      } else {
        arrowText(paramGraphics, Color.black, 
          "Will copy outer to temp", 
          0, 3, false, true);
      }
      break;
    case 2: 
      if (this.inner > 0) {
        arrowText(paramGraphics, Color.black, 
          "Have compared inner-1 and temp", 
          0, 3, false, true);
      } else {
        arrowText(paramGraphics, Color.black, 
          "Now inner is 0, so", 
          0, 3, false, true);
      }
      if ((this.inner > 0) && 
        (this.theArray[(this.inner - 1)].getHeight() >= 
        this.theArray[(this.aSize + 1)].getHeight())) {
        arrowText(paramGraphics, Color.black, 
          "   Will copy inner-1 to inner", 
          0, 4, false, true);
      } else {
        arrowText(paramGraphics, Color.black, 
          "   No copy necessary", 
          0, 4, false, true);
      }
      break;
    case 3: 
      arrowText(paramGraphics, Color.black, 
        "Will copy temp to inner", 
        0, 3, false, true);
      break;
      
      
    }
    arrowText(paramGraphics, Color.red, "xxx", this.outer, 1, true, false);
    arrowText(paramGraphics, Color.blue, "xxx", this.inner, 2, true, false);
    arrowText(paramGraphics, Color.magenta, "xxx", this.aSize + 1, 3, true, 
      false);
    this.drawMode = 2;
  }
  
  public void sortStep()
  {
    switch (this.codePart)
    {
    case 1: 
      this.theArray[(this.aSize + 1)] = this.theArray[this.outer];
      this.theArray[this.outer] = null;
      this.copies += 1;
      this.innerOld = this.inner;
      this.inner = this.outer;
      this.codePart = 2;
      return;
    case 2: 
      this.comps += 1;
      if ((this.inner > 0) && 
        (this.theArray[(this.inner - 1)].getHeight() >= 
        this.theArray[(this.aSize + 1)].getHeight()))
      {
        this.theArray[this.inner] = this.theArray[(this.inner - 1)];
        this.theArray[(this.inner - 1)] = null;
        this.copies += 1;
        this.innerOld = this.inner;
        this.inner -= 1;
      }
      else
      {
        this.codePart = 3; return;
      }
      break;
    case 3: 
      this.theArray[this.inner] = this.theArray[(this.aSize + 1)];
      this.theArray[(this.aSize + 1)] = null;
      this.copies += 1;
      this.outerOld = this.outer;
      this.outer += 1;
      if (this.outer == this.aSize) {
        this.doneFlag = true;
      }
      this.codePart = 1; return;
    }
  }
}
