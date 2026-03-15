package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import java.lang.String;


public class LoanAdjustmentForm extends PayrollBaseForm
{
  private String  txtEmpStatus;
  private String  txtEmpNo;
  private String  txtEmpName;
  private String  txtBasic;
  private String  txtEmpCategory;
  private String  txtDsgn;
  private String  txtEmpType;
  private String  txtLoan;
  private String  txtOutPrn;
  private String  txtOutInt;
  private String  txtNewIntInstal;
  private String  txtSysdate;
  private String txtLoanDesc;
  private String txtPaidPrn;
  private String txtPaidInt;
  private String txtTransID;
  private String txtLoanFlag;
  private String txtEmpCPF;
  private String txtNewPrnInstal;
  private String txtNewPrnAmt;
  private String txtNewIntAmt;
  private String txtPaidPrnInstal;
  private String txtPaidIntInstal;
  private String txtPaidPrnAmt;
  private String txtPaidIntAmt;
  private String hdnAction;
  private String txtLoanAmt;
  private String txtAlreadyPrn;
  private String txtAlreadyInt;
  private String txtOpenYYMM;
  private String txtOutAson;
  private String txtAdjOutAson;
  private String txtRecvYYMM;
  
  public String getTxtOutPrn()
  {
    return txtOutPrn;
  }
  
  public void setTxtOutPrn(String newTxtOutPrn)
  {
    txtOutPrn = newTxtOutPrn;
  }
  
  public String getTxtLoanFlag()
  {
    return txtLoanFlag;
  }
  
  public void setTxtLoanFlag(String newTxtLoanFlag)
  {
    txtLoanFlag = newTxtLoanFlag;
  }
  
  
  public String getTxtTransID()
  {
    return txtTransID;
  }
  
  public void setTxtTransID(String newTxtTransID)
  {
    txtTransID = newTxtTransID;
  }
  
  
  
  
   public String getTxtLoanDesc()
  {
    return txtLoanDesc;
  }
  
  public void setTxtLoanDesc(String newTxtLoanDesc)
  {
    txtLoanDesc = newTxtLoanDesc;
  }
  
  
    public String getTxtSysdate()
  {
    return txtSysdate;
  }
  
  public void setTxtSysdate(String newTxtSysdate)
  {
    txtSysdate = newTxtSysdate;
  }
  
   public String getTxtOutInt()
  {
    return txtOutInt;
  }
  
  public void setTxtOutInt(String newTxtOutInt)
  {
    txtOutInt = newTxtOutInt;
  }
  
     public String getTxtNewIntInstal()
  {
    return txtNewIntInstal;
  }
  
  public void setTxtNewIntInstal(String newTxtNewIntInstal)
  {
    txtNewIntInstal = newTxtNewIntInstal;
  }
  
    public String getTxtLoan()
  {
    return txtLoan;
  }
  
  public void setTxtLoan(String newTxtLoan)
  {
    txtLoan = newTxtLoan;
  }
  
  
  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }
  
  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
  
    public String getTxtEmpType()
  {
    return txtEmpType;
  }
  
  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }
  
  
   public String getTxtDsgn()
  {
    return txtDsgn;
  }
  
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
    public String getTxtEmpName()
  {
    return txtEmpName;
  }
  
  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
  
    public String getTxtBasic()
  {
    return txtBasic;
  }
  
  public void setTxtBasic(String newTxtBasic)
  {
    txtBasic = newTxtBasic;
  }
  
        public String getTxtEmpNo()
  {
    return txtEmpNo;
  }
  
  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
  
   public String getTxtEmpCategory()
  {
    return txtEmpCategory;
  }
  public void setTxtEmpCategory(String newTxtEmpCategory)
  {
    txtEmpCategory = newTxtEmpCategory;
  }
  
   public String getTxtPaidPrn()
  {
    return txtPaidPrn;
  }
  public void setTxtPaidPrn(String newTxtPaidPrn)
  {
    txtPaidPrn = newTxtPaidPrn;
  }
  
  public String getTxtPaidInt()
  {
    return txtPaidInt;
  }
  public void setTxtPaidInt(String newTxtPaidInt)
  {
    txtPaidInt = newTxtPaidInt;
  }
     public String getTxtEmpCPF()
  {
    return txtEmpCPF;
  }
  public void setTxtEmpCPF(String newTxtEmpCPF)
  {
    txtEmpCPF = newTxtEmpCPF;
  }
   
  public String getTxtNewPrnInstal()
  {
    return txtNewPrnInstal;
  }
  public void setTxtNewPrnInstal(String newTxtNewPrnInstal)
  {
    txtNewPrnInstal = newTxtNewPrnInstal;
  }  
  
  public String getTxtNewPrnAmt()
  {
    return txtNewPrnAmt;
  }
  public void setTxtNewPrnAmt(String newTxtNewPrnAmt)
  {
    txtNewPrnAmt = newTxtNewPrnAmt;
  }  
  
  public String getTxtNewIntAmt()
  {
    return txtNewIntAmt;
  }
  public void setTxtNewIntAmt(String newTxtNewIntAmt)
  {
    txtNewIntAmt = newTxtNewIntAmt;
  }  
  
  public String getTxtPaidPrnInstal()
  {
    return txtPaidPrnInstal;
  }
  public void setTxtPaidPrnInstal(String newTxtPaidPrnInstal)
  {
    txtPaidPrnInstal = newTxtPaidPrnInstal;
  }  
  
   
  public String getTxtPaidIntInstal()
  {
    return txtPaidIntInstal;
  }
  public void setTxtPaidIntInstal(String newTxtPaidIntInstal)
  {
    txtPaidIntInstal = newTxtPaidIntInstal;
  }  
  
  
  
   public String getTxtPaidPrnAmt()
  {
    return txtPaidPrnAmt;
  }
  public void setTxtPaidPrnAmt(String newTxtPaidPrnAmt)
  {
    txtPaidPrnAmt = newTxtPaidPrnAmt;
  }
  
  
  public String getTxtPaidIntAmt()
  {
    return txtPaidIntAmt;
  }
  public void setTxtPaidIntAmt(String newTxtPaidIntAmt)
  {
    txtPaidIntAmt = newTxtPaidIntAmt;
  }  
  
  
  
  public String getHdnAction()
  {
    return hdnAction;
  }
  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
  }  
  
  
  public String getTxtLoanAmt()
  {
    return txtLoanAmt;
  }
  public void setTxtLoanAmt(String newTxtLoanAmt)
  {
    txtLoanAmt = newTxtLoanAmt;
  }  
  
   public String getTxtAlreadyPrn()
  {
    return txtAlreadyPrn;
  }
  public void setTxtAlreadyPrn(String newTxtAlreadyPrn)
  {
    txtAlreadyPrn = newTxtAlreadyPrn;
  }  
  
  
   public String getTxtAlreadyInt()
  {
    return txtAlreadyInt;
  }
  public void setTxtAlreadyInt(String newTxtAlreadyInt)
  {
    txtAlreadyInt = newTxtAlreadyInt;
  }  
  
  public String getTxtOpenYYMM()
  {
    return txtOpenYYMM;
  }
  public void setTxtOpenYYMM(String newTxtOpenYYMM)
  {
    txtOpenYYMM = newTxtOpenYYMM;
  }  
  
  public String getTxtOutAson()
  {
    return txtOutAson;
  }
  public void setTxtOutAson(String newTxtOutAson)
  {
    txtOutAson = newTxtOutAson;
  }  
  public String getTxtAdjOutAson()
  {
    return txtAdjOutAson;
  }
  public void setTxtAdjOutAson(String newTxtAdjOutAson)
  {
    txtAdjOutAson = newTxtAdjOutAson;
  }  
  public String getTxtRecvYYMM()
  {
    return txtRecvYYMM;
  }
  public void setTxtRecvYYMM(String newTxtRecvYYMM)
  {
    txtRecvYYMM = newTxtRecvYYMM;
  }  
}
