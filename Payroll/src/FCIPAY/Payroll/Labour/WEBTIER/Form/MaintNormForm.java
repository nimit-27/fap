package FCIPAY.Payroll.Labour.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import java.util.ArrayList;

public class MaintNormForm extends PayrollBaseForm 
{
  private ArrayList lstInstrDtls=new ArrayList();
  private String [] txtRate;
  private String [] startField;
  private String [] endField;
  private String [] txtNormId;
  private String [] txtBagTyp;
  private String txtNormTyp;
  private String txtSiteId;
  private String txtSiteName;
  private String txtMou;
  private String txtEffDate;
  
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
   public String[] getStartField()
  {
    return startField;
  }

  public void setStartField(String[] newStartField)
  {
    startField = newStartField;
  }
  
   public String[] getEndField()
  {
    return endField;
  }

  public void setEndField(String[] newEndField)
  {
    endField = newEndField;
  }
  
  public String[] getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String[] newTxtRate)
  {
    txtRate = newTxtRate;
  }
  
  public String[] getTxtNormId()
  {
    return txtNormId;
  }

  public void setTxtNormId(String[] newTxtNormId)
  {
    txtNormId = newTxtNormId;
  }
  
  public String getTxtNormTyp()
  {
    return txtNormTyp;
  }

  public void setTxtNormTyp(String newTxtNormTyp)
  {
    txtNormTyp = newTxtNormTyp;
  }
  
   public String getTxtSiteId()
  {
    return txtSiteId;
  }

  public void setTxtSiteId(String newTxtSiteId)
  {
    txtSiteId = newTxtSiteId;
  }
  
   public String getTxtSiteName()
  {
    return txtSiteName;
  }

  public void setTxtSiteName(String newTxtSiteName)
  {
    txtSiteName = newTxtSiteName;
  }

   public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }
  
   public String getTxtMou()
  {
    return txtMou;
  }

  public void setTxtMou(String newTxtMou)
  {
    txtMou = newTxtMou;
  }
  
  public String[] getTxtBagTyp()
  {
    return txtBagTyp;
  }

  public void setTxtBagTyp(String[] newTxtBagTyp)
  {
    txtBagTyp = newTxtBagTyp;
  }
  

}