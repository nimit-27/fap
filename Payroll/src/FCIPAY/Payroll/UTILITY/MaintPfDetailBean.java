
package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;


public class MaintPfDetailBean extends PayrollBaseDetailBean implements Serializable 
{
  private String txtYearMon = "";
  private String txtEmpSub = "";
  private String txtEmpCon = "";
  private String txtVolPf = "";
  //private String txtAdvAmt = "";
  private String txtAdvDate;
  private String txtRefAdv = "";
  private String txtAdvRefDate;
  //private String txtAmtWithDrawn = "";
  private String txtWithDate;
  //private String txtWidRef;
  //private String txtWidRefDate;
  private String txtBonusToPf;
  private String txtBonToPfDate;
  
  private String txtEPS;
  private String txtPfArrear;
  private String txtAdvAmtEmpSub;
  private String txtAdvAmtVpf;
  private String txtExtraVpf;
  private String txtAmtWithDrwEmp;
  private String txtAmtWithDrwEmpr;
  private String txtAmtWithDrwVpf ;
  
  public MaintPfDetailBean()
  {
  }

 public MaintPfDetailBean(String sYearMon,String sEmpSub,String sEmpCon,String sVolPf,String sAdvAmt,String sAmtWithDrawn,String sBonPf,String sExVpfAmt )
  {
  
   txtYearMon=sYearMon;
   txtEmpSub=sEmpSub;
   txtEmpCon=sEmpCon;
   txtVolPf=sVolPf;
   //txtAdvAmt=sAdvAmt;
   //txtAmtWithDrawn=sAmtWithDrawn;
//   txtBonPf=sBonPf;
//   txtExVpfAmt=sExVpfAmt;

  }




  public String getTxtYearMon()
  {
    return txtYearMon;
  }

  public void setTxtYearMon(String newTxtYearMon)
  {
    txtYearMon = newTxtYearMon;
  }

  public String getTxtEmpSub()
  {
    return txtEmpSub;
  }

  public void setTxtEmpSub(String newTxtEmpSub)
  {
    txtEmpSub = newTxtEmpSub;
  }

  public String getTxtEmpCon()
  {
    return txtEmpCon;
  }

  public void setTxtEmpCon(String newTxtEmpCon)
  {
    txtEmpCon = newTxtEmpCon;
  }

  public String getTxtVolPf()
  {
    return txtVolPf;
  }

  public void setTxtVolPf(String newTxtVolPf)
  {
    txtVolPf = newTxtVolPf;
  }
/*
  public String getTxtAdvAmt()
  {
    return txtAdvAmt;
  }

  public void setTxtAdvAmt(String newTxtAdvAmt)
  {
    txtAdvAmt = newTxtAdvAmt;
  }
*/
  public String getTxtRefAdv()
  {
    return txtRefAdv;
  }

  public void setTxtRefAdv(String newTxtRefAdv)
  {
    txtRefAdv = newTxtRefAdv;
  }
/*
  public String getTxtAmtWithDrawn()
  {
    return txtAmtWithDrawn;
  }

  public void setTxtAmtWithDrawn(String newTxtAmtWithDrawn)
  {
    txtAmtWithDrawn = newTxtAmtWithDrawn;
  }

  public String getTxtBonPf()
  {
    return txtBonPf;
  }

  public void setTxtBonPf(String newTxtBonPf)
  {
    txtBonPf = newTxtBonPf;
  }

  public String getTxtExVpfAmt()
  {
    return txtExVpfAmt;
  } */

/*  public void setTxtExVpfAmt(String newTxtExVpfAmt)
  {
    txtExVpfAmt = newTxtExVpfAmt;
  } */

  public String getTxtPfArrear()
  {
    return txtPfArrear;
  }

  public void setTxtPfArrear(String newTxtPfArrear)
  {
    txtPfArrear = newTxtPfArrear;
  }

  public String getTxtBonusToPf()
  {
    return txtBonusToPf;
  }

  public void setTxtBonusToPf(String newTxtBonusToPf)
  {
    txtBonusToPf = newTxtBonusToPf;
  }

  public String getTxtBonToPfDate()
  {
    return txtBonToPfDate;
  }

  public void setTxtBonToPfDate(String newTxtBonToPfDate)
  {
    txtBonToPfDate = newTxtBonToPfDate;
  }

  public String getTxtAdvDate()
  {
    return txtAdvDate;
  }

  public void setTxtAdvDate(String newTxtAdvDate)
  {
    txtAdvDate = newTxtAdvDate;
  }

  public String getTxtWithDate()
  {
    return txtWithDate;
  }

  public void setTxtWithDate(String newTxtWithDate)
  {
    txtWithDate = newTxtWithDate;
  }
/*
  public String getTxtWidRef()
  {
    return txtWidRef;
  }

  public void setTxtWidRef(String newTxtWidRef)
  {
    txtWidRef = newTxtWidRef;
  }

  public String getTxtWidRefDate()
  {
    return txtWidRefDate;
  }

  public void setTxtWidRefDate(String newTxtWidRefDate)
  {
    txtWidRefDate = newTxtWidRefDate;
  }
*/
  public String getTxtAdvRefDate()
  {
    return txtAdvRefDate;
  }

  public void setTxtAdvRefDate(String newTxtAdvRefDate)
  {
    txtAdvRefDate = newTxtAdvRefDate;
  }


 /* public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  } */

  public String getTxtEPS()
  {
    return txtEPS;
  }
  public void setTxtEPS(String newTxtEPS)
  {
    txtEPS = newTxtEPS;
  }
  
  public String getTxtAdvAmtEmpSub()
  {
    return txtAdvAmtEmpSub;
  }
  public void setTxtAdvAmtEmpSub(String newTxtAdvAmtEmpSub)
  {
    txtAdvAmtEmpSub = newTxtAdvAmtEmpSub;
  }

  public String getTxtAdvAmtVpf()
  {
    return txtAdvAmtVpf;
  }
  public void setTxtAdvAmtVpf(String newTxtAdvAmtVpf)
  {
    txtAdvAmtVpf = newTxtAdvAmtVpf;
  }

  public String getTxtExtraVpf()
  {
    return txtExtraVpf;
  }
  public void setTxtExtraVpf(String newTxtExtraVpf)
  {
    txtExtraVpf = newTxtExtraVpf;
  }

  public String getTxtAmtWithDrwEmp()
  {
    return txtAmtWithDrwEmp;
  }
  public void setTxtAmtWithDrwEmp(String newTxtAmtWithDrwEmp)
  {
    txtAmtWithDrwEmp = newTxtAmtWithDrwEmp;
  }

  public String getTxtAmtWithDrwEmpr()
  {
    return txtAmtWithDrwEmpr;
  }
  public void setTxtAmtWithDrwEmpr(String newTxtAmtWithDrwEmpr)
  {
    txtAmtWithDrwEmpr = newTxtAmtWithDrwEmpr;
  }

  public String getTxtAmtWithDrwVpf()
  {
    return txtAmtWithDrwVpf;
  }
  public void setTxtAmtWithDrwVpf(String newTxtAmtWithDrwVpf)
  {
    txtAmtWithDrwVpf = newTxtAmtWithDrwVpf;
  }
}