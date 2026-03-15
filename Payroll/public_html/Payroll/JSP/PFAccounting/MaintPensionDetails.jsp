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
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="MaintPensionDetailsBaseAction" name="frmMaintPensionDetail" type="FCIPAY.Payroll.WEBTIER.Form.MaintPensionDetailForm" scope="session">
<bean:define id="ParentForm" name="frmMaintPensionDetail" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>


<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN PENSION DETAILS</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE>
<tr height="700px">
<td>
<div id=divBody>
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>

       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Pension Header Information</TD>
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
				<logic:equal property= "screenMode" name= "frmMaintPensionDetail" value="N">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="return ShowEmpNum();">
				</logic:equal>
				<logic:equal property= "screenMode" name= "frmMaintPensionDetail" value="Q">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="return ShowEmpNum();">
				</logic:equal>
				<logic:equal property= "screenMode" name= "frmMaintPensionDetail" value="U">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="">
				</logic:equal>
				<logic:equal property= "screenMode" name= "frmMaintPensionDetail" value="UG">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="">
				</logic:equal>
				&nbsp;&nbsp;
				<html:text  property="txtEmpName"  maxlength="10" size="30" styleClass="locked" readonly="true" />
				<html:hidden  property="txtCpfCode" name= "frmMaintPensionDetail" />
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
				   
				}" />                                         
           
        
                               
                 <logic:equal property= "screenMode" name= "frmMaintPensionDetail" value="Q">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtFromYear"  onclick="ShowLovYYMM();">
                 </logic:equal>      
             
            </td>
        </tr>

        <tr>
            <td class="labelText" width="15%" ><bean:message key="Payroll.MaintPfDetail.PFno" /></td>
            <td><html:text property="txtPFAcctNo" size="26"  styleClass="locked" style="text-align:left;" readonly="true" />
            <td class="labelText" width="15%" ><bean:message key="Payroll.MaintPfDetail.ToYr" /></td>
            <td><html:text  property="txtToYear" altKey="Payroll.MaintPfDetail.ToYr" readonly="true" maxlength="4" size="23" styleClass="required" /></td>         
        </tr>

        <tr>
			<td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PensionId" /></td>
                       <td> <html:text  property="txtPensionId"  maxlength="10" size="30" styleClass="locked" readonly="true" /></td>
    
        </tr>
      
         <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </table>


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
            <td align="center" colspan="6" class=mainHeader >OPENING</td>
        </tr>
        <tr>
            <td class="labelText"  width="15%" >Employee's Contribution</td>
            <td><html:text property="txtEmpOpnConPc"  size="26" styleClass="locked" style="text-align:right" readonly="true" /></td>
            <td class="labelText"  width="15%" >Employer's Contribution</td>
            <td><html:text property="txtEmprOpnConPc" size="26"  styleClass="locked" style="text-align:right" readonly="true" /></td>
            <td colspan=3></td>
         </tr>
          <!--<tr>
            <td class="labelText"  width="15%" >VPC</td>
            <td><html:text property="txtVolOpnPc" size="26"  styleClass="locked" style="text-align:right" readonly="true" /></td>
            <td colsapn=3></td>
         </tr>-->
      
        <tr height="10">		    
        <TD colspan="6" > </TD>
        </tr>
        </TABLE>
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
            <td align="center" colspan="6" class=mainHeader>CLOSING</td>
        </tr>
       
        <tr>
            <td class="labelText"  width="15%" >Employee's Contribution</td>
            <td><html:text property="txtEmpCloConPc" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td class="labelText"  width="15%" >Employer's Contribution</td>
            <td><html:text property="txtEmprCloConPc" readonly="true" size="26" styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td colspan=3></td>
        </tr>
        <!--<tr>
            <td class="labelText"  width="15%" >VPC</td>
            <td><html:text property="txtVolCloPc" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"  /></td>
            <td colsapn=3></td>
        </tr>-->
           <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </td>
    
    </tr>

    </table>
    
   
    <table cellSpacing=0 cellPadding=0 border = 0  style="BORDER-BOTTOM: #4682b4 thin solid;BORDER-LEFT: #4682b4 thin solid;BORDER-RIGHT: #4682b4 thin solid;">
 <tr>
            <td align="center" colspan="6 "class=mainHeader >INTEREST</td>
        
</tr>
<tr>

            <TD class=tableHeader width="5%" height="25"> </td>
            <TD class=tableHeader width="4%">Q1</TD>
            <TD class=tableHeader width="4%">Q2</td>
            <TD class=tableHeader width="4%">Q3</td>
            <TD class=tableHeader width="4%">Q4</TD>
            <TD class=tableHeader width="4%">Annual</TD>
            
</tr>
<tr>
 <TD  class="labelText" width="5%" height="25">Employee's Contribution</td>
<td><html:text property="txtEmpIntQ1"  readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
<td><html:text property="txtEmpIntQ2"  readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
<td><html:text property="txtEmpIntQ3"  readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
<td><html:text property="txtEmpIntQ4"  readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
<td><html:text property="txtEmpIntAnn" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
</tr>
<tr>
 <TD  class="labelText" width="5%" height="25">Employer's Contribution</td>
 <td><html:text property="txtEmprIntQ1"  readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
 <td><html:text property="txtEmprIntQ2"  readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
 <td><html:text property="txtEmprIntQ3"  readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
 <td><html:text property="txtEmprIntQ4"  readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
 <td><html:text property="txtEmprIntAnn" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
</tr>
<!--<tr>
 <TD  class="labelText" width="5%" height="25">VPC</td>
  <td><html:text property="txtVolInPCQ1"  readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
 <td><html:text property="txtVolInPCQ2"   readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
 <td><html:text property="txtVolInPCQ3"   readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
 <td><html:text property="txtVolInPCQ4"   readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
 <td><html:text property="txtVolInPCQAnn" readonly="true" size="26"  styleClass="locked" style="text-align:right" onchange="return lfnChange(this.value);"/></td>
</tr>-->
</table>
<table cellSpacing=0 cellPadding=0 border = 0  style="BORDER-BOTTOM: #4682b4 thin solid;BORDER-LEFT: #4682b4 thin solid;BORDER-RIGHT: #4682b4 thin solid;">
  <tr>
        <td width="15%" colspan="3" align="center" style="height:25">
            <logic:equal property= "screenMode" name= "frmMaintPensionDetail" value="N">
                <html:button value='Adjust PC' onclick="showAdjustHdr(1)" property="butInsertHdr" styleClass="bottomBarText" disabled="true" />			
                <html:button value='View Adjusted PC History' onclick="showAdjustHistoryHdr(1)" property="butInsertHdr" styleClass="bottomBarText" disabled="true" />			
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmMaintPensionDetail" value="N">
                <html:button value='Adjust PC' onclick="showAdjustHdr(1)" property="butInsertHdr" styleClass="bottomBarText" />			
                <html:button value='View Adjusted PC History' onclick="showAdjustHistoryHdr(1)" property="butInsertHdr" styleClass="bottomBarText" />			
            </logic:notEqual>
        </td>
        </tr>
 </table>    





<TABLE border = 0 cellSpacing=0 cellPadding=0 >
    <TR id="rowid1" style="display:none">
        <TD width=50%>
            <table cellSpacing=0 cellPadding=0  border=0 style="BORDER-RIGHT: #4682b4 thin solid;BORDER-BOTTOM: #4682b4 thin solid;BORDER-LEFT: #4682b4 thin solid;">
                <tr><td colspan="10">&nbsp</td></tr>
                <tr>
                    <td class="labelText" align="right" width="15%">Adjust Type</td>
                    <td align="left">
                            <html:select property="txtAdjTypeHdr" onchange()="enableQuarter();">
                            <html:option value="">------------Please Select-----------</html:option>
                            <logic:present name="AdjPcHdr">
                                    <html:optionsCollection label="label" value="value" name="AdjPcHdr" property="adjPensionHdrList"/>
                            </logic:present>
                            </html:select>
                    </td>
                    <td class="labelText"  align="center">Quarter</td>
                    <td >
                     <html:select property="txtQuarterHdr" >
                            <html:option value="">-----------Please Select-----------</html:option>
                                    <html:option value="Q1">Quarter1</html:option>
                                    <html:option value="Q2">Quarter2</html:option>
                                    <html:option value="Q3">Quarter3</html:option>
                                    <html:option value="Q4">Quarter4</html:option>
                                    <html:option value="AN">Annual</html:option>

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
                    <td class="labelText" align="right">Adjust Amount</td>
                    <td><html:text property="txtAdjAmtHdr" size="11" styleClass="optional" style="text-align:right" onkeypress="
                                                     if((event.keyCode < 48 || event.keyCode > 57))
                                                      {
                                                            return false;
                                                      };" onchange="return lfnChange(this.value);" /></td>
                </tr>
                <tr>
                        <td class="labelText" align="right">Remark</td>
                        <td align="left" colspan="3">
                            <textarea  name="txtRmrkHdr" cols="80" rows="2"></textarea>
                        </td>
                </tr>
                <tr><td colspan="10">&nbsp</td></tr>
                <tr>
                        <td colspan=4 align="center"><html:button value='Close' onclick="showAdjustHdr(2)" property="butInsertHdr" styleClass="bottomBarText" /></td>
                </tr>
            </table>
        </TD>
        <TD width="50%">&nbsp;</TD>
    </TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0  border = 0 >
        <TBODY>
        <logic:equal property="histBtn" name="frmMaintPensionDetail" value="VHH">
                <TR id="rowid2" >
                        <TD width="50%">
                        <TABLE cellSpacing=0 cellPadding=0  border = 0>
                                <TR>
                                        <TD>
                                                        <table cellSpacing=0 cellPadding=0  border = 0 >
                                                        <tbody>
                                                          <TR>
                                                                <TD class=tableHeader width="10%" height="25">Adjust Type</td>
                                                                <TD class=tableHeader width="4%">Pay Mode</TD>
                                                                <TD class=tableHeader width="3%">Adjust Amount</td>
                                                                <TD class=tableHeader width="3%">Quarter</td>
                                                                <TD class=tableHeader width="5%">Modified Date/Time</td>
                                                                <TD class=tableHeader width="10%">Remark</TD>
                                                          <TR>
                                                                <logic:present property="adjHistHdrList" name="frmMaintPensionDetail" >
                                                                          <logic:iterate id="adjHdrHistInfo" name="frmMaintPensionDetail" property="adjHistHdrList" type="FCIPAY.Payroll.UTILITY.PensionAdjustHistoryBean"  >
                                                                                <tr> 
                                                                                  <td><html:text property="txtAdjTypeHdr1" name="adjHdrHistInfo" styleClass="locked" style="width:100%" /></td>
                                                                                  <td><html:text property="txtPayMode1" name="adjHdrHistInfo" styleClass="locked" style="width:100%" /></td>
                                                                                  <td><html:text property="txtAdjAmtHdr1" name="adjHdrHistInfo" styleClass="locked" style="width:100%;text-align:right;padding-right:5px" /></td>
                                                                                  <td><html:text property="txtQuarterHdrl" name="adjHdrHistInfo" styleClass="locked" style="width:100%;text-align:right;padding-right:5px" /></td>
                                                                                  <td><html:text property="txtModDtHdr" name="adjHdrHistInfo" styleClass="locked" style="width:100%;text-align:center;" /></td>
                                                                                  <td><html:text property="txtRmrkHdr1" name="adjHdrHistInfo" styleClass="locked" style="width:100%" /></td>
                                                                                </tr>
                                                                          </logic:iterate>
                                                                </logic:present>
                                                                <logic:notPresent property="adjHistHdrList" name="frmMaintPensionDetail" >
                                                                        <tr> 
                                                                          <td colspan="5" align="center"><bean:message key="Pfdetail.history" /></td>
                                                                        </tr>
                                                                </logic:notPresent>
                                                        </tbody>
                                                        </table>
                                                
                                        </TD>
                                </TR>
                                <tr height="10">
                                <TD colspan="4" > </TD>
                                </tr>
                                <tr>
                                        <td colspan=4 align="center"><html:button value='Close' onclick="closeAdjustHistoryHdr()" property="butInsertHdr" styleClass="bottomBarText" /></td>
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
                <td bgcolor="#4682B4" nowrap class=actTabText>Pension Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
  			<!-- Detail table starts -->
                          <TABLE cellSpacing=0 cellPadding=0 id="Detail" border=0>
                          <TBODY>
                          <TR>
                            <TD class=tableHeader width="1%"></td>
                            <TD class=tableHeader width="4%"><bean:message  key="Payroll.MaintPfDetail.year" /></td>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.empsub" /></TD>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPfDetail.empcon" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.volpc" /></TD>
                            <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintPCDetail.arremp" /></td>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPCDetail.arrempr" /></td>
                            <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintPCDetail.remdate" /></td>                            
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintPCDetail.noofdays" /></TD>
                            </TR>

                          
                          
                          <logic:iterate id="PcDetailInfo" name="frmMaintPensionDetail" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintPCDetailBean"  >
                          <% ++i; %>
                          <logic:notEqual name="PcDetailInfo" property="status" value="D" >
                              <logic:equal name="PcDetailInfo" property="status" value="N" >
                                    <tr> 
                                              <td align=center >
                                                            <html:checkbox property="checked" name="frmMaintPensionDetail" alt="<%=String.valueOf(i-1)%>" onclick="checkRecord1(this.alt);" value="false" />
                                              </td>
                                              <td><html:text property="txtYearMon" name="PcDetailInfo" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
                                              <td><html:text property="txtEmpSub" name="PcDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
                                              <td><html:text property="txtEmpCon" name="PcDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
                                              <td><html:text property="txtVolPc" name="PcDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
                                              <td><html:text property="txtArrEmp" name="PcDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
                                              <td><html:text property="txtArrEmpr" name="PcDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>
                                              <td><html:text property="txtRemDate" name="PcDetailInfo"  styleClass="optional" size="26" style="width:80%;text-align:right"  alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" />
                                                      <img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" onclick="showCalendar('txtAdvDate',this)" />
                                              </td>
                                              <td><html:text property="txtNoOfDays" name="PcDetailInfo" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" onchange="changed(this.alt)" /></td>								
                                               
                                     </tr>
                              </logic:equal>
                                  <logic:notEqual name="PcDetailInfo" property="status" value="N" >
                                        <tr> 
                                                  <td align=center >
                                                                <html:checkbox property="checked" name="frmMaintPensionDetail" alt="<%=String.valueOf(i-1)%>" onclick="checkRecord1(this.alt);" value="false" />
                                                  </td>
                                                  <td><html:text property="txtYearMon" name="PcDetailInfo" styleClass="locked" style="width:100%" alt="<%=String.valueOf(i-1)%>" readonly="true"/></td>
                                                  <td><html:text property="txtEmpSub" name="PcDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
                                                  <td><html:text property="txtEmpCon" name="PcDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
                                                  <td><html:text property="txtVolPc" name="PcDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
                                                  <td><html:text property="txtArrEmp" name="PcDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
                                                  <td><html:text property="txtArrEmpr" name="PcDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
                                                  <td><html:text property="txtRemDate" name="PcDetailInfo"  styleClass="locked" size="26" style="width:80%;text-align:right"  alt="<%=String.valueOf(i-1)%>" readonly="true" />
                                                          <img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" />
                                                  </td>
                                                  <td><html:text property="txtNoOfDays" name="PcDetailInfo" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i-1)%>" readonly="true" /></td>
                                                
                                  </logic:notEqual>
                                 <html:hidden property="itemChecked" name="PcDetailInfo" />
                                 <html:hidden property="status" name="PcDetailInfo" />
                                 <html:hidden property="detailId" name="PcDetailInfo" value="Default"/>  
                          </logic:notEqual>
                         
                          </logic:iterate>       
                       </TBODY>
                     </TABLE>
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
                                <td	align="center"><html:button value='Adjust PC Detail' onclick="showAdjustDtl(1)" property="butAdjust" styleClass="bottomBarText" disabled="true" />
                                        <html:button value='View Adjusted PC Detail History' onclick="showAdjustHistoryDtl()" property="butViewAdj" styleClass="bottomBarText" disabled="true" />
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
                                                        <html:text property="txtYYMMDtl" styleClass="locked" name="frmMaintPensionDetail" />
                                                </td>
                                        </tr>
                                        <tr>
                                                <td class="labelText" align="right" width="15%">Adjust Type</td>
                                                <td align="left" colspan="3">
                                                        <html:select property="txtAdjTypeDtl" onchange="return AdjDtlChanged();">
                                                        <html:option value="">----------------------Please Select--------------------</html:option>
                                                        <logic:present name="AdjPcHdr">
                                                                <html:optionsCollection label="label" value="value" name="AdjPcHdr" property="adjPensionDtlList" />
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
                                                        <textarea  name="txtRmrkDtl" cols="80" rows="2" name="frmMaintPensionDetail"></textarea>
                                                </td>
                                        </tr>
                                        <tr height="10">
                                        <TD colspan="4" > </TD>
                                        </tr>
                                        <tr>
                                                <td colspan=4 align="center"><html:button value='Close' onclick="showAdjustDtl(2)" property="butInsertHdr" styleClass="bottomBarText" /></td>
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
            <logic:equal property="histBtn" name="frmMaintPensionDetail" value="VDH">
                    <TR id="rowid4" >
                        <TD width="50%">
                        <TABLE cellSpacing=0 cellPadding=0  border = 0>
                                <TR>
                                        <TD>
                                                        <table cellSpacing=0 cellPadding=0  border = 0 >
                                                        <tbody>
                                                          <TR>
                                                                <TD class=tableHeader width="10%" height="25">Adjust Type</td>
                                                                <TD class=tableHeader width="4%">Pay Mode</TD>
                                                                <TD class=tableHeader width="3%">Adjust Amount</td>
                                                                <TD class=tableHeader width="5%">Modified Date/Time</td>
                                                                <TD class=tableHeader width="10%">Remark</TD>
                                                          <TR>
                                                                <logic:present property="adjHistDtlList" name="frmMaintPensionDetail" >
                                                                  <logic:iterate id="adjDtlHistInfo" name="frmMaintPensionDetail" property="adjHistDtlList" type="FCIPAY.Payroll.UTILITY.PensionAdjustHistoryBeanDtl"  >
                                                                        <tr> 
                                                                          <td><html:text property="txtAdjTypeDtl1" name="adjDtlHistInfo" styleClass="locked" style="width:100%" /></td>
                                                                          <td><html:text property="txtPayModeDtl1" name="adjDtlHistInfo" styleClass="locked" style="width:100%" /></td>
                                                                          <td><html:text property="txtAdjAmtDtl1" name="adjDtlHistInfo" styleClass="locked" style="width:100%;text-align:right;padding-right:5px" /></td>
                                                                          <td><html:text property="txtModDtDtl" name="adjDtlHistInfo" styleClass="locked" style="width:100%;text-align:center;" /></td>
                                                                          <td><html:text property="txtRmrkDtl1" name="adjDtlHistInfo" styleClass="locked" style="width:100%" /></td>
                                                                        </tr>
                                                                  </logic:iterate>
                                                                </logic:present>
                                                                <logic:notPresent property="adjHistDtlList" name="frmMaintPensionDetail" >
                                                                        <tr> 
                                                                                <tr> 
                                                                                  <td colspan="5" align="center"><bean:message key="Pfdetail.history" /></td>
                                                                                </tr>
                                                                        </tr>
                                                                </logic:notPresent>
                                                        </tbody>
                                                        </table>
                                        </TD>
                                </TR>
                                <tr height="10">
                                <TD colspan="4" > </TD>
                                </tr>
                                <tr>
                                        <td colspan=4 align="center"><html:button value='Close' onclick="closeAdjustHistoryDtl()" property="butInsertHdr" styleClass="bottomBarText" /></td>
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
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	
</TABLE>

</div>

</td></tr>
</TABLE>


<html:hidden name="frmMaintPensionDetail"  property="screenName" value="PcDetailScreen" />
<html:hidden name="frmMaintPensionDetail"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintPensionDetail" />
<html:hidden property="headerPrimaryKey" name="frmMaintPensionDetail" />
<html:hidden property="screenMode" name="frmMaintPensionDetail" />
<html:hidden property="positionRequested" name="frmMaintPensionDetail" />
<html:hidden property="userPositionRequested" name="frmMaintPensionDetail" />
<html:hidden property="pageRequested" name="frmMaintPensionDetail" />
<html:hidden property="userPageRequested" name="frmMaintPensionDetail" />\
<html:hidden property="buttonFlag" name="frmMaintPensionDetail"  />
<html:hidden property="loginLocCode" name="frmMaintPensionDetail"  />
<html:hidden property="txtInputField" name="frmMaintPensionDetail" />
<html:hidden property="lovKey" name="frmMaintPensionDetail"  />
<html:hidden property="txtFields" name="frmMaintPensionDetail"  />   
<html:hidden property="txtSearchFields" name="frmMaintPensionDetail"  />
<html:hidden property="txtDisplayFields" name="frmMaintPensionDetail"  />
<html:hidden property="txtIndex" name="frmMaintPensionDetail"  />
<html:hidden property="userBtn" name="frmMaintPensionDetail"  />
<html:hidden property="histBtn" name="frmMaintPensionDetail"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>


<script language="javascript">

function lfnLoad()
{
      document.all.butInsertMode.disabled="true"; 
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
	mode = document.all.screenMode.value;
	if(mode == '')
	{
		doQueryMode();
	}
	if(mode=='Q')
	{
           // document.all.butGetDetail.disabled="disabled";
	}
	//document.all.butInsert.disabled="disabled";
	//document.all.butDelete.disabled="";

	menuHandling(mode);
      document.all.butInsert.disabled="true"; 
      document.all.butDelete.disabled="true"; 
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
			frmMaintPensionDetail.detailDataChanged.value = "true";
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
        document.getElementById("txtQuarterHdr").disabled=true;
}

function showAdjustHistoryHdr()
{
	document.all.userBtn.value='EX';
	document.all.histBtn.value='VHH'; // view header history clicked.
	enableAll();
	frmMaintPensionDetail.action="../../../pcshowadjusthistoryhdr.do";
	frmMaintPensionDetail.submit();
}

function showAdjustHistoryDtl()
{
	document.all.userBtn.value='EX';
	document.all.histBtn.value='VDH'; // view detail history clicked.
	enableAll();
	frmMaintPensionDetail.action="../../../pcshowadjusthistorydtl.do";
	frmMaintPensionDetail.submit();
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
		frmMaintPensionDetail.headerDataChanged.value = "true";
		return true;
	}
	else
	{
		event.srcElement.select();
		event.srcElement.focus();
		event.returnValue=false;
		return false;
	}
	frmMaintPensionDetail.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
 	if(!mandatory_Check("frmMaintPensionDetail")) return false;

	//document.all.userBtn.value='EX';
	//document.all.histBtn.value='';
	document.all.screenMode.value = 'U';
	enableAll();
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmMaintPensionDetail.action="../../../PcDetailFirstGetHeaderAction.do";
	frmMaintPensionDetail.submit();
}

function doGetNextHeader()
{ 
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
    frmMaintPensionDetail.userPositionRequested.value = 1*frmMaintPensionDetail.positionRequested.value + 1;
    document.all.screenModePensionDtl.value  = "U";        
    frmMaintPensionDetail.action="../../../PcDetailGetNextHeader.do";
    frmMaintPensionDetail.submit();
}

function PrevHeader()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
	frmMaintPensionDetail.userPositionRequested.value = 1*frmMaintPensionDetail.positionRequested.value - 1;
	document.all.screenModePensionDtl.value  = "U";      
	frmMaintPensionDetail.action = "../../../PcDetailGetPrevHeader.do";
	frmMaintPensionDetail.submit();
}

function JumpHeader()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
	document.all.screenModePensionDtl.value  = "U";    
	frmMaintPensionDetail.userPositionRequested.value = 1*frmMaintPensionDetail.newPositionRequested.value;
	frmMaintPensionDetail.action = "../../../PcDetailGetNextHeader.do";
	frmMaintPensionDetail.submit();
}

function doBasePrevDetail()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
    frmMaintPensionDetail.userPageRequested.value = 1*frmMaintPensionDetail.pageRequested.value - 1;
    frmMaintPensionDetail.action = "../../../PcDetailGetNextDetail.do";
    frmMaintPensionDetail.submit();
}


function doBaseNextDetail()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
    frmMaintPensionDetail.userPageRequested.value = 1*frmMaintPensionDetail.pageRequested.value + 1;
    frmMaintPensionDetail.action = "../../../PcDetailGetNextDetail.do";
    frmMaintPensionDetail.submit();
}

function JumpDetail()
{
	closeAdjustHistoryHdr();
	closeAdjustHistoryDtl();
    frmMaintPensionDetail.userPageRequested.value = 1*frmMaintPensionDetail.newPageRequested.value ;
    frmMaintPensionDetail.action = "../../../PcDetailGetNextDetail.do";
    frmMaintPensionDetail.submit();
}

function doInsertMode()
{
	document.all.screenModePay1.value  = "N";
	document.all.screenModePensionDtl.value  = "N";
	document.all.userBtn.value = ''; 
	document.all.histBtn.value='';
	frmMaintPensionDetail.action="../../../PcDetailNewMode.do"
	frmMaintPensionDetail.submit();
}

function doQueryMode()
{
	//document.all.screenModePay1.value  = "Q";
	//document.all.screenModePensionDtl.value  = "Q";    
	frmMaintPensionDetail.action="../../../PcDetailQueryMode.do"
	frmMaintPensionDetail.submit();
}


function SaveRecord()
{
    if(mandatory_Check("frmMaintPensionDetail"))
    {    
        frmMaintPensionDetail.headerPrimaryKey.value = document.all.txtEmpNo.value + "," + document.all.txtFromYear.value ;  
        if(frmMaintPensionDetail.screenMode.value == "N")
        {
            frmMaintPensionDetail.headerDataChanged.value = "true"; 
            frmMaintPensionDetail.detailDataChanged.value = "true";
        }
        if(frmMaintPensionDetail.screenMode.value == "U")
        {
            frmMaintPensionDetail.headerDataChanged.value = "true"; 
            frmMaintPensionDetail.detailDataChanged.value = "true";

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
        document.getElementById("txtPensionId").disabled = "";  
        document.getElementById("txtQuarterHdr").disabled = "";
        document.all.butSave.disabled="";        
        frmMaintPensionDetail.headerFields.value = "true";
        //document.all.userBtn.value = 'EX'; 
        document.all.butSave.disabled="true";
        document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmMaintPensionDetail.action = "../../../PcDetailSaveAction.do";
        frmMaintPensionDetail.submit();

    }
    else
    {
        return false;
    }
}

function ShowEmpNum()
{
	mode = document.all.screenMode.value;
	frmMaintPensionDetail.lovKey.value = "PCDetail" + frmMaintPensionDetail.screenName.value + frmMaintPensionDetail.screenMode.value;
	frmMaintPensionDetail.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode";
	frmMaintPensionDetail.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
	frmMaintPensionDetail.queryParam.value="txtSiteID="+ frmMaintPensionDetail.loginLocCode.value +" " ;   
	frmMaintPensionDetail.txtIndex.value ="";      
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPensionDetail');
	return true;
}

function GetDetail()
{
	document.all.screenMode.value='UG';
	document.all.histBtn.value='';                        
	frmMaintPensionDetail.action="../../../PcDetailFirstGetDetailAction.do"
	frmMaintPensionDetail.submit();
}

/*function doBaseAddRow()
{
	if(!mandatory_Check("frmMaintPensionDetail")) return false;
	//if(document.all.userBtn.value == 'EX') document.all.screenModePay1.value = 'U';
	//else document.all.screenModePay1.value = 'N';
	document.all.histBtn.value='';
	frmMaintPensionDetail.screenMode.value ="U";        
	frmMaintPensionDetail.detailDataChanged.value = "false";    
	frmMaintPensionDetail.headerDataChanged.value = "false";  

	document.getElementById("txtEmpNo").disabled = "";
	document.getElementById("txtFromYear").disabled = ""; 
	document.getElementById("txtToYear").disabled = "";     
	EnableFields();
	frmMaintPensionDetail.action = "../../../PcDetailAddRowAction.do";
	frmMaintPensionDetail.submit();
}*/

/*function doBaseDelRow()
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
			frmMaintPensionDetail.detailDataChanged.value = "true";      
		}
	}

	EnableFields();
	frmMaintPensionDetail.action = "../../../PcDetailDeleteRowAction.do";
	frmMaintPensionDetail.submit();
 
}
*/
function changed(val)
{
    frmMaintPensionDetail.detailDataChanged.value = "true";
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
   frmMaintPensionDetail.lovKey.value = "PcFromYR" + frmMaintPensionDetail.screenName.value + frmMaintPensionDetail.screenMode.value;
   frmMaintPensionDetail.txtDisplayFields.value = "txtFromYear";
   frmMaintPensionDetail.txtSearchFields.value = "";
   frmMaintPensionDetail.txtInputField.value = "txtFromYear";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPensionDetail');
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
	document.getElementById("txtPensionId").disabled = "";                
	document.getElementById("txtEmpOpnConPc").disabled = "";        
	document.getElementById("txtEmprOpnConPc").disabled = "";        
	document.getElementById("txtEmpCloConPc").disabled = "";        
	document.getElementById("txtEmprCloConPc").disabled = ""; 
       // document.getElementById("txtVolOpnPc").disabled = ""; 
       // document.getElementById("txtVolCloPc").disabled = ""; 
        document.getElementById("txtEmpIntQ1").disabled = "";  
        document.getElementById("txtEmpIntQ2").disabled = "";  
        document.getElementById("txtEmpIntQ3").disabled = "";  
        document.getElementById("txtEmpIntQ4").disabled = "";  
        document.getElementById("txtEmpIntAnn").disabled = "";  
        document.getElementById("txtEmprIntQ1").disabled = "";  
        document.getElementById("txtEmprIntQ2").disabled = "";  
        document.getElementById("txtEmprIntQ3").disabled = "";  
        document.getElementById("txtEmprIntQ4").disabled = "";  
        document.getElementById("txtEmprIntAnn").disabled = "";  
        //document.getElementById("txtVolInPCQ1").disabled = "";  
       // document.getElementById("txtVolInPCQ2").disabled = "";  
        //document.getElementById("txtVolInPCQ3").disabled = "";  
        //document.getElementById("txtVolInPCQ4").disabled = "";  
        //document.getElementById("txtVolInPCQAnn").disabled = "";  
}
  

function doRefresh()
{

	frmMaintPensionDetail.action = "../../../PCdetailRefresh.do";
	frmMaintPensionDetail.submit();
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
function enableQuarter()
{
   if((document.getElementById("txtAdjTypeHdr").value=="VPC$INTOPN" )||(document.getElementById("txtAdjTypeHdr").value=="EMPRCCON$INTOPN")||(document.getElementById("txtAdjTypeHdr").value=="EMPCCON$INTOPN")) 
   {
            document.getElementById("txtQuarterHdr").disabled="";
   }
   else 
   {
   
           document.getElementById("txtQuarterHdr").disabled=true;

   }
   
}
</script>
