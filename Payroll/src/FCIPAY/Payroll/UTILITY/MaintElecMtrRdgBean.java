package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
public class MaintElecMtrRdgBean  extends PayrollBaseDetailBean implements Serializable 
{
  private String txtSrlNo="";
  private String txtInitialReading="";
  private String txtFinalReading="";
  private String txtInitialYearMonth="";
  private String txtFinalYearMonth="";

  
 public MaintElecMtrRdgBean()
 {
 }
 public MaintElecMtrRdgBean(String sSrlNo,String sInitialReading,String sFinalReading,String sInitialYearMonth,String sFinalYearMonth)
  {
   txtSrlNo=sSrlNo;
   txtInitialReading=sInitialReading;
   txtFinalReading=sFinalReading;
   txtInitialYearMonth=sInitialYearMonth;
   txtFinalYearMonth=sFinalYearMonth;
   }
  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getTxtInitialReading()
  {
    return txtInitialReading;
  }

  public void setTxtInitialReading(String newTxtInitialReading)
  {
    txtInitialReading = newTxtInitialReading;
  }

  public String getTxtFinalReading()
  {
    return txtFinalReading;
  }

  public void setTxtFinalReading(String newTxtFinalReading)
  {
    txtFinalReading = newTxtFinalReading;
  }

  public String getTxtInitialYearMonth()
  {
    return txtInitialYearMonth;
  }

  public void setTxtInitialYearMonth(String newTxtInitialYearMonth)
  {
    txtInitialYearMonth = newTxtInitialYearMonth;
  }

  public String getTxtFinalYearMonth()
  {
    return txtFinalYearMonth;
  }

  public void setTxtFinalYearMonth(String newTxtFinalYearMonth)
  {
    txtFinalYearMonth = newTxtFinalYearMonth;
  }

















}