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
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>
<%  String empLbr = (String)(request.getSession().getAttribute("hdnEmpLbrFlag"));
	
%>

<html:form  action="MaintEmpLeave" name="frmMaintEmpLeave" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpLeaveForm" scope="session">
<bean:define id="ParentForm" name="frmMaintEmpLeave" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN EMPLOYEE LEAVE INFORMATION</TD>
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
            <logic:equal property= "optVal" name= "frmMaintEmpLeave" value="E">
            <input type="radio" name="radioMisc" value="E" checked="true" onclick="MiscelClick(this.value)" >Employee Wise
            </logic:equal>
            <logic:notEqual property= "optVal" name= "frmMaintEmpLeave" value="E">
            <input type="radio" name="radioMisc" value="E" onclick="MiscelClick(this.value)" >Employee Wise
            </logic:notEqual>
            <td width="50%" colspan=2 class="radioText">
            <logic:equal property= "optVal" name= "frmMaintEmpLeave" value="E">
            <input type="radio" name="radioMisc" value="M" onclick="MiscelClick(this.value)" >All
            </logic:equal>
            <logic:notEqual property= "optVal" name= "frmMaintEmpLeave" value="E">
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
          <logic:equal property="screenMode" name= "frmMaintEmpLeave" value="N" >
            <html:text  property="txtYYMM" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="6" size="23" readonly="true" styleClass="locked"  /> </td>
          </logic:equal>
          <logic:notEqual property="screenMode" name= "frmMaintEmpLeave" value="N" >
            <html:text  property="txtYYMM" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="6" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                }; " size="23" styleClass="optional"  /> </td>
          </logic:notEqual>

          <!-- Added on 30 March 09 -->
          <td class="labelText"  width="25%" >To Year Month</td>
          <td>
          <logic:equal property="screenMode" name= "frmMaintEmpLeave" value="N" >
            <html:text  property="txtToYYMM" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="6" size="23" readonly="true" styleClass="locked"  /> </td>
          </logic:equal>
          <logic:notEqual property="screenMode" name= "frmMaintEmpLeave" value="N" >
            <html:text  property="txtToYYMM" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="6" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                }; " size="23" styleClass="optional"  /> </td>
          </logic:notEqual>
          <!-- End of New Code -->
          <tr>  
          <logic:equal property= "optVal" name= "frmMaintEmpLeave" value="E">
          <td class="labelText"  width="25%" ><bean:message key="Payroll.MaintElecMtrRdg.empno" /></td>
          <td><html:text  property="txtEmpNo" altKey="Payroll.MaintElecMtrRdg.empno" readonly="true" maxlength="10" size="23" styleClass="required"  />
			<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo1"  onclick="return ShowEmpNo();" > 
		</td>
          <html:hidden property="txtEmpNameHdr" />
          <html:hidden property="txtCpfCode" />  
          <html:hidden property="txtGend" />
          </logic:equal>
         
          <logic:notEqual property= "optVal" name= "frmMaintEmpLeave" value="E">
            <td width="25%" >&nbsp;</td>    <td>&nbsp; </td>
            <html:hidden  property="txtEmpNo" />
            <html:hidden property="txtEmpNameHdr" />
            <html:hidden property="txtCpfCode" />
			<html:hidden property="txtGend" />
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
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"   /></td>
                                              <TD class=tableHeader width="2%">S No.</TD>                                             
                                              <TD class=tableHeader width="2%">Employee Code</TD>
                                              <TD class=tableHeader width="3%">Employee Name</TD>
                                              <TD class=tableHeader width="3%">Leave Type</td>
                                              <td class=tableHeader width="3%">Leave Description</td>
                                              <td class=tableHeader width="2%">From Date</td> 
                                              <td class=tableHeader width="2%">To Date</td> 
                                              <td class=tableHeader width="5%">Leave Status</td> 
                                      </TR>    

                         <logic:iterate id="leaveInfo" name="frmMaintEmpLeave" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintEmpLeaveBean" >
                              <% ++i; %>
                                <logic:notEqual name="leaveInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                      
                                      <logic:notEqual name="leaveInfo" property="cancelStatus" value="" >
                                      <td align=center ><html:checkbox property="checked" disabled="true" name="frmMaintEmpLeave" onclick="checkRecord();" value="false" /></td>
                                      </logic:notEqual>
                                      <logic:equal name="leaveInfo" property="cancelStatus" value="" >
                                      <td align=center ><html:checkbox property="checked" name="frmMaintEmpLeave" alt="<%=String.valueOf(i)%>" onclick="checkRecord(); enableLveType(this.alt)" value="false" /></td>
                                      </logic:equal>
									   <td><html:text property="txtSrNo" name="Sno" size="3"   value="<%=String.valueOf(i)%>" styleClass="locked" style="width:70%" /></td>
                                      <logic:notEqual name="leaveInfo" property="status" value="N" >
                                        <td >
										<html:text property="txtEmpCode" name="leaveInfo" size="9" styleClass="locked" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>"  />
                                         <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtPayCode"   >
                                         <html:hidden property="txtGender"  name="leaveInfo" />
                                         <html:hidden property="txtCpfCode1"  name="leaveInfo" />
										 
                                         </td> 
                                        <td colspan="1"><html:text property="txtEmpName" name="leaveInfo"  styleClass="locked" readonly="true" alt="<%=String.valueOf(i)%>"  style="WIDTH: 90%"  /></td>  
                
                                         <td colspan="1">
										 <%
									if (empLbr.equals("E")) 
										{
										%>											
										 <html:select property="txtLeaveTyp" name="leaveInfo" disabled="true" styleClass="locked" alt="<%=String.valueOf(i)%>"  onchange="changeleave(this.alt)"  style="WIDTH: 100%"  >
                                        <html:option value="" >-----------Please Select-----------</html:option>      
                                        <logic:present name="LeaveTyp">
                                          <html:optionsCollection label="label" value="value" property="lvTypList" name="LeaveTyp"/>
                                        </logic:present>
                                        </html:select>
											<%       } 
										else 
												{%>

										<html:select property="txtLeaveTyp" name="leaveInfo" disabled="true" styleClass="locked"  alt="<%=String.valueOf(i)%>" onchange="changeleavedept(this.alt)"  style="WIDTH: 100%"  >
										<html:option value="" >-----------Department-----------</html:option> 
										<logic:present name="LeaveTyp">
									    <html:optionsCollection label="label" value="value" property="lvDepTypList" name="LeaveTyp"/> 		</logic:present>
										</html:select>

										<% }%> 

										</td>
                                        
                                         <td ><html:text property="txtLeaveDesc" name="leaveInfo" size="9" styleClass="locked" readonly="true"  style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" />
                                         </td>                                               
                                         <td ><html:text property="txtFrom" name="leaveInfo" size="9" styleClass="locked" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>"  />
                                         <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>"  />
                                         </td>                                               
  
                                         <td ><html:text property="txtTo" name="leaveInfo" size="9" readonly="true" styleClass="locked" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>"  />
                                         <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" alt="<%=(i-1) %>" />
                                         </td>

                                         <td ><html:text property="cancelStatus" name="leaveInfo" size="9" readonly="true" styleClass="locked" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  />
                                          </td>
                                                                                  
                                      </logic:notEqual>
                                      
                                    <logic:equal name="leaveInfo" property="status" value="N" >                                      
                                      <logic:equal name="frmMaintEmpLeave" property="optVal" value="E" > 
                                        <td ><html:text property="txtEmpCode" name="leaveInfo" size="9" styleClass="locked" readonly="true" style="width:75%;text-align:right" alt="<%=String.valueOf(i)%>"  />
                                         <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtPayCode"   >
                                         </td> 
                                       </logic:equal>
                                       <logic:notEqual name="frmMaintEmpLeave" property="optVal" value="E" >
                                        <td ><html:text property="txtEmpCode" name="leaveInfo" size="9" styleClass="required" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
                                         <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtPayCode"  onclick="ShowLovEmpNo(this.alt);" >
                                         </td>
                                        </logic:notEqual> 
                                        <html:hidden property="txtGender"  name="leaveInfo" />
										<html:hidden property="txtCpfCode1"  name="leaveInfo" />
                                        <td colspan="1"><html:text property="txtEmpName" name="leaveInfo" readonly="true"  styleClass="locked" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" onfocus="test1(this.alt)" style="WIDTH: 100%"  /></td>  
                
                                         <td colspan="1"><html:select property="txtLeaveTyp" name="leaveInfo"  styleClass="required" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt),changeleave(this.alt);"  style="WIDTH: 100%"  >
                                        <html:option value="" >-----------Please Select-----------</html:option>      
                                        <logic:present name="LeaveTyp">
                                          <html:optionsCollection label="label" value="value" property="lvTypList" name="LeaveTyp"/>
                                        </logic:present>
                                        </html:select></td>
                                        
                                         <td ><html:text property="txtLeaveDesc" name="leaveInfo" size="9" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
                                         </td>                                               
                                         <td ><html:text property="txtFrom" name="leaveInfo" size="9" styleClass="required" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return chk_PrevDt(this.alt)" />
                                         <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtFrom',this)" />
                                         </td>                                               
  
                                         <td ><html:text property="txtTo" name="leaveInfo" size="9" readonly="true" styleClass="required" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return chkFromDt(this.alt)" />
                                         <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" alt="<%=(i-1) %>" onclick="showCalendar('txtTo',this)" />
                                         </td>
                                         
                                         <td ><html:text property="cancelStatus" name="leaveInfo" size="9" readonly="true" styleClass="locked" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  />
                                          </td>
                                          
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
                                       <td ><html:hidden property="checked" name="frmMaintEmpLeave" value="notchecked" /></td>
                                       <td ><html:hidden property="txtEmpCode" name="leaveInfo" /></td>
                                        <html:hidden property="txtGender"  name="leaveInfo" />
                                       <td ><html:hidden property="txtEmpName" name="leaveInfo"  value="A" /></td>
                                       <td ><html:hidden property="txtLeaveTyp" name="leaveInfo" /></td>
                                       <td ><html:hidden property="txtLeaveDesc" name="leaveInfo" /></td>
                                       <td ><html:hidden property="txtFrom" name="leaveInfo" /></td> 
                                       <td ><html:hidden property="txtTo" name="leaveInfo" /></td>
                                       <td ><html:hidden property="cancelStatus" name="leaveInfo" /></td> 
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
				
								<% if(empLbr.equals("L")) { 
								%> 
 <jsp:include page = "../INCLUDES/GenDetailLeaveMenudept.jsp" flush="true" /> 


								<%}else { %>
 <jsp:include page = "../INCLUDES/GenDetailLeaveMenu.jsp" flush="true" /> 

								<% }%>
                            
						
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
<html:hidden property="headerPrimaryKey" name="frmMaintEmpLeave" value="Default" />
<html:hidden property="loginLocCode" name="frmMaintEmpLeave"  />
<html:hidden property="screenMode" name="frmMaintEmpLeave"  />
<html:hidden name="frmMaintEmpLeave"  property="screenName" value="LeaveScreen" />
<html:hidden name="frmMaintEmpLeave"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmMaintEmpLeave"  />
<html:hidden property="lovKey" name="frmMaintEmpLeave"  />
<html:hidden property="txtFields" name="frmMaintEmpLeave"  />   
<html:hidden property="txtSearchFields" name="frmMaintEmpLeave"  />
<html:hidden property="txtDisplayFields" name="frmMaintEmpLeave"  />
<html:hidden property="txtIndex" name="frmMaintEmpLeave"  />
<html:hidden property="optVal" name="frmMaintEmpLeave"  />
<input type="hidden" name="queryParam" />
<html:hidden property="pageRequested" name="frmMaintEmpLeave" />
<html:hidden property="userPageRequested" name="frmMaintEmpLeave" />
<html:hidden property="userPositionRequested" name="frmMaintEmpLeave" />
 <!--Added by Varalika on 03-Oct-2011-->     
<html:hidden property="txtUpdatedSite"  name="frmMaintEmpLeave" />
<html:hidden property="txtCreationDate" name="frmMaintEmpLeave" />
<html:hidden property="txtCreatedBy"    name="frmMaintEmpLeave" />
<html:hidden property="txtCreatedSite"  name="frmMaintEmpLeave" />
<html:hidden property="txtUpdationDate" name="frmMaintEmpLeave" />
<html:hidden property="txtUpdatedBy"    name="frmMaintEmpLeave" />
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
      frmMaintEmpLeave.screenMode.value = 'U';
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

 }

 function changed(val)
{
   frmMaintEmpLeave.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}

function doBaseAddRow()
{
  if(mandatory_Check("frmMaintEmpLeave"))
  {
	  var emp_type = document.getElementById("hdnEmpLbrFlag").value;
	  if(emp_type == 'L' || emp_type == 'D')
	  {
		  alert("you can not add leaves for labours. Days marked absent in attendance will come automatically.");
		  return;
	  }

	 var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
     var iTr2 = oTable.rows.length;
    EnableFields();  
    document.forms[0].action = "../../../EmpLeaveAddRowAction.do";
    document.forms[0].submit();
  }
  else
  {
      return false;
  }
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintEmpLeave"))
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
      frmMaintEmpLeave.headerFields.value = "false";
      frmMaintEmpLeave.screenMode.value = "U";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintEmpLeave.action = "../../../EmpLeaveSaveAction.do";
      // frmMaintHraRate.totalDetailRecord.value=parseInt(iTr2)-1;
      frmMaintEmpLeave.submit();
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
  
  frmMaintEmpLeave.action="../../../EmpLeaveQueryAction.do"
  frmMaintEmpLeave.submit();
}

function GetDetail()
{
  if(mandatory_Check("frmMaintEmpLeave"))
  { 
  document.all.screenMode.value='U'; 
  frmMaintEmpLeave.action="../../../EmpLeaveGetDetailAction.do"
  frmMaintEmpLeave.submit();
  }
  else{
    return false;
  }
}

function checkRecord()
{

var emptyp=document.getElementById("hdnEmpLbrFlag").value;

if(emptyp=='L')
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

document.all.butConvert.disabled="";
document.all.butHistory.disabled="";
return true;
}
}
if(fl == 0)
{

document.all.butConvert.disabled="true";
document.all.butHistory.disabled="";
return false;
} 


}
else{
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
 
}
 

function doRefresh()
{
  frmMaintEmpLeave.action="../../../EmpLeaveRefresh.do"
  frmMaintEmpLeave.submit();
}
     


function doBaseDelRow()
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
  document.forms[0].action = "../../../EmpLeaveDeleteRowAction.do";
  document.forms[0].submit();
}

function ShowLovEmpNo(i)
{

  document.getElementsByName("txtLeaveTyp")[i-1].selectedIndex=0;	
   frmMaintEmpLeave.lovKey.value = "EmpNo" +frmMaintEmpLeave.screenName.value + frmMaintEmpLeave.screenMode.value;
   frmMaintEmpLeave.txtDisplayFields.value = "txtEmpCode,txtEmpName,txtCpfCode1,txtGender";                                       // added by dushyant for cpf code
   frmMaintEmpLeave.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";      // added by dushyant for cpf code
   frmMaintEmpLeave.txtIndex.value=i-1;
   frmMaintEmpLeave.queryParam.value="txtSiteID="+ frmMaintEmpLeave.loginLocCode.value +",hdnEmpLbrFlag="+frmMaintEmpLeave.hdnEmpLbrFlag.value  ;
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintEmpLeave');
   frmMaintEmpLeave.detailDataChanged.value = "true";
   changed(i);
   return true;
}

function ShowEmpNo()
{
    frmMaintEmpLeave.lovKey.value = "EmpNo" +frmMaintEmpLeave.screenName.value + frmMaintEmpLeave.screenMode.value;
     frmMaintEmpLeave.txtDisplayFields.value = "txtEmpNo,txtEmpNameHdr,txtCpfCode,txtGend";                                     // added by dushyant for cpf code
     frmMaintEmpLeave.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode,Payroll.EmpInfo.Gender";    // added by dushyant for cpf code
     frmMaintEmpLeave.txtIndex.value="";
     frmMaintEmpLeave.queryParam.value="txtSiteID="+ frmMaintEmpLeave.loginLocCode.value +",hdnEmpLbrFlag="+frmMaintEmpLeave.hdnEmpLbrFlag.value  ;
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintEmpLeave');
     return true;
}
function showLov(pageName, formName) {
var oLovWin=window.open(pageName,formName, "height=500,width=900,resizable=yes,menubar=no,toolbar=none,statusbar=none");
oLovWin.moveTo(200,200);
//oLovWin.document.all.hdnLOVFlag.value = '0';
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
          frmMaintEmpLeave.detailDataChanged.value = "true";
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
  document.forms[0].action = "../../../EmpLeaveSaveAction.do";
  document.forms[0].submit();
}

function doBaseConvert()
{
  document.all.butConvert.disabled="true";
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
          document.getElementsByName("status")[i].value = "V";
          frmMaintEmpLeave.detailDataChanged.value = "true";
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
  document.all.screenMode.value='V';
  document.forms[0].action = "../../../EmpLeaveSaveAction.do";
  document.forms[0].submit();
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
  frmMaintEmpLeave.detailDataChanged.value = "true";
  document.all.screenMode.value='C';  
  document.forms[0].action = "../../../EmpLeaveSaveAction.do";
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
				  if(!(frmMaintEmpLeave.txtCreationDate[i].value&&frmMaintEmpLeave.txtCreatedBy[i].value&&frmMaintEmpLeave.txtCreatedSite[i].value))
				  {
				  alert("No history exists for the selected record");
				  }
				  else
				  {
				
				  alert("Record History "+"\n"
				  +"Creation Date :  "+ frmMaintEmpLeave.txtCreationDate[i].value
				  +"\n"
				  +"Created By      :  "+frmMaintEmpLeave.txtCreatedBy[i].value
				  +"\n"
				  +"Created Site    :  "+frmMaintEmpLeave.txtCreatedSite[i].value
				  +"\n"
				  +"Updation Date:  "+frmMaintEmpLeave.txtUpdationDate[i].value
				  +"\n"
				  +"Updated By     :  "+frmMaintEmpLeave.txtUpdatedBy[i].value
				  +"\n"
				  +"Updated Site   :  "+frmMaintEmpLeave.txtUpdatedSite[i].value
				  );
				}
              }
              else
              {
              if(!(frmMaintEmpLeave.txtCreationDate[i].value&&frmMaintEmpLeave.txtCreatedBy[i].value&&frmMaintEmpLeave.txtCreatedSite[i].value))
              {
              alert("No history exists for the selected record");
              }
              else
              {
              alert("Record History"+"\n"
              +"Creation Date :  "+ frmMaintEmpLeave.txtCreationDate[i].value+"\n"
              +"Created By      :  "+frmMaintEmpLeave.txtCreatedBy[i].value
              +"\n"
              +"Created Site    :  "+frmMaintEmpLeave.txtCreatedSite[i].value
              +"\n"
              +"Updation Date:  "+frmMaintEmpLeave.txtUpdationDate[i].value
              +"\n"
              +"Updated By     :  "+frmMaintEmpLeave.txtUpdatedBy[i].value
              +"\n"
              +"Updated Site   :  "+frmMaintEmpLeave.txtUpdatedSite[i].value
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
        //  showHistWin('<html:rewrite page="/Payroll/JSP/COMMON/JSP/ShowHistory.jsp" />', 'frmMaintEmpLeave');
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
    frmMaintEmpLeave.userPageRequested.value = 1*frmMaintEmpLeave.pageRequested.value - 1;
    frmMaintEmpLeave.action = "../../../EmpLeaveNextDetailAction.do";
    frmMaintEmpLeave.submit();
}


function doBaseNextDetail()
{
    frmMaintEmpLeave.userPageRequested.value = 1*frmMaintEmpLeave.pageRequested.value + 1;
    frmMaintEmpLeave.action = "../../../EmpLeaveNextDetailAction.do";
    frmMaintEmpLeave.submit();
}

function JumpDetail()
{
    frmMaintEmpLeave.userPageRequested.value = 1*frmMaintEmpLeave.newPageRequested.value ;
    frmMaintEmpLeave.action = "../../../EmpLeaveNextDetailAction.do";
    frmMaintEmpLeave.submit();
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
    document.frmMaintEmpLeave.action="../../../EmpLeaveOptionClickAction.do";
    document.frmMaintEmpLeave.txtEmpNo.value='';
    document.frmMaintEmpLeave.txtEmpNameHdr.value='';
    document.frmMaintEmpLeave.txtYYMM.value='';
    if(document.all.screenMode.value !='N')
     document.all.screenMode.value='Q';
    document.all.detailDataChanged.value='false';
    document.frmMaintEmpLeave.optVal.value=optVal;        
    document.frmMaintEmpLeave.submit(); 
}

function doInsertMode()
{    
    frmMaintEmpLeave.action="../../../EmpLeaveNewMode.do"
    frmMaintEmpLeave.submit();
}

function changeleave(val)
{
   
    var lvtyp=document.getElementsByName('txtLeaveTyp')[val-1].value;
   // alert('employee');

     if(document.getElementById("optVal").value=='E')
     {
      var gen=document.getElementById("txtGend").value;
      //alert(gen);
 
      if(gen=="")
      {
        alert("Please select employee first");
        return false;
    }
    else if(gen=='M')
    {
        
        if (lvtyp=='LVTYP$ML') 
        {
            alert("You can not give Maternity Leave to Male Employee");
            document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
            return false;
        }
      /*  if (lvtyp=='LVTYP$CCL') 
        {
            alert("You can not give Child Care Leave to Male Employee");
            document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
            return false;
        }*/
    }
    else if (gen=='F')
    {
         
         if(lvtyp=='LVTYP$PL')
         {
            alert("You can not give Paternity Leave to Female Employee");
            document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
            return false;
         }
    }
    
 }
 
 else {
      var gen1=document.getElementsByName("txtGender")[val-1].value;
    // alert(gen1);
 
    if(gen1=="")
    {
        alert("Please select employee first");
        return false;
    }
    else if(gen1=='M')
    {
        
        if (lvtyp=='LVTYP$ML') 
        {
            alert("You can not give Maternity Leave to Male Employee");
            document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
            return false;
        }
        /*if (lvtyp=='LVTYP$CCL') 
        {
            alert("You can not give Child Care Leave to Male Employee");
            document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
            return false;
        }*/
    }
    else if (gen1=='F')
    {
         
         if(lvtyp=='LVTYP$PL')
         {
            alert("You can not give Paternity Leave to Female Employee");
            document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
            return false;
         }
    }
    
     
     
 }
 
 
	return true;
}

function changeleavedept(val)
{
 //System.out.print("inside dept");
  var emp_type = document.getElementById("hdnEmpLbrFlag").value;
  var lvtyp=document.getElementsByName('txtLeaveTyp')[val-1].value;
   
     //  alert('A');

   
   if(emp_type=='L')
 {
   
     if(lvtyp=='LVTYP$LWP')
    {
     alert("Leave Without Pay is not applicable for departmental labours");
     document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
     return false;
    }
   if(document.getElementById("optVal").value=='E')
     {
        var gen=document.getElementById("txtGend").value;
   
      // alert(gen);
        if(gen=='M')
        {
       //  alert("inside dept1");
        
        if (lvtyp=='LVTYP$ML') 
           {
            alert("You can not give Maternity Leave to Male Employee");
            document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
            return false;
           }
        }
     }
  else
  {
  
     var gen1=document.getElementsByName("txtGender")[val-1].value;
   
      // alert(gen1);
        if(gen1=='M')
        {
        if (lvtyp=='LVTYP$ML') 
           {
            alert("You can not give Maternity Leave to Male Employee");
            document.getElementsByName('txtLeaveTyp')[val-1].selectedIndex=0;
            return false;
           }
        }
  }
  
 } 
 return true;
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
              if(document.getElementsByName("status")[i].value!='D')
              {
                var tempEmp=document.getElementsByName("txtEmpCode")[j].value;
                var tempStartDt=document.getElementsByName("txtFrom")[j].value;
                var tempEndDt=document.getElementsByName("txtTo")[j].value;
                if((j!=i) && (tempEmp==emp) && (document.getElementsByName("cancelStatus")[j].value==''))
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
		if((frmMaintEmpLeave.hdnEmpLbrFlag.value=='L') || (frmMaintEmpLeave.hdnEmpLbrFlag.value=='D'))
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

</script>

