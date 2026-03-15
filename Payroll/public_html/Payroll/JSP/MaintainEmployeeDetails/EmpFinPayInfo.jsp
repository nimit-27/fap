<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
  

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>  

</head>

<BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
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


<table>
<TR height=30>
  <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE FINANCIAL INFORMATION</TD>
</TR>
<tr height="10"><td class=userText colspan="11"></td></tr>
</TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD colspan = 12>
	

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
                 <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left"><html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="26" styleClass="required" />
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" >
                 </logic:equal>                                                                    
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                 </logic:equal>                                                                                                 
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                 </logic:equal>                                                                                                                   
                  &nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="32" styleClass="locked" readonly="true" />                 
                  </td>
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.lstGroup" /></td>
                  <td>
                  <html:text  property="txtGroup" altKey="pay.EmpInfo.lstGroup" maxlength="10" size="23" styleClass="optional" />
                  </td>                                                      
                </TR> 

                <TR>                            
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>
                  <td>
                    <html:select property="lstCateg" alt="Type" styleClass="required" >
                      <html:option value="" >-----------Please Select-----------</html:option>      
                      <logic:present name="Categories">
                        <html:optionsCollection label="label" value="value" property="valueCategArrayList" name="Categories"/>
                      </logic:present>
                    </html:select>                 
                   
                  </td>
                  <TD class=labelText  ><bean:message key="Payroll.EmpInfo.txtDesig" /></TD>
                  <td align="left">
                    <html:text  property="txtDsgn" altKey="pay.EmpInfo.txtDsgnDesc" maxlength="10" size="23" styleClass="required" />
                    <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig"  onclick="return ShowLovDsgn();">
                   </logic:equal>                                                                                                 
                    <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" >
                   </logic:notEqual>                                                                     
                   <html:hidden  property="txtDsgnDesc" altKey="pay.EmpInfo.txtDesig"  />                   
                   
                  </td> 
                </tr> 
          
            <tr height="15" >
            <td colspan="6"></td>
            </tr>
                                 
         </table>
         
    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
            <TABLE cellSpacing=0 cellPadding=0 >
             
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>Payroll Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
             </TR>


           
            <tr height="10"><td class=userText colspan="11"></td></tr>            
            <TR height=10>
 <!-- Detail table Container starts -->
                <TD colspan=11>
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                      <TD >
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0>
                          <TBODY>
                                
                          <TR>                            
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.Emptype" /></td>
                              <td colspan="1" >
                              <html:select property="txtEmpType" alt="txtEmpType" styleClass="required" style="width:92%" onchange="comboChange();" >
                               <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                               <html:option value="R" > <bean:message key="Payroll.EmpInfo.reg" /></html:option>
                               <html:option value="D" > <bean:message key="Payroll.EmpInfo.dep" /></html:option>
                               <html:option value="C" > <bean:message key="Payroll.EmpInfo.con" /></html:option>
                               </html:select>
                              </td>
  

                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pscalemode" /></td>
                              <td colspan="1" ><html:select  property="txtPayScaleMode" styleClass = "required" alt="txtPayScaleMode" style="width:90%" onchange="comboChange();" >                             
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                               <html:option value="O" > <bean:message key="Payroll.EmpInfo.old" /></html:option>
                               <html:option value="N" > <bean:message key="Payroll.EmpInfo.new" /></html:option>
                               
                               </html:select>
                              </td>


                              <td width="15%" class=labelText ><bean:message key="Payroll.EmpInfo.pcode" /></td>
                              <td>
                            
                              <html:select property="lstPayScale" alt="Type" styleClass="required" onchange="comboChange();" >
                                <html:option value="" >-----------Please Select-----------</html:option>      
                                <logic:present name="Categories">
                                  <html:optionsCollection label="label" value="value" property="valueGroupPayScale" name="Categories"/>
                                </logic:present>
                              </html:select>
                                                   
                              </td>   
                              



<!--                          <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.ptype" /></td>
                              <td colspan="1" ><html:select  property="txtPayType" styleClass = "required" alt="txtPayType" style="width:83%" onchange="comboChange();"  >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                               <html:option value="IDA" > <bean:message key="Payroll.EmpInfo.ida" /></html:option>
                               <html:option value="CDA" > <bean:message key="Payroll.EmpInfo.cda" /></html:option>
                               
                               </html:select>
                               </td>  -->
                          </tr> 
                         <TR>                         
                              <td width="15%" class=labelText ><bean:message key="Payroll.EmpInfo.SplAllowType" /></td>
                              <td>                            
                              <html:select property="txtSplAllowType" alt="txtSplAllowType" styleClass="required" style="width:92%" onchange="comboChange();"  >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                               <html:option value="SAE" > <bean:message key="Payroll.EmpInfo.sae" /></html:option>
                               <html:option value="SAC" > <bean:message key="Payroll.EmpInfo.sac" /></html:option>
                               <html:option value="SAI" > <bean:message key="Payroll.EmpInfo.sai" /></html:option>
                               <html:option value="OTH" > <bean:message key="Payroll.EmpInfo.oth" /></html:option>                                                              
                               </html:select>                                                   
                              </td>                            

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.splpay" /></td>
                              <td ><html:text  property="txtSplPay" altKey="Payroll.EmpInfo.splpay" maxlength="6" size="26" styleClass="optional" onchange="lfnChange(this.value);"  style="text-align:right"   /></td>

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.perpay" /></td>
                              <td ><html:text  property="txtPerPay" styleClass = "optional" altKey="Payroll.EmpInfo.perpay" maxlength="10" size="26" onchange="lfnChange(this.value);"  style="text-align:right"  /></td>                              
                          </tr> 
                      
	                       <TR>

<!--                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.curbas" /></td>
                              <td ><html:text  property="txtCurtBasic" styleClass = "required" altKey="Payroll.EmpInfo.curbas" maxlength="10" size="26" onchange="lfnChange(this.value);"  /></td>  -->
                                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.oldbas" /></td>
                              <td ><html:text  property="txtOldBasic" styleClass = "required" altKey="Payroll.EmpInfo.oldbas" maxlength="10" size="26" onchange="lfnChange(this.value);"   style="text-align:right" /></td>                              

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.child" /></td>
                              <td ><html:text  property="txtChild" styleClass = "optional" altKey="Payroll.EmpInfo.child" maxlength="1" size="26" onchange="lfnChange(this.value);"  style="text-align:right"  /></td>                                                             

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.fpa" /></td>
                              <td ><html:text  property="txtPlanAmt" styleClass = "optional" altKey="Payroll.EmpInfo.fpa"  size="26" onchange="lfnChange(this.value);" maxlength = "6" style="text-align:right" /></td>
                                                            
                          </tr> 
                            <TR>                            
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pmode" /></td>
                              <td colspan="1" ><html:select property="txtPayMode" alt="txtPayMode" styleClass="required" style="width:92%" onchange="comboChange();checkPayMode(); " >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
<!--                               <html:option value="Q" > <bean:message key="Payroll.EmpInfo.chq" /></html:option>  -->
                               <html:option value="B" > <bean:message key="Payroll.EmpInfo.bank" /></html:option>
                               <html:option value="C" > <bean:message key="Payroll.EmpInfo.cash" /></html:option>
                               <html:option value="Q" > <bean:message key="Payroll.EmpInfo.oth" /></html:option>                                
                               
                               </html:select>
                               </td>


                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pmodeType"/>
                              <td colspan="1" ><html:select property="txtPayModeType" alt="txtPayModeType" styleClass="required" style="width:92%" onchange="comboChange();" >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                               <html:option value="ECT" > <bean:message key="Payroll.EmpInfo.ECT" /></html:option>
                               <html:option value="DD" > <bean:message key="Payroll.EmpInfo.DD" /></html:option>
                               <html:option value="CTI" > <bean:message key="Payroll.EmpInfo.CTI" /></html:option>
                               <html:option value="CTB" > <bean:message key="Payroll.EmpInfo.CTB" /></html:option>                                                              
                               </html:select>
                               </td>

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.Arrpromdate" /></td>
                              <td ><html:text  property="txtArrPromDate" styleClass = "optional" altKey="Payroll.EmpInfo.Arrpromdate" maxlength="15" size="23"   /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="butTxtArrPromDate" alt="<%=(i-1) %>" onclick="showCalendar('txtArrPromDate',this)" /></td>                              


<!--                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.city" /></td>
                             <td colspan="1">       
                              <html:select property="txtCityType" alt="txtCityType" styleClass="required"  style="width:83%" onchange="comboChange();">
                                  <html:option value="" >-----------Please Select-----------</html:option>      
                                  <logic:present name="Categories">
                                    <html:optionsCollection label="label" value="value" property="cityList" name="Categories"/>
                                  </logic:present>
                                </html:select>
                              </td>  -->
                                

                              
                          </tr> 


                         <TR>                            
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.promdate" /></td>
                              <td ><html:text  property="txtlstPromDate" styleClass = "optional" readonly = "true" altKey="Payroll.EmpInfo.promdate" maxlength="15" size="23"   /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="butTxtlstPromDate" alt="<%=(i-1) %>" onclick="" /></td>
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.inrmon" /></td>
                              <td ><html:text  property="txtInrMon" altKey="Payroll.EmpInfo.inrmon" maxlength="2" size="26" styleClass="required" onchange="lfnChange(this.value);"  style="text-align:right"   /></td>

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.inrstat" /></td>
                              <td colspan="1" ><html:select property="txtInrSt" alt="txtInrSt" styleClass="required" style="width:83%" onchange="comboChange();"  >
                               <html:option value="" > <bean:message key="Payroll.pleaseSelect" /></html:option>
                               <html:option value="R" > <bean:message key="Payroll.EmpInfo.rls" /></html:option>
                               <html:option value="S" > <bean:message key="Payroll.EmpInfo.stp" /></html:option>
                               
                                
                               </html:select>
                               </td>
 
                          </tr> 
                      
	                       <TR>
                            
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.psatat" /></td>
                              <td colspan="1" ><html:select property="txtPayStatus" alt="txtPayStatus" styleClass="required" style="width:92%" onchange="comboChange();" >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                               <html:option value="A" > <bean:message key="Payroll.EmpInfo.act" /></html:option>
                               <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>
                               <html:option value="S" > <bean:message key="Payroll.EmpInfo.sus" /></html:option>
                               <html:option value="L" > <bean:message key="Payroll.EmpInfo.lop" /></html:option>                                
                               </html:select>
                               </td>
             
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pstchdate" /></td>
                              <td ><html:text  property="txtPayStsChnDate" styleClass = "optional" altKey="Payroll.EmpInfo.pstchdate" maxlength="15" size="23"    /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="butTxtPayStsChnDate" alt="<%=(i-1) %>" onclick="showCalendar('txtPayStsChnDate',this)" /></td>

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.StrInc" /></td>
                              <td ><html:text  property="txtStrInc" styleClass = "optional" altKey="Payroll.EmpInfo.StrInc" maxlength="10" size="26" onchange="comboChange();"  style="text-align:right"   /></td>                              
                              
                          </tr> 
<!--                            <TR>
                            
                             <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.npa" /></td>
                              <td ><html:text  property="txtNPAAmt" styleClass = "optional" altKey="Payroll.EmpInfo.npa"  size="26"  onchange="lfnChange(this.value);"   /></td> 
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.fpa" /></td>
                              <td ><html:text  property="txtPlanAmt" styleClass = "optional" altKey="Payroll.EmpInfo.fpa"  size="26" onchange="lfnChange(this.value);"   /></td>
                             <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.suball" /></td>
                              <td ><html:text  property="txtSubAllow" styleClass = "required" altKey="Payroll.EmpInfo.suball" maxlength="10" size="26" onchange="perCheck(this.value);"   /> %</td>  
                                                            
                          </tr>   -->

                          <TR>
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.ntSftHrs" /></td>
                              <td ><html:text  property="txtNiteSftHrs" styleClass = "optional" maxlength = "3" altKey="Payroll.EmpInfo.npa"  size="26"  onchange="lfnChange(this.value);"  style="text-align:right"  /></td>                                                          
                              
                            <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.handi" /></td>
                              <td colspan="1" >

                              <html:text property="txtHandi" readonly = "true" styleClass = "optional" size="26" />

<!--                              <html:select  property="txtHandi" styleClass = "optional" alt="txtHandi"  disabled = "true" style="width:89%" onchange="comboChange();"  >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                               <html:option value="B" >Blindness/LowVision </html:option>
                               <html:option value="H" > Hearing Impairment</html:option>
                               <html:option value="L" > Locomotor Disability</html:option>                               
                               </html:select>  -->

                               
                               </td>   

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.StateCode" /></td>
                              <td>
                              <html:text  property="txtStateCode" altKey="pay.EmpInfo.StateCode" maxlength="10" size="23" styleClass="optional" />
                              <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">                              
                                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovStateCode();">
                             </logic:equal>                                                                    
                              <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">                              
                                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovStateCode();">
                             </logic:equal>                                                                                                 
                              <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState" > 
                             </logic:equal>                                                                             
                             <html:hidden  property="txtStateCodeDesc" altKey="pay.EmpInfo.StateCode" />                                                          
                              </td>
                      </tr>

                           <tr>                                  

                           
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PF" /></td>
                              <td colspan="1" ><html:select  property="txtPF" styleClass = "optional" alt="txtPF" style="width:82%" onchange="comboChange();"  >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                               <html:option value="CP" >CPF </html:option>
                               <html:option value="GP" > GPF</html:option>
                               <html:option value="EP" > EPF</html:option>
                               <html:option value="EN" > ENCPF</html:option>                               1
                               </html:select>
                               </td>   

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.SubsAmt" /></td>
                              <td ><html:text  property="txtSubsAmt" styleClass = "optional" altKey="Payroll.EmpInfo.SubsAmt" maxlength="10" style="text-align:right"   size="26" onchange="lfnChange(this.value);"  /></td>
                          </tr> 

<!--                           <tr>                                  
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.AbsIncrRate" /></td>
                              <td>
                              <html:text  property="txtAbsIncrRate" style="text-align:right" styleClass = "optional" altKey="Payroll.EmpInfo.SubsAmt" maxlength="10" size="26" onchange="lfnChange(this.value);"  /> 
                              </td>   

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.NoOfIncr" /></td>
                              <td ><html:text  property="txtNoOfIncr" styleClass = "optional" altKey="Payroll.EmpInfo.SubsAmt" maxlength="10" style="text-align:right"   size="26" onchange="lfnChange(this.value);"  /></td> 
                          </tr>            -->


<!--       <tr>

          <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BankCode" /></td>
          <td width = "18%">
          <html:text  property="txtBankCode" altKey="pay.EmpInfo.BankCode" maxlength="10" size="23" styleClass="optional" />
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBank"  onclick="return ShowLovBankCode();">
         </logic:equal>                                                                    
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">                              
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBank"  onclick="return ShowLovBankCode();">
         </logic:equal>                                                                                                 
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBank" > 
         </logic:equal>                                                                             
          </td>

          <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BranchCode" /></td>
          <td>
          <html:text  property="txtBranchCode" altKey="pay.EmpInfo.BranchCode" maxlength="10" size="23" styleClass="optional" />
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBranch"  onclick="return ShowLovBranchCode();">
         </logic:equal>                                                                    
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">                              
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBranch"  onclick="return ShowLovBranchCode();">
         </logic:equal>                                                                                                 
         <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBranch" > 
         </logic:equal>                                                                             
         </td>
         <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.acno" /></td>
         <td ><html:text  property="txtBank" styleClass = "optional" altKey="Payroll.EmpInfo.acno" maxlength="10" size="26" onchange="comboChange();"   /></td>                    
         </tr>  -->

                          <tr height = 3><td></td></tr>
                          
         
              <tr>
              <TD colspan=11 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
              </tr> 

                          <tr height = 3><td></td></tr>
         

            <tr>
            
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.ptype" /></td>
                              <td colspan="1" ><html:select  property="txtPayType" styleClass = "required" alt="txtPayType" style="width:83%" onchange="comboChange();"  >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                               <html:option value="IDA" > <bean:message key="Payroll.EmpInfo.ida" /></html:option>
                               <html:option value="CDA" > <bean:message key="Payroll.EmpInfo.cda" /></html:option>
                               
                               </html:select>
                               </td>

                             <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.curbas" /></td>
                              <td ><html:text  property="txtCurtBasic" styleClass = "required" altKey="Payroll.EmpInfo.curbas" maxlength="10" size="26" onchange="lfnChange(this.value);" style="text-align:right" /></td>


                             <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.city" /></td>
                             <td colspan="1">       
                              <html:select property="txtCityType" alt="txtCityType" styleClass="required"  style="width:83%" onchange="comboChange();">
                                  <html:option value="" >-----------Please Select-----------</html:option>      
                                  <logic:present name="Categories">
                                    <html:optionsCollection label="label" value="value" property="cityList" name="Categories"/>
                                  </logic:present>
                                </html:select>
                              </td>                              
                                
                          </tr> 


                            <TR>
                            
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.suball" /></td>
                              <td ><html:text  property="txtSubAllow" styleClass = "required" style="text-align:right"  altKey="Payroll.EmpInfo.suball" maxlength="10" size="26" onchange="perCheck(this.value);"   /> %</td>

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.AbsIncrRate" /></td>
                              <td>
                              <html:text  property="txtAbsIncrRate" style="text-align:right" styleClass = "optional" altKey="Payroll.EmpInfo.SubsAmt" maxlength="3" size="26" onchange="lfnChange(this.value);"  /> 
                              </td>   

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.NoOfIncr" /></td>
                              <td ><html:text  property="txtNoOfIncr" styleClass = "optional" altKey="Payroll.EmpInfo.SubsAmt" style="text-align:right"   size="26" onchange="lfnChange(this.value);"  maxlength="2" /></td> 
                              
                                                            
                          </tr> 


        <tr>

          <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BankCode" /></td>
          <td width = "18%">
          <html:text  property="txtBankCode" altKey="pay.EmpInfo.BankCode"  size="23" styleClass="optional" onchange="lfnChange(this.value);" maxlength="5"  />
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBank"  onclick="return ShowLovBankCode();">
         </logic:equal>                                                                    
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">                              
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBank"  onclick="return ShowLovBankCode();">
         </logic:equal>                                                                                                 
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBank" > 
         </logic:equal>                                                                             
          </td>

          <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BranchCode" /></td>
          <td>
          <html:text  property="txtBranchCode" altKey="pay.EmpInfo.BranchCode" size="23" styleClass="optional"  onchange="lfnChange(this.value);" maxlength="5"  />
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBranch"  onclick="return ShowLovBranchCode();">
         </logic:equal>                                                                    
          <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">                              
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBranch"  onclick="return ShowLovBranchCode();">
         </logic:equal>                                                                                                 
         <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBranch" > 
         </logic:equal>                                                                             
         </td>
         <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.acno" /></td>
         <td ><html:text  property="txtBank" styleClass = "optional" altKey="Payroll.EmpInfo.acno" maxlength="10" size="26" onchange="comboChange();"   /></td>                    
         </tr>


                              <tr>        
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.npa" /></td>
                              <td ><html:text  property="txtNPAAmt" styleClass = "optional" altKey="Payroll.EmpInfo.npa"  size="26"  onchange="lfnChange(this.value);"  style="text-align:right"  /></td>
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
                      <TD width = 15% class=labelText>HRR Lease </td>

                               <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnHrrFlag" value = "Y"  > 
                                   <td width = 5%><input type="checkbox" name="selectHrr" onclick="lfnChange('1');" /></TD>                                                               
                               </logic:notEqual>    
                        
                               <logic:equal name= "frmEmpFinInfoForm"  property = "hdnHrrFlag" value = "Y" > 
                                 <td width = 5%><input type="checkbox" name="selectHrr" checked = "true" onclick="lfnChange('1');" /></TD>                                                               
                               </logic:equal>    

                    <td width = 5%>
                    <TD width = 15% class=labelText>Board Vehicle </td>

                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnBoardFlag" value = "Y" > 
                             <td width = 5%><input type="checkbox" name="selectVeh" onclick="lfnChange('1');" /></TD>                                                               
                           </logic:notEqual>    
                        
                           <logic:equal name= "frmEmpFinInfoForm"  property = "hdnBoardFlag" value = "Y" > 
                               <td width = 5%><input type="checkbox" name="selectVeh" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                           </logic:equal>    
         
                    <td width = 5%>
                    <TD width = 15% class=labelText>Deputation Allowance</td>
                                                                                           
                       
                           <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDepuFlag" value = "Y" > 
                             <td width = 5%><input type="checkbox" name="selectDep" onclick="DepuFlag(); lfnChange('1');" /></TD>                                              
                           </logic:notEqual>    
                           <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDepuFlag" value = "Y" > 
                             <td width = 5%><input type="checkbox" name="selectDep" checked = "true" onclick="DepuFlag(); lfnChange('1');" /></TD>
                           </logic:equal>    
         

                    <td width = 5%>
                    <TD width = 15% class=labelText>Out Station </td>
                             
                          <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDepuFlag" value = "Y" > 
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnOutFlag" value = "Y" > 
                             <td width = 5%><input type="checkbox" name="selectOut" disabled="true" onclick="lfnChange('1');" /></TD>
                           </logic:notEqual>    
                           <logic:equal name= "frmEmpFinInfoForm"  property = "hdnOutFlag" value = "Y" > 
                             <td width = 5%><input type="checkbox" name="selectOut" disabled="true" onclick="lfnChange('1');"  /></TD>
                           </logic:equal>    
                         </logic:notEqual>    
                          <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDepuFlag" value = "Y" > 
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnOutFlag" value = "Y" > 
                             <td width = 5%><input type="checkbox" name="selectOut" onclick="lfnChange('1');" /></TD>
                           </logic:notEqual>    
                           <logic:equal name= "frmEmpFinInfoForm"  property = "hdnOutFlag" value = "Y" > 
                             <td width = 5%><input type="checkbox" name="selectOut" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                           </logic:equal>    
                         </logic:equal>    
                        
                    <td width = 4%>
         
                </tr>    
                         

                          <TR>

                             <td width = 1%>
                             <TD width = 15% class=labelText>Tax Exemption</td>

                                       <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnITFlag" value = "Y" > 
                                           <td width = 5%><input type="checkbox" name="selectIT" onclick="lfnChange('1');" /></TD>                                                               
                                       </logic:notEqual>    
                        
                                       <logic:equal name= "frmEmpFinInfoForm"  property = "hdnITFlag" value = "Y" > 
                                           <td width = 5%><input type="checkbox" name="selectIT" checked = "true" onclick="lfnChange('1');" /></TD>                                                               
                                       </logic:equal>    

                             <td width = 5%>
                             <TD width = 15% class=labelText>Project Allowance</td>

                                        <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnProjFalg" value = "Y" > 
                                       <td width = 5%><input type="checkbox" name="selectProj" onclick="lfnChange('1');" /></TD>                                                               
                                       </logic:notEqual>    
                        
                                       <logic:equal name= "frmEmpFinInfoForm"  property = "hdnProjFalg" value = "Y" > 
                                       <td width = 5%><input type="checkbox" name="selectProj" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                                      </logic:equal>    
         
                              <td width = 5%>
                             <TD width = 15% class=labelText>UpGrade Allowance</td>
                                                                                           
                                   <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnUpGradeFlag" value = "Y" > 
                                       <td width = 5%><input type="checkbox" name="selectUp" onclick="lfnChange('1');" /></TD>                                                               
                                     </logic:notEqual>    
                        
                                   <logic:equal name= "frmEmpFinInfoForm"  property = "hdnUpGradeFlag" value = "Y" > 
                                       <td width = 5%><input type="checkbox" name="selectUp" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                                   </logic:equal>    
         

                             <td width = 5%>
                             <TD width = 15% class=labelText>Uniform Allowance</td>
                             
                                      <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnUniFlag" value = "Y" > 
                                         <td width = 5%><input type="checkbox" name="selectUni" onclick="lfnChange('1');" /></TD>                                                               
                                       </logic:notEqual>    
                        
                                     <logic:equal name= "frmEmpFinInfoForm"  property = "hdnUniFlag" value = "Y" > 
                                         <td width = 5%><input type="checkbox" name="selectUni" checked = "true"  onclick="lfnChange('1');" /></TD>                                                               
                                     </logic:equal>    

                             <td width = 4%>
         
                </tr>                             

                     <TR>

                             <td width = 1%>
                             <TD width = 15% class=labelText>Cycle Allowance</td>

                                     <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnCycleFlag" value = "Y" > 
                                         <td width = 5%><input type="checkbox" name="selectCycle" onclick="lfnChange('1');" /></TD>                                                               
                                     </logic:notEqual>    
                        
                                     <logic:equal name= "frmEmpFinInfoForm"  property = "hdnCycleFlag" value = "Y" > 
                                         <td width = 5%><input type="checkbox" name="selectCycle" checked = "true" onclick="lfnChange('1');" /></TD>                                                               
                                     </logic:equal>    


                             <td width = 5%>
                             <TD width = 15% class=labelText>Charge Allowance</td>

                                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnChargeFlag" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectCharge" onclick="lfnChange('1');" /></TD>                                                               
                                            </logic:notEqual>    
                        
                                           <logic:equal name= "frmEmpFinInfoForm"  property = "hdnChargeFlag" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectCharge" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                                         </logic:equal>    
         
                            <td width = 5%>
                             <TD width = 15% class=labelText>Nursing  Allowance</td>
                                                                                           
                                         <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnNurseFalg" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectNurse" onclick="lfnChange('1');" /></TD>                                                               
                                           </logic:notEqual>    
                        
                                         <logic:equal name= "frmEmpFinInfoForm"  property = "hdnNurseFalg" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectNurse" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                                         </logic:equal>    
         

                             <td width = 5%>
                             <TD width = 15% class=labelText>Special Allowance</td>
                             
                                          <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplFlag" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectSpl" onclick="lfnChange('1');" /></TD>                                                               
                                           </logic:notEqual>    
                        
                                         <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplFlag" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectSpl" checked = "true" onclick="lfnChange('1');" /></TD>                                                               
                                         </logic:equal>    
                     <td width = 4%>
              </tr> 
              
                     <TR>

                             <td width = 1%>
                             <TD width = 15% class=labelText><bean:message  key="Payroll.EmpInfo.QualIncent" /></td>
                                     <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnQualIncentFlag" value = "Y" > 
                                         <td width = 5%><input type="checkbox" name="selectQualIncentFlag" onclick="lfnChange('1');" /></TD>                                                               
                                     </logic:notEqual>    
                        
                                     <logic:equal name= "frmEmpFinInfoForm"  property = "hdnQualIncentFlag" value = "Y" > 
                                         <td width = 5%><input type="checkbox" name="selectQualIncentFlag" checked = "true" onclick="lfnChange('1');" /></TD>                                                               
                                     </logic:equal>    


                             <td width = 5%>
                             <TD width = 15% class=labelText><bean:message  key="Payroll.EmpInfo.CableTv" /></td>

                                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnCableTVFlag" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectCableTVFlag" onclick="lfnChange('1');" /></TD>                                                               
                                            </logic:notEqual>    
                        
                                           <logic:equal name= "frmEmpFinInfoForm"  property = "hdnCableTVFlag" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectCableTVFlag" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                                         </logic:equal>    
         
                            <td width = 5%>
                             <TD width = 15% class=labelText><bean:message  key="Payroll.EmpInfo.Cca" /></td>
                                                                                           
                                         <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnCCAFlag" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectCCAFlag" onclick="lfnChange('1');" /></TD>                                                               
                                           </logic:notEqual>    
                        
                                         <logic:equal name= "frmEmpFinInfoForm"  property = "hdnCCAFlag" value = "Y" > 
                                             <td width = 5%><input type="checkbox" name="selectCCAFlag" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                                         </logic:equal>    
         
              </tr> 


              


		                <TR>
                        <TD colspan=16 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          

                    </tr> 



              <TR>
               <td colspan=16>
                 <TABLE cellSpacing=0 cellPadding=0  border = 0>
                         
                         <tr>  
                         <td width="10%" ></td>
                         <td width="6%" ></td>
                         <TD  class=labelLeftAlign  >Washing Allowance

                                     <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnWashFlag" value = "Y" > 
                                         <input type="checkbox" name="selectWash" onclick="lfnChange('1');" />                                                               
                                     </logic:notEqual>    
                        
                                     <logic:equal name= "frmEmpFinInfoForm"  property = "hdnWashFlag" value = "Y" > 
                                         <input type="checkbox" name="selectWash" checked = "true" onclick="lfnChange('1');"  />                                                               
                                     </logic:equal>    
                          </TD>

                           <td width="2%"></td>
                           <TD  class=labelLeftAlign align = "left"  width="20%" >Canteen Subsidy
                                                                                           
                                     <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnCantFlag" value = "Y" > 
                                         <input type="checkbox" name="selectCant" onclick="CantDisab(); " />                                                               
                                      </logic:notEqual>    
                        
                                     <logic:equal name= "frmEmpFinInfoForm"  property = "hdnCantFlag" value = "Y" > 
                                         <input type="checkbox" name="selectCant" checked = "true" onclick="CantDisab();"  />                                                             
                                     </logic:equal>    
                          </td>

                          <td class=labelLeftAlign width="25%" >
                                  <bean:message key="Payroll.EmpInfo.rate" />&nbsp;
                          <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnCantFlag" value = "Y" > 
                                  <html:select property="txtCantRate" alt="txtCantRate" styleClass="optional" style='width:42%' disabled="true" onchange="comboChange();"  >
                                  <html:option value="" >Please Select </html:option>
                                  <html:option value="O" > Old</html:option>
                                  <html:option value="N" > Current</html:option>
                                  </html:select>
                          </logic:notEqual> 
                          <logic:equal name= "frmEmpFinInfoForm"  property = "hdnCantFlag" value = "Y" > 
                                  <html:select property="txtCantRate" alt="txtCantRate" styleClass="required" style='width:42%'  onchange="comboChange();"  >
                                  <html:option value="" >Please Select </html:option>
                                  <html:option value="O" > Old</html:option>
                                  <html:option value="C" > Current</html:option>
                                  </html:select>
                          </logic:equal>    
                         </td>                          
                  </tr>

                      <tr>         
                         <td width="10%" ></td>


                          <TD  class=labelLeftAlign colspan="3" >Children Education Allowance

                                    <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnChEduFlag" value = "Y" > 
                                     <input type="checkbox" name="selectChEdAl" onclick="disable(); lfnChange('1');" />                                                               
                                   </logic:notEqual>    
                        
                                   <logic:equal name= "frmEmpFinInfoForm"  property = "hdnChEduFlag" value = "Y" > 
                                       <input type="checkbox" name="selectChEdAl" checked = "true" onclick="disable(); lfnChange('1');"  />                                                           
                                   </logic:equal>                           


                                  <bean:message key="Payroll.EmpInfo.noc" />
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnChEduFlag" value = "Y" > 
                                    <html:text  property="txtNoc" styleClass = "locked"  size="4" disabled="true" onchange="lfnChange(this.value);"  />
                                 </logic:notEqual>    
                                 <logic:equal name= "frmEmpFinInfoForm"  property = "hdnChEduFlag" value = "Y" > 
                                    <html:text  property="txtNoc" styleClass = "required"  size="4"  onchange="lfnChange(this.value)"   />
                                 </logic:equal>                           

                          </td>               
                         
                          <TD  class=labelLeftAlign  >Hostel Subsidy &nbsp;&nbsp;
                             
                                    <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnHosFlag" value = "Y" > 
                                       <input type="checkbox" name="selectHos" onclick="HosDisab(); lfnChange('1');" />                                                              
                                     </logic:notEqual>    
                        
                                   <logic:equal name= "frmEmpFinInfoForm"  property = "hdnHosFlag" value = "Y" > 
                                       <input type="checkbox" name="selectHos" checked = "true" onclick="HosDisab(); lfnChange('1');" />                                                           
                                   </logic:equal>   
                         </td>
                                  <td class=labelLeftAlign >
                                  <bean:message key="Payroll.EmpInfo.noc" />
                              <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnHosFlag" value = "Y" > 
                                    <html:text  property="txtHosChld" styleClass = "locked"  size="14" disabled="true" onchange="lfnChange(this.value)"  />
                              </logic:notEqual> 

                           <logic:equal name= "frmEmpFinInfoForm"  property = "hdnHosFlag" value = "Y" > 
                                <html:text  property="txtHosChld" styleClass = "required"  size="14"  onchange="lfnChange(this.value)"  />                                                           
                          </logic:equal>   
                          </td>                                     
                                </tr>





                         <tr>  


                         <td width="10%" ></td>


                          <TD  class=labelLeftAlign colspan="3" >GIS Recovery

                                    <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnGisRec" value = "Y" > 
                                     <input type="checkbox" name="selectGisRec" onclick="GisDisab(); lfnChange('1');" />                                                               
                                   </logic:notEqual>    
                        
                                   <logic:equal name= "frmEmpFinInfoForm"  property = "hdnGisRec" value = "Y" > 
                                       <input type="checkbox" name="selectGisRec" checked = "true" onclick="GisDisab(); lfnChange('1');"  />                                                           
                                   </logic:equal>                           


                                  <bean:message key="Payroll.EmpInfo.gisType" />
                          <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnGisRec" value = "Y" > 
                                  <html:select property="txtGisType" alt="txtGisType" styleClass="optional" style='width:42%' disabled="true" onchange="comboChange();"  >
                                  <html:option value="" >Please Select </html:option>
                                  <html:option value="EGO" >EGLIS (NEW)</html:option>      
                                  <html:option value="EGN" >EGLIS (OLD)</html:option>      
                                  <html:option value="CGO" >CGIS (NEW)</html:option>                      
                                  <html:option value="CGN" >CGIS (OLD)</html:option>                                      
                                  </html:select>
                          </logic:notEqual> 
                          <logic:equal name= "frmEmpFinInfoForm"  property = "hdnGisRec" value = "Y" > 
                                  <html:select property="txtGisType" alt="txtGisType" styleClass="required" style='width:42%'  onchange="comboChange();"  >
                                  <html:option value="" >Please Select </html:option>
                                  <html:option value="EGO" >EGLIS (NEW)</html:option>      
                                  <html:option value="EGN" >EGLIS (OLD)</html:option>      
                                  <html:option value="CGO" >CGIS (NEW)</html:option>                      
                                  <html:option value="CGN" >CGIS (OLD)</html:option>                                      
                                  </html:select>
                          </logic:equal>    
                          </td>               
                  </tr>     
</tr>                         
                           </table>
                        </td>
                      </tr>  
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
<!-- Tab table Row 3 starts -->
 
</TABLE>

  </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
               <td align=center bgcolor=#4682b4 width="40%"></td>
               <td  bgcolor=#4682b4></td>
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

<html:hidden property="hdnHrrFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnBoardFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnDepuFlag" name="frmEmpFinInfoForm"  />   
<html:hidden property="hdnOutFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnITFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnProjFalg" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnUpGradeFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnUniFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnCycleFlag" name="frmEmpFinInfoForm"  />   
<html:hidden property="hdnChargeFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnNurseFalg" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnSplFlag" name="frmEmpFinInfoForm"  />

<html:hidden property="hdnWashFlag" name="frmEmpFinInfoForm"  />   
<html:hidden property="hdnCantFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnChEduFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnHosFlag" name="frmEmpFinInfoForm"  />


<html:hidden property="hdnQualIncentFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnCableTVFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnCCAFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnGisRec" name="frmEmpFinInfoForm"  />


</html:form>
</body>
</html:html>


<script language="javascript">

function lfnLoad()
{
  mode = document.all.screenMode.value;
  if(mode == '')
  {
      doQueryMode();
  }

  
  if(mode=='U' || mode == 'N')
  {
    document.all.lstGroup.disabled = "true";
    document.all.lstCateg.disabled = "true";
    document.all.txtDsgn.disabled = "true";      
    document.all.headerPrimaryKey.disabled = "true";          
  }


  
 checkPayMode();
 hedMenuHandling(mode);

}


 function lfnChange(val)
{
  if(num_Check(val,1))
    frmEmpFinInfoForm.headerDataChanged.value = "true";
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

function comboChange(val)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function doOnChangeCalendar(buttonName)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
  document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

  frmEmpFinInfoForm.action="../../../EmpFinFirstGetHeaderAction.do"
  frmEmpFinInfoForm.submit();
}


function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value + 1;
    frmEmpFinInfoForm.action="../../../EmpFinGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value - 1;
  frmEmpFinInfoForm.action = "../../../EmpFinGetPrevHeader.do";
  frmEmpFinInfoForm.submit();
}


function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.newPositionRequested.value;
  frmEmpFinInfoForm.action = "../../../EmpFinGetNextHeader.do";
  frmEmpFinInfoForm.submit();
}

function doInsertMode()
{
  if ( document.all.screenMode.value == "Q")
      document.all.headerDataChanged.value='';
      
  document.all.buttonFlag.value='';
  frmEmpFinInfoForm.action="../../../EmpFinNewMode.do"
  frmEmpFinInfoForm.submit();
}

function doQueryMode()
{
  document.all.buttonFlag.value='';
  frmEmpFinInfoForm.action="../../../EmpFinQueryMode.do"
  frmEmpFinInfoForm.submit();
}
function doRefresh()
{
  document.all.buttonFlag.value=''; 
  frmEmpFinInfoForm.action="../../../EmpFinRefresh.do"
  frmEmpFinInfoForm.submit();
}

    function ShowLovStateCode()
    {
       frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastStatecode" + frmEmpFinInfoForm.screenName.value + "Q";
//       frmEmpFinInfoForm.txtDisplayFields.value = "txtStateCode";
//       frmEmpFinInfoForm.txtSearchFields.value = "";
       frmEmpFinInfoForm.txtDisplayFields.value = "txtStateCode,txtStateDesc";
       frmEmpFinInfoForm.txtSearchFields.value = "Pay.proftax.statecode,pr.PayCode.description";
       frmEmpFinInfoForm.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
       frmEmpFinInfoForm.headerDataChanged.value = "true";       
       return true;
    }

    function ShowLovBankCode()
    {
       frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBankCode" + frmEmpFinInfoForm.screenName.value + "Q";
       frmEmpFinInfoForm.txtDisplayFields.value = "txtBankCode";
       frmEmpFinInfoForm.txtSearchFields.value = "";
       frmEmpFinInfoForm.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
       return true;
    }

    function ShowLovBranchCode()
    {
       frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBranchCode" + frmEmpFinInfoForm.screenName.value + "Q";
       frmEmpFinInfoForm.txtDisplayFields.value = "txtBranchCode";
       frmEmpFinInfoForm.txtSearchFields.value = "";
       frmEmpFinInfoForm.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
       return true;
    }
    
    

     

function ShowEmpNum()
{
   frmEmpFinInfoForm.lovKey.value = "EmpFinInfo" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
   if(frmEmpFinInfoForm.screenMode.value == 'N')
   {
     frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,lstGroup,lstCateg,txtDsgn,txtHandi,txtCurtBasic,txtlstPromDate";
//     frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.Empno";
       frmEmpFinInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
     frmEmpFinInfoForm.txtIndex.value ="";      
   }
   if(frmEmpFinInfoForm.screenMode.value == 'Q')
   {
     frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
//     frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.Empno";
       frmEmpFinInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
     frmEmpFinInfoForm.txtIndex.value ="";      
   }
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   return true;
}
function SaveRecord()
{
  document.all.buttonFlag.value='';
  if(mandatory_Check("frmEmpFinInfoForm"))
  { 
    
    frmEmpFinInfoForm.detailDataChanged.value = "false";  
    if(frmEmpFinInfoForm.screenMode.value == "N")
      frmEmpFinInfoForm.headerDataChanged.value = "true";  
  
    frmEmpFinInfoForm.headerFields.value = "true";
    saveCheckBox();
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";

    frmEmpFinInfoForm.action = "../../../EmpFinSaveAction.do";
    document.all.lstGroup.disabled = "";
    document.all.lstCateg.disabled = "";
    document.all.txtDsgn.disabled = "";      
    document.all.txtNoc.disabled = "";
    document.all.txtHosChld.disabled = "";
    document.all.txtCantRate.disabled = "";      
    document.all.txtGisType.disabled = "";          
  document.all.selectDep.disabled="";

    frmEmpFinInfoForm.submit();
  }
  else
  {
    return false;
  }
}


function saveCheckBox()
{
//document.all.headerPrimaryKey.value = "txtEmpNo";
if (document.all.selectHrr.checked==true)
  {
  document.all.hdnHrrFlag.value="Y";
  }
else 
  {
  document.all.hdnHrrFlag.value="N";
  }

if (document.all.selectVeh.checked==true)
  {
  document.all.hdnBoardFlag.value="Y";
  }
else 
  {document.all.hdnBoardFlag.value="N";}

if (document.all.selectIT.checked==true)
  {
  document.all.hdnITFlag.value="Y";
  }
else 
  {document.all.hdnITFlag.value="N";}

if (document.all.selectOut.checked==true)
  {
  document.all.hdnOutFlag.value="Y";
  }
else 
  {document.all.hdnOutFlag.value="N";}


if (document.all.selectDep.checked==true)
  {
  document.all.hdnDepuFlag.value="Y";
  }
else 
  {document.all.hdnDepuFlag.value="N";}



if (document.all.selectProj.checked==true)
  {
  document.all.hdnProjFalg.value="Y";
  }
else 
  {document.all.hdnProjFalg.value="N";}



if (document.all.selectUp.checked==true)
  {
  document.all.hdnUpGradeFlag.value="Y";
  }
else 
  {document.all.hdnUpGradeFlag.value="N";}



if (document.all.selectCycle.checked==true)
  {
  document.all.hdnCycleFlag.value="Y";
  }
else 
  {document.all.hdnCycleFlag.value="N";}


if (document.all.selectCharge.checked==true)
  {
  document.all.hdnChargeFlag.value="Y";
  }
else 
  {document.all.hdnChargeFlag.value="N";}


if (document.all.selectNurse.checked==true)
  {
  document.all.hdnNurseFalg.value="Y";
  }
else 
  {document.all.hdnNurseFalg.value="N";}


if (document.all.selectSpl.checked==true)
  {
  document.all.hdnSplFlag.value="Y";
  }
else 
  {document.all.hdnSplFlag.value="N";}


if (document.all.selectWash.checked==true)
  {
  document.all.hdnWashFlag.value="Y";
  }
else 
  {document.all.hdnWashFlag.value="N";}


if (document.all.selectCant.checked==true)
  {
  document.all.hdnCantFlag.value="Y";
  }
else 
  {document.all.hdnCantFlag.value="N";}


if (document.all.selectChEdAl.checked==true)
  {
  document.all.hdnChEduFlag.value="Y";
  }
else 
  {document.all.hdnChEduFlag.value="N";}

  
if (document.all.selectHos.checked==true)
  {
  document.all.hdnHosFlag.value="Y";
  }
else 
  {document.all.hdnHosFlag.value="N";}


if (document.all.selectQualIncentFlag.checked==true)
  {
  document.all.hdnQualIncentFlag.value="Y";
  }
else 
  {document.all.hdnQualIncentFlag.value="N";}

if (document.all.selectCableTVFlag.checked==true)
  {
  document.all.hdnCableTVFlag.value="Y";
  }
else 
  {document.all.hdnCableTVFlag.value="N";}


if (document.all.selectCCAFlag.checked==true)
  {
  document.all.hdnCCAFlag.value="Y";
  }
else 
  {document.all.hdnCCAFlag.value="N";}


if (document.all.selectGisRec.checked==true)
  {
  document.all.hdnGisRec.value="Y";
  }
else 
  {document.all.hdnGisRec.value="N";}



if (document.all.selectUni.checked==true)
  {
  document.all.hdnUniFlag.value="Y";
  }
else 
  {document.all.hdnUniFlag.value="N";}

  //alert(document.all.selectHrr.value);
}

function disable()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";

    if (document.all.selectChEdAl.checked==true)
    {
        document.all.selectChEdAl.value="Y";
      if(document.all.selectChEdAl.value=="Y")
      {
       document.getElementById("txtNoc").disabled = "";
       document.getElementById("txtNoc").style.background="#ffffd3";
       document.getElementById("txtNoc").style.className="required";       
      }
    }  
    else 
    {
      document.getElementById("txtNoc").disabled = "true"; 
       document.getElementById("txtNoc").value = "";     
       document.getElementById("txtNoc").style.background="#e0e0e0";
       document.getElementById("txtNoc").style.className="locked";       
    }

}

function HosDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";

    if (document.all.selectHos.checked==true)
    {
        document.all.selectHos.value="Y";
      if(document.all.selectHos.value=="Y")
      {
       document.getElementById("txtHosChld").disabled = "";
       document.getElementById("txtHosChld").style.background="#ffffd3";
       document.getElementById("txtHosChld").style.className="required";       

      }
    }  
    else 
    {
        document.getElementById("txtHosChld").disabled = "true";
        document.getElementById("txtHosChld").value = "";
       document.getElementById("txtHosChld").style.background="#e0e0e0";
       document.getElementById("txtHosChld").style.className="locked";       

      }
}


function CantDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";

    if (document.all.selectCant.checked==true)
    {
        document.all.selectCant.value="Y";
      if(document.all.selectCant.value=="Y")
      {
       document.getElementById("txtCantRate").disabled = "";
       document.getElementById("txtCantRate").style.background="#ffffd3";
       document.getElementById("txtCantRate").style.className="required";       

      }
    }  
    else 
    {
        document.getElementById("txtCantRate").disabled = "true";
        document.getElementById("txtCantRate").value = "";
        document.getElementById("txtCantRate").style.background="#ffffff";
        document.getElementById("txtCantRate").style.className="optional";       

        }
}


function GisDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";

    if (document.all.selectGisRec.checked==true)
    {
        document.all.selectGisRec.value="Y";
      if(document.all.selectGisRec.value=="Y")
      {
       document.getElementById("txtGisType").disabled = "";
       document.getElementById("txtGisType").style.background="#ffffd3";
       document.getElementById("txtGisType").style.className="required";       

      }
    }  
    else 
    {
        document.getElementById("txtGisType").disabled = "true";
        document.getElementById("txtGisType").value = "";
        document.getElementById("txtGisType").style.background="#ffffff";
        document.getElementById("txtGisType").style.className="optional";       
        }
}




function DepuFlag()
{
       if (document.all.selectDep.checked==true)
       document.getElementById("selectOut").disabled = "";
    else
       {
       document.getElementById("selectOut").disabled = "disabled"; 
      document.getElementById("selectOut").checked="";
       }
}

 function perCheck(val)
{
  if(num_Check(val,1))
  {
    var num = parseInt(val);
    if(num>=0 && num<=100)
      frmEmpFinInfoForm.headerDataChanged.value = "true";
    else 
    {
      alert("Value Should be between 0 and 100");
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
    }
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}


function ShowLovDsgn()
{
   frmEmpFinInfoForm.lovKey.value = "EmpInfoDsgn" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
   frmEmpFinInfoForm.txtDisplayFields.value = "txtDsgn";
   frmEmpFinInfoForm.txtSearchFields.value = "";
   frmEmpFinInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   return true;
}


function checkPayMode()
{
    if (document.all.txtPayMode.value=="Q")
    {
       document.getElementById("txtPayModeType").disabled = "";
       document.getElementById("txtPayModeType").style.background="#ffffd3";
       document.getElementById("txtPayModeType").style.className="required";           
    }  
    else 
    {
       document.getElementById("txtPayModeType").disabled = "true";
       document.getElementById("txtPayModeType").style.background="#ffffff";
       document.getElementById("txtPayModeType").style.className="optional";           
    }
}


function showCalendar(inputId, butId) {  
   if(butId.alt)
   {
    iIndex=butId.alt;
   }
   else
   {
    iIndex="-1";
   }
   Calendar.setup({inputField	: inputId,
		   ifFormat	: "%d-%b-%Y",
		   button	: butId,
       position: iIndex
  		  });
        
   return false;
}

 function doGetTab(arg)
 {
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoPayTabAction.do";
    document.forms[0].submit(); 
 }

</script> 
