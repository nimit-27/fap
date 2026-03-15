package FCIPAY.Payroll.Labour.WEBTIER.Form;


import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;


public class NWNPMaintHndlngAttndForm  extends PayrollBaseForm {
   
    private String lstLabourType;
    private String txtGangId;
    private String txtGangName;
    private String txtLocation; 
    private String txtLocId;
    private String [] txtEmpNo;
    private String [] txtEmpName;
    private String [] txtLabourCode;
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
    private String yrMonth;
        
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
    
    private String [] dayModified1;
    private String [] dayModified2;
    private String [] dayModified3;
    private String [] dayModified4;
    private String [] dayModified5;
    private String [] dayModified6;
    private String [] dayModified7;
    private String [] dayModified8;
    private String [] dayModified9;
    private String [] dayModified10;
    private String [] dayModified11;
    private String [] dayModified12;
    private String [] dayModified13;
    private String [] dayModified14;
    private String [] dayModified15;
    private String [] dayModified16;
    private String [] dayModified17;
    private String [] dayModified18;
    private String [] dayModified19;
    private String [] dayModified20;
    private String [] dayModified21;
    private String [] dayModified22;
    private String [] dayModified23;
    private String [] dayModified24;
    private String [] dayModified25;
    private String [] dayModified26;
    private String [] dayModified27;
    private String [] dayModified28;
    private String [] dayModified29;
    private String [] dayModified30;
    private String [] dayModified31;
    
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
      
    
    public NWNPMaintHndlngAttndForm() {
        super();
    }


    public void setLstLabourType(String lstLabourType) {
        this.lstLabourType = lstLabourType;
    }

    public String getLstLabourType() {
        return lstLabourType;
    }

    public void setTxtGangId(String txtGangId) {
        this.txtGangId = txtGangId;
    }

    public String getTxtGangId() {
        return txtGangId;
    }

    public void setTxtGangName(String txtGangName) {
        this.txtGangName = txtGangName;
    }

    public String getTxtGangName() {
        return txtGangName;
    }

    public void setTxtLocation(String txtLocation) {
        this.txtLocation = txtLocation;
    }

    public String getTxtLocation() {
        return txtLocation;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setTxtEmpNo(String[] txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String[] getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtEmpName(String[] txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public String[] getTxtEmpName() {
        return txtEmpName;
    }

    public void setTxtLabourCode(String[] txtLabourCode) {
        this.txtLabourCode = txtLabourCode;
    }

    public String[] getTxtLabourCode() {
        return txtLabourCode;
    }

    public void setTxtDays1(String[] txtDays1) {
        this.txtDays1 = txtDays1;
    }

    public String[] getTxtDays1() {
        return txtDays1;
    }

    public void setTxtDays2(String[] txtDays2) {
        this.txtDays2 = txtDays2;
    }

    public String[] getTxtDays2() {
        return txtDays2;
    }

    public void setTxtDays3(String[] txtDays3) {
        this.txtDays3 = txtDays3;
    }

    public String[] getTxtDays3() {
        return txtDays3;
    }

    public void setTxtDays4(String[] txtDays4) {
        this.txtDays4 = txtDays4;
    }

    public String[] getTxtDays4() {
        return txtDays4;
    }

    public void setTxtDays5(String[] txtDays5) {
        this.txtDays5 = txtDays5;
    }

    public String[] getTxtDays5() {
        return txtDays5;
    }

    public void setTxtDays6(String[] txtDays6) {
        this.txtDays6 = txtDays6;
    }

    public String[] getTxtDays6() {
        return txtDays6;
    }

    public void setTxtDays7(String[] txtDays7) {
        this.txtDays7 = txtDays7;
    }

    public String[] getTxtDays7() {
        return txtDays7;
    }

    public void setTxtDays8(String[] txtDays8) {
        this.txtDays8 = txtDays8;
    }

    public String[] getTxtDays8() {
        return txtDays8;
    }

    public void setTxtDays9(String[] txtDays9) {
        this.txtDays9 = txtDays9;
    }

    public String[] getTxtDays9() {
        return txtDays9;
    }

    public void setTxtDays10(String[] txtDays10) {
        this.txtDays10 = txtDays10;
    }

    public String[] getTxtDays10() {
        return txtDays10;
    }

    public void setTxtDays11(String[] txtDays11) {
        this.txtDays11 = txtDays11;
    }

    public String[] getTxtDays11() {
        return txtDays11;
    }

    public void setTxtDays12(String[] txtDays12) {
        this.txtDays12 = txtDays12;
    }

    public String[] getTxtDays12() {
        return txtDays12;
    }

    public void setTxtDays13(String[] txtDays13) {
        this.txtDays13 = txtDays13;
    }

    public String[] getTxtDays13() {
        return txtDays13;
    }

    public void setTxtDays14(String[] txtDays14) {
        this.txtDays14 = txtDays14;
    }

    public String[] getTxtDays14() {
        return txtDays14;
    }

    public void setTxtDays15(String[] txtDays15) {
        this.txtDays15 = txtDays15;
    }

    public String[] getTxtDays15() {
        return txtDays15;
    }

    public void setTxtDays16(String[] txtDays16) {
        this.txtDays16 = txtDays16;
    }

    public String[] getTxtDays16() {
        return txtDays16;
    }

    public void setTxtDays17(String[] txtDays17) {
        this.txtDays17 = txtDays17;
    }

    public String[] getTxtDays17() {
        return txtDays17;
    }

    public void setTxtDays18(String[] txtDays18) {
        this.txtDays18 = txtDays18;
    }

    public String[] getTxtDays18() {
        return txtDays18;
    }

    public void setTxtDays19(String[] txtDays19) {
        this.txtDays19 = txtDays19;
    }

    public String[] getTxtDays19() {
        return txtDays19;
    }

    public void setTxtDays20(String[] txtDays20) {
        this.txtDays20 = txtDays20;
    }

    public String[] getTxtDays20() {
        return txtDays20;
    }

    public void setTxtDays21(String[] txtDays21) {
        this.txtDays21 = txtDays21;
    }

    public String[] getTxtDays21() {
        return txtDays21;
    }

    public void setTxtDays22(String[] txtDays22) {
        this.txtDays22 = txtDays22;
    }

    public String[] getTxtDays22() {
        return txtDays22;
    }

    public void setTxtDays23(String[] txtDays23) {
        this.txtDays23 = txtDays23;
    }

    public String[] getTxtDays23() {
        return txtDays23;
    }

    public void setTxtDays24(String[] txtDays24) {
        this.txtDays24 = txtDays24;
    }

    public String[] getTxtDays24() {
        return txtDays24;
    }

    public void setTxtDays25(String[] txtDays25) {
        this.txtDays25 = txtDays25;
    }

    public String[] getTxtDays25() {
        return txtDays25;
    }

    public void setTxtDays26(String[] txtDays26) {
        this.txtDays26 = txtDays26;
    }

    public String[] getTxtDays26() {
        return txtDays26;
    }

    public void setTxtDays27(String[] txtDays27) {
        this.txtDays27 = txtDays27;
    }

    public String[] getTxtDays27() {
        return txtDays27;
    }

    public void setTxtDays28(String[] txtDays28) {
        this.txtDays28 = txtDays28;
    }

    public String[] getTxtDays28() {
        return txtDays28;
    }

    public void setTxtDays29(String[] txtDays29) {
        this.txtDays29 = txtDays29;
    }

    public String[] getTxtDays29() {
        return txtDays29;
    }

    public void setTxtDays30(String[] txtDays30) {
        this.txtDays30 = txtDays30;
    }

    public String[] getTxtDays30() {
        return txtDays30;
    }

    public void setTxtDays31(String[] txtDays31) {
        this.txtDays31 = txtDays31;
    }

    public String[] getTxtDays31() {
        return txtDays31;
    }

    public void setScreenModeFlag(String screenModeFlag) {
        this.screenModeFlag = screenModeFlag;
    }

    public String getScreenModeFlag() {
        return screenModeFlag;
    }

    public void setYrMonth(String yrMonth) {
        this.yrMonth = yrMonth;
    }

    public String getYrMonth() {
        return yrMonth;
    }

    public void setTxtDaMinimum(String[] txtDaMinimum) {
        this.txtDaMinimum = txtDaMinimum;
    }

    public String[] getTxtDaMinimum() {
        return txtDaMinimum;
    }

    public void setHdnCheck(String[] hdnCheck) {
        this.hdnCheck = hdnCheck;
    }

    public String[] getHdnCheck() {
        return hdnCheck;
    }

    public void setLstInstrDtls(ArrayList lstInstrDtls) {
        this.lstInstrDtls = lstInstrDtls;
    }

    public ArrayList getLstInstrDtls() {
        return lstInstrDtls;
    }

    public void setLstInstrDtls1(ArrayList lstInstrDtls1) {
        this.lstInstrDtls1 = lstInstrDtls1;
    }

    public ArrayList getLstInstrDtls1() {
        return lstInstrDtls1;
    }

    public void setTxtTest(long txtTest) {
        this.txtTest = txtTest;
    }

    public long getTxtTest() {
        return txtTest;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setLstPayScaleType(String lstPayScaleType) {
        this.lstPayScaleType = lstPayScaleType;
    }

    public String getLstPayScaleType() {
        return lstPayScaleType;
    }

    public void setTxtYYMM(String txtYYMM) {
        this.txtYYMM = txtYYMM;
    }

    public String getTxtYYMM() {
        return txtYYMM;
    }

    public void setHdrGoto(String hdrGoto) {
        this.hdrGoto = hdrGoto;
    }

    public String getHdrGoto() {
        return hdrGoto;
    }

    public void setTxtDPRate(String[] txtDPRate) {
        this.txtDPRate = txtDPRate;
    }

    public String[] getTxtDPRate() {
        return txtDPRate;
    }

    public void setTxtDAType(String txtDAType) {
        this.txtDAType = txtDAType;
    }

    public String getTxtDAType() {
        return txtDAType;
    }

    public void setTxtSrlNo(String[] txtSrlNo) {
        this.txtSrlNo = txtSrlNo;
    }

    public String[] getTxtSrlNo() {
        return txtSrlNo;
    }

    public void setScreenModeDARate(String screenModeDARate) {
        this.screenModeDARate = screenModeDARate;
    }

    public String getScreenModeDARate() {
        return screenModeDARate;
    }

    public void setScreenModeCDA(String screenModeCDA) {
        this.screenModeCDA = screenModeCDA;
    }

    public String getScreenModeCDA() {
        return screenModeCDA;
    }

    public void setHeaderClick(String headerClick) {
        this.headerClick = headerClick;
    }

    public String getHeaderClick() {
        return headerClick;
    }

    public void setScreenModeID(String screenModeID) {
        this.screenModeID = screenModeID;
    }

    public String getScreenModeID() {
        return screenModeID;
    }

    public void setHeaderMode(String headerMode) {
        this.headerMode = headerMode;
    }

    public String getHeaderMode() {
        return headerMode;
    }

    public void setHeaderMode1(String headerMode1) {
        this.headerMode1 = headerMode1;
    }

    public String getHeaderMode1() {
        return headerMode1;
    }

    public void setDayModified1(String[] dayModified1) {
        this.dayModified1 = dayModified1;
    }

    public String[] getDayModified1() {
        return dayModified1;
    }

    public void setDayModified2(String[] dayModified2) {
        this.dayModified2 = dayModified2;
    }

    public String[] getDayModified2() {
        return dayModified2;
    }

    public void setDayModified3(String[] dayModified3) {
        this.dayModified3 = dayModified3;
    }

    public String[] getDayModified3() {
        return dayModified3;
    }

    public void setDayModified4(String[] dayModified4) {
        this.dayModified4 = dayModified4;
    }

    public String[] getDayModified4() {
        return dayModified4;
    }

    public void setDayModified5(String[] dayModified5) {
        this.dayModified5 = dayModified5;
    }

    public String[] getDayModified5() {
        return dayModified5;
    }

    public void setDayModified6(String[] dayModified6) {
        this.dayModified6 = dayModified6;
    }

    public String[] getDayModified6() {
        return dayModified6;
    }

    public void setDayModified7(String[] dayModified7) {
        this.dayModified7 = dayModified7;
    }

    public String[] getDayModified7() {
        return dayModified7;
    }

    public void setDayModified8(String[] dayModified8) {
        this.dayModified8 = dayModified8;
    }

    public String[] getDayModified8() {
        return dayModified8;
    }

    public void setDayModified9(String[] dayModified9) {
        this.dayModified9 = dayModified9;
    }

    public String[] getDayModified9() {
        return dayModified9;
    }

    public void setDayModified10(String[] dayModified10) {
        this.dayModified10 = dayModified10;
    }

    public String[] getDayModified10() {
        return dayModified10;
    }

    public void setDayModified11(String[] dayModified11) {
        this.dayModified11 = dayModified11;
    }

    public String[] getDayModified11() {
        return dayModified11;
    }

    public void setDayModified12(String[] dayModified12) {
        this.dayModified12 = dayModified12;
    }

    public String[] getDayModified12() {
        return dayModified12;
    }

    public void setDayModified13(String[] dayModified13) {
        this.dayModified13 = dayModified13;
    }

    public String[] getDayModified13() {
        return dayModified13;
    }

    public void setDayModified14(String[] dayModified14) {
        this.dayModified14 = dayModified14;
    }

    public String[] getDayModified14() {
        return dayModified14;
    }

    public void setDayModified15(String[] dayModified15) {
        this.dayModified15 = dayModified15;
    }

    public String[] getDayModified15() {
        return dayModified15;
    }

    public void setDayModified16(String[] dayModified16) {
        this.dayModified16 = dayModified16;
    }

    public String[] getDayModified16() {
        return dayModified16;
    }

    public void setDayModified17(String[] dayModified17) {
        this.dayModified17 = dayModified17;
    }

    public String[] getDayModified17() {
        return dayModified17;
    }

    public void setDayModified18(String[] dayModified18) {
        this.dayModified18 = dayModified18;
    }

    public String[] getDayModified18() {
        return dayModified18;
    }

    public void setDayModified19(String[] dayModified19) {
        this.dayModified19 = dayModified19;
    }

    public String[] getDayModified19() {
        return dayModified19;
    }

    public void setDayModified20(String[] dayModified20) {
        this.dayModified20 = dayModified20;
    }

    public String[] getDayModified20() {
        return dayModified20;
    }

    public void setDayModified21(String[] dayModified21) {
        this.dayModified21 = dayModified21;
    }

    public String[] getDayModified21() {
        return dayModified21;
    }

    public void setDayModified22(String[] dayModified22) {
        this.dayModified22 = dayModified22;
    }

    public String[] getDayModified22() {
        return dayModified22;
    }

    public void setDayModified23(String[] dayModified23) {
        this.dayModified23 = dayModified23;
    }

    public String[] getDayModified23() {
        return dayModified23;
    }

    public void setDayModified24(String[] dayModified24) {
        this.dayModified24 = dayModified24;
    }

    public String[] getDayModified24() {
        return dayModified24;
    }

    public void setDayModified25(String[] dayModified25) {
        this.dayModified25 = dayModified25;
    }

    public String[] getDayModified25() {
        return dayModified25;
    }

    public void setDayModified26(String[] dayModified26) {
        this.dayModified26 = dayModified26;
    }

    public String[] getDayModified26() {
        return dayModified26;
    }

    public void setDayModified27(String[] dayModified27) {
        this.dayModified27 = dayModified27;
    }

    public String[] getDayModified27() {
        return dayModified27;
    }

    public void setDayModified28(String[] dayModified28) {
        this.dayModified28 = dayModified28;
    }

    public String[] getDayModified28() {
        return dayModified28;
    }

    public void setDayModified29(String[] dayModified29) {
        this.dayModified29 = dayModified29;
    }

    public String[] getDayModified29() {
        return dayModified29;
    }

    public void setDayModified30(String[] dayModified30) {
        this.dayModified30 = dayModified30;
    }

    public String[] getDayModified30() {
        return dayModified30;
    }

    public void setDayModified31(String[] dayModified31) {
        this.dayModified31 = dayModified31;
    }

    public String[] getDayModified31() {
        return dayModified31;
    }
}
