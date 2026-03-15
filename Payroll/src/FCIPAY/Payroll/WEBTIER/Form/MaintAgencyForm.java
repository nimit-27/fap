package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


public class MaintAgencyForm extends PayrollBaseForm 
{
 
  private String txtAgeCode[]=null;
  private String txtAgeName[]=null;
  private String txtAdd[]=null;
  private String txtFavour[]=null;
  private String txtMode[]=null;
  private String txtDraw[]=null;
  private ArrayList lstInstrDtls=new ArrayList();
  private String txtSite[]=null;

 
  public String[] getTxtAgeCode()
  {
    return txtAgeCode;
  }

  public void setTxtAgeCode(String[] newTxtAgeCode)
  {
    txtAgeCode = newTxtAgeCode;
  }

  public String[] getTxtAgeName()
  {
    return txtAgeName;
  }

  public void setTxtAgeName(String[] newTxtAgeName)
  {
    txtAgeName = newTxtAgeName;
  }

  public String[] getTxtAdd()
  {
    return txtAdd;
  }

  public void setTxtAdd(String[] newTxtAdd)
  {
    txtAdd = newTxtAdd;
  }

  public String[] getTxtFavour()
  {
    return txtFavour;
  }

  public void setTxtFavour(String[] newTxtFavour)
  {
    txtFavour = newTxtFavour;
  }

  public String[] getTxtMode()
  {
    return txtMode;
  }

  public void setTxtMode(String[] newTxtMode)
  {
    txtMode = newTxtMode;
  }

  public String[] getTxtDraw()
  {
    return txtDraw;
  }

  public void setTxtDraw(String[] newTxtDraw)
  {
    txtDraw = newTxtDraw;
  }



  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public String[] getTxtSite()
  {
    return txtSite;
  }

  public void setTxtSite(String[] newTxtSite)
  {
    txtSite = newTxtSite;
  }


  
 }