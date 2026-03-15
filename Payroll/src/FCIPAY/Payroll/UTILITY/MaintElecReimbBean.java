package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MaintElecReimbBean  extends PayrollBaseDetailBean implements Serializable
{
  private String txtAllow;
  private String hdnSrlNo;
  private String startField;
  private String endField;

  public MaintElecReimbBean()
  {
  }

  public String getTxtAllow()
  {
    return txtAllow;
  }

  public void setTxtAllow(String newTxtAllow)
  {
    txtAllow = newTxtAllow;
  }

  public String getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
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