/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 5          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Momday, 04/01/2019             *
 *                                                          *
 *  TipApp                                                  *
 *                                                          *
 ************************************************************/ 
/**
 * TipApp is an application that calculates the tip amount, depending on the
 * percentage the user determines using a slider. The user may also change their
 * party size using a spinner. There is error handling on the user's input.
 * 
 * Could not figure out how to implement both ActionListener and 
 * ChangeListener to a single class. So there is no overridden 
 * stateChanged() method.
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TipApp extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  
  private JButton calculate;     //Button used to calculate tip amount
  private JButton clear;         //Button used to clear and reset UI
  private JTextField input;      //Text box for user to enter bill amount
  private JSlider slider;        //Slider to change tip percentage
  private JSpinner spinner;      //Spinner to change party size
  private JLabel billAmount;     //Label to read Bill Amount
  private JLabel tipPercentage;  //Label to read Tip Percentage
  private JLabel partySize;      //Label to read Party Size
  private JLabel total;          //Label to read total bill
  private JLabel totalAmount;    //Label to read total bill amount
  private JLabel indShare;       //Label to read individual share
  private JLabel shareAmount;    //Label to read individual share amount
  
  private TipCalculator TipCalculator;
  
  public static void main(String[] args)
  {
     EventQueue.invokeLater(() ->
                            {
       TipApp frame = new TipApp("Tip Calculator");
       frame.createAndShowGUI();
     });
  }
  
  private TipApp(String title)
  {
     super(title); //Title on the application window
     TipCalculator = new TipCalculator();
  }
  
  private void createAndShowGUI()
  {
     initComponents();
     
     calculate.addActionListener(this);
     clear.addActionListener(this);
     
     setSize(300, 250);
     setLayout(null);
     setLocationRelativeTo(null); // Center the frame
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     setVisible(true);
  }
  
  private void initComponents()
  {
     //Initialize the labels and set their bounds
     billAmount = new JLabel("Bill Amount");
     billAmount.setBounds(20,5,200,20);
     tipPercentage = new JLabel("Tip Percentage");
     tipPercentage.setBounds(20,30,200,20);
     partySize = new JLabel("Party Size");
     partySize.setBounds(20,75,200,20);
     total = new JLabel("Total Bill(with Tip)");
     total.setBounds(20,140,200,20);
     totalAmount = new JLabel("$0.00");
     totalAmount.setBounds(240,140,200,20);
     indShare = new JLabel("Individual Share");
     indShare.setBounds(20,165,200,20);
     shareAmount = new JLabel("$0.00");
     shareAmount.setBounds(240,165,200,20);
       
     //Initialize text fields and set its bounds
     input = new JTextField(10);
     input.setBounds(125,5,150,20);
     
     //Initialize Slider and set its bounds
     slider = new JSlider(JSlider.HORIZONTAL,0,50,20); //Sets slider to be from 0-50, default value is 20
     slider.setMinorTickSpacing(5);
     slider.setMajorTickSpacing(10);
     slider.setPaintTicks(true);
     slider.setPaintLabels(true);
     slider.setLabelTable(slider.createStandardLabels(10));
     slider.setBounds(125,30,150,40);
     
     //Initialize spinner and set its bounds
     spinner = new JSpinner(new SpinnerNumberModel(1,1,50,1));
     spinner.setBounds(240,75,35,20);

     //Initialize the buttons for user to calculate or clear and set their bounds
     calculate = new JButton("Calculate");
     clear = new JButton("Clear");
     calculate.setBounds(40,110,90,20);
     clear.setBounds(150,110,90,20);
     
     //Add labels,buttons,textfields, and slider to layout
     add(billAmount);
     add(input);
     add(tipPercentage);
     add(slider);
     add(partySize);
     add(spinner);
     add(calculate);
     add(clear);
     add(total);
     add(totalAmount);
     add(indShare);
     add(shareAmount);
  }
  //Event handling for buttons
  @Override
  public void actionPerformed(ActionEvent event)
  {
  if(event.getSource() == clear)
  {
     input.setText(""); //Reset input field to blank
     totalAmount.setText("$0.00"); //Reset total amount back to $0.00
     shareAmount.setText("$0.00"); //Reset individual share back to $0.00
     slider.setValue(20); //Set the slider back to default value, 20
     spinner.setValue(1); //Set the spinner back to default value, 1
  }
  else
  {
     String billAmount = input.getText();
     if(billAmount.isEmpty())
     {
        JOptionPane.showMessageDialog(null, "Please enter a value.", "Error", JOptionPane.ERROR_MESSAGE);
     }
     else
     {
        double bill;
        double percent;
        double tipAmount;
        double totalBill;
        double share;
        int size = (Integer) spinner.getValue();
        
        try
        {
           bill = Double.parseDouble(billAmount);
           if(bill < 0)
           {
              JOptionPane.showMessageDialog(null, "Bill amount must be greater than 0.","Error", JOptionPane.ERROR_MESSAGE);
           }
           else
           {
              percent = slider.getValue();
              tipAmount = bill * (percent / 100);
              totalBill = bill + tipAmount;
              share = totalBill / size;
              
              totalAmount.setText(String.format("$" + "%.2f", totalBill));
              shareAmount.setText(String.format("$" + "%.2f", share));
           }
         }
         catch (NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null, "Bill amount must be numeric.","Error", JOptionPane.ERROR_MESSAGE);
         }
      }
   }
  }
} 