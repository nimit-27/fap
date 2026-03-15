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

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="ReportLinkerAction" name="LoanRecoveryRepForm" type="FCIPAY.Payroll.WEBTIER.Form.LoanRecoveryRepForm" scope="session" >
<bean:define id="ParentForm" name="LoanRecoveryRepForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>LOAN OUTSTANDING REPORT</TD>
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
          <TD class=subHeader colspan=6> Loan Outstanding Report</TD>
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
              <TR height=60>
         
		<!-- Detail table Container starts -->
              <td class="labelText"  align="left">Year Month</td><td>
              <html:text  property="txtFromYYMM"  maxlength="6" size="23" styleClass="required"  
                onchange="                                                  
                       if(!(chk_YearMonth('txtFromYYMM')))
                          {
                          }                                            
              "
              />
              </td>
      
              </tr>

              <TR >
                <TD class=labelText >                
                Loan Type</TD>
                <td  align="left"><html:text  property="txtPayCode" maxlength="10" size="20" styleClass="required"   />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovLoanType();" >
                <html:text property="txtPayCodeDesc"  value="" styleClass="locked" readonly="true" /></td>
                </td>
                </tr>           
           
           
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
               <td  bgcolor=#4682b4><html:button value=' LOAN OUTSTANDING REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	var check_valid=chk_YearMonth('txtFromYYMM');
    
    if(check_valid == false)
    {
        document.getElementById("txtFromYYMM").focus();   
        return false;
    }
	else
	{
		if(mandatory_Check('LoanRecoveryRepForm'))
		{
			var winurl= "LOAN_adv.rdf&P_yyyymm="+LoanRecoveryRepForm.txtFromYYMM.value+"&loc_id="+LoanRecoveryRepForm.loginLocCode.value+"&loan_type="+LoanRecoveryRepForm.txtPayCode.value+"&P_EMP_TYPE="+LoanRecoveryRepForm.hdnEmpLbrFlag.value;
			document.getElementById('butInsert').value="Please wait. File is being downloaded..";
			document.getElementById('butInsert').disabled="true";
			document.getElementById('submitParam').value = winurl;
			document.LoanRecoveryRepForm.submit();
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

    <html:hidden name="LoanRecoveryRepForm"  property="screenMode"/>
    <html:hidden name="LoanRecoveryRepForm"  property="screenName" value="LoanOutRep" />
    <html:hidden property="buttonFlag" name="LoanRecoveryRepForm"  />
<!--    <html:hidden property="txtEmp" name="LoanRecoveryRepForm"  />    -->     
  
    <html:hidden property="lovKey" name="LoanRecoveryRepForm"  />
    <html:hidden property="txtFields" name="LoanRecoveryRepForm"  />   
    <html:hidden property="txtSearchFields" name="LoanRecoveryRepForm"  />
    <html:hidden property="txtDisplayFields" name="LoanRecoveryRepForm"  />
    <html:hidden property="txtIndex" name="LoanRecoveryRepForm"  />
    <html:hidden property="loginLocCode" name="LoanRecoveryRepForm"  />
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
    LoanRecoveryRepForm.action="../../../LoanOutRepGetAccess.do";
    LoanRecoveryRepForm.submit();  
  }
}

function ShowLovLoanType()
{
        LoanRecoveryRepForm.lovKey.value = "ReportLoanRecoveryType" + LoanRecoveryRepForm.screenName.value + "U";
		LoanRecoveryRepForm.queryParam.value = "hdnEmpLbrFlag="+LoanRecoveryRepForm.hdnEmpLbrFlag.value+",screenName="+LoanRecoveryRepForm.screenName.value+",screenMode="+LoanRecoveryRepForm.screenMode.value+",txtSiteID="+LoanRecoveryRepForm.loginLocCode.value; 

        LoanRecoveryRepForm.txtSearchFields.value = "Payroll.Report.PayCode,Payroll.Report.PayCodeDesc";
        LoanRecoveryRepForm.txtDisplayFields.value = "txtPayCode,txtPayCodeDesc";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LoanRecoveryRepForm');
        return true;
}


function chk_YearMonth(input)
{
       var  yearM = document.getElementById(input).value;          
       var month =  parseInt(yearM.substring(4,6),10);
      
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Year Month should be a six digit Number");
//        document.getElementById(input).focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

       if(month < 1 || month > 12)
       {
       alert("Month should be Within 1 to 12");
       document.getElementById(input).focus();                     
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