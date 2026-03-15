package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class PLIReportAdjustmentQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String tranId;
  private String screenName;
  private String txtInvoice;
  
  public PLIReportAdjustmentQueryVO()
  {
  }
  
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  } 
  
  public String getTranId()
  {
    return tranId;
  }
  public void setTranId(String newTranId)
  {
    tranId = newTranId;
  }
  
  public String getScreenName()
  {
    return screenName;
  }
  public void setScreenName(String newScreenName)
  {
    screenName = newScreenName;
  }
   public String getTxtInvoice()
  {
    return txtInvoice;
  }
  public void setTxtInvoice(String newTxtInvoice)
  {
    txtInvoice = newTxtInvoice;
  }
  
  
}