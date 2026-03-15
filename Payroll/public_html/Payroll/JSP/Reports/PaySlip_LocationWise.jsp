<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
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

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="PaySlipLocBaseAction" name="PaySlipLocationForm" type="FCIPAY.Payroll.WEBTIER.Form.PaySlipLocationForm" scope="session" >
<bean:define id="ParentForm" name="PaySlipLocationForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>PAY SLIP LOCATION WISE REPORT</TD>
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
          <TD class=subHeader colspan=6> Pay Slip Location Wise Report</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2">&nbsp;</td>
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
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.PaySlip.Year" /></td><td colspan=2>
              <html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required"  
                onchange="                                                  
                       if(!(chk_YearMonth()))
                          {
                          }                  
              " />
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovYYMM();" >
              </td>      
              </tr>

                <tr>
                <td class="labelText"  width="45%" align="center">
                <bean:message key="Payroll.PaySlip.Location"  />  
                <td  align="left"><html:text  property="txtLocation" maxlength="10" size="20" styleClass="optional"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtLocation" onclick="ShowLovLocation();">&nbsp;&nbsp;
                </tr>
              
              </center>
              </table>        
               

<!-- Tab table Row 3 starts -->

  <TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>
         <tr height="15" >
            <td colspan="16">&nbsp;</td>
         </tr>

      <TR>
               <td align=center bgcolor=#4682b4 width="37%">&nbsp;</td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE PAY SLIP REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
               <td width="45%" bgColor=#4682b4>&nbsp;</td>
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
    window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","PaySlipReport","PaySlipReportForAllkey").trim()%>&yearmonth="+PaySlipLocationForm.txtYYMM.value+"&location_code="+PaySlipLocationForm.txtLocation.value,'',win_option);
}

</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="PaySlipLocationForm"  property="screenMode"/>
    <html:hidden name="PaySlipLocationForm"  property="screenName" value="PaySlipLocReport" />
    <html:hidden property="buttonFlag" name="PaySlipLocationForm"  />
    <html:hidden property="txtAllEmpFlag" name="PaySlipLocationForm"  />  
    <html:hidden property="lovKey" name="PaySlipLocationForm"  />
    <html:hidden property="txtFields" name="PaySlipLocationForm"  />   
    <html:hidden property="txtSearchFields" name="PaySlipLocationForm"  />
    <html:hidden property="txtDisplayFields" name="PaySlipLocationForm"  />
    <html:hidden property="txtIndex" name="PaySlipLocationForm"  />
    <html:hidden property="hdnLoginUserId" name="PaySlipLocationForm"  />    
    <html:hidden property="hdnPayUser" name="PaySlipLocationForm"  />        
    <html:hidden property="hdnLoginUserName" name="PaySlipLocationForm"  />                
    
</html:form>
</body>
</html:html>



<script language="javascript">

function doSetFlag(val)
{ 
  PaySlipLocationForm.txtAllEmpFlag.value=val;        
  
  if(val=='B')
  {
    document.all.txtEmp.style.background = "#ffffd3";
    document.all.butTxtEmpNo.disabled="";
    document.all.butTxtEmpNo.className="required";
  }
  else
  {
    document.all.txtEmp.value="";
    document.all.txtEmpName.value="";
    document.all.txtEmp.style.background = "#e0e0e0";   
    document.all.butTxtEmpNo.disabled="";    
//    document.all.butTxtEmpNo.disabled="true";
    document.all.txtEmp.className="optional";
  }
     
}


function lfnLoad()
{  
  mode=document.all.screenMode.value;
}

function doOnLoad()
{
  return  "PaySlipOnLoadAction.do";
}


function ShowLovYYMM()
{

        PaySlipLocationForm.lovKey.value = "ReportGeneratePaySlipLocYear" + PaySlipLocationForm.screenName.value + "U";
        PaySlipLocationForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        PaySlipLocationForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PaySlipLocationForm');

        
        return true;
}

function ShowLovLocation()
{
        PaySlipLocationForm.lovKey.value = "ReportGeneratePaySlipLoc" + PaySlipLocationForm.screenName.value + "U";
        PaySlipLocationForm.txtSearchFields.value = "Payroll.PaySlip.Location";
        PaySlipLocationForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PaySlipLocationForm');
        return true;
}

function chk_YearMonth()
{
       var  yearM = document.getElementById("txtYYMM").value;          
       var month =  parseInt(yearM.substring(4,6),10);
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Revision Year Month should be a Six digit Number");
//        document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

      if (yearM < 200609)
      { 
        alert("Year Month Should Be Greater Than or Equal to 200609");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                    
        return false;
      }
  
       if(month < 1 || month > 12)
       {
       alert("Revision  Month should be Within 1 to 12");
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
     //       event.srcElement.select();
      //      event.srcElement.focus();
     //       event.returnValue=false;     
    return false;
     }
}

</script>
