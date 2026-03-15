package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class IntRateDetailInfo extends BaseDetailInfo implements Serializable
{
  private String loanType;
  private String loanIntType;  
  private String dateFrom;
  private String dateTo;
  private String refundFlag;

  public IntRateDetailInfo()
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
  
  public String getRefundFlag()
  {
    return refundFlag;
  }

  public void setRefundFlag(String newRefundFlag)
  {
    refundFlag = newRefundFlag;
  }
  
}