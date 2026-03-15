package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class GenDAArrearQueryVO extends PayrollBaseQueryVO implements Serializable 
{
  private String txtPayYYMM;
  private String txtDAType;
  private String screenName;
  
  public GenDAArrearQueryVO()
  {
  }

  public String getTxtPayYYMM()
  {
    return txtPayYYMM;
  }

  public void setTxtPayYYMM(String newTxtPayYYMM)
  {
    txtPayYYMM = newTxtPayYYMM;
  }

  public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  }

  public String getScreenName()
  {
    return screenName;
  }

  public void setscreenName(String newScreenName)
  {
    screenName = newScreenName;
  }  

 
}