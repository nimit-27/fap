package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class DeptLabourQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtEmpFirstName;  
  private String txtEmpLastName;    
  private String txtDsgnDesc;  
  private String txtCateg;  
  private String txtCadre;
  private String txtEmpTypeId;
  private String txtStaffCode;
  private String parentZone;
  private String txtEmpStatus;    
  private String txtSection;
  private String txtSectionDesc;
  private String txtCpfCode="";
  private String payRevFlag; // added by devendra on 21 sept 2010

  public DeptLabourQueryVO()
  {
  }

 // added by devendra on 21 sept 2010 start
 public String getPayRevFlag()
  {
    return payRevFlag;
  }

  public void setPayRevFlag(String newTxtPayRevFlag)
  {
    payRevFlag = newTxtPayRevFlag;
  }
 // added by devendra on 21 sept 2010 end
 
 
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
  
  public String getTxtCadre()
  {
    return txtCadre;
  }
  public void setTxtCadre(String newTxtCadre)
  {
    txtCadre = newTxtCadre;
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
  
  public String getParentZone()
  {
    return parentZone;
  }
  public void setParentZone(String newParentZone)
  {
    parentZone = newParentZone;
  }
  
  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }
  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
  
  public String getTxtSection()
  {
    return txtSection;
  }
  public void setTxtSection(String newTxtSection)
  {
    txtSection = newTxtSection;
  } 
  
  public String getTxtSectionDesc()
  {
    return txtSectionDesc;
  }

  public void setTxtSectionDesc(String newTxtSectionDesc)
  {
    txtSectionDesc = newTxtSectionDesc;
  } 
  
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }  
  
}