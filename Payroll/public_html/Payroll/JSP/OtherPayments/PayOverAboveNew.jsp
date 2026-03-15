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
  <html:form  action="PayOverAboveBaseAction" name="frmPayOverAbove" type="FCIPAY.Payroll.WEBTIER.Form.PayOverAboveForm">
  <bean:define id="ParentForm" name="frmPayOverAbove" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>OVER & ABOVE PAYMENT</TD>
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
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" onchange="checkMonthITDed();"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </td>  
                  
                  <td class=labelText  >Employee Name </td>
                  <td>                             
                  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
              </TR> 
              
              <TR>              
                  <TD width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
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
                  <td ><html:text property="txtEmpStatus" name="frmPayOverAbove" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23"  onchange="return changed(this.alt)" />
                  </td>             
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.curbas" /> </td>                            
                  <td ><html:text property="txtCurrBas" name="frmPayOverAbove" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23" onchange="return changed(this.alt)" />
                  </td>

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
                    <td bgcolor="#4682B4" nowrap class=actTabText> Over & Above Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                            
                            <tr>                             
                              <td  width="20%" class=labelText>Pay Code</td>                              
                              <td >                                                                       
                              <html:text  property="txtPayCodeDesc"  maxlength="10" size="23" styleClass="required" readonly="true" onchange="enableITDed(); chkvldn();" />
                              <logic:equal name="frmPayOverAbove" property="screenMode" value="N">
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowPayCodeNew()"  >
                               </logic:equal>
                              </td> 
                              
                               <td  width="20%" class=labelText>Agency Code</td>                              
                              <td >                                                                       
                              <html:text  property="txtAgencyCodeDesc"  maxlength="10" size="23" styleClass="optional" readonly="true" onchange="enableITDed();" />
                              <logic:equal name="frmPayOverAbove" property="screenMode" value="N">
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowAgencyCode();">
                               </logic:equal>
                              </td> 
                              
                              <tr> 
                               <td  width="20%" class=labelText>Agency Site Code</td>                              
                              <td >                                                                       
                              <html:text  property="txtAgencySiteCodeDesc"  maxlength="10" size="23" styleClass="optional" readonly="true" onchange="enableITDed();" />
                              <logic:equal name="frmPayOverAbove" property="screenMode" value="N">
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowAgencySiteCode();">
                               </logic:equal>
                              </td> 
                              
                              <td  width="22%" class=labelText>Application Date</td>
                              <td width="28%"><html:text  property="txtApplnDt" disabled="true" readonly="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" />
                              <logic:equal name="frmPayOverAbove" property="screenMode" value="N">
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" alt="<%=(i-1) %>" onclick="showCalendar('txtApplnDt',this)" /></td>   </logic:equal>
                            </tr>
                            
                            <TR> 
                              <td  width="15%" class=labelText>Sanction Date</td>
                              <td ><html:text  property="txtSnctnDt"  disabled="true" readonly="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="chkSanctionDt()" />
                              <logic:equal name="frmPayOverAbove" property="screenMode" value="N">
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" alt="<%=(i-1) %>" onclick="showCalendar('txtSnctnDt',this)" /></td>                                                                         
                              </logic:equal>
                              
                              <td  width="15%" class=labelText>Sanctioned Amount</td>                              
                              <td >
							  <logic:equal name="frmPayOverAbove" property="screenMode" value="N">
							  <html:text  property="txtSnctnAmnt"  styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="5" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" size="23" onchange="calcAmt()" />
							  </logic:equal>
							  <logic:notEqual name="frmPayOverAbove" property="screenMode" value="N">
							  <html:text  property="txtSnctnAmnt"  styleClass = "locked" readonly="true" altKey="Payroll.EmpInfo.PermState" maxlength="5" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" size="23" onchange="calcAmt()" />
							  </logic:notEqual>
							  </td>                                                                       
                              
                            </tr>
                            
                             <tr>                             
                              <td  width="15%" class=labelText>Invoice No.</td>                              
                              <td ><html:text  property="txtInvoceId" disabled="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" style="text-align:right" size="23" /></td>                                                                       
                                                                                                                                   
                            </tr> 
                            
                          <TR height="10">
                            <TD class=subHeader colspan=6> Deductions</TD>
                          </TR>
              
                          <TR >
                            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                          </TR>
                          
                          <TR height="15">
                            <TD class=subHeader colspan=6></TD>
                          </TR>
                           <tr>
                            
                          <tr>
                              
                              <td  width="15%" class=labelText align="left" >IT Deductions</td>
                              <td >                              
                              <html:text  property="txtDedIT" styleClass = "optional" disabled="true" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" onchange="calcAmt()"  /></td>                                                                       
                              
                              <td  width="20%" class=labelText align="left" >Net Amount Payable</td>
                              <td ><html:text  property="txtNetAmt"  styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" readonly="true"/></td>                                                                       
                              
                        </tr>
                        
                        <TR height="15">
                            <TD class=subHeader colspan=6></TD>
                          </TR>
                                                      
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
      <td align=center bgcolor=#4682b4 width="45%"></td>      
	  <logic:equal name="frmPayOverAbove" property="screenMode" value="U" >
      <logic:equal name= "frmPayOverAbove"  property = "txtInvoceId" value = "" > 
      <td  bgcolor=#4682b4>
      <html:button property="butInv" value="Send Invoice" onclick="sendInv()" /> <!--added by sonia on 31-08-2011-->
        <html:button value="Delete Record" property="butInv" onclick="DelRecord()"  /></td>
      </logic:equal>
      <logic:notEqual name= "frmPayOverAbove"  property = "txtInvoceId" value = "" >
      <td  bgcolor=#4682b4>
      <html:button property="butInv" value="Send Invoice" disabled="true" /> <!--added by sonia on 31-08-2011-->
        <html:button value="Delete Record" property="butInv" onclick="DelRecord()" disabled="true" /> </td>
      </logic:notEqual>     
	  </logic:equal><!-- by sonia on 31-08-2011 -->
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
<html:hidden name="frmPayOverAbove"  property="screenName" value="PayOverAboveScreen" />
<html:hidden property="loginLocCode" name="frmPayOverAbove"  />
<html:hidden name="frmPayOverAbove"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmPayOverAbove" />
<html:hidden property="positionRequested" name="frmPayOverAbove" />
<html:hidden property="userPositionRequested" name="frmPayOverAbove" />
<html:hidden property="buttonFlag" name="frmPayOverAbove"  />
<html:hidden property="lovKey" name="frmPayOverAbove"  />
<html:hidden property="txtFields" name="frmPayOverAbove"  />   
<html:hidden property="txtSearchFields" name="frmPayOverAbove"  />
<html:hidden property="txtDisplayFields" name="frmPayOverAbove"  />
<html:hidden property="txtIndex" name="frmPayOverAbove"  />
<html:hidden property="txtInputField" name="frmPayOverAbove"  />
<html:hidden property="txtPayScaleType" name="frmPayOverAbove"  />
<html:hidden property="hdnFlagIT" name="frmPayOverAbove"  />
<html:hidden property="payCodeTaxInd" name="frmPayOverAbove"  />
<html:hidden property="txtPayCode" name="frmPayOverAbove"  />
<html:hidden property="txtAgencyCode" name="frmPayOverAbove"  />
<html:hidden property="txtAgencySiteCode" name="frmPayOverAbove"  />
<html:hidden property="hdnCpfDed" name="frmPayOverAbove"  />
<html:hidden property="chkCpfDed" name="frmPayOverAbove"  />
<html:hidden property="txtCpfEmpCntrb" name="frmPayOverAbove"  />
<html:hidden property="txtCpfEmplyrCntrb" name="frmPayOverAbove"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">
function ShowEmpNum()
{
    frmPayOverAbove.lovKey.value = "PayOverAboveEmp" + frmPayOverAbove.screenName.value + frmPayOverAbove.screenMode.value;
    frmPayOverAbove.queryParam.value = "txtSiteID="+frmPayOverAbove.loginLocCode.value+",hdnEmpLbrFlag="+frmPayOverAbove.hdnEmpLbrFlag.value;
    if(frmPayOverAbove.screenMode.value == 'N')
    {
        frmPayOverAbove.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtDOJSite,txtEmpStatus,txtCurrBas";    
        frmPayOverAbove.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
        frmPayOverAbove.txtInputField.value ="txtEmpNo"; 
        frmPayOverAbove.txtIndex.value ="";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPayOverAbove');
    }
    if(frmPayOverAbove.screenMode.value == 'Q')
    {
        frmPayOverAbove.txtDisplayFields.value = "txtEmpNo,txtEmpName";
        frmPayOverAbove.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
        frmPayOverAbove.txtIndex.value ="";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPayOverAbove');
    }   
    return true;
}   

function ShowPayCodeNew()
{
  //  alert(+frmPayOverAbove.screenMode.value);
    frmPayOverAbove.lovKey.value = "PayOverAbovePayCode" + frmPayOverAbove.screenName.value + frmPayOverAbove.screenMode.value;   
	frmPayOverAbove.queryParam.value = "hdnEmpLbrFlag="+frmPayOverAbove.hdnEmpLbrFlag.value+",screenName="+frmPayOverAbove.screenName.value+",screenMode="+frmPayOverAbove.screenMode.value+",txtSiteID="+frmPayOverAbove.loginLocCode.value+",txtEmpNo="+frmPayOverAbove.txtEmpNo.value;;

    frmPayOverAbove.txtDisplayFields.value = "txtPayCode,txtPayCodeDesc,payCodeTaxInd";      
    frmPayOverAbove.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";    
    frmPayOverAbove.txtInputField.value ="txtPayCodeDesc"; 
    frmPayOverAbove.txtIndex.value ="";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPayOverAbove');
    
  
    return true;
    
} 


function ShowAgencyCode()
{
if(document.all.txtPayCode.value ==191 )
{
    frmPayOverAbove.lovKey.value = "PayOverAboveAgencyCode" + frmPayOverAbove.screenName.value + frmPayOverAbove.screenMode.value;   
  //  frmPayOverAbove.queryParam.value="hdnEmpLbrFlag="+frmPayOverAbove.hdnEmpLbrFlag.value+" " ;
    frmPayOverAbove.txtDisplayFields.value = "txtAgencyCode,txtAgencyCodeDesc";      
    frmPayOverAbove.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Agency,Payroll.Common.Desc";    
    frmPayOverAbove.txtInputField.value ="txtAgencyCodeDesc"; 
    
   // frmPayOverAbove.txtIndex.value ="";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPayOverAbove');
    return true;
}
else
{
  alert('Agency Code is Only for Third Party Lease Payment');
  return;
}
}


function ShowAgencySiteCode()
{
if(document.all.txtPayCode.value ==191 )
{
    frmPayOverAbove.lovKey.value = "PayOverAboveAgencySiteCode" + frmPayOverAbove.screenName.value + frmPayOverAbove.screenMode.value;   
  // frmPayOverAbove.queryParam.value="hdnEmpLbrFlag="+frmPayOverAbove.hdnEmpLbrFlag.value+" " ;
    frmPayOverAbove.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySiteCodeDesc";      
    frmPayOverAbove.txtSearchFields.value = "";    
    frmPayOverAbove.txtInputField.value ="txtAgencySiteCodeDesc"; 
   if(document.all.txtAgencyCode.value!="" )
   {
   frmPayOverAbove.queryParam.value ="txtAgencyCode="+document.all.txtAgencyCode.value;
   }
   else
   {
   alert("Please Select the Agency first");
   return;
   }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmPayOverAbove');
    return true;
}
else
{
  alert('Agency Code is Only for Third Party Lease Payment');
  return;
}
}

function lfnLoad()
{   
    mode = document.all.screenMode.value;
    //alert(document.all.screenMode.value);
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='N')
    {        

        document.all.txtApplnDt.disabled = "";
        document.all.txtSnctnDt.disabled = "";   
		
		document.all.txtDedIT.disabled = "";
        if(document.all.hdnFlagIT.value=='N')
        {
            document.all.txtDedIT.disabled = "";
        }
        //document.all.butInv.disabled = "true"; 
    }
    hedMenuHandling(mode);
}

function SaveRecord()
{
   document.all.chkCpfDed.checked = 'N';
   if(document.all.txtPayCode.value==191)
   {
      if(document.all.txtAgencyCode.value == '' || document.all.txtAgencySiteCode.value == '')
      {
        alert('Please enter AgencyCode & AgencySite Code');
        return true;
      } 
   }
    document.all.buttonFlag.value='';
    if(document.all.txtInvoceId.value=='')
    {
      if(mandatory_Check("frmPayOverAbove"))
      {    calcAmt();
          frmPayOverAbove.detailDataChanged.value = "false";  
          //if(frmPayOverAbove.screenMode.value == "N")
            frmPayOverAbove.headerDataChanged.value = "true";             
          frmPayOverAbove.headerFields.value = "true";             
          document.all.txtNetAmt.disabled="";
          document.all.txtDedIT.disabled="";
          document.all.txtNetAmt.value = parseInt(document.all.txtSnctnAmnt.value - document.all.txtDedIT.value);
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
          frmPayOverAbove.action = "../../../PayOverAboveSaveAction.do";            
          frmPayOverAbove.submit();
      }
      else
      {
          return false;
      }
    }   
      
}

function lfnChanged(val)
{
    frmPayOverAbove.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmPayOverAbove.action="../../../PayOverAboveFirstGetHeaderAction.do"
    frmPayOverAbove.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmPayOverAbove.userPositionRequested.value = 1*frmPayOverAbove.positionRequested.value + 1;
    frmPayOverAbove.action="../../../PayOverAboveGetNextHeader.do";
    frmPayOverAbove.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmPayOverAbove.userPositionRequested.value = 1*frmPayOverAbove.positionRequested.value - 1;
    frmPayOverAbove.action = "../../../PayOverAboveGetNextHeader.do";
    frmPayOverAbove.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmPayOverAbove.userPositionRequested.value = 1*frmPayOverAbove.newPositionRequested.value;
    frmPayOverAbove.action = "../../../PayOverAboveGetNextHeader.do";
    frmPayOverAbove.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmPayOverAbove.action="../../../PayOverAboveNewMode.do"
    frmPayOverAbove.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';    
    frmPayOverAbove.action="../../../PayOverAboveQueryMode.do"
    frmPayOverAbove.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmPayOverAbove.action="../../../PayOverAboveRefresh.do"
    frmPayOverAbove.submit();
}

function sendInv()
{
	document.getElementById("butInv").disabled="true";
    frmPayOverAbove.action="../../../PayOverAboveSendInvAction.do"
    frmPayOverAbove.submit();
}

function chk_YearMonth(val)
{
    var  yearM = val;          
    var month =  yearM.substring(4,6);                                 
    if (yearM.length != 6)
    {
        alert(" Year Month should be a Six digit Number");             
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;   
        return false;
    }
    else if(month < 1 || month > 12)
    {
        alert("  Month should be Within 1 to 12");                   
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

/*function calcAmt()
{
    if(chkSelEL())
    {
      /*var itDed=document.all.txtDedIT.value==""?"0":document.all.txtDedIT.value;
      var othrDed=document.all.txtDedOthr.value==""?"0":document.all.txtDedOthr.value;
      document.all.txtEncshAmt.value = parseInt(document.all.txtEL.value * document.all.hdnDayWage.value);
      document.all.txtCpfEmpCntrb.value=Math.round(document.all.txtEncshAmt.value*parseFloat(document.all.hdnCpfDed.value)/100);
      document.all.txtCpfEmplyrCntrb.value=document.all.txtCpfEmpCntrb.value;
      document.all.txtNetAmt.value=parseInt(document.all.txtEncshAmt.value-document.all.txtCpfEmpCntrb.value-itDed-othrDed);
      document.all.txtDedOthr.value=othrDed;
      document.all.buttonFlag.value=''; 
      document.all.txtCpfEmpCntrb.disabled="";
      document.all.txtEncshAmt.disabled="";
      document.all.txtNetAmt.disabled="";
      frmPayOverAbove.action="../../../LeaveEncashCalcITDed.do"
      frmPayOverAbove.submit();
    }
    else
    {
    }
}
*/
function chkSanctionDt()
{
    var sanctionDt=document.all.txtSnctnDt.value;
    var applnDt=document.all.txtApplnDt.value;    
    if(!cmpSysDate(sanctionDt,0))
    { 
        document.all.txtSnctnDt.value="";
        return false;
    }
    if (!cmpDate(applnDt,sanctionDt,0))
    {
        alert("Application Date cannot be greater than Sanction Date");
        document.all.txtSnctnDt.value="";
        return false;                      
    }
}

function enableITDed()
{       
    if(document.all.hdnFlagIT.value=='Y')        
    {
        document.all.txtDedIT.disabled = "true";        
        document.all.txtDedIT.style.background="#e0e0e0";
        document.all.txtDedIT.style.className="locked";                
    }    
    else
    {
        document.all.txtDedIT.style.background="#ffffff";
        document.all.txtDedIT.style.className="optional";
        document.all.txtDedIT.disabled="";
        if(document.all.payCodeTaxInd.value=="N")
        {
            document.all.txtDedIT.disabled = "true";        
            document.all.txtDedIT.style.background="#e0e0e0";
            document.all.txtDedIT.style.className="locked";         
        }
    }
    
}

function checkMonthITDed()
{   
    frmPayOverAbove.action="../../../PayOverAboveCalcITDed.do"
    frmPayOverAbove.submit();    
    
}

function onclickCheck(checkFlag,hdnFlag)
{
    //lfnChange('1');  
    if (document.getElementById(checkFlag).checked)
    {
        document.all.hdnCpfDed.value="Y";      
     
    }  
    else 
    {        
        document.all.hdnCpfDed.value="N";      
    }
    
}
 
function chkvldn()
{
 // alert('Paycode '+document.all.txtPayCode.value);


if(document.all.txtPayCode.value == 191)
  {
    document.getElementById("txtAgencyCodeDesc").disabled = "";
    document.getElementById("txtAgencyCodeDesc").style.background="#ffffd3";
    document.getElementById("txtAgencyCodeDesc").style.className="required";
    
    document.getElementById("txtAgencySiteCodeDesc").disabled = "";
    document.getElementById("txtAgencySiteCodeDesc").style.background="#ffffd3";
    document.getElementById("txtAgencySiteCodeDesc").style.className="required";
  }
else
  {
    document.getElementById("txtAgencyCodeDesc").disabled = "true";
    document.getElementById("txtAgencyCodeDesc").style.background="#e0e0e0";
    document.getElementById("txtAgencyCodeDesc").style.className="locked";
    
    document.getElementById("txtAgencySiteCodeDesc").disabled = "true";
    document.getElementById("txtAgencySiteCodeDesc").style.background="#e0e0e0";
    document.getElementById("txtAgencySiteCodeDesc").style.className="locked";
  }
}


function calcAmt()
{   
   
    if(parseInt(document.all.txtSnctnAmnt.value )==0)
    {
        alert("Sanction Amount can't be 0");
        document.all.txtNetAmt.value = parseInt(document.all.txtSnctnAmnt.value );
        document.all.txtSnctnAmnt.value="";
        document.all.txtDedIT.value="";
        document.all.txtSnctnAmnt.focus();
        return false;
    }
    if(document.all.txtDedIT.value==0){
	document.all.txtNetAmt.value = parseInt(document.all.txtSnctnAmnt.value );
	}
	else{
     document.all.txtNetAmt.value = parseInt(document.all.txtSnctnAmnt.value - document.all.txtDedIT.value);
	}
      
    
}

function DelRecord()
{ 
	//alert("deleting Record...");
  if(document.all.txtEmpNo.value=='')
  {
    alert("Please Select a record first!!");
    return false;
  }
  if(document.all.txtInvoceId.value!='')
  {
    alert("Invoice created. Record cannot be deleted now ");
    return false;  
  }
  frmPayOverAbove.action="../../../PayOverAboveDelRecord.do?param1=ovrNabv"
  frmPayOverAbove.submit();
}

function chkSanctionDt()
{
  var sanctionDt=document.all.txtSnctnDt.value;
  var applnDt=document.all.txtApplnDt.value;
 
    if(sanctionDt != "")
	{
	  if(!cmpSysDate(sanctionDt,0))
	  { 
		  document.all.txtSnctnDt.value="";
		  return false;
	  }
	  if (!cmpDate(applnDt,sanctionDt,0))
	  {
		alert("Application Date cannot be greater than Sanction Date");
		document.all.txtSnctnDt.value="";
		return false;                      
	  }
	}
}

</script>