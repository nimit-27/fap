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
  <html:form  action="MaintOTAPymnt" name="frmOTAPymntForm" type="FCIPAY.Payroll.WEBTIER.Form.OTAPymntForm">
  <bean:define id="ParentForm" name="frmOTAPymntForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>OTA PAYMENT</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
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
                  
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <logic:equal name="frmOTAPymntForm" property="screenMode" value="Q">
                    <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="optional" readonly="true"/>
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowDsgn();">
                  </logic:equal>
                  <logic:notEqual name="frmOTAPymntForm" property="screenMode" value="Q">
                    <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:notEqual>
                  <html:hidden name="frmOTAPymntForm" property="txtDsgnDesc" />
                  </td>
              </TR> 
              
              <TR>     
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/></td>                  
                    <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                  
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <logic:equal name="frmOTAPymntForm" property="screenMode" value="Q">
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="7" size="23" styleClass="optional" onkeypress="
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {
                      return false;
                    }; "  style="text-align:right"   />
                   </logic:equal>
                  <logic:notEqual name="frmOTAPymntForm" property="screenMode" value="Q">
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" readonly="true" maxlength="7" size="23" styleClass="locked" onkeypress="
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {
                      return false;
                    }; "  style="text-align:right"   />
                   </logic:notEqual> 
                    </td>                    
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
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text property="txtEmpStatus" name="frmOTAPymntForm" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23"  onchange="return lfnChanged(this.alt)" />
                  </td>             

              </tr>   
              
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.curbas" /> </td>                            
                  <td ><html:text property="txtCurrBas" name="frmOTAPymntForm" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23" onchange="return lfnChanged(this.alt)" />
                  </td>
                  <td width="15%" class=labelText  >&nbsp; </td>                            
                  <td >&nbsp;</td>
                  <td width="15%" class=labelText  >&nbsp; </td>                            
                  <td >&nbsp;</td>
              </tr>   
          
          <TR>
              <TD class=subHeader colspan=6> Overtime Header</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="6"></td>
            </tr>
             <tr>
                             <td  width="15%" class=labelText>Year Month (YYYYMM)</td>
                              <td ><html:text  property="txtYYMM" disabled="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="6" size="23" onchange="chk_YearMonth(this.value)" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " /></td>
                                      
                              <html:hidden property="txtPayModeType" />
                              
                              
                              <td  width="15%" class=labelText align="left" >IT Deductions</td>
                              <td >
                              <logic:equal name="frmOTAPymntForm" property="hdnFlagIT" value="Y">
                              <html:text  property="txtDedIT" styleClass = "optional"  disabled="false" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " onchange="calcTotal()" style="text-align:right" /></td>                                                                       
                             </logic:equal>
                             <logic:notEqual name="frmOTAPymntForm" property="hdnFlagIT" value="Y">
                              <html:text  property="txtDedIT" styleClass = "optional" disabled="false" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " onchange="calcTotal()" style="text-align:right" /></td>                                                                       
                             </logic:notEqual>
                             </td>
                             <html:hidden property="txtDedOthr" name="frmOTAPymntForm"  />
                             <td width="15%" class=labelText  >Net Amount </td>                            
                              <td ><html:text  property="txtNetAmt" readonly="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" style="text-align:right" /></td>
                            
                              </tr>
                           
                            <tr>
                              <td class=labelText width="15%" >Remarks</td>                              
                              <td ><html:textarea  property="txtRmrks" styleClass = "optional" altKey="Payroll.EmpInfo.PermState" cols="27" /></td>                                                                                                    
                              <td  width="15%" class=labelText align="left" >Invoice No.</td>
                              <td >
                                <html:text  property="txtInvId" readonly="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" style="text-align:right" />
                              </td>
                              <td  width="15%" class=labelText align="left" >Ceiling Applicable?</td>
                        
                              
                               <td colspan="1" >
                                <logic:notEqual property= "screenMode" name= "frmOTAPymntForm" value="U"> 
                                <html:select  property="ceilFlag" styleClass = "required" style="width:32%" onchange="" >                           
                                <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                                <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>                               
                                
                                </html:select>
                                </logic:notEqual>  
                                
                                <logic:equal property= "screenMode" name= "frmOTAPymntForm" value="U">
                                <html:select  property="ceilFlag" styleClass = "optional" style="width:32%" onchange="return lfnChanged(this.alt)" >                           
                                <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>                               
                                <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                                </html:select>
                                </logic:equal>
                                </td>
                              </tr>                         

            </table>     
          </tr>
                      <tr height="10">		    
              <TD colspan="2" > </TD>
            </tr>
  </table>

    <TABLE cellSpacing=0 cellPadding=0 border=0 >
      <TBODY>
        <TR>
          <TD>
            <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
              <TR height="200">
                <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
                  <TABLE cellSpacing=0 cellPadding=0 >
               
                  <TR>                                                
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > Payment Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("Ded") > Deduction Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                  </tr>      
                  
                    <TR height=10>
                   <!-- Detail table Container starts -->
                      <TD colspan=11>
                        <TABLE cellSpacing=0 cellPadding=0 border=0>
                          <TBODY>
                            <TR>
                              <TD >
                                <DIV id=divDtlTable style="height:175px" >
  		                        	<!-- Detail table starts -->
                                  <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                    <TBODY>
                                    <TR height=20>
                                      <td class=tableHeader width="1%"></td>
                                      <TD class=tableHeader width="12%">OTA Hrs</td>
                                      <TD class=tableHeader width="10%">OTA Rate</td>
                                      <TD class=tableHeader width="12%">Emoluments</td>
                                    </TR> 
                                    
                            <logic:iterate id="otaInfo" name="frmOTAPymntForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.OTAPymntBean" >
                              <% ++i; %>
                               <logic:notEqual name="otaInfo" property="status" value="D" >  
                                   <tr>
                                       <td ><html:checkbox property="checked"  onclick="checkRecord();" value="false" name="frmOTAPymntForm" /></td>
                                       
                                       <td ><html:text property="txtOTAHrs" name="otaInfo" size="5" styleClass="required" maxlength="9" onkeypress="if(( event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57) )return false;" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="calcAmt(this.alt); changed(this.alt)"  />
                                       </td>
                                       <td ><html:text property="txtOTARate" name="otaInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 && event.keyCode!=46 || event.keyCode > 57))return false;" onchange="calcAmt(this.alt); changed(this.alt)"  style="WIDTH: 100%;text-align:right" />
                                       </td>
                                       <td ><html:text property="txtEmolument" name="otaInfo" size="5" styleClass="optional" readonly="true" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  />
                                       </td>
                                       
                                        <html:hidden property="txtPayCode" name="otaInfo" />
                                        <html:hidden property="txtDesc" name="otaInfo" />
                                        <html:hidden property="txtAmt" name="otaInfo" />
                                      
                                       <html:hidden property="itemChecked" name="otaInfo" />
                                       <html:hidden property="status" name="otaInfo" />
                                       <html:hidden property="detailId" name="otaInfo" />
                                </tr>
                                 </logic:notEqual>
                                <logic:equal name="otaInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmOTAPymntForm" value="notchecked" /></td>                                      
                                       <td ><html:hidden property="txtOTARate" name="otaInfo" /></td>
                                       <td ><html:hidden property="txtOTAHrs" name="otaInfo" /></td>
                                       <td ><html:hidden property="txtEmolument" name="otaInfo" /></td> 
                                       
                                        <html:hidden property="txtPayCode" name="otaInfo" />
                                        <html:hidden property="txtDesc" name="otaInfo" />
                                        <html:hidden property="txtAmt" name="otaInfo" />
                                       <html:hidden property="itemChecked" name="otaInfo" />                                   
                                       <html:hidden property="status" name="otaInfo" />
                                       <html:hidden property="detailId" name="otaInfo" />
                                    </tr>
                                  </logic:equal>                                                                                                
                                </logic:iterate>                                    
                                    </TBODY>
                                  </TABLE>
                                </DIV>
                              </TD>
                            </TR>                     
                            <tr>
                              <td class=labelText align="left" colspan="11" >Gross Amount
                                <html:text  property="txtGrossAmt" readonly="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" style="text-align:right" />
                              </td>
                            </tr>       
                      <!-- Get details starts -->
                            <tr>
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
                                    <TR>
                                      <td colspan=11>	
                                        <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                                      </TD>                                  
                                    </TR>
                                  </TBODY>
                                </TABLE>
                              </TD>
                            </tr>
                          
                          </TBODY>
                        </TABLE>
                      </td>
                    </tr>
                  </TABLE>
                </td>
	            </tr>
                <!-- Tab Table Ends -->

                <!-- Bottom Blue Bar -->
              <TR>
                <td align=center bgcolor=#4682b4 width="40%"></td>
          <logic:equal name="frmOTAPymntForm" property="screenMode" value="U" >
          <logic:equal name="frmOTAPymntForm" property="txtInvId" value="" >

                <td  bgcolor=#4682b4><html:button property="butInv" value="Send Invoice" onclick="sendInv()" /><!--added by sonia on 31-08-2011-->
                <html:button value="Delete Record" property="butInv" onclick="DelRecord()"  /></td>
                <td bgColor=#4682b4></td>
				 </logic:equal>
            </logic:equal>


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
<html:hidden name="frmOTAPymntForm"  property="screenName" value="OTAPymntScreen" />
<html:hidden property="loginLocCode" name="frmOTAPymntForm"  />
<html:hidden name="frmOTAPymntForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmOTAPymntForm" />
<html:hidden property="positionRequested" name="frmOTAPymntForm" />
<html:hidden property="userPositionRequested" name="frmOTAPymntForm" />
<html:hidden property="pageRequested" name="frmOTAPymntForm" />
<html:hidden property="userPageRequested" name="frmOTAPymntForm" />
<html:hidden property="buttonFlag" name="frmOTAPymntForm"  />
<html:hidden property="lovKey" name="frmOTAPymntForm"  />
<html:hidden property="txtFields" name="frmOTAPymntForm"  />   
<html:hidden property="txtSearchFields" name="frmOTAPymntForm"  />
<html:hidden property="txtDisplayFields" name="frmOTAPymntForm"  />
<html:hidden property="txtIndex" name="frmOTAPymntForm"  />
<html:hidden property="txtHrlyWage" name="frmOTAPymntForm"  />
<html:hidden property="headerPrimaryKey" name="frmOTAPymntForm"  />
<html:hidden property="hdnFlagIT" name="frmOTAPymntForm"  />
<html:hidden property="hdnTotHrs" name="frmOTAPymntForm"  />
<html:hidden property="flag" name="frmOTAPymntForm"  />
<html:hidden property="txtDedAmt" name="frmOTAPymntForm"  />
<html:hidden property="txtHdnNetAmt" name="frmOTAPymntForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">

// Helper functions to lock/unlock fields
function lockField(id) {
    var el = document.getElementById(id);
    if (!el) return;
    el.disabled = true;
}

function unlockField(id) {
    var el = document.getElementById(id);
    if (!el) return;
    el.disabled = false;
}

function getSafeValue(id) {
    var el = document.getElementById(id);
    return el ? el.value : "";
}

// Show Employee Lookup
function ShowEmpNum() {
    frmOTAPymntForm.lovKey.value = "OTAPymntEmp" + frmOTAPymntForm.screenName.value + frmOTAPymntForm.screenMode.value;
    frmOTAPymntForm.queryParam.value = "txtSiteID=" + frmOTAPymntForm.loginLocCode.value + ",hdnEmpLbrFlag=" + frmOTAPymntForm.hdnEmpLbrFlag.value;
    if (frmOTAPymntForm.screenMode.value == 'N') {
        frmOTAPymntForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtDOJSite,txtEmpStatus,txtCurrBas,txtDsgnDesc";
        frmOTAPymntForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmOTAPymntForm.txtIndex.value = "";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmOTAPymntForm');
    }
    if (frmOTAPymntForm.screenMode.value == 'Q') {
        frmOTAPymntForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
        frmOTAPymntForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmOTAPymntForm.txtIndex.value = "";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmOTAPymntForm');
    }
    return true;
}

// Show Designation Lookup
function ShowQryLovDsgn() {
    frmOTAPymntForm.lovKey.value = "OTAPymntDsgn" + frmOTAPymntForm.screenName.value + frmOTAPymntForm.screenMode.value;
    frmOTAPymntForm.txtDisplayFields.value = "txtDsgnDesc,txtDsgn";
    frmOTAPymntForm.txtSearchFields.value = "";
    frmOTAPymntForm.txtIndex.value = "";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmOTAPymntForm');
    return true;
}

// Load form based on mode
function lfnLoad() {
    var mode = document.all.screenMode.value;
    var flag = document.all.flag.value;

    if (mode == '') {
        doQueryMode();
    }

    if (mode == 'N') {
        unlockField("txtRmrks");
        unlockField("txtPayModeType");
        unlockField("txtYYMM");
        lockField("butGetDetail");
        unlockField("butInsert");
        unlockField("txtDedIT");
    }

    if (mode == 'Q') {
        lockField("butGetDetail");
        lockField("butDelete");
        lockField("butInsert");
    }

    if (mode == 'U') {
        if (flag == 'true') {
            lockField("butGetDetail");
            lockField("butInsert");
            lockField("butDelete");
        } else {
            unlockField("butGetDetail");
            lockField("butInsert");
            lockField("butDelete");
        }
        if (document.all.txtInvId.value != '') {
            lockField("ceilFlag");
            lockField("txtRmrks");
            lockField("txtDedIT");

            var oTable = document.getElementById("Detail");
            if (oTable != null) {
                for (var indx = 0; indx < oTable.rows.length - 1; indx++) {
                    lockField("txtOTARate");
                    lockField("txtOTAHrs");
                }
            }
            lockField("butSave");
            lockField("butInv");
            lockField("butDel");
        }
    }

    menuHandling(mode);
    disableInsert();
}

// Disable Insert button
function disableInsert() {
    lockField("butInsertMode");
    document.all.butInsertMode.src = "../INCLUDES/IMAGES/insert_dis.jpg";
}

// Save record after validation
function SaveRecord() {
    document.all.buttonFlag.value = '';
    if (mandatory_Check("frmOTAPymntForm")) {
        var answer = confirm("Have you verified all the data including Income Tax. Press OK to save the record!");
        if (!answer) {
            return false;
        }

        if (document.all.txtGrossAmt.value == 0) {
            alert("Gross Amount Payable can't be 0");
            return false;
        }

        if (document.all.txtDedIT.value != 0) {
            calcTotal();
            var itDed = document.all.txtDedIT.value;
            var checkDed = parseInt(document.all.txtGrossAmt.value - itDed);
            if (checkDed != document.all.txtNetAmt.value) {
                alert("Please check your calculation it is not correct");
                return false;
            }
        }

        var oTable = document.getElementById("Detail");
        if (oTable == null) {
            return;
        }
        if (oTable.rows.length == 1) {
            alert("Please add at least one record");
            return false;
        }

        var gross = 0;
        var totHrs = 0;
        for (var indx = 0; indx < oTable.rows.length - 1; indx++) {
            if (document.getElementsByName("status")[indx].value != 'D') {
                gross += parseInt(document.getElementsByName("txtEmolument")[indx].value || "0", 10);
                totHrs += parseInt(document.getElementsByName("txtOTAHrs")[indx].value || "0", 10);
            }
        }
        document.all.txtGrossAmt.value = gross;
        document.all.hdnTotHrs.value = totHrs;

        var ded = document.all.txtDedIT.value || "0";
        if (isNaN(document.all.txtDedAmt.value)) {
            document.all.txtDedAmt.value = 0;
        }

        if (document.all.txtNetAmt.value < 0) {
            alert("Net Amount cannot be less than zero");
            return false;
        }

        if (document.all.txtGrossAmt.value == 0) {
            alert("Please check the gross Amount");
            return false;
        }

        if (document.all.txtGrossAmt.value != gross) {
            alert("Gross Amount should be equal to sum of Emoluments");
            return false;
        }

        unlockField("txtNetAmt");
        frmOTAPymntForm.headerDataChanged.value = "true";
        frmOTAPymntForm.detailDataChanged.value = "true";
        unlockField("txtDedIT");

        lockField("butSave");
        document.all.butSave.src = "../INCLUDES/IMAGES/save_dis.jpg";

        frmOTAPymntForm.action = "../../../OTAPymntSaveAction.do";
        frmOTAPymntForm.submit();
    } else {
        return false;
    }
}

// Change functions to set data changed flags
function changed(val) {
    frmOTAPymntForm.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val - 1].value == 'Q') {
        document.getElementsByName("status")[val - 1].value = 'U';
    }
}

function lfnChanged(val) {
    frmOTAPymntForm.headerDataChanged.value = "true";
}

// Navigate through headers
function getHeaderRecord() {
    document.all.buttonFlag.value = '';
    frmOTAPymntForm.flag.value = "false";
    frmOTAPymntForm.action = "../../../OTAPymntFirstGetHeaderAction.do";
    frmOTAPymntForm.submit();
}

function doGetNextHeader() {
    document.all.buttonFlag.value = '';
    frmOTAPymntForm.flag.value = "false";
    frmOTAPymntForm.userPositionRequested.value = 1 * frmOTAPymntForm.positionRequested.value + 1;
    frmOTAPymntForm.action = "../../../OTAPymntGetNextHeader.do";
    frmOTAPymntForm.submit();
}

function PrevHeader() {
    document.all.buttonFlag.value = '';
    frmOTAPymntForm.flag.value = "false";
    frmOTAPymntForm.userPositionRequested.value = 1 * frmOTAPymntForm.positionRequested.value - 1;
    frmOTAPymntForm.action = "../../../OTAPymntGetNextHeader.do";
    frmOTAPymntForm.submit();
}

function JumpHeader() {
    document.all.buttonFlag.value = '';
    frmOTAPymntForm.flag.value = "false";
    frmOTAPymntForm.userPositionRequested.value = 1 * frmOTAPymntForm.newPositionRequested.value;
    frmOTAPymntForm.action = "../../../OTAPymntGetNextHeader.do";
    frmOTAPymntForm.submit();
}

// Switch between modes
function doInsertMode() {
    if (document.all.screenMode.value == "Q") {
        document.all.headerDataChanged.value = '';
    }
    document.all.buttonFlag.value = '';
    frmOTAPymntForm.action = "../../../OTAPymntNewMode.do";
    frmOTAPymntForm.submit();
}

function doQueryMode() {
    document.all.buttonFlag.value = '';
    frmOTAPymntForm.action = "../../../OTAPymntQueryMode.do";
    frmOTAPymntForm.submit();
}

function doRefresh() {
    document.all.buttonFlag.value = '';
    frmOTAPymntForm.action = "../../../OTAPymntRefresh.do";
    frmOTAPymntForm.submit();
}

// Calculation functions
function calcAmt(i) {
    var int_hrs = parseInt(document.getElementsByName("txtOTAHrs")[i - 1].value || "0", 10);
    var float_hrs = parseFloat(document.getElementsByName("txtOTAHrs")[i - 1].value || "0");

    if (((float_hrs * 10) % 5) != 0) {
        alert('Please Enter Hours In Multiples of 0.5');
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue = false;
        return false;
    }

    var otaHrs = document.getElementsByName("txtOTAHrs")[i - 1].value || "0";
    var otaRate = document.getElementsByName("txtOTARate")[i - 1].value || "0";
    var wage = document.all.txtHrlyWage.value || "0";

    document.getElementsByName("txtEmolument")[i - 1].value = Math.round(otaHrs * otaRate * wage);

    calcTotal();
}

function calcTotal() {
    var oTable = document.getElementById("Detail");
    if (oTable == null) {
        return;
    }
    var gross = 0;
    var totHrs = 0;
    for (var indx = 0; indx < oTable.rows.length - 1; indx++) {
        if (document.getElementsByName("status")[indx].value != 'D') {
            gross += parseInt(document.getElementsByName("txtEmolument")[indx].value || "0", 10);
            totHrs += parseInt(document.getElementsByName("txtOTAHrs")[indx].value || "0", 10);
        }
    }
    document.all.txtGrossAmt.value = gross;
    document.all.hdnTotHrs.value = totHrs;

    var ded = document.all.txtDedIT.value || "0";
    if (isNaN(document.all.txtDedAmt.value)) {
        document.all.txtDedAmt.value = 0;
    }
    document.all.txtNetAmt.value = gross - ded - document.all.txtDedAmt.value;
    unlockField("txtNetAmt");
}

function chk_YearMonth(val) {
    var yearM = val;
    var month = yearM.substring(4, 6);
    var year = yearM.substring(0, 4);

    var today = new Date();
    var curr_date = today.getDate();
    var curr_month = today.getMonth() + 1;
    var curr_year = today.getFullYear();

    if (yearM.length != 6) {
        alert(" Year Month should be a Six digit Number");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue = false;
        return false;
    } else if (month < 1 || month > 12) {
        alert("  Month should be Within 1 to 12");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue = false;
        return false;
    } else if ((year == curr_year) && (month > curr_month)) {
        alert("Payment can not be done in advance. Check the month");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue = false;
        return false;
    } else if (year > curr_year) {
        alert("Year should not exceed Current Year");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue = false;
        return false;
    } else {
        frmOTAPymntForm.action = "../../../OTAPymntGetWage.do";
        frmOTAPymntForm.submit();
        return true;
    }
}

function JumpDetail() {
    frmOTAPymntForm.userPageRequested.value = 1 * frmOTAPymntForm.newPageRequested.value;
    frmOTAPymntForm.action = "../../../OTAPymntNextDetailAction.do";
    frmOTAPymntForm.submit();
}

function doBaseDelRow() {
    var oTable = document.getElementById("Detail");
    if (oTable == null) {
        return;
    }
    for (var i = 0; i < oTable.rows.length - 1; i++) {
        if (document.getElementsByName("checked")[i].checked) {
            if (frmOTAPymntForm.txtInvId.value == '') {
                document.getElementsByName("itemChecked")[i].value = "Y";
                frmOTAPymntForm.detailDataChanged.value = "true";
            } else {
                alert("You Can not delete the record");
                return;
            }
        }
    }
    calcTotal();
    frmOTAPymntForm.action = "../../../OTAPymntDeleteRowAction.do";
    frmOTAPymntForm.submit();
}

function GetDetail() {
    frmOTAPymntForm.flag.value = "true";
    frmOTAPymntForm.action = "../../../OTAPymntGetDetailAction.do";
    frmOTAPymntForm.submit();
}

function doBaseAddRow() {
    if (mandatory_Check("frmOTAPymntForm")) {
        var oTable = document.getElementById("Detail");
        if (oTable == null) {
            return;
        }
        frmOTAPymntForm.action = "../../../OTAPymntAddRowAction.do";
        frmOTAPymntForm.submit();
    } else {
        return false;
    }
}

function doGetTab(arg) {
    document.all.buttonFlag.value = '';
    var mode = document.all.screenMode.value;
    if (mode == 'N')
        return false;
    document.all.forwardedPage.value = arg;
    frmOTAPymntForm.flag.value = "false";
    frmOTAPymntForm.action = "../../../OTAPymntTabAction.do";
    frmOTAPymntForm.submit();
}

function sendInv() {
    if (document.all.headerPrimaryKey.value == '') {
        alert("Please Select a record first!!");
        return false;
    }
    lockField("butInv");
    frmOTAPymntForm.action = "../../../OTAPymntSendInvAction.do";
    frmOTAPymntForm.submit();
}

function DelRecord() {
    if (document.all.txtEmpNo.value == '') {
        alert("Please Select a record first!!");
        return false;
    }
    if (document.all.txtInvId.value != '') {
        alert("Invoice created. Record cannot be deleted now ");
        return false;
    }
    frmOTAPymntForm.action = "../../../OTAPaymentDelRecord.do?param1=OTAPay";
    frmOTAPymntForm.submit();
}

</script>
