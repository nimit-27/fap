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

<html:form  action="SalStatementBaseAction" name="SalStatementForm" type="FCIPAY.Payroll.WEBTIER.Form.GenerateSalStatementForm" scope="session" >
<bean:define id="ParentForm" name="SalStatementForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>GENERATE SALARY STATEMENT</TD>
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
          <TD class=subHeader colspan=6> Generate Salary Statement</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         
         
            <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="60">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
              <td class="labelText"  width="15%" ><bean:message key="Payroll.SalStatement.YYMM" /></td>
            <td><html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" ></td>


             <td class=labelText width="20%" ><bean:message key="Payroll.SalStatement.SelectOption" /></td>
                   <td colspan="1" ><html:select property="txtOptType" styleClass="required" >
                   <html:option value=" "><bean:message key="Payroll.SalStatement.PleaseSelect" /></html:option>      
                   <html:option value="A" ><bean:message key="Payroll.SalStatement.All" /></html:option>      
                   <html:option value="G"><bean:message key="Payroll.SalStatement.Group" /> </html:option>
                   <html:option value="D"> <bean:message key="Payroll.SalStatement.Designation" /></html:option>
                  
                   </html:select>
            </td>
               </tr>

            <tr height="12">		    
        <TD colspan="6" > </TD>
      </tr>
<!-- Tab table Row 3 starts -->
               
    <TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

 <!-- Bottom Blue Bar -->
       <TR>
            <td>
              <TABLE  cellspacing="0" cellpadding="0" border=0>
                    <tr>
                        <td width=38% align=center bgColor=#4682b4></td>
                        <td  bgColor=#4682b4></td>
                        <td  bgColor=#4682b4><input class=bottomBarText type=button value="  GENERATE SALARY REPORT   "  onclick="doGetReport();" ></td>                
                        <td bgColor=#4682b4></td><td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
                       
                   </TR>
                </table>
            </td>
          </tr>

	<% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">

function doGetReport()
{

if(SalStatementForm.txtOptType.value=='A')
  {
    var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
    window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateSalStatement","GenerateSalStatementforallkey").trim()%>&yearmonth="+SalStatementForm.txtYYMM.value,'',win_option);
  }
if(SalStatementForm.txtOptType.value=='G')
  {
    var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
    window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateSalStatement","GenerateSalStatementGroupkey").trim()%>&yearmonth="+SalStatementForm.txtYYMM.value,'',win_option);
  }
if(SalStatementForm.txtOptType.value=='D')
  {
    var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
    window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateSalStatement","GenerateSalStatementDesigkey").trim()%>&yearmonth="+SalStatementForm.txtYYMM.value,'',win_option);
  }
}

</script>
 
	 

</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="SalStatementForm"  property="screenName" value="GenerateSalStatement" />
  
<html:hidden property="screenMode" name="SalStatementForm" value="U" />
<html:hidden property="positionRequested" name="SalStatementForm" />
<html:hidden property="userPageRequested" name="SalStatementForm" />
<html:hidden property="userPositionRequested" name="SalStatementForm" />
<html:hidden property="pageRequested" name="SalStatementForm" />
<html:hidden property="headerDataChanged" name="SalStatementForm" />
<html:hidden property="detailDataChanged" name="SalStatementForm" />
<html:hidden property="lovKey" name="SalStatementForm"  />
<html:hidden property="txtSearchFields" name="SalStatementForm"  />
<html:hidden property="txtDisplayFields" name="SalStatementForm"  />
<html:hidden property="txtIndex" name="SalStatementForm"  />
<html:hidden property="headerPrimaryKey" name="SalStatementForm"  />


</html:form>
</body>
</html:html>

<script language="javascript">
function ShowLovYYMM()
{
        SalStatementForm.lovKey.value = "ReportGenerateSalStatementYear" + SalStatementForm.screenName.value + "U";
        SalStatementForm.txtSearchFields.value = "Payroll.SalStatement.YYMM";
        SalStatementForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','SalStatementForm');
        return true;
}


</script>