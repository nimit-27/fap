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

public class MaintainDirectPayrollBean22092010  extends PayrollBaseDetailBean implements Serializable
{
    private String txtSrNo = "";
    private String txtEmpNo = "";
    private String txtName = "";
    //private String txtCPFCode = "";

    private String txtPayCode = "";
    private String txtDescription = "";
    private String txtPayMode = "";
    private String txtAmount = "";
    private String txtValidFrom = "";
  private String txtSrlNo;
  private String txtAgency="";
  private String txtNoInst="";
  private String txtInstAmount="";
  private String txtPayrollFlag;
  private String txtAdvBalance;
  private String txtTxnCateg;
  private String txtAgencyName;
  private String txtAgencySite;
  private String txtAgencySiteCode;

    public MaintainDirectPayrollBean22092010()
    {
    }

    public MaintainDirectPayrollBean22092010(String sEmpNo,String sEmpName, String sPayCode, String sDescription, String sPayMode, String sValidFrom,String sAmount, String sSrlNo,String sAgency,String sInstAmt,String sNoInst)
    {
        //txtSrNo=sSrNo;
        txtEmpNo = sEmpNo;
        txtName = sEmpName;
        txtPayCode=sPayCode;
        txtDescription=sDescription;
        txtPayMode=sPayMode;
        txtAmount=sAmount;
        txtValidFrom=sValidFrom;
        txtSrlNo=sSrlNo;
        txtAgency=sAgency;
        txtInstAmount=sInstAmt;
        txtNoInst=sNoInst;
     //   txtCPFCode=sCPFCode;
    }

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


}