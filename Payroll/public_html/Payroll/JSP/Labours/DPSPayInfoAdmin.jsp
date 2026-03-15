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
      <script language="JavaScript1.2" src="../INCLUDES/DPSPayInfoAdmin.js"></script>      
  </head>
<BODY  onload="EmpFinLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintDPSInfoAdmin" name="frmDPSInfoForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.DPSInfoForm">
<bean:define id="ParentForm" name="frmDPSInfoForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>

<jsp:include page="DPSHeaderInfoAdmin.jsp" flush="true" />
    <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
          <TR >
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
              <TABLE cellSpacing=0 cellPadding=0 border = 0>
                <TR>          
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > Payroll Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("HrDet")> HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                                                             
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="80%">&nbsp;</td>
                    
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
         
        <TR height=10>
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
                          <td width="100%" colspan=17>
                            <TABLE width="100%" cellpadding=0 cellspacing=0 border=0>
                             
                                <TR>       
                               
				 <!--Added by dushyant on 26-April-2013 for pay status-->
							 <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.psatat" /> </td>               
							  <td>                  
							  <logic:equal property= "screenMode" name= "frmDPSInfoForm" value="N">                              
								  <html:select property="txtPayStatus" alt="txtPayStatus" titleKey="Payroll.EmpInfo.psatat" styleClass="required" disabled="true" style="width:80%" onchange="fillPayStatusChdDate(); comboChange();" >   
								 <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>             
								 </html:select>
							  </logic:equal> 

							  <logic:notEqual property= "screenMode" name= "frmDPSInfoForm" value="N">
                                  <logic:equal property= "txtCpfCode" name= "frmDPSInfoForm" value="TEMP">
									  <html:select property="txtPayStatus" alt="txtPayStatus" titleKey="Payroll.EmpInfo.psatat" styleClass="required" disabled="true" style="width:80%" onchange="fillPayStatusChdDate(); comboChange();" >
										 <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>     
										 </html:select>
                                  </logic:equal>
								  <logic:notEqual property= "txtCpfCode" name= "frmDPSInfoForm" value="TEMP">
									  <html:select property="txtPayStatus" alt="txtPayStatus" titleKey="Payroll.EmpInfo.psatat" styleClass="required" style="width:80%" onchange="fillPayStatusChdDate(); comboChange();" >
										 <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>
										 <html:option value="A" > <bean:message key="Payroll.EmpInfo.act" /></html:option>
										 <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>     
										 </html:select>
                                  </logic:notEqual>
							  </logic:notEqual><html:hidden  property="txtPayStatus" altKey="Payroll.EmpInfo.psatat"  />                    
							  </td>
				 <!--Added by dushyant on 26-April-2013 for pay status-->
                                
                              <td width="15%" class=labelText>Current MGW</td>
                              <td ><html:text  property="txtCurMGW" styleClass = "locked" readonly="true" altKey="Payroll.EmpInfo.pstchdate" maxlength="15" size="23" onchange="lfnChanged(this.value)" /></td>

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pstchdate" /></td>
                              <td ><html:text  property="txtPayStsChnDate" styleClass = "required" altKey="Payroll.EmpInfo.pstchdate" maxlength="15" size="23" onchange="lfnChanged(this.value)" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" title="Calender" styleClass="lov" property="butTxtPayStsChnDate" alt="<%=(i-1) %>" onclick="showCalendar('txtPayStsChnDate',this)" /></td>
                 
                              </tr>
                              
                              <tr>
                               <td class=labelText  ><bean:message key="Payroll.EmpInfo.FpsNo" /> </td>                
                              <td>
							  <logic:equal property= "screenMode" name= "frmDPSInfoForm" value="Q"> 
                              <html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" onchange="checkFPSLength(this.value);" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right"   /> 
                               </logic:equal>
							<logic:notEqual property= "screenMode" name= "frmDPSInfoForm" value="Q">
								<logic:equal property= "screenMode" name= "frmDPSInfoForm" value="N">
									<html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" onchange="checkFPSLength(this.value);" onkeypress="
									 if((event.keyCode < 48 || event.keyCode > 57))
									  {
										return false;
									  };                            
											lfnChanged(this.value);
									   "  style="text-align:right"   />
								</logic:equal>
								<logic:notEqual property= "screenMode" name= "frmDPSInfoForm" value="N">
									<html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" readonly="true"  onchange="checkFPSLength(this.value);" onkeypress="
									 if((event.keyCode < 48 || event.keyCode > 57))
									  {
										return false;
									  };                            
											lfnChanged(this.value);
									   "  style="text-align:right"   />
								</logic:notEqual>
							</logic:notEqual>
							   </td>
                             <td width="15%" class=labelText>EPS Payment</td>
                                <td colspan="1">                                                                 
                                <html:select property="txtEpsFlag" name= "frmDPSInfoForm"  alt="txtMHSTyp" styleClass="required" style="width:79%"  onchange="checkEpsFlag();lfnChanged(this.value);"  >
                                <html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>      
                                <html:option value="Y" >Yes</html:option>
                                <html:option value="N" >No</html:option>
				<html:option value="P" >Previous</html:option>
                                </html:select>                              
                                </td> 
                                <td class=labelText  >Entitlement Date </td>                
                              <td>
                              <html:text  property="txtEpsEntDt" styleClass = "optional" maxlength="10"  size="23" onchange="lfnChanged(this.value)" readonly="true"/>
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butEpsEntDt" alt="<%=(i-1) %>" onclick="showCalendar('txtEpsEntDt',this)" />
                              </td> 
                              </tr>
                              <!-- added by swarnika in ref to issue id 75040-->
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
                              <tr>                                             
                                 <td width="15%" class=labelText>EPS Separation Reason</td>
                                  <td colspan="1">                                                                 
                                  <html:select property="txtEpsSepRsn" name= "frmDPSInfoForm"  alt="txtMHSTyp" styleClass="optional" style="width:79%"  onchange="lfnChanged(this.value);"  >
                                  <html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>      
                                  <logic:present name="DPSLabourList">
                                  <html:optionsCollection label="label" value="value" property="epsSepTypList" name="DPSLabourList"/>
                                  </logic:present>
                                  </html:select>                              
                                 </td>
                                 <td class=labelText  >EPS Separation Date </td>                
                                  <td>
                                  <html:text  property="txtEpsSepDt" styleClass = "optional" maxlength="10"  size="23" onchange="lfnChanged(this.value)" readonly="true"/>
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butEpsSepDt" alt="<%=(i-1) %>" onclick="showCalendar('txtEpsSepDt',this)" />
                                  </td> 
          <!--Added by dushyant on 06-Jan-2011 for pAN card-->
                                <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.txtPanNo" /></td>
                                   <td ><html:text  property="txtPanNo" name= "frmDPSInfoForm"  styleClass = "optional" altKey="Payroll.EmpInfo.txtPanNo" maxlength="10" onkeypress="
                                   if((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122))
                                   {}
                                    else
                                   {
									  return false;
									}; 
									lfnChanged(this.value);"   onchange="upper(this);" style="text-align:Left"   size="23" />
                               </td>        
        <!--Added by dushyant on 06-Jan-2011 for pAN card-->
                                  
                              </tr>  
                              <tr>
                              <td class=labelText  >CPF Int End Dt </td>                
                            <td>
                            <html:text  property="txtCPFIntEndDt" styleClass = "optional" maxlength="10"  size="23" onchange="lfnChanged(this.value)" readonly="true"/>
                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butEpsEntDt" alt="<%=(i-1) %>" onclick="showCalendar('txtCPFIntEndDt',this)" />
                            </td> 
                            <td class=labelText >Member Id(EPFO)</td> 
	
    <td>
      <html:text  property="txtMemberId" name= "frmDPSInfoForm"  maxlength="30" styleClass="optional"  onkeypress=" lfnChanged(this.value);" style="text-align:right" />
    </td>
                              </tr>
                              </TABLE>
                              </TD>
                            </TR>
                            <TR>
                              <TD colspan=17 >&nbsp;</TD>          
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
<html:hidden name="frmDPSInfoForm"  property="screenName" value="DPSInfoAdminScreen" />
<html:hidden name="frmDPSInfoForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDPSInfoForm" />
<html:hidden property="positionRequested" name="frmDPSInfoForm" />
<html:hidden property="userPositionRequested" name="frmDPSInfoForm" />
<html:hidden property="buttonFlag" name="frmDPSInfoForm"  />
<html:hidden property="lovKey" name="frmDPSInfoForm"  />
<html:hidden property="txtFields" name="frmDPSInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmDPSInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmDPSInfoForm"  />
<html:hidden property="txtIndex" name="frmDPSInfoForm"  />
<html:hidden property="loginLocCode" name="frmDPSInfoForm" />
<html:hidden property="txtInputField" name="frmDPSInfoForm"  />
<html:hidden property="txtCateg" name="frmDPSInfoForm"  />

<html:hidden property="txtPayMode" name="frmDPSInfoForm"  />
<html:hidden property="hdnIRFlag" name="frmDPSInfoForm"  /> 
<html:hidden property="hdnBFFlag" name="frmDPSInfoForm"  />
<html:hidden property="hdnSocRecFlag" name="frmDPSInfoForm"  />
<html:hidden property="txtSocRecAmt"  name="frmDPSInfoForm"  />  
 
<html:hidden property="txtDOB" name="frmDPSInfoForm"  />
<html:hidden property="txtGender" name="frmDPSInfoForm"  />
<html:hidden property="txtMarStat" name="frmDPSInfoForm"  />
<html:hidden property="txtFatherNam" name="frmDPSInfoForm"  />
<html:hidden property="txtHomTwn" name="frmDPSInfoForm"  />
<html:hidden property="txtHandi" name="frmDPSInfoForm"  />
<html:hidden property="txtHandiEffDate" name="frmDPSInfoForm"  />
<html:hidden property="txtRetireDate" name="frmDPSInfoForm"  />

<html:hidden property="txtAddId" name="frmDPSInfoForm"  />
<html:hidden property="txtPermAddL1" name="frmDPSInfoForm"  />
<html:hidden property="txtPermAddL2" name="frmDPSInfoForm"  />
<html:hidden property="txtPermCity" name="frmDPSInfoForm"  />
<html:hidden property="txtPermState" name="frmDPSInfoForm"  />
<html:hidden property="txtPermStateDesc" name="frmDPSInfoForm"  />
<html:hidden property="txtPermCountry" name="frmDPSInfoForm"  />
<html:hidden property="txtPermPin" name="frmDPSInfoForm"  />
<html:hidden property="txtTempAddL1" name="frmDPSInfoForm"  />
<html:hidden property="txtTempAddL2" name="frmDPSInfoForm"  />
<html:hidden property="txtTempCity" name="frmDPSInfoForm"  />
<html:hidden property="txtTempState" name="frmDPSInfoForm"  />
<html:hidden property="txtTempStateDesc" name="frmDPSInfoForm"  />
<html:hidden property="txtTempCountry" name="frmDPSInfoForm"  />
<html:hidden property="txtTempPin" name="frmDPSInfoForm"  />
<html:hidden property="txtCasteCateg" name="frmDPSInfoForm"  />
<html:hidden property="txtHandiType" name="frmDPSInfoForm"  />
<html:hidden property="txtReligion" name="frmDPSInfoForm"  />
<html:hidden property="txtExsrvcman" name="frmDPSInfoForm"  />
<html:hidden property="txtAadharNum" name="frmDPSInfoForm"  />
<html:hidden property="txtUanNum" name="frmDPSInfoForm" />
<input type="hidden" name="queryParam" />
<script language="javascript">

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
    frmDPSInfoForm.txtPayStsChnDate.value=curdate;  
  }
   else
    {
      if(frmDPSInfoForm.txtPayStatus.value=='A')
      {
        frmDPSInfoForm.txtPayStatus.value='I';
      }
      else
      {
        frmDPSInfoForm.txtPayStatus.value='A';
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
    
 