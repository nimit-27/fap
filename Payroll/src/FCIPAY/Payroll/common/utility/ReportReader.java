package FCIPAY.Payroll.common.utility;

public class ReportReader 
{
  String parameter;
  String parameterValue;

  public ReportReader()
  {
  }

  public String getAppServerName()
  {
     /* 
     return "fcilekha1.in";
     return "fcifap-apps01.nic.in"; //for PROD
     return "fcidev.nic.in";  //for BUILD
     return "fcisit-apps01.nic.in"; //for TESTDC
     return "fciuatdr-apps01.nic.in"; //for TEST
    */
    // FOR CLOUD
    return "fciapp1"; //for PROD 1

  }
 
  public String getAppServerPortNumber()
  {
    
     return "9007";
     
  }


  public String getAppServerReportPathAlias()
  {
    return "reports";
  }


  public String getRepKey()
  {
    /*
        
        return "FCIBUILDReport"; //for BUILD   
        return "FCIBUILDReport"; //for TESTDC   
        return "FCITESTReport";   //for TEST
    */
     //for PROD
     return "FCIPRODReport";  //for PROD
      
  }

  public String getRepPath()
  {
   return "";
  }
  
  public String getParameter()
  {
    return parameter;
  }

  public void setParameter(String newParameter)
  {
    parameter = newParameter;
  }

  public String getParameterValue()
  {
    return parameterValue;
  }

  public void setParameterValue(String newParameterValue)
  {
    parameterValue = newParameterValue;
  }
}
