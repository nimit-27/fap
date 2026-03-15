package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class EmpPrmsReportForm extends PayrollBaseForm
{
  private String txtFinYear;
  private String txtRepMode;
  private String optSelect;
  private String hdnPayUser;
  private String hdnLoginUserId;
  private String hdnLoginUserName;
  private String PaySlipLocationForm;
  private String txtAllEmpFlag;
  private String txtEmpNum;
  private String txtEmpName;
  private String txtCpfCode;   //Added By Swapnendu Dt 16/08/2010.
  private String hdnMaxYYMM;
  private String txtLocId;
  private String txtGangId;
  private String txtGangName;
  private String txtType;
  private String txtMou;

  private String txtLoc;   //added by jatin dt 19/07/2012

  public EmpPrmsReportForm()
  {
  }

    public void setTxtFinYear(String txtFinYear) {
        this.txtFinYear = txtFinYear;
    }

    public String getTxtFinYear() {
        return txtFinYear;
    }

    public void setOptSelect(String optSelect) {
        this.optSelect = optSelect;
    }

    public String getOptSelect() {
        return optSelect;
    }

    public void setHdnPayUser(String hdnPayUser) {
        this.hdnPayUser = hdnPayUser;
    }

    public String getHdnPayUser() {
        return hdnPayUser;
    }

    public void setHdnLoginUserId(String hdnLoginUserId) {
        this.hdnLoginUserId = hdnLoginUserId;
    }

    public String getHdnLoginUserId() {
        return hdnLoginUserId;
    }

    public void setHdnLoginUserName(String hdnLoginUserName) {
        this.hdnLoginUserName = hdnLoginUserName;
    }

    public String getHdnLoginUserName() {
        return hdnLoginUserName;
    }

    public void setPaySlipLocationForm(String PaySlipLocationForm) {
        this.PaySlipLocationForm = PaySlipLocationForm;
    }

    public String getPaySlipLocationForm() {
        return PaySlipLocationForm;
    }

    public void setTxtAllEmpFlag(String txtAllEmpFlag) {
        this.txtAllEmpFlag = txtAllEmpFlag;
    }

    public String getTxtAllEmpFlag() {
        return txtAllEmpFlag;
    }

    public void setTxtEmpNum(String txtEmpNum) {
        this.txtEmpNum = txtEmpNum;
    }

    public String getTxtEmpNum() {
        return txtEmpNum;
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

    public void setHdnMaxYYMM(String hdnMaxYYMM) {
        this.hdnMaxYYMM = hdnMaxYYMM;
    }

    public String getHdnMaxYYMM() {
        return hdnMaxYYMM;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setTxtGangId(String txtGangId) {
        this.txtGangId = txtGangId;
    }

    public String getTxtGangId() {
        return txtGangId;
    }

    public void setTxtGangName(String txtGangName) {
        this.txtGangName = txtGangName;
    }

    public String getTxtGangName() {
        return txtGangName;
    }

    public void setTxtType(String txtType) {
        this.txtType = txtType;
    }

    public String getTxtType() {
        return txtType;
    }

    public void setTxtMou(String txtMou) {
        this.txtMou = txtMou;
    }

    public String getTxtMou() {
        return txtMou;
    }

    public void setTxtLoc(String txtLoc) {
        this.txtLoc = txtLoc;
    }

    public String getTxtLoc() {
        return txtLoc;
    }

    public void setTxtRepMode(String txtRepMode) {
        this.txtRepMode = txtRepMode;
    }

    public String getTxtRepMode() {
        return txtRepMode;
    }
}
