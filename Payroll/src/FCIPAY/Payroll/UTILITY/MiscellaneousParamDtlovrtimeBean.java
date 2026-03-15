package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MiscellaneousParamDtlovrtimeBean  extends PayrollBaseDetailBean implements Serializable 
{
  private String txtOvrTimeAllow;
  private String txtOverSrl;
  private String startField;
  private String endField;

  public MiscellaneousParamDtlovrtimeBean()
  {
  }





  public String getTxtOvrTimeAllow()
  {
    return txtOvrTimeAllow;
  }

  public void setTxtOvrTimeAllow(String newTxtOvrTimeAllow)
  {
    txtOvrTimeAllow = newTxtOvrTimeAllow;
  }

  public String getTxtOverSrl()
  {
    return txtOverSrl;
  }

  public void setTxtOverSrl(String newTxtOverSrl)
  {
    txtOverSrl = newTxtOverSrl;
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



}