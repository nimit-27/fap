package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class PLIReportDetailInfo extends BaseDetailInfo implements Serializable 
{
    private String txtEmpNo;
    private String tranId;
    private String buttonFlag;

      
  public PLIReportDetailInfo()
  {
  }
    
  public String getTranId()
  {
    return tranId;
  }
  public void setTranId(String newTranId)
  {
    tranId = newTranId;
  }
 
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }
  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
  
  public String getButtonFlag()
  {
    return buttonFlag;
  }
  public void setButtonFlag(String newButtonFlag)
  {
    buttonFlag = newButtonFlag;
  }
}
