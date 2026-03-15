    /*
    * Module:        MaintDaRatesForm.java
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
import FCIPAY.Payroll.UTILITY.MaintPayCodesBean;


public class MaintDaRatesForm extends PayrollBaseForm 
{
    private String txtLowBasic[] = null;
    private String txtHighBasic[] = null;
    private String txtDaRate[] = null;
    private String txtDaMinimum[] = null;
   
    private String hdnCheck[] = null;
    private ArrayList lstInstrDtls = new ArrayList();
    private ArrayList lstInstrDtls1 = new ArrayList();
    private long txtTest = 0;
    private String action = "";
    private String lstPayScaleType;
    private String txtYYMM;
    private String hdrGoto;
    private String txtDPRate[]=null;
    private String txtDAType;
    private String txtSrlNo[]=null;
  private String screenModeDARate;
  private String screenModeCDA;
  private String headerClick;
  private String screenModeID = "";
  private String headerMode;
  private String headerMode1;
  //added by himanshu
  private String hdnEmpLbrFlag;
    
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
  
    public String[] gettxtLowBasic()
    {
        return txtLowBasic;
    }

    public void settxtLowBasic(String[] newtxtLowBasic)
    {
        txtLowBasic = newtxtLowBasic;
    }

    public String[] gettxtHighBasic()
    {
        return txtHighBasic;
    }

    public void settxtHighBasic(String[] newtxtHighBasic)
    {
        txtHighBasic = newtxtHighBasic;
    }

    public String[] gettxtDaRate()
    {
        return txtDaRate;
    }

    public void settxtDaRate(String[] newtxtDaRate)
    {
        txtDaRate = newtxtDaRate;
    }

    public String[] gettxtDaMinimum()
    {
        return txtDaMinimum;
    }

    public void settxtDaMinimum(String[] newtxtDaMinimum)
    {
        txtDaMinimum = newtxtDaMinimum;
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

    public String getAction()
    {
        return action;
    }

    public void setAction(String newAction)
    {
        action = newAction;
    }
   
    public String[] getHdnCheck()
    {
        return hdnCheck;
    }

    public void setHdnCheck(String[] newHdnCheck)
    {
        hdnCheck = newHdnCheck;
    }

  public String getLstPayScaleType()
  {
    return lstPayScaleType;
  }

  public void setLstPayScaleType(String newLstPayScaleType)
  {
    lstPayScaleType = newLstPayScaleType;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }
    
 
  public String getHdrGoto()
  {
    return hdrGoto;
  }

  public void setHdrGoto(String newHdrGoto)
  {
    hdrGoto = newHdrGoto;
  }

public ArrayList getLstInstrDtls1()
    {
        return lstInstrDtls1;
    }

    public void setLstInstrDtls1(ArrayList newLstInstrDtls1)
    {
        lstInstrDtls1 = newLstInstrDtls1;
    }

  public String[] getTxtDPRate()
  {
    return txtDPRate;
  }

  public void setTxtDPRate(String[] newTxtDPRate)
  {
    txtDPRate = newTxtDPRate;
  }

  public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }



  public String getScreenModeDARate()
  {
    return screenModeDARate;
  }

  public void setScreenModeDARate(String newScreenModeDARate)
  {
    screenModeDARate = newScreenModeDARate;
  }

  public String getScreenModeCDA()
  {
    return screenModeCDA;
  }

  public void setScreenModeCDA(String newScreenModeCDA)
  {
    screenModeCDA = newScreenModeCDA;
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
  
  public String getHdnEmpLbrFlag()
  {
    return hdnEmpLbrFlag;
  }

  public void setHdnEmpLbrFlag(String newhdnEmpLbrFlag)
  {
    hdnEmpLbrFlag = newhdnEmpLbrFlag;
  }









 /* public String getHeaderMode()
  {
    return HeaderMode;
  }

  public void setHeaderMode(String newHeaderMode)
  {
    HeaderMode = newHeaderMode;
  }

  public String getHeaderMode1()
  {
    return HeaderMode1;
  }

  public void setHeaderMode1(String newHeaderMode1)
  {
    HeaderMode1 = newHeaderMode1;
  }*/









}