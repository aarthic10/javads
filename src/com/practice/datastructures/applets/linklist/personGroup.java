package com.practice.datastructures.applets.linklist;
import java.awt.Color;
import java.awt.Graphics;

class personGroup
{
  private final int appletWidth = 440;
  private final int appletHeight = 300;
  private final int topMargin = 80;
  private final int leftMargin = 10;
  private final int textHeight = 13;
  private final int hF1 = 11;
  private final int hF2 = 5;
  private final int vF = 8;
  private final int nColumns = 7;
  private final int nRows = 4;
  private final int columnWidth = 57;
  private final int linkWidth = 35;
  private final int interLink = 20;
  private final int linkHeight = 17;
  private final int digits3Width = 18;
  private final int rowHeight = 57;
  private final int noteBoxTop = 55;
  private final int noteBoxHeight = 25;
  private final int noteBoxWidth = 300;
  private final int ASIZE = 28;
  private final int MAX_KEY = 999;
  private link[] linkArray = new link[28];
  private int totalLinks = 0;
  private int curIn = this.oldCurIn = 0;
  private int codePart = 1;
  private int codePart2 = 1;
  private int drawMode = 2;
  private String note = "Press any button";
  private boolean notSorted = true;
  private boolean isOKChangeSort = false;
  private boolean areInserting = false;
  private final int hF3 = 0;
  private person tempPers;
  private int fillValue;
  private int insKey;
  private int findKey;
  private int delKey;
  private int opMode;
  private int oldCurIn;
  private int insDex;
  private boolean insertAtEnd;
  private int delDex;
  private boolean areDeleting;
  
  private person makePerson(int paramInt)
  {
    int i = 100 + (int)(Math.random() * 154.0D);
    int j = 100 + (int)(Math.random() * 154.0D);
    int k = 100 + (int)(Math.random() * 154.0D);
    Color localColor = new Color(i, j, k);
    return new person(paramInt, localColor);
  }
  
  public boolean getSortStatus()
  {
    return this.notSorted;
  }
  
  public boolean getChangeStatus()
  {
    return this.isOKChangeSort;
  }
  
  public void setSortStatus(boolean paramBoolean)
  {
    if ((this.isOKChangeSort) && (paramBoolean != this.notSorted)) {
      this.notSorted = paramBoolean;
    }
    if (!this.isOKChangeSort) {
      this.note = "To change sort status, create list with New";
    }
    this.drawMode = 1;
  }
  
  public void newList(boolean paramBoolean, int paramInt)
  {
    this.areInserting = false;
    this.areDeleting = false;
    if (this.opMode != 1)
    {
      this.opMode = 1;
      this.codePart = 1;
    }
    switch (this.codePart)
    {
    case 1: 
      this.note = "Enter size of linked list to create";
      this.drawMode = 1;
      this.codePart = 2;
      this.oldCurIn = this.curIn;
      this.curIn = 0;
      return;
    case 2: 
      if ((!paramBoolean) || (paramInt < 0) || (paramInt > 28))
      {
        this.note = ("ERROR: use size between 0 and " + 28);
        this.codePart = 1;
      }
      else
      {
        this.note = 
          ("Will create list with " + paramInt + " links");
        this.codePart = 3;
      }
      this.drawMode = 1;
      return;
    case 3: 
      this.note = "Select unsorted or sorted data";
      this.isOKChangeSort = true;
      this.drawMode = 1;
      this.codePart = 4;
      return;
    case 4: 
      if (this.notSorted) {
        this.note = "Data will not be sorted";
      } else {
        this.note = "Data will be sorted";
      }
      this.isOKChangeSort = false;
      this.totalLinks = 0;
      this.drawMode = 2;
      this.codePart = 5;
      return;
    case 5: 
      this.totalLinks = paramInt;
      doFill(this.totalLinks);
      this.note = 
        ("New list created; total links = " + this.totalLinks);
      this.oldCurIn = this.curIn;
      this.curIn = 0;
      this.drawMode = 2;
      this.codePart = 6;
      return;
    case 6: 
      this.note = "Press any button";
      this.drawMode = 1;
      this.codePart = 1; return;
    }
  }
  
  public void doFill(int paramInt)
  {
    this.totalLinks = paramInt;
    for (int i = 0; i < 28; i++) {
      this.linkArray[i] = null;
    }
    this.oldCurIn = this.curIn;
    this.curIn = 0;
    this.codePart = 1;
    int j;
    if (this.notSorted)
    {
      for (int i = 0; i < this.totalLinks; i++)
      {
        j = (int)(Math.random() * 999.0D);
        this.tempPers = makePerson(j);
        this.linkArray[i] = new link(this.tempPers);
      }
    }
    else
    {
      int k = 0;
      
      int n = 0;
      for (int i = 0; i < this.totalLinks; i++)
      {
        int m = (int)((999.0F - n) / (
          this.totalLinks - i));
        j = (int)(Math.random() * m);
        k += j;
        n = k;
        this.tempPers = makePerson(k);
        this.linkArray[i] = new link(this.tempPers);
      }
    }
  }
  
  public void insert(boolean paramBoolean, int paramInt)
  {
    this.areDeleting = false;
    if (this.opMode != 3)
    {
      this.opMode = 3;
      this.codePart = 1;
    }
    switch (this.codePart)
    {
    case 1: 
      this.oldCurIn = this.curIn;
      this.curIn = 0;
      this.insertAtEnd = false;
      this.note = "Enter key of item to insert";
      this.drawMode = 1;
      this.codePart = 2;
      return;
    case 2: 
      if ((!paramBoolean) || (paramInt < 0) || (paramInt > 999))
      {
        this.note = 
          ("CAN'T INSERT: need key between 0 and " + 999);
        this.codePart = 1;
      }
      else if (this.totalLinks >= 28)
      {
        this.note = "CAN'T INSERT: no room in display";
        this.codePart = 6;
      }
      else
      {
        this.insKey = paramInt;
        
        this.tempPers = makePerson(this.insKey);
        if (this.notSorted)
        {
          this.note = ("Will insert item with key " + this.insKey);
          this.codePart = 4;
        }
        else
        {
          this.note = "Will search for insertion point";
          this.codePart = 3;
        }
      }
      this.drawMode = 1;
      return;
    case 3: 
      if ((this.curIn == this.totalLinks - 1) && 
        (this.insKey > this.linkArray[this.curIn].persData.getHeight()))
      {
        this.note = "Found insertion point at end of list";
        this.insertAtEnd = true;
        this.codePart = 5;
      }
      else if (this.insKey > 
        this.linkArray[this.curIn].persData.getHeight())
      {
        this.note = "Searching for insertion point";
        this.oldCurIn = (this.curIn++);
        this.codePart = 3;
      }
      else
      {
        this.note = "Have found insertion point";
        this.codePart = 4;
      }
      this.drawMode = 1;
      return;
    case 4: 
      this.areInserting = true;
      if (this.notSorted) {
        this.insDex = 0;
      } else {
        this.insDex = this.curIn;
      }
      this.note = "Inserted item; will redraw list";
      this.drawMode = 1;
      this.codePart = 5;
      return;
    case 5: 
      if (this.insertAtEnd)
      {
        this.oldCurIn = (this.curIn++);
        this.note = 
          ("Inserted item with key " + this.insKey + " at end of list");
      }
      else
      {
        this.areInserting = false;
        for (int i = this.totalLinks; i > this.curIn; i--) {
          this.linkArray[i] = this.linkArray[(i - 1)];
        }
        this.note = ("Inserted item with key " + this.insKey);
      }
      this.linkArray[this.curIn] = new link(this.tempPers);
      this.totalLinks += 1;
      this.drawMode = 2;
      this.codePart = 6;
      return;
    case 6: 
      this.note = 
        ("Insertion completed; total items = " + this.totalLinks);
      this.drawMode = 1;
      this.codePart = 7;
      return;
    case 7: 
      this.oldCurIn = this.curIn;
      this.curIn = 0;
      this.note = "Press any button";
      this.drawMode = 1;
      this.codePart = 1; return;
    }
  }
  
  public void find(boolean paramBoolean, int paramInt)
  {
    this.areInserting = false;
    this.areDeleting = false;
    if (this.opMode != 4)
    {
      this.opMode = 4;
      this.codePart = 1;
    }
    switch (this.codePart)
    {
    case 1: 
      this.note = "Enter key of item to find";
      this.codePart = 2;
      break;
    case 2: 
      if ((!paramBoolean) || (paramInt < 0) || (paramInt > 999))
      {
        this.note = ("ERROR: use key between 0 and " + 999);
        this.codePart = 1;
      }
      else
      {
        this.findKey = paramInt;
        this.oldCurIn = this.curIn;
        this.curIn = 0;
        this.note = ("Looking for item with key " + this.findKey);
        this.codePart = 3;
      }
      break;
    case 3: 
      if (this.linkArray[this.curIn].persData.getHeight() == this.findKey)
      {
        this.note = ("Have found item with key " + this.findKey);
        this.codePart = 6;
      }
      else if ((this.curIn == this.totalLinks - 1) || (
        (!this.notSorted) && 
        (this.linkArray[this.curIn].persData.getHeight() > this.findKey)))
      {
        this.note = ("Can't locate item with key " + this.findKey);
        this.codePart = 6;
      }
      else
      {
        this.note = ("Searching for item with key " + this.findKey);
        this.oldCurIn = (this.curIn++);
        this.codePart = 3;
      }
      break;
    case 6: 
      this.oldCurIn = this.curIn;
      this.curIn = 0;
      this.note = "Press any button";
      this.codePart = 1;
      break;
    }
    this.drawMode = 1;
  }
  
  public void delete(boolean paramBoolean, int paramInt)
  {
    this.areInserting = false;
    if (this.opMode != 5)
    {
      this.opMode = 5;
      this.codePart = 1;
    }
    switch (this.codePart)
    {
    case 1: 
      this.note = "Enter key of item to delete";
      this.drawMode = 1;
      this.codePart = 2;
      return;
    case 2: 
      if ((!paramBoolean) || (paramInt < 0) || (paramInt > 999))
      {
        this.note = ("ERROR: use key between 0 and " + 999);
        this.codePart = 1;
      }
      else
      {
        this.delKey = paramInt;
        this.oldCurIn = this.curIn;
        this.curIn = 0;
        this.note = ("Looking for item with key " + this.delKey);
        this.codePart = 3;
      }
      this.drawMode = 1;
      return;
    case 3: 
      if (this.linkArray[this.curIn].persData.getHeight() == this.delKey)
      {
        this.note = ("Have found item with key " + this.delKey);
        if (this.curIn == this.totalLinks - 1) {
          this.codePart = 5;
        } else {
          this.codePart = 4;
        }
      }
      else if ((this.curIn == this.totalLinks - 1) || (
        (!this.notSorted) && 
        (this.linkArray[this.curIn].persData.getHeight() > this.delKey)))
      {
        this.note = ("Can't locate item with key " + this.delKey);
        this.codePart = 6;
      }
      else
      {
        this.note = ("Searching for item with key " + this.delKey);
        this.oldCurIn = (this.curIn++);
        this.codePart = 3;
      }
      this.drawMode = 1;
      return;
    case 4: 
      this.areDeleting = true;
      this.delDex = this.curIn;
      this.note = "Deleted item; will redraw list";
      this.drawMode = 1;
      this.codePart = 5;
      return;
    case 5: 
      this.areDeleting = false;
      for (int i = this.curIn; i < this.totalLinks - 1; i++) {
        this.linkArray[i] = this.linkArray[(i + 1)];
      }
      this.totalLinks -= 1;
      this.oldCurIn = this.curIn;
      this.curIn = 0;
      this.note = ("Deleted item with key " + this.delKey);
      this.drawMode = 2;
      this.codePart = 6;
      return;
    case 6: 
      this.oldCurIn = this.curIn;
      this.curIn = 0;
      this.note = "Press any button";
      this.codePart = 1; return;
    }
  }
  
  public void drawLink(Graphics paramGraphics, int paramInt)
  {
    int i = 32 + 57 * (paramInt % 7);
    int j = 89 + 57 * (paramInt / 7);
    if (this.linkArray[this.curIn] != null)
    {
      paramGraphics.setColor(Color.black);
      paramGraphics.drawRect(i, j - 5, 35, 17);
      
      int m = this.linkArray[paramInt].persData.getHeight();
      paramGraphics.setColor(this.linkArray[paramInt].persData.getColor());
      
      paramGraphics.fill3DRect(i + 1, j - 4, 34, 
        16, true);
      int k;
      if (m < 10) {
        k = 11;
      } else if (m < 100) {
        k = 5;
      } else {
        k = 0;
      }
      paramGraphics.setColor(Color.black);
      paramGraphics.drawString(String.valueOf(m), i + k + 10, j + 17 - 8);
      if (paramInt < this.totalLinks - 1) {
        if (paramInt % 7 != 6)
        {
          paramGraphics.drawLine(i + 35, j + 8 - 4, 
            i + 35 + 20, j + 8 - 4);
          smallArrow(paramGraphics, i + 35 + 20, j + 8 - 4);
        }
        else
        {
          int n = j + 8 - 4;
          paramGraphics.drawLine(i + 35, n, 
            i + 35 + 8, n);
          paramGraphics.drawLine(i + 35 + 8, n, 
            i + 35 + 8, n + 34 + 4);
          
          paramGraphics.drawLine(i + 35 + 8, n + 34 + 4, 
            10, n + 34 + 4);
          
          paramGraphics.drawLine(10, n + 34 + 4, 
            10, n + 57);
          
          paramGraphics.drawLine(10, n + 57, 
            30, n + 57);
          smallArrow(paramGraphics, 30, n + 57);
        }
      }
    }
    if ((paramInt == this.curIn) && (!this.areInserting)) {
      paramGraphics.setColor(Color.red);
    } else {
      paramGraphics.setColor(Color.lightGray);
    }
    int n = i + 17;
    int i1 = j + 17 - 3;
    paramGraphics.drawLine(n, i1, n, i1 + 19);
    paramGraphics.drawLine(n + 1, i1, n + 1, i1 + 19);
    paramGraphics.drawLine(n, i1, n + 6, i1 + 10);
    paramGraphics.drawLine(n + 1, i1, n + 7, i1 + 10);
    paramGraphics.drawLine(n, i1, n - 6, i1 + 10);
    paramGraphics.drawLine(n + 1, i1, n - 5, i1 + 10);
  }
  
  private void drawInsertLink(Graphics paramGraphics)
  {
    int i = 15 + 57 * (this.insDex % 7);
    int j = 115 + 57 * (this.insDex / 7);
    paramGraphics.setColor(Color.black);
    paramGraphics.drawRect(i, j - 5, 35, 17);
    
    int m = this.tempPers.getHeight();
    paramGraphics.setColor(this.tempPers.getColor());
    
    paramGraphics.fill3DRect(i + 1, j - 4, 34, 16, true);
    int k;
    if (m < 10) {
      k = 11;
    } else if (m < 100) {
      k = 5;
    } else {
      k = 0;
    }
    paramGraphics.setColor(Color.black);
    paramGraphics.drawString(String.valueOf(m), i + k + 10, j + 17 - 8);
    int n = j + 8 - 3;
    if (this.insDex != 0)
    {
      paramGraphics.setColor(Color.lightGray);
      paramGraphics.drawLine(i - 4, n - 27, 
        i + 8 + 7, n - 27);
      paramGraphics.setColor(Color.black);
      paramGraphics.drawLine(i - 4, n - 27, i + 2, n - 27);
      paramGraphics.drawLine(i + 2, n - 27, i + 2, n - 14);
      paramGraphics.drawLine(i + 2, n - 14, i - 8, n - 14);
      paramGraphics.drawLine(i - 8, n - 14, i - 8, n - 1);
      paramGraphics.drawLine(i - 8, n - 1, i - 1, n - 1);
      smallArrow(paramGraphics, i - 1, n - 1);
    }
    paramGraphics.drawLine(i + 35, n - 1, 
      i + 35 + 8, n - 1);
    paramGraphics.drawLine(i + 35 + 8, n - 1, 
      i + 35 + 8, n - 14);
    paramGraphics.drawLine(i + 35 + 8, n - 14, 
      i + 8, n - 14);
    paramGraphics.drawLine(i + 8, n - 14, 
      i + 8, n - 27);
    paramGraphics.drawLine(i + 8, n - 27, 
      i + 8 + 7, n - 27);
    smallArrow(paramGraphics, i + 8 + 7, n - 27);
  }
  
  private void drawDeleteLink(Graphics paramGraphics)
  {
    int i = 32 + 57 * (this.delDex % 7);
    int j = 89 + 57 * (this.delDex / 7);
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(i - 10, j - 5, 46, 18);
    if (this.delDex == this.totalLinks - 1) {
      paramGraphics.setColor(Color.lightGray);
    } else {
      paramGraphics.setColor(Color.black);
    }
    paramGraphics.drawLine(i - 20 - 1, j + 8 - 4, 
      i + 35 + 7, j + 8 - 4);
  }
  
  private void smallArrow(Graphics paramGraphics, int paramInt1, int paramInt2)
  {
    paramGraphics.drawLine(paramInt1, paramInt2, paramInt1 - 5, paramInt2 - 3);
    paramGraphics.drawLine(paramInt1, paramInt2, paramInt1 - 5, paramInt2 + 3);
  }
  
  public void draw(Graphics paramGraphics)
  {
    if (this.drawMode == 1)
    {
      paramGraphics.setColor(Color.lightGray);
      paramGraphics.fillRect(10, 55, 300, 
        25);
      paramGraphics.setColor(Color.black);
      paramGraphics.drawString(this.note, 16, 
        74);
      
      drawLink(paramGraphics, this.oldCurIn);
      drawLink(paramGraphics, this.curIn);
      this.drawMode = 2;
    }
    else
    {
      paramGraphics.setColor(Color.lightGray);
      paramGraphics.fillRect(0, 0, 440, 300);
      for (int i = 0; i < this.totalLinks; i++) {
        drawLink(paramGraphics, i);
      }
      paramGraphics.setColor(Color.black);
      paramGraphics.drawString(this.note, 16, 
        74);
    }
    if (this.areInserting) {
      drawInsertLink(paramGraphics);
    } else if (this.areDeleting) {
      drawDeleteLink(paramGraphics);
    }
  }
}
