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

<html:form  action="NewEntrantsReportBaseAction" name="GenerateNewEntrantsReportForm" type="FCIPAY.Payroll.WEBTIER.Form.GenerateNewEntrantsReportForm" scope="session" >
<bean:define id="ParentForm" name="GenerateNewEntrantsReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>GENERATE NEW ENTRANTS REPORT</TD>
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
          <TD class=subHeader colspan=6> Generate New Entrants Report</TD>
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
              <td class="labelText"  width="25%" >From YearMonth</td>
            <td><html:text  property="txtFrmYear"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" ></td>

    <td class="labelText"  width="15%" >To YearMonth</td>
            <td><html:text  property="txtToYear"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" ></td>

            
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
               <td align=center bgcolor=#4682b4 width="33%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE NEW ENTRANTS REPORT'  onclick="computeTransaction()" property="butInsert" styleClass="bottomBarText" /></td>
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	
                </table>
            </td>
          </tr>

	 


</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="GenerateNewEntrantsReportForm"  property="screenName" value="GenerateNewEntrantsReport" />
  
<html:hidden property="screenMode" name="GenerateNewEntrantsReportForm" value="U" />
<html:hidden property="positionRequested" name="GenerateNewEntrantsReportForm" />
<html:hidden property="userPageRequested" name="GenerateNewEntrantsReportForm" />
<html:hidden property="userPositionRequested" name="GenerateNewEntrantsReportForm" />
<html:hidden property="pageRequested" name="GenerateNewEntrantsReportForm" />
<html:hidden property="headerDataChanged" name="GenerateNewEntrantsReportForm" />
<html:hidden property="detailDataChanged" name="GenerateNewEntrantsReportForm" />
<html:hidden property="lovKey" name="GenerateNewEntrantsReportForm"  />
<html:hidden property="txtSearchFields" name="GenerateNewEntrantsReportForm"  />
<html:hidden property="txtDisplayFields" name="GenerateNewEntrantsReportForm"  />
<html:hidden property="txtIndex" name="GenerateNewEntrantsReportForm"  />
<html:hidden property="headerPrimaryKey" name="GenerateNewEntrantsReportForm"  />


</html:form>
</body>
</html:html>

