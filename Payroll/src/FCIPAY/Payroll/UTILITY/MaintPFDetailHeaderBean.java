package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;


public class MaintPFDetailHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{

  private String txtEmpNo;
  private String txtEmpName;
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
  private String txtPfType;
 
    private String txtVPFOpnPf;
    private String txtVPFOpnInt;
    private String txtVPFCloPf;
    private String txtVPFCloInt;  

    private String txtAdjTypeHdr;
    private String txtAdjAmtHdr;
    private String txtAdjTypeDtl;
    private String txtAdjAmtDtl;
    private String txtPayMode;
    private String txtRmrkHdr;
    private String txtYYMMDtl;
    private String txtPayModeDtl;
    private String txtRmrkDtl;
/*  private String txtEmpInSub;
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

  public MaintPFDetailHeaderBean()
  {
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

 /* public String getTxtEmpInSub()
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
  }

*/

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
    public String getTxtRmrkHdr()
    {
        return txtRmrkHdr;
    }
    public void setTxtRmrkHdr(String newTxtRmrkHdr)
    {
        txtRmrkHdr = newTxtRmrkHdr;
    }

    public String getTxtYYMMDtl()
    {
        return txtYYMMDtl;
    }
    public void setTxtYYMMDtl(String newTxtYYMMDtl)
    {
        txtYYMMDtl = newTxtYYMMDtl;
    }
    public String getTxtPayModeDtl()
    {
        return txtPayModeDtl;
    }
    public void setTxtPayModeDtl(String newTxtPayModeDtl)
    {
        txtPayModeDtl = newTxtPayModeDtl;
    }
    public String getTxtRmrkDtl()
    {
        return txtRmrkDtl;
    }
    public void setTxtRmrkDtl(String newTxtRmrkDtl)
    {
        txtRmrkDtl = newTxtRmrkDtl;
    }

}