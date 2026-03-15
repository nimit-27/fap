package FCIPAY.Payroll.WEBTIER.Form;

import java.util.ArrayList;

public class IncomeTaxRegimeForm  extends PayrollBaseForm{
    
    private ArrayList lstInstrDtls=new ArrayList();
    private String txtEmpId;
    private String txtEmpName;
    private String txtCpfCode;
    private String screenInt;
    private String txtSiteId;
    private String txtSiteName;
    
    private int txtSrlNo[];
    private String txtFinYear[];
    private String txtITRegime[];
    private String txtFinalFlag[];
    private String txtFreeze[];
    
    
    public IncomeTaxRegimeForm() {
    
    }

    public void setLstInstrDtls(ArrayList lstInstrDtls) {
        this.lstInstrDtls = lstInstrDtls;
    }

    public ArrayList getLstInstrDtls() {
        return lstInstrDtls;
    }

    public void setTxtEmpId(String txtEmpId) {
        this.txtEmpId = txtEmpId;
    }

    public String getTxtEmpId() {
        return txtEmpId;
    }

    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public String getTxtEmpName() {
        return txtEmpName;
    }

    public void setTxtCpfCode(String txtCpfCode) {
        this.txtCpfCode = txtCpfCode;
    }

    public String getTxtCpfCode() {
        return txtCpfCode;
    }


    public void setTxtSiteId(String txtSiteId) {
        this.txtSiteId = txtSiteId;
    }

    public String getTxtSiteId() {
        return txtSiteId;
    }

    public void setTxtSiteName(String txtSiteName) {
        this.txtSiteName = txtSiteName;
    }

    public String getTxtSiteName() {
        return txtSiteName;
    }

    public void setTxtSrlNo(int[] txtSrlNo) {
        this.txtSrlNo = txtSrlNo;
    }

    public int[] getTxtSrlNo() {
        return txtSrlNo;
    }    

    public void setTxtFinYear(String[] txtFinYear) {
        this.txtFinYear = txtFinYear;
    }

    public String[] getTxtFinYear() {
        return txtFinYear;
    }

    public void setTxtITRegime(String[] txtITRegime) {
        this.txtITRegime = txtITRegime;
    }

    public String[] getTxtITRegime() {
        return txtITRegime;
    }

    public void setTxtFinalFlag(String[] txtFinalFlag) {
        this.txtFinalFlag = txtFinalFlag;
    }

    public String[] getTxtFinalFlag() {
        return txtFinalFlag;
    }

    public void setTxtFreeze(String[] txtFreeze) {
        this.txtFreeze = txtFreeze;
    }

    public String[] getTxtFreeze() {
        return txtFreeze;
    }

    public void setScreenInt(String screenInt) {
        this.screenInt = screenInt;
    }

    public String getScreenInt() {
        return screenInt;
    }

}
