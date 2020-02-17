/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 2          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Wednesday, 02/20/2019          *
 *                                                          *
 *  MileRedemptionApp class                                 *
 *                                                          *
 ************************************************************/ 
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.*;
/**
 * The MilesRedeemerApp Class is the main app of the program. It utilizes the other
 * two classes to read an input file that is prompted by the user. If the file exists,
 * asks the user how many miles they have earned and how long they plan to take a trip for.
 * Using this information, various cities are returned aswell as which class they are able to fly
 * in. It then prompts the user if they wish to continue or not.
 */
public class MileRedemptionApp
{
   public static void main(String[] args)throws IOException
   {   
       //Prompts user to enter name of input file.
       String answer;
       System.out.println("Please enter the name of the file:  ");
       Scanner inputFile = null;

       Scanner input = new Scanner(System.in);
       String fileName = input.nextLine();
       
       File file = new File(fileName);
       inputFile = new Scanner(file);
       
       //Goes to the MileRedeemer class with the input file as arguement.
       MilesRedeemer service = new MilesRedeemer();
       service.readDestinations(inputFile);
       
       //Prints out some headers so user can understand whats going on.
       System.out.println("-------------------------------------------------------------------------");  
       System.out.println("WELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
       System.out.println("-------------------------------------------------------------------------");
       System.out.println("");
       System.out.println("List of destination cities your client can travel to:");
       System.out.println("");
       
       //Prints out all the cities that client is able to travel to
       String[] cities = service.getCityNames();
       for(int i = 0; i < cities.length; i++)
       {
          System.out.println(cities[i]); 
       }
       
       //Do loop that prompts user for various information, that will continue to loop
       //until user enters 'n' or 'N'.
       do
       {
          System.out.println("");
          System.out.println("-------------------------------------------------------------------------");
          System.out.println("Please enter your client's accumulated Frequent Flyer Miles:  ");
          int totalMiles = input.nextInt();
       
          System.out.println("");
          System.out.println("Please enter your client's month of departure (1-12):  ");
          int tripLength = input.nextInt();
          System.out.println("");
          System.out.println("Your client's Frequent Flyer Miles can be used to redeem the following tickets:");
          System.out.println("");
       
          ArrayList<String> desc = service.redeemMiles(totalMiles,tripLength);
         
          if(desc.size() == 0)
          {
             System.out.println("*** Your client has not accumulated enough Frequent Flyer Miles ***");
          }
          else
          {
             for(String line : desc)
             {
                System.out.println(line);
             }
          }
          
          System.out.println("");
          System.out.println("Your client's remaining Frequent Flyer Miles:  "+ service.getRemainingMiles());
          System.out.println("");
          System.out.println("-------------------------------------------------------------------------");
          System.out.println("Do you want to continue (y/n)?"); 
          answer = input.next();
          
          //Error checking to make sure user enters Y/y or N/n. 
          //All other input else loops with an error message.
          if((answer.equals("y") || answer.equals("Y") || answer.equals("n") || answer.equals("N")))
          {
             continue;
          }
          else
          {
             do
             {
             System.out.println("Invalid entry!");
             System.out.println("");
             System.out.println("Do you want to continue (y/n)?");
             answer = input.next();
             }while(!answer.equals("y") && !answer.equals("Y") && !answer.equals("n") && !answer.equals("N"));
          }
      }while(answer.equals("y") || answer.equals("Y"));
       
       //Prints out final header, thanking user for using the application.
       System.out.println("-------------------------------------------------------------------------");  
       System.out.println("THANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
       System.out.println("-------------------------------------------------------------------------");
   }
}