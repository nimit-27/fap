package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintConvAllowBean;
//import IBA.Payroll.UTILITY.MaintConvParamBean1;
//import IBA.Payroll.DATAACCESSTIER.VO.MaintConvParamVO;


public class MaintConvParamForm extends PayrollBaseForm 
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
  private String buttVal;
  private ArrayList lstIdaInstrDtls = new ArrayList();
  private String optPayScaleType;
  private String txtCadre1[]=null;
  private String txtCatEmp1[]=null;
  private String txtMaxNDJA[]=null;
  private String txtRecAmt[]=null;
  private String hdnCheck1[]=null;
  private ArrayList lstCarInstrDtls = new ArrayList();
  private String txtAmtFrom[]=null;
  private String txtAmtTo[]=null;

  //  MaintConvParamVO fedoVO = new MaintConvParamVO();
  private String hdnSrlNo[]=null;
  private String hdnSrlNo1[]=null;
  private ArrayList lstCategValues = new ArrayList();
  private ArrayList lstCategLabels = new ArrayList();
  private ArrayList lstCatreValues = new ArrayList();
  private ArrayList lstCatreLabels = new ArrayList();
  private ArrayList lstInstrDtls= new ArrayList();
  private String txtSrlNo[]=null;
  private ArrayList lstInstrDtlsCDA= new ArrayList();
  private ArrayList lstInstrDtlsIDA= new ArrayList();
  private ArrayList lstInstrDtlsRall= new ArrayList();
  private ArrayList lstInstrDtlsRcda= new ArrayList();
  private ArrayList lstInstrDtlsRida= new ArrayList();
  private String txtCity[]=null;
  private String txtAllow[]=null;
  private String screenModeAll;
  private String screenModeCDA;
  private String screenModeIDA;

  private boolean flagCda=false;
  private boolean flagIda=false;
  private boolean flagAll=false;
  private String txtPayScale[] = null;
  private String txtEffectDate;
  private String payScaleType;
  private String txtCategory[]=null;
  private String txtHandicap[]=null;
  private String screenModeAll1;
  private String screenModeConvAllow;
  private String headerClick;


  /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
    public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstIdaInstrDtls.clear();
        this.lstCarInstrDtls.clear();
        this.txtTest = 0;
   }

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
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

  public String getButtVal()
  {
    return buttVal;
  }

  public void setButtVal(String newButtVal)
  {
    buttVal = newButtVal;
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

  public String[] getTxtCadre1()
  {
    return txtCadre1;
  }

  public void setTxtCadre1(String[] newTxtCadre1)
  {
    txtCadre1 = newTxtCadre1;
  }

  public String[] getTxtCatEmp1()
  {
    return txtCatEmp1;
  }

  public void setTxtCatEmp1(String[] newTxtCatEmp1)
  {
    txtCatEmp1 = newTxtCatEmp1;
  }

  public String[] getTxtMaxNDJA()
  {
    return txtMaxNDJA;
  }

  public void setTxtMaxNDJA(String[] newTxtMaxNDJA)
  {
    txtMaxNDJA = newTxtMaxNDJA;
  }

  public String[] getTxtRecAmt()
  {
    return txtRecAmt;
  }

  public void setTxtRecAmt(String[] newTxtRecAmt)
  {
    txtRecAmt = newTxtRecAmt;
  }

  public String[] getHdnCheck1()
  {
    return hdnCheck1;
  }

  public void setHdnCheck1(String[] newHdnCheck1)
  {
    hdnCheck1 = newHdnCheck1;
  }

  public ArrayList getLstCarInstrDtls()
  {
    return lstCarInstrDtls;
  }

  public void setLstCarInstrDtls(ArrayList newLstCarInstrDtls)
  {
    lstCarInstrDtls = newLstCarInstrDtls;
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


 
  


 
  public String[] getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String[] newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }

  public String[] getHdnSrlNo1()
  {
    return hdnSrlNo1;
  }

  public void setHdnSrlNo1(String[] newHdnSrlNo1)
  {
    hdnSrlNo1 = newHdnSrlNo1;
  }





  public ArrayList getLstCategValues()
  {
    return lstCategValues;
  }

  public void setLstCategValues(ArrayList newLstCategValues)
  {
    lstCategValues = newLstCategValues;
  }

  public ArrayList getLstCategLabels()
  {
    return lstCategLabels;
  }

  public void setLstCategLabels(ArrayList newLstCategLabels)
  {
    lstCategLabels = newLstCategLabels;
  }

  public ArrayList getLstCatreValues()
  {
    return lstCatreValues;
  }

  public void setLstCatreValues(ArrayList newLstCatreValues)
  {
    lstCatreValues = newLstCatreValues;
  }

  public ArrayList getLstCatreLabels()
  {
    return lstCatreLabels;
  }

  public void setLstCatreLabels(ArrayList newLstCatreLabels)
  {
    lstCatreLabels = newLstCatreLabels;
  }



  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public ArrayList getLstInstrDtlsCDA()
  {
    return lstInstrDtlsCDA;
  }

  public void setLstInstrDtlsCDA(ArrayList newLstInstrDtlsCDA)
  {
    lstInstrDtlsCDA = newLstInstrDtlsCDA;
  }

  public ArrayList getLstInstrDtlsIDA()
  {
    return lstInstrDtlsIDA;
  }

  public void setLstInstrDtlsIDA(ArrayList newLstInstrDtlsIDA)
  {
    lstInstrDtlsIDA = newLstInstrDtlsIDA;
  }

  public ArrayList getLstInstrDtlsRall()
  {
    return lstInstrDtlsRall;
  }

  public void setLstInstrDtlsRall(ArrayList newLstInstrDtlsRall)
  {
    lstInstrDtlsRall = newLstInstrDtlsRall;
  }

  public ArrayList getLstInstrDtlsRcda()
  {
    return lstInstrDtlsRcda;
  }

  public void setLstInstrDtlsRcda(ArrayList newLstInstrDtlsRcda)
  {
    lstInstrDtlsRcda = newLstInstrDtlsRcda;
  }

  public ArrayList getLstInstrDtlsRida()
  {
    return lstInstrDtlsRida;
  }

  public void setLstInstrDtlsRida(ArrayList newLstInstrDtlsRida)
  {
    lstInstrDtlsRida = newLstInstrDtlsRida;
  }

  public String[] getTxtCity()
  {
    return txtCity;
  }

  public void setTxtCity(String[] newTxtCity)
  {
    txtCity = newTxtCity;
  }

  public String[] getTxtAllow()
  {
    return txtAllow;
  }

  public void setTxtAllow(String[] newTxtAllow)
  {
    txtAllow = newTxtAllow;
  }

  public String getScreenModeAll()
  {
    return screenModeAll;
  }

  public void setScreenModeAll(String newScreenModeAll)
  {
    screenModeAll = newScreenModeAll;
  }

  public String getScreenModeCDA()
  {
    return screenModeCDA;
  }

  public void setScreenModeCDA(String newScreenModeCDA)
  {
    screenModeCDA = newScreenModeCDA;
  }

  public String getScreenModeIDA()
  {
    return screenModeIDA;
  }

  public void setScreenModeIDA(String newScreenModeIDA)
  {
    screenModeIDA = newScreenModeIDA;
  }




  public boolean isFlagCda()
  {
    return flagCda;
  }

  public void setFlagCda(boolean newFlagCda)
  {
    flagCda = newFlagCda;
  }

  public boolean isFlagIda()
  {
    return flagIda;
  }

  public void setFlagIda(boolean newFlagIda)
  {
    flagIda = newFlagIda;
  }

  public boolean isFlagAll()
  {
    return flagAll;
  }

  public void setFlagAll(boolean newFlagAll)
  {
    flagAll = newFlagAll;
  }

  public String[] getTxtPayScale()
  {
    return txtPayScale;
  }

  public void setTxtPayScale(String[] newTxtPayScale)
  {
    txtPayScale = newTxtPayScale;
  }
  
  public String[] getTxtCategory()
  {
    return txtCategory;
  }

  public void setTxtCategory(String[] newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }
  
   public String[] getTxtHandicap()
  {
    return txtHandicap;
  }

  public void setTxtHandicap(String[] newTxtHandicap)
  {
    txtHandicap = newTxtHandicap;
  }

  public String getTxtEffectDate()
  {
    return txtEffectDate;
  }

  public void setTxtEffectDate(String newTxtEffectDate)
  {
    txtEffectDate = newTxtEffectDate;
  }

  public String getPayScaleType()
  {
    return payScaleType;
  }

  public void setPayScaleType(String newPayScaleType)
  {
    payScaleType = newPayScaleType;
  }

  public String getScreenModeAll1()
  {
    return screenModeAll1;
  }

  public void setScreenModeAll1(String newScreenModeAll1)
  {
    screenModeAll1 = newScreenModeAll1;
  }

  public String getScreenModeConvAllow()
  {
    return screenModeConvAllow;
  }

  public void setScreenModeConvAllow(String newScreenModeConvAllow)
  {
    screenModeConvAllow = newScreenModeConvAllow;
  }

  public String getHeaderClick()
  {
    return headerClick;
  }

  public void setHeaderClick(String newHeaderClick)
  {
    headerClick = newHeaderClick;
  }
  
}