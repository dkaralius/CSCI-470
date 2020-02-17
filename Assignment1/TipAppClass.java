/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 1           Spring 2019  *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Wednesday, 02/13/2019          *
 *                                                          *
 ************************************************************/ 
import java.util.Scanner;

/**
 * The TipAppClass prints out a header and then uses the calculateTips()
 * method inorder to calculate the total bill amount and how much should
 * be paid per person.
 */
public class TipAppClass
{
    public static void main( String[] args )
    {
       System.out.println("*** Tip Calculator ***");
       System.out.println();
       calculateTips(); 
    }
    public static void calculateTips()
    {
      String answer;
      do
      {
       double bill;
       int tip;
       int size;
       Scanner input = new Scanner(System.in);
       TipCalculator myTipCalculator = new TipCalculator();
       
       System.out.print("Enter the bill amount: ");
       bill = input.nextDouble();
       while(bill < 0)
       {  
         System.out.println("Please enter a positive number!");
         System.out.print("Enter the bill amount: ");
         bill = input.nextDouble();
       }
       myTipCalculator.setBillAmount(bill);
       
       System.out.print("Enter your desired tip percentage (20 = 20%): ");
       tip = input.nextInt();
       while(tip  < 0)
       {
         System.out.println("Please enter a valid tip percentage!");
         System.out.print("Enter your desired tip percentage (20 = 20%): ");
         tip = input.nextInt();
       }
       myTipCalculator.setTipPercentage(tip);
       
       System.out.print("Enter the size of your party: ");
       size = input.nextInt();
       while(size <= 0)
       {
         System.out.println("Please enter a valid party size!");
         System.out.print("Enter the size of your party: ");
         size = input.nextInt();
       }
       myTipCalculator.setPartySize(size);
       
       System.out.println("*** Your Bill ***");
       System.out.println();
       System.out.printf("Bill Amount: $%.2f\n",myTipCalculator.getBillAmount());
       System.out.printf("Tip Percentage: %d%%\n",myTipCalculator.getTipPercentage());
       System.out.printf("Party Size: %s\n",myTipCalculator.getPartySize());
       
       System.out.println();
       System.out.printf("Total Bill (with Tip): $%.2f\n",myTipCalculator.getTotalBill());
       System.out.printf("Share for Each Individual: $%.2f\n",myTipCalculator.getIndividualShare());
       
       System.out.println();
       System.out.println("Another bill? (y/n)");
       answer = input.next();
       }while(answer.equals("y") || answer.equals("Y"));
       System.out.println("Goodbye!");
    }
}