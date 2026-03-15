/* 
 * Module:        QueryVoucherForm.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Oct - 2003 
 * Description:   This class Holds all the values of the form(QueryVoucherForm.jsp)
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
*/

package FCIPAY.HRMS.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class QueryVoucherForm extends ActionForm
{
   private String txtSubmitFirst="";
   private String txtHidAction="";
   private String txtHidSelectedValue="";
   private String txtHidTotRows="";
   private String txtHidVouchType="";
   private String txtTransStatus=""; 
   private String selRadio="";

   private ArrayList lstSearchResult=new ArrayList();
   private String txtSMS;

   public String getselRadio() 
   {
      return this.selRadio;
   }
   public void setselRadio(String a) 
   {
      this.selRadio=a;
   }
   public String gettxtSubmitFirst() 
   {
      return this.txtSubmitFirst;
   }
   public String gettxtHidAction() 
   {
      return this.txtHidAction;
   }
   public String gettxtHidSelectedValue() 
   {
      return this.txtHidSelectedValue;
   }
   public String gettxtHidTotRows() 
   {
      return this.txtHidTotRows;
   }
   public String gettxtHidVouchType() 
   {
      return this.txtHidVouchType;
   }
   public String gettxtTransStatus() 
   {
      return this.txtTransStatus;
   }
   public ArrayList getlstSearchResult() 
   {
      return this.lstSearchResult;
   }
   public void settxtSubmitFirst(String txtSubmitFirst) 
   {
      this.txtSubmitFirst=txtSubmitFirst;
   }
   public void settxtHidAction(String txtHidAction) 
   {
      this.txtHidAction=txtHidAction;
   }
   public void settxtHidSelectedValue(String txtHidSelectedValue) 
   {
      this.txtHidSelectedValue=txtHidSelectedValue;
   }
   public void settxtHidTotRows(String txtHidTotRows) 
   {
      this.txtHidTotRows=txtHidTotRows;
   }
   public void settxtHidVouchType(String txtHidVouchType) 
   {
      this.txtHidVouchType=txtHidVouchType;
   }
   public void settxtTransStatus(String txttransStatus) 
   {
      this.txtTransStatus=txttransStatus;
   }
   public void setlstSearchResult(ArrayList lsttransStatus) 
   {
      this.lstSearchResult=lsttransStatus;
   }

   public String getTxtSMS() {
      return txtSMS;
   }

   public void setTxtSMS(String newTxtSMS) {
      txtSMS = newTxtSMS;
   }

}