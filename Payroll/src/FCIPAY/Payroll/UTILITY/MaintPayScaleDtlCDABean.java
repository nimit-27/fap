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
public class MaintPayScaleDtlCDABean implements Serializable 
{
        

  private String txtSrNo;
  private String txtStartBasic;
  private String txtIncrement;
  private String txtFinalBasic;
  private String txtEfficiencyBar;

    public MaintPayScaleDtlCDABean()
    {
    }

    public MaintPayScaleDtlCDABean(String sSrNo,String sStartBasic,String sIncrement,String sFinalBasic)
    {
        txtSrNo = sSrNo;
        txtStartBasic = sStartBasic;
        txtIncrement = sIncrement;
        txtFinalBasic = sFinalBasic;
        
    }

   

  public String getTxtSrNo()
  {
    return txtSrNo;
  }

  public void setTxtSrNo(String newTxtSrNo)
  {
    txtSrNo = newTxtSrNo;
  }

  public String getTxtStartBasic()
  {
    return txtStartBasic;
  }

  public void setTxtStartBasic(String newTxtStartBasic)
  {
    txtStartBasic = newTxtStartBasic;
  }

  public String getTxtIncrement()
  {
    return txtIncrement;
  }

  public void setTxtIncrement(String newTxtIncrement)
  {
    txtIncrement = newTxtIncrement;
  }

  public String getTxtFinalBasic()
  {
    return txtFinalBasic;
  }

  public void setTxtFinalBasic(String newTxtFinalBasic)
  {
    txtFinalBasic = newTxtFinalBasic;
  }

  public String getTxtEfficiencyBar()
  {
    return txtEfficiencyBar;
  }

  public void setTxtEfficiencyBar(String newTxtEfficiencyBar)
  {
    txtEfficiencyBar = newTxtEfficiencyBar;
  }


      






}