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
  <html:form  action="MaintEmpPrmsMediBills" name="frmEmpPrmsMediBillsForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpPrmsMediBillsForm">
  <bean:define id="ParentForm" name="frmEmpPrmsMediBillsForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>PRMS Medical Claim</TD>
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
          <TD class=subHeader colspan=6>PRMS Medical Claim</TD>
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
					  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">                              
						  <html:select property="txtPayCode" name="frmEmpPrmsMediBillsForm"  titleKey="Payroll.MediClaim.code" styleClass="required" onchange="onChangeMediCode(this.value)"  style="WIDTH:60%"  >
						  <html:option value="" >---------Please Select---------</html:option>      
						  <logic:present name="MediBillPayCode">
						  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
						  </logic:present>
						  </html:select>
					  </logic:equal>
					  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">  
							<logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpPrmsMediBillsForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" onchange="onChangeMediCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpPrmsMediBillsForm"  titleKey="Payroll.MediClaim.code" styleClass="optional" onchange="onChangeMediCode(this.value)" style="WIDTH:60%" >
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
						<logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpPrmsMediBillsForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="setDependentVal()" size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpPrmsMediBillsForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="setDependentVal() " size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:notEqual>
                  </td>  
                  
              </TR> 
			<TR>
				<td class=labelText width="18%">
					<bean:message key="Payroll.MediReim.Quarter"/>
				</TD>
				<td>
					<logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">
						<html:select property="quarter" name="frmEmpPrmsMediBillsForm"  titleKey="Payroll.MediReim.quarter" styleClass="required"  style="WIDTH:30%" >
							<html:option value="">---Please Select---</html:option>
								<html:option value="Q1" >Q1</html:option>
								<html:option value="Q2" >Q2</html:option>
								<html:option value="Q3" >Q3</html:option>
								<html:option value="Q4" >Q4</html:option>
						</html:select>
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">
						<html:select property="quarter" name="frmEmpPrmsMediBillsForm"  titleKey="Payroll.MediReim.quarter" styleClass="optional"  style="WIDTH:30%" >
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
					<logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">
						<html:text property="finYear" styleClass="optional"  style="text-align:left" size="18" onblur="GetCeilDtlN()"  maxlength="6" styleClass="required" titleKey="pay.MaintainAnnualIncome.FinYYMM"  onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" />
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">
						<html:text property="finYear" styleClass="optional" titleKey="pay.MaintainAnnualIncome.FinYYMM"  onchange="chk_YearMonth()" onblur="GetCeilDtlN()" style="text-align:left" size="18" maxlength="6" />
					</logic:notEqual>
						(YYYYYY)
				</td>
			</TR>
			
               <TR>
                  <TD class=labelText>Medical Amount</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q"> 
                  <html:text  property="txtClaimAmt" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="required" onkeypress="
                    if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }               
                    ;" onchange="calcAmt();" /></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">
                  <html:text  property="txtClaimAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  
                  <td class=labelText >Bill Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">
                  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="setDependentVal()" readonly="true" styleClass="required"/>
				  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtBillDate" title="Calender" onclick="showCalendar('txtBillDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
                  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
				  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtBillDate" title="Calender" />
                  </logic:equal>
                  </td>
               </tr>


<tr height=30  >
<td class=labelText >From Date
</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">
					  <html:text  property="txtStartDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="required"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtStartDate" id="txtDate1" title="Calender" onclick="showCalendar('txtStartDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
					  <html:text  property="txtStartDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtStartDate" title="Calender" onclick="showCalendar('txtStartDate',this)" />
                  </logic:equal>
                  </td>

<td class=labelText >To Date
</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">
					  <html:text  property="txtEndDate" altKey="Payroll.EmpInfo.DojSite" titleKey="To Date" readonly="true" maxlength="15" size="23"  styleClass="required"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtEndDate" id="txtDate2" title="Calender" onclick="showCalendar('txtEndDate',this)" />
                  </logic:notEqual>
				  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
					  <html:text  property="txtEndDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtEndDate" title="Calender" onclick="showCalendar('txtEndDate',this)" />
                  </logic:equal>
                  </td>
</tr>

<!--end-->

               <tr>                  
                  <TD class=labelText>Bill Against</TD>
                  <td colspan="1" >
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q"> 
                  <html:select  property="txtBillAgst" styleClass = "optional" style="width:41%" onchange="onChangeBillAgst(this.value);" >                           
                  <html:option value="SELF">Self</html:option>                               
                  <html:option value="DEPNDNT" >Dependent</html:option>
                  </html:select>
                  </logic:notEqual>                    
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">
                  <html:select  property="txtBillAgst" styleClass = "optional" style="width:41%" onchange="" >                           
                  <html:option value=""><bean:message key="pr.pleaseSelect" /></html:option>
                  <html:option value="SELF">Self</html:option>                               
                  <html:option value="DEPNDNT" >Dependent</html:option>
                  </html:select>
                  </logic:equal>
                  </td>
                  
                  <td class=labelText  ><bean:message key="Payroll.MediClaim.Rel"/></TD>
                  <td >                  
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
                  <html:text property="txtDpndntNam" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtRelShip" onclick="ShowLovEmpDepndnt();" >
                  </logic:notEqual>                                                                                                 
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
                  <html:text property="txtDpndntNam" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                  </logic:equal>
                  </td>                   
                </tr>
                
               <TR>
                  <TD class=labelText>Taxable Indicator</TD>
                  <td colspan="1" >
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q"> 
                  <html:select  property="txtDedIT" styleClass = "optional" style="width:41%" onchange="ITDedChk(this.value);" >                           
                  <html:option value=""><bean:message key="pr.pleaseSelect" /></html:option>
                  <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>                               
                  <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                  </html:select>
                  </logic:notEqual>  
                  
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">
                  <html:select  property="txtDedIT" styleClass = "optional" style="width:41%"  >                           
                  <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>                               
                  <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                  </html:select>
                  </logic:equal>
                  </td>                
                
                  <TD class=labelText>IT Ded Amount</TD>
                  <td align="left" >
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">
                  <html:text  property="txtITDedAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" onchange="calcAmt()"/>
                  </logic:equal>
                  
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="N">
                  <html:text  property="txtITDedAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" onchange="calcAmt();" />
                  </logic:notEqual>
                  </td>
                
               <tr>    
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.MaintDirect.agencycod" /> </td>
                <td >                  
                <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
                <html:text property="txtAgencyName" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtAgncyCode" onclick="ShowLovAgencyCode();" >
                </logic:notEqual>                                                                                                 
                <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
                <html:text property="txtAgencyName" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                </logic:equal>
                </td>               
                                
                <td class="labelText"  ><bean:message key="Payroll.MaintDirect.agencysite" /> </td>
                <td >                  
                <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
                <html:text property="txtAgencySite" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtAgncySite" onclick="ShowLovAgencySiteCode();" >
                </logic:notEqual> 
                
                <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
                <html:text property="txtAgencySite" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                </logic:equal>
                </td>                
                
                <tr> 
                <TD class=labelText>Remarks</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q"> 
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="optional" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>   
                                
                  <td class=labelText  >Invoice Number</td>
                  <td>                             
                  <html:text  property="txtInvID" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                </tr>
                <tr>
                  <td class=labelText >Net Amount</td>
                  <td>                            
                  <html:text  property="txtNetAmt" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  
                  <td class=labelText >Sanction Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="required"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">                              
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:equal>
                  </td>
                  
                  <tr>
                  <TD class=labelText>Sanction Order</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q"> 
                  <html:text  property="txtSancOrder" altKey="Payroll.EmpInfo.Empno" maxlength="50" style="text-align:right" size="23" styleClass="required"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpPrmsMediBillsForm" value="Q">
                  <html:text  property="txtSancOrder" altKey="Payroll.EmpInfo.Empno" maxlength="50" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  </tr>
                  
                  

                <TR height="50"><td>&nbsp;</td></tr>
        		</TABLE>
                        
            <table>
            <TR>
                
                  <td class=labelText style="color:blue"   width="500" >* NOTE : Please Enter Employee details while searching for employee</td>
                </tr>
                </table>
          </td>
        </tr>
<!-- Tab table Row 3 starts -->               
      <TR>
       <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
      </TR>  
      </TABLE>
      <table>
         </tr>
                
                  <td class=labelText  >Opening Balance</td>
                  <td>                             
                  <html:text  property="txtOpenBal" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                               
                  <td class=labelText  >Claimed Ceiling</td>
                  <td>                             
                  <html:text  property="txtCeilAdj" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  
                               
                  <td class=labelText  >Closing Balance</td>
                  <td>                             
                  <html:text  property="txtCloseBal" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>

      </table>
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
<html:hidden name="frmEmpPrmsMediBillsForm"  property="screenName" value="EmpPrmsMediBillsScreen" />
<html:hidden property="loginLocCode" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpPrmsMediBillsForm"  />
<html:hidden name="frmEmpPrmsMediBillsForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpPrmsMediBillsForm" />
<html:hidden property="positionRequested" name="frmEmpPrmsMediBillsForm" />
<html:hidden property="userPositionRequested" name="frmEmpPrmsMediBillsForm" />
<html:hidden property="buttonFlag" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="lovKey" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="txtFields" name="frmEmpPrmsMediBillsForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="txtIndex" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="hdnPayYYMM" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="txtAgency" name="frmEmpPrmsMediBillsForm" />
<html:hidden property="txtAgencySiteCode" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="txtDpndntId" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="txtRelShip" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="hdnITFlag" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="txtCpfCode" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="txtInputField" name="frmEmpPrmsMediBillsForm"  />
<html:hidden property="reqAlreadyRaised" name="frmEmpPrmsMediBillsForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">
function ShowEmpNum()
{
	if (frmEmpPrmsMediBillsForm.txtPayCode.value == '' && frmEmpPrmsMediBillsForm.screenMode.value == 'N')
	{
		alert("Please select Medical Code.");
		frmEmpPrmsMediBillsForm.txtPayCode.focus();
		return;
	}
	var qryprm = "";
	if(frmEmpPrmsMediBillsForm.screenMode.value == 'N')
	{
		qryprm = "txtSiteID="+ frmEmpPrmsMediBillsForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmEmpPrmsMediBillsForm.hdnEmpLbrFlag.value+",txtPayCode="+ frmEmpPrmsMediBillsForm.txtPayCode.value ;
	}
	else
	{
		if(frmEmpPrmsMediBillsForm.txtPayCode.value == "")
		{
			qryprm = "txtSiteID="+ frmEmpPrmsMediBillsForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmEmpPrmsMediBillsForm.hdnEmpLbrFlag.value+",txtPayCode="+"00";
		}
		else
		{
			qryprm = "txtSiteID="+ frmEmpPrmsMediBillsForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmEmpPrmsMediBillsForm.hdnEmpLbrFlag.value+",txtPayCode="+ frmEmpPrmsMediBillsForm.txtPayCode.value ;
		}
	}
	frmEmpPrmsMediBillsForm.lovKey.value = "EmpPrmsMediBillsEmpLov" + frmEmpPrmsMediBillsForm.screenName.value + frmEmpPrmsMediBillsForm.screenMode.value;
	frmEmpPrmsMediBillsForm.queryParam.value = qryprm;
	frmEmpPrmsMediBillsForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,hdnITFlag";
	frmEmpPrmsMediBillsForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
	frmEmpPrmsMediBillsForm.txtInputField.value ="txtEmpNo";
	frmEmpPrmsMediBillsForm.txtIndex.value ="";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPrmsMediBillsForm');
	return true;
}    

function ShowLovAgencyCode()
{
  if (frmEmpPrmsMediBillsForm.txtPayCode.value==197)
  {
     frmEmpPrmsMediBillsForm.lovKey.value = "EmpPrmsMediBillsAgencyCode" + frmEmpPrmsMediBillsForm.screenName.value + "N";
     frmEmpPrmsMediBillsForm.txtDisplayFields.value = "txtAgency,txtAgencyName";
     frmEmpPrmsMediBillsForm.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Agency,Payroll.Common.Desc";
     frmEmpPrmsMediBillsForm.txtInputField.value ="";
     frmEmpPrmsMediBillsForm.queryParam.value = "txtSiteID="+ frmEmpPrmsMediBillsForm.loginLocCode.value +",txtPayCode="+ frmEmpPrmsMediBillsForm.txtPayCode.value ;
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPrmsMediBillsForm');
     return true;
  }
}

function ShowLovAgencySiteCode()
{
  if (frmEmpPrmsMediBillsForm.txtPayCode.value==197)
  {
     if(document.all.txtAgency.value=="" )
     {
        alert("Please select Agency Code first!!!");
        return false;
     }
     frmEmpPrmsMediBillsForm.lovKey.value = "EmpPrmsMediBillsAgencySiteCode" + frmEmpPrmsMediBillsForm.screenName.value + "N";
     frmEmpPrmsMediBillsForm.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";   
     frmEmpPrmsMediBillsForm.queryParam.value = "txtAgency="+document.all.txtAgency.value;
     frmEmpPrmsMediBillsForm.txtSearchFields.value = "";      
     frmEmpPrmsMediBillsForm.txtInputField.value ="";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPrmsMediBillsForm');
     return true;
   }  
}

function ShowLovEmpDepndnt()
{
  if (frmEmpPrmsMediBillsForm.txtEmpNo.value=='' || frmEmpPrmsMediBillsForm.txtBillAgst.value=='' || frmEmpPrmsMediBillsForm.txtBillDate.value=='')
  {
    alert("Please select Employee, Bill Against and Bill Date First");
    return;
  }
  else
  {
    if (frmEmpPrmsMediBillsForm.txtBillAgst.value=='DEPNDNT')
    {
       frmEmpPrmsMediBillsForm.lovKey.value = "EmpPrmsMediBillsDepndnt" + frmEmpPrmsMediBillsForm.screenName.value + "N";
       frmEmpPrmsMediBillsForm.queryParam.value = "EmpNo="+ frmEmpPrmsMediBillsForm.txtEmpNo.value +",BillDate="+ frmEmpPrmsMediBillsForm.txtBillDate.value +",hdnEmpLbrFlag="+ frmEmpPrmsMediBillsForm.hdnEmpLbrFlag.value ;             
       frmEmpPrmsMediBillsForm.txtDisplayFields.value = "txtDpndntNam,txtRelShip,txtDpndntId";
       frmEmpPrmsMediBillsForm.txtSearchFields.value = "";   
       frmEmpPrmsMediBillsForm.txtInputField.value ="";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPrmsMediBillsForm');
       return true;
    }else
    return;
  }  
}

function lfnLoad()
{  
    
        document.all.txtDedIT.disabled="true";
	 document.all.butDel.disabled="true";
	 document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
	var medicalCode = document.all.txtPayCode.value;
	if(medicalCode=='')
	{
	
		document.all.quarter.disabled = "true";
		document.all.quarter.style.background="#ffffff";
		
	}

	mode = document.all.screenMode.value;
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='N'|| frmEmpPrmsMediBillsForm.headerPrimaryKey.value=='' )
    { 
      document.all.butSendInv.disabled = "true"; 
      document.all.butCancelInv.disabled = "true";
//      document.getElementById("txtSancOrder").style.background="#e0e0e0";
//      document.getElementById("txtSancOrder").style.className="required";
//      document.getElementById("txtSancDate").style.background="#e0e0e0";
//      document.getElementById("txtSancDate").style.className="required";
      


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
      document.all.butSave.disabled="true";
      alert("Invoice already Sent Can not Modify the record now.");
    }
    onLoadBillAgst();
	var val = document.getElementById("txtPayCode").value;
	if(val != "") onChangeMediCodeU(val);
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "N")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpPrmsMediBillsForm.action="../../../EmpPrmsMediBillsNewMode.do"
    frmEmpPrmsMediBillsForm.submit();
}

function getHeaderRecord()
{
    if(mandatory_Check("frmEmpPrmsMediBillsForm"))
    {   
		document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmEmpPrmsMediBillsForm.action="../../../EmpPrmsMediBillsGetHeaderAction.do"
                frmEmpPrmsMediBillsForm.submit();
                
                
    }
  
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpPrmsMediBillsForm.userPositionRequested.value = 1*frmEmpPrmsMediBillsForm.positionRequested.value + 1;
    frmEmpPrmsMediBillsForm.action="../../../EmpPrmsMediBillsGetNextHeader.do";
    frmEmpPrmsMediBillsForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPrmsMediBillsForm.userPositionRequested.value = 1*frmEmpPrmsMediBillsForm.positionRequested.value - 1;
    frmEmpPrmsMediBillsForm.action = "../../../EmpPrmsMediBillsGetNextHeader.do";
    frmEmpPrmsMediBillsForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPrmsMediBillsForm.userPositionRequested.value = 1*frmEmpPrmsMediBillsForm.newPositionRequested.value;
    frmEmpPrmsMediBillsForm.action = "../../../EmpPrmsMediBillsGetNextHeader.do";
    frmEmpPrmsMediBillsForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpPrmsMediBillsForm.action="../../../EmpPrmsMediBillsQueryMode.do"
    frmEmpPrmsMediBillsForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpPrmsMediBillsForm.action="../../../EmpPrmsMediBillsRefresh.do"
    frmEmpPrmsMediBillsForm.submit();
}
function sendInv()
{
    if(!mandatory_Check("frmEmpPrmsMediBillsForm"))
    {
      return false;
    }
    document.all.butSendInv.disabled="true";
    frmEmpPrmsMediBillsForm.action="../../../EmpPrmsMediBillsSendInv.do"
    frmEmpPrmsMediBillsForm.submit();
}

function cancelInv()
{
    if(confirm("Do you want to cancel Invoice"))
    {
    document.all.butCancelInv.disabled="true";
    frmEmpPrmsMediBillsForm.action="../../../EmpPrmsMediBillsCancelInv.do"
    frmEmpPrmsMediBillsForm.submit();
    }
}
function SaveRecord()
{   
    document.all.txtITDedAmt.disabled ="";
    document.all.buttonFlag.value='';
    if(document.all.txtInvID.value=='')
    {
      if(mandatory_Check("frmEmpPrmsMediBillsForm"))
      {   
		  var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}
       calcAmt();
          
        if(frmEmpPrmsMediBillsForm.txtBillAgst.value=='DEPNDNT' && frmEmpPrmsMediBillsForm.txtRelShip.value=='')
        {
          alert("Dependent Name is Mandatory");
          return;
        }          
        if (frmEmpPrmsMediBillsForm.txtPayCode.value==197)
        {
          if(frmEmpPrmsMediBillsForm.txtAgencySite.value =='' || frmEmpPrmsMediBillsForm.txtAgencyName.value =='')
          {
            alert("Agency Code & Agency Site code are Mandatory");
            return;
          }
        }
        
        frmEmpPrmsMediBillsForm.detailDataChanged.value = "false";            
        if(frmEmpPrmsMediBillsForm.screenMode.value == 'N')
          frmEmpPrmsMediBillsForm.headerDataChanged.value = "true";
        else if(frmEmpPrmsMediBillsForm.screenMode.value == 'U')
          frmEmpPrmsMediBillsForm.headerDataChanged.value = "true";
          else
          frmEmpPrmsMediBillsForm.headerDataChanged.value = "false";
        frmEmpPrmsMediBillsForm.headerFields.value = "true";        
        document.all.txtDedIT.disabled ="";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpPrmsMediBillsForm.action = "../../../EmpPrmsMediBillsSaveAction.do";            
        frmEmpPrmsMediBillsForm.submit();
    }
    else
    {
        return false;
    }
  }   
      
}

function onChangeBillAgst(val)
{
  if (val=='DEPNDNT')
  {
    
    document.getElementById("txtDpndntNam").disabled = "";
    document.getElementById("txtDpndntNam").style.background="#ffffd3";
    document.getElementById("txtDpndntNam").style.className="required";
  }else
  {
    document.getElementById("txtDpndntNam").disabled = "true";
    document.getElementById("txtDpndntNam").style.background="#e0e0e0";
    document.getElementById("txtDpndntNam").style.className="locked";
  }
}


function onLoadBillAgst()
{
  if (frmEmpPrmsMediBillsForm.txtBillAgst.value=='DEPNDNT')
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
  }
}  

function setDependentVal()
{
  if(frmEmpPrmsMediBillsForm.txtBillAgst.value=='DEPNDNT')
  {    
      frmEmpPrmsMediBillsForm.txtDpndntId.value = '';
      frmEmpPrmsMediBillsForm.txtDpndntNam.value ='';
      frmEmpPrmsMediBillsForm.txtRelShip.value ='';
  }
}


function onChangeMediCode(val)
{
  document.getElementById("txtEmpNo").value = "";
  document.getElementById("txtEmpName").value = "";
  if (!(val==197))
  { 
                document.getElementById("txtDedIT").disabled = "";
                document.all.quarter.disabled = "true";
                document.all.quarter.style.className="optional";
                document.all.quarter.style.background="#e0e0e0";
                
			  //document.all.finYear.style.background="#e0e0e0";
                          
		document.getElementById("txtAgencyName").readOnly = true;
		frmEmpPrmsMediBillsForm.txtAgency.value ='';
		frmEmpPrmsMediBillsForm.txtAgencyName.value ='';
		document.getElementById("txtAgencyName").style.background="#e0e0e0";
		
		document.getElementById("txtAgencySite").readOnly = true;
		frmEmpPrmsMediBillsForm.txtAgencySiteCode.value='';
		frmEmpPrmsMediBillsForm.txtAgencySite.value ='';
		document.getElementById("txtAgencySite").style.background="#e0e0e0";    
		document.getElementById("quarter").selectedIndex=0;
  }
  else
  {
		if(document.all.screenMode.value!='Q')
		{
		frmEmpPrmsMediBillsForm.txtDedIT.value ='N';
		document.getElementById("txtDedIT").disabled = "true";
		document.getElementById("txtAgencyName").readOnly = false;
		document.getElementById("txtAgencyName").style.background="#ffffd3";
		document.getElementById("txtAgencySite").readOnly = false;
		document.getElementById("txtAgencySite").style.background="#ffffd3";  
		document.getElementById("txtITDedAmt").readOnly = true;
		document.getElementById("txtITDedAmt").style.background="#e0e0e0";  
		//alert('inside 2nd else')
		document.all.quarter.disabled = "true";
		document.all.quarter.style.className="optional";
		document.all.quarter.style.background="#e0e0e0";
		//document.all.finYear.style.background="#e0e0e0";
	    }
		else
		{
		frmEmpPrmsMediBillsForm.txtDedIT.value ='N';
		document.getElementById("txtDedIT").disabled = "true";
		document.getElementById("txtAgencyName").readOnly = true;
		document.getElementById("txtAgencyName").style.background="#e0e0e0";
		document.getElementById("txtAgencySite").readOnly = true;
		document.getElementById("txtAgencySite").style.background="#e0e0e0";  
		document.getElementById("txtITDedAmt").readOnly = true;
		document.getElementById("txtITDedAmt").style.background="#e0e0e0";  
    		document.all.quarter.disabled = "true";
		document.all.quarter.style.className="optional";
		document.all.quarter.style.background="#e0e0e0";
		//document.all.finYear.style.background="#e0e0e0"; 
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
  //calcAmt();
  
  if(document.getElementById("txtEmpNo").value=="")
  {
    alert("Please Select Employee No. First");
    document.getElementById("txtDedIT").value="";
    return false;
  }
  document.getElementById("txtITDedAmt").value = "";
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

}

function calcAmt()
{  
    if (document.all.txtDedIT.value=='Y'){
    var itDed=document.all.txtITDedAmt.value==""?"0":document.all.txtITDedAmt.value;
     document.all.txtNetAmt.value = parseInt(document.all.txtClaimAmt.value - itDed);
}
 if (document.all.txtDedIT.value=='N'||document.all.txtDedIT.value==''){
    var itDed=document.all.txtITDedAmt.value==""?"0":document.all.txtITDedAmt.value;
    document.all.txtNetAmt.value =document.all.txtClaimAmt.value ;
}
 adjCeil();
}

function  adjCeil(){
    document.all.txtCeilAdj.value=document.all.txtClaimAmt.value;
    document.all.txtCloseBal.value=document.all.txtOpenBal.value-document.all.txtCeilAdj.value;    
}

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
			frmEmpPrmsMediBillsForm.txtDedIT.value ='Y';
			document.getElementById("txtDedIT").disabled = "true";
			document.getElementById("txtITDedAmt").readOnly = false;
			document.getElementById("txtITDedAmt").style.background="#ffffff";   
			document.all.quarter.disabled = "";
			document.all.quarter.style.className="required";
			document.all.quarter.style.background="#ffffd3";
			document.all.finYear.readOnly = false;
			document.all.finYear.style.className="required";
			//document.all.finYear.style.background="#ffffd3";
		}
		else
		{
			  document.getElementById("txtDedIT").disabled = "";
			  document.all.quarter.disabled = "true";
			  document.all.quarter.style.className="optional";
			  document.all.quarter.style.background="#e0e0e0";
			  document.all.finYear.readOnly = true;
			  document.all.finYear.style.className="optional";
			  document.all.finYear.style.background="#e0e0e0"; 
		}
		document.getElementById("txtAgencyName").readOnly = true;
		frmEmpPrmsMediBillsForm.txtAgency.value ='';
		frmEmpPrmsMediBillsForm.txtAgencyName.value ='';
		document.getElementById("txtAgencyName").style.background="#e0e0e0";
		
		document.getElementById("txtAgencySite").readOnly = true;
		frmEmpPrmsMediBillsForm.txtAgencySiteCode.value='';
		frmEmpPrmsMediBillsForm.txtAgencySite.value ='';
		document.getElementById("txtAgencySite").style.background="#e0e0e0";    
  }
  else
  {
		if(document.all.screenMode.value!='Q')
		{
		frmEmpPrmsMediBillsForm.txtDedIT.value ='N';
		document.getElementById("txtDedIT").disabled = "true";
		document.getElementById("txtAgencyName").readOnly = false;
		document.getElementById("txtAgencyName").style.background="#ffffd3";
		document.getElementById("txtAgencySite").readOnly = false;
		document.getElementById("txtAgencySite").style.background="#ffffd3";  
		document.getElementById("txtITDedAmt").readOnly = true;
		document.getElementById("txtITDedAmt").style.background="#e0e0e0";  
		document.all.quarter.disabled = "true";
		document.all.quarter.style.className="optional";
		document.all.quarter.style.background="#e0e0e0";
		document.all.finYear.readOnly = false;
		document.all.finYear.style.className="required";
		//document.all.finYear.style.background="#e0e0e0"; 
	    }
		else
		{
		frmEmpPrmsMediBillsForm.txtDedIT.value ='N';
		document.getElementById("txtDedIT").disabled = "true";

		document.getElementById("txtAgencyName").readOnly = true;
		document.getElementById("txtAgencyName").style.background="#e0e0e0";
		document.getElementById("txtAgencySite").readOnly = true;
		document.getElementById("txtAgencySite").style.background="#e0e0e0";  
		document.getElementById("txtITDedAmt").readOnly = true;
		document.getElementById("txtITDedAmt").style.background="#e0e0e0";  
		document.all.quarter.disabled = "true";
		document.all.quarter.style.className="optional";
		document.all.quarter.style.background="#e0e0e0";
		document.all.finYear.readOnly = false;
                document.all.finYear.style.className="required";
		document.all.finYear.style.background="#e0e0e0"; 
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

function GetCeilDtl()
{
    if(document.all.screenMode.value!='N')
        {
            document.all.txtCloseBal.value=document.all.txtOpenBal.value;
            document.all.txtCeilAdj.value=frmEmpPrmsMediBillsForm.txtClaimAmt.value;
        }
}
function GetCeilDtlN()
{   
    if(document.all.txtEmpNo.value=='')
        {
            alert("Please Enter Employee Details First");
            return false;
        }
    if(document.all.finYear.value=='')
        {
            alert("Please Enter Financial Year First");
            return false;
        }
        
    else  {
        url="../../../GetEmpDtlRetroParZone.do";
        //alert(frmEmpPrmsMediBillsForm.txtPayCode.value);
        //prm="mode=1&txtEmpNo="+frmEmpPrmsMediBillsForm.txtEmpNo.value+"&finYear="+frmEmpPrmsMediBillsForm.finYear.value+"&txtClaimAmt="+frmEmpPrmsMediBillsForm.txtClaimAmt.value+" &txtPayCode="+frmEmpPrmsMediBillsForm.txtPayCode.value+"&screenName="+frmEmpPrmsMediBillsForm.screenName.value;
        prm="mode=1&txtEmpNo="+frmEmpPrmsMediBillsForm.txtEmpNo.value+"&finYear="+frmEmpPrmsMediBillsForm.finYear.value+" &txtPayCode="+frmEmpPrmsMediBillsForm.txtPayCode.value+"&screenName="+frmEmpPrmsMediBillsForm.screenName.value;
        //alert(prm);
        xml=getXML(url,prm);
        Tags=xml.getElementsByTagName("record");
        document.all.txtCeilAdj.value=frmEmpPrmsMediBillsForm.txtClaimAmt.value;
        if(Tags.length > 0)
        { 
            frmEmpPrmsMediBillsForm.txtOpenBal.value=Tags[0].childNodes[0].nodeValue;
            frmEmpPrmsMediBillsForm.txtCloseBal.value=frmEmpPrmsMediBillsForm.txtOpenBal.value;
            //frmEmpPrmsMediBillsForm.txtCloseBal.value=Tags[1].childNodes[0].nodeValue;
            /*document.all.txtBillDate.readOnly = false;
            document.all.txtBillDate.style.className="required";
            document.all.txtBillDate.style.background="#e0e0e0";*/
            return true;
        }
        else
        {
            alert("Error Occured Please Contact Administrator");
            return false;
        }
    }
}
</script>