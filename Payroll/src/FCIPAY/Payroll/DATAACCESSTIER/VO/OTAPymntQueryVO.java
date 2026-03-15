package FCIPAY.Payroll.DATAACCESSTIER.VO;

public class OTAPymntQueryVO extends PayrollBaseQueryVO 
{
  private String txtEmpNo;
  private String screenName;
  private String txtDsgn;  
  private String txtDsgnDesc;
  private String txtCateg;  
  private String txtCategDesc; 
  private String txtCpfCode;
  private String txtYYMM;
  private String txtGrossAmt;
  private String txtNetAmt;

  public OTAPymntQueryVO()
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
  
  public String getTxtDsgn()
  {
    return txtDsgn;
  }
  
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }

  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtCategDesc()
  {
    return txtCategDesc;
  }

  public void setTxtCategDesc(String newTxtCategDesc)
  {
    txtCategDesc = newTxtCategDesc;
  }

  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }  

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }  


  public String getTxtGrossAmt()
  {
    return txtGrossAmt;
  }

  public void setTxtGrossAmt(String newTxtGrossAmt)
  {
    txtGrossAmt = newTxtGrossAmt;
  }  
  
  public String getTxtNetAmt()
  {
    return txtNetAmt;
  }

  public void setTxtNetAmt(String newTxtNetAmt)
  {
    txtNetAmt = newTxtNetAmt;
  }


}