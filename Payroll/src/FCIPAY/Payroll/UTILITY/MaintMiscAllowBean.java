package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class MaintMiscAllowBean  extends PayrollBaseDetailBean implements Serializable
{
  private String txtPayCode="";
  private String txtPayCodeDesc="";  
  private String txtRate="";
  private String txtEffEndDate="";
  private String txtEffDate="";
  private String txtPayScaleType="";
  private String txtCategory="";
  private String txtSrlNo="";
  private String txtPayScaleCode="";
  private String txtPayScaleRange="";

  public MaintMiscAllowBean()
  {
  }
  

  public MaintMiscAllowBean(String PayScaleType, String Category, String payCode, String sPayCodeDesc ,String rate,String effDate,String effEndDate)
  {
      txtPayScaleType=PayScaleType;
      txtCategory=Category;
      txtPayCode=payCode;
      txtPayCodeDesc = sPayCodeDesc;      
      txtRate=rate;
      txtEffDate=effDate;  
      txtEffEndDate=effEndDate;
  }

   public String getTxtPayScaleType()
  {
    return txtPayScaleType;
  }

  public void setTxtPayScaleType(String newTxtPayScaleType)
  {
    txtPayScaleType = newTxtPayScaleType;
  }
  
  public String getTxtCategory()
  {
    return txtCategory;
  }

  public void setTxtCategory(String newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String newTxtRate)
  {
    txtRate = newTxtRate;
  }

  public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }

  public String getTxtPayCodeDesc()
  {
    return txtPayCodeDesc;
  }

  public void setTxtPayCodeDesc(String newTxtPayCodeDesc)
  {
    txtPayCodeDesc = newTxtPayCodeDesc;
  }

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }
  
  public String getTxtEffEndDate()
  {
    return txtEffEndDate;
  }

  public void setTxtEffEndDate(String newTxtEffEndDate)
  {
    txtEffEndDate = newTxtEffEndDate;
  }
  
  public String getTxtPayScaleCode()
  {
    return txtPayScaleCode;
  }

  public void setTxtPayScaleCode(String newTxtPayScaleCode)
  {
    txtPayScaleCode = newTxtPayScaleCode;
  }

  public String getTxtPayScaleRange()
  {
    return txtPayScaleRange;
  }

  public void setTxtPayScaleRange(String newTxtPayScaleRange)
  {
    txtPayScaleRange = newTxtPayScaleRange;
  }
 
  
}