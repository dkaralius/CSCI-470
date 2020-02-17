/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 2          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Wednesday, 02/20/2019          *
 *                                                          *
 *  Desination Class                                        *
 *                                                          *
 ************************************************************/ 
/**
 * The Desination class encapsulates the default constructor and get/set methods for the variables that
 * will be used in the main app. Variables are private.
 */

public class Destination
{
  //Variable declarations.
   private String destination;
   private int normalMiles;
   private int upgradeMiles;
   private int frequentFlyer;
   private int startMonth;
   private int endMonth;
  
  //Constructor
   public Destination(String destinationCity, int normMiles, int upMiles, int freqMiles, int sMonth, int eMonth)
   {
      setName(destinationCity);
      setNormalMiles(normMiles);
      setUpgradeMiles(upMiles);
      setFrequentFlyerMiles(freqMiles);
      setStartMonth(sMonth);
      setEndMonth(eMonth);
   }

// get methods
   public String getName()
   {
      return destination; 
   }
   
   public int getNormalMiles()
   {
      return normalMiles; 
   }
   
   public int getUpgradeMiles()
   {
      return upgradeMiles; 
   }
   
   public int getFrequentFlyerMiles()
   {
      return frequentFlyer;
   }
   
   public int getStartMonth()
   {
      return startMonth; 
   }
   
   public int getEndMonth()
   {
      return endMonth; 
   }
// set methods
   public void setName(String destination)
   {
      this.destination = destination;
   }
   
   public void setNormalMiles(int normalMiles)
   {
      this.normalMiles = normalMiles; 
   }
   
   public void setUpgradeMiles(int upgradeMiles)
   {
      this.upgradeMiles = upgradeMiles; 
   }
   
   public void setFrequentFlyerMiles(int frequentFlyer)
   {
      this.frequentFlyer = frequentFlyer;
   }
   
   public void setStartMonth(int startMonth)
   {
      this.startMonth = startMonth; 
   }
   
   public void setEndMonth(int endMonth)
   {
      this.endMonth = endMonth; 
   }
}