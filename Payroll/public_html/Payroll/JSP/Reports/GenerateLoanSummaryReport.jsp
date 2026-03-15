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

<html:form  action="GenerateLoanSummReportBaseAction" name="GenerateLoanSummReportForm" type="FCIPAY.Payroll.WEBTIER.Form.GenerateLoanSummReportForm" scope="session" >
<bean:define id="ParentForm" name="GenerateLoanSummReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>GENERATE LOAN SUMMARY REPORT</TD>
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
          <TD class=subHeader colspan=2 > Generate Loan Summary Report</TD>
        </TR>
        
        <TR>
              <TD bgColor=#4682b4 colspan=7 ><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="25" >
            <td colspan=2 ></td>
         </tr>
         
            <tr height="50">		    
        <td  class="labelText"  >Year Month</td>
            <td colspan=2><html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" ></td>
      </tr>
      

            
         <tr height="50">		    
        <td  class="labelText"  width="45%" >Loan Code</td>
        <td colspan=3><html:text  property="txtLoanCode"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovLoan();" >&nbsp;&nbsp;<html:text  property="loanDesc"  maxlength="10" size="26" styleClass="locked" readonly="true" /></td>

      </tr>
      
      <!-- <tr height="20" >
            <td colspan=2></td>
         </tr>  -->
  <TR height="50">	
  <table border=0 cellPadding=0>
<TR>
              <TD colspan=7 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
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
                        <td  bgColor=#4682b4><input class=bottomBarText type=button value="   Generate Loan Summary Report   "  onclick="doGetReport();" ></td>                
                        <td bgColor=#4682b4></td>
                       
                   </TR>
                </table>
            </td>
          </tr>

	 
<!-- Container Table Ending Columns Starts-->


</TBODY>
</TABLE>
<html:hidden name="GenerateLoanSummReportForm"  property="screenMode"/>
    <html:hidden name="GenerateLoanSummReportForm"  property="screenName" value="GenerateLoanSummReport" />
    <html:hidden property="buttonFlag" name="GenerateLoanSummReportForm"  />
    <html:hidden property="txtAllEmpFlag" name="GenerateLoanSummReportForm"  />  
    <html:hidden property="lovKey" name="GenerateLoanSummReportForm"  />
    <html:hidden property="txtFields" name="GenerateLoanSummReportForm"  />   
    <html:hidden property="txtSearchFields" name="GenerateLoanSummReportForm"  />
    <html:hidden property="txtDisplayFields" name="GenerateLoanSummReportForm"  />
    <html:hidden property="txtIndex" name="GenerateLoanSummReportForm"  />
</html:form>
</body>
</html:html>


 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">
function doGetReport()
{  
      var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
      window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateLoanSummReport","GenerateLoanSummarykey").trim()%>&YYMM="+GenerateLoanSummReportForm.txtYYMM.value+"&pay_code="+GenerateLoanSummReportForm.txtLoanCode.value,'',win_option);
}

function lfnLoad()
{  
  if(GenerateLoanSummReportForm.firstLoad.value=="")
  {
   doBaseOnLoad();
    
  }  
}
function doOnLoad()
{
  return  "GenerateLoanSummOnLoadAction.do";
}


function doSetFlag(val)
{ 
  GenerateLoanSummReportForm.txtAllEmpFlag.value=val;   
     
  if(val=='B')
  {
    document.all.txtEmp.style.background = "#ffffd3";
    document.all.butTxtEmpNo.disabled="";
    document.all.txtEmp.disabled="";
    document.all.butTxtEmpNo.className="required";
  }
  else
  {
    document.all.txtEmp.value="";
    document.all.txtEmp.disabled="true";    
    document.all.txtEmpName.value="";
    document.all.txtEmp.style.background = "#e0e0e0";   
    document.all.butTxtEmpNo.disabled="true";
    document.all.txtEmp.className="optional";
  }
     
}


function ShowLovYYMM()
{
        GenerateLoanSummReportForm.lovKey.value = "ReportGenerateLoanSummYear" + GenerateLoanSummReportForm.screenName.value + "U";
        GenerateLoanSummReportForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        GenerateLoanSummReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PaySlipReportForm');
        return true;
}

function ShowLovEmpNo()
{
        GenerateLoanSummReportForm.lovKey.value = "ReportGenerateLoanSummEmp" + GenerateLoanSummReportForm.screenName.value + "U";
        GenerateLoanSummReportForm.txtSearchFields.value = "Payroll.PaySlip.Emp";
        GenerateLoanSummReportForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PaySlipReportForm');
        return true;
}

function ShowLovLoan()
{
        GenerateLoanSummReportForm.lovKey.value = "ReportGenerateLoanSummLoan" + GenerateLoanSummReportForm.screenName.value + "U";
         GenerateLoanSummReportForm.txtDisplayFields.value = "txtLoanCode,loanDesc";
         GenerateLoanSummReportForm.txtSearchFields.value = "Payroll.MaintAdhoc.Code,Payroll.Common.Desc";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PaySlipReportForm');
        return true;
}
</script>