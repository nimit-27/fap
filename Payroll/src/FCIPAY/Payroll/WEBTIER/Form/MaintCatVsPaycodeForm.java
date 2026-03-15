package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintCatVsPaycodeForm extends PayrollBaseForm 
{
    
  private ArrayList catVsPayCode=new ArrayList();
  private String optVal;
  private String txtPayCodeDescHdr;
  private String txtPayCodeHdr;  
  private String txtLocDescHdr;
  private String txtLocHdr;
  private String txtCategory;
  private String [] txtPayCodeDesc;
  private String [] txtPayCode;

   public String getTxtCategory()
  {
    return txtCategory;
  }

  public void setTxtCategory(String newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }
    
    
    
    
    
    
    
    
  public ArrayList getCatVsPayCode()
  {
    return catVsPayCode;
  }

  public void setCatVsPayCode(ArrayList newCatVsPayCode)
  {
    catVsPayCode = newCatVsPayCode;
  }
  
  public String getTxtPayCodeDescHdr()
  {
    return txtPayCodeDescHdr;
  }

  public void setTxtPayCodeDescHdr(String newTxtPayCodeDescHdr)
  {
    txtPayCodeDescHdr = newTxtPayCodeDescHdr;
  }
  
  public String getTxtPayCodeHdr()
  {
    return txtPayCodeHdr;
  }

  public void setTxtPayCodeHdr(String newTxtPayCodeHdr)
  {
    txtPayCodeHdr = newTxtPayCodeHdr;
  }

  public String getTxtLocDescHdr()
  {
    return txtLocDescHdr;
  }

  public void setTxtLocDescHdr(String newTxtLocDescHdr)
  {
    txtLocDescHdr = newTxtLocDescHdr;
  }

  public String getTxtLocHdr()
  {
    return txtLocHdr;
  }

  public void setTxtLocHdr(String newTxtLocHdr)
  {
    txtLocHdr = newTxtLocHdr;
  }

  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
  }

  public String [] getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }

  public void setTxtPayCodeDesc(String[] newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  }
  
  public String [] getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String[] newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }


  




}