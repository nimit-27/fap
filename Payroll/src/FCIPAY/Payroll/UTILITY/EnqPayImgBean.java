package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class EnqPayImgBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtPayCode="";
  private String txtDesc="";
  private String txtSrlNo="";
  private String txtPayMode="";
  private String txtAmt="";
  private String txtPayCode1="";
  private String txtDesc1="";
  private String txtSrlNo1="";
  private String txtPayMode1="";
  private String txtAmt1="";

  public EnqPayImgBean()
  {
  }

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtDesc()
  {
    return txtDesc;
  }

  public void setTxtDesc(String newTxtDesc)
  {
    txtDesc = newTxtDesc;
  }

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }

  public String getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }
	public String getTxtPayCode1() {
		return txtPayCode1;
	}
	public void setTxtPayCode1(String txtPayCode1) {
		this.txtPayCode1 = txtPayCode1;
	}
	public String getTxtDesc1() {
		return txtDesc1;
	}
	public void setTxtDesc1(String txtDesc1) {
		this.txtDesc1 = txtDesc1;
	}
	public String getTxtSrlNo1() {
		return txtSrlNo1;
	}
	public void setTxtSrlNo1(String txtSrlNo1) {
		this.txtSrlNo1 = txtSrlNo1;
	}
	public String getTxtPayMode1() {
		return txtPayMode1;
	}
	public void setTxtPayMode1(String txtPayMode1) {
		this.txtPayMode1 = txtPayMode1;
	}
	public String getTxtAmt1() {
		return txtAmt1;
	}
	public void setTxtAmt1(String txtAmt1) {
		this.txtAmt1 = txtAmt1;
	}
}