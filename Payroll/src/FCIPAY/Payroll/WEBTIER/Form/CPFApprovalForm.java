package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class CPFApprovalForm extends PayrollBaseForm 
{
    private ArrayList lstInstrDtls=new ArrayList();
    private String txtEmpNo;
    private String txtEmpName;
    private String txtCPFCode;
    private String txtAppvSts;
    private String txtUnitCode;
    private String txtUnitDesc;
    private String [] txtApprId;
    private String [] txtSrNo;
    private String [] txtEmpNo1;
    private String [] txtEmpName1;
    private String [] txtPOP;
    private String [] txtFpsNum;
    private String [] txtOldCpf;
    private String [] txtNewCpf;
    private String [] txtRequester;
    private String [] txtReqDate;
    private String [] txtReqReason;
    private String [] txtAppvSts1;
    private String [] txtRemark;
    private String [] txtReqZone;
    private String [] txtApprDt;
    private String [] txtReqGenFrm;
    private String [] txtReqZoneDesc;
    
    public String[] getTxtApprId() {
        return txtApprId;
    }
    
    public void setTxtApprId(String[] txtApprId) {
        this.txtApprId = txtApprId;
    }
    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }
    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls=newLstInstrDtls;
    }
	public String getTxtEmpNo() {
		return txtEmpNo;
	}
	public void setTxtEmpNo(String txtEmpNo) {
		this.txtEmpNo = txtEmpNo;
	}
	public String getTxtEmpName() {
		return txtEmpName;
	}
	public void setTxtEmpName(String txtEmpName) {
		this.txtEmpName = txtEmpName;
	}
	public String getTxtCPFCode() {
		return txtCPFCode;
	}
	public void setTxtCPFCode(String txtCPFCode) {
		this.txtCPFCode = txtCPFCode;
	}
	public String getTxtAppvSts() {
		return txtAppvSts;
	}
	public void setTxtAppvSts(String txtAppvSts) {
		this.txtAppvSts = txtAppvSts;
	}
	public String getTxtUnitCode() {
		return txtUnitCode;
	}
	public void setTxtUnitCode(String txtUnitCode) {
		this.txtUnitCode = txtUnitCode;
	}
	public String getTxtUnitDesc() {
		return txtUnitDesc;
	}
	public void setTxtUnitDesc(String txtUnitDesc) {
		this.txtUnitDesc = txtUnitDesc;
	}
	public String[] getTxtSrNo() {
		return txtSrNo;
	}
	public void setTxtSrNo(String[] txtSrNo) {
		this.txtSrNo = txtSrNo;
	}
	public String[] getTxtEmpNo1() {
		return txtEmpNo1;
	}
	public void setTxtEmpNo1(String[] txtEmpNo1) {
		this.txtEmpNo1 = txtEmpNo1;
	}
	public String[] getTxtEmpName1() {
		return txtEmpName1;
	}
	public void setTxtEmpName1(String[] txtEmpName1) {
		this.txtEmpName1 = txtEmpName1;
	}
	public String[] getTxtPOP() {
		return txtPOP;
	}
	public void setTxtPOP(String[] txtPOP) {
		this.txtPOP = txtPOP;
	}
	public String[] getTxtFpsNum() {
		return txtFpsNum;
	}
	public void setTxtFpsNum(String[] txtFpsNum) {
		this.txtFpsNum = txtFpsNum;
	}
	public String[] getTxtOldCpf() {
		return txtOldCpf;
	}
	public void setTxtOldCpf(String[] txtOldCpf) {
		this.txtOldCpf = txtOldCpf;
	}
	public String[] getTxtNewCpf() {
		return txtNewCpf;
	}
	public void setTxtNewCpf(String[] txtNewCpf) {
		this.txtNewCpf = txtNewCpf;
	}
	public String[] getTxtRequester() {
		return txtRequester;
	}
	public void setTxtRequester(String[] txtRequester) {
		this.txtRequester = txtRequester;
	}
	public String[] getTxtReqDate() {
		return txtReqDate;
	}
	public void setTxtReqDate(String[] txtReqDate) {
		this.txtReqDate = txtReqDate;
	}
	public String[] getTxtReqReason() {
		return txtReqReason;
	}
	public void setTxtReqReason(String[] txtReqReason) {
		this.txtReqReason = txtReqReason;
	}
	public String[] getTxtAppvSts1() {
		return txtAppvSts1;
	}
	public void setTxtAppvSts1(String[] txtAppvSts1) {
		this.txtAppvSts1 = txtAppvSts1;
	}
	public String[] getTxtRemark() {
		return txtRemark;
	}
	public void setTxtRemark(String[] txtRemark) {
		this.txtRemark = txtRemark;
	}
	public String[] getTxtReqZone() {
		return txtReqZone;
	}
	public void setTxtReqZone(String[] txtReqZone) {
		this.txtReqZone = txtReqZone;
	}
	public String[] getTxtApprDt() {
		return txtApprDt;
	}
	public void setTxtApprDt(String[] txtApprDt) {
		this.txtApprDt = txtApprDt;
	}
    public String[] getTxtReqGenFrm() {
		return txtReqGenFrm;
	}
	public void setTxtReqGenFrm(String[] txtReqGenFrm) {
		this.txtReqGenFrm = txtReqGenFrm;
	}
	public String[] getTxtReqZoneDesc() {
		return txtReqZoneDesc;
	}
	public void setTxtReqZoneDesc(String[] txtReqZoneDesc) {
		this.txtReqZoneDesc = txtReqZoneDesc;
	}    
}