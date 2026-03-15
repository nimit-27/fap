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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>

   
</head>
<BODY scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


 <html:form  action="LPCReportBaseAction" name="LPCReportForm" type="FCIPAY.Payroll.WEBTIER.Form.GenerateLastPayCertificateForm" scope="session">
 <bean:define id="ParentForm" name="LPCReportForm" toScope="request" />
 <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>GENERATE LAST PAY CERTIFICATE REPORT </TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Last Pay Certificate of Employee </TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	                                                                       
            <TR height=10>
            <td class="labelText"  width="25%" ><bean:message key="Payroll.LPC.FrYYMM" /></td>
            <td><html:text  property="txtFrmYear"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" ></td>
 
            <td class="labelText"  width="15%" ><bean:message key="Payroll.LPC.ToYYMM" /></td>
            <td><html:text  property="txtToYear"  maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(); " />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovToYYMM();" ></td>
            </tr>
 
        <table border=0 cellpadding=0>
              <TR height=60>
              <td width=25% >
               <td width="6%" align="right" value="checked" class="radioText" ><input type="radio" name="optSelect"   onclick="doSetFlag('A');" /><bean:message key="Payroll.LPCReport.All"  />
              <td width="12%" align="right" class="radioText" ><html:radio  property="optSelect" value="B" onclick="doSetFlag('B');" /><bean:message key="Payroll.LPCReport.Emp"  />  
              <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional" readonly="" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtEmpNo" onclick="ShowLovEmpNo();">&nbsp;&nbsp;<html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
              </td>
              </tr>
         
   	 </table>
    </div>

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="60">
            <TD colspan=16>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              
          
              
                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    
                    <TR>
                      <TD width = 30%></td>
  			<!-- Detail table starts -->
                      <TD width = 40%>        
                        
                   </TD>
                   <TD width = 30%></td>                   
                  </TR>                     
                                      
        		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
               <tr>
		
		</TR>
    <TR>
     <TD colspan=16 align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
               <td align=center bgcolor=#4682b4 width="38%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE LPC REPORT'  onclick="doGetReport();" property="butInsert" styleClass="bottomBarText" /></td>
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>

 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
    
<script language="javascript">
function doGetReport()
{
if(LPCReportForm.txtAllEmpFlag.value=='B')
  {                                                                                                                                                                                                                                                                                                                                  
   var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
   window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateLPCReport","GenerateLastPayCertificatekey").trim()%>&emp_number="+LPCReportForm.txtEmp.value+"&startyear="+LPCReportForm.txtFrmYear.value+"&endyear="+LPCReportForm.txtToYear.value,'',win_option);
  }
if(LPCReportForm.txtAllEmpFlag.value=='A')
  {
    var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
    window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateLPCReport","GenerateLastPayCertificateForAllkey").trim()%>&startyear="+LPCReportForm.txtFrmYear.value+"&endyear="+LPCReportForm.txtToYear.value,'',win_option);
  }
}
</script>

	 

</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="LPCReportForm"  property="screenMode"/>
    <html:hidden name="LPCReportForm"  property="screenName" value="GenerateLPCReport" />
    <html:hidden property="buttonFlag" name="LPCReportForm"  />
    <html:hidden property="txtAllEmpFlag" name="LPCReportForm"  />  
    <html:hidden property="lovKey" name="LPCReportForm"  />
    <html:hidden property="txtFields" name="LPCReportForm"  />   
    <html:hidden property="txtSearchFields" name="LPCReportForm"  />
    <html:hidden property="txtDisplayFields" name="LPCReportForm"  />
    <html:hidden property="txtIndex" name="LPCReportForm"  />
   

</html:form>
</body>
</html:html>
<script language="javascript">

function doSetFlag(val)
{ 
  LPCReportForm.txtAllEmpFlag.value=val;   
     
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


function lfnLoad()
{  
  if(LPCReportForm.firstLoad.value=="")
  {
   doBaseOnLoad();
    
  }  
}
function doOnLoad()
{
  return  "LPCReportOnLoadAction.do";
}


function ShowLovYYMM()
{
        LPCReportForm.lovKey.value = "GenerateLPCReportYearFrom" + LPCReportForm.screenName.value + "U";
        LPCReportForm.txtSearchFields.value = "Payroll.LPC.FrYYMM";
        LPCReportForm.txtDisplayFields.value = "txtFrmYear";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LPCReportForm');
        return true;
}

function ShowLovToYYMM()
{
        LPCReportForm.lovKey.value = "GenerateLPCReportYearTo" + LPCReportForm.screenName.value + "U";
        LPCReportForm.txtSearchFields.value = "Payroll.LPC.ToYYMM";
        LPCReportForm.txtDisplayFields.value = "txtToYear";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LPCReportForm');
        return true;
}

function ShowLovEmpNo()
{
        LPCReportForm.lovKey.value = "GenerateLPCReportEmp" + LPCReportForm.screenName.value + "U";
        LPCReportForm.txtSearchFields.value = "Payroll.LPCReport.Emp";
        LPCReportForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LPCReportForm');
        return true;
}
</script>
 
