package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MaintainExternalSavingsBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtSrlNo="";
  private String txtEmpNo="";
  private String txtEmpName="";
  private String txtSavCode="";
  private String txtDescription="";
  private String txtType="";
  private String txtSavingsNumber="";
  private String txtSavingsYear="";
  private String txtAmount="";
  //private String hdnCheck="";
  //private String chkDel;
  private String hdnSavCodeSrlNo="";
  
   // added by varalika on 30-Sep-2011
   private String txtCreationDate; 
   private String txtCreatedBy; 
   private String txtCreatedSite; 
   private String txtUpdationDate; 
   private String txtUpdatedBy; 
   private String txtUpdatedSite; 
   //ended by varalika
 

  public MaintainExternalSavingsBean()
  {
  }
  public MaintainExternalSavingsBean(String sEmpNo,String sEmpName, String sSavCode, String sDescription, String sType, String sSavingsNumber, String sSavingsYear, String sAmount, String sSavCodeSrlNo)
    {
        //txtSrNo=sSrNo;
        txtEmpNo = sEmpNo;
        txtEmpName = sEmpName;
        txtSavCode=sSavCode;
        txtDescription=sDescription;
        txtSavingsNumber=sSavingsNumber;
        txtSavingsYear=sSavingsYear;
        txtAmount=sAmount;
         txtType=sType; 
        hdnSavCodeSrlNo=sSavCodeSrlNo;
        //hdnCheck = sCheck;
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

  public String getTxtType()
  {
    return txtType;
  }

  public void setTxtType(String newTxtType)
  {
    txtType = newTxtType;
  }

  public String getTxtSavingsNumber()
  {
    return txtSavingsNumber;
  }

  public void setTxtSavingsNumber(String newTxtSavingsNumber)
  {
    txtSavingsNumber = newTxtSavingsNumber;
  }

  public String getTxtSavingsYear()
  {
    return txtSavingsYear;
  }

  public void setTxtSavingsYear(String newTxtSavingsYear)
  {
    txtSavingsYear = newTxtSavingsYear;
  }

  public String getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }

 /* public String getHdnCheck()
  {
    return hdnCheck;
  }

  public void setHdnCheck(String newHdnCheck)
  {
    hdnCheck = newHdnCheck;
  }*/

 /* public String getChkDel()
  {
    return chkDel;
  }

  public void setChkDel(String newChkDel)
  {
    chkDel = newChkDel;
  }*/

  public String getHdnSavCodeSrlNo()
  {
    return hdnSavCodeSrlNo;
  }

  public void setHdnSavCodeSrlNo(String newHdnSavCodeSrlNo)
  {
    hdnSavCodeSrlNo = newHdnSavCodeSrlNo;
  }
  
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