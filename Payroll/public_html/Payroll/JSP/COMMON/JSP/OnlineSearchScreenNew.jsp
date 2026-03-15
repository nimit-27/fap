<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="FCIPAY.Payroll.common.utility.EnrgiseConstants" %>

<html:html locale="true">
<head>
  <html:base />
  <LINK href="../../INCLUDES/ENRGISE.css" rel=stylesheet> <title>Search</title>
  </head>
<html:errors />

<body onload="checkOnLoad();" scroll=no> 

<html:form  name="CreateSearchPayScreen"  action="/onlinesearchscreennew"  type="FCIPAY.Payroll.common.webtier.form.NewLovForm" method="post">
<!-- Hidden Fields -->     
<html:hidden property="txtHidSubmitFirst" value="true" />
<html:hidden property="txtHidAction" />
<html:hidden property="txtHidSelectedValue" />
<html:hidden property="txtHidTotRows" />
<html:hidden property="txtHidTotCols" />

<!-- Hidden Field Added by Baqlpreet Dt 30 Nov 2007 -->
<html:hidden property="txtInputField" />

<!-- Hidden Fields For Parent Field -->
<input type="hidden" name="openerFieldName1" >  
<input type="hidden" name="openerFieldName2" >  
<input type="hidden" name="openerFieldName3" >  
<input type="hidden" name="openerFieldName4" >  
<input type="hidden" name="openerFieldName5" >  
<input type="hidden" name="openerFieldName6" >  
<input type="hidden" name="openerFieldName7" >  
<input type="hidden" name="openerFieldName8" >  
<input type="hidden" name="openerFieldName9" >  
<input type="hidden" name="openerFieldName10" >  
<input type="hidden" name="openerFieldName11" >  
<input type="hidden" name="openerFieldName12" >  
<input type="hidden" name="openerFieldName13" >  
<input type="hidden" name="openerFieldName14" >  
<input type="hidden" name="openerFieldName15" >  
<input type="hidden" name="openerFieldName16" >  
<input type="hidden" name="openerFieldName17" >
<input type="hidden" name="openerFieldName18" >
<input type="hidden" name="openerFieldName19" >
<input type="hidden" name="openerFieldName20" >

<html:hidden property="searchFieldName1" />  
<html:hidden property="searchFieldName2" />  
<html:hidden property="searchFieldName3" /> 
<html:hidden property="searchFieldName4" />  <!--added by devendra on 16th aug 2010-->
<!--added by neeraj on 5oct 2010-->
<html:hidden property="searchFieldName5" />
<html:hidden property="searchFieldName6" />
<!--End of addition by neeraj-->

<html:hidden property="lovKey" />
<html:hidden property="insertFlag" />
<input type="hidden" name="multipleFlag" />
<html:hidden property="queryParam" />
<html:hidden property="hdnLOVFlag" name="CreateSearchPayScreen" />


<bean:define id="SearchField1" name="CreateSearchPayScreen" property="searchFieldName1"/>
<bean:define id="SearchField2" name="CreateSearchPayScreen" property="searchFieldName2"/>
<bean:define id="SearchField3" name="CreateSearchPayScreen" property="searchFieldName3"/>
<bean:define id="SearchField4" name="CreateSearchPayScreen" property="searchFieldName4"/><!--added by devendra on 16th aug 2010-->
<!--Added by neeraj starts-->
<bean:define id="SearchField5" name="CreateSearchPayScreen" property="searchFieldName5"/>
<bean:define id="SearchField6" name="CreateSearchPayScreen" property="searchFieldName6"/>
<!--Added by neeraj ends-->
<bean:define id="lovFlag" name="CreateSearchPayScreen" property="hdnLOVFlag"/>


<table cellpadding="0" cellspacing="0" class="blueBar">
  <tr >
     <logic:notEqual name="CreateSearchPayScreen" property="searchFieldName1" value="NULL" >
      <td width="15%" align="right"><bean:message key="<%=String.valueOf(SearchField1)%>" /></td>
      <td width="20%" align="left"><html:text property="searchField1" size="15" /></td>
     </logic:notEqual>
     <logic:notEqual name="CreateSearchPayScreen" property="searchFieldName2" value="NULL" >
        <td width="15%" align="right"><bean:message key="<%=String.valueOf(SearchField2) %>" /></td>
        <td width="20%" align="left"><html:text property="searchField2" size="15" /></td>
     </logic:notEqual>
     <logic:notEqual name="CreateSearchPayScreen" property="searchFieldName3" value="NULL" >
        <td width="15%" align="right"><bean:message key="<%=String.valueOf(SearchField3) %>" /></td>
        <td width="20%" align="left"><html:text property="searchField3" size="15" /></td>
     </logic:notEqual>
     <logic:notEqual name="CreateSearchPayScreen" property="searchFieldName4" value="NULL" >
        <td width="15%" align="right"><bean:message key="<%=String.valueOf(SearchField4) %>" /></td>
        <td width="20%" align="left"><html:text property="searchField4" size="15" /></td>
     </logic:notEqual>
	 <!-- added by devendra on 16th aug 2010 start-->
		<logic:notEqual name="CreateSearchPayScreen" property="searchFieldName5" value="NULL" >
        <td width="15%" align="right"><bean:message key="<%=String.valueOf(SearchField5) %>" /></td>
        <td width="20%" align="left"><html:text property="searchField5" size="15" /></td>
     </logic:notEqual>
	<!-- added by devendra on 16th aug 2010 end-->
<!--added by neeraj on 5oct 2010-->
	<logic:notEqual name="CreateSearchPayScreen" property="searchFieldName6" value="NULL" >
        <td width="15%" align="right"><bean:message key="<%=String.valueOf(SearchField6) %>" /></td>
        <td width="20%" align="left"><html:text property="searchField6" size="15" /></td>
     </logic:notEqual>
     
<!-- added by neeraj on 5oct 2010 ends-->
     <td width="30%" align="right" ><html:button accesskey="S" property="butSearch" onclick="Search();" value="Search" /></td>
       </tr>
</table>
<%
if(lovFlag.equals("1")){
System.out.println("LOVflag---->"+lovFlag);
%>
<logic:greaterThan name="CreateSearchPayScreen" property="txtHidTotRows" value="0" >
<table width="100%">
  <center><td align="left" ><strong><font color="blue" ><bean:write name="CreateSearchPayScreen" property="txtHidTotRows" /> Matching Rows Found</font></strong></td></center>
</table>
</logic:greaterThan>
<logic:lessEqual name="CreateSearchPayScreen" property="txtHidTotRows" value="0" >
<table width="100%">
<center><td align="left" ><strong><font color="red" >No Matching Rows Found</font></strong></td></center>
</table>
</logic:lessEqual>
<%}%>

<div id="divDtlTable" style="height:310px">
<table id="tableId" cellpadding="0" cellspacing="0">
  <logic:greaterThan name="CreateSearchPayScreen" property="txtHidTotRows" value="0" >
  <bean:define id="oVisib" name="CreateSearchPayScreen" property="visibilityList" type="java.util.ArrayList" />
  <tr>    
    <logic:equal name="CreateSearchPayScreen" property="multipleFlag" value="true" >
    <td width="5%" class="tableHeader" ><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
    </logic:equal>
    <logic:notEqual name="CreateSearchPayScreen" property="multipleFlag" value="true" >
    <td width="5%" class="tableHeader" >Select</td>
    </logic:notEqual>
   
   <logic:iterate name="CreateSearchPayScreen" property="headerList" id="Index" indexId="hIdx">
      <%
      if(oVisib.get(hIdx.intValue()).equals(EnrgiseConstants.VISIBLE)){%>
        <td class="tableHeader" >
          <bean:write name="Index" />
        </td>
      <%
      }
      %>
   </logic:iterate> 
  </tr> 
  
<logic:iterate name="CreateSearchPayScreen" property="detailList" id="oDtlList" type="FCIPAY.Payroll.common.bean.LOVBean" indexId="iDtl">
<tr>
	  <td width="5%" align="center">
      <logic:equal name="CreateSearchPayScreen" property="multipleFlag" value="true" >
        <html:checkbox  property="selRadio" onclick="setSelectedValue(this.value)"  value="<%=String.valueOf(iDtl)%>" />
      </logic:equal>
      <logic:notEqual name="CreateSearchPayScreen" property="multipleFlag" value="true" >
        <html:radio property="selRadio" onclick="setSelectedValue(this.value)"  value="<%=String.valueOf(iDtl)%>" />
      </logic:notEqual>
    </td>
    
    <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="1">
      <%if(oVisib.get(0).equals(EnrgiseConstants.VISIBLE)){%>
	   
	   <td align="center">
         <html:text property="detailField1" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField1" name="oDtlList" />   
       <%}%>    
    </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="2">
    <%if(oVisib.get(1).equals(EnrgiseConstants.VISIBLE)){%>
	
      <td align="center">
       <html:text property="detailField2" name="oDtlList" style="width:100%" readonly="true" />
      </td>
    <%}else{%>
      <html:hidden property="detailField2" name="oDtlList" />   
    <%}%>    
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="3">
   <%if(oVisib.get(2).equals(EnrgiseConstants.VISIBLE)){%>
   
    <td align="center">
     <html:text property="detailField3" name="oDtlList" style="width:100%" readonly="true" />
    </td>
   <%}else{%>
     <html:hidden property="detailField3" name="oDtlList" />   
   <%}%>    
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="4">
    <%if(oVisib.get(3).equals(EnrgiseConstants.VISIBLE)){%>
      <td align="center">
       <html:text property="detailField4" name="oDtlList" style="width:100%" readonly="true" />
      </td>
     <%}else{%>
       <html:hidden property="detailField4" name="oDtlList" />   
     <%}%>    
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="5">
  <%if(oVisib.get(4).equals(EnrgiseConstants.VISIBLE)){%>
    <td align="center">
     <html:text property="detailField5" name="oDtlList"  style="width:100%" readonly="true" />
    </td>
   <%}else{%>
     <html:hidden property="detailField5" name="oDtlList" />   
   <%}%>      
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="6">
  <%if(oVisib.get(5).equals(EnrgiseConstants.VISIBLE)){%>
    <td align="center">
     <html:text property="detailField6" name="oDtlList"  style="width:100%" readonly="true" />
    </td>
   <%}else{%>
     <html:hidden property="detailField6" name="oDtlList" />   
   <%}%>    
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="7">
       <%if(oVisib.get(6).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField7" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField7" name="oDtlList" />   
       <%}%>    
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="8">
      <%if(oVisib.get(7).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField8" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField8" name="oDtlList" />   
       <%}%>    
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="9">
       <%if(oVisib.get(8).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField9" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField9" name="oDtlList" />   
       <%}%>    
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="10">
       <%if(oVisib.get(9).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField10" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField10" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="11">
       <%if(oVisib.get(10).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField11" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField11" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="12">
       <%if(oVisib.get(11).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField12" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField12" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="13">
       <%if(oVisib.get(12).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField13" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField13" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="14">
       <%if(oVisib.get(13).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField14" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField14" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="15">
       <%if(oVisib.get(14).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField15" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField15" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual> 
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="16">
       <%if(oVisib.get(15).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField16" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField16" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="17">
       <%if(oVisib.get(16).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField17" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField17" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="18">
       <%if(oVisib.get(17).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField18" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField18" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="19">
       <%if(oVisib.get(18).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField19" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField19" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>
  <logic:greaterEqual name="CreateSearchPayScreen" property="txtHidTotCols" value="20">
       <%if(oVisib.get(19).equals(EnrgiseConstants.VISIBLE)){%>
        <td align="center">
         <html:text property="detailField20" name="oDtlList" style="width:100%" readonly="true" />
        </td>
       <%}else{%>
         <html:hidden property="detailField20" name="oDtlList" />   
       <%}%>     
  </logic:greaterEqual>  
  </tr>

   </logic:iterate>
</table>

</div>
<table width="100%" border="0" class="blueBar">
  <tr>
    <td width="25%" align="center">&nbsp;</td>
    <td width="50%" align="center">
      <table width="100%" border="0" class="blueBar">
        <tr>
          <td align="center"><html:button accesskey="S" property="butSave" onclick="Save_Exit();" value="Select" /></td>
          <td align="center"><html:button property="butClose" onclick="window.close()" value="   Exit   " /></td>
          <td align="center"><html:button property="butClear" onclick="Clear()" value="Clear & Exit" /></td>
        </tr>
      </table>
    </td>     
    <td width="25%" align="center">&nbsp;</td>
  </tr>
</table>
</logic:greaterThan>


<bean:define id="colCount" name="CreateSearchPayScreen" property="txtHidTotCols" />
<input type="hidden" name="colCount" value="<%=colCount%>" >

</html:form>
</body>
</html:html>




<script language="javascript" >
var iOpenerFieldCount;

function setOpenerFields(fieldString)
{   
  aryOpener = new Array();
  aryOpener = fieldString.split(",");
  iOpenerFieldCount=aryOpener.length;
  //alert('iOpenerFieldCount:::'+iOpenerFieldCount)
  //If no opener fields are specified.
  if(iOpenerFieldCount==0)
  {
    alert("At least 1 opener fieldmust be specified");
    return;
  }
  for(i=0; i<iOpenerFieldCount;i++){
    if(aryOpener[i]){
      document.getElementById("openerFieldName"+(i+1)).value= aryOpener[i];
	  //alert('aryOpener[i]:::'+aryOpener[i]);
    }
  }
}

function setSearchFields(fieldString)
{
  arySearch = new Array();
  arySearch = fieldString.split(",");  
  if(arySearch[0]){
    CreateSearchPayScreen.searchFieldName1.value = arySearch[0];
  }
  else{
    CreateSearchPayScreen.searchFieldName1.value = "NULL";
  }
  
  if(arySearch[1]){
    CreateSearchPayScreen.searchFieldName2.value = arySearch[1];
  }
  else{
    CreateSearchPayScreen.searchFieldName2.value = "NULL";
  }
  
  if(arySearch[2]){
    CreateSearchPayScreen.searchFieldName3.value = arySearch[2];
  }
  else{
    CreateSearchPayScreen.searchFieldName3.value = "NULL";
  }  
  
  // added by devendra on 16th aug 2010 start
  
  
  if(arySearch[3]){
    CreateSearchPayScreen.searchFieldName4.value = arySearch[3];
  }
  else{
    CreateSearchPayScreen.searchFieldName4.value = "NULL";
  }
  
  // added by devendra on 16th aug 2010 end
  //added by neeraj starts here//
  
  if(arySearch[4]){
    CreateSearchPayScreen.searchFieldName5.value = arySearch[4];
  }
  else{
    CreateSearchPayScreen.searchFieldName5.value = "NULL";
  }
  
  if(arySearch[5]){
    CreateSearchPayScreen.searchFieldName6.value = arySearch[5];
  }
  else{
    CreateSearchPayScreen.searchFieldName6.value = "NULL";
  }

  
  //added by neeraj ends here//
}

function checkOnLoad(){
	//alert('inside checkOnLoad function')
   //Set the Display Fields (for return to parent form)
   //--------------------------------------------------
   if(opener.document.getElementById("txtDisplayFields"))
    setOpenerFields(opener.document.all.item("txtDisplayFields").value);
   else
    alert('txtDisplayFields not defined as hidden field in jsp');
   
   //Set the Search fields. 
   //----------------------
   if(opener.document.all.item("txtSearchFields")){
       setSearchFields(opener.document.all.item("txtSearchFields").value);
	   //alert('search fields are :' +opener.document.all.item("txtSearchFields").value)
   }
   
   //Set Multiple Flag.
   //-------------------
   if(opener.document.all.item("multipleFlag")){
    CreateSearchPayScreen.multipleFlag.value=opener.document.all.item("multipleFlag").value;
    
   }
    
   //Set query Param  
   //---------------
   if(opener.document.all.item("queryParam")){
     CreateSearchPayScreen.queryParam.value=opener.document.all.item("queryParam").value;
   }

     
   //Set the LovKey  
   //--------------
   if(opener.document.all.item("lovKey"))
     CreateSearchPayScreen.lovKey.value=opener.document.all.item("lovKey").value;
   else
     alert('lovKey not defined as hidden field in jsp page'); 
    
    //ColCount is used to check for first submit.
    //-------------------------------------------
    if(CreateSearchPayScreen.colCount.value=="0"){
      CreateSearchPayScreen.txtHidAction.value="FirstTime";
      CreateSearchPayScreen.submit();
   }
}

function setSelectedValue(Val)
{
   CreateSearchPayScreen.txtHidSelectedValue.value=Val;
   //alert('Val : '+Val)
}

function Search()
{   
	
	document.getElementById("butSearch").disabled=true;

if(	((typeof(CreateSearchPayScreen.searchField1)=='object')?(CreateSearchPayScreen.searchField1.value):"")=="" &&
	((typeof(CreateSearchPayScreen.searchField2)=='object')?(CreateSearchPayScreen.searchField2.value):"")=="" &&
	((typeof(CreateSearchPayScreen.searchField3)=='object')?(CreateSearchPayScreen.searchField3.value):"")=="" &&
	((typeof(CreateSearchPayScreen.searchField4)=='object')?(CreateSearchPayScreen.searchField4.value):"")=="" &&
	((typeof(CreateSearchPayScreen.searchField5)=='object')?(CreateSearchPayScreen.searchField5.value):"")=="" &&
	((typeof(CreateSearchPayScreen.searchField6)=='object')?(CreateSearchPayScreen.searchField6.value):"")=="" )

	{
		alert("Please define atleast one searching criteria.");
		return false;
	}
      CreateSearchPayScreen.hdnLOVFlag.value="1";
      CreateSearchPayScreen.txtHidAction.value="SearchRecords";
      CreateSearchPayScreen.submit();
}

function Save_Exit()
{ 
   var j="";
   var inputfield="";
   if(opener.document.all.item("txtInputField"))
   {
    inputfield=opener.document.all.item("txtInputField").value;
   // alert("111111---->"+inputfield);
   }
   if(opener.document.all.item("txtIndex"))
      j = opener.document.all.item("txtIndex").value;
     // alert("value of j----------------->"+j);
     //alert("CreateSearchPayScreen.txtHidSelectedValue.value--->"+CreateSearchPayScreen.txtHidSelectedValue.value);
   if(CreateSearchPayScreen.txtHidSelectedValue.value!="")
   {                
//alert("222222222222222222222222222222222222222222222222222222222222");
      //If Multiple flag is true
      //------------------------
      //alert("CreateSearchPayScreen.multipleFlag.value--->"+CreateSearchPayScreen.multipleFlag.value);
      if(CreateSearchPayScreen.multipleFlag.value=="true")
      {
        //alert("33333333333333333333333333333333333333333333333333333");
          var iCols=CreateSearchPayScreen.colCount.value;          
          var iRows=document.getElementsByName("selRadio").length;
          //alert("iCols-------->"+iCols);
          //alert("iRows-------->"+iRows);
          var arrTable=new Array();
          var arrRow=new Array();
          var iCol,iRow,i=0;  
          for(iRow=0;iRow<iRows;iRow++){
            if(document.getElementsByName("selRadio")[iRow].checked){
                arrRow=new Array();
                for(iCol=0;iCol<iCols;iCol++){
                  arrRow[iCol]=document.getElementsByName("detailField"+(iCol+1))[iRow].value;
                  //alert("arrROw-------->"+arrRow[iCol]);
                }
                arrTable[i++]=arrRow;
            }
          }
          
          if(opener.doSetFields){
              opener.document.all.multipleFlag.value="false";
              opener.doSetFields(arrTable,arrTable.length,iCols);
          }
          else{
              alert('doSetFields() not set in form');    
          }
      }
      else{
      //alert("OpenerFieldCount--->"+iOpenerFieldCount);
          //For setting single Header
          //-------------------------
          if(j=="" ){
            for(i=0;i<iOpenerFieldCount;i++){
              var sOpenerField=document.getElementById("openerFieldName"+(i+1));
              //alert("sOpenerField----->"+sOpenerField.value);
               opener.document.getElementById(sOpenerField.value).value=document.getElementsByName("detailField"+(i+1))[CreateSearchPayScreen.txtHidSelectedValue.value].value;              
              //alert("sOpenerField.value---->"+sOpenerField.value);
            }
          }
          //For setting Single Detail
          //-------------------------
          else{
            for(i=0;i<iOpenerFieldCount;i++){
               var oo=document.getElementById("openerFieldName"+(i+1)).value;
                var oOpenerDtlField=opener.document.getElementsByName(oo)[j];
              oOpenerDtlField.value=document.getElementsByName("detailField"+(i+1))[CreateSearchPayScreen.txtHidSelectedValue.value].value; 
             //alert("oOpenerDtlField.value----->"+oOpenerDtlField.value);
            }
            if(oOpenerDtlField.value != ""){
                opener.document.all.detailDataChanged.value="true";
            }
          }
      }
   }   
   CreateSearchPayScreen.txtHidSelectedValue.value="";   
   if(CreateSearchPayScreen.insertFlag.value=="Y")
   {
       opener.doGetInsertData();
       
   }
    CreateSearchPayScreen.txtHidAction.value="Exit";
    if(inputfield!="")
    {
        if(j=="")
        {
          var obInput=opener.document.all.item(inputfield);
        }else
        {
          var obInput=opener.document.all.item(inputfield)[j];
        }        
        obInput.onchange();
    }
    CreateSearchPayScreen.submit();  
   if(opener.doOnChangeLov)
   {
       if(opener.document.all.lovKey)
       {
        lovName=opener.document.all.lovKey.value;
       }
       opener.doOnChangeLov(lovName);
   }
    opener.document.getElementById("txtEmpNo").focus();
    self.close();
}

function Clear()
{
   var j="";
   var inputfield="";
   if(opener.document.all.item("txtInputField"))
   {
    inputfield=opener.document.all.item("txtInputField").value;
   }
   if(opener.document.all.item("txtIndex"))
      j = opener.document.all.item("txtIndex").value;
          //For setting single Header
          //-------------------------
          if(j=="" ){
            for(i=0;i<iOpenerFieldCount;i++){
              var sOpenerField=document.getElementById("openerFieldName"+(i+1));
              opener.document.getElementById(sOpenerField.value).value="";              
            }
          }
          //For setting Single Detail
          //-------------------------
          else{
            for(i=0;i<iOpenerFieldCount;i++){
               var oo=document.getElementById("openerFieldName"+(i+1)).value;
                var oOpenerDtlField=opener.document.getElementsByName(oo)[j];
             oOpenerDtlField.value=""; 
            }
          }
  CreateSearchPayScreen.txtHidSelectedValue.value="";   
   if(CreateSearchPayScreen.insertFlag.value=="Y")
   {
       opener.doGetInsertData();
       
   }
    CreateSearchPayScreen.txtHidAction.value="Exit";
    if(inputfield!="")
    {
        if(j=="")
        {
          var obInput=opener.document.all.item(inputfield);
        }else
        {
          var obInput=opener.document.all.item(inputfield)[j];
        }
        obInput.onchange();
    }
    CreateSearchPayScreen.submit();  
   if(opener.doOnChangeLov)
   {
       if(opener.document.all.lovKey)
       {
        lovName=opener.document.all.lovKey.value;
       }
       opener.doOnChangeLov(lovName);
   }

    self.close();
}

function setSelected()
{
  var oTable = document.getElementById("tableId");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

   for(i=0; i < iTr2 -1; i++)
    {
        alert(document.getElementsByName("detailField1")[i].value);
        alert(opener.document.all.item("txtInputField").value);
    }
}

function toggleCheckBox(param)
{ 
  var oTable = document.getElementById("tableId");
  if(oTable == null)
  {
    return;
  }
  for(i = 0; i < oTable.rows.length - 1; i ++)
  {
    if(document.getElementsByName(param)[0].checked == true)
    {
      CreateSearchPayScreen.txtHidSelectedValue.value=1;
      if(document.getElementsByName("selRadio")[i].disabled!=true)
        document.getElementsByName("selRadio")[i].checked="true";
    }
    else
    {
      document.getElementsByName("selRadio")[i].checked="";
    }
  }
}
</script> 
