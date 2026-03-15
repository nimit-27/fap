package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.MaintInterestRateBean;



public class MaintInterestRateForm extends PayrollBaseForm 
{
  private String txtDateFrom="";
  private String txtDateTo="";
  private String txtInrRate[] = null;
  private long txtTest=0;
  private long lLocCode;
  private long lEmpNo;
  private String action = "";
  private ArrayList lstInstrDtls =new ArrayList();
  private String txtSrlNo[]=null;
  private boolean flag = false;
  private String memberType;

 
  public String getTxtDateFrom()
  {
    return txtDateFrom;
  }

  public void setTxtDateFrom(String newTxtDateFrom)
  {
    txtDateFrom = newTxtDateFrom;
  }

  public String getTxtDateTo()
  {
    return txtDateTo;
  }

  public void setTxtDateTo(String newTxtDateTo)
  {
    txtDateTo = newTxtDateTo;
  }

  public String[] getTxtInrRate()
  {
    return txtInrRate;
  }

  public void setTxtInrRate(String[] newTxtInrRate)
  {
    txtInrRate = newTxtInrRate;
  }

  public long getTxtTest()
  {
    return txtTest;
  }

  public void setTxtTest(long newTxtTest)
  {
    txtTest = newTxtTest;
  }

  public long getLLocCode()
  {
    return lLocCode;
  }

  public void setLLocCode(long newLLocCode)
  {
    lLocCode = newLLocCode;
  }

  public long getLEmpNo()
  {
    return lEmpNo;
  }

  public void setLEmpNo(long newLEmpNo)
  {
    lEmpNo = newLEmpNo;
  }

  public String getAction()
  {
    return action;
  }

  public void setAction(String newAction)
  {
    action = newAction;
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

  public boolean isFlag()
  {
    return flag;
  }

  public void setFlag(boolean newFlag)
  {
    flag = newFlag;
  }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberType() {
        return memberType;
    }
}
