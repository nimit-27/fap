package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class PayITForecastForm extends PayrollBaseForm
{
  private String txtYYMM;
  private String optSelect;
  private String txtEmp;
  private String txtAllEmpFlag;
  private String butAction;
  private String hdnLoginUserId;
  private String hdnPayUser;
  private String hdnLoginUserName;
  private String txtEmpName;
  private String hdnLocation;
  private String txtCpfCode;                              //  <!--added by dushyant on 20-08-2010-->

  public PayITForecastForm()
  {
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }

  public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  }

  public String getTxtAllEmpFlag()
  {
    return txtAllEmpFlag;
  }

  public void setTxtAllEmpFlag(String newTxtAllEmpFlag)
  {
    txtAllEmpFlag = newTxtAllEmpFlag;
  }
   public String getButAction()
  {
    return butAction;
  }

  public void setButAction(String newButAction)
  {
    butAction = newButAction;
  }

  public String getHdnLoginUserId()
  {
    return hdnLoginUserId;
  }

  public void setHdnLoginUserId(String newHdnLoginUserId)
  {
    hdnLoginUserId = newHdnLoginUserId;
  }

  public String getHdnPayUser()
  {
    return hdnPayUser;
  }

  public void setHdnPayUser(String newHdnPayUser)
  {
    hdnPayUser = newHdnPayUser;
  }

  public String getHdnLoginUserName()
  {
    return hdnLoginUserName;
  }

  public void setHdnLoginUserName(String newHdnLoginUserName)
  {
    hdnLoginUserName = newHdnLoginUserName;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getHdnLocation()
  {
    return hdnLocation;
  }

  public void setHdnLocation(String newHdnLocation)
  {
    hdnLocation = newHdnLocation;
  }
  
  //  <!--added by dushyant on 20-08-2010-->
  
  public String getTxtCpfCode()
  {
   return txtCpfCode;
  }
  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
  
  //  <!--end by dushyant on 20-08-2010-->
}