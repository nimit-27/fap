package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class EmpLeaveDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtEmpNo;
  private String txtToYYMM;
  private String txtYYMM;

  public EmpLeaveDetailInfo()
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

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }
  
  
  public String getTxtToYYMM()
  {
    return txtToYYMM;
  }

  public void setTxtToYYMM(String newTxtToYYMM)
  {
    txtToYYMM = newTxtToYYMM;
  }

}