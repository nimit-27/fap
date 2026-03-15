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

<html:form  action="EOLHPLBaseAction" name="EOLHPLRecReportForm" type="FCIPAY.Payroll.WEBTIER.Form.EOLHPLRecReportForm" scope="session" >
<bean:define id="ParentForm" name="EOLHPLRecReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>EOL-HPL RECOVERY REPORT</TD>
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
          <TD class=subHeader colspan=6> EOL-HPL Recovery Report</TD>
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
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.EOLHPL.YYMM" /></td><td colspan=2><html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" >
              </td>
      
              </tr>
              </center>
              </table>

              <table border=0 cellpadding=0>
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
               <td align=center bgcolor=#4682b4 width="37%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE EOL-HPL RECOVERY REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
   var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=no,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
   window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","EOLHPLRecoveryReport","EOLHPLRecReportkey").trim()%>&YYMM="+EOLHPLRecReportForm.txtYYMM.value,'',win_option);
}

</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="EOLHPLRecReportForm"  property="screenName" value="EOLHPLRecoveryReport" />
  
<html:hidden property="screenMode" name="EOLHPLRecReportForm" value="U" />
<html:hidden property="positionRequested" name="EOLHPLRecReportForm" />
<html:hidden property="txtAllEmpFlag" name="EOLHPLRecReportForm"  />
<html:hidden property="userPageRequested" name="EOLHPLRecReportForm" />
<html:hidden property="userPositionRequested" name="EOLHPLRecReportForm" />
<html:hidden property="pageRequested" name="EOLHPLRecReportForm" />
<html:hidden property="headerDataChanged" name="EOLHPLRecReportForm" />
<html:hidden property="detailDataChanged" name="EOLHPLRecReportForm" />
<html:hidden property="lovKey" name="EOLHPLRecReportForm"  />
<html:hidden property="txtSearchFields" name="EOLHPLRecReportForm"  />
<html:hidden property="txtDisplayFields" name="EOLHPLRecReportForm"  />
<html:hidden property="txtIndex" name="EOLHPLRecReportForm"  />
<html:hidden property="headerPrimaryKey" name="EOLHPLRecReportForm"  />


</html:form>
</body>
</html:html>



<script language="javascript">


function lfnLoad()
{  
  if(EOLHPLRecReportForm.firstLoad.value=="")
  {
   doBaseOnLoad();
    
  }  
}
function doOnLoad()
{
  return  "EOLHPLRecoveryOnLoadAction.do";
}



function ShowLovYYMM()
{
        EOLHPLRecReportForm.lovKey.value = "ReportGenerateEOLHPLRecYear" + EOLHPLRecReportForm.screenName.value + "U";
        EOLHPLRecReportForm.txtSearchFields.value = "Payroll.EOLHPL.YYMM";
        EOLHPLRecReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','EOLHPLRecReportForm');
        return true;
}

function ShowLovEmpNo()
{
        EOLHPLRecReportForm.lovKey.value = "ReportGenerateEOLHPLRecEmp" + EOLHPLRecReportForm.screenName.value + "U";
        EOLHPLRecReportForm.txtSearchFields.value = "Payroll.EOLHPL.Emp";
        EOLHPLRecReportForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','EOLHPLRecReportForm');
        return true;
}
</script>