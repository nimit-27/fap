package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class DirPayrollBulkDetailInfo extends BaseDetailInfo implements Serializable
{
  //private String txtEmpNo1;
  private String txtPayCode1;
  private String txtValidFrom = null;
  private String txtPayMode = null;
  private String payTxnHdrId = null;

  public DirPayrollBulkDetailInfo()
  {
  }

  /*public String getTxtEmpNo1()
  {
    return txtEmpNo1;
  }

  public void setTxtEmpNo1(String newTxtEmpNo1)
  {
    txtEmpNo1 = newTxtEmpNo1;
  }*/

  public String getTxtPayCode1()
  {
    return txtPayCode1;
  }

  public void setTxtPayCode1(String newTxtPayCode1)
  {
    txtPayCode1 = newTxtPayCode1;
  }  
  
  public String getTxtValidFrom()
  {
    return txtValidFrom;
  }

  public void setTxtValidFrom(String newTxtValidFrom)
  {
    txtValidFrom = newTxtValidFrom;
  }
  
  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }
  
  public String getPayTxnHdrId()
  {
    return payTxnHdrId;
  }

  public void setPayTxnHdrId(String newPayTxnHdrId)
  {
    payTxnHdrId = newPayTxnHdrId;
  }

}