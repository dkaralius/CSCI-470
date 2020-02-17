/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 8          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Thursday, 05/02/2019           *
 *                                                          *
 *  SortAnimationPanel                                      *
 *                                                          *
 *  SortAnimationPanel is a class that is used to populate  *
 *  the array of random integers and also contains the      *
 *  overriden paintComponent method.                        *
 *                                                          *
 *  This class also initializes the threads and keeps track *
 *  of their status. Also assigns the number of milliseconds* 
 *  that the thread will sleep between printing the elemnts *
 *  of the array, determined by the user in a JComboBox.    *
 *                                                          *
 *  The user also chooses which sorting algorithm to be     *
 *  used, which each has a specific integer value.          *
 *                                                          *
 ************************************************************/ 
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class SortAnimationPanel extends JPanel implements Runnable
{
   public int intArray[];
   private int speedInt;
   private int condition;
   private Thread thread;

   public volatile boolean paused = false;
   
   /**************************************************************
   * Method used to create a random array of integers, that will *
   * later be sorted by certain sorting algorithms.              * 
   **************************************************************/
   public void populateArray()
   {  
      Random rand = new Random();
    
      intArray = new int[this.getWidth()];
    
      rand.setSeed(System.currentTimeMillis());
    
      for(int i = 0; i < this.getWidth(); i++)                       
      {
         intArray[i] = rand.nextInt(this.getHeight() -1) + 1;
      }
    
      this.repaint();
   }
   /**************************************************************
   * Overriden paintComponent method. Is used to draw rectangles *
   * for every element in the array and color them gray.         *
   **************************************************************/
   @Override
   protected void paintComponent(Graphics g) 
   {
      super.paintComponent(g);
       
      g.clearRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
      g.setColor(Color.WHITE);
      g.fillRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());

      this.repaint();   
       
      if(intArray == null) 
      {
         return;           
      }
      for(int i = 0;i < this.getWidth();i++)
      {
         g.setColor(Color.GRAY);
         g.drawLine(i,intArray[i],i,this.getHeight() );
      }
   }
   /**************************************************************
   * Initializes a thread for each panel. Sets the initial       *
   * condition to 0. Checks to see which algorithm was selected  *
   * and assigns a number to the condition, which will be used   *
   * later in the run() method. Starts the thread and sets       *
   * the thread state.                                           *
   **************************************************************/
   public void initializeThread(String algorithm)
   {
      condition = 0;
      thread = new Thread(this);

      if(algorithm.equals("Selection Sort"))
      {
         condition = 1;
      }
      else if(algorithm.equals("Insertion Sort"))
      {
         condition = 2;
      }
      else if(algorithm.equals("Bubble Sort"))
      {
         condition = 3;
      }
      else if(algorithm.equals("Shell Sort"))
      {
         condition = 4;
      }
      
      thread.start();
      this.setThreadState();
   }
   /**************************************************************
   * Method that checks to see if the thread is paused or is     *
   * running. If paused, will wait until notified to continue.   *
   **************************************************************/
   public void setThreadState()
   {
      synchronized(this)
      {
         try
         {
            while(paused)
            {
               wait();
            }
         } 
         catch(InterruptedException e)
         {
            System.out.println("Exception occured " + e);
         }
      }
        
   }
   /**************************************************************
   * Method that is used to determine the amount of milliseconds *
   * that the thread will sleep when hopping from element to     *
   * element of the array.                                       *
   * Slow = 100ms                                                *
   * Medium = 50ms                                               *
   * Fast = 10ms                                                 *
   **************************************************************/
   public void setSpeed(String speed)
   {
      if(speed.equals("Slow"))
      {
         speedInt = 100;
      }
      if(speed.equals("Medium"))
      {
         speedInt = 50;
      } 
      if(speed.equals("Fast"))
      {
         speedInt = 10;
      }        
   }
   /**************************************************************
   * Method that, when called, will set the boolean value of     *
   * "paused" to true. Indicating that the thread was paused.    *
   **************************************************************/ 
   synchronized void pause()
   {
      paused = true;
   }
   /**************************************************************
   * Method that, when called, will set the boolean value of     *
   * "paused" to false and notify() is called. Indicating that   *
   * the thread is to continue its task.                         *
   **************************************************************/
   synchronized void resume()
   {
      paused = false;
      notify();
   }
   /**************************************************************
   * Method that, when called, will interrupt the thread and     *
   * will set the boolean value of "paused" to false, set the    *
   * array of integers to null, and call the notify() method.    *
   **************************************************************/
   synchronized void stop()
   {
      thread.interrupt();
      paused = false;
      intArray = null;
      notify();
   }
   /**************************************************************
   * Main run() method. Switch statement that has different      *
   * cases with the condition determined earlier. With each      *
   * sorting algorithm being a case and having a designated      *
   * condition.                                                  *
   * 1 : Selection Sort                                          *
   * 2 : Insertion Sort                                          *
   * 3 : Bubble Sort                                             *
   * 4 : Shell Sort                                              *
   **************************************************************/
   public void run()
   {
         switch (condition)
         {
           case 1:
               selectionSort(intArray);
           case 2:
               insertionSort(intArray);
           case 3:
               bubbleSort(intArray);
           case 4:
               shellSort(intArray);
         }
   }
   /**************************************************************
   * Selection Sort algorithm.                                   *
   **************************************************************/
   public int[] selectionSort(int[] array)
   {
      try
      {
         for (int i = 0; i < array.length - 1; i++)
         {
            int index = i;
            for (int j = i + 1; j < array.length; j++)
            if (array[j] > array[index])
            {
               index = j;
            }
            int smallerNumber = array[index]; 
            array[index] = array[i];
            array[i] = smallerNumber;
            thread.sleep(speedInt);
            repaint();
            this.setThreadState();
         }
      }
      catch(Exception e)
         {
            System.out.println("Exception occured " + e);
         }
      
      return array;
   } 
   /**************************************************************
   * Insertion Sort Algorithm.                                   *
   **************************************************************/
   public void insertionSort(int[] array) 
   {
      int i, j, temp;
      try
      { 
         for (i = 1; i < array.length; i++) 
         {
            temp = array[i];
            j = i;
            while (j > 0 && array[j - 1] < temp) 
            {
               array[j] = array[j - 1];
               j--;
               repaint();
               this.setThreadState();
               thread.sleep(speedInt);
            }
            array[j] = temp;
            repaint();
         }
     }
     catch(Exception e)
     {
        System.out.println("Exception occured " + e); 
     }
   }
   /**************************************************************
   * Bubble Sort Algorithm.                                      *
   **************************************************************/
   public void bubbleSort(int[] array)
   {
      try
      {
      int n = array.length;
      int temp = 0;
         for(int i=0; i < n; i++)
         {
            thread.sleep(speedInt);
            this.setThreadState();
            for(int j = 1; j < (n-i); j++)
            {
               if(array[j-1] < array[j])
               {
                  temp = array[j-1];
                  array[j-1] = array[j];
                  array[j] = temp;
                  repaint();
               }
            }
         }
      }
      catch(Exception e)
      {
        System.out.println("Exception occured " + e);
      }
    }
   /**************************************************************
   * Shell Sort Algorithm.                                       *
   **************************************************************/
   public void shellSort(int[] array) 
   {
      try
      {
         int increment = array.length / 2;
         while (increment > 0) 
         {
            for (int i = increment; i < array.length; i++)
            {
               int j = i;
               int temp = array[i];
               try
               {
                  while (j >= increment && array[j - increment] < temp)
                  {
                     array[j] = array[j - increment];
                     thread.sleep(speedInt);
                     repaint();
                     this.setThreadState();
                     j = j - increment;
                  }
               }
               catch(Exception e)
               {
                  System.out.println("Exception occured " + e);
               }
                  array[j] = temp;
            }
            if (increment == 2) 
            {
               increment = 1;
            } 
            else 
            {
               increment *= (5.0 / 11);
            }
         }
      }
      catch(Exception e)
      {
         System.out.println("Exception occured " + e);
      }
   }
}