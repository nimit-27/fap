package FCIPAY.Payroll.UTILITY;

public class SupplPayBean  extends PayrollBaseDetailBean
{
  private String  txtPayDesc;
  private String  txtPayCode;
  private String  txtYYMM;
  private String  txtPayMode;
  private String  txtAmt;
  
  //private String  txtCPFAutoB;
  //private String  txtInvoiceB;
  //private String  txtIncomeTaxB;

  public SupplPayBean()
  {
  }
  
  public String getTxtPayDesc()
  {
    return txtPayDesc;
  }

  public void setTxtPayDesc(String newTxtPayDesc)
  {
    txtPayDesc=newTxtPayDesc;
  }
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }
  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode=newTxtPayCode;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }
  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM=newTxtYYMM;
  }

  public String getTxtPayMode()
  {
    return txtPayMode;
  }
  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode=newTxtPayMode;
  }

  public String getTxtAmt()
  {
    return txtAmt;
  }
  public void setTxtAmt(String  newTxtAmt)
  {
    txtAmt=newTxtAmt;
  }

  /*public String getTxtCPFAutoB()
  {
    return txtCPFAutoB;
  }
  public void setTxtCPFAutoB(String newTxtCPFAutoB)
  {
    txtCPFAutoB=newTxtCPFAutoB;
  }*/

 /* public String getTxtInvoiceB()
  {
    return txtInvoiceB;
  }
  public void setTxtInvoiceB(String newTxtInvoiceB)
  {
    txtInvoiceB=newTxtInvoiceB;
  }*/

 /* public String getTxtIncomeTaxB()
  {
    return txtIncomeTaxB;
  }
  public void setTxtIncomeTaxB(String newTxtIncomeTaxB)
  {
    txtIncomeTaxB=newTxtIncomeTaxB;
  }*/
 
  
}