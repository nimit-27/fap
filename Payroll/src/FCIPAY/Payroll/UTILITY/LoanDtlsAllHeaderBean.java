package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;


public class LoanDtlsAllHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String loanType;
  private String loanDesc;
  private String loanFlag;
  private String loanAmnt;
  private String sanctionDate;
  private String sanctionNo;
  private String recStartDate;
  private String noofPrnInstall;
  private String noofIntInstall;
  private String installAmnt;
  private String firstInstallAmnt;
  private String intInstallAmnt;
  private String intAmnt;
  private String txtIntRate;
  private String screenModeLoan1;
  private String txtEmpList;
  private String txtLocId;
  private String txtGangName;
  private String txtGangId;
  private String txtLoc;

  public LoanDtlsAllHeaderBean()
  {
  }

  public String getLoanType()
  {
    return loanType;
  }

  public void setLoanType(String newLoanType)
  {
    loanType = newLoanType;
  }
  
  public String getLoanDesc()
  {
    return loanDesc;
  }

  public void setLoanDesc(String newLoanDesc)
  {
    loanDesc = newLoanDesc;
  }
  
  public String getLoanAmnt()
  {
    return loanAmnt;
  }

  public void setLoanAmnt(String newLoanAmnt)
  {
    loanAmnt = newLoanAmnt;
  }

  public String getSanctionDate()
  {
    return sanctionDate;
  }

  public void setSanctionDate(String newSanctionDate)
  {
    sanctionDate = newSanctionDate;
  }
  
  public String getSanctionNo()
  {
    return sanctionNo;
  }

  public void setSanctionNo(String newSanctionNo)
  {
    sanctionNo = newSanctionNo;
  }

  public String getRecStartDate()
  {
    return recStartDate;
  }

  public void setRecStartDate(String newRecStartDate)
  {
    recStartDate = newRecStartDate;
  }
  
  public String getNoofPrnInstall()
  {
    return noofPrnInstall;
  }

  public void setNoofPrnInstall(String newNoofPrnInstall)
  {
    noofPrnInstall = newNoofPrnInstall;
  }

  public String getNoofIntInstall()
  {
    return noofIntInstall;
  }

  public void setNoofIntInstall(String newNoofIntInstall)
  {
    noofIntInstall = newNoofIntInstall;
  }

  public String getInstallAmnt()
  {
    return installAmnt;
  }

  public void setInstallAmnt(String newInstallAmnt)
  {
    installAmnt = newInstallAmnt;
  }
  
  public String getFirstInstallAmnt()
  {
    return firstInstallAmnt;
  }

  public void setFirstInstallAmnt(String newFirstInstallAmnt)
  {
    firstInstallAmnt = newFirstInstallAmnt;
  }
  
   public String getIntInstallAmnt()
   
  {
    return intInstallAmnt;
  }

  public void setIntInstallAmnt(String newIntInstallAmnt)
  {
    intInstallAmnt = newIntInstallAmnt;
  }

  public String getTxtIntRate()
  {
    return txtIntRate;
  }

  public void setTxtIntRate(String newTxtIntRate)
  {
    txtIntRate = newTxtIntRate;
  }
  
  public String getScreenModeLoan1()
  {
    return screenModeLoan1;
  }

  public void setScreenModeLoan1(String newScreenModeLoan1)
  {
    screenModeLoan1 = newScreenModeLoan1;
  } 

  public String getIntAmnt()
  {
    return intAmnt;
  }

  public void setIntAmnt(String newIntAmnt)
  {
    intAmnt = newIntAmnt;
  }

  public String getLoanFlag()
  {
    return loanFlag;
  }

  public void setLoanFlag(String newLoanFlag)
  {
    loanFlag = newLoanFlag;
  }
  
    public String getTxtEmpList()
    {
      return txtEmpList;
    }
    
    public void setTxtEmpList(String newTxtEmpList)
    {
      txtEmpList=newTxtEmpList;
    }
    
    public String getTxtLocId()
    {
    return txtLocId;
    }
    
    public void setTxtLocId(String newTxtLocId)
    {
    txtLocId = newTxtLocId;
    }
    
    public String getTxtGangId()
    {
    return txtGangId;
    }
    
    public void setTxtGangId(String newTxtGangId)
    {
    txtGangId = newTxtGangId;
    }
    
    public String getTxtGangName()
    {
    return txtGangName;
    }
    
    public void setTxtGangName(String newTxtGangName)
    {
    txtGangName = newTxtGangName;
    }
    
    public String getTxtLoc()
    {
    return txtLoc;
    }
    
    public void setTxtLoc(String newTxtLoc)
    {
    txtLoc = newTxtLoc;
    }
    
}
