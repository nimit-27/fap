package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

public class CommonSearchScreenForm extends ActionForm 
{
    private String  txtId="";
	 private String  txtDesc="";
	 private String  selRadio="";
	 private String[]  txtIds=null;
	 private String[]  txtDescs=null;
    private String[]  txtIdValues=null;
	 private String  txtHidSubmitFirst="";
	 private String  txtHidAction="";
	 private String  txtHidSelectedValue="";
	 private String  txtHidTotRows="-1";
    
    private ArrayList lstSearchResult=new ArrayList();

	 private String  txtHidWhField="";
    private String  txtIdLength="";
    private String  txt_Id="";
    private String  txt_Code="";
    private String  txt_Desc="";
    private String  txt_AddCond="";
    private String  txtTable="";    

	    
   public CommonSearchScreenForm() {
      System.out.println("Common Search Form Constructor Called");
      lstSearchResult.clear();
      txtId="";
      txtDesc="";
      txtHidSubmitFirst="";
	   txtHidWhField="";
      txtIdLength="";
      txt_Id="";
      txt_Code="";
      txt_Desc="";
      txt_AddCond="";
      txtTable="";    
   }
   
   public void onLoadReset()   {
      txtId="";
      txtDesc="";
      selRadio="";
      txtIds=null;
      txtDescs=null;
      txtHidTotRows="-1";  
      lstSearchResult.clear();
   }//End-Reset

   public void FormReset()   {
      txtId="";
      txtDesc="";
      selRadio="";
      txtIds=null;
      txtDescs=null;
      txtHidSubmitFirst="";
      txtHidAction="";
      txtHidSelectedValue="";
      txtHidWhField="";
      txtHidTotRows="-1";  
      lstSearchResult.clear();
   }//End-Reset

	//Setter Methods 
   
	public void settxtId(String temptxtId) {
		this.txtId=temptxtId;
	}

	public void settxtDesc(String temptxtDesc) {
		this.txtDesc=temptxtDesc;
	}

	public void setselRadio(String tempselRadio) {
		this.selRadio=tempselRadio;
	}

	public void settxtIds(String[] temptxtIds) {
		this.txtIds=temptxtIds;
	}

	public void settxtDescs(String[] temptxtDescs) {
		this.txtDescs=temptxtDescs;
	}

   public void settxtIdValues(String[] temptxtIdValues) {
		this.txtIdValues=temptxtIdValues;
	}

	public void settxtHidSubmitFirst(String temptxtHidSubmitFirst) {
		this.txtHidSubmitFirst=temptxtHidSubmitFirst;
	}

	public void settxtHidAction(String temptxtHidAction) {
		this.txtHidAction=temptxtHidAction;
	}

	public void settxtHidSelectedValue(String temptxtHidSelectedValue) {
		this.txtHidSelectedValue=temptxtHidSelectedValue;
	}

	public void settxtHidWhField(String temptxtHidWhField) {
		this.txtHidWhField=temptxtHidWhField;
	}

	public void settxtHidTotRows(String temptxtHidTotRows) {
		this.txtHidTotRows=temptxtHidTotRows;
	}

   public void setlstSearchResult(ArrayList tempLstSearchResult) 
   {
      this.lstSearchResult=tempLstSearchResult;
   }

   public void settxtIdLength(String temptxtIdLength) {
		this.txtIdLength=temptxtIdLength;
	}

	public void settxt_Id(String temptxt_Id) {
		this.txt_Id=temptxt_Id;
	}
	public void settxt_Code(String temptxt_Code) {
		this.txt_Code=temptxt_Code;
	}

	public void settxt_Desc(String temptxt_Desc) {
		this.txt_Desc=temptxt_Desc;
	}
	public void settxtTable(String temptxtTable) {
		this.txtTable=temptxtTable;
	}
    public void settxt_AddCond(String temptxt_AddCond) {
        this.txt_AddCond=temptxt_AddCond;
    }
	//Getter Methods 

	public String gettxtId() {
		return this.txtId;
	}

	public String gettxtDesc() {
		return this.txtDesc;
	}

	public String getselRadio() {
		return this.selRadio;
	}

	public String[] gettxtIds() {
		return this.txtIds;
	}

	public String[] gettxtDescs() {
		return this.txtDescs;
	}

   public String[] gettxtIdValues() {
		return this.txtIdValues;
	}

	public String gettxtHidSubmitFirst() {
		return this.txtHidSubmitFirst;
	}

	public String gettxtHidAction() {
		return this.txtHidAction;
	}

	public String gettxtHidSelectedValue() {
		return this.txtHidSelectedValue;
	}

	public String gettxtHidWhField() {
		return this.txtHidWhField;
	}

	public String gettxtHidTotRows() {
		return this.txtHidTotRows;
	}

   public ArrayList getlstSearchResult() {
		return this.lstSearchResult;
	}   

   public String gettxtIdLength() 
   {
      return this.txtIdLength;
   }
   public String gettxt_Id() 
   {
      return this.txt_Id;
   }
   public String gettxt_Code() 
   {
      return this.txt_Code;
   }
   public String gettxt_Desc() 
   {
      return this.txt_Desc;
   }
   public String gettxtTable() 
   {
      return this.txtTable;
   }
   public String gettxt_AddCond() {
       return this.txt_AddCond;
   }

}//End - SearchIdDescForm