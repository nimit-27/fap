package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class PLIActualCancelForm extends PayrollBaseForm
{
    private String txtEmpNo = "";
    private String txtEmpName= "";      
    private String optVal;
    private String txtInvoice;    
    private String butAction;   
    private String txtPLIYear = "";  
    private String txtLocId;
    private String txtLocDesc;    
    private String hdnAction;   
    private String [] txtPLIAmnt;  
    private String [] netAmntPayble;
    private ArrayList lstInstrDtls= new ArrayList();
    private String screenModePLI;
    private String screenModePLI1;
    private String screenModePLI2;
    private String screenModeFlag;
   

    /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
    public void reset(ActionMapping mapping, HttpServletRequest request)
    {
      super.reset(mapping, request);
    }

    /**
     * Validate all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return ActionErrors A list of all errors found.
     */
    /*public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
      return super.validate(mapping, request);
    }*/

    public String getTxtEmpNo()
    {
      return txtEmpNo;
    }

    public void setTxtEmpNo(String newTxtEmpNo)
    {
      txtEmpNo = newTxtEmpNo;
    }
    
    public String getTxtEmpName()
    {
      return txtEmpName;
    }
    
    public void setTxtEmpName(String newTxtEmpName)
    {
      txtEmpName = newTxtEmpName;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setTxtLocDesc(String txtLocDesc) {
        this.txtLocDesc = txtLocDesc;
    }

    public String getTxtLocDesc() {
        return txtLocDesc;
    }  
    
   

    public String getButAction()
    {
      return butAction;
    }

    public void setButAction(String newButAction)
    {
      butAction = newButAction;
    }

    
   
    public String getTxtPLIYear()
    {
      return txtPLIYear;
    }

    public void setTxtPLIYear(String newTxtPLIYear)
    {
      txtPLIYear = newTxtPLIYear;
    }

    

   
    
    public String getHdnAction()
    {
      return hdnAction;
    }

    public void setHdnAction(String newHdnAction)
    {
      hdnAction = newHdnAction;
    }   
     
       
    
    public String [] getTxtPLIAmnt()
    {
      return txtPLIAmnt;
    }

    public void setTxtPLIAmnt(String [] newTxtPLIAmnt)
    {
      txtPLIAmnt = newTxtPLIAmnt;
    }
    
     
    
   
    
    public String [] getNetAmntPayble()
    {
      return netAmntPayble;
    }

    public void setNetAmntPayble(String [] newNetAmntPayble)
    {
      netAmntPayble = newNetAmntPayble;
    }
    
     public ArrayList getLstInstrDtls()
    {
      return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
      lstInstrDtls = newLstInstrDtls;
    }
    
    public String getScreenModePLI()
    {
      return screenModePLI;
    }

    public void setScreenModePLI(String newScreenModePLI)
    {
      screenModePLI = newScreenModePLI;
    } 
    public String getScreenModePLI1()
    {
      return screenModePLI1;
    }

    public void setScreenModePLI1(String newScreenModePLI1)
    {
      screenModePLI1 = newScreenModePLI1;
    } 
    
    public String getScreenModePLI2()
    {
      return screenModePLI2;
    }

    public void setScreenModePLI2(String newScreenModePLI2)
    {
      screenModePLI2 = newScreenModePLI2;
    } 
    
    public String getScreenModeFlag()
    {
      return screenModeFlag;
    }

    public void setScreenModeFlag(String newScreenModeFlag)
    {
      screenModeFlag = newScreenModeFlag;
    }

    public void setOptVal(String optVal) {
        this.optVal = optVal;
    }

    public String getOptVal() {
        return optVal;
    }


    public void setTxtInvoice(String txtInvoice) {
        this.txtInvoice = txtInvoice;
    }

    public String getTxtInvoice() {
        return txtInvoice;
    }
}
