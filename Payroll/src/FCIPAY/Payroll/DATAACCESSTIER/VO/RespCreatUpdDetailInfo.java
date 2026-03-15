package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class RespCreatUpdDetailInfo extends BaseDetailInfo implements Serializable 
{
    private String hdnRespId;
    private String txtRespName;
    private String txtRespEndDt;
    private String lstModule="";
    private String lstHeader;
    
    public RespCreatUpdDetailInfo()
    {
    }
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
    
    public String getLstModule() 
    {
        return lstModule;
    }

    public void setLstModule(String newLstModule) {
        lstModule = newLstModule;
    }
    
   
    public String getLstHeader()
    {
        return lstHeader;
    }

    public void setLstHeader(String newLstHeader) 
    {
        lstHeader = newLstHeader;
    }
}