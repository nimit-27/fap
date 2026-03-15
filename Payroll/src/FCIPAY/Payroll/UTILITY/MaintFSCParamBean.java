    /*
    * Module:        MaintFSCParamBean.java
    * Author:        RUPAM
    * Date Written:  May 2005
    * Description:   Bean Class for Maintaining the FSC Param
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
public class MaintFSCParamBean extends PayrollBaseDetailBean implements Serializable
{
    private String txtSrlNo = "";
    private String txtRateOfPenConForGrpA = "";
    private String txtRateOfLeaveConForGrpA = "";
    private String txtRateOfPenConForGrpB = "";
    private String txtRateOfLeaveConForGrpB = "";
    private String txtRateOfPenConForGrpC = "";
    private String txtRateOfLeaveConForGrpC = "";
    private String txtRateOfPenConForGrpD = "";
    private String txtRateOfLeaveConForGrpD = "";
//    private String hdnCheck = "";
    private boolean chkDel;
  private String endField;
  private String startField;

    public MaintFSCParamBean()
    {
    }

    public MaintFSCParamBean(String sSrlNo, String sFromYear, String sToYear, String sRateOfPenConForGrpA, String sRateOfLeaveConForGrpA, String sRateOfPenConForGrpB, String sRateOfLeaveConForGrpB, String sRateOfPenConForGrpC, String sRateOfLeaveConForGrpC, String sRateOfPenConForGrpD, String sRateOfLeaveConForGrpD)
    {       
       txtSrlNo = sSrlNo;
        startField = sFromYear;
        endField = sToYear;
        txtRateOfPenConForGrpA = sRateOfPenConForGrpA;
        txtRateOfLeaveConForGrpA = sRateOfLeaveConForGrpA;
        txtRateOfPenConForGrpB = sRateOfPenConForGrpB;
        txtRateOfLeaveConForGrpB = sRateOfLeaveConForGrpB;
        txtRateOfPenConForGrpC = sRateOfPenConForGrpC;
        txtRateOfLeaveConForGrpC = sRateOfLeaveConForGrpC;
        txtRateOfPenConForGrpD = sRateOfPenConForGrpD;
        txtRateOfLeaveConForGrpD = sRateOfLeaveConForGrpD;
//        hdnCheck = sCheck;
    }    

   public String gettxtSrlNo()
    {
        return txtSrlNo;
    }

    public void settxtSrlNo(String newtxtSrlNo)
    {
        txtSrlNo = newtxtSrlNo;
    } 
    


    public boolean isChkDel()
    {
        return chkDel;
    }

    public void setChkDel(boolean newChkDel)
    {
        chkDel = newChkDel;
    }

   
   

    public String gettxtRateOfPenConForGrpA()
    {
        return txtRateOfPenConForGrpA;
    }

    public void settxtRateOfPenConForGrpA(String newtxtRateOfPenConForGrpA)
    {
        txtRateOfPenConForGrpA = newtxtRateOfPenConForGrpA;
    }

    public String gettxtRateOfPenConForGrpB()
    {
        return txtRateOfPenConForGrpB;
    }

    public void settxtRateOfPenConForGrpB(String newtxtRateOfPenConForGrpB)
    {
        txtRateOfPenConForGrpB = newtxtRateOfPenConForGrpB;
    }

    public String gettxtRateOfPenConForGrpC()
    {
        return txtRateOfPenConForGrpC;
    }

    public void settxtRateOfPenConForGrpC(String newtxtRateOfPenConForGrpC)
    {
        txtRateOfPenConForGrpC = newtxtRateOfPenConForGrpC;
    }

    public String gettxtRateOfPenConForGrpD()
    {
        return txtRateOfPenConForGrpD;
    }

    public void settxtRateOfPenConForGrpD(String newtxtRateOfPenConForGrpD)
    {
        txtRateOfPenConForGrpD = newtxtRateOfPenConForGrpD;
    }

    public String gettxtRateOfLeaveConForGrpA()
    {
        return txtRateOfLeaveConForGrpA;
    }

    public void settxtRateOfLeaveConForGrpA(String newtxtRateOfLeaveConForGrpA)
    {
        txtRateOfLeaveConForGrpA = newtxtRateOfLeaveConForGrpA;
    }    

    public String gettxtRateOfLeaveConForGrpB()
    {
        return txtRateOfLeaveConForGrpB;
    }

    public void settxtRateOfLeaveConForGrpB(String newtxtRateOfLeaveConForGrpB)
    {
        txtRateOfLeaveConForGrpB = newtxtRateOfLeaveConForGrpB;
    }    

    public String gettxtRateOfLeaveConForGrpC()
    {
        return txtRateOfLeaveConForGrpC;
    }

    public void settxtRateOfLeaveConForGrpC(String newtxtRateOfLeaveConForGrpC)
    {
        txtRateOfLeaveConForGrpC = newtxtRateOfLeaveConForGrpC;
    }    

    public String gettxtRateOfLeaveConForGrpD()
    {
        return txtRateOfLeaveConForGrpD;
    }

    public void settxtRateOfLeaveConForGrpD(String newtxtRateOfLeaveConForGrpD)
    {
        txtRateOfLeaveConForGrpD = newtxtRateOfLeaveConForGrpD;
    }    

  public String getEndField()
  {
    return endField;
  }

  public void setEndField(String newEndField)
  {
    endField = newEndField;
  }

  public String getStartField()
  {
    return startField;
  }

  public void setStartField(String newStartField)
  {
    startField = newStartField;
  }
}