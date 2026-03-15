/* 
 * Module:        CommonVoucherVo.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Oct - 2003 
 * Description:   This class acts as a backup for CommonVoucherForm
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
*/

package FCIPAY.HRMS.DATAACCESSTIER.VO;
import java.util.ArrayList;
public class CommonVoucherVo {

      private String  txtPeriod="";
      private String  txtVouchStatus="";
      private String  txtDocLoc="";
      private String  txtVouchType="";
      private String  txtVouchNo="";
      private String  txtVouchId="";
      private String  txtVouchDate="";
      private String  txtDocRef="";
      private String  txtRemarks="";
      private String  txtTotDr="0";
      private String  txtTotCr="0";
      private String  txtPartMast="";
      private String  txtAcctIdMast="";
      private String  txtPwoIndMast="";
      private String  txtOrderNoMast="";
      private String  txtSlTypeMast="";
      private String  txtSlCodeMast="";
      private String  txtChCodeMast="";
      private String  txtCcCodeMast="";
      private String  txtUSICodeMast="";
      private String  txtUSIIdMast="";
      private String  txtLinkMast="";
      private String  txtDrMast="";
      private String  txtCrMast="";
      private String  txtHidMode="";
      private String  txtHidVouchType="";
      private String  txtHidValReplDel="";
      private long  txtHidLocId=0;
      private long  txtEmpNo=0;
      private String  txtTotalRows="";
      private String  isCtrlAcct="";
      private String  isCcCode="";
      private String  isChCode="";
      private String  isUsiCode="";
      private String[]  txtHidRows=null;
      private String[]  txtSrNo=null;
      private String[]  txtPart=null;
      private String[]  txtAcctId=null;
      private String[]  txtPwoInd=null;
      private String[]  txtOrderNo=null;
      private String[]  txtSlType=null;
      private String[]  txtSlCode=null;
      private String[]  txtChCode=null;
      private String[]  txtCcCode=null;
      private String[]  txtUSICode=null;
      private String[]  txtUSIId=null;
      private String[]  txtLink=null;
      private String[]  txtDr=null;
      private String[]  txtCr=null;
      private String[]  txtSlId=null;
      private String[]  txtCcId=null;
      private String[]  txtOrderId=null;
      private ArrayList lstTransact=null;    
      private ArrayList lstPeriod=null;  
      private String chkFormReset="";
      private String txtOrderIdMast="";
      private String txtSlIdMast="";
      private String txtCcIdMast="";    
      private ArrayList lstRetainOriginalRows=new ArrayList();
      private String   txtHidSaveSubmit="";
      private String empDesignation="";
      private long txtAdvId=0;
      private String  txtTrId="";
      private String  txtEmployeeNo="";//Used By IAV(Specific for IAV)
      private String  txtTourStart="";
      private String  txtTourEnd="";
      private String  txtAdvRem="";
      private String  txtVisitLoc="";
      private String  txtSponsorFlg="";
      private String  txtSponsorDtl="";
      private String  txtAdvAmt="";
      private ArrayList  lstEmp=new ArrayList();
      private ArrayList  lstTrType=new ArrayList();
      private String  txtIAVType="";
      private ArrayList  lstSponsorGbl=new ArrayList();    
      private String[] txtFlag=null;
      private String todayPeriodId="";
      private String txtPayeeName="";
      private String txtTransactionMode="";
      private String txtDeposName="";

      public void resetCommonVoucherVo()   {
         txtPeriod="";
         txtVouchStatus="";
         //      txtDocLoc="";
         txtVouchType="";
         txtVouchNo="";
         txtVouchDate="";
         txtDocRef="";
         txtRemarks="";
         txtTotDr="0";
         txtTotCr="0";
         txtPartMast="";
         txtAcctIdMast="";
         txtPwoIndMast="";
         txtOrderNoMast="";
         txtSlTypeMast="";
         txtSlCodeMast="";
         txtChCodeMast="";
         txtCcCodeMast="";
         txtUSICodeMast="";
         txtUSIIdMast="";
         txtLinkMast="";
         txtDrMast="";
         txtCrMast="";
         txtHidRows=null;
         txtSrNo=null;
         txtPart=null;
         txtAcctId=null;
         txtPwoInd=null;
         txtOrderNo=null;
         txtSlType=null;
         txtSlCode=null;
         txtChCode=null;
         txtCcCode=null;
         txtLink=null;
         txtDr=null;
         txtCr=null;
         txtHidMode="";
         txtTotalRows="";
         isCtrlAcct="";
         isCcCode="";
         isChCode="";
         isUsiCode="";
         txtOrderIdMast="";
         txtSlIdMast="";
         txtOrderId=null;
         txtSlId=null;
         txtCcId=null;
         txtCcIdMast="";
         txtHidValReplDel="";
         txtHidSaveSubmit="";
         lstTransact.clear();
         lstRetainOriginalRows.clear();
         txtTrId="";
         txtEmployeeNo="";
         txtTourStart="";
         txtTourEnd="";
         txtAdvRem="";
         txtVisitLoc="";
         txtSponsorFlg="";
         txtSponsorDtl="";
         txtAdvAmt="";
         txtIAVType="";
         txtFlag=null;
         txtAdvId=0;
         txtPayeeName="";
         txtTransactionMode="";
      }//End-Reset
public void settxtUSIIdMast(String temptxtUSIIdMast) {
   this.txtUSIIdMast=temptxtUSIIdMast;
}
public String gettxtUSIIdMast() {
   return this.txtUSIIdMast;
}
public void settxtUSICodeMast(String temptxtUSICodeMast) {
   this.txtUSICodeMast=temptxtUSICodeMast;
}
public String gettxtUSICodeMast() {
   return this.txtUSICodeMast;
}    
public void settxtUSICode(String[] temptxtFlag) {
   this.txtUSICode=temptxtFlag;
}
public String[] gettxtUSICode() {
   return this.txtUSICode;
}
public void settxtUSIId(String[] temptxtFlag) {
   this.txtUSIId=temptxtFlag;
}
public String[] gettxtUSIId() {
   return this.txtUSIId;
}
   public String getempDesignation()
   {
    return this.empDesignation;
   }

   public void setempDesignation(String newSDesignation)
   {
    this.empDesignation = newSDesignation;
   }
   public void settxtAdvId(long txtAdvId) {
     this.txtAdvId=txtAdvId;
   }
   public long gettxtAdvId() {
     return this.txtAdvId;
   }
   public void settxtFlag(String[] temptxtFlag) {
      this.txtFlag=temptxtFlag;
   }
   public String[] gettxtFlag() {
      return this.txtFlag;
   }
   public void settxtIAVType(String temptxtIAVType) {
      this.txtIAVType=temptxtIAVType;
   }
   public String gettxtIAVType() {
      return this.txtIAVType;
   }
   public void setlstSponsorGbl(ArrayList templstSponsorGbl) {
      this.lstSponsorGbl=templstSponsorGbl;
   }
   public ArrayList getlstSponsorGbl() {
      return this.lstSponsorGbl;
   }    
   public void setlstRetainOriginalRows(ArrayList lstArray) {
      this.lstRetainOriginalRows=lstArray;
   }

   public ArrayList getlstRetainOriginalRows() {
      return this.lstRetainOriginalRows;
   }
	//Setter Methods 

   public CommonVoucherVo() 
   {
      lstTransact=new ArrayList();
      lstPeriod=new ArrayList();
   }
   public void settxtHidSaveSubmit(String temptxtHidSaveSubmit) {
      this.txtHidSaveSubmit=temptxtHidSaveSubmit;
   }
   public void settxtHidValReplDel(String temptxtHidValReplDel) 
   {
      this.txtHidValReplDel=temptxtHidValReplDel;
   }
   public void settxtOrderIdMast(String temptxtOrderIdMast) 
   {
      this.txtOrderIdMast=temptxtOrderIdMast;
   }

   public void settxtSlIdMast(String temptxtSlIdMast) 
   {
      this.txtSlIdMast=temptxtSlIdMast;
   } 
   public void settxtCcIdMast(String temptxtCcIdMast) 
   {
      this.txtCcIdMast=temptxtCcIdMast;
   }   
   public void settxtCcId(String[] temptxtCcId) 
   {
      this.txtCcId=temptxtCcId;
   }   
   public void settxtSlId(String[] temptxtSlId) 
   {
      this.txtSlId=temptxtSlId;
   }
   public void settxtOrderId(String[] temptxtOrderId) 
   {
      this.txtOrderId=temptxtOrderId;
   }   
   public void setchkFormReset(String tempchkFormReset) 
   {
      this.chkFormReset=tempchkFormReset;
   }

   public void settxtEmpNo(long temptxtEmpNo) 
   {
      this.txtEmpNo=temptxtEmpNo;
   }

   public void settxtHidLocId(long temptxtHidLocId) 
   {
      this.txtHidLocId=temptxtHidLocId;
   }
	public void settxtPeriod(String temptxtPeriod) {
		this.txtPeriod=temptxtPeriod;
	}

	public void settxtVouchStatus(String temptxtVouchStatus) {
		this.txtVouchStatus=temptxtVouchStatus;
	}

	public void settxtDocLoc(String temptxtDocLoc) {
		this.txtDocLoc=temptxtDocLoc;
	}

	public void settxtVouchType(String temptxtVouchType) {
		this.txtVouchType=temptxtVouchType;
	}

	public void settxtVouchNo(String temptxtVouchNo) {
		this.txtVouchNo=temptxtVouchNo;
	}

	public void settxtVouchDate(String temptxtVouchDate) {
		this.txtVouchDate=temptxtVouchDate;
	}

	public void settxtDocRef(String temptxtDocRef) {
		this.txtDocRef=temptxtDocRef;
	}

	public void settxtRemarks(String temptxtRemarks) {
		this.txtRemarks=temptxtRemarks;
	}

	public void settxtTotDr(String temptxtTotDr) {
		this.txtTotDr=temptxtTotDr;
	}

	public void settxtTotCr(String temptxtTotCr) {
		this.txtTotCr=temptxtTotCr;
	}

	public void settxtPartMast(String temptxtPartMast) {
		this.txtPartMast=temptxtPartMast;
	}

	public void settxtAcctIdMast(String temptxtAcctIdMast) {
		this.txtAcctIdMast=temptxtAcctIdMast;
	}

	public void settxtPwoIndMast(String temptxtPwoIndMast) {
		this.txtPwoIndMast=temptxtPwoIndMast;
	}

	public void settxtOrderNoMast(String temptxtOrderNoMast) {
		this.txtOrderNoMast=temptxtOrderNoMast;
	}

	public void settxtSlTypeMast(String temptxtSlTypeMast) {
		this.txtSlTypeMast=temptxtSlTypeMast;
	}

	public void settxtSlCodeMast(String temptxtSlCodeMast) {
		this.txtSlCodeMast=temptxtSlCodeMast;
	}

	public void settxtChCodeMast(String temptxtChCodeMast) {
		this.txtChCodeMast=temptxtChCodeMast;
	}

	public void settxtCcCodeMast(String temptxtCcCodeMast) {
		this.txtCcCodeMast=temptxtCcCodeMast;
	}

	public void settxtLinkMast(String temptxtLinkMast) {
		this.txtLinkMast=temptxtLinkMast;
	}

	public void settxtDrMast(String temptxtDrMast) {
		this.txtDrMast=temptxtDrMast;
	}

	public void settxtCrMast(String temptxtCrMast) {
		this.txtCrMast=temptxtCrMast;
	}

	public void settxtHidMode(String temptxtHidMode) {
		this.txtHidMode=temptxtHidMode;
	}

	public void settxtTotalRows(String temptxtTotalRows) {
		this.txtTotalRows=temptxtTotalRows;
	}

	public void setisCtrlAcct(String tempisCtrlAcct) {
		this.isCtrlAcct=tempisCtrlAcct;
	}

	public void setisCcCode(String tempisCcCode) {
		this.isCcCode=tempisCcCode;
	}

	public void setisChCode(String tempisChCode) {
		this.isChCode=tempisChCode;
	}

	public void setisUsiCode(String tempisUsiCode) {
		this.isUsiCode=tempisUsiCode;
	}

	public void settxtHidRows(String[] temptxtHidRows) {
		this.txtHidRows=temptxtHidRows;
	}

	public void settxtSrNo(String[] temptxtSrNo) {
		this.txtSrNo=temptxtSrNo;
	}

	public void settxtPart(String[] temptxtPart) {
		this.txtPart=temptxtPart;
	}

	public void settxtAcctId(String[] temptxtAcctId) {
		this.txtAcctId=temptxtAcctId;
	}

	public void settxtPwoInd(String[] temptxtPwoInd) {
		this.txtPwoInd=temptxtPwoInd;
	}

	public void settxtOrderNo(String[] temptxtOrderNo) {
		this.txtOrderNo=temptxtOrderNo;
	}

	public void settxtSlType(String[] temptxtSlType) {
		this.txtSlType=temptxtSlType;
	}

	public void settxtSlCode(String[] temptxtSlCode) {
		this.txtSlCode=temptxtSlCode;
	}

	public void settxtChCode(String[] temptxtChCode) {
		this.txtChCode=temptxtChCode;
	}

	public void settxtCcCode(String[] temptxtCcCode) {
		this.txtCcCode=temptxtCcCode;
	}

	public void settxtLink(String[] temptxtLink) {
		this.txtLink=temptxtLink;
	}

	public void settxtDr(String[] temptxtDr) {
		this.txtDr=temptxtDr;
	}

	public void settxtCr(String[] temptxtCr) {
		this.txtCr=temptxtCr;
	}
	public void setlstTransact(ArrayList templstTransact) {
		this.lstTransact=templstTransact;
	}   

	public void setlstPeriod(ArrayList templstPeriod) {
		this.lstPeriod=templstPeriod;
	}   

	public void settxtHidVouchType(String temptxtHidVouchType) {
		this.txtHidVouchType=temptxtHidVouchType;
	}   



   public void settxtTrId(String temptxtTrId) {
		this.txtTrId=temptxtTrId;
	}

	public void settxtEmployeeNo(String temptxtEmployeeNo) {
		this.txtEmployeeNo=temptxtEmployeeNo;
	}

	public void settxtTourStart(String temptxtTourStart) {
		this.txtTourStart=temptxtTourStart;
	}

	public void settxtTourEnd(String temptxtTourEnd) {
		this.txtTourEnd=temptxtTourEnd;
	}

	public void settxtAdvRem(String temptxtAdvRem) {
		this.txtAdvRem=temptxtAdvRem;
	}

	public void settxtVisitLoc(String temptxtVisitLoc) {
		this.txtVisitLoc=temptxtVisitLoc;
	}

	public void settxtSponsorFlg(String temptxtSponsorFlg) {
		this.txtSponsorFlg=temptxtSponsorFlg;
	}

	public void settxtSponsorDtl(String temptxtSponsorDtl) {
		this.txtSponsorDtl=temptxtSponsorDtl;
	}

	public void settxtAdvAmt(String temptxtAdvAmt) {
		this.txtAdvAmt=temptxtAdvAmt;
	}

	public void setlstEmp(ArrayList templstEmp) {
		this.lstEmp=templstEmp;
	}

	public void setlstTrType(ArrayList templstTrType) {
		this.lstTrType=templstTrType;
	}

   
	//Getter Methods 
   public String gettxtHidSaveSubmit() {
      return this.txtHidSaveSubmit;
   }
   public String gettxtHidValReplDel() 
   {
      return this.txtHidValReplDel;
   }
   public String gettxtOrderIdMast() 
   {
      return this.txtOrderIdMast;
   }
   public String gettxtSlIdMast() 
   {
      return this.txtSlIdMast;
   }   
   public String gettxtCcIdMast() 
   {
      return this.txtCcIdMast;
   }   
   public String[] gettxtCcId() 
   {
      return this.txtCcId;
   }   
   public String[] gettxtOrderId() 
   {
      return this.txtOrderId;
   }
   public String[] gettxtSlId() 
   {
      return this.txtSlId;
   }   
   public String getchkFormReset() 
   {
      return this.chkFormReset;
   }
   
   public long gettxtEmpNo() 
   {
      return this.txtEmpNo;
   }

   public long gettxtHidLocId() 
   {
      return this.txtHidLocId;
   }

	public String gettxtPeriod() {
		return this.txtPeriod;
	}

	public String gettxtVouchStatus() {
		return this.txtVouchStatus;
	}

	public String gettxtDocLoc() {
		return this.txtDocLoc;
	}

	public String gettxtVouchType() {
		return this.txtVouchType;
	}

	public String gettxtVouchNo() {
		return this.txtVouchNo;
	}

	public String gettxtVouchDate() {
		return this.txtVouchDate;
	}

	public String gettxtDocRef() {
		return this.txtDocRef;
	}

	public String gettxtRemarks() {
		return this.txtRemarks;
	}

	public String gettxtTotDr() {
		return this.txtTotDr;
	}

	public String gettxtTotCr() {
		return this.txtTotCr;
	}

	public String gettxtPartMast() {
		return this.txtPartMast;
	}

	public String gettxtAcctIdMast() {
		return this.txtAcctIdMast;
	}

	public String gettxtPwoIndMast() {
		return this.txtPwoIndMast;
	}

	public String gettxtOrderNoMast() {
		return this.txtOrderNoMast;
	}

	public String gettxtSlTypeMast() {
		return this.txtSlTypeMast;
	}

	public String gettxtSlCodeMast() {
		return this.txtSlCodeMast;
	}

	public String gettxtChCodeMast() {
		return this.txtChCodeMast;
	}

	public String gettxtCcCodeMast() {
		return this.txtCcCodeMast;
	}

	public String gettxtLinkMast() {
		return this.txtLinkMast;
	}

	public String gettxtDrMast() {
		return this.txtDrMast;
	}

	public String gettxtCrMast() {
		return this.txtCrMast;
	}

	public String gettxtHidMode() {
		return this.txtHidMode;
	}

	public String gettxtTotalRows() {
		return this.txtTotalRows;
	}

	public String getisCtrlAcct() {
		return this.isCtrlAcct;
	}

	public String getisCcCode() {
		return this.isCcCode;
	}

	public String getisChCode() {
		return this.isChCode;
	}

	public String getisUsiCode() {
		return this.isUsiCode;
	}
  
	public String[] gettxtHidRows() {
		return this.txtHidRows;
	}

	public String[] gettxtSrNo() {
		return this.txtSrNo;
	}

	public String[] gettxtPart() {
		return this.txtPart;
	}

	public String[] gettxtAcctId() {
		return this.txtAcctId;
	}

	public String[] gettxtPwoInd() {
		return this.txtPwoInd;
	}

	public String[] gettxtOrderNo() {
		return this.txtOrderNo;
	}

	public String[] gettxtSlType() {
		return this.txtSlType;
	}

	public String[] gettxtSlCode() {
		return this.txtSlCode;
	}

	public String[] gettxtChCode() {
		return this.txtChCode;
	}

	public String[] gettxtCcCode() {
		return this.txtCcCode;
	}

	public String[] gettxtLink() {
		return this.txtLink;
	}

	public String[] gettxtDr() {
		return this.txtDr;
	}

	public String[] gettxtCr() {
		return this.txtCr;
	}

	public ArrayList getlstTransact() {
		return this.lstTransact;
	}  

	public ArrayList getlstPeriod() {
		return this.lstPeriod;
	}   

	public String gettxtHidVouchType() {
		return this.txtHidVouchType;
	}   


   public String gettxtTrId() {
		return this.txtTrId;
	}

	public String gettxtEmployeeNo() {
		return this.txtEmployeeNo;
	}

	public String gettxtTourStart() {
		return this.txtTourStart;
	}

	public String gettxtTourEnd() {
		return this.txtTourEnd;
	}

	public String gettxtAdvRem() {
		return this.txtAdvRem;
	}

	public String gettxtVisitLoc() {
		return this.txtVisitLoc;
	}

	public String gettxtSponsorFlg() {
		return this.txtSponsorFlg;
	}

	public String gettxtSponsorDtl() {
		return this.txtSponsorDtl;
	}

	public String gettxtAdvAmt() {
		return this.txtAdvAmt;
	}

	public ArrayList getlstEmp() {
		return this.lstEmp;
	}

	public ArrayList getlstTrType() {
		return this.lstTrType;
	}

   public String getTodayPeriodId() {
      return todayPeriodId;
   }

   public void setTodayPeriodId(String newTodayPeriodId) {
      todayPeriodId = newTodayPeriodId;
   }

    public String getTxtPayeeName() {
        return txtPayeeName;
    }

    public void setTxtPayeeName(String newTxtPayeeName) {
        txtPayeeName = newTxtPayeeName;
    }

    public String getTxtTransactionMode() {
        return txtTransactionMode;
    }

    public void setTxtTransactionMode(String newTxtTransactionMode) {
        txtTransactionMode = newTxtTransactionMode;
    }

  public String getTxtVouchId()
  {
    return txtVouchId;
  }

  public void setTxtVouchId(String newTxtVouchId)
  {
    txtVouchId = newTxtVouchId;
  }

  public String getTxtDeposName()
  {
    return txtDeposName;
  }

  public void setTxtDeposName(String newTxtDeposName)
  {
    txtDeposName = newTxtDeposName;
  }
}//End - CommonVoucherVotxtUSIIdMast