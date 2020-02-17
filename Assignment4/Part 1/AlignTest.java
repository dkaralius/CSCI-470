/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 4, Part 1  Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Tuesday, 03/19/2019            *
 *                                                          *
 *  AlignTest                                               *
 *                                                          *
 ************************************************************/ 
/**
 * AlignFrame is a simple GUI for an application that aligns coordinates.
 * This application offers no functionality other than simple event handling that 
 * tells the user which button they have pressed, the values for X and Y, or if the
 * check boxes are checked or unchecked.
 */
import javax.swing.JFrame;

public class AlignTest
{
   public static void main(String args[])
   {
      AlignFrame align = new AlignFrame();
      align.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      align.setSize(300,140);
      align.setVisible(true);
   }
}