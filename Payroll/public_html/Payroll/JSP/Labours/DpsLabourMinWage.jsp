<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
	<HEAD>
    <html:base/>
	<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />  
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>      
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintDpsLbrMinWageDetailBase" name="frmDpsLbrMinWageForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.DpsLabourMinWageForm">
  <bean:define id="ParentForm" name="frmDpsLbrMinWageForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>  
  <% i = 0;j=0; %>       

  <table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>DPS LABOUR MINIMUM WAGE INFORMATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 border=0>
            <!--General Information Row Starts -->
            <TR>
              <TD class=subHeader colspan=2> Detail Information DPS Labour Minimum Wage </TD>
            </TR>
            
            <TR>
              <TD colspan=2 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="2"></td>
            </tr>                                
            
            <tr></tr>
              <table  cellSpacing=0 cellPadding=0 border=0>
                <tr>
                  <td class=labelText width=20%><bean:message key="Payroll.Labour.effDate" /> </td>            
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmDpsLbrMinWageForm" value="Q">
                  <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required" />
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtEffDate" onclick="showCalendar('headerPrimaryKey',this)" />
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmDpsLbrMinWageForm" value="Q">                              
                  <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required"/>
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtEffDate" onclick="showCalendar('headerPrimaryKey',this)" />
                  </logic:notEqual>
                  </td>   
                  
                  <td width="20%" class=labelText><bean:message key="Payroll.Labour.effEndDate" /></td>
                  <td >                              
                  <html:text  property="txtEndDate" altKey="Payroll.Labour.effEndDate" maxlength="6" size="23" styleClass="locked" onchange=""  style="text-align:right" readonly="true"/>
                  </td> 
                  
              </tr>                              
            </table>     
          </tr>              
        <tr height="15" >
          <td colspan="2"></td>
        </tr>                                 
      </table> 
      <table cellspacing=0 cellpadding=0 border=0 >
      <!-- Detail Information Row starts -->
        <TR>
          <TD colspan=2>
            <!-- Purchase Requisition Info Table Starts -->
            <TABLE cellSpacing=0 cellPadding=0 border =0 >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText > DPS Labour Minimum Wages Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              </tr> 
            <tr height="10"><td class=userText colspan="17"></td></tr>            
            <TR height=10>
            
 <!-- Detail table Container starts -->
              <TD colspan=17>
                <TABLE cellSpacing=0 cellPadding=0 border=0 >
                  <TBODY>
                    <TR>
                      <TD>
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 border=0>
                          <TBODY>
						  <TR>       
                              <td width="45%" class=labelText><bean:message key="Payroll.Labour.CityType" /></td>
                              <td >
                              <logic:notEqual property= "screenMode" name= "frmDpsLbrMinWageForm" value="N">
                              <html:text  property="txtCityType" altKey="Payroll.Labour.MGWSardar" maxlength="6" size="23" styleClass="locked" onchange="lfnChange(this.value);"  style="text-align:right" readonly="true"/></td>                                                                                                                        
                              </logic:notEqual>
                              <logic:equal property= "screenMode" name= "frmDpsLbrMinWageForm" value="N">
                              <html:text  property="txtCityType" altKey="Payroll.Labour.CityType" maxlength="2" size="23" titleKey="Payroll.Labour.PieceRate"  styleClass="required" onkeypress="                            
                              if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                              {}
                               else
                              {                                                          
                                return false;                            
                              };
                             "    onchange="upper(this);"
                                style="text-align:right" />                                                                                                                                                     
                              </logic:equal>
                              </td>
                          </tr> 

                            <TR>       
                              <td width="45%" class=labelText><bean:message key="Payroll.Labour.MiniRates" /></td>
                              <td >
                              <logic:notEqual property= "screenMode" name= "frmDpsLbrMinWageForm" value="N">
                              <html:text  property="txtPieceRate" altKey="Payroll.Labour.MGWSardar" maxlength="6" size="23" styleClass="locked" onchange="lfnChange(this.value);"  style="text-align:right" readonly="true"/></td>                                                                                                                        
                              </logic:notEqual>
                              <logic:equal property= "screenMode" name= "frmDpsLbrMinWageForm" value="N">
                              <html:text  property="txtPieceRate" altKey="Payroll.Labour.MiniRates" maxlength="14" size="23" titleKey="Payroll.Labour.PieceRate"  styleClass="required" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right" />                                                                                                                                                     
                              </logic:equal>
                              </td>
                          </tr> 

                          <tr><td colspan=2>&nbsp;</td> </tr>                  
                          <tr height = 3><td></td></tr>                          
                        </TBODY>
                      </TABLE>
                    </TD>
                  </TR>                       
                </TBODY>
              </TABLE>
            </td>
          </tr>
<!-- Tab table Row 3 starts -->
      </TABLE>
    </td>
	</tr>
                <!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->
       <TR>
        <td>
        <jsp:include  page = "../INCLUDES/BottomBlueBar.jsp" flush="true" />
        </td>
      </TR>
  </TABLE> 
<!-- Container Table Ending Columns Starts-->
    </TD>    
</TR>
</TBODY>
</TABLE>
</div>
<!-- Container Table Ends -->
<html:hidden name="frmDpsLbrMinWageForm"  property="screenName" value="MaintDpsLbrMinWageScreen" />
<html:hidden name="frmDpsLbrMinWageForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDpsLbrMinWageForm" />
<html:hidden property="positionRequested" name="frmDpsLbrMinWageForm" />
<html:hidden property="userPositionRequested" name="frmDpsLbrMinWageForm"/>

<html:hidden property="buttonFlag" name="frmDpsLbrMinWageForm"  />
<html:hidden property="lovKey" name="frmDpsLbrMinWageForm"  />
<html:hidden property="txtFields" name="frmDpsLbrMinWageForm"  />   
<html:hidden property="txtSearchFields" name="frmDpsLbrMinWageForm"  />
<html:hidden property="txtDisplayFields" name="frmDpsLbrMinWageForm" />
<html:hidden property="txtIndex" name="frmDpsLbrMinWageForm"  />
<html:hidden property="loginLocCode" name="frmDpsLbrMinWageForm" />
<html:hidden property="txtEffDate" name="frmDpsLbrMinWageForm"  />

<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>


<script language="javascript">

function lfnLoad()
{   
    mode = document.all.screenMode.value;       
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='U')
    {   
        document.all.headerPrimaryKey.disabled = "true";          
    }
    hedMenuHandling(mode);
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmDpsLbrMinWageForm"))
    {     
        var response=confirm("There is already a record. Do You want to Insert New values?");
        if(response==false)
        {
            document.all.txtEffDate.value="";
            document.all.txtPieceRate.value="";
            document.all.txtMgwSardar.value="";
            document.all.txtMgwMandal.value="";
            document.all.txtMgwAncllry.value="";
            document.all.txtMgwHndlng.value="";
            return false;
        } 
        frmDpsLbrMinWageForm.txtEffDate.value=frmDpsLbrMinWageForm.headerPrimaryKey.value;
        frmDpsLbrMinWageForm.detailDataChanged.value = "false";  
        if(frmDpsLbrMinWageForm.screenMode.value == "N")
            frmDpsLbrMinWageForm.headerDataChanged.value = "true";  
        
		document.all.butSave.disabled="true";
        document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmDpsLbrMinWageForm.headerFields.value = "true";                  
        frmDpsLbrMinWageForm.action = "../../../DpsLbrMinWageSaveAction.do";                
        frmDpsLbrMinWageForm.submit();
    }
    else
    {
        return false;
    }
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmDpsLbrMinWageForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmDpsLbrMinWageForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmDpsLbrMinWageForm.action="../../../DpsLbrMinWageGetHeaderAction.do"
    frmDpsLbrMinWageForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmDpsLbrMinWageForm.userPositionRequested.value = 1*frmDpsLbrMinWageForm.positionRequested.value + 1;
    frmDpsLbrMinWageForm.action="../../../DpsLbrMinWageGetNextHeader.do";
    frmDpsLbrMinWageForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmDpsLbrMinWageForm.userPositionRequested.value = 1*frmDpsLbrMinWageForm.positionRequested.value - 1;
    frmDpsLbrMinWageForm.action = "../../../DpsLbrMinWageGetPrevHeader.do";
    frmDpsLbrMinWageForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmDpsLbrMinWageForm.userPositionRequested.value = 1*frmDpsLbrMinWageForm.newPositionRequested.value;
    frmDpsLbrMinWageForm.action = "../../../DpsLbrMinWageGetNextHeader.do";
    frmDpsLbrMinWageForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmDpsLbrMinWageForm.action="../../../DpsLbrMinWageNewMode.do"
    frmDpsLbrMinWageForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';    
    frmDpsLbrMinWageForm.action="../../../DpsLbrMinWageQueryMode.do"
    frmDpsLbrMinWageForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmDpsLbrMinWageForm.action="../../../DpsLbrMinWageRefresh.do"
    frmDpsLbrMinWageForm.submit();
}

  // added by dushyant on 19-April-2011
function upper(val)
{
   val.value=val.value.toUpperCase();
}

</script>


