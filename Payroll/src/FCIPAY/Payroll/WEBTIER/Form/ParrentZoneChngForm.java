package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
public class ParrentZoneChngForm extends PayrollBaseForm 
{
  private ArrayList lstInstrDtls=new ArrayList();
  private String txtEmpNo;
  private String txtYYMMFrom;
  private String txtYYMMTo;
  private String txtMonth;
  private String txtZoneCode;
  private String txtNewParentZone;
  private String txtEmpName;
  private String txtCpfCode;
  private String txtSiteCode;
  private String txtSiteDesc;
  private String txtUserFlag;
  private String hdnAction;
  private String txtDesig;
  private String txtDob;
  private String txtCurrentZone;
  private String txtStaffCode;

  private String [] txtNewParZone;
  private String [] txtOldParZone;
  private String [] txtYYMM;
  private String [] txtEmpContr;
  private String [] txtEmplyrContr;
  private String [] txtEPS;
  private String [] txtOldParZoneCode;
  private String [] txtNewParZoneCode;
  
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls=newLstInstrDtls;
  }
  
    public String getTxtEmpNo()
    {
        return txtEmpNo;
    }
    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo=newTxtEmpNo;
    }
    
    public String getTxtYYMMFrom()
    {
        return txtYYMMFrom;
    }
    public void setTxtYYMMFrom(String newTxtDateFrom)
    {
        txtYYMMFrom=newTxtDateFrom ;
    }
    
    public String getTxtYYMMTo()
    {
        return txtYYMMTo;
    }
    public void setTxtYYMMTo(String newTxtYYMMTo)
    {
        txtYYMMTo=newTxtYYMMTo;
    }
    public String getTxtZoneCode()
    {
        return txtZoneCode;
    }
    public void setTxtZoneCode(String newTxtZoneCode)
    {
        txtZoneCode=newTxtZoneCode;
    }
      public String getTxtEmpName()
    {
        return txtEmpName;
    }
    public void setTxtEmpName(String newTxtEmpName)
    {
        txtEmpName=newTxtEmpName;
    }
    public String getTxtCpfCode()
    {
        return txtCpfCode;
    }
    public void setTxtCpfCode(String newTxtCpfCode)
    {
        txtCpfCode=newTxtCpfCode;
    }
       public String getTxtSiteCode()
    {
        return txtSiteCode;
    }
    public void setTxtSiteCode(String newTxtSiteCode)
    {
        txtSiteCode=newTxtSiteCode;
    }
    public String getTxtSiteDesc()
    {
        return txtSiteDesc;
    }
    public void setTxtSiteDesc(String newTxtSiteDesc)
    {
        txtSiteDesc=newTxtSiteDesc;
    }
    public String getTxtUserFlag()
    {
        return txtUserFlag;
    }
    public void setTxtUserFlag(String newTxtUserFlag)
    {
        txtUserFlag=newTxtUserFlag;
    }
    public String getTxtNewParentZone()
   {
      return txtNewParentZone;
   }
  public void setTxtNewParentZone(String newParentZone)
  {
    txtNewParentZone = newParentZone;
  }
    public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }

    public String getTxtDesig()
  {
    return txtDesig;
  }

  public void setTxtDesig(String newTxtDesig)
  {
    txtDesig = newTxtDesig;
  }
      public String getTxtDob()
  {
    return txtDob;
  }

  public void setTxtDob(String newTxtDob)
  {
    txtDob = newTxtDob;
  }

      public String getTxtCurrentZone()
  {
    return txtCurrentZone;
  }

  public void setTxtCurrentZone(String newTxtCurrentZone)
  {
    txtCurrentZone = newTxtCurrentZone;
  }

  public String getTxtStaffCode()
  {
    return txtStaffCode;
  }

  public void setTxtStaffCode(String newTxtStaffCode)
  {
    txtStaffCode = newTxtStaffCode;
  }
    public String [] getTxtNewParZone()
  {
    return txtNewParZone;
  }
  public void setTxtNewParZone(String [] newTxtNewParZone)
  {
    txtNewParZone=newTxtNewParZone;
  }
  public String [] getTxtOldParZone()
  {
    return txtOldParZone;
  }
  public void setTxtOldParZone(String [] newTxtOldParZone)
  {
    txtOldParZone=newTxtOldParZone;
  }
  public String [] getTxtYYMM()
  {
    return txtYYMM;
  }
  public void setTxtYYMM(String [] newTxtYYMM)
  {
    txtYYMM=newTxtYYMM;
  }
  public String [] getTxtEmpContr()
  {
    return txtEmpContr;
  }
  public void setTxtEmpContr(String [] newTxtEmpContr)
  {
    txtEmpContr=newTxtEmpContr;
  }
  
    public String [] getTxtEmplyrContr()
  {
    return txtEmplyrContr;
  }
  public void setTxtEmplyrContr(String [] newTxtEmplyrContr)
  {
    txtEmplyrContr=newTxtEmplyrContr;
  }
  
      public String [] getTxtEPS()
  {
    return txtEPS;
  }
  public void setTxtEPS(String [] newTxtEPS)
  {
    txtEPS=newTxtEPS;
  }
  
         public String []  getTxtOldParZoneCode()
  {
    return txtOldParZoneCode;
  }
  public void setTxtOldParZoneCode(String [] newTxtOldParZoneCode)
  {
    txtOldParZoneCode=newTxtOldParZoneCode;
  }
       public String []  getTxtNewParZoneCode()
  {
    return txtNewParZoneCode;
  }
  public void setTxtNewParZoneCode(String [] newTxtNewParZoneCode)
  {
    txtNewParZoneCode=newTxtNewParZoneCode;
  }
 
}