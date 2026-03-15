package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class DirPayrollBulkQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtPayCode1;
  private String txtValidFrom = null;
  private String txtPayMode = null;
  private String txtDepoCode;  // Added by dushaynt on 20-Aug-2013
  private String txtGangId;    // Added by dushaynt on 20-Aug-2013
  
  public DirPayrollBulkQueryVO()
  {
  }

  public String getTxtPayCode1()
  {
    return txtPayCode1;
  }

  public void setTxtPayCode1(String newTxtPayCode1)
  {
    txtPayCode1 = newTxtPayCode1;
  }
  
  public String getTxtValidFrom()
  {
    return txtValidFrom;
  }

  public void setTxtValidFrom(String newTxtValidFrom)
  {
    txtValidFrom = newTxtValidFrom;
  }
  
  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }
 // Added by dushaynt on 20-Aug-2013
   public String getTxtDepoCode()
  {
    return txtDepoCode;
  }

  public void setTxtDepoCode(String newTxtDepoCode)
  {
    txtDepoCode = newTxtDepoCode;
  }

 public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  } 
    
  
  
}