package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class CPFFinalPaymentQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String screenName;
  private String hdnSancType;
  private String sancDate;
  private String txtReason;
  private String sancAmount;
  private String vpfContri;
  private String empContri;
  private String emplyrContri;
  private String noInstallAmt;
  private String txtSysSantionNum;//added by geetika
  private String txtInvID;//added by arvind
  private String SancOrderNo;//added by arvind
  private String loginEmployeeNo; //added by arvind

  public CPFFinalPaymentQueryVO()
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
 
  public String getScreenName()
  {
    return screenName;
  }

  public void setScreenName(String newScreenName)
  {
    screenName = newScreenName;
  }  
  
  public String getHdnSancType()
  {
    return hdnSancType;
  }

  public void setHdnSancType(String newHdnSancType)
  {
    hdnSancType = newHdnSancType;
  } 
  
  public String getSancDate()
  {
    return sancDate;
  }

  public void setSancDate(String newSancDate)
  {
    sancDate = newSancDate;
  } 

  public String getSancAmount()
  {
    return sancAmount;
  }

  public void setSancAmount(String newSancAmount)
  {
    sancAmount = newSancAmount;
  } 
  
  public String getTxtReason()
  {
    return txtReason;
  }

  public void setTxtReason(String newTxtReason)
  {
    txtReason = newTxtReason;
  }
  
  public String getEmpContri()
  {
    return empContri;
  }

  public void setEmpContri(String newEmpContri)
  {
    empContri = newEmpContri;
  }

  public String getEmplyrContri()
  {
    return emplyrContri;
  }

  public void setEmplyrContri(String newEmplyrContri)
  {
    emplyrContri = newEmplyrContri;
  }
  
  public String getVpfContri()
  {
    return vpfContri;
  }

  public void setVpfContri(String newVpfContri)
  {
    vpfContri = newVpfContri;
  }

  public String getNoInstallAmt()
  {
    return noInstallAmt;
  }

  public void setNoInstallAmt(String newNoInstallAmt)
  {
    noInstallAmt = newNoInstallAmt;
  }
  
  
//added by geetika 14/12/2013
  public String geTxtSysSantionNum()
  {
    return txtSysSantionNum;
  }

  public void settxtSysSantionNum(String newTxtSysSantionNum)
  {
    txtSysSantionNum = newTxtSysSantionNum;
  }
//added by arvind 26/7/2017  
  public String getTxtInvID()
  {
      return txtInvID;
  }
  
  public void setTxtInvID(String newTxtInvID)
  {
      txtInvID = newTxtInvID;
  }
  
  public String getSancOrderNo()
  {
      return SancOrderNo;
  }
  
  public void setSancOrderNo(String newSancOrderNo) 
  {
      SancOrderNo = newSancOrderNo;
  }

    public void setLoginEmployeeNo(String loginEmployeeNo) 
    {
        this.loginEmployeeNo = loginEmployeeNo;
    }

    public String getLoginEmployeeNo() 
    {
        return loginEmployeeNo;
    }
}
