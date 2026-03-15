package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class EmpCPFSearchQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtEmpFirstName;  
  private String txtEmpLastName;      
  private String txtStaffCode; 
  private String txtCpfCode="";
  private String txtDsgnDesc;
  private String txtEmpTypeId;
  private String txtPresentPOP;
  private String txtCadre;
  private String txtDsgn;
  
  
  public EmpCPFSearchQueryVO()
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

  public String getTxtEmpFirstName()
  {
    return txtEmpFirstName;
  }

  public void setTxtEmpFirstName(String newTxtEmpFirstName)
  {
    txtEmpFirstName = newTxtEmpFirstName;
  }

  public String getTxtEmpLastName()
  {
    return txtEmpLastName;
  }

  public void setTxtEmpLastName(String newTxtEmpLastName)
  {
    txtEmpLastName = newTxtEmpLastName;
  } 
  
  public String getTxtStaffCode()
  {
    return txtStaffCode;
  }
  public void setTxtStaffCode(String newTxtStaffCode)
  {
    txtStaffCode = newTxtStaffCode;
  } 
  
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
  
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }

  public String getTxtEmpTypeId()
  {
    return txtEmpTypeId;
  }

  public void setTxtEmpTypeId(String newTxtEmpTypeId)
  {
    txtEmpTypeId = newTxtEmpTypeId;
  }   
  
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  public String getTxtCadre()
  {
    return txtCadre;
  }

  public void setTxtCadre(String newTxtCadre)
  {
    txtCadre = newTxtCadre;
  } 
  
  public String getTxtDsgn()
  {
    return txtDsgn;
  }

  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  } 
}