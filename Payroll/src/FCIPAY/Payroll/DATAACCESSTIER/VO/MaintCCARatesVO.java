package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;


public class MaintCCARatesVO  implements Serializable 
{

  private String txtCityA1[]=null;
  private String txtCityA[]=null;
  private String txtCityB1[]=null;
  private String txtCityB2[]=null;
  private String txtCityC[]=null;
  private String hdnCheck[]=null;
  private String action;
  private long txtTest=0;
  private String optVal;
  private ArrayList lstIdaInstrDtls = new ArrayList();
  private String optPayScaleType;
  private String txtAmtFrom[]=null;
  private String txtAmtTo[]=null;
  private ArrayList tempArr =  new ArrayList();
  private String hdnSrlNo[]=null;
  private ArrayList rdoArrList =  new ArrayList();
  private long lEmpNo=0;
  private long lLocCode=0;

  public MaintCCARatesVO()
  {
  }


  public String[] getTxtCityA1()
  {
    return txtCityA1;
  }

  public void setTxtCityA1(String[] newTxtCityA1)
  {
    txtCityA1 = newTxtCityA1;
  }

  public String[] getTxtCityA()
  {
    return txtCityA;
  }

  public void setTxtCityA(String[] newTxtCityA)
  {
    txtCityA = newTxtCityA;
  }

  public String[] getTxtCityB1()
  {
    return txtCityB1;
  }

  public void setTxtCityB1(String[] newTxtCityB1)
  {
    txtCityB1 = newTxtCityB1;
  }

  public String[] getTxtCityB2()
  {
    return txtCityB2;
  }

  public void setTxtCityB2(String[] newTxtCityB2)
  {
    txtCityB2 = newTxtCityB2;
  }

  public String[] getTxtCityC()
  {
    return txtCityC;
  }

  public void setTxtCityC(String[] newTxtCityC)
  {
    txtCityC = newTxtCityC;
  }

  public String[] getHdnCheck()
  {
    return hdnCheck;
  }

  public void setHdnCheck(String[] newHdnCheck)
  {
    hdnCheck = newHdnCheck;
  }

  public String getAction()
  {
    return action;
  }

  public void setAction(String newAction)
  {
    action = newAction;
  }



  public long getTxtTest()
  {
    return txtTest;
  }

  public void setTxtTest(long newTxtTest)
  {
    txtTest = newTxtTest;
  }

  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
  }



  public ArrayList getLstIdaInstrDtls()
  {
    return lstIdaInstrDtls;
  }

  public void setLstIdaInstrDtls(ArrayList newLstIdaInstrDtls)
  {
    lstIdaInstrDtls = newLstIdaInstrDtls;
  }

  public String getOptPayScaleType()
  {
    return optPayScaleType;
  }

  public void setOptPayScaleType(String newOptPayScaleType)
  {
    optPayScaleType = newOptPayScaleType;
  }

  public String[] getTxtAmtFrom()
  {
    return txtAmtFrom;
  }

  public void setTxtAmtFrom(String[] newTxtAmtFrom)
  {
    txtAmtFrom = newTxtAmtFrom;
  }

  public String[] getTxtAmtTo()
  {
    return txtAmtTo;
  }

  public void setTxtAmtTo(String[] newTxtAmtTo)
  {
    txtAmtTo = newTxtAmtTo;
  }

  public ArrayList getTempArr()
  {
    return tempArr;
  }

  public void setTempArr(ArrayList newTempArr)
  {
    tempArr = newTempArr;
  }

  public String[] getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String[] newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }

  public ArrayList getRdoArrList()
  {
    return rdoArrList;
  }

  public void setRdoArrList(ArrayList newRdoArrList)
  {
    rdoArrList = newRdoArrList;
  }

  public long getLEmpNo()
  {
    return lEmpNo;
  }

  public void setLEmpNo(long newLEmpNo)
  {
    lEmpNo = newLEmpNo;
  }

  public long getLLocCode()
  {
    return lLocCode;
  }

  public void setLLocCode(long newLLocCode)
  {
    lLocCode = newLLocCode;
  }





  
}