<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.ArrayList,FCIPAY.Payroll.UTILITY.EmpFinVldnBean" %>
<html:html>
	<HEAD>
    <html:base/>
	<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />  
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>  
    <script language="JavaScript1.2" src="../INCLUDES/DeptLabourFinanceInfo.js"></script>          
    <script language="JavaScript1.2" src="../INCLUDES/pohw.js"></script>
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY  onload="EmpFinLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintDeptLabourDetailBase" name="frmDeptLabourInfoForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.DeptLabourInfoForm">
  <bean:define id="ParentForm" name="frmDeptLabourInfoForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>  
  <% i = 0;j=0; %>
        <%
              ArrayList arEmpVld=new ArrayList();
              if(session.getAttribute("arEmpVld")!=null)
              {
                arEmpVld=(ArrayList)session.getAttribute("arEmpVld");
              }
        %>

  <jsp:include page="DeptLabourHeader.jsp" flush="true" />
  <table cellspacing=0 cellpadding=0 border=0 >
         <!-- Detail Information Row starts -->
 	 <TR>
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
            <TABLE cellSpacing=0 cellPadding=0 border =0 >
              <TR>          
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText > Payroll Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("FlagDet")> Payroll Flag Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("HrDet")> HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td background="../INCLUDES/IMAGES/line_t.gif" width="60%">&nbsp;</td>
                
            </tr> 
            <tr height="10"><td class=userText colspan="17"></td></tr>            
            <TR height=10>
            
 <!-- Detail table Container starts -->
              <TD colspan=17>
                <TABLE cellSpacing=0 cellPadding=0 border=0 >
                  <TBODY>
                    <TR>
                      <TD>
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 border=0>
                          <TBODY>        
                            <TR>       
							<!--commented by devendra on 20th sept 2010 start--
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.ptype" /></td>
                              <td colspan="1" >
                              <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                              <html:select  property="txtPayType" styleClass = "optional" alt="txtPayType" style="width:80%" disabled="true" >
                              <!--<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>--      
                              <html:option value="IDA" > <bean:message key="Payroll.EmpInfo.ida" /></html:option>
                              <!--<html:option value="CDA" > <bean:message key="Payroll.EmpInfo.cda" /></html:option>--                            
                              </html:select>
                              </logic:equal>
                              <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                              <html:select  property="txtPayType" styleClass = "required" alt="txtPayType" titleKey="Payroll.EmpInfo.ptype" style="width:80%" disabled="true" onchange="chkVldn(); comboChange();"  >
                              <!--<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>--     
                              <html:option value="IDA" > <bean:message key="Payroll.EmpInfo.ida" /></html:option>
                              <!--<html:option value="CDA" > <bean:message key="Payroll.EmpInfo.cda" /></html:option>--                              
                              </html:select>
                              </logic:notEqual>
                              </td>           
							  <!--commented by devendra on 20th sept 2010 end-->
                              
                              <td class=labelText width="15%"  ><bean:message key="Payroll.EmpInfo.pcode" /> </td>            
                              <td><html:text  property="txtPayScaleCode" altKey="Payroll.EmpInfo.pcode" maxlength="10" size="23" styleClass="locked" onchange="lfnChanged(this.value);" readonly="true"/>                                               
                              </td>    
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.curbas" /></td>
                              <td >
                              <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                              <html:text  property="txtCurtBasic" altKey="Payroll.EmpInfo.curbas" maxlength="6" size="23" styleClass="locked" onchange="lfnChange(this.value);"  style="text-align:right" readonly="true"/></td>                                                                                                                        
                              </logic:equal>
                              <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                              <html:text  property="txtCurtBasic" altKey="Payroll.EmpInfo.curbas" maxlength="14" size="23" titleKey="Payroll.EmpInfo.curbas" styleClass="required" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right" /></td>                                                                                                                        
                              </logic:notEqual>
                          </tr>                
                          
                          <TR>       
                     <!--Added by dushyant on 26-April-2013 for pay status-->
							 <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.psatat" /> </td>               
							  <td>                  
							  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">                                          
								  <html:select property="txtPayStatus" alt="txtPayStatus" titleKey="Payroll.EmpInfo.psatat" styleClass="required" disabled="true" style="width:80%" onchange="fillPayStatusChdDate(); comboChange();" >   
								 <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>             
								 </html:select>
							  </logic:equal> 

							  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="N">
                                  <logic:equal property= "txtCpfCode" name= "frmDeptLabourInfoForm" value="TEMP">
									  <html:select property="txtPayStatus" alt="txtPayStatus" titleKey="Payroll.EmpInfo.psatat" styleClass="required" disabled="true" style="width:80%" onchange="fillPayStatusChdDate(); comboChange();" >
										 <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>     
										 </html:select>
                                  </logic:equal>
								  <logic:notEqual property= "txtCpfCode" name= "frmDeptLabourInfoForm" value="TEMP">
									  <html:select property="txtPayStatus" alt="txtPayStatus" titleKey="Payroll.EmpInfo.psatat" styleClass="required" style="width:80%" onchange="fillPayStatusChdDate(); comboChange();" >
										 <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>
										 <html:option value="A" > <bean:message key="Payroll.EmpInfo.act" /></html:option>
										 <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>     
										 </html:select>
                                  </logic:notEqual>
							  </logic:notEqual><html:hidden  property="txtPayStatus" altKey="Payroll.EmpInfo.psatat"  />         
							  </td>
					  <!--Added by dushyant on 26-April-2013 for pay status-->



                              
                              <td  width="16%" class=labelText><bean:message key="Payroll.EmpInfo.pmode" /></td>
                              <td colspan="1" ><html:select property="txtPayMode" alt="txtPayMode" titleKey="Payroll.EmpInfo.pmode" styleClass="required" style="width:80%" onchange="comboChange(); " >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>                                    
                              <html:option value="C" > <bean:message key="Payroll.EmpInfo.cash" /></html:option>
                              <html:option value="B" > <bean:message key="Payroll.EmpInfo.bank" /></html:option>
                              <html:option value="O" > <bean:message key="Payroll.EmpInfo.oth" /></html:option>                                                               
                              </html:select>
                              </td>
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pmodeType"/>
                              <td colspan="1" ><html:select property="txtPayModeType" alt="txtPayModeType" titleKey="Payroll.EmpInfo.pmodeType" styleClass="required" style="width:79%" >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                              <html:option value="ECS" > <bean:message key="Payroll.EmpInfo.ECS" /></html:option>
                              <html:option value="CTI" > <bean:message key="Payroll.EmpInfo.CTI" /></html:option>                              
                              </html:select>
                              </td>
                          </tr> 
                          
                          <tr>
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BankName" /></td>
                              <td width = "18%">
		                          <html:text  property="txtBankDesc" altKey="pay.EmpInfo.BankCode"  size="23" styleClass="locked" onchange="lfnChange(this.value);" maxlength="4" readonly="true" />
    							  <html:hidden property="txtBankCode" altKey="Payroll.EmpInfo.BankCode"  />                                                                                                 
                              </td>
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BranchCode" /></td>
                              <td width = "18%">
	                              <html:text  property="txtBranchDesc" altKey="pay.EmpInfo.BranchCode" size="23" styleClass="locked"  onchange="lfnChange(this.value);" maxlength="4" readonly="true" />
                                 <html:hidden property="txtBranchCode" altKey="Payroll.EmpInfo.BranchName"  /> 
                             </td>
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.acno" /></td>
                              <td><html:text  property="txtBankAccNo" styleClass = "locked" altKey="Payroll.EmpInfo.acno" maxlength="20" size="23" onchange="lfnChanged(this.value);"  readonly="true" /></td>
                          </tr>                                                              
                         
                          <TR>                              
                        <!--Added by dushyant on 26-April-2013 for Pay Status Changed Date-->
							 <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.pstchdate" /> </td> 
							  <td>                  
							  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">                       
								 <html:text  property="txtPayStsChnDate" styleClass = "required" altKey="Payroll.EmpInfo.pstchdate" maxlength="15" size="23" onchange="lfnChanged(this.value)" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" title="Calender" styleClass="lov" disabled="true" property="butTxtPayStsChnDate" alt="<%=(i-1) %>" />
						 
							  </logic:equal> 
							  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="N">
								<html:text  property="txtPayStsChnDate" styleClass = "required" altKey="Payroll.EmpInfo.pstchdate" maxlength="15" size="23" onchange="lfnChanged(this.value)" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" title="Calender" styleClass="lov" property="butTxtPayStsChnDate" alt="<%=(i-1) %>" onclick="showCalendar('txtPayStsChnDate',this)" />
								  </logic:notEqual><html:hidden  property="txtPayStatus" altKey="Payroll.EmpInfo.pstchdate"  />  
							  </td>
					  <!--Added by dushyant on 26-April-2013 for Pay Status Changed Date-->


                                                          
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.StrInc" /></td>
                              <td ><html:text  property="txtStagInc" styleClass = "optional" altKey="Payroll.EmpInfo.StrInc" maxlength="10" style="text-align:right"   size="23" onchange="lfnChangeNegNum(this.value);"  /></td>                                                                                                                        
                          
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.StagIncEffDate" /></td>
                              <td ><html:text  property="txtStagEffDate" styleClass = "optional" altKey="Payroll.EmpInfo.StagIncEffDate" maxlength="10"  size="23" onchange="checkStagDate(this.value); lfnChanged(this.value)" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="butTxtPayStsChnDate" alt="<%=(i-1) %>" onclick="showCalendar('txtStagEffDate',this)" /></td>                                                                                                                                                                                                                                               
                                   
                          </tr>
                          
                          <tr>
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.inrstat" /></td>
                              <td colspan="1" >
                              <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                              <html:select property="txtInrSt" alt="txtInrSt" titleKey="Payroll.EmpInfo.inrstat" styleClass="optional" disabled="true"  style="width:79%">
                              <html:option value="" > <bean:message key="Payroll.pleaseSelect" /></html:option>
                              <html:option value="R" > <bean:message key="Payroll.EmpInfo.rls" /></html:option>
                              <html:option value="S" > <bean:message key="Payroll.EmpInfo.stp" /></html:option>
                              </html:select>
                              </logic:equal>
                              <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                              <html:select property="txtInrSt" alt="txtInrSt" titleKey="Payroll.EmpInfo.inrstat" styleClass="required" style="width:79%" onchange="comboChange();"  >
                              <html:option value="" > <bean:message key="Payroll.pleaseSelect" /></html:option>
                              <html:option value="R" > <bean:message key="Payroll.EmpInfo.rls" /></html:option>
                              <html:option value="S" > <bean:message key="Payroll.EmpInfo.stp" /></html:option>
                              </html:select>
                              </logic:notEqual>
                              </td>
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.txtPanNo" /></td>
                              <td ><html:text  property="txtPanNo" styleClass = "required" altKey="Payroll.EmpInfo.txtPanNo" maxlength="18" onkeypress="
                               if((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122))
                               {}
                               else
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "style="text-align:Left" size="23" />
								 If PAN not applicable, click <html:button value='NA'  onclick="panNA()" property="butNA" styleClass="bottomBarText" />
								<html:button value='Clear' onclick="butClearPan()" property="butClr" styleClass="bottomBarText" />
								 </td>                            
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.Hra.city" /></td>
                              <td colspan="1">       
                              <html:text  property="txtCityTypeHra" altKey="pay.EmpInfo.Hra.city" maxlength="10" size="23" styleClass="locked" readonly="true" onchange="lfnChanged(this.value);"  />                                                                                                                                       
                              </td>
                                                            
                          </tr> 
                           <tr>
                            <td width="15%" class=labelText>MHS Member</td>
                              <td colspan="1">                                                                 
                              <html:select property="txtMHSTyp" name= "frmDeptLabourInfoForm"  alt="txtMHSTyp" styleClass="required" style="width:79%"  onchange="lfnChanged(this.value);"  >
                              <html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>      
                              <logic:present name="DeptLabourList">
                              <html:optionsCollection label="label" value="value" property="mhsTypList" name="DeptLabourList"/>
                              </logic:present>
                              </html:select>                              
                              </td>
                               <td class=labelText><bean:message key="Payroll.EmpInfo.FpsNo" /> </td>                
                            <td>
							<logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">
								<html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" onkeypress="
								 if((event.keyCode < 48 || event.keyCode > 57))
								  {
									return false;
								  };                            
										lfnChanged(this.value);
								   "  style="text-align:right"   /></td> 
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">
								<logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">
									<html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" onchange="checkFPSLength(this.value);" onkeypress="
									 if((event.keyCode < 48 || event.keyCode > 57))
									  {
										return false;
									  };                            
											lfnChanged(this.value);
									   "  style="text-align:right"   />
								</logic:equal>
								<logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="N">
									<logic:equal property= "txtEpsFlag" name= "frmDeptLabourInfoForm" value="Y">
										<html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" onchange="checkFPSLength(this.value);"  onkeypress="
										 if((event.keyCode < 48 || event.keyCode > 57))
										  {
											return false;
										  };                            
												lfnChanged(this.value);
										   "  style="text-align:right"   />
									</logic:equal>	
									<logic:notEqual property= "txtEpsFlag" name= "frmDeptLabourInfoForm" value="Y">
										<html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" onchange="checkFPSLength(this.value);" onclick="updateFPSno(this.value)" onkeypress="
										 if((event.keyCode < 48 || event.keyCode > 57))
										  {
											return false;
										  };                            
												lfnChanged(this.value);
										   "  style="text-align:right"   />
									</logic:notEqual>	
								</logic:notEqual>
							</logic:notEqual>
                           <td width="15%" class=labelText>EPS Payment</td>
                              <td colspan="1">                                                                 
                              <html:select property="txtEpsFlag" name= "frmDeptLabourInfoForm"  alt="txtEpsFlag" styleClass="optional" style="width:79%"  onchange="checkEpsFlag();lfnChanged(this.value);"  >
                               <html:option value="N" >No</html:option>
                              <html:option value="Y" >Yes</html:option>
                              <html:option value="P" >Previous</html:option>
                              </html:select>                              
                              </td> 
                        </tr>
                        
                        <tr>
                            <td class=labelText  >Entitlement Date </td>                
                            <td>
                            <html:text  property="txtEpsEntDt" styleClass = "optional" maxlength="10"  size="23" onchange="lfnChanged(this.value)" readonly="true"/>
                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butEpsEntDt" alt="<%=(i-1) %>" onclick="showCalendar('txtEpsEntDt',this)" />
                            </td> 
                                                 
                           <td width="15%" class=labelText>EPS Separation Reason</td>
                              <td colspan="1">                                                                 
                              <html:select property="txtEpsSepRsn" name= "frmDeptLabourInfoForm"  alt="txtMHSTyp" styleClass="locked" style="width:79%" disabled="true" onchange="lfnChanged(this.value);"  >
                              <html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>      
                              <logic:present name="DeptLabourList">
                              <html:optionsCollection label="label" value="value" property="epsSepTypList" name="DeptLabourList"/>
                              </logic:present>
                              </html:select>                              
                           </td>
                           <td class=labelText  >EPS Separation Date </td>                
                            <td>
                            <html:text  property="txtEpsSepDt" styleClass = "locked" maxlength="10"  size="23" onchange="lfnChanged(this.value)" readonly="true"/>
                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butEpsSepDt" alt="<%=(i-1) %>" onclick="showCalendar('txtEpsSepDt',this)" />
                            </td> 
                            </td> 
                          </tr>  
                        <tr><td class=labelText >Member Id(EPFO)</td>	
                            <td>
                                <html:text  property="txtMemberId" name= "frmDeptLabourInfoForm"  maxlength="30" styleClass="optional"  onkeypress=" lfnChanged(this.value);" style="text-align:right" />
                            </td> 
                            <td class=labelText  >Last Increment Date </td>                
                            <td colspan=5>
                            
                                    <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">

							<html:text  property="txtLastIncrDt" styleClass = "optional" maxlength="10"  size="23"  readonly="true" />
							
                                    </logic:equal>	  
							<logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="N">
                          
							<html:text  property="txtLastIncrDt" styleClass = "optional" maxlength="10"  size="23" onchange="lfnChanged(this.value)" />
                          
                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butLastIncrDt" alt="<%=(i-1) %>" onclick="showCalendar('txtLastIncrDt',this)" />
                            </logic:notEqual>
                          </td>
                           
                          </tr>
                          <tr>
                          <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.pohw" /> </td> 
                                <td colspan="1">                                                                 
                                    <html:select property="txtPohwFlag" name= "frmDeptLabourInfoForm"  alt="txtNpsFlag" styleClass="optional" style="width:79%"  onchange="lfnChanged(this.value);"  >
                                    <html:option value="N" >No</html:option>
                                    <html:option value="Y" >Yes</html:option>
                                    </html:select>                              
                                </td>
                                <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.pohw_eff_dt" /> </td> 

                                  <td> 
                                        <html:text  property="txtPohwEffDt" styleClass = "" altKey="Payroll.EmpInfo.pohw_eff_dt" maxlength="15" size="23" onchange="lfnChanged(this.value)" readonly="true"/> 
                                 
                                </td>
                                </tr>
                          <tr><td colspan=6>&nbsp;</td> </tr>                  
                          <tr height = 3><td></td></tr>                          
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
        <td>
        <jsp:include  page = "../INCLUDES/BottomBlueBar.jsp" flush="true" />
        </td>
      </TR>
  </TABLE> 
<!-- Container Table Ending Columns Starts-->
    </TD>    
</TR>
</TBODY>
</TABLE>
</div>
<!-- Container Table Ends -->
<html:hidden name="frmDeptLabourInfoForm"  property="screenName" value="MaintDeptLabourDetailScreen" />
<html:hidden name="frmDeptLabourInfoForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDeptLabourInfoForm" />
<html:hidden property="positionRequested" name="frmDeptLabourInfoForm" />
<html:hidden property="userPositionRequested" name="frmDeptLabourInfoForm"/>

<html:hidden property="buttonFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="lovKey" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtFields" name="frmDeptLabourInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmDeptLabourInfoForm" />
<html:hidden property="txtIndex" name="frmDeptLabourInfoForm"  />
<html:hidden property="loginLocCode" name="frmDeptLabourInfoForm" />
<html:hidden property="hdnStartBasic" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnEndBasic" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtInputField" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSubsAmt" name="frmDeptLabourInfoForm"  />

<html:hidden property="hdnHraFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnNpaFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnCantFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnWashFlag" name="frmDeptLabourInfoForm"  />   
<html:hidden property="hdnStationCompFlag" name="frmDeptLabourInfoForm"  />  
<html:hidden property="hdnCCAFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnPLIFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnConvFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnDustOpAllowFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnDepuFlag" name="frmDeptLabourInfoForm"  /> 
<html:hidden property="hdnDblHraFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtDblHraCity" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnAdvIncrFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtAdvIncrType" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtAdvIncrEffDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnSplCmpAllowFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplCmpAllowAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnSplPaySprtFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplPaySprtAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnSplPayCshAllowFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplPayCshAllowAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnPersPaySFNFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPersPaySFNAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnPersPayHQuaFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPersPayHQuaAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnBoardFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPersPaySFNEffFrom" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPersPaySFNEffTill" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplCmpAllowEffFrom" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplCmpAllowEffTill" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnSplDtyAllowFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplDtyAllowArea" name="frmDeptLabourInfoForm"  />		<!--added by swapnendu on 28 Feb 2011-->
<html:hidden property="txtSplDtyAllowEffFrom" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplDtyAllowEffFrom" name="frmDeptLabourInfoForm"  />

<html:hidden property="txtDOB" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtGender" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtMarStat" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtFatherNam" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHomTwn" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHandi" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHandiEffDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPrvPromDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtRetireDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHRAStat" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHRAEffDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="lstAccomType" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtLeaseAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtLicFeeDEM" name="frmDeptLabourInfoForm"  />

<html:hidden property="txtAddId" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPermAddL1" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPermAddL2" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPermCity" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPermState" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPermStateDesc" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPermCountry" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPermPin" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtTempAddL1" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtTempAddL2" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtTempCity" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtTempState" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtTempStateDesc" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtTempCountry" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtTempPin" name="frmDeptLabourInfoForm"  />

<html:hidden property="txtEmpNo" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtDivision" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPerPayHighQual" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtCasteCateg" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtHandiType" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtReligion" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtExsrvcman" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtAadharNum" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtUanNum" name="frmDeptLabourInfoForm"/>
<html:hidden property="payYYMM" name="frmDeptLabourInfoForm"  />

<input type="hidden" name="queryParam" />


<script language="javascript">

function ShowLovHraCityCode()
{
   frmDeptLabourInfoForm.lovKey.value = "PayrollEmpMastHraCityCode" + frmDeptLabourInfoForm.screenName.value + "U";
   frmDeptLabourInfoForm.txtDisplayFields.value = "txtCityTypeHra";
   frmDeptLabourInfoForm.txtSearchFields.value = "";
   frmDeptLabourInfoForm.txtIndex.value="";  
   frmDeptLabourInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
   frmDeptLabourInfoForm.headerDataChanged.value = "true";       
   return true;
}     

function ShowLovBankCode()
{
   frmDeptLabourInfoForm.lovKey.value = "DeptLabourBankCode" + frmDeptLabourInfoForm.screenName.value + "Q";
   frmDeptLabourInfoForm.txtDisplayFields.value = "txtBankDesc";
   frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.EmpInfo.BankName";
   frmDeptLabourInfoForm.txtIndex.value="";  
   frmDeptLabourInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
   frmDeptLabourInfoForm.headerDataChanged.value = "true";
   return true;
}

function ShowLovBranchCode()
{
   frmDeptLabourInfoForm.queryParam.value="txtBankCode="+ frmDeptLabourInfoForm.txtBankDesc.value +" " ;    
   frmDeptLabourInfoForm.lovKey.value = "DeptLabourBranchCode" + frmDeptLabourInfoForm.screenName.value + "Q";
   frmDeptLabourInfoForm.txtDisplayFields.value = "txtBranchCode,txtBranchDesc";
   frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.EmpInfo.BranchCode,Payroll.Common.desc";
   frmDeptLabourInfoForm.txtIndex.value="";  
   frmDeptLabourInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
   frmDeptLabourInfoForm.headerDataChanged.value = "true";
   return true;
}
    
function ShowLovPayScaleCode()
{
    frmDeptLabourInfoForm.lovKey.value = "PayrollEmpMastPayScaleCode" + frmDeptLabourInfoForm.screenName.value + "Q";
    frmDeptLabourInfoForm.txtDisplayFields.value = "txtGroupPayScale";
    frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.EmpInfo.pcode";
    frmDeptLabourInfoForm.txtIndex.value="";    
    frmDeptLabourInfoForm.txtInputField.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    frmDeptLabourInfoForm.headerDataChanged.value = "true";       
    return true;
}

function chkVldn()
{
    var selPayScaleTyp=frmDeptLabourInfoForm.txtPayType.value;
    var selCtgry=frmDeptLabourInfoForm.txtCateg.value;    
    if(selCtgry=='EMPCTGRY$I')
    {    
        frmDeptLabourInfoForm.parentZone.value=0;
        document.all.parentZone.disabled="true";
     }   
    else
    {
        //frmEmpFinInfoForm.parentZone.value="";
        document.all.parentZone.disabled="";
    }
    var selDsgnId=frmDeptLabourInfoForm.txtDsgnDesc.value;
    var selEmpStatus=frmDeptLabourInfoForm.txtEmpStatus.value;
    var payCodeArr = new Array();    
<%
    for(int i=0;i<arEmpVld.size();i++)
    {
      EmpFinVldnBean vdln=(EmpFinVldnBean)arEmpVld.get(i);
%>
      var payScaleTyp="<%=vdln.getStrPayScaleTyp()%>";
      var payCode=<%=vdln.getStrPayCode()%>;
      var ctgry="<%=vdln.getStrCtgry()%>";      
      var dsgnId="<%=vdln.getStrDsgnId()%>";
      var payCodeDesc="<%=vdln.getStrAllow()%>";
      var empStatus="<%=vdln.getStrEmpStatus()%>";
      
     if((payScaleTyp=="All") || (payScaleTyp==selPayScaleTyp))
     {
         if((dsgnId=="All") || (dsgnId==selDsgnId))
         {
            if((ctgry=="All") || (ctgry==selCtgry))
            {
              if((empStatus=="All") || (empStatus==selEmpStatus))
              {              
                payCodeArr.push(payCode);
              }
            }
         }
     }    
<%
    }
%> 
 setAllowFlag(payCodeArr);
}

function fillPayStatusChdDate()
{    
    var resFlag;
    if(document.all.screenMode.value!='N')
    {
      resFlag=confirm("This will change the pay staus change date. Are you sure you want to continue?");
    }
    else
    {
      resFlag=true;
    }
    if(resFlag==true)
    {    
      var d=new Date();        
      var curdate=d.getDate()+"/"+eval(d.getMonth()+1)+"/"+d.getYear();
      var strMon=eval(d.getMonth());
      var arrCal=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
      for(var i=0;i<arrCal.length;i++)
      {
        if(i==strMon)
        {        
          break;
        }
      }
      curdate=(d.getDate() < 10 ? '0' : '') + d.getDate()+"-"+arrCal[i]+"-"+d.getYear();        
      frmDeptLabourInfoForm.txtPayStsChnDate.value=curdate;  
    }
    else
    {
      if(frmDeptLabourInfoForm.txtPayStatus.value=='A')
      {
        frmDeptLabourInfoForm.txtPayStatus.value='I';
      }
      else
      {
        frmDeptLabourInfoForm.txtPayStatus.value='A';
      }
      return false;
    }
}

function checkFPSLength(val)
{
   var str='';
		  if(val.length == 1)
		  {
			  if(val==0)
			  {
				  alert(str + " FPS Number can not start with '0'");
			      document.all.txtFpsNo.value="";
				  event.srcElement.focus();
			  }
		  }
		  else
		  {
			  var val = val.substr(0,1);
			  if(val==0){
				  alert(str + " FPS Number can not start with '0'");
			      document.all.txtFpsNo.value="";
				  event.srcElement.focus();
			  }
		  }
 }


</script>

</html:form>
</body>
</html:html>