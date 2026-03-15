package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class LeaseAccomBean extends PayrollBaseDetailBean implements Serializable 
{
  private String txtFromDate;
  private String txtToDate;
  private String hdnSrlNo;
  private String txtAccomTyp;
  private String txtHraAmt;
  private String txtLicenseFee;
  private String txtLeaseAmt;
  private String txtLeasePerc;
  /*private String txtArrearInst;
  private String txtArrearFlag;
  private String txtMaxInst;*/
  
// added by varalika on 30-Sep-2011
   private String txtCreationDate; 
   private String txtCreatedBy; 
   private String txtCreatedSite; 
   private String txtUpdationDate; 
   private String txtUpdatedBy; 
   private String txtUpdatedSite; 
 // ended by varalika
  public LeaseAccomBean()
  {
  }

  public String getTxtFromDate()
  {
    return txtFromDate;
  }

  public void setTxtFromDate(String newTxtFromDate)
  {
    txtFromDate = newTxtFromDate;
  }

  public String getTxtToDate()
  {
    return txtToDate;
  }

  public void setTxtToDate(String newTxtToDate)
  {
    txtToDate = newTxtToDate;
  }

  public String getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }
  

  public String getTxtAccomTyp()
  {
    return txtAccomTyp;
  }

  public void setTxtAccomTyp(String newTxtAccomTyp)
  {
    txtAccomTyp = newTxtAccomTyp;
  }

  public String getTxtHraAmt()
  {
    return txtHraAmt;
  }

  public void setTxtHraAmt(String newTxtHraAmt)
  {
    txtHraAmt = newTxtHraAmt;
  }

  public String getTxtLicenseFee()
  {
    return txtLicenseFee;
  }

  public void setTxtLicenseFee(String newTxtLicenseFee)
  {
    txtLicenseFee = newTxtLicenseFee;
  }

  public String getTxtLeaseAmt()
  {
    return txtLeaseAmt;
  }

  public void setTxtLeaseAmt(String newTxtLeaseAmt)
  {
    txtLeaseAmt = newTxtLeaseAmt;
  }
  
  public String getTxtLeasePerc()
  {
    return txtLeasePerc;
  }

  public void setTxtLeasePerc(String newTxtLeasePerc)
  {
    txtLeasePerc = newTxtLeasePerc;
  }

  /*public String getTxtArrearInst()
  {
    return txtArrearInst;
  }

  public void setTxtArrearInst(String newTxtArrearInst)
  {
    txtArrearInst = newTxtArrearInst;
  }
  
  public String getTxtArrearFlag()
  {
    return txtArrearFlag;
  }

  public void setTxtArrearFlag(String newTxtArrearFlag)
  {
    txtArrearFlag = newTxtArrearFlag;
  }
  
  public String getTxtMaxInst()
  {
    return txtMaxInst;
  }

  public void setTxtMaxInst(String newTxtMaxInst)
  {
    txtMaxInst = newTxtMaxInst;
  }*/
  
   //added by varalika on 30-Apr-2011//
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
// ended by varalika
}