package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintWrkSlipHeaderBean extends PayrollBaseHeaderBean 
{
  
    private String hdnWrkSlipId;
    private String txtSiteId;
    private String txtSiteName;
    private String txtSite;        // added by dushyant on 10-03-2011
    private String hdnGangId;
    private String txtGangName;
    private String txtWrkSlipDt;
    private String hdnMou;
    private String txtYYMM;
  
    public MaintWrkSlipHeaderBean()
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
      txtGangName=newTxtGangName;
    }
    
    public String getTxtWrkSlipDt()
    {
      return txtWrkSlipDt;
    }
    
    public void setTxtWrkSlipDt(String newTxtWrkSlipDt)
    {
      txtWrkSlipDt=newTxtWrkSlipDt;
    }
    
    public String getHdnMou()
    {
      return hdnMou;
    }
    
    public void setHdnMou(String newHdnMou)
    {
      hdnMou=newHdnMou;
    }
    
    public String getTxtYYMM()
    {
      return txtYYMM;
    }
    
    public void setTxtYYMM(String newTxtYYMM)
    {
      txtYYMM=newTxtYYMM;
    }
 // added by dushaynt on 10-03-2011
  public String getTxtSite()
    {
      return txtSite;
    }
    
    public void setTxtSite(String newTxtSite)
    {
      txtSite=newTxtSite;
    }
  // added by dushaynt on 10-03-2011   
}