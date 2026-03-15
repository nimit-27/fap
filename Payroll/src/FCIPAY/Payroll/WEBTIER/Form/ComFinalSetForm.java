package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class ComFinalSetForm extends PayrollBaseForm 
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
  
  private String txtVrsSancNo;
  private String txtVrsSancDt;
  private String txtVrsAmt;
  private String txtVrsGrossAmt;
  private String txtVrsNetAmt;
  private String txtVrsInv;

  
  private boolean graFlag;
  private String txtNetEarning;
 
  private String txtflagITDetail;
 
  private String flag;
  private String flagITDetail;
  private String txtPayCode[];
  private String txtDesc[];
  private String txtAmt[];
  private String txtSerialNo[];
  private String txtTransMastId[];
  private String txtOutAmt[];
  private String txtRecFlag[];
  private String txtDednAdjFlag[];
  private String chkManDednFlag[];
  
  private String txtTotDed;
  private String txtOutDed;
  
  private String txtApplnDt;
  private String hdnDayWage;

  private String txtflagGetDetail;
  private String txtBtnAction;
  private String txtOldNewFlag[];
  private ArrayList lstInstrDtls= new ArrayList();
  private String txtTotalNetAmt;
  
  private String txtLastSalInv;
  private String txtLeaveEncInv;
  private String txtGratuityInv;
  private String txtOutStandInv;
  private String txtHPLEncInv;
  private String txtIncentiveAmt;
  private String txtIncentiveInv;  
  
    //added by geetika on 24-01-2014
  private String txtIfGratuityChng;
  private String chkEditSepEntry;
  /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
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

  public String getHdnDayWage()
  {
    return hdnDayWage;
  }

  public void setHdnDayWage(String newHdnDayWage)
  {
    hdnDayWage = newHdnDayWage;
  }

  public String getTxtApplnDt()
  {
    return txtApplnDt;
  }

  public void setTxtApplnDt(String newTxtApplnDt)
  {
    txtApplnDt = newTxtApplnDt;
  }
  
  public String getTxtGraSancDt()
  {
    return txtGraSancDt;
  }

  public void setTxtGraSancDt(String newTxtGraSancDt)
  {
    txtGraSancDt = newTxtGraSancDt;
  }

  public String getTxtGraSancAmt()
  {
    return txtGraSancAmt;
  }

  public void setTxtGraSancAmt(String newTxtGraSancAmt)
  {
    txtGraSancAmt = newTxtGraSancAmt;
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

  public String getTxtHPLNetAmt()
  {
    return txtHPLNetAmt;
  }

  public void setTxtHPLNetAmt(String newTxtHPLNetAmt)
  {
    txtHPLNetAmt = newTxtHPLNetAmt;
  }

  public String[] getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String[] newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String[] getTxtDesc()
  {
    return txtDesc;
  }

  public void setTxtDesc(String[] newTxtDesc)
  {
    txtDesc = newTxtDesc;
  }

  public String[] getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String[] newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }

  public String[] getTxtOutAmt()
  {
    return txtOutAmt;
  }

  public void setTxtOutAmt(String[] newTxtOutAmt)
  {
    txtOutAmt = newTxtOutAmt;
  }
  
  public String[] getTxtTransMastId()
  {
    return txtTransMastId;
  }

  public void setTxtTransMastId(String[] newTxtTransMastId)
  {
    txtTransMastId = newTxtTransMastId;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
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

  public String getTxtLeave()
  {
    return txtLeave;
  }

  public void setTxtLeave(String newTxtLeave)
  {
    txtLeave = newTxtLeave;
  }

  public String getTxtGratuity()
  {
    return txtGratuity;
  }

  public void setTxtGratuity(String newTxtGratuity)
  {
    txtGratuity = newTxtGratuity;
  }

  public String[] getTxtSerialNo()
  {
    return txtSerialNo;
  }

  public void setTxtSerialNo(String[] newTxtSerialNo)
  {
    txtSerialNo = newTxtSerialNo;
  }

  public String[] getTxtRecFlag()
  {
    return txtRecFlag;
  }

  public void setTxtRecFlag(String[] newTxtRecFlag)
  {
    txtRecFlag = newTxtRecFlag;
  }

  public boolean getGraFlag()
  {
    return graFlag;
  }

  public void setGraFlag(boolean newGraFlag)
  {
    graFlag = newGraFlag;
  }

  public String getFlag()
  {
    return flag;
  }

  public void setFlag(String newFlag)
  {
    flag = newFlag;
  }
  
    public String getFlagITDetail()
  {
    return flagITDetail;
  }

  public void setFlagITDetail(String newFlagITDetail)
  {
    flagITDetail = newFlagITDetail;
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

  public String getTxtBtnAction()
  {
    return txtBtnAction;
  }

  public void setTxtBtnAction(String newTxtBtnAction)
  {
    txtBtnAction = newTxtBtnAction;
  }
  
  
  
  public String[] getTxtOldNewFlag()
  {
    return txtOldNewFlag;
  }

  public void setTxtOldNewFlag(String[] newTxtOldNewFlag)
  {
    txtOldNewFlag = newTxtOldNewFlag;
  }

  public String getTxtNetEarning()
  {
    return txtNetEarning;
  }

  public void setTxtNetEarning(String newTxtNetEarning)
  {
    txtNetEarning = newTxtNetEarning;
  }
  

  public String getTxtOutDed()
  {
    return txtOutDed;
  }

  public void setTxtOutDed(String newTxtOutDed)
  {
    txtOutDed = newTxtOutDed;
  }



 public String getTxtHPLEncaSancAmt()
  {
    return txtHPLEncaSancAmt;
  }

  public void setTxtHPLEncaSancAmt(String newTxtHPLEncaSancAmt)
  {
    txtHPLEncaSancAmt = newTxtHPLEncaSancAmt;
  }
  
  public String getTxtHPLEncaSancNo()
  {
    return txtHPLEncaSancNo;
  }

  public void setTxtHPLEncaSancNo(String newTxtHPLEncaSancNo)
  {
    txtHPLEncaSancNo = newTxtHPLEncaSancNo;
  }
  
  public String getTxtHPLNoAccEld()
  {
    return txtHPLNoAccEld;
  }

  public void setTxtHPLNoAccEld(String newTxtHPLNoAccEld)
  {
    txtHPLNoAccEld = newTxtHPLNoAccEld;
  }
  
  public String getTxtHPLEncaSancDt()
  {
    return txtHPLEncaSancDt;
  }

  public void setTxtHPLEncaSancDt(String newTxtHPLEncaSancDt)
  {
    txtHPLEncaSancDt = newTxtHPLEncaSancDt;
  }
  
   public String getTxtflagITDetail()
  {
    return txtflagITDetail;
  }

  public void setTxtflagITDetail(String newTxtflagITDetail)
  {
    txtflagITDetail = newTxtflagITDetail;
  }
  
  
  public String getTxtflagGetDetail()
  {
    return txtflagGetDetail;
  }

  public void setTxtflagGetDetail(String newTxtflagGetDetail)
  {
    txtflagGetDetail = newTxtflagGetDetail;
  }
  
  public String getTxtTotalNetAmt()
  {
    return txtTotalNetAmt;
  }

  public void setTxtTotalNetAmt(String newTotalNetAmt)
  {
    txtTotalNetAmt = newTotalNetAmt;
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
  
  public String[] getTxtDednAdjFlag()
  {
    return txtDednAdjFlag;
  }

  public void setTxtDednAdjFlag(String[] newTxtDednAdjFlag)
  {
    txtDednAdjFlag = newTxtDednAdjFlag;
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

    public void setChkManDednFlag(String[] chkManDednFlag) {
        this.chkManDednFlag = chkManDednFlag;
    }

    public String[] getChkManDednFlag() {
        return chkManDednFlag;
    }


    public void setTxtVrsSancNo(String newTxtVrsSancNo) {
        txtVrsSancNo = newTxtVrsSancNo;
    }

    public String getTxtVrsSancNo() {
        return txtVrsSancNo;
    }

    public void setTxtVrsSancDt(String newTxtVrsSancDt) {
        txtVrsSancDt =  newTxtVrsSancDt;
    }

    public String getTxtVrsSancDt() {
        return txtVrsSancDt;
    }

    public void setTxtVrsGrossAmt(String newTxtVrsGrossAmt) {
        txtVrsGrossAmt = newTxtVrsGrossAmt;
    }

    public String getTxtVrsGrossAmt() {
        return txtVrsGrossAmt;
    }

    public void setTxtVrsNetAmt(String newTxtVrsNetAmt) {
        txtVrsNetAmt = newTxtVrsNetAmt;
    }

    public String getTxtVrsNetAmt() {
        return txtVrsNetAmt;
    }

    public void setTxtVrsInv(String newTxtVrsInv) {
        txtVrsInv = newTxtVrsInv;
    }

    public String getTxtVrsInv() {
        return txtVrsInv;
    }
    
    public void setTxtVrsAmt(String newTxtVrsAmt) {
        txtVrsAmt = newTxtVrsAmt;
    }

    public String getTxtVrsAmt() {
        return txtVrsAmt;
    }
}
