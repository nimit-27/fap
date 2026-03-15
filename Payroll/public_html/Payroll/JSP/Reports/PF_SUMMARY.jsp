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
<html:form  action="PFSummaryReportBaseAction" name="PFSummaryRepForm" type="FCIPAY.Payroll.WEBTIER.Form.PFSummaryRepForm" scope="session" >
<bean:define id="ParentForm" name="PFSummaryRepForm" toScope="request" />

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

<table  >
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>PF SUMMARY REPORT</TD>
</TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD colspan = 12>     
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>PF SUMMARY STATEMENT</TD>
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
              <TR height=60>         
		<!-- Detail table Container starts -->
              <td class="labelText"  width="45%" align="center">
              <bean:message key="Payroll.CanteenSubsidy.YYMM" /></td>
              <td colspan=2>
              <html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required" readonly="false" onchange="chk_YearMonth(); " /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" >
              </td>      
              </tr>              

              <TR>
                <td width="45%" class=labelText align="center"><bean:message key="Payroll.EmpInfo.PF" /></td>
                <td colspan=2 ><html:select  property="txtPFType" styleClass = "optional" alt="txtPFType"  >
                 <html:option value="CP" >CPF </html:option>
                 <html:option value="GP" > GPF</html:option>
                 <html:option value="EP" > EPF</html:option>
                 <html:option value="EN" > ENCPF</html:option>    
                 </html:select>
                 </td>               
              </tr>
              
              </table>
              <table border=0 cellpadding=0>
              </TABLE>
                <tr height="15" >            
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
               <td align=center bgcolor=#4682b4 width="37%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE PF SUMMARY REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
               <td width="37%" bgColor=#4682b4></td>
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
    window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GeneratePFSummaryReport","GeneratePFSummarykey").trim()%>&YYMM="+PFSummaryRepForm.txtYYMM.value+"&EMP_PF_TYPE="+PFSummaryRepForm.txtPFType.value,'',win_option);
}
</script>	 


</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="PFSummaryRepForm"  property="screenName" value="GeneratePFSummaryReport" />
  
<html:hidden property="screenMode" name="PFSummaryRepForm" value="U" />
<html:hidden property="positionRequested" name="PFSummaryRepForm" />
<html:hidden property="userPageRequested" name="PFSummaryRepForm" />
<html:hidden property="userPositionRequested" name="PFSummaryRepForm" />
<html:hidden property="pageRequested" name="PFSummaryRepForm" />
<html:hidden property="headerDataChanged" name="PFSummaryRepForm" />
<html:hidden property="detailDataChanged" name="PFSummaryRepForm" />
<html:hidden property="lovKey" name="PFSummaryRepForm"  />
<html:hidden property="txtSearchFields" name="PFSummaryRepForm"  />
<html:hidden property="txtDisplayFields" name="PFSummaryRepForm"  />
<html:hidden property="txtIndex" name="PFSummaryRepForm"  />
<html:hidden property="headerPrimaryKey" name="PFSummaryRepForm"  />
</html:form>
</body>
</html:html>



<script language="javascript">

function ShowLovYYMM()
{
        PFSummaryRepForm.lovKey.value = "ReportGeneratePfSummYYMM" + PFSummaryRepForm.screenName.value + "U";
        PFSummaryRepForm.txtSearchFields.value = "Payroll.CanteenSubsidy.YYMM";
        PFSummaryRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PFSummaryRepForm');
        return true;
}
</script>