package FCIPAY.COMMON.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import java.util.ArrayList;

public class RespCreatUpdtForm  extends PayrollBaseForm
{
    private ArrayList lstInstrDtls=new ArrayList();
    private ArrayList headerList=new ArrayList();
    private String hdnAction="";
    private String hdnRespId;
    private String txtRespName;
    private String txtRespEndDt;
    private String lstModule="";
    private String lstHeader;
    private String [] txtLevel1;
    private String [] txtLevel2;
    private String [] txtScrEndDt; 
    private String [] hdnScreenId;
    
    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }
    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls=newLstInstrDtls;
    }
    
    public String getHdnAction()
    {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction)
    {
        hdnAction = newHdnAction;
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
   
    public ArrayList getHeaderList() 
    {
        return headerList;
    }

    public void setHeaderList(ArrayList newHeaderList) 
    {
        headerList = newHeaderList;
    }
    
    public String getLstHeader()
    {
        return lstHeader;
    }

    public void setLstHeader(String newLstHeader) 
    {
        lstHeader = newLstHeader;
    }
    
    public String[] getTxtLevel1() {
		return txtLevel1;
	}
	public void setTxtLevel1(String[] txtLevel1) {
		this.txtLevel1 = txtLevel1;
	}
	public String[] getTxtLevel2() {
		return txtLevel2;
	}
	public void setTxtLevel2(String[] txtLevel2) {
		this.txtLevel2 = txtLevel2;
	}
	public String[] getTxtScrEndDt() {
		return txtScrEndDt;
	}
	public void setTxtScrEndDt(String[] txtScrEndDt) {
		this.txtScrEndDt = txtScrEndDt;
	} 
	public String[] getHdnScreenId() {
		return hdnScreenId;
	}

	public void setHdnScreenId(String[] hdnScreenId) {
		this.hdnScreenId = hdnScreenId;
	}    
    
    public String getHdnRespId() {
		return hdnRespId;
	}
	public void setHdnRespId(String hdnRespId) {
		this.hdnRespId = hdnRespId;
	}
	public String getTxtRespName() {
		return txtRespName;
	}
	public void setTxtRespName(String txtRespName) {
		this.txtRespName = txtRespName;
	}
}
