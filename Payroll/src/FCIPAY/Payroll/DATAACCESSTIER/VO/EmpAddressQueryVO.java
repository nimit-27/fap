package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class EmpAddressQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtEmpName;  
  private String txtDsgnDesc;  
  private String txtCateg; 
  private String txtEmpTypeId;
  private String txtStaffCode;
  private String txtEmpStatus; 
  private String txtPresentPOP;

  public EmpAddressQueryVO()
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

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }
  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }
  
  public String getTxtCateg()
  {
    return txtCateg;
  }
  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtEmpTypeId()
  {
    return txtEmpTypeId;
  }
  public void setTxtEmpTypeId(String newTxtEmpTypeId)
  {
    txtEmpTypeId = newTxtEmpTypeId;
  } 
  
  public String getTxtStaffCode()
  {
    return txtStaffCode;
  }
  public void setTxtStaffCode(String newTxtStaffCode)
  {
    txtStaffCode = newTxtStaffCode;
  }
  
  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }
  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
 
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }  
  
}