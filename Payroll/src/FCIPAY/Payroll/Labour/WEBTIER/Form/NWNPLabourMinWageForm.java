package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class NWNPLabourMinWageForm extends PayrollBaseForm
{
  private String txtCityType;    // added by dushyant on 19-April-2011
  private String txtPieceRate;
  private String txtEffDate;
  private String txtEndDate;  
  private String txtVDA;

  public NWNPLabourMinWageForm()
  {
  }

  public String getTxtPieceRate()
  {
    return txtPieceRate;
  }

  public void setTxtPieceRate(String newTxtPieceRate)
  {
    txtPieceRate = newTxtPieceRate;
  }  
  
  public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }
  
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  } 
  
 // added by dushyant on 19-April-2011
 public String getTxtCityType()
  {
    return txtCityType;
  }

  public void setTxtCityType(String newTxtCityType)
  {
    txtCityType = newTxtCityType;
  }   
 // end by dushyant on 19-April-2011
 public String getTxtVDA()
 {
 return txtVDA;
 }

 public void setTxtVDA(String newTxtVDA)
 {
 txtVDA = newTxtVDA;
 }
}


