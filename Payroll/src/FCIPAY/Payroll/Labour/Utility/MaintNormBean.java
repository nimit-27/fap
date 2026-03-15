package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MaintNormBean extends PayrollBaseDetailBean 
{
  
  private String startField;
  private String endField;
  private String txtRate;
  private String txtNormId;
  private String txtBagTyp;
  
  
  public MaintNormBean()
  {
  }
  
  public MaintNormBean(String sStartField,String sEndField,String sRate,String sNormId)
  {
      startField=sStartField;
      endField=sEndField;
      txtRate=sRate;
      txtNormId=sNormId;
  }
  
   public String getStartField()
  {
    return startField;
  }

  public void setStartField(String newStartField)
  {
    startField = newStartField;
  }
  
   public String getEndField()
  {
    return endField;
  }

  public void setEndField(String newEndField)
  {
    endField = newEndField;
  }
  
  public String getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String newTxtRate)
  {
    txtRate = newTxtRate;
  }
  
  public String getTxtNormId()
  {
    return txtNormId;
  }

  public void setTxtNormId(String newTxtNormId)
  {
    txtNormId = newTxtNormId;
  }
  
  public String getTxtBagTyp()
  {
    return txtBagTyp;
  }

  public void setTxtBagTyp(String newTxtBagTyp)
  {
    txtBagTyp = newTxtBagTyp;
  }

}