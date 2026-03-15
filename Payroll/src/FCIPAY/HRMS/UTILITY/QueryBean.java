/* 
 * Module:        QueryBean.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Oct - 2003 
 * Description:   This is a simple bean which stores all the rows in the Query Screens
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
*/

package FCIPAY.HRMS.UTILITY;
import java.lang.StringBuffer;

public class QueryBean 
{
   private String txtVoucherId="";
   private String txtVoucherNo="";
   private String txtVoucherDate="";
   private String txtDocRef="";
   private String txtDocRem="";   
   private String txtVhStat="";
   private String txtHidVoucherNo="";
   private String txtAuthCmnt="";
   
   public QueryBean(String temptxtVoucherId,String temptxtVoucherNo,String temptxtVoucherDate,String temptxtDocRef,String temptxtDocRem)
   {
      this.txtVoucherId=temptxtVoucherId;
      this.txtVoucherNo=temptxtVoucherNo;
      this.txtVoucherDate=temptxtVoucherDate;
      this.txtDocRef=temptxtDocRef;
      this.txtDocRem=temptxtDocRem;
      this.txtHidVoucherNo=temptxtVoucherNo;
   }

   public QueryBean(String temptxtVoucherId,String temptxtVoucherNo,String temptxtVoucherDate,String temptxtDocRef,String temptxtDocRem,String temptxtVhStat,String temptxtAuthCmnt)
   {
      this.txtVoucherId=temptxtVoucherId;
      this.txtVoucherNo=temptxtVoucherNo;
      this.txtVoucherDate=temptxtVoucherDate;
      this.txtDocRef=temptxtDocRef;
      this.txtDocRem=temptxtDocRem;
      this.txtVhStat=temptxtVhStat;
      this.txtHidVoucherNo=temptxtVoucherNo;
      this.txtAuthCmnt=temptxtAuthCmnt;
   }   

   public String gettxtVoucherId() 
   {
      return this.txtVoucherId;
   }
   public String gettxtVoucherNo() 
   {
      return this.txtVoucherNo;   
   }
   public String gettxtVoucherDate() 
   {
      return this.txtVoucherDate;
   }
   public String gettxtDocRef() 
   {
      return this.txtDocRef;     
   }
   public String gettxtDocRem() 
   {
      return this.txtDocRem;      
   }
   public String gettxtVhStat() 
   {
      return this.txtVhStat;      
   }
   public String gettxtHidVoucherNo() 
   {
      return this.txtHidVoucherNo;      
   }
   
   public String toString() 
   {
      StringBuffer strBuf=new StringBuffer();
      strBuf.append(this.txtVoucherId);strBuf.append("|");
      strBuf.append(this.txtVoucherNo);strBuf.append("|");
      strBuf.append(this.txtVoucherDate);strBuf.append("|");
      strBuf.append(this.txtDocRef);strBuf.append("|");
      strBuf.append(this.txtDocRem);strBuf.append("|");
      strBuf.append(this.txtVhStat);strBuf.append("|");
      strBuf.append(this.txtAuthCmnt);
      System.out.println(strBuf.toString());
      return strBuf.toString();
   }

    public String getTxtAuthCmnt() {
        return txtAuthCmnt;
    }
}