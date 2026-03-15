<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
 	<head><%response.setHeader("Cache-Control", "no-cache"); response.setHeader("Cache-Control", "no-store"); response.setHeader("Pragma", "no-cache"); response.setDateHeader("Expires", 0); %>
  <html:base/>
	<TITLE><bean:message key="Payroll.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

     <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
     <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
  </HEAD>

<BODY scroll=yes onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">

<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>
<html:form action="EmpSixPayAction" name="frmEmpPayForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpPaySixPayForm" scope="session">
<bean:define id="ParentForm" name="frmEmpPayForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>  
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />

<TABLE cellSpacing=0 cellPadding=0 border=0 >

	<TR height=30>
		<TD colSpan=11 class=mainHeader height=10>DEFINE EMPLOYEE CAFETERIA APPROACH</TD>
	</TR>

    <TR>
		<TD class=subHeader colspan=6> Employee Header</TD>
	</TR>
	<TR>
	    <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	</TR>
	<tr>
		<td height="10"></td>
	</tr>

	<table>
			<table cellSpacing=0 cellPadding=0 border=0 >
					<TR>
							<TD class=labelText width="22%"><bean:message key="Payroll.EmpInfo.Empno" /></TD>
							<td align="left" >
								<html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
								<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowLovEmp();">
							</td>  

							<td class=labelText  width="20%" >Employee Name </td>
							<td>                             
								<html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
							</td>
						
					</TR> 
              
					  <TR>              
							  <TD width="15%" class=labelText><bean:message key="Payroll.EmpInfo.Desig" /></TD>
							  <td align="left">
									<html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>
							  </td>
							  
							  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
							  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/></td>                  
											
					  </tr>
                      
					  <tr>
							  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
							  <td>
									<html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                  
							  </td> 
							  
							  <td class=labelText><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
							  <td>
									<html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" readonly="true" maxlength="7" size="23" styleClass="locked" style="text-align:right"   />
							  </td>
					  </tr>                  
      
					  <tr>
							  <td class=labelText><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
							  <td>
									<html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" styleClass="locked" readonly="true"/>
							  </td>
							  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
							  <td>
									<html:text property="txtEmpStatus" name="frmEmpPayForm" readonly="true" size="23" styleClass="locked" alt="<%=String.valueOf(i)%>"  />
							  </td> 
					  </tr>   
              
					  <tr>
							  <td class="labelText"><bean:message key="Payroll.SupplyPay.PayScale" /></td>
							  <td>
									<html:text property="txtPayScale" size="23" readonly="true" styleClass="locked" />
							  </td>
							  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.FinYear" /> </td>                            
							  <td>
									<logic:equal name="frmEmpPayForm" property="screenMode" value="Q" >
										<html:text property="txtYYMM" size="23" maxlength="6" onblur="chk_YearMonth()" onkeypress="return numbersonly(event)" />(YYYYYY)
									</logic:equal>
									<logic:notEqual name="frmEmpPayForm" property="screenMode" value="Q" >
										<logic:equal name="frmEmpPayForm" property="screenMode" value="U" >
											<html:text property="txtYYMM" size="23" maxlength="6" styleClass="locked" readonly="true" />(YYYYYY)
										</logic:equal>
										<logic:notEqual name="frmEmpPayForm" property="screenMode" value="U" >
											<html:text property="txtYYMM" size="23" maxlength="6" styleClass="required" onblur="chk_YearMonth()" onkeypress="return numbersonly(event)" />(YYYYYY)
										</logic:notEqual>
									</logic:notEqual>
									<html:hidden property="hdnFinYear" name="frmEmpPayForm" />
									<html:hidden property="hdnDesgId" name="frmEmpPayForm" />
									<html:hidden property="hdnHandFlag" name="frmEmpPayForm" />
							  </td>
					  </tr>
					  <tr>
							  <td width="15%" class=labelText>Effective Date </td>                            
							  <td>
									<logic:equal name="frmEmpPayForm" property="screenMode" value="Q" >
										<html:text property="txtEffDt" size="23" maxlength="6" readonly="true" />
										<img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffDt',this)" />
									</logic:equal>
									<logic:notEqual name="frmEmpPayForm" property="screenMode" value="Q" >
										<logic:equal name="frmEmpPayForm" property="screenMode" value="U" >
											<html:text property="txtEffDt" size="23" maxlength="6" readonly="true" styleClass="locked" />
											<img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtEffDt',this)" />
										</logic:equal>
										<logic:notEqual name="frmEmpPayForm" property="screenMode" value="U" >
											<html:text property="txtEffDt" size="23" maxlength="6" readonly="true" styleClass="required" />
											<img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffDt',this)" />
										</logic:notEqual>
									</logic:notEqual>

							  <td width="15%" class=labelText>Using Official Vehicle</td>
							  <td>
									<logic:equal name="frmEmpPayForm" property="screenMode" value="Q" >
										<html:select property="chkVhclType" name="frmEmpPayForm" style="width:145;text-align:left" >
											<html:option value="N">No</html:option>
											<html:option value="Y">Yes</html:option>
										</html:select>                                    
									</logic:equal>
									<logic:notEqual name="frmEmpPayForm" property="screenMode" value="Q" >
										<logic:equal name="frmEmpPayForm" property="screenMode" value="U" >
											<html:select property="chkVhclType" name="frmEmpPayForm" style="width:145;text-align:left" onchange="Calc_Tot_Percent_Excess()" >
												<html:option value="N">No</html:option>
												<html:option value="Y">Yes</html:option>
											</html:select>                                    
										</logic:equal>
										<logic:notEqual name="frmEmpPayForm" property="screenMode" value="U" >
											<html:select property="chkVhclType" name="frmEmpPayForm" styleClass="required" style="width:145;text-align:left" onchange="Calc_Tot_Percent_Excess();"  >
												<html:option value="N">No</html:option>
												<html:option value="Y">Yes</html:option>
											</html:select>                                    
										</logic:notEqual>
									</logic:notEqual>
							  </td>
							  </td>
					  </tr>

	</table>
	<tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Payment Information<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                            <DIV id=divDtlTable style="height:350px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                <TBODY>
                                     <TR height="20">
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                              <TD class=tableHeader width="2%">Pay Code</TD>
                                              <TD class=tableHeader width="4%">Pay Code Desc</TD>
                                              <TD class=tableHeader width="3%">Percentage</td>
                                              <TD class=tableHeader width="3%">Mode Of Payment</td>
                                      </TR>    

                         <logic:iterate id="empPayid" name="frmEmpPayForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EmpPaySixBean" indexId="idx"  >
                              <% ++i; %>
                                <logic:notEqual name="empPayid" property="status" value="D" >

                                   <tr>   <% ++j; %>

                                      <td align=center >
											<html:checkbox property="checked" name="frmEmpPayForm" onclick="checkRecord();" value="false" />
									  </td>

									  <logic:equal name="empPayid" property="status" value="N" >
										  <td align="right">
												<html:text property="txtPayCode" name="empPayid" style="width:70%;text-align:right" styleClass="required" readonly="true" alt="<%=String.valueOf(i)%>" />
												<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowPayCode(this.alt);"  />&nbsp;&nbsp;
                                          </td>
										  <td align="left">
												<html:text property="txtPayDesc" name="empPayid" readonly="true" styleClass="locked" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" />
										  </td>
										  <td align="center">
												<html:text property="txtPrcntage" name="empPayid" readonly="true" styleClass="locked" style="width:50%;text-align:right" alt="<%=String.valueOf(i)%>" />
										  </td>
                                          <td colspan="1" align="center">
											   <html:select property="txtPayMode" name="empPayid" styleClass="required" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>" >
													<html:option value="A">Allowance</html:option>
													<html:option value="R">Reimbursement</html:option>
											   </html:select>                                    
										  </td>
									 </logic:equal>

                                     <logic:notEqual name="empPayid" property="status" value="N" >
										  <td align="right">
												<html:text property="txtPayCode" name="empPayid" style="width:70%;text-align:right" styleClass="required" readonly="true" alt="<%=String.valueOf(i)%>" />
												<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode" onclick="ShowPayCode(this.alt);"  />&nbsp;&nbsp;
                                          </td>  
										  <td align="left">
												<html:text property="txtPayDesc" name="empPayid" readonly="true" styleClass="locked" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>"  />
										  </td>
										  <td align="center">
												<html:text property="txtPrcntage" name="empPayid" readonly="true" styleClass="locked" style="width:50%;text-align:right" alt="<%=String.valueOf(i)%>"  />
										  </td>
                                          <td colspan="1" align="center">
											   <html:select property="txtPayMode" name="empPayid" styleClass="required" style="width:70%;text-align:right" alt="<%=String.valueOf(i)%>" >
													<html:option value="A">Allowance</html:option>
													<html:option value="R">Reimbursement</html:option>
											   </html:select>                                    
										  </td>

                                    </logic:notEqual>

                                       <html:hidden property="itemChecked" name="empPayid" />
                                       <html:hidden property="status" name="empPayid" />
                                       <html:hidden property="detailId" name="empPayid" />
									</tr>
                           </logic:notEqual>

                                  <logic:equal name="empPayid" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmEmpPayForm" value="notchecked" /></td>
                                       <td ><html:hidden property="txtPayCode" name="empPayid" /></td>
                                       <td ><html:hidden property="txtPayDesc" name="empPayid" /></td>
                                       <td ><html:hidden property="txtPrcntage" name="empPayid" /></td>
                                       <td ><html:hidden property="txtPayMode" name="empPayid" /></td>
                                       <html:hidden property="itemChecked" name="empPayid" />
                                       <html:hidden property="status" name="empPayid" />
                                       <html:hidden property="detailId" name="empPayid" />
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
											<jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
										</TD> 
									</TR>

									<TR>
										<TD colspan="11">
										  <table border=0>
												<tr>
													<td width="15%" class=labelText>Enter Pay Code to adjust</td>
													<td align="left" width="15%">
														<html:text property="txtPayCodeAdj" name="frmEmpPayForm" styleClass="locked" readonly="true" style="text-align:right" size="10" onkeypress="return numbersonly(event)" onblur="IfPayCode_Inlist()" />
													</td> 
												</tr>

												<tr>
													<td width="15%" class=labelText>Enter Corresponding Percentage of Pay Code to adjust</td>
													<td align="left" width="15%">
														<html:text property="txtPayCodePerc" name="frmEmpPayForm" styleClass="locked" readonly="true" style="text-align:right" size="10" onblur="IfPerc_Inlist()" />&nbsp;% ( If Applicable )
													</td> 
												</tr>
												<tr>
													<td width="15%" class=labelText>Excess Percentage</td>
													<td align="left" width="15%">
														<html:text property="txtPercAdj" name="frmEmpPayForm" styleClass="locked" readonly="true" style="text-align:right" size="10" />&nbsp;%&nbsp;
													</td> 
												</tr>
										  </table>
										<TD>
									</TR>
									<tr>
										<td height="10"></td>					
									</tr>
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
           <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />

           <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
            <% if(smode.equals(new String("U"))) {%> 
            Update Mode
           <%} else if(smode.equals(new String("N"))) {  %>
            New Mode
           <%} else if(smode.equals(new String("Q"))) {  %>
            Query Mode
           <%}  %>
           </td> 
          
           <td align=center bgcolor=#4682b4 width="35%"></td>
           <td bgcolor=#4682b4><html:button value='Copy To Next Financial Year' onclick="copyToNxtFinYear()" property="butInsert1" styleClass="bottomBarText" /></td>
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
<html:hidden property="txtPayRevFlag" name="frmEmpPayForm" />
<html:hidden property="screenMode" name="frmEmpPayForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpPayForm" />
<html:hidden property="loginLocCode" name="frmEmpPayForm"  />
<html:hidden name="frmEmpPayForm" property="screenName" value="EmpSixPayScreen" />
<html:hidden name="frmEmpPayForm" property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmEmpPayForm"  />
<html:hidden property="lovKey" name="frmEmpPayForm"  />
<html:hidden property="txtFields" name="frmEmpPayForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpPayForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpPayForm"  />
<html:hidden property="txtIndex" name="frmEmpPayForm"  />
<html:hidden property="txtInputField" name="frmEmpPayForm"  />
<html:hidden property="userPageRequested" name="frmEmpPayForm"  />
<html:hidden property="pageRequested" name="frmEmpPayForm"  />
<html:hidden property="positionRequested" name="frmEmpPayForm" />
<html:hidden property="userPositionRequested" name="frmEmpPayForm" />
<html:hidden property="totalDetailRecord" name="frmEmpPayForm"  />

<html:hidden property="userBtn" name="frmEmpPayForm"  />
<html:hidden property="userBtn1" name="frmEmpPayForm"  />
<html:hidden property="chkUpdtBtn" name="frmEmpPayForm"  />

<input type="hidden" name="queryParam" />

</html:form>


</body>
</html:html>


<script language="javascript">

function copyToNxtFinYear()
{
	if(mandatory_Check("frmEmpPayForm"))
	{
		var actFinYr = document.all.hdnFinYear.value;
		if(confirm("Do you want to copy benefits to the financial year : "+actFinYr))
		{
			document.getElementById("butInsert1").disabled="true";
			if (!chkRcdsToCopy()) return;
			
			var actYY = actFinYr.substring(0,4);
			var usrFinYr = document.all.txtYYMM.value;
			var y1 = usrFinYr.substring(0,4);
			y1 = eval(y1)+1;
			var y2 = eval(y1)+1;
			y2 = (y2+'').substr(2,4);
			if (y1 <= actYY)
			{
				document.all.txtYYMM.value = (y1+y2);
			}
			SaveRecord();
		}
	}
}

function chkRcdsToCopy()
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return false;
	}

	var iTr2 = oTable.rows.length;
	if(iTr2 > 1)
	{
		return true;
	}
	else
	{
		alert("There is no record to copy. \n Please ensure that you have pressed the 'Get Detail' button. ");
		return false;
	}
}

function lfnLoad()
{
  var screenmode = document.all.screenMode.value;
  var mode1 = document.all.userBtn.value;
  //alert("screenmode=="+screenmode+"=mode1=="+mode1)
  if(screenmode == '')
  {
      doQueryMode();
  }  
  if(screenmode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }
  if(screenmode=='Q')
  {
	 document.all.butGetDetail.disabled="disabled";
     document.all.butInsert.disabled="disabled";
  } 
  if(screenmode=='U')
  {

		if(mode1=='false')
		{
			frmEmpPayForm.butGetDetail.disabled="";
			frmEmpPayForm.butInsert.disabled="true";
			frmEmpPayForm.butDelete.disabled="true";
		}    
		if(mode1=='true')
		{
			frmEmpPayForm.butGetDetail.disabled="true";
			frmEmpPayForm.butInsert.disabled="";
			frmEmpPayForm.butDelete.disabled="";
		}
	 
  }

  menuHandling(screenmode);

  if(document.all.hdnEmpLbrFlag.value=='V')
  {
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butInsert.disabled="true";
   }
   //Disabling INsert Mode  and Delete Mode 
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
 }

function resetFields()
{
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var payCodeAdjPercObj = document.getElementById("txtPayCodePerc");
	if(payCodeAdjObj.value != "")
	{
		payCodeAdjObj.select();
		frmEmpPayForm.txtPercAdj.value = "";
		payCodeAdjPercObj.value = "";
		payCodeAdjPercObj.className = "locked";
		payCodeAdjPercObj.style.background = "#e0e0e0";
		payCodeAdjPercObj.readOnly = true;
	}
	else
	{
		frmEmpPayForm.txtPercAdj.value = "";
		payCodeAdjPercObj.value = "";
		payCodeAdjPercObj.className = "locked";
		payCodeAdjPercObj.style.background = "#e0e0e0";
		payCodeAdjPercObj.readOnly = true;
		if(Calc_Tot_Percent_Excess()) return;
		else
		{
			payCodeAdjObj.className = "locked";
			payCodeAdjObj.style.background = "#e0e0e0";
			payCodeAdjObj.readOnly = true;
		}
	}
}

function SaveRecord()
{//alert("save");
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var txtPercAdjObj = document.getElementById("txtPercAdj");
	//resetFields();
	if(Child_Allow_Chk()) return;
	//alert(1);
        if(Duplicacy_Chk()) return;
	//alert(2);
        if(Calc_Tot_Percent_Excess()) return; //checking excess %age .
	//alert(3);
        if(Calc_Tot_Percent_Lag()) return; //checking if total %age of allowances lagging specified %age.
	//alert(4);
        if(payCodeAdjObj.value != "" && txtPercAdjObj.value == "") IfPayCode_Inlist(); // check wheather paycode present in the list. calculate adjust percentage.
//alert(5);
	if(mandatory_Check("frmEmpPayForm"))
	{
		var oTable = document.getElementById("Detail");
		if(oTable == null)
		{
			return;
		}
		var iTr2 = oTable.rows.length;
		if(iTr2 > 1)
		{
			frmEmpPayForm.detailDataChanged.value = "true";
			frmEmpPayForm.headerPrimaryKey.value = "";
			document.all.buttonFlag.value='SV';	
			document.all.userBtn1.value = 'EX';
			frmEmpPayForm.headerFields.value = "false";
	        document.all.butSave.disabled="true";
		    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
			frmEmpPayForm.action = "../../../EmpSixPayActionSaveAction.do";
			frmEmpPayForm.submit();
		}
		else 
		{
			return false;
		}
	}
	else
	{
		//disable();
		return false;
	}
}

function doBaseAddRow()
{
  if(mandatory_Check("frmEmpPayForm"))
  {
        clrAdjustPerc();
		if(Child_Allow_Chk()) return;
		if(Duplicacy_Chk()) return;
		if(Calc_Tot_Percent_Exact()) return; //if total percent of allowances is exactly equal to specified percentage.
     	if(Calc_Tot_Percent_Excess()) return; //if excess %age entered then prompt to enter adjust paycode.
		if(document.all.chkUpdtBtn.value == "true") frmEmpPayForm.headerPrimaryKey.value = "";
		if(document.all.userBtn1.value == 'EX') document.all.buttonFlag.value = '';
		else document.all.buttonFlag.value='IN';
		document.all.screenMode.value='U';
		document.all.userBtn.value = "true";
		document.forms[0].action = "../../../EmpSixPayActionAddRowAction.do";
		document.forms[0].submit();
  }
  else
  {
	  return false;
  }
}

function Child_Allow_Chk()
{
	var oTable = document.getElementById("Detail");

	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;
	var count = 0;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value!='D')
		{
			var temp1 = document.getElementsByName("txtPayCode")[i].value;
			var temp2 = 116;
			if (eval(temp1) == eval(temp2))
			{
				count++;
			}
		}
	}

	if (count > 2)
	{
		alert("Children Education Allowance is Restricted to 2 children only. Please delete additional record(s)");
		return true;
	}
	return false;
}
	
function Duplicacy_Chk()
{
	var oTable = document.getElementById("Detail");

	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0, j = 0;
	var count = 0;
	var rows = 0;
	var delrowcnt = 0;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value != 'D')
		{
			var paycode_i = document.getElementsByName("txtPayCode")[i].value;
			var percent_i = document.getElementsByName("txtPrcntage")[i].value;
			var chld_allwn = 116;
			var trns_allwn = 166;
			var cony_allwn = 216;
			if (eval(paycode_i) != eval(chld_allwn))
			{
				for(j=i+1; j < (iTr2-1); j++)
				{
					var paycode_j = document.getElementsByName("txtPayCode")[j].value;
					var percent_j = document.getElementsByName("txtPrcntage")[j].value;
					if((document.getElementsByName("status")[j].value != 'D'))
					{
						
						delrowcnt++
						if ((eval(paycode_i) == eval(paycode_j)) && (eval(percent_i) == eval(percent_j)))
						{
							count++;
							rows =delrowcnt +" or "+ (delrowcnt+1);
						}
						/*if ((eval(paycode_j) == eval(trns_allwn)) || (eval(percent_j) == eval(cony_allwn)) && (eval(paycode_i) == eval(trns_allwn)) || (eval(percent_i) == eval(cony_allwn)) )
						{
							count++;
							rows =delrowcnt +" or "+ (delrowcnt+1);
						}*/
						if( (eval(paycode_i) == eval(trns_allwn)) && (eval(paycode_j) == eval(cony_allwn))&& (eval(percent_i)!=0 && eval(percent_j)!=0 ))
						{
							count++;
							rows =delrowcnt +" or "+ (delrowcnt+1);
						}
						if( (eval(paycode_i) == eval(cony_allwn)) && (eval(paycode_j) == eval(trns_allwn)) && (eval(percent_i)!=0 && eval(percent_j)!=0 ))
						{
							count++;
							rows =delrowcnt +" or "+ (delrowcnt+1);
						}
						
					}
				}
			}
			

		}
	}

	if (count > 0)
	{
		alert("Duplicate Allowance is not allowed, except Children Education Allowance. Please delete the Duplicate Allowance");
		return true;
	}
	return false;
}

function Calc_Tot_Percent_Exact()
{
	var totPerc = 0;
	var vhclType = document.getElementById("chkVhclType").value;
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var payCodeAdjPercObj = document.getElementById("txtPayCodePerc");
	var oTable = document.getElementById("Detail");
	totPerc = Calc_Tot_Perc();
	var designation_id=frmEmpPayForm.hdnDesgId.value;
	if(vhclType == "Y")
	{
		if (eval(totPerc) == 25)
		{
			alert("Total Percentage is equal to 25%");
			return true;
		}
	}

	else if(vhclType == "N")
	{
		if(eval(totPerc) == 40)
		{
			alert("Total Percentage is equal to 40%");
			return true;
		}
	}
	return false;
}

function Calc_Tot_Percent_Excess()
{ //alert(1);
	var totPerc = 0;
        var txtPercAdjObj = document.getElementById("txtPercAdj");
	var vhclType = document.getElementById("chkVhclType").value;
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var payCodeAdjPercObj = document.getElementById("txtPayCodePerc");
	var oTable = document.getElementById("Detail");
	var designation_id=frmEmpPayForm.hdnDesgId.value;
        var payflag=frmEmpPayForm.txtPayRevFlag.value;
	//alert("payCodeAdjObj.value"+payCodeAdjObj.value);
       /// alert("txtPercAdjObj"+txtPercAdjObj.value);
        if(payCodeAdjObj.value == "") 
	{
		if(oTable == null)
		{
			return;
		}
		var iTr2 = oTable.rows.length;
		var i = 0;
		
		for(i=0; i < iTr2 -1; i++)
		{
			if(document.getElementsByName("status")[i].value!='D')
			{
				totPerc += eval(document.getElementsByName("txtPrcntage")[i].value); // getting total percentage.
			}
		}
//added by gagan on 13-06-2013
// Designation Id 155v is for ED's, The ED's are entitled for 40% BOB irrespective of Offcicail Vehicle flag ticked or not.
	//	if(designation_id == 155)
	//	{
		//if(eval(totPerc) > 40)
		//	{
		//		alert("Total Percentage should be defined 40% for ED's. % is more than 40%. Please enter Pay Code to adjust.");
		//	payCodeAdjObj.readOnly = false; 
			//	payCodeAdjObj.className = "required";
			//	payCodeAdjObj.style.background = "#ffffd3";
			//	payCodeAdjObj.focus();
			//	frmEmpPayForm.butInsert.disabled="true";
			//	return true;
		//	}
		//	else
          //  {
			//	payCodeAdjObj.readOnly = true; 
			//	payCodeAdjObj.className = "locked";
			//	frmEmpPayForm.butInsert.disabled="";
			//	return false;
			//}
		//}
	//	else
	//	{
        
         if(payCodeAdjObj.value!="" && txtPercAdjObj.value!="")
                {
                totPerc=totPerc-txtPercAdjObj.value;
                }
         if(payflag==3)   
         {
          if(vhclType == "Y")
		{
			if (eval(totPerc) > 26)
			{
				alert("Total Percentage is more than 26%. Please enter Pay Code to adjust.");
				payCodeAdjObj.readOnly = false; 
				payCodeAdjObj.className = "required";
				payCodeAdjObj.style.background = "#ffffd3";
				payCodeAdjObj.focus();
				frmEmpPayForm.butInsert.disabled="true";
				return true;
			}
			else
			{
				payCodeAdjObj.readOnly = true; 
				payCodeAdjObj.className = "locked";
				frmEmpPayForm.butInsert.disabled="";
				return false;
			}
		}

		else if(vhclType == "N")
		{ 
			if(eval(totPerc) > 32)
			{
				alert("Total Percentage is more than 32%. Please enter Pay Code to adjust.");
				payCodeAdjObj.readOnly = false; 
				payCodeAdjObj.className = "required";
				payCodeAdjObj.style.background = "#ffffd3";
				payCodeAdjObj.focus();
				frmEmpPayForm.butInsert.disabled="true";
				return true;
			}
			else
			{
				payCodeAdjObj.readOnly = true; 
				payCodeAdjObj.className = "locked";
				frmEmpPayForm.butInsert.disabled="";
				return false;
			}
		}     
         }
         else if (payflag==2)
         {
            if(vhclType == "Y")
		{
			if (eval(totPerc) > 25)
			{
				alert("Total Percentage is more than 25%. Please enter Pay Code to adjust.");
				payCodeAdjObj.readOnly = false; 
				payCodeAdjObj.className = "required";
				payCodeAdjObj.style.background = "#ffffd3";
				payCodeAdjObj.focus();
				frmEmpPayForm.butInsert.disabled="true";
				return true;
			}
			else
			{
				payCodeAdjObj.readOnly = true; 
				payCodeAdjObj.className = "locked";
				frmEmpPayForm.butInsert.disabled="";
				return false;
			}
		}

		else if(vhclType == "N")
		{
			if(eval(totPerc) > 40)
			{
				alert("Total Percentage is more than 40%. Please enter Pay Code to adjust.");
				payCodeAdjObj.readOnly = false; 
				payCodeAdjObj.className = "required";
				payCodeAdjObj.style.background = "#ffffd3";
				payCodeAdjObj.focus();
				frmEmpPayForm.butInsert.disabled="true";
				return true;
			}
			else
			{
				payCodeAdjObj.readOnly = true; 
				payCodeAdjObj.className = "locked";
				frmEmpPayForm.butInsert.disabled="";
				return false;
			}
		}   
         }
		
        //}
	}
	return false;
}

function Calc_Tot_Percent_Lag()
{        
        var txtPercAdjObj = document.getElementById("txtPercAdj");
	var vhclType = document.getElementById("chkVhclType").value;
	var oTable = document.getElementById("Detail");
	var designation_id=frmEmpPayForm.hdnDesgId.value;
	var totPerc = 0;
        var payflag=frmEmpPayForm.txtPayRevFlag.value;
	totPerc = Calc_Tot_Perc();
        
                if(txtPercAdjObj.value!="")
                    {
                   totPerc=totPerc-txtPercAdjObj.value;
                    }
//added by gagan on 13-06-2013
// Designation Id 155v is for ED's, The ED's are entitled for 40% BOB irrespective of Offcicail Vehicle flag ticked or not.
		//if(designation_id == 155)
		//{
		//if(eval(totPerc) != 40)
		//{
		//	alert("Total Percentage should be defined 40% for ED's. Please make adjustment accordingly.");
		//	return true;
		//}
		//else return false;
		//}
		//else
		//{
                
                if(payflag==3)
                { 
                   if(vhclType == "Y")
			{
				if (eval(totPerc) < 26)
				{
					alert("Total Percentage is less than 26%. Please add more records");
					return true;
				}
				else return false;
			}

			else if(vhclType == "N")
			{ 
				if(eval(totPerc) < 32)
				{
					alert("Total Percentage is less than 32%. Please add more records");
					return true;
				}
                                if(eval(totPerc) > 32)
				{ 
					alert("Total Percentage is more than 32%. Please enter Pay Code to adjust.");
					return true;
				}
                                
				else return false;
			}
                }
                else if (payflag==2)
                {
                   if(vhclType == "Y")
			{
				if (eval(totPerc) < 25)
				{
					alert("Total Percentage is less than 25%. Please add more records");
					return true;
				}
				else return false;
			}

			else if(vhclType == "N")
			{
				if(eval(totPerc) < 40)
				{
					alert("Total Percentage is less than 40%. Please add more records");
					return true;
				}
                                if(eval(totPerc) > 40)
				{
					alert("Total Percentage is more than 40%. Please enter Pay Code to adjust.");
					return true;
				}
                                
				else return false;
			}
                }
			
		//}

	
}

function Multiple_Pay_Code_Chk()
{
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var oTable = document.getElementById("Detail");

	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;
	var count = 0;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value!='D')
		{
			var temp1 = document.getElementsByName("txtPayCode")[i].value;
			var temp2 = payCodeAdjObj.value;
			if (eval(temp1) == eval(temp2))
			{
				count++;
			}
		}
	}

	return count;
}

function IfPayCode_Inlist() // check wheather paycode present in the list. calculate adjust percentage.
{
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var payCodeAdjPercObj = document.getElementById("txtPayCodePerc");
	var oTable = document.getElementById("Detail");

	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;
	var count = 0;
	var rcdCount = 0;

	if(payCodeAdjObj.value != "")
	{
		for(i=0; i < iTr2 -1; i++)
		{
			if(document.getElementsByName("status")[i].value!='D')
			{
				rcdCount++;
				var temp1 = document.getElementsByName("txtPayCode")[i].value;
				var temp2 = payCodeAdjObj.value;
				if (eval(temp1) == eval(temp2))
				{
					var excess_perc = Calc_Excess_perc(); //how much is excess.
					var adj_perc = 0;
					if(Multiple_Pay_Code_Chk() > 1) 
					{
						payCodeAdjPercObj.readOnly = false;		//if multiple paycode present then allow to enter percentage.
						payCodeAdjPercObj.className = "required"; 
						payCodeAdjPercObj.style.background = "#ffffd3";
						payCodeAdjPercObj.focus();
					}
					else
					{
						//Wheather percentage to be adjusted is sufficient to adjust.
						adj_perc = Calc_Adj_perc();
						if(excess_perc > adj_perc)
						{
							alert("Please choose a different Pay Code. Percentage to be adjusted is insufficient");
							resetFields();
							return false;
						}
						else
						{
							document.getElementById("txtPercAdj").value = excess_perc;
						}
					}
				}
				else
				{
					count++;
				}
			}
		}
		if(count == rcdCount)
		{
			alert("The adjust Pay Code is not present in the list of Pay Code(s)");
			payCodeAdjObj.select();
			return;
		}
	}
	else
	{
		resetFields();
	}
}

function IfPerc_Inlist()
{
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var payCodeAdjPercObj = document.getElementById("txtPayCodePerc");
	if (isNaN(payCodeAdjPercObj.value))
	{
		payCodeAdjPercObj.select();
		return false;
	}

	var excess_perc = Calc_Excess_perc(); //how much is excess.
	adj_perc = Calc_Adj_perc1();
	var oTable = document.getElementById("Detail");

	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;
	var count = 0;

	if(payCodeAdjPercObj.value != "")
	{
		for(i=0; i < iTr2 -1; i++)
		{
			if(document.getElementsByName("status")[i].value != 'D')
			{
				var temp1 = document.getElementsByName("txtPrcntage")[i].value;
				var temp2 = payCodeAdjPercObj.value;
				if (eval(temp1) == eval(temp2))
				{
					if(excess_perc > adj_perc)
					{
						alert("Please choose a different Pay Code or Percentage. Percentage to be adjusted is Insufficient");
						resetFields();
						return false;
					}
					else
					{
						document.getElementById("txtPercAdj").value = excess_perc;
					}
				}
				else
				{
					count++;
				}
			}

			if(count == (iTr2 -1))
			{
				alert("The Percentage is not present in the list of Percentage(s)");
				payCodeAdjPercObj.select();
				return;
			}
		}
	}
}

function Calc_Excess_perc() // return excess percentage depending upon the vehicle type.
{
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var vhclType = frmEmpPayForm.chkVhclType.value;
	var oTable = document.getElementById("Detail");
	var totPerc = 0;
	var designation_id=frmEmpPayForm.hdnDesgId.value;
        var payflag=frmEmpPayForm.txtPayRevFlag.value;
	totPerc = Calc_Tot_Perc();
//added by gagan on 13-06-2013
// Designation Id 155v is for ED's, The ED's are entitled for 40% BOB irrespective of Offcicail Vehicle flag ticked or not.

	//if(designation_id ==155)
	//{
	//	return (eval(totPerc)-40);
	//}
	//else
	//{
    if(payflag==3) 
    {
       if(eval(totPerc) > 26 || eval(totPerc) > 32)
	{
		if(vhclType == "Y")
		{
			return (eval(totPerc)-26);
		}

		else if(vhclType == "N")
		{
			return (eval(totPerc)-32);
		}
	}
	else return "";
    }
    else if(payflag==2)
    {
       if(eval(totPerc) > 25 || eval(totPerc) > 40)
	{
		if(vhclType == "Y")
		{
			return (eval(totPerc)-25);
		}

		else if(vhclType == "N")
		{
			return (eval(totPerc)-40);
		}
	}
	else return "";
    }
    
	
//}
}

function Calc_Adj_perc() //percentage of paycode from where deduction will be done if excess .
{
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var oTable = document.getElementById("Detail");
	var adj_perc = 0;

	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value!='D')
		{
			if ((document.getElementsByName("txtPayCode")[i].value) == payCodeAdjObj.value)
			{
				adj_perc = document.getElementsByName("txtPrcntage")[i].value;
				return adj_perc;
			}
		}
	}
}

function Calc_Adj_perc1() //percentage of paycode from where deduction will be done if excess (in case multiple pay code present).
{
	var payCodeAdjObj = document.getElementById("txtPayCodeAdj");
	var payCodeAdjPercObj = document.getElementById("txtPayCodePerc");
	var oTable = document.getElementById("Detail");
	var adj_perc = 0;

	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value!='D')
		{
			if ((document.getElementsByName("txtPayCode")[i].value) == payCodeAdjObj.value)
			{
				if ((document.getElementsByName("txtPrcntage")[i].value) == payCodeAdjPercObj.value)
				{
					adj_perc = document.getElementsByName("txtPrcntage")[i].value;
					return adj_perc;
				}
			}
		}
	}
}

function Calc_Tot_Perc()
{
	var totPerc = 0;
	var oTable = document.getElementById("Detail");
	
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value!='D')
		{
			var temp = document.getElementsByName("txtPrcntage")[i].value;
			temp = (temp=="")?0:temp;
			totPerc += eval(temp); // getting total percentage.
		}
	}

	return totPerc;
}

function doQueryMode()
{
	document.all.userBtn.value = "false";
	document.all.screenMode.value = "Q";
	frmEmpPayForm.action="../../../EmpSixPayActionQueryMode.do";
	frmEmpPayForm.submit();
}

function doInsertMode()
{
	document.all.buttonFlag.value = '';
	document.all.chkUpdtBtn.value="false";
	document.all.userBtn1.value = ''; 
	document.all.userBtn.value = "false";
	frmEmpPayForm.action="../../../EmpSixPayActionNewMode.do"
	frmEmpPayForm.submit();
}

function getHeaderRecord()
{
	if(mandatory_Check("frmEmpPayForm"))
	{
		document.all.chkUpdtBtn.value="true";
		document.all.buttonFlag.value='';
		document.all.userBtn.value = "false";
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		
		frmEmpPayForm.action="../../../EmpSixPayActionGetHeaderAction.do"
		frmEmpPayForm.submit();
	}
}

function GetDetail()
{
	if(mandatory_Check("frmEmpPayForm"))
	{
	      document.all.buttonFlag.value='';
		  document.all.screenMode.value='U'; 
		  document.all.userBtn.value = "true";
		  frmEmpPayForm.action="../../../EmpSixPayActionDetailAction.do";
		  frmEmpPayForm.submit();
	}
}
 
function doRefresh()
{
	document.all.buttonFlag.value='';
	frmEmpPayForm.action="../../../EmpSixPayActionRefresh.do"
	frmEmpPayForm.submit();
}
     
function doBaseDelRow()
{
	var oTable = document.getElementById("Detail");
	if(document.all.chkUpdtBtn.value == "true") frmEmpPayForm.headerPrimaryKey.value = "";
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;
	var strRecList='';

	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("checked")[i].checked)
		{
		//if(document.getElementsByName("detailId")[i].value=='')
			document.getElementsByName("itemChecked")[i].value = "Y";
		//else
		//strRecList=strRecList+(i+1)+",";
		}
	}

	/*
	if(strRecList!='')
	{
		alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
	} 
	*/  

	document.all.buttonFlag.value='';
	clrAdjustPerc();
	document.forms[0].action = "../../../EmpSixPayActionDeleteRowAction.do";
	document.forms[0].submit();
}

function clrAdjustPerc()
{
	document.all.txtPayCodeAdj.value='';
	document.all.txtPayCodePerc.value='';
	document.all.txtPercAdj.value='';

}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmEmpPayForm.userPageRequested.value = 1*frmEmpPayForm.newPageRequested.value ;
    frmEmpPayForm.action = "../../../EmpSixPayActionNextDetailAction.do";
    frmEmpPayForm.submit();

}

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmEmpPayForm.userPageRequested.value = 1*frmEmpPayForm.pageRequested.value - 1;
    frmEmpPayForm.action = "../../../EmpSixPayActionNextDetailAction.do";
    frmEmpPayForm.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmEmpPayForm.userPageRequested.value = 1*frmEmpPayForm.pageRequested.value + 1;
    frmEmpPayForm.action = "../../../EmpSixPayActionNextDetailAction.do";
    frmEmpPayForm.submit();
}

function doGetNextHeader()
{
	document.all.buttonFlag.value='';
	document.all.userBtn.value = "false";
	frmEmpPayForm.userPositionRequested.value = 1*frmEmpPayForm.positionRequested.value + 1;
	frmEmpPayForm.action="../../../EmpSixPayActionGetNextHeader.do";
	frmEmpPayForm.submit();
}


function PrevHeader()
{
	document.all.buttonFlag.value='';
	document.all.userBtn.value = "false";
	frmEmpPayForm.userPositionRequested.value = frmEmpPayForm.positionRequested.value - 1;
	frmEmpPayForm.action = "../../../EmpSixPayActionGetNextHeader.do";
	frmEmpPayForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
	document.all.userBtn.value = "false";
    frmEmpPayForm.userPositionRequested.value = 1*frmEmpPayForm.newPositionRequested.value;
    frmEmpPayForm.action = "../../../EmpSixPayActionGetNextHeader.do";
    frmEmpPayForm.submit();
}

function ShowLovEmp(){
     frmEmpPayForm.lovKey.value = "EmpPaymentSixPay" + frmEmpPayForm.screenName.value + frmEmpPayForm.screenMode.value;
     frmEmpPayForm.queryParam.value = "txtSiteID="+frmEmpPayForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpPayForm.hdnEmpLbrFlag.value;
     frmEmpPayForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtEmpStatus,txtPayScale,hdnFinYear,hdnDesgId,hdnHandFlag,txtPayRevFlag";
	 frmEmpPayForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
     frmEmpPayForm.txtInputField.value ="";
     frmEmpPayForm.txtIndex.value = "";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPayForm');
     return true;
}

function ShowPayCode(i)
{
    frmEmpPayForm.lovKey.value = "EmpPaymentSixPayCode" + frmEmpPayForm.screenName.value + frmEmpPayForm.screenMode.value;
    frmEmpPayForm.txtDisplayFields.value = "txtPayCode,txtPayDesc,txtPrcntage";
    frmEmpPayForm.txtSearchFields.value = "pr.PayCode.code,pr.PayCode.description";
    frmEmpPayForm.queryParam.value = "hdnDesgId="+document.all.hdnDesgId.value+",hdnHandFlag="+document.all.hdnHandFlag.value+",txtPayRevFlag="+document.all.txtPayRevFlag.value; 
    frmEmpPayForm.txtIndex.value = i;
    frmEmpPayForm.txtInputField.value ="";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPayForm');
    return true;
}

function chk_YearMonth()
{
	var yearMObj = document.getElementById("txtYYMM");
	var yearM = yearMObj.value;
	var y1 = yearM.substring(2,4);
	var y2 = yearM.substring(4,6);
	var fin_year = document.getElementById("hdnFinYear").value;
	if(yearM!=""){
		if (num_Check(yearM,1))
		 {                                   
			if (yearM.length != 6)
			{
			    alert("Year Month should be a Six digit Number");
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;            
			    return false;
			}
			if ((eval(y1)+1) != eval(y2) )
			{
			    alert("Wrong Financial Year format");
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;            
			    return false;
			}
		    if (eval(yearM) > eval(fin_year))
			{
			    alert("Financial Year can not Exceed Current Financial Year : "+fin_year);
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;            
			    return false;
			}
			return true;
		 }
		 else
		 {
			  document.getElementById("txtYYMM").select();
			  return false;
		 }
    }
}

function numbersonly(e)
{
	var unicode=e.charCode? e.charCode : e.keyCode
	if (unicode!=8){ //if the key isn't the backspace key (which we should allow)
	if (unicode<48||unicode>57) //if not a number
		return false //disable key press
	}
}


</script>
