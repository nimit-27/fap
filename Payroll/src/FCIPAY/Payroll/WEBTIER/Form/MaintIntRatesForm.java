package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintIntRatesForm extends PayrollBaseForm
{
  private String loanHdrDesc;
  private String refundFlag;
  private String loanIntType;
  private String dateFrom;
  private String dateTo;
  private String startField[];
  private String endField[];
  private String txtIntRate[];
// private String txtIntRate;
  private ArrayList lstInstrDtls = new ArrayList();
  private boolean flag=false;
  private String txtSerialNo[];
  private String hdnHeaderFlag;
  private String txtConcession[];
  private String txtPenalty[];
  private String txtYearMonth[];

  public MaintIntRatesForm()
  {
  }
  
  public String getLoanIntType()
  {
    return loanIntType;
  }

  public void setLoanIntType(String newLoanIntType)
  {
    loanIntType = newLoanIntType;
  }

  public String getDateFrom()
  {
    return dateFrom;
  }

  public void setDateFrom(String newDateFrom)
  {
    dateFrom = newDateFrom;
  }

  public String getDateTo()
  {
    return dateTo;
  }

  public void setDateTo(String newDateTo)
  {
    dateTo = newDateTo;
  }
  
  public String getRefundFlag()
  {
    return refundFlag;
  }

  public void setRefundFlag(String newRefundFlag)
  {
    refundFlag = newRefundFlag;
  }

  public String[] getStartField()
  {
    return startField;
  }

  public void setStartField(String[] newStartField)
  {
    startField = newStartField;
  }

  public String[] getEndField()
  {
    return endField;
  }

  public void setEndField(String[] newEndField)
  {
    endField = newEndField;
  }

  public String[] getTxtIntRate()
  {
    return txtIntRate;
  }

  public void setTxtIntRate(String[] newTxtIntRate)
  {
    txtIntRate = newTxtIntRate;
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

  public String getLoanHdrDesc()
  {
    return loanHdrDesc;
  }

  public void setLoanHdrDesc(String newLoanHdrDesc)
  {
    loanHdrDesc = newLoanHdrDesc;
  }

  public String[] getTxtSerialNo()
  {
    return txtSerialNo;
  }

  public void setTxtSerialNo(String[] newTxtSerialNo)
  {
    txtSerialNo = newTxtSerialNo;
  }

  public String getHdnHeaderFlag()
  {
    return hdnHeaderFlag;
  }

  public void setHdnHeaderFlag(String newHdnHeaderFlag)
  {
    hdnHeaderFlag = newHdnHeaderFlag;
  }

  public String[] getTxtConcession()
  {
    return txtConcession;
  }

  public void setTxtConcession(String[] newTxtConcession)
  {
    txtConcession = newTxtConcession;
  }

  public String[] getTxtPenalty()
  {
    return txtPenalty;
  }

  public void setTxtPenalty(String[] newTxtPenalty)
  {
    txtPenalty = newTxtPenalty;
  }
  
  public String[] getTxtYearMonth()
  {
    return txtYearMonth;
  }

  public void setTxtYearMonth(String[] newTxtYearMonth)
  {
    txtYearMonth = newTxtYearMonth;
  }
}