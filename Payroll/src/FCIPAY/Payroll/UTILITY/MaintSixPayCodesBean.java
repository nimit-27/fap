    /*
    * Module:        MaintPayCodesBean.java
    * Author:        Surajeet Chakraborty
    * Date Written:  December 2004
    * Description:   Bean Class for Maintaining the Pay Codes
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class MaintSixPayCodesBean  extends PayrollBaseDetailBean implements Serializable
{
  private String txtSrlNo;
  private String txtPayCode = "";
  private String txtDescription = "";    
  private String txtDesg=""; 
  private String txtDsgnDesc="";
  private String txtEducation=""; 
  private String txtPercentage=""; 
  private String txtMobile=""; 
  private String txtConveyance=""; 
  private String txtStartDate=""; 
  private String txtEndDate="";

    public MaintSixPayCodesBean()
    {
    }
/*
  public MaintSixPayCodesBean(String sSrlNo, String sPayCode, String sDescription,String sDsgnDesc, String sEducation,String sMobile,String sConveyance,String sDesignation,String sStartdate,String sEnddate,String sPercentage)
   // public MaintainDirectPayrollBean(String sSrlNo,String sEmpNo,String sEmpName, String sPayCode, String sDescription, String sPayMode, String sValidFrom,String sAmount, String sInstAmt,String sNoInst,String sAdvBalance,String sAgency)

    {
        
        txtSrlNo=sSrlNo;       
        txtPayCode=sPayCode;
        txtDescription=sDescription;
        txtDesg=sDesignation;
        txtEducation =sEducation;
        txtPercentage =sPercentage;
        txtMobile =sMobile;
        txtConveyance =sConveyance;
        txtStartDate =sStartdate;
        txtEndDate=sEnddate;  
        txtDsgnDesc=sDsgnDesc;

    }
*/

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }
 public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }

  public String getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }


 



  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }


  public String getTxtDesg()
  {
    return txtDesg;
  }

  public void setTxtDesg(String newTxtDesg)
  {
    txtDesg = newTxtDesg;
  }
  
  public String getTxtMobile()
  {
    return txtMobile;
  }

  public void setTxtMobile(String newTxtMobile)
  {
    txtMobile = newTxtMobile;
  }
  
  public String getTxtConveyance()
  {
    return txtConveyance;
  }

  public void setTxtConveyance(String newTxtConveyance)
  {
    txtConveyance = newTxtConveyance;
  }
  
  public String getTxtEducation()
  {
    return txtEducation;
  }

  public void setTxtEducation(String newTxtEducation)
  {
    txtEducation = newTxtEducation;
  }
  public String getTxtPercentage()
  {
    return txtPercentage;
  }

  public void setTxtPercentage(String newTxtPercentage)
  {
    txtPercentage = newTxtPercentage;
  }
  public String getTxtStartDate()
  {
    return txtStartDate;
  }

  public void setTxtStartDate(String newTxtStartDate)
  {
    txtStartDate = newTxtStartDate;
  }
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  }
  

}