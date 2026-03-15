package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class NWNPLabourASORDtlBean extends PayrollBaseDetailBean implements Serializable  
{

//    private String txtOperation;
//    private String txtBagRateAbv65;
//    private String txtBagRateBlw65;  
//    //private String txtEffDate;
//    private String txtBaseYr;
//    private String txtSorRateUpto50; 
//    private String txtSorRateUpto75; 
//    private String txtSorRateabove75;

  //private String txtLocation;
  private String txtAsorPercent;
  private String txtGoDownTyp; 
  private String  txtFromDate; 
  private String  txtToDate;
    
  public NWNPLabourASORDtlBean()
  {
  }


//    public void setTxtOperation(String txtOperation) {
//        this.txtOperation = txtOperation;
//    }
//
//    public String getTxtOperation() {
//        return txtOperation;
//    }
//
//    public void setTxtBagRateAbv65(String txtBagRateAbv65) {
//        this.txtBagRateAbv65 = txtBagRateAbv65;
//    }
//
//    public String getTxtBagRateAbv65() {
//        return txtBagRateAbv65;
//    }
//
//    public void setTxtBagRateBlw65(String txtBagRateBlw65) {
//        this.txtBagRateBlw65 = txtBagRateBlw65;
//    }
//
//    public String getTxtBagRateBlw65() {
//        return txtBagRateBlw65;
//    }
//
//    public void setTxtBaseYr(String txtBaseYr) {
//        this.txtBaseYr = txtBaseYr;
//    }
//
//    public String getTxtBaseYr() {
//        return txtBaseYr;
//    }
//
//    public void setTxtSorRateUpto50(String txtSorRateUpto50) {
//        this.txtSorRateUpto50 = txtSorRateUpto50;
//    }
//
//    public String getTxtSorRateUpto50() {
//        return txtSorRateUpto50;
//    }
//
//    public void setTxtSorRateUpto75(String txtSorRateUpto75) {
//        this.txtSorRateUpto75 = txtSorRateUpto75;
//    }
//
//    public String getTxtSorRateUpto75() {
//        return txtSorRateUpto75;
//    }
//
//    public void setTxtSorRateabove75(String txtSorRateabove75) {
//        this.txtSorRateabove75 = txtSorRateabove75;
//    }
//
//    public String getTxtSorRateabove75() {
//        return txtSorRateabove75;
//    }

//    public void setTxtLocation(String txtLocation) {
//        this.txtLocation = txtLocation;
//    }
//
//    public String getTxtLocation() {
//        return txtLocation;
//    }

    public void setTxtAsorPercent(String txtAsorPercent) {
        this.txtAsorPercent = txtAsorPercent;
    }

    public String getTxtAsorPercent() {
        return txtAsorPercent;
    }

    public void setTxtGoDownTyp(String txtGoDownTyp) {
        this.txtGoDownTyp = txtGoDownTyp;
    }

    public String getTxtGoDownTyp() {
        return txtGoDownTyp;
    }

    public void setTxtFromDate(String txtFromDate) {
        this.txtFromDate = txtFromDate;
    }

    public String getTxtFromDate() {
        return txtFromDate;
    }

    public void setTxtToDate(String txtToDate) {
        this.txtToDate = txtToDate;
    }

    public String getTxtToDate() {
        return txtToDate;
    }
}
