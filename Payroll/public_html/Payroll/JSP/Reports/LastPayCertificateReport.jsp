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
  <html:form  action="ReportLinkerAction" name="LastPayCertifRepForm" type="FCIPAY.Payroll.WEBTIER.Form.LastPayCertifRepForm" scope="session" >
  <bean:define id="ParentForm" name="LastPayCertifRepForm" toScope="request" />  
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
      <TD  colSpan=12 class=mainHeader height=10>LAST PAY CERTIFICATE REPORT</TD>
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
              <TD class=subHeader colspan=6>Last Pay Certificate Report</TD>
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
					"if(!(checkEmployee(LastPayCertifRepForm.txtEmp.value,LastPayCertifRepForm.loginLocCode.value)))
					{
						LastPayCertifRepForm.txtEmp.value='';
					}"
					/>
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                                      
                  </tr> 
                  
                  </center>
                </table>
              </td>
            </tr>
            <!-- Tab table Row 3 starts -->          
            <TR>
              <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
            </TR>
            <tr height="15" >
              <td colspan="16"></td>
            </tr>            
            <TR>
              <td align=center bgcolor=#4682b4 width="37%"></td>
              <td  bgcolor=#4682b4><html:button value='GENERATE LAST PAY CERTIFICATE REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
if(mandatory_Check('LastPayCertifRepForm'))
{
	var winurl="last_pay_certificate.rdf&P_EMP_NUM="+LastPayCertifRepForm.txtEmp.value+"&P_EMP_SITE_CODE="+LastPayCertifRepForm.loginLocCode.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.LastPayCertifRepForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="LastPayCertifRepForm"  property="screenMode"/>
    <html:hidden name="LastPayCertifRepForm"  property="screenName" value="LastPayCertifReport" />
    <html:hidden property="buttonFlag" name="LastPayCertifRepForm"  />       

    
    <html:hidden property="lovKey" name="LastPayCertifRepForm"  />
    <html:hidden property="txtFields" name="LastPayCertifRepForm"  />   
    <html:hidden property="txtSearchFields" name="LastPayCertifRepForm"  />
    <html:hidden property="txtDisplayFields" name="LastPayCertifRepForm"  />
    <html:hidden property="txtIndex" name="LastPayCertifRepForm"  />
    <html:hidden property="txtCpfCode" name="LastPayCertifRepForm"  />             <!--added by dushyant on 20-08-2010-->
    
    
    <html:hidden property="loginLocCode" name="LastPayCertifRepForm"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(LastPayCertifRepForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    LastPayCertifRepForm.action="../../../LastPayCertifGetAccess.do"
    LastPayCertifRepForm.submit();  
  }
}

function ShowLovYYMM()
{
        LastPayCertifRepForm.queryParam.value="hdnMaxYYMM="+ LastPayCertifRepForm.hdnMaxYYMM.value +" " ;    
        LastPayCertifRepForm.lovKey.value = "ReportGeneratePaySlipYear" + LastPayCertifRepForm.screenName.value + "U";
        LastPayCertifRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        LastPayCertifRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LastPayCertifRepForm');

        
        return true;
}

function ShowLovEmpNo()
{
        LastPayCertifRepForm.lovKey.value = "LastPayCertifEmp" + LastPayCertifRepForm.screenName.value + "U";
        LastPayCertifRepForm.queryParam.value="txtSiteID="+ LastPayCertifRepForm.loginLocCode.value +",hdnEmpLbrFlag="+LastPayCertifRepForm.hdnEmpLbrFlag.value ;
        LastPayCertifRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
        LastPayCertifRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LastPayCertifRepForm');
        return true;
}
</script>
