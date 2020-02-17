/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 3, Part 2  Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Wednesday, 03/06/2019          *
 *                                                          *
 *  Date Class                                              *
 *                                                          *
 ************************************************************/ 
/**
 * The Date class has three private 
 */

public class Date
{
   //Variable declarations
   private int Day;
   private int Month;
   private int Year;
   private int Result;
   
   //Constructor
   public Date(int Day, int Month, int Year)
   {
      this.Day = Day;
      this.Month = Month;
      this.Year = Year;
   }
   
   //methods
   public int getDay()
   {
      return Day; 
   }
   public int getMonth()
   {
      return Month; 
   }
   public int getYear()
   {
      return Year; 
   }
   
   //Method that is used to calculate the number of days since January 1st of a certain year.
   //First checks to see if the year entered by the user is a leap year or not.
   //General logic of method is to take all the months prior to month entered, and add up
   //all the days in those months and then add the day entered. 
   public int daysSinceJan1()
   {  
      //If the year entered is a leap year, February has 29 days.
      if(((this.Year % 4 == 0) && (this.Year % 100!= 0)) || (this.Year % 400 == 0))
      {
         //January
         if(this.Month == 1)
         {
            Result = (this.Day - 1); 
         }
         //February (Days = 29)
         if(this.Month == 2)
         {
            Result = (this.Day + 31); 
         }   
         //March
         if(this.Month == 3)
         {
            Result = (this.Day + 31 + 29); 
         }  
         //April
         if(this.Month == 4)
         {
            Result = (this.Day + 31 + 29 + 31);
         }
         //May
         if(this.Month == 5)
         {
            Result = (this.Day + 31 + 29 + 31 + 30); 
         }      
         //June
         if(this.Month == 6)
         {
            Result = (this.Day + 31 + 29 + 31 + 30 + 31); 
         }           
         //July
         if(this.Month == 7)
         {
            Result = (this.Day + 31 + 29 + 31 + 30 + 31 + 30);  
         }
         //August
         if(this.Month == 8)
         {
            Result = (this.Day + 31 + 29 + 31 + 30 + 31 + 30 + 31); 
         }   
         //September
         if(this.Month == 9)
         {
            Result = (this.Day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31); 
         }
         //October
         if(this.Month == 10)
         {
            Result = (this.Day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30);
         } 
         //November
         if(this.Month == 11)
         {
            Result = (this.Day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31); 
         }
         //December
         if(this.Month == 12)
         {
            Result = (this.Day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30);  
         }        
      }
      //Else, the year entered is not a leap year.
      //So February only has 28 days.
      else
      {
         //January
         if(this.Month == 1)
         {
            Result = (this.Day - 1); 
         }
         //February (Days = 28)
         if(this.Month == 2)
         {
            Result = (this.Day + 31); 
         }   
         //March
         if(this.Month == 3)
         {
            Result = (this.Day + 31 + 28); 
         }  
         //April
         if(this.Month == 4)
         {
            Result = (this.Day + 31 + 28 + 31);
         }
         //May
         if(this.Month == 5)
         {
            Result = (this.Day + 31 + 28 + 31 + 30); 
         }      
         //June
         if(this.Month == 6)
         {
            Result = (this.Day + 31 + 28 + 31 + 30 + 31);
         }           
         //July
         if(this.Month == 7)
         {
            Result = (this.Day + 31 + 28 + 31 + 30 + 31 + 30);
         }
         //August
         if(this.Month == 8)
         {
            Result = (this.Day + 31 + 28 + 31 + 30 + 31 + 30 + 31); 
         }   
         //September
         if(this.Month == 9)
         {
            Result = (this.Day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31); 
         }
         //October
         if(this.Month == 10)
         {
            Result = (this.Day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30);
         } 
         //November
         if(this.Month == 11)
         {
            Result = (this.Day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31);
         }
         //December
         if(this.Month == 12)
         {
            Result = (this.Day + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30);
         }        
      }
         //Return the result
         return Result;
   }
}