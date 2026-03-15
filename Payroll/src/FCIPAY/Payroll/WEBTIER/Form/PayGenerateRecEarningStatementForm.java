package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;



public class PayGenerateRecEarningStatementForm extends PayrollBaseForm
{
  private String txtEmpNo;
  private String txtYYYYMM;
  private String txtEmpName;
  private String txtRecType;
  private String txtAgencyCode;
  private String txtAgencyName;
  private String optSelect;
  private String hdnEmpId;
  private String txtAllEmpFlag;
  private String butTxtEmpNo;
  private String txtPayCode;
  private String txtPayCodeDesc;

  public PayGenerateRecEarningStatementForm()
  {
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtYYYYMM()
  {
    return txtYYYYMM;
  }

  public void setTxtYYYYMM(String newTxtYYYYMM)
  {
    txtYYYYMM = newTxtYYYYMM;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtRecType()
  {
    return txtRecType;
  }

  public void setTxtRecType(String newTxtRecType)
  {
    txtRecType = newTxtRecType;
  }

  public String getTxtAgencyCode()
  {
    return txtAgencyCode;
  }

  public void setTxtAgencyCode(String newTxtAgencyCode)
  {
    txtAgencyCode = newTxtAgencyCode;
  }

  public String getTxtAgencyName()
  {
    return txtAgencyName;
  }

  public void setTxtAgencyName(String newTxtAgencyName)
  {
    txtAgencyName = newTxtAgencyName;
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }

  public String getHdnEmpId()
  {
    return hdnEmpId;
  }

  public void setHdnEmpId(String newHdnEmpId)
  {
    hdnEmpId = newHdnEmpId;
  }

  public String getTxtAllEmpFlag()
  {
    return txtAllEmpFlag;
  }

  public void setTxtAllEmpFlag(String newTxtAllEmpFlag)
  {
    txtAllEmpFlag = newTxtAllEmpFlag;
  }

  public String getButTxtEmpNo()
  {
    return butTxtEmpNo;
  }

  public void setButTxtEmpNo(String newButTxtEmpNo)
  {
    butTxtEmpNo = newButTxtEmpNo;
  }

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }

  public void setTxtPayCodeDesc(String newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  }



}