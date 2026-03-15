package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class PLIPaymentDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtPLIYear;
  private String txtDAType;
  private String txtEmpNo;
  private String txtPLIType;
  private String txtPLIPerc;
  private String txtPLIAdvAmnt;
  private String screenModeFlag;
  private String optSelectAllEmp;
  private String optSelectAllEmpVal;


  public PLIPaymentDetailInfo()
  {
  }

  public String getTxtPLIYear()
  {
    return txtPLIYear;
  }

  public void setTxtPLIYear(String newTxtPLIYear)
  {
    txtPLIYear = newTxtPLIYear;
  }

  public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  }
  
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
  
   public String getTxtPLIType()
  {
    return txtPLIType;
  }

  public void setTxtPLIType(String newTxtPLIType)
  {
    txtPLIType = newTxtPLIType;
  }
  
   public String getScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(String newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
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