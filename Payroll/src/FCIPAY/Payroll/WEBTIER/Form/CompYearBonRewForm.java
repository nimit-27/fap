package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class CompYearBonRewForm extends PayrollBaseForm
{
  private String optSelect;
  private String txtEmpName;
  private String txtBonDays="";
  private String txtAwdDays="";
  private String txtMaxAwdAmt="";
  private String txtYYMM;
  private String txtMaxEmolAmt="";
  private String optVal;
  private String txtEmpNum;
  private String txtSrlNo;
  private String txtBonAwdFlag;

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











  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }









  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtBonDays()
  {
    return txtBonDays;
  }

  public void setTxtBonDays(String newTxtBonDays)
  {
    txtBonDays = newTxtBonDays;
  }

  public String getTxtAwdDays()
  {
    return txtAwdDays;
  }

  public void setTxtAwdDays(String newTxtAwdDays)
  {
    txtAwdDays = newTxtAwdDays;
  }

  public String getTxtMaxAwdAmt()
  {
    return txtMaxAwdAmt;
  }

  public void setTxtMaxAwdAmt(String newTxtMaxAwdAmt)
  {
    txtMaxAwdAmt = newTxtMaxAwdAmt;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getTxtMaxEmolAmt()
  {
    return txtMaxEmolAmt;
  }

  public void setTxtMaxEmolAmt(String newTxtMaxEmolAmt)
  {
    txtMaxEmolAmt = newTxtMaxEmolAmt;
  }

  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
  }

  public String getTxtEmpNum()
  {
    return txtEmpNum;
  }

  public void setTxtEmpNum(String newTxtEmpNum)
  {
    txtEmpNum = newTxtEmpNum;
  }

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getTxtBonAwdFlag()
  {
    return txtBonAwdFlag;
  }

  public void setTxtBonAwdFlag(String newTxtBonAwdFlag)
  {
    txtBonAwdFlag = newTxtBonAwdFlag;
  }
}