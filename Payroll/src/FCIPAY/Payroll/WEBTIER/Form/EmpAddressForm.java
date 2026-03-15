package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class EmpAddressForm extends PayrollBaseForm
{
  private String txtEmpNo;
  private String txtStaffCode;
  private String txtEmpName;
  private String txtDsgn;  
  private String txtDsgnDesc;
  private String txtCateg;  
  private String txtCategDesc;  
  private String txtEmpType;
  private String txtEmpTypeId;
  private String txtDojFCI;
  private String txtPresentPOP;
  private String txtPresentPOPDesc;
  private String txtDOJSite;
  private String txtEmpStatus;
  
  private String txtAddId;
  /*private String txtAddType;
  private String txtAddL1;
  private String txtAddL2;
  private String txtCity;
  private String txtState;
  private String txtCountry;
  private String txtPin;*/
  private String txtPermAddL1;
  private String txtPermAddL2;
  private String txtPermCity;
  private String txtPermState;
  private String txtPermStateDesc;
  private String txtPermCountry;
  private String txtPermPin;
  private String txtTempAddL1;
  private String txtTempAddL2;
  private String txtTempCity;
  private String txtTempState;
  private String txtTempStateDesc;
  private String txtTempCountry;
  private String txtTempPin;

  public EmpAddressForm()
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
  
  public String getTxtStaffCode()
  {
    return txtStaffCode;
  }

  public void setTxtStaffCode(String newTxtStaffCode)
  {
    txtStaffCode = newTxtStaffCode;
  } 
  

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
  
  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtCategDesc()
  {
    return txtCategDesc;
  }

  public void setTxtCategDesc(String newTxtCategDesc)
  {
    txtCategDesc = newTxtCategDesc;
  }
  
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  public String getTxtPresentPOPDesc()
  {
    return txtPresentPOPDesc;
  }

  public void setTxtPresentPOPDesc(String newTxtPresentPOPDesc)
  {
    txtPresentPOPDesc = newTxtPresentPOPDesc;
  }
  

  public String getTxtDsgn()
  {
    return txtDsgn;
  }
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }


  public String getTxtEmpType()
  {
    return txtEmpType;
  }

  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }
  
  public String getTxtEmpTypeId()
  {
    return txtEmpTypeId;
  }

  public void setTxtEmpTypeId(String newTxtEmpTypeId)
  {
    txtEmpTypeId = newTxtEmpTypeId;
  }   
  

  public String getTxtDojFCI()
  {
    return txtDojFCI;
  }

  public void setTxtDojFCI(String newTxtDojFCI)
  {
    txtDojFCI = newTxtDojFCI;
  }  

  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
  
  public String getTxtDOJSite()
  {
    return txtDOJSite;
  }

  public void setTxtDOJSite(String newTxtDOJSite)
  {
    txtDOJSite = newTxtDOJSite;
  } 
  
  public String getTxtAddId()
  {
    return txtAddId;
  }  

  public void setTxtAddId(String newTxtAddId)
  {
    txtAddId = newTxtAddId;
  }

  public String getTxtPermAddL1()
  {
    return txtPermAddL1;
  }

  public void setTxtPermAddL1(String newTxtPermAddL1)
  {
    txtPermAddL1 = newTxtPermAddL1;
  }

  public String getTxtPermAddL2()
  {
    return txtPermAddL2;
  }

  public void setTxtPermAddL2(String newTxtPermAddL2)
  {
    txtPermAddL2 = newTxtPermAddL2;
  }
  
  public String getTxtPermCity()
  {
    return txtPermCity;
  }

  public void setTxtPermCity(String newTxtPermCity)
  {
    txtPermCity = newTxtPermCity;
  }
  
  public String getTxtPermState()
  {
    return txtPermState;
  }

  public void setTxtPermState(String newTxtPermState)
  {
    txtPermState = newTxtPermState;
  }
  
  public String getTxtPermStateDesc()
  {
    return txtPermStateDesc;
  }

  public void setTxtPermStateDesc(String newTxtPermStateDesc)
  {
    txtPermStateDesc = newTxtPermStateDesc;
  }
  
  public String getTxtPermCountry()
  {
    return txtPermCountry;
  }

  public void setTxtPermCountry(String newTxtPermCountry)
  {
    txtPermCountry = newTxtPermCountry;
  }
  
  public String getTxtPermPin()
  {
    return txtPermPin;
  }

  public void setTxtPermPin(String newTxtPermPin)
  {
    txtPermPin = newTxtPermPin;
  }
  
  public String getTxtTempAddL1()
  {
    return txtTempAddL1;
  }

  public void setTxtTempAddL1(String newTxtTempAddL1)
  {
    txtTempAddL1 = newTxtTempAddL1;
  }

  public String getTxtTempAddL2()
  {
    return txtTempAddL2;
  }

  public void setTxtTempAddL2(String newTxtTempAddL2)
  {
    txtTempAddL2 = newTxtTempAddL2;
  }
  
  public String getTxtTempCity()
  {
    return txtTempCity;
  }

  public void setTxtTempCity(String newTxtTempCity)
  {
    txtTempCity = newTxtTempCity;
  }
  
  public String getTxtTempState()
  {
    return txtTempState;
  }

  public void setTxtTempState(String newTxtTempState)
  {
    txtTempState = newTxtTempState;
  }
  
  public String getTxtTempStateDesc()
  {
    return txtTempStateDesc;
  }

  public void setTxtTempStateDesc(String newTxtTempStateDesc)
  {
    txtTempStateDesc = newTxtTempStateDesc;
  }
  
  public String getTxtTempCountry()
  {
    return txtTempCountry;
  }

  public void setTxtTempCountry(String newTxtTempCountry)
  {
    txtTempCountry = newTxtTempCountry;
  }
  
  public String getTxtTempPin()
  {
    return txtTempPin;
  }

  public void setTxtTempPin(String newTxtTempPin)
  {
    txtTempPin = newTxtTempPin;
  }

}


