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

<BODY  onkeydown="hotKeys(event);"; scroll=no  onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="LicenceFeeStatementBaseAction" name="GenerateLicenceFeeStatementForm" type="FCIPAY.Payroll.WEBTIER.Form.GenerateLicenceFeeStatementForm" scope="session" >
<bean:define id="ParentForm" name="GenerateLicenceFeeStatementForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>GENERATE LICENCE FEE STATEMENT</TD>
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
          <TD class=subHeader colspan=2 > Generate Licence Fee Statement</TD>
        </TR>
        <TR>
              <TD bgColor=#4682b4 colspan=2 ><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan=2 ></td>
         </tr>
         
            <tr height="60">		    
        <td  class="labelText"  width="45%" ><bean:message key="Payroll.Glfee.YYMM" /></td>
            <td><html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" ></td>
      </tr>
       <tr height="20" >
            <td colspan=2></td>
         </tr>  

<TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>
 <tr height="20" >
            <td colspan=2></td>
         </tr>


   	 </table>
    </td>
    </tr>

 <!-- Bottom Blue Bar -->
       <TR>
            <td>
              <TABLE  cellspacing="0" cellpadding="0" border=0>
                    <tr>
                        <td width=35% bgColor=#4682b4></td>
                        <td  bgColor=#4682b4></td>
                        <td  bgColor=#4682b4><input class=bottomBarText type=button value="   Generate Licence Fee Statement   "  onclick="doGetReport();" ></td>                
                        <td bgColor=#4682b4></td>
                       
                   </TR>
                </table>
            </td>
          </tr>

	 
<!-- Container Table Ending Columns Starts-->


</TBODY>
</TABLE>
<html:hidden name="GenerateLicenceFeeStatementForm"  property="screenName" value="PayGenerateLicenceFee" />
  
<html:hidden property="screenMode" name="GenerateLicenceFeeStatementForm" value="U" />
<html:hidden property="positionRequested" name="GenerateLicenceFeeStatementForm" />
<html:hidden property="userPageRequested" name="GenerateLicenceFeeStatementForm" />
<html:hidden property="userPositionRequested" name="GenerateLicenceFeeStatementForm" />
<html:hidden property="pageRequested" name="GenerateLicenceFeeStatementForm" />
<html:hidden property="headerDataChanged" name="GenerateLicenceFeeStatementForm" />
<html:hidden property="detailDataChanged" name="GenerateLicenceFeeStatementForm" />
<html:hidden property="lovKey" name="GenerateLicenceFeeStatementForm"  />
<html:hidden property="txtSearchFields" name="GenerateLicenceFeeStatementForm"  />
<html:hidden property="txtDisplayFields" name="GenerateLicenceFeeStatementForm"  />
<html:hidden property="txtIndex" name="GenerateLicenceFeeStatementForm"  />
<html:hidden property="headerPrimaryKey" name="GenerateLicenceFeeStatementForm"  />
</html:form>
</body>
</html:html>



 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %>  


<script language="javascript">

function doGetReport()
{
var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","PayGenerateLicenceFee","GenerateLicenceFeeReportkey").trim()%>&yearmonth="+GenerateLicenceFeeStatementForm.txtYYMM.value,'',win_option);
}
function lfnLoad()
{  
  if(GenerateLicenceFeeStatementForm.firstLoad.value=="")
  {
    doBaseOnLoad();       
  }  
}
function doOnLoad()
{
    return "GenerateLicenceFeeStatementOnLoadAction.do";
}

function ShowLovYYMM()
{
        GenerateLicenceFeeStatementForm.lovKey.value = "ReportGenerateLicenceFee" + GenerateLicenceFeeStatementForm.screenName.value + "U";
        GenerateLicenceFeeStatementForm.txtSearchFields.value = "Payroll.Glfee.YYMM";
        GenerateLicenceFeeStatementForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','GenerateLicenceFeeStatementForm');
        return true;
}
</script>