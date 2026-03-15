
package FCIPAY.Payroll.UTILITY;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
import java.io.Serializable;




public class MaintCCARatesCdaBean  extends PayrollBaseDetailBean implements Serializable
{

  private String txtCityA1="";
  private String txtCityA="";
  private String txtCityB1="";
  private String txtCityB2="";
  private String txtCityC="";
  private String txtAmtFrom="";
  private String txtAmtTo="";
  private String txtSrlNo;
  private String lstPayScaleType;
  private String txtEffDate;
  
  public MaintCCARatesCdaBean()
  {
  }

  
 public MaintCCARatesCdaBean(String amtfrom,String amtto,String citya1,String citya,String cityb1,String cityb2,String cityc)
  {

      txtAmtFrom=amtfrom;
      txtAmtTo=amtto;
      txtCityA1=citya1;
      txtCityA=citya;
      txtCityB1=cityb1;
      txtCityB2=cityb2;
      txtCityC=cityc;
  
  }






  public String getTxtCityA1()
  {
    return txtCityA1;
  }

  public void setTxtCityA1(String newTxtCityA1)
  {
    txtCityA1 = newTxtCityA1;
  }

  public String getTxtCityA()
  {
    return txtCityA;
  }

  public void setTxtCityA(String newTxtCityA)
  {
    txtCityA = newTxtCityA;
  }

  public String getTxtCityB1()
  {
    return txtCityB1;
  }

  public void setTxtCityB1(String newTxtCityB1)
  {
    txtCityB1 = newTxtCityB1;
  }

  public String getTxtCityB2()
  {
    return txtCityB2;
  }

  public void setTxtCityB2(String newTxtCityB2)
  {
    txtCityB2 = newTxtCityB2;
  }

  public String getTxtCityC()
  {
    return txtCityC;
  }

  public void setTxtCityC(String newTxtCityC)
  {
    txtCityC = newTxtCityC;
  }

  
  public String getTxtAmtFrom()
  {
    return txtAmtFrom;
  }

  public void setTxtAmtFrom(String newTxtAmtFrom)
  {
    txtAmtFrom = newTxtAmtFrom;
  }

  public String getTxtAmtTo()
  {
    return txtAmtTo;
  }

  public void setTxtAmtTo(String newTxtAmtTo)
  {
    txtAmtTo = newTxtAmtTo;
  }

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getLstPayScaleType()
  {
    return lstPayScaleType;
  }

  public void setLstPayScaleType(String newLstPayScaleType)
  {
    lstPayScaleType = newLstPayScaleType;
  }

  public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }

 
 



}