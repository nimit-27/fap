package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
public class ReportInfo implements Serializable
{
  private String keyinfo;
  private String reportkey;
  
  public ReportInfo()
  {
  }

 
  public String getKeyInfo()
  {
    return keyinfo;
  }

  public void setKeyInfo(String newKeyinfo)
  {
    keyinfo = newKeyinfo;
  }

 public String getReportKey()
  {
    return reportkey;
  }

  public void setReportKey(String newReportKey)
  {
    reportkey = newReportKey;
  }

  
}
