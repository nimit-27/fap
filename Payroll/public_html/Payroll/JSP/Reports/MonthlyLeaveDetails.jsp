<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>

<BODY  onkeydown="hotKeys(event);"; scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MonLeaveDetailsBaseAction" name="MonthlyLeaveDetailsForm" type="FCIPAY.Payroll.WEBTIER.Form.MonthlyLeaveDetailsForm" scope="session" >
<bean:define id="ParentForm" name="MonthlyLeaveDetailsForm" toScope="request" />

<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<enrgise:errors/>
<logic:messagesPresent message="true">
<Table>
    <html:messages id="message" message="true">
    <TR><TD>
      <bean:write name="message"/>
    </TD></TR>
    </html:messages>
</Table>
</logic:messagesPresent>
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MONTHLY LEAVE DETAILS REPORT</TD>
</TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Monthly Leave Details Report</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
            
   	 </table>
 

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="100">
            <TD colspan=12>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
           <center>
              <TR height=60>
         
		<!-- Detail table Container starts -->
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.MonthlyLeaveDetails.Year" /></td><td colspan=2><html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="ShowLovYYMM();" > </td>
      
              </tr>
              </center>
             


              <table border=0 cellpadding=0>
              <TR height=40>
              <td width=25% >
              <td width="6%" align="right" value="checked" class="radioText" ><input type="radio" name="optSelect" checked value="T" onclick="doSetFlag('A');" /><bean:message key="Payroll.MonthlyLeaveDetails.All" />
              <td width="12%" align="right" class="radioText" ><html:radio  property="optSelect" value="p" onclick="doSetFlag('B');"  /><bean:message key="Payroll.MonthlyLeaveDetails.Emp" />
              <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtEmpNo" onclick="ShowLovEmpNo();">&nbsp;&nbsp;<html:text property="txtEmpName"  size="26" value="" styleClass="locked" readonly="true" /></td>
            
              </tr>
              </table>
            
        
   <!-- Tab table Row 3 starts -->

 <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
  <TR>
     <TD colspan="16" align=right bgColor=#4682b4 ><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>

         
      <TR>
            <td>
             
               <tr height="15" ><TD colspan="16"></TD> </tr>
            
                  <TR>
               <td align=center bgcolor=#4682b4 width="35%"></td>
               <td  bgcolor=#4682b4><html:button value='GENERATE MONTHLY LEAVE REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
                  </TR>
	
                
            </td>
          </tr>
        
  
</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->
 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">
function doGetReport()
{
var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","MonthlyLeaveDetails","MonthlyLeaveDetailsReportkey").trim()%>",'',win_option);
}
</script>

	

</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="MonthlyLeaveDetailsForm"  property="screenName" value="MonthlyLeaveDetails" />
  
<html:hidden property="screenMode" name="MonthlyLeaveDetailsForm" value="U" />
<html:hidden property="positionRequested" name="MonthlyLeaveDetailsForm" />
<html:hidden property="txtAllEmpFlag" name="MonthlyLeaveDetailsForm"  />
<html:hidden property="userPageRequested" name="MonthlyLeaveDetailsForm" />
<html:hidden property="userPositionRequested" name="MonthlyLeaveDetailsForm" />
<html:hidden property="pageRequested" name="MonthlyLeaveDetailsForm" />
<html:hidden property="headerDataChanged" name="MonthlyLeaveDetailsForm" />
<html:hidden property="detailDataChanged" name="MonthlyLeaveDetailsForm" />
<html:hidden property="lovKey" name="MonthlyLeaveDetailsForm"  />
<html:hidden property="txtSearchFields" name="MonthlyLeaveDetailsForm"  />
<html:hidden property="txtDisplayFields" name="MonthlyLeaveDetailsForm"  />
<html:hidden property="txtIndex" name="MonthlyLeaveDetailsForm"  />
<html:hidden property="headerPrimaryKey" name="MonthlyLeaveDetailsForm"  />


</html:form>
</body>
</html:html>

<script language="javascript">
function ShowLovYYMM()
{
        MonthlyLeaveDetailsForm.lovKey.value = "MonthlyLeaveDetailsYear" + MonthlyLeaveDetailsForm.screenName.value + "U";
        MonthlyLeaveDetailsForm.txtSearchFields.value = "Payroll.MonthlyLeaveDetails.Year";
        MonthlyLeaveDetailsForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','MonthlyLeaveDetailsForm');
        return true;
}

function ShowLovEmpNo()
{
        MonthlyLeaveDetailsForm.lovKey.value = "MonthlyLeaveDetailsEmp" + MonthlyLeaveDetailsForm.screenName.value + "U";
        MonthlyLeaveDetailsForm.txtSearchFields.value = "Payroll.MonthlyLeaveDetails.Emp";
        MonthlyLeaveDetailsForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','MonthlyLeaveDetailsForm');
        return true;
}

function doSetFlag(val)
{ 
  MonthlyLeaveDetailsForm.txtAllEmpFlag.value=val;   
     
  if(val=='B')
  {
    document.all.txtEmp.style.background = "#ffffd3";
    document.all.txtEmp.disabled="";
    document.all.txtEmp.className="required";
  }
  else
  {
    document.all.txtEmp.value="";
    document.all.txtEmpName.value="";
    document.all.txtEmp.style.background = "#e0e0e0";
    document.all.txtEmp.disabled="true";
    document.all.txtEmp.className="optional";
  }
     
}

</script>