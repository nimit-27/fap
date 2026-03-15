package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
public class MaintCategoryLocationBean extends PayrollBaseDetailBean implements Serializable
{

 public String txtEmpCategory="";
  public String txtPayScaleType="";
  public String  txtLocationType="";
 public String  txtDepotType="";
    public String  txtScheme="";
     public String  txtSchemeDesc="";
    
  public MaintCategoryLocationBean()
  {
  }
  
    public String getTxtEmpCategory()
  {
    return txtEmpCategory;
  }
  
  public void setTxtEmpCategory(String newTxtEmpCategory)
  {
    txtEmpCategory = newTxtEmpCategory;
  }
  
      public String getTxtPayScaleType()
  {
    return txtPayScaleType;
  }
  
  public void setTxtPayScaleType(String newTxtPayScaleType)
  {
    txtPayScaleType = newTxtPayScaleType;
  }
 
    public String getTxtLocationType()
  {
    return txtLocationType;
  }
  
  public void setTxtLocationType(String newTxtLocationType)
  {
    txtLocationType = newTxtLocationType;
  } 
  
     public String getTxtDepotType()
  {
    return txtDepotType;
  }
  
  public void setTxtDepotType(String newTxtDepotType)
  {
    txtDepotType = newTxtDepotType;
  }
  
   public String getTxtScheme()
  {
    return txtScheme;
  }
  
  public void setTxtScheme(String newTxtScheme)
  {
    txtScheme = newTxtScheme;
  } 
  
    public String getTxtSchemeDesc()
  {
    return txtSchemeDesc;
  }
  
  public void setTxtSchemeDesc(String newTxtSchemeDesc)
  {
    txtSchemeDesc = newTxtSchemeDesc;
  } 
}

