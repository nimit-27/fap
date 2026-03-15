package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
//import IBA.Payroll.UTILITY.MaintPayCodesBean;
//import IBA.Payroll.DATAACCESSTIER.VO.MaintAcctCodeVO;

public class MaintPfDetailForm extends PayrollBaseForm 
{
  private String txtSrlNo[];
  private String txtYearMon[];
  private String txtEmpSub[];
  private String txtEmpCon[];
  private String txtVolPf[];
  //private String txtAdvAmt[];
  private String txtRefAdv[];
  //private String txtAmtWithDrawn[];

  private String txtPfArrear[];
  private String txtBonusToPf[];
  private String txtBonToPfDate[];
  private String txtAdvDate[];
  private String txtWithDate[];
  //private String txtWidRef[];
  //private String txtWidRefDate[];
  private String txtAdvRefDate[];
  
  private String txtEPS[];
  private String txtAdvAmtEmpSub[];
  private String txtAdvAmtVpf[];
  private String txtExtraVpf[];
  private String txtAmtWithDrwEmp[];
  private String txtAmtWithDrwEmpr[];
  private String txtAmtWithDrwVpf[];

//  private String txtBonPf[];
//  private String txtExVpfAmt[];
  private ArrayList lstInstrDtls = new ArrayList();
  private ArrayList adjHistHdrList = new ArrayList();
  private ArrayList adjHistDtlList = new ArrayList();
   
  private long txtTest;
  private String action = "";
  private String txtEmpNo;
  private String txtEmpName;
  private String txtCpfCode;
  private String hdrGoto;
  private String txtFromYear;
  private String txtPFAcctNo;
  private String txtToYear;
  private String txtEmpOpnCon;
  private String txtEmpOpnInt;
  private String txtEmprOpnCon;
  private String txtEmprOpnInt;
  private String txtEmpCloCon;
  private String txtEmpCloInt;
  private String txtEmprCloCon;
  private String txtEmprCloInt;
  private String txtEmpInSub;
  private String txtEmprInCon;
  private String txtVolInPf;
  private String txtEmpInSubDate;
  private String txtEmprInConDate;
  private String txtVolInPFDate;
  private String txtEmpOutSub;
  private String txtEmprOutCon;
  private String txtVolOutPf;
  private String txtEmpOutSubDate;
  private String txtEmprOutConDate;
  private String txtVolOutPFDate;
  private String screenModePay1;
  private String screenModePfDtl;
  private String txtPfType;
  
    private String txtVPFOpnPf;
    private String txtVPFOpnInt;
    private String txtVPFCloPf;
    private String txtVPFCloInt;  
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
    
 /* private String txtEmpInSub;
  private String txtEmpInCon;
  private String txtVolInPf;
  private String txtSubInTransDate;
  private String txtConInTransDate;
  private String txtVPFInTransDate;
  private String txtEmpOutSub;
  private String txtEmpOutCon;
  private String txtVolOutPf;
  private String txtSubOutTransDate;
  private String txtConOutTransDate;
  private String txtVPFOutTransDate;*/
  
 /* private String txtFinPeriod;
  private String txtOpBal;
  private String txtCloBal;
  private String txtIntActotal;
  private String txtPfActNo;
  private String txtSubInTransDate;
  private String txtConInTransDate;
  private String txtVPFInTransDate;
  private String txtSubOutTransDate;
  private String txtConOutTransDate;
  private String txtVPFOutTransDate;*/

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

  public String[] getTxtVolPf()
  {
    return txtVolPf;
  }

  public void setTxtVolPf(String[] newTxtVolPf)
  {
    txtVolPf = newTxtVolPf;
  }
/*
  public String[] getTxtAdvAmt()
  {
    return txtAdvAmt;
  }

  public void setTxtAdvAmt(String[] newTxtAdvAmt)
  {
    txtAdvAmt = newTxtAdvAmt;
  }
*/
  public String[] getTxtRefAdv()
  {
    return txtRefAdv;
  }

  public void setTxtRefAdv(String[] newTxtRefAdv)
  {
    txtRefAdv = newTxtRefAdv;
  }
/*
  public String[] getTxtAmtWithDrawn()
  {
    return txtAmtWithDrawn;
  }

  public void setTxtAmtWithDrawn(String[] newTxtAmtWithDrawn)
  {
    txtAmtWithDrawn = newTxtAmtWithDrawn;
  }

  public String[] getTxtBonPf()
  {
    return txtBonPf;
  }

  public void setTxtBonPf(String[] newTxtBonPf)
  {
    txtBonPf = newTxtBonPf;
  } */

/*  public String[] getTxtExVpfAmt()
  {
    return txtExVpfAmt;
  }

  public void setTxtExVpfAmt(String[] newTxtExVpfAmt)
  {
    txtExVpfAmt = newTxtExVpfAmt;
  } */

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
  
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
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

  public String getTxtPFAcctNo()
  {
    return txtPFAcctNo;
  }

  public void setTxtPFAcctNo(String newTxtPFAcctNo)
  {
    txtPFAcctNo = newTxtPFAcctNo;
  }

  public String getTxtToYear()
  {
    return txtToYear;
  }

  public void setTxtToYear(String newTxtToYear)
  {
    txtToYear = newTxtToYear;
  }

  public String getTxtEmpOpnCon()
  {
    return txtEmpOpnCon;
  }

  public void setTxtEmpOpnCon(String newTxtEmpOpnCon)
  {
    txtEmpOpnCon = newTxtEmpOpnCon;
  }

  public String getTxtEmpOpnInt()
  {
    return txtEmpOpnInt;
  }

  public void setTxtEmpOpnInt(String newTxtEmpOpnInt)
  {
    txtEmpOpnInt = newTxtEmpOpnInt;
  }

  public String getTxtEmprOpnCon()
  {
    return txtEmprOpnCon;
  }

  public void setTxtEmprOpnCon(String newTxtEmprOpnCon)
  {
    txtEmprOpnCon = newTxtEmprOpnCon;
  }

  public String getTxtEmprOpnInt()
  {
    return txtEmprOpnInt;
  }

  public void setTxtEmprOpnInt(String newTxtEmprOpnInt)
  {
    txtEmprOpnInt = newTxtEmprOpnInt;
  }

  public String getTxtEmpCloCon()
  {
    return txtEmpCloCon;
  }

  public void setTxtEmpCloCon(String newTxtEmpCloCon)
  {
    txtEmpCloCon = newTxtEmpCloCon;
  }

  public String getTxtEmpCloInt()
  {
    return txtEmpCloInt;
  }

  public void setTxtEmpCloInt(String newTxtEmpCloInt)
  {
    txtEmpCloInt = newTxtEmpCloInt;
  }

  public String getTxtEmprCloCon()
  {
    return txtEmprCloCon;
  }

  public void setTxtEmprCloCon(String newTxtEmprCloCon)
  {
    txtEmprCloCon = newTxtEmprCloCon;
  }

  public String getTxtEmprCloInt()
  {
    return txtEmprCloInt;
  }

  public void setTxtEmprCloInt(String newTxtEmprCloInt)
  {
    txtEmprCloInt = newTxtEmprCloInt;
  }

  public String getTxtEmpInSub()
  {
    return txtEmpInSub;
  }

  public void setTxtEmpInSub(String newTxtEmpInSub)
  {
    txtEmpInSub = newTxtEmpInSub;
  }

  public String getTxtEmprInCon()
  {
    return txtEmprInCon;
  }

  public void setTxtEmprInCon(String newTxtEmprInCon)
  {
    txtEmprInCon = newTxtEmprInCon;
  }

  public String getTxtVolInPf()
  {
    return txtVolInPf;
  }

  public void setTxtVolInPf(String newTxtVolInPf)
  {
    txtVolInPf = newTxtVolInPf;
  }

  public String getTxtEmpInSubDate()
  {
    return txtEmpInSubDate;
  }

  public void setTxtEmpInSubDate(String newTxtEmpInSubDate)
  {
    txtEmpInSubDate = newTxtEmpInSubDate;
  }

  public String getTxtEmprInConDate()
  {
    return txtEmprInConDate;
  }

  public void setTxtEmprInConDate(String newTxtEmprInConDate)
  {
    txtEmprInConDate = newTxtEmprInConDate;
  }

  public String getTxtVolInPFDate()
  {
    return txtVolInPFDate;
  }

  public void setTxtVolInPFDate(String newTxtVolInPFDate)
  {
    txtVolInPFDate = newTxtVolInPFDate;
  }

  public String getTxtEmpOutSub()
  {
    return txtEmpOutSub;
  }

  public void setTxtEmpOutSub(String newTxtEmpOutSub)
  {
    txtEmpOutSub = newTxtEmpOutSub;
  }

  public String getTxtEmprOutCon()
  {
    return txtEmprOutCon;
  }

  public void setTxtEmprOutCon(String newTxtEmprOutCon)
  {
    txtEmprOutCon = newTxtEmprOutCon;
  }

  public String getTxtVolOutPf()
  {
    return txtVolOutPf;
  }

  public void setTxtVolOutPf(String newTxtVolOutPf)
  {
    txtVolOutPf = newTxtVolOutPf;
  }

  public String getTxtEmpOutSubDate()
  {
    return txtEmpOutSubDate;
  }

  public void setTxtEmpOutSubDate(String newTxtEmpOutSubDate)
  {
    txtEmpOutSubDate = newTxtEmpOutSubDate;
  }

  public String getTxtEmprOutConDate()
  {
    return txtEmprOutConDate;
  }

  public void setTxtEmprOutConDate(String newTxtEmprOutConDate)
  {
    txtEmprOutConDate = newTxtEmprOutConDate;
  }

  public String getTxtVolOutPFDate()
  {
    return txtVolOutPFDate;
  }

  public void setTxtVolOutPFDate(String newTxtVolOutPFDate)
  {
    txtVolOutPFDate = newTxtVolOutPFDate;
  }

  public String getScreenModePay1()
  {
    return screenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    screenModePay1 = newScreenModePay1;
  }

  public String getScreenModePfDtl()
  {
    return screenModePfDtl;
  }

  public void setScreenModePfDtl(String newScreenModePfDtl)
  {
    screenModePfDtl = newScreenModePfDtl;
  }

  public String getTxtPfType()
  {
    return txtPfType;
  }

  public void setTxtPfType(String newTxtPfType)
  {
    txtPfType = newTxtPfType;
  }

    public String getTxtVPFOpnPf()
    {
        return txtVPFOpnPf;
    }
    
    public void setTxtVPFOpnPf(String newTxtVPFOpnPf)
    {
        txtVPFOpnPf = newTxtVPFOpnPf;
    }
    public String getTxtVPFOpnInt()
    {
        return txtVPFOpnInt;
    }
    
    public void setTxtVPFOpnInt(String newTxtVPFOpnInt)
    {
        txtVPFOpnInt = newTxtVPFOpnInt;
    }
    public String getTxtVPFCloPf()
    {
        return txtVPFCloPf;
    }
    public void setTxtVPFCloPf(String newTxtVPFCloPf)
    {
        txtVPFCloPf = newTxtVPFCloPf;
    }
    public String getTxtVPFCloInt()
    {
        return txtVPFCloInt;
    }
    public void setTxtVPFCloInt(String newTxtVPFCloInt)
    {
        txtVPFCloInt = newTxtVPFCloInt;
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
    
  public String[] getTxtPfArrear()
  {
    return txtPfArrear;
  }

  public void setTxtPfArrear(String[] newTxtPfArrear)
  {
    txtPfArrear = newTxtPfArrear;
  }

  public String[] getTxtBonusToPf()
  {
    return txtBonusToPf;
  }

  public void setTxtBonusToPf(String[] newTxtBonusToPf)
  {
    txtBonusToPf = newTxtBonusToPf;
  }

  public String[] getTxtBonToPfDate()
  {
    return txtBonToPfDate;
  }

  public void setTxtBonToPfDate(String[] newTxtBonToPfDate)
  {
    txtBonToPfDate = newTxtBonToPfDate;
  }

  public String[] getTxtAdvDate()
  {
    return txtAdvDate;
  }

  public void setTxtAdvDate(String[] newTxtAdvDate)
  {
    txtAdvDate = newTxtAdvDate;
  }

  public String[] getTxtWithDate()
  {
    return txtWithDate;
  }

  public void setTxtWithDate(String[] newTxtWithDate)
  {
    txtWithDate = newTxtWithDate;
  }
/*
  public String[] getTxtWidRef()
  {
    return txtWidRef;
  }

  public void setTxtWidRef(String[] newTxtWidRef)
  {
    txtWidRef = newTxtWidRef;
  }

  public String[] getTxtWidRefDate()
  {
    return txtWidRefDate;
  }

  public void setTxtWidRefDate(String[] newTxtWidRefDate)
  {
    txtWidRefDate = newTxtWidRefDate;
  }
*/
  public String[] getTxtAdvRefDate()
  {
    return txtAdvRefDate;
  }

  public void setTxtAdvRefDate(String[] newTxtAdvRefDate)
  {
    txtAdvRefDate = newTxtAdvRefDate;
  }



/*  public String getTxtEmpInSub()
  {
    return txtEmpInSub;
  }

  public void setTxtEmpInSub(String newTxtEmpInSub)
  {
    txtEmpInSub = newTxtEmpInSub;
  }

  public String getTxtEmpInCon()
  {
    return txtEmpInCon;
  }

  public void setTxtEmpInCon(String newTxtEmpInCon)
  {
    txtEmpInCon = newTxtEmpInCon;
  }

  public String getTxtVolInPf()
  {
    return txtVolInPf;
  }

  public void setTxtVolInPf(String newTxtVolInPf)
  {
    txtVolInPf = newTxtVolInPf;
  }

  public String getTxtSubInTransDate()
  {
    return txtSubInTransDate;
  }

  public void setTxtSubInTransDate(String newTxtSubInTransDate)
  {
    txtSubInTransDate = newTxtSubInTransDate;
  }

  public String getTxtConInTransDate()
  {
    return txtConInTransDate;
  }

  public void setTxtConInTransDate(String newTxtConInTransDate)
  {
    txtConInTransDate = newTxtConInTransDate;
  }

  public String getTxtVPFInTransDate()
  {
    return txtVPFInTransDate;
  }

  public void setTxtVPFInTransDate(String newTxtVPFInTransDate)
  {
    txtVPFInTransDate = newTxtVPFInTransDate;
  }

  public String getTxtEmpOutSub()
  {
    return txtEmpOutSub;
  }

  public void setTxtEmpOutSub(String newTxtEmpOutSub)
  {
    txtEmpOutSub = newTxtEmpOutSub;
  }

  public String getTxtEmpOutCon()
  {
    return txtEmpOutCon;
  }

  public void setTxtEmpOutCon(String newTxtEmpOutCon)
  {
    txtEmpOutCon = newTxtEmpOutCon;
  }

  public String getTxtVolOutPf()
  {
    return txtVolOutPf;
  }

  public void setTxtVolOutPf(String newTxtVolOutPf)
  {
    txtVolOutPf = newTxtVolOutPf;
  }

  public String getTxtSubOutTransDate()
  {
    return txtSubOutTransDate;
  }

  public void setTxtSubOutTransDate(String newTxtSubOutTransDate)
  {
    txtSubOutTransDate = newTxtSubOutTransDate;
  }

  public String getTxtConOutTransDate()
  {
    return txtConOutTransDate;
  }

  public void setTxtConOutTransDate(String newTxtConOutTransDate)
  {
    txtConOutTransDate = newTxtConOutTransDate;
  }

  public String getTxtVPFOutTransDate()
  {
    return txtVPFOutTransDate;
  }

  public void setTxtVPFOutTransDate(String newTxtVPFOutTransDate)
  {
    txtVPFOutTransDate = newTxtVPFOutTransDate;
  }*/

 /* public String getTxtFinPeriod()
  {
    return txtFinPeriod;
  }

  public void setTxtFinPeriod(String newTxtFinPeriod)
  {
    txtFinPeriod = newTxtFinPeriod;
  }

  public String getTxtOpBal()
  {
    return txtOpBal;
  }

  public void setTxtOpBal(String newTxtOpBal)
  {
    txtOpBal = newTxtOpBal;
  }

  public String getTxtCloBal()
  {
    return txtCloBal;
  }

  public void setTxtCloBal(String newTxtCloBal)
  {
    txtCloBal = newTxtCloBal;
  }

  public String getTxtIntActotal()
  {
    return txtIntActotal;
  }

  public void setTxtIntActotal(String newTxtIntActotal)
  {
    txtIntActotal = newTxtIntActotal;
  }

  public String getTxtPfActNo()
  {
    return txtPfActNo;
  }

  public void setTxtPfActNo(String newTxtPfActNo)
  {
    txtPfActNo = newTxtPfActNo;
  }

  public String getTxtSubInTransDate()
  {
    return txtSubInTransDate;
  }

  public void setTxtSubInTransDate(String newTxtSubInTransDate)
  {
    txtSubInTransDate = newTxtSubInTransDate;
  }

  public String getTxtConInTransDate()
  {
    return txtConInTransDate;
  }

  public void setTxtConInTransDate(String newTxtConInTransDate)
  {
    txtConInTransDate = newTxtConInTransDate;
  }

  public String getTxtVPFInTransDate()
  {
    return txtVPFInTransDate;
  }

  public void setTxtVPFInTransDate(String newTxtVPFInTransDate)
  {
    txtVPFInTransDate = newTxtVPFInTransDate;
  }

  public String getTxtSubOutTransDate()
  {
    return txtSubOutTransDate;
  }

  public void setTxtSubOutTransDate(String newTxtSubOutTransDate)
  {
    txtSubOutTransDate = newTxtSubOutTransDate;
  }

  public String getTxtConOutTransDate()
  {
    return txtConOutTransDate;
  }

  public void setTxtConOutTransDate(String newTxtConOutTransDate)
  {
    txtConOutTransDate = newTxtConOutTransDate;
  }

  public String getTxtVPFOutTransDate()
  {
    return txtVPFOutTransDate;
  }

  public void setTxtVPFOutTransDate(String newTxtVPFOutTransDate)
  {
    txtVPFOutTransDate = newTxtVPFOutTransDate;
  }


*/

  public String[] getTxtEPS()
  {
    return txtEPS;
  }
  public void setTxtEPS(String[] newTxtEPS)
  {
    txtEPS = newTxtEPS;
  }
  
  public String[] getTxtAdvAmtEmpSub()
  {
    return txtAdvAmtEmpSub;
  }
  public void setTxtAdvAmtEmpSub(String[] newTxtAdvAmtEmpSub)
  {
    txtAdvAmtEmpSub = newTxtAdvAmtEmpSub;
  }

  public String[] getTxtAdvAmtVpf()
  {
    return txtAdvAmtVpf;
  }
  public void setTxtAdvAmtVpf(String[] newTxtAdvAmtVpf)
  {
    txtAdvAmtVpf = newTxtAdvAmtVpf;
  }

  public String[] getTxtExtraVpf()
  {
    return txtExtraVpf;
  }
  public void setTxtExtraVpf(String[] newTxtExtraVpf)
  {
    txtExtraVpf = newTxtExtraVpf;
  }

  public String[] getTxtAmtWithDrwEmp()
  {
    return txtAmtWithDrwEmp;
  }
  public void setTxtAmtWithDrwEmp(String[] newTxtAmtWithDrwEmp)
  {
    txtAmtWithDrwEmp = newTxtAmtWithDrwEmp;
  }

  public String[] getTxtAmtWithDrwEmpr()
  {
    return txtAmtWithDrwEmpr;
  }
  public void setTxtAmtWithDrwEmpr(String[] newTxtAmtWithDrwEmpr)
  {
    txtAmtWithDrwEmpr = newTxtAmtWithDrwEmpr;
  }

  public String[] getTxtAmtWithDrwVpf()
  {
    return txtAmtWithDrwVpf;
  }
  public void setTxtAmtWithDrwVpf(String[] newTxtAmtWithDrwVpf)
  {
    txtAmtWithDrwVpf = newTxtAmtWithDrwVpf;
  }

}