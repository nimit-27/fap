    /*
    * Module:        EmpNomineeInfoForm.java
    * Author:        Aqeel Ahmed
    * Date Written:  Aug 2007
    * Description:   Form bean for Employee Nominee/Dependent Details
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;



public class EmpNomineeInfoForm extends PayrollBaseForm 
{
    private String txtDepndntId[] = null;
    private String txtDepndntName[] = null;
    private String txtDepndntAge[] = null;
    private String txtDepndntRel[] = null;
    private String txtDepndntEffFrom[] = null;
    private String txtDepndntEffTill[] = null;
    
    private String txtNomineeId[] = null;
    private String txtNomineeName[] = null;
    private String txtNomineeAge[] = null;
    private String txtNomineeRel[] = null;
    private String txtDepndntGuard[] = null;         // added by dushyant on 20-10-2010 
    private String txtNomineeShare[] = null;
    
    private String txtGratuityId[] = null;          // added by dushyant on 15-10-2010  
    private String txtGratuityName[] = null;       // added by dushyant on 15-10-2010                
    private String txtGratuityAge[] = null;                             
    private String txtGratuityRel[] = null; 
    private String txtGratGuardian[] = null;  
    private String txtGratuityShare[] = null;     // added by dushyant on 14-10-2010
      
    
    private String txtEmpNo= "";
    private String txtEmpName;   
    
    private String txtDsgn;  
    private String txtDsgnDesc;
    private String txtCateg;  
    private String txtCategDesc; 
    private String txtEmpType;
    private String txtCpfCode; 
    private String txtPresentPOP;
    private String txtPresentPOPDesc;
    private String txtDOJSite;
    private String txtDOR;
    private String txtEmpStatus;
  
    private ArrayList lstInstrDtls = new ArrayList();
    private ArrayList lstInstrDtls1 = new ArrayList();  
    private ArrayList lstInstrDtls2 = new ArrayList();           // added by dushyant on 18-10-2010
    private String action = "";         
    private String screenModeDepndnt;
    private String screenModeNominee;
    private String headerClick;
    private String screenModeID = "";
    private String headerMode;
    private String headerMode1;  
    private String headerMode2;                                   // added by dushyant on 18-10-2010
    private boolean flagDepndnt=false;
    private boolean flagNominee=false;
    private boolean flagGratuity=false;                           // added by dushyant on 18-10-2010
    
      
    /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
    public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstInstrDtls.clear();
       // this.txtTest = 0;
    }
  
    public String[] getTxtDepndntId()
    {
        return txtDepndntId;
    }
    
    public void setTxtDepndntId(String[] newTxtDepndntId)
    {
        txtDepndntId = newTxtDepndntId;
    }
    
     public String[] getTxtDepndntName()
    {
        return txtDepndntName;
    }
    
    public void setTxtDepndntName(String[] newTxtDepndntName)
    {
        txtDepndntName = newTxtDepndntName;
    }

    public String[] getTxtDepndntAge()
    {
        return txtDepndntAge;
    }
    public void setTxtDepndntAge(String[] newTxtDepndntAge)
    {
        txtDepndntAge = newTxtDepndntAge;
    }

    public String[] getTxtDepndntRel()
    {
        return txtDepndntRel;
    }
    public void setTxtDepndntRel(String[] newTxtDepndntRel)
    {
        txtDepndntRel = newTxtDepndntRel;
    }

    public String[] getTxtDepndntEffFrom()
    {
        return txtDepndntEffFrom;
    }
    
    public void setTxtDepndntEffFrom(String[] newTxtDepndntEffFrom)
    {
        txtDepndntEffFrom = newTxtDepndntEffFrom;
    }
    
    public String[] getTxtDepndntEffTill()
    {
        return txtDepndntEffTill;
    }
    
    public void setTxtDepndntEffTill(String[] newTxtDepndntEffTill)
    {
        txtDepndntEffTill = newTxtDepndntEffTill;
    }
    
     public String[] getTxtNomineeId()
    {
        return txtNomineeId;
    }
    
    public void setTxtNomineeId(String[] newTxtNomineeId)
    {
        txtNomineeId = newTxtNomineeId;
    } 

    public String[] getTxtNomineeName()
    {
        return txtNomineeName;
    }
    
    public void setTxtNomineeName(String[] newTxtNomineeName)
    {
        txtNomineeName = newTxtNomineeName;
    } 

    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }
    
    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }

    public String[] getTxtNomineeAge()
    {
        return txtNomineeAge;
    }
    
    public void setTxtNomineeAge(String[] newTxtNomineeAge)
    {
        txtNomineeAge = newTxtNomineeAge;
    }

    public String getAction()
    {
        return action;
    }
    
    public void setAction(String newAction)
    {
        action = newAction;
    }   

    public String[] getTxtNomineeRel()
    {
        return txtNomineeRel;
    }
    
    public void setTxtNomineeRel(String[] newTxtNomineeRel)
    {
        txtNomineeRel = newTxtNomineeRel;
    }

    public String[] getTxtNomineeShare()
    {
      return txtNomineeShare;
    }
    
    public void setTxtNomineeShare(String[] newTxtNomineeShare)
    {
      txtNomineeShare = newTxtNomineeShare;
    }  
    
    public ArrayList getLstInstrDtls1()
    {
      return lstInstrDtls1;
    }
    
    public void setLstInstrDtls1(ArrayList newLstInstrDtls1)
    {
      lstInstrDtls1 = newLstInstrDtls1;
    }

// added by dushyant on 18-10-2010
 public ArrayList getLstInstrDtls2()
    {
      return lstInstrDtls2;
    }
    
    public void setLstInstrDtls2(ArrayList newLstInstrDtls2)
    {
      lstInstrDtls2 = newLstInstrDtls2;
    }
// added by dushyant on 18-10-2010

    public String getScreenModeDepndnt()
    {
      return screenModeDepndnt;
    }
  
    public void setScreenModeDepndnt(String newScreenModeDepndnt)
    {
      screenModeDepndnt = newScreenModeDepndnt;
    }
  
    public String getscreenModeNominee()
    {
      return screenModeNominee;
    }

    public void setscreenModeNominee(String newscreenModeNominee)
    {
      screenModeNominee = newscreenModeNominee;
    }
  
    public String getHeaderClick()
    {
      return headerClick;
    }
  
    public void setHeaderClick(String newHeaderClick)
    {
      headerClick = newHeaderClick;
    }
  
    public String getScreenModeID()
    {
      return screenModeID;
    }
  
    public void setScreenModeID(String newScreenModeID)
    {
      screenModeID = newScreenModeID;
    }
  
    public String getHeaderMode()
    {
      return headerMode;
    }
  
    public void setHeaderMode(String newHeaderMode)
    {
      headerMode = newHeaderMode;
    }
  
    public String getHeaderMode1()
    {
      return headerMode1;
    }
  
    public void setHeaderMode1(String newHeaderMode1)
    {
      headerMode1 = newHeaderMode1;
    }
 
 // added by dushyant on 18-10-2010
   public String getHeaderMode2()
    {
      return headerMode2;
    }
  
    public void setHeaderMode2(String newHeaderMode2)
    {
      headerMode2 = newHeaderMode2;
    }
    
// added by dushyant on 18-10-2010  

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
    
    public boolean isFlagDepndnt()
    {
        return flagDepndnt;
    }
    
    public void setFlagDepndnt(boolean newFlagDepndnt)
    {
        flagDepndnt = newFlagDepndnt;
    }
    
    public boolean isFlagNominee()
    {
        return flagNominee;
    }
    
    public void setFlagNominee(boolean newFlagNominee)
    {
        flagNominee = newFlagNominee;
    }
    
                             // added by dushyant on 18-10-2010
    
       public boolean isFlagGratuity()
    {
        return flagGratuity;
    }
    
    public void setFlagGratuity(boolean newFlagGratuity)
    {
        flagGratuity = newFlagGratuity;
    }

                         // added by dushyant on 18-10-2010
   public String getTxtDsgn()
  {
    return txtDsgn;
  }
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }
  
  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }
  
  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtCategDesc()
  {
    return txtCategDesc;
  }

  public void setTxtCategDesc(String newTxtCategDesc)
  {
    txtCategDesc = newTxtCategDesc;
  }
  
   public String getTxtEmpType()
  {
    return txtEmpType;
  }

  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }  
 
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  } 
  
  public String getTxtPresentPOPDesc()
  {
    return txtPresentPOPDesc;
  }

  public void setTxtPresentPOPDesc(String newTxtPresentPOPDesc)
  {
    txtPresentPOPDesc = newTxtPresentPOPDesc;
  }
  
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }  
  
   public String getTxtDOJSite()
  {
    return txtDOJSite;
  }

  public void setTxtDOJSite(String newTxtDOJSite)
  {
    txtDOJSite = newTxtDOJSite;
  } 
  
  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }

   public String getTxtDOR()
  {
    return txtDOR;
  }

  public void setTxtDOR(String newTxtDOR)
  {
    txtDOR = newTxtDOR;
  } 
  
// added by dushyant on 14-10-2010  for gratuity tab

    public String[] getTxtGratuityId()
    {
        return txtGratuityId;
    }
    
    public void setTxtGratuityId(String[] newTxtGratuityId)
    {
        txtGratuityId = newTxtGratuityId;
    } 

  public String[] getTxtGratuityName()
    {
        return txtGratuityName;
    }
    
    public void setTxtGratuityName(String[] newTxtGratuityName)
    {
        txtGratuityName = newTxtGratuityName;
    } 


   public String[] getTxtGratuityAge()
    {
        return txtGratuityAge;
    }
    
    public void setTxtGratuityAge(String[] newTxtGratuityAge)
    {
        txtGratuityAge = newTxtGratuityAge;
    }


 public String[] getTxtGratuityRel()
    {
        return txtGratuityRel;
    }
    
    public void setTxtGratuityRel(String[] newTxtGratuityRel)
    {
        txtGratuityRel = newTxtGratuityRel;
    }

  public String[] getTxtGratuityShare()
    {
      return txtGratuityShare;
    }
    
   public void setTxtGratuityShare(String[] newTxtGratuityShare)
    {
      txtGratuityShare = newTxtGratuityShare;
    } 
  
   public String[] getTxtGratGuardian()
    {
      return txtGratGuardian;
    }
    
   public void setTxtGratGuardian(String[] newTxtGratGuardian)
    {
      txtGratGuardian = newTxtGratGuardian;
    } 
    
    public String[] getTxtDepndntGuard()
    {
      return txtDepndntGuard;
    }
    
   public void setTxtDepndntGuard(String[] newTxtDepndntGuard)
    {
      txtDepndntGuard = newTxtDepndntGuard;
    }  
}