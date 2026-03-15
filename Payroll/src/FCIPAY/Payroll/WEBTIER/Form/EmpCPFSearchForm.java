package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class EmpCPFSearchForm extends PayrollBaseForm
{
  private String txtEmpNo;
  private String txtStaffCode;
  private String parentZone;
  private String txtEmpFirstName;
  private String txtEmpMiddleName;
  private String txtEmpLastName;
  private String txtEmpName;
  private String txtDsgn;  
  private String txtDsgnDesc;
  private String txtCateg;  
  private String txtCategDesc;   
  private String txtCadre;
  private String txtEmpType;
  private String txtEmpTypeId;
  private String txtPFType;
  private String txtCpfCode="";
  private String txtFpsNo;
  private String txtDojFCI;
  private String txtPresentPOP;
  private String txtPresentPOPDesc;
  private String txtDOJSite;
  private String txtEmpStatus;
  private String txtDepuType="";
  private String prefix="";
  private String txtDivision;
  private String txtSection;
  private String txtSectionDesc;
  private String txtDOB;
  private String txtRetireDate;
  
  private String txtPayType;
  private String txtPayScaleCode;
  private String txtCurtBasic;
  private String txtPayStatus;
  private String txtPayMode;
  private String txtPayModeType;
  private String txtBankCode;
  private String txtBankDesc;
  private String txtBranchCode;
  private String txtBranchDesc;
  private String txtBankAccNo;
  private String txtPayStsChnDate="";  
  private String txtPerPay;
  private String txtPerPayHighQual;
  private String txtInrSt;
  private String txtStagInc;
  private String txtStagEffDate;
  private String txtSubsAmt;
  private String txtPanNo;
  private String txtLicFeeDEM; 
  private String txtCityTypeHra;
  private String hdnStartBasic;
  private String hdnEndBasic;  
  private String txtMHSTyp;
  private String txtEpsFlag;
  private String txtEpsEntDt;
  private String txtEpsSepRsn;
  private String txtEpsSepDt;  
  private String txtPayRevFlag; // added by yogesh
  
  private String txtGradePay;
  private String resetFlag;
  private String tmpCpfFlg;

  public EmpCPFSearchForm()
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
  
  public String getTxtStaffCode()
  {
    return txtStaffCode;
  }

  public void setTxtStaffCode(String newTxtStaffCode)
  {
    txtStaffCode = newTxtStaffCode;
  } 
  
  public String getParentZone()
  {
    return parentZone;
  }

  public void setParentZone(String newParentZone)
  {
    parentZone = newParentZone;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
  
  public String getTxtEmpFirstName()
  {
    return txtEmpFirstName;
  }

  public void setTxtEmpFirstName(String newTxtEmpFirstName)
  {
    txtEmpFirstName = newTxtEmpFirstName;
  }
  
  public String getTxtEmpMiddleName()
  {
    return txtEmpMiddleName;
  }

  public void setTxtEmpMiddleName(String newTxtEmpMiddleName)
  {
    txtEmpMiddleName = newTxtEmpMiddleName;
  }
  
  public String getTxtEmpLastName()
  {
    return txtEmpLastName;
  }

  public void setTxtEmpLastName(String newTxtEmpLastName)
  {
    txtEmpLastName = newTxtEmpLastName;
  }
  
  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtCategDesc()
  {
    return txtCategDesc;
  }

  public void setTxtCategDesc(String newTxtCategDesc)
  {
    txtCategDesc = newTxtCategDesc;
  }
  
  public String getTxtCadre()
  {
    return txtCadre;
  }

  public void setTxtCadre(String newTxtCadre)
  {
    txtCadre = newTxtCadre;
  }
  
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  public String getTxtPresentPOPDesc()
  {
    return txtPresentPOPDesc;
  }

  public void setTxtPresentPOPDesc(String newTxtPresentPOPDesc)
  {
    txtPresentPOPDesc = newTxtPresentPOPDesc;
  }
  
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }  
  
  public String getTxtFpsNo()
  {
    return txtFpsNo;
  }
  public void setTxtFpsNo(String newTxtFpsNo)
  {
    txtFpsNo = newTxtFpsNo;
  }
  
  public String getTxtDojFCI()
  {
    return txtDojFCI;
  }
  public void setTxtDojFCI(String newTxtDojFCI)
  {
    txtDojFCI = newTxtDojFCI;
  } 
  
  public String getTxtDsgn()
  {
    return txtDsgn;
  }
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }

  public String getTxtEmpType()
  {
    return txtEmpType;
  }

  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }
  
  public String getTxtEmpTypeId()
  {
    return txtEmpTypeId;
  }

  public void setTxtEmpTypeId(String newTxtEmpTypeId)
  {
    txtEmpTypeId = newTxtEmpTypeId;
  }   
  
  public String getTxtPayScaleCode()
  {
    return txtPayScaleCode;
  }

  public void setTxtPayScaleCode(String newTxtPayScaleCode)
  {
    txtPayScaleCode = newTxtPayScaleCode;
  }

  public String getTxtPayType()
  {
    return txtPayType;
  }

  public void setTxtPayType(String newTxtPayType)
  {
    txtPayType = newTxtPayType;
  }

  public String getTxtCurtBasic()
  {
    return txtCurtBasic;
  }

  public void setTxtCurtBasic(String newTxtCurtBasic)
  {
    txtCurtBasic = newTxtCurtBasic;
  }
  
  public String getTxtPerPay()
  {
    return txtPerPay;
  }

  public void setTxtPerPay(String newTxtPerPay)
  {
    txtPerPay = newTxtPerPay;
  }
  
  public String getTxtPerPayHighQual()
  {
    return txtPerPayHighQual;
  }

  public void setTxtPerPayHighQual(String newTxtPerPayHighQual)
  {
    txtPerPayHighQual = newTxtPerPayHighQual;
  }
  
  
  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }

  public String getTxtBankAccNo()
  {
    return txtBankAccNo;
  }

  public void setTxtBankAccNo(String newTxtBankAccNo)
  {
    txtBankAccNo = newTxtBankAccNo;
  }  

  public String getTxtInrSt()
  {
    return txtInrSt;
  }

  public void setTxtInrSt(String newTxtInrSt)
  {
    txtInrSt = newTxtInrSt;
  }

  public String getTxtPayStatus()
  {
    return txtPayStatus;
  }

  public void setTxtPayStatus(String newTxtPayStatus)
  {
    txtPayStatus = newTxtPayStatus;
  }

  public String getTxtPayStsChnDate()
  {
    return txtPayStsChnDate;
  }

  public void setTxtPayStsChnDate(String newTxtPayStsChnDate)
  {
    txtPayStsChnDate = newTxtPayStsChnDate;
  }  
      
  public String getTxtStagInc()
  {
    return txtStagInc;
  }

  public void setTxtStagInc(String newTxtStagInc)
  {
    txtStagInc = newTxtStagInc;
  }
  
  public String getTxtStagEffDate()
  {
    return txtStagEffDate;
  }

  public void setTxtStagEffDate(String newTxtStagEffDate)
  {
    txtStagEffDate = newTxtStagEffDate;
  }
  
  public String getTxtPFType()
  {
    return txtPFType;
  }

  public void setTxtPFType(String newTxtPFType)
  {
    txtPFType = newTxtPFType;
  }
  
  public String getTxtSubsAmt()
  {
    return txtSubsAmt;
  }

  public void setTxtSubsAmt(String newTxtSubsAmt)
  {
    txtSubsAmt = newTxtSubsAmt;
  }  

  public String getTxtBankCode()
  {
    return txtBankCode;
  }

  public void setTxtBankCode(String newTxtBankCode)
  {
    txtBankCode = newTxtBankCode;
  }
  
  public String getTxtBankDesc()
  {
    return txtBankDesc;
  }

  public void setTxtBankDesc(String newTxtBankDesc)
  {
    txtBankDesc = newTxtBankDesc;
  }

  public String getTxtBranchCode()
  {
    return txtBranchCode;
  }

  public void setTxtBranchCode(String newTxtBranchCode)
  {
    txtBranchCode = newTxtBranchCode;
  }  
  
  public String getTxtBranchDesc()
  {
    return txtBranchDesc;
  }

  public void setTxtBranchDesc(String newTxtBranchDesc)
  {
    txtBranchDesc = newTxtBranchDesc;
  }  

  public String getTxtPayModeType()
  {
    return txtPayModeType;
  }

  public void setTxtPayModeType(String newTxtPayModeType)
  {
    txtPayModeType = newTxtPayModeType;
  }  
  
  public String getTxtCityTypeHra()
  {
    return txtCityTypeHra;
  }

  public void setTxtCityTypeHra(String newTxtCityTypeHra)
  {
    txtCityTypeHra = newTxtCityTypeHra;
  }  
  
  public String getHdnStartBasic()
  {
    return hdnStartBasic;
  }

  public void setHdnStartBasic(String newHdnStartBasic)
  {
    hdnStartBasic = newHdnStartBasic;
  }
  
  public String getHdnEndBasic()
  {
    return hdnEndBasic;
  }

  public void setHdnEndBasic(String newHdnEndBasic)
  {
    hdnEndBasic = newHdnEndBasic;
  }  
  
  public String getTxtMHSTyp()
  {
    return txtMHSTyp;
  }

  public void setTxtMHSTyp(String newTxtMHSTyp)
  {
    txtMHSTyp = newTxtMHSTyp;
  }  

  public String getTxtEpsFlag()
  {
    return txtEpsFlag;
  }

  public void setTxtEpsFlag(String newTxtEpsFlag)
  {
    txtEpsFlag = newTxtEpsFlag;
  }  

  public String getTxtEpsEntDt()
  {
    return txtEpsEntDt;
  }

  public void setTxtEpsEntDt(String newTxtEpsEntDt)
  {
    txtEpsEntDt = newTxtEpsEntDt;
  }  

  public String getTxtEpsSepRsn()
  {
    return txtEpsSepRsn;
  }

  public void setTxtEpsSepRsn(String newTxtEpsSepRsn)
  {
    txtEpsSepRsn = newTxtEpsSepRsn;
  }  

  public String getTxtEpsSepDt()
  {
    return txtEpsSepDt;
  }

  public void setTxtEpsSepDt(String newTxtEpsSepDt)
  {
    txtEpsSepDt = newTxtEpsSepDt;
  }
  

  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
  
  public String getTxtDepuType()
  {
    return txtDepuType;
  }

  public void setTxtDepuType(String newTxtDepuType)
  {
    txtDepuType = newTxtDepuType;
  }  
  
  public String getPrefix()
  {
    return prefix;
  }

  public void setPrefix(String newPrefix)
  {
    prefix = newPrefix;
  }  
  
  public String getTxtDivision()
  {
    return txtDivision;
  }

  public void setTxtDivision(String newTxtDivision)
  {
    txtDivision = newTxtDivision;
  }
  
  public String getTxtSection()
  {
    return txtSection;
  }

  public void setTxtSection(String newTxtSection)
  {
    txtSection = newTxtSection;
  }
  
  public String getTxtSectionDesc()
  {
    return txtSectionDesc;
  }

  public void setTxtSectionDesc(String newTxtSectionDesc)
  {
    txtSectionDesc = newTxtSectionDesc;
  }
  
  public String getTxtDOB()
  {
    return txtDOB;
  }

  public void setTxtDOB(String newTxtDOB)
  {
    txtDOB = newTxtDOB;
  }
  
  public String getTxtRetireDate()
  {
    return txtRetireDate;
  }

  public void setTxtRetireDate(String newTxtRetireDate)
  {
    txtRetireDate = newTxtRetireDate;
  }

  public String getTxtDOJSite()
  {
    return txtDOJSite;
  }

  public void setTxtDOJSite(String newTxtDOJSite)
  {
    txtDOJSite = newTxtDOJSite;
  } 

  public String getTxtPanNo()
  {
    return txtPanNo;
  }

  public void setTxtPanNo(String newTxtPanNo)
  {
    txtPanNo = newTxtPanNo;
  }  
  
  public String getTxtGradePay()
  {
    return txtGradePay;
  }

  public void setTxtGradePay(String newTxtGradePay)
  {
    txtGradePay = newTxtGradePay;
  }  
  public String getTxtPayRevFlag() 
  {
    return txtPayRevFlag;
  }
  
  public void setTxtPayRevFlag(String newTxtPayRevFlag)
  {
    txtPayRevFlag = newTxtPayRevFlag;
  }  
}


