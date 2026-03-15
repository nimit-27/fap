<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>           
   <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../INCLUDES/ENRGISE.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/Payroll.js"></script>     
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="MaintPfDetailBase" name="frmMaintPfDetail" type="FCIPAY.Payroll.WEBTIER.Form.MaintPfDetailForm" scope="session">
<bean:define id="ParentForm" name="frmMaintPfDetail" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>


<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN PF DETAILS</TD>
</TR>
</TABLE>
<!--container table starts -->
<div id=divBody style="height:90%">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>

       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> PF Header Information</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.emp" /></td>
            <td align="left">
				<html:text property="txtEmpNo" altKey="Payroll.MaintPfDetail.emp" maxlength="10" size="23" styleClass="required"  />
				<logic:equal property= "screenMode" name= "frmMaintPfDetail" value="N">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="return ShowEmpNum();">
				</logic:equal>
				<logic:equal property= "screenMode" name= "frmMaintPfDetail" value="Q">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="return ShowEmpNum();">
				</logic:equal>
				<logic:equal property= "screenMode" name= "frmMaintPfDetail" value="U">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="">
				</logic:equal>
				<logic:equal property= "screenMode" name= "frmMaintPfDetail" value="UG">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="">
				</logic:equal>
				&nbsp;&nbsp;
				<html:text  property="txtEmpName"  maxlength="10" size="30" styleClass="locked" readonly="true" />
				<html:hidden  property="txtCpfCode" name= "frmMaintPfDetail" />
            </td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.FromYr" /></td>
            <td>
				<html:text  property="txtFromYear" altKey="Payroll.MaintPfDetail.FromYr" maxlength="4" size="23" styleClass="required" onchange="
				if (!num_Check(this.value,1))
				{
					this.focus();
					return false;
				}  
				
				if(!(chk_Year()))
				{
					this.focus();
					return false;              
				}
				else
				{
				   calcToYear();
				   
				}                                         
            " />
          <!--  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtFromYear"  onclick="ShowLovYYMM();">    -->


                 <logic:equal property= "screenMode" name= "frmMaintPfDetail" value="">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtFromYear"  onclick="ShowLovYYMM();">
                 </logic:equal>                                      
                 <logic:equal property= "screenMode" name= "frmMaintPfDetail" value="Q">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtFromYear"  onclick="ShowLovYYMM();">
                 </logic:equal>      
                  <logic:equal property= "screenMode" name= "frmMaintPfDetail" value="U">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtFromYear" disabled onclick="">
                 </logic:equal>   
                  <logic:equal property= "screenMode" name= "frmMaintPfDetail" value="UG">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtFromYear" disabled onclick="">
                 </logic:equal>  
          
            </td>
        </tr>

        <tr>
            <td class="labelText" width="15%" ><bean:message key="Payroll.MaintPfDetail.PFno" /></td>
            <td><html:text property="txtPFAcctNo" size="26"  styleClass="locked" style="text-align:left;" readonly="true" />
            <td class="labelText" width="15%" ><bean:message key="Payroll.MaintPfDetail.ToYr" /></td>
            <td><html:text  property="txtToYear" altKey="Payroll.MaintPfDetail.ToYr" maxlength="4" size="23" styleClass="required" /></td>         
        </tr>

        <tr>
			<td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PF" /></td>
			<td>
				<html:select  property="txtPfType" styleClass = "optional" alt="txtPF" >
				<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
				<html:option value="PFTYPE$CPF" >CPF </html:option>
				<html:option value="PFTYPE$GPF" > GPF</html:option>
				<!--    <html:option value="EP" > EPF</html:option>
				<html:option value="EN" > ENCPF</html:option>
				-->                        
				</html:select>
			</td>   
        </tr>
      
         <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>


<table border = 0 cellSpacing=0 cellPadding=0 >

   <tr>
   <td width = "50%">
      <TABLE cellSpacing=0 cellPadding=0  border = 0 style="BORDER-TOP: #4682b4 thin solid;BORDER-BOTTOM: #4682b4 thin solid;BORDER-LEFT: #4682b4 thin solid;BORDER-RIGHT: #4682b4 thin solid;">
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6></TD>
        </TR>

         <tr height="15" >
            <td colspan="6"></td>
         </tr>
         
        <tr>
            <td align="center" colspan="6 "class=subHeading >OPENING</td>
        </tr>
        <tr>
            <td colspan=2 align="center" class=smallHeading  >PF</td>
            <td align="center" class=smallHeading >INTEREST</td>
        </tr>
<logic:equal property="screenMode" name="frmMaintPfDetail" value="N">
        <tr>
            <td class="labelText"  width="15%" >Employee's Contribution</td>
            <td><html:text property="txtEmpOpnCon"  size="26" styleClass="optional" style="text-align:right" onchange="return lfnChange(this.value);" /></td>
            <td><html:text property="txtEmpOpnInt"  size="26" styleClass="optional" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td colspan=3></td>
         </tr>

         <tr>
            <td class="labelText"  width="15%" >Employer's Contribution</td>
            <td><html:text property="txtEmprOpnCon" size="26"  styleClass="optional" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td><html:text property="txtEmprOpnInt" size="26"  styleClass="optional" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td colsapn=3></td>
         </tr>

         <tr>
            <td class="labelText"  width="15%" >VPF</td>
            <td><html:text property="txtVPFOpnPf" size="26"  styleClass="optional" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td><html:text property="txtVPFOpnInt" size="26" styleClass="optional" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td colsapn=3></td>
         </tr>
</logic:equal>
<logic:notEqual property="screenMode" name="frmMaintPfDetail" value="N">
        <tr>
            <td class="labelText"  width="15%" >Employee's Contribution</td>
            <td><html:text property="txtEmpOpnCon"  size="26" styleClass="locked" style="text-align:right" readonly="true" /></td>
            <td><html:text property="txtEmpOpnInt"  size="26" styleClass="locked" style="text-align:right" readonly="true" /></td>
            <td colspan=3></td>
         </tr>

         <tr>
            <td class="labelText"  width="15%" >Employer's Contribution</td>
            <td><html:text property="txtEmprOpnCon" size="26"  styleClass="locked" style="text-align:right" readonly="true" /></td>
            <td><html:text property="txtEmprOpnInt" size="26"  styleClass="locked" style="text-align:right" readonly="true" /></td>
            <td colsapn=3></td>
         </tr>

         <tr>
            <td class="labelText"  width="15%" >VPF</td>
            <td><html:text property="txtVPFOpnPf" size="26"  styleClass="locked" style="text-align:right" readonly="true" /></td>
            <td><html:text property="txtVPFOpnInt" size="26" styleClass="locked" style="text-align:right" readonly="true" /></td>
            <td colsapn=3></td>
         </tr>
</logic:notEqual>
		 <tr>
            <td width="15%" colspan="3" align="center" style="height:25">
				<logic:equal property= "screenMode" name= "frmMaintPfDetail" value="N">
					<html:button value='Adjust PF' onclick="showAdjustHdr(1)" property="butInsert" styleClass="bottomBarText" disabled="true" />			
					<html:button value='View Adjusted PF History' onclick="showAdjustHistoryHdr(1)" property="butInsert" styleClass="bottomBarText" disabled="true" />			
				</logic:equal>
				<logic:notEqual property= "screenMode" name= "frmMaintPfDetail" value="N">
					<html:button value='Adjust PF' onclick="showAdjustHdr(1)" property="butInsert" styleClass="bottomBarText" />			
					<html:button value='View Adjusted PF History' onclick="showAdjustHistoryHdr(1)" property="butInsert" styleClass="bottomBarText" />			
				</logic:notEqual>
			</td>
         </tr>

		   <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </td>


   <td width = "50%">
      <TABLE cellSpacing=0 cellPadding=0  border = 0 style="BORDER-RIGHT: #4682b4 thin solid;BORDER-TOP: #4682b4 thin solid;BORDER-BOTTOM: #4682b4 thin solid;">
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6></TD>
        </TR>

         <tr height="15" >
            <td colspan="6"></td>
         </tr>
         
        <tr>
            <td align="center" colspan="6 " class=subHeading>CLOSING</td>
        </tr>
        <tr>
            <td colspan=2 align="center" class=smallHeading>PF</td>
            <td align="center" class=smallHeading >INTEREST</td>
        </tr>

        <tr>
            <td class="labelText"  width="15%" >Employee's Contribution</td>
            <td><html:text property="txtEmpCloCon" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td><html:text property="txtEmpCloInt" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td colspan=3></td>
        </tr>
        <tr>
            <td class="labelText"  width="15%" >Employer's Contribution</td>
            <td><html:text property="txtEmprCloCon" readonly="true" size="26" styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td><html:text property="txtEmprCloInt" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td colsapn=3></td>
        </tr>
        <tr>
            <td class="labelText"  width="15%" >VPF</td>
            <td><html:text property="txtVPFCloPf" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td><html:text property="txtVPFCloInt" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td colsapn=3></td>
        </tr>

		 <tr>
            <td width="15%" colspan="3" align="center" style="height:25">
				&nbsp;		
			</td>
         </tr>

           <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </td>
    
    </tr>

    </table>

	<TABLE border = 0 cellSpacing=0 cellPadding=0 >
		<TR id="rowid1" style="display:none">
			<TD width="50%">
				<table cellSpacing=0 cellPadding=0  border = 0 style="BORDER-RIGHT: #4682b4 thin solid;BORDER-BOTTOM: #4682b4 thin solid;BORDER-LEFT: #4682b4 thin solid;">
					<tr height="10">		    
					<TD colspan="4" > </TD>
					</tr>
					<tr>
						<td class="labelText" align="right" width="15%">Adjust Type</td>
						<td align="left" colspan="3">
							<html:select property="txtAdjTypeHdr">
							<html:option value="">----------------------Please Select--------------------</html:option>
							<logic:present name="AdjPfHdr">
								<html:optionsCollection label="label" value="value" name="AdjPfHdr" property="adjPfHdrList" />
							</logic:present>
							</html:select>
						</td>
					</tr>
					<tr>
						<td class="labelText" align="right">Pay Mode</td>
						<td align="left">
							<html:select property="txtPayMode" >
								<html:option value="A">Add</html:option>
								<html:option value="S">Subtract</html:option>
							</html:select>
						</td>
						<td class="labelText" align="right" width="25%">Adjust Amount</td>
						<td><html:text property="txtAdjAmtHdr" size="11" styleClass="optional" style="text-align:right" onkeypress="
										 if((event.keyCode < 48 || event.keyCode > 57))
										  {
											return false;
										  };" onchange="return lfnChange(this.value);" /></td>
					</tr>
					<tr>
						<td class="labelText" align="right" width="15%">Remark</td>
						<td align="left" colspan="3">
                            <textarea  name="txtRmrkHdr" cols="80" rows="2"></textarea>
						</td>
					</tr>
					<tr height="10">
					<TD colspan="4" > </TD>
					</tr>
					<tr>
						<td colspan=4 align="center"><html:button value='Close' onclick="showAdjustHdr(2)" property="butInsert" styleClass="bottomBarText" /></td>
					</tr>
					<tr height="10">
					<TD colspan="4" > </TD>
					</tr>
				</table>
			</TD>
			<TD width="50%">&nbsp;</TD>
		</TR>
	</TABLE>


	<TABLE cellSpacing=0 cellPadding=0  border = 0 >
		<TBODY>
		<logic:equal property="histBtn" name="frmMaintPfDetail" value="VHH">
			<TR id="rowid2" >
				<TD width="50%">
				<TABLE cellSpacing=0 cellPadding=0  border = 0>
					<TR>
						<TD>
							<DIV id=divDtlTable style="height:200px;width= 100%">
								<table cellSpacing=0 cellPadding=0  border = 0 >
								<tbody>
								  <TR>
									<TD class=tableHeader width="10%" height="25">Adjust Type</td>
									<TD class=tableHeader width="4%">Pay Mode</TD>
									<TD class=tableHeader width="3%">Adjust Amount</td>
									<TD class=tableHeader width="5%">Modified Date/Time</td>
									<TD class=tableHeader width="10%">Remark</TD>
								  <TR>
									<logic:present property="adjHistHdrList" name="frmMaintPfDetail" >
										  <logic:iterate id="adjHdrHistInfo" name="frmMaintPfDetail" property="adjHistHdrList" type="FCIPAY.Payroll.UTILITY.PfAdjustHistoryBean"  >
											<tr> 
											  <td><html:text property="txtAdjTypeHdr1" name="adjHdrHistInfo" styleClass="locked" style="width:100%" /></td>
											  <td><html:text property="txtPayMode1" name="adjHdrHistInfo" styleClass="locked" style="width:100%" /></td>
											  <td><html:text property="txtAdjAmtHdr1" name="adjHdrHistInfo" styleClass="locked" style="width:100%;text-align:right;padding-right:5px" /></td>
											  <td><html:text property="txtModDtHdr" name="adjHdrHistInfo" styleClass="locked" style="width:100%;text-align:center;" /></td>
											  <td><html:text property="txtRmrkHdr1" name="adjHdrHistInfo" styleClass="locked" style="width:100%" /></td>
											</tr>
										  </logic:iterate>
									</logic:present>
									<logic:notPresent property="adjHistHdrList" name="frmMaintPfDetail" >
										<tr> 
										  <td colspan="5" align="center"><bean:message key="Pfdetail.history" /></td>
										</tr>
									</logic:notPresent>
								</tbody>
								</table>
							</DIV>
						</TD>
					</TR>
					<tr height="10">
					<TD colspan="4" > </TD>
					</tr>
					<tr>
						<td colspan=4 align="center"><html:button value='Close' onclick="closeAdjustHistoryHdr()" property="butInsert" styleClass="bottomBarText" /></td>
					</tr>
					<tr height="10">
					<TD colspan="4" > </TD>
					</tr>
				</TABLE>
				</TD>
			<TR>
		</logic:equal>
		</TBODY>
	 </TABLE>



<TABLE cellSpacing=0 cellPadding=0 >
     
           <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>

  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
            <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>Pf Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="5">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:300px;width= 100%" >
  			<!-- Detail table starts -->
                          <TABLE cellSpacing=0 cellPadding=0 id="Detail" border=0>
                          <TBODY>
                          <TR>
                            <TD class=tableHeader width="1%"></td>
                            <TD class=tableHeader width="4%"><bean:message  key="Payroll.MaintPfDetail.year" /></td>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.empsub" /></TD>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.empcon" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.volpf" /></TD>
                            <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintPfDetail.advamtempsub" /></td>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.advamtvpf" /></td>
                            <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintPfDetail.advdate" /></td>                            
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.refadv" /></TD>
                            <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintPfDetail.Advrefdate" /></TD>    
							
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.extravpf" /></td>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.amtwithdrwemp" /></td>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.amtwithdrwempr" /></td>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.amtwithdrwvpf" /></td>

                            <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintPfDetail.withdate" /></td>                            
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.eps" /></td>                            
                         <!--   <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.pfarrear" /></td>                            

					    <TD class=tableHeader width="7%"><bean:message  key="Payroll.MaintPfDetail.widRef" /></td>
                            <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintPfDetail.widRefDate" /></td>                                                        
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.bondepopf" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.exvpfamt" /></td> 
                            <TD class=tableHeader width="7%"><bean:message  key="Payroll.MaintPfDetail.pfArrear" /></td>  -->                         
                            </TR>

                          
                          
                          <logic:iterate id="PfDetailInfo" name="frmMaintPfDetail" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintPfDetailBean"  >
                          <% ++i; %>
                          <logic:notEqual name="PfDetailInfo" property="status" value="D" >
							  <logic:equal name="PfDetailInfo" property="status" value="N" >
								<tr> 
									  <td align=center >
											<html:checkbox property="checked" name="frmMaintPfDetail" alt="<%=String.valueOf(i-1)%>" onclick="checkRecord1(this.alt);" value="false" />
									  </td>
									  <td><html:text property="txtYearMon" name="PfDetailInfo" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtEmpSub" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtEmpCon" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtVolPf" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtAdvAmtEmpSub" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtAdvAmtVpf" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtAdvDate" name="PfDetailInfo"  styleClass="optional" size="26" style="width:80%;text-align:right"  alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" />
										  <img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" onclick="showCalendar('txtAdvDate',this)" />
									  </td>
									  <td><html:text property="txtRefAdv" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtAdvRefDate" name="PfDetailInfo" styleClass="optional" size="26" style="width:80%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" />
										  <img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" onclick="showCalendar('txtAdvRefDate',this)" />
									  </td>
									  
									  <td><html:text property="txtExtraVpf" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td> <!-- interest on advance-->
									  <td><html:text property="txtAmtWithDrwEmp" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtAmtWithDrwEmpr" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtAmtWithDrwVpf" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
									  <td><html:text property="txtWithDate" name="PfDetailInfo"  styleClass="optional" size="26" style="width:80%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" />
										  <img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" onclick="showCalendar('txtWithDate',this)" />
									  </td>
									  <td><html:text property="txtEPS" name="PfDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
								   <!--   <td><html:text property="txtPfArrear" name="PfDetailInfo"  styleClass="optional" size="26" style="width:100%;text-align:center" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /> Commented By Ankit -->
                                       <td><html:hidden property="txtPfArrear" name="PfDetailInfo" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" />
								 </tr>
							  </logic:equal>
							  <logic:notEqual name="PfDetailInfo" property="status" value="N" >
								<tr> 
									  <td align=center >
											<html:checkbox property="checked" name="frmMaintPfDetail" alt="<%=String.valueOf(i-1)%>" onclick="checkRecord1(this.alt);" value="false" />
									  </td>
									  <td><html:text property="txtYearMon" name="PfDetailInfo" styleClass="locked" style="width:100%" alt="<%=String.valueOf(i-1)%>" readonly="true"/></td>
									  <td><html:text property="txtEmpSub" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									  <td><html:text property="txtEmpCon" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									  <td><html:text property="txtVolPf" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									  <td><html:text property="txtAdvAmtEmpSub" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									  <td><html:text property="txtAdvAmtVpf" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									  <td><html:text property="txtAdvDate" name="PfDetailInfo"  styleClass="locked" size="26" style="width:80%;text-align:right"  alt="<%=String.valueOf(i-1)%>" readonly="true" />
										  <img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" />
									  </td>
									  <td><html:text property="txtRefAdv" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									  <td><html:text property="txtAdvRefDate" name="PfDetailInfo" styleClass="locked" size="26" style="width:80%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" />
										  <img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" />
									  </td>
									  
									  <td><html:text property="txtExtraVpf" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td> <!-- interest on advance-->
									  <td><html:text property="txtAmtWithDrwEmp" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									  <td><html:text property="txtAmtWithDrwEmpr" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									  <td><html:text property="txtAmtWithDrwVpf" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									  <td><html:text property="txtWithDate" name="PfDetailInfo"  styleClass="locked" size="26" style="width:80%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" />
										  <img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" />
									  </td>
									  <td><html:text property="txtEPS" name="PfDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
									 <!--  <td><html:text property="txtPfArrear" name="PfDetailInfo"  styleClass="locked" size="26" style="width:100%;text-align:center" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>Commeneted by ankit -->
								     <td><html:hidden property="txtPfArrear" name="PfDetailInfo" alt="<%=String.valueOf(i-1)%>" /></td>
                                 </tr>
							  </logic:notEqual>
									  <html:hidden property="txtBonusToPf" name="PfDetailInfo" />
									  <html:hidden property="txtBonToPfDate" name="PfDetailInfo" />
									  <html:hidden property="itemChecked" name="PfDetailInfo" />
									  <html:hidden property="status" name="PfDetailInfo" />
									  <html:hidden property="detailId" name="PfDetailInfo" value="Default"/>                                   
                          </logic:notEqual>
                          <logic:equal name="PfDetailInfo" property="status" value="D" >                              
                            <tr> 
		     					  <td><html:hidden property="checked" name="frmMaintPfDetail" value="notchecked" /></td>
                                  <td><html:hidden property="txtYearMon" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtEmpSub" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtEmpCon" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtVolPf" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtAdvAmtEmpSub" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtAdvAmtVpf" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtAdvDate" name="PfDetailInfo" />
                                  <td><html:hidden property="txtRefAdv" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtAdvRefDate" name="PfDetailInfo" />
                                  <td><html:hidden property="txtExtraVpf" name="PfDetailInfo" /></td> <!-- interest on advance-->
                                  <td><html:hidden property="txtAmtWithDrwEmp" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtAmtWithDrwEmpr" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtAmtWithDrwVpf" name="PfDetailInfo" /></td>
                                  <td><html:hidden property="txtWithDate" name="PfDetailInfo"  />
                                  <td><html:hidden property="txtEPS" name="PfDetailInfo"  /></td>
                                  <td><html:hidden property="txtPfArrear" name="PfDetailInfo" /></td>
                                  
                                  <html:hidden property="txtBonusToPf" name="PfDetailInfo" />
                                  <html:hidden property="txtBonToPfDate" name="PfDetailInfo" />
                                  <html:hidden property="itemChecked" name="PfDetailInfo" />
                                  <html:hidden property="status" name="PfDetailInfo" />
                                  <html:hidden property="detailId" name="PfDetailInfo" value="Default"/>                                   
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
                            <tr>
                             <td colspan=11>	
                             <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                             </TD>
                           </tr>
                      </TBODY>
                    </TABLE>
                </TD>
               </tr> 
			   <tr>
					<td colspan=11>
						<TABLE border=0>
						  <TBODY>
							   <tr>
								 	<td	align="center"><html:button value='Adjust PF Detail' onclick="showAdjustDtl(1)" property="butAdjust" styleClass="bottomBarText" disabled="true" />
								 		<html:button value='View Adjusted PF Detail History' onclick="showAdjustHistoryDtl()" property="butViewAdj" styleClass="bottomBarText" disabled="true" />
									</TD>
							   </tr>
						  </TBODY>
						</TABLE>
					</td>
			   </tr>

			   <tr>
					<td colspan=11>
						<TABLE border = 0 cellSpacing=0 cellPadding=0 >
							<TR id="rowid3" style="display:none">
								<TD width="50%">
									<table cellSpacing=0 cellPadding=0  border = 0 style="BORDER-RIGHT: #4682b4 thin solid;BORDER-TOP: #4682b4 thin solid;BORDER-LEFT: #4682b4 thin solid;">
										<tr height="10">		    
										<TD colspan="4" > </TD>
										</tr>
										<tr>
											<td class="labelText" align="right" width="15%">Year Month</td>
											<td align="left" colspan="3">
												<html:text property="txtYYMMDtl" styleClass="locked" name="frmMaintPfDetail" />
											</td>
										</tr>
										<tr>
											<td class="labelText" align="right" width="15%">Adjust Type</td>
											<td align="left" colspan="3">
												<html:select property="txtAdjTypeDtl" onchange="return AdjDtlChanged();">
												<html:option value="">----------------------Please Select--------------------</html:option>
												<logic:present name="AdjPfDtl">
													<html:optionsCollection label="label" value="value" name="AdjPfHdr" property="adjPfDtlList" />
												</logic:present>
												</html:select>
											</td>
										</tr>
										<tr>
											<td class="labelText" align="right">Pay Mode</td>
											<td align="left">
												<html:select property="txtPayModeDtl" >
													<html:option value="A">Add</html:option>
													<html:option value="S">Subtract</html:option>
												</html:select>
											</td>
											<td class="labelText" align="right" width="25%">Adjust Amount</td>
											<td><html:text property="txtAdjAmtDtl" size="11" styleClass="optional" onkeypress="
										 if((event.keyCode < 48 || event.keyCode > 57))
										  {
											return false;
										  };" style="text-align:right" /></td>
										</tr>
										<tr>
											<td class="labelText" align="right" width="15%">Remark</td>
											<td align="left" colspan="3">
												<textarea  name="txtRmrkDtl" cols="80" rows="2" name="frmMaintPfDetail"></textarea>
											</td>
										</tr>
										<tr height="10">
										<TD colspan="4" > </TD>
										</tr>
										<tr>
											<td colspan=4 align="center"><html:button value='Close' onclick="showAdjustDtl(2)" property="butInsert" styleClass="bottomBarText" /></td>
										</tr>
										<tr height="10">
										<TD colspan="4" > </TD>
										</tr>
									</table>
								</TD>
								<TD width="50%">&nbsp;</TD>
							</TR>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=0  border = 0 >
							<TBODY>
							<logic:equal property="histBtn" name="frmMaintPfDetail" value="VDH">
								<TR id="rowid4" >
									<TD width="50%">
									<TABLE cellSpacing=0 cellPadding=0  border = 0>
										<TR>
											<TD>
												<DIV id=divDtlTable style="height:200px;width= 100%">
													<table cellSpacing=0 cellPadding=0  border = 0 >
													<tbody>
													  <TR>
														<TD class=tableHeader width="10%" height="25">Adjust Type</td>
														<TD class=tableHeader width="4%">Pay Mode</TD>
														<TD class=tableHeader width="3%">Adjust Amount</td>
														<TD class=tableHeader width="5%">Modified Date/Time</td>
														<TD class=tableHeader width="10%">Remark</TD>
													  <TR>
														<logic:present property="adjHistDtlList" name="frmMaintPfDetail" >
														  <logic:iterate id="adjDtlHistInfo" name="frmMaintPfDetail" property="adjHistDtlList" type="FCIPAY.Payroll.UTILITY.PfAdjustHistoryBeanDtl"  >
															<tr> 
															  <td><html:text property="txtAdjTypeDtl1" name="adjDtlHistInfo" styleClass="locked" style="width:100%" /></td>
															  <td><html:text property="txtPayModeDtl1" name="adjDtlHistInfo" styleClass="locked" style="width:100%" /></td>
															  <td><html:text property="txtAdjAmtDtl1" name="adjDtlHistInfo" styleClass="locked" style="width:100%;text-align:right;padding-right:5px" /></td>
															  <td><html:text property="txtModDtDtl" name="adjDtlHistInfo" styleClass="locked" style="width:100%;text-align:center;" /></td>
															  <td><html:text property="txtRmrkDtl1" name="adjDtlHistInfo" styleClass="locked" style="width:100%" /></td>
															</tr>
														  </logic:iterate>
														</logic:present>
														<logic:notPresent property="adjHistDtlList" name="frmMaintPfDetail" >
															<tr> 
																<tr> 
																  <td colspan="5" align="center"><bean:message key="Pfdetail.history" /></td>
																</tr>
															</tr>
														</logic:notPresent>
													</tbody>
													</table>
												</DIV>
											</TD>
										</TR>
										<tr height="10">
										<TD colspan="4" > </TD>
										</tr>
										<tr>
											<td colspan=4 align="center"><html:button value='Close' onclick="closeAdjustHistoryDtl()" property="butInsert" styleClass="bottomBarText" /></td>
										</tr>
										<tr height="10">
										<TD colspan="4" > </TD>
										</tr>
									</TABLE>
									</TD>
								<TR>
							</logic:equal>
							</TBODY>
						 </TABLE>

					</td>
			   </tr>

                 
  </TBODY>
		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
               <tr>
		<TD background="../INCLUDES/IMAGES/line_r.gif"><IMG src="../INCLUDES/IMAGES/pixel.gif" border=0></TD>
		</TR>
    <TR>
     <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
               <td align=center bgcolor=#4682b4 width="40%"></td>
               <!--<td  bgcolor=#4682b4><html:button value='Approve'  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Reject '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Revise '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /></td>-->
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
<html:hidden name="frmMaintPfDetail"  property="screenName" value="pfDetailScreen" />
<html:hidden name="frmMaintPfDetail"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintPfDetail" />
<html:hidden property="headerPrimaryKey" name="frmMaintPfDetail" />
<html:hidden property="screenMode" name="frmMaintPfDetail" />
<html:hidden property="screenModePay1" name="frmMaintPfDetail"  />
<html:hidden property="screenModePfDtl" name="frmMaintPfDetail"  />
<html:hidden property="positionRequested" name="frmMaintPfDetail" />
<html:hidden property="userPositionRequested" name="frmMaintPfDetail" />
<html:hidden property="pageRequested" name="frmMaintPfDetail" />
<html:hidden property="userPageRequested" name="frmMaintPfDetail" />\
<html:hidden property="buttonFlag" name="frmMaintPfDetail"  />
<html:hidden property="loginLocCode" name="frmMaintPfDetail"  />

<html:hidden property="lovKey" name="frmMaintPfDetail"  />
<html:hidden property="txtFields" name="frmMaintPfDetail"  />   
<html:hidden property="txtSearchFields" name="frmMaintPfDetail"  />
<html:hidden property="txtDisplayFields" name="frmMaintPfDetail"  />
<html:hidden property="txtIndex" name="frmMaintPfDetail"  />
<html:hidden property="userBtn" name="frmMaintPfDetail"  />
<html:hidden property="histBtn" name="frmMaintPfDetail"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

 
<script language="javascript">

function lfnLoad()
{
	mode = document.all.screenMode.value;
	//alert("document.all.screenMode.value=="+document.all.screenMode.value);
	var  mode1;
	mode1 = mode;
	if (mode == 'UG')	mode1 = 'U';

	if(mode == '')
	{
		doQueryMode();
	}
	
	if (mode1 == 'U')
	{ 
		document.getElementById("txtEmpNo").disabled = "true";
		document.getElementById("txtFromYear").disabled = "true";        
		document.getElementById("txtPFAcctNo").disabled = "true";        
		document.getElementById("txtToYear").disabled = "true";        
		document.getElementById("txtPfType").disabled = "true";                        
	}

	if(mode=='Q')
	{
		document.getElementById("txtFromYear").disabled = "true";        
		document.getElementById("txtPFAcctNo").disabled = "true";        
		document.getElementById("txtEmpOpnCon").disabled = "true";        
		document.getElementById("txtEmpOpnInt").disabled = "true";        
		document.getElementById("txtEmprOpnCon").disabled = "true";        
		document.getElementById("txtEmprOpnInt").disabled = "true";        
		document.getElementById("txtEmpCloCon").disabled = "true";        
		document.getElementById("txtEmpCloInt").disabled = "true";        
		document.getElementById("txtEmprCloCon").disabled = "true";        
		document.getElementById("txtEmprCloInt").disabled = "true";        
		//document.getElementById("txtEmpInSub").disabled = "true";        
		//document.getElementById("txtEmprInCon").disabled = "true";        
		//document.getElementById("txtEmpOutSub").disabled = "true";        
		//document.getElementById("txtEmprOutCon").disabled = "true";        
	}

	if(mode=='U')
	{
		document.getElementById("txtEmpNo").disabled = "true";
		document.getElementById("txtFromYear").disabled = "true"; 
		var oTable = document.getElementById("Detail");
		if(oTable == null)
		{
			return;
		}
		var iTr2 = oTable.rows.length;
		var i = 0;

		for(i=0; i < iTr2 -1; i++)
		{
			if (document.getElementsByName("status")[i].value == 'Q')
			{      
				document.getElementsByName("txtYearMon")[i].disabled="disabled";
			}
		} 
	}

	mode = document.all.screenModePfDtl.value;    
	//alert("document.all.screenModePfDtl.value=="+document.all.screenModePfDtl.value)
	if(mode=='N')
	{
		document.all.butGetDetail.disabled="disabled";
	}
	if(mode=='UG')
	{
		document.all.butGetDetail.disabled="disabled";
	} 
	if(mode=='U')
	{
		document.all.butGetDetail.disabled="";
	} 
	if(mode=='Q')
	{
		document.all.butGetDetail.disabled="disabled";
	} 
	document.all.butInsert.disabled="";
	document.all.butDelete.disabled="";

	if (frmMaintPfDetail.screenModePay1.value=="N") 
	{
		frmMaintPfDetail.screenMode.value ="N";
	}

	menuHandling(mode1);
}

function AdjDtlChanged()
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;

	for(i=0; i < iTr2 - 1; i++)
	{
		if(document.getElementsByName("checked")[i].checked)
		{
			frmMaintPfDetail.detailDataChanged.value = "true";
			if(document.getElementsByName("status")[i].value=='Q')
			{
				document.getElementsByName("status")[i].value='U';
				return true;
			}
		}
	}
	return false;
}

function showAdjustHdr(val)
{
	if(val=="1")
	{
		document.getElementById("rowid1").style.display='block';
	}
	else
	{
		document.getElementById("rowid1").style.display='none';
	}
}

function showAdjustHistoryHdr()
{
	document.all.userBtn.value='EX';
	document.all.histBtn.value='VHH'; // view header history clicked.
	enableAll();
	frmMaintPfDetail.action="../../../pfshowadjusthistoryhdr.do";
	frmMaintPfDetail.submit();
}

function showAdjustHistoryDtl()
{
	document.all.userBtn.value='EX';
	document.all.histBtn.value='VDH'; // view detail history clicked.
	enableAll();
	frmMaintPfDetail.action="../../../pfshowadjusthistorydtl.do";
	frmMaintPfDetail.submit();
}

function closeAdjustHistoryHdr()
{
	if(typeof(rowid2) == "object")
	{
		document.all.histBtn.value='';
		document.getElementById("rowid2").style.display='none';
	}
}

function closeAdjustHistoryDtl()
{
	if(typeof(rowid4) == "object")
	{
		document.all.histBtn.value='';
		document.getElementById("rowid4").style.display='none';
	}
}

function showAdjustDtl(val)
{
	if(val=="1")
	{
		document.all.histBtn.value='APD'; //adjust pf detail clicked
		document.getElementById("rowid3").style.display='block';
	}
	else
	{
		document.all.histBtn.value=''; //close button clicked. 
		document.getElementById("rowid3").style.display='none';
	}
}

function checkRecord1(rowid)
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
	  if(i!=rowid)
	  {
			if(document.getElementsByName("checked")[i].checked)
			{
				document.getElementsByName("checked")[i].checked=false;
			}
	  }
  }

  for(i=0; i < iTr2 - 1; i++)
  {
	if(document.getElementsByName("checked")[i].checked)
	{
		//document.all.butDelete.disabled="";
		document.all.butAdjust.disabled="";
		document.all.butViewAdj.disabled="";
		document.getElementById("txtYYMMDtl").value=document.getElementsByName("txtYearMon")[rowid].value;
		return true;
	}
  }
  if(fl == 0)   
  {      
	  //document.all.butDelete.disabled="true";
      document.all.butAdjust.disabled="true";
	  document.all.butViewAdj.disabled="true";
	  document.getElementById("txtYYMMDtl").value="";
	  return false;
  }
}

function lfnChange(val)
{
	if(num_Check(val,1))
	{
		frmMaintPfDetail.headerDataChanged.value = "true";
		return true;
	}
	else
	{
		event.srcElement.select();
		event.srcElement.focus();
		event.returnValue=false;
		return false;
	}
	frmMaintPfDetail.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
	document.all.userBtn.value='EX';
	document.all.histBtn.value='';
	document.all.screenMode.value = 'U';
	document.all.screenModePay1.value  = "U";
	document.all.screenModePfDtl.value  = "U";      
	enableAll();
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmMaintPfDetail.action="../../../PfDetailFirstGetHeaderAction.do";
	frmMaintPfDetail.submit();
}

function doGetNextHeader()
{ 
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
    frmMaintPfDetail.userPositionRequested.value = 1*frmMaintPfDetail.positionRequested.value + 1;
    document.all.screenModePfDtl.value  = "U";        
    frmMaintPfDetail.action="../../../PfDetailGetNextHeader.do";
    frmMaintPfDetail.submit();
}

function PrevHeader()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
	frmMaintPfDetail.userPositionRequested.value = 1*frmMaintPfDetail.positionRequested.value - 1;
	document.all.screenModePfDtl.value  = "U";      
	frmMaintPfDetail.action = "../../../PfDetailGetPrevHeader.do";
	frmMaintPfDetail.submit();
}

function JumpHeader()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
	document.all.screenModePfDtl.value  = "U";    
	frmMaintPfDetail.userPositionRequested.value = 1*frmMaintPfDetail.newPositionRequested.value;
	frmMaintPfDetail.action = "../../../PfDetailGetNextHeader.do";
	frmMaintPfDetail.submit();
}

function doBasePrevDetail()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
    frmMaintPfDetail.userPageRequested.value = 1*frmMaintPfDetail.pageRequested.value - 1;
    frmMaintPfDetail.action = "../../../PfDetailGetNextDetail.do";
    frmMaintPfDetail.submit();
}


function doBaseNextDetail()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
    frmMaintPfDetail.userPageRequested.value = 1*frmMaintPfDetail.pageRequested.value + 1;
    frmMaintPfDetail.action = "../../../PfDetailGetNextDetail.do";
    frmMaintPfDetail.submit();
}

function JumpDetail()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
    frmMaintPfDetail.userPageRequested.value = 1*frmMaintPfDetail.newPageRequested.value ;
    frmMaintPfDetail.action = "../../../PfDetailGetNextDetail.do";
    frmMaintPfDetail.submit();
}

function doInsertMode()
{
	document.all.screenModePay1.value  = "N";
	document.all.screenModePfDtl.value  = "N";
	document.all.userBtn.value = ''; 
	document.all.histBtn.value='';
	frmMaintPfDetail.action="../../../PfDetailNewMode.do"
	frmMaintPfDetail.submit();
}

function doQueryMode()
{
	document.all.screenModePay1.value  = "Q";
	document.all.screenModePfDtl.value  = "Q";    
	frmMaintPfDetail.action="../../../PfDetailQueryMode.do"
	frmMaintPfDetail.submit();
}


function SaveRecord()
{
	if(mandatory_Check("frmMaintPfDetail"))
	{    

		if (!DupliCheck())	return false;

		if (!YMonthRangeCheck())	return false;

		frmMaintPfDetail.headerPrimaryKey.value = document.all.txtEmpNo.value + "," + document.all.txtFromYear.value ;   
		//document.all.screenModePay1.value = document.all.screenMode.value;
		
		if(frmMaintPfDetail.screenMode.value == "N")
		{
			frmMaintPfDetail.headerDataChanged.value = "true"; 
			frmMaintPfDetail.detailDataChanged.value = "true";
		}

		if(frmMaintPfDetail.screenMode.value == "U")
		{
			frmMaintPfDetail.headerDataChanged.value = "true"; 
		}  

		var oTable = document.getElementById("Detail");
		if(oTable == null)
		{
			return;
		}
		var iTr2 = oTable.rows.length;
		var i = 0;
		for(i=0; i < iTr2 -1; i++)
		{
			document.getElementsByName("txtYearMon")[i].disabled="";
		}

		document.getElementById("txtEmpNo").disabled = "";
		document.getElementById("txtFromYear").disabled = ""; 
		document.getElementById("txtPfType").disabled = "";                      

		document.all.butSave.disabled="";        
		frmMaintPfDetail.headerFields.value = "true";
		document.all.userBtn.value = 'EX'; 
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
		if (document.all.histBtn.value == 'APD') //saving adjust pf detail.
		{

			frmMaintPfDetail.action = "../../../PfDetailSaveAction.do";
			frmMaintPfDetail.submit();
		}
		else
		{
			frmMaintPfDetail.action = "../../../PfDetailSaveAction.do";
			frmMaintPfDetail.submit();
		}
	}
	else
	{
		return false;
	}
}

function ShowEmpNum()
{
	mode = document.all.screenMode.value;
	frmMaintPfDetail.lovKey.value = "PFDetail" + frmMaintPfDetail.screenName.value + frmMaintPfDetail.screenMode.value;
	frmMaintPfDetail.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode";
	frmMaintPfDetail.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
	frmMaintPfDetail.queryParam.value="txtSiteID="+ frmMaintPfDetail.loginLocCode.value +" " ;   
	frmMaintPfDetail.txtIndex.value ="";      
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPfDetail');
	return true;
}

function GetDetail()
{
	document.all.screenMode.value='UG';
	document.all.screenModePfDtl.value  = "UG";        
	document.all.histBtn.value='';
	frmMaintPfDetail.action="../../../PfDetailFirstGetDetailAction.do"
	frmMaintPfDetail.submit();
}

function doBaseAddRow()
{
	if(!mandatory_Check("frmMaintPfDetail")) return false;

	if(document.all.userBtn.value == 'EX') document.all.screenModePay1.value = 'U';
	else document.all.screenModePay1.value = 'N';
	document.all.histBtn.value='';
	frmMaintPfDetail.screenMode.value ="U";        
	frmMaintPfDetail.detailDataChanged.value = "false";    
	frmMaintPfDetail.headerDataChanged.value = "false";  

	document.getElementById("txtEmpNo").disabled = "";
	document.getElementById("txtFromYear").disabled = ""; 
	document.getElementById("txtToYear").disabled = "";     
	EnableFields();
	frmMaintPfDetail.action = "../../../PfDetailAddRowAction.do";
	frmMaintPfDetail.submit();
}

function doBaseDelRow()
{
	// document.all.buttonFlag.value='D';
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;

	var flag = 0;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("checked")[i].checked)
		{
			flag=flag+1;
		}
	}  

	if ( flag == 0)
	{
		alert("Please check the rows to be deleted");
		return false;
	}

	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("checked")[i].checked)
		{
			document.getElementsByName("itemChecked")[i].value = "Y";
			frmMaintPfDetail.detailDataChanged.value = "true";      
		}
	}

	EnableFields();
	frmMaintPfDetail.action = "../../../PfDetailDeleteRowAction.do";
	frmMaintPfDetail.submit();
 
}


function changed(val)
{
    frmMaintPfDetail.detailDataChanged.value = "true";
    if(document.getElementsByName("status")[val-1].value=='Q')
    {
		document.getElementsByName("status")[val-1].value='U';
    }
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
              document.getElementsByName("txtYearMon")[i].disabled="";
       }
}

function ShowLovYYMM()
{
   frmMaintPfDetail.lovKey.value = "PfFromYR" + frmMaintPfDetail.screenName.value + frmMaintPfDetail.screenMode.value;
   frmMaintPfDetail.txtDisplayFields.value = "txtFromYear";
   frmMaintPfDetail.txtSearchFields.value = "";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPfDetail');
   return true;
}

function calcToYear()
{           
	var fromYear = parseInt(document.getElementById("txtFromYear").value,10);
	var toYear = fromYear + 1;
	document.getElementById("txtToYear").value = toYear;
	return true;
}

function chk_Year()
{
	var fromYear = document.getElementById("txtFromYear").value;
	if (fromYear.length != 4)
	{      
	alert("Enter From Year In The Format YYYY");
	document.getElementById("txtFromYear").focus();                     
	document.getElementById("txtFromYear").select();
	event.returnValue=false;                    
	return false;  
	}
	return true;
}

function chk_YearMonth()
{
	var oTable = document.getElementById("Detail");
	var iTR = oTable.rows.length;
	var flag =0;
	var i ;
					   
	for(i=0;i<iTR-1;i++)
	{   
		var  yearM = document.getElementsByName("txtYearMon")[i].value;  
		var month =yearM.substring(4,6);

		if (yearM.length != 6)
		{
			alert("Year Month should be a six digit number");
			document.getElementsByName("txtYearMon")[i].focus();                     
			document.getElementsByName("txtYearMon")[i].select();
			//event.srcElement.focus();
			event.returnValue=false;                    
			return false;
		}

		if(month < 1 || month > 12)
		{
			alert("Month should be Within 1 to 12");
			document.getElementsByName("txtYearMon")[i].focus();                     
			event.srcElement.select();
			event.srcElement.focus();
			event.returnValue=false;            
			return false;
		}

	}
	return true;
}

function enableAll()
{
	document.getElementById("txtFromYear").disabled = "";        
	document.getElementById("txtPFAcctNo").disabled = "";        
	document.getElementById("txtPfType").disabled = "";                
	
	document.getElementById("txtEmpOpnCon").disabled = "";        
	document.getElementById("txtEmpOpnInt").disabled = "";        
	document.getElementById("txtEmprOpnCon").disabled = "";        
	document.getElementById("txtEmprOpnInt").disabled = "";        
	document.getElementById("txtEmpCloCon").disabled = "";        
	document.getElementById("txtEmpCloInt").disabled = "";        
	document.getElementById("txtEmprCloCon").disabled = "";        
	document.getElementById("txtEmprCloInt").disabled = "";        
	//document.getElementById("txtEmpInSub").disabled = "";        
	//document.getElementById("txtEmprInCon").disabled = "";        
    //document.getElementById("txtVolInPf").disabled = "";        
	//document.getElementById("txtEmpOutSub").disabled = "";        
	//document.getElementById("txtEmprOutCon").disabled = "";        
    //document.getElementById("txtVolOutPf").disabled = "";        
}
  

function doRefresh()
{

	frmMaintPfDetail.action = "../../../PFdetailRefresh.do";
	frmMaintPfDetail.submit();
}

function DupliCheck()
{
	var oTable = document.getElementById("Detail");
	var iTr2 = oTable.rows.length;
	var flag =0;
	 var i = 0;
	var j;
	j = 0;
   
	 for(i=0;i<iTr2-2;i++)
	{   

		var YearMonth1 = parseInt(document.getElementsByName("txtYearMon")[i].value);
		for(j=i+1;j<iTr2-1;j++)                
		{                       
			  var YearMonth2 = parseInt(document.getElementsByName("txtYearMon")[j].value);
			  if (document.getElementsByName("status")[i].value != 'D')
			  {
				  if((YearMonth1==YearMonth2))
				  {
					   var msg = "Duplication of Year Month in Row Number "  + parseInt(j+1) + " Not Allowed";
					   alert(msg); 
					   document.getElementsByName("txtYearMon")[j].focus();
					   return false;
				  }                                               
			  }
		 }                              
	 }
	return true;
}

function YMonthRangeCheck()
{
	var FromYear =    document.getElementById("txtFromYear").value;
	var ToYear =    document.getElementById("txtToYear").value;  
	var oTable = document.getElementById("Detail");
	var StartYYMM = FromYear + "04";
	var EndYYMM =   ToYear + "03";
	var iTr2 = oTable.rows.length;

	for(i=0;i<iTr2-1;i++)
	{   
	   if (document.getElementsByName("status")[i].value != 'D')
	   {               
			var YearMonth1 = parseInt(document.getElementsByName("txtYearMon")[i].value);                 
			if(parseInt(YearMonth1,10) < parseInt(StartYYMM,10)) 
			{
				var msg = "Entered Year Month not in the range " + StartYYMM +  " - " + EndYYMM  + " in row "   + i;                    
				alert(msg);
				document.getElementsByName("txtYearMon")[i].focus();                    
				return false;
			}

			if(parseInt(YearMonth1,10) > parseInt(EndYYMM,10)) 
			{
				var msg = "Entered Year Month not in the range " + StartYYMM +  " - " + EndYYMM  + " in row "   + i;                    
				alert(msg);
				document.getElementsByName("txtYearMon")[i].focus();                    
				return false;
			}                           
		}
	}   
	return true;
}

function checkDate(value)
{
	var m = value ; 
	if(m != "")
	{
		if(!isDate(m,"dd-MMM-yyyy"))
		{
			alert("Enter Proper Effective Date  in the Format DD-MMM-YYYY");
			return false;
		}
	}    
	return true;
}

</script> 