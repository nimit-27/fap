package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class MaintPCDetailHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
    private String txtEmpNo;
    private String txtEmpName;
    private String txtPensionId;
    private String hdrGoto;
    private String txtFromYear;
    private String txtPFAcctNo;
    private String txtToYear;
    private String txtEmpOpnConPc;
    private String txtEmpCloConPc;
    private String txtEmpIntQ1;
    private String txtEmpIntQ2;
    private String txtEmpIntQ3;
    private String txtEmpIntQ4;
    private String txtEmpIntAnn;
    private String txtEmprOpnConPc;
    private String txtEmprCloConPc;
    private String txtEmprIntQ1;
    private String txtEmprIntQ2;
    private String txtEmprIntQ3;
    private String txtEmprIntQ4;
    private String txtEmprIntAnn;
    private String txtVolOpnPc;
    private String txtVolCloPc;
    private String txtVolInPCQ1;
    private String txtVolInPCQ2;
    private String txtVolInPCQ3;
    private String txtVolInPCQ4;
    private String txtVolInPCQAnn;
    private String txtQuarterDtl;
    /*private String txtEmpInSub;
    private String txtEmprInCon;
    private String txtEmpInSubDate;
    private String txtEmprInConDate;
    private String txtVolInPFDate;
    private String txtEmpOutSub;
    private String txtEmprOutCon;
    private String txtEmpOutSubDate;
    private String txtEmprOutConDate;
    private String txtVolOutPFDate;
    private String txtPfType; */
   /* private String txtVolInPf;
    private String txtVolOutPf;*/
    /*private String userBtn;
    private String histBtn;*/
    private String txtAdjTypeHdr;
    private String txtAdjTypeDtl;
    private String txtAdjAmtHdr;
    private String txtAdjAmtDtl;
    private String txtPayMode;
    private String txtRmrkHdr;
    private String txtPayModeDtl;
    private String txtRmrkDtl;
    private String txtYYMMDtl;
    private String txtCpfCode;
    private String txtQuarterHdr;
    private String txtYr;
    private String txtQuarter;

    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public String getTxtEmpName() {
        return txtEmpName;
    }

    public void setTxtPensionId(String txtPensionId) {
        this.txtPensionId = txtPensionId;
    }

    public String getTxtPensionId() {
        return txtPensionId;
    }

    public void setHdrGoto(String hdrGoto) {
        this.hdrGoto = hdrGoto;
    }

    public String getHdrGoto() {
        return hdrGoto;
    }

    public void setTxtFromYear(String txtFromYear) {
        this.txtFromYear = txtFromYear;
    }

    public String getTxtFromYear() {
        return txtFromYear;
    }

    public void setTxtPFAcctNo(String txtPFAcctNo) {
        this.txtPFAcctNo = txtPFAcctNo;
    }

    public String getTxtPFAcctNo() {
        return txtPFAcctNo;
    }

    public void setTxtToYear(String txtToYear) {
        this.txtToYear = txtToYear;
    }

    public String getTxtToYear() {
        return txtToYear;
    }

    public void setTxtEmpOpnConPc(String txtEmpOpnConPc) {
        this.txtEmpOpnConPc = txtEmpOpnConPc;
    }

    public String getTxtEmpOpnConPc() {
        return txtEmpOpnConPc;
    }

    public void setTxtEmpCloConPc(String txtEmpCloConPc) {
        this.txtEmpCloConPc = txtEmpCloConPc;
    }

    public String getTxtEmpCloConPc() {
        return txtEmpCloConPc;
    }

    public void setTxtEmpIntQ1(String txtEmpIntQ1) {
        this.txtEmpIntQ1 = txtEmpIntQ1;
    }

    public String getTxtEmpIntQ1() {
        return txtEmpIntQ1;
    }

    public void setTxtEmpIntQ2(String txtEmpIntQ2) {
        this.txtEmpIntQ2 = txtEmpIntQ2;
    }

    public String getTxtEmpIntQ2() {
        return txtEmpIntQ2;
    }

    public void setTxtEmpIntQ3(String txtEmpIntQ3) {
        this.txtEmpIntQ3 = txtEmpIntQ3;
    }

    public String getTxtEmpIntQ3() {
        return txtEmpIntQ3;
    }

    public void setTxtEmpIntQ4(String txtEmpIntQ4) {
        this.txtEmpIntQ4 = txtEmpIntQ4;
    }

    public String getTxtEmpIntQ4() {
        return txtEmpIntQ4;
    }

    public void setTxtEmpIntAnn(String txtEmpIntAnn) {
        this.txtEmpIntAnn = txtEmpIntAnn;
    }

    public String getTxtEmpIntAnn() {
        return txtEmpIntAnn;
    }

    public void setTxtEmprOpnConPc(String txtEmprOpnConPc) {
        this.txtEmprOpnConPc = txtEmprOpnConPc;
    }

    public String getTxtEmprOpnConPc() {
        return txtEmprOpnConPc;
    }

    public void setTxtEmprCloConPc(String txtEmprCloConPc) {
        this.txtEmprCloConPc = txtEmprCloConPc;
    }

    public String getTxtEmprCloConPc() {
        return txtEmprCloConPc;
    }

    public void setTxtEmprIntQ1(String txtEmprIntQ1) {
        this.txtEmprIntQ1 = txtEmprIntQ1;
    }

    public String getTxtEmprIntQ1() {
        return txtEmprIntQ1;
    }

    public void setTxtEmprIntQ2(String txtEmprIntQ2) {
        this.txtEmprIntQ2 = txtEmprIntQ2;
    }

    public String getTxtEmprIntQ2() {
        return txtEmprIntQ2;
    }

    public void setTxtEmprIntQ3(String txtEmprIntQ3) {
        this.txtEmprIntQ3 = txtEmprIntQ3;
    }

    public String getTxtEmprIntQ3() {
        return txtEmprIntQ3;
    }

    public void setTxtEmprIntQ4(String txtEmprIntQ4) {
        this.txtEmprIntQ4 = txtEmprIntQ4;
    }

    public String getTxtEmprIntQ4() {
        return txtEmprIntQ4;
    }

    public void setTxtEmprIntAnn(String txtEmprIntAnn) {
        this.txtEmprIntAnn = txtEmprIntAnn;
    }

    public String getTxtEmprIntAnn() {
        return txtEmprIntAnn;
    }

    public void setTxtVolOpnPc(String txtVolOpnPc) {
        this.txtVolOpnPc = txtVolOpnPc;
    }

    public String getTxtVolOpnPc() {
        return txtVolOpnPc;
    }

    public void setTxtVolCloPc(String txtVolCloPc) {
        this.txtVolCloPc = txtVolCloPc;
    }

    public String getTxtVolCloPc() {
        return txtVolCloPc;
    }

    public void setTxtVolInPCQ1(String txtVolInPCQ1) {
        this.txtVolInPCQ1 = txtVolInPCQ1;
    }

    public String getTxtVolInPCQ1() {
        return txtVolInPCQ1;
    }

    public void setTxtVolInPCQ2(String txtVolInPCQ2) {
        this.txtVolInPCQ2 = txtVolInPCQ2;
    }

    public String getTxtVolInPCQ2() {
        return txtVolInPCQ2;
    }

    public void setTxtVolInPCQ3(String txtVolInPCQ3) {
        this.txtVolInPCQ3 = txtVolInPCQ3;
    }

    public String getTxtVolInPCQ3() {
        return txtVolInPCQ3;
    }

    public void setTxtVolInPCQ4(String txtVolInPCQ4) {
        this.txtVolInPCQ4 = txtVolInPCQ4;
    }

    public String getTxtVolInPCQ4() {
        return txtVolInPCQ4;
    }

    public void setTxtVolInPCQAnn(String txtVolInPCQAnn) {
        this.txtVolInPCQAnn = txtVolInPCQAnn;
    }

    public String getTxtVolInPCQAnn() {
        return txtVolInPCQAnn;
    }

    public void setTxtQuarterDtl(String txtQuarterDtl) {
        this.txtQuarterDtl = txtQuarterDtl;
    }

    public String getTxtQuarterDtl() {
        return txtQuarterDtl;
    }
    public void setTxtAdjTypeHdr(String txtAdjTypeHdr) {
        this.txtAdjTypeHdr = txtAdjTypeHdr;
    }

    public String getTxtAdjTypeHdr() {
        return txtAdjTypeHdr;
    }

    public void setTxtAdjTypeDtl(String txtAdjTypeDtl) {
        this.txtAdjTypeDtl = txtAdjTypeDtl;
    }

    public String getTxtAdjTypeDtl() {
        return txtAdjTypeDtl;
    }

    public void setTxtAdjAmtHdr(String txtAdjAmtHdr) {
        this.txtAdjAmtHdr = txtAdjAmtHdr;
    }

    public String getTxtAdjAmtHdr() {
        return txtAdjAmtHdr;
    }

    public void setTxtAdjAmtDtl(String txtAdjAmtDtl) {
        this.txtAdjAmtDtl = txtAdjAmtDtl;
    }

    public String getTxtAdjAmtDtl() {
        return txtAdjAmtDtl;
    }

    public void setTxtPayMode(String txtPayMode) {
        this.txtPayMode = txtPayMode;
    }

    public String getTxtPayMode() {
        return txtPayMode;
    }

    public void setTxtRmrkHdr(String txtRmrkHdr) {
        this.txtRmrkHdr = txtRmrkHdr;
    }

    public String getTxtRmrkHdr() {
        return txtRmrkHdr;
    }

    public void setTxtPayModeDtl(String txtPayModeDtl) {
        this.txtPayModeDtl = txtPayModeDtl;
    }

    public String getTxtPayModeDtl() {
        return txtPayModeDtl;
    }

    public void setTxtRmrkDtl(String txtRmrkDtl) {
        this.txtRmrkDtl = txtRmrkDtl;
    }

    public String getTxtRmrkDtl() {
        return txtRmrkDtl;
    }

    public void setTxtYYMMDtl(String txtYYMMDtl) {
        this.txtYYMMDtl = txtYYMMDtl;
    }

    public String getTxtYYMMDtl() {
        return txtYYMMDtl;
    }

    public void setTxtCpfCode(String txtCpfCode) {
        this.txtCpfCode = txtCpfCode;
    }

    public String getTxtCpfCode() {
        return txtCpfCode;
    }


    public void setTxtQuarterHdr(String txtQuarterHdr) {
        this.txtQuarterHdr = txtQuarterHdr;
    }

    public String getTxtQuarterHdr() {
        return txtQuarterHdr;
    }


    public void setTxtYr(String txtYr) {
        this.txtYr = txtYr;
    }

    public String getTxtYr() {
        return txtYr;
    }

    public void setTxtQuarter(String txtQuarter) {
        this.txtQuarter = txtQuarter;
    }

    public String getTxtQuarter() {
        return txtQuarter;
    }
}
