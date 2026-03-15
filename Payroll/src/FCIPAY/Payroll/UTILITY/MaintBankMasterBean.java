package FCIPAY.Payroll.UTILITY;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
import java.io.Serializable;

public class MaintBankMasterBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtBranchCode="";
  private String txtBranchName="";
  private String txtAddress1="";
  private String txtAddress2="";
  
  private String txtAddress3="";
  private String txtMicrNO;
  private String txtPinCode;
  private String txtCity;
  private String txtState;
  public MaintBankMasterBean()
  {
  }


  public MaintBankMasterBean(String BranchCode, String BranchName, String Address1, String Address2,String Address3)
  {
        txtBranchCode = BranchCode;
        txtBranchName = BranchName;
        txtAddress1 = Address1;
        txtAddress2 = Address2;
        txtAddress3 = Address3;
  }


  public String getTxtBranchCode()
  {
    return txtBranchCode;
  }

  public void setTxtBranchCode(String newTxtBranchCode)
  {
    txtBranchCode = newTxtBranchCode;
  }

  public String getTxtBranchName()
  {
    return txtBranchName;
  }

  public void setTxtBranchName(String newTxtBranchName)
  {
    txtBranchName = newTxtBranchName;
  }

  public String getTxtAddress1()
  {
    return txtAddress1;
  }

  public void setTxtAddress1(String newTxtAddress1)
  {
    txtAddress1 = newTxtAddress1;
  }

  public String getTxtAddress2()
  {
    return txtAddress2;
  }

  public void setTxtAddress2(String newTxtAddress2)
  {
    txtAddress2 = newTxtAddress2;
  }

  public String getTxtAddress3()
  {
    return txtAddress3;
  }

  public void setTxtAddress3(String newTxtAddress3)
  {
    txtAddress3 = newTxtAddress3;
  }

  public String getTxtMicrNO()
  {
    return txtMicrNO;
  }

  public void setTxtMicrNO(String newTxtMicrNO)
  {
    txtMicrNO = newTxtMicrNO;
  }

  public String getTxtPinCode()
  {
    return txtPinCode;
  }

  public void setTxtPinCode(String newTxtPinCode)
  {
    txtPinCode = newTxtPinCode;
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