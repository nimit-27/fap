package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MediReimbursDtlsAllForm  extends PayrollBaseForm
{
    private String medicalAmt;
    private String medicalDate;
    private String taxIndicator;
    private String quarter;
    private String medicalFromDate;
    private String medicalToDate;
    private String txtEmpList;
    private String hdnAction;
    private String txtEmpNo[];
    private String txtEmpName[];
    private String txtDsgn[];
    private String txtCateg[];
    private String txtPresentPOP[];
    private ArrayList lstInstrDtls= new ArrayList();
    private String screenModeFlag;
    private String flag;
    
    // added later on
    private String txtPayCode;
    private String txtBillAgst;
    private String txtITDedAmt;
    private String finYear;
    private String yearMonth;
    //added by priyanka
    private String payYYMM; // Added to get the current payroll year month for given location
    /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
    public void reset(ActionMapping mapping, HttpServletRequest request)
    {
      super.reset(mapping, request);
    }
   public String getyearMonth()
  {
    return yearMonth;
  }

  public void setyearMonth (String newTxtyearMonth)
  {
    yearMonth = newTxtyearMonth;
  }    
  
   public String getFinYear()
  {
    return finYear;
  }

  public void setFinYear(String newTxtFinYear)
  {
    finYear = newTxtFinYear;
  }  
  
  
  public String getTxtITDedAmt()
  {
    return txtITDedAmt;
  }

  public void setTxtITDedAmt(String newTxtITDedAmt)
  {
    txtITDedAmt = newTxtITDedAmt;
  }  
  
  
  
  public String getTxtBillAgst()
  {
    return txtBillAgst;
  }

  public void setTxtBillAgst(String newTxtBillAgst)
  {
    txtBillAgst = newTxtBillAgst;
  }  
  
  
  
  
  
  
  
  
  
   public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }  
  
  
  
  
  
 
  
  
   public String getMedicalToDate()
  {
    return medicalToDate;
  }

  public void setMedicalToDate(String newMedicalToDate)
  {
    medicalToDate = newMedicalToDate;
  }  
   
   public String getMedicalFromDate()
  {
    return medicalFromDate;
  }

  public void setMedicalFromDate(String newMedicalFromDate)
  {
    medicalFromDate = newMedicalFromDate;
  }  
  
  
   public String getQuarter()
  {
    return quarter;
  }

  public void setQuarter(String newQuarter)
  {
    quarter = newQuarter;
  }  
  
  
  
  
  
  
  
  
  
  
   
  public String getTaxIndicator()
  {
    return taxIndicator;
  }

  public void setTaxIndicator(String newTaxIndicator)
  {
    taxIndicator = newTaxIndicator;
  }  
  
  
  
  
  
  
  
   public String getMedicalAmt()
  {
    return medicalAmt;
  }

  public void setMedicalAmt(String newMedicalAmt)
  {
    medicalAmt = newMedicalAmt;
  } 
  
  public String getMedicalDate()
  {
    return medicalDate;
  }

  public void setMedicalDate(String newMedicalDate)
  {
    medicalDate = newMedicalDate;
  } 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    
   
    public String getScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(String newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  } 
    
    public String getTxtEmpList()
    {
      return txtEmpList;
    }
    
    public void setTxtEmpList(String newTxtEmpList)
    {
      txtEmpList=newTxtEmpList;
    }
    
    public String [] getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String [] newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
  
  public String [] getTxtEmpName()
  {
    return txtEmpName;
  }
  
  public void setTxtEmpName(String [] newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
  
  public String [] getTxtDsgn()
  {
    return txtDsgn;
  }
  
  public void setTxtDsgn(String [] newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String [] getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String [] newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String [] getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String [] newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
   public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  } 
  //added by priyanka
    public String getPayYYMM()
  {
    return payYYMM;
  }

  public void setPayYYMM(String newPayYYMM)
  {
    payYYMM = newPayYYMM;
  }



}