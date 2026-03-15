package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class PLIPaymentDetailBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtAllEmpNo;
  private String txtAllEmpName;
  private String txtDesig;
  private String prevPLIPaidAmnt;
  private String txtPLIAmnt;
  private String txtIncomTax;
  private String txtLeaveDed;
  private String netAmntPayble;

  public PLIPaymentDetailBean()
  {
  }

   public String getTxtAllEmpNo()
  {
    return txtAllEmpNo;
  }

  public void setTxtAllEmpNo(String newTxtAllEmpNo)
  {
    txtAllEmpNo = newTxtAllEmpNo;
  }
  
  public String getTxtAllEmpName()
  {
    return txtAllEmpName;
  }
  
  public void setTxtAllEmpName(String newTxtAllEmpName)
  {
    txtAllEmpName = newTxtAllEmpName;
  }
  
  public String getTxtDesig()
  {
    return txtDesig;
  }

  public void setTxtDesig(String newTxtDesig)
  {
    txtDesig = newTxtDesig;
  }
  
  public String getPrevPLIPaidAmnt()
  {
    return prevPLIPaidAmnt;
  }

  public void setPrevPLIPaidAmnt(String newPrevPLIPaidAmnt)
  {
    prevPLIPaidAmnt = newPrevPLIPaidAmnt;
  }
  
  public String getTxtPLIAmnt()
  {
    return txtPLIAmnt;
  }

  public void setTxtPLIAmnt(String newTxtPLIAmnt)
  {
    txtPLIAmnt = newTxtPLIAmnt;
  }
  
   public String getTxtIncomTax()
  {
    return txtIncomTax;
  }

  public void setTxtIncomTax(String newTxtIncomTax)
  {
    txtIncomTax = newTxtIncomTax;
  }
  
   public String getTxtLeaveDed()
  {
    return txtLeaveDed;
  }

  public void setTxtLeaveDed(String newTxtLeaveDed)
  {
    txtLeaveDed = newTxtLeaveDed;
  }
  
  public String getNetAmntPayble()
  {
    return netAmntPayble;
  }

  public void setNetAmntPayble(String newNetAmntPayble)
  {
    netAmntPayble = newNetAmntPayble;
  }
  
}