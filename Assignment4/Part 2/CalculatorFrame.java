/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 4, Part 2  Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Tuesday, 03/19/2019            *
 *                                                          *
 *  CalculatorFrame                                         *
 *                                                          *
 ************************************************************/ 
/**
 * CalculatorFrame is a simple GUI for a calculator that offers no functionality
 * other than simple event handling that tells the user which button they have pressed
 * and if a value is entered in the text field.
 */
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class CalculatorFrame extends JFrame
{
   private JButton button[];                          //buttons for the calculator
   private JPanel pad;                                //to be used for layout of buttons
   private JTextField screen;                         //screen that would show input
   
   public CalculatorFrame()
   {
      super("Calculator");                            //Title on top of the application
      
      //Initialize components
      screen = new JTextField(15);                    //Create new textfield with length 15
      screen.setEditable(true);                       //Textfield CAN be edited
      screen.setPreferredSize(new Dimension(200,28)); //Change size of textfield
      button = new JButton[16];                       //Create 16 new buttons
      pad = new JPanel();                             //Create new panel
      pad.setLayout(new GridLayout(4,4,5,5));         //Set the layout GridLayout and to 4 x 4
      pad.setBorder(new EmptyBorder(5,5,5,5));        //Padding on the border by 5 pixels
      
      //Buttons 0 - 9 are numbers 0 - 9
      for(int i = 0; i <= 9; i++)
      {
         button[i] = new JButton(String.valueOf(i));
      }
      
      //Buttons 10 - 15 are operations and decimal point
      button[10] = new JButton("/");
      button[11] = new JButton("*");
      button[12] = new JButton("-");
      button[13] = new JButton(".");
      button[14] = new JButton("=");
      button[15] = new JButton("+");
      
      //Add first row on calculator. (7,8,9,/)
      for(int i = 7; i <= 10; i++)
      {
         pad.add(button[i]);
      }
      
      //Add second row on calculator. (4,5,6,*)
      for(int i = 4; i <= 6; i++)
      {
         pad.add(button[i]);
      }
      pad.add(button[11]);
      
      //Add third row on calculator. (1,2,3,-)
      for(int i = 1; i <= 3; i++)
      {
         pad.add(button[i]);
      }
      pad.add(button[12]);
      
      //Add final row on calculator. (0,.,=,+)
      pad.add(button[0]);
      for(int i = 13; i <= 15; i++)
      {
         pad.add(button[i]);
      }
      
      //Creates container and adds the two components to it
      Container box = getContentPane();
      box.add(screen,BorderLayout.NORTH);
      box.add(pad,BorderLayout.CENTER);
      
      //Register event handlers. Uses 'for' loop, so each button gets registered
      ButtonHandler handler = new ButtonHandler();
      for(int i = 0; i <= 15; i++)
      {
         button[i].addActionListener(handler);
      }
      
      //Register event handlers for textfields
      TextFieldHandler textFieldHandler = new TextFieldHandler();
      screen.addActionListener(textFieldHandler);
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
            JOptionPane.showMessageDialog(CalculatorFrame.this, String.format(
            "You pressed: %s", event.getActionCommand()), "Buttons", JOptionPane.PLAIN_MESSAGE);
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
            //User presses enter in screen text field
            if(event.getSource() == screen)
            {
               string = String.format("Screen: %s",
               event.getActionCommand());
            }
            //Prints message telling user what value is entered
            JOptionPane.showMessageDialog(CalculatorFrame.this, string, 
                                             "Text fields", JOptionPane.PLAIN_MESSAGE);
         }
      }
}