package FCIPAY.Payroll.UTILITY;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
import java.io.Serializable;

public class EmpDepndntBean  extends PayrollBaseDetailBean implements Serializable
{ 
  private String txtDepndntId="";
  private String txtDepndntName="";
  private String txtDepndntAge="";
  private String txtDepndntRel="";
  private String txtDepndntEffFrom="";
  private String txtDepndntEffTill="";   
  private String txtNomineeId=""; 
  private String txtDepndntGuard=""; 
  private String txtNomineeShare=""; 
  
  private String txtGratuityId="";
  private String txtGratuityName="";       // added by dushyant on 15-10-2010                
  private String txtGratuityAge="";                             
  private String txtGratuityRel="";  
  private String txtGratGuardian=""; 
  private String txtGratuityShare="";     // added by dushyant on 14-10-2010
  
  public EmpDepndntBean()
  {
  }

  
 public EmpDepndntBean( String depndntId,String depndntNam,String depndntAge,String depndntRel,String nomineeId,String nomineeShare,String gratuityId,String gratuityName,String gratuityAge,String gratuityRel,String gratuityGuard,String nomineeGuard,String gratuityShare)
  {   
      txtDepndntId=depndntId;
      txtDepndntName=depndntNam;
      txtDepndntAge=depndntAge;
      txtDepndntRel = depndntRel;
      txtNomineeId = nomineeId;
      txtNomineeShare = nomineeShare;
      txtGratuityId = gratuityId;
      txtGratuityName = gratuityName;                  // added by dushyant on 15-10-2010    
      txtGratuityAge = gratuityAge;
      txtGratuityRel = gratuityRel;
      txtGratGuardian = gratuityGuard;
      txtDepndntGuard = nomineeGuard;
      txtGratuityShare= gratuityShare;               // added by dushyant on 14-10-2010
  }  
  
  public String getTxtDepndntId()
  {
    return txtDepndntId;
  }  
  public void setTxtDepndntId(String newTxtDepndntId)
  {
    txtDepndntId = newTxtDepndntId;
  }
  
  public String getTxtDepndntName()
  {
    return txtDepndntName;
  }  
  public void setTxtDepndntName(String newTxtDepndntName)
  {
    txtDepndntName = newTxtDepndntName;
  }

  public String getTxtDepndntAge()
  {
    return txtDepndntAge;
  }

  public void setTxtDepndntAge(String newTxtDepndntAge)
  {
    txtDepndntAge = newTxtDepndntAge;
  }

  public String getTxtDepndntRel()
  {
    return txtDepndntRel;
  }

  public void setTxtDepndntRel(String newTxtDepndntRel)
  {
    txtDepndntRel = newTxtDepndntRel;
  }

  public String getTxtDepndntEffFrom()
  {
    return txtDepndntEffFrom;
  }

  public void setTxtDepndntEffFrom(String newTxtDepndntEffFrom)
  {
    txtDepndntEffFrom = newTxtDepndntEffFrom;
  }  

  public String getTxtDepndntEffTill()
  {
    return txtDepndntEffTill;
  }

  public void setTxtDepndntEffTill(String newTxtDepndntEffTill)
  {
    txtDepndntEffTill = newTxtDepndntEffTill;
  }  
  
  public String getTxtNomineeId()
  {
    return txtNomineeId;
  }

  public void setTxtNomineeId(String newTxtNomineeId)
  {
    txtNomineeId = newTxtNomineeId;
  }  
  
  public String getTxtNomineeShare()
  {
    return txtNomineeShare;
  }

  public void setTxtNomineeShare(String newTxtNomineeShare)
  {
    txtNomineeShare = newTxtNomineeShare;
  }  
 
// added by dushyant on 14-10-2010 

    public String getTxtGratuityId()
    {
        return txtGratuityId;
    }
    
    public void setTxtGratuityId(String newTxtGratuityId)
    {
        txtGratuityId = newTxtGratuityId;
    } 

   public String getTxtGratuityName()
    {
        return txtGratuityName;
    }
    
    public void setTxtGratuityName(String newTxtGratuityName)
    {
        txtGratuityName = newTxtGratuityName;
    } 


 public String getTxtGratuityAge()
    {
        return txtGratuityAge;
    }
    
    public void setTxtGratuityAge(String newTxtGratuityAge)
    {
        txtGratuityAge = newTxtGratuityAge;
    }


   public String getTxtGratuityRel()
    {
        return txtGratuityRel;
    }
    
    public void setTxtGratuityRel(String newTxtGratuityRel)
    {
        txtGratuityRel = newTxtGratuityRel;
    } 
    
  public String getTxtGratuityShare()
    {
      return txtGratuityShare;
    }
    
   public void setTxtGratuityShare(String newTxtGratuityShare)
    {
      txtGratuityShare = newTxtGratuityShare;
    } 
    
  public String getTxtGratGuardian()
    {
      return txtGratGuardian;
    }
    
   public void setTxtGratGuardian(String newTxtGratGuardian)
    {
      txtGratGuardian = newTxtGratGuardian;
    }  
    
  public String getTxtDepndntGuard()
    {
      return txtDepndntGuard;
    }
    
   public void setTxtDepndntGuard(String newTxtDepndntGuard)
    {
      txtDepndntGuard = newTxtDepndntGuard;
    }  

}