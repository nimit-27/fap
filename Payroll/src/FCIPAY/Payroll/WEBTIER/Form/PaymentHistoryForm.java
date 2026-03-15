package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class PaymentHistoryForm extends PayrollBaseForm
{
  private String txtPayAmt[];
  private String txtPayDate[];
  private String txtRemark[];
  private String txtPayHead;
  private String txtEmpNo;
  private ArrayList lstInstrDtls1=new ArrayList();
  private String flag;
  private String txtSerialNo[];

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

  public String[] getTxtPayAmt()
  {
    return txtPayAmt;
  }

  public void setTxtPayAmt(String newTxtPayAmt[])
  {
    txtPayAmt = newTxtPayAmt;
  }

  public String[] getTxtPayDate()
  {
    return txtPayDate;
  }

  public void setTxtPayDate(String newTxtPayDate[])
  {
    txtPayDate = newTxtPayDate;
  }

  public String[] getTxtRemark()
  {
    return txtRemark;
  }

  public void setTxtRemark(String newTxtRemark[])
  {
    txtRemark = newTxtRemark;
  }

  public String getTxtPayHead()
  {
    return txtPayHead;
  }

  public void setTxtPayHead(String newTxtPayHead)
  {
    txtPayHead = newTxtPayHead;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public ArrayList getLstInstrDtls1()
  {
    return lstInstrDtls1;
  }

  public void setLstInstrDtls1(ArrayList newLstInstrDtls1)
  {
    lstInstrDtls1 = newLstInstrDtls1;
  }

  public String getFlag()
  {
    return flag;
  }

  public void setFlag(String newFlag)
  {
    flag = newFlag;
  }

  public String[] getTxtSerialNo()
  {
    return txtSerialNo;
  }

  public void setTxtSerialNo(String newTxtSerialNo[])
  {
    txtSerialNo = newTxtSerialNo;
  }
}