package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class GenerateRevrRecoveriesForm extends PayrollBaseForm 
{
  private String txtEmployeeNo[]=null;
  private String txtEmployeeName[]=null;
  private String txtFromDate[]=null;
  private String txtUptoMonth[]=null;
  private String txtpayYYMM= "";
  private ArrayList lstInstrDtls = new ArrayList();
  private String screenModePay1;
  private String screenModePay2;
  private String screenModeBasicArr;
  private String screenModeBasic;
  private String hdnPayrollFlag;
  private String hdnCurYYMM;
  private String hdnPayStatus;
  private String butAction;

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

  public String[] getTxtEmployeeNo()
  {
    return txtEmployeeNo;
  }

  public void setTxtEmployeeNo(String[] newTxtEmployeeNo)
  {
    txtEmployeeNo = newTxtEmployeeNo;
  }

  public String[] getTxtEmployeeName()
  {
    return txtEmployeeName;
  }

  public void setTxtEmployeeName(String[] newTxtEmployeeName)
  {
    txtEmployeeName = newTxtEmployeeName;
  }

  public String[] getTxtFromDate()
  {
    return txtFromDate;
  }

  public void setTxtFromDate(String[] newTxtFromDate)
  {
    txtFromDate = newTxtFromDate;
  }

  public String[] getTxtUptoMonth()
  {
    return txtUptoMonth;
  }

  public void setTxtUptoMonth(String[] newTxtUptoMonth)
  {
    txtUptoMonth = newTxtUptoMonth;
  }

  public String getTxtpayYYMM()
  {
    return txtpayYYMM;
  }

  public void setTxtpayYYMM(String newTxtpayYYMM)
  {
    txtpayYYMM = newTxtpayYYMM;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public String getScreenModePay1()
  {
    return screenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    screenModePay1 = newScreenModePay1;
  }

  public String getScreenModePay2()
  {
    return screenModePay2;
  }

  public void setScreenModePay2(String newScreenModePay2)
  {
    screenModePay2 = newScreenModePay2;
  }

  public String getScreenModeBasicArr()
  {
    return screenModeBasicArr;
  }

  public void setScreenModeBasicArr(String newScreenModeBasicArr)
  {
    screenModeBasicArr = newScreenModeBasicArr;
  }

  public String getScreenModeBasic()
  {
    return screenModeBasic;
  }

  public void setScreenModeBasic(String newScreenModeBasic)
  {
    screenModeBasic = newScreenModeBasic;
  }

  public String getHdnPayrollFlag()
  {
    return hdnPayrollFlag;
  }

  public void setHdnPayrollFlag(String newHdnPayrollFlag)
  {
    hdnPayrollFlag = newHdnPayrollFlag;
  }

  public String getHdnCurYYMM()
  {
    return hdnCurYYMM;
  }

  public void setHdnCurYYMM(String newHdnCurYYMM)
  {
    hdnCurYYMM = newHdnCurYYMM;
  }

  public String getHdnPayStatus()
  {
    return hdnPayStatus;
  }

  public void setHdnPayStatus(String newHdnPayStatus)
  {
    hdnPayStatus = newHdnPayStatus;
  }

  public String getButAction()
  {
    return butAction;
  }

  public void setButAction(String newButAction)
  {
    butAction = newButAction;
  }

}