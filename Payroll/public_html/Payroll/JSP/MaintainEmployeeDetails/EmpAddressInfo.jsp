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
    <script language="JavaScript1.2" src="../INCLUDES/EmpFinInfo.js"></script>      
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintainEmpAddressBase" name="frmEmpAddressForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpAddressForm">
  <bean:define id="ParentForm" name="frmEmpAddressForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>  
  <% i = 0;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE INFORMATION </TD>
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
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpAddressForm" value="Q">                                                
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </logic:notEqual>                                                                    
                  <logic:equal property= "screenMode" name= "frmEmpAddressForm" value="Q">                              
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required"  />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>               
                  </td>  
              
                  <td class=labelText  ><bean:message key="Payroll.Common.empName" /> </td>
                  <td>                                              
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true"/>                 
                  
                  </td> 
                        
              </tr>
              
              <TR>              
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">            
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /></TD>
                  <td align="left"> 
                  <html:text  property="txtCateg" altKey="Payroll.EmpInfo.lstCateg" titleKey="Payroll.EmpInfo.lstCateg" maxlength="25" size="23" styleClass="locked" readonly="true"/>                  
                 </td>     
                 <td class=labelText  ><bean:message key="Payroll.EmpInfo.StaffCode" /> </td>
                  <td>                  
                  <html:text  property="txtStaffCode" altKey="pay.MaintainAnnualIncome.StaffCode" maxlength="10" size="23" styleClass="locked" readonly="true"/>                 
                  </td>
              </tr>
              
              <tr>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>                  
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" onchange="checkDepuType();" readonly="true"/>
                  </td> 
             
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td>                                                                
                  <html:text  property="txtPresentPOP" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" readonly="true" styleClass="locked" />
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td >
                  <html:text property="txtEmpStatus" name="frmEmpAddressForm"  titleKey="Payroll.EmpInfo.EmpStat" readonly="true" styleClass="locked" />
                  </td>
              </tr>                   
              
              <tr>
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.dojFCI" /> </td>            
                  <td>                  
                  <html:text  property="txtDojFCI" altKey="Payroll.EmpInfo.dojFCI" titleKey="Payroll.EmpInfo.dojFCI" maxlength="15" size="23" onchange="fillDOJPP(this.value);" readonly="true" styleClass="locked" />
                  </td>
                                    
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>                  
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" titleKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" readonly="true" styleClass="locked" />
                   </td>                  
              </tr>   
            </table>     
          </tr>
      <tr height="15" >
      <td colspan="6"></td>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText> Address Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>                  
                                        
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="95%">&nbsp;</td>
                    
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
          <TD class=subHeader colspan=11> Present Address</TD>
        </TR>   
        <TR>
          <TD colspan=11 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
        </tr> 
        <tr><td colspan=11>&nbsp;</td></tr>
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
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempAddLine1" /></td>
                              <td ><html:text  property="txtTempAddL1" styleClass = "required" altKey="Payroll.EmpInfo.TempAddLine1" maxlength="100" size="23" onchange="lfnChanged(this.value);"/></td>             
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempAddLine2" /></td>
                              <td ><html:text  property="txtTempAddL2" styleClass = "optional" altKey="Payroll.EmpInfo.TempAddLine2" maxlength="100" size="23" onchange="lfnChanged(this.value);"/></td>             
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempCity" /></td>
                              <td ><html:text  property="txtTempCity" styleClass = "required" altKey="Payroll.EmpInfo.TempCity" maxlength="20" size="23" onchange="lfnChanged(this.value);"/></td>                                                                         
                            </tr> 
                    
                            <tr>                              
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempState" /></td>
                              <td >
                              <html:text  property="txtTempStateDesc" altKey="pay.EmpInfo.TempState" size="23" styleClass="required" readonly="true" onchange="lfnChange(this.value);" maxlength="25"  />
                              <logic:equal property= "screenMode" name= "frmEmpAddressForm" value="U">
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovTempStateCode();">
                              </logic:equal>                                                                    
                              <logic:equal property= "screenMode" name= "frmEmpAddressForm" value="N">                              
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovTempStateCode();">
                              </logic:equal><html:hidden  property="txtTempState" altKey="Payroll.EmpInfo.TempState"  /> 
                              </td>
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempCountry" /></td>
                              <td ><html:text  property="txtTempCountry" styleClass = "required" readonly="true" altKey="Payroll.EmpInfo.TempCountry" maxlength="20" size="23" value="INDIA" onchange="lfnChanged(this.value);"/></td>                                                                       
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempPin" /></td>
                              <td ><html:text  property="txtTempPin" styleClass = "optional" altKey="Payroll.EmpInfo.TempPin" maxlength="6" size="23" onchange="checkMinLength(this.value)" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right"   /></td>                                                       
                          </tr>                                                    
                          <tr><td colspan=6>&nbsp;</td> </tr>
                            <TR>
                              <TD class=subHeader colspan=6> Permanant Address</TD>
                            </TR>   
                            <TR>
                              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
                            </tr>
                            <tr><td colspan=6>&nbsp;</td></tr>                
                            <TR>       
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermAddLine1" /></td>
                              <td ><html:text  property="txtPermAddL1" titleKey="Payroll.EmpInfo.PermAddLine1" styleClass = "optional" altKey="Payroll.EmpInfo.PermAddLine1" maxlength="100" size="23" onchange="lfnChanged(this.value);" /></td>             
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermAddLine2" /></td>
                              <td ><html:text  property="txtPermAddL2" styleClass = "optional" altKey="Payroll.EmpInfo.PermAddLine2" maxlength="100" size="23" onchange="lfnChanged(this.value);"/></td>             
                          
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermCity" /></td>
                              <td ><html:text  property="txtPermCity" titleKey="Payroll.EmpInfo.PermCity" styleClass = "optional" altKey="Payroll.EmpInfo.PermCity" maxlength="20" size="23" onchange="lfnChanged(this.value);"/></td>                                                                          
                            </tr> 
                    
                            <tr>
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermState" /></td>
                              <td >
                              <html:text  property="txtPermStateDesc" altKey="pay.EmpInfo.PermState" size="23" readonly="true" styleClass="optional"  onchange="lfnChange(this.value);" maxlength="25"  />
                              <logic:equal property= "screenMode" name= "frmEmpAddressForm" value="U">
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovPermStateCode();">
                              </logic:equal>                                                                    
                              <logic:equal property= "screenMode" name= "frmEmpAddressForm" value="N">                              
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovPermStateCode();">
                              </logic:equal><html:hidden  property="txtPermState" altKey="Payroll.EmpInfo.PermState"  /> 
                              </td>
                               
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermCountry" /></td>
                              <td ><html:text  property="txtPermCountry" titleKey="Payroll.EmpInfo.PermCountry" readonly="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermCountry" maxlength="20" size="23" value="INDIA" onchange="lfnChanged(this.value);"/></td>                                           
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermPin" /></td>
                              <td ><html:text  property="txtPermPin" styleClass = "optional" altKey="Payroll.EmpInfo.PermPin" maxlength="6" size="23" onchange="checkMinLength(this.value)" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right"   /></td>             
                              
                            </tr> 
                          <tr><td colspan=6>&nbsp;</td> </tr>  
                            <tr><td colspan=6>&nbsp;</td></tr>     
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
<html:hidden name="frmEmpAddressForm"  property="screenName" value="MaintainEmpAddressScreen" />
<html:hidden name="frmEmpAddressForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpAddressForm" />
<html:hidden property="positionRequested" name="frmEmpAddressForm" />
<html:hidden property="userPositionRequested" name="frmEmpAddressForm" />
<html:hidden property="buttonFlag" name="frmEmpAddressForm"  />
<html:hidden property="lovKey" name="frmEmpAddressForm"  />
<html:hidden property="txtFields" name="frmEmpAddressForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpAddressForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpAddressForm"  />
<html:hidden property="txtIndex" name="frmEmpAddressForm"  />
<html:hidden property="loginLocCode" name="frmEmpAddressForm" />
<html:hidden property="loginEmployeelocation" name="frmEmpAddressForm" />
<html:hidden property="txtInputField" name="frmEmpAddressForm"  />
<html:hidden property="txtAddId" name="frmEmpAddressForm"  />

<html:hidden property="txtEmpNo" name="frmEmpAddressForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">
function ShowLovPermStateCode()
{
    frmEmpAddressForm.lovKey.value = "PayrollEmpMastStatecode" + frmEmpAddressForm.screenName.value + "Q";
    frmEmpAddressForm.txtDisplayFields.value = "txtPermState,txtPermStateDesc";
    frmEmpAddressForm.txtSearchFields.value = "";
    frmEmpAddressForm.txtIndex.value="";
    frmEmpAddressForm.queryParam.value="";
    frmEmpAddressForm.txtInputField.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpAddressForm');
    frmEmpAddressForm.headerDataChanged.value = "true";       
    return true;
}

function ShowLovTempStateCode()
{
    frmEmpAddressForm.lovKey.value = "PayrollEmpMastStatecode" + frmEmpAddressForm.screenName.value + "Q";
    frmEmpAddressForm.txtDisplayFields.value = "txtTempState,txtTempStateDesc";
    frmEmpAddressForm.txtSearchFields.value = "";
    frmEmpAddressForm.txtIndex.value="";
    frmEmpAddressForm.queryParam.value="";
    frmEmpAddressForm.txtInputField.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpAddressForm');
    frmEmpAddressForm.headerDataChanged.value = "true";       
    return true;
} 

function lfnLoad()
{   
    mode = document.all.screenMode.value;     
    if(mode == '')
    {
        doQueryMode();
    }
    hedMenuHandling(mode);
    document.all.butInsertMode.disabled="true";    
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg"; 
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmEmpAddressForm"))
    {     
        frmEmpAddressForm.detailDataChanged.value = "false";  
        if(frmEmpAddressForm.screenMode.value == "U")
        frmEmpAddressForm.headerDataChanged.value = "true";      
        frmEmpAddressForm.headerFields.value = "true";   
        document.all.butSave.disabled="true";
        document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	    frmEmpAddressForm.action = "../../../EmpFinAddSaveAction.do";        
        document.all.txtCateg.disabled = "";
        document.all.txtDsgn.disabled = "";              
        
        frmEmpAddressForm.submit();
    }
    else
    {
        return false;
    }
}

function ShowEmpNum()
{
 //   alert('k');
    frmEmpAddressForm.lovKey.value = "EmpFinInfo" + frmEmpAddressForm.screenName.value + frmEmpAddressForm.screenMode.value; 
    frmEmpAddressForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
    frmEmpAddressForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
    frmEmpAddressForm.txtIndex.value ="";
    frmEmpAddressForm.queryParam.value="txtSiteID="+frmEmpAddressForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpAddressForm.hdnEmpLbrFlag.value;
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpAddressForm');
    return true;
}  

function lfnChange(val)
{
    if(num_Check(val,1))
        frmEmpAddressForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmEmpAddressForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    document.all.txtEmpStatus.disabled=''; 
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		
    frmEmpAddressForm.action="../../../EmpAddressFirstGetHeaderAction.do"
    frmEmpAddressForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpAddressForm.userPositionRequested.value = 1*frmEmpAddressForm.positionRequested.value + 1;
    frmEmpAddressForm.action="../../../EmpAddressGetNextHeader.do";
    frmEmpAddressForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpAddressForm.userPositionRequested.value = 1*frmEmpAddressForm.positionRequested.value - 1;
    frmEmpAddressForm.action = "../../../EmpAddressGetPrevHeader.do";
    frmEmpAddressForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpAddressForm.userPositionRequested.value = 1*frmEmpAddressForm.newPositionRequested.value;
    frmEmpAddressForm.action = "../../../EmpAddressGetNextHeader.do";
    frmEmpAddressForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpAddressForm.action="../../../EmpAddressNewMode.do"
    frmEmpAddressForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpAddressForm.action="../../../EmpAddressQueryMode.do"
    frmEmpAddressForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpAddressForm.action="../../../EmpAddressRefresh.do"
    frmEmpAddressForm.submit();
}

</script>