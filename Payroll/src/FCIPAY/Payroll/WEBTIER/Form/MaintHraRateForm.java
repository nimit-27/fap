package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
//import IBA.Payroll.UTILITY.MaintHraHrrRateBean;

public class MaintHraRateForm extends PayrollBaseForm 
{
  private String txtHRAAmt[];
  private String txtTypeofCity[];
    
  private ArrayList lstInstrDtls=new ArrayList();
  
  private String optPayScaleType;
  private String txtType[];
  private String txtSrlNo[];
  private String txtEffDate[];

  public String[] getTxtHRAAmt()
  {
    return txtHRAAmt;
  }

  public void setTxtHRAAmt(String[] newTxtHRAAmt)
  {
    txtHRAAmt = newTxtHRAAmt;
  }

  public String[] getTxtTypeofCity()
  {
    return txtTypeofCity;
  }

  public void setTxtTypeofCity(String[] newTxtTypeofCity)
  {
    txtTypeofCity = newTxtTypeofCity;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }


  public String getOptPayScaleType()
  {
    return optPayScaleType;
  }

  public void setOptPayScaleType(String newOptPayScaleType)
  {
    optPayScaleType = newOptPayScaleType;
  }

  public String[] getTxtType()
  {
    return txtType;
  }

  public void setTxtType(String[] newTxtType)
  {
    txtType = newTxtType;
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String[] getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String[] newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }





}