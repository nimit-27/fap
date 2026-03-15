package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import java.lang.String;
public class MaintPaycodeVSAgencycodeForm extends PayrollBaseForm
{

  private ArrayList paycodevsAgency = new ArrayList();
  private String[]  txtPayCode;
  private String[]  txtAgency;
  private String[]  txtAgencySite;
  private String[]  txtLocation;
  private String[]  txtLocationDesc;
  private String[]  txtEmployeeNo;
  private String[]  txtPayCodeDesc;
  private String[]  txtEmployeeNoDesc;
  private String[]  txtAgencySiteDesc;
  private String[]  txtAgencyDesc;
  
public String[] getTxtPayCode()
  {
    return txtPayCode;
  }
  
  public void setTxtPayCode(String[] newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }
  public String[] getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }
  
  public void setTxtPayCodeDesc(String[] newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  }
  public String[] getTxtAgency()
  {
    return txtAgency;
  }
  
  public void setTxtAgency(String[] newTxtAgency)
  {
    txtAgency=newTxtAgency;
  }
  
  
    public String[] getTxtAgencyDesc()
  {
    return txtAgencyDesc;
  }
  
  public void setTxtAgencyDesc(String[] newTxtAgencyDesc)
  {
    txtAgencyDesc=newTxtAgencyDesc;
  }
  
  
  
  public String[] getTxtAgencySite()
  {
    return txtAgencySite;
  }
  
  public void setTxtAgencySite(String[] newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }
  
  
  
    public String[] getTxtAgencySiteDesc()
  {
    return txtAgencySiteDesc;
  }
  
  public void setTxtAgencySiteDesc(String[] newTxtAgencySiteDesc)
  {
    txtAgencySiteDesc = newTxtAgencySiteDesc;
  }
  
  public String[] getTxtLocationDesc()
  
  {
    return txtLocationDesc;
  }
  
  public void setTxtLocationDesc(String[] newTxtLocationDesc)
  {
    txtLocationDesc = newTxtLocationDesc;
  }
  public String[] getTxtLocation()
  
  {
    return txtLocation;
  }
  
  public void setTxtLocation(String[] newTxtLocation)
  {
    txtLocation = newTxtLocation;
  }
  
  public String[] getTxtEmployeeNo()
  {
    return txtEmployeeNo;
  }
  
  public void setTxtEmployeeNo(String[] newTxtEmployeeNo)
  {
    txtEmployeeNo = newTxtEmployeeNo;
  }
  
   public String[] getTxtEmployeeNoDesc()
  {
    return txtEmployeeNoDesc;
  }
  
  public void setTxtEmployeeNoDesc(String[] newTxtEmployeeNoDesc)
  {
    txtEmployeeNoDesc = newTxtEmployeeNoDesc;
  }
  
  
  public ArrayList getPaycodevsAgency()
  {
    return paycodevsAgency;
  }
  
  public void setPaycodevsAgency(ArrayList newPaycodevsAgency)
  {
    paycodevsAgency=newPaycodevsAgency;
  }
}