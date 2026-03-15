package FCIPAY.Payroll.Labour.Utility;

import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

import javax.swing.JPanel;

public class NWNPAreaClassiFicationMappingBean extends PayrollBaseDetailBean  {
    
    private String txtLoc;
    private String txtLocId;
    private String txtCityTypId;
    private String txtAreaTyp;
//    private String txtTranCityTyp; 
//    private String txtMgwCityTyp;
//    private String txtPopTyp;
    private String txtFrom;
    private String txtTo="";
    
    //private String txtLocationId;
    
    public NWNPAreaClassiFicationMappingBean() {
    }

    public void setTxtLoc(String txtLoc) {
        this.txtLoc = txtLoc;
    }

    public String getTxtLoc() {
        return txtLoc;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setTxtAreaTyp(String txtAreaTyp) {
        this.txtAreaTyp = txtAreaTyp;
    }

    public String getTxtAreaTyp() {
        return txtAreaTyp;
    }

    public void setTxtFrom(String txtFrom) {
        this.txtFrom = txtFrom;
    }

    public String getTxtFrom() {
        return txtFrom;
    }

    public void setTxtTo(String txtTo) {
        this.txtTo = txtTo;
    }

    public String getTxtTo() {
        return txtTo;
    }

//    public void setTxtLocationId(String txtLocationId) {
//        this.txtLocationId = txtLocationId;
//    }
//
//    public String getTxtLocationId() {
//        return txtLocationId;
//    }

    public void setTxtCityTypId(String txtCityTypId) {
        this.txtCityTypId = txtCityTypId;
    }

    public String getTxtCityTypId() {
        return txtCityTypId;
    }
}
