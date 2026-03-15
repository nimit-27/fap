package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
public class MaintHandlingNormBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtNormId= "";
  private String txtNormDesc ="";
  private String txtNormBel66kg = "";
  private String txtNormAbv66kg = "";
  private String txtNormRate;
  private String txtNormUnit;
  
  public MaintHandlingNormBean()
  {
  }
  
  public String getTxtNormId()
  {
    return txtNormId;
  }

  public void setTxtNormId(String newTxtNormId)
  {
    txtNormId = newTxtNormId;
  }

  public String getTxtNormDesc()
  {
    return txtNormDesc;
  }

  public void setTxtNormDesc(String newTxtNormDesc)
  {
    txtNormDesc = newTxtNormDesc;
  }

  public String getTxtNormBel66kg()
  {
    return txtNormBel66kg;
  }

  public void setTxtNormBel66kg(String newTxtNormBel66kg)
  {
    txtNormBel66kg = newTxtNormBel66kg;
  }
  
  public String getTxtNormAbv66kg()
  {
    return txtNormAbv66kg;
  }

  public void setTxtNormAbv66kg(String newTxtNormAbv66kg)
  {
    txtNormAbv66kg = newTxtNormAbv66kg;
  }
  
  public String getTxtNormUnit()
  {
    return txtNormUnit;
  }

  public void setTxtNormUnit(String newTxtNormUnit)
  {
    txtNormUnit = newTxtNormUnit;
  }

   public String getTxtNormRate()
  {
    return txtNormRate;
  }

  public void setTxtNormRate(String newTxtNormRate)
  {
    txtNormRate = newTxtNormRate;
  }
}