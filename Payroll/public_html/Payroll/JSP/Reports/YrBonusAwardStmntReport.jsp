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

<BODY  onkeydown="hotKeys(event);"; scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="YrBonusAwardStmntReportBaseAction" name="YrBonusAwardStmntReportForm" type="FCIPAY.Payroll.WEBTIER.Form.YrBonusAwardStmntReportForm" scope="session" >
<bean:define id="ParentForm" name="YrBonusAwardStmntReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>YEARLY BONUS/AWARDS STATEMENT</TD>
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
          <TD class=subHeader colspan=6>Yearly Bonus/Awards Statement </TD>
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
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
          
             
              <table border=0 cellpadding=0>
              <center>
              <TR height=60>
         
		<!-- Detail table Container starts -->
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.BonusAward.Year" /><td colspan=2><html:text  property="txtYear"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" >
              </td>
      
              </tr>
              </center>
              </table>


              <table border=0 cellpadding=0>
              <TR height=40>
              <td width=25% >
              <td width="6%" align="right" value="checked" class="radioText" ><input type="radio" name="optSelect" checked value="T" onclick="doSetEmployee('A');" /><bean:message key="Payroll.BonusAward.All" />
              <td width="12%" align="right" class="radioText" ><html:radio  property="optSelect" value="p" onclick="doSetEmployee('E');"  /><bean:message key="Payroll.BonusAward.Emp" />
              <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional" readonly="true" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtEmpNo" onclick="ShowLovEmpNo();">&nbsp;&nbsp;<html:text property="txtEmpName"  size="26" value="" styleClass="locked" readonly="true" /></td>
              </td>
              </tr>

                <tr height="15" >
            <td colspan="4"></td>
         </tr>
         
              </table>
            
        
               

<!-- Tab table Row 3 starts -->

  <TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>
         <tr height="15" >
            <td colspan="16"></td>
         </tr>

      <TR>
               <td align=center bgcolor=#4682b4 width="42%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE YEARLY BONUS/AWARDS STATEMENT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
               <td width="45%" bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	


                   
                </table>
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
window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","YrBonusAwardStmntReport","YrBonusAwardStmntReportkey").trim()%>",'',win_option);
}
</script>
 

	 


</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="YrBonusAwardStmntReportForm"  property="screenName" value="YrBonusAwardStmntReport" />
  
<html:hidden property="screenMode" name="YrBonusAwardStmntReportForm" value="U" />
<html:hidden property="positionRequested" name="YrBonusAwardStmntReportForm" />
<html:hidden property="userPageRequested" name="YrBonusAwardStmntReportForm" />
<html:hidden property="userPositionRequested" name="YrBonusAwardStmntReportForm" />
<html:hidden property="pageRequested" name="YrBonusAwardStmntReportForm" />
<html:hidden property="headerDataChanged" name="YrBonusAwardStmntReportForm" />
<html:hidden property="detailDataChanged" name="YrBonusAwardStmntReportForm" />
<html:hidden property="lovKey" name="YrBonusAwardStmntReportForm"  />
<html:hidden property="txtSearchFields" name="YrBonusAwardStmntReportForm"  />
<html:hidden property="txtDisplayFields" name="YrBonusAwardStmntReportForm"  />
<html:hidden property="txtIndex" name="YrBonusAwardStmntReportForm"  />
<html:hidden property="headerPrimaryKey" name="YrBonusAwardStmntReportForm"  />


</html:form>
</body>
</html:html>

<script language="javascript">
function ShowLovYYMM()
{
        YrBonusAwardStmntReportForm.lovKey.value = "GenYrBonusAwardStmntYear" + YrBonusAwardStmntReportForm.screenName.value + "U";
        YrBonusAwardStmntReportForm.txtSearchFields.value = "Payroll.BonusAward.Year";
        YrBonusAwardStmntReportForm.txtDisplayFields.value = "txtYear";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','YrBonusAwardStmntReportForm');
        return true;
}

function ShowLovEmpNo()
{
        YrBonusAwardStmntReportForm.lovKey.value = "GenYrBonusAwardStmntEmp" + YrBonusAwardStmntReportForm.screenName.value + "U";
        YrBonusAwardStmntReportForm.txtSearchFields.value = "Payroll.BonusAward.Emp";
        YrBonusAwardStmntReportForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','YrBonusAwardStmntReportForm');
        return true;
}
</script>