package FCIPAY.Payroll.Labour.WEBTIER.Form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class DeptLabourInfoForm extends PayrollBaseForm {
    private String txtEmpNo;
    private String txtStaffCode;
    private String parentZone;
    private String txtEmpFirstName;
    private String txtEmpMiddleName;
    private String txtEmpLastName;
    private String txtDsgn;
    private String txtDsgnDesc;
    private String txtCateg;
    private String txtCategDesc;
    private String txtCadre;
    private String txtEmpType;
    private String txtEmpTypeId;
    private String txtPFType;
    private String txtCpfCode = "";
    private String txtOldCpfCode; // Added by dushyant on 18-May-2013
    private String txtFpsNo;
    private String txtDojFCI;
    private String txtPresentPOP;
    private String txtPresentPOPDesc;
    private String txtDOJSite;
    private String txtEmpStatus;
    private String txtDepuType = "";
    private String prefix = "";
    private String txtDivision;
    private String txtSection;
    private String txtSectionDesc;

    private String txtPayType;
    private String txtPayScaleCode;
    private String txtCurtBasic;
    private String txtPayStatus;
    private String txtPayMode;
    private String txtPayModeType;
    private String txtBankCode;
    private String txtBankDesc;
    private String txtBranchCode;
    private String txtBranchDesc;
    private String txtBankAccNo;
    private String txtPayStsChnDate = "";
    private String txtPerPay;
    private String txtPerPayHighQual;
    private String txtInrSt;
    private String txtStagInc;
    private String txtStagEffDate;
    private String txtSubsAmt;
    private String txtPanNo;
    private String txtLicFeeDEM;
    private String txtCityTypeHra;
    private String hdnStartBasic;
    private String hdnEndBasic;
    private String txtMHSTyp;
    private String txtEpsFlag;
    private String txtEpsEntDt;
    private String txtEpsSepRsn;
    private String txtEpsSepDt;
    private String txtLastIncrDt;

    private boolean selectHraFlag;
    private String hdnHraFlag;
    private boolean selectNpa;
    private String hdnNpaFlag;
    private boolean selectCant;
    private String hdnCantFlag;
    private boolean selectWash;
    private String hdnWashFlag;
    private boolean selectStationComp;
    private String hdnStationCompFlag;
    private boolean selectCCAFlag;
    private String hdnCCAFlag;
    private boolean selectPLI;
    private String hdnPLIFlag;
    private boolean selectConvFlag;
    private String hdnConvFlag;
    private boolean selectDustOpAllow;
    private String hdnDustOpAllowFlag;
    private boolean selectChEdAl;
    private String hdnChEduFlag;
    private boolean selectDepu;
    private String hdnDepuFlag;
    private boolean selectDblHraFlag;
    private String hdnDblHraFlag;
    private String txtDblHraCity;
    private boolean selectAdvIncr;
    private String hdnAdvIncrFlag;
    private String txtAdvIncrType;
    private String txtAdvIncrEffDate;
    private boolean selectSplCmpAllow;
    private String hdnSplCmpAllowFlag;
    private String txtSplCmpAllowAmt;
    private boolean selectSplPaySprt;
    private String hdnSplPaySprtFlag;
    private String txtSplPaySprtAmt;
    private boolean selectSplPayCshAllow;
    private String hdnSplPayCshAllowFlag;
    private String txtSplPayCshAllowAmt;
    private boolean selectPersPaySFN;
    private String hdnPersPaySFNFlag;
    private String txtPersPaySFNAmt;
    private boolean selectPersPayHQua;
    private String hdnPersPayHQuaFlag;
    private String txtPersPayHQuaAmt;
    private String hdnBoardFlag;
    private String txtPersPaySFNEffFrom;
    private String txtPersPaySFNEffTill;
    private String txtSplCmpAllowEffFrom;
    private String txtSplCmpAllowEffTill;


    private boolean selectSplDtyAllow;
    private String hdnSplDtyAllowFlag;
    private String txtSplDtyAllowAmt;
    private String txtSplDtyAllowEffFrom;
    private String txtSplDtyAllowEffTill;

    private String txtDOB;
    private String txtGender;
    private String txtMarStat;
    private String txtFatherNam;
    private String txtHomTwn;
    private String txtHandi;
    private String txtHandiEffDate;
    private String txtPrvPromDate;
    private String txtRetireDate;
    private String txtHRAStat;
    private String txtHRAEffDate;
    private String lstAccomType;
    private String txtLeaseAmt;

    private String txtAddId;
    private String txtPermAddL1;
    private String txtPermAddL2;
    private String txtPermCity;
    private String txtPermState;
    private String txtPermStateDesc;
    private String txtPermCountry;
    private String txtPermPin;
    private String txtTempAddL1;
    private String txtTempAddL2;
    private String txtTempCity;
    private String txtTempState;
    private String txtTempStateDesc;
    private String txtTempCountry;
    private String txtTempPin;
    private String txtLabourCode;

    private String payRevFlag; // added by devendra on 20th sept 2010
    private String txtSplDtyAllowArea; // added by devendra on 22th sept 2010
    private String screenNameForSuper; // added by devendra on 1 oct 2010
    private String txtGangId; //added by Swapnendu Dt 21 May 2012.
    private String txtGangName; //added by Swapnendu Dt 21 May 2012.

    private String txtCasteCateg;
    private String txtHandiType;
    private String txtReligion;
    private String txtExsrvcman;
    private String txtAadharNum;
    private String txtUanNum;
    private String txtFathHusflag;
    private String txtPohwEffDt;
    private String txtPohwFlag;

    public void setTxtPohwEffDt(String txtPohwEffDt) {
        this.txtPohwEffDt = txtPohwEffDt;
    }

    public String getTxtPohwEffDt() {
        return txtPohwEffDt;
    }

    public void setTxtPohwFlag(String txtPohwFlag) {
        this.txtPohwFlag = txtPohwFlag;
    }

    public String getTxtPohwFlag() {
        return txtPohwFlag;
    }

    public void setTxtMemberId(String txtMemberId) {
        this.txtMemberId = txtMemberId;
    }

    public String getTxtMemberId() {
        return txtMemberId;
    }
    private String txtCPFIntEndDt;
    private String txtMemberId;


    public DeptLabourInfoForm() {
    }

    public String getTxtFathHusflag() {
        return txtFathHusflag;
    }

    public void setTxtFathHusflag(String newTxtFathHusflag) {
        txtFathHusflag = newTxtFathHusflag;
    }


    public String getTxtUanNum() {
        return txtUanNum;
    }

    public void setTxtUanNum(String newTxtUanNum) {
        txtUanNum = newTxtUanNum;
    }

    public String getTxtAadharNum() {
        return txtAadharNum;
    }

    public void setTxtAadharNum(String newTxtAadharNum) {
        txtAadharNum = newTxtAadharNum;
    }

    public String getTxtExsrvcman() {
        return txtExsrvcman;
    }

    public void setTxtExsrvcman(String newTxtExsrvcman) {
        txtExsrvcman = newTxtExsrvcman;
    }

    public String getTxtReligion() {
        return txtReligion;
    }

    public void setTxtReligion(String newTxtReligion) {
        txtReligion = newTxtReligion;
    }


    public String getTxtHandiType() {
        return txtHandiType;
    }

    public void setTxtHandiType(String newTxtHandiType) {
        txtHandiType = newTxtHandiType;
    }

    public String getTxtCasteCateg() {
        return txtCasteCateg;
    }

    public void setTxtCasteCateg(String newTxtCasteCateg) {
        txtCasteCateg = newTxtCasteCateg;
    }
    //added by devendra on 1 oct 2010 start
    public String getScreenNameForSuper() {
        return screenNameForSuper;
    }

    public void setScreenNameForSuper(String newScreenNameForSuper) {
        screenNameForSuper = newScreenNameForSuper;
    }
    //added by devendra on 1 oct 2010 end


    //added by devendra on 22th sept 2010 start
    public String getTxtSplDtyAllowArea() {
        return txtSplDtyAllowArea;
    }

    public void setTxtSplDtyAllowArea(String newTxtSplDtyAllowArea) {
        txtSplDtyAllowArea = newTxtSplDtyAllowArea;
    }
    //added by devendra on 22th sept 2010 end
    //added by devendra on 20th sept 2010 start
    public String getPayRevFlag() {
        return payRevFlag;
    }

    public void setPayRevFlag(String newTxtPayRevFlag) {
        payRevFlag = newTxtPayRevFlag;
    }
    //added by devendra on 20th sept 2010 end

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtEmpNo(String newTxtEmpNo) {
        txtEmpNo = newTxtEmpNo;
    }

    public String getTxtStaffCode() {
        return txtStaffCode;
    }

    public void setTxtStaffCode(String newTxtStaffCode) {
        txtStaffCode = newTxtStaffCode;
    }

    public String getParentZone() {
        return parentZone;
    }

    public void setParentZone(String newParentZone) {
        parentZone = newParentZone;
    }

    public String getTxtEmpFirstName() {
        return txtEmpFirstName;
    }

    public void setTxtEmpFirstName(String newTxtEmpFirstName) {
        txtEmpFirstName = newTxtEmpFirstName;
    }

    public String getTxtEmpMiddleName() {
        return txtEmpMiddleName;
    }

    public void setTxtEmpMiddleName(String newTxtEmpMiddleName) {
        txtEmpMiddleName = newTxtEmpMiddleName;
    }

    public String getTxtEmpLastName() {
        return txtEmpLastName;
    }

    public void setTxtEmpLastName(String newTxtEmpLastName) {
        txtEmpLastName = newTxtEmpLastName;
    }

    public String getTxtCateg() {
        return txtCateg;
    }

    public void setTxtCateg(String newTxtCateg) {
        txtCateg = newTxtCateg;
    }

    public String getTxtCategDesc() {
        return txtCategDesc;
    }

    public void setTxtCategDesc(String newTxtCategDesc) {
        txtCategDesc = newTxtCategDesc;
    }

    public String getTxtCadre() {
        return txtCadre;
    }

    public void setTxtCadre(String newTxtCadre) {
        txtCadre = newTxtCadre;
    }

    public String getTxtPresentPOP() {
        return txtPresentPOP;
    }

    public void setTxtPresentPOP(String newTxtPresentPOP) {
        txtPresentPOP = newTxtPresentPOP;
    }

    public String getTxtPresentPOPDesc() {
        return txtPresentPOPDesc;
    }

    public void setTxtPresentPOPDesc(String newTxtPresentPOPDesc) {
        txtPresentPOPDesc = newTxtPresentPOPDesc;
    }

    public String getTxtCpfCode() {
        return txtCpfCode;
    }

    public void setTxtCpfCode(String newTxtCpfCode) {
        txtCpfCode = newTxtCpfCode;
    }

    public String getTxtFpsNo() {
        return txtFpsNo;
    }

    public void setTxtFpsNo(String newTxtFpsNo) {
        txtFpsNo = newTxtFpsNo;
    }

    public String getTxtDsgn() {
        return txtDsgn;
    }

    public void setTxtDsgn(String newTxtDsgn) {
        txtDsgn = newTxtDsgn;
    }

    public String getTxtDsgnDesc() {
        return txtDsgnDesc;
    }

    public void setTxtDsgnDesc(String newTxtDsgnDesc) {
        txtDsgnDesc = newTxtDsgnDesc;
    }


    public String getTxtEmpType() {
        return txtEmpType;
    }

    public void setTxtEmpType(String newTxtEmpType) {
        txtEmpType = newTxtEmpType;
    }

    public String getTxtEmpTypeId() {
        return txtEmpTypeId;
    }

    public void setTxtEmpTypeId(String newTxtEmpTypeId) {
        txtEmpTypeId = newTxtEmpTypeId;
    }

    public String getTxtPayScaleCode() {
        return txtPayScaleCode;
    }

    public void setTxtPayScaleCode(String newTxtPayScaleCode) {
        txtPayScaleCode = newTxtPayScaleCode;
    }

    public String getTxtPayType() {
        return txtPayType;
    }

    public void setTxtPayType(String newTxtPayType) {
        txtPayType = newTxtPayType;
    }

    public String getTxtCurtBasic() {
        return txtCurtBasic;
    }

    public String getTxtLastIncrDt() {
        return txtLastIncrDt;
    }

    public void setTxtLastIncrDt(String newTxtLastIncrDt) {
        txtLastIncrDt = newTxtLastIncrDt;
    }


    public void setTxtCurtBasic(String newTxtCurtBasic) {
        txtCurtBasic = newTxtCurtBasic;
    }

    public String getTxtPerPay() {
        return txtPerPay;
    }

    public void setTxtPerPay(String newTxtPerPay) {
        txtPerPay = newTxtPerPay;
    }

    public String getTxtPerPayHighQual() {
        return txtPerPayHighQual;
    }

    public void setTxtPerPayHighQual(String newTxtPerPayHighQual) {
        txtPerPayHighQual = newTxtPerPayHighQual;
    }

    public String getTxtHandi() {
        return txtHandi;
    }

    public void setTxtHandi(String newTxtHandi) {
        txtHandi = newTxtHandi;
    }

    public String getTxtPayMode() {
        return txtPayMode;
    }

    public void setTxtPayMode(String newTxtPayMode) {
        txtPayMode = newTxtPayMode;
    }

    public String getTxtBankAccNo() {
        return txtBankAccNo;
    }

    public void setTxtBankAccNo(String newTxtBankAccNo) {
        txtBankAccNo = newTxtBankAccNo;
    }

    public String getTxtInrSt() {
        return txtInrSt;
    }

    public void setTxtInrSt(String newTxtInrSt) {
        txtInrSt = newTxtInrSt;
    }

    public String getTxtPayStatus() {
        return txtPayStatus;
    }

    public void setTxtPayStatus(String newTxtPayStatus) {
        txtPayStatus = newTxtPayStatus;
    }

    public String getTxtPayStsChnDate() {
        return txtPayStsChnDate;
    }

    public void setTxtPayStsChnDate(String newTxtPayStsChnDate) {
        txtPayStsChnDate = newTxtPayStsChnDate;
    }

    public boolean getSelectDepu() {
        return selectDepu;

    }

    public void setSelectDepu(boolean newSelectDepu) {
        selectDepu = newSelectDepu;
    }

    public boolean getSelectWash() {
        return selectWash;
    }

    public void setSelectWash(boolean newSelectWash) {
        selectWash = newSelectWash;
    }

    public boolean getSelectStationComp() {
        return selectStationComp;
    }

    public void setSelectStationComp(boolean newSelectStationComp) {
        selectStationComp = newSelectStationComp;
    }

    public boolean getSelectCant() {
        return selectCant;
    }

    public void setSelectCant(boolean newSelectCant) {
        selectCant = newSelectCant;
    }

    public boolean getSelectSplCmpAllow() {
        return selectSplCmpAllow;
    }

    public void setSelectSplCmpAllow(boolean newSelectSplCmpAllow) {
        selectSplCmpAllow = newSelectSplCmpAllow;
    }

    public boolean getSelectChEdAl() {
        return selectChEdAl;
    }

    public void setSelectChEdAl(boolean newSelectChEdAl) {
        selectChEdAl = newSelectChEdAl;
    }

    public String getTxtStagInc() {
        return txtStagInc;
    }

    public void setTxtStagInc(String newTxtStagInc) {
        txtStagInc = newTxtStagInc;
    }

    public String getTxtStagEffDate() {
        return txtStagEffDate;
    }

    public void setTxtStagEffDate(String newTxtStagEffDate) {
        txtStagEffDate = newTxtStagEffDate;
    }

    public String getHdnDepuFlag() {
        return hdnDepuFlag;
    }

    public void setHdnDepuFlag(String newHdnDepuFlag) {
        hdnDepuFlag = newHdnDepuFlag;
    }

    public String getHdnDblHraFlag() {
        return hdnDblHraFlag;
    }

    public void setHdnDblHraFlag(String newHdnDblHraFlag) {
        hdnDblHraFlag = newHdnDblHraFlag;
    }

    public String getHdnAdvIncrFlag() {
        return hdnAdvIncrFlag;
    }

    public void setHdnAdvIncrFlag(String newHdnAdvIncrFlag) {
        hdnAdvIncrFlag = newHdnAdvIncrFlag;
    }

    public String getHdnSplPaySprtFlag() {
        return hdnSplPaySprtFlag;
    }

    public void setHdnSplPaySprtFlag(String newHdnSplPaySprtFlag) {
        hdnSplPaySprtFlag = newHdnSplPaySprtFlag;
    }

    public String getHdnSplPayCshAllowFlag() {
        return hdnSplPayCshAllowFlag;
    }

    public void setHdnSplPayCshAllowFlag(String newHdnSplPayCshAllowFlag) {
        hdnSplPayCshAllowFlag = newHdnSplPayCshAllowFlag;
    }

    public String getHdnPersPaySFNFlag() {
        return hdnPersPaySFNFlag;
    }

    public void setHdnPersPaySFNFlag(String newHdnPersPaySFNFlag) {
        hdnPersPaySFNFlag = newHdnPersPaySFNFlag;
    }

    public String getHdnPersPayHQuaFlag() {
        return hdnPersPayHQuaFlag;
    }

    public void setHdnPersPayHQuaFlag(String newHdnPersPayHQuaFlag) {
        hdnPersPayHQuaFlag = newHdnPersPayHQuaFlag;
    }

    public String getHdnWashFlag() {
        return hdnWashFlag;
    }

    public void setHdnWashFlag(String newHdnWashFlag) {
        hdnWashFlag = newHdnWashFlag;
    }

    public String getHdnStationCompFlag() {
        return hdnStationCompFlag;
    }

    public void setHdnStationCompFlag(String newHdnStationCompFlag) {
        hdnStationCompFlag = newHdnStationCompFlag;
    }

    public String getHdnCantFlag() {
        return hdnCantFlag;
    }

    public void setHdnCantFlag(String newHdnCantFlag) {
        hdnCantFlag = newHdnCantFlag;
    }

    public String getHdnSplCmpAllowFlag() {
        return hdnSplCmpAllowFlag;
    }

    public void setHdnSplCmpAllowFlag(String newHdnSplCmpAllowFlag) {
        hdnSplCmpAllowFlag = newHdnSplCmpAllowFlag;
    }

    public String getHdnChEduFlag() {
        return hdnChEduFlag;
    }

    public void setHdnChEduFlag(String newHdnChEduFlag) {
        hdnChEduFlag = newHdnChEduFlag;
    }

    public String getTxtPFType() {
        return txtPFType;
    }

    public void setTxtPFType(String newTxtPFType) {
        txtPFType = newTxtPFType;
    }

    public String getTxtSubsAmt() {
        return txtSubsAmt;
    }

    public void setTxtSubsAmt(String newTxtSubsAmt) {
        txtSubsAmt = newTxtSubsAmt;
    }

    public String getTxtBankCode() {
        return txtBankCode;
    }

    public void setTxtBankCode(String newTxtBankCode) {
        txtBankCode = newTxtBankCode;
    }

    public String getTxtBankDesc() {
        return txtBankDesc;
    }

    public void setTxtBankDesc(String newTxtBankDesc) {
        txtBankDesc = newTxtBankDesc;
    }

    public String getTxtBranchCode() {
        return txtBranchCode;
    }

    public void setTxtBranchCode(String newTxtBranchCode) {
        txtBranchCode = newTxtBranchCode;
    }

    public String getTxtBranchDesc() {
        return txtBranchDesc;
    }

    public void setTxtBranchDesc(String newTxtBranchDesc) {
        txtBranchDesc = newTxtBranchDesc;
    }

    public boolean isSelectCCAFlag() {
        return selectCCAFlag;
    }

    public void setSelectCCAFlag(boolean newSelectCCAFlag) {
        selectCCAFlag = newSelectCCAFlag;
    }

    public boolean isSelectPLI() {
        return selectPLI;
    }

    public void setSelectPLI(boolean newSelectPLI) {
        selectPLI = newSelectPLI;
    }

    public String getHdnCCAFlag() {
        return hdnCCAFlag;
    }

    public void setHdnCCAFlag(String newHdnCCAFlag) {
        hdnCCAFlag = newHdnCCAFlag;
    }

    public String getHdnPLIFlag() {
        return hdnPLIFlag;
    }

    public void setHdnPLIFlag(String newHdnPLIFlag) {
        hdnPLIFlag = newHdnPLIFlag;
    }

    public String getTxtPayModeType() {
        return txtPayModeType;
    }

    public void setTxtPayModeType(String newTxtPayModeType) {
        txtPayModeType = newTxtPayModeType;
    }

    public String getHdnNpaFlag() {
        return hdnNpaFlag;
    }

    public void setHdnNpaFlag(String newHdnNpaFlag) {
        hdnNpaFlag = newHdnNpaFlag;
    }

    public boolean getSelectNpa() {
        return selectNpa;
    }

    public void setSelectNpa(boolean newSelectNpa) {
        selectNpa = newSelectNpa;
    }

    public String getTxtCityTypeHra() {
        return txtCityTypeHra;
    }

    public void setTxtCityTypeHra(String newTxtCityTypeHra) {
        txtCityTypeHra = newTxtCityTypeHra;
    }

    public String getHdnStartBasic() {
        return hdnStartBasic;
    }

    public void setHdnStartBasic(String newHdnStartBasic) {
        hdnStartBasic = newHdnStartBasic;
    }

    public String getHdnEndBasic() {
        return hdnEndBasic;
    }

    public void setHdnEndBasic(String newHdnEndBasic) {
        hdnEndBasic = newHdnEndBasic;
    }

    public String getTxtMHSTyp() {
        return txtMHSTyp;
    }

    public void setTxtMHSTyp(String newTxtMHSTyp) {
        txtMHSTyp = newTxtMHSTyp;
    }

    public String getTxtEpsFlag() {
        return txtEpsFlag;
    }

    public void setTxtEpsFlag(String newTxtEpsFlag) {
        txtEpsFlag = newTxtEpsFlag;
    }

    public String getTxtEpsEntDt() {
        return txtEpsEntDt;
    }

    public void setTxtEpsEntDt(String newTxtEpsEntDt) {
        txtEpsEntDt = newTxtEpsEntDt;
    }

    public String getTxtEpsSepRsn() {
        return txtEpsSepRsn;
    }

    public void setTxtEpsSepRsn(String newTxtEpsSepRsn) {
        txtEpsSepRsn = newTxtEpsSepRsn;
    }

    public String getTxtEpsSepDt() {
        return txtEpsSepDt;
    }

    public void setTxtEpsSepDt(String newTxtEpsSepDt) {
        txtEpsSepDt = newTxtEpsSepDt;
    }

    public boolean isSelectHraFlag() {
        return selectHraFlag;
    }

    public void setSelectHraFlag(boolean newSelectHraFlag) {
        selectHraFlag = newSelectHraFlag;
    }

    public boolean isSelectDblHraFlag() {
        return selectDblHraFlag;
    }

    public void setSelectDblHraFlag(boolean newSelectDblHraFlag) {
        selectDblHraFlag = newSelectDblHraFlag;
    }

    public boolean isSelectAdvIncr() {
        return selectAdvIncr;
    }

    public void setSelectAdvIncr(boolean newSelectAdvIncr) {
        selectAdvIncr = newSelectAdvIncr;
    }

    public boolean isSelectSplPaySprt() {
        return selectSplPaySprt;
    }

    public void setSelectSplPaySprt(boolean newSelectSplPaySprt) {
        selectSplPaySprt = newSelectSplPaySprt;
    }

    public boolean isSelectSplPayCshAllow() {
        return selectSplPayCshAllow;
    }

    public void setSelectSplPayCshAllow(boolean newSelectSplPayCshAllow) {
        selectSplPayCshAllow = newSelectSplPayCshAllow;
    }

    public boolean isSelectPersPaySFN() {
        return selectPersPaySFN;
    }

    public void setSelectPersPaySFN(boolean newSelectPersPaySFN) {
        selectPersPaySFN = newSelectPersPaySFN;
    }

    public boolean isSelectPersPayHQua() {
        return selectPersPayHQua;
    }

    public void setSelectPersPayHQua(boolean newSelectPersPayHQua) {
        selectPersPayHQua = newSelectPersPayHQua;
    }


    public String getHdnHraFlag() {
        return hdnHraFlag;
    }

    public void setHdnHraFlag(String newHdnHraFlag) {
        hdnHraFlag = newHdnHraFlag;
    }

    public String getTxtDblHraCity() {
        return txtDblHraCity;
    }

    public void setTxtDblHraCity(String newTxtDblHraCity) {
        txtDblHraCity = newTxtDblHraCity;
    }

    public String getTxtAdvIncrType() {
        return txtAdvIncrType;
    }

    public void setTxtAdvIncrType(String newTxtAdvIncrType) {
        txtAdvIncrType = newTxtAdvIncrType;
    }

    public String getTxtAdvIncrEffDate() {
        return txtAdvIncrEffDate;
    }

    public void setTxtAdvIncrEffDate(String newTxtAdvIncrEffDate) {
        txtAdvIncrEffDate = newTxtAdvIncrEffDate;
    }

    public String getTxtSplCmpAllowAmt() {
        return txtSplCmpAllowAmt;
    }

    public void setTxtSplCmpAllowAmt(String newTxtSplCmpAllowAmt) {
        txtSplCmpAllowAmt = newTxtSplCmpAllowAmt;
    }

    public String getTxtSplPaySprtAmt() {
        return txtSplPaySprtAmt;
    }

    public void setTxtSplPaySprtAmt(String newTxtSplPaySprtAmt) {
        txtSplPaySprtAmt = newTxtSplPaySprtAmt;
    }

    public String getTxtSplPayCshAllowAmt() {
        return txtSplPayCshAllowAmt;
    }

    public void setTxtSplPayCshAllowAmt(String newTxtSplPayCshAllowAmt) {
        txtSplPayCshAllowAmt = newTxtSplPayCshAllowAmt;
    }

    public String getTxtPersPaySFNAmt() {
        return txtPersPaySFNAmt;
    }

    public void setTxtPersPaySFNAmt(String newTxtPersPaySFNAmt) {
        txtPersPaySFNAmt = newTxtPersPaySFNAmt;
    }

    public String getTxtPersPayHQuaAmt() {
        return txtPersPayHQuaAmt;
    }

    public void setTxtPersPayHQuaAmt(String newTxtPersPayHQuaAmt) {
        txtPersPayHQuaAmt = newTxtPersPayHQuaAmt;
    }

    public String getHdnBoardFlag() {
        return hdnBoardFlag;
    }

    public void setHdnBoardFlag(String newHdnBoardFlag) {
        hdnBoardFlag = newHdnBoardFlag;
    }

    public String getHdnConvFlag() {
        return hdnConvFlag;
    }

    public void setHdnConvFlag(String newHdnConvFlag) {
        hdnConvFlag = newHdnConvFlag;
    }

    public String getHdnDustOpAllowFlag() {
        return hdnDustOpAllowFlag;
    }

    public void setHdnDustOpAllowFlag(String newHdnDustOpAllowFlag) {
        hdnDustOpAllowFlag = newHdnDustOpAllowFlag;
    }

    public boolean isSelectConvFlag() {
        return selectConvFlag;
    }

    public void setSelectConvFlag(boolean newSelectConvFlag) {
        selectConvFlag = newSelectConvFlag;
    }

    public boolean isSelectDustOpAllow() {
        return selectDustOpAllow;
    }

    public void setSelectDustOpAllow(boolean newSelectDustOpAllow) {
        selectDustOpAllow = newSelectDustOpAllow;
    }

    public String getTxtLicFeeDEM() {
        return txtLicFeeDEM;
    }

    public void setTxtLicFeeDEM(String newTxtLicFeeDEM) {
        txtLicFeeDEM = newTxtLicFeeDEM;
    }

    public String getLstAccomType() {
        return lstAccomType;
    }

    public void setLstAccomType(String newLstAccomType) {
        lstAccomType = newLstAccomType;
    }

    public String getTxtLeaseAmt() {
        return txtLeaseAmt;
    }

    public void setTxtLeaseAmt(String newTxtLeaseAmt) {
        txtLeaseAmt = newTxtLeaseAmt;
    }

    public String getTxtDojFCI() {
        return txtDojFCI;
    }

    public void setTxtDojFCI(String newTxtDojFCI) {
        txtDojFCI = newTxtDojFCI;
    }

    public String getTxtDOB() {
        return txtDOB;
    }

    public void setTxtDOB(String newTxtDOB) {
        txtDOB = newTxtDOB;
    }

    public String getTxtGender() {
        return txtGender;
    }

    public void setTxtGender(String newTxtGender) {
        txtGender = newTxtGender;
    }

    public String getTxtMarStat() {
        return txtMarStat;
    }

    public void setTxtMarStat(String newTxtMarStat) {
        txtMarStat = newTxtMarStat;
    }

    public String getTxtFatherNam() {
        return txtFatherNam;
    }

    public void setTxtFatherNam(String newTxtFatherNam) {
        txtFatherNam = newTxtFatherNam;
    }

    public String getTxtHomTwn() {
        return txtHomTwn;
    }

    public void setTxtHomTwn(String newTxtHomTwn) {
        txtHomTwn = newTxtHomTwn;
    }

    public String getTxtHandiEffDate() {
        return txtHandiEffDate;
    }

    public void setTxtHandiEffDate(String newTxtHandiEffDate) {
        txtHandiEffDate = newTxtHandiEffDate;
    }

    public String getTxtPrvPromDate() {
        return txtPrvPromDate;
    }

    public void setTxtPrvPromDate(String newTxtPrvPromDate) {
        txtPrvPromDate = newTxtPrvPromDate;
    }

    public String getTxtHRAStat() {
        return txtHRAStat;
    }

    public void setTxtHRAStat(String newTxtHRAStat) {
        txtHRAStat = newTxtHRAStat;
    }

    public String getTxtHRAEffDate() {
        return txtHRAEffDate;
    }

    public void setTxtHRAEffDate(String newTxtHRAEffDate) {
        txtHRAEffDate = newTxtHRAEffDate;
    }


    public String getTxtRetireDate() {
        return txtRetireDate;
    }

    public void setTxtRetireDate(String newTxtRetireDate) {
        txtRetireDate = newTxtRetireDate;
    }

    public String getTxtEmpStatus() {
        return txtEmpStatus;
    }

    public void setTxtEmpStatus(String newTxtEmpStatus) {
        txtEmpStatus = newTxtEmpStatus;
    }

    public String getTxtDepuType() {
        return txtDepuType;
    }

    public void setTxtDepuType(String newTxtDepuType) {
        txtDepuType = newTxtDepuType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String newPrefix) {
        prefix = newPrefix;
    }

    public String getTxtDivision() {
        return txtDivision;
    }

    public void setTxtDivision(String newTxtDivision) {
        txtDivision = newTxtDivision;
    }

    public String getTxtSection() {
        return txtSection;
    }

    public void setTxtSection(String newTxtSection) {
        txtSection = newTxtSection;
    }

    public String getTxtSectionDesc() {
        return txtSectionDesc;
    }

    public void setTxtSectionDesc(String newTxtSectionDesc) {
        txtSectionDesc = newTxtSectionDesc;
    }

    public String getTxtDOJSite() {
        return txtDOJSite;
    }

    public void setTxtDOJSite(String newTxtDOJSite) {
        txtDOJSite = newTxtDOJSite;
    }

    public String getTxtPanNo() {
        return txtPanNo;
    }

    public void setTxtPanNo(String newTxtPanNo) {
        txtPanNo = newTxtPanNo;
    }

    public String getTxtAddId() {
        return txtAddId;
    }

    public void setTxtAddId(String newTxtAddId) {
        txtAddId = newTxtAddId;
    }

    /* public String getTxtAddType()
  {
    return txtAddType;
  }

  public void setTxtAddType(String newTxtAddType)
  {
    txtAddType = newTxtAddType;
  }

  public String getTxtAddL1()
  {
    return txtAddL1;
  }

  public void setTxtAddL1(String newTxtAddL1)
  {
    txtAddL1 = newTxtAddL1;
  }

  public String getTxtAddL2()
  {
    return txtAddL2;
  }

  public void setTxtAddL2(String newTxtAddL2)
  {
    txtAddL2 = newTxtAddL2;
  }

  public String getTxtCity()
  {
    return txtCity;
  }

  public void setTxtCity(String newTxtCity)
  {
    txtCity = newTxtCity;
  }

  public String getTxtState()
  {
    return txtState;
  }

  public void setTxtState(String newTxtState)
  {
    txtState = newTxtState;
  }

  public String getTxtCountry()
  {
    return txtCountry;
  }

  public void setTxtCountry(String newTxtCountry)
  {
    txtCountry = newTxtCountry;
  }

  public String getTxtPin()
  {
    return txtPin;
  }

  public void setTxtPin(String newTxtPin)
  {
    txtPin = newTxtPin;
  }*/

    public String getTxtPermAddL1() {
        return txtPermAddL1;
    }

    public void setTxtPermAddL1(String newTxtPermAddL1) {
        txtPermAddL1 = newTxtPermAddL1;
    }

    public String getTxtPermAddL2() {
        return txtPermAddL2;
    }

    public void setTxtPermAddL2(String newTxtPermAddL2) {
        txtPermAddL2 = newTxtPermAddL2;
    }

    public String getTxtPermCity() {
        return txtPermCity;
    }

    public void setTxtPermCity(String newTxtPermCity) {
        txtPermCity = newTxtPermCity;
    }

    public String getTxtPermState() {
        return txtPermState;
    }

    public void setTxtPermState(String newTxtPermState) {
        txtPermState = newTxtPermState;
    }

    public String getTxtPermStateDesc() {
        return txtPermStateDesc;
    }

    public void setTxtPermStateDesc(String newTxtPermStateDesc) {
        txtPermStateDesc = newTxtPermStateDesc;
    }

    public String getTxtPermCountry() {
        return txtPermCountry;
    }

    public void setTxtPermCountry(String newTxtPermCountry) {
        txtPermCountry = newTxtPermCountry;
    }

    public String getTxtPermPin() {
        return txtPermPin;
    }

    public void setTxtPermPin(String newTxtPermPin) {
        txtPermPin = newTxtPermPin;
    }

    public String getTxtTempAddL1() {
        return txtTempAddL1;
    }

    public void setTxtTempAddL1(String newTxtTempAddL1) {
        txtTempAddL1 = newTxtTempAddL1;
    }

    public String getTxtTempAddL2() {
        return txtTempAddL2;
    }

    public void setTxtTempAddL2(String newTxtTempAddL2) {
        txtTempAddL2 = newTxtTempAddL2;
    }

    public String getTxtTempCity() {
        return txtTempCity;
    }

    public void setTxtTempCity(String newTxtTempCity) {
        txtTempCity = newTxtTempCity;
    }

    public String getTxtTempState() {
        return txtTempState;
    }

    public void setTxtTempState(String newTxtTempState) {
        txtTempState = newTxtTempState;
    }

    public String getTxtTempStateDesc() {
        return txtTempStateDesc;
    }

    public void setTxtTempStateDesc(String newTxtTempStateDesc) {
        txtTempStateDesc = newTxtTempStateDesc;
    }

    public String getTxtTempCountry() {
        return txtTempCountry;
    }

    public void setTxtTempCountry(String newTxtTempCountry) {
        txtTempCountry = newTxtTempCountry;
    }

    public String getTxtTempPin() {
        return txtTempPin;
    }

    public void setTxtTempPin(String newTxtTempPin) {
        txtTempPin = newTxtTempPin;
    }

    public String getTxtPersPaySFNEffFrom() {
        return txtPersPaySFNEffFrom;
    }

    public void setTxtPersPaySFNEffFrom(String newTxtPersPaySFNEffFrom) {
        txtPersPaySFNEffFrom = newTxtPersPaySFNEffFrom;
    }

    public String getTxtPersPaySFNEffTill() {
        return txtPersPaySFNEffTill;
    }

    public void setTxtPersPaySFNEffTill(String newTxtPersPaySFNEffTill) {
        txtPersPaySFNEffTill = newTxtPersPaySFNEffTill;
    }

    public String getTxtSplCmpAllowEffFrom() {
        return txtSplCmpAllowEffFrom;
    }

    public void setTxtSplCmpAllowEffFrom(String newTxtSplCmpAllowEffFrom) {
        txtSplCmpAllowEffFrom = newTxtSplCmpAllowEffFrom;
    }

    public String getTxtSplCmpAllowEffTill() {
        return txtSplCmpAllowEffTill;
    }

    public void setTxtSplCmpAllowEffTill(String newTxtSplCmpAllowEffTill) {
        txtSplCmpAllowEffTill = newTxtSplCmpAllowEffTill;
    }

    public boolean getSelectSplDtyAllow() {
        return selectSplDtyAllow;
    }

    public void setSelectSplDtyAllow(boolean newSelectSplDtyAllow) {
        selectSplDtyAllow = newSelectSplDtyAllow;
    }

    public String getTxtSplDtyAllowEffFrom() {
        return txtSplDtyAllowEffFrom;
    }

    public void setTxtSplDtyAllowEffFrom(String newTxtSplDtyAllowEffFrom) {
        txtSplDtyAllowEffFrom = newTxtSplDtyAllowEffFrom;
    }

    public String getTxtSplDtyAllowEffTill() {
        return txtSplDtyAllowEffTill;
    }

    public void setTxtSplDtyAllowEffTill(String newTxtSplDtyAllowEffTill) {
        txtSplDtyAllowEffTill = newTxtSplDtyAllowEffTill;
    }

    public String getHdnSplDtyAllowFlag() {
        return hdnSplDtyAllowFlag;
    }

    public void setHdnSplDtyAllowFlag(String newHdnSplDtyAllowFlag) {
        hdnSplDtyAllowFlag = newHdnSplDtyAllowFlag;
    }

    public String getTxtSplDtyAllowAmt() {
        return txtSplDtyAllowAmt;
    }

    public void setTxtSplDtyAllowAmt(String newTxtSplDtyAllowAmt) {
        txtSplDtyAllowAmt = newTxtSplDtyAllowAmt;
    }

    public String getTxtLabourCode() {
        return txtLabourCode;
    }

    public void setTxtLabourCode(String newTxtLabourCode) {
        txtLabourCode = newTxtLabourCode;
    }

    public String getTxtGangId() {
        return txtGangId;
    }

    public void setTxtGangId(String newTxtGangId) {
        txtGangId = newTxtGangId;
    }

    public String getTxtGangName() {
        return txtGangName;
    }

    public void setTxtGangName(String newTxtGangName) {
        txtGangName = newTxtGangName;
    }

    public String getTxtOldCpfCode() {
        return txtOldCpfCode;
    }

    public void setTxtOldCpfCode(String newTxtOldCpfCode) {
        txtOldCpfCode = newTxtOldCpfCode;
    }

    public void setTxtCPFIntEndDt(String txtCPFIntEndDt) {
        this.txtCPFIntEndDt = txtCPFIntEndDt;
    }

    public String getTxtCPFIntEndDt() {
        return txtCPFIntEndDt;
    }
}


