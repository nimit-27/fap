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
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintEmpSuspensionDetailBase" name="frmEmpSuspensionForm" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpSuspensionForm">
<bean:define id="ParentForm" name="frmEmpSuspensionForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<%
	String lbrType = (String)session.getAttribute("hdnEmpLbrFlag"); 
%>
<% 
	String lbrDisplayName="";
	if (lbrType.equals("E"))
		lbrDisplayName = "EMPLOYEE";
	else 
		lbrDisplayName = "LABOUR";	
%>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10><%=lbrDisplayName%> SUSPENSION/ABSCONDING/REVOCATION INFORMATION</TD>
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
     			<td colspan=2></td>
				<logic:equal name="frmEmpSuspensionForm" property="screenMode" value="U">
				<td width="10%" class="radioText"><input type="radio" name="radioPay" value="1" onclick="radClick()"  disabled ><bean:message  key="Payroll.Emp.Suspension" /></td>
				<td width="27%" class="radioText" ><input type="radio" name="radioPay" value="2" onclick="radClick()" disabled ><bean:message key="Payroll.Emp.Absconding"  /></td>
				</logic:equal>
				<logic:notEqual name="frmEmpSuspensionForm" property="screenMode" value="U">
				<td width="10%" class="radioText"><input type="radio" name="radioPay" value="1" onclick="radClick()"   ><bean:message  key="Payroll.Emp.Suspension" /></td>
				<td width="27%" class="radioText" ><input type="radio" name="radioPay" value="2" onclick="radClick()" ><bean:message key="Payroll.Emp.Absconding"  /></td>
				</logic:notEqual>
				<td colspan=2></td>
            </TR>

            <TR>
              <TD class=subHeader colspan=6> Detail Information Of Employee</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="6"></td>
            </tr>           
            
            <tr></tr>
            <table  cellSpacing=0 cellPadding=0 border=0> 
            
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" colspan="5">
                  <logic:equal property= "screenMode" name= "frmEmpSuspensionForm" value="N">                   
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmEmpSuspensionForm" value="N">
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmEmpSuspensionForm" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" onclick="return ShowEmpNum();">
                  </logic:equal>                  
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td>               
                  
              </TR> 
                                
              <TR>              
                  <TD width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                                             
                  </td>
                  
                  <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/><html:hidden property="txtCateg"  styleClass="locked" /></td>                                     
              </tr>
                      
              <tr>              
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                    
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   /></td>                                                                  
              </tr>    
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td><html:text  property="txtPresentPOP" altKey="pay.EmpInfo.PresentPOP" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   />                  
                  </td>                                                            
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>   
      
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text  property="txtEmpStatus" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>      
                                    
              </tr>                
   
            </table>     
          </tr>            
      <tr height="15" >
      <td colspan="6"></td>
    </tr>                                 
  </table>
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	 <TR height="100">
      <TD colspan=6>
      <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellspacing="0" cellPadding="0" >
              <TR id="rowid1">
					<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td bgcolor="#4682B4" nowrap class=actTabText > Suspension Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
					
					<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("RevokDet")> Revocation Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
					
					<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetSlrRlsTab("SalRlsDet")>Salary Release<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>

					<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetInvDtlsTab("InvDtlsDet")>Invoice Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
	   
					<td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
					<td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
           <TR id="rowid2">
					<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td bgcolor="#4682B4" nowrap class=actTabText > Absconding Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
					
					<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("RevokDet")> Revocation Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
					
					<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetInvDtlsTab("InvDtlsDet")>Invoice Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
					<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
	   
					<td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
					<td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
           
          <tr height="10"><td class=userText colspan="14"></td></tr>            
          <TR height=10>
 <!-- Detail table Container starts -->
            <TD colspan=14>
              <TABLE cellSpacing=0 cellPadding=0 border=0>
                <TBODY>
                  <TR>
                    <TD >
  			<!-- Detail table starts -->
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR width="100%">                          
                          <td width="20%" class=labelText id="tdid1">
						  <logic:equal property="radFlg" name="frmEmpSuspensionForm" value="1" >
						    <bean:message key="Payroll.EmpInfo.abscEffDate" />
						  </logic:equal>
						  <logic:notEqual property="radFlg" name="frmEmpSuspensionForm" value="1" >
						    <bean:message key="Payroll.EmpInfo.suspEffDate" />
						  </logic:notEqual>
						  </td>
                          <td >
                          <logic:equal property="screenMode" value="N" name="frmEmpSuspensionForm" >
                          <html:text  property="suspEffDate" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:left" readonly="true" onchange="fillSubsEffDate(this.value);"/><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="suspEffDate" alt="<%=(i-1) %>" onclick="showCalendar('suspEffDate',this)" />
                          </logic:equal>
                          <logic:notEqual property="screenMode" value="N" name="frmEmpSuspensionForm" >
                          <html:text  property="suspEffDate" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:left" readonly="true" onchange="fillSubsEffDate(this.value);"/>
                          </logic:notEqual>
                          </td>                                                     
                           
                          
                          <td class=labelText id="tdid2">
						  <logic:equal property="radFlg" name="frmEmpSuspensionForm" value="1" >
						    <bean:message key="Payroll.EmpInfo.abscReason" /></td>
						  </logic:equal>
						  <logic:notEqual property="radFlg" name="frmEmpSuspensionForm" value="1" >
						    <bean:message key="Payroll.EmpInfo.suspReason" /></td>
						  </logic:notEqual>
                          <td colspan="1">
                          <logic:equal property="revokeDate" value="" name="frmEmpSuspensionForm" >
                          <html:text property="suspReason" styleClass = "optional" alt="<%=String.valueOf(i)%>" maxlength="50" size="23" style="text-align:left"  onchange="lfnChanged(this.value);"/>
                          </logic:equal>
                          <logic:notEqual property="revokeDate" value="" name="frmEmpSuspensionForm" >
                          <html:text property="suspReason" styleClass = "locked" alt="<%=String.valueOf(i)%>" readonly="true" maxlength="50" size="23" style="text-align:left"  onchange="lfnChanged(this.value);"/>
                          </logic:notEqual>
                          </td>                                                                                 
                     </tr> 

                    <tr>   
                        <td width="20%" class=labelText id="tdid3"><bean:message key="Payroll.EmpInfo.subsAllow" /></td>
                        <td colspan="1">
                        <logic:equal property="screenMode" value="N" name="frmEmpSuspensionForm" >
                        <html:text  property="subsAllow" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="3" size="23" style="text-align:right" onchange="return checkSubsistenceRange(this);" />
                          </logic:equal>
                          <logic:notEqual property="screenMode" value="N" name="frmEmpSuspensionForm" >
                          <html:text  property="subsAllow" styleClass = "locked" readonly="true" alt="<%=String.valueOf(i)%>" maxlength="3" size="23" style="text-align:right" onchange="return checkSubsistenceRange(this);" />
                          </logic:notEqual>
                          </td>                              
                          
                        <td width="20%" class=labelText id="tdid4"><bean:message key="Payroll.EmpInfo.subsEffDate" /> </td>            
                        <td>
                        <logic:equal property="screenMode" value="N" name="frmEmpSuspensionForm" >
                        <html:text  property="subsEffDate"  maxlength="10" size="23" styleClass="required" readonly="true" onchange="" />
                        </logic:equal>
                        <logic:notEqual property="screenMode" value="N" name="frmEmpSuspensionForm" >
                        <html:text  property="subsEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true" onchange="" />
                        </logic:notEqual>
                        </td>
                    </tr>
					<logic:notEqual property="screenMode" value="N" name="frmEmpSuspensionForm" >
                    <tr>   
                        <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.revSubsAllow" /></td>
                        <td colspan="1">
                        <logic:equal property="revokeDate" value="" name="frmEmpSuspensionForm" >
						<logic:equal property="revSubsAllow" value="" name="frmEmpSuspensionForm" >
                        <html:text  property="revSubsAllow" styleClass = "optional" alt="<%=String.valueOf(i)%>" maxlength="3" size="23" style="text-align:right" onchange="return subsNotEqualRevSubsAllow(this);" />
                        </logic:equal>

						<logic:notEqual property="revSubsAllow" value="" name="frmEmpSuspensionForm" >
                        <html:text  property="revSubsAllow" styleClass = "locked" readonly="true" alt="<%=String.valueOf(i)%>" maxlength="3" size="23" style="text-align:right" onchange="return subsNotEqualRevSubsAllow(this);" />
                        </logic:notEqual>
						</logic:equal>
                        <logic:notEqual property="revokeDate" value="" name="frmEmpSuspensionForm" >
                        <html:text  property="revSubsAllow" styleClass = "locked" readonly="true" alt="<%=String.valueOf(i)%>" maxlength="3" size="23" style="text-align:right" onchange="return subsNotEqualRevSubsAllow(this);" />
                        </logic:notEqual>
                        </td>   
                        <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.revSubsEffDate" /> </td>            
                        <td>
                        <logic:equal property="revokeDate" value="" name="frmEmpSuspensionForm" >

						<logic:equal property="revSubsEffDate" value="" name="frmEmpSuspensionForm" >
                        <html:text  property="revSubsEffDate"  maxlength="10" size="23" styleClass="optional" readonly="true" onchange="checkRevSubsEffDate(this.value);" />
                        <img src="..\INCLUDES\IMAGES\cal.gif" title="Calendar" width=15 height=19 align="top" styleClass="lov" property="subsEffDate" alt="<%=(i-1) %>" onclick="showCalendar('revSubsEffDate',this);"/>
						</logic:equal>

						<logic:notEqual property="revSubsEffDate" value="" name="frmEmpSuspensionForm" >
                        <html:text  property="revSubsEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true"  onchange="lfnChanged(this.value);" />
                        </logic:notEqual>

						</logic:equal>

						<logic:notEqual property="revokeDate" value="" name="frmEmpSuspensionForm" >
                        <html:text  property="revSubsEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true"  onchange="lfnChanged(this.value);" />
						</logic:notEqual>
                        </td>
                    </tr>

					
					
					</logic:notEqual>
                    <logic:equal property="screenMode" value="N" name="frmEmpSuspensionForm" >
                    <html:hidden  property="revSubsAllow" name="frmEmpSuspensionForm"  />
                    <html:hidden  property="revSubsEffDate" name="frmEmpSuspensionForm"  />
                    
                    </logic:equal>
                    <tr height = 3><td class="labelText" colspan="2"></td></tr>                    
                    <tr height = 3><td>&nbsp;</td></tr>                    
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
<html:hidden name="frmEmpSuspensionForm"  property="screenName" value="EmpSuspensionScreen" />
<html:hidden name="frmEmpSuspensionForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpSuspensionForm" />
<html:hidden property="loginLocCode" name="frmEmpSuspensionForm" />
<html:hidden property="positionRequested" name="frmEmpSuspensionForm" />
<html:hidden property="userPositionRequested" name="frmEmpSuspensionForm" />
<html:hidden property="buttonFlag" name="frmEmpSuspensionForm"  />
<html:hidden property="lovKey" name="frmEmpSuspensionForm"  />
<html:hidden property="txtFields" name="frmEmpSuspensionForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpSuspensionForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpSuspensionForm"  />
<html:hidden property="txtIndex" name="frmEmpSuspensionForm"  />
<html:hidden property="txtEmpNo" name="frmEmpSuspensionForm"  />

<html:hidden property="suspId" name="frmEmpSuspensionForm"  />
<html:hidden property="revokeType" name="frmEmpSuspensionForm"  />
<html:hidden property="revokeDate" name="frmEmpSuspensionForm"  />
<html:hidden property="txtYYMM" name="frmEmpSuspensionForm"  />
<html:hidden property="payYYMM" name="frmEmpSuspensionForm" />
<html:hidden property="radFlg" name="frmEmpSuspensionForm" />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function ShowEmpNum()
{
	if(frmEmpSuspensionForm.radFlg.value=="")
	{
		alert("Please select from the radio button above if Suspended or Absconding.");
		return;
	}
    frmEmpSuspensionForm.lovKey.value = "EmpSusp" + frmEmpSuspensionForm.screenName.value + frmEmpSuspensionForm.screenMode.value;       
    frmEmpSuspensionForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtDOJSite";
    frmEmpSuspensionForm.queryParam.value = "txtSiteID="+frmEmpSuspensionForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpSuspensionForm.hdnEmpLbrFlag.value+",radFlg="+frmEmpSuspensionForm.radFlg.value;
    frmEmpSuspensionForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
    frmEmpSuspensionForm.txtIndex.value ="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpSuspensionForm');
    return true;
}

function fillSubsEffDate(val)
{    
    var systDate = getSysDate();  
	var payrollyymm = frmEmpSuspensionForm.payYYMM.value;
	var paylastdate=new Date( (new Date(payrollyymm.substring(0,4), payrollyymm.substring(4),1))-1 );
	var strdate=paylastdate.getDate()+'-'+(paylastdate.getMonth()+1)+'-'+paylastdate.getFullYear();
    if(cmpDateMsg(val,strdate,0,"Date cannot be greater than current payroll YYMM!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        document.all.subsEffDate.value=val;
        return true;        
    }
    else
    {
        document.all.suspEffDate.value="";     
        return false;
    }        
}

function lfnChanged(val)
{
    frmEmpSuspensionForm.headerDataChanged.value = "true";
}

function lfnLoad()
{
	mode = document.all.screenMode.value;    
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {
        document.all.txtCateg.disabled = "true";
        //document.all.txtDsgn.disabled = "true";      
        //document.all.headerPrimaryKey.disabled = "true";          
    } 
	var radflg1=document.getElementsByName("radioPay");
	if(frmEmpSuspensionForm.radFlg.value==0)
	{
		frmEmpSuspensionForm.radFlg.value=0;
		radflg1[0].checked="true";
	}
	else
	{
		frmEmpSuspensionForm.radFlg.value=1;
		radflg1[1].checked="true";
	}
	show_hideRow();
    hedMenuHandling(mode);    
}

function show_hideRow()
{
	val = document.getElementById("radFlg").value;
	if(val=="1")
	{
		document.getElementById("rowid1").style.display='none';
		document.getElementById("rowid2").style.display='block';
	}
	else
	{
		document.getElementById("rowid1").style.display='block';
		document.getElementById("rowid2").style.display='none';
	}
}
function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.action="../../../EmpSuspensionQueryMode.do"
    frmEmpSuspensionForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpSuspensionForm.action="../../../EmpSuspensionRefresh.do"
    frmEmpSuspensionForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.action="../../../EmpSuspensionNewMode.do"
    frmEmpSuspensionForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

    frmEmpSuspensionForm.action="../../../EmpSuspFirstGetHeaderAction.do"
    frmEmpSuspensionForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.userPositionRequested.value = 1*frmEmpSuspensionForm.positionRequested.value + 1;
    frmEmpSuspensionForm.action="../../../EmpSuspGetNextHeader.do";
    frmEmpSuspensionForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.userPositionRequested.value = 1*frmEmpSuspensionForm.positionRequested.value - 1;
    frmEmpSuspensionForm.action = "../../../EmpSuspGetPrevHeader.do";
    frmEmpSuspensionForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.userPositionRequested.value = 1*frmEmpSuspensionForm.newPositionRequested.value;
    frmEmpSuspensionForm.action = "../../../EmpSuspGetNextHeader.do";
    frmEmpSuspensionForm.submit();
}


function cancelSuspension()
{
    alert("Cancel Suspension");
}

function SaveRecord()
{    
    var sEffdate=document.all.subsEffDate.value;
    var subEffdate=document.all.revSubsEffDate.value;
    if(mandatory_Check("frmEmpSuspensionForm"))
    {          
       
		if(checkFieldEmpty()) 
		{
			if (cmpSuspDate(sEffdate, subEffdate, 0) )
			{
           
				frmEmpSuspensionForm.txtEmpNo.value=frmEmpSuspensionForm.headerPrimaryKey.value;         
				frmEmpSuspensionForm.revokeType.value= "";
				frmEmpSuspensionForm.revokeDate.value= "";
				frmEmpSuspensionForm.detailDataChanged.value = "false";             
				frmEmpSuspensionForm.headerDataChanged.value = "true";    
				frmEmpSuspensionForm.headerFields.value = "true";                 
				document.all.butSave.disabled="true";
				document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
				frmEmpSuspensionForm.action = "../../../EmpSuspSaveAction.do";            
				frmEmpSuspensionForm.submit();
			}
		} 
		else
		{
			return false;
		}
    }
    else
    {
        return false;
    }
}

function cmpSuspDate(date1,date2, flag)
{
	if (trim(date1) == "")
	{
		return true;
	}

	date1 = change_DateFormatMon(date1);
	sysDate = change_DateFormatMon(date2);
	if(sysDate=='')
    return true;
	if (flag == 0)
	{
    if (dateDiff(sysDate, date1) > 0)
		{
			alert("Subsistence Date cannot be Less than the Revised Subsitence date!");
      document.all.subsEffDate.select();
      document.all.subsEffDate.focus();
		//	event.srcElement.select();
		//	event.srcElement.focus();
			return false;
		}
	}
	return true;
}

function Chk_Char(name)
{
    that=document.getElementsByName(name)[0];    
    str=that.value; 
    for(i=0; i<str.length; i++)
    {
        var txtVal =str.charAt(i);
        if((txtVal >= 'A' && txtVal <= 'Z') ||(txtVal >= 'a' && txtVal <= 'z') || (txtVal == ',') || (txtVal == ' '))
        {}
        else
        {
            alert("Invalid Input");               
            that.select();             
            return true;
        }
    }
}

function doGetTab(arg)
{  
    mode = document.all.screenMode.value;
    if(mode == 'N' || mode == 'Q')
    {
        return false;
    }
    else
    {
        document.all.forwardedPage.value=arg;
        document.forms[0].action="../../../EmpRevokTabAction.do";        
        document.forms[0].submit(); 
    }    
}

function doGetSlrRlsTab(arg)
{   
    mode = document.all.screenMode.value;
    if(mode == 'N' || mode == 'Q')
    {
        return false;
    }
	if(arg=="SalRlsDet")
	{
		if(document.getElementById("radFlg").value=="1")
		{
			alert("Salary release is not applicable for Absconding employees");
			return false;
		}
	}
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpSuspYrMonthAction.do";
    document.forms[0].submit(); 
}


function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpRevokTabAction.do";
    document.forms[0].submit(); 
}
///added by sonia on 17-10-2011
function doGetInvDtlsTab(arg)
{   
     mode = document.all.screenMode.value;
    if(mode == 'N' || mode == 'Q')
    {
        return false;
    }
    else
    {
      document.all.forwardedPage.value=arg;
      document.forms[0].action="../../../EmpSuspInvDtlsAction.do";
      document.forms[0].submit(); 
    }  
}
///end by sonia

//added by nitin
function checkSubsistenceRange(elementName)
{
	
  var regex = /^[0-9]*$/;
  
  var subspercent = elementName.value;
  if(!subspercent.match(regex))
  {
      alert("Please enter only numeric values for percentage");
      elementName.value='';
      return false;
  }
	if(document.getElementById("hdnEmpLbrFlag").value == 'L' && (subspercent != 50 && subspercent != 75))
	{
		alert('Please enter valid percentage: 50 or 75');
		elementName.value='';
		return false;
	}
	else if(document.getElementById("hdnEmpLbrFlag").value == 'D' && (subspercent<25 || subspercent>75))
	{
		alert('Please Enter valid percentage between 25 and 75');
		elementName.value='';
		return false;
	}
	else if(subspercent>100)
    {
		 alert('Please Enter valid percentage');
         elementName.value='';
		 return false;
    }
    else
	{
		lfnChanged(subspercent);
		return true;
	}	
}

function subsNotEqualRevSubsAllow(elementName)
{
	var subsallowance = frmEmpSuspensionForm.subsAllow.value;
	var revsubsallowance = elementName.value;
	if(checkSubsistenceRange(elementName))
	{
		if(document.getElementById("hdnEmpLbrFlag").value == 'L' && subsallowance >= revsubsallowance)
		{
			alert("Revised Subsistence Allowance should be greater than Subsistence Allowance");
			elementName.value = '';
			return false;
		}
	}
}

function checkFieldEmpty()
{
	var flag = true;
	if(frmEmpSuspensionForm.revSubsAllow.value == "" && frmEmpSuspensionForm.revSubsEffDate.value != "")
	{
		alert("Please enter Revised Subsistence Allowance");
		flag = false;
	}
	if(frmEmpSuspensionForm.revSubsAllow.value != "" && frmEmpSuspensionForm.revSubsEffDate.value == "")
	{
		alert("Please enter Revised Subsistence Eff. Date");
		flag = false;
	}
 	if(frmEmpSuspensionForm.revSubsAllow.value == "" && frmEmpSuspensionForm.revSubsEffDate.value == "" && mode != 'N')
	{
		flag = false;
	} 
	return flag;
}

function checkRevSubsEffDate(val)
{
	var payrollyymm = frmEmpSuspensionForm.payYYMM.value;
	var subseffdate = frmEmpSuspensionForm.subsEffDate.value;
	var paylastdate=new Date( (new Date(payrollyymm.substring(0,4), payrollyymm.substring(4),1))-1 );
	var strdate=paylastdate.getDate()+'-'+(paylastdate.getMonth()+1)+'-'+paylastdate.getFullYear();
	if(cmpDateMsg(val,strdate,0,"Date cannot be greater than current payroll YYMM!" ) && cmpDateMsg(val,subseffdate,1,"Date cannot be less than Subsistence Eff. Date!" ))
		{
        document.all.revSubsEffDate.value=val;
        return true;        
    }
    else
    {
        document.all.revSubsEffDate.value="";     
        return false;
    }  
}
//addition by nitin ends

function radClick()
{
    var radflg1=document.getElementsByName("radioPay");
    if(radflg1[1].checked)
	{
		frmEmpSuspensionForm.radFlg.value=1;
		frmEmpSuspensionForm.suspReason.value='Absconding';
	    document.getElementById("suspReason").className = "locked";
		document.getElementById("suspReason").style.background = "#e0e0e0";
		document.getElementById("suspReason").readOnly="true";
		frmEmpSuspensionForm.subsAllow.value=0;
	    document.getElementById("subsAllow").className = "locked";
		document.getElementById("subsAllow").style.background = "#e0e0e0";
		document.getElementById("subsAllow").readOnly="true";
		document.getElementById("tdid1").innerHTML="Absconding Eff. Date";
		document.getElementById("tdid2").innerHTML="Absconding Reason";
	}
	else
	{
		frmEmpSuspensionForm.radFlg.value=0;
		frmEmpSuspensionForm.suspReason.value='Suspension';
		document.getElementById("suspReason").readOnly="";
		document.getElementById("suspReason").className="optional";
		document.getElementById("suspReason").style.background="#FFFFFF";
		document.getElementById("subsAllow").className ="required";
		document.getElementById("subsAllow").style.background="#ffffd3";
		document.getElementById("subsAllow").readOnly="";
    	document.getElementById("tdid1").innerHTML="Suspension Eff. Date";
		document.getElementById("tdid2").innerHTML="Suspension Reason";
	}
	show_hideRow();
}

</script>