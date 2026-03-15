package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class ResponsibilityCreationHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  public ResponsibilityCreationHeaderBean()
  {
  }   
    private String txtRespName;
    private String txtRespEndDt;
    private String hdnRespId;
    private String lstModule="";
    private String lstHeader;
 
  public String getHdnRespId() {
		return hdnRespId;
	}
  public void setHdnRespId(String hdnRespId) {
  	this.hdnRespId = hdnRespId;
  }
  public String getTxtRespName()
  {
    return txtRespName;
  }
  public void setTxtRespName(String newTxtRespName)
  {
    txtRespName = newTxtRespName;
  }

  public String getTxtRespEndDt()
  {
    return txtRespEndDt;
  }
  public void setTxtRespEndDt(String newTxtRespEndDt)
  {
    txtRespEndDt = newTxtRespEndDt;
  }
    public String getLstHeader()
    {
        return lstHeader;
    }

    public void setLstHeader(String newLstHeader) 
    {
        lstHeader = newLstHeader;
    }
    public String getLstModule() 
    {
        return lstModule;
    }

    public void setLstModule(String newLstModule) {
        lstModule = newLstModule;
    }
}