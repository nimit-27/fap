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

<html:form  action="ReportLinkerAction" name="ArrearCalcRepForm" type="FCIPAY.Payroll.WEBTIER.Form.ArrearCalcRepForm" scope="session" >
<bean:define id="ParentForm" name="ArrearCalcRepForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>ARREAR CALCUATION REPORT</TD>
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
          <TD class=subHeader colspan=6> Arrear Calculation Report</TD>
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
              <TR height=25>         
                  <!-- Detail table Container starts -->                    
                  <TD class=labelText width="40%" ><bean:message key="Payroll.PaySlip.EmpNumber" /></td>
                  <td  align="left" ><html:text  property="txtEmp" maxlength="10" size="16" styleClass="required"  readonly="true" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                  onclick="return ShowLovEmpNo();" >                       
                  <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                  </td>               
              </tr>    
              
              <TR height=25>
         
              <!-- Detail table Container starts -->
              <td class="labelText"  align="left">Year Month</td><td>
              <html:text  property="txtYYMM"  maxlength="6" size="20" styleClass="required"  
                onchange="                                                  
                       if(!(chk_YearMonth('txtYYMM')))
                          {
                          }                                            
              " 

                onblur="                                                  
                       if(!(chk_YearMonth('txtYYMM')))
                          {
                          }                                            
              " 
              /><bean:message key="Payroll.MaintDARates.yymm" />
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
               <td  bgcolor=#4682b4><html:button value='ARREAR CALCULATION REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	if(mandatory_Check('ArrearCalcRepForm'))
	{
		var winurl= "Arrear.rdf&P_PAY_YYMM="+ArrearCalcRepForm.txtYYMM.value+"&P_LOCATION="+ArrearCalcRepForm.loginLocCode.value+"&P_EMP_FLG="+ArrearCalcRepForm.hdnEmpLbrFlag.value+"&P_EMP_NUM="+ArrearCalcRepForm.txtEmp.value;
		document.getElementById('butInsert').value="Please wait. File is being downloaded..";
		document.getElementById('butInsert').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.ArrearCalcRepForm.submit();
	}
	else{
		return false;
	}
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="ArrearCalcRepForm"  property="screenMode"/>
    <html:hidden name="ArrearCalcRepForm"  property="screenName" value="ArrearCalcRep" />
    <html:hidden property="buttonFlag" name="ArrearCalcRepForm"  />
<!--    <html:hidden property="txtEmp" name="ArrearCalcRepForm"  />    -->     
  
    <html:hidden property="lovKey" name="ArrearCalcRepForm"  />
    <html:hidden property="txtFields" name="ArrearCalcRepForm"  />   
    <html:hidden property="txtSearchFields" name="ArrearCalcRepForm"  />
    <html:hidden property="txtDisplayFields" name="ArrearCalcRepForm"  />
    <html:hidden property="txtIndex" name="ArrearCalcRepForm"  />
    <html:hidden property="loginLocCode" name="ArrearCalcRepForm"  />
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
      ArrearCalcRepForm.action="../../../ArrearCalcRepGetAccess.do";
      ArrearCalcRepForm.submit();  
    }
}

function ShowLovEmpNo()
{
    ArrearCalcRepForm.lovKey.value = "ArrearCalc" + ArrearCalcRepForm.screenName.value + "U";
    ArrearCalcRepForm.queryParam.value="txtSiteID="+ ArrearCalcRepForm.loginLocCode.value +",hdnEmpLbrFlag="+ArrearCalcRepForm.hdnEmpLbrFlag.value ; 
    ArrearCalcRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
    ArrearCalcRepForm.txtDisplayFields.value = "txtEmp,txtEmpName";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','ArrearCalcRepForm');
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
          alert("Year should be a four digit Number");
          //document.getElementById(input).focus();                     
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