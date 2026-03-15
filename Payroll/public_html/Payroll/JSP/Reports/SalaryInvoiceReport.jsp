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

<BODY  onload="lfnLoad();"  scroll=no  onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="ReportLinkerAction" name="SalaryInvoiceReportForm" type="FCIPAY.Payroll.WEBTIER.Form.SalaryInvoiceReportForm" scope="session" >
<bean:define id="ParentForm" name="SalaryInvoiceReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>SALARY INVOICE REPORT</TD>
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
          <TD class=subHeader colspan=6> Salary Invoice Report</TD>
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
              <tr>
         
		<!-- Detail table Container starts -->
              <td class="labelText" align="center"><bean:message key="Payroll.PaySlip.Year" /></td>
			  <td>
              <html:text  property="txtYYMM"  maxlength="6" size="23" styleClass="required"  
                onblur="                                                  
                       if(!(chk_YearMonth()))
                          {
                          }                                            
              " 
              /><bean:message key="Payroll.MaintDARates.yymm" />
              </td>
      
              
         
		     <td class="labelText" align="center"><bean:message key="pr.PayCode.code" /></td>
             <td ><html:text property="txtPayCode"     styleClass="required"  readonly="true"/>
                                                                          
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center"  property="buttxtPayCode"   onclick="ShowLovPayCode1();" >
                                                                                                       
                                                                           
                                      <html:text property="txtDescription"  styleClass="locked" readonly="true"    /></td>

              </tr>
<logic:notEqual name="SalaryInvoiceReportForm" property="hdnEmpLbrFlag" value='E' >
			  <tr>
					
					<td class="labelText"  align="center">Location/Depot Name</td>
					<td><html:text property="txtLocId" styleClass="optional"  readonly="true"/>
					<logic:equal name="SalaryInvoiceReportForm" property="screenMode" value="U" >            
							<IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" >
							</logic:equal>            
							<logic:notEqual name="SalaryInvoiceReportForm" property="screenMode" value="U" >
							<IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" onclick="return ShowSite();" >
							</logic:notEqual>            
							<html:text  property="txtLocation" maxlength="10" styleClass="locked" readonly="true" />
						
					</td>

                                        <%if(!lbrType.equals("N")){%>
					<td class="labelText" align="center" >Gang Name</td>
						<td><html:text property="txtGangId" styleClass="optional"  readonly="true"/>
							<logic:equal name="SalaryInvoiceReportForm" property="screenMode" value="Q" >
								
								<IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
							</logic:equal>
							<logic:equal name="SalaryInvoiceReportForm" property="screenMode" value="N" >
								<IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >        
							</logic:equal>
							<logic:equal name="SalaryInvoiceReportForm" property="screenMode" value="U" >
								 <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >        
							</logic:equal>
							<html:text  property="txtGangName" maxlength="10" styleClass="locked" readonly="true" />  
						</td>
                                        <%}%>

			  </tr>
</logic:notEqual>
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
               <td  bgcolor=#4682b4><html:button value=' GENERATE SALARY INVOICE REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	if(mandatory_Check('SalaryInvoiceReportForm'))
	{
		if(document.all.hdnEmpLbrFlag.value !='E')
		{
                      if(document.all.hdnEmpLbrFlag.value =='N')
			var winurl="salaryInvoice_labour.rdf&P_YYMM="+SalaryInvoiceReportForm.txtYYMM.value+"&P_LOCATION="+SalaryInvoiceReportForm.loginLocCode.value+"&P_LOCATION_TYPE="+SalaryInvoiceReportForm.locTyp.value+"&P_EMP_FLG="+SalaryInvoiceReportForm.hdnEmpLbrFlag.value+"&P_PAYCODE="+SalaryInvoiceReportForm.txtPayCode.value+"&P_LOCATIONID="+SalaryInvoiceReportForm.txtLocId.value;//Added by Shivani on 24 Dec,2020
                      
                      else
			var winurl="salaryInvoice_labour.rdf&P_YYMM="+SalaryInvoiceReportForm.txtYYMM.value+"&P_LOCATION="+SalaryInvoiceReportForm.loginLocCode.value+"&P_LOCATION_TYPE="+SalaryInvoiceReportForm.locTyp.value+"&P_EMP_FLG="+SalaryInvoiceReportForm.hdnEmpLbrFlag.value+"&P_PAYCODE="+SalaryInvoiceReportForm.txtPayCode.value+"&P_LOCATIONID="+SalaryInvoiceReportForm.txtLocId.value+"&P_GANGID="+SalaryInvoiceReportForm.txtGangId.value;
		}
		else
		{
			winurl="salaryinvoice.rdf&P_YYMM="+SalaryInvoiceReportForm.txtYYMM.value+"&P_LOCATION="+SalaryInvoiceReportForm.loginLocCode.value+"&P_LOCATION_TYPE="+SalaryInvoiceReportForm.locTyp.value+"&P_EMP_FLG="+SalaryInvoiceReportForm.hdnEmpLbrFlag.value+"&P_PAYCODE="+SalaryInvoiceReportForm.txtPayCode.value;
		}
		document.getElementById('butInsert').value="Please wait. File is being downloaded..";
		document.getElementById('butInsert').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.SalaryInvoiceReportForm.submit();
	}
	else{
		return false;
	}
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="SalaryInvoiceReportForm"  property="screenMode"/>
    <html:hidden name="SalaryInvoiceReportForm"  property="screenName" value="SalaryInvoiceReport" />
    <html:hidden property="buttonFlag" name="SalaryInvoiceReportForm"  />       

    
    <html:hidden property="lovKey" name="SalaryInvoiceReportForm"  />
    <html:hidden property="txtFields" name="SalaryInvoiceReportForm"  />   
    <html:hidden property="txtSearchFields" name="SalaryInvoiceReportForm"  />
    <html:hidden property="txtDisplayFields" name="SalaryInvoiceReportForm"  />
    <html:hidden property="txtIndex" name="SalaryInvoiceReportForm"  />   
    <html:hidden property="loginLocCode" name="SalaryInvoiceReportForm"  />
	<html:hidden property="txtInputField" name="SalaryInvoiceReportForm"  />
    <html:hidden property="locTyp" name="SalaryInvoiceReportForm"  />  
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(SalaryInvoiceReportForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    SalaryInvoiceReportForm.action="../../../SalaryInvoiceGetAccess.do"
    SalaryInvoiceReportForm.submit();  
  }
}

function ShowSite()
{
  
   SalaryInvoiceReportForm.lovKey.value = "GangDepot" + SalaryInvoiceReportForm.screenName.value + SalaryInvoiceReportForm.screenMode.value;
    
   SalaryInvoiceReportForm.queryParam.value="txtSiteID="+SalaryInvoiceReportForm.loginLocCode.value;
   SalaryInvoiceReportForm.txtDisplayFields.value = "txtLocId,txtLocation";
    
   SalaryInvoiceReportForm.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   SalaryInvoiceReportForm.txtIndex.value=""; 
   SalaryInvoiceReportForm.txtInputField.value="";
 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'SalaryInvoiceReportForm');
  
   return true;
}

function ShowLovGang()
{
	var txtType;
 // alert(document.all.hdnEmpLbrFlag.value);
   if(document.all.hdnEmpLbrFlag.value =='D')
	  txtType="DPS";
   else if(document.all.hdnEmpLbrFlag.value =='L')
       txtType="DEP";
  //alert(txtType);
   SalaryInvoiceReportForm.queryParam.value="txtLocId= "+ SalaryInvoiceReportForm.txtLocId.value +",txtSiteID="+SalaryInvoiceReportForm.loginLocCode.value+",txtType="+txtType;    
   SalaryInvoiceReportForm.lovKey.value = "GangName" + SalaryInvoiceReportForm.screenName.value + SalaryInvoiceReportForm.screenMode.value;
   SalaryInvoiceReportForm.txtDisplayFields.value = "txtGangId,txtGangName";
   
   SalaryInvoiceReportForm.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
   SalaryInvoiceReportForm.txtIndex.value="";
   SalaryInvoiceReportForm.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'SalaryInvoiceReportForm');
   return true;
} 

function ShowLovYYMM()
{
        SalaryInvoiceReportForm.queryParam.value="hdnMaxYYMM="+ SalaryInvoiceReportForm.hdnMaxYYMM.value +" " ;    
        SalaryInvoiceReportForm.lovKey.value = "ReportGeneratePaySlipYear" + SalaryInvoiceReportForm.screenName.value + "U";
        SalaryInvoiceReportForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        SalaryInvoiceReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','SalaryInvoiceReportForm');       
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


function ShowLovPayCode1()
{
   SalaryInvoiceReportForm.lovKey.value = "MaintDirectPayrollPayCode" + SalaryInvoiceReportForm.screenName.value + "Q";
   SalaryInvoiceReportForm.txtDisplayFields.value = "txtPayCode,txtDescription";
   SalaryInvoiceReportForm.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
  
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'SalaryInvoiceReportForm');
   
   return true;
}

</script>
