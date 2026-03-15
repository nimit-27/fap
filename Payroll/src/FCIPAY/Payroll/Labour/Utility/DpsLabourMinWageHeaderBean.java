package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class DpsLabourMinWageHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  private String txtCityType;   // added by dushyant on 19-April-2011
  private String txtPieceRate;
  private String txtEffDate;
  private String txtEndDate; 
  
  public DpsLabourMinWageHeaderBean()
  {
  }
  
  public String getTxtPieceRate()
  {
    return txtPieceRate;
  }

  public void setTxtPieceRate(String newTxtPieceRate)
  {
    txtPieceRate = newTxtPieceRate;
  }  
  
  public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }
  
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  } 
// added by dushyant on 19-April-2011
 public String getTxtCityType()
  {
    return txtCityType;
  }

  public void setTxtCityType(String newTxtCityType)
  {
    txtCityType = newTxtCityType;
  }
// end by dushyant on 19-April-2011
  
}