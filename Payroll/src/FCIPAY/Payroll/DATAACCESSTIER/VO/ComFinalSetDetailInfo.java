package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class ComFinalSetDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtEmpNo;
  private String txtDate;
  private String txtflagGetDetail;

  public ComFinalSetDetailInfo()
  {
  }

  public String getTxtflagGetDetail()
  {
    return txtflagGetDetail;
  }

  public void setTxtflagGetDetail(String newTxtflagGetDetail)
  {
    txtflagGetDetail = newTxtflagGetDetail;
  }
  
  
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
  

  public String getTxtDate()
  {
    return txtDate;
  }

  public void setTxtDate(String newTxtDate)
  {
    txtDate = newTxtDate;
  }

}