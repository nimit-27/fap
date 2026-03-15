package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class CPFFinalPaymentDetailBean extends PayrollBaseDetailBean implements Serializable  
{
  private String txtEmpNoDtl;  
  private String txtEmpNameDtl;  
  private String claimReqId;

  private String sancOrderNoDtl;  
  private String sancDateDtl;  
  private String sancAmountDtl;
  private String dedITDtl;
  private String flgDedITDtl;
  private String txtRecYYYYMM;
  private String txtsancReason;
  private String txtEmployeeCntr;
  private String txtEmployerCntr;
  private String txtInvoiceNo;
  private String txtDedIT;
  public CPFFinalPaymentDetailBean()
  {
  }

  public String getTxtEmployeeCntr()
  {
    return txtEmployeeCntr;
  }

  public void setTxtEmployeeCntr(String newTxtEmployeeCntr)
  {
    txtEmployeeCntr = newTxtEmployeeCntr;
  }
  
  public String getTxtDedIT()
  {
    return txtDedIT;
  }

  public void setTxtDedIT(String newTxtDedIT)
  {
    txtDedIT = newTxtDedIT;
  }
  
  
   public String getTxtEmployerCntr()
  {
    return txtEmployerCntr;
  }

  public void setTxtEmployerCntr(String newTxtEmployerCntr)
  {
    txtEmployerCntr = newTxtEmployerCntr;
  }
  
  public String getTxtsancReason()
  {
    return txtsancReason;
  }

  public void setTxtsancReason(String newTxtsancReason)
  {
    txtsancReason = newTxtsancReason;
  }

  public String getTxtRecYYYYMM()
  {
    return txtRecYYYYMM;
  }

  public void setTxtRecYYYYMM(String newTxtRecYYYYMM)
  {
    txtRecYYYYMM = newTxtRecYYYYMM;
  }
  
  
  public String getTxtEmpNoDtl()
  {
    return txtEmpNoDtl;
  }

  public void setTxtEmpNoDtl(String newTxtEmpNoDtl)
  {
    txtEmpNoDtl = newTxtEmpNoDtl;
  }
  
  
   public String getTxtInvoiceNo()
  {
    return txtInvoiceNo;
  }

  public void setTxtInvoiceNo(String newTxtInvoiceNo)
  {
    txtInvoiceNo = newTxtInvoiceNo;
  }
  
  public String getTxtEmpNameDtl()
  {
    return txtEmpNameDtl;
  }

  public void setTxtEmpNameDtl(String newTxtEmpNameDtl)
  {
    txtEmpNameDtl = newTxtEmpNameDtl;
  }
  
  public String getSancAmountDtl()
  {
    return sancAmountDtl;
  }

  public void setSancAmountDtl(String newSancAmountDtl)
  {
    sancAmountDtl = newSancAmountDtl;
  }

  public String getSancOrderNoDtl()
  {
    return sancOrderNoDtl;
  }

  public void setSancOrderNoDtl(String newSancOrderNoDtl)
  {
    sancOrderNoDtl = newSancOrderNoDtl;
  }
  
  public String getSancDateDtl()
  {
    return sancDateDtl;
  }

  public void setSancDateDtl(String newSancDateDtl)
  {
    sancDateDtl = newSancDateDtl;
  } 
  
  public String getDedITDtl()
  {
    return dedITDtl;
  }
  
  public void setDedITDtl(String newDedITDtl)
  {
    dedITDtl=newDedITDtl;
  }  
  
  public String getFlgDedITDtl()
  {
    return flgDedITDtl;
  }
  
  public void setFlgDedITDtl(String newFlgDedITDtl)
  {
    flgDedITDtl=newFlgDedITDtl;
  }

    public void setClaimReqId(String claimReqId) {
        this.claimReqId = claimReqId;
    }

    public String getClaimReqId() {
        return claimReqId;
    }
}
