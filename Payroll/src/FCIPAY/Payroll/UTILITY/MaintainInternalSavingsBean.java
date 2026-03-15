package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MaintainInternalSavingsBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtSrlNo="";
  private String txtEmpNo="";
  private String txtEmpName="";
  private String txtSavCode="";
  private String txtDescription="";
  private String txtSavingsNumber="";
  private String txtValUpto="";
  private String txtAmount="";
 
  private String hdnSavCodeSrlNo="";
  
  private String txtSavingsDate="";
  private String txtLastYYMM="";
  
  //////////added by sonia  09-02-2011 /////
   private String txtAgency="";  
   private String txtAgencyNo="";  
   private String txtAgencyName="";
   private String txtAgencySite="";
   private String txtAgencySiteCode="";
    //////////added by sonia on 09-02-2011 /////
    
    private String txtCreationDate; //added by varalika
   private String txtCreatedBy; //added by varalika
   private String txtCreatedSite; //added by varalika
   private String txtUpdationDate; //added by varalika
   private String txtUpdatedBy; //added by varalika
   private String txtUpdatedSite; //added by varalika
  

  public MaintainInternalSavingsBean()
  {
  }

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
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

  public String getTxtSavCode()
  {
    return txtSavCode;
  }

  public void setTxtSavCode(String newTxtSavCode)
  {
    txtSavCode = newTxtSavCode;
  }

  public String getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }

  public String getTxtSavingsNumber()
  {
    return txtSavingsNumber;
  }

  public void setTxtSavingsNumber(String newTxtSavingsNumber)
  {
    txtSavingsNumber = newTxtSavingsNumber;
  }

  public String getTxtValUpto()
  {
    return txtValUpto;
  }

  public void setTxtValUpto(String newTxtValUpto)
  {
    txtValUpto = newTxtValUpto;
  }

  public String getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }

  /*public String getHdnCheck()
  {
    return hdnCheck;
  }

  public void setHdnCheck(String newHdnCheck)
  {
    hdnCheck = newHdnCheck;
  }*/

 public String getHdnSavCodeSrlNo()
  {
    return hdnSavCodeSrlNo;
  }

  public void setHdnSavCodeSrlNo(String newHdnSavCodeSrlNo)
  {
    hdnSavCodeSrlNo = newHdnSavCodeSrlNo;
  }

 
  public String getTxtSavingsDate()
  {
    return txtSavingsDate;
  }

  public void setTxtSavingsDate(String newTxtSavingsDate)
  {
    txtSavingsDate = newTxtSavingsDate;
  }

  public String getTxtLastYYMM()
  {
    return txtLastYYMM;
  }

  public void setTxtLastYYMM(String newTxtLastYYMM)
  {
    if(newTxtLastYYMM == null)
      txtLastYYMM = "N";
    else
      txtLastYYMM = newTxtLastYYMM;
  }
  
  //////////added by sonia  09-02-2011 /////
  
   public String getTxtAgency()
  {
    return txtAgency;
  }

  public void setTxtAgency(String newTxtAgency)
  {
    txtAgency = newTxtAgency;
  }

 public String getTxtAgencyNo()
  {
    return txtAgencyNo;
  }

  public void setTxtAgencyNo(String newTxtAgencyNo)
  {
    txtAgencyNo = newTxtAgencyNo;
  }
 
  public String getTxtAgencyName()
  {
    return txtAgencyName;
  }
  public void setTxtAgencyName(String newTxtAgencyName)
  {
    txtAgencyName = newTxtAgencyName;
  }
  public String getTxtAgencySite()
  {
    return txtAgencySite;
  }
  public void setTxtAgencySite(String newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }
  public String getTxtAgencySiteCode()
  {
    return txtAgencySiteCode;
  }
  public void setTxtAgencySiteCode(String newTxtAgencySiteCode)
  {
    txtAgencySiteCode = newTxtAgencySiteCode;
  } 
  //////////end added by sonia  09-02-2011 /////

//added by varalika on 30-Sep-2011//

 public String getTxtCreationDate()
  {
    return txtCreationDate;
  }

  public void setTxtCreationDate(String newtxtCreationDate)
  {

    txtCreationDate = newtxtCreationDate;
  }

 public String getTxtCreatedBy()
  {
    return txtCreatedBy;
  }

  public void setTxtCreatedBy(String newtxtCreatedBy)
  {
    txtCreatedBy = newtxtCreatedBy;
  }
  
  public String getTxtCreatedSite()
  {
    return txtCreatedSite;
  }

  public void setTxtCreatedSite(String newtxtCreatedSite)
  {
    txtCreatedSite = newtxtCreatedSite;
  }
//updation details
 public String getTxtUpdationDate()
  {
    return txtUpdationDate;
  }

  public void setTxtUpdationDate(String newtxtUpdationDate)
  {
    txtUpdationDate = newtxtUpdationDate;
  }

  public String getTxtUpdatedBy()
  {
    return txtUpdatedBy;
  }

  public void setTxtUpdatedBy(String newtxtUpdatedBy)
  {
    txtUpdatedBy = newtxtUpdatedBy;
  }
  
  public String getTxtUpdatedSite()
  {
    return txtUpdatedSite;
  }

  public void setTxtUpdatedSite(String newtxtUpdatedSite)
  {
    txtUpdatedSite = newtxtUpdatedSite;
  }

// code ends by varalika

}