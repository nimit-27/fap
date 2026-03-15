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
    <script language="JavaScript1.2" src="../INCLUDES/DPSHrInfo.js"></script>          
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>      
</head>
<BODY  onload="lfnHrLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintDPSInfo" name="frmDPSInfoForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.DPSInfoForm">
<bean:define id="ParentForm" name="frmDPSInfoForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>

<jsp:include page="DPSHeaderInc.jsp" flush="true" />
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
               
              <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td bgcolor="#4682B4" nowrap class=actTabText > HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                            
              <td background="../INCLUDES/IMAGES/line_t.gif" width="80%">&nbsp;</td>
              
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
                          <html:text  property="txtDOB" maxlength="10" size="23" titleKey="Payroll.EmpInfo.dob" styleClass="required" readonly="true" onchange="cmpDOBSysDate(this.value,0); lfnChanged(this.value);" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDOB" alt="<%=(i-1) %>" onclick="showCalendar('txtDOB',this)" />
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
                         <logic:equal property= "txtFathHusflag" name= "frmDPSInfoForm" value="H">
					                <input type="radio" name="radioFathHus" value="F" onclick="FathHusFlag(this.value)"  > FATHER NAME
                         <input type="radio" name="radioFathHus" value="H" onclick="FathHusFlag(this.value)" checked="checked"  >HUSBAND NAME
					          </logic:equal>
                    
                        <logic:notEqual property= "txtFathHusflag" name= "frmDPSInfoForm" value="H">
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
                        <td ><html:text  property="txtHomTwn" styleClass = "optional" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" onkeypress="
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
                        <html:text  property="txtHandiEffDate"  maxlength="10" size="23" styleClass="locked" onchange="checkHandicapDate(this.value); lfnChanged(this.value);" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtHandiEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtHandiEffDate',this)" />
                        </td>
                        
                        <td width="13%" class=labelText  ><bean:message key="Payroll.EmpInfo.Retdate" /> </td>            
                        <td>
                        <html:text  property="txtRetireDate"  maxlength="10" size="22" styleClass="optional" onchange="lfnChanged(this.value);" readonly="true"/>
                        </td>                                         
                    </tr>                                 
                                              
                    <tr><td colspan=6>&nbsp;</td> </tr>
                     <tr><td colspan=6>&nbsp;</td> </tr>
                    
                        <TR>                            
                         <td  width="16%" class=labelText><bean:message key="Payroll.EmpInfo.casteCateg" /></td>
                          <td width="18%" colspan="1" >
                          <logic:equal property= "txtCasteCateg" name= "frmDPSInfoForm" value="">
                          <html:select  property="txtCasteCateg" titleKey="Payroll.EmpInfo.casteCateg" styleClass = "required" style="width:81%"onchange="comboChange(); " >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <logic:present name="DPSLabourList">
                              <html:optionsCollection label="label" value="value" property="valueCasteCategList" name="DPSLabourList"/>
                              </logic:present>
                          </html:select>
                          </logic:equal>
                          
                          <logic:notEqual property= "txtCasteCateg" name= "frmDPSInfoForm" value="">
                          <html:select  property="txtCasteCateg" titleKey="Payroll.EmpInfo.casteCateg" styleClass = "locked" disabled="true" style="width:81%" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <logic:present name="DPSLabourList">
                              <html:optionsCollection label="label" value="value" property="valueCasteCategList" name="DPSLabourList"/>
                              </logic:present>
                          </html:select>
                          </logic:notEqual>
                          
                          </td>
                          
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.phtype" /></td>
                          <td colspan="1" >
                          <logic:equal property= "txtHandi" name= "frmDPSInfoForm" value="Y">
                          <logic:equal property= "txtHandiType" name= "frmDPSInfoForm" value="">
                          <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                         <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>
                                <logic:present name="DPSLabourList">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="DPSLabourList"/>
                              </logic:present>
                          </html:select>
                          </logic:equal>
                          
                          <logic:notEqual property= "txtHandiType" name= "frmDPSInfoForm" value="">
                          <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "locked" disabled="true"style="width:80%" onchange="comboChange();" >                             
                               <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>
                                <logic:present name="DPSLabourList">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="DPSLabourList"/>
                              </logic:present>
                          </html:select>
                          </logic:notEqual>
                          
                           </logic:equal>
                          
                           <logic:notEqual property= "txtHandi" name= "frmDPSInfoForm" value="Y">
                          <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "locked" disabled="true" style="width:80%"  >                             
                               <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>
                                <logic:present name="DPSLabourList">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="DPSLabourList"/>
                              </logic:present>
                          </html:select>
                          </logic:notEqual>
                         
                          </td>
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.rel" /></td>
                          <td colspan="1" >
                          <logic:equal property= "txtReligion" name= "frmDPSInfoForm" value="">
                          <html:select  property="txtReligion" titleKey="Payroll.EmpInfo.rel" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <logic:present name="DPSLabourList">
                              <html:optionsCollection label="label" value="value" property="valueReligionList" name="DPSLabourList"/>
                              </logic:present>
                         </html:select>
                          </logic:equal>
                          
                          <logic:notEqual property= "txtReligion" name= "frmDPSInfoForm" value="">
                          <html:select  property="txtReligion" titleKey="Payroll.EmpInfo.rel" styleClass = "locked" disabled="true" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <logic:present name="DPSLabourList">
                              <html:optionsCollection label="label" value="value" property="valueReligionList" name="DPSLabourList"/>
                              </logic:present>
                         </html:select>
                          </logic:notEqual>
                          
                    </tr>
                    
                     <TR>                            
                         
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.exsrvc" /></td>
                          <td colspan="1" >
                          <logic:equal property= "txtExsrvcman" name= "frmDPSInfoForm" value="">
                          <html:select  property="txtExsrvcman" titleKey="Payroll.EmpInfo.exsrvc" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                          <html:option value="N" > <bean:message key="Payroll.EmpInfo.No" /></html:option>   
                                                      
                          </html:select>
                          </logic:equal>
                          
                          <logic:notEqual property= "txtExsrvcman" name= "frmDPSInfoForm" value="">
                          <html:select  property="txtExsrvcman" titleKey="Payroll.EmpInfo.exsrvc" styleClass = "locked" disabled="true" style="width:80%"  >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                          <html:option value="N" > <bean:message key="Payroll.EmpInfo.No" /></html:option>   
                                                      
                          </html:select>
                          </logic:notEqual>
                          
                          </td>
                          
                        
                        <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.aadhar" />
                        <td>
                        <logic:equal property= "txtAadharNum" name= "frmDPSInfoForm" value="">
                        <html:text  property="txtAadharNum" alt="<%=String.valueOf(i)%>" maxlength="12" size="23" titleKey=
                        "Payroll.EmpInfo.aadhar" styleClass="optional" onkeypress="                            
                          if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                          
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkAadharNum(this.value);" /></td> 
                     </logic:equal>
                      <logic:notEqual property= "txtAadharNum" name= "frmDPSInfoForm" value=""> 
                        <html:text  property="txtAadharNum" alt="<%=String.valueOf(i)%>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.aadhar" readonly="true" styleClass="locked" style="text-align:left" />
                     </logic:notEqual>
                     </td>
                     <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.uan" /></td>
                     
                        <td >
                        <logic:equal property= "txtUanNum" name= "frmDPSInfoForm" value="">
                        <html:text  property="txtUanNum" alt="<%=String.valueOf(i)%>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.uan" styleClass="optional" onkeypress="                            
                          if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                           
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkUANum(this.value);" />
                     </logic:equal>
                     <logic:notEqual property= "txtUanNum" name= "frmDPSInfoForm" value=""> 
                        <html:text  property="txtUanNum" alt="<%=String.valueOf(i)%>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.uan" readonly="true" styleClass="locked" style="text-align:left" />
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
<html:hidden name="frmDPSInfoForm"  property="screenName" value="DPSInfoScreen" />
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

<html:hidden property="txtCurMGW" name="frmDPSInfoForm"  />
<html:hidden property="txtPayStatus" name="frmDPSInfoForm"  />
<html:hidden property="txtPayMode" name="frmDPSInfoForm"  />
<html:hidden property="txtPayStsChnDate" name="frmDPSInfoForm"  />

<html:hidden property="hdnIRFlag" name="frmDPSInfoForm"  /> 
<html:hidden property="hdnBFFlag" name="frmDPSInfoForm"  />
<html:hidden property="hdnSocRecFlag" name="frmDPSInfoForm"  />
<html:hidden property="txtSocRecAmt" name="frmDPSInfoForm"  />

<html:hidden property="txtFpsNo" name="frmDPSInfoForm"/>
<html:hidden property="txtEpsFlag" name="frmDPSInfoForm"/>
<html:hidden property="txtEpsSepRsn" name="frmDPSInfoForm"/>
<html:hidden property="txtEpsEntDt" name="frmDPSInfoForm"/>
<html:hidden property="txtEpsSepDt" name="frmDPSInfoForm"/>

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

<html:hidden property="txtFathHusflag" name="frmDPSInfoForm"  />

<html:hidden property="txtEmpNo" name="frmDPSInfoForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function FathHusFlag(name)

{
// alert ("in function");
 frmDPSInfoForm.txtFathHusflag.value = name;
// alert (frmDPSInfoForm.txtFathHusflag.value);
return success;
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