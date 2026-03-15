package FCIPAY.Payroll.DATAACCESSTIER.VO;

public class LeaveEncashQueryVO extends PayrollBaseQueryVO 
{
  private String txtEmpNo;
  private String screenName;
  private String txtApplnDt;
  private String txtEncshAmt;
  private String txtCpfEmpCntrb;
  private String txtInvId;


  public LeaveEncashQueryVO()
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

  public void setscreenName(String newScreenName)
  {
    screenName = newScreenName;
  }
  
  public String getTxtApplnDt()
  {
    return txtApplnDt;
  }

  public void setTxtApplnDt(String newTxtApplnDt)
  {
    txtApplnDt = newTxtApplnDt;
  }  

  
  public String getTxtEncshAmt()
  {
    return txtEncshAmt;
  }

  public void setTxtEncshAmt(String newTxtEncshAmt)
  {
    txtEncshAmt = newTxtEncshAmt;
  }  

  
  public String getTxtCpfEmpCntrb()
  {
    return txtCpfEmpCntrb;
  }

  public void setTxtCpfEmpCntrb(String newTxtCpfEmpCntrb)
  {
    txtCpfEmpCntrb = newTxtCpfEmpCntrb;
  }  
    public String getTxtInvId()
    {
    return txtInvId;
    }

    public void setTxtInvId(String newTxtInvId)
    {
    txtInvId = newTxtInvId;
    }
}