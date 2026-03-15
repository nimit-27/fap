package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class EmpDpndntNomHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{  
  private String txtEmpNo;
  private String txtEmpName;  
  private String txtDsgnDesc;  
  private String txtCategDesc; 
  private String txtCpfCode;
  private String txtEmpType;
  private String txtDOJSite;
  private String txtEmpStatus;  
  private String txtDOR;
  
  public EmpDpndntNomHeaderBean()
  {
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
     
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }  
  
  public String getTxtCategDesc()
  {
    return txtCategDesc;
  }

  public void setTxtCategDesc(String newTxtCategDesc)
  {
    txtCategDesc = newTxtCategDesc;
  }
  
  public String getTxtEmpType()
  {
    return txtEmpType;
  }

  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }  

  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
  
  public String getTxtDOJSite()
  {
    return txtDOJSite;
  }

  public void setTxtDOJSite(String newTxtDOJSite)
  {
    txtDOJSite = newTxtDOJSite;
  }

  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  } 
  
  public String getTxtDOR()
  {
    return txtDOR;
  }

  public void setTxtDOR(String newTxtDOR)
  {
    txtDOR = newTxtDOR;
  } 

}