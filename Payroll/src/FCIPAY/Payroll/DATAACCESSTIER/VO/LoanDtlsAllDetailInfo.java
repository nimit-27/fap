package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class LoanDtlsAllDetailInfo extends BaseDetailInfo implements Serializable
{
  private String loanType;
  private String sanctionDate;
  private String sanctionNo;
  private String screenModeFlag; 


  public LoanDtlsAllDetailInfo()
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
  
   public String getScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(String newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  }
  
   
}