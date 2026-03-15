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

<html:form  action="CanteenSubsidyBaseAction" name="CanteenSubsidyReportForm" type="FCIPAY.Payroll.WEBTIER.Form.GenerateCanteenSubsidyReportForm" scope="session" >
<bean:define id="ParentForm" name="CanteenSubsidyReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>CANTEEN SUBSIDY REPORT</TD>
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
          <TD class=subHeader colspan=6>Canteen Subsidy Report</TD>
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
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.CanteenSubsidy.YYMM" /></td><td colspan=2><html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required" readonly="false" onchange="chk_YearMonth(); " /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" >
              </td>
      
              </tr>
              
              </table>


              <table border=0 cellpadding=0>
               <TD colspan=10>
             <!-- <TR height=40>
              

             
              <td  colspan="2" class="labelText"  width="45%" align="center"  ><bean:message key="Payroll.CanteenSubsidy.Emp" />&nbsp;&nbsp;<html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional" readonly="true" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtEmpNo" onclick="ShowLovEmpNo();">&nbsp;&nbsp;<html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
              
              </tr>-->

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
               <td  bgcolor=#4682b4><html:button value=' GENERATE CANTEEN SUBSIDY REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
    var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=no,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
    window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","CanteenSubsidyReport","CanteenSubsidyforAllReportkey").trim()%>&YYMM="+CanteenSubsidyReportForm.txtYYMM.value,'',win_option);
}
</script>

	 


</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="CanteenSubsidyReportForm"  property="screenName" value="CanteenSubsidyReport" />
  
<html:hidden property="screenMode" name="CanteenSubsidyReportForm" value="U" />
<html:hidden property="positionRequested" name="CanteenSubsidyReportForm" />
<html:hidden property="userPageRequested" name="CanteenSubsidyReportForm" />
<html:hidden property="userPositionRequested" name="CanteenSubsidyReportForm" />
<html:hidden property="pageRequested" name="CanteenSubsidyReportForm" />
<html:hidden property="headerDataChanged" name="CanteenSubsidyReportForm" />
<html:hidden property="detailDataChanged" name="CanteenSubsidyReportForm" />
<html:hidden property="lovKey" name="CanteenSubsidyReportForm"  />
<html:hidden property="txtSearchFields" name="CanteenSubsidyReportForm"  />
<html:hidden property="txtDisplayFields" name="CanteenSubsidyReportForm"  />
<html:hidden property="txtIndex" name="CanteenSubsidyReportForm"  />
<html:hidden property="headerPrimaryKey" name="CanteenSubsidyReportForm"  />
<html:hidden property="txtAllEmpFlag" name="CanteenSubsidyReportForm"  />  


</html:form>
</body>
</html:html>



<script language="javascript">

function ShowLovYYMM()
{
        CanteenSubsidyReportForm.lovKey.value = "ReportGenerateCanteenSubsidyYear" + CanteenSubsidyReportForm.screenName.value + "U";
        CanteenSubsidyReportForm.txtSearchFields.value = "Payroll.CanteenSubsidy.YYMM";
        CanteenSubsidyReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','CanteenSubsidyReportForm');
        return true;
}

</script>