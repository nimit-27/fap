package FCIPAY.Payroll.UTILITY;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
import java.io.Serializable;

public class EmpNomineeBean  extends PayrollBaseDetailBean implements Serializable
{ 
  private String txtNomineeId="";
  private String txtNomineeName="";
  private String txtNomineeAge="";
  private String txtNomineeRel=""; 
  private String txtNomineeShare=""; 
  
  public EmpNomineeBean()
  {
  }
  
 public EmpNomineeBean(String NomineeId, String NomineeNam,String NomineeAge,String NomineeRel,String NomineeShare)
  {
      txtNomineeId = NomineeId;
      txtNomineeName=NomineeNam;
      txtNomineeAge=NomineeAge;
      txtNomineeRel = NomineeRel;
      txtNomineeShare = NomineeShare;
  }

   public String getTxtNomineeId()
  {
    return txtNomineeId;
  }

  public void setTxtNomineeId(String newTxtNomineeId)
  {
    txtNomineeId = newTxtNomineeId;
  }

   public String getTxtNomineeName()
  {
    return txtNomineeName;
  }

  public void setTxtNomineeName(String newTxtNomineeName)
  {
    txtNomineeName = newTxtNomineeName;
  }

  public String getTxtNomineeAge()
  {
    return txtNomineeAge;
  }

  public void setTxtNomineeAge(String newTxtNomineeAge)
  {
    txtNomineeAge = newTxtNomineeAge;
  }

  public String getTxtNomineeRel()
  {
    return txtNomineeRel;
  }

  public void setTxtNomineeRel(String newTxtNomineeRel)
  {
    txtNomineeRel = newTxtNomineeRel;
  }  
  
  public String getTxtNomineeShare()
  {
    return txtNomineeShare;
  }

  public void setTxtNomineeShare(String newTxtNomineeShare)
  {
    txtNomineeShare = newTxtNomineeShare;
  }  
}