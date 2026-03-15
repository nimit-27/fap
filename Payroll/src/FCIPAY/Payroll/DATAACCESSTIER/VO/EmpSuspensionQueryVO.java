package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class EmpSuspensionQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String radFlg;
  //private String txtEmpFirstName;  
  //private String txtEmpLastName;

  public EmpSuspensionQueryVO()
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
  public String getRadFlg()
  {
    return radFlg;
  }

  public void setRadFlg(String newRadFlg)
  {
    radFlg = newRadFlg;
  } 
  /*public String getTxtEmpFirstName()
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
  }*/  

}