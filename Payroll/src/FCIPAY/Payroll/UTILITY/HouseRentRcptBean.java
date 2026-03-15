package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;


public class HouseRentRcptBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtYYMM;
  private String txtAmt;
  private String hdnSrlNo;
  private String txtMonth;
  private String txtMnthRentAmt;

  public HouseRentRcptBean()
  {
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getTxtMonth()
  {
    return txtMonth;
  }

  public void setTxtMonth(String newTxtMonth)
  {
    txtMonth = newTxtMonth;
  }
  
  public String getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }

  public String getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }

  public String getTxtMnthRentAmt()
  {
    return txtMnthRentAmt;
  }

  public void setTxtMnthRentAmt(String newTxtMnthRentAmt)
  {
    txtMnthRentAmt = newTxtMnthRentAmt;
  }

}