package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MaintGangBean extends PayrollBaseDetailBean 
{
  
   private String hdnEmpId;
   private String txtCpfCode;  // added by dushyant on 01-03-2011
   private String txtEmpTyp;
   private String txtEmpName;
   private String txtFrom;
   private String txtFromHrs;
   private String txtFromMin;
   private String txtTo;
   private String txtToHrs;
   private String txtToMin;
   private String txtCurrBas;
   private String hdnEffToDt;
   private String hdnEffToHr;
   private String hdnEffToMin;
     

   
  public MaintGangBean()
  {
  }
  
  public String getHdnEmpId()
  {
    return hdnEmpId;
  }

  public void setHdnEmpId(String newHdnEmpId)
  {
    hdnEmpId = newHdnEmpId;
  }
  
  public String getTxtEmpTyp()
  {
    return txtEmpTyp;
  }

  public void setTxtEmpTyp(String newTxtEmpTyp)
  {
    txtEmpTyp = newTxtEmpTyp;
  }
  
  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
  
  public String getTxtFrom()
  {
    return txtFrom;
  }

  public void setTxtFrom(String newTxtFrom)
  {
    txtFrom = newTxtFrom;
  }
  
  public String getTxtFromHrs()
  {
    return txtFromHrs;
  }

  public void setTxtFromHrs(String newTxtFromHrs)
  {
    txtFromHrs = newTxtFromHrs;
  }
  
  public String getTxtFromMin()
  {
    return txtFromMin;
  }

  public void setTxtFromMin(String newTxtFromMin)
  {
    txtFromMin = newTxtFromMin;
  }
  
  public String getTxtTo()
  {
    return txtTo;
  }

  public void setTxtTo(String newTxtTo)
  {
    txtTo = newTxtTo;
  }
  
  public String getTxtToHrs()
  {
    return txtToHrs;
  }

  public void setTxtToHrs(String newTxtToHrs)
  {
    txtToHrs = newTxtToHrs;
  }

  public String getTxtToMin()
  {
    return txtToMin;
  }

  public void setTxtToMin(String newTxtToMin)
  {
    txtToMin = newTxtToMin;
  }

  public String getTxtCurrBas()
  {
    return txtCurrBas;
  }

  public void setTxtCurrBas(String newTxtCurrBas)
  {
    txtCurrBas = newTxtCurrBas;
  }
// added by  dushaynt

public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
  
// added by dushaynt
//added by shivani
    public void setHdnEffToDt(String hdnEffToDt) {
        this.hdnEffToDt = hdnEffToDt;
    }

    public String getHdnEffToDt() {
        return hdnEffToDt;
    }
    
    
    public void setHdnEffToHr(String hdnEffToHr) {
        this.hdnEffToHr = hdnEffToHr;
    }
    
    public String getHdnEffToHr() {
        return hdnEffToHr;
    }
    
    public void setHdnEffToMin(String hdnEffToMin) {
        this.hdnEffToMin = hdnEffToMin;
    }
    
    public String getHdnEffToMin() {
        return hdnEffToMin;
    }
}
