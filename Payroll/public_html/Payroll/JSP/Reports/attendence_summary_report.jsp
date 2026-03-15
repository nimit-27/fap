<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>
<%
    String lbrType = (String)session.getAttribute("hdnEmpLbrFlag"); 
%>
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

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="ReportLinkerAction" name="AttendnceSummRepForm" type="FCIPAY.Payroll.WEBTIER.Form.AttendnceSummRepForm" scope="session" >
<bean:define id="ParentForm" name="AttendnceSummRepForm" toScope="request" />

<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

  <html:errors/>

<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="headerDataChanged" value="false" />

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>ATTENDENCE SUMMARY REPORT</TD>
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
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         
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
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.PaySlip.Year" /></td><td colspan=2>
              <html:text  property="txtYYMM"  maxlength="6" size="23" styleClass="required"  
                onblur="                                                  
                       if(!(chk_YearMonth()))
                          {
                          }                                            
              " 
              /><bean:message key="Payroll.MaintDARates.yymm" />
              </td>
      
              </tr>
              </center>
              </table>
              
              <table border=0 cellpadding=0>
              <TR height=40>
                <td width=25% >
                <TD class=labelText width="20%" >                
                Depot No  
                <td  align="left">
                <html:text  property="txtDepotId" maxlength="10" size="20" styleClass="optional"  readonly="true" />
               
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovDepot();" >
                <html:text property="txtDepotName"  size="35" value="" styleClass="locked" readonly="true" /></td>
                
                </td>
                 
                </tr>         
           
                <tr height="15" >
            <td colspan="4"></td>
         </tr>         
        </table>
        <%if(!lbrType.equals("N")){%>
        <table border=0 cellpadding=0>
              <TR height=40>
                <td width=25% >
                <TD class=labelText width="20%" >                
                Gang Name  
                <td  align="left">
                <html:text  property="txtGangId" maxlength="10" size="20" styleClass="optional"  readonly="true" />
               
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovGang();" >
                <html:text property="txtGangName"  size="35" value="" styleClass="locked" readonly="true" /></td>
                </td>
                </tr>         
                <tr height="15" >
            <td colspan="4"></td>
         </tr>         
        </table>
        <%}%>

<!-- Tab table Row 3 starts -->

  <TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>
         <tr height="15" >
            <td colspan="16"></td>
         </tr>

      <TR>
               <td align=center bgcolor=#4682b4 width="37%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE ATTENDENCE SUMMARY REPORT' onclick="doGetReport()"  property="butInsert" styleClass="bottomBarText" /></td>
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

if(mandatory_Check('AttendnceSummRepForm'))
{
	var lbr_flag = AttendnceSummRepForm.hdnEmpLbrFlag.value;
	if (lbr_flag == 'D')
		var winurl="attendence_summary_report_DPS.rdf&P_DEPOT_CODE="+AttendnceSummRepForm.txtDepotId.value+"&P_YYMM="+AttendnceSummRepForm.txtYYMM.value+"&P_LOC_ID="+AttendnceSummRepForm.loginLocCode.value+"&P_EMP_TYPE="+
		AttendnceSummRepForm.hdnEmpLbrFlag.value+"&P_GANG_ID="+AttendnceSummRepForm.txtGangId.value;
	else if (lbr_flag == 'L')
		var winurl="attendence_summary_report_DEPT.rdf&P_DEPOT_CODE="+AttendnceSummRepForm.txtDepotId.value+"&P_YYMM="+AttendnceSummRepForm.txtYYMM.value+"&P_LOC_ID="+AttendnceSummRepForm.loginLocCode.value+"&P_EMP_TYPE="+
		AttendnceSummRepForm.hdnEmpLbrFlag.value+"&P_GANG_ID="+AttendnceSummRepForm.txtGangId.value;
	else if (lbr_flag == 'N')
                var winurl="attendence_summary_report_NWNP.rdf&P_DEPOT_CODE="+AttendnceSummRepForm.txtDepotId.value+"&P_YYMM="+AttendnceSummRepForm.txtYYMM.value+"&P_LOC_ID="+AttendnceSummRepForm.loginLocCode.value+"&P_EMP_TYPE="+
		AttendnceSummRepForm.hdnEmpLbrFlag.value;
        	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
		document.getElementById('butInsert').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.AttendnceSummRepForm.submit();
}
else
{
    return false;
}
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="AttendnceSummRepForm"  property="screenMode"/>
    <html:hidden name="AttendnceSummRepForm"  property="screenName" value="AttendenceSummReport" />
    <html:hidden property="buttonFlag" name="AttendnceSummRepForm"  />
    <html:hidden property="txtAllEmpFlag" name="AttendnceSummRepForm"  />
      
    <html:hidden property="lovKey" name="AttendnceSummRepForm"  />
    <html:hidden property="txtFields" name="AttendnceSummRepForm"  />   
    <html:hidden property="txtSearchFields" name="AttendnceSummRepForm"  />
    <html:hidden property="txtDisplayFields" name="AttendnceSummRepForm"  />
    <html:hidden property="txtIndex" name="AttendnceSummRepForm"  />
    <html:hidden property="hdnLoginUserId" name="AttendnceSummRepForm"  />    
    <html:hidden property="hdnPayUser" name="AttendnceSummRepForm"  />        
    <html:hidden property="hdnLoginUserName" name="AttendnceSummRepForm"  />
    <html:hidden property="loginLocCode" name="AttendnceSummRepForm"  />
    <html:hidden property="txtInputField" name="AttendnceSummRepForm"  />
	<html:hidden property="txtSiteCode" name="AttendnceSummRepForm"/>
    <html:hidden property="txtSiteDesc" name="AttendnceSummRepForm"  />
	<html:hidden property="txtUserFlag" name="AttendnceSummRepForm"  />

	<input type="hidden" name="queryParam" />
	<input type="hidden" id="submitParam" name="submitParam" />       
    
</html:form>
</body>
</html:html>

<script language="javascript">

function lfnLoad()
{  

 
  mode=document.all.screenMode.value;
  
  disableMenu();
  if(mode != 'Q' )
  {
    AttendnceSummRepForm.action="../../../AttendnceSummRepFormGetAccess.do"
    AttendnceSummRepForm.submit();  
  }
}




function chk_YearMonth()
{
       var  yearM = document.getElementById("txtYYMM").value;          
    if(yearM!=""){
	   
       var month =  parseInt(yearM.substring(4,6),10);

    
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Year Month should be a Six digit Number");
//        document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

       if(month < 1 || month > 12)
       {
       alert("Month should be Within 1 to 12");
       document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                    
          return false;
       }
        return true;
     }
     else
     {
              document.getElementById("txtYYMM").select();
     //       event.srcElement.select();
      //      event.srcElement.focus();
     //       event.returnValue=false;     
    return false;
     }
    }
}



function ShowLovDepot()
{
	//alert(AttendnceSummRepForm.loginLocCode.value)
    AttendnceSummRepForm.lovKey.value = "DailyAttSummLst" + AttendnceSummRepForm.screenName.value + "Q";
    AttendnceSummRepForm.queryParam.value="txtSiteID="+ AttendnceSummRepForm.loginLocCode.value +",hdnEmpLbrFlag="+AttendnceSummRepForm.hdnEmpLbrFlag.value ;           
    AttendnceSummRepForm.txtDisplayFields.value = "txtDepotId,txtDepotName";
    AttendnceSummRepForm.txtSearchFields.value = "";
    AttendnceSummRepForm.txtIndex.value="";              
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'AttendnceSummRepForm');
    return true;
}

function ShowLovGang()
{
    AttendnceSummRepForm.lovKey.value = "DailyAttGangLstSummLst" + AttendnceSummRepForm.screenName.value + "Q";
    AttendnceSummRepForm.queryParam.value="txtDepotId="+ AttendnceSummRepForm.txtDepotId.value +",hdnEmpLbrFlag="+AttendnceSummRepForm.hdnEmpLbrFlag.value ;           
    AttendnceSummRepForm.txtDisplayFields.value = "txtGangId,txtGangName";
    AttendnceSummRepForm.txtSearchFields.value = "";
    AttendnceSummRepForm.txtIndex.value="";              
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'AttendnceSummRepForm');
    return true;
}
</script>
