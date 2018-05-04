package com.practice.datastructures.applets.binarytree;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class Tree
  extends Applet
  implements Runnable, ActionListener
{
  private Thread runner;
  private int groupSize = 24;
  private personGroup thePersonGroup;
  private boolean runFlag;
  private int order = 1;
  private int GPNumber = -1;
  private boolean isNumber = false;
  private TextField tf = new TextField("", 3);
  private int MAX_KEY = 99;
  private Button fillButton;
  private Button findButton;
  private Button insButton;
  private Button travButton;
  private Button delButton;
  
  public void init()
  {
    this.runFlag = false;
    this.thePersonGroup = new personGroup();
    setLayout(new FlowLayout());
    Panel localPanel1 = new Panel();
    add(localPanel1);
    localPanel1.setLayout(new FlowLayout());
    
    Panel localPanel2 = new Panel();
    localPanel1.add(localPanel2);
    localPanel2.setLayout(new FlowLayout(0));
    
    this.fillButton = new Button("Fill");
    localPanel2.add(this.fillButton);
    this.fillButton.addActionListener(this);
    
    this.findButton = new Button("Find");
    localPanel2.add(this.findButton);
    this.findButton.addActionListener(this);
    
    this.insButton = new Button("Ins");
    localPanel2.add(this.insButton);
    this.insButton.addActionListener(this);
    
    this.travButton = new Button("Trav");
    localPanel2.add(this.travButton);
    this.travButton.addActionListener(this);
    
    this.delButton = new Button("Del");
    localPanel2.add(this.delButton);
    this.delButton.addActionListener(this);
    
    Panel localPanel3 = new Panel();
    localPanel1.add(localPanel3);
    localPanel3.setLayout(new FlowLayout(2));
    localPanel3.add(new Label("Enter number: "));
    localPanel3.add(this.tf);
    this.thePersonGroup = new personGroup();
    this.thePersonGroup.doFill(20);
    repaint();
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
    if (this.runner != null)
    {
      this.runner.stop();
      this.runner = null;
    }
  }
  
  public void paint(Graphics paramGraphics)
  {
    this.thePersonGroup.draw(paramGraphics);
  }
  
  public void update(Graphics paramGraphics)
  {
    paint(paramGraphics);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    this.isNumber = true;
    String str = this.tf.getText();
    try
    {
      this.GPNumber = Integer.parseInt(str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.GPNumber = 0;
      this.isNumber = false;
    }
    this.thePersonGroup.setDrawAll(false);
    if (paramActionEvent.getSource() == this.fillButton) {
      this.thePersonGroup.fill(this.isNumber, this.GPNumber);
    } else if (paramActionEvent.getSource() == this.findButton) {
      this.thePersonGroup.find(this.isNumber, this.GPNumber);
    } else if (paramActionEvent.getSource() == this.insButton) {
      this.thePersonGroup.insert(this.isNumber, this.GPNumber);
    } else if (paramActionEvent.getSource() == this.travButton) {
      this.thePersonGroup.traverse();
    } else if (paramActionEvent.getSource() == this.delButton) {
      this.thePersonGroup.remove(this.isNumber, this.GPNumber);
    }
    repaint();
    try
    {
      Thread.sleep(10L); return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public void run()
  {
    label3:
    break label3;
  }
}
