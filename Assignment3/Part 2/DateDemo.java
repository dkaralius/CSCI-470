/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 3, Part 2  Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Wednesday, 03/06/2019          *
 *                                                          *
 *  DateDemo Class                                          *
 *                                                          *
 ************************************************************/ 
/**
 * The DateDemo Class is used to test the Date class in a simple prompt to the user.
 * Asking for the day, month, and year. Using this information, it creates a new Date
 * object and then uses the daysSinceJan1() method, to find out how many days have elapsed
 * since January 1st of that year. There is no validation or loop, as it was not needed.
 */
import java.util.Scanner;

public class DateDemo
{
   public static void main( String[] args )
   {
      //Header
      System.out.println("*** Date Class Demo ***");
      System.out.println();
      
      //Variables and Scanner declared
      Scanner input = new Scanner(System.in);
      int Day;
      int Month;
      int Year;
      
      //Prompt user for information.
      //No validation, as it was not needed.
      System.out.println("Please enter a day:");
      Day = input.nextInt();
      System.out.println("Please enter a month(1-12):");
      Month = input.nextInt();
      System.out.println("Please enter a year:");
      Year = input.nextInt();
      
      //Create a new Date object with user's information
      Date date = new Date(Day,Month,Year);
      
      //Show the user the date they had entered, in Month/Day/Year format.
      //Then calculate and print out the number of days since January 1st of that year.
      System.out.println("You've entered " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + ".");
      System.out.println("Calculating days since January 1st, " + date.getYear() + "...");
      System.out.println();
      System.out.println("Days since January 1st, " + date.getYear() + ": " + date.daysSinceJan1() + " days.");
   }
}