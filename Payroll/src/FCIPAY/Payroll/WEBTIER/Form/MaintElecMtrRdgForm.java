package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintElecMtrRdgBean;

public class MaintElecMtrRdgForm extends PayrollBaseForm 
{
  private String txtSrlNo[]=null;
  private String txtInitialReading[]=null;
  private String txtFinalReading[]=null;
  private String txtInitialYearMonth[]=null;
  private String txtFinalYearMonth[]=null;
  private String formMode;
  private String hdnRecordPos;
  private String action="";
  private String hdnCheck[]=null;
  private String txtMtrNo;
  private String txtEmpNo;
  private String txtFreq;
  private long txtTest=0;
  private ArrayList lstInstrDtls=new ArrayList();
  private String hdnPosition;
  private String hdrGoto;
  private String txtEmpName;
  private boolean flag = false;
  public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {    
        this.lstInstrDtls.clear();
        this.txtTest = 0;        
        this.txtMtrNo="";
        this.txtEmpNo="";
        this.txtInitialReading=null;
        this.txtFinalReading=null;
        this.txtInitialYearMonth=null;
        this.txtFinalYearMonth=null;
        this.txtFreq="";
    }
  public MaintElecMtrRdgForm()
  {
  }

  public String[] getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String[] newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String[] getTxtInitialReading()
  {
    return txtInitialReading;
  }

  public void setTxtInitialReading(String[] newTxtInitialReading)
  {
    txtInitialReading = newTxtInitialReading;
  }

  public String[] getTxtFinalReading()
  {
    return txtFinalReading;
  }

  public void setTxtFinalReading(String[] newTxtFinalReading)
  {
    txtFinalReading = newTxtFinalReading;
  }

  public String[] getTxtInitialYearMonth()
  {
    return txtInitialYearMonth;
  }

  public void setTxtInitialYearMonth(String[] newTxtInitialYearMonth)
  {
    txtInitialYearMonth = newTxtInitialYearMonth;
  }

  public String[] getTxtFinalYearMonth()
  {
    return txtFinalYearMonth;
  }

  public void setTxtFinalYearMonth(String[] newTxtFinalYearMonth)
  {
    txtFinalYearMonth = newTxtFinalYearMonth;
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

  public String getTxtMtrNo()
  {
    return txtMtrNo;
  }

  public void setTxtMtrNo(String newTxtMtrNo)
  {
    txtMtrNo = newTxtMtrNo;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtFreq()
  {
    return txtFreq;
  }

  public void setTxtFreq(String newTxtFreq)
  {
    txtFreq = newTxtFreq;
  }

  public long getTxtTest()
  {
    return txtTest;
  }

  public void setTxtTest(long newTxtTest)
  {
    txtTest = newTxtTest;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
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
}