package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class IncentiveOperationsDtlKotForm extends PayrollBaseForm 
{
  private ArrayList incentiveoperationsdtl = new ArrayList();
  private String txtOperationID;
  private String[] txtDatumFrom;
  private String[] txtDatumTo;
  private String txtBagType;
  private String[] txtL1;
  private String[] txtL2;
  private String[] txtL3;
  private String[] txtL4;
  private String[] txtL5;
  private String[] txtL6;
  private String[] txtOpr_Sequence;
  private String txtEffFromDt;
  private String txtEffToDt;
  private String txtDatumVal;
  private String txtOperationDesc;
  public IncentiveOperationsDtlKotForm()
  {
  }
  
  public String[] getTxtOpr_Sequence()
  {
    return txtOpr_Sequence;
  }

  public void setTxtOpr_Sequence(String[] newTxtOpr_Sequence)
  {
    txtOpr_Sequence = newTxtOpr_Sequence;
  }
  
   public String getTxtOperationID()
  {
    return txtOperationID;
  }

  public void setTxtOperationID(String newTxtOperationID)
  {
    txtOperationID = newTxtOperationID;
  }
  
   public String getTxtOperationDesc()
  {
    return txtOperationDesc;
  }

  public void setTxtOperationDesc(String newTxtOperationDesc)
  {
    txtOperationDesc = newTxtOperationDesc;
  }
  
  
   public String[] getTxtDatumFrom()
  {
    return txtDatumFrom;
  }

  public void setTxtDatumFrom(String[] newTxtDatumFrom)
  {
    txtDatumFrom = newTxtDatumFrom;
  }
  
   public String[] getTxtDatumTo()
  {
    return txtDatumTo;
  }

  public void setTxtDatumTo(String[] newTxtDatumTo)
  {
    txtDatumTo = newTxtDatumTo;
  }
  
    public String getTxtBagType()
  {
    return txtBagType;
  }

  public void setTxtBagType(String newTxtBagType)
  {
    txtBagType = newTxtBagType;
  }
  
   public String[] getTxtL1()
  {
    return txtL1;
  }

  public void setTxtL1(String[] newTxtL1)
  {
    txtL1 = newTxtL1;
  }
  
    public String[] getTxtL2()
  {
    return txtL2;
  }

  public void setTxtL2(String[] newTxtL2)
  {
    txtL2 = newTxtL2;
  }
  
    public String[] getTxtL3()
  {
    return txtL3;
  }

  public void setTxtL3(String[] newTxtL3)
  {
    txtL3 = newTxtL3;
  }
  
    public String[] getTxtL4()
  {
    return txtL4;
  }

  public void setTxtL4(String[] newTxtL4)
  {
    txtL4 = newTxtL4;
  }
  
  public String[] getTxtL5()
  {
    return txtL5;
  }

  public void setTxtL5(String[] newTxtL5)
  {
    txtL5 = newTxtL5;
  }
  
   public String[] getTxtL6()
  {
    return txtL6;
  }

  public void setTxtL6(String[] newTxtL6)
  {
    txtL6 = newTxtL6;
  }
  
   public ArrayList getIncentiveoperationsdtl()
  {
    return incentiveoperationsdtl;
  }
  
  public void setIncentiveoperationsdtl(ArrayList newIncentiveoperationsdtl)
  {
    incentiveoperationsdtl=newIncentiveoperationsdtl;
  }
  
  public String getTxtEffFromDt()
  {
    return txtEffFromDt;
  }

  public void setTxtEffFromDt(String newTxtEffFromDt)
  {
    txtEffFromDt = newTxtEffFromDt;
  }
  
   public String getTxtEffToDt()
  {
    return txtEffToDt;
  }

  public void setTxtEffToDt(String newTxtEffToDt)
  {
    txtEffToDt = newTxtEffToDt;
  }
  
  public String getTxtDatumVal()
  {
    return txtDatumVal;
  }

  public void setTxtDatumVal(String newTxtDatumVal)
  {
    txtDatumVal = newTxtDatumVal;
  }  
  
}