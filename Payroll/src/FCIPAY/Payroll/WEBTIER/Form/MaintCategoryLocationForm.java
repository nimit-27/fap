package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import java.lang.String;
public class MaintCategoryLocationForm extends PayrollBaseForm
{

 private ArrayList categorylocationmap = new ArrayList();
  private String[] txtEmpCategory;
  private String[] txtPayScaleType;
  private String[]  txtLocationType;
  private String[]  txtDepotType;
    private String[]  txtScheme;
   private String[]  txtSchemeDesc; 
   
    public String[] getTxtEmpCategory()
  {
    return txtEmpCategory;
  }
  
  public void setTxtEmpCategory(String[] newTxtEmpCategory)
  {
    txtEmpCategory = newTxtEmpCategory;
  }
  
      public String[] getTxtPayScaleType()
  {
    return txtPayScaleType;
  }
  
  public void setTxtPayScaleType(String[] newTxtPayScaleType)
  {
    txtPayScaleType = newTxtPayScaleType;
  }
 
    public String[] getTxtLocationType()
  {
    return txtLocationType;
  }
  
  public void setTxtLocationType(String[] newTxtLocationType)
  {
    txtLocationType = newTxtLocationType;
  } 
  
     public String[] getTxtDepotType()
  {
    return txtDepotType;
  }
  
  public void setTxtDepotType(String[] newTxtDepotType)
  {
    txtDepotType = newTxtDepotType;
  }
  
   public String[] getTxtScheme()
  {
    return txtScheme;
  }
  
  public void setTxtScheme(String[] newTxtScheme)
  {
    txtScheme = newTxtScheme;
  } 
   
     public String[] getTxtSchemeDesc()
  {
    return txtSchemeDesc;
  }
  
  public void setTxtSchemeDesc(String[] newTxtSchemeDesc)
  {
    txtSchemeDesc = newTxtSchemeDesc;
  } 
  public ArrayList getCategorylocationmap()
  {
    return categorylocationmap;
  }
  
  public void setCategorylocationmap(ArrayList newCategorylocationmap)
  {
    categorylocationmap=newCategorylocationmap;
  }
  
}