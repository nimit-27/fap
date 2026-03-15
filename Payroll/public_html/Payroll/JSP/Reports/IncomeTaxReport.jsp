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
  <html:form  action="ReportLinkerAction" name="IncomeTaxRepForm" type="FCIPAY.Payroll.WEBTIER.Form.IncomeTaxRepForm" scope="session" >
  <bean:define id="ParentForm" name="IncomeTaxRepForm" toScope="request" />  
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
      <TD  colSpan=12 class=mainHeader height=10>INCOME TAX REPORT</TD>
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
              <TD class=subHeader colspan=6>Income Tax Report</TD>
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
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.PaySlip.Year" /></td><td >
                    <html:text  property="txtYYMM"  maxlength="6" size="16" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_YearMonth()))
                    {
                    }                                            
                    " 
                    /><bean:message key="Payroll.Report.YyyyMm" />
                    </td>              
                  </tr>                
                  
				  <tr>
			  <td class="labelText"  width="45%" align="center">Category</td>
			  <td>
			  <select name="txtCategory">
			  <option value="0">All</option>
			  <option value="1">Category 1</option>
			  <option value="2">Category 2</option>
			  <option value="3">Category 3</option>
			  <option value="4">Category 4</option>
			  </select>
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
              <td  bgcolor=#4682b4><html:button value=' GENERATE INCOME TAX REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	var check_valid=chk_YearMonth();
    
    if(check_valid == false)
    {
        document.getElementById("txtYYMM").focus();   
        return false;
    }
	else
	{
		if(mandatory_Check('IncomeTaxRepForm'))
		{
			var winurl="Income_Tax.rdf&P_MONTHYR="+IncomeTaxRepForm.txtYYMM.value+"&P_EMP_FLG="+IncomeTaxRepForm.hdnEmpLbrFlag.value+"&P_LOCATION="+IncomeTaxRepForm.loginLocCode.value+"&P_CATEGORY="+document.getElementById("txtCategory").value;
			document.getElementById('butInsert').value="Please wait. File is being downloaded..";
			document.getElementById('butInsert').disabled="true";
			document.getElementById('submitParam').value = winurl;
			document.IncomeTaxRepForm.submit();		}
		else{
			return false;
		}
	}
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="IncomeTaxRepForm"  property="screenMode"/>
    <html:hidden name="IncomeTaxRepForm"  property="screenName" value="IncomeTaxReport" />
    <html:hidden property="buttonFlag" name="IncomeTaxRepForm"  />       
    <html:hidden property="lovKey" name="IncomeTaxRepForm"  />
    <html:hidden property="txtFields" name="IncomeTaxRepForm"  />   
    <html:hidden property="txtSearchFields" name="IncomeTaxRepForm"  />
    <html:hidden property="txtDisplayFields" name="IncomeTaxRepForm"  />
    <html:hidden property="txtIndex" name="IncomeTaxRepForm"  />
    <html:hidden property="loginLocCode" name="IncomeTaxRepForm"  />
    <input type="hidden" name="queryParam" />    
	<input type="hidden" id="submitParam" name="submitParam" />       
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(IncomeTaxRepForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    IncomeTaxRepForm.action="../../../IncomeTaxGetAccess.do"
    IncomeTaxRepForm.submit();  
  }
}

function ShowLovYYMM()
{
        IncomeTaxRepForm.queryParam.value="hdnMaxYYMM="+ IncomeTaxRepForm.hdnMaxYYMM.value +" " ;    
        IncomeTaxRepForm.lovKey.value = "ReportGeneratePaySlipYear" + IncomeTaxRepForm.screenName.value + "U";
        IncomeTaxRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        IncomeTaxRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','IncomeTaxRepForm');

        
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
