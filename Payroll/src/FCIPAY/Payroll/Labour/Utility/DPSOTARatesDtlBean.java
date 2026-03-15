package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
public class DPSOTARatesDtlBean extends PayrollBaseDetailBean
{   
  //private String txtYYMM = "";
  //private String txtLocId="";
  private String txtSrNo = null;
  private String txtRate=null;   
  private String txtSrlNo=null;    
  private String endDate=null;
  private String startDate=null;    
  
  public DPSOTARatesDtlBean()
  {
  }  
 
  /*public String getTxtYYMM()
  {
      return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
      txtYYMM = newTxtYYMM;
  }  
  
  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  }*/
  
  public String gettxtSrNo()
  {
      return txtSrNo;
  }    

  public void settxtSrNo(String newtxtSrNo)
  {
      txtSrNo = newtxtSrNo;
  }
  
   public String getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String newTxtRate)
  {
    txtRate = newTxtRate;
  }
  
  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }
  
  public String getEndDate()
  {
    return endDate;
  }

  public void setEndDate(String newEndDate)
  {
    endDate = newEndDate;
  }

  public String getStartDate()
  {
    return startDate;
  }

  public void setStartDate(String newStartDate)
  {
    startDate = newStartDate;
  }
  
}