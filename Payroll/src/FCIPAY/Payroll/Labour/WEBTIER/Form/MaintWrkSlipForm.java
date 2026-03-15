package FCIPAY.Payroll.Labour.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import java.util.ArrayList;

public class MaintWrkSlipForm extends PayrollBaseForm 
{

    private ArrayList lstInstrDtls=new ArrayList();
    private String hdnWrkSlipId;
    private String txtSiteId;
    private String txtSiteName;
    private String hdnGangId;
    private String txtGangName;
    private String txtSite;    // added by dushyant on 10-03-2011
    private String txtWrkSlipDt;
    private String hdnMou;
    private String txtYYMM;
    private String [] txtNormTyp;
    private String [] txtHndlngNorm;
    private String [] hdnHndlngNormId;
    private String [] txtBags;
    private String [] hdnWrkSlipDtlId;
    private String [] txtSlab;
    private String [] txtOTHrs;
    private String [] txtBagTyp;
    private String [] hdnSlabId;
    private String [] txtEmpList;
    private String [] txtEmpNameList;
    private String [] txtStartHrs;
    private String [] txtStartMin;
    private String [] txtEndHrs;
    private String [] txtEndMin;
    private String [] hdnHndlngNormUnit;
    private boolean [] chkContWork;
    private String [] hdnContWork;
    
    public ArrayList getLstInstrDtls()
    {
      return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
      lstInstrDtls = newLstInstrDtls;
    }
    
    public String getHdnWrkSlipId()
    {
      return hdnWrkSlipId;
    }
    
    public void setHdnWrkSlipId(String newHdnWrkSlipId)
    {
      hdnWrkSlipId=newHdnWrkSlipId;
    }

    public String getHdnMou()
    {
      return hdnMou;
    }
    
    public void setHdnMou(String newHdnMou)
    {
      hdnMou=newHdnMou;
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

    public String getTxtYYMM()
    {
      return txtYYMM;
    }
    
    public void setTxtYYMM(String newTxtYYMM)
    {
      txtYYMM=newTxtYYMM;
    }
    
    public String [] getTxtNormTyp()
    {
      return txtNormTyp;
    }
    
    public void setTxtNormTyp(String [] newTxtNormTyp)
    {
      txtNormTyp=newTxtNormTyp;
    }
    
    public String [] getTxtHndlngNorm()
    {
      return txtHndlngNorm;
    }
    
    public void setTxtHndlngNorm(String [] newTxtHndlngNorm)
    {
      txtHndlngNorm=newTxtHndlngNorm;
    }

    public String [] getHdnHndlngNormId()
    {
      return hdnHndlngNormId;
    }
    
    public void setHdnHndlngNormId(String [] newHdnHndlngNormId)
    {
      hdnHndlngNormId=newHdnHndlngNormId;
    }

    public String [] getHdnHndlngNormUnit()
    {
      return hdnHndlngNormUnit;
    }
    
    public void setHdnHndlngNormUnit(String [] newHdnHndlngNormUnit)
    {
      hdnHndlngNormUnit=newHdnHndlngNormUnit;
    }
    
    public String [] getTxtBags()
    {
      return txtBags;
    }
    
    public void setTxtBags(String[] newTxtBags)
    {
      txtBags=newTxtBags;
    }
    
    public String [] getHdnWrkSlipDtlId()
    {
      return hdnWrkSlipDtlId;
    }
    
    public void setHdnWrkSlipDtlId(String [] newHdnWrkSlipDtlId)
    {
      hdnWrkSlipDtlId=newHdnWrkSlipDtlId;
    }

    public String [] getTxtSlab()
    {
      return txtSlab;
    }
    
    public void setTxtSlab(String [] newTxtSlab)
    {
      txtSlab=newTxtSlab;
    }
    
    public String [] getTxtOTHrs()
    {
      return txtOTHrs;
    }
    
    public void setTxtOTHrs(String [] newTxtOTHrs)
    {
      txtOTHrs=newTxtOTHrs;
    }
    
    public String [] getTxtBagTyp()
    {
      return txtBagTyp;
    }
    
    public void setTxtBagTyp(String [] newTxtBagTyp)
    {
      txtBagTyp=newTxtBagTyp;
    }
    
    public String [] getHdnSlabId()
    {
      return hdnSlabId;
    }
    
    public void setHdnSlabId(String [] newHdnSlabId)
    {
      hdnSlabId=newHdnSlabId;
    }
    
    public String [] getTxtEmpList()
    {
      return txtEmpList;
    }
    
    public void setTxtEmpList(String [] newTxtEmpList)
    {
      txtEmpList=newTxtEmpList;
    }

    public String [] getTxtEmpNameList()
    {
      return txtEmpNameList;
    }
    
    public void setTxtEmpNameList(String [] newTxtEmpNameList)
    {
      txtEmpNameList=newTxtEmpNameList;
    }
    
    public String [] getTxtStartHrs()
    {
      return txtStartHrs;
    }
    
    public void setTxtStartHrs(String [] newTxtStartHrs)
    {
      txtStartHrs=newTxtStartHrs;
    }
    
    public String [] getTxtStartMin()
    {
      return txtStartMin;
    }
    
    public void setTxtStartMin(String [] newTxtStartMin)
    {
      txtStartMin=newTxtStartMin;
    }
    
    public String [] getTxtEndHrs()
    {
      return txtEndHrs;
    }
    
    public void setTxtEndHrs(String [] newTxtEndHrs)
    {
      txtEndHrs=newTxtEndHrs;
    }
    
    public String [] getTxtEndMin()
    {
      return txtEndMin;
    }
    
    public void setTxtEndMin(String [] newTxtEndMin)
    {
      txtEndMin=newTxtEndMin;
    }
    
 // added by dushyant on 10-03-2011
        public String getTxtSite()
    {
      return txtSite;
    }
    
    public void setTxtSite(String newTxtSite)
    {
      txtSite=newTxtSite;
    }    
 // added by dushyant on 10-03-2011
    public boolean [] getChkContWork()
    {
      return chkContWork;
    }
    
    public void setChkContWork(boolean [] newChkContWork)
    {
      chkContWork=newChkContWork;
    }

    public String [] getHdnContWork()
    {
      return hdnContWork;
    }
    
    public void setHdnContWork(String [] newHdnContWork)
    {
      hdnContWork=newHdnContWork;
    }
}