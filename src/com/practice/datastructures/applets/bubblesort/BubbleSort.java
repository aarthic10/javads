package com.practice.datastructures.applets.bubblesort;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class BubbleSort
  extends Applet
  implements Runnable, ActionListener
{
  private Image offscreenImage;
  private Graphics offscreenGraphics;
  private int aWidth;
  private int aHeight;
  private Thread runner;
  private int groupSize = 10;
  private groupBS thePersonGroup;
  private boolean runFlag;
  private int order = 1;
  private Button newButton;
  private Button sizeButton;
  private Button drawButton;
  private Button runButton;
  private Button stepButton;
  
  public void init()
  {
    this.thePersonGroup = new groupBS(this.groupSize, this.order);
    setLayout(new FlowLayout(2));
    
    this.newButton = new Button("New");
    add(this.newButton);
    this.newButton.addActionListener(this);
    
    this.sizeButton = new Button("Size");
    add(this.sizeButton);
    this.sizeButton.addActionListener(this);
    
    this.drawButton = new Button("Draw");
    add(this.drawButton);
    this.drawButton.addActionListener(this);
    
    this.runButton = new Button("Run");
    add(this.runButton);
    this.runButton.addActionListener(this);
    
    this.stepButton = new Button("Step");
    add(this.stepButton);
    this.stepButton.addActionListener(this);
    
    this.aWidth = this.thePersonGroup.getAppletWidth();
    this.aHeight = this.thePersonGroup.getAppletHeight();
    this.offscreenImage = createImage(this.aWidth, this.aHeight);
    this.offscreenGraphics = this.offscreenImage.getGraphics();
    
    this.thePersonGroup.setDrawMode(2);
    this.runFlag = false;
  }
  
  public void paint(Graphics paramGraphics)
  {
    this.thePersonGroup.draw(this.offscreenGraphics);
    paramGraphics.drawImage(this.offscreenImage, 0, 0, this);
  }
  
  public void update(Graphics paramGraphics)
  {
    paint(paramGraphics);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    if (paramActionEvent.getSource() == this.newButton)
    {
      this.runFlag = false;
      this.order = (this.order == 1 ? 2 : 1);
      this.thePersonGroup = new groupBS(this.groupSize, this.order);
    }
    else if (paramActionEvent.getSource() == this.sizeButton)
    {
      this.runFlag = false;
      this.groupSize = (this.groupSize == 10 ? 100 : 10);
      this.thePersonGroup = new groupBS(this.groupSize, this.order);
    }
    else if (paramActionEvent.getSource() == this.drawButton)
    {
      this.runFlag = false;
      this.thePersonGroup.setDrawMode(2);
    }
    else if (paramActionEvent.getSource() == this.runButton)
    {
      this.runFlag = true;
    }
    else if (paramActionEvent.getSource() == this.stepButton)
    {
      this.runFlag = false;
      this.thePersonGroup.sortStep();
      this.thePersonGroup.setDrawMode(1);
    }
    repaint();
  }
  
  public void run()
  {
    Thread localThread = Thread.currentThread();
    while (this.runner == localThread) {
      if ((this.runFlag == true) && (this.thePersonGroup.getDone() == false))
      {
        this.thePersonGroup.sortStep();
        repaint();
        this.thePersonGroup.setDrawMode(1);
        int i = this.groupSize == 10 ? 250 : 75;
        try
        {
          Thread.sleep(i);
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
  
  public void start()
  {
    if (this.runner == null)
    {
      this.runner = new Thread(this);
      this.runner.start();
    }
  }
  
  public void stop()
  {
    this.runner = null;
  }
}
