package FCIPAY.Payroll.DATAACCESSTIER.VO;

public class EmpTrnsfrQueryVO extends PayrollBaseQueryVO 
{
  private String txtEmpNo;
  private String screenName;
  private String hdnActionFlag;

  public EmpTrnsfrQueryVO()
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
  
  public String getHdnActionFlag()
  {
    return hdnActionFlag;
  }

  public void setHdnActionFlag(String newHdnActionFlag)
  {
    hdnActionFlag = newHdnActionFlag;
  }  
}