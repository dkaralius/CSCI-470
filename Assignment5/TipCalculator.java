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
}