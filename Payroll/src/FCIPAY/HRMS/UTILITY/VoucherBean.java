/* 
 * Module:        VoucherBean.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Oct - 2003 
 * Description:   This is a simple bean which stores all the rows in the Voucher Screens
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
*/

package FCIPAY.HRMS.UTILITY;
import java.lang.StringBuffer;

public final class VoucherBean {
    private String  txtHidRows;
	 private String  txtSrNo="";
	 private String  txtPart="";
	 private String  txtAcctId="";
	 private String  txtOrderNo="";
	 private String  txtSlCode="";
	 private String  txtChCode="";
	 private String  txtCcCode="";
    private String  txtUSICode="";
	 private String  txtLink="";
	 private String  txtDr="";
	 private String  txtCr="";
    private String  txtPwoInd="";
    private String  txtSlType="";    
    private String  txtOrderId="";
    private String  txtSlId="";
    private String  txtCcId="";
    private String  txtFlag="";
    //Empty Constructor
    public VoucherBean() {
    }
   public VoucherBean(String temptxtHidRows,String  temptxtSrNo,String  temptxtPart,String  temptxtAcctId,String  temptxtOrderNo,String  temptxtSlCode,String  temptxtChCode,String  temptxtCcCode,String  temptxtUSICode,String  temptxtLink,String  temptxtDr,String  temptxtCr,String temptxtPWOType,String temptxtSLType,String temptxtOrderId,String temptxtSlId,String temptxtCcId) 
   {
      this.txtHidRows=temptxtHidRows;
      this.txtSrNo=temptxtSrNo;
      this.txtPart=temptxtPart;
      this.txtAcctId=temptxtAcctId;
      this.txtOrderNo=temptxtOrderNo;
      this.txtSlCode=temptxtSlCode;
      this.txtChCode=temptxtChCode;
      this.txtCcCode=temptxtCcCode;
      this.txtUSICode=temptxtUSICode;
      this.txtLink=temptxtLink;
      this.txtDr=temptxtDr;
      this.txtCr=temptxtCr;
      this.txtPwoInd=temptxtPWOType;
      this.txtSlType=temptxtSLType;
      this.txtOrderId=temptxtOrderId;
      this.txtSlId=temptxtSlId;
      this.txtCcId=temptxtCcId;
   }
   public VoucherBean(String temptxtHidRows,String  temptxtSrNo,String  temptxtPart,String  temptxtAcctId,String  temptxtOrderNo,String  temptxtSlCode,String  temptxtChCode,String  temptxtCcCode,String  temptxtUSICode,String  temptxtLink,String  temptxtDr,String  temptxtCr,String temptxtPWOType,String temptxtSLType,String temptxtOrderId,String temptxtSlId,String temptxtCcId,String Flag) 
   {
      this.txtHidRows=temptxtHidRows;
      this.txtSrNo=temptxtSrNo;
      this.txtPart=temptxtPart;
      this.txtAcctId=temptxtAcctId;
      this.txtOrderNo=temptxtOrderNo;
      this.txtSlCode=temptxtSlCode;
      this.txtChCode=temptxtChCode;
      this.txtCcCode=temptxtCcCode;
      this.txtUSICode=temptxtUSICode;
      this.txtLink=temptxtLink;
      this.txtDr=temptxtDr;
      this.txtCr=temptxtCr;
      this.txtPwoInd=temptxtPWOType;
      this.txtSlType=temptxtSLType;
      this.txtOrderId=temptxtOrderId;
      this.txtSlId=temptxtSlId;
      this.txtCcId=temptxtCcId;
      this.txtFlag=Flag;
   }


	//Getter Methods 

   public String gettxtFlag() 
   {
      return this.txtFlag;
   }
   public void settxtFlag(String tFlag) 
   {
      this.txtFlag=tFlag;
   }
   public String gettxtCcId() 
   {
      return this.txtCcId;
   }
   public String gettxtOrderId() 
   {
      return this.txtOrderId;
   }
   public String gettxtSlId() 
   {
      return this.txtSlId;
   }
   public String gettxtHidRows() {
		return this.txtHidRows;
	}

	public String gettxtSrNo() {
		return this.txtSrNo;
	}

	public String gettxtPart() {
		return this.txtPart;
	}

	public String gettxtAcctId() {
		return this.txtAcctId;
	}


	public String gettxtOrderNo() {
		return this.txtOrderNo;
	}


	public String gettxtSlCode() {
		return this.txtSlCode;
	}

	public String gettxtChCode() {
		return this.txtChCode;
	}

	public String gettxtCcCode() {
		return this.txtCcCode;
	}

   public String gettxtUSICode() {
		return this.txtUSICode;
	}

	public String gettxtLink() {
		return this.txtLink;
	}

	public String gettxtDr() {
		return this.txtDr;
	}

	public String gettxtCr() {
		return this.txtCr;
	}

   public String gettxtPwoInd() 
   {
      return this.txtPwoInd;
   }    

   public String gettxtSlType() 
   {
      return this.txtSlType;
   }

   public String toString() 
   {
      StringBuffer strBuf=new StringBuffer();
      strBuf.append(this.txtHidRows);strBuf.append("|");
      strBuf.append(this.txtSrNo);strBuf.append("|");
      strBuf.append(this.txtPart);strBuf.append("|");
      strBuf.append(this.txtAcctId);strBuf.append("|");
      strBuf.append(this.txtOrderNo);strBuf.append("|");
      strBuf.append(this.txtSlCode);strBuf.append("|");
      strBuf.append(this.txtChCode);strBuf.append("|");
      strBuf.append(this.txtCcCode);strBuf.append("|");
      strBuf.append(this.txtLink);strBuf.append("|");
      strBuf.append(this.txtDr);strBuf.append("|");
      strBuf.append(this.txtCr);strBuf.append("|");
      strBuf.append(this.txtPwoInd);strBuf.append("|");
      strBuf.append(this.txtSlType);strBuf.append("|");
      strBuf.append(this.txtOrderId);strBuf.append("|");
      strBuf.append(this.txtSlId);strBuf.append("|");
      strBuf.append(this.txtCcId);
      System.out.println(strBuf.toString());
      return strBuf.toString();
   }


}//End - VoucherBean