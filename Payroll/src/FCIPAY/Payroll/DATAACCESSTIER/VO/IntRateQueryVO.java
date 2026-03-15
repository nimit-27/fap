package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

public class IntRateQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String loanType;
  private String loanIntType;
  private String refundFlag;
  private String dateFrom;
  private String dateTo;
  private String loanDesc;

  public IntRateQueryVO()
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
  
  public String getLoanIntType()
  {
    return loanIntType;
  }

  public void setLoanIntType(String newLoanIntType)
  {
    loanIntType = newLoanIntType;
  }
  
  public String getRefundFlag()
  {
    return refundFlag;
  }

  public void setRefundFlag(String newRefundFlag)
  {
    refundFlag = newRefundFlag;
  }

  public String getDateFrom()
  {
    return dateFrom;
  }

  public void setDateFrom(String newDateFrom)
  {
    dateFrom = newDateFrom;
  }

  public String getDateTo()
  {
    return dateTo;
  }

  public void setDateTo(String newDateTo)
  {
    dateTo = newDateTo;
  }

  public String getLoanDesc()
  {
    return loanDesc;
  }

  public void setLoanDesc(String newLoanDesc)
  {
    loanDesc = newLoanDesc;
  }
}