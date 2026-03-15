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
                     <td ><html:text  property="txtEmpNo" altKey="pay.ComFinalSet.txtEmpNo" maxlength="10" size="23" styleClass="required"  readonly = "true"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="doPopulateLov('txtEmpNo')">&nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.ComFinalSet.txtEmpName" maxlength="10" size="26" styleClass="locked" /></td>
                     
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
        

        </div> 




    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 border = 0>              
                <TR >
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('cal');" > Final Settlement Parameters <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText> Final Settlement Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td width="10"><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                     <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('final');" > Payment Detials <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>


                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 <TR height=10>
                	<!-- Detail table Container starts -->
                <TD colspan="11">
                
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TR>
                      <TD ></td>
                      <TD width =50%>
                      <table cellspacing=0 cellpadding=0 border=0 width = 100%>
                      <TR>
                      <td align = top>                      
                            <TABLE cellSpacing="0" cellPadding="0" border = 0 style="BORDER-LEFT: #4682b4 thin solid; BORDER-BOTTOM: #4682b4 thin solid;BORDER-top: #4682b4 thin solid;">                      
                            <tr height = 33><td>&nbsp;</td></tr>                                                                                   

                              <TR>                            
                              <td width = 5%></td>
                              <td  width="40%" class=labelText><bean:message key="pay.ComFinalSet.txtorgNormpension" /></td>
                              <td width = 55%><html:text  property="txtOrgPenAm" styleClass="optional" altKey="pay.ComFinalSet.txtorgNormpension" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>
                             </tr>

                              <TR>                            
                              <td width = 5%></td>
                              <td  width="40%" class=labelText><bean:message key="pay.ComFinalSet.txtorgFampension" /></td>
                              <td width = 55%><html:text  property="txtOrgFamPenAm" styleClass="optional" altKey="pay.ComFinalSet.txtorgFampension" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>
                             </tr>

                              <TR>                            
                              <td width = 5%></td>
                              <td  width="40%" class=labelText><bean:message key="pay.ComFinalSet.txtorgEnFampension" /></td>
                              <td width = 55%><html:text  property="txtOrgEnFamPenAm" styleClass="optional" altKey="pay.ComFinalSet.txtorgEnFampension" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>
                             </tr>
                             
                              <TR>                            
                              <td width="5%"></td>
                              <td  width="40%" class=labelText><bean:message key="pay.ComFinalSet.txtNetCom" /></td>
                              <td width = 55%><html:text  property="txtNetCom" styleClass="optional" altKey="pay.ComFinalSet.txtNetCom" maxlength="10" size="23" onchange="lfnHeaderChange();"  readonly="true" /></td>
                             </tr>
                             <tr>
                            

                             <TR>                            
                              <td width = 5%></td>
                              <td  width="40%" class=labelText><bean:message key="pay.ComFinalSet.txtmoncom" /></td>
                              <td width = 55%><html:text  property="txtMthComValue" styleClass="optional" altKey="pay.ComFinalSet.txtmoncom" maxlength="10" size="23" onchange="lfnHeaderChange();"  readonly="true" /></td>
                             </tr>
                             

                              <TR>                            
                              <td width = 5%></td>
                              <td  width="40%" class=labelText><bean:message key="pay.ComFinalSet.txtredmon" /></td>
                              <td width = 55%><html:text  property="txtRedMonPen" styleClass="optional" altKey="pay.ComFinalSet.txtredmon" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>
                             </tr>
                             

                             <TR>                            
                              <td width = 5%></td>
                              <td  width="40%" class=labelText><bean:message key="pay.ComFinalSet.txtTmon" /></td>
                              <td width = 55%><html:text  property="txtTmon" styleClass="optional" altKey="pay.ComFinalSet.txtTmon" maxlength="10" size="23" onchange="lfnHeaderChange();"  readonly="true" /></td>
                             </tr>
                            <tr height = 35><td>&nbsp;</td></tr>                                                       
                          </table> 
                          


                     </td></tr> 
                     </TABLE>
                      </td>

  <td width = 50%>
    <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TR>
                     
                      <TD width =50%>
                     <TABLE cellSpacing="0" cellPadding="0" border = 0 style="BORDER-RIGHT: #4682b4 thin solid; BORDER-LEFT: #4682b4 thin solid; BORDER-BOTTOM: #4682b4 thin solid;BORDER-top: #4682b4 thin solid;">
                             <tr height = 48><td>&nbsp;</td></tr> 

                          <TR>                            
                              <td width = 5%></td>
                              <td  width="60%" class=labelText><bean:message key="pay.ComFinalSet.gratuity" /></td>
                              <td width = 65%><html:text  property="txtGratuity" styleClass="optional" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="lfnHeaderChange();" readonly="true" /></td>
                             </tr>
                             

                             <TR>                            
                              <td width = 5%></td>
                              <td  width="60%" class=labelText><bean:message key="pay.ComFinalSet.leave" /></td>
                              <td width = 65%><html:text  property="txtLeave" styleClass="optional" altKey="pay.ComFinalSet.leave" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>
                             </tr>
                           

                              <TR>                            
                              <td width = 5%></td>
                              <td  width="60%" class=labelText><bean:message key="pay.ComFinalSet.pfsettle" /></td>
                              <td width = 65%><html:text  property="txtPFSettle" styleClass="optional" altKey="pay.ComFinalSet.pfsettle" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>
                             </tr>
                            

                             <TR>                            
                              <td width = 5%></td>
                              <td  width="60%" class=labelText><bean:message key="pay.ComFinalSet.Gis" /></td>
                              <td width = 65%><html:text  property="txtGIS" styleClass="optional" altKey="pay.ComFinalSet.Gis" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>
                             </tr>
                           <tr height = 48><td>&nbsp;</td></tr>                                   
                      </table> 
 </td>
</tr>
</TBODY>
</TABLE>
                     
                   </TD>
                   <TD width = 30%></td>                   
                  </TR>                     
                    <tr height = 2><td></td></tr>                  
        		    </TABLE>
                   
   
          <TR>
          <TD colspan=6 ></TD>
          </TR> 
        


   <TD colspan="11">
                
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TR>
                      <TD width =50%></td>
                      <TD width =50%>
                      <table cellspacing=0 cellpadding=0 border=0 width = 100%>
                     
                     </TABLE>
                          </td>


                
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
    
</TABLE>
        </td>
	</tr>
  
     <!-- Tab Ta  ble Ends -->
     </table>
     <table cellspacing="0" cellpadding="0" border="0">
                <tr height = 5><td>&nbsp;</td></tr>
                <!-- Bottom Blue Bar -->
             <TR>
                      <!--<td width=15% colspan =8 align=left bgColor=#4682b4></td>-->
                     
                      <td align="center" bgColor=#4682b4>
                      <button  alt="Pension (Alt+P)"  onclick="doCompute('PEN')" name="butPension" class="bottomBarText">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Pension &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </button>
                      <button  alt="Gratuity (Alt+G)"  onclick="doCompute('GRA')" name="butGratuity" class="bottomBarText">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;Gratuity &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</button>
                      <button  alt="Approve (Alt+L)"  onclick="doCompute('LEAVE')" name="butLeave" class="bottomBarText">Leave Encashment</button>
                      <button  alt="Pf Settle (Alt+f)"  onclick="doCompute('Pf')" name="butPfSettle" class="bottomBarText"> &nbsp;&nbsp; PF Settlement&nbsp;&nbsp;  </button> 
                      <button  alt="GIS (Alt+I)"  onclick="doCompute('GIS')" name="butGIS" class="bottomBarText"> &nbsp; GIS Settlement &nbsp; </button></td>
                      <td><img src="../INCLUDES/IMAGES/man.jpg"></td>
                  
             </TR>
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>

<!-- Container Table Ends -->
<html:hidden name="frmComFinalSet"  property="screenName" value="ComFinalSetFinalScreen" />
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
<html:hidden property="headerDataChanged" name="frmComFinalSet"  />
<html:hidden property="loginLocCode" name="frmComFinalSet"  />
<input type="hidden" name="queryParam" >

</html:form>
</body>
</html:html>
<script language="javascript">
function doCompute(val)
{  
  var ac="../../../DoComputeAction.do?param1="+val+"&param2="+document.all.txtEmpNo.value;
  lfnHeaderChange();
  document.forms[0].action = ac;
  document.forms[0].submit();  
}
function doGetTab(arg)
{    
  document.all.forwardedPage.value=arg;
  document.all.flag.value='';
  document.forms[0].action="../../../FinalSetTabAction.do";
  
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
    document.all.butPension.disabled="true";
    document.all.butGratuity.disabled="true";
    document.all.butLeave.disabled="true";
    document.all.butPfSettle.disabled="true";
    document.all.butGIS.disabled="true";
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
  document.all.butDel.disabled="true";    
  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg"; 
  document.all.txtDate.disabled="true";
  document.all.buttxtdate.disabled="true";
  document.all.butInsertMode.disabled="true";    
  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  document.all.butDel.disabled="true";    
  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
}
function lfnHeaderChange()
{  
  frmComFinalSet.headerDataChanged.value = "true";  
}
function doQueryMode()
{
  frmComFinalSet.action="../../../ComFinalSetFinalQueryMode.do";
  document.all.flag.value='';
  frmComFinalSet.submit();
}  
function getHeaderRecord()
{
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmComFinalSet.action="../../../ComFinalSetFinalGetHeaderAction.do";
	document.all.flag.value='';  
	frmComFinalSet.submit();
}
function doPopulateLov(popupType, val)
{
  if(popupType == 'txtEmpNo')
  {    
    frmComFinalSet.lovKey.value = "ComFinalSetFinalEmpNo" + frmComFinalSet.screenName.value + frmComFinalSet.screenMode.value;
    frmComFinalSet.txtDisplayFields.value = "txtEmpNo,txtEmpName";
    frmComFinalSet.queryParam.value="txtSiteID="+frmComFinalSet.loginLocCode.value;
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
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmComFinalSet.action = "../../../ComFinalSetFinalSaveAction.do";
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
  frmComFinalSet.action="../../../ComFinalSetFinalRefresh.do"
  frmComFinalSet.submit();
}
function doGetNextHeader()
{ 
    frmComFinalSet.userPositionRequested.value = 1*(frmComFinalSet.positionRequested.value) + 1;  
    frmComFinalSet.action="../../../ComFinalSetFinalGetNextHeader.do";
    frmComFinalSet.submit();
}
function PrevHeader()
{
  frmComFinalSet.flag.value = "false";
  frmComFinalSet.userPositionRequested.value = frmComFinalSet.positionRequested.value - 1;
  frmComFinalSet.action = "../../../ComFinalSetFinalGetNextHeader.do";
  frmComFinalSet.submit();
}
function JumpHeader()
{
  frmComFinalSet.flag.value = "false";
  frmComFinalSet.userPositionRequested.value = 1*frmComFinalSet.newPositionRequested.value;
  frmComFinalSet.action = "../../../ComFinalSetFinalGetNextHeader.do";
  frmComFinalSet.submit();
}
</script>  