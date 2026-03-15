package FCIPAY.Payroll.DATAACCESSTIER.VO;

public class EmpMediBillsQueryVO extends PayrollBaseQueryVO 
{
  private String txtEmpNo;
  private String txtPayCode;
  private String txtPayYYMM;
  private String quarter; // added by devendra on 8th sept 2010
  private String finYear; // added by devendra on 8th sept 2010
  private String txtInvID;
  private String screenName;
  

  public EmpMediBillsQueryVO()
  {
  }


  // added by devendra on 8th sept 2010 start
   public String getFinYear()
  {
    return finYear;
  }

  public void setFinYear(String newTxtFinYear)
  {
    finYear = newTxtFinYear;
  }  
  
  
  public String getQuarter()
  {
    return quarter;
  }

  public void setQuarter(String newQuarter)
  {
    quarter = newQuarter;
  }  
  // added by devendra on 8th sept 2010 end


  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtPayYYMM()
  {
    return txtPayYYMM;
  }

  public void setTxtPayYYMM(String newTxtPayYYMM)
  {
    txtPayYYMM = newTxtPayYYMM;
  }
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }  
    public String getTxtInvID()
  {
    return txtInvID;
  }

  public void setTxtInvID(String newTxtInvID)
  {
    txtInvID = newTxtInvID;
  }
  
     public String getScreenName()
  {
    return screenName;
  }

  public void setScreenName(String newScreenName)
  {
    screenName = newScreenName;
  }
}