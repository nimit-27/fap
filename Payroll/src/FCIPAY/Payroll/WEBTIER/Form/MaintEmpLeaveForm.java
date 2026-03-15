package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintEmpLeaveForm extends PayrollBaseForm 
{
    
  private ArrayList lstInstrDtls=new ArrayList();
  private String optVal;
  private String txtEmpNo;
  private String txtGend;
  private String txtEmpNameHdr;
  private String txtCpfCode;    // added by dushyant on 30-09-2010 for cpf code
  private String txtYYMM;
  private String txtToYYMM;
  private String [] txtEmpCode;
  private String [] txtLeaveTyp;
  private String [] txtLeaveDesc;
  private String [] txtFrom;
  private String [] txtTo;
  private String [] txtEmpLeaveId;
  private String [] txtEmpName;
  private String [] txtCpfCode1;      // added by dushyant on 30-09-2010 for cpf code
  private String [] hdnProcYYMM;
  private String [] hdnSalProc;
  private String [] cancelStatus;
  private String [] txtRevLeaveTyp;
  private String [] txtGender;
    
   // added by varalika on 30-Sep-2011

 private String []txtCreationDate; 
   private String []txtCreatedBy; 
   private String []txtCreatedSite; 
   private String []txtUpdationDate; 
   private String []txtUpdatedBy; 
   private String []txtUpdatedSite; 
 // ended by varalika
 
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
  public String  getTxtGend()
  {
    return txtGend;
  }
   public void setTxtGend(String newTxtGend)
  {
    txtGend = newTxtGend;
  }
  
  
  public String getTxtEmpNameHdr()
  {
    return txtEmpNameHdr;
  }

  public void setTxtEmpNameHdr(String newTxtEmpNameHdr)
  {
    txtEmpNameHdr = newTxtEmpNameHdr;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

 public String getTxtToYYMM()
  {
    return txtToYYMM;
  }

  public void setTxtToYYMM(String newTxtToYYMM)
  {
    txtToYYMM = newTxtToYYMM;
  }

  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
  }

  public String [] getTxtEmpCode()
  {
    return txtEmpCode;
  }

  public void setTxtEmpCode(String[] newTxtEmpCode)
  {
    txtEmpCode = newTxtEmpCode;
  }
  
  public String [] getTxtLeaveTyp()
  {
    return txtLeaveTyp;
  }

  public void setTxtLeaveTyp(String[] newTxtLeaveTyp)
  {
    txtLeaveTyp = newTxtLeaveTyp;
  }
  
  public String [] getTxtLeaveDesc()
  {
    return txtLeaveDesc;
  }

  public void setTxtLeaveDesc(String[] newTxtLeaveDesc)
  {
    txtLeaveDesc = newTxtLeaveDesc;
  }
  public String [] getTxtFrom()
  {
    return txtFrom;
  }

  public void setTxtFrom(String[] newTxtFrom)
  {
    txtFrom = newTxtFrom;
  }
  public String [] getTxtTo()
  {
    return txtTo;
  }

  public void setTxtTo(String[] newTxtTo)
  {
    txtTo = newTxtTo;
  }
  public String [] getTxtEmpLeaveId()
  {
    return txtEmpLeaveId;
  }

  public void setTxtEmpLeaveId(String[] newTxtEmpLeaveId)
  {
    txtEmpLeaveId = newTxtEmpLeaveId;
  }

  public String [] getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String[] newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String [] getHdnProcYYMM()
  {
    return hdnProcYYMM;
  }

  public void setHdnProcYYMM(String[] newHdnProcYYMM)
  {
    hdnProcYYMM = newHdnProcYYMM;
  }

  public String [] getHdnSalProc()
  {
    return hdnSalProc;
  }

  public void setHdnSalProc(String[] newHdnSalProc)
  {
    hdnSalProc = newHdnSalProc;
  }

  public String [] getCancelStatus()
  {
    return cancelStatus;
  }

  public void setCancelStatus(String[] newCancelStatus)
  {
    cancelStatus = newCancelStatus;
  }

  public String [] getTxtRevLeaveTyp()
  {
    return txtRevLeaveTyp;
  }

  public void setTxtRevLeaveTyp(String[] newTxtRevLeaveTyp)
  {
    txtRevLeaveTyp = newTxtRevLeaveTyp;
  }
  
  public String [] getTxtGender()
  {
    return txtGender;
  }

  public void setTxtGender(String[] newTxtGender)
  {
    txtGender = newTxtGender;
  }
                                                           // added by dushyant on 30-09-2010
   public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
  
                                                         // added by dushyant on 30-09-2010
   public String [] getTxtCpfCode1()
  {
    return txtCpfCode1;
  }

  public void setTxtCpfCode1(String [] newTxtCpfCode1)
  {
    txtCpfCode1 = newTxtCpfCode1;
  }
 //added by varalika on 30-Sep-2011//
 public String[] getTxtCreationDate()
  {
    return txtCreationDate;
  }

  public void setTxtCreationDate(String []newtxtCreationDate)
  {

    txtCreationDate = newtxtCreationDate;
  }

 public String[] getTxtCreatedBy()
  {
    return txtCreatedBy;
  }

  public void setTxtCreatedBy(String []newtxtCreatedBy)
  {
    txtCreatedBy = newtxtCreatedBy;
  }
  
  public String [] getTxtCreatedSite()
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
// ended by varalika
 
}