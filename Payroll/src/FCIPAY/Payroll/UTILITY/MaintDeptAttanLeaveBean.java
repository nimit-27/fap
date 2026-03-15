package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintDeptAttanLeaveBean extends PayrollBaseDetailBean implements Serializable
{
  
    
     private String txtEmpCode;
    private String txtEmpName;
    private String txtLeaveTyp;
    private String txtStaffCode;
    private String txtFrom;
    private String txtTo;
    private String txtEmpLeaveId;
    private String hdnProcYYMM="0";
    private String hdnSalProc="0";
    private String txtDesignation="";
    private String txtRevLeaveTyp;

// added by varalika on 30-Sep-2011
   private String txtCreationDate; 
   private String txtCreatedBy; 
   private String txtCreatedSite; 
   private String txtUpdationDate; 
   private String txtUpdatedBy; 
   private String txtUpdatedSite; 

 // ended by varalika
  public MaintDeptAttanLeaveBean()
  {
  }

  public String getTxtEmpCode()
  {
    return txtEmpCode;
  }

  public void setTxtEmpCode(String newTxtEmpCode)
  {
    txtEmpCode = newTxtEmpCode;
  }
  
    public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  
  public String getTxtLeaveTyp()
  {
    return txtLeaveTyp;
  }

  public void setTxtLeaveTyp(String newTxtLeaveTyp)
  {
    txtLeaveTyp = newTxtLeaveTyp;
  }
  public String getTxtStaffCode()
  {
    return txtStaffCode;
  }

  public void setTxtStaffCode(String newTxtStaffCode)
  {
    txtStaffCode = newTxtStaffCode;
  }
  public String getTxtFrom()
  {
    return txtFrom;
  }

  public void setTxtFrom(String newTxtFrom)
  {
    txtFrom = newTxtFrom;
  }
  public String getTxtTo()
  {
    return txtTo;
  }

  public void setTxtTo(String newTxtTo)
  {
    txtTo = newTxtTo;
  }
  
  public String getTxtEmpLeaveId()
  {
    return txtEmpLeaveId;
  }

  public void setTxtEmpLeaveId(String newTxtEmpLeaveId)
  {
    txtEmpLeaveId = newTxtEmpLeaveId;
  }

  public String getHdnProcYYMM()
  {
    return hdnProcYYMM;
  }

  public void setHdnProcYYMM(String newHdnProcYYMM)
  {
    hdnProcYYMM = newHdnProcYYMM;
  }

  public String getHdnSalProc()
  {
    return hdnSalProc;
  }

  public void setHdnSalProc(String newHdnSalProc)
  {
    hdnSalProc = newHdnSalProc;
  }

  public String getTxtDesignation()
  {
    return txtDesignation;
  }

  public void setTxtDesignation(String newTxtDesignation)
  {
    txtDesignation = newTxtDesignation;
  }

  public String getTxtRevLeaveTyp()
  {
    return txtRevLeaveTyp;
  }

  public void setTxtRevLeaveTyp(String newTxtRevLeaveTyp)
  {
    txtRevLeaveTyp = newTxtRevLeaveTyp;
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
    
}