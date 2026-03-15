package FCIPAY.Payroll.DATAACCESSTIER.VO;
import  FCIPAY.Payroll.common.vo.BaseQueryVO; 
import java.io.Serializable;

public class MediReimbursDtlsAllQueryVO extends PayrollBaseQueryVO implements Serializable
{
    private String medicalDate;
    private String quarter;
    private String txtPayCode;
    private String finYear;
    private String txtBillAgst;
    private String yearMonth;
    
    
    public String getyearMonth()
  {
    return yearMonth;
  }

  public void setyearMonth (String newTxtyearMonth)
  {
    yearMonth = newTxtyearMonth;
  }    
    
    public String getTxtBillAgst()
  {
    return txtBillAgst;
  }

  public void setTxtBillAgst(String newTxtBillAgst)
  {
    txtBillAgst = newTxtBillAgst;
  }  
    
    
     public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }  
  
    
     public String getFinYear()
  {
    return finYear;
  }

  public void setFinYear(String newTxtFinYear)
  {
    finYear = newTxtFinYear;
  }  
     
     
     
     public String getMedicalDate()
  {
    return medicalDate;
  }

  public void setMedicalDate(String newMedicalDate)
  {
    medicalDate = newMedicalDate;
  } 
  
   public String getQuarter()
  {
    return quarter;
  }

  public void setQuarter(String newQuarter)
  {
    quarter = newQuarter;
  }  
  
   
}