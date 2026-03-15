<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
	<script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
	<script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
	<script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
	<script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>
<%  String empLbr = (String)(request.getSession().getAttribute("hdnEmpLbrFlag"));
	
%>

<html:form  action="MaintDeptAttanLeave" name="frmMaintDeptAttanLeave" type="FCIPAY.Payroll.WEBTIER.Form.MaintDeptAttanLeaveForm" scope="session">
<bean:define id="ParentForm" name="frmMaintDeptAttanLeave" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>DEPT. LABOUR LEAVE APPLICATION</TD>
  </TR>

  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
 
         <TABLE cellSpacing=0 cellPadding=0 >
        <!--Account  Header Row Starts -->
          <TR>
            <TD class=subHeader colspan=6><bean:message key="Payroll.MaintIntSavings.hd" /></TD>
          </TR>
          <TR>
            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
          </TR>

          <tr height="15" >
            <td colspan="2"></td>
          </tr>
       
          <TR>                            
            <td width="50%" colspan=2 class="radioText" >
            <logic:equal property= "optVal" name= "frmMaintDeptAttanLeave" value="E">
            <input type="radio" name="radioMisc" value="E" checked="true" onclick="MiscelClick(this.value)" >Employee Wise
            </logic:equal>
            <logic:notEqual property= "optVal" name= "frmMaintDeptAttanLeave" value="E">
            <input type="radio" name="radioMisc" value="E" onclick="MiscelClick(this.value)" >Employee Wise
            </logic:notEqual>
            <td width="50%" colspan=2 class="radioText">
            <logic:equal property= "optVal" name= "frmMaintDeptAttanLeave" value="E">
            <input type="radio" name="radioMisc" value="M" onclick="MiscelClick(this.value)" >All
            </logic:equal>
            <logic:notEqual property= "optVal" name= "frmMaintDeptAttanLeave" value="E">
            <input type="radio" name="radioMisc" value="M" checked="true" onclick="MiscelClick(this.value)" >All
            </logic:notEqual>
          <td colspan="2" height="10" ></td>          
          </TR>
          
          <tr >	
            <td></td>
          </tr>
          
          <tr>        
           <td class="labelText"  width="25%" >From Year Month</td>
          <td>
          <logic:equal property="screenMode" name= "frmMaintDeptAttanLeave" value="N" >
            <html:text  property="txtYYMM" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="6" size="23" readonly="true" styleClass="locked"  /> </td>
          </logic:equal>
          <logic:notEqual property="screenMode" name= "frmMaintDeptAttanLeave" value="N" >
            <html:text  property="txtYYMM" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="6" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                }; " size="23" styleClass="optional"  /> </td>
          </logic:notEqual>

          <!-- Added on 30 March 09 -->
          <td class="labelText"  width="25%" >To Year Month</td>
          <td>
          <logic:equal property="screenMode" name= "frmMaintDeptAttanLeave" value="N" >
            <html:text  property="txtToYYMM" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="6" size="23" readonly="true" styleClass="locked"  /> </td>
          </logic:equal>
          <logic:notEqual property="screenMode" name= "frmMaintDeptAttanLeave" value="N" >
            <html:text  property="txtToYYMM" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="6" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                }; " size="23" styleClass="optional"  /> </td>
          </logic:notEqual>
          <!-- End of New Code -->
          <tr>  
          <logic:equal property= "optVal" name= "frmMaintDeptAttanLeave" value="E">
          <td class="labelText"  width="25%" ><bean:message key="Payroll.MaintElecMtrRdg.empno" /></td>
          <td><html:text  property="txtEmpNo" altKey="Payroll.MaintElecMtrRdg.empno" readonly="true" maxlength="10" size="23" styleClass="required"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo1"  onclick="return ShowEmpNo();" > </td>
          <html:hidden property="txtEmpNameHdr" />
          <html:hidden property="txtCpfCode" />    
          </logic:equal>
         
          <logic:notEqual property= "optVal" name= "frmMaintDeptAttanLeave" value="E">
            <td width="25%" >&nbsp;</td>    <td>&nbsp; </td>
            <html:hidden  property="txtEmpNo" />
            <html:hidden property="txtEmpNameHdr" />
            <html:hidden property="txtCpfCode" />
          </logic:notEqual>
          
         </tr>
        </tr>  
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
 
  
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Leave Information<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
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
                            <DIV id=divDtlTable style="height:320px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                <TBODY>
                                     <TR height="20">
                                              <td class=tableHeader width="2%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"   /></td>
                                              <TD class=tableHeader width="2%">S No.</TD>                                             
                                              <TD class=tableHeader width="8%">Employee No.</TD>
											   <TD class=tableHeader width="7%">Staff Code</TD>
                                              <TD class=tableHeader width="17%">Employee Name</TD>
											   <TD class=tableHeader width="16%">Designation</TD>
                                              <td class=tableHeader width="8%">From Date</td> 
                                              <td class=tableHeader width="8%">To Date</td> 
                                              <TD class=tableHeader width="12%">Leave Type</td>
                                              
                                      </TR>    

                         <logic:iterate id="leaveInfo" name="frmMaintDeptAttanLeave" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintDeptAttanLeaveBean" >
                              <% ++i; %>
                                <logic:notEqual name="leaveInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                     
                                     
                                      <td align=center ><html:checkbox property="checked" name="frmMaintDeptAttanLeave" alt="<%=String.valueOf(i)%>" onclick="checkRecord(); enableLveType(this.alt)" value="false" /></td>
                                   
                                    
									   <td><html:text property="txtSrNo" name="Sno" size="3"   value="<%=String.valueOf(i)%>" styleClass="locked" style="width:70%" /></td>
                                      <logic:notEqual name="leaveInfo" property="status" value="N" >
                                        <td ><html:text property="txtEmpCode" name="leaveInfo" size="9" styleClass="locked" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>"  />
                                         <img src="../INCLUDES/IMAGES/lov.jpg" height="15" align="center" alt="<%=i%>" property="buttxtPayCode"   >
                                         </td> 
										 <!--ashish bansal-->
										 <td ><html:text property="txtStaffCode" name="leaveInfo" size="9" styleClass="locked" readonly="true"  style="width:85%;text-align:left" alt="<%=String.valueOf(i)%>" />
                                         </td>
                                        <td colspan="1"><html:text property="txtEmpName" name="leaveInfo"  styleClass="locked" readonly="true" alt="<%=String.valueOf(i)%>"  style="WIDTH: 90%"  /></td>  
                
                                            <td ><html:text property="txtDesignation" name="leaveInfo" size="9" readonly="true" styleClass="locked" style="width:85%;text-align:left" alt="<%=String.valueOf(i)%>"  />
                                          </td>                         
                                         <td ><html:text property="txtFrom" name="leaveInfo" size="9" styleClass="locked" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="validFromDate(this.alt)"  />
                                         <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>"  />
                                         </td>                                               
  
                                         <td ><html:text property="txtTo" name="leaveInfo" size="9" readonly="true" styleClass="locked" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>"  />
                                         <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" alt="<%=(i-1) %>" />
                                         </td>
										       <td colspan="1">
									
										<html:select property="txtLeaveTyp" name="leaveInfo" disabled="true" styleClass="locked" alt="<%=String.valueOf(i)%>"  onchange="changeleavedept(this.alt);return changed(this.alt);" style="WIDTH: 100%"  >
										<html:option value="" >-----------Please Select-----------</html:option> 
										<logic:present name="LeaveTyp">
									    <html:optionsCollection label="label" value="value" property="lvDepTypList" name="LeaveTyp"/> 		</logic:present>
										</html:select>

										</td>
                                        
                                     
                                                                                  
                                      </logic:notEqual>
                                      
                                    <logic:equal name="leaveInfo" property="status" value="N" >                                      
                                      <logic:equal name="frmMaintDeptAttanLeave" property="optVal" value="E" > 
                                        <td ><html:text property="txtEmpCode" name="leaveInfo" size="9" styleClass="locked" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>"  />
                                         <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtPayCode"   >
                                         </td> 
                                       </logic:equal>
                                       <logic:notEqual name="frmMaintDeptAttanLeave" property="optVal" value="E" >
                                        <td ><html:text property="txtEmpCode" name="leaveInfo" size="9" styleClass="required" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
                                         <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtPayCode"  onclick="ShowLovEmpNo(this.alt);" >
                                         </td>
                                        </logic:notEqual> 
										 <td ><html:text property="txtStaffCode" name="leaveInfo" size="9" styleClass="locked" style="width:85%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
                                         </td>   
                                        <td colspan="1"><html:text property="txtEmpName" name="leaveInfo" readonly="true"  styleClass="locked" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" style="WIDTH: 90%"  /></td>  
                                       <td ><html:text property="txtDesignation" name="leaveInfo" size="9" readonly="true" styleClass="locked" style="width:85%;text-align:left" alt="<%=String.valueOf(i)%>"  />
                                          </td>
                                        
                                        
                                                                                    
                                         <td ><html:text property="txtFrom" name="leaveInfo" size="9" styleClass="required" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="validFromDate(this.alt); return chk_PrevDt(this.alt);" />
                                         <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtFrom',this)" />
                                         </td>                                               
  
                                         <td ><html:text property="txtTo" name="leaveInfo" size="9" readonly="true" styleClass="required" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return chkFromDt(this.alt)" />
                                         <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" alt="<%=(i-1) %>" onclick="showCalendar('txtTo',this)" />
                                         </td>
                                         
                                         <td colspan="1"><html:select property="txtLeaveTyp" name="leaveInfo" disabled="false" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="changeleavedept(this.alt);return changed(this.alt);"   style="WIDTH: 100%"  >
										<html:option value="" >-----------Please Select-----------</html:option> 
										<logic:present name="LeaveTyp">
									    <html:optionsCollection label="label" value="value" property="lvDepTypList" name="LeaveTyp"/> 		</logic:present>
										</html:select></td>
                                          
                                      </logic:equal>
                                      <html:hidden property="itemChecked" name="leaveInfo" />
                                       <html:hidden property="detailId" name="leaveInfo" value="Default"/>
                                       <html:hidden property="status" name="leaveInfo" />
                                       <html:hidden property="txtEmpLeaveId" name="leaveInfo" />
                                       <html:hidden property="hdnProcYYMM" name="leaveInfo" />
                                       <html:hidden property="hdnSalProc" name="leaveInfo" />
                                       <html:hidden property="txtRevLeaveTyp" name="leaveInfo" />
									   
										 <!--Added by Varalika on 03-Oct-2011-->     
										<html:hidden property="txtUpdatedSite"  name="leaveInfo" />
										<html:hidden property="txtCreationDate" name="leaveInfo" />
										<html:hidden property="txtCreatedBy"    name="leaveInfo" />
										<html:hidden property="txtCreatedSite"  name="leaveInfo" />
										<html:hidden property="txtUpdationDate" name="leaveInfo" />
										<html:hidden property="txtUpdatedBy"    name="leaveInfo" />
										<!--ended by varalika -->

                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="leaveInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintDeptAttanLeave" value="notchecked" /></td>
                                       <td ><html:hidden property="txtEmpCode" name="leaveInfo" /></td>
                                       <td ><html:hidden property="txtStaffCode" name="leaveInfo" /></td>
										<td ><html:hidden property="txtEmpName" name="leaveInfo"  value="A" /></td>
                                       <td ><html:hidden property="txtDesignation" name="leaveInfo" /></td> 
									   <td ><html:hidden property="txtLeaveTyp" name="leaveInfo" /></td>
                                       <td ><html:hidden property="txtFrom" name="leaveInfo" /></td> 
                                       <td ><html:hidden property="txtTo" name="leaveInfo" /></td>
                                       <html:hidden property="itemChecked" name="leaveInfo" />
                                       <html:hidden property="status" name="leaveInfo" />
                                        <html:hidden property="hdnProcYYMM" name="leaveInfo" />
                                        <html:hidden property="hdnSalProc" name="leaveInfo" />
                                       <html:hidden property="detailId" name="leaveInfo" value="Default"/>
                                       <html:hidden property="txtEmpLeaveId" name="leaveInfo" />
                                       <html:hidden property="txtRevLeaveTyp" name="leaveInfo" />
									    <!--Added by Varalika on 03-Oct-2011-->     
										<html:hidden property="txtUpdatedSite"  name="leaveInfo" />
										<html:hidden property="txtCreationDate" name="leaveInfo" />
										<html:hidden property="txtCreatedBy"    name="leaveInfo" />
										<html:hidden property="txtCreatedSite"  name="leaveInfo" />
										<html:hidden property="txtUpdationDate" name="leaveInfo" />
										<html:hidden property="txtUpdatedBy"    name="leaveInfo" />
										<!--ended by varalika -->
                                    </tr>
                                  </logic:equal>                                    
                           </logic:iterate>                           

                                         
                                 </TBODY>
                                </TABLE>
                              </DIV>
                             </TD>
                            </TR>                     
          
              <!-- Get details starts -->
                            <tr>
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
                                  <TR>
                                <td colspan=11>	
                                  <jsp:include  page = "../INCLUDES/GenDetailLeaveMenu.jsp" flush="true" />
								  <p>
								  Note: 1. You are not allowed to Update/Delete a Leave for a day earlier than current payroll Month.<Br/>
								        </t>2. To Change Leave Type First click the checkBox then select Leave Type and then Press Save Button.<Br/>
										</t>3. Delete Row Would Delete the record permanently and 'W' will be replaced in attandance By default. <Br/>
										</t>4. To change the Leave Date you need to delete the earlier leave entry and create a new entry.</Br>
										</t>5. A maximum of 120 Disability leaves are allowed in a year for employee. If Disability leaves applied 
										</t>   counts more than 120 days,then extra leaves will be converted to 'Half Pay Leave' automatically during 'initialise payroll transaction'. <p>
                              </TD>
                              <td colspan=11>	
                                 
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
                     <td  bgcolor=#4682b4></td>
                     <td bgColor=#4682b4></td>
                     <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
             </TR>
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->
<html:hidden property="headerPrimaryKey" name="frmMaintDeptAttanLeave" value="Default" />
<html:hidden property="loginLocCode" name="frmMaintDeptAttanLeave"  />
<html:hidden property="screenMode" name="frmMaintDeptAttanLeave"  />
<html:hidden name="frmMaintDeptAttanLeave"  property="screenName" value="AttandanceUpdationScreen" />
<html:hidden name="frmMaintDeptAttanLeave"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmMaintDeptAttanLeave"  />
<html:hidden property="lovKey" name="frmMaintDeptAttanLeave"  />
<html:hidden property="txtFields" name="frmMaintDeptAttanLeave"  />   
<html:hidden property="txtSearchFields" name="frmMaintDeptAttanLeave"  />
<html:hidden property="txtDisplayFields" name="frmMaintDeptAttanLeave"  />
<html:hidden property="txtIndex" name="frmMaintDeptAttanLeave"  />
<html:hidden property="optVal" name="frmMaintDeptAttanLeave"  />
<input type="hidden" name="queryParam" />
<html:hidden property="pageRequested" name="frmMaintDeptAttanLeave" />
<html:hidden property="userPageRequested" name="frmMaintDeptAttanLeave" />
<html:hidden property="userPositionRequested" name="frmMaintDeptAttanLeave" />
 <!--Added by Varalika on 03-Oct-2011-->     
<html:hidden property="txtUpdatedSite"  name="frmMaintDeptAttanLeave" />
<html:hidden property="txtCreationDate" name="frmMaintDeptAttanLeave" />
<html:hidden property="txtCreatedBy"    name="frmMaintDeptAttanLeave" />
<html:hidden property="txtCreatedSite"  name="frmMaintDeptAttanLeave" />
<html:hidden property="txtUpdationDate" name="frmMaintDeptAttanLeave" />
<html:hidden property="txtUpdatedBy"    name="frmMaintDeptAttanLeave" />
<html:hidden property="payYYMM"    name="frmMaintDeptAttanLeave" />

<!--ended by varalika -->

</html:form>
</body>
</html:html>


<script language="javascript">

function lfnLoad()
{
  var screenmode = document.all.screenMode.value;
  if(screenmode=='C' || screenmode=='V')
  {
      frmMaintDeptAttanLeave.screenMode.value = 'U';
  }
  if(screenmode == '')
  {
      doQueryMode();
  }  
  if(screenmode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }
  if(screenmode=='U')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
  }
  if(screenmode=='Q')
  {
     document.all.butInsert.disabled="disabled";
     document.all.butCancel.disabled="disabled";
  }
  document.all.butDelete.disabled="disabled";
  document.all.butCancel.disabled="true";
  document.all.butHistory.disabled="disabled";

  menuHandling(screenmode);
  document.all.butExecute.disabled="true";
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
document.getElementById("butCancel").style.display='none';

disablePrevleaves();
 }

function changed(val)
{
   frmMaintDeptAttanLeave.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
    
}

function changeleavedept(val)
{

  var emp_type = document.getElementById("hdnEmpLbrFlag").value;
  var lvtyp=document.getElementsByName('txtLeaveTyp')[val-1].value;
 if(emp_type=='L')
 {
  if(lvtyp=='LVTYP$LWP')
  {
  alert("Leave Without Pay is not applicable for departmental labours");
  document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
   return false;
  }
 } 
 return true;
}


function doBaseAddRow()
{
  if(mandatory_Check("frmMaintDeptAttanLeave"))
  {
	  var emp_type = document.getElementById("hdnEmpLbrFlag").value;
	 

	 var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
     var iTr2 = oTable.rows.length;
    EnableFields();  
    document.forms[0].action = "../../../DeptAttanLeaveAddRowAction.do";
    document.forms[0].submit();
  }
  else
  {
      return false;
  }
}

function SaveRecord()
{

  if(mandatory_Check("frmMaintDeptAttanLeave"))
  { 
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  EnableFields();
  if(checkLeaveDate())
  {
      frmMaintDeptAttanLeave.headerFields.value = "false";
      frmMaintDeptAttanLeave.screenMode.value = "U";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintDeptAttanLeave.action = "../../../DeptAttanLeaveSaveAction.do";
      // frmMaintHraRate.totalDetailRecord.value=parseInt(iTr2)-1;
      frmMaintDeptAttanLeave.submit();
  }
  else
    return false;
}
 else
  {
    return false;
  }
}


function doQueryMode()
{
  
  frmMaintDeptAttanLeave.action="../../../DeptAttanLeaveQueryAction.do"
  frmMaintDeptAttanLeave.submit();
}

function GetDetail()
{
  if(mandatory_Check("frmMaintDeptAttanLeave"))
  { 
  document.all.screenMode.value='U'; 
  frmMaintDeptAttanLeave.action="../../../DeptAttanLeaveGetDetailAction.do"
  frmMaintDeptAttanLeave.submit();
  }
  else{
    return false;
  }
}

function checkRecord()
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    var fl = 0;
    for(i=0; i < iTr2 - 1; i++)
    {

      if(document.getElementsByName("checked")[i].checked)
      {
          document.all.butDelete.disabled="";
          document.all.butCancel.disabled="";
		  document.all.butHistory.disabled="";
          return true;
      }
    }
    if(fl == 0)   
    {      
        document.all.butDelete.disabled="true";
        document.all.butCancel.disabled="true";
		document.all.butHistory.disabled="";
        return false;
    }

}
 

function doRefresh()
{
  frmMaintDeptAttanLeave.action="../../../DeptAttanLeaveRefresh.do"
  frmMaintDeptAttanLeave.submit();
}
     


function doBaseDelRow()
{
  var r=confirm("Are You Sure you want to delete this record?");
if (r==true)
  {
  var oTable = document.getElementById("Detail");
  var strRecList='';
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  EnableFields();
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("txtEmpLeaveId")[i].value=="" )
        document.getElementsByName("itemChecked")[i].value = "Y";
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
  document.forms[0].action = "../../../DeptAttanLeaveDeleteRowAction.do";
  document.forms[0].submit();
}
}

function ShowLovEmpNo(i)
{
   frmMaintDeptAttanLeave.lovKey.value = "EmpNo" +frmMaintDeptAttanLeave.screenName.value + frmMaintDeptAttanLeave.screenMode.value;
   frmMaintDeptAttanLeave.txtDisplayFields.value = "txtEmpCode,txtEmpName";                                       // added by dushyant for cpf code
   frmMaintDeptAttanLeave.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";      // added by dushyant for cpf code
   frmMaintDeptAttanLeave.txtIndex.value=i-1;
   frmMaintDeptAttanLeave.queryParam.value="txtSiteID="+ frmMaintDeptAttanLeave.loginLocCode.value +",hdnEmpLbrFlag="+frmMaintDeptAttanLeave.hdnEmpLbrFlag.value  ;
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintDeptAttanLeave');
   frmMaintDeptAttanLeave.detailDataChanged.value = "true";
   changed(i);
   return true;
}

function ShowEmpNo()
{
    frmMaintDeptAttanLeave.lovKey.value = "EmpNo" +frmMaintDeptAttanLeave.screenName.value + frmMaintDeptAttanLeave.screenMode.value;
     frmMaintDeptAttanLeave.txtDisplayFields.value = "txtEmpNo,txtEmpNameHdr,txtCpfCode";                                     // added by dushyant for cpf code
     frmMaintDeptAttanLeave.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";    // added by dushyant for cpf code
     frmMaintDeptAttanLeave.txtIndex.value="";
     frmMaintDeptAttanLeave.queryParam.value="txtSiteID="+ frmMaintDeptAttanLeave.loginLocCode.value +",hdnEmpLbrFlag="+frmMaintDeptAttanLeave.hdnEmpLbrFlag.value  ;
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintDeptAttanLeave');
     return true;
}

function chk_PrevDt(i)
{
    if(document.getElementsByName("txtTo")[i-1].value!='')
    {    
      return chkFromDt(i);
    }
}

function chkFromDt(i)
{
  var fromDt=document.getElementsByName("txtFrom")[i-1].value;
  var toDt=document.getElementsByName("txtTo")[i-1].value; 
  if (!cmpDate(fromDt,toDt,0))
  {
    alert("To Date cannot be less than From Date");
    document.getElementsByName("txtTo")[i-1].value="";
    return false;                      
  }
  changed(i);
}

function doBaseCancel()
{
  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  EnableFields();
  var strRecList='';
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
        if(document.getElementsByName("txtEmpLeaveId")[i].value!='')
        {
          document.getElementsByName("status")[i].value = "C";
          frmMaintDeptAttanLeave.detailDataChanged.value = "true";
         }
        else
          strRecList=strRecList+(i+1)+",";
    }
  }
  if(strRecList!='')
  {
    alert("Sorry you cannot Cancel Record(s) ");
    return false;
  }
  document.all.screenMode.value='C';  
  document.forms[0].action = "../../../DeptAttanLeaveSaveAction.do";
  document.forms[0].submit();
}

function doBaseConvert()
{
  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  SaveRecord();
}

function revLeave(i,revTyp)
{
  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  EnableFields();
  var strRecList='';
  document.getElementsByName("txtRevLeaveTyp")[i].value = revTyp;
  document.getElementsByName("status")[i].value = "R";
  frmMaintDeptAttanLeave.detailDataChanged.value = "true";
  document.all.screenMode.value='C';  
  document.forms[0].action = "../../../DeptAttanLeaveSaveAction.do";
  document.forms[0].submit();
}

// Added by varalika on 03-Oct-2011
function doBaseShowHistory()
{

      var oTable = document.getElementById("Detail");
    
      if(oTable == null)
      {
       document.all.butHistory.disabled="true";
       return;
      }
    
      var iTr2 = oTable.rows.length;
      var i = 0;
      var f2=0;
	   var noRowSel=0;

      for(i=0; i < iTr2 - 1; i++)
      {
		   if(document.getElementsByName("checked")[i].checked)
          { 
		noRowSel =noRowSel + 1;
		  }
	  }

      for(i=0; i < iTr2 - 1; i++)
      {
           if(document.getElementsByName("checked")[i].checked)
          {          
              f2=f2+1;
		if(noRowSel == 1)
        {
              if(iTr2 <= 2)
              {
				  if(!(frmMaintDeptAttanLeave.txtCreationDate[i].value&&frmMaintDeptAttanLeave.txtCreatedBy[i].value&&frmMaintDeptAttanLeave.txtCreatedSite[i].value))
				  {
				  alert("No history exists for the selected record");
				  }
				  else
				  {
				
				  alert("Record History "+"\n"
				  +"Creation Date :  "+ frmMaintDeptAttanLeave.txtCreationDate[i].value
				  +"\n"
				  +"Created By      :  "+frmMaintDeptAttanLeave.txtCreatedBy[i].value
				  +"\n"
				  +"Created Site    :  "+frmMaintDeptAttanLeave.txtCreatedSite[i].value
				  +"\n"
				  +"Updation Date:  "+frmMaintDeptAttanLeave.txtUpdationDate[i].value
				  +"\n"
				  +"Updated By     :  "+frmMaintDeptAttanLeave.txtUpdatedBy[i].value
				  +"\n"
				  +"Updated Site   :  "+frmMaintDeptAttanLeave.txtUpdatedSite[i].value
				  );
				}
              }
              else
              {
              if(!(frmMaintDeptAttanLeave.txtCreationDate[i].value&&frmMaintDeptAttanLeave.txtCreatedBy[i].value&&frmMaintDeptAttanLeave.txtCreatedSite[i].value))
              {
              alert("No history exists for the selected record");
              }
              else
              {
              alert("Record History"+"\n"
              +"Creation Date :  "+ frmMaintDeptAttanLeave.txtCreationDate[i].value+"\n"
              +"Created By      :  "+frmMaintDeptAttanLeave.txtCreatedBy[i].value
              +"\n"
              +"Created Site    :  "+frmMaintDeptAttanLeave.txtCreatedSite[i].value
              +"\n"
              +"Updation Date:  "+frmMaintDeptAttanLeave.txtUpdationDate[i].value
              +"\n"
              +"Updated By     :  "+frmMaintDeptAttanLeave.txtUpdatedBy[i].value
              +"\n"
              +"Updated Site   :  "+frmMaintDeptAttanLeave.txtUpdatedSite[i].value
              );
            }
           }
          }
		  }
      }

	  if(noRowSel == 0 )
	{
	       alert("Select atleast one row for history !");
           document.all.butHistory.disabled="";
           return false;
	}
    
     if(noRowSel > 1)
        {
           alert("Select only one row for history !");
           document.all.butHistory.disabled="";
           return false;
        }
        
    if(f2 == 1)
      {
          document.all.butHistory.disabled="";
        //  showHistWin('<html:rewrite page="/Payroll/JSP/COMMON/JSP/ShowHistory.jsp" />', 'frmMaintDeptAttanLeave');
          return true;
      }
    
    if(f2 == 0)
      {
		   document.all.butHistory.disabled="";
       return false;
      }
}
//Added By Varalika Ends here

function doBasePrevDetail()
{
    frmMaintDeptAttanLeave.userPageRequested.value = 1*frmMaintDeptAttanLeave.pageRequested.value - 1;
    frmMaintDeptAttanLeave.action = "../../../DeptAttanLeaveNextDetailAction.do";
    frmMaintDeptAttanLeave.submit();
}


function doBaseNextDetail()
{
    frmMaintDeptAttanLeave.userPageRequested.value = 1*frmMaintDeptAttanLeave.pageRequested.value + 1;
    frmMaintDeptAttanLeave.action = "../../../DeptAttanLeaveNextDetailAction.do";
    frmMaintDeptAttanLeave.submit();
}

function JumpDetail()
{
    frmMaintDeptAttanLeave.userPageRequested.value = 1*frmMaintDeptAttanLeave.newPageRequested.value ;
    frmMaintDeptAttanLeave.action = "../../../DeptAttanLeaveNextDetailAction.do";
    frmMaintDeptAttanLeave.submit();
}

function EnableFields()
{
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      } 
      var iTr2 = oTable.rows.length;
      var i = 0;
      for(i=0; i < iTr2 -1; i++)
      {
                 document.getElementsByName("txtLeaveTyp")[i].disabled="";
      }
}

function MiscelClick(optVal) 
{
    document.frmMaintDeptAttanLeave.action="../../../DeptAttanLeaveOptionClickAction.do";
    document.frmMaintDeptAttanLeave.txtEmpNo.value='';
    document.frmMaintDeptAttanLeave.txtEmpNameHdr.value='';
    document.frmMaintDeptAttanLeave.txtYYMM.value='';
    if(document.all.screenMode.value !='N')
     document.all.screenMode.value='Q';
    document.all.detailDataChanged.value='false';
    document.frmMaintDeptAttanLeave.optVal.value=optVal;        
    document.frmMaintDeptAttanLeave.submit(); 
}

function doInsertMode()
{    
    frmMaintDeptAttanLeave.action="../../../DeptAttanLeaveNewMode.do"
    frmMaintDeptAttanLeave.submit();
}


function checkLeaveDate()
{
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      } 
      var iTr2 = oTable.rows.length;
      var i = 0;
      for(i=0; i < iTr2 -1; i++)
      {
        if(document.getElementsByName("status")[i].value=='N')
        {
            var emp=document.getElementsByName("txtEmpCode")[i].value;
            var startDt=document.getElementsByName("txtFrom")[i].value;
            var endDt=document.getElementsByName("txtTo")[i].value;
            for(j=0; j < iTr2 -1; j++)
            {
            
               if(document.getElementsByName("status")[j].value!='D')
              {
                var tempEmp=document.getElementsByName("txtEmpCode")[j].value;
                var tempStartDt=document.getElementsByName("txtFrom")[j].value;
                var tempEndDt=document.getElementsByName("txtTo")[j].value;
          
                if((j!=i) && (tempEmp==emp))
                {
                  if(cmpDate(startDt,tempStartDt,1) && cmpDate(tempEndDt,startDt,1))
                  {
                    alert("Sorry!!! You Cannot Enter duplicate Leave records for employee "+emp+" !");
                    return false;
                  }
                  if(cmpDate(endDt,tempStartDt,1) && cmpDate(tempEndDt,endDt,1))
                  {
                    alert("Sorry!!! You Cannot Enter duplicate Leave records for employee "+emp+" !");
                    return false;
                  }
                }
              }
            }
        }
      }
  return true;
}

function enableLveType(indx)
{
	var screenmode = document.all.screenMode.value;
	if(screenmode == 'U')
	{
		if(frmMaintDeptAttanLeave.hdnEmpLbrFlag.value=='L')
		{
			if(document.getElementsByName("checked")[indx-1].checked)
			{
				document.getElementsByName("txtLeaveTyp")[indx-1].disabled="";
				document.getElementsByName("txtLeaveTyp")[indx-1].style.background="#ffffd3";
				document.getElementsByName("txtLeaveTyp")[indx-1].className="required";        
			}
			else
			{
				document.getElementsByName("txtLeaveTyp")[indx-1].disabled="true";
				document.getElementsByName("txtLeaveTyp")[indx-1].selectedIndex=3;
				document.getElementsByName("txtLeaveTyp")[indx-1].style.background="#e0e0e0";
				document.getElementsByName("txtLeaveTyp")[indx-1].className="locked";
			}
		}
	}
}


function disablePrevleaves()
{
var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      } 
      var iTr2 = oTable.rows.length;
      var i = 0;
	 var validDate= document.getElementById("payYYMM").value;
	
	 var mon=validDate.substring(4,6);

	 mon=mon-1;


	 var yyyy=validDate.substring(0,4);
	 

	 var Month =["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];	 var validdate2=(new Date(yyyy,mon,'01')).toDateString('dd-mm-yyyy');

	 var validdate2='01-'+Month[mon]+'-'+yyyy;
      for(i=0; i < iTr2 -1; i++)
      {
if(!cmpDate(validdate2,document.getElementsByName("txtFrom")[i].value,0) && document.getElementsByName("txtFrom")[i].value!='')
{

document.getElementsByName("checked")[i].disabled="true";
}

                
      }

}

function validFromDate(indx)
{

 var validDate= document.getElementById("payYYMM").value;
	
	 var mon=validDate.substring(4,6);
     var val=document.getElementsByName("txtFrom")[indx-1].value;
	 
	 mon=mon-1;


	 var yyyy=validDate.substring(0,4);
	 

	 var Month =["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];	 var validdate2=(new Date(yyyy,mon,'01')).toDateString('dd-mm-yyyy');

	 var validdate2='01-'+Month[mon]+'-'+yyyy;
	 
	 
	 if(!cmpDateMsg(val,validdate2,1,"You are not allowed to enter leaves before "+ validdate2))
	 {
	 document.getElementsByName("txtFrom")[indx-1].value="";
	 return false;
	 }

}

</script>

