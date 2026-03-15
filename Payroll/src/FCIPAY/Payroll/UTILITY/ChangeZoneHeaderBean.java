package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class ChangeZoneHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
    public ChangeZoneHeaderBean()
    {
    }
      private String txtEmpNo;
      private String txtYYMMFrom;
      private String txtYYMMTo;
      private String txtNewParentZone;
      
        public String getTxtEmpNo()
    {
        return txtEmpNo;
    }
    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo=newTxtEmpNo;
    }
    
    public String getTxtYYMMFrom()
    {
        return txtYYMMFrom;
    }
    public void setTxtYYMMFrom(String newTxtDateFrom)
    {
        txtYYMMFrom=newTxtDateFrom ;
    }
    
    public String getTxtYYMMTo()
    {
        return txtYYMMTo;
    }
    public void setTxtYYMMTo(String newTxtYYMMTo)
    {
        txtYYMMTo=newTxtYYMMTo;
    }
    public String getTxtNewParentZone()
     {
        return txtNewParentZone;
     }
    public void setTxtNewParentZone(String newParentZone)
      {
         txtNewParentZone = newParentZone;
      }    
    
   
   
}