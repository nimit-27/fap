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
		<TITLE>Payroll</TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>

<BODY   scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="PayGenRecEarnStatementBaseAction" name="PayGenerateRecEarningStatementForm" type="FCIPAY.Payroll.WEBTIER.Form.PayGenerateRecEarningStatementForm" scope="session">
<bean:define id="ParentForm" name="PayGenerateRecEarningStatementForm" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<html:errors/>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>GENERATE RECOVERY/EARNING STATEMENT </TD>
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
          <TD class=subHeader colspan=10> Generate Recovery/Earning Statement</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
  <tr>
              <!--<td width="33%">  </td>-->
              
              <td class="labelText"  width="50%" ><bean:message key="Payroll.RecEarnings.YYMM" /></td>
              <td align="left"><html:text property="txtYYYYMM"   alt="P" maxlength="20" size="23" styleClass="required" readonly="false"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtYYMM" onclick=" ShowLovYYMM();"></td>
        </tr>

        
            
   	 </table>
    

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Second Row starts -->

 	 <TR height="80">
            <TD colspan=11>
              <td class="labelText"  width="35%" ><bean:message key="Payroll.RecEarnings.PayCode" /></td>
              <td><html:text property="txtPayCode"  alt="P" maxlength="20" size="23" styleClass="optional" readonly="false"/> <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtPayCode" onclick="return ShowLovPayCode();">
              <html:text  property="txtPayCodeDesc" maxlength="10" size="26" styleClass="locked" readonly="true" /></td>
              </tr>

<!-- Tab table Row 3 starts -->
              
    <TR>
     <TD align=right bgColor=#4682b4 colSpan=16><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
              

<!-- Bottom Blue Bar -->
          <TR>
            <td>
              <TABLE  cellspacing="0" cellpadding="0" border=0>
                    <TR>
               <td align=center bgcolor=#4682b4 width="37%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE REC/ERN STATEMENT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	
                </table>
            </td>
          </tr>
	
</TABLE>

 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>

<% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">

function doGetReport()
{
    var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
    window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","PayGenerateRecEarningStatement","RecEarningStatementForAllkey").trim()%>&YYMM="+PayGenerateRecEarningStatementForm.txtYYYYMM.value+"&P_1="+PayGenerateRecEarningStatementForm.txtPayCode.value,'',win_option);
}

</script>
</TBODY>
</TABLE>

<!-- Container Table Ends -->

<html:hidden name="PayGenerateRecEarningStatementForm"  property="screenName" value="PayGenerateRecEarningStatement" />
 <html:hidden property="txtAllEmpFlag" name="PayGenerateRecEarningStatementForm"  /> 
<html:hidden property="screenMode" name="PayGenerateRecEarningStatementForm" value="U" />
<html:hidden property="positionRequested" name="PayGenerateRecEarningStatementForm" />
<html:hidden property="userPageRequested" name="PayGenerateRecEarningStatementForm" />
<html:hidden property="userPositionRequested" name="PayGenerateRecEarningStatementForm" />
<html:hidden property="pageRequested" name="PayGenerateRecEarningStatementForm" />
<html:hidden property="headerDataChanged" name="PayGenerateRecEarningStatementForm" />
<html:hidden property="detailDataChanged" name="PayGenerateRecEarningStatementForm" />
<html:hidden property="lovKey" name="PayGenerateRecEarningStatementForm"/>
<html:hidden property="txtSearchFields" name="PayGenerateRecEarningStatementForm"  />
<html:hidden property="txtDisplayFields" name="PayGenerateRecEarningStatementForm"  />
<html:hidden property="txtIndex" name="PayGenerateRecEarningStatementForm"/>
<html:hidden property="headerPrimaryKey" name="PayGenerateRecEarningStatementForm"  />
 

</html:form>
</body>
</html:html>

<script language="javascript">

function doSetFlag(val)
{ 
  PayGenerateRecEarningStatementForm.txtAllEmpFlag.value=val;   
     
  if(val=='B')
  {
    document.all.txtEmpNo.style.background = "#ffffd3";
    document.all.butTxtEmpNo.disabled="";
    document.all.butTxtEmpNo.className="required";
  }
  else
  {
    document.all.txtEmpNo.value="";
    document.all.txtEmpName.value="";
    document.all.txtEmpNo.style.background = "#e0e0e0";   
    document.all.butTxtEmpNo.disabled="true";
    document.all.txtEmpNo.className="optional";
  }
     
}


function lfnLoad()
{  
  if(PayGenerateRecEarningStatementForm.firstLoad.value=="")
  {
   doBaseOnLoad();
    
  }  
}
function doOnLoad()
{
  return  "GenerateRecEarnOnLoadAction.do";
}


function ShowLovYYMM()
{
        PayGenerateRecEarningStatementForm.lovKey.value = "PayGenerateRecEarningsYear" + PayGenerateRecEarningStatementForm.screenName.value + "U";
        PayGenerateRecEarningStatementForm.txtSearchFields.value = "Payroll.RecEarnings.YYMM";
        PayGenerateRecEarningStatementForm.txtDisplayFields.value = "txtYYYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PayGenerateRecEarningStatementForm');
        return true;
}

function ShowLovEmpNo()
{
        PayGenerateRecEarningStatementForm.lovKey.value = "PayGenerateRecEarningsEmp" + PayGenerateRecEarningStatementForm.screenName.value + "U";
        PayGenerateRecEarningStatementForm.txtSearchFields.value = "Payroll.RecEarnings.Emp";
        PayGenerateRecEarningStatementForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PayGenerateRecEarningStatementForm');
        return true;
}

function ShowLovPayCode()
{
        PayGenerateRecEarningStatementForm.lovKey.value = "PayGenerateRecEarningsPayCode" + PayGenerateRecEarningStatementForm.screenName.value + "Q";
        PayGenerateRecEarningStatementForm.txtSearchFields.value = "Payroll.RecEarnings.PayCode,Payroll.RecEarnings.PayCodeDesc";
        PayGenerateRecEarningStatementForm.txtDisplayFields.value = "txtPayCode,txtPayCodeDesc";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PayGenerateRecEarningStatementForm');
        return true;
}

function ShowLovAgencyCode()
{
        PayGenerateRecEarningStatementForm.lovKey.value = "PayGenerateRecEarningsAgencyCode" + PayGenerateRecEarningStatementForm.screenName.value + "U";
        PayGenerateRecEarningStatementForm.txtSearchFields.value = "Payroll.RecEarnings.AgencyCode";
        PayGenerateRecEarningStatementForm.txtDisplayFields.value = "txtAgencyCode,txtAgencyName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PayGenerateRecEarningStatementForm');
        return true;
}

</script>

 