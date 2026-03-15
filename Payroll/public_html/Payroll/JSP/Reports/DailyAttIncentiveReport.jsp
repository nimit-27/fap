<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>
<%@ page import="FCIPAY.Payroll.common.utility.EnrgiseUtil" %>

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
  <html:form  action="ReportLinkerAction" name="DailyAttIncentiveRepForm" type="FCIPAY.Payroll.WEBTIER.Form.DailyAttIncentiveRepForm" scope="session" >
  <bean:define id="ParentForm" name="DailyAttIncentiveRepForm" toScope="request" />  
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
      <TD  colSpan=12 class=mainHeader height=10>DAILY ATTENDANCE CUM INCENTIVE REPORT</TD>
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
              <TD class=subHeader colspan=6>Daily Attendance cum Incentive Report</TD>
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
                  
                  <TR height=25 >         
                    <!-- Detail table Container starts -->                    
                    <td class="labelText">Gang Name</td>
                    <td>
                    <html:text  property="txtGangName" maxlength="10" size="26" styleClass="required" readonly="true" />                    
                    <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
                    <html:hidden property="hdnGangId" />
                    <html:hidden property="hdnMou" />
                    </td>                         
                                      
                  </tr>    
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center">WorkSlip Date</td><td >
                    <html:text  property="txtWrkSlipDt"  maxlength="6" size="16" styleClass="required" readonly="true" />
                    <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" onclick="showCalendar('txtWrkSlipDt',this)" />
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
              <td  bgcolor=#4682b4><html:button value='GENERATE REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
    if(mandatory_Check('DailyAttIncentiveRepForm'))
    {
      var winurl="attd_cum_incentive.rdf&P_pay_date="+DailyAttIncentiveRepForm.txtWrkSlipDt.value+"&GANG_ID="+DailyAttIncentiveRepForm.hdnGangId.value;
	  document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	  document.getElementById('butInsert').disabled="true";
	  document.getElementById('submitParam').value = winurl;
	  document.DailyAttIncentiveRepForm.submit();
    }
    else{
      return false;
    }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="DailyAttIncentiveRepForm"  property="screenMode"/>
    <html:hidden name="DailyAttIncentiveRepForm"  property="screenName" value="DailyAttIncentiveReport" />
    <html:hidden property="buttonFlag" name="DailyAttIncentiveRepForm"  />       

    
    <html:hidden property="lovKey" name="DailyAttIncentiveRepForm"  />
    <html:hidden property="txtFields" name="DailyAttIncentiveRepForm"  />   
    <html:hidden property="txtSearchFields" name="DailyAttIncentiveRepForm"  />
    <html:hidden property="txtDisplayFields" name="DailyAttIncentiveRepForm"  />
    <html:hidden property="txtIndex" name="DailyAttIncentiveRepForm"  />
    <html:hidden property="txtLbrType" name="DailyAttIncentiveRepForm"  />
    
    <html:hidden property="loginLocCode" name="DailyAttIncentiveRepForm"  />
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
  
  if(DailyAttIncentiveRepForm.hdnEmpLbrFlag.value=='D')
    DailyAttIncentiveRepForm.txtLbrType.value='DPS';
  else
    DailyAttIncentiveRepForm.txtLbrType.value='DEP';
    
  if(mode != 'Q' )
  {
    DailyAttIncentiveRepForm.action="../../../DailyAttIncentiveGetAccess.do"
    DailyAttIncentiveRepForm.submit();  
  }
}

function ShowLovGang()
{
    DailyAttIncentiveRepForm.lovKey.value = "DailyAttIncGangList" + DailyAttIncentiveRepForm.screenName.value + "Q";
    DailyAttIncentiveRepForm.queryParam.value="txtSiteID="+ DailyAttIncentiveRepForm.loginLocCode.value +",hdnEmpLbrFlag="+DailyAttIncentiveRepForm.txtLbrType.value ;           
    DailyAttIncentiveRepForm.txtDisplayFields.value = "hdnGangId,txtGangName,hdnMou";
    DailyAttIncentiveRepForm.txtSearchFields.value = "Labours.txtGangName";
    DailyAttIncentiveRepForm.txtIndex.value="";              
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'DailyAttIncentiveRepForm');
    return true;
}

</script>
