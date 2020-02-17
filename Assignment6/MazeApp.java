/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 6          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Friday, 04/12/2019             *
 *                                                          *
 *  MazeApp                                                 *
 *                                                          *
 ************************************************************/ 
/**
 * MazeApp is a the main driver class for the program. Contains
 * the UI interface and event handling for the buttons.
 * 
 * Could not figure out why the program does not draw the maze onto
 * the application window. 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MazeApp extends JFrame implements ActionListener
{
   public MazePanel MazePanel;
   
   private JButton open;
   private JButton solve;
   private JButton clear;
   
   JFileChooser chooser = new JFileChooser(".");
   
   JFrame frame =  new JFrame("Maze Application");
   
  //Creates an instance of MazeApp and then uses it to 
  //call method(s) to set up the user interface elements  
  public static void main(String[] args)
  {
     EventQueue.invokeLater(() ->
                            {
       MazeApp frame = new MazeApp("Maze Application");
       frame.createAndShowGUI();
     });
  }
  
  //Constructor that sets the title on the application’s title bar
  private MazeApp(String title)
  {
     super(title); //Title on the application window
     MazePanel = new MazePanel();
  }
  
  private void createAndShowGUI()
  {
     initComponents();
     frame.add(MazePanel);
     
     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     frame.setSize(600, 500);
     frame.setLayout(null);
     frame.setLocationRelativeTo(null); // Center the frame
     frame.setVisible(true);
     
     
     open.addActionListener(this);
     solve.addActionListener(this);
     clear.addActionListener(this);
  }
  
  private void initComponents()
  {
     //Initialize the buttons for user to calculate or clear and set their bounds
     open = new JButton("Open Maze File");
     solve = new JButton("Solve Maze"); 
     clear = new JButton("Clear Solution"); 
     
     open.setBounds(20,430,140,20);
     solve.setBounds(210,430,140,20);
     clear.setBounds(400,430,140,20);
     
     solve.setEnabled(false);
     clear.setEnabled(false);
     
     
     frame.add(open);
     frame.add(solve);
     frame.add(clear);
  }
  
  //Event handling for buttons
  @Override
  public void actionPerformed(ActionEvent event)
  {
     if(event.getSource() == open)
     {
        int result = chooser.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
           File selectedFile = chooser.getSelectedFile();
           MazePanel.readMaze(selectedFile);
           solve.setEnabled(true);
           clear.setEnabled(false);
        }    
     }
     
     else if(event.getSource() == solve)
     {
        MazePanel.solveMaze();
        solve.setEnabled(false);
        clear.setEnabled(true);
     }
  
     else if(event.getSource() == clear)
     {
        MazePanel.clearMazePath();
        solve.setEnabled(true);
        clear.setEnabled(false);
     }
  }
  
}