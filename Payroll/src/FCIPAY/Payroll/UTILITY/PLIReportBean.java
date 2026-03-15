package FCIPAY.Payroll.UTILITY;

public class PLIReportBean extends PayrollBaseDetailBean
{
  private String  txtYYMM;
  private String  txtPayMode;
  private String  txtAmt;
  
  //private String  txtCPFAutoB;
  //private String  txtInvoiceB;
  //private String  txtIncomeTaxB;

  public PLIReportBean()
  {
  }


    public void setTxtYYMM(String txtYYMM) {
        this.txtYYMM = txtYYMM;
    }

    public String getTxtYYMM() {
        return txtYYMM;
    }

    public void setTxtPayMode(String txtPayMode) {
        this.txtPayMode = txtPayMode;
    }

    public String getTxtPayMode() {
        return txtPayMode;
    }

    public void setTxtAmt(String txtAmt) {
        this.txtAmt = txtAmt;
    }

    public String getTxtAmt() {
        return txtAmt;
    }

   
}
