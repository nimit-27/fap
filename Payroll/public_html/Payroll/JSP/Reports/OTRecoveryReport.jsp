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

<html:form  action="ReportLinkerAction" name="OTRecoveryRepForm" type="FCIPAY.Payroll.WEBTIER.Form.OTRecoveryRepForm" scope="session" >
<bean:define id="ParentForm" name="OTRecoveryRepForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>OVERTIME RECOVERY REPORT</TD>
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
          <TD class=subHeader colspan=6> OverTime Recovery Report</TD>
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
              <td class="labelText"  width="25%" align="center">From Year Month</td><td>
              <html:text  property="txtFromYYMM"  maxlength="6" size="23" styleClass="required"  
                onchange="                                                  
                       if(!(chk_YearMonth('txtFromYYMM')))
                          {
                          }                                            
              " 

                onblur="                                                  
                       if(!(chk_YearMonth('txtFromYYMM')))
                          {
                          }                                            
              " 
              />
              </td>

              <td class="labelText"  width="25%" align="center">To Year Month</td><td >
              <html:text  property="txtToYYMM"  maxlength="6" size="23" styleClass="required"  
                onchange="                                                  
                       if(!(chk_YearMonth('txtToYYMM')))
                          {
                          }                                            
              " 

                onblur="                                                  
                       if(!(chk_YearMonth('txtToYYMM')))
                          {
                          }                                            
              " 
              />
              </td>

      
              </tr>
              </center>
              </table>


              <table border=0 cellpadding=0>
              <TR height=40>
                <td width=25% >
                <TD class=labelText width="20%" >                
                <bean:message key="Payroll.PaySlip.EmpNumber"  />  
                <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  readonly="true" />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovEmpNo();" >
                <html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
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
               <td  bgcolor=#4682b4><html:button value=' OT RECOVERY REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
if(mandatory_Check('OTRecoveryRepForm'))
{
    var winurl= "overtime_recovery.rdf&P_EMP_NUM="+OTRecoveryRepForm.txtEmp.value+"&P_YYMM_FRM="+OTRecoveryRepForm.txtFromYYMM.value+"&P_YYMM_TO="+OTRecoveryRepForm.txtToYYMM.value+"&P_LOCATION="+OTRecoveryRepForm.loginLocCode.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.PaySlipReportForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="OTRecoveryRepForm"  property="screenMode"/>
    <html:hidden name="OTRecoveryRepForm"  property="screenName" value="OTRecoveryRep" />
    <html:hidden property="buttonFlag" name="OTRecoveryRepForm"  />   
  
    <html:hidden property="lovKey" name="OTRecoveryRepForm"  />
    <html:hidden property="txtFields" name="OTRecoveryRepForm"  />   
    <html:hidden property="txtSearchFields" name="OTRecoveryRepForm"  />
    <html:hidden property="txtDisplayFields" name="OTRecoveryRepForm"  />
    <html:hidden property="txtIndex" name="OTRecoveryRepForm"  />
    <html:hidden property="txtCpfCode" name="OTRecoveryRepForm"  />                     <!--added by dushyant on 20-08-2010-->
    <html:hidden property="loginLocCode" name="OTRecoveryRepForm"  />
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
    OTRecoveryRepForm.action="../../../OTRecoveryRepGetAccess.do";
    OTRecoveryRepForm.submit();  
  }
}

function ShowLovEmpNo()
{
        OTRecoveryRepForm.lovKey.value = "ReportOTRecoveryEmp" + OTRecoveryRepForm.screenName.value + "U";
        OTRecoveryRepForm.queryParam.value="txtSiteID="+ OTRecoveryRepForm.loginLocCode.value +" " ; 
        OTRecoveryRepForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        OTRecoveryRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','OTRecoveryRepForm');
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
        alert("Year Month should be a Six digit Number");
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
