package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;


public class MediReimbursDtlsAllHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
    private String medicalAmt;
    private String medicalDate;
    private String taxIndicator;
    private String quarter;
    private String medicalFromDate;
    private String medicalToDate;
    private String txtEmpList;
    private String hdnAction;
    
    private String txtPayCode;
    private String txtBillAgst;
    private String txtITDedAmt;
    private String finYear;
    private String yearMonth;
    
    
   public String getyearMonth()
  {
    return yearMonth;
  }

  public void setyearMonth (String newTxtyearMonth)
  {
    yearMonth = newTxtyearMonth;
  }    
  
    public String getFinYear()
  {
    return finYear;
  }

  public void setFinYear(String newTxtFinYear)
  {
    finYear = newTxtFinYear;
  }  
    
     public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }  
     public String getTxtITDedAmt()
  {
    return txtITDedAmt;
  }

  public void setTxtITDedAmt(String newTxtITDedAmt)
  {
    txtITDedAmt = newTxtITDedAmt;
  }  
  
  
  
  public String getTxtBillAgst()
  {
    return txtBillAgst;
  }

  public void setTxtBillAgst(String newTxtBillAgst)
  {
    txtBillAgst = newTxtBillAgst;
  }  
  
     public String getTxtEmpList()
  {
    return txtEmpList;
  }

  public void setTxtEmpList(String newTxtEmpList)
  {
    txtEmpList = newTxtEmpList;
  }  
  
  
  
  
  

  
  
   public String getMedicalToDate()
  {
    return medicalToDate;
  }

  public void setMedicalToDate(String newMedicalToDate)
  {
    medicalToDate = newMedicalToDate;
  }  
   
   public String getMedicalFromDate()
  {
    return medicalFromDate;
  }

  public void setMedicalFromDate(String newMedicalFromDate)
  {
    medicalFromDate = newMedicalFromDate;
  }  
  
  
   public String getQuarter()
  {
    return quarter;
  }

  public void setQuarter(String newQuarter)
  {
    quarter = newQuarter;
  }  
  
  
  
  
  
  
  
  
  
  
   
  public String getTaxIndicator()
  {
    return taxIndicator;
  }

  public void setTaxIndicator(String newTaxIndicator)
  {
    taxIndicator = newTaxIndicator;
  }  
  
  
  
  
  
  
  
   public String getMedicalAmt()
  {
    return medicalAmt;
  }

  public void setMedicalAmt(String newMedicalAmt)
  {
    medicalAmt = newMedicalAmt;
  } 
  
  public String getMedicalDate()
  {
    return medicalDate;
  }

  public void setMedicalDate(String newMedicalDate)
  {
    medicalDate = newMedicalDate;
  } 
   
}