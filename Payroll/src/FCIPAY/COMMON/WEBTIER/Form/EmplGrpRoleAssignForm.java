package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

public class EmplGrpRoleAssignForm extends ActionForm  {

    private String txtHidAction     ="";
    private String txtEmplNo        ="";
    private String txtEmplName      ="";
    private String txtHidUserLocId  ="";
    private String txtHidDisableButtons     ="";
    private String txtRole          ="";
    private String txtModule        ="";
    private ArrayList lstRoles      =null;
    private ArrayList lstModules    =null;
    private ArrayList lstGroupRows  =null;
    private String txtHidTotRowsGroups   ="";
    private String isGroupChecked   ="";
    private String[] txtHidGroupChecked=null;
    private ArrayList lstRoleRows  =null;
    private String txtHidTotRowsRole   ="";
    private String isRoleChecked   ="";
    private String[] txtHidRoleChecked=null;
    private String txtUserId="";
    private String txtLocId="";
    private String txtOpeningTime="";

    public void reSet() {
        txtHidAction     ="";
        txtEmplNo        ="";
        txtEmplName      ="";
        txtHidUserLocId  ="";
        txtHidDisableButtons     ="";
        txtRole          ="";
        txtModule        ="";
        lstRoles      =new ArrayList(1);
        lstModules    =new ArrayList(1);
        lstGroupRows  =new ArrayList(1);
        txtHidTotRowsGroups   ="";
        isGroupChecked   ="";
        txtHidGroupChecked=null;
        lstRoleRows  =new ArrayList(1);
        txtHidTotRowsRole   ="";
        isRoleChecked   ="";
        txtHidRoleChecked=null;
        txtUserId="";
        txtLocId="";
    }

    public EmplGrpRoleAssignForm() {
        lstRoles=new ArrayList(1);
        lstModules=new ArrayList(1);
        lstGroupRows=new ArrayList(1);
        lstRoleRows=new ArrayList(1);
    }
    

    public String getTxtEmplName() {
        return txtEmplName;
    }

    public void setTxtEmplName(String newTxtEmplName) {
        txtEmplName = newTxtEmplName;
    }

    public String getTxtEmplNo() {
        return txtEmplNo;
    }

    public void setTxtEmplNo(String newTxtEmplNo) {
        txtEmplNo = newTxtEmplNo;
    }

    public String getTxtHidAction() {
        return txtHidAction;
    }

    public void setTxtHidAction(String newTxtHidAction) {
        txtHidAction = newTxtHidAction;
    }

    public String getTxtHidDisableButtons() {
        return txtHidDisableButtons;
    }

    public void setTxtHidDisableButtons(String newTxtHidDisableButtons) {
        txtHidDisableButtons = newTxtHidDisableButtons;
    }

    public String getTxtHidUserLocId() {
        return txtHidUserLocId;
    }

    public void setTxtHidUserLocId(String newTxtHidUserLocId) {
        txtHidUserLocId = newTxtHidUserLocId;
    }

    public ArrayList getLstModules() {
        return lstModules;
    }

    public void setLstModules(ArrayList newLstModules) {
        lstModules = newLstModules;
    }

    public ArrayList getLstRoles() {
        return lstRoles;
    }

    public void setLstRoles(ArrayList newLstRoles) {
        lstRoles = newLstRoles;
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

    public String getIsGroupChecked() {
        return isGroupChecked;
    }

    public void setIsGroupChecked(String newIsGroupChecked) {
        isGroupChecked = newIsGroupChecked;
    }

    public ArrayList getLstGroupRows() {
        return lstGroupRows;
    }

    public void setLstGroupRows(ArrayList newLstGroupRows) {
        lstGroupRows = newLstGroupRows;
    }

    public String[] getTxtHidGroupChecked() {
        return txtHidGroupChecked;
    }

    public void setTxtHidGroupChecked(String[] newTxtHidGroupChecked) {
        txtHidGroupChecked = newTxtHidGroupChecked;
    }

    public String getTxtHidTotRowsGroups() {
        return txtHidTotRowsGroups;
    }

    public void setTxtHidTotRowsGroups(String newTxtHidTotRowsGroups) {
        txtHidTotRowsGroups = newTxtHidTotRowsGroups;
    }

    public String[] getTxtHidRoleChecked() {
        return txtHidRoleChecked;
    }

    public void setTxtHidRoleChecked(String[] newTxtHidRoleChecked) {
        txtHidRoleChecked = newTxtHidRoleChecked;
    }

    public String getTxtHidTotRowsRole() {
        return txtHidTotRowsRole;
    }

    public void setTxtHidTotRowsRole(String newTxtHidTotRowsRole) {
        txtHidTotRowsRole = newTxtHidTotRowsRole;
    }

    public String getIsRoleChecked() {
        return isRoleChecked;
    }

    public void setIsRoleChecked(String newIsRoleChecked) {
        isRoleChecked = newIsRoleChecked;
    }

    public ArrayList getLstRoleRows() {
        return lstRoleRows;
    }

    public void setLstRoleRows(ArrayList newLstRoleRows) {
        lstRoleRows = newLstRoleRows;
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

    public String getTxtOpeningTime() {
        return txtOpeningTime;
    }

    public void setTxtOpeningTime(String newTxtOpeningTime) {
        txtOpeningTime = newTxtOpeningTime;
    }

}