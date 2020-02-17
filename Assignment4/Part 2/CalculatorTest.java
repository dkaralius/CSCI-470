/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 4, Part 2  Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Tuesday, 03/19/2019            *
 *                                                          *
 *  CalculatorTest                                          *
 *                                                          *
 ************************************************************/ 
/**
 * CalculatorTest is a demo of a calculator that offers no functionality other
 * than event handling that tells the user which button they have pressed and if 
 * a value is entered in the textfield.
 */
import javax.swing.JFrame;

public class CalculatorTest
{
   public static void main(String args[])
   {
      CalculatorFrame calculator = new CalculatorFrame();
      calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      calculator.setSize(250,250);
      calculator.setVisible(true);
   }
}