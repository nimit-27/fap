package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MaintPFDudnMstBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtSubscripAmt;
  private String txtDudnSrl;
  private String endField;
  private String startField;

  public MaintPFDudnMstBean()
  {
  }







  public String getTxtSubscripAmt()
  {
    return txtSubscripAmt;
  }

  public void setTxtSubscripAmt(String newTxtSubscripAmt)
  {
    txtSubscripAmt = newTxtSubscripAmt;
  }

  public String getTxtDudnSrl()
  {
    return txtDudnSrl;
  }

  public void setTxtDudnSrl(String newTxtDudnSrl)
  {
    txtDudnSrl = newTxtDudnSrl;
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