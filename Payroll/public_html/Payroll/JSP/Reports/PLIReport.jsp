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

<html:form  action="ReportLinkerAction" name="PLIReportForm" type="FCIPAY.Payroll.WEBTIER.Form.PLIReportForm" scope="session" >
<bean:define id="ParentForm" name="PLIReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>PLI REPORT</TD>
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
          <TD class=subHeader colspan=6> PLI Report</TD>
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
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.PLI.Year" /></td><td colspan=2>
              <html:text  property="txtYYMM"  maxlength="6" size="23" styleClass="required"  
                onblur="                                                  
                       if(!(chk_YearMonth()))
                          {
                          }                                            
              " 
              /><bean:message key="Payroll.PLI.yyyy" />
              </td>
      
              </tr>
              </center>
              </table>


              <table border=0 cellpadding=0>
              <TR height=40>
                <td width=25% >
                <TD class=labelText width="20%" >                
                <bean:message key="Payroll.PLI.EmpNumber"  />  
                <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  
				onchange=
							"if(!(checkEmployee(PLIReportForm.txtEmp.value,PLIReportForm.loginLocCode.value)))
							{
								PLIReportForm.txtEmp.value='';
							}"
				/>
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
               <td  bgcolor=#4682b4><html:button value=' GENERATE PLI REPORT'  onclick="return doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
if(mandatory_Check('PLIReportForm'))
{
    var winurl="plipayment.rdf&P_EMP_NUM="+PLIReportForm.txtEmp.value+"&P_YYMM="+PLIReportForm.txtYYMM.value+"&p_LOCATION_CODE="+PLIReportForm.loginLocCode.value+"&P_EMP_FLG="+PLIReportForm.hdnEmpLbrFlag.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.PLIReportForm.submit();
 }
 else{
 return false;
 }
}
</script>
	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="PLIReportForm"  property="screenMode"/>
    <html:hidden name="PLIReportForm"  property="screenName" value="PLIReport" />
    <html:hidden property="buttonFlag" name="PLIReportForm"  />
    <html:hidden property="txtAllEmpFlag" name="PLIReportForm"  />  
    <html:hidden property="txtEmpName" name="PLIReportForm"  />          
    <html:hidden property="txtCpfCode" name="PLIReportForm"  />          

    <html:hidden property="hdnMaxYYMM" name="PLIReportForm"  />    
    <html:hidden property="lovKey" name="PLIReportForm"  />
    <html:hidden property="txtFields" name="PLIReportForm"  />   
    <html:hidden property="txtSearchFields" name="PLIReportForm"  />
    <html:hidden property="txtDisplayFields" name="PLIReportForm"  />
    <html:hidden property="txtIndex" name="PLIReportForm"  />
    <html:hidden property="hdnLoginUserId" name="PLIReportForm"  />    
    <html:hidden property="hdnPayUser" name="PLIReportForm"  />        
    <html:hidden property="hdnLoginUserName" name="PLIReportForm"  />
    <html:hidden property="loginLocCode" name="PLIReportForm"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{ 
	
	mode=document.all.screenMode.value;
	
	//alert("MODE" + mode);
/*  if(PaySlipReportForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  
  disableMenu();
  if(mode != 'Q' )
  {
    PLIReportForm.action="../../../PLIPaymentGetAccess.do"
    PLIReportForm.submit();  
  }
}

function ShowLovYYMM()
{
        PLIReportForm.queryParam.value="hdnMaxYYMM="+ PLIReportForm.hdnMaxYYMM.value +" " ;    
        PLIReportForm.lovKey.value = "ReportGeneratePaySlipYear" + PLIReportForm.screenName.value + "U";
        PLIReportForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        PLIReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PLIReportForm');

        
        return true;
}

function ShowLovEmpNo()
{
        PLIReportForm.lovKey.value = "ReportGeneratePaySlipEmp" + PLIReportForm.screenName.value + "U";
        PLIReportForm.queryParam.value="txtSiteID="+ PLIReportForm.loginLocCode.value +",hdnEmpLbrFlag="+PLIReportForm.hdnEmpLbrFlag.value ; 
        PLIReportForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        PLIReportForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PLIReportForm');
        return true;
}

function chk_YearMonth()
{
       var  yearM = document.getElementById("txtYYMM").value;          
    if(yearM!="")
    {
       var month =  parseInt(yearM.substring(4,6),10);

        var year2 =  parseInt(yearM.substring(4,6),10);
        var year1 =  parseInt(yearM.substring(2,4),10);                            
       
                                                                             
       var  maxYYMM = document.getElementById("hdnMaxYYMM").value;          
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Financial Year should be a Six digit Number");
//        document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }
        
                                                                                
        if(year2!=year1+1)
        {
          alert("Please enter correct Financial Year.");                    
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
</script>
