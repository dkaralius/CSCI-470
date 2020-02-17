public class TipCalculator
{
  private double billAmount;
  private int tipPercentage;
  private int partySize;
 
  public TipCalculator()
  {
    billAmount = 0;
    tipPercentage = 20;
    partySize = 1;
  }
  public void setBillAmount(double billAmount)
  {
    this.billAmount = billAmount;
  }
  public void setTipPercentage(int tipPercentage)
  {
    this.tipPercentage = tipPercentage;
  }
  public void setPartySize(int partySize)
  {
    this.partySize = partySize;
  }
  public double getBillAmount()
  {
    return billAmount;
  }
  public int getTipPercentage()
  {
    return tipPercentage;
  }
  public int getPartySize()
  {
    return partySize;
  }
  public double getTotalBill()
  {
    double totalBill = 0;
    double tipAmount;
    tipAmount = billAmount*(double)tipPercentage/100;
    totalBill = tipAmount + billAmount;
    return totalBill;
  }
  public double getIndividualShare()
  {
    double totalBill = 0;
    double tipAmount;
    double equalShare = 0;
    tipAmount = billAmount*(double)tipPercentage/100;
    totalBill = tipAmount + billAmount;
    equalShare = totalBill/partySize;
    return equalShare;
  }
  public void displayMessage()
  {
    System.out.printf("\nYour bill is %s!\n", getBillAmount()); 
  }
}