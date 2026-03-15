package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class NWNPLabourASORInfoForm extends PayrollBaseForm
{
    private String [] txtLocCode;
    private String txtLocName;
    //private String [] txtOperation;
    private String [] txtBagRateAbv65;
    private String [] txtBagRateBlw65;  
    private String txtEffDate;
    private String txtEndDate;  
    private ArrayList lstInstrDtls= new ArrayList();
    private String txtRegCode;  
    private String txtRegName;  
    private String effStartDate;
    private String screenModeASOR;
    private String screenModeASOR1;
    private String screenModeASOR2;
    private String txtLocation; 
    private String txtLocId;
    private String [] txtBaseYr;
    private String [] txtSorRateUpto50;
    private String [] txtSorRateUpto75;
    private String [] txtSorRateabove75;
  
    private String [] txtLocationInfo;
    private String [] txtAsorPercent;
    private String [] txtGoDownTyp; 
    private String  [] txtFromDate; 
    private String  [] txtToDate;
  

  public NWNPLabourASORInfoForm()
  {
  }


    public void setTxtLocCode(String[] txtLocCode) {
        this.txtLocCode = txtLocCode;
    }

    public String[] getTxtLocCode() {
        return txtLocCode;
    }

    public void setTxtLocName(String txtLocName) {
        this.txtLocName = txtLocName;
    }

    public String getTxtLocName() {
        return txtLocName;
    }

//    public void setTxtOperation(String[] txtOperation) {
//        this.txtOperation = txtOperation;
//    }
//
//    public String[] getTxtOperation() {
//        return txtOperation;
//    }

    public void setTxtBagRateAbv65(String[] txtBagRateAbv65) {
        this.txtBagRateAbv65 = txtBagRateAbv65;
    }

    public String[] getTxtBagRateAbv65() {
        return txtBagRateAbv65;
    }

    public void setTxtBagRateBlw65(String[] txtBagRateBlw65) {
        this.txtBagRateBlw65 = txtBagRateBlw65;
    }

    public String[] getTxtBagRateBlw65() {
        return txtBagRateBlw65;
    }

    public void setTxtEffDate(String txtEffDate) {
        this.txtEffDate = txtEffDate;
    }

    public String getTxtEffDate() {
        return txtEffDate;
    }

    public void setTxtEndDate(String txtEndDate) {
        this.txtEndDate = txtEndDate;
    }

    public String getTxtEndDate() {
        return txtEndDate;
    }

    public void setLstInstrDtls(ArrayList lstInstrDtls) {
        this.lstInstrDtls = lstInstrDtls;
    }

    public ArrayList getLstInstrDtls() {
        return lstInstrDtls;
    }

    public void setTxtRegCode(String txtRegCode) {
        this.txtRegCode = txtRegCode;
    }

    public String getTxtRegCode() {
        return txtRegCode;
    }

    public void setTxtRegName(String txtRegName) {
        this.txtRegName = txtRegName;
    }

    public String getTxtRegName() {
        return txtRegName;
    }

    public void setEffStartDate(String effStartDate) {
        this.effStartDate = effStartDate;
    }

    public String getEffStartDate() {
        return effStartDate;
    }

    public void setScreenModeASOR(String screenModeASOR) {
        this.screenModeASOR = screenModeASOR;
    }

    public String getScreenModeASOR() {
        return screenModeASOR;
    }

    public void setScreenModeASOR1(String screenModeASOR1) {
        this.screenModeASOR1 = screenModeASOR1;
    }

    public String getScreenModeASOR1() {
        return screenModeASOR1;
    }

    public void setScreenModeASOR2(String screenModeASOR2) {
        this.screenModeASOR2 = screenModeASOR2;
    }

    public String getScreenModeASOR2() {
        return screenModeASOR2;
    }

    public void setTxtLocation(String txtLocation) {
        this.txtLocation = txtLocation;
    }

    public String getTxtLocation() {
        return txtLocation;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setTxtBaseYr(String[] txtBaseYr) {
        this.txtBaseYr = txtBaseYr;
    }

    public String[] getTxtBaseYr() {
        return txtBaseYr;
    }

    public void setTxtSorRateUpto50(String[] txtSorRateUpto50) {
        this.txtSorRateUpto50 = txtSorRateUpto50;
    }

    public String[] getTxtSorRateUpto50() {
        return txtSorRateUpto50;
    }

    public void setTxtSorRateUpto75(String[] txtSorRateUpto75) {
        this.txtSorRateUpto75 = txtSorRateUpto75;
    }

    public String[] getTxtSorRateUpto75() {
        return txtSorRateUpto75;
    }

    public void setTxtSorRateabove75(String[] txtSorRateabove75) {
        this.txtSorRateabove75 = txtSorRateabove75;
    }

    public String[] getTxtSorRateabove75() {
        return txtSorRateabove75;
    }

    public void setTxtLocationInfo(String[] txtLocationInfo) {
        this.txtLocationInfo = txtLocationInfo;
    }

    public String[] getTxtLocationInfo() {
        return txtLocationInfo;
    }

    public void setTxtAsorPercent(String[] txtAsorPercent) {
        this.txtAsorPercent = txtAsorPercent;
    }

    public String[] getTxtAsorPercent() {
        return txtAsorPercent;
    }

    public void setTxtGoDownTyp(String[] txtGoDownTyp) {
        this.txtGoDownTyp = txtGoDownTyp;
    }

    public String[] getTxtGoDownTyp() {
        return txtGoDownTyp;
    }

    public void setTxtFromDate(String[] txtFromDate) {
        this.txtFromDate = txtFromDate;
    }

    public String[] getTxtFromDate() {
        return txtFromDate;
    }

    public void setTxtToDate(String[] txtToDate) {
        this.txtToDate = txtToDate;
    }

    public String[] getTxtToDate() {
        return txtToDate;
    }
}

