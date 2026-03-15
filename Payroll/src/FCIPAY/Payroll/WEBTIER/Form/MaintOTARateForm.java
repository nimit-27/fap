package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintOTARateForm extends PayrollBaseForm 
{
  private ArrayList lstInstrDtls=new ArrayList();
  private String [] txtOTATyp;
  private String [] txtRate;
  
 
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  
  public String [] getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String[] newTxtRate)
  {
    txtRate = newTxtRate;
  }
  
  public String [] getTxtOTATyp()
  {
    return txtOTATyp;
  }

  public void setTxtOTATyp(String[] newTxtOTATyp)
  {
    txtOTATyp = newTxtOTATyp;
  }
}