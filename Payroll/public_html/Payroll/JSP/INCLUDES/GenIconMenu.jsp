<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

    <bean:define id="left" name="ParentForm" property="positionRequested" type="java.lang.Long" />
    <bean:define id="right" name="ParentForm" property="totalCount" />
    <bean:define id="empNo" name="ParentForm" property="loginEmployeeNo" />
    <bean:define id="empLocCode" name="ParentForm" property="loginLocCode" />
    <bean:define id="empName" name="ParentForm" property="loginEmployeeName" />
    <bean:define id="empLocation" name="ParentForm" property="loginEmployeelocation" />
<%
java.util.Date systemDate = new java.util.Date();

java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd-MMM-yyyy");
String strSystemDate = dateFormat.format(systemDate);  
String strEmpLbrFlag=(String)session.getAttribute("hdnEmpLbrFlag");
FCIPAY.COMMON.UTILITY.UserInfoBean uib = (FCIPAY.COMMON.UTILITY.UserInfoBean)session.getAttribute("USERINFO");
String slocation = uib.getSSubLocation();
%>
<html:hidden property="hdnLoginDate" name="ParentForm" value="<%=strSystemDate%>" />

<html:hidden name="ParentForm" property="hdnEmpLbrFlag" value="<%=strEmpLbrFlag%>" /> 

<html:hidden name="ParentForm" property="SSubLocation" value="<%=slocation%>" />

<TABLE cellSpacing=0 bgColor=#bdd0ef border="0">
<TR height=27>
  <TD colSpan=11></TD>
</TR>
  <TR bgColor=#bdd0ef>
    <TD>
      <IMG name='butQueryMode' onmouseover='this.src="../INCLUDES/IMAGES/query_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/query.jpg"' alt=Query onclick="doQueryMode();" src="../INCLUDES/IMAGES/query.jpg">
      <IMG name='butInsertMode' onmouseover='this.src="../INCLUDES/IMAGES/insert_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/insert.jpg"' alt=Insert onclick="doInsertMode();" src="../INCLUDES/IMAGES/insert.jpg">
    </TD>
    <TD width="2%"></TD>
    <TD bgColor=#bdd0ef><IMG name='butExecute' onmouseover='this.src="../INCLUDES/IMAGES/execute_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/execute.jpg"' alt=Execute onclick="getHeaderRecord();" src="../INCLUDES/IMAGES/execute.jpg">
      <IMG onmouseover='this.src="../INCLUDES/IMAGES/save_act.jpg"' name='butSave' onmouseout='this.src="../INCLUDES/IMAGES/save.jpg"' alt=Save onclick="SaveRecord();" src="../INCLUDES/IMAGES/save.jpg">
      <IMG name='butDel' onmouseover='this.src="../INCLUDES/IMAGES/delete_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/delete.jpg"' alt=Delete src="../INCLUDES/IMAGES/delete.jpg" onclick="DelRecord()" >
      <IMG name='butRefresh' onmouseover='this.src="../INCLUDES/IMAGES/refresh_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/refresh.jpg"' alt=Refresh onclick="doRefresh();" src="../INCLUDES/IMAGES/refresh.jpg">
      <IMG name='butPrint' onmouseover='this.src="../INCLUDES/IMAGES/print_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/print.jpg"' alt=Print onclick="window.print();" src="../INCLUDES/IMAGES/print.jpg">
    </TD>
    <TD width="2%" bgColor=#bdd0ef></TD>
    <TD bgColor=#bdd0ef>
      <IMG name='butExit' onmouseover='this.src="../INCLUDES/IMAGES/exit_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/exit.jpg"' alt=Exit  src="../INCLUDES/IMAGES/exit.jpg" onclick="doExit();">
      <IMG name='butHelp' onmouseover='this.src="../INCLUDES/IMAGES/help_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/help.jpg"' alt=Help src="../INCLUDES/IMAGES/help.jpg">
    </TD>
    <TD width="45%"></TD>

    <%if(left.equals(new Long(1))||left.equals(new Long(0))){%>
      <TD ><IMG name='butPrevHeader' src='../INCLUDES/IMAGES/butn_prev_dis.jpg'></td>
    <%}else{%>
     <TD class="icon"><IMG name='butPrevHeader' src='../INCLUDES/IMAGES/butn_prev.jpg' onmouseover='this.src="../INCLUDES/IMAGES/butn_prev_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_prev.jpg"' alt=Butn_prev onclick="PrevHeader();" src="../INCLUDES/IMAGES/butn_dtl_prev.jpg"></td>
    <%}%>
    
     <td class=dtlNavText><bean:write name="left" /> of <bean:write name="right" /></td>

    <%if(left.equals(right)){%>
      <td align=right><IMG name='butNextHeader' src="../INCLUDES/IMAGES/butn_next_dis.jpg"></td>
    <%}else{%>
     <td align=right class="icon"><IMG name='butNextHeader' src="../INCLUDES/IMAGES/butn_next.jpg" onmouseover='this.src="../INCLUDES/IMAGES/butn_next_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_next.jpg"' alt=Butn_next src="../INCLUDES/IMAGES/butn_next.jpg" onclick="doGetNextHeader();" src="../INCLUDES/IMAGES/butn_next.jpg"></td>
    <%}%>
    
    <td class="icon" align=right><html:text property="newPositionRequested" size="1" maxlength="10" onkeypress="isInteger(event)" title=" " alt="N" /></td>
    <td class="icon" ><img  alt="Go (Ctrl+G)" name='butnGo' src="../INCLUDES/IMAGES/go.jpg" onclick="JumpHeader()"></td>
    <td > </td>
</TR>
<TR height=10 >
  <TD style="color:#993300;font-size:8pt;text-align:left;font-weight:normal;font-family:'verdana, Arial, Helvetica, sans-serif';background-color:#eff9ff;" height=10 colspan=6 ><b>Welcome </b><bean:write name="empName" />(<bean:write name="empNo" />)</td>
  <td class=userText height=10 colspan=5 >Site:<bean:write name="empLocation" />(<bean:write name="empLocCode" />)</TD>
</TR>
</table>
<script language="javascript">
function doExit()
{
    document.forms[0].action="../../../RedirectMap.do?action=frmMainPage|MainPage";
    document.forms[0].submit();
}

</script>