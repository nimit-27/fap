    /*
    * Module:        MaintPayCodesBean.java
    * Author:        Surajeet Chakraborty
    * Date Written:  December 2004
    * Description:   Bean Class for Maintaining the Pay Codes
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
public class MaintPayScaleDtlIDABean extends PayrollBaseDetailBean implements Serializable
{
        

  private String txtSrNo;
  
  private boolean TxtEfficiencyBar;
  private String txtSrlNo;
  private String startField;
  private String endField;
  private String txtGradePay;//added by geetika on 19-11-2014
  private String txtIncrement;
  public String hdnEBCheck;
  public String txtStartDate;
  public String txtEndDate;
 // private String txtRevYYMM1;
 // private String txtPayScaleCode;

    public MaintPayScaleDtlIDABean()
    {
    }

    public MaintPayScaleDtlIDABean(String sSrNo,String sStartField,String sIncrement,String sEndField, String sEBCheck,String sSrlNo)
    {
        txtSrNo = sSrNo;
        startField = sStartField;
        txtIncrement = sIncrement;
        endField = sEndField;
        hdnEBCheck = sEBCheck; 
   //     txtRevYYMM1=sRevyymm;
   //     txtPayScaleCode=sPayscale;
        txtSrlNo=sSrlNo;
    }

   

  public String getTxtSrNo()
  {
    return txtSrNo;
  }

  public void setTxtSrNo(String newTxtSrNo)
  {
    txtSrNo = newTxtSrNo;
  }



  public String getTxtIncrement()
  {
    return txtIncrement;
  }

  public void setTxtIncrement(String newTxtIncrement)
  {
    txtIncrement = newTxtIncrement;
  }



  public String getHdnEBCheck()
  {
    return hdnEBCheck;
  }

  public void setHdnEBCheck(String newHdnEBCheck)
  {
    hdnEBCheck = newHdnEBCheck;
  }

  public boolean isTxtEfficiencyBar()
  {
    return TxtEfficiencyBar;
  }

  public void setTxtEfficiencyBar(boolean newTxtEfficiencyBar)
  {
    TxtEfficiencyBar = newTxtEfficiencyBar;
  }
 public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getStartField()
  {
    return startField;
  }

  public void setStartField(String newStartField)
  {
    startField = newStartField;
  }

  public String getEndField()
  {
    return endField;
  }

  public void setEndField(String newEndField)
  {
    endField = newEndField;
  }
//added by geetika on 19-11-2014  
    public String getTxtGradePay()
  {
    return txtGradePay;
  }

  public void setTxtGradePay(String newtxtGradePay)
  {
    txtGradePay = newtxtGradePay;
  }
  public String getTxtStartDate()
  {
    return txtStartDate;
  }

  public void setTxtStartDate(String newtxtStartDate)
  {
    txtStartDate = newtxtStartDate;
  }
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newtxtEndDate)
  {
    txtEndDate = newtxtEndDate;
  }




}