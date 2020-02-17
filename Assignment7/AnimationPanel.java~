/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 7          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Monday, 04/22/2019             *
 *                                                          *
 *  AnimationPanel                                          *
 *                                                          *
 ************************************************************/ 
/**
 * AnimationPanel contains the bulk of the logic of the application.
 * Contains the methods that load, start, resume, pause, and stop
 * the animation.
*/
import java.awt.Image;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JPanel;


class AnimationPanel extends JPanel implements Runnable
{
   //Reference to a Thread object. 
   //This will be used to run the animation in a background thread.
   private volatile Thread animator = null;
   
   //A boolean variable that indicates whether or not 
   //the animation thread has been paused. Initialize this to false.
   private boolean paused = false;
   
   //Two integer variables for specifying the x and y coordinates at which to draw the top 
   //left corner of an animation frame image so that it will be centered in the animation panel.
   private int x;
   private int y;
   
   //An integer variable to store the delay between animation frames.
   private int delay;
   
   //An integer array index that specifies the current animation frame. Initialize this to 0.
   private int index = 0;
   
   //An object reference to an array of Image objects. 
   //This array will be used to store the image frames of an animation.
   private Image[] imageArray;
   
   //An object reference to a MediaTracker object that will be used to monitor the load progress 
   //of the animation image frames. 
   private MediaTracker tracker;
   
   //Create a new array of Image objects with a number of elements equal to the number of frames 
   //in the animation. Save the delay to be used in run().
   //Save the x and y coordinates so panel is displayed nicely.
   //Format the string, so starts reading from 000.
   public void loadAnimation(Animation a)
   {
      imageArray = new Image[a.getFrames()];
      x = ((this.getWidth() - a.getWidth()) / 2);
      y = ((this.getHeight() - a.getHeight()) / 2);
      delay = a.getDelay();
      
      //Make the string be "000", since images start at "000"
      int frame = 0;
      String format = String.format("%03d",frame);
      
      tracker = new MediaTracker(this);
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      
      for(int i = 0; i < imageArray.length; i++)
      {
         //Construct string that will hold image name
         String test = "Animations/" + a.getAnimationName() + "/frame" + format + ".gif";
       
         //Replace spaces(if there are any) in animation name with "_"
         test = test.replaceAll(" ","_");
         
         imageArray[i] = toolkit.getImage(test);
         tracker.addImage(imageArray[i],1);
         
         frame += 1;
         format = String.format("%03d",frame);
      }
      repaint();
   }
   
   //Sets the current frame index to 0
   //Sets the “thread paused” Boolean variable to false
   //Creates a new Thread object from the Runnable object 'this'
   //And then call the start() method for the Thread to make it runnable
   public void startAnimation()
   {
      index = 0;
      paused = false;
      animator = new Thread(this);
      animator.start();
   }
   
   //Set the “thread paused” Boolean variable to true
   synchronized void pauseAnimation()
   {
      paused = true; 
   }
   
   //Set the “thread paused” Boolean variable to false and 
   //then calls notify() to tell the waiting animation thread to stop waiting.
   synchronized void resumeAnimation()
   {
       paused = false;
       notify();
   }
   
   //Sets the Thread reference for the animation to null 
   //calls notify() and then set the current frame index back to 0.
   synchronized void stopAnimation()
   {
       animator = null;
       notify();
       index = 0;
   }
   
   //Average paintComponent method. Calls superclass.
   //Checks to see if the imageArray is not null,
   //If it is, draws the image at current index.
   @Override
   protected void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      if(imageArray != null)
      {
         g.drawImage(imageArray[index],x,y,this);
      }
   }
   
   @Override
   public void run()
   {
      try
      {
         tracker.waitForID(1); 
      }
      catch (InterruptedException e)
      {
         return;
      }
      
      Thread thisThread = Thread.currentThread();
      
      while(animator == thisThread)
      {
         try
         {
            Thread.sleep(delay);
            
            synchronized(this) 
            {
               while (paused && animator == thisThread)
               wait();
            }
         }
         catch (InterruptedException e) 
         {
         }
         
         repaint();
         
         if(index == imageArray.length-1)
         {
            index = 0; 
         }
         else
         {
            index++;
         }
      }   
   }
}