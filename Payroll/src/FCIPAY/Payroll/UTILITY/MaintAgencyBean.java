package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
public class MaintAgencyBean  extends PayrollBaseDetailBean implements Serializable
{
  private String txtAgeCode="";
  private String txtAgeName="";
  private String txtAdd="";
  private String txtMode="";
  private String txtFavour="";
  private String txtDraw="";
  private String txtSite="";
  

  public MaintAgencyBean()
  {
  }


 public MaintAgencyBean(String sAgeCode,String sAgeName,String sAdd,String sMode,String sFavour,String sDraw,String sSite)
  {

      txtAgeCode=sAgeCode;
      txtAgeName=sAgeName;
      txtAdd=sAdd;
      txtMode=sMode;
      txtFavour=sFavour;
      txtDraw=sDraw;
      txtSite=sSite;
      
  
  }

  

  public String getTxtAgeCode()
  {
    return txtAgeCode;
  }

  public void setTxtAgeCode(String newTxtAgeCode)
  {
    txtAgeCode = newTxtAgeCode;
  }

  public String getTxtAgeName()
  {
    return txtAgeName;
  }

  public void setTxtAgeName(String newTxtAgeName)
  {
    txtAgeName = newTxtAgeName;
  }

  public String getTxtAdd()
  {
    return txtAdd;
  }

  public void setTxtAdd(String newTxtAdd)
  {
    txtAdd = newTxtAdd;
  }

  public String getTxtMode()
  {
    return txtMode;
  }

  public void setTxtMode(String newTxtMode)
  {
    txtMode = newTxtMode;
  }

  public String getTxtFavour()
  {
    return txtFavour;
  }

  public void setTxtFavour(String newTxtFavour)
  {
    txtFavour = newTxtFavour;
  }

  public String getTxtDraw()
  {
    return txtDraw;
  }

  public void setTxtDraw(String newTxtDraw)
  {
    txtDraw = newTxtDraw;
  }

  public String getTxtSite()
  {
    return txtSite;
  }

  public void setTxtSite(String newTxtSite)
  {
    txtSite = newTxtSite;
  }



  


}