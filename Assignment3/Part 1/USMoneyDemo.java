/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 3, Part 1  Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Wednesday, 03/06/2019          *
 *                                                          *
 *  USMoneyDemo Class                                       *
 *                                                          *
 ************************************************************/ 
/**
 * The USMoneyDemo class is used as a demo for the USMoney class.
 * The Demo prompts the user to enter a dollar and cent amount two times.
 * The Demo then calls the plus() method, to create a 3rd USMoney object
 * with the sum of the other two USMoney objects.
 */
import java.util.Scanner;

public class USMoneyDemo
{
   public static void main( String[] args )
   {
      System.out.println("*** USMoney ***");
      System.out.println();
      
      Scanner input = new Scanner(System.in);
      int Dollars;
      int Cents;
      
      System.out.println("Please enter a dollar amount:");
      Dollars = input.nextInt();
      System.out.println("Please enter a cent amount:");
      Cents = input.nextInt();
      
      USMoney x = new USMoney(Dollars,Cents);
      
      System.out.println();
      System.out.println();
      System.out.println("First entry: $" + x.getDollars() + "." + x.getCents());
      System.out.println();
      
      System.out.println("Please enter another dollar amount:");
      Dollars = input.nextInt();
      System.out.println("Please enter another cent amount:");
      Cents = input.nextInt();
      
      USMoney y = new USMoney(Dollars,Cents);
      
      System.out.println();
      System.out.println();
      System.out.println("Second entry: $" + y.getDollars() + "." + y.getCents());
      System.out.println();
      
      USMoney z = x.plus(y);
      
      System.out.println("Total amount is: $" + z.getDollars() + "." + z.getCents());
   }
}