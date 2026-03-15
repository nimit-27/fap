package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintPayCodeAgencyMapForm extends PayrollBaseForm 
{
    
  private ArrayList lstInstrDtls=new ArrayList();
  private String optVal;
  private String txtPayCodeDescHdr;
  private String txtPayCodeHdr;  
  private String txtLocDescHdr;
  private String txtLocHdr;
  
  private String [] txtPayCodeDesc;
  private String [] txtPayCode;
  private String [] txtAgencyCode;
  private String [] txtAgencySite;
  private String [] txtLoc;
  private String [] txtEmpNo;
  private String [] txtEmpName;
  private String [] txtLocDesc;
    
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
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
  
  public String [] getTxtAgencyCode()
  {
    return txtAgencyCode;
  }

  public void setTxtAgencyCode(String[] newTxtAgencyCode)
  {
    txtAgencyCode = newTxtAgencyCode;
  }
  
  public String [] getTxtAgencySite()
  {
    return txtAgencySite;
  }

  public void setTxtAgencySite(String[] newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }
 
  public String [] getTxtLoc()
  {
    return txtLoc;
  }

  public void setTxtLoc(String[] newTxtLoc)
  {
    txtLoc = newTxtLoc;
  }
  
  public String [] getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String[] newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String [] getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String[] newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String [] getTxtLocDesc()
  {
    return txtLocDesc;
  }

  public void setTxtLocDesc(String[] newTxtLocDesc)
  {
    txtLocDesc = newTxtLocDesc;
  }

}