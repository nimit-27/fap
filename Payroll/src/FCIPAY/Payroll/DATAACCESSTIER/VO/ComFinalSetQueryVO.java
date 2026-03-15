package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class ComFinalSetQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String lstPension;
  private String txtDate;

  public ComFinalSetQueryVO()
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

  public String getLstPension()
  {
    return lstPension;
  }

  public void setLstPension(String newLstPension)
  {
    lstPension = newLstPension;
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