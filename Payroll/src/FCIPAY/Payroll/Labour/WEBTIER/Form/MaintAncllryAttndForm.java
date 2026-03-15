    /*
    * Module:        MaintHndlngAttndForm.java
    * Author:        Aqeel Ahmed
    * Date Written:  Feb 2008
    * Description:   Action Form for Ancillary Attendance Details
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.Labour.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintPayCodesBean;

public class MaintAncllryAttndForm extends PayrollBaseForm 
{
    private String lstLabourType;
    private String txtGangId;
    private String txtGangName;
    private String [] txtLabourCode;
    private String txtLocation;    
    private String txtLocId;    
    private String [] txtEmpNo;
    private String [] txtEmpName;
    private String [] txtDays1;
    private String [] txtDays2;
    private String [] txtDays3;
    private String [] txtDays4;
    private String [] txtDays5;
    private String [] txtDays6;
    private String [] txtDays7;
    private String [] txtDays8;
    private String [] txtDays9;
    private String [] txtDays10;
    private String [] txtDays11;
    private String [] txtDays12;
    private String [] txtDays13;
    private String [] txtDays14;
    private String [] txtDays15;
    private String [] txtDays16;
    private String [] txtDays17;
    private String [] txtDays18;
    private String [] txtDays19;
    private String [] txtDays20;
    private String [] txtDays21;
    private String [] txtDays22;
    private String [] txtDays23;
    private String [] txtDays24;
    private String [] txtDays25;
    private String [] txtDays26;
    private String [] txtDays27;
    private String [] txtDays28;
    private String [] txtDays29;
    private String [] txtDays30;
    private String [] txtDays31;
    private String screenModeFlag;
        
    private String txtDaMinimum[] = null;
   
    private String hdnCheck[] = null;
    private ArrayList lstInstrDtls = new ArrayList();
    private ArrayList lstInstrDtls1 = new ArrayList();
    private long txtTest = 0;
    private String action = "";
    private String lstPayScaleType;
    private String txtYYMM;
    private String hdrGoto;
    private String txtDPRate[]=null;
    private String txtDAType;
    private String txtSrlNo[]=null;
    private String screenModeDARate;
    private String screenModeCDA;
    private String headerClick;
    private String screenModeID = "";
    private String headerMode;
    private String headerMode1;
  
    
    /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
    public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstInstrDtls.clear();
        this.txtTest = 0;
   }
   
   public String getLstLabourType()
  {
    return lstLabourType;
  }

  public void setLstLabourType(String newLstLabourType)
  {
    lstLabourType = newLstLabourType;
  }

   public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  }
  
  public String getTxtGangName()
  {
    return txtGangName;
  }

  public void setTxtGangName(String newTxtGangName)
  {
    txtGangName = newTxtGangName;
  }
  
   public String [] getTxtLabourCode()
    {
      return txtLabourCode;
    }
  
    public void setTxtLabourCode(String [] newTxtLabourCode)
    {
      txtLabourCode = newTxtLabourCode;
    }

  
  public String getTxtLocation()
  {
    return txtLocation;
  }

  public void setTxtLocation(String newTxtLocation)
  {
    txtLocation = newTxtLocation;
  }
  
  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  }
  
    public String[] getTxtEmpNo()
    {
        return txtEmpNo;
    }

    public void setTxtEmpNo(String [] newTxtEmpNo)
    {
        txtEmpNo = newTxtEmpNo;
    }

    public String [] getTxtEmpName()
    {
        return txtEmpName;
    }

    public void setTxtEmpName(String [] newTxtEmpName)
    {
        txtEmpName = newTxtEmpName;
    }

    public String [] getTxtDays1()
    {
        return txtDays1;
    }

    public void setTxtDays1(String [] newTxtDays1)
    {
        txtDays1 = newTxtDays1;
    }
    
    public String[] getTxtDays2()
    {
        return txtDays2;
    }

    public void setTxtDays2(String[] newTxtDays2)
    {
        txtDays2 = newTxtDays2;
    }
    
    public String[] getTxtDays3()
    {
        return txtDays3;
    }

    public void setTxtDays3(String[] newTxtDays3)
    {
        txtDays3 = newTxtDays3;
    }
    
    public String[] getTxtDays4()
    {
        return txtDays4;
    }

    public void setTxtDays4(String[] newTxtDays4)
    {
        txtDays4 = newTxtDays4;
    }
    
    public String[] getTxtDays5()
    {
        return txtDays5;
    }

    public void setTxtDays5(String[] newTxtDays5)
    {
        txtDays5 = newTxtDays5;
    }
    
    public String[] getTxtDays6()
    {
        return txtDays6;
    }

    public void setTxtDays6(String[] newTxtDays6)
    {
        txtDays6 = newTxtDays6;
    }
    
    public String[] getTxtDays7()
    {
        return txtDays7;
    }

    public void setTxtDays7(String[] newTxtDays7)
    {
        txtDays7 = newTxtDays7;
    }
    
    public String[] getTxtDays8()
    {
        return txtDays8;
    }

    public void setTxtDays8(String[] newTxtDays8)
    {
        txtDays8 = newTxtDays8;
    }
    
    public String[] getTxtDays9()
    {
        return txtDays9;
    }

    public void setTxtDays9(String[] newTxtDays9)
    {
        txtDays9 = newTxtDays9;
    }
    
    public String[] getTxtDays10()
    {
        return txtDays10;
    }

    public void setTxtDays10(String[] newTxtDays10)
    {
        txtDays10 = newTxtDays10;
    }
    
    public String[] getTxtDays11()
    {
        return txtDays11;
    }

    public void setTxtDays11(String[] newtxtDays11)
    {
        txtDays11 = newtxtDays11;
    }
    
    public String[] getTxtDays12()
    {
        return txtDays12;
    }

    public void setTxtDays12(String[] newtxtDays12)
    {
        txtDays12 = newtxtDays12;
    }
    
    public String[] getTxtDays13()
    {
        return txtDays13;
    }

    public void setTxtDays13(String[] newtxtDays13)
    {
        txtDays13 = newtxtDays13;
    }
    
    public String[] getTxtDays14()
    {
        return txtDays14;
    }

    public void setTxtDays14(String[] newtxtDays14)
    {
        txtDays14 = newtxtDays14;
    }
    
    public String[] getTxtDays15()
    {
        return txtDays15;
    }

    public void setTxtDays15(String[] newtxtDays15)
    {
        txtDays15 = newtxtDays15;
    }
    
    public String[] getTxtDays16()
    {
        return txtDays16;
    }

    public void setTxtDays16(String[] newtxtDays16)
    {
        txtDays16 = newtxtDays16;
    }
    
    public String[] getTxtDays17()
    {
        return txtDays17;
    }

    public void setTxtDays17(String[] newtxtDays17)
    {
        txtDays17 = newtxtDays17;
    }
    
    public String[] getTxtDays18()
    {
        return txtDays18;
    }

    public void setTxtDays18(String[] newtxtDays18)
    {
        txtDays18 = newtxtDays18;
    }
    
    public String[] getTxtDays19()
    {
        return txtDays19;
    }

    public void setTxtDays19(String[] newtxtDays19)
    {
        txtDays19 = newtxtDays19;
    }
    
    public String[] getTxtDays20()
    {
        return txtDays20;
    }

    public void setTxtDays20(String[] newtxtDays20)
    {
        txtDays20 = newtxtDays20;
    }
    
    public String[] getTxtDays21()
    {
        return txtDays21;
    }

    public void setTxtDays21(String[] newtxtDays21)
    {
        txtDays21 = newtxtDays21;
    }
    
    public String[] getTxtDays22()
    {
        return txtDays22;
    }

    public void setTxtDays22(String[] newtxtDays22)
    {
        txtDays22 = newtxtDays22;
    }
    
    public String[] getTxtDays23()
    {
        return txtDays23;
    }

    public void setTxtDays23(String[] newtxtDays23)
    {
        txtDays23 = newtxtDays23;
    }
    
    public String[] getTxtDays24()
    {
        return txtDays24;
    }

    public void setTxtDays24(String[] newtxtDays24)
    {
        txtDays24 = newtxtDays24;
    }
    
    public String[] getTxtDays25()
    {
        return txtDays25;
    }

    public void setTxtDays25(String[] newtxtDays25)
    {
        txtDays25 = newtxtDays25;
    }
    
    public String[] getTxtDays26()
    {
        return txtDays26;
    }

    public void setTxtDays26(String[] newtxtDays26)
    {
        txtDays26 = newtxtDays26;
    }
    
    public String[] getTxtDays27()
    {
        return txtDays27;
    }

    public void setTxtDays27(String[] newtxtDays27)
    {
        txtDays27 = newtxtDays27;
    }
    
    public String[] getTxtDays28()
    {
        return txtDays28;
    }

    public void setTxtDays28(String[] newtxtDays28)
    {
        txtDays28 = newtxtDays28;
    }
    
    public String[] getTxtDays29()
    {
        return txtDays29;
    }

    public void setTxtDays29(String[] newtxtDays29)
    {
        txtDays29 = newtxtDays29;
    }
    
    public String[] getTxtDays30()
    {
        return txtDays30;
    }

    public void setTxtDays30(String[] newtxtDays30)
    {
        txtDays30 = newtxtDays30;
    }
    
    public String[] getTxtDays31()
    {
        return txtDays31;
    }

    public void setTxtDays31(String[] newtxtDays31)
    {
        txtDays31 = newtxtDays31;
    }
    
    public String[] gettxtDaMinimum()
    {
        return txtDaMinimum;
    }

    public void settxtDaMinimum(String[] newtxtDaMinimum)
    {
        txtDaMinimum = newtxtDaMinimum;
    } 

    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }

    public long getTxtTest()
    {
        return txtTest;
    }

    public void setTxtTest(long newTxtTest)
    {
        txtTest = newTxtTest;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String newAction)
    {
        action = newAction;
    }
   
    public String[] getHdnCheck()
    {
        return hdnCheck;
    }

    public void setHdnCheck(String[] newHdnCheck)
    {
        hdnCheck = newHdnCheck;
    }

  public String getLstPayScaleType()
  {
    return lstPayScaleType;
  }

  public void setLstPayScaleType(String newLstPayScaleType)
  {
    lstPayScaleType = newLstPayScaleType;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }
    
 
  public String getHdrGoto()
  {
    return hdrGoto;
  }

  public void setHdrGoto(String newHdrGoto)
  {
    hdrGoto = newHdrGoto;
  }

public ArrayList getLstInstrDtls1()
    {
        return lstInstrDtls1;
    }

    public void setLstInstrDtls1(ArrayList newLstInstrDtls1)
    {
        lstInstrDtls1 = newLstInstrDtls1;
    }

  public String[] getTxtDPRate()
  {
    return txtDPRate;
  }

  public void setTxtDPRate(String[] newTxtDPRate)
  {
    txtDPRate = newTxtDPRate;
  }

  public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }



  public String getScreenModeDARate()
  {
    return screenModeDARate;
  }

  public void setScreenModeDARate(String newScreenModeDARate)
  {
    screenModeDARate = newScreenModeDARate;
  }

  public String getScreenModeCDA()
  {
    return screenModeCDA;
  }

  public void setScreenModeCDA(String newScreenModeCDA)
  {
    screenModeCDA = newScreenModeCDA;
  }

  public String getHeaderClick()
  {
    return headerClick;
  }

  public void setHeaderClick(String newHeaderClick)
  {
    headerClick = newHeaderClick;
  }

  public String getScreenModeID()
  {
    return screenModeID;
  }

  public void setScreenModeID(String newScreenModeID)
  {
    screenModeID = newScreenModeID;
  }

  public String getHeaderMode()
  {
    return headerMode;
  }

  public void setHeaderMode(String newHeaderMode)
  {
    headerMode = newHeaderMode;
  }

  public String getHeaderMode1()
  {
    return headerMode1;
  }

  public void setHeaderMode1(String newHeaderMode1)
  {
    headerMode1 = newHeaderMode1;
  }
  
  public String getScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(String newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  }









 /* public String getHeaderMode()
  {
    return HeaderMode;
  }

  public void setHeaderMode(String newHeaderMode)
  {
    HeaderMode = newHeaderMode;
  }

  public String getHeaderMode1()
  {
    return HeaderMode1;
  }

  public void setHeaderMode1(String newHeaderMode1)
  {
    HeaderMode1 = newHeaderMode1;
  }*/









}