/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 2          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Wednesday, 02/20/2019          *
 *                                                          *
 *  MilesRedeemer Class                                     *
 *                                                          *
 ************************************************************/ 
//import java.util.Arrays; This would prevent me from compiling.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
/**
 * The MilesRedeemer Class parses the input file and stores the information into
 * Destination objects in an array. It then goes through to check where user is able
 * to fly with their miles and if they can fly first or economy class.
 */

public class MilesRedeemer
{
   List<Destination> destinationList;
   int remainingMiles;
   
   public MilesRedeemer()
   {
      this.destinationList = new ArrayList<Destination>(); 
   }
   
   //Parses the input file and separates information into tokens.
   //Creates new Destination object with the parsed information.
   //Closes the input file at end of method.
   public void readDestinations(Scanner fileScanner) throws IOException
   {
         while(fileScanner.hasNextLine())
         {
            String nextLine = fileScanner.nextLine();
            
            String[] tokens = nextLine.split(";");
            
            String name = tokens[0];
            int nMiles = Integer.parseInt(tokens[1]);
            int fMiles = Integer.parseInt(tokens[2]);
            int uMiles = Integer.parseInt(tokens[3]);
            
            String[] time = tokens[4].split("-");
            int firstMonth = Integer.parseInt(time[0]);
            int secondMonth = Integer.parseInt(time[1]);
            
            destinationList.add(new Destination(name, nMiles, fMiles, uMiles, firstMonth, secondMonth));
         }
         
         fileScanner.close();
   }
   
   //Returns all cities names.
   //Is supposed to sort them, however Arrays.sort() function prevented me from compiling.
   public String[] getCityNames()
   {
      String[] cityList = new String[this.destinationList.size()];
      for(int i = 0; i < this.destinationList.size(); i++)
      {
         cityList[i] = this.destinationList.get(i).getName();
      }
      //Arrays.sort(cityList); Would not let program compile.
      return cityList;
   }
   
   //Redemption algorithm.
   public ArrayList<String> redeemMiles(int remainingMiles, int month)
   {
      ArrayList<String> output = new ArrayList<String>();
      ArrayList<Destination> temp = new ArrayList<Destination>();
      
      for(int i = 0; i < this.destinationList.size(); i++)
      {
         Destination d = this.destinationList.get(i);
         int cost = d.getNormalMiles();
         
         if(month >= d.getStartMonth() && month <= d.getEndMonth())
         {
            cost = d.getFrequentFlyerMiles(); 
         }
         if(remainingMiles > cost)
         {
            remainingMiles -= cost;
            temp.add(d);
         }
      }
      for(int i = 0; i < temp.size(); i++)
      {
         if(remainingMiles > temp.get(i).getUpgradeMiles())
         {
            remainingMiles -= temp.get(i).getUpgradeMiles();
            System.out.println(remainingMiles);
            output.add("*A trip to " + temp.get(i).getName() + ", first class");
         }
         else
         {
            output.add("*A trip to " + temp.get(i).getName() + ", economy class");
         }
      }
      this.remainingMiles = remainingMiles;
      return output;
   }
   
   //Standard return method for the remainingMiles after Redemption algorithm.
   public int getRemainingMiles()
   {
      return remainingMiles;
   }
}
