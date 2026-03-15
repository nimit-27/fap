package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MaintWrkSlipBean extends PayrollBaseDetailBean 
{
  
    private String txtNormTyp;
    //private String txtHndlngNorm;
    private String hdnHndlngNormId;
    private String hdnHndlngNormUnit;
    private String txtBags;
    private String hdnWrkSlipDtlId;
    private String txtSlab;
    private String txtOTHrs;
    private String hdnSlabId;
    private String txtEmpList;
    private String txtEmpNameList;
    private String txtStartHrs;
    private String txtStartMin;
    private String txtEndHrs;
    private String txtEndMin;
    private String txtBagTyp;
    private boolean chkContWork;
    private String hdnContWork;
    
    public MaintWrkSlipBean()
    {
    }
    
    public String getTxtNormTyp()
    {
      return txtNormTyp;
    }
    
    public void setTxtNormTyp(String newTxtNormTyp)
    {
      txtNormTyp=newTxtNormTyp;
    }
    
    /*public String getTxtHndlngNorm()
    {
      return txtHndlngNorm;
    }
    
    public void setTxtHndlngNorm(String newTxtHndlngNorm)
    {
      txtHndlngNorm=newTxtHndlngNorm;
    }*/
    
    public String getTxtBags()
    {
      return txtBags;
    }
    
    public void setTxtBags(String newTxtBags)
    {
      txtBags=newTxtBags;
    }
    
    public String getHdnWrkSlipDtlId()
    {
      return hdnWrkSlipDtlId;
    }
    
    public void setHdnWrkSlipDtlId(String newHdnWrkSlipDtlId)
    {
      hdnWrkSlipDtlId=newHdnWrkSlipDtlId;
    }

    public String getHdnHndlngNormId()
    {
      return hdnHndlngNormId;
    }
    
    public void setHdnHndlngNormId(String newHdnHndlngNormId)
    {
      hdnHndlngNormId=newHdnHndlngNormId;
    }

    public String getHdnHndlngNormUnit()
    {
      return hdnHndlngNormUnit;
    }
    
    public void setHdnHndlngNormUnit(String newHdnHndlngNormUnit)
    {
      hdnHndlngNormUnit=newHdnHndlngNormUnit;
    }

    public String getTxtSlab()
    {
      return txtSlab;
    }
    
    public void setTxtSlab(String newTxtSlab)
    {
      txtSlab=newTxtSlab;
    }
    
    public String getTxtOTHrs()
    {
      return txtOTHrs;
    }
    
    public void setTxtOTHrs(String newTxtOTHrs)
    {
      txtOTHrs=newTxtOTHrs;
    }

    public String getHdnSlabId()
    {
      return hdnSlabId;
    }
    
    public void setHdnSlabId(String newHdnSlabId)
    {
      hdnSlabId=newHdnSlabId;
    }

    public String getTxtEmpList()
    {
      return txtEmpList;
    }
    
    public void setTxtEmpList(String newTxtEmpList)
    {
      txtEmpList=newTxtEmpList;
    }
    
    public String getTxtEmpNameList()
    {
      return txtEmpNameList;
    }
    
    public void setTxtEmpNameList(String newTxtEmpNameList)
    {
      txtEmpNameList=newTxtEmpNameList;
    }

    public String getTxtStartHrs()
    {
      return txtStartHrs;
    }
    
    public void setTxtStartHrs(String newTxtStartHrs)
    {
      txtStartHrs=newTxtStartHrs;
    }
    
    public String getTxtStartMin()
    {
      return txtStartMin;
    }
    
    public void setTxtStartMin(String newTxtStartMin)
    {
      txtStartMin=newTxtStartMin;
    }
    
    public String getTxtEndHrs()
    {
      return txtEndHrs;
    }
    
    public void setTxtEndHrs(String newTxtEndHrs)
    {
      txtEndHrs=newTxtEndHrs;
    }
    
    public String getTxtEndMin()
    {
      return txtEndMin;
    }
    
    public void setTxtEndMin(String newTxtEndMin)
    {
      txtEndMin=newTxtEndMin;
    }

    public String getTxtBagTyp()
    {
      return txtBagTyp;
    }
    
    public void setTxtBagTyp(String newTxtBagTyp)
    {
      txtBagTyp=newTxtBagTyp;
    }

    public boolean getChkContWork()
    {
      return chkContWork;
    }
    
    public void setChkContWork(boolean newChkContWork)
    {
      chkContWork=newChkContWork;
    }
    
    public String getHdnContWork()
    {
      return hdnContWork;
    }
    
    public void setHdnContWork(String newHdnContWork)
    {
      hdnContWork=newHdnContWork;
    }
}