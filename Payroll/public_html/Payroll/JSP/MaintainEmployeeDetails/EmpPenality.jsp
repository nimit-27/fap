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
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintEmpPenalityDetailBase" name="frmEmpPenalityForm" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpPenalityForm">
<bean:define id="ParentForm" name="frmEmpPenalityForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE PENALTY</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:700px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
            <!--General Information Row Starts -->
            <TR>
              <TD class=subHeader colspan=6> Detail Information Of Employee</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="6"></td>
            </tr>           
            
            <tr></tr>
            <table  cellSpacing=0 cellPadding=0 border=0> 
            
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" colspan="5">
                  <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">                   
					  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" name= "frmEmpPenalityForm" maxlength="10" size="23" styleClass="required" readonly="true"/>
					  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N">
					  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" name= "frmEmpPenalityForm" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="Q">                              
	                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" onclick="return ShowEmpNum();">
                  </logic:equal>
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td> 
              </TR> 
                                
              <TR>              
                  <TD width="23%" class=labelText><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgnDesc" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/></td>
  				  <html:hidden property="txtDsgn" name="frmEmpPenalityForm" />

				  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/></td>  
				  <html:hidden property="txtCateg" name="frmEmpPenalityForm" />
              </tr>
                      
              <tr> 
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                    
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="7" size="23" styleClass="locked"  style="text-align:Left"   /></td>                                                                  
              </tr>
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td><html:text  property="txtPresentPOP" altKey="pay.EmpInfo.PresentPOP" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   />                  
                  </td>                                                            
                  
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>    
      
              <tr>
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text  property="txtEmpStatus" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>             
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.curbas" /> </td>            
                  <td>
                  <html:text  property="txtCurtBasic" altKey="Payroll.EmpInfo.curbas" maxlength="15" size="23" styleClass="locked"  readonly="true"/>
                  </td>
              </tr>
                  <td width="15%" class=labelText  >Pay Band/Pay Scale code </td>            
                  <td>
                  <html:text  property="payScaleCode"  maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>

				  <td width="15%" class=labelText  >Pay Scale</td>            
                  <td>
                  <html:text  property="txtPayType"  maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
				  </tr>
              </tr>
   
            </table>     
          </tr>            
      <tr height="15" >
      <td colspan="6"></td>
    </tr>                                 
  </table>
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	 <TR height="100">
      <TD colspan=6>
      <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellspacing="0" cellPadding="0" >
           <TR>
				<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td bgcolor="#4682B4" nowrap class=actTabText>Penalty Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                
				<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("waiver")>Penalty Waiver<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
				<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("instate")>Increment Re-instate<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("dismiss")>Dismissal Re-instate<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                
		   </TR>
           
          <tr height="10"><td class=userText colspan="14"></td></tr>            
          <TR height=10>
 <!-- Detail table Container starts -->
            <TD colspan=14>
              <TABLE cellSpacing=0 cellPadding=0 border=0>
                <TBODY>
                  <TR>
                    <TD>
  			<!-- Detail table starts -->
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>                          
                          <td  width="23%" class=labelText>Penalty Type</td>                                                    
                          <td width="30%" colspan="1">
                          <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">  
                          <html:select property="penaType" name="frmEmpPenalityForm"  styleClass="required"  onchange="onChangePenalityType();"  >
                          <html:option value="" >---------Please Select--------</html:option>      
                          <logic:present name="PenalityType">
                          <html:optionsCollection label="label" value="value" property="valuePenaTypeArrayList" name="PenalityType"/>
                          </logic:present>
                          </html:select>
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N">
                          <html:select property="penaType" name="frmEmpPenalityForm"  styleClass="optional"  disabled="true" >
                          <html:option value="" >-----------Please Select-----------</html:option>      
                          <logic:present name="PenalityType">
                          <html:optionsCollection label="label" value="value" property="valuePenaTypeArrayList" name="PenalityType"/>
                          </logic:present>
                          </html:select>
                          </logic:notEqual>
                          </td>                                                   
                          <TD width="20%" class=labelText >Total Amount to be recovered</TD>
                          <td align="left" colspan="1">                                                    
                          <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">                              
                          <html:text  property="recvdAmt"  maxlength="25" size="23" styleClass="required" onkeypress="
							 if((event.keyCode < 48 || event.keyCode > 57))
							  {
								return false;
							  };"
							  onchange="
                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                        if(!(checkInstAmt1()))
                                        {
                                        }                                        

                                       " style="text-align:right" />
                         
                          </logic:equal>                                                                                                 
                          <logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N"> 
                          <html:text  property="recvdAmt"  maxlength="25" size="23" styleClass="locked" readonly="true" style="text-align:right"/>               
                          </logic:notEqual>
						                                       
                          </td>
                    </tr> 

                    <tr>                      
                        <td class=labelText>First Installment Amount</td>
                        <td colspan="1">
                        <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">  
                        <html:text  property="fstInstamntAmt"  styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:right" onchange="checkInstAmt()" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "  />                       
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N">
                        <html:text  property="fstInstamntAmt" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:right" readonly="true" />
                        </logic:notEqual>
                        </td>

						<TD class=labelText >Installment Amount</TD>
                        <td align="left" colspan="1">
						<logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N"> 
                        <html:text  property="instalmntAmt"  size="23" styleClass="required" onchange="checkInstAmt()" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "   style="text-align:right"/>
						</logic:equal> 

						<logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N"> 
                        <html:text  property="instalmntAmt"  size="23" styleClass="locked" style="text-align:right" readonly="true" onchange="checkInstAmtU()" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           " />
						</logic:notEqual> 
                        </td>
                    </tr>
                    <tr>                
						<td class=labelText>No Of Installment</td>
                        <td colspan="1">
                        <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">  
                        <html:text  property="noOfInstalmnt" styleClass="locked" readonly="true" alt="<%=String.valueOf(i)%>" maxlength="10" size="23"  onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "  style="text-align:right"   />                      
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N">
                        <html:text  property="noOfInstalmnt" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:right" readonly="true" />
                        </logic:notEqual>
                        </td>
                        
                        <td class=labelText>Recovery YYYYMM</td>
                        <td colspan="1">
                        <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">  
                        <html:text  property="recvYYMM" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="6" size="23" style="text-align:right" onblur="chkRcvYYMM(this)" onchange="if(chk_YearMonth(this,this.alt));"  onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };" />                      
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N">
                        <html:text  property="recvYYMM" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:right" readonly="true" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };" />
                        </logic:notEqual>
                        </td>
                    </tr> 
                    <tr>
                        <TD class=labelText>Balance Amount</TD>
                        <td align="left" colspan="1">                        
                        <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">  
                        <html:text  property="balAmt"  maxlength="10" size="23" styleClass="locked" readonly="true" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };  
                           "  style="text-align:right"   />
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N">
                        <html:text  property="balAmt"  maxlength="10" size="23" styleClass="locked" readonly="true" onchange="checkInstAmtU()" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "  style="text-align:right"/>
                        </logic:notEqual>
                        </td>

                        <td class=labelText>Balance Installment</td>
                        <td colspan="1">
                        <html:text  property="balInstalmnt" styleClass = "locked" readonly="true" alt="<%=String.valueOf(i)%>" maxlength="10" size="23"  onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "  style="text-align:right"   />                      
                        </td>
                    </tr>
					<!--logic starts dor demotion-->
                    <tr>

					<TD class=labelText  ><bean:message key="Payroll.EmpInfo.newDesig" /></TD>
                          <td align="left" colspan="1">                                                    
                          <html:text  property="newDsgnDesc" altKey="Payroll.EmpInfo.newDesig" maxlength="25" size="23" styleClass="locked" onchange="upper(this);" readonly="true"/>
                          <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig"  onclick="return ShowLovDsgn();">
						   </logic:equal>
                          <html:hidden  property="newDsgn" altKey="Payroll.EmpInfo.newDesig"  />                                      
                          </td>
						<TD class=labelText  ><bean:message key="Payroll.EmpInfo.payscalecode" /></TD>
                        <td align="left" colspan="1">
                        <html:text  property="newPayScaleCode" altKey="Payroll.EmpInfo.payscalecode" size="2" styleClass="locked" readonly="true"/>                                         
                        </td>
						</tr>
                    <tr>
                        <td class=labelText>Demotion Basic</td>
                        <td colspan="1">
                        
                        <html:text  property="newBasic" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="10" size="23" onblur="chkNewBasic(this)" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "     />                      
                        </td>
                    </tr>
					<tr>
                        <td class=labelText>Penalty Effective From </td>
                        <td colspan="1">
                        <html:text  property="newPenaEffDate"  maxlength="10" size="23" styleClass="locked" onchange="chkValidDateFrm(this)" readonly="true"/>
						<logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">  
						<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="effDate" alt="<%=(i-1) %>" onclick="showCalendar('newPenaEffDate',this)" />
                        </logic:equal>
                        </td>

						<td class=labelText>Penalty Effective To </td>
                        <td colspan="1">
                        <html:text  property="txtPenaEffDateTo"  maxlength="10" size="23" styleClass="locked" onchange="chkValidDateTo(this);" readonly="true"/>
						<logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">  
						<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="effDateTo" alt="<%=(i-1) %>" onclick="showCalendar('txtPenaEffDateTo',this)" />
                        </logic:equal>
						<logic:equal property="screenMode" name= "frmEmpPenalityForm" value="U">  
						<logic:equal property="penaType" name= "frmEmpPenalityForm" value="PENALTY$STOPINCR"> 
						<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="effDateTo" alt="<%=(i-1) %>" disabled="true" onclick="showCalendar('txtPenaEffDateTo',this)" />
                        </logic:equal>
						</logic:equal>
                        </td>
                    </tr>
					<tr>
						<td class=labelText>Increment Stop Type (Incr. to be Re-Instated)</td>                                                    
						<td colspan="1">
						<html:select property="txtIncrType" name="frmEmpPenalityForm"  styleClass="optional" disabled="true" >
						<html:option value="" >-------------------------------Please Select----------------------------</html:option>      
						<logic:present name="PenalityType">
						<html:optionsCollection label="label" value="value" property="incrTypeArraylist" name="PenalityType"/>
						</logic:present>
						</html:select>

						<td class=labelText><bean:message key="Payroll.EmpInfo.remark" /></td>
                        <td colspan=1>
                        <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">  
                        <html:textarea  property="remarks" styleClass = "optional" alt="<%=String.valueOf(i)%>" rows="3" cols="30" style="text-align:left" onkeypress="return textCounter(this,1000);" />
 
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N">  
                        <html:textarea  property="remarks" styleClass = "locked" alt="<%=String.valueOf(i)%>" rows="3" cols="30" style="text-align:left" readonly="true"  /> 
						</logic:notEqual>
                        </td>
                    </tr>
					<!--logic ends for demotion-->
                    <tr height = 3><td>&nbsp;</td></tr>                    
                    <tr height = 3><td>&nbsp;</td></tr>                    
                  </TBODY>
                </TABLE>
              </TD>
            </TR>                     
         </TBODY>
	    </TABLE>
	  </td>
   </tr>       
<!-- Tab table Row 3 starts -->
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
		 <td  bgcolor=#4682b4 width="35%"></td>
         <td bgcolor=#4682b4>
		 <logic:equal property="penaType" name="frmEmpPenalityForm" value="PENALTY$RECVRY">
		 <logic:equal property="screenMode" name="frmEmpPenalityForm" value="U">
		 <logic:equal property="txtWaiveFlg" name="frmEmpPenalityForm" value="R">
		 <html:button value='Penalty Re-schedule' onclick="reschedule_penalty()" property="butReschedule" styleClass="bottomBarText" />
		 </logic:equal>
		 </logic:equal>
		 </logic:equal>
		 <logic:equal property="penaType" name="frmEmpPenalityForm" value="PENALTY$ALL">
		 <logic:equal property="screenMode" name="frmEmpPenalityForm" value="U">
		 <logic:equal property="txtWaiveFlg" name="frmEmpPenalityForm" value="R">
		 <html:button value='Penalty Re-schedule' onclick="reschedule_penalty()" property="butReschedule" styleClass="bottomBarText" />
		 </logic:equal>
		 </logic:equal>
		 </logic:equal>
		 </td>
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
<html:hidden name="frmEmpPenalityForm"  property="screenName" value="MaintEmpPenalityScreen" />
<html:hidden name="frmEmpPenalityForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpPenalityForm" />
<html:hidden property="loginLocCode" name="frmEmpPenalityForm" />
<html:hidden property="positionRequested" name="frmEmpPenalityForm" />
<html:hidden property="userPositionRequested" name="frmEmpPenalityForm" />
<html:hidden property="buttonFlag" name="frmEmpPenalityForm"  />
<html:hidden property="lovKey" name="frmEmpPenalityForm"  />
<html:hidden property="txtFields" name="frmEmpPenalityForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpPenalityForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpPenalityForm"  />
<html:hidden property="txtIndex" name="frmEmpPenalityForm"  />
<html:hidden property="newCateg" name="frmEmpPenalityForm"  />
<html:hidden property="newCategDesc" name="frmEmpPenalityForm"  />
<html:hidden property="payScaleCode" name="frmEmpPenalityForm"  />
<html:hidden property="newPayScaleCode" name="frmEmpPenalityForm"  />
<html:hidden property="hdnStartBasic" name="frmEmpPenalityForm"  />
<html:hidden property="newGradePay" name="frmEmpPenalityForm"  />
<html:hidden property="hdnEndBasic" name="frmEmpPenalityForm"  />
<html:hidden property="txtGradePay" name="frmEmpPenalityForm"  />
<html:hidden property="txtInputField" name="frmEmpPenalityForm"  />
<html:hidden property="txtPenaltyId" name="frmEmpPenalityForm"  />
<html:hidden property="hdnAction" name="frmEmpPenalityForm"  />
<html:text property="payYYMM" name="frmEmpPenalityForm"  />

<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>

<script language="javascript">
function lfnLoad()
{
	//alert(document.all.screenMode.value);

    mode = document.all.screenMode.value;    
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {        
        document.all.txtCateg.disabled = "true";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    } 

    if(mode=='E')
		disableMenu();
    else
		hedMenuHandling(mode);    

	onChangePenalityType();
}

function ShowEmpNum()
{
    frmEmpPenalityForm.lovKey.value = "EmpPenality" + frmEmpPenalityForm.screenName.value + frmEmpPenalityForm.screenMode.value;    
    frmEmpPenalityForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgnDesc,txtCateg,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtCurtBasic,payScaleCode,txtPayType,txtGradePay,txtDsgn,txtDOJSite";
    frmEmpPenalityForm.queryParam.value = "txtSiteID="+frmEmpPenalityForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpPenalityForm.hdnEmpLbrFlag.value;
    frmEmpPenalityForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName";
    frmEmpPenalityForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPenalityForm');
    return true;
}    

function ShowLovDsgn()
{
	if(frmEmpPenalityForm.txtEmpNo.value=="")
	{
		alert("Please Select an Employee");
		return false;
	}
    if(frmEmpPenalityForm.penaType.value=="")
    {
        alert("Please Select Penalty Type First!");
        frmEmpPenalityForm.penaType.focus();
        return false;
    }
    else
    {
        frmEmpPenalityForm.lovKey.value = "EmpPenalityDsgn" + frmEmpPenalityForm.screenName.value + frmEmpPenalityForm.screenMode.value;
        frmEmpPenalityForm.txtDisplayFields.value = "newDsgn,newDsgnDesc,newCateg,newCategDesc,newPayScaleCode,newGradePay";
        frmEmpPenalityForm.queryParam.value = "txtPromoType="+frmEmpPenalityForm.penaType.value+",txtCategory="+frmEmpPenalityForm.txtCateg.value+",payType="+frmEmpPenalityForm.txtPayType.value;   
        frmEmpPenalityForm.txtSearchFields.value = "";
        frmEmpPenalityForm.txtInputField.value =""; 
        frmEmpPenalityForm.txtIndex.value =""; 
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPenalityForm');
        return true;
    }
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.action="../../../EmpPenalityQueryMode.do"
    frmEmpPenalityForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpPenalityForm.action="../../../EmpPenalityRefresh.do"
    frmEmpPenalityForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.action="../../../EmpPenalityNewMode.do"
    frmEmpPenalityForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

    frmEmpPenalityForm.action="../../../EmpPenalityFirstGetHeaderAction.do"
    frmEmpPenalityForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.userPositionRequested.value = 1*frmEmpPenalityForm.positionRequested.value + 1;
    frmEmpPenalityForm.action="../../../EmpPenalityGetNextHeader.do";
    frmEmpPenalityForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.userPositionRequested.value = 1*frmEmpPenalityForm.positionRequested.value - 1;
    frmEmpPenalityForm.action = "../../../EmpPenalityGetPrevHeader.do";
    frmEmpPenalityForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.userPositionRequested.value = 1*frmEmpPenalityForm.newPositionRequested.value;
    frmEmpPenalityForm.action = "../../../EmpPenalityGetNextHeader.do";
    frmEmpPenalityForm.submit();
}

function cancelPromotion()
{
    alert("Cancel Promotion");
}

function SaveRecord()
{
    document.all.buttonFlag.value=''; 
	enableAll();
	if(mandatory_Check("frmEmpPenalityForm"))
	{
		frmEmpPenalityForm.detailDataChanged.value = "false";             
		frmEmpPenalityForm.headerDataChanged.value = "true";    
		frmEmpPenalityForm.headerFields.value = "true"; 
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
		frmEmpPenalityForm.action = "../../../EmpPenalitySaveAction.do";
		frmEmpPenalityForm.submit();
	}
    else
    {
        return false;
    }
}

function enableAll()
{
	frmEmpPenalityForm.penaType.disabled="";
	frmEmpPenalityForm.recvdAmt.disabled="";
	frmEmpPenalityForm.instalmntAmt.disabled="";
	frmEmpPenalityForm.noOfInstalmnt.disabled="";
	frmEmpPenalityForm.fstInstamntAmt.disabled="";
	frmEmpPenalityForm.recvYYMM.disabled="";
	frmEmpPenalityForm.balAmt.disabled="";
	frmEmpPenalityForm.newDsgn.disabled="";
	frmEmpPenalityForm.newPayScaleCode.disabled="";
	frmEmpPenalityForm.newBasic.disabled="";
	frmEmpPenalityForm.newPenaEffDate.disabled="";
	frmEmpPenalityForm.txtIncrType.disabled="";
}

function Chk_Char(name)
{
    that=document.getElementsByName(name)[0];    
    str=that.value; 
    for(i=0; i<str.length; i++)
    {
        var txtVal =str.charAt(i);
        if((txtVal >= 'A' && txtVal <= 'Z') ||(txtVal >= 'a' && txtVal <= 'z') || (txtVal == ',') || (txtVal == ' '))
        {}
        else
        {
            alert("Invalid Input");               
            that.select(); 
            //alert(that.value);
            return true;
        }
    }
}

function checkCurBasicLimit()
{
    var curBasic;
    var startBasic;
    var endBasic;
    var curBasic;     
    curBasic = parseInt(frmEmpPenalityForm.newBasic.value);
    startBasic =parseInt(frmEmpPenalityForm.hdnStartBasic.value); 
    endBasic = parseInt(frmEmpPenalityForm.hdnEndBasic.value); 
    //alert(startBasic);
    //alert(endBasic);
    if(curBasic < startBasic || curBasic > endBasic)
    {
        alert("New Basic Should be In Range "+startBasic+" To "+endBasic);
        frmEmpPenalityForm.newBasic.select();
        frmEmpPenalityForm.newBasic.focus();
        return false;
    }    
    else
        return true;
}

function onChangePenalityType()
{   
	if(frmEmpPenalityForm.screenMode.value == 'N')
	{
		if (frmEmpPenalityForm.penaType.value=='PENALTY$DEMO')
		{       
			document.getElementById("newDsgnDesc").disabled = ""; 
			document.getElementById("newDsgnDesc").style.background="#ffffd3";
			document.getElementById("newDsgnDesc").className="required";
			document.getElementById("buttxtDesig").disabled="";
			/*document.getElementById("newPayScaleCode").disabled = "";       
			document.getElementById("newPayScaleCode").style.background="#ffffd3";
			document.getElementById("newPayScaleCode").className="required";*/
			document.getElementById("newBasic").disabled = "";     
			document.getElementById("newBasic").value = "";
			document.getElementById("newBasic").style.background="#ffffd3";
			document.getElementById("newBasic").className="required";
			document.getElementById("newPenaEffDate").value = "";
			document.getElementById("newPenaEffDate").style.background="#ffffd3";
			document.getElementById("newPenaEffDate").className="required";
			document.getElementById("effDate").disabled = "";
			document.getElementById("txtPenaEffDateTo").value = "";
			document.getElementById("txtPenaEffDateTo").style.background="#FFFFFF";
			document.getElementById("txtPenaEffDateTo").className="optional";
			document.getElementById("effDateTo").disabled = "";

			document.getElementById("recvdAmt").value = ""; 
			document.getElementById("recvdAmt").disabled = "true"; 
			document.getElementById("recvdAmt").className = "locked";
			document.getElementById("recvdAmt").style.background = "#e0e0e0";
			document.getElementById("instalmntAmt").value = ""; 
			document.getElementById("instalmntAmt").disabled = "true"; 
			document.getElementById("instalmntAmt").className = "locked";
			document.getElementById("instalmntAmt").style.background = "#e0e0e0";
			document.getElementById("noOfInstalmnt").value = ""; 
			/*document.getElementById("noOfInstalmnt").disabled = "true"; 
			document.getElementById("noOfInstalmnt").className = "locked";
			document.getElementById("noOfInstalmnt").style.background = "#e0e0e0";*/
			document.getElementById("fstInstamntAmt").value = ""; 
			document.getElementById("fstInstamntAmt").disabled = "true"; 
			document.getElementById("fstInstamntAmt").className = "locked";
			document.getElementById("fstInstamntAmt").style.background = "#e0e0e0";
			document.getElementById("recvYYMM").value = ""; 
			document.getElementById("recvYYMM").disabled = "true"; 
			document.getElementById("recvYYMM").className = "locked";
			document.getElementById("recvYYMM").style.background = "#e0e0e0";
			document.getElementById("balAmt").value = "";
			document.getElementById("balAmt").readonly = "true";
			document.getElementById("balAmt").className = "locked";
			document.getElementById("balAmt").style.background = "#e0e0e0";
			document.getElementById("txtIncrType").disabled = "true";
			document.getElementById("txtIncrType").className = "optional";
			document.getElementById("txtIncrType").style.background="#FFFFFF";
     	}
		else if(frmEmpPenalityForm.penaType.value=='PENALTY$RECVRY')
		{
			document.getElementById("recvdAmt").disabled = "";
			document.getElementById("recvdAmt").style.background="#ffffd3";
			document.getElementById("recvdAmt").className="required";        
			document.getElementById("instalmntAmt").disabled = "";
			document.getElementById("instalmntAmt").style.background="#ffffd3";
			document.getElementById("instalmntAmt").className="required";        
			/*document.getElementById("noOfInstalmnt").disabled = "";
			document.getElementById("noOfInstalmnt").style.background="#ffffd3";
			document.getElementById("noOfInstalmnt").className="required"; */       
			document.getElementById("fstInstamntAmt").disabled = "";
			document.getElementById("fstInstamntAmt").style.background="#ffffd3";
			document.getElementById("fstInstamntAmt").className="required";        
			document.getElementById("recvYYMM").disabled = "";
			document.getElementById("recvYYMM").style.background="#ffffd3";
			document.getElementById("recvYYMM").className="required";        
			document.getElementById("balAmt").readonly = "true";
			document.getElementById("txtPenaEffDateTo").style.background="#e0e0e0";
			document.getElementById("txtPenaEffDateTo").className="locked";

			document.getElementById("newDsgnDesc").disabled = "true"; 
			document.getElementById("newDsgnDesc").value = "";
			document.getElementById("newDsgnDesc").style.background="#e0e0e0";
			document.getElementById("newDsgnDesc").className="locked";
			document.getElementById("newDsgn").value = "";
			document.getElementById("buttxtDesig").disabled="true";
			/*document.getElementById("newPayScaleCode").disabled = "true";
			document.getElementById("newPayScaleCode").value = "";
			document.getElementById("newPayScaleCode").style.background="#e0e0e0";
			document.getElementById("newPayScaleCode").className="locked";*/
			document.getElementById("newBasic").disabled = "true";
			document.getElementById("newBasic").value = "";
			document.getElementById("newBasic").style.background="#e0e0e0";
			document.getElementById("newBasic").className="locked";
			document.getElementById("newPenaEffDate").value = "";
			document.getElementById("newPenaEffDate").style.background="#e0e0e0";
			document.getElementById("newPenaEffDate").className="locked";
			document.getElementById("effDate").disabled = "true";
			document.getElementById("txtPenaEffDateTo").value = "";
			document.getElementById("txtPenaEffDateTo").style.background="#e0e0e0";
			document.getElementById("txtPenaEffDateTo").className="locked";
			document.getElementById("effDateTo").disabled = "true";
			document.getElementById("txtIncrType").disabled = "true";
			document.getElementById("txtIncrType").className = "optional";
			document.getElementById("txtIncrType").style.background="#FFFFFF";
		}
		else if(frmEmpPenalityForm.penaType.value=='PENALTY$STOPINCR')
		{
			document.getElementById("recvdAmt").value = ""; 
			document.getElementById("recvdAmt").disabled = "true"; 
			document.getElementById("recvdAmt").className = "locked";
			document.getElementById("recvdAmt").style.background = "#e0e0e0";
			document.getElementById("instalmntAmt").value = ""; 
			document.getElementById("instalmntAmt").disabled = "true"; 
			document.getElementById("instalmntAmt").className = "locked";
			document.getElementById("instalmntAmt").style.background = "#e0e0e0";
			document.getElementById("noOfInstalmnt").value = ""; 
			/*document.getElementById("noOfInstalmnt").disabled = "true"; 
			document.getElementById("noOfInstalmnt").className = "locked";
			document.getElementById("noOfInstalmnt").style.background = "#e0e0e0";*/
			document.getElementById("fstInstamntAmt").value = ""; 
			document.getElementById("fstInstamntAmt").disabled = "true"; 
			document.getElementById("fstInstamntAmt").className = "locked";
			document.getElementById("fstInstamntAmt").style.background = "#e0e0e0";
			document.getElementById("recvYYMM").value = ""; 
			document.getElementById("recvYYMM").disabled = "true"; 
			document.getElementById("recvYYMM").className = "locked";
			document.getElementById("recvYYMM").style.background = "#e0e0e0";
			document.getElementById("balAmt").value = "";
			//document.getElementById("balAmt").readonly = "true";
			//document.getElementById("balAmt").className = "locked";
			//document.getElementById("balAmt").style.background = "#e0e0e0";

			document.getElementById("newDsgnDesc").disabled = "true"; 
			document.getElementById("newDsgnDesc").value = "";
			document.getElementById("newDsgnDesc").style.background="#e0e0e0";
			document.getElementById("newDsgnDesc").className="locked";
			document.getElementById("newDsgn").value = "";
			document.getElementById("buttxtDesig").disabled="true";
			/*document.getElementById("newPayScaleCode").disabled = "true";
			document.getElementById("newPayScaleCode").value = "";
			document.getElementById("newPayScaleCode").style.background="#e0e0e0";
			document.getElementById("newPayScaleCode").className="locked";*/
			document.getElementById("newBasic").disabled = "true";
			document.getElementById("newBasic").value = "";
			document.getElementById("newBasic").style.background="#e0e0e0";
			document.getElementById("newBasic").className="locked";
			document.getElementById("newPenaEffDate").value = "";
			document.getElementById("newPenaEffDate").style.background="#ffffd3";
			document.getElementById("newPenaEffDate").className="required";
			document.getElementById("effDate").disabled = "";
			document.getElementById("txtPenaEffDateTo").value = "";
			document.getElementById("txtPenaEffDateTo").style.background="white";
			document.getElementById("txtPenaEffDateTo").className="optional";
			document.getElementById("effDateTo").disabled = "";
			document.getElementById("txtIncrType").disabled = "";
			document.getElementById("txtIncrType").className = "required";
			document.getElementById("txtIncrType").style.background = "#ffffd3";
		}
		else if(frmEmpPenalityForm.penaType.value=='PENALTY$ALL')
		{
			document.getElementById("recvdAmt").disabled = "";
			document.getElementById("recvdAmt").style.background="#ffffd3";
			document.getElementById("recvdAmt").className="required";        
			document.getElementById("instalmntAmt").disabled = "";
			document.getElementById("instalmntAmt").style.background="#ffffd3";
			document.getElementById("instalmntAmt").className="required";        
			/*document.getElementById("noOfInstalmnt").disabled = "";
			document.getElementById("noOfInstalmnt").style.background="#ffffd3";
			document.getElementById("noOfInstalmnt").className="required";    */    
			document.getElementById("fstInstamntAmt").disabled = "";
			document.getElementById("fstInstamntAmt").style.background="#ffffd3";
			document.getElementById("fstInstamntAmt").className="required";        
			document.getElementById("recvYYMM").disabled = "";
			document.getElementById("recvYYMM").style.background="#ffffd3";
			document.getElementById("recvYYMM").className="required";        
			//document.getElementById("balAmt").disabled = "";
			//document.getElementById("balAmt").style.background="#ffffd3";
			//document.getElementById("balAmt").className="required";        

			document.getElementById("newDsgnDesc").disabled = ""; 
			document.getElementById("newDsgnDesc").style.background="#ffffd3";
			document.getElementById("newDsgnDesc").className="required";
			document.getElementById("buttxtDesig").disabled="";
			/*document.getElementById("newPayScaleCode").disabled = "";       
			document.getElementById("newPayScaleCode").style.background="#ffffd3";
			document.getElementById("newPayScaleCode").className="required";*/
			document.getElementById("newBasic").disabled = "";     
			document.getElementById("newBasic").value = "";
			document.getElementById("newBasic").style.background="#ffffd3";
			document.getElementById("newBasic").className="required";

			document.getElementById("newPenaEffDate").value = "";
			document.getElementById("newPenaEffDate").style.background="#ffffd3";
			document.getElementById("newPenaEffDate").className="required";
			document.getElementById("effDate").disabled = "";
			document.getElementById("txtPenaEffDateTo").value = "";
			document.getElementById("txtPenaEffDateTo").style.background="#ffffd3";
			document.getElementById("txtPenaEffDateTo").className="required";
			document.getElementById("effDateTo").disabled = "";
			document.getElementById("txtIncrType").disabled = "";
			document.getElementById("txtIncrType").className = "required";
			document.getElementById("txtIncrType").style.background = "#ffffd3";
		}
		else
		{
			document.getElementById("recvdAmt").value = ""; 
			document.getElementById("recvdAmt").disabled = "true"; 
			document.getElementById("recvdAmt").className = "locked";
			document.getElementById("recvdAmt").style.background = "#e0e0e0";
			document.getElementById("instalmntAmt").value = ""; 
			document.getElementById("instalmntAmt").disabled = "true"; 
			document.getElementById("instalmntAmt").className = "locked";
			document.getElementById("instalmntAmt").style.background = "#e0e0e0";
			/*document.getElementById("noOfInstalmnt").value = ""; 
			document.getElementById("noOfInstalmnt").disabled = "true"; 
			document.getElementById("noOfInstalmnt").className = "locked";
			document.getElementById("noOfInstalmnt").style.background = "#e0e0e0";*/
			document.getElementById("fstInstamntAmt").value = ""; 
			document.getElementById("fstInstamntAmt").disabled = "true"; 
			document.getElementById("fstInstamntAmt").className = "locked";
			document.getElementById("fstInstamntAmt").style.background = "#e0e0e0";
			document.getElementById("recvYYMM").value = ""; 
			document.getElementById("recvYYMM").disabled = "true"; 
			document.getElementById("recvYYMM").className = "locked";
			document.getElementById("recvYYMM").style.background = "#e0e0e0";
			document.getElementById("balAmt").value = "";
			document.getElementById("balAmt").readonly = "true";
			document.getElementById("balAmt").className = "locked";
			document.getElementById("balAmt").style.background = "#e0e0e0";

			document.getElementById("newDsgnDesc").disabled = "true"; 
			document.getElementById("newDsgnDesc").value = "";
			document.getElementById("newDsgnDesc").style.background="#e0e0e0";
			document.getElementById("newDsgnDesc").className="locked";
			document.getElementById("newDsgn").value = "";
			document.getElementById("buttxtDesig").disabled="true";
			/*document.getElementById("newPayScaleCode").disabled = "true";
			document.getElementById("newPayScaleCode").value = "";
			document.getElementById("newPayScaleCode").style.background="#e0e0e0";
			document.getElementById("newPayScaleCode").className="locked";*/
			document.getElementById("newBasic").disabled = "true";
			document.getElementById("newBasic").value = "";
			document.getElementById("newBasic").style.background="#e0e0e0";
			document.getElementById("newBasic").className="locked";
			document.getElementById("newPenaEffDate").value = "";
			document.getElementById("newPenaEffDate").style.background="#e0e0e0";
			document.getElementById("newPenaEffDate").className="locked";
			document.getElementById("effDate").disabled = "true";
			document.getElementById("txtPenaEffDateTo").value = "";
			document.getElementById("txtPenaEffDateTo").style.background="#e0e0e0";
			document.getElementById("txtPenaEffDateTo").className="locked";
			document.getElementById("effDateTo").disabled = "true";
			document.getElementById("txtIncrType").disabled = "true";
			document.getElementById("txtIncrType").className = "optional";
			document.getElementById("txtIncrType").style.background="#FFFFFF";
		}
	}
	else if(frmEmpPenalityForm.screenMode.value == 'U')
	{
		
		if(frmEmpPenalityForm.penaType.value=='PENALTY$STOPINCR')
		{
			if(document.getElementById("txtPenaEffDateTo").value == "")
			{
				document.getElementById("txtPenaEffDateTo").disabled = "";
				document.getElementById("txtPenaEffDateTo").className = "optional";
				document.getElementById("txtPenaEffDateTo").style.background="#FFFFFF";
				document.getElementById("effDateTo").disabled = "";
				document.all.butSave.disabled="";
				document.all.butSave.src="../INCLUDES/IMAGES/save.jpg";
			}
		}
	}
}

function chk_YearMonth(obj,Ind)
{       
    var  yearM = (obj.value);      
    var month =  yearM.substring(4,6);   
    if (num_Check(yearM,1))
    {  
        if (yearM.length != 6)
        {
            alert(" Year Month should be a Six digit Number");
            obj.focus();   
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                    
            return false;        
        }    
        else if((eval(month) < 1) || (eval(month) > 12))
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("recvYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        }
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

function checkInstAmt1()
{           
	if (frmEmpPenalityForm.screenMode.value == "N")
	{  
	
		var tempTotalAmt = parseInt(document.getElementById("recvdAmt").value,10);
		document.getElementById("balAmt").value=document.getElementById("recvdAmt").value;
	} 
    return true;
}

function checkAmountCalculation()
{
	var tempTotalAmt = document.getElementById("recvdAmt").value==""?0:parseInt(document.getElementById("recvdAmt").value,10);
	var tempFstInstamntAmt = document.getElementById("fstInstamntAmt").value==""?0:parseInt(document.getElementById("fstInstamntAmt").value,10);
	var tempNoOfInstalmnt = document.getElementById("noOfInstalmnt").value==""?0:parseInt(document.getElementById("noOfInstalmnt").value,10);
	var tempInstalmntAmt = document.getElementById("instalmntAmt").value==""?0:parseInt(document.getElementById("instalmntAmt").value,10);
	//alert(tempFstInstamntAmt+","+tempNoOfInstalmnt+","+tempInstalmntAmt);
	var calcAmt=tempFstInstamntAmt+(tempNoOfInstalmnt-1)*tempInstalmntAmt;
	if(tempInstalmntAmt==0)
	{
		alert("Installment amount cannot be 0");
		document.getElementById("instalmntAmt").value='';
		return false;
	}
	if(tempTotalAmt!=calcAmt)
	{
		alert("Please Enter the correct Amount");
		document.getElementById("fstInstamntAmt").value='';
		document.getElementById("noOfInstalmnt").value='';
		document.getElementById("instalmntAmt").value='';
		return false;
	}
}

function getTab(arg)
{
	document.all.forwardedPage.value=arg;
	document.forms[0].action="../../../PenaltyDetailTabAction.do";
	document.forms[0].submit();
}

function stopIncrement()
{
	if(confirm("Do you want to stop the increment.?"))
	{
		enableAll();
		if(mandatory_Check("frmEmpPenalityForm"))
		{
			document.getElementById("hdnAction").value = "INCRSTOP";
			document.forms[0].action="../../../IncrStopAction.do";
			document.forms[0].submit();
		}
	}
}  

function reschedule_penalty()
{
	frmEmpPenalityForm.buttonFlag.value = "RESCHEDULE";
	document.getElementById("instalmntAmt").readOnly="";
	document.getElementById("instalmntAmt").style.background="#ffffd3";
	document.getElementById("instalmntAmt").className="required";
	document.getElementById("balAmt").readOnly="";
	document.getElementById("balAmt").style.background="#ffffd3";
	document.getElementById("balAmt").className="required";
	//document.getElementById("balInstalmnt").readOnly="";
	//document.getElementById("balInstalmnt").style.background="#ffffd3";
	//document.getElementById("balInstalmnt").className="required";
	document.getElementById("butReschedule").disabled="true";
	document.getElementById("remarks").readOnly="";
	document.all.butSave.disabled="";
	document.all.butSave.src="../INCLUDES/IMAGES/save.jpg";
}

function chkValidDateFrm(me)
{
	var toDate = me.value;
	var months = {Jan:1,Feb:2,Mar:3,Apr:4,May:5,Jun:6,Jul:7,Aug:8,Sep:9,Oct:10,Nov:11,Dec:12};
	var currYYMM = document.getElementById("payYYMM").value;
	var currYY = currYYMM.substring(0,4);
	var currM = currYYMM.substring(4,6);
	var arr=toDate.split("-");
	var vYear = arr[2];
	var vMon = months[arr[1]];
	//alert(vYear+","+currYY)
	//alert(vMon+","+currM)
	if(eval(vYear) > eval(currYY))
    {
		alert("Effective From Date can not be Greater than the Current Date.");
		me.value="";
		return false;
	}
	else if((eval(vYear) == eval(currYY)) && (eval(vMon) > eval(currM)) )
	{
		alert("Effective From Date can not be Greater than the Current Date.");
		me.value="";
		return false;
	}
	/*else if((eval(vYear) == eval(currYY)) && (eval(vMon) < eval(currM)) && (frmEmpPenalityForm.penaType.value=='PENALTY$STOPINCR'))
	{
		alert("Back dated Stop Increment is not permissible");
		me.value="";
		return false;
	}*/
	else
	{
		compareDate(1);
	}
}

function chkValidDateTo(me)
{
	var toDate = me.value;
	var months = {Jan:1,Feb:2,Mar:3,Apr:4,May:5,Jun:6,Jul:7,Aug:8,Sep:9,Oct:10,Nov:11,Dec:12};
	var currYYMM = document.getElementById("payYYMM").value;
	var currYY = currYYMM.substring(0,4);
	var currM = currYYMM.substring(4,6);
	var arr=toDate.split("-");
	var vYear = arr[2];
	var vMon = months[arr[1]];
	//alert(vYear+","+currYY)
	//alert(vMon+","+currM)
	var incrtype = frmEmpPenalityForm.penaType.value;
	if(eval(vYear) < eval(currYY))
    {
		if(incrtype=='PENALTY$STOPINCR') return true;
		alert("Effective To Date can not be Less than the Current Date.");
		me.value="";
		return false;
	}
	else if((eval(vYear) == eval(currYY)) && (eval(vMon) < eval(currM)))
	{
		if(incrtype=='PENALTY$STOPINCR') return true;
		alert("Effective To Date can not be Less than the Current Date.");
		me.value="";
		return false;
	}
	else
	{
		compareDate(2);
	}
}

function compareDate(val)
{
	var dtFrm = document.getElementById("newPenaEffDate").value;
	var dtTo = document.getElementById("txtPenaEffDateTo").value;
	if(val=="1")
	{
		if(dtTo != "")
		{
			if (!cmpDate(dtFrm,dtTo,0))
			{
				alert("Effective From date can not be larger than Effective To date."); 
				document.all.newPenaEffDate.value="";
				return false;                      
			}
		}
	}
	if(val=="2")
	{
		if(dtFrm != "")
		{
			if (!cmpDate(dtFrm, dtTo,0))
			{
				alert("Effective To date can not be less than Effective From date."); 
				document.all.txtPenaEffDateTo.value="";
				return false;                      
			}
		}
	}
    return true;
}

function chkNewBasic(me)
{
	var oldBasic = document.all.txtCurtBasic.value;
	if(eval(me.value) != "")
	{
		if(eval(me.value) > eval(oldBasic))
		{
			alert("New Basic can not be More than Old Basic.")
			me.value="";
			me.focus();
		}
    }
}

function chkRcvYYMM(me)
{
	var yymm = document.all.recvYYMM.value;
	var currYYMM = document.getElementById("payYYMM").value;
	if(eval(me.value) != "")
	{
		if(eval(yymm) < eval(currYYMM))
		{
			alert("Recovery Financial Year can not be less than Current Financial Year.");
			me.value="";
			me.focus();
		}
	}
}

function checkInstAmt()
{
	
	//alert(document.getElementById("instalmntAmt").value)
	var tempTotalAmt = parseInt(document.getElementById("recvdAmt").value,10);
	var tempInstAmt = parseInt(document.getElementById("instalmntAmt").value,10);
	var tempfstInstamntAmt = parseInt(document.getElementById("fstInstamntAmt").value,10);
	//alert("tempInstAmt" + tempInstAmt);
	//document.getElementsByName("txtAdvBalance").value=document.getElementsByName("recvdAmt").value;
	if (isNaN(tempTotalAmt))
	{
		document.getElementById("noOfInstalmnt").value= "";
		return false;
	}

	if (isNaN(tempInstAmt))
	{
		document.getElementById("noOfInstalmnt").value= "";
		return false;
	}
	var x=(tempTotalAmt-tempfstInstamntAmt)/tempInstAmt;
	var y=(tempTotalAmt-tempfstInstamntAmt)%tempInstAmt;
	var diff = x - Math.floor(x);
	diff = Math.ceil(diff);
	if (parseInt(diff)  > 0)
	{
		document.getElementById("noOfInstalmnt").value=parseInt(Math.floor(x)) + 1;                                             
	}
	else
	{
		document.getElementById("noOfInstalmnt").value = Math.floor(x);  
	}
	
	if (tempfstInstamntAmt > 0)
	{
		document.getElementById("noOfInstalmnt").value = eval(document.getElementById("noOfInstalmnt").value) + 1;
	}

	if(tempInstAmt == 0)
	{
		document.getElementById("noOfInstalmnt").value=0;    
	}
	checkAmountCalculation();
	return true;
}

function checkInstAmtU()
{
	var instalmntAmt = parseInt(document.getElementById("instalmntAmt").value,10);
	var balAmt = parseInt(document.getElementById("balAmt").value,10);
    if (isNaN(instalmntAmt))
	{
		document.getElementById("instalmntAmt").value= "";
		return false;
	}

	if (isNaN(balAmt))
	{
		document.getElementById("balAmt").value= "";
		return false;
	}
	if(instalmntAmt > balAmt)
	{
		alert("Installment amount can not exceed Balance amount");
		return false;
	}
	var x=balAmt/instalmntAmt;
	var y=balAmt%instalmntAmt;
	var diff= x - Math.floor(x);
	diff = Math.ceil(diff);
	if (parseInt(diff)  > 0)
	{
		document.getElementById("balInstalmnt").value=parseInt(Math.floor(x)) + 1;                                             
	}
	else
	{
		document.getElementById("balInstalmnt").value = Math.floor(x);  
	}
	return true;
}

function textCounter(field, maxlimit)     
{
//alert(field.value.length)
	if (field.value.length >= maxlimit)         
	{   
		field.value = field.value.substring(0, maxlimit);            
		return false;
	}        
	else         
	{            
		return true;
	}
}

</script>