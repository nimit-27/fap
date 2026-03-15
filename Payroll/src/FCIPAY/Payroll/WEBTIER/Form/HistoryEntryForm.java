package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class HistoryEntryForm extends PayrollBaseForm
{
  private String formMode;
  private String hdnRecordPos;
  private String action="";
  private String hdnCheck[]=null;
  private String txtEmpNo;
  private String hdnPosition;
  private String hdrGoto;
  private String txtEmpName;
  private boolean flag = false;
  private String txtYYMM;
  private String txtPayCode[];
  private String txtDescription[];
  private String txtPayMode[];
  private String txtAmount[];
  private ArrayList lstInstrDtls = new ArrayList();
  private String screenModeHist;
  private String hdnAction;
  private String screenModePay1;
  private String txtUnitID[];
  private String txtPaymentDate[];
  private String hdnSrlNo[];
  private String hdnPayCode;
  private String hdnPayCodeName;
  private String hdnRowVal;
    
 public HistoryEntryForm()
  {
  }











  public String getFormMode()
  {
    return formMode;
  }

  public void setFormMode(String newformMode)
  {
    formMode = newformMode;
  }

  public String getHdnRecordPos()
  {
    return hdnRecordPos;
  }

  public void setHdnRecordPos(String newhdnRecordPos)
  {
    hdnRecordPos = newhdnRecordPos;
  }



  public String getAction()
  {
    return action;
  }

  public void setAction(String newAction)
  {
    action = newAction;
  }

  public String[] getHdnCheck()
  {
    return hdnCheck;
  }

  public void setHdnCheck(String[] newHdnCheck)
  {
    hdnCheck = newHdnCheck;
  }



  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }







  public String getHdnPosition()
  {
    return hdnPosition;
  }

  public void setHdnPosition(String newHdnPosition)
  {
    hdnPosition = newHdnPosition;
  }

  public String getHdrGoto()
  {
    return hdrGoto;
  }

  public void setHdrGoto(String newHdrGoto)
  {
    hdrGoto = newHdrGoto;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public boolean isFlag()
  {
    return flag;
  }

  public void setFlag(boolean newFlag)
  {
    flag = newFlag;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String[] getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String[] newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String[] getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String[] newTxtDescription)
  {
    txtDescription = newTxtDescription;
  }

  public String[] getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String[] newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }

  public String[] getTxtAmount()
  {
    return txtAmount;
  }

  public void setTxtAmount(String[] newTxtAmount)
  {
    txtAmount = newTxtAmount;
  }

  
    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }

  public String getScreenModeHist()
  {
    return screenModeHist;
  }

  public void setScreenModeHist(String newScreenModeHist)
  {
    screenModeHist = newScreenModeHist;
  }

  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }







  public String getScreenModePay1()
  {
    return screenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    screenModePay1 = newScreenModePay1;
  }

  public String[] getTxtUnitID()
  {
    return txtUnitID;
  }

  public void setTxtUnitID(String[] newTxtUnitID)
  {
    txtUnitID = newTxtUnitID;
  }

  public String[] getTxtPaymentDate()
  {
    return txtPaymentDate;
  }

  public void setTxtPaymentDate(String[] newTxtPaymentDate)
  {
    txtPaymentDate = newTxtPaymentDate;
  }

  public String[] getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String[] newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }

  public String getHdnPayCode()
  {
    return hdnPayCode;
  }

  public void setHdnPayCode(String newHdnPayCode)
  {
    hdnPayCode = newHdnPayCode;
  }

  public String getHdnPayCodeName()
  {
    return hdnPayCodeName;
  }

  public void setHdnPayCodeName(String newHdnPayCodeName)
  {
    hdnPayCodeName = newHdnPayCodeName;
  }

  public String getHdnRowVal()
  {
    return hdnRowVal;
  }

  public void setHdnRowVal(String newHdnRowVal)
  {
    hdnRowVal = newHdnRowVal;
  }

}