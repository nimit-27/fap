package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class EmpHighAchieversVO extends BaseDetailInfo implements Serializable
{
  private String txtEmployeeNo;
 // private String loginLocCode;
  public EmpHighAchieversVO()
  {
  }
 /*  public String getHdnEmpLbrFlag()
  {
    return hdnEmpLbrFlag;
  }

  public void setHdnEmpLbrFlag(String newHdnEmpLbrFlag)
  {
    hdnEmpLbrFlag = newHdnEmpLbrFlag;
  }
  
  public String getLoginLocCode()
  {
    return loginLocCode;
  }

  public void setLoginLocCode(String newLoginLocCode)
  {
    loginLocCode = newLoginLocCode;
  }
  */
 public String getTxtEmployeeNo()
  {
    return txtEmployeeNo;
  }

  public void setTxtEmployeeNo(String newTxtEmployeeNo)
  {
    txtEmployeeNo = newTxtEmployeeNo;
  }  
}