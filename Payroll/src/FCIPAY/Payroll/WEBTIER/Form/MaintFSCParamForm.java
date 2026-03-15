    /*
    * Module:        MaintFSCParamForm.java
    * Author:        Surajeet Chakraborty
    * Date Written:  December 2004
    * Description:   Action Form for FE Release Details
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
import FCIPAY.Payroll.UTILITY.MaintFSCParamBean;


public class MaintFSCParamForm extends PayrollBaseForm 
{    
    private String txtSrlNo[] = null;
    private String txtFromYear[] = null;
    private String txtToYear[] = null;
    private String txtRateOfPenConForGrpA[] = null;
    private String txtRateOfLeaveConForGrpA[] = null;
    private String txtRateOfPenConForGrpB[] = null;
    private String txtRateOfLeaveConForGrpB[] = null;
    private String txtRateOfPenConForGrpC[] = null;
    private String txtRateOfLeaveConForGrpC[] = null;
    private String txtRateOfPenConForGrpD[] = null;
    private String txtRateOfLeaveConForGrpD[] = null;
    private String hdnCheck[] = null;
    private ArrayList lstInstrDtls = new ArrayList();
    private long txtTest = 0;
    private String action = "";
   
    String formMode;
    
    /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
    public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstInstrDtls.clear();
        this.txtTest = 0;
   }

  public String getAction()
  {
    return action;
  }

  public void setAction(String newAction)
  {
    action = newAction;
  }
    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }

    public long getTxtTest()
    {
        return txtTest;
    }

    public void setTxtTest(long newTxtTest)
    {
        txtTest = newTxtTest;
    }


   
    public String[] getHdnCheck()
    {
        return hdnCheck;
    }

    public void setHdnCheck(String[] newHdnCheck)
    {
        hdnCheck = newHdnCheck;
    }
    
    

    public String[] gettxtSrlNo()
    {
        return txtSrlNo;
    }

    public void settxtSrlNo(String[] newtxtSrlNo)
    {
        txtSrlNo = newtxtSrlNo;
    }

  public String[] getTxtFromYear()
  {
       return txtFromYear;
  }

  public void setTxtFromYear(String[] newTxtFromYear)
  {
    txtFromYear = newTxtFromYear;
  }

  public String[] getTxtToYear()
  {
    return txtToYear;
  }

  public void setTxtToYear(String[] newTxtToYear)
  {
    txtToYear = newTxtToYear;
  }

  public String[] getTxtRateOfPenConForGrpA()
  {
    return txtRateOfPenConForGrpA;
  }

  public void setTxtRateOfPenConForGrpA(String[] newTxtRateOfPenConForGrpA)
  {
    txtRateOfPenConForGrpA = newTxtRateOfPenConForGrpA;
  }

  public String[] getTxtRateOfLeaveConForGrpA()
  {
    return txtRateOfLeaveConForGrpA;
  }

  public void setTxtRateOfLeaveConForGrpA(String[] newTxtRateOfLeaveConForGrpA)
  {
    txtRateOfLeaveConForGrpA = newTxtRateOfLeaveConForGrpA;
  }

  public String[] getTxtRateOfPenConForGrpB()
  {
    return txtRateOfPenConForGrpB;
  }

  public void setTxtRateOfPenConForGrpB(String[] newTxtRateOfPenConForGrpB)
  {
    txtRateOfPenConForGrpB = newTxtRateOfPenConForGrpB;
  }

  public String[] getTxtRateOfLeaveConForGrpB()
  {
    return txtRateOfLeaveConForGrpB;
  }

  public void setTxtRateOfLeaveConForGrpB(String[] newTxtRateOfLeaveConForGrpB)
  {
    txtRateOfLeaveConForGrpB = newTxtRateOfLeaveConForGrpB;
  } 

  public String[] getTxtRateOfPenConForGrpC()
  {
    return txtRateOfPenConForGrpC;
  }

  public void setTxtRateOfPenConForGrpC(String[] newTxtRateOfPenConForGrpC)
  {
    txtRateOfPenConForGrpC = newTxtRateOfPenConForGrpC;
  }

  public String[] getTxtRateOfLeaveConForGrpC()
  {
    return txtRateOfLeaveConForGrpC;
  }

  public void setTxtRateOfLeaveConForGrpC(String[] newTxtRateOfLeaveConForGrpC)
  {
    txtRateOfLeaveConForGrpC = newTxtRateOfLeaveConForGrpC;
  }

  public String[] getTxtRateOfPenConForGrpD()
  {
    return txtRateOfPenConForGrpD;
  }

  public void setTxtRateOfPenConForGrpD(String[] newTxtRateOfPenConForGrpD)
  {
    txtRateOfPenConForGrpD = newTxtRateOfPenConForGrpD;
  }

  public String[] getTxtRateOfLeaveConForGrpD()
  {
    return txtRateOfLeaveConForGrpD;
  }

  public void setTxtRateOfLeaveConForGrpD(String[] newTxtRateOfLeaveConForGrpD)
  {
    txtRateOfLeaveConForGrpD = newTxtRateOfLeaveConForGrpD;
  }

 
  public String getFormMode()
  {
    return formMode;
  }

  public void setFormMode(String newFormMode)
  {
    formMode = newFormMode;
  }
}