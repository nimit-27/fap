package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import java.util.ArrayList;

public class MaintAdhocPayForm extends PayrollBaseForm 
{
  private String txtSrlNo[]=null;
  private String txtPayYYMM;
  private String txtPayCode;
  private String txtPayMode;
  private String txtOptCode[]=null;
  private String txtGroupCode[]=null;
  private String txtCategCode[]=null;
  private String txtDesigCode[]=null;
  private String txtAmount[]=null;
  private ArrayList lstInstrDtls= new ArrayList();
  private String txtPayCodeDesc;
  private String headerMode;
  private String headerMode1;
  private boolean flag = false;
  private String hdnPayrollFlag;
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

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getTxtPayYYMM()
  {
    return txtPayYYMM;
  }

  public void setTxtPayYYMM(String newTxtPayYYMM)
  {
    txtPayYYMM = newTxtPayYYMM;
  }

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }

  public String[] getTxtOptCode()
  {
    return txtOptCode;
  }

  public void setTxtOptCode(String[] newTxtOptCode)
  {
    txtOptCode = newTxtOptCode;
  }

  public String[] getTxtGroupCode()
  {
    return txtGroupCode;
  }

  public void setTxtGroupCode(String[] newTxtGroupCode)
  {
    txtGroupCode = newTxtGroupCode;
  }

  public String[] getTxtCategCode()
  {
    return txtCategCode;
  }

  public void setTxtCategCode(String[] newTxtCategCode)
  {
    txtCategCode = newTxtCategCode;
  }

  public String[] getTxtDesigCode()
  {
    return txtDesigCode;
  }

  public void setTxtDesigCode(String[] newTxtDesigCode)
  {
    txtDesigCode = newTxtDesigCode;
  }

  public String[] getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String[] newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public String getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }

  public void setTxtPayCodeDesc(String newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  }

  public String getHeaderMode()
  {
    return headerMode;
  }

  public void setHeaderMode(String newHeaderMode)
  {
    headerMode = newHeaderMode;
  }

  public String getHeaderMode1()
  {
    return headerMode1;
  }

  public void setHeaderMode1(String newHeaderMode1)
  {
    headerMode1 = newHeaderMode1;
  }
 public boolean isFlag()
  {
    return flag;
  }

  public void setFlag(boolean newFlag)
  {
    flag = newFlag;
  }

  public String getHdnPayrollFlag()
  {
    return hdnPayrollFlag;
  }

  public void setHdnPayrollFlag(String newHdnPayrollFlag)
  {
    hdnPayrollFlag = newHdnPayrollFlag;
  }
}