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

public class MaintainDirectPayrollBean  extends PayrollBaseDetailBean implements Serializable
{
   private String txtSrlNo;
   private String txtEmpNo = "";
   private String txtName = "";
    //private String txtCPFCode = "";

   private String txtPayCode = "";
   private String txtDescription = "";
   private String txtPayMode = "";
   private String txtValidFrom = "";
   private String txtAmount = "";
   private String txtInstAmount="";
   private String txtNoInst="";
   private String txtAdvBalance="";
   private String txtAgency="";
   private String txtPayrollFlag="";
   private String txtTxnCateg="";
   private String txtAgencyNo="";  
   private String txtAgencyName="";
   private String txtAgencySite="";
   private String txtAgencySiteCode="";
   private String txtSrNo;
   private String txtCreationDate; //added by Neeraj 27 oct 2010
   private String txtCreatedBy; //added by neeraj
   private String txtCreatedSite; //added by neeraj
   private String txtUpdationDate; //added by neeraj
   private String txtUpdatedBy; //added by neeraj
   private String txtUpdatedSite; //added by neeraj
   private String txtCategory ;// added by sonia on 02-02-2010
   private String txtPattern ;// added by sonia on 02-02-2010
   private String txtCPF ;// added by sonia on 02-02-2010
   private String txtEmpStatus ;// added by sonia on 07-07-2011
   private String txtSavNo; //added by swapnendu Dt 04 Feb 2013

    public MaintainDirectPayrollBean()
    {
    }

  public MaintainDirectPayrollBean(String sSrNo,String sSrlNo,String sEmpNo,String sEmpName, String sPayCode, String sDescription, String sPayMode, String sValidFrom,String sAmount, String sInstAmt,String sNoInst,String sAdvBalance,String sAgencyNo,String sAgencyName,String sAgencySite,String sAgency,String Category)
   // public MaintainDirectPayrollBean(String sSrlNo,String sEmpNo,String sEmpName, String sPayCode, String sDescription, String sPayMode, String sValidFrom,String sAmount, String sInstAmt,String sNoInst,String sAdvBalance,String sAgency)

    {
        txtSrNo=sSrNo;
        txtSrlNo=sSrlNo;
        txtEmpNo = sEmpNo;
        txtName = sEmpName;
        txtPayCode=sPayCode;
        txtDescription=sDescription;
        txtPayMode=sPayMode;
        //txtAmount=sAmount;
        txtValidFrom=sValidFrom;
        txtAmount=sAmount;
        txtInstAmount=sInstAmt;
        txtNoInst=sNoInst;
        txtAdvBalance=sAdvBalance;
        txtAgencyNo=sAgencyNo;
        txtAgencyName=sAgencyName;
        txtAgencySite=sAgencySite;
        txtAgency=sAgency;
        txtCategory=Category;

    }
//Added By Neeraj On 27 oct 2010
//added by neeraj starts here//

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

//added by neeraj ends here//


//End of Added By Neeraj on 27 oct 2010



 public String getTxtSrNo()
  {
    return txtSrNo;
  }

  public void setTxtSrNo(String newTxtSrNo)
  {
    txtSrNo = newTxtSrNo;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtName()
  {
    return txtName;
  }

  public void setTxtName(String newTxtName)
  {
    txtName = newTxtName;
  }
/* public String getTxtCPFCode()
  {
    return txtCPFCode;
  }

  public void setTxtCPFCode(String newTxtCPFCode)
  {
    txtCPFCode= newTxtCPFCode;
  }*/
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }

  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }



  public String getTxtValidFrom()
  {
    return txtValidFrom;
  }

  public void setTxtValidFrom(String newTxtValidFrom)
  {
    txtValidFrom = newTxtValidFrom;
  }

  public String getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }





  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

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
   public String getTxtNoInst()
  {
    return txtNoInst;
  }
  public void setTxtNoInst(String newTxtNoInst)
  {
    txtNoInst = newTxtNoInst;
  }

  public String getTxtInstAmount()
  {
    return txtInstAmount;
  }

  public void setTxtInstAmount(String newTxtInstAmount)
  {
    txtInstAmount = newTxtInstAmount;
  }

  public String getTxtPayrollFlag()
  {
    return txtPayrollFlag;
  }

  public void setTxtPayrollFlag(String newTxtPayrollFlag)
  {
    txtPayrollFlag = newTxtPayrollFlag;
  }

  public String getTxtAdvBalance()
  {
    return txtAdvBalance;
  }

  public void setTxtAdvBalance(String newTxtAdvBalance)
  {
    txtAdvBalance = newTxtAdvBalance;
  }

  public String getTxtTxnCateg()
  {
    return txtTxnCateg;
  }

  public void setTxtTxnCateg(String newTxtTxnCateg)
  {
    txtTxnCateg = newTxtTxnCateg;
  }
/////////////start added by sonia on 02-02-2011/////////////
public String getTxtCategory()
  {
    return txtCategory;
  }
  public void setTxtCategory(String newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }

  public void setTxtPattern(String newTxtPattern)
  {
    txtPattern = newTxtPattern;
  }
  public String getTxtPattern()
  {
    return txtPattern;
  }

  public void setTxtCPF(String newTxtCPF)
  {
    txtCPF = newTxtCPF;
  }
  public String getTxtCPF()
  {
    return txtCPF;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtSavNo(String newTxtSavNo)
  {
    txtSavNo = newTxtSavNo;
  }
  
  public String getTxtSavNo()
  {
    return txtSavNo;
  }
  
//txtEmpStatus
/////////////////end added by sonia on 02-02-2011  txtCPF/////////////
///commented by sonia
 // public String getTxtAgencyName()
  //{
  //  return txtAgencyName;
  //}

  //public void setTxtAgencyName(String newTxtAgencyName)
 // {
 //   txtAgencyName = newTxtAgencyName;
 // }


 // public String getTxtAgencySite()
 // {
 //   return txtAgencySite;
 // }

 // public void setTxtAgencySite(String newTxtAgencySite)
 // {
 //   txtAgencySite = newTxtAgencySite;
 // }

//  public String getTxtAgencySiteCode()
 // {
 //   return txtAgencySiteCode;
 // }

 // public void setTxtAgencySiteCode(String newTxtAgencySiteCode)
 // {
 //   txtAgencySiteCode = newTxtAgencySiteCode;
 // }


}