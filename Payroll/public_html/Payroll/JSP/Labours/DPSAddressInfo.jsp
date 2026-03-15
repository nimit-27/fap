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
    <script language="JavaScript1.2" src="../INCLUDES/DPSPayInfo.js"></script>      
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintDPSInfo" name="frmDPSInfoForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.DPSInfoForm">
  <bean:define id="ParentForm" name="frmDPSInfoForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %> 
  
  <jsp:include page="DPSHeaderInc.jsp" flush="true" />
  <table cellspacing=0 cellpadding=0 border=0 >
         <!-- Detail Information Row starts -->
 	 <TR >
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
            <TABLE cellSpacing=0 cellPadding=0 border = 0 >
               <TR>          
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("PayDet")> Payroll Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("HrDet")> HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText> Address Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>                  
                                        
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="65%">&nbsp;</td>
                    
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
          <TD class=subHeader colspan=11> Permanent Address</TD>
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
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermAddLine1" /></td>
                              <td ><html:text  property="txtPermAddL1" titleKey="Payroll.EmpInfo.PermAddLine1" styleClass = "optional" altKey="Payroll.EmpInfo.PermAddLine1" maxlength="100" size="23" onchange="Chk_Char(this.alt,'txtAddL1'); lfnChanged(this.value);" /></td>             
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermAddLine2" /></td>
                              <td ><html:text  property="txtPermAddL2" styleClass = "optional" altKey="Payroll.EmpInfo.PermAddLine2" maxlength="100" size="23" onchange="lfnChanged(this.value);"/></td>             
                          
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermCity" /></td>
                              <td ><html:text  property="txtPermCity" titleKey="Payroll.EmpInfo.PermCity" styleClass = "optional" altKey="Payroll.EmpInfo.PermCity" maxlength="20" size="23" onchange="lfnChanged(this.value);"/></td>                                                                          
                            </tr> 
                    
                            <tr>
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermState" /></td>
                              <td >
                              <html:text  property="txtPermStateDesc" altKey="pay.EmpInfo.PermState" size="23" styleClass="optional"  onchange="lfnChange(this.value);" maxlength="25"  />
                              <logic:equal property= "screenMode" name= "frmDPSInfoForm" value="U">
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovPermStateCode();">
                              </logic:equal>                                                                    
                              <logic:equal property= "screenMode" name= "frmDPSInfoForm" value="N">                              
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovPermStateCode();">
                              </logic:equal><html:hidden  property="txtPermState" altKey="Payroll.EmpInfo.PermState"  /> 
                              </td>
                               
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermCountry" /></td>
                              <td ><html:text  property="txtPermCountry" titleKey="Payroll.EmpInfo.PermCountry" styleClass = "optional" altKey="Payroll.EmpInfo.PermCountry" maxlength="20" size="23" value="INDIA" onchange="lfnChanged(this.value);"/></td>                                           
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermPin" /></td>
                              <td ><html:text  property="txtPermPin" styleClass = "optional" altKey="Payroll.EmpInfo.PermPin" maxlength="6" size="23" onchange="checkMinLength(this.value)" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right"   /></td>             
                              
                            </tr>   
                            <tr><td colspan=6>&nbsp;</td></tr>                              
                            <TR>
                              <TD class=subHeader colspan=6> Present Address</TD>
                            </TR>   
                            <TR>
                              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
                            </tr>
                            <tr><td colspan=6>&nbsp;</td></tr> 
                            <TR>                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempAddLine1" /></td>
                              <td ><html:text  property="txtTempAddL1" styleClass = "optional" altKey="Payroll.EmpInfo.TempAddLine1" maxlength="100" size="23" onchange="lfnChanged(this.value);"/></td>             
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempAddLine2" /></td>
                              <td ><html:text  property="txtTempAddL2" styleClass = "optional" altKey="Payroll.EmpInfo.TempAddLine2" maxlength="100" size="23" onchange="lfnChanged(this.value);"/></td>             
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempCity" /></td>
                              <td ><html:text  property="txtTempCity" styleClass = "optional" altKey="Payroll.EmpInfo.TempCity" maxlength="20" size="23" onchange="lfnChanged(this.value);"/></td>                                                                         
                            </tr> 
                    
                            <tr>                              
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempState" /></td>
                              <td >
                              <html:text  property="txtTempStateDesc" altKey="pay.EmpInfo.TempState" size="23" styleClass="optional"  onchange="lfnChange(this.value);" maxlength="25"  />
                              <logic:equal property= "screenMode" name= "frmDPSInfoForm" value="U">
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovTempStateCode();">
                              </logic:equal>                                                                    
                              <logic:equal property= "screenMode" name= "frmDPSInfoForm" value="N">                              
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovTempStateCode();">
                              </logic:equal><html:hidden  property="txtTempState" altKey="Payroll.EmpInfo.TempState"  /> 
                              </td>
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempCountry" /></td>
                              <td ><html:text  property="txtTempCountry" styleClass = "optional" altKey="Payroll.EmpInfo.TempCountry" maxlength="20" size="23" value="INDIA" onchange="lfnChanged(this.value);"/></td>                                                                       
                              
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
                          <tr><td colspan=6>&nbsp;</td> </tr>                          
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
<html:hidden name="frmDPSInfoForm"  property="screenName" value="DPSInfoScreen" />
<html:hidden name="frmDPSInfoForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDPSInfoForm" />
<html:hidden property="positionRequested" name="frmDPSInfoForm" />
<html:hidden property="userPositionRequested" name="frmDPSInfoForm" />
<html:hidden property="buttonFlag" name="frmDPSInfoForm"  />
<html:hidden property="lovKey" name="frmDPSInfoForm"  />
<html:hidden property="txtFields" name="frmDPSInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmDPSInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmDPSInfoForm"  />
<html:hidden property="txtIndex" name="frmDPSInfoForm"  />
<html:hidden property="loginLocCode" name="frmDPSInfoForm" />
<html:hidden property="txtInputField" name="frmDPSInfoForm"  />
<html:hidden property="txtCateg" name="frmDPSInfoForm"  />

<html:hidden property="txtCurMGW" name="frmDPSInfoForm"  />
<html:hidden property="txtPayStatus" name="frmDPSInfoForm"  />
<html:hidden property="txtPayMode" name="frmDPSInfoForm"  />
<html:hidden property="txtPayStsChnDate" name="frmDPSInfoForm"  />


<html:hidden property="hdnIRFlag" name="frmDPSInfoForm"  /> 
<html:hidden property="hdnBFFlag" name="frmDPSInfoForm"  />
<html:hidden property="hdnSocRecFlag" name="frmDPSInfoForm"  />
<html:hidden property="txtSocRecAmt" name="frmDPSInfoForm"  />

<html:hidden property="txtDOB" name="frmDPSInfoForm"  />
<html:hidden property="txtGender" name="frmDPSInfoForm"  />
<html:hidden property="txtMarStat" name="frmDPSInfoForm"  />
<html:hidden property="txtFatherNam" name="frmDPSInfoForm"  />
<html:hidden property="txtHomTwn" name="frmDPSInfoForm"  />
<html:hidden property="txtHandi" name="frmDPSInfoForm"  />
<html:hidden property="txtHandiEffDate" name="frmDPSInfoForm"  />
<html:hidden property="txtRetireDate" name="frmDPSInfoForm"  />

<html:hidden property="txtAddId" name="frmDPSInfoForm"  />

<html:hidden property="txtEmpNo" name="frmDPSInfoForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">
function ShowLovPermStateCode()
{
    frmDPSInfoForm.lovKey.value = "DPSLabourStatecode" + frmDPSInfoForm.screenName.value + frmDPSInfoForm.screenMode.value;
    frmDPSInfoForm.txtDisplayFields.value = "txtPermState,txtPermStateDesc";
    frmDPSInfoForm.txtSearchFields.value = "";
    frmDPSInfoForm.txtIndex.value="";
    frmDPSInfoForm.txtInputField.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDPSInfoForm');
    frmDPSInfoForm.headerDataChanged.value = "true";       
    return true;
}

function ShowLovTempStateCode()
{
    frmDPSInfoForm.lovKey.value = "DPSLabourStatecode" + frmDPSInfoForm.screenName.value + frmDPSInfoForm.screenMode.value;
    frmDPSInfoForm.txtDisplayFields.value = "txtTempState,txtTempStateDesc";
    frmDPSInfoForm.txtSearchFields.value = "";
    frmDPSInfoForm.txtIndex.value="";
    frmDPSInfoForm.txtInputField.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDPSInfoForm');
    frmDPSInfoForm.headerDataChanged.value = "true";       
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
        document.all.headerPrimaryKey.disabled = "true";          
    }
      
    checkPFType();     
    hedMenuHandling(mode);
}

function checkPFType(){  
    if (document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=='')
    {
        document.getElementById("cpf").style.display='';        
        document.getElementById("gpf").style.display='none';        
        //document.getElementById("vcpf").style.display='';        
        //document.getElementById("vgpf").style.display='none';        
    }
    if (document.all.txtPFType.value=="PFTYPE$GPF")
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';           
        //document.getElementById("vgpf").style.display='';
        //document.getElementById("vcpf").style.display='none';           
    }    
}  

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmDPSInfoForm"))
    {     
        frmDPSInfoForm.detailDataChanged.value = "false";  
        if(frmDPSInfoForm.screenMode.value == "U")
        frmDPSInfoForm.headerDataChanged.value = "true";      
        frmDPSInfoForm.headerFields.value = "true"; 
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmDPSInfoForm.action = "../../../DPSAddSaveAction.do";        
        document.all.txtPFType.disabled = "";
        document.all.txtDsgn.disabled = "";              
        
        frmDPSInfoForm.submit();
    }
    else
    {
        return false;
    }
}

function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../DPSInfoAddressTabAction.do";
    document.forms[0].submit(); 
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmDPSInfoForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmDPSInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
	document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmDPSInfoForm.action="../../../DPSAddressFirstGetHeaderAction.do"
	frmDPSInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmDPSInfoForm.userPositionRequested.value = 1*frmDPSInfoForm.positionRequested.value + 1;
    frmDPSInfoForm.action="../../../DPSAddressGetNextHeader.do";
    frmDPSInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmDPSInfoForm.userPositionRequested.value = 1*frmDPSInfoForm.positionRequested.value - 1;
    frmDPSInfoForm.action = "../../../DPSAddressGetPrevHeader.do";
    frmDPSInfoForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmDPSInfoForm.userPositionRequested.value = 1*frmDPSInfoForm.newPositionRequested.value;
    frmDPSInfoForm.action = "../../../DPSAddressGetNextHeader.do";
    frmDPSInfoForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmDPSInfoForm.action="../../../DPSPayNewMode.do"
    frmDPSInfoForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmDPSInfoForm.action="../../../DPSPayQueryMode.do"
    frmDPSInfoForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmDPSInfoForm.action="../../../DPSAddressRefresh.do"
    frmDPSInfoForm.submit();
}

function checkMinLength(str)
{
    if(!(str.length == 6))
    {
        alert("Please Enter 6 Digit Value");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}
</script>