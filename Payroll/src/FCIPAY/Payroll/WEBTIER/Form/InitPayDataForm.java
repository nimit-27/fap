package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class InitPayDataForm extends PayrollBaseForm 
{
  private String butAction;
  private String hdnAction;
  private String txtPenEmpList;
  private String txtButFlg;
  private String txtSepEmpList;
  
  public InitPayDataForm()
  {
  }

  public String getButAction()
  {
    return butAction;
  }

  public void setButAction(String newButAction)
  {
    butAction = newButAction;
  }

  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }

  public String getTxtPenEmpList()
  {
    return txtPenEmpList;
  }

  public void setTxtPenEmpList(String newTxtPenEmpList)
  {
    txtPenEmpList = newTxtPenEmpList;
  }

  public String getTxtButFlg()
  {
    return txtButFlg;
  }

  public void setTxtButFlg(String newTxtButFlg)
  {
    txtButFlg = newTxtButFlg;
  }
  public String getTxtSepEmpList()
  {
    return txtSepEmpList;
  }

  public void setTxtSepEmpList(String newTxtSepEmpList)
  {
    txtSepEmpList = newTxtSepEmpList;
  }

}