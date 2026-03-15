package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class LeaseAccomForm extends PayrollBaseForm 
{
  private String []txtFromDate;
  private String []txtToDate;
  private String txtEmpNo= "";
  private ArrayList lstInstrDtls = new ArrayList();
  private String screenModeLease;
  private String butAction;
  private String txtEmpName;
  private String txtCpfCode;
  private String []hdnSrlNo;
  private String []txtAccomTyp;
  private String []txtHraAmt;
  private String []txtLicenseFee;
  private String []txtLeaseAmt;
  private String []txtArrearInst;
  private String []txtArrearFlag;
  private String []txtMaxInst;
  private String []txtLeasePerc;
// added by varalika on 30-Sep-2011

   private String []txtCreationDate; 
   private String []txtCreatedBy; 
   private String []txtCreatedSite; 
   private String []txtUpdationDate; 
   private String []txtUpdatedBy; 
   private String []txtUpdatedSite; 
 // ended by varalika

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
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }

  public String[] getTxtFromDate()
  {
    return txtFromDate;
  }

  public void setTxtFromDate(String[] newTxtFromDate)
  {
    txtFromDate = newTxtFromDate;
  }

  public String[] getTxtToDate()
  {
    return txtToDate;
  }

  public void setTxtToDate(String[] newTxtToDate)
  {
    txtToDate = newTxtToDate;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }


  public String getScreenModeLease()
  {
    return screenModeLease;
  }

  public void setScreenModeLease(String newScreenModeLease)
  {
    screenModeLease = newScreenModeLease;
  }


  public String getButAction()
  {
    return butAction;
  }

  public void setButAction(String newButAction)
  {
    butAction = newButAction;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }

  public String[] getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String[] newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }

  public String[] getTxtAccomTyp()
  {
    return txtAccomTyp;
  }

  public void setTxtAccomTyp(String[] newTxtAccomTyp)
  {
    txtAccomTyp = newTxtAccomTyp;
  }

  public String[] getTxtHraAmt()
  {
    return txtHraAmt;
  }

  public void setTxtHraAmt(String[] newTxtHraAmt)
  {
    txtHraAmt = newTxtHraAmt;
  }

  public String[] getTxtLicenseFee()
  {
    return txtLicenseFee;
  }

  public void setTxtLicenseFee(String[] newTxtLicenseFee)
  {
    txtLicenseFee = newTxtLicenseFee;
  }

  public String[] getTxtLeaseAmt()
  {
    return txtLeaseAmt;
  }

  public void setTxtLeaseAmt(String[] newTxtLeaseAmt)
  {
    txtLeaseAmt = newTxtLeaseAmt;
  }
  
  public String[] getTxtArrearInst()
  {
    return txtArrearInst;
  }

  public void setTxtArrearInst(String[] newTxtArrearInst)
  {
    txtArrearInst = newTxtArrearInst;
  }
  
  public String[] getTxtArrearFlag()
  {
    return txtArrearFlag;
  }

  public void setTxtArrearFlag(String[] newTxtArrearFlag)
  {
    txtArrearFlag = newTxtArrearFlag;
  }
  
  public String[] getTxtMaxInst()
  {
    return txtMaxInst;
  }

  public void setTxtMaxInst(String[] newTxtMaxInst)
  {
    txtMaxInst = newTxtMaxInst;
  }
  
  public String[] getTxtLeasePerc()
  {
    return txtLeasePerc;
  }

  public void setTxtLeasePerc(String[] newTxtLeasePerc)
  {
    txtLeasePerc = newTxtLeasePerc;
  }
//added by varalika on 30-Sep-2011//
 public String[] getTxtCreationDate()
  {
    return txtCreationDate;
  }

  public void setTxtCreationDate(String []newtxtCreationDate)
  {

    txtCreationDate = newtxtCreationDate;
  }

 public String[] getTxtCreatedBy()
  {
    return txtCreatedBy;
  }

  public void setTxtCreatedBy(String []newtxtCreatedBy)
  {
    txtCreatedBy = newtxtCreatedBy;
  }
  
  public String [] getTxtCreatedSite()
  {
    return txtCreatedSite;
  }

  public void setTxtCreatedSite(String[] newtxtCreatedSite)
  {
    txtCreatedSite = newtxtCreatedSite;
  }
//updation details
 public String[] getTxtUpdationDate()
  {
    return txtUpdationDate;
  }

  public void setTxtUpdationDate(String[] newtxtUpdationDate)
  {
    txtUpdationDate = newtxtUpdationDate;
  }

  public String[] getTxtUpdatedBy()
  {
    return txtUpdatedBy;
  }

  public void setTxtUpdatedBy(String[] newtxtUpdatedBy)
  {
    txtUpdatedBy = newtxtUpdatedBy;
  }
  
  public String[] getTxtUpdatedSite()
  {
    return txtUpdatedSite;
  }

  public void setTxtUpdatedSite(String[] newtxtUpdatedSite)
  {
    txtUpdatedSite = newtxtUpdatedSite;
    }
// ended by varalika
  
}