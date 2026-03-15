<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
  <HEAD>
    <html:base/>
      <TITLE><bean:message key="Payroll.title" /></TITLE>
      <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
      <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css"/>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
      <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
   </head>
<BODY onbeforeunload="confWindowClose()" onunload="handleOnClose()" onload="lfnLoad();history.forward(1);" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0; %>
<% i = 0; j=0; %>

<html:form  action="BasicHistoryEventAction" name="frmBasicHistoryEvent" type="FCIPAY.Payroll.WEBTIER.Form.BasicHistoryEventForm" scope="session">

<bean:define id="ParentForm" name="frmBasicHistoryEvent" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" />
<html:hidden property="headerFields" value="false" />


<table>
  <TR height=30>
    <TD  colSpan=12 class=mainHeader height=10><bean:message key="Payroll.BasicHistoryEvent.head" /></TD>
  </TR>
</TABLE>
<html:errors/>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
    <TR>
      <TD>	
        <!-- Body table Starts -->
        <TABLE cellSpacing=0 cellPadding=0 >
        <!--Account  Header Row Starts -->
          <TR>
            <TD class=subHeader colspan=6><bean:message key="Payroll.BasicHistoryEvent.empDetail" /></TD>
          </TR>
          <TR>
            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></img></TD>
          </TR>
       
          <tr>
          <td class="labelText"  width="20%" ><bean:message key="Payroll.BasicHistoryEvent.empNo" /></td>
          <td width="10%"><html:text  property="txtEmpId" altKey="Payroll.BasicHistoryEvent.empNo" maxlength="10" size="20" styleClass="required"/>&nbsp;
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();"/>&nbsp;
          </td>

          <td><html:text  property="txtEmpName" altKey="Payroll.BasicHistoryEvent.empName" maxlength="50" size="50" styleClass="locked" readonly="true" /></td>

          <td class="labelText"  width="10%" ><bean:message key="Payroll.BasicHistoryEvent.cpfCode" /></td>
          <td><html:text  property="txtCpfCode" altKey="Payroll.BasicHistoryEvent.cpfCode" maxlength="10" size="23" readonly="true" styleClass="required"/></td>

          </tr>
         </table>
    </div>
   
<table cellspacing=0 cellpadding=0 border=0>
<!-- Detail Information Row starts -->

<TR height="200">
<TD colspan=11>

<!-- Account Config Detail Table Starts -->
<TABLE cellspacing="0" cellPadding="0" >
  <TR>
    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"/></td>
    <td bgcolor="#4682B4" nowrap class=actTabText><bean:message key="Payroll.BasicHistoryEvent.detail" /><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"/></td>
    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"/></td>
    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"/></td>
 </TR>          
<TR height=10>                
<!-- Detail table Container starts -->
<TD colspan="11">
<TABLE cellSpacing="0" cellPadding="0" border="0">
<TBODY>
<TR>
<TD >
<DIV id=divDtlTable style="height:280px">
<!-- Detail table starts -->
<TABLE cellSpacing="0" cellPadding="0" id="Detail">
  <TBODY>
    <TR>
      <!--<TD class=tableHeader width="1%"><html:checkbox property="selectAll" disabled="true" /></TD>-->
      <td class=tableHeader><bean:message key="Payroll.BasicHistoryEvent.srno" /></td>
      <td class=tableHeader><bean:message key="Payroll.BasicHistoryEvent.eventEffDate"  /></td>
      <td class=tableHeader><bean:message key="Payroll.BasicHistoryEvent.incremetType" /></td>                                               
      <td class=tableHeader><bean:message key="Payroll.BasicHistoryEvent.eventType" /></td>
      <td class=tableHeader><bean:message key="Payroll.BasicHistoryEvent.amount" /></td>
      <td class=tableHeader><bean:message key="Payroll.BasicHistoryEvent.eventFlag" /></td>
      <td class=tableHeader><bean:message key="Payroll.BasicHistoryEvent.freeze" /></td>
    </TR>

    <bean:define id="newPgReq" name="ParentForm" property="pageRequested" type="java.lang.Long" />
    <%--<bean:define id="pageDetailCount" name="ParentForm" property="thisPageDetailCount" type="java.lang.Integer" />--%>
    <bean:define id="recordsPerPg" name="ParentForm" property="recordsPerPage" type="java.lang.Integer" />
    <%
        if(newPgReq>1){
        if(null!=recordsPerPg)
            j=(new Long(newPgReq).intValue()-1)*recordsPerPg;
        }
        
    %>

<logic:iterate id="intInfo" name="frmBasicHistoryEvent" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.BasicHistoryEventBean">
<% ++i; %>
<!--<logic:notEqual name="intInfo" property="status" value="D" >-->
<tr>   
   <!--<td ><html:checkbox property="checked" onclick="" value="false" name="frmBasicHistoryEvent"/></td>-->
   <!--<td></td>-->
   <% ++j; %>
    <td align=center><html:text property="txtSrlNo" name="intInfo" size="2" value="<%=String.valueOf(j)%>" styleClass="optional" readonly="true" alt="<%=String.valueOf(i)%>"/></td>         
    <td align=center><html:text property="txtEventEffDate" name="intInfo" styleClass="optional" size="15" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
    <td align=center><html:text property="txtIncrementType" name="intInfo" styleClass="optional" size="15" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
    <td align=center><html:text property="txtEventType" name="intInfo" styleClass="optional" size="15" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
    
    <bean:define id="freezeFlagValue" name="intInfo" property="txtFreezeFlag" type="java.lang.String" />
    <bean:define id="eventType" name="intInfo" property="txtEventType" type="java.lang.String" />
    <%if(freezeFlagValue.equals(new String("F"))) {%>
        <td align=center><html:text property="txtAmount" name="intInfo" styleClass="locked" size="15" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
    <%}else {if(eventType.equals(new String("Promotion reversal"))) {%>
        <td align=center><html:text property="txtAmount" name="intInfo" styleClass="optional" size="15" alt="<%=String.valueOf(i)%>"/></td>
    <%}else{%>
        <td align=center><html:text property="txtAmount" name="intInfo" styleClass="locked" size="15" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
    <%}}%>
    <td align=center>
    <%if(freezeFlagValue.equals(new String("F"))) {%>
    <html:select property="txtEventFlag" name="intInfo" styleClass="locked" style="width:35%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
                <html:option value="">-----Please Select-----</html:option>      
                <html:option value="Y">Yes</html:option>
                <html:option value="N">No</html:option>
    </html:select>
    <%} else {%>
    <html:select property="txtEventFlag" name="intInfo" styleClass="optional" style="width:35%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
                <html:option value="">-----Please Select-----</html:option>      
                <html:option value="Y">Yes</html:option>
                <html:option value="N">No</html:option>
    </html:select>
    <%}%>
    </td>
    <% if(freezeFlagValue.equals(new String("N"))) {%> 
        <td align=center><html:text value="Not Modified" name="intInfo" styleClass="locked" size="15" readonly="true" alt="<%=String.valueOf(i)%>" property="txtFreezeFlag"/></td>
    <%} else if(freezeFlagValue.equals(new String("Y"))) {  %>
        <td align=center><html:text value="Modified" name="intInfo" styleClass="locked" size="15" readonly="true" alt="<%=String.valueOf(i)%>" property="txtFreezeFlag"/></td>
    <%} else if(freezeFlagValue.equals(new String("F"))) {  %>
        <td align=center><html:text value="Freezed" name="intInfo" styleClass="locked" size="15" readonly="true" alt="<%=String.valueOf(i)%>" property="txtFreezeFlag"/></td>
    <%}%>
        
</tr>
<!--</logic:notEqual>-->

  <html:hidden property="itemChecked" name="intInfo" />
  <html:hidden property="status" name="intInfo"/>
  <html:hidden property="detailId" name="intInfo" value="Default" />
  
</logic:iterate>
       
</TBODY>
</TABLE>
</DIV>
</TD>
</TR>

<!-- Get details starts -->
<tr>
  <td colspan=11>	
    <TABLE border=0>
      <TBODY>
        <TR>
          <TD>
            <jsp:include  page = "../INCLUDES/GenDetailBasicHistEventMenu.jsp" flush="true" />
          </td>
        </TR>
      </TBODY>
    </TABLE>
  </TD>               
</tr>
</TBODY>
</TABLE>
</td>
</tr>  
</TABLE>
</td>
</tr>
<!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->

 <!-- Detail Information Row starts -->
 <TR height="50">
    <TD colspan=11>
   <TABLE cellspacing="0" cellPadding="0" >
   <TR>
   <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />

   <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
    <% if(smode.equals(new String("U"))) {%> 
    Update Mode
   <%} else if(smode.equals(new String("N"))) {  %>
    New Mode
   <%} else if(smode.equals(new String("Q"))) {  %>
    Query Mode
   <%}  %>
   </td> 

   <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></img></td>
</table>
</td>
</tr>
</TABLE> 
<!-- Container Table Ending Columns Starts-->
</TD>    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden property="headerPrimaryKey" name="frmBasicHistoryEvent"  />
<html:hidden property="screenMode" name="frmBasicHistoryEvent"  />
<html:hidden name="frmBasicHistoryEvent"  property="screenName" value="BasicHistoryEventScreen" />
<html:hidden name="frmBasicHistoryEvent"  property="forwardedPage" />
<!--<html:hidden name="frmBasicHistoryEvent"  property="headerFields" />-->
<!--<html:hidden name="frmBasicHistoryEvent"  property="totalDetailRecord" />-->
<html:hidden property="txtEmpNo" name="frmBasicHistoryEvent"  />
<html:hidden property="screenInt" name="frmBasicHistoryEvent"  />
<html:hidden property="lovKey" name="frmBasicHistoryEvent"  />
<html:hidden property="txtFields" name="frmBasicHistoryEvent"  />   
<html:hidden property="txtSearchFields" name="frmBasicHistoryEvent"  />
<html:hidden property="txtDisplayFields" name="frmBasicHistoryEvent"  />
<html:hidden property="txtIndex" name="frmBasicHistoryEvent"  />
<html:hidden property="txtInputField" name="frmBasicHistoryEvent"  />
<html:hidden property="buttonFlag" name="frmBasicHistoryEvent"  />
<html:hidden property="userPageRequested" name="frmBasicHistoryEvent" />
<html:hidden property="pageRequested" name="frmBasicHistoryEvent" />
<html:hidden property="loginLocCode" name="frmBasicHistoryEvent" />
<html:hidden property="txtSiteId" name="frmBasicHistoryEvent" />
<html:hidden property="txtSiteName" name="frmBasicHistoryEvent" />

<input type="hidden" name="queryParam" />
<input type="hidden" name="multipleFlag" />
<input type="hidden" id="submitParam" name="submitParam" /> 

</html:form>
</BODY>
</html:html>        

<script language="javascript">

function lfnLoad()
{
    mode = document.all.screenMode.value;
    frmBasicHistoryEvent.butGetDetail.disabled="true";
    //frmBasicHistoryEvent.butInsert.disabled="true";
    //frmBasicHistoryEvent.butDelete.disabled="true";
    if(mode=='')
    {
        doQueryMode();
    }
    if(mode=="U"){
        document.all.butExecute.disabled="true";
        document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
//        document.all.butSave.disabled="true";
//        document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmBasicHistoryEvent.butGetDetail.disabled="";
    }
    if(mode=="Q"){
        document.all.butSave.disabled="true";
        document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
//        document.all.butSaveFirst.disabled="true";
        document.all.txtCpfCode.value="";
    }
    if(mode=="N"){
        frmBasicHistoryEvent.butGetDetail.disabled="";
        //document.all.butSaveFirst.disabled="";
    }
    if (document.all.screenInt.value == "")
    {
        document.all.screenInt.value = "Q";
        document.all.screenMode.value = "Q";    
    }    
//    screenIntMode = document.all.screenInt.value;    
//    if(screenIntMode=='')
//    {
//        document.all.butGetDetail.disabled="";   
//    }
//    if(screenIntMode=='Q')
//    {
//        document.all.txtCpfCode.value="";
//    }
//    if(screenIntMode=='U')
//    {       
//        document.all.butGetDetail.disabled="";
//        var oTable = document.getElementById("Detail");
//        if(oTable == null)
//        {
//            return;
//        }
//    }
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    //menuHandling(mode); 
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
  
}

function ShowEmpNum(){
   frmBasicHistoryEvent.lovKey.value = "BasicHistoryEventEmpList" + frmBasicHistoryEvent.screenName.value + frmBasicHistoryEvent.screenMode.value;
   frmBasicHistoryEvent.queryParam.value = "txtSiteID="+frmBasicHistoryEvent.loginLocCode.value+",hdnEmpLbrFlag="+frmBasicHistoryEvent.hdnEmpLbrFlag.value;
   frmBasicHistoryEvent.txtDisplayFields.value = "txtEmpId,txtEmpName,txtCpfCode";
   frmBasicHistoryEvent.txtSearchFields.value = "Payroll.BasicHistoryEvent.empNo,Payroll.BasicHistoryEvent.empName,Payroll.BasicHistoryEvent.cpfCode";
   frmBasicHistoryEvent.txtIndex.value ="";      
   frmBasicHistoryEvent.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmBasicHistoryEvent');
   return true;
}

function doQueryMode()
{
    //document.frmBasicHistoryEvent.hdnAction.value = "";
    document.all.screenInt.value = 'Q';
    document.all.buttonFlag.value='';
    frmBasicHistoryEvent.headerDataChanged.value = "false";
    
    frmBasicHistoryEvent.action="../../../BasicHistoryEventQueryMode.do"
    frmBasicHistoryEvent.submit();
}

//function doInsertMode()
//{
//    if ( document.all.screenMode.value == "Q")
//        document.all.headerDataChanged.value='';
//    
//    document.all.buttonFlag.value='';
//    frmBasicHistoryEvent.action="../../../BasicHistoryEventNewMode.do"
//    frmBasicHistoryEvent.submit();
//}

function getHeaderRecord()
 {
   if(checkHeaderMandatory())
   {
    document.all.buttonFlag.value=''; 
    frmBasicHistoryEvent.action="../../../BasicHistoryEventGetHeaderAction.do";
    frmBasicHistoryEvent.submit();
   }
 }
 
function checkHeaderMandatory()
 {
    if(document.all.txtEmpId.value=="")
    {
      alert("Please Select/Enter Employee");
      return false;
    }
    return true;
}

//function doBaseAddRow()
//{
//    document.all.buttonFlag.value='D';
//    var oTable = document.getElementById("Detail");
//    if(oTable == null)
//    {
//        return;
//    }
//    var iTr2 = oTable.rows.length;        
//    var i = 0;
//    for(i=0; i < iTr2 -1; i++)
//    {
//        if (document.getElementsByName("status")[i].value == 'Q')
//        {                
//            document.getElementsByName("txtDepndntName")[i].disabled=""; 
//        }
//    }  
//   if(!mandatory_Check("frmBasicHistoryEvent"))
//     return false;
//    frmBasicHistoryEvent.headerPrimaryKey.value=frmBasicHistoryEvent.txtEmpId.value;
//    document.getElementById("txtEmpNo").disabled="";    
//    document.forms[0].action = "../../../BasicHistoryEventAddRowAction.do";
//    document.forms[0].submit();   
//}

function GetDetail()
{
    //document.all.butSaveFirst.disabled="";
    frmBasicHistoryEvent.screenMode.value='U';
    frmBasicHistoryEvent.headerDataChanged.value = "false";
    frmBasicHistoryEvent.headerPrimaryKey.value=frmBasicHistoryEvent.headerPrimaryKey.value;
    frmBasicHistoryEvent.headerPrimaryKey.disabled="";
    frmBasicHistoryEvent.action="../../../BasicHistoryEventGetDetailAction.do"
    frmBasicHistoryEvent.submit();
}

//function saveFirst()
//{ 
//var oTable = document.getElementById("Detail");
//  if(oTable == null)
//  {
//    return;
//  }
//  var iTr2 = oTable.rows.length;
//  var i = 0;
//  for(i=0; i < iTr2 -1; i++)
//  {
//    document.getElementsByName("status")[i].value = "N";
//    frmBasicHistoryEvent.detailDataChanged.value = "true";
//  }
//
//    frmBasicHistoryEvent.screenMode.value='N';
//    //frmBasicHistoryEvent.detailDataChanged.value = "true";
//    frmBasicHistoryEvent.headerFields.value = "false";
//    document.all.buttonFlag.value='';
//    frmBasicHistoryEvent.action="../../../BasicHistoryEventSaveAction.do"
//    frmBasicHistoryEvent.submit();
//}

function SaveRecord()
{ 
    if(mandatory_Check("frmBasicHistoryEvent"))
    {
        enableAll(); 
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;       
        for(i=0; i < iTr2 -1; i++)
        {
            document.getElementsByName("status")[i].value = "N";
            frmBasicHistoryEvent.detailDataChanged.value = "true";
        }
        document.all.buttonFlag.value='';
        frmBasicHistoryEvent.headerFields.value = "false";
        document.all.butSave.disabled="true";        
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmBasicHistoryEvent.action = "../../../BasicHistoryEventSaveAction.do";
        frmBasicHistoryEvent.submit();
    }
    else
    {
        return false;
    }
}

function enableAll()
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    
    for(i=0; i < iTr2 -1; i++)
    {
        //document.getElementsByName("txtEmpNo")[i].disabled="";
    }
}



function doRefresh()
{
    //document.frmBasicHistoryEvent.hdnAction.value = "";
    frmBasicHistoryEvent.action="../../../BasicHistoryEventRefresh.do"
    frmBasicHistoryEvent.submit();
}

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';  
    frmBasicHistoryEvent.userPageRequested.value = 1*frmBasicHistoryEvent.pageRequested.value - 1;
    frmBasicHistoryEvent.action = "../../../BasicHistoryEventNextDetailAction.do";
    frmBasicHistoryEvent.submit();
}

function doBaseNextDetail()
{
    document.all.buttonFlag.value='';  
    frmBasicHistoryEvent.userPageRequested.value = 1*frmBasicHistoryEvent.pageRequested.value + 1;
    frmBasicHistoryEvent.action = "../../../BasicHistoryEventNextDetailAction.do";
    frmBasicHistoryEvent.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';  
    frmBasicHistoryEvent.userPageRequested.value = 1*frmBasicHistoryEvent.newPageRequested.value ;
    frmBasicHistoryEvent.action = "../../../BasicHistoryEventNextDetailAction.do";
    frmBasicHistoryEvent.submit();
}

function changed(val)
{
  frmBasicHistoryEvent.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
}

</script>