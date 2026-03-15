<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
    <html:base/>
    <TITLE><bean:message key="pay.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>        
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
  </HEAD>

  <BODY scroll=yes onbeforeunload="confWindowClose()" onunload="handleOnClose()" onload="lfnLoad();">
    <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

    <html:form  action="EnqPayImgGangBase" name="frmEnqPayImgGang" type="FCIPAY.Payroll.WEBTIER.Form.EnqPayImgForm" scope="session">
    <bean:define id="ParentForm" name="frmEnqPayImgGang" toScope="request" />
    <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
    <html:errors/>
    <html:hidden property="detailDataChanged" />
    <html:hidden property="headerFields" value="false" />
    <%! int i=0,j=0; %>
    <% i = 0;j=0; %>
    <!--Table 10 starts-->
    <TABLE cellSpacing=0 bgColor="#bdd0ef">
      <TR height=30>
        <TD  colSpan=11 class=mainHeader height=10>ENQUIRE LABOUR PAY IMAGE (SALARY)</TD>
      </TR>
      <tr height="10">
        <td class=userText colspan="11">
        </td>
      </tr>
    </TABLE>
    <!--Table 10 ends-->
    <!--container table starts -->
    <div id=divDtlTable  style="height:700px" >
      <!--Table 11 starts-->
      <TABLE cellSpacing=0 cellPadding=0 border=0 >
        <TBODY>
          <TR>
            <TD>     
              <!-- Body table Starts -->
              <!--Table 20 starts-->
              <TABLE cellSpacing=0 cellPadding=0 border = 0>
              <!--pay Scale Header Row Starts -->
                <TR>
                  <TD class=subHeader colspan=6> PAY IMAGE HEADERS </TD>
                </TR>
                <TR>
                  <TD colspan=6 bgColor="#4682b4"><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>
                <tr height="5" >
                  <td colspan="6"></td>
                </tr>
                <tr height="12" align="center">
                  <td width="20%" ></td>  
                  <td width="20%" class="radioTextRight" align="center" colspan="2"><input type="radio" name="radioEmp" value="E" onclick="EmpNoClick()" ><bean:message  key="Payroll.Labour.empWise" />         
                  <td width="30%" class="radioTextCenter" align="center" colspan="2"><input type="radio" name="radioGang" value="S" onclick="EmpGangClick()" ><bean:message key="Payroll.Labour.GangWise"  />            
                  
                  <td width="30%"></td>  
                </TR>
                <tr height="5" >
                  <td colspan="6"></td>
                </tr>
                <TR>
                    <TD colspan=6 bgColor="#4682b4"><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>                
                <tr height="5" >
                  <td colspan="6"></td>
                </tr>
                
                <TR>
					<TD colspan="10">
						<table cellSpacing=0 cellPadding=0 border=0 >
							<tr>                
							  <td class=labelText width="10%"><bean:message key="Payroll.EnqPayImg.txtEmpNo" /></td>
							  <td align="left" width="25%">
								  <logic:equal property= "optVal" name= "frmEnqPayImgGang" value="1">
									  <html:text  property="txtEmpNo" altKey="pay.EnqPayImg.txtEmpNo" maxlength="10" size="23" styleClass="required"
					  				    onchange=
										  "if(!(checkEmployee(frmEnqPayImgGang.txtEmpNo.value,frmEnqPayImgGang.loginLocCode.value)))
										  {
											frmEnqPayImgGang.txtEmpNo.value='';
										  }"
									  />                                   
									  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick=" return ShowLovEmpNo();">
									  &nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="32" styleClass="locked" readonly="true" />
								  </logic:equal>
								  <logic:notEqual property= "optVal" name= "frmEnqPayImgGang" value="1">
									  <html:text  property="txtEmpNo" altKey="pay.EnqPayImg.txtEmpNo" maxlength="10" size="23" readonly="true" styleClass="optional" />
									  &nbsp;&nbsp;<html:text property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="32" styleClass="locked" readonly="true" />
								  </logic:notEqual>
							  </td>
							  <td class=labelText width="10%"><bean:message key="Payroll.EnqPayImg.lstCadre" /></td>
							  <td width="10%">
								<html:text  property="lstGroup" altKey="pay.EnqPayImg.lstCadre" maxlength="10" size="23" styleClass="locked" readonly="true" />                    
							  </td>                                   
							  <td class=labelText width="14%" ><bean:message key="Payroll.EnqPayImg.lstCateg" /> </td>
							  <td width="10%">
								<html:text  property="lstCateg" altKey="pay.EnqPayImg.lstCateg" maxlength="10" size="23" styleClass="locked" readonly="true" />                                                         
							  </td>
							</tr> 
							<tr> 
							  <td class=labelText><bean:message key="Payroll.EnqPayImg.txtBasic" /></td>
							  <td align="left">
								<html:text  property="txtCurrBas" altKey="Payroll.EnqPayImg.txtBasic" maxlength="10" size="23" styleClass="locked" readonly="true" />
							  </td>
							  <td class=labelText><bean:message key="Payroll.EnqPayImg.txtDesig" /></td>
							  <td align="left">
								<html:text  property="txtDesig" altKey="pay.EnqPayImg.txtDesig" maxlength="10" size="23" styleClass="locked" readonly="true" />
							  </td>
							  <td class=labelText><bean:message key="Labours.txtGangName" /></td>
							  <td >
									<logic:equal property= "optVal" name= "frmEnqPayImgGang" value="2">
										<html:text  property="txtGang" name="frmEnqPayImgGang" styleClass = "required" altKey="Labours.txtGangName" maxlength="10" size="23" />                                                
										<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtYtm"  onclick=" return ShowLovGang()">
									</logic:equal>
									<logic:notEqual property= "optVal" name= "frmEnqPayImgGang" value="2">
										<html:text  property="txtGang" name="frmEnqPayImgGang" styleClass = "optional" altKey="Labours.txtGangName" readonly="true" maxlength="10" size="23" />
									</logic:notEqual>
									<html:hidden property="txtGangId" name="frmEnqPayImgGang"/>
							   </td>                                                                               
							</tr>

							<tr>
								<td class=labelText><bean:message key="Payroll.LPC.FrYYMM" /></td>
								<td>
									<logic:equal property= "screenMode" name= "frmEnqPayImgGang" value="Q">
										<html:text property="txtYtm" styleClass = "required" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" onblur="checkYYYYMM(this);" />
										<!--<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtYtm"  onclick=" return  ShowLovYYMM()">-->
									</logic:equal>
									<logic:notEqual property= "screenMode" name= "frmEnqPayImgGang" value="Q">
										<html:text  property="txtYtm" styleClass = "locked" readonly="true" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" />
										<!--<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtYtm"  onclick=" return  ShowLovYYMM()">-->
									</logic:notEqual>
								</td>

								<td class=labelText><bean:message key="Payroll.LPC.ToYYMM" /></td>
								<td align="left">
									<logic:equal name="frmEnqPayImgGang" property="screenMode" value="Q"> 
										<html:text property="txtUptoYYMM" styleClass = "required" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" onblur="checkYYYYMM(this);" />
									</logic:equal>
									<logic:notEqual name="frmEnqPayImgGang" property="screenMode" value="Q"> 
										<html:text property="txtUptoYYMM" styleClass = "locked" readonly="true" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" onblur="checkYYYYMM(this);" />
									</logic:notEqual>
								</td>
							</tr>
						</table>
					</TD>
				</TR>               
                


			  </TABLE>

			<table cellSpacing=0 cellPadding=0 border=0>
				<tr>
					<td colspan="10">
						<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
						<td bgcolor="#4682B4" nowrap class=actTabText>Salary<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
						<td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
						
						<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
						<td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("incentive")>Incentive<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
						<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
						
						<td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
						<td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
						<TD align="right"><html:button value='   Get Detail   '  onclick="GetDetail()" property="butInsert" styleClass="bottomBarText" /> </TD>
					</td>
				</tr>
			</table>

              <!--Body table ends-->
    
              <!--Table 21 starts-->
              <table cellspacing=0 cellpadding=0 border=0>
              <!-- Detail Information Row starts -->
                <TR>
                  <TD colspan=6>
                    <!--Table 31 starts-->
                    <table cellspacing=0 cellpadding=0 border=0>
                      <TBODY>
                        <TR>
                          <td width = 50%>
                            <!-- Purchase Requisition Info Table Starts -->
                            <!--Table 40 starts-->
                            <TABLE cellSpacing=0 cellPadding=0 >
                              <TR>
                                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td bgcolor="#4682B4" nowrap class=actTabText>Earning Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                              </TR> 
                              <TR>
                                <TD colspan=5>
                                  <!--Table 50 starts-->
                                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                                    <TBODY>
                                      <TR>
                                        <TD >   
                                          <DIV id=divDtlTable style="height:350px" >
                                          <!-- Detail table starts -->
                                            <!--Table 60 starts-->
                                            <TABLE cellSpacing=0 cellPadding=0>
                                              <TBODY>
                                                <TR height="20">
                                                  <td class=tableHeader width="9%"><bean:message key="Payroll.EnqPayImg.txtPayCode" /></td>
                                                  <td class=tableHeader width="15%"><bean:message key="Payroll.EnqPayImg.txtDesc" /></td>
                                                  <td class=tableHeader width="5%"><bean:message key="Payroll.EnqPayImg.txtSrlNo" /></td>
                                                  <td class=tableHeader width="5%"><bean:message key="Payroll.EnqPayImg.txtPayMode" /></td>
                                                  <td class=tableHeader width="6%"><bean:message key="Payroll.EnqPayImg.txtAmt" /></td>                              
                                                </TR> 
                                                
                                                <logic:iterate id="payImage" name="frmEnqPayImgGang" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                                                <logic:lessThan name="payImage" property="txtPayCode" value="997">
                                                <logic:equal name="payImage" property="txtPayMode" value="1">
                                                   <tr>
                                                      <td width="9%"><html:text property="txtPayCode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="15%"><html:text property="txtDesc" name="payImage" size = "31" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtSrlNo" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtPayMode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="6%"><html:text property="txtAmt" name="payImage" style="width:100%;text-align:right" readonly="true" /></td>
                                                  </tr>    
                                                </logic:equal>
                                                <logic:equal name="payImage" property="txtPayMode" value="4">
                                                   <tr>
                                                      <td width="9%"><html:text property="txtPayCode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="15%"><html:text property="txtDesc" name="payImage" size = "31" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtSrlNo" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtPayMode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="6%"><html:text property="txtAmt" name="payImage" style="width:100%;text-align:right" readonly="true" /></td>
                                                  </tr>    
                                                </logic:equal>
                                                </logic:lessThan>
                                               </logic:iterate>   
                                              </TBODY>
                                            </TABLE>
                                            <!--Table 60 ends-->
                                          </DIV>
                                        </TD>
                                      </TR>                       
                                    </TBODY>
                                  </TABLE> 
                                  <!--Table 50 ends-->
                                </TD>
                              </TR>
                            </TABLE>
                            <!--Table 40 ends-->
                          </td>
                          <td width = 50%>
                            <!--Table 41 starts-->
                            <TABLE cellSpacing=0 cellPadding=0 >
                              <TR>
                                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td bgcolor="#4682B4" nowrap class=actTabText>Deduction Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                              </TR> 
                              <TR>
                                <TD colspan=5>
                                  <!--Table 51 starts-->
                                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                                    <TBODY>
                                      <TR>
                                        <TD >   
                                          <!-- Detail table starts -->
                                            <!--Table 61 starts-->
                                          <DIV id=divDtlTable style="height:350px" >
                                            <TABLE cellSpacing=0 cellPadding=0>
                                              <TBODY>
                                                 <TR height="20">
                                                  <td class=tableHeader width="9%"><bean:message key="Payroll.EnqPayImg.txtPayCode" /></td>
                                                  <td class=tableHeader width="15%"><bean:message key="Payroll.EnqPayImg.txtDesc" /></td>
                                                  <td class=tableHeader width="5%"><bean:message key="Payroll.EnqPayImg.txtSrlNo" /></td>
                                                  <td class=tableHeader width="5%"><bean:message key="Payroll.EnqPayImg.txtPayMode" /></td>
                                                  <td class=tableHeader width="6%"><bean:message key="Payroll.EnqPayImg.txtAmt" /></td>                              
                                                </TR>   
                                                <logic:iterate id="payImage" name="frmEnqPayImgGang" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                                                <logic:lessThan name="payImage" property="txtPayCode" value="997">
                                                <logic:equal name="payImage" property="txtPayMode" value="2">
                                                   <tr>
                                                      <td width="9%"><html:text property="txtPayCode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="15%"><html:text property="txtDesc" name="payImage" size = "31" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtSrlNo" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtPayMode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="6%"><html:text property="txtAmt" name="payImage" style="width:100%;text-align:right" readonly="true" /></td>
                                                  </tr>      
                                                  </logic:equal>
                                                <logic:equal name="payImage" property="txtPayMode" value="5">
                                                   <tr>
                                                      <td width="9%"><html:text property="txtPayCode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="15%"><html:text property="txtDesc" name="payImage" size = "31" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtSrlNo" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtPayMode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="6%"><html:text property="txtAmt" name="payImage" style="width:100%;text-align:right" readonly="true" /></td>
                                                  </tr>      
                                                  </logic:equal>
                                                  </logic:lessThan>
                                               </logic:iterate>                                            
                                              </TBODY>
                                            </TABLE>
                                            <!--Table 61 ends-->
                                          </DIV>
                                        </TD>
                                      </TR>                       
                                    </TBODY>
                                  </TABLE> 
                                  <!--Table 51 ends-->
                                </TD>
                              </TR>
                            </TABLE>  
                            <!--Table 41 ends-->
                          </td>
                        </TR>   
                      </TBODY>
                    </table>
                    <!--Table 31 ends--> 
                  </TD>
                </TR>
                <TR >
                  <td colspan = 6>     
                    <!--Table 32 starts-->            
                    <table width = "100%"  cellspacing="0" cellpadding="0" border = 0>
                      <tr height = 5><td></td></tr>
                      <tr>
                        <td class=labelLeftAlign width = "9%"><bean:message key="pay.EnqPayImg.txtNetEar" /></td>
                        <% int flg = 0; %>     
                        <logic:iterate id="payImage" name="frmEnqPayImgGang" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                        <logic:equal name="payImage" property="txtPayCode" value="999">
                              <% flg = 1; %>
                              <td width="11%"><html:text property="txtAmt" name="payImage" size = "11" style="text-align:right" readonly="true"/></td>
                          </logic:equal>
                       </logic:iterate>    
                       <% if (flg ==0) { %>
                          <td width="11%"><html:text size = "11" property = "txtAmt" value = "" style="text-align:right" readonly="true" /></td>                       
                       <%  } %>
                          <% flg = 0; %>
                        <td class=labelText width = "18%" align="right"><bean:message key="pay.EnqPayImg.txtGrossEar" /></td>     
                        <logic:iterate id="payImage" name="frmEnqPayImgGang" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                        <logic:equal name="payImage" property="txtPayCode" value="997">
                              <% flg = 1; %>                        
                              <td width="10%" align = "right" ><html:text property="txtAmt" name="payImage" size = "11" style="text-align:right" readonly="true"/></td>
                         </logic:equal>
                       </logic:iterate>
                       <% if (flg ==0) { %>
                          <td width="10%" align = "right" ><html:text size = "11" property = "txtAmt" value = "" style="text-align:right" readonly="true" /></td>                       
                       <%  } %>         
                       <% flg = 0; %>                       
                        <td class=labelText width = "41%" align="right"><bean:message key="pay.EnqPayImg.txtGrossDed" /></td>     
                        <logic:iterate id="payImage" name="frmEnqPayImgGang" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                        <logic:equal name="payImage" property="txtPayCode" value="998">
                          <% flg = 1; %>
                          <td width="9%" align = "right"><html:text property="txtAmt" name="payImage" size = "11" style="text-align:right" readonly="true"/></td>
                          </logic:equal>
                       </logic:iterate>                  
                       <% if (flg ==0) { %>
                          <td width="9%" align = "right"><html:text size = "11" property = "txtAmt" value = "" style="text-align:right" readonly="true" /></td>                       
                       <%  } %>                                              
                       <td width="2%">&nbsp;</td>                       
                      </tr> 
					  <!--Added by Vibhuti-PayCode 902,952-->
                      <tr>
						<td width="9%" class=labelLeftAlign><bean:message key="pay.EnqPayImg.txtEPSDed"/></td>
						<td width="11"><html:text size="11" property="txtEPSDed" name="frmEnqPayImgGang" style="text-align:right" readonly="true"/></td>
						<td class=labelText><bean:message key="pay.EnqPayImg.txtPFContr"/></td>
						<td align="right"><html:text size="11" property="txtPFContr" name="frmEnqPayImgGang" style="text-align:right" readonly="true"/></td>
     				  </tr>
                    </table>
                    <!--Table 32 ends-->
                  </td>
                </TR>

				<!-- Get details starts -->
				<tr>
				  <td colspan=11>	
					<TABLE border=0>
					  <TBODY>
						<TR>
							<td colspan=11>	
								<jsp:include  page = "../INCLUDES/GenDetailMenuPayImg.jsp" flush="true" />
							</TD> 
						</TR>
					  </TBODY>
				  </TABLE>

				 </TD>
				</tr>
                <!-- Bottom Blue Bar -->
                <TR >
                  <td width="40%" bgColor="#4682b4"></td>
                  <td align=right bgColor="#4682b4"><img src="../INCLUDES/IMAGES/man.jpg"></td>  
                </TR>
              </table>
              <!--Table 20 ends-->
              <!-- Container Table Ending Columns Starts-->
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!--Table 11 ends-->
    </div>

    <!-- Container Table Ends -->
    <html:hidden name="frmEnqPayImgGang"  property="headerPrimaryKey" value="Default" />
    <html:hidden name="frmEnqPayImgGang"  property="screenMode"/>
    <html:hidden name="frmEnqPayImgGang"  property="screenName" value="PayImgGangWiseScreen" />
    <html:hidden name="frmEnqPayImgGang"  property="forwardedPage" />
    <html:hidden name="frmEnqPayImgGang"  property="positionRequested" />    
    <html:hidden property="userPositionRequested" name="frmEnqPayImgGang" />
    <html:hidden property="pageRequested" name="frmEnqPayImgGang" />
    <html:hidden property="userPageRequested" name="frmEnqPayImgGang" />
    <html:hidden property="loginLocCode" name="frmEnqPayImgGang"  />
    
    <html:hidden property="lovKey" name="frmEnqPayImgGang"  />
    <html:hidden property="txtFields" name="frmEnqPayImgGang"  />   
    <html:hidden property="txtSearchFields" name="frmEnqPayImgGang"  />
    <html:hidden property="txtDisplayFields" name="frmEnqPayImgGang"  />
    <html:hidden property="txtIndex" name="frmEnqPayImgGang"  />
    <html:hidden property="buttonFlag" name="frmEnqPayImgGang"  />
    <html:hidden name="frmEnqPayImgGang"  property="screenModeGang"/>
    <html:hidden property="optVal" />
    <html:hidden  property="txtrs1" />                              
    <html:hidden  property="txtrs2" />   
    <input type="hidden" name="queryParam" />
	<html:hidden property="payYYMM" name="frmEnqPayImgGang"  />

	</html:form>
  </BODY>
</html:html>

<script language="javascript">

function lfnLoad()
{
  var sMode = document.frmEnqPayImgGang.screenMode.value;
  var mode = document.frmEnqPayImgGang.screenModeGang.value;
  
  if(sMode == "")
  {
    doQueryMode();
  }
  if(sMode == "Q")
  {
    document.frmEnqPayImgGang.butInsert.disabled="true";
  	document.getElementById("txtUptoYYMM").value=document.getElementById("payYYMM").value; //added by swapnendu 17-jan-17
}  
  if(sMode == "U")
  {     
    document.frmEnqPayImgGang.buttxtYtm.disabled="true";
  }
  hedMenuHandling(sMode);  
  
    document.all.butInsertMode.disabled="true";    
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";   
    document.all.butSave.disabled="true";    
    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";   
    
    if((document.frmEnqPayImgGang.optVal.value == '')||(document.frmEnqPayImgGang.optVal.value == '1'))
    {
        document.all.radioEmp.checked="true";
        if(document.frmEnqPayImgGang.optVal.value == '')
        {
          document.frmEnqPayImgGang.screenMode.value="";
          EmpNoClick();
        }
    }
    else if(document.frmEnqPayImgGang.optVal.value == '2')
    {
        document.all.radioGang.checked="true";
        return true;
    }
    else{}
}

function changed(val)
{ 
  frmEnqPayImgGang.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}
 
function doQueryMode()
{
  if(frmEnqPayImgGang.txtGang.value != '')
  {
    frmEnqPayImgGang.txtGang.value ='';
    frmEnqPayImgGang.txtGangId.value =''
  }
  frmEnqPayImgGang.screenMode.value ='Q';
  frmEnqPayImgGang.action="../../../EnqDepPayImageQueryMode.do"
  frmEnqPayImgGang.submit();
}

function GetDetail()
{
	frmEnqPayImgGang.butInsert.disabled="true";
  frmEnqPayImgGang.screenModeGang.value ='U';
  frmEnqPayImgGang.action="../../../EnqDepPayImgFirstGetDetailAction.do"
  frmEnqPayImgGang.submit();
}

function getHeaderRecord()
{
	if(mandatory_Check("frmEnqPayImgGang")){
		frmEnqPayImgGang.screenModeGang.value ='UG';
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
		frmEnqPayImgGang.action="../../../EnqDepPayImgFirstGetHeaderAction.do";
		frmEnqPayImgGang.submit();
	}
}
function doRefresh()
{
  frmEnqPayImgGang.action="../../../EnqPayImgRefresh.do"
  frmEnqPayImgGang.submit();
}
function doGetNextHeader()
{ 
    frmEnqPayImgGang.screenModeGang.value ='UG';
    frmEnqPayImgGang.userPositionRequested.value = 1*(frmEnqPayImgGang.positionRequested.value) + 1;  
    frmEnqPayImgGang.action="../../../EnqDepPayImgGetNextHeader.do";
    frmEnqPayImgGang.submit();
}

function PrevHeader()
{
  frmEnqPayImgGang.screenModeGang.value ='UG';
  frmEnqPayImgGang.userPositionRequested.value = frmEnqPayImgGang.positionRequested.value - 1;
  frmEnqPayImgGang.action = "../../../EnqDepPayImgGetNextHeader.do";
  frmEnqPayImgGang.submit();
}

function JumpHeader()
{
  frmEnqPayImgGang.screenModeGang.value ='UG';
  frmEnqPayImgGang.userPositionRequested.value = 1*frmEnqPayImgGang.newPositionRequested.value;
  frmEnqPayImgGang.action = "../../../EnqDepPayImgGetNextHeader.do";
  frmEnqPayImgGang.submit();
}

function JumpDetail()
{
    frmEnqPayImgGang.userPageRequested.value = 1*frmEnqPayImgGang.newPageRequested.value ;
    frmEnqPayImgGang.action = "../../../EnqDepPayImgGetNextDetail.do";
    frmEnqPayImgGang.submit();

}

function doBasePrevDetail()
{
    frmEnqPayImgGang.userPageRequested.value = 1*frmEnqPayImgGang.pageRequested.value - 1;
    frmEnqPayImgGang.action = "../../../EnqDepPayImgGetNextDetail.do";
    frmEnqPayImgGang.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmEnqPayImgGang.userPageRequested.value = 1*frmEnqPayImgGang.pageRequested.value + 1;
    frmEnqPayImgGang.action = "../../../EnqDepPayImgGetNextDetail.do";
    frmEnqPayImgGang.submit();
}

function ShowLovYYMM()
{
   frmEnqPayImgGang.lovKey.value = "EnqPayImageYtm" + frmEnqPayImgGang.screenName.value + frmEnqPayImgGang.screenMode.value; 
   frmEnqPayImgGang.queryParam.value="txtSiteID="+ frmEnqPayImgGang.loginLocCode.value;
   frmEnqPayImgGang.txtDisplayFields.value = "txtYtm";
   frmEnqPayImgGang.txtSearchFields.value = "";   
   frmEnqPayImgGang.txtIndex.value ="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEnqPayImgGang');
   return true;
}

function ShowLovEmpNo()
{
   frmEnqPayImgGang.lovKey.value = "EnqPayImageEmp" + frmEnqPayImgGang.screenName.value + frmEnqPayImgGang.screenMode.value;
   frmEnqPayImgGang.queryParam.value="txtSiteID="+ frmEnqPayImgGang.loginLocCode.value +",hdnEmpLbrFlag="+ frmEnqPayImgGang.hdnEmpLbrFlag.value ;
   frmEnqPayImgGang.txtDisplayFields.value = "txtEmpNo,txtEmpName"; 
   frmEnqPayImgGang.txtSearchFields.value = "Payroll.EnqPayImg.txtEmpNo,Payroll.EnqPayImg.txtEmpName";
   frmEnqPayImgGang.txtIndex.value ="";   
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEnqPayImgGang');
   return true;
}

function ShowLovGang()
{
   frmEnqPayImgGang.lovKey.value = "EnqPayImageGang" + frmEnqPayImgGang.screenName.value + frmEnqPayImgGang.screenMode.value;
   frmEnqPayImgGang.txtDisplayFields.value = "txtGangId,txtGang";   
   frmEnqPayImgGang.txtSearchFields.value = "Labours.txtGangName";
   frmEnqPayImgGang.queryParam.value="txtSiteID="+ frmEnqPayImgGang.loginLocCode.value +",hdnEmpLbrFlag="+ frmEnqPayImgGang.hdnEmpLbrFlag.value;
   frmEnqPayImgGang.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEnqPayImgGang');
   return true;
}

function ShowLovDsgn()
{
   frmEnqPayImgGang.lovKey.value = "EnqPayImageDsgn" + frmEnqPayImgGang.screenName.value + frmEnqPayImgGang.screenMode.value;
   frmEnqPayImgGang.txtDisplayFields.value = "txtDesig";
   frmEnqPayImgGang.txtSearchFields.value = "";
   frmEnqPayImgGang.queryParam.value="";
   frmEnqPayImgGang.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEnqPayImgGang');
   return true;
}

function checkYYYYMM(me)
{
  var yymm = me.value; //document.all.txtYtm.value;
  var currYYMM = document.getElementById("payYYMM").value;
  var frmYYMM = document.getElementById("txtYtm").value;
  var toYYMM = document.getElementById("txtUptoYYMM").value;

  if(yymm.length == 0)
  {
    return;
  }
  if(yymm.length != 6)
  {
    alert("Please give proper year-month in YYYYMM format");
    me.value="";
	me.focus();
    return;
  }
  if(parseInt(yymm,10)/100000 > 1)
  {
  }
  else
  {
    alert("Please give proper year-month in YYYYMM format");
	me.value="";
	me.focus();
	return;
  }
  var mon=parseInt(yymm.substring(4,6),10);
  if(mon<1 || mon>12)
  {
    alert("MM should be from 01 to 12");
	me.value="";
	me.focus();
    return;
  }
  if(toYYMM != ""){
	  if(parseInt(toYYMM)>parseInt(currYYMM))
	  {
		  alert("To Year Month can't exceed the current month, i.e "+currYYMM);
		  document.all.txtUptoYYMM.select();
		  document.all.txtUptoYYMM.focus();
		  return false;
	  }
  }
  if(frmYYMM != "" && toYYMM != ""){
	  if(parseInt(frmYYMM)>parseInt(toYYMM))
	  {
		  alert("'From Year Month' can't exceed 'To Year Month'");
		  document.all.txtYtm.select();
		  document.all.txtYtm.focus();
		  return false;
	  }
	  var cnt=0;
	  if((parseInt(toYYMM.substring(0,4),10)-parseInt(frmYYMM.substring(0,4),10))==0)
	  {
		 cnt=0;
	  }
	  else if((parseInt(toYYMM.substring(0,4),10)-parseInt(frmYYMM.substring(0,4),10))==1)
	  {
		if(((12-parseInt(frmYYMM.substring(4,6),10))+1) + (parseInt(toYYMM.substring(4,6),10)) > 12)
		{
			cnt=1;
		}
	  }
	  else{
		  cnt=1;
	  }

	  if(cnt==1)
	  {
		  alert("The range should not exceed more than 12 months; Please change 'From Year Month' or 'To Year Month' accordingly.");
		  me.value="";
		  me.focus();
		  return;
	  }
  }
}

function EmpNoClick() 
{
    //document.frmEnqPayImgGang.hdnAction.value = "";      
    document.all.buttonFlag.value='';   
    if(document.all.screenMode.value == 'U')
       document.all.screenMode.value = 'Q';
    
    if(frmEnqPayImgGang.txtGang.value != '')
    {
      frmEnqPayImgGang.txtGang.value ='';
      frmEnqPayImgGang.txtGangId.value =''
    }
      
    document.frmEnqPayImgGang.action="../../../PayImgGangOptionClickAction.do";
    document.frmEnqPayImgGang.optVal.value="1";    
    document.frmEnqPayImgGang.submit(); 
}

function EmpGangClick()
{
    //document.frmEnqPayImgGang.hdnAction.value = "";
    if(document.all.screenMode.value == 'U')
       document.all.screenMode.value = 'Q';
           
    document.all.buttonFlag.value='';
    document.frmEnqPayImgGang.action="../../../PayImgGangOptionClickAction.do";
    document.frmEnqPayImgGang.optVal.value="2";     
    document.frmEnqPayImgGang.submit();
}
function getTab(arg)
{
	document.all.forwardedPage.value=arg;
	document.forms[0].action="../../../PayImgTabAction.do";
	document.forms[0].submit();
}


</script>
