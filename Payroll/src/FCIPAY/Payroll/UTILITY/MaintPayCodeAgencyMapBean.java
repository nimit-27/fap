package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;


public class MaintPayCodeAgencyMapBean extends PayrollBaseDetailBean implements Serializable
{

  private String txtPayCodeDesc;
  private String txtPayCode;
  private String txtAgencyCode;
  private String txtAgencySite;
  private String txtLoc;
  private String txtEmpNo;
  private String txtEmpName;
  private String txtLocDesc;

  public MaintPayCodeAgencyMapBean()
  {
  }

  public String getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }

  public void setTxtPayCodeDesc(String newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  }
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }
  
  public String getTxtAgencyCode()
  {
    return txtAgencyCode;
  }

  public void setTxtAgencyCode(String newTxtAgencyCode)
  {
    txtAgencyCode = newTxtAgencyCode;
  }
  
  public String getTxtAgencySite()
  {
    return txtAgencySite;
  }

  public void setTxtAgencySite(String newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }
 
  public String getTxtLoc()
  {
    return txtLoc;
  }

  public void setTxtLoc(String newTxtLoc)
  {
    txtLoc = newTxtLoc;
  }
  
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtLocDesc()
  {
    return txtLocDesc;
  }

  public void setTxtLocDesc(String newTxtLocDesc)
  {
    txtLocDesc = newTxtLocDesc;
  }
}