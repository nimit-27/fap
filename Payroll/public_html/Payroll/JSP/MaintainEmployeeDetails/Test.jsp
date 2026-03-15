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
      <script language="JavaScript1.2" src="../INCLUDES/EmpFlagInfo.js"></script>      
  </head>
<BODY  onload="lfnFlagLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintainEmpFinDetailBase" name="frmEmpFinInfoForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpFinInfoForm">
<bean:define id="ParentForm" name="frmEmpFinInfoForm" toScope="request" />
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
<jsp:include page="EmpHeaderInc.jsp" flush="true" />
    <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
          <TR height="200">
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
                    
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("AddressDet")> Address Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                        <TABLE cellSpacing=0 cellPadding=0>
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
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnWashFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectWash" onclick="lfnChange('1');" /></TD>                                              
                            </logic:notEqual>    
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnWashFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectWash" checked = "true" onclick="lfnChange('1');" /></TD>
                            </logic:equal> 
                            
                            <td width = 3%>
                            
                            <TD width = 15% class=labelText>NPA</td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnNpaFlag" value = "Y"  > 
                            <td width = 5%><input type="checkbox" Id="selectNpa" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnNpaFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectNpa" checked = "true" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:equal>    
                            
                            <td width = 3%>
                            
                            <TD width = 15% class=labelText>Lunch Subsidy</td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnCantFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCant" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:notEqual>                          
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnCantFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCant" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                            </logic:equal>             
                            
                            <td width = 3%>
                            
                            <TD width = 15% class=labelText><bean:message  key="Payroll.EmpInfo.Cca" /></td>                                                                                           
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnCCAFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCCAFlag" onclick="onclickCheck('selectCCAFlag',document.all.hdnCCAFlag);" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnCCAFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCCAFlag" checked = "true" disabled="true" /></TD>                                                               
                            </logic:equal>                              
                            
                            <td width = 3%>         
                        </tr>    
                        <TR>
                            <td width = 1%>
                                                      
                            <TD width = 15% class=labelText>Station Compensatory Allowance</td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnStationCompFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectStationComp" onclick="onclickCheck('selectStationComp',document.all.hdnStationCompFlag);" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnStationCompFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectStationComp" checked = "true" disabled="true" /></TD>                                                               
                            </logic:equal>
                            
                            <td width = 3%>

                            <TD width = 15% class=labelText>Dusting Operator Allowance</td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDustOpAllowFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectDustOpAllow" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDustOpAllowFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectDustOpAllow" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                            </logic:equal>          
                            
                            <td width = 3%>
                            
                            <TD width = 15% class=labelText>Productivity Link Incentive</td>                             
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPLIFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectPLI" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPLIFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectPLI" checked = "true"  onclick="lfnChange('1');" /></TD>                                                               
                            </logic:equal>    
                            
                            <td width = 3%>   
                            
                            <TD width = 15% class=labelText><bean:message  key="Payroll.EmpInfo.ConvFlg" /></td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnConvFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectConvFlag" onclick="onclickCheck('selectConvFlag',document.all.hdnConvFlag);" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnConvFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectConvFlag" checked = "true" onclick="onclickCheck('selectConvFlag',document.all.hdnConvFlag);"  /></TD>                                                               
                            </logic:equal>    
                            
                            <td width = 3%>
                        </tr>                         
              
                        <TR>
                            <TD colspan=17 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
                        </tr> 
                        
                        <TR>                            
                          <td width="100%" colspan=17>
                            <TABLE width="100%" cellpadding=0 cellspacing=0 border=0>
                              <tr>                               
                                  <td width="1%" ></td>
                                        
                                  <TD  class=labelText align = "left"  width="23%" >Double HRA&nbsp;                                                                                   
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <input type="checkbox" name="selectDblHraFlag" onclick="cmnFlagTxtImgDisab('selectDblHraFlag','txtDblHraCity'); " />                                                               
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <input type="checkbox" name="selectDblHraFlag" checked = "true" onclick="cmnFlagTxtImgDisab('selectDblHraFlag','txtDblHraCity');"  />                                                             
                                  </logic:equal>    
                                  </td>
                                  
                                  <td class=labelText width="27%" >Double HRA City
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <html:text  property="txtDblHraCity" styleClass = "locked" readonly="true" size="18"  onchange="lfnChange(this.value)"  />
                                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDblHraCity" id="buttxtDblHraCity" onclick="return ShowLovHraCityCode();">                                
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <html:text  property="txtDblHraCity" styleClass = "required" readonly="true"  size="18"  onchange="lfnChange(this.value)"  />                                                           
                                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDblHraCity" id="buttxtDblHraCity" onclick="return ShowLovHraCityCode();">                                
                                  </logic:equal>   
                                  </td>
                                  
                                  <td width="2%"></td>                                
                                  
                                  <TD  class=labelText  >Special Pay for Sportsmanship&nbsp;                          
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplPaySprt" onclick="cmnFlagTxtDisab('selectSplPaySprt','txtSplPaySprtAmt'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplPaySprt" checked = "true" onclick="cmnFlagTxtDisab('selectSplPaySprt','txtSplPaySprtAmt'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText >Sportsmanship Amount(Rs.)&nbsp;
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <html:text  property="txtSplPaySprtAmt" styleClass = "locked" size="6" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <html:text  property="txtSplPaySprtAmt" styleClass ="required" maxlength="8" size="6"  onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td>                                                                        
                              </tr>
                              <tr>         
                                  <td width="1%" ></td>
                                  
                                  <TD  class=labelText  >Special Pay As Cash Allow. &nbsp;                            
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplPayCshAllow" onclick="cmnFlagTxtDisab('selectSplPayCshAllow','txtSplPayCshAllowAmt'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplPayCshAllow" checked = "true" onclick="cmnFlagTxtDisab('selectSplPayCshAllow','txtSplPayCshAllowAmt'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText >&nbsp;&nbsp;Cash Allow. Amount(Rs.)&nbsp;
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplPayCshAllowAmt" styleClass = "locked"  size="6" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplPayCshAllowAmt" styleClass = "required" size="6"  maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td>       
                                  
                                  <td width="2%"></td>
                                  
                                  <TD  class=labelText  >Personal Pay For SFN &nbsp;                            
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPaySFN" onclick="cmnFlagTxtDisab('selectPersPaySFN','txtPersPaySFNAmt'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPaySFN" checked = "true" onclick="cmnFlagTxtDisab('selectPersPaySFN','txtPersPaySFNAmt'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText >Personal Pay Amount(Rs.)&nbsp;                            
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNAmt" styleClass = "locked" size="6" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNAmt" styleClass = "required" size="6" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td>                                     
                              </tr>                             
                              
                               <tr>         
                                  <td width="1%" ></td>
                                  
                                  <TD  class=labelText  >Spl. Comp. Allow. &nbsp;                             
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplCmpAllow" onclick="cmnFlagTxtDisab('selectSplCmpAllow','txtSplCmpAllowAmt'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplCmpAllow" checked = "true" onclick="cmnFlagTxtDisab('selectSplCmpAllow','txtSplCmpAllowAmt'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td> 
                                  
                                  <td class=labelText >Allow. Type &nbsp;                                  
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <html:select property="txtSplCmpAllowAmt" alt="txtSplCmpAllowAmt" styleClass="optional" style='width:56%' disabled="true" onchange="comboChange();"  >
                                  <html:option value="" >-----------Please Select-----------</html:option>      
                                  <logic:present name="Categories">
                                  <html:optionsCollection label="label" value="value" property="valueSplCompArrayList" name="Categories"/>
                                  </logic:present>
                                  </html:select>
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <html:select property="txtSplCmpAllowAmt" alt="txtSplCmpAllowAmt" styleClass="required" style='size:56%'  onchange="comboChange();"  >
                                  <html:option value="" >-----------Please Select-----------</html:option>      
                                  <logic:present name="Categories">
                                  <html:optionsCollection label="label" value="value" property="valueSplCompArrayList" name="Categories"/>
                                  </logic:present>
                                  </html:select>
                                  </logic:equal>
                                  </td>
                                
                                                                   
                                  <td width="2%"></td>
                                  
                                  <TD  class=labelText  >Personal Pay For Higher Qual. &nbsp;                             
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPayHQua" onclick="cmnFlagTxtDisab('selectPersPayHQua','txtPersPayHQuaAmt'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPayHQua" checked = "true" onclick="cmnFlagTxtDisab('selectPersPayHQua','txtPersPayHQuaAmt'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText >Higher Qual. Amount(Rs.)&nbsp;
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHQuaAmt" styleClass = "locked" size="6" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHQuaAmt" styleClass = "required" size="6" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
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
<html:hidden name="frmEmpFinInfoForm"  property="screenName" value="MaintainEmpFinDetailScreen" />
<html:hidden name="frmEmpFinInfoForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpFinInfoForm" />
<html:hidden property="positionRequested" name="frmEmpFinInfoForm" />
<html:hidden property="userPositionRequested" name="frmEmpFinInfoForm" />
<html:hidden property="newPositionRequested" name="frmEmpFinInfoForm"  />
<html:hidden property="buttonFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="lovKey" name="frmEmpFinInfoForm"  />
<html:hidden property="txtFields" name="frmEmpFinInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpFinInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpFinInfoForm"  />
<html:hidden property="txtIndex" name="frmEmpFinInfoForm"  />
<html:hidden property="loginLocCode" name="frmEmpFinInfoForm" />
<html:hidden property="hdnBoardFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="txtInputField" name="frmEmpFinInfoForm"  />

<html:hidden property="txtPayType" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPayScaleCode" name="frmEmpFinInfoForm"  />
<html:hidden property="txtCurtBasic" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPayStatus" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPayMode" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPayModeType" name="frmEmpFinInfoForm"  />
<html:hidden property="txtBankCode" name="frmEmpFinInfoForm"  />
<html:hidden property="txtBankDesc" name="frmEmpFinInfoForm"  />
<html:hidden property="txtBranchCode" name="frmEmpFinInfoForm"  />
<html:hidden property="txtBranchDesc" name="frmEmpFinInfoForm"  />
<html:hidden property="txtBankAccNo" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPayStsChnDate" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPerPayHighQual" name="frmEmpFinInfoForm"  />
<html:hidden property="txtInrSt" name="frmEmpFinInfoForm"  />
<html:hidden property="txtStagInc" name="frmEmpFinInfoForm"  />
<html:hidden property="txtStagEffDate" name="frmEmpFinInfoForm"  />
<html:hidden property="txtSubsAmt" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPanNo" name="frmEmpFinInfoForm"  />
<html:hidden property="txtLicFeeDEM" name="frmEmpFinInfoForm"  />
<html:hidden property="txtCityTypeHra" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnStartBasic" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnEndBasic" name="frmEmpFinInfoForm"  />

<html:hidden property="txtDOB" name="frmEmpFinInfoForm"  />
<html:hidden property="txtGender" name="frmEmpFinInfoForm"  />
<html:hidden property="txtMarStat" name="frmEmpFinInfoForm"  />
<html:hidden property="txtFatherNam" name="frmEmpFinInfoForm"  />
<html:hidden property="txtHomTwn" name="frmEmpFinInfoForm"  />
<html:hidden property="txtHandi" name="frmEmpFinInfoForm"  />
<html:hidden property="txtHandiEffDate" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPrvPromDate" name="frmEmpFinInfoForm"  />
<html:hidden property="txtRetireDate" name="frmEmpFinInfoForm"  />
<html:hidden property="txtHRAStat" name="frmEmpFinInfoForm"  />
<html:hidden property="txtHRAEffDate" name="frmEmpFinInfoForm"  />
<html:hidden property="lstAccomType" name="frmEmpFinInfoForm"  />
<html:hidden property="txtLeaseAmt" name="frmEmpFinInfoForm"  />

<html:hidden property="hdnHraFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnNpaFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnCantFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnWashFlag" name="frmEmpFinInfoForm"  />   
<html:hidden property="hdnStationCompFlag" name="frmEmpFinInfoForm"  />  
<html:hidden property="hdnCCAFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnPLIFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnConvFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnDustOpAllowFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnDepuFlag" name="frmEmpFinInfoForm"  /> 
<html:hidden property="hdnDblHraFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="txtDblHraCity" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnAdvIncrFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="txtAdvIncrType" name="frmEmpFinInfoForm"  />
<html:hidden property="txtAdvIncrEffDate" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnSplCmpAllowFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="txtSplCmpAllowAmt" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnSplPaySprtFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="txtSplPaySprtAmt" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnSplPayCshAllowFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="txtSplPayCshAllowAmt" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnPersPaySFNFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPersPaySFNAmt" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnPersPayHQuaFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPersPayHQuaAmt" name="frmEmpFinInfoForm"  />

<html:hidden property="txtAddId" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPermAddL1" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPermAddL2" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPermCity" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPermState" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPermStateDesc" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPermCountry" name="frmEmpFinInfoForm"  />
<html:hidden property="txtPermPin" name="frmEmpFinInfoForm"  />
<html:hidden property="txtTempAddL1" name="frmEmpFinInfoForm"  />
<html:hidden property="txtTempAddL2" name="frmEmpFinInfoForm"  />
<html:hidden property="txtTempCity" name="frmEmpFinInfoForm"  />
<html:hidden property="txtTempState" name="frmEmpFinInfoForm"  />
<html:hidden property="txtTempStateDesc" name="frmEmpFinInfoForm"  />
<html:hidden property="txtTempCountry" name="frmEmpFinInfoForm"  />
<html:hidden property="txtTempPin" name="frmEmpFinInfoForm"  />

<input type="hidden" name="queryParam" />
<script language="javascript">

function ShowLovPayScaleCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastPayScaleCode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtGroupPayScale";
    frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.pcode";
    frmEmpFinInfoForm.txtIndex.value="";       
    frmEmpFinInfoForm.txtInputField.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    frmEmpFinInfoForm.headerDataChanged.value = "true";       
    return true;
} 

function ShowLovCityCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastCityCode" + frmEmpFinInfoForm.screenName.value + "U";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtCityType";
    frmEmpFinInfoForm.txtSearchFields.value = "";
    frmEmpFinInfoForm.txtInputField.value =""; 
    frmEmpFinInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    frmEmpFinInfoForm.headerDataChanged.value = "true";       
    return true;
}

function ShowLovHraCityCode()
{   
    if(frmEmpFinInfoForm.selectDblHraFlag.checked)
    {
        frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastHraCityCode" + frmEmpFinInfoForm.screenName.value + "U";
        frmEmpFinInfoForm.txtDisplayFields.value = "txtDblHraCity";
        frmEmpFinInfoForm.txtSearchFields.value = "";
        frmEmpFinInfoForm.txtIndex.value=""; 
        frmEmpFinInfoForm.txtInputField.value =""; 
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
        frmEmpFinInfoForm.headerDataChanged.value = "true";       
        return true;
    }
    else
    {
       return false;
    }   
} 

function chkVldn()
{
    var selPayScaleTyp=frmEmpFinInfoForm.txtPayType.value;
    var selCtgry=frmEmpFinInfoForm.txtCateg.value;
    var selDsgnId=frmEmpFinInfoForm.txtDsgnDesc.value;
    var selEmpStatus=frmEmpFinInfoForm.txtEmpStatus.value;
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
    var flagArr=['114','122','174','184']; 
    var flagHdnArr=["hdnWashFlag","hdnNpaFlag","hdnCantFlag","hdnDustOpAllowFlag"]; 
    var ctrlArr=["selectWash","selectNpa","selectCant","selectDustOpAllow"]; 
    var i,j;    
    for(i=0; i < flagArr.length; i++)
    {
        for(j=0; j < payCodeArr.length; j++)
        {          
           if (flagArr[i] == payCodeArr[j]) 
           {
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
    //alert("hdnWashFlag---"+frmEmpFinInfoForm.hdnWashFlag.value);
    //alert("hdnNpaFlag---"+frmEmpFinInfoForm.hdnNpaFlag.value);
    //alert("hdnCantFlag---"+frmEmpFinInfoForm.hdnCantFlag.value);
    //alert("hdnDustOpAllowFlag---"+frmEmpFinInfoForm.hdnDustOpAllowFlag.value);   
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
    
 