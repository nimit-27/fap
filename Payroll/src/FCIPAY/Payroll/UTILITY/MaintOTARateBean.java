package FCIPAY.Payroll.UTILITY;

public class MaintOTARateBean extends PayrollBaseDetailBean 
{

  private String txtOTATyp;
  private String txtRate;
  
  public MaintOTARateBean()
  {
  }
  
  public String getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String newTxtRate)
  {
    txtRate = newTxtRate;
  }
  
  public String getTxtOTATyp()
  {
    return txtOTATyp;
  }

  public void setTxtOTATyp(String newTxtOTATyp)
  {
    txtOTATyp = newTxtOTATyp;
  }
}