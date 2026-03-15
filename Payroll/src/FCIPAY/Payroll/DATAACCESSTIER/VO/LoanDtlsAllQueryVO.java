package FCIPAY.Payroll.DATAACCESSTIER.VO;
import  FCIPAY.Payroll.common.vo.BaseQueryVO; 
import java.io.Serializable;

public class LoanDtlsAllQueryVO extends PayrollBaseQueryVO implements Serializable
{
   private String loanType;
   private String sanctionDate;
   private String sanctionNo;

  public LoanDtlsAllQueryVO()
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
}