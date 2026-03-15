package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class CPFFinalPaymentBaseDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtEmpNo;
  private String screenName;
  private String hdnSancType;

  public CPFFinalPaymentBaseDetailInfo()
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
 
  public String getScreenName()
  {
    return screenName;
  }

  public void setScreenName(String newScreenName)
  {
    screenName = newScreenName;
  }
  
  
  public String getHdnSancType()
  {
    return hdnSancType;
  }

  public void setHdnSancType(String newHdnSancType)
  {
    hdnSancType = newHdnSancType;
  } 

}