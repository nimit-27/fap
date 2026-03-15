package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;

public class MaintWrkSlipQueryVO extends PayrollBaseQueryVO implements Serializable 
{
  
    private String hdnWrkSlipId;
    private String txtSiteId;
    private String txtSiteName;
    private String hdnGangId;
    private String txtGangName;
    private String txtWrkSlipDt;
    private String txtYYMM;
  
    public MaintWrkSlipQueryVO()
    {
    }
  
    public String getHdnWrkSlipId()
    {
      return hdnWrkSlipId;
    }
    
    public void setHdnWrkSlipId(String newHdnWrkSlipId)
    {
      hdnWrkSlipId=newHdnWrkSlipId;
    }
    
    public String getTxtSiteId()
    {
      return txtSiteId;
    }
    
    public void setTxtSiteId(String newTxtSiteId)
    {
      txtSiteId=newTxtSiteId;
    }
    
    public String getTxtSiteName()
    {
      return txtSiteName;
    }
    
    public void setTxtSiteName(String newTxtSiteName)
    {
      txtSiteName=newTxtSiteName;
    }
    
    public String getHdnGangId()
    {
      return hdnGangId;
    }
    
    public void setHdnGangId(String newHdnGangId)
    {
      hdnGangId=newHdnGangId;
    }
    
    public String getTxtGangName()
    {
      return txtGangName;
    }
    
    public void setTxtGangName(String newTxtGangName)
    {
      txtGangName=txtGangName;
    }
    
    public String getTxtWrkSlipDt()
    {
      return txtWrkSlipDt;
    }
    
    public void setTxtWrkSlipDt(String newTxtWrkSlipDt)
    {
      txtWrkSlipDt=newTxtWrkSlipDt;
    }

    public String getTxtYYMM()
    {
      return txtYYMM;
    }
    
    public void setTxtYYMM(String newTxtYYMM)
    {
      txtYYMM=newTxtYYMM;
    }
    
}