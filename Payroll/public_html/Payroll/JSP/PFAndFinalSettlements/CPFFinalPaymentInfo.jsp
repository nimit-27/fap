<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>

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

<html:form  action="CPFFinalPaymentDetailBase" name="frmCPFFinalPayForm" type="FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm" scope="session">
<bean:define id="ParentForm" name="frmCPFFinalPayForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE CPF FINAL PAYMENT INFORMATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td>
  </tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
            <!--General Information Row Starts -->
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
                  <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">                   
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td> 
              </TR> 
                                
              <TR>              
                  <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>                  
                  </td>
                  
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCateg" styleClass="locked" readonly="true" size="23"/>
                  </td>                                                                        
              </tr>
                      
              <tr> 
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                    
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="7" size="23" styleClass="locked"  style="text-align:Left"   /></td>                                                                  
              </tr>
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td><html:text  property="txtPresentPOP" altKey="pay.EmpInfo.PresentPOP" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   />                  
                  </td>                                                            
                  
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.StaffCode" /> </td>            
                  <td>
                  <html:text  property="txtStaffCode" altKey="Payroll.EmpInfo.StaffCode" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>    
      
              <tr>
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text  property="txtEmpStatus" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td> 
				  <!-- added by gagan on 23-04-2013-->
				  <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
				  <td width="23%" class=labelText  >System Sanction number </td>                            
                  <td ><html:text  property="txtSysSantionNum" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td> 
				  </logic:notEqual> 
				  <!-- added by gagan on 23-04-2013-->
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
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>CPF Final Payment Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                  
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
                       <tr>
                          
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.SancDate" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="sancDate" altKey="Payroll.EmpInfo.SancDate" maxlength="25" size="23" styleClass="required" readonly="true" />
                          <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="sancDate" alt="<%=(i-1) %>" onclick="showCalendar('sancDate',this)" />                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="sancDate" altKey="Payroll.EmpInfo.SancDate" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:notEqual>
                          </td>
                          <td align="right">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:button value="Get Payment Details " property="butGetDetail" onclick="getFinalDetails()" />
                          </logic:equal> 
                          </td>
                          <td></td>
                          
                        </tr>
                        
                        <tr>
                        
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.sancOrderNo" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="sancOrderNo" altKey="Payroll.EmpInfo.sancOrderNo" maxlength="25" size="23" styleClass="required" />                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="sancOrderNo" altKey="Payroll.EmpInfo.sancOrderNo" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:notEqual>
                          </td>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.InvNum" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="txtInvID" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                        </tr>
                        
                        <TR>                          
                          <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.EmpContri" /></td>
                          <td >
                          <html:text  property="empContri" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                           </td>                                                   
                          
                          <td width="23%" class=labelText><bean:message key="Payroll.EmpInfo.IntEmpContri" /></td>
                          <td >
                          <html:text  property="intrstEmpContri" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="50" size="23" style="text-align:left" readonly="true" />                                                        
                          </td>
                        </tr>
                        <tr>                      
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmplyrContri" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="emplyrContri" altKey="Payroll.EmpInfo.IntEmpContri" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                      
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.IntEmpyrContri" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="intrstEmplyrContri" altKey="Payroll.EmpInfo.IntEmpyrContri" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                        </tr>
                        <tr>                      
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.VpfContri" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="vpfContri" altKey="Payroll.EmpInfo.IntEmpContri" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                      
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.IntVpfContri" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="intrstVpfContri" altKey="Payroll.EmpInfo.IntEmpyrContri" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                        </tr>
                        <tr>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.IntIntrvngPd" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="intrstIntrvngPrd" altKey="Payroll.EmpInfo.IntIntrvngPd" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                          
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.TDSIntIntervngPd" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="tdsIntIntrvngPrd" altKey="Payroll.EmpInfo.TDSIntIntervngPd" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>  
                        </tr> 
                        <!--
                        <tr>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.PartFinWd" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="partFinalWid" altKey="Payroll.EmpInfo.PartFinWd" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                          
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.CPFAdvRecvry" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="cpfAdvIntRcvry" altKey="Payroll.EmpInfo.CPFAdvRecvry" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                      
                          
                        </tr>
                        -->
                        <tr>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.SancAmnt" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="sancAmount" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                          
                          <logic:notEqual property="cancelStatus" name="frmCPFFinalPayForm" value="">
                          <td width="23%" class=labelText>Cancel Status</td>
                          <td >
                            <html:textarea  property="cancelStatus" styleClass = "locked" alt="<%=String.valueOf(i)%>" cols="25" style="text-align:left" readonly="true" />                              
                          </td> 
                          </logic:notEqual>
                         <td class=labelText  ><bean:message key="Payroll.LoanDtls.claimReqId"/></TD>
                            <td >                  
                            <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="Q">                              
                                <html:text property="claimReqId" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="butclaimReqId" onclick="ShowLovClaimReqId();" >
                            </logic:notEqual>                                                                                                 
                            <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="Q">                              
                                <html:text property="claimReqId" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                            </logic:equal>
                            </td>
                        </tr>                    
                                  
                    
                        <tr height = 3><td>&nbsp;</td></tr>                    
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
        <td align=center bgcolor=#4682b4 width="30%"></td>
        <td  bgcolor=#4682b4>
        <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
          <html:button property="butSanc" value="Generate Sanction Order" onclick="SaveRecord()" />&nbsp;&nbsp;&nbsp;&nbsp;
        </logic:equal>
        <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="U">
        <logic:equal property= "txtInvID" name= "frmCPFFinalPayForm" value="">
          <logic:equal property="cancelStatus" name="frmCPFFinalPayForm" value="">
            <html:button property="butRel" value="Release Payment" onclick="relFinalPay()" />&nbsp;&nbsp;&nbsp;&nbsp;
          </logic:equal>
          <logic:notEqual property="cancelStatus" name="frmCPFFinalPayForm" value="">
            <html:button property="butRel" value="Release Payment" onclick="relFinalPay()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;
          </logic:notEqual>
        </logic:equal>
        <logic:notEqual property= "txtInvID" name= "frmCPFFinalPayForm" value=""> 
          <html:button property="butRel" value="Release Payment" onclick="relFinalPay()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;
        </logic:notEqual>
        </logic:equal>
        
        <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="U">
        
        <logic:equal property= "txtInvID" name= "frmCPFFinalPayForm" value="">
          <logic:equal property="cancelStatus" name="frmCPFFinalPayForm" value="">
            <html:button property="butCancelSanc" value="Cancel Sanction Order" onclick="doCancelSanc()" />&nbsp;&nbsp;&nbsp;&nbsp;
          </logic:equal>
          <logic:notEqual property="cancelStatus" name="frmCPFFinalPayForm" value="">
            <html:button property="butCancelSanc" value="Cancel Sanction Order" onclick="doCancelSanc()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;
          </logic:notEqual>
        </logic:equal>
        <logic:notEqual property= "txtInvID" name= "frmCPFFinalPayForm" value=""> 
          <html:button property="butCancelSanc" value="Cancel Sanction Order" onclick="doCancelSanc()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;
          <html:button property="butCancelInv" value="Cancel Final Invoice" onclick="doCancelInv()" />&nbsp;&nbsp;&nbsp;&nbsp;
        </logic:notEqual>
         
        </logic:equal>
    
        <!--commented by Himanshu on 13-oct-2014-->
        <!--<logic:notEqual property= "txtInvID" name= "frmCPFFinalPayForm" value="">
          <logic:equal property="cancelStatus" name="frmCPFFinalPayForm" value="">
            <html:button property="butRevoke" value="Cancel Payment Details" onclick="doRevoke()" disabled="" />&nbsp;&nbsp;&nbsp;&nbsp;
          </logic:equal>
          <logic:notEqual property="cancelStatus" name="frmCPFFinalPayForm" value="">
            <html:button property="butRevoke" value="Cancel Payment Details" onclick="doRevoke()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;
          </logic:notEqual>
        </logic:notEqual>-->
		
		<logic:notEqual property= "txtSysSantionNum" name= "frmCPFFinalPayForm" value="">
            <html:button property="reportButton" value="Generate Report" onclick="doGetReport()"  />&nbsp;&nbsp;&nbsp;&nbsp;
        </logic:notEqual>
       
         <td bgColor=#4682b4>
         </td>
        <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
      </TR>
	
  </TABLE> 
<!-- Container Table Ending Columns Starts-->
  </TD>
 
</TR>
</TBODY>
</TABLE>

</div>


<!-- Container Table Ends -->
<html:hidden name="frmCPFFinalPayForm"  property="screenName" value="CPFFinalPaymentScreen" />
<html:hidden name="frmCPFFinalPayForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmCPFFinalPayForm" />
<html:hidden property="loginLocCode" name="frmCPFFinalPayForm" />
<html:hidden property="positionRequested" name="frmCPFFinalPayForm" />
<html:hidden property="userPositionRequested" name="frmCPFFinalPayForm" />
<html:hidden property="buttonFlag" name="frmCPFFinalPayForm"  />
<html:hidden property="lovKey" name="frmCPFFinalPayForm"  />
<html:hidden property="txtFields" name="frmCPFFinalPayForm"  />   
<html:hidden property="txtSearchFields" name="frmCPFFinalPayForm"  />
<html:hidden property="txtDisplayFields" name="frmCPFFinalPayForm"  />
<html:hidden property="txtIndex" name="frmCPFFinalPayForm"  />
<html:hidden property="txtInputField" name="frmCPFFinalPayForm"  />
<html:hidden  property="hdnAction" name="frmCPFFinalPayForm" />
<html:hidden  property="hdnSancType" name="frmCPFFinalPayForm" value="F" />
<html:hidden property="txtSysSantionNum" name="frmCPFFinalPayForm"  />
<html:hidden property="headerPrimaryKey" name="frmCPFFinalPayForm"  />
<input type="hidden" name="queryParam" />
<input type="hidden" id="submitParam" name="submitParam" /> 

</html:form>
</body>
</html:html>

<% ReportReader oReportReader=new ReportReader(); %> 
<% ParamUtil oParamUtil=new ParamUtil(); %> 

<script language="javascript">

function doGetReport()
{  
	var winurl="CPF_final.rdf&sanc_num="+frmCPFFinalPayForm.headerPrimaryKey.value;
	document.getElementById('reportButton').value="Please wait. File is being downloaded..";
	document.getElementById('reportButton').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.frmCPFFinalPayForm.action="../../../ReportLinkerAction.do";
	document.frmCPFFinalPayForm.submit();
}

function ShowEmpNum()
{
    frmCPFFinalPayForm.lovKey.value = "EmpCpf" + frmCPFFinalPayForm.screenName.value + frmCPFFinalPayForm.screenMode.value;    
    if(document.all.screenMode.value=='N')
    {
      frmCPFFinalPayForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCateg,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtStaffCode";
    }
    else
    {
      frmCPFFinalPayForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
    }
    frmCPFFinalPayForm.queryParam.value = "txtSiteID="+frmCPFFinalPayForm.loginLocCode.value+",hdnEmpLbrFlag="+frmCPFFinalPayForm.hdnEmpLbrFlag.value+",hdnSancType="+frmCPFFinalPayForm.hdnSancType.value;
    frmCPFFinalPayForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
    frmCPFFinalPayForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCPFFinalPayForm');
    return true;
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
    document.all.butSave.disabled="true";    
    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    hedMenuHandling(mode);
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.action="../../../CPFFinalPayQueryMode.do"
    frmCPFFinalPayForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmCPFFinalPayForm.action="../../../CPFFinalPayRefresh.do"
    frmCPFFinalPayForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.action="../../../CPFFinalPayNewMode.do"
    frmCPFFinalPayForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmCPFFinalPayForm.action="../../../CPFFinalPayGetHeaderAction.do"
    frmCPFFinalPayForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.userPositionRequested.value = 1*frmCPFFinalPayForm.positionRequested.value + 1;
    frmCPFFinalPayForm.action="../../../CPFFinalPayGetNextHeader.do";
    frmCPFFinalPayForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.userPositionRequested.value = 1*frmCPFFinalPayForm.positionRequested.value - 1;
    frmCPFFinalPayForm.action = "../../../CPFFinalPayGetPrevHeader.do";
    frmCPFFinalPayForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.userPositionRequested.value = 1*frmCPFFinalPayForm.newPositionRequested.value;
    frmCPFFinalPayForm.action = "../../../CPFFinalPayGetNextHeader.do";
    frmCPFFinalPayForm.submit();
}

function SaveRecord()
{
    if (!checkMOdifiedDate()){
    return false};
    document.all.buttonFlag.value=''; 
        if(mandatory_Check("frmCPFFinalPayForm"))
        {       
			document.all.butSanc.disabled="true";
			document.all.butSave.disabled="true";
            if(document.all.sancAmount.value=='')
            {
              alert("Please get the Payment details first");
            }else
            {
              frmCPFFinalPayForm.headerDataChanged.value = "true";    
              frmCPFFinalPayForm.headerFields.value = "true";   
		      document.all.butSave.disabled="true";
			  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
			  frmCPFFinalPayForm.action = "../../../CPFFinalPaySaveAction.do";            
              frmCPFFinalPayForm.submit();
            }
        }
    else
    {
        return false;
    }
}

function getFinalDetails()
{
  if(document.all.txtEmpNo.value=='')
  {
    alert("Please Select Employee First!!");
    return false;
  }
  if(document.all.sancDate.value=='')
  {
    alert("Please Select Sanction Date");
    return false;
  }
  document.all.hdnAction.value="getFinalDtls";
  frmCPFFinalPayForm.action="../../../CPFFinalPayDtls.do";
  frmCPFFinalPayForm.submit();

}

function relFinalPay()
{
  document.all.butSave.disabled="true";
  document.all.butRel.disabled="true";
  document.all.butCancelSanc.disabled="true";
  document.all.hdnAction.value="relCPFPay";
  frmCPFFinalPayForm.action="../../../CPFFinalPayDtls.do";
  frmCPFFinalPayForm.submit();

}

function doCancelSanc()
{
  if(mandatory_Check("frmCPFFinalPayForm"))
  {
    document.all.butSave.disabled="true";
    document.all.butRel.disabled="true";
    document.all.butCancelSanc.disabled="true";
    frmCPFFinalPayForm.headerDataChanged.value="true";
    frmCPFFinalPayForm.action = "../../../CPFFinalPaySaveAction.do";
    frmCPFFinalPayForm.submit();
  }
}

function doRevoke()
{
  document.all.hdnAction.value="revokeCPFPay";
  frmCPFFinalPayForm.action="../../../CPFFinalPayDtls.do";
  frmCPFFinalPayForm.submit();
}
//added by arvind
function doCancelInv() 
{
  if(mandatory_Check("frmCPFFinalPayForm"))
  { 
   // document.all.butCancelInv.disabled="true";
   // document.all.releaseButton.disabled="true";
    frmCPFFinalPayForm.headerDataChanged.value="true";
    frmCPFFinalPayForm.action = "../../../CPFFinalCancelInvAction.do";
    frmCPFFinalPayForm.submit();
  }  
}
function ShowLovClaimReqId()
{
if (frmCPFFinalPayForm.txtEmpNo.value=='' || frmCPFFinalPayForm.txtEmpNo.value==null)  {
    alert("Please Select Employee number !! ");
    return false;
}
else{
var screenname=frmCPFFinalPayForm.screenName.value;
   frmCPFFinalPayForm.lovKey.value = "cpfClaimReqId" + frmCPFFinalPayForm.screenName.value + frmCPFFinalPayForm.screenMode.value;    
  frmCPFFinalPayForm.txtDisplayFields.value = "claimReqId";
       frmCPFFinalPayForm.queryParam.value = "txtEmpNo="+ frmCPFFinalPayForm.txtEmpNo.value +",hdnEmpLbrFlag="+ frmCPFFinalPayForm.hdnEmpLbrFlag.value ;             
  frmCPFFinalPayForm.txtSearchFields.value = "Payroll.LoanDtls.claimReqId";
    frmCPFFinalPayForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCPFFinalPayForm');
   return true;
}
}
//Added By Amresh Kumar Regarding Backdated Separation check 
function checkMOdifiedDate() {
    var url = "../../../empDtlUpdateZone.do";
    var prm = "mode=1&txtEmpNo=" + document.getElementById("txtEmpNo").value +
              "&screenName=" + frmCPFFinalPayForm.screenName.value;

    var xml = getXML(url, prm);
    var Tags = xml.getElementsByTagName("record");

    if (Tags != null && Tags.length > 0 && Tags[0].firstChild != null) {
        var msg = Tags[0].firstChild.nodeValue;

        // Always ask user to confirm, using msg as the content
        if (msg!="SUCCESS") {
        var confirmStatus = confirm(msg);
        return confirmStatus;  // true = Yes, false = No
        }
        else
        {
        return true;
        }
    }
}




</script>