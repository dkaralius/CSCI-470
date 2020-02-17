/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 6          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Friday, 04/12/2019             *
 *                                                          *
 *  MazePanel                                               *
 *                                                          *
 ************************************************************/ 
/**
 * MazePanel is a class that creates a new Maze object and 
 * attempts to read the maze and draw it onto the GUI. Also 
 * contains the logic for the clearMaze() and solveMaze()
 * methods.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MazePanel extends JPanel
{
   public Maze maze = null;
   
   private boolean solutionAttempted = false;
   private boolean solutionFound = false;
 
   
   public void readMaze(File inputFile)
   {
     try
     {
        //Open file
        Scanner scan = new Scanner(inputFile);
        
        solutionAttempted = false;
        solutionFound = false;
        
        //Create new Maze object
        maze = new Maze(); 
        
        maze.readMaze(inputFile);
        repaint();
        
        //Close file
        scan.close();
     }
     catch (IOException e) 
     {
        System.out.println("Cannot read maze: " + inputFile);
        System.exit(0);
     }     
   }
   
   //This method will be called to clear the maze solution. 
   //It should set solutionAttempted and solutionFound to false, 
   //call the clearMazePath() method for the Maze object data member, 
   //and then call repaint() to redraw the maze.
   public void clearMazePath()
   {
      solutionAttempted = false;
      solutionFound = false;
      
      maze.clearMazePath();
      repaint();
   }
   
   //This method will be called to try to solve a maze.
   //It should set solutionAttempted to true, set solutionFound to result of calling
   //the non-recursive solveMaze() method for the Maze object data member,
   //and then call repaint() to redraw the maze.
   public void solveMaze()
   {
      solutionAttempted = true;
      solutionFound = maze.solveMaze();
      repaint();
   }
   
   @Override
   protected void paintComponent(Graphics g)
   {
       //Call the superclass version of paintComponent() to draw the panel.
       super.paintComponent(g);
       
       //Get the dimensions of the panel.
       int panelHeight = getHeight();
       int panelWidth = getWidth();
       int numRows = maze.getRows();
       int numCols = maze.getCols();
       
       //Draw a filled rectangle in LIGHT_GRAY 
       //over the entire panel to erase whatever was previously drawn there.
       g.drawRect(0,0,panelWidth,panelHeight);
       g.setColor(Color.LIGHT_GRAY);
       g.fillRect(0,0,panelWidth,panelHeight);
       
       //If a Maze object exists (i.e., its object reference is not null), 
       //compute the x and y coordinates of its upper left corner so that the maze 
       //is centered in the panel. Then call the Maze object’s drawMaze() method to draw it.
       if(maze != null)
       {
           int squareSize = Math.min(panelHeight/numRows, panelWidth/numCols);
           int upperLeftX = (panelWidth - numCols*squareSize)/2;
           int upperLeftY = (panelHeight - numRows*squareSize)/2;
           maze.drawMaze(g,upperLeftX, upperLeftY);
       }
       
       if((solutionAttempted == true) && (solutionFound == true))
       {
           JOptionPane.showMessageDialog(null,"Solved!");
       }
       else if((solutionAttempted == true) && (solutionFound == false))
       {
           JOptionPane.showMessageDialog(null,"No solution exists for this maze.");
       }
       
   }
}