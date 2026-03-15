   /*
    * Module:        MaintCCARatesForm.java
    * Author:        Manali & Arup
    * Date Written:  February,11 2005
    * Description:   Action Form for FE Release Details
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintCCARatesBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintCCARatesVO;

public class MaintCCARatesForm extends PayrollBaseForm 
{
  private long txtTest=0;
  private String hdnCheck[]=null;
  private String action;
  private String txtAmtFrom[]=null;
  private String txtAmtTo[]=null;
  private String optVal;
  private ArrayList lstIdaInstrDtls = new ArrayList();
  private String hdnSrlNo[]=null;
  MaintCCARatesVO fedoVO = new MaintCCARatesVO();
  private String optPayScaleType;
  private String txtUnclassified;
  private ArrayList lstIdaInstrDtlsCDA = new ArrayList();
  private ArrayList lstIdaInstrDtlsIDA = new ArrayList();
  private String txtSrlNo[]=null;
  private String txtAllow[]=null;
  private String screenModeAll;
  private String screenModeCDA;
  private String screenModeIDA;
  private String txtCity;
  private boolean flagCda=false;
  private boolean flagIda=false;
  private boolean flagAll=false;
  private String txtStartDate[]=null;
  private String txtEndDate[]=null;
  private String txtCtgry[];
  private String txtEffDt;

    public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstIdaInstrDtls.clear();
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

  public long getTxtTest()
  {
    return txtTest;
  }

  public void setTxtTest(long newTxtTest)
  {
    txtTest = newTxtTest;
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

  public String[] getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String[] newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }

  public void setVO()
  {       
        fedoVO.setLstIdaInstrDtls(this.lstIdaInstrDtls);
  }

  public void setVO(ArrayList tempArr)
  {             
        fedoVO.setTempArr(tempArr);  
        fedoVO.setLstIdaInstrDtls(this.lstIdaInstrDtls);        
  }


  public MaintCCARatesVO getVO()
  {
        return fedoVO;
  }  

  public String getOptPayScaleType()
  {
    return optPayScaleType;
  }

  public void setOptPayScaleType(String newOptPayScaleType)
  {
    optPayScaleType = newOptPayScaleType;
  }

  public String getTxtUnclassified()
  {
    return txtUnclassified;
  }

  public void setTxtUnclassified(String newTxtUnclassified)
  {
    txtUnclassified = newTxtUnclassified;
  }

  public ArrayList getLstIdaInstrDtlsCDA()
  {
    return lstIdaInstrDtlsCDA;
  }

  public void setLstIdaInstrDtlsCDA(ArrayList newLstIdaInstrDtlsCDA)
  {
    lstIdaInstrDtlsCDA = newLstIdaInstrDtlsCDA;
  }

  public ArrayList getLstIdaInstrDtlsIDA()
  {
    return lstIdaInstrDtlsIDA;
  }

  public void setLstIdaInstrDtlsIDA(ArrayList newLstIdaInstrDtlsIDA)
  {
    lstIdaInstrDtlsIDA = newLstIdaInstrDtlsIDA;
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
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

  public String getTxtCity()
  {
    return txtCity;
  }

  public void setTxtCity(String newTxtCity)
  {
    txtCity = newTxtCity;
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

  public String[] getTxtStartDate()
  {
    return txtStartDate;
  }

  public void setTxtStartDate(String[] newTxtStartDate)
  {
    txtStartDate = newTxtStartDate;
  }

  public String[] getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String[] newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  }

  public String[] getTxtCtgry()
  {
    return txtCtgry;
  }

  public void setTxtCtgry(String[] newTxtCtgry)
  {
    txtCtgry = newTxtCtgry;
  }

  public String getTxtEffDt()
  {
    return txtEffDt;
  }

  public void setTxtEffDt(String newTxtEffDt)
  {
    txtEffDt = newTxtEffDt;
  }


}