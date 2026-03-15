package FCIPAY.Payroll.DATAACCESSTIER.VO;

public class PLIForeclosureVO extends PayrollBaseQueryVO 
{
  private String txtEmpNo;
  private String screenName;
//  private String txtPrnInstalNo;
 // private String txtIntInstalNo;
 // private String  txtBalPrnInstal;
//  private String txtBalIntInstal;
  private String txtPLIAmt;
 // private String txtMonPrnAmt;
 // private String txtMonIntAmt;
  private String txtLoanFlag;
  private String txtTransID;
 // private String txtPLI;
 private String txtFinyr;

  private String txtT;
  private String txtInvoiceNo;
  public PLIForeclosureVO()
  {
  }
   public String getTxtT()
  {
    return txtT;
  }

  public void setTxtT(String newTxtT)
  {
    txtT = newTxtT;
  }
  
  public String getTxtFinyr()
  {
    return txtFinyr;
  }

  public void setTxtFinyr(String newTxtFinyr)
  {
    txtFinyr = newTxtFinyr;
  }
  public String getTxtTransID()
  {
    return txtTransID;
  }

  public void setTxtTransID(String newTxtTransID)
  {
    txtTransID = newTxtTransID;
  }
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
  
   public String getScreenName()
  {
    return screenName; 
  }

  public void setscreenName(String newScreenName)
  {
    screenName = newScreenName;
  }
  public String getTxtPLIAmt()
  {
    return txtPLIAmt;
  }

  public void setTxtPLIAmt(String newTxtPLIAmt)
  {
    txtPLIAmt = newTxtPLIAmt;
  }
  
  public String getTxtLoanFlag()
  {
    return txtLoanFlag;
  }

  public void setTxtLoanFlag(String newTxtLoanFlag)
  {
    txtLoanFlag = newTxtLoanFlag;
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

