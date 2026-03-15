package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class EditPayImgForm extends PayrollBaseForm 
{
  private String txtEmpNo;
  private String txtEmpName;
  private String txtYtm;
  private String txtrs1;
  private String txtrs2;
  private String txtCurrBas;
  private String txtPayCode[];
  private String txtDesc[];
  private String txtSrlNo[];
  private String txtPayMode[];
  private String txtAmt[];
  
  
  private String txtNetEar;
  private String txtGrossEar;
  private String txtGrossDed; 
  
  private String lstGroup;
  private String txtDesig;
  private String lstCateg;
  private String txtCpfCode;
  private String txtSrNo[]=null;
  private ArrayList lstInstrDtls = new ArrayList();
  private ArrayList lstInstrDtlsDed= new ArrayList();
  private ArrayList valueGroupArrayList;
  private ArrayList valueCategArrayList;
  private String screenModeId;


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

  public String getTxtYtm()
  {
    return txtYtm;
  }

  public void setTxtYtm(String newTxtYtm)
  {
    txtYtm = newTxtYtm;
  }

  public String getTxtCurrBas()
  {
    return txtCurrBas;
  }

  public void setTxtCurrBas(String newTxtCurrBas)
  {
    txtCurrBas = newTxtCurrBas;
  }

  public String getTxtrs1()
  {
    return txtrs1;
  }

  public void setTxtrs1(String newTxtrs1)
  {
    txtrs1 = newTxtrs1;
  }

  public String getTxtrs2()
  {
    return txtrs2;
  }

  public void setTxtrs2(String newTxtrs2)
  {
    txtrs2 = newTxtrs2;
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

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String[] getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String[] newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }

  public String[] getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String[] newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }

  public String getTxtNetEar()
  {
    return txtNetEar;
  }

  public void setTxtNetEar(String newTxtNetEar)
  {
    txtNetEar = newTxtNetEar;
  }

  public String getTxtGrossEar()
  {
    return txtGrossEar;
  }

  public void setTxtGrossEar(String newTxtGrossEar)
  {
    txtGrossEar = newTxtGrossEar;
  }

  public String getTxtGrossDed()
  {
    return txtGrossDed;
  }

  public void setTxtGrossDed(String newTxtGrossDed)
  {
    txtGrossDed = newTxtGrossDed;
  }

  public String getLstGroup()
  {
    return lstGroup;
  }

  public void setLstGroup(String newLstGroup)
  {
    lstGroup = newLstGroup;
  }

  public String getTxtDesig()
  {
    return txtDesig;
  }

  public void setTxtDesig(String newTxtDesig)
  {
    txtDesig = newTxtDesig;
  }

  public String getLstCateg()
  {
    return lstCateg;
  }

  public void setLstCateg(String newLstCateg)
  {
    lstCateg = newLstCateg;
  }

  public String[] getTxtSrNo()
  {
    return txtSrNo;
  }

  public void setTxtSrNo(String[] newTxtSrNo)
  {
    txtSrNo = newTxtSrNo;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public ArrayList getLstInstrDtlsDed()
  {
    return lstInstrDtlsDed;
  }

  public void setLstInstrDtlsDed(ArrayList newLstInstrDtlsDed)
  {
    lstInstrDtlsDed = newLstInstrDtlsDed;
  }

  public ArrayList getValueGroupArrayList()
  {
    return valueGroupArrayList;
  }

  public void setValueGroupArrayList(ArrayList newValueGroupArrayList)
  {
    valueGroupArrayList = newValueGroupArrayList;
  }

  public ArrayList getValueCategArrayList()
  {
    return valueCategArrayList;
  }

  public void setValueCategArrayList(ArrayList newValueCategArrayList)
  {
    valueCategArrayList = newValueCategArrayList;
  }
  
   public String getScreenModeId()
  {
    return screenModeId;
  }

  public void setScreenModeId(String newScreenModeId)
  {
    screenModeId = newScreenModeId;
  }
  
   public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }

}