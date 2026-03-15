package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class ComFinalHeaderBean extends PayrollBaseHeaderBean implements Serializable
{

  private String txtEmpNo;
  private String txtEmpName;
  private String txtCpfCode;
  private String txtDsgn;
  private String txtDsgnDesc;
  private String txtCateg;
  private String txtCategDesc;
  private String txtEmpType;
  private String txtPresentPOP;
  private String txtPresentPOPDesc;
  private String txtDOJSite;
  private String txtEmpStatus;
  
  private String txtDate;
  private String txtSepTyp;
  private String txtDepOrg;
  private String txtLien;  
  private String txtflagITDetail;
  private String txtLeaveEncaSancNo;
  private String txtNoAccELd;
  private String txtLeaveEncaSancDt;
  private String txtLeaveEncaSancAmt;
  private String txtLeave;
  private String txtLeavePaidAmt;  
  
  
  private String txtHPLEncaSancNo;
  private String txtHPLNoAccEld;
  private String txtHPLEncaSancDt;
  private String txtHPLEncaSancAmt;
  private String txtHPLNetAmt;
  
  private String txtGraSancNo;
  private String txtGratuity;
  private String txtGraSancDt;
  private String txtGraSancAmt;
  private String txtGraPaidAmt;
  
  private boolean graFlag;
  private String txtVrsSancNo;
  private String txtVrsSancDt;
  private String txtVrsGrossAmt;
  private String txtVrsNetAmt;
  private String txtNetEarning;
  
  private String txtTotDed;
  private String txtOutDed;
  
  private String txtApplnDt;
  private String hdnDayWage;
  
  private String txtLastSalInv;
  private String txtLeaveEncInv;
  private String txtGratuityInv;
  private String txtOutStandInv;
  private String txtHPLEncInv;
  private String txtVrsInv;
  private String txtIncentiveAmt;
  private String txtIncentiveInv;
  
  //added by geetika on 24-01-2014
  private String txtIfGratuityChng;
   private String chkEditSepEntry;
  
  
  public ComFinalHeaderBean()
  {
  }
  public String getChkEditSepEntry()
  {
      return chkEditSepEntry;
  }
  
  public void setChkEditSepEntry(String newChkEditSepEntry)
  {
      chkEditSepEntry=newChkEditSepEntry;
  }


  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }
  
  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }  

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
  
  public String getTxtDsgn()
  {
    return txtDsgn;
  }
  
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }

  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtCategDesc()
  {
    return txtCategDesc;
  }

  public void setTxtCategDesc(String newTxtCategDesc)
  {
    txtCategDesc = newTxtCategDesc;
  }
  
  public String getTxtEmpType()
  {
    return txtEmpType;
  }

  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }  

  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }  

  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  public String getTxtPresentPOPDesc()
  {
    return txtPresentPOPDesc;
  }

  public void setTxtPresentPOPDesc(String newTxtPresentPOPDesc)
  {
    txtPresentPOPDesc = newTxtPresentPOPDesc;
  }

  public String getTxtDOJSite()
  {
    return txtDOJSite;
  }

  public void setTxtDOJSite(String newTxtDOJSite)
  {
    txtDOJSite = newTxtDOJSite;
  }

  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
 

  public String getTxtDate()
  {
    return txtDate;
  }

  public void setTxtDate(String newTxtDate)
  {
    txtDate = newTxtDate;
  }

  public String getTxtSepTyp()
  {
    return txtSepTyp;
  }

  public void setTxtSepTyp(String newTxtSepTyp)
  {
    txtSepTyp = newTxtSepTyp;
  }

  public String getTxtDepOrg()
  {
    return txtDepOrg;
  }

  public void setTxtDepOrg(String newTxtDepOrg)
  {
    txtDepOrg = newTxtDepOrg;
  }

  public String getTxtGraSancDt()
  {
    return txtGraSancDt;
  }

  public void setTxtGraSancDt(String newTxtGraSancDt)
  {
    txtGraSancDt = newTxtGraSancDt;
  }
  
  public String getTxtGraSancNo()
  {
    return txtGraSancNo;
  }

  public void setTxtGraSancNo(String newTxtGraSancNo)
  {
    txtGraSancNo = newTxtGraSancNo;
  }
  
  public String getTxtLeaveEncaSancNo()
  {
    return txtLeaveEncaSancNo;
  }

  public void setTxtLeaveEncaSancNo(String newTxtLeaveEncaSancNo)
  {
    txtLeaveEncaSancNo = newTxtLeaveEncaSancNo;
  }

  public void setTxtGraSancAmt(String newTxtGraSancAmt)
  {
    txtGraSancAmt = newTxtGraSancAmt;
  }
  
  public String getTxtGraSancAmt()
  {
    return txtGraSancAmt;
  }
  
  public String getTxtLeaveEncaSancDt()
  {
    return txtLeaveEncaSancDt;
  }

  public void setTxtLeaveEncaSancDt(String newTxtLeaveEncaSancDt)
  {
    txtLeaveEncaSancDt = newTxtLeaveEncaSancDt;
  }
  
  public String getTxtLeaveEncaSancAmt()
  {
    return txtLeaveEncaSancAmt;
  }

  public void setTxtLeaveEncaSancAmt(String newTxtLeaveEncaSancAmt)
  {
    txtLeaveEncaSancAmt = newTxtLeaveEncaSancAmt;
  }

  public String getTxtNoAccELd()
  {
    return txtNoAccELd;
  }

  public void setTxtNoAccELd(String newTxtNoAccELd)
  {
    txtNoAccELd = newTxtNoAccELd;
  }


  public String getTxtTotDed()
  {
    return txtTotDed;
  }

  public void setTxtTotDed(String newTxtTotDed)
  {
    txtTotDed = newTxtTotDed;
  }

  public String getTxtOutDed()
  {
    return txtOutDed;
  }

  public void setTxtOutDed(String newTxtOutDed)
  {
    txtOutDed = newTxtOutDed;
  }

  public String getTxtGratuity()
  {
    return txtGratuity;
  }

  public void setTxtGratuity(String newTxtGratuity)
  {
    txtGratuity = newTxtGratuity;
  }

  public String getTxtLeave()
  {
    return txtLeave;
  }

  public void setTxtLeave(String newTxtLeave)
  {
    txtLeave = newTxtLeave;
  }

  public boolean getGraFlag()
  {
    return graFlag;
  }

  public void setGraFlag(boolean newGraFlag)
  {
    graFlag = newGraFlag;
  }

  public String getTxtGraPaidAmt()
  {
    return txtGraPaidAmt;
  }

  public void setTxtGraPaidAmt(String newTxtGraPaidAmt)
  {
    txtGraPaidAmt = newTxtGraPaidAmt;
  }

  public String getTxtLeavePaidAmt()
  {
    return txtLeavePaidAmt;
  }

  public void setTxtLeavePaidAmt(String newTxtLeavePaidAmt)
  {
    txtLeavePaidAmt = newTxtLeavePaidAmt;
  }

  public String getTxtLien()
  {
    return txtLien;
  }

  public void setTxtLien(String newTxtLien)
  {
    txtLien = newTxtLien;
  }

  public String getTxtNetEarning()
  {
    return txtNetEarning;
  }

  public void setTxtNetEarning(String newTxtNetEarning)
  {
    txtNetEarning = newTxtNetEarning;
  }

  public String getHdnDayWage()
  {
    return hdnDayWage;
  }

  public void setHdnDayWage(String newHdnDayWage)
  {
    hdnDayWage = newHdnDayWage;
  }


 public String getTxtHPLEncaSancDt()
  {
    return txtHPLEncaSancDt;
  }

  public void setTxtHPLEncaSancDt(String newTxtHPLEncaSancDt)
  {
    txtHPLEncaSancDt = newTxtHPLEncaSancDt;
  }



 public String getTxtHPLEncaSancNo()
  {
    return txtHPLEncaSancNo;
  }

  public void setTxtHPLEncaSancNo(String newTxtHPLEncaSancNo)
  {
    txtHPLEncaSancNo = newTxtHPLEncaSancNo;
  }
  
  
  public String getTxtHPLEncaSancAmt()
  {
    return txtHPLEncaSancAmt;
  }

  public void setTxtHPLEncaSancAmt(String newTxtHPLEncaSancAmt)
  {
    txtHPLEncaSancAmt = newTxtHPLEncaSancAmt;
  }
  
  
  public String getTxtHPLNoAccEld()
  {
    return txtHPLNoAccEld;
  }

  public void setTxtHPLNoAccEld(String newTxtHPLNoAccEld)
  {
    txtHPLNoAccEld = newTxtHPLNoAccEld;
  }
   
  public String getTxtHPLNetAmt()
  {
    return txtHPLNetAmt;
  }

  public void setTxtHPLNetAmt(String newTxtHPLNetAmt)
  {
    txtHPLNetAmt = newTxtHPLNetAmt;
  }  
  
  
   public String getTxtflagITDetail()
  {
    return txtflagITDetail;
  }

  public void setTxtflagITDetail(String newTxtflagITDetail)
  {
    txtflagITDetail = newTxtflagITDetail;
  }  
  
  public String getTxtLastSalInv()
  {
    return txtLastSalInv;
  }

  public void setTxtLastSalInv(String newLastSalInv)
  {
    txtLastSalInv = newLastSalInv;
  }
  
  public String getTxtLeaveEncInv()
  {
    return txtLeaveEncInv;
  }

  public void setTxtLeaveEncInv(String newLeaveEncInv)
  {
    txtLeaveEncInv = newLeaveEncInv;
  }
  
  public String getTxtGratuityInv()
  {
    return txtGratuityInv;
  }

  public void setTxtGratuityInv(String newGratuityInv)
  {
    txtGratuityInv = newGratuityInv;
  }
  
   public String getTxtOutStandInv()
  {
    return txtOutStandInv;
  }

  public void setTxtOutStandInv(String newOutStandInv)
  {
    txtOutStandInv = newOutStandInv;
  }
  
   public String getTxtHPLEncInv()
  {
    return txtHPLEncInv;
  }

  public void setTxtHPLEncInv(String newHPLEncInv)
  {
    txtHPLEncInv = newHPLEncInv;
  }

  public String getTxtIncentiveAmt()
  {
    return txtIncentiveAmt;
  }

  public void setTxtIncentiveAmt(String newTxtIncentiveAmt)
  {
    txtIncentiveAmt = newTxtIncentiveAmt;
  }

  public String getTxtIncentiveInv()
  {
    return txtIncentiveInv;
  }

  public void setTxtIncentiveInv(String newTxtIncentiveInv)
  {
    txtIncentiveInv = newTxtIncentiveInv;
  }
  
  //added by geetika on 24/01/2014
   public String getTxtIfGratuityChng()
  {
    return txtIfGratuityChng;
  }

  public void setTxtIfGratuityChng(String newTxtIfGratuityChng)
  {
    txtIfGratuityChng = newTxtIfGratuityChng;
  }

  
    public String getTxtVrsSancNo()
    {
      return txtVrsSancNo;
    }

    public void setTxtVrsSancNo(String newtxtVrsSancNo)
    {
      txtVrsSancNo = newtxtVrsSancNo;
    }
  
    public String getTxtVrsSancDt()
    {
      return txtVrsSancDt;
    }

    public void setTxtVrsSancDt(String newtxtVrsSancDt)
    {
      txtVrsSancDt = newtxtVrsSancDt;
    }
    
    public String getTxtVrsGrossAmt()
    {
      return txtVrsGrossAmt;
    }

    public void setTxtVrsGrossAmt(String newtxtVrsGrossAmt)
    {
      txtVrsGrossAmt = newtxtVrsGrossAmt;
    }
    
    public String getTxtVrsNetAmt()
    {
      return txtVrsNetAmt;
    }

    public void setTxtVrsNetAmt(String newtxtVrsNetAmt)
    {
      txtVrsNetAmt = newtxtVrsNetAmt;
    }
    
    public String getTxtVrsInv()
    {
      return txtVrsInv;
    }

    public void setTxtVrsInv(String newtxtVrsInv)
    {
      txtVrsInv = newtxtVrsInv;
    }
}