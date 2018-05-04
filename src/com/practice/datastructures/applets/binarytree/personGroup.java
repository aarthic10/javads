package com.practice.datastructures.applets.binarytree;
import java.awt.Color;
import java.awt.Graphics;

class personGroup
{
  private final int appletWidth = 440;
  private final int appletHeight = 300;
  private final int maxHeight = 200;
  private final int topMargin = 70;
  private final int leftMargin = 10;
  private final int textHeight = 13;
  private final int nodeDiameter = 20;
  private final int levelSeparation = 40;
  private final int horizSeparation = 26;
  private final int noteBoxTop = 45;
  private final int noteBoxHeight = 25;
  private final int noteBoxWidth = 200;
  private final int visitBoxTop = 280;
  private final int visitBoxHeight = 25;
  private final int visitBoxWidth = 430;
  private final int ASIZE = 31;
  private final int MAX_KEY = 99;
  private person[] treeArray;
  stack theStack = new stack();
  private int filledNodes;
  private String note;
  private boolean isRand = true;
  private int value;
  private int codePart = 1;
  private int opMode;
  private int curIn;
  private int curInOld;
  private int oldArrow;
  private int[] visitArray;
  private int visitIndex;
  private int successor;
  private boolean drawAll;
  private int drawMode = 2;
  
  public personGroup()
  {
    this.treeArray = new person[31];
    for (int i = 0; i < 31; i++) {
      this.treeArray[i] = null;
    }
    this.filledNodes = 0;
    this.note = "Press a button";
    this.visitArray = new int[31];
    this.visitIndex = 0;
  }
  
  public person makePerson(int paramInt)
  {
    int i = 100 + (int)(Math.random() * 154.0D);
    int j = 100 + (int)(Math.random() * 154.0D);
    int k = 100 + (int)(Math.random() * 154.0D);
    Color localColor = new Color(i, j, k);
    return new person(paramInt, localColor);
  }
  
  public void setDrawAll(boolean paramBoolean)
  {
    this.drawAll = paramBoolean;
  }
  
  public void fill(boolean paramBoolean, int paramInt)
  {
    if (this.opMode != 1)
    {
      this.opMode = 1;
      this.codePart = 1;
    }
    switch (this.codePart)
    {
    case 1: 
      this.visitIndex = 0;
      this.note = "Enter number of nodes (1 to 31)";
      this.curIn = 0;
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.drawMode = 0;
      this.codePart = 2;
      return;
    case 2: 
      if ((!paramBoolean) || (paramInt < 0) || (paramInt > 31))
      {
        this.note = "Inappropriate number of nodes";
        this.codePart = 1;
      }
      else
      {
        this.note = 
          ("Will create tree of " + paramInt + " nodes");
        this.codePart = 3; return;
      }
      break;
    case 3: 
      doFill(paramInt);
      this.drawMode = 2;
      this.note = "Press any button";
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.codePart = 1; return;
    }
  }
  
  public void doFill(int paramInt)
  {
    int i = 0;
    for (int k = 0; k < 31; k++) {
      this.treeArray[k] = null;
    }
    this.filledNodes = 0;
    
    boolean[] arrayOfBoolean = new boolean[100];
    for (int m = 0; m < 100; m++) {
      arrayOfBoolean[m] = false;
    }
    while ((this.filledNodes < paramInt) && (i < 100))
    {
      int j;
      do
      {
        j = (int)(Math.random() * 99.0D);
      } while (arrayOfBoolean[j]);
      person localperson = makePerson(j);
      this.curIn = 0;
      for (;;)
      {
        if (this.curIn > 30)
        {
          i++;
          break;
        }
        if (this.treeArray[this.curIn] == null)
        {
          this.treeArray[this.curIn] = localperson;
          this.filledNodes += 1;
          arrayOfBoolean[j] = true;
          break;
        }
        if (j < this.treeArray[this.curIn].getHeight()) {
          this.curIn = (2 * this.curIn + 1);
        } else {
          this.curIn = (2 * this.curIn + 2);
        }
      }
    }
  }
  
  public void find(boolean paramBoolean, int paramInt)
  {
    if (this.opMode != 2)
    {
      this.opMode = 2;
      this.codePart = 1;
    }
    switch (this.codePart)
    {
    case 1: 
      this.visitIndex = 0;
      this.note = "Enter key of node to find";
      this.curIn = 0;
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.drawMode = 0;
      this.codePart = 2;
      return;
    case 2: 
      if ((!paramBoolean) || (paramInt < 0) || (paramInt > 99))
      {
        this.note = "Nodes have values from 0 to 99";
        this.codePart = 1;
      }
      else
      {
        this.note = 
          ("Will try to find node with key " + paramInt);
        this.codePart = 3; return;
      }
      break;
    case 3: 
      if (this.treeArray[this.curIn] == null)
      {
        this.note = "Can't find node with that value";
        this.codePart = 1;
        return;
      }
      if (paramInt == this.treeArray[this.curIn].getHeight())
      {
        this.note = ("Have found node " + paramInt);
        this.oldArrow = this.curInOld;
        this.curInOld = this.curIn;
        this.codePart = 4;
        return;
      }
      this.oldArrow = this.curInOld;
      this.curInOld = this.curIn;
      if (paramInt < this.treeArray[this.curIn].getHeight())
      {
        this.curIn = (2 * this.curIn + 1);
        this.note = "Going to left child";
      }
      else
      {
        this.curIn = (2 * this.curIn + 2);
        this.note = "Going to right child";
      }
      this.codePart = 3;
      if (this.curIn > 30)
      {
        this.note = "Can't find node with that value";
        this.codePart = 1; return;
      }
      break;
    case 4: 
      this.note = "Search is complete";
      this.codePart = 5;
      return;
    case 5: 
      this.note = "Press any button";
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.codePart = 1; return;
    }
  }
  
  public void insert(boolean paramBoolean, int paramInt)
  {
    if (this.opMode != 3)
    {
      this.opMode = 3;
      this.codePart = 1;
    }
    switch (this.codePart)
    {
    case 1: 
      this.visitIndex = 0;
      this.note = "Enter value of node to insert";
      this.curIn = 0;
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.drawMode = 0;
      this.codePart = 2;
      return;
    case 2: 
      this.value = paramInt;
      if ((!paramBoolean) || (paramInt < 0) || (paramInt > 99))
      {
        this.note = "Nodes have values from 0 to 99";
        this.codePart = 1;
      }
      else
      {
        this.note = ("Will insert node with key " + this.value);
        this.codePart = 3; return;
      }
      break;
    case 3: 
      this.oldArrow = this.curInOld;
      this.curInOld = this.curIn;
      if (this.curIn > 30)
      {
        this.note = "Level is too great";
        this.codePart = 4;
        return;
      }
      if (this.treeArray[this.curIn] == null)
      {
        this.treeArray[this.curIn] = makePerson(this.value);
        this.value = this.treeArray[this.curIn].getHeight();
        this.note = 
          ("Have inserted node with key " + this.value);
        this.filledNodes += 1;
        this.curInOld = this.curIn;
        this.drawMode = 1;
        this.codePart = 4;
      }
      else
      {
        if (this.value < this.treeArray[this.curIn].getHeight())
        {
          this.curIn = (2 * this.curIn + 1);
          this.note = "Going to left child";
        }
        else
        {
          this.curIn = (2 * this.curIn + 2);
          this.note = "Going to right child";
        }
        this.codePart = 3;
        if (this.curIn > 30)
        {
          this.note = "Can't insert: Level is too great";
          this.codePart = 1;
        }
        this.drawMode = 0; return;
      }
      break;
    case 4: 
      this.note = "Insertion completed";
      this.drawMode = 0;
      this.codePart = 5;
      return;
    case 5: 
      this.note = "Press any button";
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.codePart = 1; return;
    }
  }
  
  public void remove(boolean paramBoolean, int paramInt)
  {
    if (this.opMode != 4)
    {
      this.opMode = 4;
      this.codePart = 1;
    }
    switch (this.codePart)
    {
    case 1: 
      this.visitIndex = 0;
      this.note = "Enter key of node to delete";
      this.codePart = 2;
      this.curIn = 0;
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.drawMode = 0;
      return;
    case 2: 
      if ((!paramBoolean) || (paramInt < 0) || (paramInt > 99))
      {
        this.note = "Nodes have values from 0 to 99";
        this.codePart = 1;
      }
      else
      {
        this.note = 
          ("Will try to delete node " + paramInt);
        this.codePart = 3;
      }
      this.curIn = 0;
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      return;
    case 3: 
      if (this.treeArray[this.curIn] == null)
      {
        this.note = "Can't find node with that value";
        this.codePart = 1;
        return;
      }
      if (paramInt == this.treeArray[this.curIn].getHeight())
      {
        this.note = "Have found node to delete";
        this.oldArrow = this.curInOld;
        this.curInOld = this.curIn;
        this.codePart = 4;
        return;
      }
      this.oldArrow = this.curInOld;
      this.curInOld = this.curIn;
      if (paramInt < this.treeArray[this.curIn].getHeight())
      {
        this.curIn = (2 * this.curIn + 1);
        this.note = "Going to left child";
      }
      else
      {
        this.curIn = (2 * this.curIn + 2);
        this.note = "Going to right child";
      }
      this.codePart = 3;
      if (this.curIn > 30)
      {
        this.note = "Can't find node with that value";
        this.codePart = 1; return;
      }
      break;
    case 4: 
      if ((this.curIn > 14) || (
        (this.treeArray[(2 * this.curIn + 1)] == null) && 
        (this.treeArray[(2 * this.curIn + 2)] == null)))
      {
        this.note = "Will delete node without complication";
        this.codePart = 5;
      }
      else if (this.treeArray[(2 * this.curIn + 1)] == null)
      {
        this.note = "Will replace node with its right subtree";
        this.codePart = 6;
      }
      else if (this.treeArray[(2 * this.curIn + 2)] == null)
      {
        this.note = "Will replace node with its left subtree";
        this.codePart = 7;
      }
      else
      {
        this.successor = inorderSuccessor(this.curIn);
        this.note = 
          ("Will replace node with " + this.treeArray[this.successor].getHeight());
        this.codePart = 8; return;
      }
      break;
    case 5: 
      this.treeArray[this.curIn] = null;
      this.note = "Node was deleted";
      this.drawMode = 2;
      this.codePart = 10;
      return;
    case 6: 
      this.treeArray[this.curIn] = null;
      moveUpSubTree(1, this.curIn);
      this.note = "Node was replaced by its right subtree";
      this.drawMode = 2;
      this.codePart = 10;
      return;
    case 7: 
      this.treeArray[this.curIn] = null;
      moveUpSubTree(0, this.curIn);
      this.note = "Node was replaced by its left subtree";
      this.drawMode = 2;
      this.codePart = 10;
      return;
    case 8: 
      this.treeArray[this.curIn] = this.treeArray[this.successor];
      
      int i = 2 * this.successor + 2;
      if ((this.successor < 15) && (this.treeArray[i] != null))
      {
        int j = this.treeArray[this.successor].getHeight();
        this.note = 
          ("and replace " + j + " with its right subtree");
        this.drawMode = 0;
        this.codePart = 9;
      }
      else
      {
        this.treeArray[this.successor] = null;
        this.note = "Node was replaced by successor";
        this.drawMode = 2;
        this.codePart = 10; return;
      }
      break;
    case 9: 
      moveUpSubTree(1, this.successor);
      this.note = "Removed node in 2-step process";
      this.drawMode = 2;
      this.codePart = 10;
      return;
    case 10: 
      this.note = "Press any button";
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.codePart = 1; return;
    }
  }
  
  public void moveUpSubTree(int paramInt1, int paramInt2)
  {
    if ((paramInt2 > 14) || (paramInt2 < 0)) {
      return;
    }
    int i;
    if (paramInt1 == 1) {
      i = 2 * paramInt2 + 2;
    } else {
      i = 2 * paramInt2 + 1;
    }
    int m;
    if ((i > 0) && (i < 3)) {
      m = 1;
    } else if ((i > 2) && (i < 7)) {
      m = 2;
    } else if ((i > 6) && (i < 15)) {
      m = 3;
    } else {
      m = 4;
    }
    int n = i;
    int j = n;
    int k = 1;
    for (int i4 = m; i4 < 5; i4++)
    {
      for (int i5 = 0; i5 < k; i5++)
      {
        int i2 = (j - 1) / 2;
        int i1 = k - i5 - 1;
        int i3;
        if (paramInt1 == 1) {
          i3 = i2 - (i1 + 1) / 2;
        } else {
          i3 = i2 + (i5 + 1) / 2;
        }
        this.treeArray[i3] = this.treeArray[j];
        if (i4 == 4) {
          this.treeArray[j] = null;
        }
        j++;
      }
      n = 2 * n + 1;
      j = n;
      k *= 2;
    }
  }
  
  public int inorderSuccessor(int paramInt)
  {
    int i = paramInt;
    int j = 2 * paramInt + 2;
    while ((j < 31) && (this.treeArray[j] != null))
    {
      i = j;
      j = 2 * j + 1;
    }
    return i;
  }
  
  public void traverse()
  {
    if (this.opMode != 5)
    {
      this.opMode = 5;
      this.codePart = 1;
    }
    switch (this.codePart)
    {
    case 1: 
      this.visitIndex = 0;
      this.note = "Will traverse tree in \"inorder\"";
      this.curIn = 0;
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.drawMode = 0;
      this.codePart = 2;
      return;
    case 2: 
      this.note = "Will check left child";
      this.codePart = 3;
      return;
    case 3: 
      if ((this.curIn > 14) || (this.treeArray[(2 * this.curIn + 1)] == null))
      {
        this.note = "Will visit this node";
        this.codePart = 4;
      }
      else
      {
        this.theStack.push(this.curIn);
        this.curIn = (2 * this.curIn + 1);
        this.oldArrow = this.curInOld;
        this.curInOld = this.curIn;
        this.note = "Will check for left child";
        this.codePart = 3; return;
      }
      break;
    case 4: 
      this.visitArray[(this.visitIndex++)] = 
        this.treeArray[this.curIn].getHeight();
      this.note = "Will check for right child";
      this.codePart = 5;
      return;
    case 5: 
      if ((this.curIn > 14) || (this.treeArray[(2 * this.curIn + 2)] == null))
      {
        this.note = "Will go to root of last subtree";
        this.codePart = 6;
      }
      else
      {
        this.curIn = (2 * this.curIn + 2);
        this.oldArrow = this.curInOld;
        this.curInOld = this.curIn;
        this.note = "Will check left child";
        this.codePart = 3; return;
      }
      break;
    case 6: 
      if (this.theStack.isEmpty())
      {
        this.note = "Done traversal";
        this.codePart = 7;
      }
      else
      {
        this.curIn = this.theStack.pop();
        this.oldArrow = this.curInOld;
        this.curInOld = this.curIn;
        this.note = "Will visit this node";
        this.codePart = 4; return;
      }
      break;
    case 7: 
      this.note = "Press any button";
      this.oldArrow = this.curInOld;
      this.curInOld = 0;
      this.codePart = 1; return;
    }
  }
  
  public void drawOneNode(Graphics paramGraphics, int paramInt)
  {
    if (this.treeArray[paramInt] == null) {
      return;
    }
    int i = this.treeArray[paramInt].getHeight();
    Color localColor = this.treeArray[paramInt].getColor();
    int j = paramInt % 2;
    int k = 15;
    int m = 0;
    int n = -1;
    if ((paramInt > 0) && (paramInt < 3))
    {
      k = 7 + (paramInt - 1) * 16;
      m = 1;
      n = j == 1 ? k + 8 : k - 8;
    }
    else if ((paramInt > 2) && (paramInt < 7))
    {
      k = 3 + (paramInt - 3) * 8;
      m = 2;
      n = j == 1 ? k + 4 : k - 4;
    }
    else if ((paramInt > 6) && (paramInt < 15))
    {
      k = 1 + (paramInt - 7) * 4;
      m = 3;
      n = j == 1 ? k + 2 : k - 2;
    }
    else if ((paramInt > 14) && (paramInt < 31))
    {
      k = (paramInt - 15) * 2;
      m = 4;
      n = j == 1 ? k + 1 : k - 1;
    }
    int i1 = 10 + k * 26 / 2;
    int i2 = 70 + m * 40;
    
    int i3 = 10 + n * 26 / 2;
    int i4 = 70 + (m - 1) * 40;
    if (m > 0)
    {
      paramGraphics.setColor(Color.black);
      paramGraphics.drawLine(i1 + 10, i2 + 10, 
        i3 + 10, i4 + 10);
    }
    paramGraphics.setColor(localColor);
    paramGraphics.fillOval(i1, i2, 20, 20);
    paramGraphics.setColor(Color.black);
    paramGraphics.drawOval(i1, i2, 20, 20);
    if (i < 10) {
      paramGraphics.drawString(String.valueOf(i), i1 + 7, i2 + 20 - 5);
    } else {
      paramGraphics.drawString(String.valueOf(i), i1 + 4, i2 + 20 - 5);
    }
  }
  
  public void draw(Graphics paramGraphics)
  {
    int i = this.drawAll == true ? 2 : this.drawMode;
    switch (i)
    {
    case 1: 
      int j = this.curInOld;
      while (j > 0)
      {
        drawOneNode(paramGraphics, j);
        j = (j - 1) / 2;
      }
      drawOneNode(paramGraphics, 0);
      break;
    case 2: 
      paramGraphics.setColor(Color.lightGray);
      paramGraphics.fillRect(0, 0, 440, 300);
      
      int k = 30;
      for (;;)
      {
        drawOneNode(paramGraphics, k);k--;
        if (k < 0) {
          break;
        }
      }
    }
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(10, 45, 200, 
      25);
    paramGraphics.setColor(Color.black);
    paramGraphics.drawString(this.note, 16, 
      64);
    
    paramGraphics.setColor(Color.lightGray);
    paramGraphics.fillRect(10, 280, 
      430, 25);
    paramGraphics.setColor(Color.black);
    String str = "";
    for (int k = 0; k < this.visitIndex; k++) {
      str = str + this.visitArray[k] + " ";
    }
    paramGraphics.drawString(str, 16, 
      296);
    drawArrow(paramGraphics, this.oldArrow, false);
    drawArrow(paramGraphics, this.curInOld, true);
    
    this.drawAll = true;
  }
  
  public void drawArrow(Graphics paramGraphics, int paramInt, boolean paramBoolean)
  {
    if (this.treeArray[paramInt] == null) {
      return;
    }
    int i = 15;
    int j = 0;
    if ((paramInt > 0) && (paramInt < 3))
    {
      i = 7 + (paramInt - 1) * 16;
      j = 1;
    }
    else if ((paramInt > 2) && (paramInt < 7))
    {
      i = 3 + (paramInt - 3) * 8;
      j = 2;
    }
    else if ((paramInt > 6) && (paramInt < 15))
    {
      i = 1 + (paramInt - 7) * 4;
      j = 3;
    }
    else if ((paramInt > 14) && (paramInt < 31))
    {
      i = (paramInt - 15) * 2;
      j = 4;
    }
    int k = 10 + i * 26 / 2;
    int m = 70 + j * 40;
    if (paramBoolean == true) {
      paramGraphics.setColor(Color.red);
    } else {
      paramGraphics.setColor(Color.lightGray);
    }
    int n = k + 10;
    int i1 = m - 2;
    int i2 = 20;
    paramGraphics.drawLine(n, i1, n, i1 - i2);
    paramGraphics.drawLine(n - 1, i1, n - 1, i1 - i2);
    paramGraphics.drawLine(n, i1, n - 3, i1 - 6);
    paramGraphics.drawLine(n - 1, i1, n - 4, i1 - 6);
    paramGraphics.drawLine(n, i1, n + 3, i1 - 6);
    paramGraphics.drawLine(n - 1, i1, n + 2, i1 - 6);
  }
}
