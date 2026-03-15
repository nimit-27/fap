package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class IntRateHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String loanType;
  private String loanIntType;
  private String dateFrom;
  private String dateTo;
  private String refundFlag;
  private String loanHdrDesc;
  private String hdnHeaderFlag;
  private String txtIntRate;

  public String getTxtIntRate()
  {
    return txtIntRate;
  }

  public void setTxtIntRate(String newTxtIntRate)
  {
    txtIntRate = newTxtIntRate;
  }

  public IntRateHeaderBean()
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

  public String getLoanHdrDesc()
  {
    return loanHdrDesc;
  }

  public void setLoanHdrDesc(String newLoanHdrDesc)
  {
    loanHdrDesc = newLoanHdrDesc;
  }

  public String getHdnHeaderFlag()
  {
    return hdnHeaderFlag;
  }

  public void setHdnHeaderFlag(String newHdnHeaderFlag)
  {
    hdnHeaderFlag = newHdnHeaderFlag;
  }
}