package FCIPAY.Payroll.WEBTIER.Form;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MaintSCARateForm extends PayrollBaseForm 
{
    
  private ArrayList lstInstrDtls=new ArrayList();
  
  private String txtSCAAmt[];
  private String txtTypeofCity[];
  private String txtType[];
  private String txtStartDt[];
  private String txtEndDt[];

  public String[] getTxtSCAAmt()
  {
    return txtSCAAmt;
  }

  public void setTxtSCAAmt(String[] newTxtSCAAmt)
  {
    txtSCAAmt = newTxtSCAAmt;
  }

  public String[] getTxtTypeofCity()
  {
    return txtTypeofCity;
  }

  public void setTxtTypeofCity(String[] newTxtTypeofCity)
  {
    txtTypeofCity = newTxtTypeofCity;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public String[] getTxtType()
  {
    return txtType;
  }

  public void setTxtType(String[] newTxtType)
  {
    txtType = newTxtType;
  }

  public String[] getTxtStartDt()
  {
    return txtStartDt;
  }

  public void setTxtStartDt(String[] newTxtStartDt)
  {
    txtStartDt = newTxtStartDt;
  }

  public String[] getTxtEndDt()
  {
    return txtEndDt;
  }

  public void setTxtEndDt(String[] newTxtEndDt)
  {
    txtEndDt = newTxtEndDt;
  }

}