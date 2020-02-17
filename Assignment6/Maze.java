/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 6          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Friday, 04/12/2019             *
 *                                                          *
 *  Maze                                                    *
 *                                                          *
 ************************************************************/ 
/**
 * Maze is a class that gives us the maximum dimensions of the maze.
 * The maze class also contains the number of rows and columns in the maze
 * and also creates 2D arrays of MazeSquare objects. The maze class reads
 * an input file specified by the user and then attempts to create a MazeSquare
 * object depending on the row,column, and type of character, and then draws the Maze.
 * This class also contains both the recursive and nonrecursive solveMaze() methods.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze
{
   //Constants that store the max number of rows and columns of the maze
   static public final int MAX_ROWS = 30;
   static public final int MAX_COLUMNS = 30; 
   
   //Variables that store the row and column of the start and end of maze
   private int sRow;
   private int sCol;
   private int eRow;
   private int eCol;
   
   //Number of columns and rows in the maze
   private int numCols;
   private int numRows;
   
   //2D array will hold all squares of maze
   private MazeSquare[][] square;
   
   public int getCols()
   {
      return  numCols;
   }
   
   public int getRows()
   {
      return numRows;
   }
   
   public void readMaze(File inputFile)
   {
     try
     {
        //Open file
        Scanner scan = new Scanner(inputFile);
        //Read numbers for dimensions of maze
        numRows = scan.nextInt();
        numCols = scan.nextInt();
        
        System.out.println("Number of rows = " + numRows);
        System.out.println("Number of columns = " + numCols);
        
        //Create new 2D array of MazeSquare objects
        square = new MazeSquare[numCols][numRows];
        
        int type = 0;
        
        //Read the maze
        for(int row = 0; row < numRows; row++)
        {
           String line = scan.next();
           char character;
           
           for(int column = 0; column < numCols; column++)
           {
               
               character = line.charAt((column));
               //This line prints out in console what the scanner is reading.
               //Used for error checking.
               System.out.println("Next character = " + line.charAt(column));
               
               if(character == '#')
               {
                  type = 0; 
                  //Create a new MazeSquare object for this row and column
                  square[row][column] = new MazeSquare(row, column, type);
                  MazeSquare.SquareType.WALL;
               }
               else if(character == '.')
               {
                  type = 1;
                  //Create a new MazeSquare object for this row and column
                  square[row][column] = new MazeSquare(row, column, type);
               }
               else if(character == 's')
               {
                  type = 1;
                  sRow = row;
                  sCol = column;
                  //Create a new MazeSquare object for this row and column
                  square[row][column] = new MazeSquare(row, column, type);
               }
               else if(character == 'e')
               {
                  type = 1;
                  eRow = row;
                  eCol = column;
                  //Create a new MazeSquare object for this row and column
                  square[row][column] = new MazeSquare(row, column, type);
               } 
           }
        }
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
   //It should call clearSquare() for every MazeSquare in the maze array.
   public void clearMazePath()
   {
      for(int row = 0; row < numRows; row++)
        {
           for(int column = 0; column < numCols; column++)
           {
              square[row][column].clearSquare();
           }
        }
   }
   
   public void drawMaze(Graphics g, int startX, int startY) 
   {
      for(int row = 0; row < numRows; row++)
        {
           for(int column = 0; column < numCols; column++)
           {
              square[row][column].drawSquare(g, startX, startY);
           }
        }
   }
   
   public boolean solveMaze()
   {
      return solveMaze(sRow, sCol);
   }
   
   private boolean solveMaze(int row, int column) 
   {
       //If we’ve reached the end of the maze, we have solved it. 
       if((row == eRow) && (column == eCol))
       {
           square[row][column].setToPath();
           return true;
       }
       
       //If we hit a wall or we've already visited this square, this square is
       //not part of a valid path to the end of the maze.
       if((square[row][column].isWall() == true) || (square[row][column].getVisited() == true))
       {
          square[row][column].markVisited();
          return false;
       }
       
       //If we're not on the top edge of the maze, try to go north.
       if(row != sRow)
       {
           if(solveMaze((row-1),column))
           {
              square[row][column].setToPath();
              return true;   
           }
       }
       
       //If we're not on the bottom edge of the maze, try to go south.
       if(row != eRow)
       {
           if(solveMaze((row+1),column))
           {
              square[row][column].setToPath();
              return true;   
           }
       }
       
       //If we're not on the left edge of the maze, try to go west.
       if(column != sCol)
       {
           if(solveMaze(row,(column-1)))
           {
              square[row][column].setToPath();
              return true;   
           }
       }
       
       //If we're not on the right edge of the maze, try to go east.
       if(column != eCol)
       {
           if(solveMaze(row,(column+1)))
           {
              square[row][column].setToPath();
              return true;   
           }
       }

       // If we haven't returned true by this point, no valid path through the 
       // maze has been found.
           return false;   
   }
   
}