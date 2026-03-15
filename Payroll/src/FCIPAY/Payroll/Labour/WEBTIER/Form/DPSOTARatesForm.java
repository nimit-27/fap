package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class DPSOTARatesForm extends PayrollBaseForm 
{   
    private ArrayList lstInstrDtls = new ArrayList();    
    private long txtTest = 0;    
    private String action = "";
    private String lstPayScale;
    private ArrayList lstPayScaleValues = new ArrayList();
    private ArrayList lstPayScaleLabels = new ArrayList();
    public String hdnEBCheck[]=null;      
    
    private String txtYYMM = "";
    private String txtLocId="";
    private String txtLocDesc="";
    private ArrayList lstInstrDtlsCDA = new ArrayList();    
    private String txtSrNo[] = null;
    private String txtRate[]=null;
    private String txtEfficiencyBar[]=null;    
    private String txtSrlNo[]=null;    
    private String txtRevYYMM1[]=null;
    private String txtPayScaleCode[]=null;
    
    private String screenModeIDA;
    private String screenModeCDA;
    private String screenModePayScale;
    private String headerClick;
    private String screenModeFlag;
    private String screenModePay2;
    private String endDate[]=null;
    private String startDate[]=null;  
    
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
   
    public String getTxtYYMM()
    {
        return txtYYMM;
    }

    public void setTxtYYMM(String newTxtYYMM)
    {
        txtYYMM = newTxtYYMM;
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

  public String[] getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String[] newTxtRate)
  {
    txtRate = newTxtRate;
  }

  public String[] getTxtEfficiencyBar()
  {
    return txtEfficiencyBar;
  }

  public void setTxtEfficiencyBar(String[] newTxtEfficiencyBar)
  {
    txtEfficiencyBar = newTxtEfficiencyBar;
  }

  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
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

  public String getScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(String newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  }

  public String getScreenModePay2()
  {
    return screenModePay2;
  }

  public void setScreenModePay2(String newScreenModePay2)
  {
    screenModePay2 = newScreenModePay2;
  }

  public String[] getEndDate()
  {
    return endDate;
  }

  public void setEndDate(String[] newEndDate)
  {
    endDate = newEndDate;
  }

  public String[] getStartDate()
  {
    return startDate;
  }

  public void setStartDate(String[] newStartDate)
  {
    startDate = newStartDate;
  }
  
  public String getTxtLocDesc()
  {
    return txtLocDesc;
  }

  public void setTxtLocDesc(String newTxtLocDesc)
  {
    txtLocDesc = newTxtLocDesc;
  }

    
}