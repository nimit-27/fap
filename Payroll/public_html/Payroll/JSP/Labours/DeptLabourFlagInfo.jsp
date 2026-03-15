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
      <script language="JavaScript1.2" src="../INCLUDES/DeptLabourFlagInfo.js"></script>      
  </head>
<BODY  onload="lfnFlagLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintDeptLabourDetailBase" name="frmDeptLabourInfoForm" type="FCIPAY.Payroll.WEBTIER.Form.DeptLabourInfoForm">
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
    <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
          <TR>
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
              <TABLE cellSpacing=0 cellPadding=0 border = 0>
                <TR>          
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("PayDet")> Payroll Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > Payroll Flag Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("HrDet")> HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                                                           
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="63%">&nbsp;</td>
                    
               </tr> 
               
            <tr height="10"><td class=userText colspan="17"></td></tr>            
            <TR height=10>
 <!-- Detail table Container starts -->
                <TD colspan=17>
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD>
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=1>
                          <TBODY>                                
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
    <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellSpacing=0 cellPadding=0 >
        <TR>
          <TD class=subHeader colspan=11> Eligibility</TD>
        </TR>   
        <TR>
          <TD colspan=11 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
        </tr>             
        <TR height=20>
 <!-- Detail table Container starts -->
          <TD colspan=11>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
                <TR>
                  <TD >
                    <!-- Detail table starts -->
                    <TABLE cellSpacing=0 cellPadding=0 border=0 >
                      <TBODY>
                        <TR>
                            <td width = 1%>  
                            
                            <TD width = 15% class=labelText>Washing Allowance</td>
                            <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnWashFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectWash" onclick="lfnChange('1');" /></TD>                                              
                            </logic:notEqual>    
                            <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnWashFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectWash" checked = "true" onclick="lfnChange('1');" /></TD>
                            </logic:equal> 
                            
                            <td width = 3%>
                            
                            <TD width = 15% class=labelText>Productivity Link Incentive</td>                             
                            <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnPLIFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectPLI" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnPLIFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectPLI" checked = "true"  onclick="lfnChange('1');" /></TD>                                                               
                            </logic:equal>      
                            
                            <td width = 3%>
                            
                            <TD width = 15% class=labelText>Lunch Subsidy</td>
                            <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnCantFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCant" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:notEqual>                          
                            <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnCantFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCant" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                            </logic:equal>             
                            
                            <td width = 3%>
                            
                            <TD width = 15% class=labelText><bean:message  key="Payroll.EmpInfo.Cca" /></td>                                                                                           
                            <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnCCAFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCCAFlag" onclick="onclickCheck('selectCCAFlag',document.all.hdnCCAFlag);" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnCCAFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCCAFlag" checked = "true" disabled="true" /></TD>                                                               
                            </logic:equal>                              
                            
                            <td width = 3%>         
                        </tr>    
                        <TR>
                            <td width = 1%>
                            
                            <TD width = 15% class=labelText>Station Compensatory Allowance</td>
                            <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnStationCompFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectStationComp" onclick="onclickCheck('selectStationComp',document.all.hdnStationCompFlag);" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnStationCompFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectStationComp" checked = "true" disabled="true" /></TD>                                                               
                            </logic:equal>
                            
                            <td width = 3%>
                            
                            <TD width = 15% class=labelText><bean:message  key="Payroll.EmpInfo.ConvFlg" /></td>
                            <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnConvFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectConvFlag" onclick="onclickCheck('selectConvFlag',document.all.hdnConvFlag);" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnConvFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectConvFlag" checked = "true" onclick="onclickCheck('selectConvFlag',document.all.hdnConvFlag);"  /></TD>                                                               
                            </logic:equal>    
                            
                            
                        </tr> 
                        
                        <TR>
                            <TD colspan=17 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
                        </tr>
                        
                        <TR>                            
                          <td width="100%" colspan=17>
                            <TABLE width="100%" cellpadding=0 cellspacing=0 border=0>
                              <tr>
                                  <td width="1%"></td>
                                  
                                  <TD  class=labelText width = 17% >Personal Pay For SFN &nbsp;</td>                            
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <td width = 2%><input type="checkbox" name="selectPersPaySFN" onclick="cmnFlagTxtDisab('selectPersPaySFN','txtPersPaySFNAmt,txtPersPaySFNEffFrom,txtPersPaySFNEffTill,butTxtPersPaySFNEffFrom,butTxtPersPaySFNEffTill'); lfnChange('1');" /></td>                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <td width = 2%><input type="checkbox" name="selectPersPaySFN" checked = "true" onclick="cmnFlagTxtDisab('selectPersPaySFN','txtPersPaySFNAmt,txtPersPaySFNEffFrom,txtPersPaySFNEffTill,butTxtPersPaySFNEffFrom,butTxtPersPaySFNEffTill'); lfnChange('1');" /></td>                                                           
                                  </logic:equal>   
                                  
                                  
                                  <td class=labelText width = 30% >Personal Pay Amount(Rs.)&nbsp;                            
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNAmt" styleClass = "locked" size="6" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNAmt" styleClass = "required" size="6" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td>   
                                  
                                  <td class=labelText colspan="3">Effective From
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPaySFNEffFrom" disabled="true" onclick="showCalendar('txtPersPaySFNEffFrom',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPaySFNEffFrom" onclick="showCalendar('txtPersPaySFNEffFrom',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText colspan="3" >Effective Till
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNEffTill" styleClass = "locked" readonly="true" size="18"  onchange="lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPaySFNEffTill" disabled="true" onclick="showCalendar('txtPersPaySFNEffTill',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPaySFNEffTill" onclick="showCalendar('txtPersPaySFNEffTill',this)" alt="-1" />
                                  </logic:equal>   
                                  </td> 
                                  
                                 </tr>
                                  <tr>
                                  <td width="1%"></td>
                                  
                                  <TD  class=labelText  width = 17%>Spl. Comp. Allow. &nbsp;</td>                             
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <td><input type="checkbox" name="selectSplCmpAllow" onclick="cmnFlagTxtDisab('selectSplCmpAllow','txtSplCmpAllowAmt,txtSplCmpAllowEffFrom,txtSplCmpAllowEffTill,butTxtSplCmpAllowEffFrom,butTxtSplCmpAllowEffTill'); lfnChange('1');" /></td>                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <td><input type="checkbox" name="selectSplCmpAllow" checked = "true" onclick="cmnFlagTxtDisab('selectSplCmpAllow','txtSplCmpAllowAmt,txtSplCmpAllowEffFrom,txtSplCmpAllowEffTill,butTxtSplCmpAllowEffFrom,butTxtSplCmpAllowEffTill'); lfnChange('1');" /></td>                                                           
                                  </logic:equal>   
                                   
                                  
                                  <td class=labelText width = 30%>Allow. Type &nbsp;                                  
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <html:select property="txtSplCmpAllowAmt" alt="txtSplCmpAllowAmt" styleClass="optional" style='width:45%' disabled="true" onchange="comboChange();"  >
                                  <html:option value="" >-------Please Select------</html:option>      
                                  <logic:present name="DeptLabourList">
                                  <html:optionsCollection label="label" value="value" property="valueSplCompArrayList" name="DeptLabourList"/>
                                  </logic:present>
                                  </html:select>
                                  </logic:notEqual> 
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <html:select property="txtSplCmpAllowAmt" alt="txtSplCmpAllowAmt" styleClass="required" style='size:56%'  onchange="comboChange();"  >
                                  <html:option value="" >-----------Please Select-----------</html:option>      
                                  <logic:present name="DeptLabourList">
                                  <html:optionsCollection label="label" value="value" property="valueSplCompArrayList" name="DeptLabourList"/>
                                  </logic:present>
                                  </html:select>
                                  </logic:equal>
                                  </td>
                                  
                                  <td class=labelText colspan="3">Effective From
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplCmpAllowEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplCmpAllowEffFrom" disabled="true" onclick="showCalendar('txtSplCmpAllowEffFrom',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplCmpAllowEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplCmpAllowEffFrom" onclick="showCalendar('txtSplCmpAllowEffFrom',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText colspan="3" >Effective Till
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplCmpAllowEffTill" styleClass = "locked" readonly="true" size="18"  onchange="lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplCmpAllowEffTill" disabled="true" onclick="showCalendar('txtSplCmpAllowEffTill',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplCmpAllowEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplCmpAllowEffTill" onclick="showCalendar('txtSplCmpAllowEffTill',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>   
                                </tr>
                                <tr>
                                  <td width="1%"></td>
                                  
                                  <TD  class=labelText  width = 17%>Spl. Duty. Allow. &nbsp;</td>                             
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <td>
								  <!--input type="checkbox" name="selectSplDtyAllow" onclick="cmnFlagTxtDisab('selectSplDtyAllow','txtSplDtyAllowEffFrom,txtSplDtyAllowEffTill,butTxtSplDtyAllowEffFrom,butTxtSplDtyAllowEffTill'); lfnChange('1');" /--><!--commented by devendra on 22 sept 2010-->
								  <input type="checkbox" name="selectSplDtyAllow" onclick="cmnFlagTxtDisab('selectSplDtyAllow','txtSplDtyAllowArea,txtSplDtyAllowEffFrom,txtSplDtyAllowEffTill,butTxtSplDtyAllowEffFrom,butTxtSplDtyAllowEffTill'); lfnChange('1');" /><!--added by devendra on 22 sept 2010-->
								  </td>                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <td>
								  <!--input type="checkbox" name="selectSplDtyAllow" checked = "true" onclick="cmnFlagTxtDisab('selectSplDtyAllow','txtSplDtyAllowEffFrom,txtSplDtyAllowEffTill,butTxtSplDtyAllowEffFrom,butTxtSplDtyAllowEffTill'); lfnChange('1');" /--><!--commented by devendra on 22 sept 2010-->
								  <input type="checkbox" name="selectSplDtyAllow" checked = "true" onclick="cmnFlagTxtDisab('selectSplDtyAllow','txtSplDtyAllowArea,txtSplDtyAllowEffFrom,txtSplDtyAllowEffTill,butTxtSplDtyAllowEffFrom,butTxtSplDtyAllowEffTill'); lfnChange('1');" /><!--added by devendra on 22 sept 2010-->
								  </td>                                                           
                                  </logic:equal>   
                                  <!--added by devendra on 22 sept 2010 start-->	
									
									<td class=labelText colspan="3" >Area Type &nbsp; 
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:select property="txtSplDtyAllowArea" alt="txtSplDtyAllowArea" styleClass="optional" style='width:60%' disabled="true" onchange="comboChange();"  >
                                  <html:option value="" >------Please Select------</html:option>      
                                  <logic:present name="DeptLabourList">
                                  <html:optionsCollection label="label" value="value" property="splDtyAreaList" name="DeptLabourList"/>
                                  </logic:present>
                                  </html:select>
                                  </logic:notEqual> 
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:select property="txtSplDtyAllowArea" alt="txtSplDtyAllowArea" styleClass="required" style='width:60%'  onchange="comboChange();"  >
                                  <html:option value="" >------Please Select------</html:option>      
                                  <logic:present name="DeptLabourList">
                                  <html:optionsCollection label="label" value="value" property="splDtyAreaList" name="DeptLabourList"/>
                                  </logic:present>
                                  </html:select>
                                  </logic:equal>
                                  </td>
                                  <!--added by devendra on 22 sept 2010 end-->
                                  
                                  <td class=labelText >Effective From
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplDtyAllowEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplDtyAllowEffFrom" disabled="true" onclick="showCalendar('txtSplDtyAllowEffFrom',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplDtyAllowEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplDtyAllowEffFrom" onclick="showCalendar('txtSplDtyAllowEffFrom',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText colspan="3" >Effective Till
                                  <logic:notEqual name= "frmDeptLabourInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplDtyAllowEffTill" styleClass = "locked" readonly="true" size="18"  onchange="lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplDtyAllowEffTill" disabled="true" onclick="showCalendar('txtSplDtyAllowEffTill',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmDeptLabourInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplDtyAllowEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplDtyAllowEffTill" onclick="showCalendar('txtSplDtyAllowEffTill',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>   
                                </tr> 
                              </TABLE>
                            </TD>
                          </TR>                         
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
<html:hidden property="userPositionRequested" name="frmDeptLabourInfoForm" />
<html:hidden property="buttonFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="lovKey" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtFields" name="frmDeptLabourInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtIndex" name="frmDeptLabourInfoForm"  />
<html:hidden property="loginLocCode" name="frmDeptLabourInfoForm" />
<html:hidden property="hdnBoardFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtInputField" name="frmDeptLabourInfoForm"  />

<html:hidden property="txtPayType" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayScaleCode" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtCurtBasic" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayStatus" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayMode" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayModeType" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBankCode" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBankDesc" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBranchCode" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBranchDesc" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBankAccNo" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayStsChnDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPerPayHighQual" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtInrSt" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtStagInc" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtStagEffDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSubsAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPanNo" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtLicFeeDEM" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtCityTypeHra" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnStartBasic" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnEndBasic" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtMHSTyp" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtFpsNo" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtEpsFlag" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtEpsSepRsn" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtEpsEntDt" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtEpsSepDt" name="frmDeptLabourInfoForm"/>


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
<html:hidden property="txtSplDtyAllowArea" name="frmDeptLabourInfoForm"  />  <!--added by swapnendu Dt 03-FEB-2011-->
<html:hidden property="txtSplPaySprtAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnSplPayCshAllowFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplPayCshAllowAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnPersPaySFNFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPersPaySFNAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnPersPayHQuaFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPersPayHQuaAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnSplDtyAllowFlag" name="frmDeptLabourInfoForm"  />

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
<html:hidden property="txtCasteCateg" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtHandiType" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtReligion" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtExsrvcman" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtAadharNum" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtUanNum" name="frmDeptLabourInfoForm"/>
<input type="hidden" name="queryParam" />
<script language="javascript">

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

function ShowLovCityCode()
{
    frmDeptLabourInfoForm.lovKey.value = "PayrollEmpMastCityCode" + frmDeptLabourInfoForm.screenName.value + "U";
    frmDeptLabourInfoForm.txtDisplayFields.value = "txtCityType";
    frmDeptLabourInfoForm.txtSearchFields.value = "";
    frmDeptLabourInfoForm.txtInputField.value =""; 
    frmDeptLabourInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    frmDeptLabourInfoForm.headerDataChanged.value = "true";       
    return true;
}

function ShowLovHraCityCode()
{   
    if(frmDeptLabourInfoForm.selectDblHraFlag.checked)
    {
        frmDeptLabourInfoForm.lovKey.value = "PayrollEmpMastHraCityCode" + frmDeptLabourInfoForm.screenName.value + "U";
        frmDeptLabourInfoForm.txtDisplayFields.value = "txtDblHraCity";
        frmDeptLabourInfoForm.txtSearchFields.value = "";
        frmDeptLabourInfoForm.txtIndex.value=""; 
        frmDeptLabourInfoForm.txtInputField.value =""; 
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
        frmDeptLabourInfoForm.headerDataChanged.value = "true";       
        return true;
    }
    else
    {
       return false;
    }   
} 

function chkVldn()
{
    var selPayScaleTyp=frmDeptLabourInfoForm.txtPayType.value;
    var selCtgry=frmDeptLabourInfoForm.txtCateg.value;
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
 alert("array--"+payCodeArr);
 setAllowFlag(payCodeArr);
}

function setAllowFlag(payCodeArr)
{
   alert('inside setAllowFlag in deptlabourflaginfo.jsp....' )
   // var flagArr=['114','122','174','184']; 
   // var flagHdnArr=["hdnWashFlag","hdnNpaFlag","hdnCantFlag","hdnDustOpAllowFlag"]; 
  //  var ctrlArr=["selectWash","selectNpa","selectCant","selectDustOpAllow"]; 
  //  Added by Balpreet dt 26 May 2008 for Stn Cmp Allow- dt 3 July 2008 for Trnasport allow  
    var flagArr=['114','122','174','184','161','166']; 
    var flagHdnArr=["hdnWashFlag","hdnNpaFlag","hdnCantFlag","hdnDustOpAllowFlag","hdnStationCompFlag","hdnConvFlag"];
    var ctrlArr=["selectWash","selectNpa","selectCant","selectDustOpAllow","selectStationComp","selectConvFlag"]; 
    var i,j;    
    for(i=0; i < flagArr.length; i++)
    {
        for(j=0; j < payCodeArr.length; j++)
        {          
           if (flagArr[i] == payCodeArr[j]) 
           {
              //alert('flagArr[]==='+flagArr[i]);
			  alert('setting value for '+ document.getElementById(flagHdnArr[i])+'  as Y');
              document.getElementById(flagHdnArr[i]).value='Y';                            
              document.getElementById(ctrlArr[i]).checked="true";
              
              break;
           }
        }
        
        if(j==payCodeArr.length)    
        {        
            document.getElementById(flagHdnArr[i]).value='N';            
            document.getElementById(ctrlArr[i]).checked="";            
        }
    }
    //alert("hdnWashFlag---"+frmDeptLabourInfoForm.hdnWashFlag.value);
    //alert("hdnNpaFlag---"+frmDeptLabourInfoForm.hdnNpaFlag.value);
    //alert("hdnCantFlag---"+frmDeptLabourInfoForm.hdnCantFlag.value);
    //alert("hdnDustOpAllowFlag---"+frmDeptLabourInfoForm.hdnDustOpAllowFlag.value);   
}  

function onclickCheck(checkFlag,hdnFlag)
{
    lfnChange('1');       
    if (document.getElementById(checkFlag).checked==true)
    {
        hdnFlag.value="Y";                
    }  
    else 
    {        
        hdnFlag.value="N";      
    }
}

</script>
</html:form>
</body>
</html:html>
    
 