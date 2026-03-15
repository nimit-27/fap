package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class UserRespQueryVO  extends PayrollBaseQueryVO implements Serializable
{
	private String txtUserCode;
    private String txtMapLoc;
    
	public String getTxtUserCode() {
		return txtUserCode;
	}
	public void setTxtUserCode(String txtUserCode) {
		this.txtUserCode = txtUserCode;
	}
	public String getTxtMapLoc() {
		return txtMapLoc;
	}
	public void setTxtMapLoc(String txtMapLoc) {
		this.txtMapLoc = txtMapLoc;
	}
}