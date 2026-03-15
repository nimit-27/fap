package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MaintPensionDetailForm extends PayrollBaseForm 
{
  private String txtSrlNo[];
  private String txtYearMon[];
  private String txtEmpSub[];
  private String txtEmpCon[];
  private String txtVolPc[];
  private String txtArrEmp[];
  private String txtArrEmpr[];
  private String txtRemDate[]; 
  private String txtNoOfDays[];
  private ArrayList lstInstrDtls = new ArrayList();
  private ArrayList adjHistHdrList = new ArrayList();
  private ArrayList adjHistDtlList = new ArrayList();
   
  private long txtTest;
  private String action = "";
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
 // private String txtEmpInSub;
 // private String txtEmprInCon;
  //private String txtEmpInSubDate;
  //private String txtEmprInConDate;
 // private String txtVolInPFDate;
 // private String txtEmpOutSub;
 // private String txtEmprOutCon;
  //private String txtEmpOutSubDate;
  //private String txtEmprOutConDate;
  //private String txtVolOutPFDate;
  //private String screenModePay1;
  //private String screenModePensionDtl;
  //private String txtPfType; 
  //private String txtVolInPf;
  //private String txtVolOutPf;
  private String userBtn;
  private String histBtn;
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
  private String txtPayModehdr;
  private String hdnAction;
  private String txtYr;
  private String txtQuarter;


   public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }


   public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstInstrDtls.clear();
        this.adjHistHdrList.clear();
        this.adjHistDtlList.clear();
        this.txtTest = 0;
   }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String[] getTxtYearMon()
  {
    return txtYearMon;
  }

  public void setTxtYearMon(String[] newTxtYearMon)
  {
    txtYearMon = newTxtYearMon;
  }

  public String[] getTxtEmpSub()
  {
    return txtEmpSub;
  }

  public void setTxtEmpSub(String[] newTxtEmpSub)
  {
    txtEmpSub = newTxtEmpSub;
  }

  public String[] getTxtEmpCon()
  {
    return txtEmpCon;
  }

  public void setTxtEmpCon(String[] newTxtEmpCon)
  {
    txtEmpCon = newTxtEmpCon;
  }

  public String[] getTxtVolPc()
  {
    return txtVolPc;
  }

  public void setTxtVolPc(String[] newTxtVolPc)
  {
    txtVolPc = newTxtVolPc;
  }


  public ArrayList getAdjHistHdrList()
  {
    return adjHistHdrList;
  }

  public void setAdjHistHdrList(ArrayList newAdjHistHdrList)
  {
    adjHistHdrList = newAdjHistHdrList;
  }

  public ArrayList getAdjHistDtlList()
  {
    return adjHistDtlList;
  }

  public void setAdjHistDtlList(ArrayList newAdjHistDtlList)
  {
    adjHistDtlList = newAdjHistDtlList;
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

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
  
  public String gettxtPensionId()
  {
    return txtPensionId;
  }

  public void setTxtPensionId(String newTxtPensionId)
  {
    txtPensionId = newTxtPensionId;
  }

  public String getHdrGoto()
  {
    return hdrGoto;
  }

  public void setHdrGoto(String newHdrGoto)
  {
    hdrGoto = newHdrGoto;
  }

  public String getTxtFromYear()
  {
    return txtFromYear;
  }

  public void setTxtFromYear(String newTxtFromYear)
  {
    txtFromYear = newTxtFromYear;
  }

  public String getTxtToYear()
  {
    return txtToYear;
  }

  public void setTxtToYear(String newTxtToYear)
  {
    txtToYear = newTxtToYear;
  }

 

 

 

    public String getTxtEmpIntQ1()
    {
      return txtEmpIntQ1;
    }

    public void setTxtEmpIntQ1(String newTxtEmpIntQ1)
    {
      txtEmpIntQ1 = newTxtEmpIntQ1;
    }
    
  public String getTxtEmpIntQ2()
  {
    return txtEmpIntQ2;
  }

  public void setTxtEmpIntQ2(String newTxtEmpIntQ2)
  {
    txtEmpIntQ2 = newTxtEmpIntQ2;
  }
  
    public String getTxtEmpIntQ3()
    {
      return txtEmpIntQ3;
    }

    public void setTxtEmpIntQ3(String newTxtEmpIntQ3)
    {
      txtEmpIntQ3 = newTxtEmpIntQ3;
    }
    
    public String getTxtEmpIntQ4()
    {
      return txtEmpIntQ4;
    }

    public void setTxtEmpIntQ4(String newTxtEmpIntQ4)
    {
      txtEmpIntQ4 = newTxtEmpIntQ4;
    }
    
    public String getTxtEmpIntAnn()
    {
      return txtEmpIntAnn;
    }

    public void setTxtEmpIntAnn(String newTxtEmpIntAnn)
    {
      txtEmpIntAnn = newTxtEmpIntAnn;
    }

    public String getTxtEmprIntQ1()
    {
      return txtEmprIntQ1;
    }

    public void setTxtEmprIntQ1(String newTxtEmprIntQ1)
    {
      txtEmprIntQ1 = newTxtEmprIntQ1;
    }
    
    public String getTxtEmprIntQ2()
    {
    return txtEmprIntQ2;
    }

    public void setTxtEmprIntQ2(String newTxtEmprIntQ2)
    {
    txtEmprIntQ2 = newTxtEmprIntQ2;
    }
    
    public String getTxtEmprIntQ3()
    {
      return txtEmprIntQ3;
    }

    public void setTxtEmprIntQ3(String newTxtEmprIntQ3)
    {
      txtEmprIntQ3 = newTxtEmprIntQ3;
    }
    
    public String getTxtEmprIntQ4()
    {
      return txtEmprIntQ4;
    }

    public void setTxtEmprIntQ4(String newTxtEmprIntQ4)
    {
      txtEmprIntQ4 = newTxtEmprIntQ4;
    }
    
    public String getTxtEmprIntAnn()
    {
      return txtEmprIntAnn;
    }

    public void setTxtEmprIntAnn(String newTxtEmprIntAnn)
    {
      txtEmprIntAnn = newTxtEmprIntAnn;
    }
 
  public String getTxtVolOpnPc()
  {
    return txtVolOpnPc;
  }

  public void setTxtVolOpnPc(String newTxtVolOpnPc)
  {
    txtVolOpnPc = newTxtVolOpnPc;
  }

  public String getTxtVolCloPc()
  {
    return txtVolCloPc;
  }

  public void setTxtVolCloPc(String newTxtVolCloPc)
  {
    txtVolCloPc = newTxtVolCloPc;
  }

    public String getUserBtn()
    {
        return userBtn;
    }
    public void setUserBtn(String newUserBtn)
    {
        userBtn = newUserBtn;
    }

    public String getHistBtn()
    {
        return histBtn;
    }
    public void setHistBtn(String newHistBtn)
    {
        histBtn = newHistBtn;
    }
    
    public String getTxtAdjTypeHdr()
    {
        return txtAdjTypeHdr;
    }
    public void setTxtAdjTypeHdr(String newTxtAdjTypeHdr)
    {
        txtAdjTypeHdr = newTxtAdjTypeHdr;
    }
    public String getTxtAdjTypeDtl()
    {
        return txtAdjTypeDtl;
    }
    public void setTxtAdjTypeDtl(String newTxtAdjTypeDtl)
    {
        txtAdjTypeDtl = newTxtAdjTypeDtl;
    }

    public String getTxtAdjAmtHdr()
    {
        return txtAdjAmtHdr;
    }
    public void setTxtAdjAmtHdr(String newTxtAdjAmtHdr)
    {
        txtAdjAmtHdr = newTxtAdjAmtHdr;
    }
    
    public String getTxtAdjAmtDtl()
    {
        return txtAdjAmtDtl;
    }
    public void setTxtAdjAmtDtl(String newTxtAdjAmtDtl)
    {
        txtAdjAmtDtl = newTxtAdjAmtDtl;
    }
    public String getTxtPayMode()
    {
        return txtPayMode;
    }
    public void setTxtPayMode(String newTxtPayMode)
    {
        txtPayMode = newTxtPayMode;
    }
    
    public String getTxtPayModeDtl()
    {
        return txtPayModeDtl;
    }
    public void setTxtPayModeDtl(String newTxtPayModeDtl)
    {
        txtPayModeDtl = newTxtPayModeDtl;
    }

    public String getTxtRmrkHdr()
    {
        return txtRmrkHdr;
    }
    public void setTxtRmrkHdr(String newTxtRmrkHdr)
    {
        txtRmrkHdr = newTxtRmrkHdr;
    }
    
    public String getTxtRmrkDtl()
    {
        return txtRmrkDtl;
    }
    public void setTxtRmrkDtl(String newTxtRmrkDtl)
    {
        txtRmrkDtl = newTxtRmrkDtl;
    }

    public String getTxtYYMMDtl()
    {
        return txtYYMMDtl;
    }
    public void setTxtYYMMDtl(String newTxtYYMMDtl)
    {
        txtYYMMDtl = newTxtYYMMDtl;
    }
    
  public String[] getTxtArrEmp()
  {
    return txtArrEmp;
  }

  public void setTxtArrEmp(String[] newTxtArrEmp)
  {
    txtArrEmp = newTxtArrEmp;
  }

    public String[] getTxtArrEmpr() 
    {
        return txtArrEmpr;
    }
    public void setTxtArrEmpr(String[] newTxtArrEmpr)
    {
      txtArrEmpr = newTxtArrEmpr;
    }

  public String[] getTxtRemDate()
  {
    return txtRemDate;
  }

  public void setTxtRemDate(String[] newTxtRemDate)
  {
    txtRemDate = newTxtRemDate;
  }

  public String[] getTxtNoOfDays()
  {
    return txtNoOfDays;
  }
  public void setTxtNoOfDays(String[] newTxtNoOfDays)
  {
    txtNoOfDays = newTxtNoOfDays;
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


    public void setTxtCpfCode(String txtCpfCode) {
        this.txtCpfCode = txtCpfCode;
    }

    public String getTxtCpfCode() {
        return txtCpfCode;
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

    public void setTxtPFAcctNo(String txtPFAcctNo) {
        this.txtPFAcctNo = txtPFAcctNo;
    }

    public String getTxtPFAcctNo() {
        return txtPFAcctNo;
    }

    public void setTxtQuarterHdr(String txtQuarterHdr) {
        this.txtQuarterHdr = txtQuarterHdr;
    }

    public String getTxtQuarterHdr() {
        return txtQuarterHdr;
    }

    public void setTxtPayModehdr(String txtPayModehdr) {
        this.txtPayModehdr = txtPayModehdr;
    }

    public String getTxtPayModehdr() {
        return txtPayModehdr;
    }

    public void setHdnAction(String hdnAction) {
        this.hdnAction = hdnAction;
    }

    public String getHdnAction() {
        return hdnAction;
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
