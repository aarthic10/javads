package com.practice.datastructures.applets.linklist;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventObject;

public class LinkList
  extends Applet
  implements Runnable, ActionListener, ItemListener
{
  private Thread runner;
  private personGroup thePersonGroup;
  private int GPNumber = -1;
  private boolean isNumber = false;
  private TextField tf = new TextField("", 4);
  private Checkbox nosort;
  private Checkbox sort;
  private Button newButton;
  private Button insButton;
  private Button findButton;
  private Button delButton;
  
  public void init()
  {
    setLayout(new FlowLayout());
    Panel localPanel1 = new Panel();
    add(localPanel1);
    localPanel1.setLayout(new FlowLayout());
    
    Panel localPanel2 = new Panel();
    localPanel1.add(localPanel2);
    localPanel2.setLayout(new FlowLayout(0));
    
    this.newButton = new Button("New");
    localPanel2.add(this.newButton);
    this.newButton.addActionListener(this);
    
    this.insButton = new Button("Ins");
    localPanel2.add(this.insButton);
    this.insButton.addActionListener(this);
    
    this.findButton = new Button("Find");
    localPanel2.add(this.findButton);
    this.findButton.addActionListener(this);
    
    this.delButton = new Button("Del");
    localPanel2.add(this.delButton);
    this.delButton.addActionListener(this);
    
    Panel localPanel3 = new Panel();
    localPanel1.add(localPanel3);
    localPanel3.setLayout(new GridLayout(2, 1));
    CheckboxGroup localCheckboxGroup = new CheckboxGroup();
    
    this.nosort = new Checkbox("Unsorted", true, localCheckboxGroup);
    localPanel3.add(this.nosort);
    this.nosort.addItemListener(this);
    
    this.sort = new Checkbox("Sorted", false, localCheckboxGroup);
    localPanel3.add(this.sort);
    this.sort.addItemListener(this);
    
    Panel localPanel4 = new Panel();
    localPanel1.add(localPanel4);
    localPanel4.setLayout(new FlowLayout(2));
    localPanel4.add(new Label("Enter number: "));
    localPanel4.add(this.tf);
    this.thePersonGroup = new personGroup();
    this.thePersonGroup.doFill(13);
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
    if (paramActionEvent.getSource() == this.newButton) {
      this.thePersonGroup.newList(this.isNumber, this.GPNumber);
    } else if (paramActionEvent.getSource() == this.insButton) {
      this.thePersonGroup.insert(this.isNumber, this.GPNumber);
    } else if (paramActionEvent.getSource() == this.findButton) {
      this.thePersonGroup.find(this.isNumber, this.GPNumber);
    } else if (paramActionEvent.getSource() == this.delButton) {
      this.thePersonGroup.delete(this.isNumber, this.GPNumber);
    }
    repaint();
    try
    {
      Thread.sleep(10L); return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public void itemStateChanged(ItemEvent paramItemEvent)
  {
    boolean bool1 = paramItemEvent.getSource() == this.nosort;
    boolean bool2 = this.thePersonGroup.getSortStatus();
    boolean bool3 = this.thePersonGroup.getChangeStatus();
    this.thePersonGroup.setSortStatus(bool1);
    if (((bool1) && (bool3) && (!bool2)) || (
      (!bool1) && (!bool3) && (bool2)))
    {
      this.nosort.setState(true);
      this.sort.setState(false);
    }
    if (((!bool1) && (bool3) && (bool2)) || (
      (bool1) && (!bool3) && (!bool2)))
    {
      this.nosort.setState(false);
      this.sort.setState(true);
    }
  }
  
  public void run()
  {
    label3:
    break label3;
  }
}
