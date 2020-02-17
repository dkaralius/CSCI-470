/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 6          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Friday, 04/12/2019             *
 *                                                          *
 *  MazeSquare                                              *
 *                                                          *
 ************************************************************/ 
/**
 * MazeSquare is a class that handles the creation of each
 * square that will create a maze. It specifies a number that
 * is assigned to a type of square; wall,space, or path. It also
 * specifies the dimensions of each square. Has various methods
 * that check to see what kind of square it is, and then return
 * a boolean value. Finally, it is supposed to draw the maze square,
 * depending on what kind of square it is.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MazeSquare
{
  
  public enum SquareType {WALL, SPACE, PATH}
  
  //Constants to represent types of squares
  static public final int WALL = 0;
  static public final int SPACE = 1;
  static public final int PATH = 2;
  
  //Constants that store the dimensions(Length and Width) of a maze square
  static public final int L = 15;
  static public final int W = 15;
  
  //Variables that store row,column, and type of square in maze
  //Also if it has been visited or not
  private int row;
  private int column;
  private int type;
  private boolean visited = false;
  
  //Constructor to initialize variables
  public MazeSquare(int row, int column, int type)
  {
      this.row = row;
      this.column = column;
      this.type = type;
  }
  
  //Called when "Clear solution" is pressed
  //Sets 'visited' to false and if type is PATH, gets changed to SPACE
  public void clearSquare()
  {
     visited = false;
     if(type == 2)
     {
        type = 1; 
     }
  }
  
  //Called by the solution algorithm
  //Sets the 'visited' data member to true
  public void markVisited()
  {
     visited = true;
  }
  
  //Called by the solution algorithm
  //Returns the 'visited' data member
  public boolean getVisited()
  {
     return visited;
  }
  
  //Called by the solution algorithm
  //Returns true if type is wall, else returns false
  public boolean isWall()
  {
      if(type == 0)
      {
         return true; 
      }
      else
      {
         return false; 
      }
  }
  
  //Called by the solution algorithm
  //Set the square's type to PATH, 2
  public void setToPath()
  {
     type = 2; 
  }
  
  //Called for each square as part of drawing the maze.
  //Sets the current drawing color based on the square’s type
  public void drawSquare(Graphics g, int startX, int startY)
  {
     if(type == 0)
     {
        g.setColor(Color.GRAY);
        g.fillRect(startX,startY,W,L);
        g.setColor(Color.BLACK);
        g.drawRect(startX,startY,W,L);
     }
     else if(type == 1)
     {
        g.setColor(Color.WHITE);
        g.fillRect(startX,startY,W,L);
        g.setColor(Color.BLACK);
        g.drawRect(startX,startY,W,L);
        
     }
     else if(type == 2)
     {
        g.setColor(Color.RED);
        g.fillRect(startX,startY,W,L);
        g.setColor(Color.BLACK);
        g.drawRect(startX,startY,W,L);   
     }  
  } 
}