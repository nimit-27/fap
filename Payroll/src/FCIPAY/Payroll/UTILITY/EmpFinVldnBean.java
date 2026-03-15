package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class EmpFinVldnBean implements Serializable
{
  private String strVldnKey;
  private String strAllow;
  private String strPayCode;
  private String strPayScaleTyp;
  private String strCtgry;
  private String strDsgnId;
  private String strEmpStatus;
  private String strFlag;
  
  public String getStrVldnKey ()
  {
    return strVldnKey;
  }

  public void setStrVldnKey (String newStrVldnKey)
  {
    strVldnKey=newStrVldnKey;
  }

  public String getStrAllow ()
  {
    return strAllow;
  }

  public void setStrAllow (String newStrAllow)
  {
    strAllow=newStrAllow;
  }

  public String getStrPayCode ()
  {
    return strPayCode;
  }

  public void setStrPayCode (String newStrPayCode)
  {
    strPayCode=newStrPayCode;
  }

  public String getStrPayScaleTyp ()
  {
    return strPayScaleTyp;
  }

  public void setStrPayScaleTyp (String newStrPayScaleTyp)
  {
    strPayScaleTyp=newStrPayScaleTyp;
  }

  public String getStrCtgry ()
  {
    return strCtgry;
  }

  public void setStrCtgry (String newStrCtgry)
  {
    strCtgry=newStrCtgry;
  }

  public String getStrDsgnId ()
  {
    return strDsgnId;
  }

  public void setStrDsgnId (String newStrDsgnId)
  {
    strDsgnId=newStrDsgnId;
  }

  public String getStrEmpStatus ()
  {
    return strEmpStatus;
  }

  public void setStrEmpStatus (String newStrEmpStatus)
  {
    strEmpStatus=newStrEmpStatus;
  }

  public String getStrFlag ()
  {
    return strFlag;
  }

  public void setStrFlag (String newStrFlag)
  {
    strFlag=newStrFlag;
  }

}