package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class MaintTransportSubsideDetailInfo extends BaseDetailInfo implements Serializable 
{
    private String txtEmpNo;
    private String txtFinYear;  
    private String txtAmtHdr;
     
  public MaintTransportSubsideDetailInfo()
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
  
  public String getTxtFinYear()
  {
    return txtFinYear;
  }

  public void setTxtFinYear(String newTxtFinYear)
  {
    txtFinYear = newTxtFinYear;
  }

  public String getTxtAmtHdr()
  {
    return txtAmtHdr;
  }
  public void setTxtAmtHdr(String newTxtAmtHdr)
  {
    txtAmtHdr = newTxtAmtHdr;
  }

}