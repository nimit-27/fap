package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MiscellaneousParamDtlprojBean  extends PayrollBaseDetailBean implements Serializable 
{
  private String txtProjAllow;
  private String txtProjSrl;
  private String endField;
  private String startField;

  public MiscellaneousParamDtlprojBean()
  {
  }






  public String getTxtProjAllow()
  {
    return txtProjAllow;
  }

  public void setTxtProjAllow(String newTxtProjAllow)
  {
    txtProjAllow = newTxtProjAllow;
  }

  public String getTxtProjSrl()
  {
    return txtProjSrl;
  }

  public void setTxtProjSrl(String newTxtProjSrl)
  {
    txtProjSrl = newTxtProjSrl;
  }

  public String getEndField()
  {
    return endField;
  }

  public void setEndField(String newEndField)
  {
    endField = newEndField;
  }

  public String getStartField()
  {
    return startField;
  }

  public void setStartField(String newStartField)
  {
    startField = newStartField;
  }


}