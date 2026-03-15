package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
//import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class PLIForeclosureBean extends PayrollBaseHeaderBean implements Serializable
{
 public String txtEmpStatus ="";
 public String txtBasic ="";
 public String txtEmpCategory ="";
 public String txtEmpNo= "";
 public String txtEmpName= "";
 public String txtDsgn= "";
 public String txtEmpType= "";
// public String txtPLI= "";
 private String   txtFinyr="";
 public String txtOutPrn= ""; 
// public String txtSysdate= "";
// public String txtOutInt= ""; 
 public String txtReceiptNo= "";
 public String txtReceiptAmt= "";
 public String txtLoanDesc= "";
 public String txtPaidPrn= "";
// public String txtPaidInt =""; 
 public String txtTransID="";
 public String txtT="";
 public String txtLoanFlag="";
 public String txtEmpCPF="";
 public String txtPLIAmt="";
 public String txtInvoiceNo;
 public PLIForeclosureBean()
 {
 }
  public String getTxtLoanFlag()
  {
    return txtLoanFlag;
  }
  
  public void setTxtLoanFlag(String newTxtLoanFlag)
  {
    txtLoanFlag = newTxtLoanFlag;
  }
  
   public String getTxtTransID()
  {
    return txtTransID;
  }
  public void setTxtTransID(String newTxtTransID)
  {
    txtTransID = newTxtTransID;
  }
    public String getTxtReceiptNo()
  {
    return txtReceiptNo;
  }
  
  public void setTxtReceiptNo(String newTxtReceiptNo)
  {
    txtReceiptNo = newTxtReceiptNo;
  }
   public String getTxtT()
  {
    return txtT;
  }
  
  public void setTxtT(String newTxtT)
  {
    txtT = newTxtT;
  }
   public String getTxtReceiptAmt()
  {
    return txtReceiptAmt;
  }
  
  public void setTxtReceiptAmt(String newTxtReceiptAmt)
  {
    txtReceiptAmt = newTxtReceiptAmt;
  }
  public String getTxtOutPrn()
  {
    return txtOutPrn;
  }
  public void setTxtOutPrn(String newTxtOutPrn)
  {
    txtOutPrn = newTxtOutPrn;
  }
  public String getTxtFinyr()
  {
    return txtFinyr;
  }
  public void setTxtFinyr(String newTxtFinyr)
  {
    txtFinyr = newTxtFinyr;
  }
   public String getTxtEmpType()
  {
    return txtEmpType;
  }
  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }
  public String getTxtDsgn()
  {
    return txtDsgn;
  }
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }
  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
   public String getTxtEmpName()
  {
    return txtEmpName;
  }
   public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
   public String getTxtBasic()
  {
    return txtBasic;
  }
  public void setTxtBasic(String newTxtBasic)
  {
    txtBasic = newTxtBasic;
  }
    public String getTxtEmpCategory()
  {
    return txtEmpCategory;
  }
  public void setTxtEmpCategory(String newTxtEmpCategory)
  {
    txtEmpCategory = newTxtEmpCategory;
  }
     public String getTxtEmpNo()
  {
    return txtEmpNo;
  }
  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
  public String getTxtLoanDesc()
  {
    return txtLoanDesc;
  }
  public void setTxtLoanDesc(String newTxtLoanDesc)
  {
    txtLoanDesc = newTxtLoanDesc;
  }
   public String getTxtPaidPrn()
  {
    return txtPaidPrn;
  }
  public void setTxtPaidPrn(String newTxtPaidPrn)
  {
    txtPaidPrn = newTxtPaidPrn;
  }
   public String getTxtEmpCPF()
  {
    return txtEmpCPF;
  }
  
  public void setTxtEmpCPF(String newTxtEmpCPF)
  {
    txtEmpCPF = newTxtEmpCPF;
  }
   public String getTxtPLIAmt()
  {
    return txtPLIAmt;
  }
  
  public void setTxtPLIAmt(String newTxtPLIAmt)
  {
    txtPLIAmt = newTxtPLIAmt;
  }
   public String getTxtInvoiceNo()  
  {
    return txtInvoiceNo;
  }
  public void setTxtInvoiceNo(String newTxtInvoiceNo)
  {
    txtInvoiceNo = newTxtInvoiceNo;
  } 
 }
 
