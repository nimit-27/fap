<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>
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
  <html:form  action="MaintEmpTrnsfr" name="frmEmpTrnsfrForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpTrnsfrForm">
  <bean:define id="ParentForm" name="frmEmpTrnsfrForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE TRANSFER</TD>
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
       <TABLE cellSpacing=0 cellPadding=0 >
            <!--General Information Row Starts -->
            <TR>
              <TD class=subHeader colspan=6> Employee Header</TD>
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
                  <td align="left" >
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </td>  
                  
                  <td class=labelText  >Employee Name </td>
                  <td>                             
                  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                    
                  <td  >&nbsp;</td>
                  <td >&nbsp;</td>
              </TR> 
              
              <TR>              
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/></td>                  
                                    
              </tr>
                      
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                  
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" readonly="true" maxlength="7" size="23" styleClass="locked" onkeypress="
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {
                      return false;
                    };                            
                          lfnChanged(this.value);
                     "  style="text-align:right"   /></td>                                                                  
              </tr>                  
      
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td>
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>   
              
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text property="txtEmpStatus" name="frmEmpTrnsfrForm" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt)" />
                  </td>             
                  
                  <td>&nbsp;</td>
              </tr>   
            </table>     
          </tr>                          
  </table>
    <table cellspacing=0 cellpadding=0 border=0 >
         <!-- Detail Information Row starts -->
 	 <TR height="200">
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
            <TABLE cellSpacing=0 cellPadding=0 border = 0 >
               <TR>          
                   <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText> Transfer Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>                  
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="85%">&nbsp;</td>
                    
              </tr> 
            <tr height="10"><td class=userText colspan="17"></td></tr>            
            <TR height=10>
       <!-- Detail table Container starts -->
                <TD colspan=17>
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD>
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0>
                          <TBODY>                                
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
    <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellSpacing=0 cellPadding=0 >
        <TR>
          <TD class=subHeader colspan=11> </TD>
        </TR>   
        <TR height=20>
 <!-- Detail table Container starts -->
                <TD >
                  <TABLE cellSpacing=0 cellPadding=0 border=0 >
                    <TBODY>
                      <TR>
                        <TD >
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 border=0>
                          <TBODY>                     
                            <TR>       
                              <td  width="15%" class=labelText>Transfer Location</td>
                              <td ><html:text  property="txtTrnsfrToDesc" styleClass = "required" disabled="true" altKey="Payroll.EmpInfo.PermAddLine1" maxlength="100" size="23" onchange="Chk_Char(this.alt,'txtAddL1'); lfnChanged(this.value);" />
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtLoc"  onclick="return ShowLovEmpLoc();">
                              <html:hidden property="txtTrnsfrTo" name="frmEmpTrnsfrForm" />
                              </td>             
                              
                              <td  width="15%" class=labelText>Reason of Transfer</td>
                              <td ><html:select  property="txtTrnsfrReason" disabled="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermAddLine2" >
                                <html:option value="" >-----------Please Select-----------</html:option>      
                                  <logic:present name="EmpTrnsfrCombo">
                                    <html:optionsCollection label="label" value="value" property="trnsfrReasonList" name="EmpTrnsfrCombo"/>
                                  </logic:present>
                                </html:select>
                              </td>             
                            </tr> 
                    
                            <tr>
                              <td  width="15%" class=labelText>Transfer Date</td>     
                              <td ><html:text  property="txtTrnsfrDt" disabled="true" styleClass = "required" altKey="Payroll.EmpInfo.PermCity" maxlength="25" size="23" onchange="chkDate()" />
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" alt="<%=(i-1) %>" onclick="showCalendar('txtTrnsfrDt',this)" />
                              </td> 
                              
                              <td  width="15%" class=labelText>Reliving time</td>
                              <td ><html:select property="txtRlvngTime" disabled="true" styleClass = "required" >
                                    <html:option value="" >-----------Please Select-----------</html:option>
                                    <html:option value="Forenoon" >Forenoon</html:option>
                                    <html:option value="Afternoon" >Afternoon</html:option>
                                </html:select>
                              </td>                                           
                            </tr>                            
                                                       
                          <tr>
                          <td  width="15%" class=labelText>Reliving Date</td>
                           <td ><html:text  property="txtRlvngDt" disabled="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="chkDate()" />
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" alt="<%=(i-1) %>" onclick="showCalendar('txtRlvngDt',this)" /></td>                                                                         
                                                                                                      
                           <td colspan=6>&nbsp;</td> 
                           </tr>



<!--added by sonia on 08-11-2011-->
							  <td  width="15%" class=labelText>System Date(Transfer Out)</td>                              
                              <td ><html:text  property="txtCreatedDt" readonly="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermState"  size="23" />
                             </td>                                                                         
                            
 <logic:equal property="hdnActionFlag" value="J" name ="frmEmpTrnsfrForm" >
<td  width="15%" class=labelText>System Date(Transfer In)</td>                              
 <td ><html:text  property="txtModifiedDt" readonly="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" onchange="chkDate()" maxlength="25" size="23" />                                                              
 </td>
 </logic:equal>
								   <!--end by sonia on 08-11-2011-->

                          <tr> 
                          <td  width="15%" class=labelText></td>
                              <td ></td>  
                              <td colspan=6>&nbsp;</td> </tr>                          
                          <tr height =1><td></td></tr>                          
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
        <td align=center bgcolor=#4682b4 width="40%"></td>
        <td  bgcolor=#4682b4>
        <logic:equal property="hdnActionFlag" name="frmEmpTrnsfrForm" value="T" >
          <html:button property="butLpc" value="Generate LPC" onclick="doGetReport()" />&nbsp;&nbsp;&nbsp;&nbsp;
          <html:button property="butCancel" value="Cancel Transfer" onclick="cancelTrnsfr()" />&nbsp;&nbsp;&nbsp;&nbsp;
        </logic:equal>
         <logic:notEqual property="hdnActionFlag" name="frmEmpTrnsfrForm" value="T" >
          <html:button property="butLpc" value="Generate LPC" onclick="doGetReport()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;
          <html:button property="butCancel" value="Cancel Transfer" onclick="cancelTrnsfr()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;
        </logic:notEqual>
        </td>

        <td bgColor=#4682b4></td>
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
<html:hidden name="frmEmpTrnsfrForm"  property="screenName" value="TransferScreen" />
<html:hidden property="txtTrnsfrFrom" name="frmEmpTrnsfrForm"  />
<html:hidden property="loginLocCode" name="frmEmpTrnsfrForm"  />
<html:hidden name="frmEmpTrnsfrForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpTrnsfrForm" />
<html:hidden property="positionRequested" name="frmEmpTrnsfrForm" />
<html:hidden property="userPositionRequested" name="frmEmpTrnsfrForm" />
<html:hidden property="buttonFlag" name="frmEmpTrnsfrForm"  />
<html:hidden property="lovKey" name="frmEmpTrnsfrForm"  />
<html:hidden property="txtFields" name="frmEmpTrnsfrForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpTrnsfrForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpTrnsfrForm"  />
<html:hidden property="txtIndex" name="frmEmpTrnsfrForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpTrnsfrForm"  />
<input type="hidden" name="queryParam" />
<input type="hidden" id="submitParam" name="submitParam" />    

</html:form>
</body>
</html:html>
<% ReportReader oReportReader=new ReportReader(); %> 
<% ParamUtil oParamUtil=new ParamUtil(); %> 
<script language="javascript">
function ShowEmpNum()
{
   frmEmpTrnsfrForm.lovKey.value = "EmpTrnsfr" + frmEmpTrnsfrForm.screenName.value + frmEmpTrnsfrForm.screenMode.value;
   frmEmpTrnsfrForm.queryParam.value = "txtSiteID="+frmEmpTrnsfrForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpTrnsfrForm.hdnEmpLbrFlag.value;
   if(frmEmpTrnsfrForm.screenMode.value == 'N')
   {
      frmEmpTrnsfrForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtDOJSite,txtEmpStatus";
      // frmEmpTrnsfrForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
       frmEmpTrnsfrForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
       frmEmpTrnsfrForm.txtIndex.value ="";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpTrnsfrForm');
   }
   if(frmEmpTrnsfrForm.screenMode.value == 'Q')
   {
     frmEmpTrnsfrForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
     frmEmpTrnsfrForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
     frmEmpTrnsfrForm.txtIndex.value ="";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpTrnsfrForm');
   }
   
   return true;
}    

function ShowLovEmpLoc()
{
   if(frmEmpTrnsfrForm.txtEmpNo.value=='')
   {
    alert("Please Select an Employee First!!");
    return false;
   }
   
   if(frmEmpTrnsfrForm.screenMode.value=='N')
   {
    frmEmpTrnsfrForm.lovKey.value = "EmpTrnsfrLoc" + frmEmpTrnsfrForm.screenName.value + frmEmpTrnsfrForm.screenMode.value;
    frmEmpTrnsfrForm.queryParam.value="txtEmpNo="+ frmEmpTrnsfrForm.txtEmpNo.value ;
    frmEmpTrnsfrForm.txtSearchFields.value ="Payroll.Site.LocId,Payroll.Site.LocName,Payroll.Site.parentLoc";
    frmEmpTrnsfrForm.txtDisplayFields.value = "txtTrnsfrTo,txtTrnsfrToDesc";
    frmEmpTrnsfrForm.txtIndex.value ="";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpTrnsfrForm');
   }
   return true;
}
function upper(val)
{
   val.value=val.value.toUpperCase();
}

function lfnLoad()
{   
    mode = document.all.screenMode.value;
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='N')
    {        
        document.all.butLpc.disabled = "true";
        document.all.butCancel.disabled = "true";
        document.all.txtTrnsfrTo.disabled = "";
        document.all.txtTrnsfrReason.disabled = "";
        document.all.txtTrnsfrDt.disabled = "";
        document.all.txtRlvngDt.disabled = "";
        document.all.txtRlvngTime.disabled = "";
    }
    hedMenuHandling(mode);
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmEmpTrnsfrForm"))
    {     
        frmEmpTrnsfrForm.detailDataChanged.value = "false";  
        if(frmEmpTrnsfrForm.screenMode.value == "N")
        frmEmpTrnsfrForm.headerDataChanged.value = "true";      
        frmEmpTrnsfrForm.headerFields.value = "true";     
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpTrnsfrForm.action = "../../../EmpTrnsfrSaveAction.do";  
        
        frmEmpTrnsfrForm.submit();
    }
    else
    {
        return false;
    }
}

function lfnChanged(val)
{
    frmEmpTrnsfrForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

    frmEmpTrnsfrForm.action="../../../EmpTrnsfrFirstGetHeaderAction.do"
    frmEmpTrnsfrForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpTrnsfrForm.userPositionRequested.value = 1*frmEmpTrnsfrForm.positionRequested.value + 1;
    frmEmpTrnsfrForm.action="../../../EmpTrnsfrGetNextHeader.do";
    frmEmpTrnsfrForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpTrnsfrForm.userPositionRequested.value = 1*frmEmpTrnsfrForm.positionRequested.value - 1;
    frmEmpTrnsfrForm.action = "../../../EmpTrnsfrGetNextHeader.do";
    frmEmpTrnsfrForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpTrnsfrForm.userPositionRequested.value = 1*frmEmpTrnsfrForm.newPositionRequested.value;
    frmEmpTrnsfrForm.action = "../../../EmpTrnsfrGetNextHeader.do";
    frmEmpTrnsfrForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpTrnsfrForm.action="../../../EmpTrnsfrNewMode.do"
    frmEmpTrnsfrForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpTrnsfrForm.action="../../../EmpTrnsfrQueryMode.do"
    frmEmpTrnsfrForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpTrnsfrForm.action="../../../EmpTrnsfrRefresh.do"
    frmEmpTrnsfrForm.submit();
}

function chkDate()
{   
    var trnsfrDt=document.all.txtTrnsfrDt.value;
    var rlvngDt=document.all.txtRlvngDt.value;
    if(!cmpSysDate(rlvngDt, 0))
    {
        document.all.txtRlvngDt.value="";
        return false;
    }
    
    if(document.all.txtDOJSite.value!='')
    {
        if (!cmpDate(document.all.txtDOJSite.value,trnsfrDt,0))
        {
            alert("Transfer Date must be greater than Date of Joining Present Place");
            document.all.txtTrnsfrDt.value="";
            return false;                      
        }    
    }
    if(rlvngDt!='')
    {
        if (!cmpDate(trnsfrDt,rlvngDt,0))
        {
            alert("Reliving Date must be greater than Transfer Date");
            document.all.txtRlvngDt.value="";
            return false;                      
        }
    }
}

function doGetReport()
{  
    if(document.all.headerPrimaryKey.value!='')
    { 
		var winurl="last_pay_certificate.rdf&P_EMP_NUM="+frmEmpTrnsfrForm.txtEmpNo.value+"&P_EMP_SITE_CODE="+frmEmpTrnsfrForm.loginLocCode.value;  // added by sonia 10 Jan 2011
		document.getElementById('butLpc').value="Please wait. File is being downloaded..";
		document.getElementById('butLpc').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.frmEmpTrnsfrForm.action="../../../ReportLinkerAction.do";
		document.frmEmpTrnsfrForm.submit();
    }
    else
    {
        alert("Please Select a record for generating Report");
        return false;
    }
}

function cancelTrnsfr()
{
    if(document.all.headerPrimaryKey.value!='')
    {     
        frmEmpTrnsfrForm.detailDataChanged.value = "false";  
        frmEmpTrnsfrForm.headerDataChanged.value = "true";      
        frmEmpTrnsfrForm.headerFields.value = "true";
        var resp=confirm("Are you sure you want to cancel the Employee Transfer?");
        if(resp)
        {
          frmEmpTrnsfrForm.action = "../../../EmpTrnsfrCancelAction.do";  
          frmEmpTrnsfrForm.submit();
        }
        else
        {
          return false;
        }
    }
    else
    {
        alert("Please Select a record for cancellation");
        return false;
    }
  
}
</script>