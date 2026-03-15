package FCIPAY.Payroll.UTILITY;

public class ResponsCreaBean  extends PayrollBaseDetailBean
{
  public ResponsCreaBean()
  {
  }
    private String txtLevel1;
    private String txtLevel2;
    private String txtScrEndDt;
    private String hdnScreenId;
    
	public String getTxtLevel1() {
		return txtLevel1;
	}
	public void setTxtLevel1(String txtLevel1) {
		this.txtLevel1 = txtLevel1;
	}
	public String getTxtLevel2() {
		return txtLevel2;
	}
	public void setTxtLevel2(String txtLevel2) {
		this.txtLevel2 = txtLevel2;
	}
	public String getTxtScrEndDt() {
		return txtScrEndDt;
	}
	public void setTxtScrEndDt(String txtScrEndDt) {
		this.txtScrEndDt = txtScrEndDt;
	}
	public String getHdnScreenId() {
		return hdnScreenId;
	}

	public void setHdnScreenId(String hdnScreenId) {
		this.hdnScreenId = hdnScreenId;
	}
		    
}