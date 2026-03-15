package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class DpsLabourSORViewForm extends PayrollBaseForm
{
  private String txtLocCode;
  private String txtLocName;
  
  private String [] prevOperation;
  private String [] prevOperDesc;
  private String [] prevBagRateAbv65;
  private String [] prevBagRateBlw65;  
  private String prevEffDate;
  private String prevEndDate;    
  
  private String [] curOperation;
  private String [] curBagRateAbv65;
  private String [] curBagRateBlw65;  
  private String curEffDate;
  private String curEndDate;  
  
  private ArrayList lstInstrDtls= new ArrayList();
  private String txtRegCode;  
  private String txtRegName;  
  private String effStartDate;
  private String screenModeSOR;
  private String screenModeSOR1;
  private String screenModeSOR2;
  

  public DpsLabourSORViewForm()
  {
  }
  
  public String getScreenModeSOR()
  {
    return screenModeSOR;
  }

  public void setScreenModeSOR(String newScreenModeSOR)
  {
    screenModeSOR = newScreenModeSOR;
  } 
  public String getScreenModeSOR1()
  {
    return screenModeSOR1;
  }

  public void setScreenModeSOR1(String newScreenModeSOR1)
  {
    screenModeSOR1 = newScreenModeSOR1;
  } 
  public String getScreenModeSOR2()
  {
    return screenModeSOR2;
  }

  public void setScreenModeSOR2(String newScreenModeSOR2)
  {
    screenModeSOR2 = newScreenModeSOR2;
  } 

  public String getTxtLocCode()
  {
    return txtLocCode;
  }

  public void setTxtLocCode(String newTxtLocCode)
  {
    txtLocCode = newTxtLocCode;
  } 
  
   public String getTxtLocName()
  {
    return txtLocName;
  }

  public void setTxtLocName(String newTxtLocName)
  {
    txtLocName = newTxtLocName;
  } 
  
  public String [] getPrevOperation()
  {
    return prevOperation;
  }

  public void setPrevOperation(String [] newPrevOperation)
  {
    prevOperation = newPrevOperation;
  } 
  
  public String [] getPrevOperDesc()
  {
    return prevOperDesc;
  }

  public void setPrevOperDesc(String [] newPrevOperDesc)
  {
    prevOperDesc = newPrevOperDesc;
  } 
  
  public String [] getPrevBagRateAbv65()
  {
    return prevBagRateAbv65;
  }

  public void setPrevBagRateAbv65(String [] newPrevBagRateAbv65)
  {
    prevBagRateAbv65 = newPrevBagRateAbv65;
  }
  
  public String [] getPrevBagRateBlw65()
  {
    return prevBagRateBlw65;
  }

  public void setPrevBagRateBlw65(String [] newPrevBagRateBlw65)
  {
    prevBagRateBlw65 = newPrevBagRateBlw65;
  }  
  
  public String getPrevEffDate()
  {
    return prevEffDate;
  }

  public void setPrevEffDate(String newPrevEffDate)
  {
    prevEffDate = newPrevEffDate;
  }
  
  public String getPrevEndDate()
  {
    return prevEndDate;
  }

  public void setPrevEndDate(String newPrevEndDate)
  {
    prevEndDate = newPrevEndDate;
  }
  
  public String [] getCurOperation()
  {
    return curOperation;
  }

  public void setCurOperation(String [] newCurOperation)
  {
    curOperation = newCurOperation;
  } 
  
  public String [] getCurBagRateAbv65()
  {
    return curBagRateAbv65;
  }

  public void setCurBagRateAbv65(String [] newCurBagRateAbv65)
  {
    curBagRateAbv65 = newCurBagRateAbv65;
  }
  
  public String [] getCurBagRateBlw65()
  {
    return curBagRateBlw65;
  }

  public void setCurBagRateBlw65(String [] newCurBagRateBlw65)
  {
    curBagRateBlw65 = newCurBagRateBlw65;
  }  
  
  public String getCurEffDate()
  {
    return curEffDate;
  }

  public void setCurEffDate(String newCurEffDate)
  {
    curEffDate = newCurEffDate;
  }
  
  public String getCurEndDate()
  {
    return curEndDate;
  }

  public void setCurEndDate(String newCurEndDate)
  {
    curEndDate = newCurEndDate;
  } 
  
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
  public String getTxtRegCode()
  {
    return txtRegCode;
  }

  public void setTxtRegCode(String newTxtRegCode)
  {
    txtRegCode = newTxtRegCode;
  } 
  
  public String getTxtRegName()
  {
    return txtRegName;
  }

  public void setTxtRegName(String newTxtRegName)
  {
    txtRegName = newTxtRegName;
  } 
  
  public String getEffStartDate()
  {
    return effStartDate;
  }

  public void setEffStartDate(String newEffStartDate)
  {
    effStartDate = newEffStartDate;
  }
  
}


