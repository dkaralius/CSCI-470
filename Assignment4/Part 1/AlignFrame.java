/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 4, Part 1  Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Tuesday, 03/19/2019            *
 *                                                          *
 *  AlignFrame                                              *
 *                                                          *
 ************************************************************/ 
/**
 * AlignFrame is a simple GUI for an application that aligns coordinates.
 * This application offers no functionality other than simple event handling that 
 * tells the user which button they have pressed, the values for X and Y, or if the
 * check boxes are checked or unchecked.
 */
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class AlignFrame extends JFrame
{
   private JButton okButton, cancelButton, helpButton; //Buttons(Ok, Cancel, Help)
   private JCheckBox snapCheckBox, showCheckBox;       //Checkboxes(Snap to Grid, Show Grid)
   private JPanel checkPanel, buttonPanel,             //Panels needed for formatting
     fieldPanelX, fieldPanelY,fieldPanel;
   private JTextField X, Y;                            //Textfields for X and Y
   private JLabel labelX, labelY;                      //Lables for X and Y
   
   public AlignFrame()
   {
      super("Align");      //Title on top of the application
      
      //Build panel for the checkboxes
      snapCheckBox = new JCheckBox("Snap to Grid");
      showCheckBox = new JCheckBox("Show Grid");
      
      checkPanel = new JPanel();
      checkPanel.setLayout(new GridLayout(2,1));
      checkPanel.add(snapCheckBox);
      checkPanel.add(showCheckBox);
      
      //Build panel for label X
      labelX = new JLabel("X: ");
      X = new JTextField("8",3);
      fieldPanelX = new JPanel();
      fieldPanelX.setLayout(new FlowLayout());
      fieldPanelX.add(labelX);
      fieldPanelX.add(X);
      
      //Build panel for label Y
      labelY = new JLabel("Y: ");
      Y = new JTextField("8",3);
      fieldPanelY = new JPanel();
      fieldPanelY.setLayout(new FlowLayout());
      fieldPanelY.add(labelY);
      fieldPanelY.add(Y);
      
      //Build panel to format X and Y
      fieldPanel = new JPanel();
      fieldPanel.setLayout(new BorderLayout());
      fieldPanel.add(fieldPanelX, BorderLayout.NORTH);
      fieldPanel.add(fieldPanelY, BorderLayout.SOUTH);
      
      //Build panel for buttons okButton, cancelButton, helpButton;
      okButton = new JButton("Ok");
      cancelButton = new JButton("Cancel");
      helpButton = new JButton("Help");
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(3,1,10,5));
      buttonPanel.add(okButton);
      buttonPanel.add(cancelButton);
      buttonPanel.add(helpButton);
      
      //Creates container and adds the two components to it
      Container box = getContentPane();
      box.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
      box.add(checkPanel);
      box.add(fieldPanel);
      box.add(buttonPanel);
      
      //Register event handlers for buttons
      ButtonHandler buttonHandler = new ButtonHandler();
      okButton.addActionListener(buttonHandler);
      cancelButton.addActionListener(buttonHandler);
      helpButton.addActionListener(buttonHandler);
      
      //Register event handlers for buttons
      CheckBoxHandler checkBoxHandler = new CheckBoxHandler();
      snapCheckBox.addItemListener(checkBoxHandler);
      showCheckBox.addItemListener(checkBoxHandler);
      
      //Register event handlers for textfields
      TextFieldHandler textFieldHandler = new TextFieldHandler();
      X.addActionListener(textFieldHandler);
      Y.addActionListener(textFieldHandler);
   }
/**
 * 
 * Event handling classes for buttons, checkbox, and text fields.
 * 
 */   
      //Inner class for button event handling
      private class ButtonHandler implements ActionListener 
      {
         //Handle button event
         @Override
         public void actionPerformed(ActionEvent event)
         {
            JOptionPane.showMessageDialog(AlignFrame.this, String.format(
            "You pressed: %s", event.getActionCommand()), "Buttons", JOptionPane.PLAIN_MESSAGE);
         }
      } 
      //Inner class for checkbox event handling
      private class CheckBoxHandler implements ItemListener 
      {
         //Handle checkbox event
         @Override
         public void itemStateChanged(ItemEvent event)
         {
            if (snapCheckBox.isSelected())
            {
               JOptionPane.showMessageDialog(AlignFrame.this, "'Snap to Grid' checkbox is checked.", 
                                             "Checkboxes", JOptionPane.PLAIN_MESSAGE);
            }
            else if (showCheckBox.isSelected())
            {
               JOptionPane.showMessageDialog(AlignFrame.this, "'Show grid' checkbox is checked.", 
                                             "Checkboxes", JOptionPane.PLAIN_MESSAGE);
            }
         }
      } 
      //Inner class for textfield event handling
      private class TextFieldHandler implements ActionListener 
      {
         //Handle checkbox event
         @Override
         public void actionPerformed(ActionEvent event)
         {
            String string = "";
            //User presses enter in X text field
            if(event.getSource() == X)
            {
               string = String.format("X: %s",
               event.getActionCommand());
            }
            //User presses enter in Y text field
            else if(event.getSource() == X)
            {
               string = String.format("Y: %s",
               event.getActionCommand());
            }
            //Prints message telling user what value is entered
            JOptionPane.showMessageDialog(AlignFrame.this, string, 
                                             "Text fields", JOptionPane.PLAIN_MESSAGE);
         }
      }
}
   
   