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

<BODY  onload="lfnLoad();"  scroll=no  onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

  <html:form  action="PayITForecastProjBaseAction" name="PayITForecastProjForm" type="FCIPAY.Payroll.WEBTIER.Form.PayITForecastProjForm" scope="session" >
<bean:define id="ParentForm" name="PayITForecastProjForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>IT FORECAST PROJECTION REPORT</TD>
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
          <TD class=subHeader colspan=6> IT Forecast Report</TD>
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
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.ITForecast.Year" /></td><td colspan=2><html:text  property="txtYYMM" readonly = "true"  maxlength="10" size="23" styleClass="required"  />
              </td>      
              </tr>
              </center>
              </table>
              <table border=0 cellpadding=0>
              <TR height=40>
              <logic:equal property= "hdnPayUser" name= "PayITForecastProjForm" value="Y">                            
              <td width=25% >
               <td width="6%" align="right" value="checked" class="radioText" ><input type="radio" name="optSelect"   onclick="doSetFlag('A');" /><bean:message key="Payroll.ITForecast.All"  />
              <td width="12%" align="right" class="radioText" ><html:radio  property="optSelect" value="B" onclick="doSetFlag('B');" /><bean:message key="Payroll.ITForecast.Emp"  />  
              <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional" readonly="" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtEmp" onclick="ShowLovEmpNo();">&nbsp;&nbsp;<html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
              </td>
              </tr>
           </logic:equal>                

            <logic:equal property= "hdnPayUser" name= "PayITForecastProjForm" value="N">              
                <td width=25% >
                <TD class=labelText width="20%" >                
                <bean:message key="Payroll.PaySlip.EmpNumber"  />  
                <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  readonly="true" />
                <html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
                </td>
                </tr>
           </logic:equal>                

              <logic:equal property= "hdnPayUser" name= "PayITForecastProjForm" value="">                            
                <td width=25% >
                <TD class=labelText width="20%" >                
                <bean:message key="Payroll.PaySlip.EmpNumber"  />  
                <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  readonly="true" />
                <html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
                </td>
                </tr>
           </logic:equal>                
           
           
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
               <td  bgcolor=#4682b4><html:button value=' GENERATE IT FORECAST REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
   window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","PayITForecastProjReport","payGenerateITForecastProjLockey").trim()%>&P_EMPNO="+PayITForecastProjForm.txtEmp.value+"&P_EMPLOC="+PayITForecastProjForm.hdnLocation.value+"&P_YYYYMM="+PayITForecastProjForm.txtYYMM.value,'',win_option);
//    window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","PayITForecastProjReport","payGenerateITForecastProjLockey").trim()%>&P_EMPNO="+PayITForecastProjForm.txtEmp.value+"&P_EMPLOC="+PayITForecastProjForm.hdnLocation.value+"&P_YYYYMM="+PayITForecastProjForm.txtYYMM.value);
  }
</script>	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

<html:hidden name="PayITForecastProjForm"  property="screenMode"/>
    <html:hidden name="PayITForecastProjForm"  property="screenName" value="PayITForecastProjReport"/>
    <html:hidden property="buttonFlag" name="PayITForecastProjForm"  />
    <html:hidden property="txtAllEmpFlag" name="PayITForecastProjForm"  />  
    <html:hidden property="lovKey" name="PayITForecastProjForm"  />
    <html:hidden property="txtFields" name="PayITForecastProjForm"  />   
    <html:hidden property="txtSearchFields" name="PayITForecastProjForm"  />
    <html:hidden property="txtDisplayFields" name="PayITForecastProjForm"  />
    <html:hidden property="txtIndex" name="PayITForecastProjForm"  />
    <html:hidden property="hdnLoginUserId" name="PayITForecastProjForm"  />    
    <html:hidden property="hdnLocation" name="PayITForecastProjForm"  />        
    <html:hidden property="hdnPayUser" name="PayITForecastProjForm"  />        
    <html:hidden property="hdnLoginUserName" name="PayITForecastProjForm"  />                       

</html:form>
</body>
</html:html>



<script language="javascript">

function doSetFlag(val)
{ 
  PayITForecastProjForm.txtAllEmpFlag.value=val;   
  
  if(val=='B')
  {
    document.all.txtEmp.style.background = "#ffffd3";
    document.all.butTxtEmp.disabled="";
    document.all.txtEmp.disabled="";
    document.all.butTxtEmp.className="required";
  }
  else
  {
    document.all.txtEmp.value="";
    document.all.txtEmp.disabled="true";    
    document.all.txtEmpName.value="";
    document.all.txtEmp.style.background = "#e0e0e0";   
    document.all.butTxtEmp.disabled="true";
    document.all.txtEmp.className="optional";
  }     
}


function lfnLoad()
{  

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    PayITForecastProjForm.action="../../../PayITProjGetMaxYYMM.do"
    PayITForecastProjForm.submit();  
  }
  if(mode = 'Q' )
  {
     PayITForecastProjForm.txtEmp.value=PayITForecastProjForm.hdnLoginUserId.value;
     PayITForecastProjForm.txtEmpName.value=PayITForecastProjForm.hdnLoginUserName.value;          
     PayITForecastProjForm.txtAllEmpFlag.value="B"; 
  }  
}

function doOnLoad()
{
  return  "PayITForecastOnLoadAction.do";
}


function ShowLovYYMM()
{
        PayITForecastProjForm.lovKey.value = "ReportGenerateITForecastYear" + PayITForecastProjForm.screenName.value + "U";
        PayITForecastProjForm.txtSearchFields.value = "Payroll.ITForecast.Year";
        PayITForecastProjForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PayITForecastProjForm');
        return true;
}

function ShowLovEmpNo()
{
        PayITForecastProjForm.lovKey.value = "ReportGeneratePayITForecastEmp" + PayITForecastProjForm.screenName.value + "U";
        PayITForecastProjForm.txtSearchFields.value = "Payroll.ITForecast.Emp,Payroll.ITForecast.EmpName";
        PayITForecastProjForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PayITForecastProjForm');
        return true;
}
</script>