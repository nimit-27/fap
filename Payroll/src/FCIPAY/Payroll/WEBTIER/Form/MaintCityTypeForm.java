package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintCityTypeBean;

public class MaintCityTypeForm extends PayrollBaseForm 
{
  private String txtCityType[]=null;
  private String txtDesc[]=null;
  private String txtCities[]=null;
  private ArrayList lstInstrDtls=new ArrayList();

  public MaintCityTypeForm()
  {
  }

  public String[] getTxtCityType()
  {
    return txtCityType;
  }

  public void setTxtCityType(String[] newTxtCityType)
  {
    txtCityType = newTxtCityType;
  }

  public String[] getTxtDesc()
  {
    return txtDesc;
  }

  public void setTxtDesc(String[] newTxtDesc)
  {
    txtDesc = newTxtDesc;
  }

  public String[] getTxtCities()
  {
    return txtCities;
  }

  public void setTxtCities(String[] newTxtCities)
  {
    txtCities = newTxtCities;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
}