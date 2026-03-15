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
  <html:form  action="ReportLinkerAction" name="Form16RepForm" type="FCIPAY.Payroll.WEBTIER.Form.Form16RepForm" scope="session" >
  <bean:define id="ParentForm" name="Form16RepForm" toScope="request" />  
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
  
  <enrgise:errors/>
  <logic:messagesPresent message="true">
  <Table>
    <html:messages id="message" message="true">
      <TR>
        <TD>
          <bean:write name="message"/>
        </TD>
      </TR>
    </html:messages>
  </Table>
  </logic:messagesPresent>
  <html:hidden property="detailDataChanged"  />
  <html:hidden property="headerFields" value="false" />

  <table>
    <TR height=30>
      <TD  colSpan=12 class=mainHeader height=10>FORM 16 DETAIL REPORT</TD>
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
              <TD class=subHeader colspan=6>Form 16 Report</TD>
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
                <TABLE cellspacing="5" cellPadding="0" border=0 >                      
                  <center>
                  <TR height=25>         
                    <!-- Detail table Container starts -->                    
                    <TD class=labelText width="40%" ><bean:message key="Payroll.PaySlip.EmpNumber" /></td>
                    <td  align="left" ><html:text  property="txtEmp" maxlength="10" size="16" styleClass="required" 
					onchange=
					"if(!(checkEmployee(Form16RepForm.txtEmp.value,Form16RepForm.loginLocCode.value)))
					{
						Form16RepForm.txtEmp.value='';
					}"/>
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                                      
                  </tr>    
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.Report.FinYear" /></td><td >
                    <html:text  property="txtYYMM"  maxlength="6" size="16" styleClass="required"  
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
              </td>
            </tr>
			
			<!--Added by Vibhuti on 13-06-2014-->
			
			<TR>
              <TD class=subHeader colspan=6>Authenticating Person Details</TD>
            </TR>
			<TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
            </TR>
            <tr height="10" >
              <td colspan="2"></td>
            </tr>

			<TR height=150 >
              <TD colspan=11>   
				<TABLE width = "100%" cellspacing="0" cellPadding="0" >
				 <center>
				  <tr height=25>
						<td class=labelText width = "40%" align = "right"><bean:message key="pay.EnqPayImg.txtEmpName"/></td>
						<td><html:text size = "40" property="txtAuthName" name="Form16RepForm" styleClass="required"/></td>
				  </tr>	
				  <tr height=25>
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.Report.txtFatherName" /></td>
					<td><html:text size = "40" property="txtAuthFatherName" name="Form16RepForm" styleClass="required" />
                    </td>              
                  </tr>
				  <tr height=25>
                    <td class="labelText"  width="40%" align="center"><bean:message key="pay.EnqPayImg.txtDesig" /></td>
					<td><html:text size = "40" property="txtAuthDesig" name="Form16RepForm" styleClass="required" />
                    </td>              
                  </tr>                 
				 </center>
				</TABLE>
			  </TD>
			</TR>
		
			<!--Addition by Vibhuti ends-->

			<!-- Tab table Row 3 starts -->          
            <TR>
              <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
            </TR>
            <tr height="15" >
              <td colspan="16"></td>
            </tr>            
            <TR>
              <td align=center bgcolor=#4682b4 width="37%"></td>
              <td  bgcolor=#4682b4><html:button value='GENERATE FORM 16 REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
              <td width="45%" bgColor=#4682b4></td>
              <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
            </TR>   
          </table>
        </td>
      </tr>
    </TABLE>
    <!-- Tab Table Ends -->

 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">
function doGetReport()
{  
if(mandatory_Check('Form16RepForm'))
{
	auth_name=Form16RepForm.txtAuthName.value.toUpperCase();
	auth_father_name=Form16RepForm.txtAuthFatherName.value.toUpperCase();
	auth_desig=Form16RepForm.txtAuthDesig.value.toUpperCase();

	var check_valid=chk_YearMonth();
    
    if(check_valid == false)
    {
        document.getElementById("txtYYMM").focus();   
        return false;
    }
	else
	{
		url="../../../GenForm16Chk.do";
		prm="mode=1&P_FIN_YR="+Form16RepForm.txtYYMM.value+"&P_SITE_ID="+Form16RepForm.loginLocCode.value+"&P_EMP_NUM="+Form16RepForm.txtEmp.value+"&hdnEmpLbrFlag="+Form16RepForm.hdnEmpLbrFlag.value;
		xml=getXML(url,prm);
		Tags=xml.getElementsByTagName("record");
		var genform16="",generrmsg="";
  	    if(Tags.length>0)
		{
			genform16=Tags[0].childNodes[0].nodeValue; 
		}
		if (genform16=='TRUE')
		{
			var winurl="form16.rdf&P_FIN_YR="+Form16RepForm.txtYYMM.value+"&P_EMP_NUM="+Form16RepForm.txtEmp.value+"&P_SITE_ID="+Form16RepForm.loginLocCode.value+"&P_AUTH_NAME="+auth_name+"&P_AUTH_FATHER_NAME="+auth_father_name+"&P_AUTH_DESIGN="+auth_desig;
			document.getElementById('butInsert').value="Please wait. File is being downloaded..";
			document.getElementById('butInsert').disabled="true";
			document.getElementById('submitParam').value = winurl;
			document.Form16RepForm.submit();
		}
		else
		{
			alert("Form 16 is not finalized yet for "+Form16RepForm.txtEmp.value+" and financial year "+Form16RepForm.txtYYMM.value);
		}
	}
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="Form16RepForm"  property="screenMode"/>
    <html:hidden name="Form16RepForm"  property="screenName" value="Form16Report" />
    <html:hidden property="buttonFlag" name="Form16RepForm"  />       
    <html:hidden property="lovKey" name="Form16RepForm"  />
    <html:hidden property="txtFields" name="Form16RepForm"  />   
    <html:hidden property="txtSearchFields" name="Form16RepForm"  />
    <html:hidden property="txtDisplayFields" name="Form16RepForm"  />
    <html:hidden property="txtIndex" name="Form16RepForm"  />
    <html:hidden property="txtCpfCode" name="Form16RepForm"  />                 <!--ADDED BY DUSHYANT 0N 18 AUG 2010-->
    <html:hidden property="loginLocCode" name="Form16RepForm"  />
    <input type="hidden" name="queryParam" />    
	<input type="hidden" id="submitParam" name="submitParam" />       
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(Form16RepForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    Form16RepForm.action="../../../Form16GetAccess.do"
    Form16RepForm.submit();  
  }
}

function ShowLovYYMM()
{
        Form16RepForm.queryParam.value="hdnMaxYYMM="+ Form16RepForm.hdnMaxYYMM.value +" " ;    
        Form16RepForm.lovKey.value = "ReportGeneratePaySlipYear" + Form16RepForm.screenName.value + "U";
        Form16RepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        Form16RepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','Form16RepForm');        
        return true;
}

function ShowLovEmpNo()
{
        Form16RepForm.lovKey.value = "Form16Emp" + Form16RepForm.screenName.value + "U";
        //Form16RepForm.queryParam.value="txtSiteID="+ Form16RepForm.loginLocCode.value +" " ; 
		Form16RepForm.queryParam.value="txtSiteID="+ Form16RepForm.loginLocCode.value +",hdnEmpLbrFlag="+Form16RepForm.hdnEmpLbrFlag.value ;
        Form16RepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
        Form16RepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','Form16RepForm');
        return true;
}

function chk_YearMonth()
{      
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);  
    var year2 =  parseInt(yearM.substring(4,6),10);
    var year1 =  parseInt(yearM.substring(2,4),10); 
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Financial Year should be a Six digit Number");
            document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        } 
        
        if(year2!=year1+1)
        {
          alert("Please enter correct Financial Year.(YYYYYY)");                    
          event.srcElement.select();
          event.srcElement.focus();
          event.returnValue=false;            
          return false;
        }   
        
        return true;
    
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
