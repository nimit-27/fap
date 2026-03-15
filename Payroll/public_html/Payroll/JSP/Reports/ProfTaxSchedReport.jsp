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

<html:form  action="ReportLinkerAction" name="frmProfTaxSchedReport" type="FCIPAY.Payroll.WEBTIER.Form.ProfTaxSchedReportForm" scope="session" >
<bean:define id="ParentForm" name="frmProfTaxSchedReport" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>PROFESSIONAL TAX SCHEDULE REPORT</TD>
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
          <TD class=subHeader colspan=6> Professional Tax Schedule Report</TD>
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
                onchange="                                                  
                       if(!(chk_YearMonth()))
                          {
                          }                                            
						" 
              />
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
         <td  bgcolor=#4682b4><html:button value=' GENERATE PROFESSIONAL TAX SCHEDULE REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	var check_valid=chk_YearMonth();
    
    if(check_valid == false)
    {
        document.getElementById("txtYYMM").focus();   
        return false;
    }
	else
	{
		if(mandatory_Check('frmProfTaxSchedReport'))
		{
			var winurl="Profess_TaxSched.rdf&P_MONTHYR="+frmProfTaxSchedReport.txtYYMM.value+"&P_LOCATION="+frmProfTaxSchedReport.loginLocCode.value+"&P_EMP_FLG="+frmProfTaxSchedReport.hdnEmpLbrFlag.value;
			document.getElementById('butInsert').value="Please wait. File is being downloaded..";
			document.getElementById('butInsert').disabled="true";
			document.getElementById('submitParam').value = winurl;
			document.frmProfTaxSchedReport.submit();
		}
		else{
		return false;
		}
	}
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="frmProfTaxSchedReport"  property="screenMode"/>
    <html:hidden name="frmProfTaxSchedReport"  property="screenName" value="ProfTaxSchedReport" />
    <html:hidden property="buttonFlag" name="frmProfTaxSchedReport"  />     
    <html:hidden property="lovKey" name="frmProfTaxSchedReport"  />
    <html:hidden property="txtFields" name="frmProfTaxSchedReport"  />   
    <html:hidden property="txtSearchFields" name="frmProfTaxSchedReport"  />
    <html:hidden property="txtDisplayFields" name="frmProfTaxSchedReport"  />
    <html:hidden property="txtIndex" name="frmProfTaxSchedReport"  />        
    <html:hidden property="loginLocCode" name="frmProfTaxSchedReport"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(frmProfTaxSchedReport.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    frmProfTaxSchedReport.action="../../../ProfTaxSchedGetAccess.do"
    frmProfTaxSchedReport.submit();  
  }
}

function ShowLovYYMM()
{
    frmProfTaxSchedReport.queryParam.value="hdnMaxYYMM="+ frmProfTaxSchedReport.hdnMaxYYMM.value +" " ;    
    frmProfTaxSchedReport.lovKey.value = "ReportGeneratePaySlipYear" + frmProfTaxSchedReport.screenName.value + "U";
    frmProfTaxSchedReport.txtSearchFields.value = "Payroll.PaySlip.Year";
    frmProfTaxSchedReport.txtDisplayFields.value = "txtYYMM";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmProfTaxSchedReport');
    
    return true;
}

function chk_YearMonth()
{      
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);    
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

</script>
