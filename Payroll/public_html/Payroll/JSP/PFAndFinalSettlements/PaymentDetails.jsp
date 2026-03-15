<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>        
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />



<html:form  action="ComFinalSet" name="frmComFinalSet" type="FCIPAY.Payroll.WEBTIER.Form.ComFinalSetForm" scope="session">

 <bean:define id="ParentForm" name="frmComFinalSet" toScope="request" />
 <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<table>
    <TR height=30>
         <TD  colSpan=11 class=mainHeader height=10>COMPUTE FINAL SETTLEMENT</TD>
    </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>  
   <TR>
    <TD>

 <!-- <div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--pay Scale Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Compute Final Settlement Detail</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="6"></td>
            </tr>
                  <TR>
                
                     <TD class=labelText width="15%" ><bean:message key="pay.ComFinalSet.txtEmpNo" /></td>
                     <td ><html:text  property="txtEmpNo" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" size="23" styleClass="required" readonly = "true" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="doPopulateLov('txtEmpNo')">&nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.ComFinalSet.txtEmpName" maxlength="10" size="26" styleClass="locked" /></td>
                     
                   </tr> 
          
                 <tr>
                       <td class=labelText width="15%" ><bean:message key="pay.ComFinalSet.txtpension" /></td>
                       <td><html:select property="lstPension" alt="Type" styleClass="required" >
                            <html:option value="" ><bean:message   key="pay.ComFinalSet.pleaseSelect" /></html:option>      
                            <html:option value="FP" > <bean:message key="pay.ComFinalSet.f" /></html:option>
                            <html:option value="NP" > <bean:message key="pay.ComFinalSet.n" /></html:option>
                            <html:option value="NA" > <bean:message key="pay.ComFinalSet.na" /></html:option>                            
                            </html:select></td>
                       <TD class=labelText width="15%" ><bean:message key="pay.ComFinalSet.txtdate" /></td>
                       <td ><html:text  property="txtDate" altKey="pay.ComFinalSet.txtdate" maxlength="10" size="23" styleClass="required" /><img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxtdate" onclick="showCalendar('txtdate',this)"  ></td>        
                    
                  </tr>

       <tr height="15" >
            <td colspan="6"></td>
            </tr>                              
         </table>

         
<table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR>
            <TD colspan=12>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0  border = 0>
 
              
                <TR>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('cal');" > Final Settlement Parameters <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('final');" > Final Settlement Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                     <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText  > Payment Detials <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                   

                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
              </table>
            </td>
          </tr>
      </table>

<TABLE cellSpacing="0" cellPadding="0" border = 0 >
  <TBODY>

                  
                  <tr>
                  <td>
                       <DIV id=divDtlTable style="height:273px" >
                        
                       <table borderColor="#76A2C7" border = 1 cellspacing = 0 cellpadding = 0>
                       
                           <TR >
                              <td class=tableHeader width="20%">Payment Header</td>
                              <td class=tableHeader width="20%"><bean:message key="pay.ComFinalSet.sanamt" /></td>
                              <td class=tableHeader width="20%"><bean:message key="pay.ComFinalSet.san" /></td>
                              <td class=tableHeader width="20%"><bean:message key="pay.ComFinalSet.paydone" /> </td>
                              <td class=tableHeader width="20%"><bean:message key="pay.ComFinalSet.history" /> </td>
                           </tr> 
                           <TR height="10">
                              <td align="center" class=labelLeftAlign width="20%"><b>Pension</b></td>
                              <td class=labelText width="20%"><html:text onchange="lfnHeaderChange(this);" property="txtPenSancAmt" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width=100%;text-align:right' styleClass="required" /></td>
                              <td align="center" width="20%">                              
                             <logic:equal name="frmComFinalSet" property="hdnPenFlag" value="1" >
                             <input type="checkbox" name="penFlag" checked="true" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:equal>
                             <logic:notEqual name="frmComFinalSet" property="hdnPenFlag" value="1" >
                             <input type="checkbox" name="penFlag" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:notEqual>
                              </td>
                              <td class=labelText width="20%"><html:text  property="txtPenPaidAmt" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width:100%;text-align:right' styleClass="required" /> </td>
                              <td class=labelText width="20%"><html:button value='Payment History' onclick="openHistory('1')"  property="butPayment" styleClass="bottomBarText"  /></td>                             

                           </tr> 
                           <TR>
                              <td align="center" class=labelLeftAlign width="20%"><b>Gratuity</b></td>
                              <td class=labelText width="20%"><html:text  property="txtGraSancAmt" onchange="lfnHeaderChange(this);" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width=100%;text-align:right' styleClass="required" /></td>                              
                              <td align="center" width="20%">                                                        
                             <logic:equal name="frmComFinalSet" property="hdnGraFlag" value="1" >
                             <input type="checkbox" name="graFlag" checked="true" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:equal>
                             <logic:notEqual name="frmComFinalSet" property="hdnGraFlag" value="1" >
                             <input type="checkbox" name="graFlag" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:notEqual>
                              </td>
                              <td class=labelText width="20%"><html:text  property="txtGraPaidAmt" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width:100%;text-align:right' styleClass="required" /> </td>
                              <td class=labelText width="20%"><html:button value='Payment History' onclick="openHistory('2')"  property="butPayment" styleClass="bottomBarText"  /></td>
                           </tr> 
                           <TR>
                              <td align="center" class=labelLeftAlign width="20%"><b>Leave Encashment</b></td>
                              <td class=labelText width="20%"><html:text  property="txtLeaveSancAmt" onchange="lfnHeaderChange(this);" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width=100%;text-align:right' styleClass="required" /></td>
                              <td align="center" width="20%">                                                        
                             <logic:equal name="frmComFinalSet" property="hdnLeaveFlag" value="1" >
                             <input type="checkbox" name="leaveFlag" checked="true" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:equal>
                             <logic:notEqual name="frmComFinalSet" property="hdnLeaveFlag" value="1" >
                             <input type="checkbox" name="leaveFlag" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:notEqual>
                              </td>
                              <td class=labelText width="20%"><html:text  property="txtLeavePaidAmt" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width:100%;text-align:right' styleClass="required" /> </td>
                              <td class=labelText width="20%"><html:button value='Payment History' onclick="openHistory('3')"  property="butPayment" styleClass="bottomBarText"  /></td>
                           </tr> 
                           <TR>
                              <td align="center" class=labelLeftAlign width="20%"><b>PF Settlement</b></td>
                              <td class=labelText width="20%"><html:text  property="txtPFSettleSancAmt" onchange="lfnHeaderChange(this);"  altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width=100%;text-align:right' styleClass="required" /></td>
                              <td align="center" width="20%">                              
                             <logic:equal name="frmComFinalSet" property="hdnPfFlag" value="1" >
                             <input type="checkbox" name="pfSettleFlag" checked="true" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:equal>
                             <logic:notEqual name="frmComFinalSet" property="hdnPfFlag" value="1" >
                             <input type="checkbox" name="pfSettleFlag" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:notEqual>
                              </td>
                              <td class=labelText width="20%"><html:text  property="txtPFSettlePaidAmt" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width:100%;text-align:right' styleClass="required" /> </td>
                              <td class=labelText width="20%"><html:button value='Payment History' onclick="openHistory('4')"  property="butPayment" styleClass="bottomBarText"  /></td>
                           </tr> 
                           <TR>
                              <td align="center" class=labelLeftAlign width="20%"><b>GIS Settlement</b></td>
                              <td class=labelText width="20%"><html:text  property="txtGISSancAmt" onchange="lfnHeaderChange(this);" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width=100%;text-align:right' styleClass="required" /></td>                              
                              <td align="center" width="20%">
                                                            
                             <logic:equal name="frmComFinalSet" property="hdnGISFlag" value="1" >
                             <input type="checkbox" name="gisFlag" checked="true" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:equal>
                             <logic:notEqual name="frmComFinalSet" property="hdnGISFlag" value="1" >
                             <input type="checkbox" name="gisFlag" onclick="frmComFinalSet.headerDataChanged.value='true';" />
                             </logic:notEqual>
                              </td>
                              <td class=labelText width="20%"><html:text  property="txtGISPaidAmt" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" style='width:100%;text-align:right' styleClass="required" /> </td>
                              <td class=labelText width="20%"><html:button value='Payment History' onclick="openHistory('5')"  property="butPayment" styleClass="bottomBarText"  /></td>
                           </tr> 
                          <table>
                        </div>
                   </td>
                   </tr>
                                                                                                  
                           <tr height=28></tr>
                       <!--</table>-->   

                       <TR>
               
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	
  </TABLE>

 
<!-- Container Table Ends -->
<html:hidden name="frmComFinalSet"  property="screenName" value="ComFinalPaymentDtlScreen" />
<html:hidden name="frmComFinalSet"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmComFinalSet" />
<html:hidden property="buttonFlag" name="frmComFinalSet"  />
<html:hidden property="flag" name="frmComFinalSet"  />
<html:hidden property="totalDetailRecord" name="frmComFinalSet" />
<html:hidden property="headerPrimaryKey" name="frmComFinalSet" />
<html:hidden property="positionRequested" name="frmComFinalSet" />
<html:hidden property="userPositionRequested" name="frmComFinalSet" />
<html:hidden property="pageRequested" name="frmComFinalSet" />
<html:hidden property="userPageRequested" name="frmComFinalSet" />
<html:hidden property="lovKey" name="frmComFinalSet"  />
<html:hidden property="txtFields" name="frmComFinalSet"  />   
<html:hidden property="txtSearchFields" name="frmComFinalSet"  />
<html:hidden property="txtDisplayFields" name="frmComFinalSet"  />
<html:hidden property="txtIndex" name="frmComFinalSet"  />
<html:hidden property="headerDataChanged" name="frmComFinalSet" value="false" />
<html:hidden property="hdnHead" name="frmComFinalSet" />
<html:hidden property="hdnClick" name="frmComFinalSet" />
<html:hidden property="hdnComFlag" name="frmComFinalSet"  />
<html:hidden property="hdnPenFlag" name="frmComFinalSet" />
<html:hidden property="hdnGraFlag" name="frmComFinalSet" />
<html:hidden property="hdnLeaveFlag" name="frmComFinalSet" />
<html:hidden property="hdnPfFlag" name="frmComFinalSet" />
<html:hidden property="hdnGISFlag" name="frmComFinalSet" />



 </html:form>
</body>
</html:html>

<script language="javascript">
function openHistory(val)
{
  document.all.hdnClick.value = '0';
  document.all.hdnHead.value = val;
  var win = window.open('<html:rewrite page="/Payroll/JSP/PFAndFinalSettlements/HistoryDetails.jsp" />', 'historyInfo', 'menubar=no,scrollbars=no,toolbar=no,resizable=no', true );  
  win.resizeTo(screen.availWidth, screen.availHeight);
  win.moveTo(0, 0);
  return true;
}
function doGetTab(arg)
{    
  document.all.forwardedPage.value=arg;
  document.all.flag.value='';
  document.forms[0].action="../../../PaySetTabAction.do";
  
  document.forms[0].submit();
}


function lfnLoad()
{
  mode = document.all.screenMode.value;
  if(mode == '')
  {
    doQueryMode();
  }
  if(mode=='Q')
  {
    document.all.butPayment[0].disabled="true";
    document.all.butPayment[1].disabled="true";
    document.all.butPayment[2].disabled="true";
    document.all.butPayment[3].disabled="true";    
    document.all.butPayment[4].disabled="true";
  }
  if(mode=='U')
  {
    document.all.txtEmpNo.disabled="true";
    document.all.buttxtEmpNo.src = "../INCLUDES/IMAGES/lov_dis.jpg";
    document.all.buttxtEmpNo.disabled="true";
    document.all.lstPension.disabled="true";
  }
  hedMenuHandling(mode);
  document.all.butInsertMode.disabled="true";    
  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  /*document.all.txtOrgPenAm.disabled="true";
  document.all.txtNetCom.disabled="true";
  document.all.txtMthComValue.disabled="true";
  document.all.txtRedMonPen.disabled="true";
  document.all.txtTmon.disabled="true";
  document.all.txtGratuity.disabled="true";
  document.all.txtLeave.disabled="true";
  document.all.txtPFSettle.disabled="true";
  document.all.txtGIS.disabled="true";  */
  document.all.butDel.disabled="true";    
  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg"; 
  document.all.txtDate.disabled="true";
  document.all.buttxtdate.disabled="true";
}
function lfnHeaderChange(that)
{  
  if(num_Check(that.value,1))
  {
    frmComFinalSet.headerDataChanged.value = "true";  
    return true;
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;
  }
}
function doQueryMode()
{
  frmComFinalSet.action="../../../ComFinalSetPayQueryMode.do";
  document.all.flag.value='';
  frmComFinalSet.submit();
}  
function getHeaderRecord()
{
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmComFinalSet.action="../../../ComFinalSetPayGetHeaderAction.do";
	document.all.flag.value='';  
	frmComFinalSet.submit();
}
function doPopulateLov(popupType, val)
{
  if(popupType == 'txtEmpNo')
  {    
    frmComFinalSet.lovKey.value = "ComFinalSetPayEmpNo" + frmComFinalSet.screenName.value + frmComFinalSet.screenMode.value;
    frmComFinalSet.txtDisplayFields.value = "txtEmpNo,txtEmpName";
    frmComFinalSet.txtSearchFields.value = "pay.ComFinalSet.txtEmpNo,pay.ComFinalSet.txtEmpName";
    frmComFinalSet.txtIndex.value ="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmComFinalSet');
    return true;    
  }
}
function SaveRecord()
{
  if(mandatory_Check("frmComFinalSet"))
  {
      frmComFinalSet.headerPrimaryKey.value = document.all.txtEmpNo.value;   
      frmComFinalSet.buttonFlag.value='';
      if(document.all.gisFlag.checked==true)
      {
        document.all.hdnGISFlag.value="1";
      }
      else
      {
        document.all.hdnGISFlag.value="0";
      }
      if(document.all.pfSettleFlag.checked==true)
      {
        document.all.hdnPfFlag.value="1";
      }
      else
      {
        document.all.hdnPfFlag.value="0";
      }
      if(document.all.leaveFlag.checked==true)
      {
        document.all.hdnLeaveFlag.value="1";
      }
      else
      {
        document.all.hdnLeaveFlag.value="0";
      }
      if(document.all.graFlag.checked==true)
      {
        document.all.hdnGraFlag.value="1";
      }
      else
      {
        document.all.hdnGraFlag.value="0";
      }
      if(document.all.penFlag.checked==true)
      {
        document.all.hdnPenFlag.value="1";
      }
      else
      {
        document.all.hdnPenFlag.value="0";
      }
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmComFinalSet.action = "../../../ComFinalSetPaySaveAction.do";
        frmComFinalSet.submit();
  }
  else
  {
    return false;
  }
}
function doRefresh()
{  
  document.all.buttonFlag.value='';
  frmComFinalSet.action="../../../ComFinalSetPayRefresh.do"
  frmComFinalSet.submit();
}
function doGetNextHeader()
{ 
    frmComFinalSet.userPositionRequested.value = 1*(frmComFinalSet.positionRequested.value) + 1;  
    frmComFinalSet.action="../../../ComFinalSetPayGetNextHeader.do";
    frmComFinalSet.submit();
}
function PrevHeader()
{
  frmComFinalSet.flag.value = "false";
  frmComFinalSet.userPositionRequested.value = frmComFinalSet.positionRequested.value - 1;
  frmComFinalSet.action = "../../../ComFinalSetPayGetNextHeader.do";
  frmComFinalSet.submit();
}
function JumpHeader()
{
  frmComFinalSet.flag.value = "false";
  frmComFinalSet.userPositionRequested.value = 1*frmComFinalSet.newPositionRequested.value;
  frmComFinalSet.action = "../../../ComFinalSetPayGetNextHeader.do";
  frmComFinalSet.submit();
}
</script>
