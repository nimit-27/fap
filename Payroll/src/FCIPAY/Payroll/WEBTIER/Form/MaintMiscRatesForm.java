package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintMiscRatesForm extends PayrollBaseForm
{
  private String txtRate[]=null;
  private String txtEffDate[]=null;
  private String txtEffEndDate[]=null;
  private ArrayList lstInstrDtls= new ArrayList();
  private String txtPayScaleType[]=null;
  private String txtCategory[]=null;
  private String txtPayCode[]=null;
  private String txtPayCodeDesc[]=null;
  private String txtSrlNo[]=null;
  private String txtPayScaleCode[]=null;
  private String txtPayScaleRange[]=null;

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


  public String[] getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String[] newTxtRate)
  {
    txtRate = newTxtRate;
  }

  public String[] getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String[] newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }
  
  public String[] getTxtEffEndDate()
  {
    return txtEffEndDate;
  }

  public void setTxtEffEndDate(String[] newTxtEffEndDate)
  {
    txtEffEndDate = newTxtEffEndDate;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public String[] getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String[] newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String[] getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }

  public void setTxtPayCodeDesc(String[] newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  }
  
  public String[] getTxtPayScaleType()
  {
    return txtPayScaleType;
  }

  public void setTxtPayScaleType(String[] newTxtPayScaleType)
  {
    txtPayScaleType = newTxtPayScaleType;
  }
  
  public String[] getTxtCategory()
  {
    return txtCategory;
  }

  public void setTxtCategory(String[] newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }
  
  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String[] getTxtPayScaleCode()
  {
    return txtPayScaleCode;
  }

  public void setTxtPayScaleCode(String[] newTxtPayScaleCode)
  {
    txtPayScaleCode = newTxtPayScaleCode;
  }

  public String[] getTxtPayScaleRange()
  {
    return txtPayScaleRange;
  }

  public void setTxtPayScaleRange(String[] newTxtPayScaleRange)
  {
    txtPayScaleRange = newTxtPayScaleRange;
  }
  
}