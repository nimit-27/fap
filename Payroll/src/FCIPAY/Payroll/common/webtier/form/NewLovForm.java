/*
 * Program Name : NewLovForm.java
 * Author       : Neeraj Gupta
 * Date Written : 06/10/2010
 * Description  : This is the Action Form for newlovform which is to get values from the page
 *
*/


package FCIPAY.Payroll.common.webtier.form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class NewLovForm extends ActionForm  {
  private String [] detailField1;
  private String [] detailField2;
  private String [] detailField3;
  private String [] detailField4;
  private String [] detailField5;
  private String [] detailField6;
  private String [] detailField7;
  private String [] detailField8;
  private String [] detailField9;
  private String [] detailField10;
  private String [] detailField11;
  private String [] detailField12;
  private String [] detailField13;
  private String [] detailField14;
  private String [] detailField15;
  private String [] detailField16;
  private String [] detailField17;
  private String [] detailField18;
  private String [] detailField19;
  private String [] detailField20;
  private String selRadio;
 
  private ArrayList detailList;
  
  private String userAction;
  private String txtHidSubmitFirst;
  private String txtHidAction = "FirstTime";
  private String txtHidSelectedValue;
  private String hdnAction;
  
  private int txtHidTotRows;
  private int txtHidTotCols;
  
  private String lovKey;
  
  private String searchField1;
  private String searchField2;
  private String searchField3;
  private String searchField4; // added by devendra on 16th aug 2010
  
  private String searchField5; //added by neeraj starts
  private String searchField6;
  //private String searchField7;
 // private String searchField8; //added by neeraj ends
  private String insertFlag;
  private String searchFieldName1="wenrgise.lov.SearchField1";
  private String searchFieldName2="wenrgise.lov.SearchField2";
  private String searchFieldName3="wenrgise.lov.SearchField3";
  private String searchFieldName4="wenrgise.lov.SearchField4"; // added by devendra on 16th aug 2010
  private String searchFieldName5="wenrgise.lov.SearchField5"; //added by neeraj
  private String searchFieldName6="wenrgise.lov.SearchField6"; //added by neeraj
//  private String searchFieldName7="wenrgise.lov.SearchField7"; //added by neeraj
 // private String searchFieldName8="wenrgise.lov.SearchField8"; //added by neeraj
  private String multipleFlag;
  private String queryParam;
  private ArrayList headerList;
  private ArrayList visibilityList;
  private String hdnLOVFlag="0";
  private String txtInputField;
  private String selectAll;
	
  
  public NewLovForm()
  {
  } 

  public ArrayList getDetailList()
  {
    return detailList;
  }

  public void setDetailList(ArrayList newDetailList)
  {
    detailList = newDetailList;
  }

  public String getSelRadio()
  {
    return selRadio;
  }

  public void setSelRadio(String newSelRadio)
  {
    selRadio = newSelRadio;
  }

  public String getUserAction()
  {
    return userAction;
  }

  public void setUserAction(String newUserAction)
  {
    userAction = newUserAction;
  }

  public String getTxtHidAction()
  {
    return txtHidAction;
  }

  public void setTxtHidAction(String newTxtHidAction)
  {
    txtHidAction = newTxtHidAction;
  }

  public String getTxtHidSelectedValue()
  {
    return txtHidSelectedValue;
  }

  public void setTxtHidSelectedValue(String newTxtHidSelectedValue)
  {
    txtHidSelectedValue = newTxtHidSelectedValue;
  }

  public String getTxtHidSubmitFirst()
  {
    return txtHidSubmitFirst;
  }

  public void setTxtHidSubmitFirst(String newTxtHidSubmitFirst)
  {
    txtHidSubmitFirst = newTxtHidSubmitFirst;
  }

  public String getSearchField1()
  {
    return searchField1;
  }

  public void setSearchField1(String newSearchField1)
  {
    searchField1 = newSearchField1;
  }

  public String getLovKey()
  {
    return lovKey;
  }

  public void setLovKey(String newLovKey)
  {
    lovKey = newLovKey;
  }

  public int getTxtHidTotRows()
  {
    return txtHidTotRows;
  }

  public void setTxtHidTotRows(int newTxtHidTotRows)
  {
    txtHidTotRows = newTxtHidTotRows;
  }
  
  public void onLoadReset()
  {
      searchField1="";
      searchField2="";
      searchField3="";
      searchField4=""; // added by devendra on 16th aug 2010
      searchField5=""; //added by neeraj
      searchField6="";  //added by neeraj
      //searchField7="";  //added by neeraj
      //searchField8="";  //added by neeraj
      selRadio="";
      detailField1=null;
      detailField2=null;
      detailField3=null;
      detailField4=null;
      detailField5=null;
      detailField6=null;
      detailField7=null;
      detailField8=null;
      detailField9=null;
      detailField10=null;
      detailField11=null;
      detailField12=null;
      detailField13=null;
      detailField14=null;
      detailField15=null;
      detailField16=null;
      detailField17=null;
      detailField18=null;
      detailField19=null;
      detailField20=null;
      txtHidTotRows=-1;  
      txtHidTotCols=-1;  
      headerList.clear();
      detailList.clear();
  }




  public String[] getDetailField4()
  {
    return detailField4;
  }

  public void setDetailField4(String[] newDetailField4)
  {
    detailField4 = newDetailField4;
  }

  public String[] getDetailField5()
  {
    return detailField5;
  }

  public void setDetailField5(String[] newDetailField5)
  {
    detailField5 = newDetailField5;
  }

  public String[] getDetailField6()
  {
    return detailField6;
  }

  public void setDetailField6(String[] newDetailField6)
  {
    detailField6 = newDetailField6;
  }

  public String[] getDetailField7()
  {
    return detailField7;
  }

  public void setDetailField7(String[] newDetailField7)
  {
    detailField7 = newDetailField7;
  }

  public String[] getDetailField8()
  {
    return detailField8;
  }

  public void setDetailField8(String[] newDetailField8)
  {
    detailField8 = newDetailField8;
  }

  public String[] getDetailField9()
  {
    return detailField9;
  }

  public void setDetailField9(String[] newDetailField9)
  {
    detailField9 = newDetailField9;
  }

  public String[] getDetailField10()
  {
    return detailField10;
  }

  public void setDetailField10(String[] newDetailField10)
  {
    detailField10 = newDetailField10;
  }

  public String getSearchField2()
  {
    return searchField2;
  }

  public void setSearchField2(String newSearchField2)
  {
    searchField2 = newSearchField2;
  }
  
  public String getSearchField3()
  {
    return searchField3;
  }

  public void setSearchField3(String newSearchField3)
  {
    searchField3 = newSearchField3;
  }
  // added by devendra on 16th aug 2010 start
  public String getSearchField4()
  {
    return searchField4;
  }

  public void setSearchField4(String newSearchField4)
  {
    searchField4 = newSearchField4;
  }
  // added by devendra on 16th aug 2010 end
  
//added by neeraj on 5 oct 2010 starts
  public String getSearchField5()
  {
    return searchField5;
  }

  public void setSearchField5(String newSearchField5)
  {
    searchField5 = newSearchField5;
  }
    public String getSearchField6()
  {
    return searchField6;
  }

  public void setSearchField6(String newSearchField6)
  {
    searchField6 = newSearchField6;
  }
   /* public String getSearchField7()
  {
    return searchField7;
  }

  public void setSearchField7(String newSearchField7)
  {
    searchField7 = newSearchField7;
  }
  
  public String getSearchField8()
  {
    return searchField8;
  }

  public void setSearchField8(String newSearchField8)
  {
    searchField8 = newSearchField8;
  }  
  */
  /*  public String getHdnAction() {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction) {
        hdnAction = newHdnAction;
    }

*/
//added by neeraj on 5 oct 2010 end
  

  public String[] getDetailField1()
  {
    return detailField1;
  }

  public void setDetailField1(String[] newDetailField1)
  {
    detailField1 = newDetailField1;
  }

  public String[] getDetailField2()
  {
    return detailField2;
  }

  public void setDetailField2(String[] newDetailField2)
  {
    detailField2 = newDetailField2;
  }

  public String[] getDetailField3()
  {
    return detailField3;
  }

  public void setDetailField3(String[] newDetailField3)
  {
    detailField3 = newDetailField3;
  }


  public int getTxtHidTotCols()
  {
    return txtHidTotCols;
  }

  public void setTxtHidTotCols(int newTxtHidTotCols)
  {
    txtHidTotCols = newTxtHidTotCols;
  }

  public String getInsertFlag()
  {
    return insertFlag;
  }

  public void setInsertFlag(String newInsertFlag)
  {
    insertFlag = newInsertFlag;
  }

  public String getSearchFieldName1()
  {
    return searchFieldName1;
  }

  public void setSearchFieldName1(String newSearchFieldName1)
  {
    searchFieldName1 = newSearchFieldName1;
  }

  public String getSearchFieldName2()
  {
    return searchFieldName2;
  }

  public void setSearchFieldName2(String newSearchFieldName2)
  {
    searchFieldName2 = newSearchFieldName2;
  }
  
  public String getSearchFieldName3()
  {
    return searchFieldName3;
  }

  public void setSearchFieldName3(String newSearchFieldName3)
  {
    searchFieldName3 = newSearchFieldName3;
  }
  
  //added by devendra on 16th aug 2010 start
   public String getSearchFieldName4()
  {
    return searchFieldName4;
  }

  public void setSearchFieldName4(String newSearchFieldName4)
  {
    searchFieldName4 = newSearchFieldName4;
  }
  // added by devendra on 16th aug 2010 end
//added by neeraj on 5 oct 2010 starts
 public String getSearchFieldName5()
  {
    return searchFieldName5;
  }

  public void setSearchFieldName5(String newSearchFieldName5)
  {
    searchFieldName5 = newSearchFieldName5;
  }
  
   public String getSearchFieldName6()
  {
    return searchFieldName6;
  }

  public void setSearchFieldName6(String newSearchFieldName6)
  {
    searchFieldName6 = newSearchFieldName6;
  }
  
   /*
   public String getSearchFieldName7()
  {
    return searchFieldName7;
  }

  public void setSearchFieldName7(String newSearchFieldName7)
  {
    searchFieldName7 = newSearchFieldName7;
  }
  
     public String getSearchFieldName8()
  {
    return searchFieldName8;
  }

  public void setSearchFieldName8(String newSearchFieldName8)
  {
    searchFieldName8 = newSearchFieldName8;
  }
  */
//added by neeraj on 5 oct 2010 ends
  public String getMultipleFlag()
  {
    return multipleFlag;
  }

  public void setMultipleFlag(String newMultipleFlag)
  {
    multipleFlag = newMultipleFlag;
  }

  public String getQueryParam()
  {
    return queryParam;
  }

  public void setQueryParam(String newQueryParam)
  {
    queryParam = newQueryParam;
  }

  public ArrayList getHeaderList()
  {
    return headerList;
  }

  public void setHeaderList(ArrayList newHeaderList)
  {
    headerList = newHeaderList;
  }

  public ArrayList getVisibilityList()
  {
    return visibilityList;
  }

  public void setVisibilityList(ArrayList newVisibilityList)
  {
    visibilityList = newVisibilityList;
  }

  public String getHdnLOVFlag()
  {
    return hdnLOVFlag;
  }

  public void setHdnLOVFlag(String newHdnLOVFlag)
  {
    hdnLOVFlag = newHdnLOVFlag;
  }
  
  public String getTxtInputField()
  {
    return txtInputField;
  }

  public void setTxtInputField(String newTxtInputField)
  {
    txtInputField = newTxtInputField;
  }
  
  public String[] getDetailField11()
  {
    return detailField11;
  }

  public void setDetailField11(String[] newDetailField11)
  {
    detailField11 = newDetailField11;
  }
  
  public String[] getDetailField12()
  {
    return detailField12;
  }

  public void setDetailField12(String[] newDetailField12)
  {
    detailField12 = newDetailField12;
  }
  
  public String[] getDetailField13()
  {
    return detailField13;
  }

  public void setDetailField13(String[] newDetailField13)
  {
    detailField13 = newDetailField13;
  }
  
  public String[] getDetailField14()
  {
    return detailField14;
  }

  public void setDetailField14(String[] newDetailField14)
  {
    detailField14 = newDetailField14;
  }
  
  public String[] getDetailField15()
  {
    return detailField15;
  }

  public void setDetailField15(String[] newDetailField15)
  {
    detailField15 = newDetailField15;
  }
  
  public String[] getDetailField16()
  {
    return detailField16;
  }

  public void setDetailField16(String[] newDetailField16)
  {
    detailField16 = newDetailField16;
  }
  
  public String[] getDetailField17()
  {
    return detailField17;
  }

  public void setDetailField17(String[] newDetailField17)
  {
    detailField17 = newDetailField17;
  }
  
  public String[] getDetailField18()
  {
    return detailField18;
  }

  public void setDetailField18(String[] newDetailField18)
  {
    detailField18 = newDetailField18;
  }
  
  public String[] getDetailField19()
  {
    return detailField19;
  }

  public void setDetailField19(String[] newDetailField19)
  {
    detailField19 = newDetailField19;
  }
  
  public String[] getDetailField20()
  {
    return detailField20;
  }

  public void setDetailField20(String[] newDetailField20)
  {
    detailField20 = newDetailField20;
  }

  public String getSelectAll()
  {
    return selectAll;
  }

  public void setSelectAll(String newSelectAll)
  {
    selectAll = newSelectAll;
  }
}