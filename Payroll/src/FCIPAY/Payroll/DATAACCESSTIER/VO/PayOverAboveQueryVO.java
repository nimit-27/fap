package FCIPAY.Payroll.DATAACCESSTIER.VO;

public class PayOverAboveQueryVO extends PayrollBaseQueryVO 
{
  private String txtEmpNo;
  private String screenName;
  private String txtApplnDt;
  //private String txtEncshAmt;
  private String txtCpfEmpCntrb;
  private String txtSnctnDt;
  private String txtSnctnAmnt;
  private String txtNetAmt;
  private String txtPayCode;

  public PayOverAboveQueryVO()
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

  
  /*public String getTxtEncshAmt()
  {
    return txtEncshAmt;
  }

  public void setTxtEncshAmt(String newTxtEncshAmt)
  {
    txtEncshAmt = newTxtEncshAmt;
  }*/  

  
  public String getTxtCpfEmpCntrb()
  {
    return txtCpfEmpCntrb;
  }

  public void setTxtCpfEmpCntrb(String newTxtCpfEmpCntrb)
  {
    txtCpfEmpCntrb = newTxtCpfEmpCntrb;
  }  
  public String getTxtSnctnDt()
  {
    return txtSnctnDt;
  }

  public void setTxtSnctnDt(String newTxtSnctnDt)
  {
    txtSnctnDt = newTxtSnctnDt;
  } 

  public String getTxtSnctnAmnt()
  {
    return txtSnctnAmnt;
  }

  public void setTxtSnctnAmnt(String newTxtSnctnAmnt)
  {
    txtSnctnAmnt = newTxtSnctnAmnt;
  } 
 public String getTxtNetAmt()
  {
    return txtNetAmt;
  }

  public void setTxtNetAmt(String newTxtNetAmt)
  {
    txtNetAmt = newTxtNetAmt;
  }
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }  

}