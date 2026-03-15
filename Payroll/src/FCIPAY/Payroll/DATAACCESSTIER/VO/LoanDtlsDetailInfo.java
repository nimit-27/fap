package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class LoanDtlsDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtEmpNo;  
  private String loanType;  
  private String loanAmnt;
  private String sanctionDate;
  private String recStartDate;
  private String noofPrnInstall;
  private String noofIntInstall;
  private String installAmnt;
  private String loanDesc;
  private String invoiceNo;                                   // added by duhsyant on 29-11-2010  
  

  public LoanDtlsDetailInfo()
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

  public String getLoanType()
  {
    return loanType;
  }

  public void setLoanType(String newLoanType)
  {
    loanType = newLoanType;
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
  
  public String getLoanDesc()
  {
    return loanDesc;
  }

  public void setLoanDesc(String newLoanDesc)
  {
    loanDesc = newLoanDesc;
  }
// added by dushyant on 29-11-2010
 
  public String getInvoiceNo()
  {
    return invoiceNo;
  }

  public void setInvoiceNo(String  newInvoiceNo)
  {
    invoiceNo = newInvoiceNo;
  }
  
}