package FCIPAY.Payroll.Labour.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import java.util.ArrayList;

public class MaintGangForm extends PayrollBaseForm 
{
    private String txtLocId;
    private String txtLoc;
    private String txtGangId;
    private String txtGangName;
    private String txtMou;
    private String txtType;
    private String [] hdnEmpId;
    private String [] txtCpfCode;    // added by dushyant on 01-03-2011
    private String [] txtEmpTyp;
    private String [] txtEmpName;
    private String [] txtFrom;
    private String [] txtFromHrs;
    private String [] txtFromMin;
    private String [] txtTo;
    private String [] txtToHrs;
    private String [] txtToMin;
    private ArrayList lstInstrDtls=new ArrayList();
   
    private String [] txtSNo;
    private String [] txtCurrBas;
    private String [] hdnEffToDt;
    private String [] hdnEffToHr;
    private String [] hdnEffToMin;
    
  public String getTxtLoc()
  {
    return txtLoc;
  }

  public void setTxtLoc(String newTxtLoc)
  {
    txtLoc = newTxtLoc;
  }
    
  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
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
  
  public String getTxtType()
  {
    return txtType;
  }

  public void setTxtType(String newTxtType)
  {
    txtType = newTxtType;
  }

  public String getTxtMou()
  {
    return txtMou;
  }

  public void setTxtMou(String newTxtMou)
  {
    txtMou = newTxtMou;
  }
  
  public String[] getHdnEmpId()
  {
    return hdnEmpId;
  }

  public void setHdnEmpId(String[] newHdnEmpId)
  {
    hdnEmpId = newHdnEmpId;
  }
  
  public String[] getTxtEmpTyp()
  {
    return txtEmpTyp;
  }

  public void setTxtEmpTyp(String[] newTxtEmpTyp)
  {
    txtEmpTyp = newTxtEmpTyp;
  }
  
   public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
   public String[] getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String[] newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

   public String[] getTxtFrom()
  {
    return txtFrom;
  }

  public void setTxtFrom(String[] newTxtFrom)
  {
    txtFrom = newTxtFrom;
  }
  
   public String[] getTxtFromHrs()
  {
    return txtFromHrs;
  }

  public void setTxtFromHrs(String[] newTxtFromHrs)
  {
    txtFromHrs = newTxtFromHrs;
  }
    public String[] getHdnEffToHr()
    {
     return hdnEffToHr;
    }
    public void sethdnEffToHr(String[] newHdnEffToHr)
    {
      hdnEffToHr = newHdnEffToHr;
    }

   public String[] getTxtFromMin()
  {
    return txtFromMin;
  }

  public void setTxtFromMin(String[] newTxtFromMin)
  {
    txtFromMin = newTxtFromMin;
  }

    public String[] getHdnEffToMin()
    {
     return hdnEffToMin;
    }
    
    public void setHdnEffToMin(String[] newHdnEffToMin)
    {
      hdnEffToMin = newHdnEffToMin;
    }

   public String[] getTxtTo()
  {
    return txtTo;
  }

  public void setTxtTo(String[] newTxtTo)
  {
    txtTo = newTxtTo;
  }
  
   public String[] getTxtToHrs()
  {
    return txtToHrs;
  }

  public void setTxtToHrs(String[] newTxtToHrs)
  {
    txtToHrs = newTxtToHrs;
  }
  
   public String[] getTxtToMin()
  {
    return txtToMin;
  }

  public void setTxtToMin(String[] newTxtToMin)
  {
    txtToMin = newTxtToMin;
  }

   public String[] getTxtSNo()
  {
    return txtSNo;
  }

  public void setTxtSNo(String[] newTxtSNo)
  {
    txtSNo = newTxtSNo;
  }

   public String[] getTxtCurrBas()
  {
    return txtCurrBas;
  }

  public void setTxtCurrBas(String[] newTxtCurrBas)
  {
    txtCurrBas = newTxtCurrBas;
  }
// added by dushyant on 01-03-2011    //   txtCpfCode  TxtCpfCode

 public String[] getTxtCpfCode()     
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String[] newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
// added by dushyant on 01-03-2011

    public void setHdnEffToDt(String[] hdnEffToDt) {
        this.hdnEffToDt = hdnEffToDt;
    }

    public String[] getHdnEffToDt() {
        return hdnEffToDt;
    }
}
