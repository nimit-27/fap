package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class LoanDtlsAdminDetailBean extends PayrollBaseDetailBean implements Serializable
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
  private String transMastId;
  private String intInstallAmnt; 
  private String intAmnt; 
  
  private String balInstall;
  private String paidInstall;
  private String paidAmt;
  private String balPrnAmt;
  private String balIntAmt;

  public LoanDtlsAdminDetailBean()
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

  public String getLoanFlag()
  {
    return loanFlag;
  }

  public void setLoanFlag(String newLoanFlag)
  {
    loanFlag = newLoanFlag;
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
  
  public String getTransMastId()
  {
    return transMastId;
  }

  public void setTransMastId(String newTransMastId)
  {
    transMastId = newTransMastId;
  }  
  
  public String getIntInstallAmnt()
  {
    return intInstallAmnt;
  }

  public void setIntInstallAmnt(String newIntInstallAmnt)
  {
    intInstallAmnt = newIntInstallAmnt;
  }  
  
  public String getIntAmnt()
  {
    return intAmnt;
  }

  public void setIntAmnt(String newIntAmnt)
  {
    intAmnt = newIntAmnt;
  }  

  public String getBalInstall()
  {
    return balInstall;
  }

  public void setBalInstall(String newBalInstall)
  {
    balInstall = newBalInstall;
  }  

  public String getPaidInstall()
  {
    return paidInstall;
  }

  public void setPaidInstall(String newPaidInstall)
  {
    paidInstall = newPaidInstall;
  }  

  public String getPaidAmt()
  {
    return paidAmt;
  }

  public void setPaidAmt(String newPaidAmt)
  {
    paidAmt = newPaidAmt;
  }  

  public String getBalPrnAmt()
  {
    return balPrnAmt;
  }

  public void setBalPrnAmt(String newBalPrnAmt)
  {
    balPrnAmt = newBalPrnAmt;
  }  

  public String getBalIntAmt()
  {
    return balIntAmt;
  }

  public void setBalIntAmt(String newBalIntAmt)
  {
    balIntAmt = newBalIntAmt;
  }  
  
}