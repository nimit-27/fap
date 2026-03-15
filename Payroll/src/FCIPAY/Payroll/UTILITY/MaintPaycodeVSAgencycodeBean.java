package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
public class MaintPaycodeVSAgencycodeBean extends PayrollBaseDetailBean implements Serializable
{

  public String txtPayCode="";
  public String txtAgency="";
  public String txtAgencyDesc="";
  public String txtAgencySite="";
  public String txtLocation="";
  public String txtLocationDesc="";
  public String txtEmployeeNo="";
  public String txtPayCodeDesc="";
  public String txtEmployeeNoDesc="";
  public String txtAgencySiteDesc="";
 
  
  public MaintPaycodeVSAgencycodeBean()
  {
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
  
  public String getTxtAgency()
  {
    return txtAgency;
  }
  
  public void setTxtAgency(String newTxtAgency)
  {
    txtAgency=newTxtAgency;
  }
  
  
    public String getTxtAgencyDesc()
  {
    return txtAgencyDesc;
  }
  
  public void setTxtAgencyDesc(String newTxtAgencyDesc)
  {
    txtAgencyDesc=newTxtAgencyDesc;
  }
  
  
  
  public String getTxtAgencySite()
  {
    return txtAgencySite;
  }
  
  public void setTxtAgencySite(String newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }
  
   public String getTxtAgencySiteDesc()
  {
    return txtAgencySiteDesc;
  }
  
  public void setTxtAgencySiteDesc(String newTxtAgencySiteDesc)
  {
    txtAgencySiteDesc = newTxtAgencySiteDesc;
  } 
  

  
  public String getTxtLocation()
  
  {
    return txtLocation;
  }
  
  public void setTxtLocation(String newTxtLocation)
  {
    txtLocation = newTxtLocation;
  }
   public String getTxtLocationDesc()
  
  {
    return txtLocationDesc;
  }
  
  public void setTxtLocationDesc(String newTxtLocationDesc)
  {
    txtLocationDesc = newTxtLocationDesc;
  }
  public String getTxtEmployeeNo()
  {
    return txtEmployeeNo;
  }
  
  public void setTxtEmployeeNo(String newTxtEmployeeNo)
  {
    txtEmployeeNo = newTxtEmployeeNo;
  }
  public String getTxtEmployeeNoDesc()
  {
    return txtEmployeeNoDesc;
  }
  
  public void setTxtEmployeeNoDesc(String newTxtEmployeeNoDesc)
  {
    txtEmployeeNoDesc = newTxtEmployeeNoDesc;
  }
 
}