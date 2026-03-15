package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintIncentiveOperationsKotForm extends PayrollBaseForm 
{
  private ArrayList incentiveoperationskotwal = new ArrayList();
  private String[] txtOperationID;
  private String[] txtOperationDesc;
  private String[] txtDatumFlag;
  private String[] txtLeadFlag;
  private String[] txtRate;
  private String[] txtUnit; 
  public MaintIncentiveOperationsKotForm()
  {
  }
  
  public String[] getTxtOperationID()
  {
    return txtOperationID;
  }

  public void setTxtOperationID(String[] newTxtOperationID)
  {
    txtOperationID = newTxtOperationID;
  }
 
   public String[] getTxtOperationDesc()
  {
    return txtOperationDesc;
  }

  public void setTxtOperationDesc(String[] newTxtOperationDesc)
  {
    txtOperationDesc = newTxtOperationDesc;
  }
  
  public String[] getTxtDatumFlag()
  {
    return txtDatumFlag;
  }

  public void setTxtDatumFlag(String[] newTxtDatumFlag)
  {
    txtDatumFlag = newTxtDatumFlag;
  }
  
   public String[] getTxtLeadFlag()
  {
    return txtLeadFlag;
  }

  public void setTxtLeadFlag(String[] newTxtLeadFlag)
  {
    txtLeadFlag = newTxtLeadFlag;
  }
  
   public String[] getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String[] newTxtRate)
  {
    txtRate = newTxtRate;
  }
  
   public ArrayList getIncentiveoperationskotwal()
  {
    return incentiveoperationskotwal;
  }
  
  public void setIncentiveoperationskotwal(ArrayList newIncentiveoperationskotwal)
  {
    incentiveoperationskotwal=newIncentiveoperationskotwal;
  }
  
   public String[] getTxtUnit()
  {
    return txtUnit;
  }

  public void setTxtUnit(String[] newTxtUnit)
  {
    txtUnit = newTxtUnit;
  }
  
}