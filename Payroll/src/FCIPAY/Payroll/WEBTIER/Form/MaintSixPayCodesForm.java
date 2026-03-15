package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MaintSixPayCodesForm extends PayrollBaseForm 
{
 
  private String txtPayCode[] = null;
  private String txtDescription[]=null;  

  private String Action;
  private String action = "";  
  private String optPayScaleType;
  private String txtPayCode1 = null;
  private String txtPayCodeName = null; 
  
  private String txtName1= null;  
  private String hdnCheck[] = null;
  private ArrayList lstInstrDtls = new ArrayList();
  //private String txtCPFCode[] = null;
  private String hdnPayCodeSrlNo[];
  private String formMode;
  private String txtSrlNo[] = null;
  private String actionName; 
  private String screenModeDir;
  private String hdnCurYYMM;
  private String hdnPayStatus;
  private String hdnAction;
  private String hdnRowVal;

  private String hdnPayCode;
  private String hdnPayCodeName;
  private long txtTest;
 


  
  private String txtDesg[]=null; 
  private String txtEducation[]=null; 
  private String txtPercentage[]=null; 
  private String txtMobile[]=null; 
  private String txtConveyance[]=null; 
  private String txtStartDate[]=null; 
  private String txtEndDate[]=null; 
  private String  txtDsgnDesc[]=null;

  

  /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }


   public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstInstrDtls.clear();
        this.txtTest = 0;
   }
  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }

  

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */

 

  /*public String[] getTxtCPFCode()
  {
    return txtCPFCode;
  }

  public void setCPFCode(String[] newCPFCode)
  {
    txtCPFCode = newCPFCode;
  }*/
  public String[] getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String[] newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String[] getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String[] newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }

 

 

  
  

  

  public long getTxtTest()
  {
    return txtTest;
  }

  public void setTxtTest(long newTxtTest)
  {
    txtTest = newTxtTest;
  }

  public String getAction()
  {
    return Action;
  }

  public void setAction(String newAction)
  {
    Action = newAction;
  }

  public String getOptPayScaleType()
  {
    return optPayScaleType;
  }

  public void setOptPayScaleType(String newOptPayScaleType)
  {
    optPayScaleType = newOptPayScaleType;
  }

  public String getTxtPayCode1()
  {
    return txtPayCode1;
  }

  public void setTxtPayCode1(String  newTxtPayCode1)
  {
    txtPayCode1 = newTxtPayCode1;
  }

  public String getTxtPayCodeName()
  {
    return txtPayCodeName;
  }

  public void setTxtPayCodeName(String newTxtPayCodeName)
  {
    txtPayCodeName = newTxtPayCodeName;
  }

  

 

  
    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }

   public String[] getHdnCheck()
    {
        return hdnCheck;
    }

    public void setHdnCheck(String[] newHdnCheck)
    {
        hdnCheck = newHdnCheck;
    }  

 /* public void setVO()
  {       
     fedoVO.setTxtEmpNo1(this.txtEmpNo1); 
     fedoVO.setTxtName1(this.txtName1);
     fedoVO.setTxtPayCode1(this.txtPayCode1);
     fedoVO.setTxtPayCodeName(this.txtPayCodeName);     
     fedoVO.setLstInstrDtls(this.lstInstrDtls);  
  }*/

 
       

  public String[] getHdnPayCodeSrlNo()
  {
    return hdnPayCodeSrlNo;
  }

  public void setHdnPayCodeSrlNo(String[] newHdnPayCodeSrlNo)
  {
    hdnPayCodeSrlNo = newHdnPayCodeSrlNo;
  }

  public String getFormMode()
  {
    return formMode;
  }

  public void setFormMode(String newFormMode)
  {
    formMode = newFormMode;
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getActionName()
  {
    return actionName;
  }

  public void setActionName(String newActionName)
  {
    actionName = newActionName;
  } 

  public String getScreenModeDir()
  {
    return screenModeDir;
  }

  public void setScreenModeDir(String newScreenModeDir)
  {
    screenModeDir = newScreenModeDir;
  }
 
  public String getHdnCurYYMM()
  {
    return hdnCurYYMM;
  }

  public void setHdnCurYYMM(String newHdnCurYYMM)
  {
    hdnCurYYMM = newHdnCurYYMM;
  }

  public String getHdnPayStatus()
  {
    return hdnPayStatus;
  }

  public void setHdnPayStatus(String newHdnPayStatus)
  {
    hdnPayStatus = newHdnPayStatus;
  }

  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }

  public String getHdnRowVal()
  {
    return hdnRowVal;
  }

  public void setHdnRowVal(String newHdnRowVal)
  {
    hdnRowVal = newHdnRowVal;
  }

  

  public String getHdnPayCode()
  {
    return hdnPayCode;
  }

  public void setHdnPayCode(String newHdnPayCode)
  {
    hdnPayCode = newHdnPayCode;
  }

  public String getHdnPayCodeName()
  {
    return hdnPayCodeName;
  }

  public void setHdnPayCodeName(String newHdnPayCodeName)
  {
    hdnPayCodeName = newHdnPayCodeName;
  }

 
  public String[] getTxtDesg()
  {
    return txtDesg;
  }

  public void setTxtDesg(String[] newTxtDesg)
  {
    txtDesg = newTxtDesg;
  }
  
  public String[] getTxtMobile()
  {
    return txtMobile;
  }

  public void setTxtMobile(String[] newTxtMobile)
  {
    txtMobile = newTxtMobile;
  }
  
  public String[] getTxtConveyance()
  {
    return txtConveyance;
  }

  public void setTxtConveyance(String[] newTxtConveyance)
  {
    txtConveyance = newTxtConveyance;
  }
  
  public String[] getTxtEducation()
  {
    return txtEducation;
  }

  public void setTxtEducation(String[] newTxtEducation)
  {
    txtEducation = newTxtEducation;
  }
  public String[] getTxtPercentage()
  {
    return txtPercentage;
  }

  public void setTxtPercentage(String[] newTxtPercentage)
  {
    txtPercentage = newTxtPercentage;
  }
  public String[] getTxtStartDate()
  {
    return txtStartDate;
  }
  

  public void setTxtStartDate(String[] newTxtStartDate)
  {
    txtStartDate = newTxtStartDate;
  }
  public String[] getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String[] newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  } 
  
   public String[] getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String[] newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }  
}