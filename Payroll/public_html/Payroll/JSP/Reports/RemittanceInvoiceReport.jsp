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

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="ReportLinkerAction" name="RemittanceInvoiceReportForm" type="FCIPAY.Payroll.WEBTIER.Form.RemittanceInvoiceReportForm" scope="session" >
<bean:define id="ParentForm" name="RemittanceInvoiceReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>REMITTANCES INVOICE REPORT</TD>
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
          <TD class=subHeader colspan=6> Remittances Invoice Report</TD>
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
        
               

<!-- Tab table Row 3 starts -->

  <TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>
         <tr height="15" >
            <td colspan="16"></td>
         </tr>

      <TR>
               <td align=center bgcolor=#4682b4 width="37%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE REMITTANCES INVOICE REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
if(mandatory_Check('RemittanceInvoiceReportForm'))
{
    var winurl="remittancereport.rdf&P_YYMM="+RemittanceInvoiceReportForm.txtYYMM.value+"&P_LOCATION="+RemittanceInvoiceReportForm.loginLocCode.value+"&P_EMP_FLG="+RemittanceInvoiceReportForm.hdnEmpLbrFlag.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.RemittanceInvoiceReportForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="RemittanceInvoiceReportForm"  property="screenMode"/>
    <html:hidden name="RemittanceInvoiceReportForm"  property="screenName" value="RemittanceInvoiceReport" />
    <html:hidden property="buttonFlag" name="RemittanceInvoiceReportForm"  />       

    
    <html:hidden property="lovKey" name="RemittanceInvoiceReportForm"  />
    <html:hidden property="txtFields" name="RemittanceInvoiceReportForm"  />   
    <html:hidden property="txtSearchFields" name="RemittanceInvoiceReportForm"  />
    <html:hidden property="txtDisplayFields" name="RemittanceInvoiceReportForm"  />
    <html:hidden property="txtIndex" name="RemittanceInvoiceReportForm"  />   
    <html:hidden property="loginLocCode" name="RemittanceInvoiceReportForm"  />
    <html:hidden property="locTyp" name="RemittanceInvoiceReportForm"  />  
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(RemittanceInvoiceReportForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    RemittanceInvoiceReportForm.action="../../../RemittanceInvoiceGetAccess.do"
    RemittanceInvoiceReportForm.submit();  
  }
}

function ShowLovYYMM()
{
        RemittanceInvoiceReportForm.queryParam.value="hdnMaxYYMM="+ RemittanceInvoiceReportForm.hdnMaxYYMM.value +" " ;    
        RemittanceInvoiceReportForm.lovKey.value = "ReportGeneratePaySlipYear" + RemittanceInvoiceReportForm.screenName.value + "U";
        RemittanceInvoiceReportForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        RemittanceInvoiceReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','RemittanceInvoiceReportForm');       
        return true;
}

function chk_YearMonth()
{      
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);    
    if(yearM!=""){
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        }
        else
        {
            return true;
        }
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;     
        return false;
        }
    }
}

</script>
