package FCIPAY.Payroll.DATAACCESSTIER.VO;
import  FCIPAY.Payroll.common.vo.BaseQueryVO; 
import java.io.Serializable;

public class PLIPaymentQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String optSelectAllEmp;
  private String optSelectAllEmpVal;
  private String txtPLIYear;
  private String txtPLIType;
  private String txtPLIAdvAmnt;
  private String txtPLIPerc; 

  public PLIPaymentQueryVO()
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

  public String getOptSelectAllEmp()
  {
    return optSelectAllEmp;
  }

  public void setOptSelectAllEmp(String newOptSelectAllEmp)
  {
    optSelectAllEmp = newOptSelectAllEmp;
  }

  public String getOptSelectAllEmpVal()
  {
    return optSelectAllEmpVal;
  }

  public void setOptSelectAllEmpVal(String newOptSelectAllEmpVal)
  {
    optSelectAllEmpVal = newOptSelectAllEmpVal;
  }  
  public String getTxtPLIYear()
  {
    return txtPLIYear;
  }

  public void setTxtPLIYear(String newTxtPLIYear)
  {
    txtPLIYear = newTxtPLIYear;
  }
  
  public String getTxtPLIType()
  {
    return txtPLIType;
  }

  public void setTxtPLIType(String newTxtPLIType)
  {
    txtPLIType = newTxtPLIType;
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

}