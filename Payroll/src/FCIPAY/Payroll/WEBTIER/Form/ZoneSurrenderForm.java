package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ZoneSurrenderForm extends PayrollBaseForm 
{
    private ArrayList lstInstrDtls=new ArrayList();
	private String txtEmpNo;
	private String txtRetrDt;
	private String txtEmpName;
	private String txtStaffCode;
	private String txtCPFCode;
	private String txtUnitDesc;
    private String txtUnitCode;
	private String txtCurrZone;
	private String txtCurrZoneDesc;
	private String txtNewZone;
	private String txtSurrRsn;
    private String txtAppvSts;
    
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
	public String getTxtRetrDt() {
		return txtRetrDt;
	}
	public void setTxtRetrDt(String txtRetrDt) {
		this.txtRetrDt = txtRetrDt;
	}
	public String getTxtEmpName() {
		return txtEmpName;
	}
	public void setTxtEmpName(String txtEmpName) {
		this.txtEmpName = txtEmpName;
	}
	public String getTxtStaffCode() {
		return txtStaffCode;
	}
	public void setTxtStaffCode(String txtStaffCode) {
		this.txtStaffCode = txtStaffCode;
	}
	public String getTxtCPFCode() {
		return txtCPFCode;
	}
	public void setTxtCPFCode(String txtCPFCode) {
		this.txtCPFCode = txtCPFCode;
	}
	public String getTxtUnitDesc() {
		return txtUnitDesc;
	}
	public void setTxtUnitDesc(String txtUnitDesc) {
		this.txtUnitDesc = txtUnitDesc;
	}
	public String getTxtUnitCode() {
		return txtUnitCode;
	}
	public void setTxtUnitCode(String txtUnitCode) {
		this.txtUnitCode = txtUnitCode;
	}
	public String getTxtCurrZone() {
		return txtCurrZone;
	}
	public void setTxtCurrZone(String txtCurrZone) {
		this.txtCurrZone = txtCurrZone;
	}
	public String getTxtCurrZoneDesc() {
		return txtCurrZoneDesc;
	}
	public void setTxtCurrZoneDesc(String txtCurrZoneDesc) {
		this.txtCurrZoneDesc = txtCurrZoneDesc;
	}
	public String getTxtNewZone() {
		return txtNewZone;
	}
	public void setTxtNewZone(String txtNewZone) {
		this.txtNewZone = txtNewZone;
	}
	public String getTxtSurrRsn() {
		return txtSurrRsn;
	}
	public void setTxtSurrRsn(String txtSurrRsn) {
		this.txtSurrRsn = txtSurrRsn;
	}
	public String getTxtAppvSts() {
		return txtAppvSts;
	}
	public void setTxtAppvSts(String txtAppvSts) {
		this.txtAppvSts = txtAppvSts;
	}

}