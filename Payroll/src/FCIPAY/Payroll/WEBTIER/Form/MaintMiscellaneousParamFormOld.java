package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintMiscellaneousParamFormOld extends PayrollBaseForm 
{
  private String txtCategory[];
  private String txtWashAllowance[];
  private String txtCableReimb[];
  private String lstCadre[];
  private ArrayList lstInstrDtls = new ArrayList();
  private ArrayList lstPayScaleValues = new ArrayList();
  private ArrayList lstPayScaleLabels;
  private String txtAmtffm[];
  private String txtAmtto[];
  private String txtProjAllow[];
  private String txtOvrTimeAllow[];
  private String txtMinBasic[];
  private String txtMaxBasic[];
  private String txtRPWH[];
  private String txtWSameSt;
  private String txtOutSt;
/*  private String txtCycAllow;
  private String txtUniAllow;
  private String txtSpAllow;
  private String txtNurallow;
  private String txtChAllow;
  private String txtMsAllow;  */
  private String txtEdAllow;
  private String txtPf;
  private ArrayList lstNdutyDtls = new ArrayList();
  private ArrayList lstOtherDtls = new ArrayList();
  private ArrayList lstOTimeDtls = new ArrayList();
  private ArrayList lstProjDtls = new ArrayList();
  private ArrayList lstWashDtls = new ArrayList();
  private String lstNdutyCadre[];
  private String tstNdutyCatagory[];
  private String txtWashSrl[];
  private String txtProjSrl[];
  private String txtOverSrl[];
  private String txtNDutySrl[];
  private String txtDASame;
  private String txtDAOut;
  private String txtUpgradeAllow[];
  private String txtUpgradeSrl[];
  private ArrayList lstUpgradeDtls = new ArrayList();
  private String txtCateg[];
  private boolean flagNduty = false;
  private boolean flagOtime = false;
  private boolean flagProj = false;
  private boolean flagUpgrade = false;
  private boolean flagWash = false;
  private String txtCPF;
  private String txtMaxChild;
  private boolean flagOther = false;
/*  private String txtHostSub;
  private String txtOldCant;
  private String txtCurrCant;
  private String tempOldCant;  */
  private String txtGPF;
  private String txtENCPF;
  private String txtPayScale[]=null;
  private String txtMaxAbsRate;
  private String lstCadreDesc[]=null;

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

  public String[] getTxtCategory()
  {
    return txtCategory;
  }

  public void setTxtCategory(String[] newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }

  public String[] getTxtWashAllowance()
  {
    return txtWashAllowance;
  }

  public void setTxtWashAllowance(String[] newTxtWashAllowance)
  {
    txtWashAllowance = newTxtWashAllowance;
  }

  public String[] getTxtCableReimb()
  {
    return txtCableReimb;
  }

  public void setTxtCableReimb(String[] newTxtCableReimb)
  {
    txtCableReimb = newTxtCableReimb;
  }

  public String[] getLstCadre()
  {
    return lstCadre;
  }

  public void setLstCadre(String[] newLstCadre)
  {
    lstCadre = newLstCadre;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public ArrayList getLstPayScaleValues()
  {
    return lstPayScaleValues;
  }

  public void setLstPayScaleValues(ArrayList newLstPayScaleValues)
  {
    lstPayScaleValues = newLstPayScaleValues;
  }

  public ArrayList getLstPayScaleLabels()
  {
    return lstPayScaleLabels;
  }

  public void setLstPayScaleLabels(ArrayList newLstPayScaleLabels)
  {
    lstPayScaleLabels = newLstPayScaleLabels;
  }

  public String[] getTxtAmtffm()
  {
    return txtAmtffm;
  }

  public void setTxtAmtffm(String[] newTxtAmtffm)
  {
    txtAmtffm = newTxtAmtffm;
  }

  public String[] getTxtAmtto()
  {
    return txtAmtto;
  }

  public void setTxtAmtto(String[] newTxtAmtto)
  {
    txtAmtto = newTxtAmtto;
  }

  public String[] getTxtProjAllow()
  {
    return txtProjAllow;
  }

  public void setTxtProjAllow(String[] newTxtProjAllow)
  {
    txtProjAllow = newTxtProjAllow;
  }

  public String[] getTxtOvrTimeAllow()
  {
    return txtOvrTimeAllow;
  }

  public void setTxtOvrTimeAllow(String[] newTxtOvrTimeAllow)
  {
    txtOvrTimeAllow = newTxtOvrTimeAllow;
  }

  public String[] getTxtMinBasic()
  {
    return txtMinBasic;
  }

  public void setTxtMinBasic(String[] newTxtMinBasic)
  {
    txtMinBasic = newTxtMinBasic;
  }

  public String[] getTxtMaxBasic()
  {
    return txtMaxBasic;
  }

  public void setTxtMaxBasic(String[] newTxtMaxBasic)
  {
    txtMaxBasic = newTxtMaxBasic;
  }

  public String[] getTxtRPWH()
  {
    return txtRPWH;
  }

  public void setTxtRPWH(String[] newTxtRPWH)
  {
    txtRPWH = newTxtRPWH;
  }

  public String getTxtWSameSt()
  {
    return txtWSameSt;
  }

  public void setTxtWSameSt(String newTxtWSameSt)
  {
    txtWSameSt = newTxtWSameSt;
  }

  public String getTxtOutSt()
  {
    return txtOutSt;
  }

  public void setTxtOutSt(String newTxtOutSt)
  {
    txtOutSt = newTxtOutSt;
  }



/*  public String getTxtCycAllow()
  {
    return txtCycAllow;
  }

  public void setTxtCycAllow(String newTxtCycAllow)
  {
    txtCycAllow = newTxtCycAllow;
  }

  public String getTxtUniAllow()
  {
    return txtUniAllow;
  }

  public void setTxtUniAllow(String newTxtUniAllow)
  {
    txtUniAllow = newTxtUniAllow;
  }

  public String getTxtSpAllow()
  {
    return txtSpAllow;
  }

  public void setTxtSpAllow(String newTxtSpAllow)
  {
    txtSpAllow = newTxtSpAllow;
  }

  public String getTxtNurallow()
  {
    return txtNurallow;
  }

  public void setTxtNurallow(String newTxtNurallow)
  {
    txtNurallow = newTxtNurallow;
  }  */

/*  public String getTxtChAllow()
  {
    return txtChAllow;
  }

  public void setTxtChAllow(String newTxtChAllow)
  {
    txtChAllow = newTxtChAllow;
  }  */

/*  public String getTxtMsAllow()
  {
    return txtMsAllow;
  }

  public void setTxtMsAllow(String newTxtMsAllow)
  {
    txtMsAllow = newTxtMsAllow;
  }  */

  public String getTxtEdAllow()
  {
    return txtEdAllow;
  }

  public void setTxtEdAllow(String newTxtEdAllow)
  {
    txtEdAllow = newTxtEdAllow;
  }

  public String getTxtPf()
  {
    return txtPf;
  }

  public void setTxtPf(String newTxtPf)
  {
    txtPf = newTxtPf;
  }


  public ArrayList getLstNdutyDtls()
  {
    return lstNdutyDtls;
  }

  public void setLstNdutyDtls(ArrayList newLstNdutyDtls)
  {
    lstNdutyDtls = newLstNdutyDtls;
  }

  public ArrayList getLstOtherDtls()
  {
    return lstOtherDtls;
  }

  public void setLstOtherDtls(ArrayList newLstOtherDtls)
  {
    lstOtherDtls = newLstOtherDtls;
  }

  public ArrayList getLstOTimeDtls()
  {
    return lstOTimeDtls;
  }

  public void setLstOTimeDtls(ArrayList newLstOTimeDtls)
  {
    lstOTimeDtls = newLstOTimeDtls;
  }

  public ArrayList getLstProjDtls()
  {
    return lstProjDtls;
  }

  public void setLstProjDtls(ArrayList newLstProjDtls)
  {
    lstProjDtls = newLstProjDtls;
  }

  public ArrayList getLstWashDtls()
  {
    return lstWashDtls;
  }

  public void setLstWashDtls(ArrayList newLstWashDtls)
  {
    lstWashDtls = newLstWashDtls;
  }

  public String[] getLstNdutyCadre()
  {
    return lstNdutyCadre;
  }

  public void setLstNdutyCadre(String[] newLstNdutyCadre)
  {
    lstNdutyCadre = newLstNdutyCadre;
  }

  public String[] getTstNdutyCatagory()
  {
    return tstNdutyCatagory;
  }

  public void setTstNdutyCatagory(String[] newTstNdutyCatagory)
  {
    tstNdutyCatagory = newTstNdutyCatagory;
  }

  public String[] getTxtWashSrl()
  {
    return txtWashSrl;
  }

  public void setTxtWashSrl(String[] newTxtWashSrl)
  {
    txtWashSrl = newTxtWashSrl;
  }

  public String[] getTxtProjSrl()
  {
    return txtProjSrl;
  }

  public void setTxtProjSrl(String[] newTxtProjSrl)
  {
    txtProjSrl = newTxtProjSrl;
  }

  public String[] getTxtOverSrl()
  {
    return txtOverSrl;
  }

  public void setTxtOverSrl(String[] newTxtOverSrl)
  {
    txtOverSrl = newTxtOverSrl;
  }

  public String[] getTxtNDutySrl()
  {
    return txtNDutySrl;
  }

  public void setTxtNDutySrl(String[] newTxtNDutySrl)
  {
    txtNDutySrl = newTxtNDutySrl;
  }

  public String getTxtDASame()
  {
    return txtDASame;
  }

  public void setTxtDASame(String newTxtDASame)
  {
    txtDASame = newTxtDASame;
  }

  public String getTxtDAOut()
  {
    return txtDAOut;
  }

  public void setTxtDAOut(String newTxtDAOut)
  {
    txtDAOut = newTxtDAOut;
  }

  public String[] getTxtUpgradeAllow()
  {
    return txtUpgradeAllow;
  }

  public void setTxtUpgradeAllow(String[] newTxtUpgradeAllow)
  {
    txtUpgradeAllow = newTxtUpgradeAllow;
  }

  public String[] getTxtUpgradeSrl()
  {
    return txtUpgradeSrl;
  }

  public void setTxtUpgradeSrl(String[] newTxtUpgradeSrl)
  {
    txtUpgradeSrl = newTxtUpgradeSrl;
  }

  public ArrayList getLstUpgradeDtls()
  {
    return lstUpgradeDtls;
  }

  public void setLstUpgradeDtls(ArrayList newLstUpgradeDtls)
  {
    lstUpgradeDtls = newLstUpgradeDtls;
  }

  public String[] getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String[] newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }



  public boolean isFlagNduty()
  {
    return flagNduty;
  }

  public void setFlagNduty(boolean newFlagNduty)
  {
    flagNduty = newFlagNduty;
  }

  public boolean isFlagOtime()
  {
    return flagOtime;
  }

  public void setFlagOtime(boolean newFlagOtime)
  {
    flagOtime = newFlagOtime;
  }

  public boolean isFlagProj()
  {
    return flagProj;
  }

  public void setFlagProj(boolean newFlagProj)
  {
    flagProj = newFlagProj;
  }

  public boolean isFlagUpgrade()
  {
    return flagUpgrade;
  }

  public void setFlagUpgrade(boolean newFlagUpgrade)
  {
    flagUpgrade = newFlagUpgrade;
  }

  public boolean isFlagWash()
  {
    return flagWash;
  }

  public void setFlagWash(boolean newFlagWash)
  {
    flagWash = newFlagWash;
  }

  public String getTxtCPF()
  {
    return txtCPF;
  }

  public void setTxtCPF(String newTxtCPF)
  {
    txtCPF = newTxtCPF;
  }

  public String getTxtMaxChild()
  {
    return txtMaxChild;
  }

  public void setTxtMaxChild(String newTxtMaxChild)
  {
    txtMaxChild = newTxtMaxChild;
  }

  public boolean isFlagOther()
  {
    return flagOther;
  }

  public void setFlagOther(boolean newFlagOther)
  {
    flagOther = newFlagOther;
  }

/*  public String getTxtHostSub()
  {
    return txtHostSub;
  }

  public void setTxtHostSub(String newTxtHostSub)
  {
    txtHostSub = newTxtHostSub;
  }

  public String getTxtOldCant()
  {
    return txtOldCant;
  }

  public void setTxtOldCant(String newTxtOldCant)
  {
    txtOldCant = newTxtOldCant;
  }

  public String getTxtCurrCant()
  {
    return txtCurrCant;
  }

  public void setTxtCurrCant(String newTxtCurrCant)
  {
    txtCurrCant = newTxtCurrCant;
  }

  public String getTempOldCant()
  {
    return tempOldCant;
  }

  public void setTempOldCant(String newTempOldCant)
  {
    tempOldCant = newTempOldCant;
  }  */

  public String getTxtGPF()
  {
    return txtGPF;
  }

  public void setTxtGPF(String newTxtGPF)
  {
    txtGPF = newTxtGPF;
  }

  public String getTxtENCPF()
  {
    return txtENCPF;
  }

  public void setTxtENCPF(String newTxtENCPF)
  {
    txtENCPF = newTxtENCPF;
  }

  public String[] getTxtPayScale()
  {
    return txtPayScale;
  }

  public void setTxtPayScale(String[] newTxtPayScale)
  {
    txtPayScale = newTxtPayScale;
  }

  public String getTxtMaxAbsRate()
  {
    return txtMaxAbsRate;
  }

  public void setTxtMaxAbsRate(String newTxtMaxAbsRate)
  {
    txtMaxAbsRate = newTxtMaxAbsRate;
  }

  public String[] getLstCadreDesc()
  {
    return lstCadreDesc;
  }

  public void setLstCadreDesc(String[] newLstCadreDesc)
  {
    lstCadreDesc = newLstCadreDesc;
  }





}