package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class MediReimbDtlsAllDetailInfo extends BaseDetailInfo implements Serializable
{
        private String medicalDate;
        private String quarter;
        private String txtPayCode;
        private String txtBillAgst;
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
        
        public MediReimbDtlsAllDetailInfo()
        {
        }
        
        
        public String getTxtPayCode()
        {
          return txtPayCode;
        }
      
        public void setTxtPayCode(String newTxtPayCode)
        {
          txtPayCode = newTxtPayCode;
        }  
        
        public String getQuarter()
        {
          return quarter;
        }
      
        public void setQuarter(String newQuarter)
        {
          quarter = newQuarter;
        }  
        
        public String getMedicalDate()
        {
          return medicalDate;
        }
      
        public void setMedicalDate(String newMedicalDate)
        {
          medicalDate = newMedicalDate;
        } 
   
        public String getTxtBillAgst()
        {
          return txtBillAgst;
        }
      
        public void setTxtBillAgst(String newTxtBillAgst)
        {
          txtBillAgst = newTxtBillAgst;
        }  
  
        public String getFinYear()
        {
          return finYear;
        }
      
        public void setFinYear(String newTxtFinYear)
        {
          finYear = newTxtFinYear;
        }  
        
        
}