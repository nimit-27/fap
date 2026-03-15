package FCIPAY.Payroll.WEBTIER.Form;

import java.util.ArrayList;

public class BasicHistoryEventForm extends PayrollBaseForm{
    
    private ArrayList lstInstrDtls=new ArrayList();
    private String txtEmpId;
    private String txtEmpName;
    private String txtCpfCode;
    private String screenInt;
    private String txtSiteId;
    private String txtSiteName;
    
    private int txtSrlNo[];
    private String txtEventEffDate[];
    private String txtIncrementType[];
    private String txtEventType[];
    private String txtAmount[];
    private String txtEventFlag[];
    private String txtFreezeFlag[];

    private String txtEmpNo= "";
    
    public BasicHistoryEventForm() {
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

    public void setTxtSrlNo(int[] txtSrlNo) {
        this.txtSrlNo = txtSrlNo;
    }

    public int[] getTxtSrlNo() {
        return txtSrlNo;
    }

    public void setTxtEventEffDate(String[] txtEventEffDate) {
        this.txtEventEffDate = txtEventEffDate;
    }

    public String[] getTxtEventEffDate() {
        return txtEventEffDate;
    }

    public void setTxtIncrementType(String[] txtIncrementType) {
        this.txtIncrementType = txtIncrementType;
    }

    public String[] getTxtIncrementType() {
        return txtIncrementType;
    }

    public void setTxtEventType(String[] txtEventType) {
        this.txtEventType = txtEventType;
    }

    public String[] getTxtEventType() {
        return txtEventType;
    }

    public void setTxtAmount(String[] txtAmount) {
        this.txtAmount = txtAmount;
    }

    public String[] getTxtAmount() {
        return txtAmount;
    }

    

    public void setScreenInt(String screenInt) {
        this.screenInt = screenInt;
    }

    public String getScreenInt() {
        return screenInt;
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

    public void setTxtEventFlag(String[] txtEventFlag) {
        this.txtEventFlag = txtEventFlag;
    }

    public String[] getTxtEventFlag() {
        return txtEventFlag;
    }

    public void setTxtFreezeFlag(String[] txtFreezeFlag) {
        this.txtFreezeFlag = txtFreezeFlag;
    }

    public String[] getTxtFreezeFlag() {
        return txtFreezeFlag;
    }

    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }
}
