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
  <html:form  action="MaintEmpMediBills" name="frmEmpMediBillsForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpMediBillsForm">
  <bean:define id="ParentForm" name="frmEmpMediBillsForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>Medical Claim</TD>
</TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>Medical Claim</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
            <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	 <TR height="50">
            <TD colspan=11>
            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >          
              <TR height=10>                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                 <TABLE cellSpacing="0" cellPadding="0" border="0" >
                <tr>
                  <td class=labelText width="18%"  ><bean:message key="Payroll.MediClaim.code"/></TD>
                  <td >
					  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="N">                              
						  <html:select property="txtPayCode" name="frmEmpMediBillsForm"  titleKey="Payroll.MediClaim.code" styleClass="required" onchange="onChangeMediCode(this.value)"  style="WIDTH:60%"  >
						  <html:option value="" >---------Please Select---------</html:option>      
						  <logic:present name="MediBillPayCode">
						  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
						  </logic:present>
						  </html:select>
					  </logic:equal>
					  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="N">  
							<logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpMediBillsForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" onchange="onChangeMediCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpMediBillsForm"  titleKey="Payroll.MediClaim.code" styleClass="optional" onchange="onChangeMediCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:notEqual>
					  </logic:notEqual>
                  </td>          

				  <TD class=labelText width="18%"><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" width="35%" >
						<logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpMediBillsForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="setDependentVal()" size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpMediBillsForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="setDependentVal()" size="15"  readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:notEqual>
                  </td>  
                  
              </TR> 
			<!--added by devendra on 3rd sep 2010 start-->
			<TR>
				<td class=labelText width="18%">
					<bean:message key="Payroll.MediReim.Quarter"/>
				</TD>
				<td>
					<logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="N">
						<html:select property="quarter" name="frmEmpMediBillsForm"  titleKey="Payroll.MediReim.quarter" styleClass="required"  style="WIDTH:30%" >
							<html:option value="">---Please Select---</html:option>
								<html:option value="Q1" >Q1</html:option>
								<html:option value="Q2" >Q2</html:option>
								<html:option value="Q3" >Q3</html:option>
								<html:option value="Q4" >Q4</html:option>
						</html:select>
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="N">
						<html:select property="quarter" name="frmEmpMediBillsForm"  titleKey="Payroll.MediReim.quarter" styleClass="optional"  style="WIDTH:30%" >
							<html:option value="">---Please Select---</html:option>
								<html:option value="Q1" >Q1</html:option>
								<html:option value="Q2" >Q2</html:option>
								<html:option value="Q3" >Q3</html:option>
								<html:option value="Q4" >Q4</html:option>
						</html:select>
					</logic:notEqual>
				</td>
				<td class="labelText"  width="10%" >
					<bean:message key="pay.MaintainAnnualIncome.FinYYMM" />
				</td>
				<td width="15%" >
					<logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="N">
						<html:text property="finYear" styleClass="optional"  style="text-align:left" size="18" maxlength="6"  titleKey="pay.MaintainAnnualIncome.FinYYMM" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" />
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="N">
						<html:text property="finYear" styleClass="optional" titleKey="pay.MaintainAnnualIncome.FinYYMM" onchange="chk_YearMonth()"  style="text-align:left" size="18" maxlength="6" />
					</logic:notEqual>
						(YYYYYY)
				</td>
			</TR>
  			<!--added by devendra on 3rd sep 2010 end-->
			
               <TR>
                  <TD class=labelText>Medical Amount</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q"> 
                  <html:text  property="txtClaimAmt" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="required" onkeypress="
                    if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }               
                    ;" onchange="calcAmt()" /></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">
                  <html:text  property="txtClaimAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  
                  <td class=labelText >Bill Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q">
                  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="setDependentVal()" readonly="true" styleClass="required"/>
				  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtBillDate" title="Calender" onclick="showCalendar('txtBillDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">                              
                  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
				  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtBillDate" title="Calender" />
                  </logic:equal>
                  </td>
               </tr>


<!--added by sonia on 17-11-2011-->
<tr height=30  >
<td class=labelText >From Date
</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q">
					  <html:text  property="txtStartDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="required"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtStartDate" id="txtDate1" title="Calender" onclick="showCalendar('txtStartDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">                              
					  <html:text  property="txtStartDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtStartDate" title="Calender" onclick="showCalendar('txtStartDate',this)" />
                  </logic:equal>
                  </td>

<td class=labelText >To Date
</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q">
					  <html:text  property="txtEndDate" altKey="Payroll.EmpInfo.DojSite" titleKey="To Date" readonly="true" maxlength="15" size="23"  styleClass="required"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtEndDate" id="txtDate2" title="Calender" onclick="showCalendar('txtEndDate',this)" />
                  </logic:notEqual>
				  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">                              
					  <html:text  property="txtEndDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtEndDate" title="Calender" onclick="showCalendar('txtEndDate',this)" />
                  </logic:equal>
                  </td>
</tr>

<!--end-->

               <tr>                  
                  <TD class=labelText>Bill Against</TD>
                  <td colspan="1" >
                  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q"> 
                  <html:select  property="txtBillAgst" styleClass = "optional" style="width:41%" onchange="onChangeBillAgst(this.value);" >                           
                  <html:option value="SELF">Self</html:option>                               
                  <html:option value="DEPNDNT" >Dependent</html:option>
                  </html:select>
                  </logic:notEqual>                    
                  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">
                  <html:select  property="txtBillAgst" styleClass = "optional" style="width:41%" onchange="" >                           
                  <html:option value=""><bean:message key="pr.pleaseSelect" /></html:option>
                  <html:option value="SELF">Self</html:option>                               
                  <html:option value="DEPNDNT" >Dependent</html:option>
                  </html:select>
                  </logic:equal>
                  </td>
                  
                  <td class=labelText  ><bean:message key="Payroll.MediClaim.Rel"/></TD>
                  <td >                  
                  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q">                              
                  <html:text property="txtDpndntNam" styleClass="locked"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtRelShip" onclick="ShowLovEmpDepndnt();" >
                  </logic:notEqual>                                                                                                 
                  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">                              
                  <html:text property="txtDpndntNam" styleClass="locked"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                  </logic:equal>
                  </td>                   
                </tr>
                
               <TR>
                  <TD class=labelText>Taxable Indicator</TD>
                  <td colspan="1" >
                  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q"> 
                  <html:select  property="txtDedIT" styleClass = "optional" style="width:41%" onchange="ITDedChk(this.value);" >                           
                  <html:option value=""><bean:message key="pr.pleaseSelect" /></html:option>
                  <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>                               
                  <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                  </html:select>
                  </logic:notEqual>  
                  
                  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">
                  <html:select  property="txtDedIT" styleClass = "optional" style="width:41%"  >                           
                  <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>                               
                  <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                  </html:select>
                  </logic:equal>
                  </td>                
                
                  <TD class=labelText>IT Ded Amount</TD>
                  <td align="left" >
                  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="N">
                  <html:text  property="txtITDedAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" onchange="calcAmt()"/>
                  </logic:equal>
                  
                  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="N">
                  <html:text  property="txtITDedAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" onchange="calcAmt()"/>
                  </logic:notEqual>
                  </td>
                
               <tr>    
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.MaintDirect.agencycod" /> </td>
                <td >                  
                <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q">                              
                <html:text property="txtAgencyName" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtAgncyCode" onclick="ShowLovAgencyCode();" >
                </logic:notEqual>                                                                                                 
                <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">                              
                <html:text property="txtAgencyName" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                </logic:equal>
                </td>               
                                
                <td class="labelText"  ><bean:message key="Payroll.MaintDirect.agencysite" /> </td>
                <td >                  
                <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q">                              
                <html:text property="txtAgencySite" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtAgncySite" onclick="ShowLovAgencySiteCode();" >
                </logic:notEqual> 
                
                <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">                              
                <html:text property="txtAgencySite" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                </logic:equal>
                </td>                
                
                <tr> 
                <TD class=labelText>Remarks</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpMediBillsForm" value="Q"> 
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="optional" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpMediBillsForm" value="Q">
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>   
                                
                  <td class=labelText  >Invoice Number</td>
                  <td>                             
                  <html:text  property="txtInvID" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                </tr>
                
                  <td class=labelText  >Net Amount</td>
                  <td>                             
                  <html:text  property="txtNetAmt" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                
                <TR height="50"><td>&nbsp;</td></tr>  
                   
        		</TABLE>
          </td>
        </tr>
<!-- Tab table Row 3 starts -->               
      <TR>
       <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
      </TR>  
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
    
           <td align=center bgcolor=#4682b4 width="30%"></td>
           <td  bgcolor=#4682b4><html:button value='Send Invoice'  onclick="sendInv()" property="butSendInv" styleClass="bottomBarText" /></td>
           <td  bgcolor=#4682b4><html:button value='Cancel Invoice' onclick="cancelInv()" property="butCancelInv" styleClass="bottomBarText" /></td>
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
<html:hidden name="frmEmpMediBillsForm"  property="screenName" value="EmpMediBillsScreen" />
<html:hidden property="loginLocCode" name="frmEmpMediBillsForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpMediBillsForm"  />
<html:hidden name="frmEmpMediBillsForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpMediBillsForm" />
<html:hidden property="positionRequested" name="frmEmpMediBillsForm" />
<html:hidden property="userPositionRequested" name="frmEmpMediBillsForm" />
<html:hidden property="buttonFlag" name="frmEmpMediBillsForm"  />
<html:hidden property="lovKey" name="frmEmpMediBillsForm"  />
<html:hidden property="txtFields" name="frmEmpMediBillsForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpMediBillsForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpMediBillsForm"  />
<html:hidden property="txtIndex" name="frmEmpMediBillsForm"  />
<html:hidden property="hdnPayYYMM" name="frmEmpMediBillsForm"  />
<html:hidden property="txtAgency" name="frmEmpMediBillsForm" />
<html:hidden property="txtAgencySiteCode" name="frmEmpMediBillsForm"  />
<html:hidden property="txtDpndntId" name="frmEmpMediBillsForm"  />
<html:hidden property="txtRelShip" name="frmEmpMediBillsForm"  />
<html:hidden property="hdnITFlag" name="frmEmpMediBillsForm"  />
<html:hidden property="txtCpfCode" name="frmEmpMediBillsForm"  />
<html:hidden property="txtInputField" name="frmEmpMediBillsForm"  />
<html:hidden property="reqAlreadyRaised" name="frmEmpMediBillsForm"  /> <!--added by devendra on 13th sept 2010-->

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">
function ShowEmpNum()
{
	if (frmEmpMediBillsForm.txtPayCode.value == '' && frmEmpMediBillsForm.screenMode.value == 'N')
	{
		alert("Please select Medical Code.");
		frmEmpMediBillsForm.txtPayCode.focus();
		return;
	}
	var qryprm = "";
	if(frmEmpMediBillsForm.screenMode.value == 'N')
	{
		qryprm = "txtSiteID="+ frmEmpMediBillsForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmEmpMediBillsForm.hdnEmpLbrFlag.value+",txtPayCode="+ frmEmpMediBillsForm.txtPayCode.value ;
	}
	else
	{
		if(frmEmpMediBillsForm.txtPayCode.value == "")
		{
			qryprm = "txtSiteID="+ frmEmpMediBillsForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmEmpMediBillsForm.hdnEmpLbrFlag.value+",txtPayCode="+"00";
		}
		else
		{
			qryprm = "txtSiteID="+ frmEmpMediBillsForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmEmpMediBillsForm.hdnEmpLbrFlag.value+",txtPayCode="+ frmEmpMediBillsForm.txtPayCode.value ;
		}
	}
	frmEmpMediBillsForm.lovKey.value = "EmpMediBillsEmpLov" + frmEmpMediBillsForm.screenName.value + frmEmpMediBillsForm.screenMode.value;
	frmEmpMediBillsForm.queryParam.value = qryprm;
	frmEmpMediBillsForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,hdnITFlag";
	frmEmpMediBillsForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
	frmEmpMediBillsForm.txtInputField.value ="txtEmpNo";
	frmEmpMediBillsForm.txtIndex.value ="";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpMediBillsForm');
	return true;
}    

function ShowLovAgencyCode()
{
  if (frmEmpMediBillsForm.txtPayCode.value==197)
  {
     frmEmpMediBillsForm.lovKey.value = "EmpMediBillsAgencyCode" + frmEmpMediBillsForm.screenName.value + "N";
     frmEmpMediBillsForm.txtDisplayFields.value = "txtAgency,txtAgencyName";
     frmEmpMediBillsForm.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Agency,Payroll.Common.Desc";
     frmEmpMediBillsForm.txtInputField.value ="";
	   frmEmpMediBillsForm.queryParam.value = "txtSiteID="+ frmEmpMediBillsForm.loginLocCode.value +",txtPayCode="+ frmEmpMediBillsForm.txtPayCode.value ;
	 //frmEmpMediBillsForm.txtInputField.value ="txtAgencyName"; 
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpMediBillsForm');
     return true;
  }
}

function ShowLovAgencySiteCode()
{
  if (frmEmpMediBillsForm.txtPayCode.value==197)
  {
     if(document.all.txtAgency.value=="" )
     {
        alert("Please select Agency Code first!!!");
        return false;
     }
     frmEmpMediBillsForm.lovKey.value = "EmpMediBillsAgencySiteCode" + frmEmpMediBillsForm.screenName.value + "N";
     frmEmpMediBillsForm.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";   
     frmEmpMediBillsForm.queryParam.value = "txtAgency="+document.all.txtAgency.value;
     frmEmpMediBillsForm.txtSearchFields.value = "";      
     frmEmpMediBillsForm.txtInputField.value ="";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpMediBillsForm');
     return true;
   }  
}

function ShowLovEmpDepndnt()
{
  if (frmEmpMediBillsForm.txtEmpNo.value=='' || frmEmpMediBillsForm.txtBillAgst.value=='' || frmEmpMediBillsForm.txtBillDate.value=='')
  {
    alert("Please select Employee, Bill Against and Bill Date First");
    return;
  }
  else
  {
    if (frmEmpMediBillsForm.txtBillAgst.value=='DEPNDNT')
    {
       frmEmpMediBillsForm.lovKey.value = "EmpMediBillsDepndnt" + frmEmpMediBillsForm.screenName.value + "N";
       frmEmpMediBillsForm.queryParam.value = "EmpNo="+ frmEmpMediBillsForm.txtEmpNo.value +",BillDate="+ frmEmpMediBillsForm.txtBillDate.value +",hdnEmpLbrFlag="+ frmEmpMediBillsForm.hdnEmpLbrFlag.value ;             
       frmEmpMediBillsForm.txtDisplayFields.value = "txtDpndntNam,txtRelShip,txtDpndntId";
       frmEmpMediBillsForm.txtSearchFields.value = "";   
       frmEmpMediBillsForm.txtInputField.value ="";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpMediBillsForm');
       return true;
    }else
    return;
  }  
}

function lfnLoad()
{  
    //added by devendra on 8th sept 2010 start
    document.all.txtDedIT.disabled="true";
	 document.all.butDel.disabled="true";
	 document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
	//added by devendra on 8th sept 2010 end

    //added by devendra on 10th sept 2010 start
	var medicalCode = document.all.txtPayCode.value;
	if(medicalCode=='' || medicalCode!='200')
	{
	
		document.all.quarter.disabled = "true";
		document.all.quarter.style.background="#ffffff";
		
		document.all.finYear.readOnly = true;
		document.all.finYear.style.background="#e0e0e0";
	}
	//added by devendra on 10th sept 2010 end

	mode = document.all.screenMode.value;
	//alert(mode)
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='N'|| frmEmpMediBillsForm.headerPrimaryKey.value=='' )
    { 
      document.all.butSendInv.disabled = "true"; 
      document.all.butCancelInv.disabled = "true"; 
    }
    hedMenuHandling(mode);        
    
    if(document.all.txtInvID.value=='' && mode=='U')
    {
        document.all.butSendInv.disabled="";
        document.all.butCancelInv.disabled = "true"; 
    }
	else if(document.all.txtInvID.value!='' && mode=='U')
    {
      document.all.butSendInv.disabled="true";
      document.all.butCancelInv.disabled ="";
    }
    onLoadBillAgst();
	var val = document.getElementById("txtPayCode").value;
	if(val != "") onChangeMediCodeU(val);
         
       //Disabling INsert Mode  and Delete Mode 
  if (frmEmpMediBillsForm.hdnEmpLbrFlag.value=="E"){
//    document.all.butInsertMode.disabled="true";
//    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      disableInsert();
    }
}
function disableInsert(){
    //Disabling INsert Mode  and Delete Mode 
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butDel.disabled="true";
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
    

}
function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpMediBillsForm.action="../../../EmpMediBillsNewMode.do"
    frmEmpMediBillsForm.submit();
}

function getHeaderRecord()
{
    if(mandatory_Check("frmEmpMediBillsForm"))
    {   
		document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmEmpMediBillsForm.action="../../../EmpMediBillsGetHeaderAction.do"
		frmEmpMediBillsForm.submit();
    }
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpMediBillsForm.userPositionRequested.value = 1*frmEmpMediBillsForm.positionRequested.value + 1;
    frmEmpMediBillsForm.action="../../../EmpMediBillsGetNextHeader.do";
    frmEmpMediBillsForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpMediBillsForm.userPositionRequested.value = 1*frmEmpMediBillsForm.positionRequested.value - 1;
    frmEmpMediBillsForm.action = "../../../EmpMediBillsGetNextHeader.do";
    frmEmpMediBillsForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpMediBillsForm.userPositionRequested.value = 1*frmEmpMediBillsForm.newPositionRequested.value;
    frmEmpMediBillsForm.action = "../../../EmpMediBillsGetNextHeader.do";
    frmEmpMediBillsForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpMediBillsForm.action="../../../EmpMediBillsQueryMode.do"
    frmEmpMediBillsForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpMediBillsForm.action="../../../EmpMediBillsRefresh.do"
    frmEmpMediBillsForm.submit();
}

function sendInv()
{
    if(!mandatory_Check("frmEmpMediBillsForm"))
    {
      return false;
    }
    document.all.butSendInv.disabled="true";
    frmEmpMediBillsForm.action="../../../EmpMediBillsSendInv.do"
    frmEmpMediBillsForm.submit();
}

function cancelInv()
{
    if(confirm("Do you want to cancel Invoice"))
    {
    document.all.butCancelInv.disabled="true";
    frmEmpMediBillsForm.action="../../../EmpMediBillsCancelInv.do"
    frmEmpMediBillsForm.submit();
    }
}
function SaveRecord()
{   
    document.all.txtITDedAmt.disabled ="";
    document.all.buttonFlag.value='';
    if(document.all.txtInvID.value=='')
    {
      if(mandatory_Check("frmEmpMediBillsForm"))
      {   
		  var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}
       calcAmt();
          
        /*if(frmEmpMediBillsForm.txtBillAgst.value=='DEPNDNT' && frmEmpMediBillsForm.txtRelShip.value=='')
        {
          alert("Dependent Name is Mandatory");
          return;
        } */         
        if (frmEmpMediBillsForm.txtPayCode.value==197)
        {
          if(frmEmpMediBillsForm.txtAgencySite.value =='' || frmEmpMediBillsForm.txtAgencyName.value =='')
          {
            alert("Agency Code & Agency Site code are Mandatory");
            return;
          }
        }
        
        frmEmpMediBillsForm.detailDataChanged.value = "false";            
        if(frmEmpMediBillsForm.screenMode.value == 'N')
          frmEmpMediBillsForm.headerDataChanged.value = "true";
        else if(frmEmpMediBillsForm.screenMode.value == 'U')
          frmEmpMediBillsForm.headerDataChanged.value = "true";
          else
          frmEmpMediBillsForm.headerDataChanged.value = "false";
        frmEmpMediBillsForm.headerFields.value = "true";        
        document.all.txtDedIT.disabled ="";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpMediBillsForm.action = "../../../EmpMediBillsSaveAction.do";            
        frmEmpMediBillsForm.submit();
    }
    else
    {
        return false;
    }
  }   
      
}

function onChangeBillAgst(val)
{
 /* if (val=='DEPNDNT')
  {
    
    document.getElementById("txtDpndntNam").disabled = "true";
    document.getElementById("txtDpndntNam").locked = "true";
    
    document.getElementById("txtDpndntNam").style.background="#ffffd3";
    document.getElementById("txtDpndntNam").style.className="required";
   
  }else
  {
    document.getElementById("txtDpndntNam").disabled = "true";
    document.getElementById("txtDpndntNam").style.background="#e0e0e0";
    document.getElementById("txtDpndntNam").style.className="locked";
  } */
    document.getElementById("txtDpndntNam").disabled = "true";
    document.getElementById("txtDpndntNam").style.background="#e0e0e0";
    document.getElementById("txtDpndntNam").style.className="locked";
}


function onLoadBillAgst()
{
/*  if (frmEmpMediBillsForm.txtBillAgst.value=='DEPNDNT')
  {
    
    document.getElementById("txtDpndntNam").disabled = "";
    document.getElementById("txtDpndntNam").style.background="#ffffd3";
    document.getElementById("txtDpndntNam").style.className="required";
  }
  else
  {
    document.getElementById("txtDpndntNam").disabled = "true";
    document.getElementById("txtDpndntNam").style.background="#e0e0e0";
    document.getElementById("txtDpndntNam").style.className="locked";
  }*/
     document.getElementById("txtDpndntNam").disabled = "true";
    document.getElementById("txtDpndntNam").style.background="#e0e0e0";
    document.getElementById("txtDpndntNam").style.className="locked";
}  

function setDependentVal()
{
  if(frmEmpMediBillsForm.txtBillAgst.value=='DEPNDNT')
  {    
      frmEmpMediBillsForm.txtDpndntId.value = '';
      frmEmpMediBillsForm.txtDpndntNam.value ='';
      frmEmpMediBillsForm.txtRelShip.value ='';
  }
}


function onChangeMediCode(val)
{
  //document.getElementById("txtITDedAmt").value = "";
  //document.getElementById("txtITDedAmt").readOnly = false;
  //document.getElementById("txtITDedAmt").style.background="#ffffff";   
  document.getElementById("txtEmpNo").value = "";
  document.getElementById("txtEmpName").value = "";
  if (!(val==197))
  { 
		if(val == 200)
		{
			frmEmpMediBillsForm.txtDedIT.value ='Y';
			document.getElementById("txtDedIT").disabled = "true";
			//document.getElementById("txtITDedAmt").readOnly = false;
			//document.getElementById("txtITDedAmt").style.background="#ffffff";   
			document.all.quarter.disabled = "";
			document.all.quarter.style.className="required";
			document.all.quarter.style.background="#ffffd3";
			document.all.finYear.readOnly = false;
			document.all.finYear.style.className="required";
			document.all.finYear.style.background="#ffffd3"; // for yellow background
		}
		else
		{
			  //frmEmpMediBillsForm.txtDedIT.value ='';
			  document.getElementById("txtDedIT").disabled = "";
			  document.all.quarter.disabled = "true";
			  document.all.quarter.style.className="optional";
			  document.all.quarter.style.background="#e0e0e0";
			  document.all.finYear.readOnly = true;
			  document.all.finYear.style.className="optional";
			  document.all.finYear.style.background="#e0e0e0"; // for yellow background
		}
		document.getElementById("txtAgencyName").readOnly = true;
		frmEmpMediBillsForm.txtAgency.value ='';
		frmEmpMediBillsForm.txtAgencyName.value ='';
		document.getElementById("txtAgencyName").style.background="#e0e0e0";
		
		document.getElementById("txtAgencySite").readOnly = true;
		frmEmpMediBillsForm.txtAgencySiteCode.value='';
		frmEmpMediBillsForm.txtAgencySite.value ='';
		document.getElementById("txtAgencySite").style.background="#e0e0e0";    
		document.getElementById("quarter").selectedIndex=0;
  }
  else
  {
		if(document.all.screenMode.value!='Q')
		{
		frmEmpMediBillsForm.txtDedIT.value ='N';
		document.getElementById("txtDedIT").disabled = "true";

		document.getElementById("txtAgencyName").readOnly = false;
		document.getElementById("txtAgencyName").style.background="#ffffd3";
		document.getElementById("txtAgencySite").readOnly = false;
		document.getElementById("txtAgencySite").style.background="#ffffd3";  


		document.getElementById("txtITDedAmt").readOnly = true;
		document.getElementById("txtITDedAmt").style.background="#e0e0e0";  
		
		 // added by devendra on 13 sept 2010 start
		//alert('inside 2nd else')
		document.all.quarter.disabled = "true";
		document.all.quarter.style.className="optional";
		document.all.quarter.style.background="#e0e0e0";
		document.all.finYear.readOnly = true;
		document.all.finYear.style.className="optional";
		document.all.finYear.style.background="#e0e0e0"; // for yellow background
			// added by devendra on 13 sept 2010 end
	    }
		else
		{
		frmEmpMediBillsForm.txtDedIT.value ='N';
		document.getElementById("txtDedIT").disabled = "true";

		document.getElementById("txtAgencyName").readOnly = true;
		document.getElementById("txtAgencyName").style.background="#e0e0e0";
		document.getElementById("txtAgencySite").readOnly = true;
		document.getElementById("txtAgencySite").style.background="#e0e0e0";  


		document.getElementById("txtITDedAmt").readOnly = true;
		document.getElementById("txtITDedAmt").style.background="#e0e0e0";  
		
		 // added by devendra on 13 sept 2010 start
		//alert('inside 2nd else')
		document.all.quarter.disabled = "true";
		document.all.quarter.style.className="optional";
		document.all.quarter.style.background="#e0e0e0";
		document.all.finYear.readOnly = true;
		document.all.finYear.style.className="optional";
		document.all.finYear.style.background="#e0e0e0"; // for yellow background
			// added by devendra on 13 sept 2010 end
		}	
	}  

	dateStateChng(val);
}

function dateStateChng(val)
{
	if(val=="200" || val=="261")
	{
		if(document.all.txtDate1) document.all.txtDate1.disabled = "true";
		if(document.all.txtDate2) document.all.txtDate2.disabled = "true";
		document.all.txtStartDate.value = "";
		document.all.txtEndDate.value = "";
		document.getElementById("txtStartDate").className="locked";
		document.getElementById("txtEndDate").className="locked";
		document.all.txtStartDate.style.background="#e0e0e0";
		document.all.txtEndDate.style.background="#e0e0e0";
	}
	else
	{
		if(document.all.screenMode.value!='Q')
		{
			if(document.all.txtDate1) document.all.txtDate1.disabled = "";
			if(document.all.txtDate2) document.all.txtDate2.disabled = "";
			document.getElementById("txtStartDate").className="required";
			document.getElementById("txtEndDate").className="required";
			document.all.txtStartDate.style.background="#ffffd3";
			document.all.txtEndDate.style.background="#ffffd3";
		}
	}

}

function ITDedChk(val)
{  
  calcAmt();
  
  if(document.getElementById("txtEmpNo").value=="")
  {
    alert("Please Select Employee No. First");
    document.getElementById("txtDedIT").value="";
    return false;
  }
  document.getElementById("txtITDedAmt").value = "";
      /*if (document.all.hdnITFlag.value=='Y') 
        {           
           document.getElementById("txtITDedAmt").readOnly = true;
           document.getElementById("txtITDedAmt").style.background="#e0e0e0";           
        }*/
        
      if (val=='Y')
       {          
          document.getElementById("txtITDedAmt").className="required";
          document.getElementById("txtITDedAmt").readOnly = false;
          document.getElementById("txtITDedAmt").style.background="#ffffff";
          
       }
       else
       {
          document.getElementById("txtITDedAmt").readOnly = true;
          document.getElementById("txtITDedAmt").style.background="#e0e0e0";
          document.getElementById("txtITDedAmt").className="optional";
       }
      /*if (val=='N')
      {         
         document.getElementById("txtITDedAmt").readOnly = true;
         document.getElementById("txtITDedAmt").style.background="#e0e0e0";         
      }*/
    
}

function calcAmt()
{   //alert(document.all.txtDedIT.value)
    if (document.all.txtDedIT.value=='Y'){
    var itDed=document.all.txtITDedAmt.value==""?"0":document.all.txtITDedAmt.value;
     document.all.txtNetAmt.value = parseInt(document.all.txtClaimAmt.value - itDed);
}
 if (document.all.txtDedIT.value=='N'){
    var itDed=document.all.txtITDedAmt.value==""?"0":document.all.txtITDedAmt.value;
    document.all.txtNetAmt.value =document.all.txtClaimAmt.value ;
}
	     
    
}


////added by sonia on 17-11-2011
function chkToDt()
{
  var fromDt=document.getElementById("txtEndDate").value;
  if(!cmpSysDate(fromDt,0))
	{
	  document.getElementById("txtEndDate").value="";
	  return false;
	}

	comprDate();
}

function comprDate(){
	var frmDt = document.getElementById("txtStartDate").value;
	if(frmDt != ""){
		var toDt = document.getElementById("txtEndDate").value;
		if (!cmpDate(frmDt,toDt,0)){
			alert("End Date must be greater than Start Date.");
			document.getElementById("txtEndDate").value="";
			return false;
		}
	}else{
		alert("Enter Start Date First");
		document.getElementById("txtEndDate").value="";
		document.getElementById("txtStartDate").focus();
		return false;
	}
}

function onChangeMediCodeU(val)
{
  if (!(val==197))
  { 
		if(val == 200)
		{
     if(document.all.screenMode.value=='N')
			frmEmpMediBillsForm.txtDedIT.value ='Y';
			document.getElementById("txtDedIT").disabled = "true";
			document.getElementById("txtITDedAmt").readOnly = false;
			document.getElementById("txtITDedAmt").style.background="#ffffff";   
			document.all.quarter.disabled = "";
			document.all.quarter.style.className="required";
			document.all.quarter.style.background="#ffffd3";
			document.all.finYear.readOnly = false;
			document.all.finYear.style.className="required";
			document.all.finYear.style.background="#ffffd3"; // for yellow background
		}
		else
		{
			  //frmEmpMediBillsForm.txtDedIT.value ='';
			  document.getElementById("txtDedIT").disabled = "";
			  document.all.quarter.disabled = "true";
			  document.all.quarter.style.className="optional";
			  document.all.quarter.style.background="#e0e0e0";
			  document.all.finYear.readOnly = true;
			  document.all.finYear.style.className="optional";
			  document.all.finYear.style.background="#e0e0e0"; // for yellow background
		}
		document.getElementById("txtAgencyName").readOnly = true;
		frmEmpMediBillsForm.txtAgency.value ='';
		frmEmpMediBillsForm.txtAgencyName.value ='';
		document.getElementById("txtAgencyName").style.background="#e0e0e0";
		
		document.getElementById("txtAgencySite").readOnly = true;
		frmEmpMediBillsForm.txtAgencySiteCode.value='';
		frmEmpMediBillsForm.txtAgencySite.value ='';
		document.getElementById("txtAgencySite").style.background="#e0e0e0";    
  }
  else
  {
		if(document.all.screenMode.value!='Q')
		{
		frmEmpMediBillsForm.txtDedIT.value ='N';
		document.getElementById("txtDedIT").disabled = "true";

		document.getElementById("txtAgencyName").readOnly = false;
		document.getElementById("txtAgencyName").style.background="#ffffd3";
		document.getElementById("txtAgencySite").readOnly = false;
		document.getElementById("txtAgencySite").style.background="#ffffd3";  


		document.getElementById("txtITDedAmt").readOnly = true;
		document.getElementById("txtITDedAmt").style.background="#e0e0e0";  
		
		 // added by devendra on 13 sept 2010 start
		//alert('inside 2nd else')
		document.all.quarter.disabled = "true";
		document.all.quarter.style.className="optional";
		document.all.quarter.style.background="#e0e0e0";
		document.all.finYear.readOnly = true;
		document.all.finYear.style.className="optional";
		document.all.finYear.style.background="#e0e0e0"; // for yellow background
			// added by devendra on 13 sept 2010 end
	    }
		else
		{
		frmEmpMediBillsForm.txtDedIT.value ='N';
		document.getElementById("txtDedIT").disabled = "true";

		document.getElementById("txtAgencyName").readOnly = true;
		document.getElementById("txtAgencyName").style.background="#e0e0e0";
		document.getElementById("txtAgencySite").readOnly = true;
		document.getElementById("txtAgencySite").style.background="#e0e0e0";  


		document.getElementById("txtITDedAmt").readOnly = true;
		document.getElementById("txtITDedAmt").style.background="#e0e0e0";  
		
		 // added by devendra on 13 sept 2010 start
		//alert('inside 2nd else')
		document.all.quarter.disabled = "true";
		document.all.quarter.style.className="optional";
		document.all.quarter.style.background="#e0e0e0";
		document.all.finYear.readOnly = true;
		document.all.finYear.style.className="optional";
		document.all.finYear.style.background="#e0e0e0"; // for yellow background
			// added by devendra on 13 sept 2010 end
		}	
	}  

	dateStateChng(val);
}

function chk_YearMonth()
{
	var yearMObj = document.getElementById("finYear");
	var yearM = yearMObj.value;
	var y1 = yearM.substring(2,4);
	var y2 = yearM.substring(4,6);
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
			return true;
		 }
		 else
		 {
			  document.getElementById("txtYYMM").select();
			  return false;
		 }
    }
}


</script>