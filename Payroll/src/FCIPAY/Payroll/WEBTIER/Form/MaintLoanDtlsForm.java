package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintLoanDtlsForm extends PayrollBaseForm
{
  private String txtEmpNo;
  private String txtEmpName;
  private String txtDsgn;
  private String txtCateg;
  private String txtPresentPOP;
  private String loanType[];
  private String loanAmnt[];
  private String sanctionDate[];
  private String sanctionNo[];
  private String recStartDate[];
  private String noofPrnInstall[];
  private String noofIntInstall[];
  private String installAmnt[];
  private String firstInstallAmnt[];
  private String intInstallAmnt[];
  private String intAmnt[];
  private String txtIntRate[]; 
  private String invoiceNo[];                                   // added by duhsyant on 29-11-2010  
  private ArrayList lstInstrDtls = new ArrayList();
  private ArrayList lstInstrAdminDtls= new ArrayList();
  private String flag;
  private String loanDesc[];
  private String transMastId[];
  private String [] loanFlag;
  private String hdnHeaderFlag;
  
  private String [] balInstall;
  private String [] paidInstall;
  private String [] paidAmt;
  private String [] balPrnAmt;
  private String [] balIntAmt;
  private String [] txtITAmt;
  
   // added by varalika on 03-Oct-2011
  private String txtCreationDate[]=null;  
  private String txtCreatedBy[]=null;  
  private String txtCreatedSite[]=null; 
  private String txtUpdationDate[]=null; 
  private String txtUpdatedBy[]=null; 
  private String txtUpdatedSite[]=null; 
  private String txtButAction;
 // ended by varalika
  
  public MaintLoanDtlsForm()
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
  
  public String getTxtDsgn()
  {
    return txtDsgn;
  }
  
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  public String[] getLoanType()
  {
    return loanType;
  }

  public void setLoanType(String[] newLoanType)
  {
    loanType = newLoanType;
  }
  
  public String[] getLoanAmnt()
  {
    return loanAmnt;
  }

  public void setLoanAmnt(String[] newLoanAmnt)
  {
    loanAmnt = newLoanAmnt;
  }

  public String[] getSanctionDate()
  {
    return sanctionDate;
  }

  public void setSanctionDate(String[] newSanctionDate)
  {
    sanctionDate = newSanctionDate;
  }
  
  public String[] getSanctionNo()
  {
    return sanctionNo;
  }

  public void setSanctionNo(String[] newSanctionNo)
  {
    sanctionNo = newSanctionNo;
  }

  public String[] getRecStartDate()
  {
    return recStartDate;
  }

  public void setRecStartDate(String[] newRecStartDate)
  {
    recStartDate = newRecStartDate;
  }
  
  public String[] getNoofPrnInstall()
  {
    return noofPrnInstall;
  }

  public void setNoofPrnInstall(String[] newNoofPrnInstall)
  {
    noofPrnInstall = newNoofPrnInstall;
  }

  public String[] getNoofIntInstall()
  {
    return noofIntInstall;
  }

  public void setNoofIntInstall(String[] newNoofIntInstall)
  {
    noofIntInstall = newNoofIntInstall;
  }

  public String[] getInstallAmnt()
  {
    return installAmnt;
  }

  public void setInstallAmnt(String[] newInstallAmnt)
  {
    installAmnt = newInstallAmnt;
  }
  
  public String[] getFirstInstallAmnt()
  {
    return firstInstallAmnt;
  }

  public void setFirstInstallAmnt(String[] newFirstInstallAmnt)
  {
    firstInstallAmnt = newFirstInstallAmnt;
  }

  public String[] getTxtIntRate()
  {
    return txtIntRate;
  }

  public void setTxtIntRate(String[] newTxtIntRate)
  {
    txtIntRate = newTxtIntRate;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public ArrayList getLstInstrAdminDtls()
  {
    return lstInstrAdminDtls;
  }

  public void setLstInstrAdminDtls(ArrayList newLstInstrAdminDtls)
  {
    lstInstrAdminDtls = newLstInstrAdminDtls;
  }

  /*public boolean isFlag()
  {
    return flag;
  }

  public void setFlag(boolean newFlag)
  {
    flag = newFlag;
  }*/
  
  public String getFlag()
  {
    return flag;
  }
  
  public void setFlag(String newFlag)
  {
    flag = newFlag;
  }

  public String[] getLoanDesc()
  {
    return loanDesc;
  }

  public void setLoanDesc(String[] newLoanDesc)
  {
    loanDesc = newLoanDesc;
  }

  public String[] getTransMastId()
  {
    return transMastId;
  }

  public void setTransMastId(String[] newTransMastId)
  {
    transMastId = newTransMastId;
  }

  public String getHdnHeaderFlag()
  {
    return hdnHeaderFlag;
  }

  public void setHdnHeaderFlag(String newHdnHeaderFlag)
  {
    hdnHeaderFlag = newHdnHeaderFlag;
  }

  public String[] getIntInstallAmnt()
  {
    return intInstallAmnt;
  }

  public void setIntInstallAmnt(String[] newIntInstallAmnt)
  {
    intInstallAmnt = newIntInstallAmnt;
  }

  public String [] getLoanFlag()
  {
    return loanFlag;
  }

  public void setLoanFlag(String [] newLoanFlag)
  {
    loanFlag = newLoanFlag;
  }

  public String [] getIntAmnt()
  {
    return intAmnt;
  }

  public void setIntAmnt(String [] newIntAmnt)
  {
    intAmnt = newIntAmnt;
  }  

  public String [] getBalInstall()
  {
    return balInstall;
  }

  public void setBalInstall(String [] newBalInstall)
  {
    balInstall = newBalInstall;
  }  

  public String [] getPaidInstall()
  {
    return paidInstall;
  }

  public void setPaidInstall(String [] newPaidInstall)
  {
    paidInstall = newPaidInstall;
  }  

  public String [] getPaidAmt()
  {
    return paidAmt;
  }

  public void setPaidAmt(String [] newPaidAmt)
  {
    paidAmt = newPaidAmt;
  }  

  public String [] getBalPrnAmt()
  {
    return balPrnAmt;
  }

  public void setBalPrnAmt(String [] newBalPrnAmt)
  {
    balPrnAmt = newBalPrnAmt;
  }  

  public String [] getBalIntAmt()
  {
    return balIntAmt;
  }

  public void setBalIntAmt(String [] newBalIntAmt)
  {
    balIntAmt = newBalIntAmt;
  }  
  
  public String [] getTxtITAmt()
  {
    return txtITAmt;
  }

  public void setTxtITAmt(String [] newTxtITAmt)
  {
    txtITAmt = newTxtITAmt;
  }  

 // added by dushyant on 29-11-2010
 
  public String [] getInvoiceNo()
  {
    return invoiceNo;
  }

  public void setInvoiceNo(String [] newInvoiceNo)
  {
    invoiceNo = newInvoiceNo;
  }  
  
   //added by varalika on 03-Oct-2011//

 public String[] getTxtCreationDate()
  {
 // System.out.println("Creation_Date::::>"+txtCreationDate[0]);
    return txtCreationDate;
  }

  public void setTxtCreationDate(String[] newtxtCreationDate)
  {
    txtCreationDate = newtxtCreationDate;
  }

  public String[] getTxtCreatedBy()
  {
    return txtCreatedBy;
  }

  public void setTxtCreatedBy(String[] newtxtCreatedBy)
  {
    txtCreatedBy = newtxtCreatedBy;
  }
  
  public String[] getTxtCreatedSite()
  {
    return txtCreatedSite;
  }

  public void setTxtCreatedSite(String[] newtxtCreatedSite)
  {
    txtCreatedSite = newtxtCreatedSite;
  }
//updation details
 public String[] getTxtUpdationDate()
  {
    return txtUpdationDate;
  }

  public void setTxtUpdationDate(String[] newtxtUpdationDate)
  {
    txtUpdationDate = newtxtUpdationDate;
  }

  public String[] getTxtUpdatedBy()
  {
    return txtUpdatedBy;
  }

  public void setTxtUpdatedBy(String[] newtxtUpdatedBy)
  {
    txtUpdatedBy = newtxtUpdatedBy;
  }
  
  public String[] getTxtUpdatedSite()
  {
    return txtUpdatedSite;
  }

  public void setTxtUpdatedSite(String[] newtxtUpdatedSite)
  {
    txtUpdatedSite = newtxtUpdatedSite;
  }
  
  public String getTxtButAction()
  {
    return txtButAction;
  }

  public void setTxtButAction(String newTxtButAction)
  {
    txtButAction = newTxtButAction;
  }
}