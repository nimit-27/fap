package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class PLIReportAdjustmentForm extends PayrollBaseForm
{
    
      private ArrayList lstInstrDtls=new ArrayList();
      
        private String txtEmpNo;
        private String txtEmpName;
        private String txtStaffCode;
        private String txtCPFCode;
        private String txtDesg;
        private String txtPayScale;
        private String txtCatg;
        private String txtPayScaleType;
        private String tranId;
        private String delTranId;
        private String delUpTran;
        private String userBtn;
        private String txtNetAmt;

        private String [] txtYYMM;
        private String [] txtPayMode;
        private String [] txtAmt;
       
        
      public ArrayList getLstInstrDtls()
      {
        return lstInstrDtls;
      }

      public void setLstInstrDtls(ArrayList newLstInstrDtls)
      {
        lstInstrDtls=newLstInstrDtls;
      }
     
      public String getTranId()
      {
        return tranId;
      }
      public void setTranId(String newTranId)
      {
        tranId = newTranId;
      }
      
      public String getUserBtn()
      {
        return userBtn;
      }
      public void setUserBtn(String newUserBtn)
      {
        userBtn = newUserBtn;
      }
     
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

      public String getTxtStaffCode()
      {
        return txtStaffCode;
      }
      public void setTxtStaffCode(String newTxtStaffCode)
      {
        txtStaffCode = newTxtStaffCode;
      }

      public String getTxtCPFCode()
      {
        return txtCPFCode;
      }
      public void setTxtCPFCode(String newTxtCPFCode)
      {
        txtCPFCode = newTxtCPFCode;
      }

      public String getTxtDesg()
      {
        return txtDesg;
      }
      public void setTxtDesg(String newTxtDesg)
      {
        txtDesg = newTxtDesg;
      }

      public String getTxtPayScale()
      {
        return txtPayScale;
      }
      public void setTxtPayScale(String newTxtPayScale)
      {
        txtPayScale = newTxtPayScale;
      }

      public String getTxtPayScaleType()
      {
        return txtPayScaleType;
      }
      public void setTxtPayScaleType(String newTxtPayScaleType)
      {
        txtPayScaleType = newTxtPayScaleType;
      }

      public String getTxtCatg()
      {
        return txtCatg;
      }
      public void setTxtCatg(String newTxtCatg)
      {
        txtCatg = newTxtCatg;
      }
      public String getDelTranId()
      {
        return delTranId;
      }
      public void setDelTranId(String newDelTranId)
      {
        delTranId = newDelTranId;
      }
      
      public String getDelUpTran()
      {
        return delUpTran;
      }
      public void setDelUpTran(String newDelUpTran)
      {
        delUpTran = newDelUpTran;
      }

      public String getTxtNetAmt()
      {
        return txtNetAmt;
      }
      public void setTxtNetAmt(String newTxtNetAmt)
      {
        txtNetAmt = newTxtNetAmt;
      }

      public String [] getTxtYYMM()
      {
        return txtYYMM;
      }
      public void setTxtYYMM(String [] newTxtYYMM)
      {
        txtYYMM=newTxtYYMM;
      }

      public String [] getTxtPayMode()
      {
        return txtPayMode;
      }
      public void setTxtPayMode(String [] newTxtPayMode)
      {
        txtPayMode=newTxtPayMode;
      }

      public String [] getTxtAmt()
      {
        return txtAmt;
      }
      public void setTxtAmt(String [] newTxtAmt)
      {
        txtAmt=newTxtAmt;
      }

    }