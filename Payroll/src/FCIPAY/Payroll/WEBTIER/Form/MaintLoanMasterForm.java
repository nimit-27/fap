package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MaintLoanMasterForm extends PayrollBaseForm
{
  private String txtEmpNo;
  private String txtLoanType;
  private String txtSanctionDate;
  private String txtLoanAmount;
  private String txtInstAmt;
  private String txtRecoverYYMM;
  private String txtBalNoofInstall;
  private String txtPaidInstall;
  private String txtAmtPaid;
  private String txtExistLoanBal;
  private String txtIntAmount;
  private String txtIntAmountFinYear;
  private String txtBalIntAmount;
  private String txtLoanOpBal;
  private String txtLoanStatus;
  private String buttxtSanctionDate;
  private String buttxtLoanType;
  private String buttxtEmpNo;
  private String txtEmpName;
  private String txtLoan;

  public MaintLoanMasterForm()
  {
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtLoanType()
  {
    return txtLoanType;
  }

  public void setTxtLoanType(String newTxtLoanType)
  {
    txtLoanType = newTxtLoanType;
  }

  public String getTxtSanctionDate()
  {
    return txtSanctionDate;
  }

  public void setTxtSanctionDate(String newTxtSanctionDate)
  {
    txtSanctionDate = newTxtSanctionDate;
  }

  public String getTxtLoanAmount()
  {
    return txtLoanAmount;
  }

  public void setTxtLoanAmount(String newTxtLoanAmount)
  {
    txtLoanAmount = newTxtLoanAmount;
  }

  public String getTxtInstAmt()
  {
    return txtInstAmt;
  }

  public void setTxtInstAmt(String newTxtInstAmt)
  {
    txtInstAmt = newTxtInstAmt;
  }

  public String getTxtRecoverYYMM()
  {
    return txtRecoverYYMM;
  }

  public void setTxtRecoverYYMM(String newTxtRecoverYYMM)
  {
    txtRecoverYYMM = newTxtRecoverYYMM;
  }

  public String getTxtBalNoofInstall()
  {
    return txtBalNoofInstall;
  }

  public void setTxtBalNoofInstall(String newTxtBalNoofInstall)
  {
    txtBalNoofInstall = newTxtBalNoofInstall;
  }

  public String getTxtPaidInstall()
  {
    return txtPaidInstall;
  }

  public void setTxtPaidInstall(String newTxtPaidInstall)
  {
    txtPaidInstall = newTxtPaidInstall;
  }

  public String getTxtAmtPaid()
  {
    return txtAmtPaid;
  }

  public void setTxtAmtPaid(String newTxtAmtPaid)
  {
    txtAmtPaid = newTxtAmtPaid;
  }

  public String getTxtExistLoanBal()
  {
    return txtExistLoanBal;
  }

  public void setTxtExistLoanBal(String newTxtExistLoanBal)
  {
    txtExistLoanBal = newTxtExistLoanBal;
  }

  public String getTxtIntAmount()
  {
    return txtIntAmount;
  }

  public void setTxtIntAmount(String newTxtIntAmount)
  {
    txtIntAmount = newTxtIntAmount;
  }

  public String getTxtIntAmountFinYear()
  {
    return txtIntAmountFinYear;
  }

  public void setTxtIntAmountFinYear(String newTxtIntAmountFinYear)
  {
    txtIntAmountFinYear = newTxtIntAmountFinYear;
  }

  public String getTxtBalIntAmount()
  {
    return txtBalIntAmount;
  }

  public void setTxtBalIntAmount(String newTxtBalIntAmount)
  {
    txtBalIntAmount = newTxtBalIntAmount;
  }

  public String getTxtLoanOpBal()
  {
    return txtLoanOpBal;
  }

  public void setTxtLoanOpBal(String newTxtLoanOpBal)
  {
    txtLoanOpBal = newTxtLoanOpBal;
  }

  public String getTxtLoanStatus()
  {
    return txtLoanStatus;
  }

  public void setTxtLoanStatus(String newTxtLoanStatus)
  {
    txtLoanStatus = newTxtLoanStatus;
  }

  public String getButtxtSanctionDate()
  {
    return buttxtSanctionDate;
  }

  public void setButtxtSanctionDate(String newButtxtSanctionDate)
  {
    buttxtSanctionDate = newButtxtSanctionDate;
  }

  public String getButtxtLoanType()
  {
    return buttxtLoanType;
  }

  public void setButtxtLoanType(String newButtxtLoanType)
  {
    buttxtLoanType = newButtxtLoanType;
  }

  public String getButtxtEmpNo()
  {
    return buttxtEmpNo;
  }

  public void setButtxtEmpNo(String newButtxtEmpNo)
  {
    buttxtEmpNo = newButtxtEmpNo;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtLoan()
  {
    return txtLoan;
  }

  public void setTxtLoan(String newTxtLoan)
  {
    txtLoan = newTxtLoan;
  }
}