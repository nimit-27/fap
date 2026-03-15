package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class ZoneSurrQueryVO  extends PayrollBaseQueryVO implements Serializable
{
	private String txtEmpNo;
    private String txtUnitCode;
	private String txtCurrZone;
	private String txtNewZone;
    private String txtAppvSts;
    
	public String getTxtEmpNo() {
		return txtEmpNo;
	}
	public void setTxtEmpNo(String txtEmpNo) {
		this.txtEmpNo = txtEmpNo;
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
	public String getTxtNewZone() {
		return txtNewZone;
	}
	public void setTxtNewZone(String txtNewZone) {
		this.txtNewZone = txtNewZone;
	}
	public String getTxtAppvSts() {
		return txtAppvSts;
	}
	public void setTxtAppvSts(String txtAppvSts) {
		this.txtAppvSts = txtAppvSts;
	}
}