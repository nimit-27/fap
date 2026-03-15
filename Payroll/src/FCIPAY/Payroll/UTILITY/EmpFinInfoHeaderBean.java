package FCIPAY.Payroll.UTILITY;

import java.io.Serializable;

import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class EmpFinInfoHeaderBean extends PayrollBaseHeaderBean implements Serializable {
    private String txtEmpNo;
    private String txtStaffCode;
    private String parentZone;
    private String txtEmpName;
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
    //private String txtStagInc; commented by devendra on 20th aug 2010
    private String txtStagInc = ""; //added by devendra on 20th aug 2010
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
    private String txtDblHraEffFrom;
    private String txtDblHraEffTill;
    private boolean selectAdvIncr;
    private String hdnAdvIncrFlag;
    private String txtAdvIncrType;
    private String txtAdvIncrEffDate;
    private boolean selectSplCmpAllow;
    private String hdnSplCmpAllowFlag;
    private String txtSplCmpAllowAmt;
    private String txtSplCmpAllowEffFrom;
    private String txtSplCmpAllowEffTill;
    private boolean selectSplPaySprt;
    private String hdnSplPaySprtFlag;
    private String txtSplPaySprtAmt;
    private String txtSplPaySprtEffFrom;
    private String txtSplPaySprtEffTill;
    private boolean selectSplPayCshAllow;
    private String hdnSplPayCshAllowFlag;
    private String txtSplPayCshAllowAmt;
    private String txtSplPayCshAllowEffFrom;
    private String txtSplPayCshAllowEffTill;
    private boolean selectPersPaySFN;
    private String hdnPersPaySFNFlag;
    private String txtPersPaySFNAmt;
    private String txtPersPaySFNEffFrom;
    private String txtPersPaySFNEffTill;
    private boolean selectPersPayHQua;
    private String hdnPersPayHQuaFlag;
    private String txtPersPayHQuaAmt;
    private String txtPersPayHQuaEffFrom;
    private String txtPersPayHQuaEffTill;
    private boolean selectPersPayHndQua;
    private String hdnPersPayHndQuaFlag;
    private String txtPersPayHndQuaAmt;
    private String txtPersPayHndQuaNoIncr;
    private String txtPersPayHndQuaEffFrom;
    private String txtPersPayHndQuaEffTill;
    private String hdnBoardFlag;

    private boolean selectSplDtyAllow;
    private String hdnSplDtyAllowFlag;
    private String txtSplDtyAllowEffFrom;
    private String txtSplDtyAllowEffTill;
    private String txtSplDtyAllowArea;

    private boolean selectOpAllowFlag;
    private String hdnOpAllowFlag;

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
    private String txtHRAEndDate;
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

    private String screenFlag;
    private String txtGradePay;
    private String resetFlag;
    private String tmpCpfFlg;
    // added by devendra start
    private String tmpGradePay;
    private String tmpPayScaleCode;
    // added by devendra end

    //added by devendra start
    private String hdnTmpPayScaleCode;
    private String hdnTmpGradePay;
    private String payRevFlag;
    //added by devendra end
    // added by Neeraj on  27 Dec 2010 starts here//
    private String txtCreationDate; //added by neeraj
    private String txtCreatedBy; //added by neeraj
    private String txtCreatedSite; //added by neeraj
    private String txtUpdationDate; //added by neeraj
    private String txtUpdatedBy; //added by neeraj
    private String txtUpdatedSite; //added by neeraj
    //added by Neeraj on 27 Dec 2010 ends here
    private String txtCpfapproval; //added by Dushyant on 28-may-2013
    private String txtMhsAmt; //added by Avtar on 20 Mar 2013 ends here
    private String selectCarAvail; // added by gagan under CR-283 on 18-06-2013
    private String txtCasual;
    private String txtCasteCateg;
    private String txtHandiType;
    private String txtReligion;
    private String txtExsrvcman;
    private String txtAadharNum;
    private String txtUanNum;
    private String txtPenNum;
    private String txtFathHusflag;

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
    private String txtPohwEffDt;
    private String txtPohwFlag;

    public void setTxtMemberId(String txtMemberId) {
        this.txtMemberId = txtMemberId;
    }

    public String getTxtMemberId() {
        return txtMemberId;
    }
    private String txtPenFlag;
    private String txtCPFIntEndDt;
    private String txtNpsFlag;
    private String txtPranNo;
    private String txtMemberId;


    public void setTxtNpsFlag(String txtNpsFlag) {
        this.txtNpsFlag = txtNpsFlag;
    }

    public String getTxtNpsFlag() {
        return txtNpsFlag;
    }

    public void setTxtPranNo(String txtPranNo) {
        this.txtPranNo = txtPranNo;
    }

    public String getTxtPranNo() {
        return txtPranNo;
    }


    public EmpFinInfoHeaderBean() {
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

    public String getSelectCarAvail() {
        return selectCarAvail;
    }

    public void setSelectCarAvail(String newSelectCarAvail) {
        selectCarAvail = newSelectCarAvail;
    }

    public String getTxtCreationDate() {
        return txtCreationDate;
    }

    public void setTxtCreationDate(String sTxtCreationDate) {
        txtCreationDate = sTxtCreationDate;
    }

    public String getTxtCreatedBy() {
        return txtCreatedBy;
    }

    public void setTxtCreatedBy(String sTxtCreatedBy) {
        txtCreatedBy = sTxtCreatedBy;
    }

    public String getTxtCreatedSite() {
        return txtCreatedSite;
    }

    public void setTxtCreatedSite(String sTxtCreatedSite) {
        txtCreatedSite = sTxtCreatedSite;
    }

    public String getTxtUpdationDate() {
        return txtUpdationDate;
    }

    public void setTxtUpdationDate(String sTxtUpdationDate) {
        txtUpdationDate = sTxtUpdationDate;
    }

    public String getTxtUpdatedBy() {
        return txtUpdatedBy;
    }

    public void setTxtUpdatedBy(String sTxtUpdatedBy) {
        txtUpdatedBy = sTxtUpdatedBy;
    }

    public String getTxtUpdatedSite() {
        return txtUpdatedSite;
    }

    public void setTxtUpdatedSite(String sTxtUpdatedSite) {
        txtUpdatedSite = sTxtUpdatedSite;
    }

    // added by Neeraj Ends here//


    // added by devendra start

    public String getPayRevFlag() {
        return payRevFlag;
    }

    public void setPayRevFlag(String sPayRevFlag) {
        payRevFlag = sPayRevFlag;
    }

    public String getTmpGradePay() {
        return tmpGradePay;
    }

    public void setTmpGradePay(String sTmpGradePay) {
        tmpGradePay = sTmpGradePay;
    }

    public String getTmpPayScaleCode() {
        return tmpPayScaleCode;
    }

    public void setTmpPayScaleCode(String sTmpPayScaleCode) {
        tmpPayScaleCode = sTmpPayScaleCode;
    }
    //added by devendra end

    //added by devendra start
    public String getHdnTmpPayScaleCode() {
        return hdnTmpPayScaleCode;
    }

    public void setHdnTmpPayScaleCode(String sHdnTmpPayScaleCode) {
        hdnTmpPayScaleCode = sHdnTmpPayScaleCode;
    }

    public String getHdnTmpGradePay() {
        return hdnTmpGradePay;
    }

    public void setHdnTmpGradePay(String sHdnTmpGradePay) {
        hdnTmpGradePay = sHdnTmpGradePay;
    }
    //added by devendra end

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

    public String getTxtEmpName() {
        return txtEmpName;
    }

    public void setTxtEmpName(String newTxtEmpName) {
        txtEmpName = newTxtEmpName;
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

    public String getHdnBoardFlag() {
        return hdnBoardFlag;
    }

    public void setHdnBoardFlag(String newHdnBoardFlag) {
        hdnBoardFlag = newHdnBoardFlag;
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

    public boolean getSelectHraFlag() {
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

    public String getTxtHRAEndDate() {
        return txtHRAEndDate;
    }

    public void setTxtHRAEndDate(String newTxtHRAEndDate) {
        txtHRAEndDate = newTxtHRAEndDate;
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

    public String getHdnOpAllowFlag() {
        return hdnOpAllowFlag;
    }

    public void setHdnOpAllowFlag(String newHdnOpAllowFlag) {
        hdnOpAllowFlag = newHdnOpAllowFlag;
    }

    public boolean isSelectOpAllowFlag() {
        return selectOpAllowFlag;
    }

    public void setSelectOpAllowFlag(boolean newSelectOpAllowFlag) {
        selectOpAllowFlag = newSelectOpAllowFlag;
    }

    public String getTxtDblHraEffFrom() {
        return txtDblHraEffFrom;
    }

    public void setTxtDblHraEffFrom(String newTxtDblHraEffFrom) {
        txtDblHraEffFrom = newTxtDblHraEffFrom;
    }

    public String getTxtDblHraEffTill() {
        return txtDblHraEffTill;
    }

    public void setTxtDblHraEffTill(String newTxtDblHraEffTill) {
        txtDblHraEffTill = newTxtDblHraEffTill;
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

    public String getTxtSplPaySprtEffFrom() {
        return txtSplPaySprtEffFrom;
    }

    public void setTxtSplPaySprtEffFrom(String newTxtSplPaySprtEffFrom) {
        txtSplPaySprtEffFrom = newTxtSplPaySprtEffFrom;
    }

    public String getTxtSplPaySprtEffTill() {
        return txtSplPaySprtEffTill;
    }

    public void setTxtSplPaySprtEffTill(String newTxtSplPaySprtEffTill) {
        txtSplPaySprtEffTill = newTxtSplPaySprtEffTill;
    }

    public String getTxtSplPayCshAllowEffFrom() {
        return txtSplPayCshAllowEffFrom;
    }

    public void setTxtSplPayCshAllowEffFrom(String newTxtSplPayCshAllowEffFrom) {
        txtSplPayCshAllowEffFrom = newTxtSplPayCshAllowEffFrom;
    }

    public String getTxtSplPayCshAllowEffTill() {
        return txtSplPayCshAllowEffTill;
    }

    public void setTxtSplPayCshAllowEffTill(String newTxtSplPayCshAllowEffTill) {
        txtSplPayCshAllowEffTill = newTxtSplPayCshAllowEffTill;
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

    public String getTxtPersPayHQuaEffFrom() {
        return txtPersPayHQuaEffFrom;
    }

    public void setTxtPersPayHQuaEffFrom(String newTxtPersPayHQuaEffFrom) {
        txtPersPayHQuaEffFrom = newTxtPersPayHQuaEffFrom;
    }

    public String getTxtPersPayHQuaEffTill() {
        return txtPersPayHQuaEffTill;
    }

    public void setTxtPersPayHQuaEffTill(String newTxtPersPayHQuaEffTill) {
        txtPersPayHQuaEffTill = newTxtPersPayHQuaEffTill;
    }

    public String getTxtPersPayHndQuaEffFrom() {
        return txtPersPayHndQuaEffFrom;
    }

    public void setTxtPersPayHndQuaEffFrom(String newTxtPersPayHndQuaEffFrom) {
        txtPersPayHndQuaEffFrom = newTxtPersPayHndQuaEffFrom;
    }

    public String getTxtPersPayHndQuaEffTill() {
        return txtPersPayHndQuaEffTill;
    }

    public void setTxtPersPayHndQuaEffTill(String newTxtPersPayHndQuaEffTill) {
        txtPersPayHndQuaEffTill = newTxtPersPayHndQuaEffTill;
    }

    public String getTxtPersPayHndQuaAmt() {
        return txtPersPayHndQuaAmt;
    }

    public void setTxtPersPayHndQuaAmt(String newTxtPersPayHndQuaAmt) {
        txtPersPayHndQuaAmt = newTxtPersPayHndQuaAmt;
    }

    public String getTxtPersPayHndQuaNoIncr() {
        return txtPersPayHndQuaNoIncr;
    }

    public void setTxtPersPayHndQuaNoIncr(String newTxtPersPayHndQuaNoIncr) {
        txtPersPayHndQuaNoIncr = newTxtPersPayHndQuaNoIncr;
    }

    public String getHdnPersPayHndQuaFlag() {
        return hdnPersPayHndQuaFlag;
    }

    public void setHdnPersPayHndQuaFlag(String newHdnPersPayHndQuaFlag) {
        hdnPersPayHndQuaFlag = newHdnPersPayHndQuaFlag;
    }

    public boolean isSelectPersPayHndQua() {
        return selectPersPayHndQua;
    }

    public void setSelectPersPayHndQua(boolean newSelectPersPayHndQua) {
        selectPersPayHndQua = newSelectPersPayHndQua;
    }

    public String getScreenFlag() {
        return screenFlag;
    }

    public void setScreenFlag(String newScreenFlag) {
        screenFlag = newScreenFlag;
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

    public String getTxtGradePay() {
        return txtGradePay;
    }

    public void setTxtGradePay(String newTxtGradePay) {
        txtGradePay = newTxtGradePay;
    }

    public String getTxtSplDtyAllowArea() {
        return txtSplDtyAllowArea;
    }

    public void setTxtSplDtyAllowArea(String newTxtSplDtyAllowArea) {
        txtSplDtyAllowArea = newTxtSplDtyAllowArea;
    }

    public String getResetFlag() {
        return resetFlag;
    }

    public void setResetFlag(String newResetFlag) {
        resetFlag = newResetFlag;
    }

    public String getTmpCpfFlg() {
        return tmpCpfFlg;
    }

    public void setTmpCpfFlg(String newTmpCpfFlg) {
        tmpCpfFlg = newTmpCpfFlg;
    }
    //added by Avtar on 20 Mar 2013
    public String getTxtMhsAmt() {
        return txtMhsAmt;
    }

    public void setTxtMhsAmt(String newTxtMhsAmt) {
        txtMhsAmt = newTxtMhsAmt;
    }
    //ended by Avtar on 20 Mar 2013
    // Added by dushyant on 20-May-2013
    public String getTxtOldCpfCode() {
        return txtOldCpfCode;
    }

    public void setTxtOldCpfCode(String newTxtOldCpfCode) {
        txtOldCpfCode = newTxtOldCpfCode;
    }
    // END by dushyant on 20-May-2013
    // Added by dushyant on 28-May-2013
    public String getTxtCpfapproval() {
        return txtCpfapproval;
    }

    public void setTxtCpfapproval(String newTxtCpfapproval) {
        txtCpfapproval = newTxtCpfapproval;
    }
    // END by dushyant on 28-May-2013
    public String getTxtCasual() {
        return txtCasual;
    }

    public void setTxtCasual(String newTxtCasual) {
        txtCasual = newTxtCasual;
    }

    public void setTxtPenFlag(String txtPenFlag) {
        this.txtPenFlag = txtPenFlag;
    }

    public String getTxtPenFlag() {
        return txtPenFlag;
    }


    public void setTxtPenNum(String txtPenNum) {
        this.txtPenNum = txtPenNum;
    }

    public String getTxtPenNum() {
        return txtPenNum;
    }

    public void setTxtCPFIntEndDt(String txtCPFIntEndDt) {
        this.txtCPFIntEndDt = txtCPFIntEndDt;
    }

    public String getTxtCPFIntEndDt() {
        return txtCPFIntEndDt;
    }
}
