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
    <script language="JavaScript1.2" src="../INCLUDES/DeptLabourHrmsInfo.js"></script>          
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>      
</head>
<BODY  onload="lfnHrLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
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
 	 <TR >
      <TD colspan=6>
      <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellSpacing=0 cellPadding=0 border = 0>               
            <TR>
              <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("PayDet")> Payroll Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
              
              <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("FlagDet")> Payroll Flag Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
              
              <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td bgcolor="#4682B4" nowrap class=actTabText > HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                            
              <td background="../INCLUDES/IMAGES/line_t.gif" width="63%">&nbsp;</td>
              
              
              
          </tr> 
          <tr height="10"><td class=userText colspan="14"></td></tr>            
          <TR height=10>
 <!-- Detail table Container starts -->
            <TD colspan=14>
              <TABLE cellSpacing=0 cellPadding=0 border=0>
                <TBODY>
                  <TR>
                    <TD >
  			<!-- Detail table starts -->
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>                            
                          <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.dob" /> </td>            
                          <td width="18%">
                          <html:text  property="txtDOB" maxlength="10" size="23" titleKey="Payroll.EmpInfo.dob" styleClass="required" readonly="true" onchange="cmpDOBSysDate(this.value); lfnChanged(this.value);" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDOB" alt="<%=(i-1) %>" onclick="showCalendar('txtDOB',this)" />
                          </td>

                          <td  width="16%" class=labelText><bean:message key="Payroll.EmpInfo.Gender" /></td>
                          <td width="18%" colspan="1" ><html:select  property="txtGender" titleKey="Payroll.EmpInfo.Gender" styleClass = "required" style="width:81%" onchange="checkGenPrefix(this.value);" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="M" > <bean:message key="Payroll.EmpInfo.Male" /></html:option>
                          <html:option value="F" > <bean:message key="Payroll.EmpInfo.Female" /></html:option>                               
                          </html:select>
                          </td>
                          
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.MariSta" /></td>
                          <td colspan="1" ><html:select  property="txtMarStat" titleKey="Payroll.EmpInfo.MariSta" styleClass = "optional" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="M" > <bean:message key="Payroll.EmpInfo.Married" /></html:option>
                          <html:option value="S" > <bean:message key="Payroll.EmpInfo.Single" /></html:option>                               
                          </html:select>
                          </td>
                    </tr> 

                    <tr>
                    <td  width="15%" class="labelText" >
                         <logic:equal property= "txtFathHusflag" name= "frmDeptLabourInfoForm" value="H">
					                <input type="radio" name="radioFathHus" value="F" onclick="FathHusFlag(this.value)"  > FATHER NAME
                         <input type="radio" name="radioFathHus" value="H" onclick="FathHusFlag(this.value)" checked="checked"  >HUSBAND NAME
					          </logic:equal>
                    
                        <logic:notEqual property= "txtFathHusflag" name= "frmDeptLabourInfoForm" value="H">
					                <input type="radio" name="radioFathHus" value="F" onclick="FathHusFlag(this.value)" checked="checked"  > FATHER NAME
                         <input type="radio" name="radioFathHus" value="H" onclick="FathHusFlag(this.value)"  >HUSBAND NAME
					          </logic:notEqual>
                    
                         </td>
                         
                        <td ><html:text  property="txtFatherNam" alt="<%=String.valueOf(i) %>" maxlength="25" size="23" titleKey="Payroll.EmpInfo.FatherNam" styleClass="optional" onkeypress="                            
                        if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                          {}
                          else
                          {
                              //alert('Invalid Input' );               
                              //this.select();                                 
                              return false;                            
                          };                             
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="upper(this);" /></td>                                                                                                                        
                        
                        <td width="13%" class=labelText><bean:message key="Payroll.EmpInfo.HomTwn" /></td>
                        <td ><html:text  property="txtHomTwn" styleClass = "optional" alt="<%=String.valueOf(i) %>" maxlength="25" size="23" onkeypress="
                        if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                          {}
                          else
                          {
                              //alert('Invalid Input' );               
                              //this.select();                                 
                              return false;                            
                          };                             
                          lfnChanged(this.value);"  style="text-align:left"  /></td>                              
                       
                        <td  width="13%" class=labelText><bean:message key="Payroll.EmpInfo.handi" /></td>
                        <td colspan="1" ><html:select  property="txtHandi" styleClass = "optional" style="width:80%" onchange="comboChange(); checkHandicap();" >                           
                        <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>                               
                        <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                        </html:select>
                        </td>
                    </tr>

                    <TR>
                        <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.handiEffDate" /> </td>            
                        <td>
                        <html:text  property="txtHandiEffDate"  maxlength="10" size="23" styleClass="Optional" onchange="checkHandicapDate(this.value); lfnChanged(this.value);" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtHandiEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtHandiEffDate',this)" />
                        </td>
                        
                        <td width="13%" class=labelText  ><bean:message key="Payroll.EmpInfo.PrvPromdate" /> </td>            
                        <td>
                        <html:text  property="txtPrvPromDate"  maxlength="10" size="23" styleClass="optional" onchange="checkPrevPromDate(this.value); lfnChanged(this.value);" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtPrvPromDate" alt="<%=(i-1) %>" onclick="showCalendar('txtPrvPromDate',this)" />
                        </td>
                        
                        <td width="13%" class=labelText  ><bean:message key="Payroll.EmpInfo.Retdate" /> </td>            
                        <td>
                        <html:text  property="txtRetireDate"  maxlength="10" size="22" styleClass="optional" onchange="lfnChanged(this.value);" readonly="true"/>
                        </td>                                         
                    </tr>                                 
                                              
                    <TR>                   
                       
                    <!--    <td width="13%" class=labelText  ><bean:message key="Payroll.EmpInfo.Hra.EffDate" /> </td>            
                        <td>
                        <html:text  property="txtHRAEffDate"  maxlength="10" size="23" styleClass="required" onchange="checkHRAEffDate(this.value); lfnChanged(this.value);" readonly="true" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtHRAEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtHRAEffDate',this)" />
                        </td> 
                        
                         <td  width="15%" class=labelText></td>
                        <td colspan="1" >
                        <html:hidden  property="txtHRAStat" titleKey="Payroll.EmpInfo.Hra.Status" />                             
                        
                        </td> -->
                        <html:hidden  property="txtHRAStat" />
                        <html:hidden  property="txtHRAEffDate" />
                    </tr> 
                     
                     <tr><td colspan=6>&nbsp;</td> </tr>
                     <tr><td colspan=6>&nbsp;</td> </tr>
                    
                     <!-- addition By swati -->
                           <TR>                            
                         <td  width="16%" class=labelText><bean:message key="Payroll.EmpInfo.casteCateg" /></td>
                          <td width="18%" colspan="1" >
                          <logic:equal property= "txtCasteCateg" name= "frmDeptLabourInfoForm" value="">
                          <html:select  property="txtCasteCateg" titleKey="Payroll.EmpInfo.casteCateg" styleClass = "required" style="width:81%"onchange="comboChange(); " >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>   
                          <logic:present name="DeptLabourList">
                              <html:optionsCollection label="label" value="value" property="valueCasteCategList" name="DeptLabourList"/>
                              </logic:present>
                          
                          </html:select>
                          </logic:equal>
                          
                        <logic:notEqual property= "txtCasteCateg" name= "frmDeptLabourInfoForm" value="">
                          <html:select  property="txtCasteCateg" titleKey="Payroll.EmpInfo.casteCateg" styleClass = "locked" disabled="true" style="width:81%"onchange="comboChange(); " >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>   
                          <logic:present name="DeptLabourList">
                              <html:optionsCollection label="label" value="value" property="valueCasteCategList" name="DeptLabourList"/>
                              </logic:present>
                          
                          </html:select>
                          </logic:notEqual>
                          
                          
                          </td>
                          
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.phtype" /></td>
                          <td colspan="1" >
                          <logic:equal property= "txtHandi" name= "frmDeptLabourInfoForm" value="Y">
                          <logic:equal property= "txtHandiType" name= "frmDeptLabourInfoForm" value="">
                          <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                        
                          <logic:present name="DeptLabourList">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="DeptLabourList"/>
                              </logic:present>

                          </html:select>
                          </logic:equal>
                          <logic:notEqual property= "txtHandiType" name= "frmDeptLabourInfoForm" value="">
                          <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "locked" disabled="true" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                        
                          <logic:present name="DeptLabourList">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="DeptLabourList"/>
                              </logic:present>

                          </html:select>
                          </logic:notEqual>
                          
                           </logic:equal>
                          
                          <logic:notEqual property= "txtHandi" name= "frmDeptLabourInfoForm" value="Y">
                          <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "locked" disabled="true" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                        
                          <logic:present name="DeptLabourList">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="DeptLabourList"/>
                              </logic:present>

                          </html:select>
                          </logic:notEqual>
                          
                          </td>
                          
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.rel" /></td>
                          <td colspan="1" >
                          <logic:equal property= "txtReligion" name= "frmDeptLabourInfoForm" value="">
                          <html:select  property="txtReligion" titleKey="Payroll.EmpInfo.rel" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                            <logic:present name="DeptLabourList">
                               <html:optionsCollection label="label" value="value" property="valueReligionList" name="DeptLabourList"/>
                             </logic:present>

                          </html:select>
                          </logic:equal>
                          
                          <logic:notEqual property= "txtReligion" name= "frmDeptLabourInfoForm" value="">
                          <html:select  property="txtReligion" titleKey="Payroll.EmpInfo.rel" styleClass = "locked" disabled="true" style="width:80%"  >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                            <logic:present name="DeptLabourList">
                               <html:optionsCollection label="label" value="value" property="valueReligionList" name="DeptLabourList"/>
                             </logic:present>

                          </html:select>
                          </logic:notEqual>
                          
                    </tr>
                    
                     <TR>                            
                         
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.exsrvc" /></td>
                          <td colspan="1" >
                          <logic:equal property= "txtExsrvcman" name= "frmDeptLabourInfoForm" value="">
                          <html:select  property="txtExsrvcman" titleKey="Payroll.EmpInfo.exsrvc" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                          <html:option value="N" > <bean:message key="Payroll.EmpInfo.No" /></html:option>   
                                                      
                          </html:select>
                          </logic:equal>
                          
                           <logic:notEqual property= "txtExsrvcman" name= "frmDeptLabourInfoForm" value="">
                          <html:select  property="txtExsrvcman" titleKey="Payroll.EmpInfo.exsrvc" disabled="true" styleClass="locked" style="width:80%"  >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                          <html:option value="N" > <bean:message key="Payroll.EmpInfo.No" /></html:option>   
                                                      
                          </html:select>
                          </logic:notEqual>
                         
                          
                          </td>
                          
                        <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.aadhar" /></td>
                        <td >
                        <logic:equal property= "txtAadharNum" name= "frmDeptLabourInfoForm" value="">
                        <html:text  property="txtAadharNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.aadhar" styleClass="optional" onkeypress="                            
                           if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                          
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkAadharNum(this.value);" />
                     </logic:equal>
                     <logic:notEqual property= "txtAadharNum" name= "frmDeptLabourInfoForm" value=""> 
                        <html:text  property="txtAadharNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.aadhar" readonly="true" styleClass="locked" style="text-align:left" />
                     </logic:notEqual>
                        </td> 
                     
                     <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.uan" /></td>
                        <td >
                        <logic:equal property= "txtUanNum" name= "frmDeptLabourInfoForm" value=""> 
                        <html:text  property="txtUanNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.uan" styleClass="optional" onkeypress="                            
                           if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                           
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkUANum(this.value);" />
                        </logic:equal>
                     
                     <logic:notEqual property= "txtUanNum" name= "frmDeptLabourInfoForm" value=""> 
                        <html:text  property="txtUanNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.uan" readonly="true" styleClass="locked" style="text-align:left" />
                     </logic:notEqual>
                     
                     </td>   
                    </tr>
                  
                  
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
<html:hidden property="userPositionRequested" name="frmDeptLabourInfoForm" />
<html:hidden property="buttonFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="lovKey" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtFields" name="frmDeptLabourInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtIndex" name="frmDeptLabourInfoForm"  />
<html:hidden property="loginLocCode" name="frmDeptLabourInfoForm" />
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
<html:hidden property="txtCityTypeHra" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnStartBasic" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnEndBasic" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtMHSTyp" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtFpsNo" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtEpsFlag" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtEpsSepRsn" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtEpsEntDt" name="frmDeptLabourInfoForm"/>
<html:hidden property="txtEpsSepDt" name="frmDeptLabourInfoForm"/>

<html:hidden property="selectHraFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnHraFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="selectNpa" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnNpaFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="selectCant" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnCantFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="selectWash" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnWashFlag" name="frmDeptLabourInfoForm"  /> 
<html:hidden property="selectStationComp" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnStationCompFlag" name="frmDeptLabourInfoForm"  />  
<html:hidden property="selectCCAFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnCCAFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnPLIFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="selectNpa" name="frmDeptLabourInfoForm"  />
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
<html:hidden property="txtSplDtyAllowEffFrom" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplDtyAllowEffFrom" name="frmDeptLabourInfoForm"  />

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
<html:hidden property="payYYMM" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtFathHusflag" name="frmDeptLabourInfoForm"  /> 
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">



function FathHusFlag(name)

{
//alert ("in function");
 frmDeptLabourInfoForm.txtFathHusflag.value = name;
//alert (frmDeptLabourInfoForm.txtFathHusflag.value);
return success;
}
function ShowLovBankCode()
{
    frmDeptLabourInfoForm.lovKey.value = "PayrollEmpMastBankCode" + frmDeptLabourInfoForm.screenName.value + "Q";
    frmDeptLabourInfoForm.txtDisplayFields.value = "txtBankCode";
    frmDeptLabourInfoForm.txtSearchFields.value = "";
    frmDeptLabourInfoForm.txtIndex.value="";  
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
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    frmDeptLabourInfoForm.headerDataChanged.value = "true";       
    return true;
} 

function ShowLovBranchCode()
{
    frmDeptLabourInfoForm.queryParam.value ="txtBankCode="+ frmDeptLabourInfoForm.txtBankCode.value +" " ;    
    frmDeptLabourInfoForm.lovKey.value = "PayrollEmpMastBranchCode" + frmDeptLabourInfoForm.screenName.value + "Q";
    frmDeptLabourInfoForm.txtDisplayFields.value = "txtBranchCode";
    frmDeptLabourInfoForm.txtSearchFields.value = "";
    frmDeptLabourInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
    return true;
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
            alert(that.value);
            return true;
        }
    }
}
    
</script>