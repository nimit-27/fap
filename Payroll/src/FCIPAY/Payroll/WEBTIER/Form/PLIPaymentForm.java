package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class PLIPaymentForm extends PayrollBaseForm
{
  private String txtEmpNo = "";
  private String txtEmpName= "";  
  private String optSelectAllEmp = "";
  private String optVal;
  private String optSelectBasedOn;
  private String butAction;
  private String txtPLIType = "";
  private String txtPLIYear = "";
  private String txtPLIPerc = "";
  private String txtPLIAdvAmnt = "";  
  private String hdnAction;
  private String [] txtAllEmpNo;
  private String [] txtAllEmpName;
  private String [] txtDesig;
  private String [] prevPLIPaidAmnt;
  private String [] txtPLIAmnt;
  private String [] txtIncomTax;
  private String [] txtLeaveDed;
  private String [] netAmntPayble;
  private ArrayList lstInstrDtls= new ArrayList();
  private String screenModePLI;
  private String screenModePLI1;
  private String screenModePLI2;
  private String screenModeFlag;
  

  /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
  /*public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }*/

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

  public String getOptSelectAllEmp()
  {
    return optSelectAllEmp;
  }

  public void setOptSelectAllEmp(String newOptSelectAllEmp)
  {
    optSelectAllEmp = newOptSelectAllEmp;
  }
  
  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
  }

  public String getOptSelectBasedOn()
  {
    return optSelectBasedOn;
  }

  public void setOptSelectBasedOn(String newOptSelectBasedOn)
  {
    optSelectBasedOn = newOptSelectBasedOn;
  }

  public String getButAction()
  {
    return butAction;
  }

  public void setButAction(String newButAction)
  {
    butAction = newButAction;
  }

  public String getTxtPLIType()
  {
    return txtPLIType;
  }

  public void setTxtPLIType(String newTxtPLIType)
  {
    txtPLIType = newTxtPLIType;
  }

  public String getTxtPLIYear()
  {
    return txtPLIYear;
  }

  public void setTxtPLIYear(String newTxtPLIYear)
  {
    txtPLIYear = newTxtPLIYear;
  }

  public String getTxtPLIPerc()
  {
    return txtPLIPerc;
  }

  public void setTxtPLIPerc(String newTxtPLIPerc)
  {
    txtPLIPerc = newTxtPLIPerc;
  }

  public String getTxtPLIAdvAmnt()
  {
    return txtPLIAdvAmnt;
  }

  public void setTxtPLIAdvAmnt(String newTxtPLIAdvAmnt)
  {
    txtPLIAdvAmnt = newTxtPLIAdvAmnt;
  }
  
  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }
  
  public String [] getTxtAllEmpNo()
  {
    return txtAllEmpNo;
  }

  public void setTxtAllEmpNo(String [] newTxtAllEmpNo)
  {
    txtAllEmpNo = newTxtAllEmpNo;
  }
  
  public String [] getTxtAllEmpName()
  {
    return txtAllEmpName;
  }
  
  public void setTxtAllEmpName(String [] newTxtAllEmpName)
  {
    txtAllEmpName = newTxtAllEmpName;
  }
  
  public String [] getTxtDesig()
  {
    return txtDesig;
  }

  public void setTxtDesig(String [] newTxtDesig)
  {
    txtDesig = newTxtDesig;
  }
  
  public String [] getPrevPLIPaidAmnt()
  {
    return prevPLIPaidAmnt;
  }

  public void setPrevPLIPaidAmnt(String [] newPrevPLIPaidAmnt)
  {
    prevPLIPaidAmnt = newPrevPLIPaidAmnt;
  }
  
  public String [] getTxtPLIAmnt()
  {
    return txtPLIAmnt;
  }

  public void setTxtPLIAmnt(String [] newTxtPLIAmnt)
  {
    txtPLIAmnt = newTxtPLIAmnt;
  }
  
   public String [] getTxtIncomTax()
  {
    return txtIncomTax;
  }

  public void setTxtIncomTax(String [] newTxtIncomTax)
  {
    txtIncomTax = newTxtIncomTax;
  }
  
  public String [] getTxtLeaveDed()
  {
    return txtLeaveDed;
  }

  public void setTxtLeaveDed(String [] newTxtLeaveDed)
  {
    txtLeaveDed = newTxtLeaveDed;
  }
  
  public String [] getNetAmntPayble()
  {
    return netAmntPayble;
  }

  public void setNetAmntPayble(String [] newNetAmntPayble)
  {
    netAmntPayble = newNetAmntPayble;
  }
  
   public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
  public String getScreenModePLI()
  {
    return screenModePLI;
  }

  public void setScreenModePLI(String newScreenModePLI)
  {
    screenModePLI = newScreenModePLI;
  } 
  public String getScreenModePLI1()
  {
    return screenModePLI1;
  }

  public void setScreenModePLI1(String newScreenModePLI1)
  {
    screenModePLI1 = newScreenModePLI1;
  } 
  
  public String getScreenModePLI2()
  {
    return screenModePLI2;
  }

  public void setScreenModePLI2(String newScreenModePLI2)
  {
    screenModePLI2 = newScreenModePLI2;
  } 
  
  public String getScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(String newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  } 

}