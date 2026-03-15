package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MaintBankMastForm extends PayrollBaseForm
{

  private String txtBankCode;
  private String txtBranchName[]=null;
  private String txtBranchCode[] = null;
  private String txtAddress1[] = null;
  private String txtBankName;
  private String txtAddress2[] = null;
  private String txtAddress3[] = null;
  private ArrayList lstInstrDtls = new ArrayList();
  private boolean flag = false;
  private String screenModePay1;
  private String txtPinCode[] = null;
  private String txtMicrNO[] = null;
  private String hdnBankDesc;
  private String txtCity;
  private String txtState;

  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }


   public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstInstrDtls.clear();
//        this.txtTest = 0;
   }

  public MaintBankMastForm()
  {
  }

  public String getTxtBankCode()
  {
    return txtBankCode;
  }

  public void setTxtBankCode(String newTxtBankCode)
  {
    txtBankCode = newTxtBankCode;
  }

  public String[] getTxtBranchName()
  {
    return txtBranchName;
  }

  public void setTxtBranchName(String[] newTxtBranchName)
  {
    txtBranchName = newTxtBranchName;
  }

  public String[] getTxtBranchCode()
  {
    return txtBranchCode;
  }

  public void setTxtBranchCode(String[] newTxtBranchCode)
  {
    txtBranchCode = newTxtBranchCode;
  }

  public String[] getTxtAddress1()
  {
    return txtAddress1;
  }

  public void setTxtAddress1(String[] newTxtAddress1)
  {
    txtAddress1 = newTxtAddress1;
  }

  public String getTxtBankName()
  {
    return txtBankName;
  }

  public void setTxtBankName(String newTxtBankName)
  {
    txtBankName = newTxtBankName;
  }

  public String[] getTxtAddress2()
  {
    return txtAddress2;
  }

  public void setTxtAddress2(String[] newTxtAddress2)
  {
    txtAddress2 = newTxtAddress2;
  }

  public String[] getTxtAddress3()
  {
    return txtAddress3;
  }

  public void setTxtAddress3(String[] newTxtAddress3)
  {
    txtAddress3 = newTxtAddress3;
  }

    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }

  public boolean isFlag()
  {
    return flag;
  }

  public void setFlag(boolean newFlag)
  {
    flag = newFlag;
  }

  public String getScreenModePay1()
  {
    return screenModePay1;
  }

  public void setScreenModePay1(String newScreenModePay1)
  {
    screenModePay1 = newScreenModePay1;
  }

  public String[] getTxtPinCode()
  {
    return txtPinCode;
  }

  public void setTxtPinCode(String[] newTxtPinCode)
  {
    txtPinCode = newTxtPinCode;
  }

  public String[] getTxtMicrNO()
  {
    return txtMicrNO;
  }

  public void setTxtMicrNO(String[] newTxtMicrNO)
  {
    txtMicrNO = newTxtMicrNO;
  }

  public String getHdnBankDesc()
  {
    return hdnBankDesc;
  }

  public void setHdnBankDesc(String newHdnBankDesc)
  {
    hdnBankDesc = newHdnBankDesc;
  }
  
  public String getTxtCity()
  {
    return txtCity;
  }

  public void setTxtCity(String newTxtCity)
  {
    txtCity = newTxtCity;
  }
  
  public String getTxtState()
  {
    return txtState;
  }

  public void setTxtState(String newTxtState)
  {
    txtState = newTxtState;
  }

  
}