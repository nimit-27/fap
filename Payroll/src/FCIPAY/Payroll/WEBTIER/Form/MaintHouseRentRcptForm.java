package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;



public class MaintHouseRentRcptForm extends PayrollBaseForm
{
  
  private String txtEmpNo;
  private String [] txtMonth;
  private String txtYYMM[]=null;
  private String txtAmt[]=null;
  private String [] txtMnthRentAmt;
  ArrayList lstInstrDtls= new ArrayList();
  private String txtEmpName;
  private String txtFinYYMM;
  private String screenModeHRR;
  private boolean flag;
  private String hdnSrlNo[] = null;
  private boolean screenModeFlag;
  private String txtRentAmt;

 public MaintHouseRentRcptForm()
  {
  }
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String[] getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String[] newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String[] getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String[] newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtFinYYMM()
  {
    return txtFinYYMM;
  }

  public void setTxtFinYYMM(String newTxtFinYYMM)
  {
    txtFinYYMM = newTxtFinYYMM;
  }

  public String getScreenModeHRR()
  {
    return screenModeHRR;
  }

  public void setScreenModeHRR(String newScreenModeHRR)
  {
    screenModeHRR = newScreenModeHRR;
  }

  public boolean isFlag()
  {
    return flag;
  }

  public void setFlag(boolean newFlag)
  {
    flag = newFlag;
  }

  public String[] getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String[] newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }

  public boolean isScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(boolean newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  }

  public String[] getTxtMonth()
  {
    return txtMonth;
  }

  public void setTxtMonth(String[] newTxtMonth)
  {
    txtMonth = newTxtMonth;
  }
  
  public String getTxtRentAmt()
  {
    return txtRentAmt;
  }

  public void setTxtRentAmt(String newTxtRentAmt)
  {
    txtRentAmt = newTxtRentAmt;
  }

  public String [] getTxtMnthRentAmt()
  {
    return txtMnthRentAmt;
  }

  public void setTxtMnthRentAmt(String [] newTxtMnthRentAmt)
  {
    txtMnthRentAmt = newTxtMnthRentAmt;
  }

}