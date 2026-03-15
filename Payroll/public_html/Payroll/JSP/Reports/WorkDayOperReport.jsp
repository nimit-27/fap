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

  <BODY  onload="lfnLoad();"  scroll=no  onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />  
  <html:form  action="ReportLinkerAction" name="WorkDayOperRepForm" type="FCIPAY.Payroll.WEBTIER.Form.WorkDayOperRepForm" scope="session" >
  <bean:define id="ParentForm" name="WorkDayOperRepForm" toScope="request" />  
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
      <TD  colSpan=12 class=mainHeader height=10>WORK DAY OPERATION DETAIL REPORT</TD>
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
              <TD class=subHeader colspan=6>Work Day Operation Detail Report</TD>
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
  
if(mandatory_Check('WorkDayOperRepForm'))
{
    var winurl="unified_bag.rdf&work_slip_date="+WorkDayOperRepForm.txtWrkSlipDt.value+"&gang_id="+WorkDayOperRepForm.hdnGangId.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.WorkDayOperRepForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="WorkDayOperRepForm"  property="screenMode"/>
    <html:hidden name="WorkDayOperRepForm"  property="screenName" value="WorkDayOperReport" />
    <html:hidden property="buttonFlag" name="WorkDayOperRepForm"  />       
    <html:hidden property="lovKey" name="WorkDayOperRepForm"  />
    <html:hidden property="txtFields" name="WorkDayOperRepForm"  />   
    <html:hidden property="txtSearchFields" name="WorkDayOperRepForm"  />
    <html:hidden property="txtDisplayFields" name="WorkDayOperRepForm"  />
    <html:hidden property="txtIndex" name="WorkDayOperRepForm"  />
    <html:hidden property="txtLbrType" name="WorkDayOperRepForm"  />
    <html:hidden property="loginLocCode" name="WorkDayOperRepForm"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(WorkDayOperRepForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
   if(WorkDayOperRepForm.hdnEmpLbrFlag.value=='D')
    WorkDayOperRepForm.txtLbrType.value='DPS';
  else
    WorkDayOperRepForm.txtLbrType.value='DEP';
  if(mode != 'Q' )
  {
    WorkDayOperRepForm.action="../../../WorkDayOperGetAccess.do"
    WorkDayOperRepForm.submit();  
  }
}

function ShowLovGang()
{
       WorkDayOperRepForm.lovKey.value = "WorkDayOperGangList" + WorkDayOperRepForm.screenName.value + "Q";
       WorkDayOperRepForm.queryParam.value="txtSiteID="+ WorkDayOperRepForm.loginLocCode.value +",hdnEmpLbrFlag="+WorkDayOperRepForm.txtLbrType.value ;           
       WorkDayOperRepForm.txtDisplayFields.value = "hdnGangId,txtGangName,hdnMou";
       WorkDayOperRepForm.txtSearchFields.value = "Labours.txtGangName";
       WorkDayOperRepForm.txtIndex.value="";              
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'WorkDayOperRepForm');
       return true;
}

</script>
