package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class DpsLabourSORDtlInfo extends BaseDetailInfo implements Serializable
{
  //private String txtLocCode;
  private String txtRegCode="";
  private String txtOperation;
  private String txtBagRateAbv65;
  private String txtBagRateBlw65;  
  //private String txtEffDate;
  private String txtEndDate;

  public DpsLabourSORDtlInfo()
  {
  }  
  
   public String getTxtRegCode()
  {
    return txtRegCode;
  }

  public void setTxtRegCode(String newTxtRegCode)
  {
    txtRegCode = newTxtRegCode;
  } 
  
  public String getTxtOperation()
  {
    return txtOperation;
  }

  public void setTxtOperation(String newTxtOperation)
  {
    txtOperation = newTxtOperation;
  } 
  
  public String getTxtBagRateAbv65()
  {
    return txtBagRateAbv65;
  }

  public void setTxtBagRateAbv65(String newTxtBagRateAbv65)
  {
    txtBagRateAbv65 = newTxtBagRateAbv65;
  }
  
  public String getTxtBagRateBlw65()
  {
    return txtBagRateBlw65;
  }

  public void setTxtBagRateBlw65(String newTxtBagRateBlw65)
  {
    txtBagRateBlw65 = newTxtBagRateBlw65;
  } 
  
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  }  
}