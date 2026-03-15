    /*
    * Module:        MaintPayCodesForm.java
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
import FCIPAY.Payroll.UTILITY.MaintPayScaleDtlIDABean;
//import IBA.Payroll.DATAACCESSTIER.VO.MaintPayCodesVO;

public class MaintPayScaleForm extends PayrollBaseForm 
{
   
    private ArrayList lstInstrDtls = new ArrayList();    
    private long txtTest = 0;
    private String txtRevYYMM = "";
    private String action = "";
    private String lstPayScale;
    private ArrayList lstPayScaleValues = new ArrayList();
    private ArrayList lstPayScaleLabels = new ArrayList();
    public String hdnEBCheck[]=null;
    private ArrayList lstInstrDtlsCDA = new ArrayList();
    private String txtSrNo[] = null;
    private String txtIncrement[]=null;
    private String txtEfficiencyBar[]=null;
      //MaintPayCodesVO fedoVO = new MaintPayCodesVO();
    private String txtSrlNo[]=null;
    private String txtPayScaleType="";
    private String txtRevYYMM1[]=null;
    private String txtPayScaleCode[]=null;
    private String screenModeIDA;
    private String screenModeCDA;
    private String screenModePayScale;
    private String headerClick;
    private String screenModePay1;
    private String screenModePay2;
    private String endField[];
    private String startField[];
    private String txtGradePay[]=null;//added by geetika on 19-11-204
    private String txtStartDate[];
    private String txtEndDate[];
  
    
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
  
    public String[] gettxtSrNo()
    {
        return txtSrNo;
    }

    

    public void settxtSrNo(String[] newtxtSrNo)
    {
        txtSrNo = newtxtSrNo;
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
   
    public String gettxtRevYYMM()
    {
        return txtRevYYMM;
    }

    public void settxtRevYYMM(String newtxtRevYYMM)
    {
        txtRevYYMM = newtxtRevYYMM;
    }    

  public String getLstPayScale()
  {
    return lstPayScale;
  }

  public void setLstPayScale(String newLstPayScale)
  {
    lstPayScale = newLstPayScale;
  }

   public ArrayList getlstPayScaleLabels()
   {
        return lstPayScaleLabels;
   }

   public void setlstPayScaleLabels(ArrayList newlstPayScaleLabels)
   {
        lstPayScaleValues = newlstPayScaleLabels;
   } 

    public ArrayList getlstPayScaleValues()
   {
        return lstPayScaleValues;
   }

    public void setlstPayScaleValues(ArrayList newlstPayScaleValues)
    {
        lstPayScaleValues = newlstPayScaleValues;
    } 

  public String[] getHdnEBCheck()
  {
    return hdnEBCheck;
  }

  public void setHdnEBCheck(String[] newHdnEBCheck)
  {
    hdnEBCheck = newHdnEBCheck;
  }

  public ArrayList getLstInstrDtlsCDA()
  {
    return lstInstrDtlsCDA;
  }

  public void setLstInstrDtlsCDA(ArrayList newLstInstrDtls1CDA)
  {
    lstInstrDtlsCDA = newLstInstrDtls1CDA;
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }



  public String[] getTxtIncrement()
  {
    return txtIncrement;
  }

  public void setTxtIncrement(String[] newTxtIncrement)
  {
    txtIncrement = newTxtIncrement;
  }



  public String[] getTxtEfficiencyBar()
  {
    return txtEfficiencyBar;
  }

  public void setTxtEfficiencyBar(String[] newTxtEfficiencyBar)
  {
    txtEfficiencyBar = newTxtEfficiencyBar;
  }

  public String getTxtPayScaleType()
  {
    return txtPayScaleType;
  }

  public void setTxtPayScaleType(String newTxtPayScaleType)
  {
    txtPayScaleType = newTxtPayScaleType;
  }

  public String[] getTxtRevYYMM1()
  {
    return txtRevYYMM1;
  }

  public void setTxtRevYYMM1(String[] newTxtRevYYMM1)
  {
    txtRevYYMM1 = newTxtRevYYMM1;
  }

  public String[] getTxtPayScaleCode()
  {
    return txtPayScaleCode;
  }

  public void setTxtPayScaleCode(String[] newTxtPayScaleCode)
  {
    txtPayScaleCode = newTxtPayScaleCode;
  }

  public String getScreenModeIDA()
  {
    return screenModeIDA;
  }

  public void setScreenModeIDA(String newScreenModeIDA)
  {
    screenModeIDA = newScreenModeIDA;
  }

  public String getScreenModeCDA()
  {
    return screenModeCDA;
  }

  public void setScreenModeCDA(String newScreenModeCDA)
  {
    screenModeCDA = newScreenModeCDA;
  }

  public String getScreenModePayScale()
  {
    return screenModePayScale;
  }

  public void setScreenModePayScale(String newScreenModePayScale)
  {
    screenModePayScale = newScreenModePayScale;
  }

  public String getHeaderClick()
  {
    return headerClick;
  }

  public void setHeaderClick(String newHeaderClick)
  {
    headerClick = newHeaderClick;
  }

  public String getScreenModePay1()
  {
    return screenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    screenModePay1 = newScreenModePay1;
  }

  public String getScreenModePay2()
  {
    return screenModePay2;
  }

  public void setScreenModePay2(String newScreenModePay2)
  {
    screenModePay2 = newScreenModePay2;
  }

  public String[] getEndField()
  {
    return endField;
  }

  public void setEndField(String[] newEndField)
  {
    endField = newEndField;
  }

  public String[] getStartField()
  {
    return startField;
  }

  public void setStartField(String[] newStartField)
  {
    startField = newStartField;
  }
  //added by geetika on 19-11-2014
   public String[] gettxtGradePay()
  {
    return txtGradePay;
  }

  public void settxtGradePay(String[] newtxtGradePay)
  {
    txtGradePay = newtxtGradePay;
  }
   public String[] getTxtStartDate()
  {
    return txtStartDate;
  }

  public void setTxtStartDate(String[] newtxtStartDate)
  {
    txtStartDate = newtxtStartDate;
  }
     public String[] getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String[] newtxtEndDate)
  {
    txtEndDate = newtxtEndDate;
  }
}