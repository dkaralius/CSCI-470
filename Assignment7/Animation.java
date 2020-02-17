/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 7          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Monday, 04/22/2019             *
 *                                                          *
 *  Animation                                               *
 *                                                          *
 ************************************************************/ 
/**
 * Animation is a class that contains information of the animation.
 * Includes private data members, default constructors, and
 * accessor methods. Is used to create animation objects that will
 * later be put into a vector.
*/
public class Animation
{
    //Data members that hold information of the animation
    private String animationName;
    private int width;
    private int height;
    private int frames;
    private int delay;
     
    //Default constructor
    public Animation(String animationName, int width, int height, int frames, int delay)
    {
       this.animationName = animationName;
       this.width = width;
       this.height = height;
       this.frames = frames;
       this.delay = delay;
    }
    //Get methods for data members
    public String getAnimationName()
    {
        return animationName;
    }
    
    public int getWidth()
    {
       return width; 
    }
    
    public int getHeight()
    {
       return height; 
    }
    
    public int getFrames()
    {
       return frames; 
    }
    
    public int getDelay()
    {
       return delay; 
    }
    
    @Override
    public String toString()
    {
       return animationName; 
    }
}