package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class UserRespHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  public UserRespHeaderBean()
  {
  }
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