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

<html:form  action="GenRetirementReportBaseAction" name="GenRetirementReportForm" type="FCIPAY.Payroll.WEBTIER.Form.GenRetirementReportForm" scope="session" >
<bean:define id="ParentForm" name="GenRetirementReportForm" toScope="request" />

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


<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>GENERATE RETIREMENT REPORT</TD>
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
          <TD class=subHeader colspan=6> Generate Retirement Report</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
            <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="50">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
               <td class=labelText width="10%" >From Date</td>
           <td colspan="1" width="14%" ><html:text  property="dateFrom" altKey="" maxlength="10" size="16" styleClass="required" readonly="true" />&nbsp;<img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butFromDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('dateFrom',this)"  ></td>

           <td class=labelText width="6%" >To Date</td>
           <td colspan="1" width="14%" ><html:text  property="dateTo" altKey="" maxlength="10" size="16"  styleClass="optional" readonly="true" onchange="checkDates()" />&nbsp;<img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butToDate" alt="<%=(i-1) %>" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('dateTo',this)"  ></td>
  
            
            
               </tr>

<!-- Tab table Row 3 starts -->
       <tr height=20>  <td colspan=3></td> </tr>


       <tr>
  
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
               <tr height=20>  <td colspan=3></td> </tr>
   <!-- Tab Table Ends -->

 <!-- Bottom Blue Bar -->
         <TR>
               <td align=center bgcolor=#4682b4 width="35%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE RETIREMENT REPORT'  onclick="computeTransaction()" property="butInsert" styleClass="bottomBarText" /></td>
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	
                </table>
            </td>
          </tr>

	 


</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="GenRetirementReportForm"  property="screenName" value="GenerateSalStatement" />
  
<html:hidden property="screenMode" name="GenRetirementReportForm" value="U" />
<html:hidden property="positionRequested" name="GenRetirementReportForm" />
<html:hidden property="userPageRequested" name="GenRetirementReportForm" />
<html:hidden property="userPositionRequested" name="GenRetirementReportForm" />
<html:hidden property="pageRequested" name="GenRetirementReportForm" />
<html:hidden property="headerDataChanged" name="GenRetirementReportForm" />
<html:hidden property="detailDataChanged" name="GenRetirementReportForm" />
<html:hidden property="lovKey" name="GenRetirementReportForm"  />
<html:hidden property="txtSearchFields" name="GenRetirementReportForm"  />
<html:hidden property="txtDisplayFields" name="GenRetirementReportForm"  />
<html:hidden property="txtIndex" name="GenRetirementReportForm"  />
<html:hidden property="headerPrimaryKey" name="GenRetirementReportForm"  />


</html:form>
</body>
</html:html>

