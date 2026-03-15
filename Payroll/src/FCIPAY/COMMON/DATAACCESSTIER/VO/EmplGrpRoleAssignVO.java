package FCIPAY.COMMON.DATAACCESSTIER.VO;

import java.util.ArrayList;

public class EmplGrpRoleAssignVO  {

    private String txtEmplNo        ="";
    private String txtHidUserLocId  ="";
    private String txtRole          ="";
    private String txtModule        ="";
    private ArrayList lstGroupRows  =null;
    private String[] txtHidGroupChecked=null;
    private ArrayList lstRoleRows  =null;
    private String[] txtHidRoleChecked=null;
    private String txtUserId="";
    private String txtLocId="";

    public EmplGrpRoleAssignVO() {
        lstGroupRows=new ArrayList(1);
        lstRoleRows=new ArrayList(1);
    }

    public ArrayList getLstGroupRows() {
        return lstGroupRows;
    }

    public void setLstGroupRows(ArrayList newLstGroupRows) {
        lstGroupRows = newLstGroupRows;
    }

    public ArrayList getLstRoleRows() {
        return lstRoleRows;
    }

    public void setLstRoleRows(ArrayList newLstRoleRows) {
        lstRoleRows = newLstRoleRows;
    }

    public String getTxtEmplNo() {
        return txtEmplNo;
    }

    public void setTxtEmplNo(String newTxtEmplNo) {
        txtEmplNo = newTxtEmplNo;
    }

    public String[] getTxtHidGroupChecked() {
        return txtHidGroupChecked;
    }

    public void setTxtHidGroupChecked(String[] newTxtHidGroupChecked) {
        txtHidGroupChecked = newTxtHidGroupChecked;
    }

    public String[] getTxtHidRoleChecked() {
        return txtHidRoleChecked;
    }

    public void setTxtHidRoleChecked(String[] newTxtHidRoleChecked) {
        txtHidRoleChecked = newTxtHidRoleChecked;
    }

    public String getTxtHidUserLocId() {
        return txtHidUserLocId;
    }

    public void setTxtHidUserLocId(String newTxtHidUserLocId) {
        txtHidUserLocId = newTxtHidUserLocId;
    }

    public String getTxtModule() {
        return txtModule;
    }

    public void setTxtModule(String newTxtModule) {
        txtModule = newTxtModule;
    }

    public String getTxtRole() {
        return txtRole;
    }

    public void setTxtRole(String newTxtRole) {
        txtRole = newTxtRole;
    }

    public String getTxtUserId() {
        return txtUserId;
    }

    public void setTxtUserId(String newTxtUserId) {
        txtUserId = newTxtUserId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setTxtLocId(String newTxtLocId) {
        txtLocId = newTxtLocId;
    }
}