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
    <script language="JavaScript1.2" src="../INCLUDES/NWNPHrInfoAdmin.js"></script>          
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>      
</head>
<BODY  onload="lfnHrLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintNWNPInfoAdmin" name="frmNWNPInfoForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.NWNPInfoForm">
<bean:define id="ParentForm" name="frmNWNPInfoForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>

<jsp:include page="NWNPHeaderInfoAdmin.jsp" flush="true" />
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
                         <logic:equal property= "txtFathHusflag" name= "frmNWNPInfoForm" value="H">
					                <input type="radio" name="radioFathHus" value="F" onclick="FathHusFlag(this.value)"  > FATHER NAME
                         <input type="radio" name="radioFathHus" value="H" onclick="FathHusFlag(this.value)" checked="checked"  >HUSBAND NAME
					          </logic:equal>
                    
                        <logic:notEqual property= "txtFathHusflag" name= "frmNWNPInfoForm" value="H">
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
                          <td width="18%" colspan="1" ><html:select  property="txtCasteCateg" titleKey="Payroll.EmpInfo.casteCateg" styleClass = "required" style="width:81%"onchange="comboChange(); " >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <!--<html:option value="SC" > <bean:message key="Payroll.EmpInfo.sc" /></html:option>
                          <html:option value="ST" > <bean:message key="Payroll.EmpInfo.st" /></html:option>  
                          <html:option value="OBC" > <bean:message key="Payroll.EmpInfo.obc" /></html:option>
                          <html:option value="GEN" > <bean:message key="Payroll.EmpInfo.gen" /></html:option>  -->
                          <logic:present name="NWNPLabourList">
                              <html:optionsCollection label="label" value="value" property="valueCasteCategList" name="NWNPLabourList"/>
                              </logic:present>
                          </html:select>
                          </td>
                          
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.phtype" /></td>
                          <td colspan="1" ><html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "locked" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                         <!-- <html:option value="VH" > <bean:message key="Payroll.EmpInfo.vh" /></html:option>
                          <html:option value="HH" > <bean:message key="Payroll.EmpInfo.hh" /></html:option>   
                          <html:option value="OH" > <bean:message key="Payroll.EmpInfo.oh" /></html:option>  -->
                          
                          <logic:present name="NWNPLabourList">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="NWNPLabourList"/>
                              </logic:present>

                          </html:select>
                          </td>
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.rel" /></td>
                          <td colspan="1" ><html:select  property="txtReligion" titleKey="Payroll.EmpInfo.rel" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                       <!--   <html:option value="HINDU" > <bean:message key="Payroll.EmpInfo.hindu" /></html:option>
                          <html:option value="MUSLIM" > <bean:message key="Payroll.EmpInfo.muslim" /></html:option>   
                          <html:option value="CHRISTIAN" > <bean:message key="Payroll.EmpInfo.christian" /></html:option>                               
                          <html:option value="SIKH" > <bean:message key="Payroll.EmpInfo.sikh" /></html:option>
                          <html:option value="BUDDHIST" > <bean:message key="Payroll.EmpInfo.budh" /></html:option>   
                          <html:option value="PARSI" > <bean:message key="Payroll.EmpInfo.parsi" /></html:option>                               
                          <html:option value="JAIN" > <bean:message key="Payroll.EmpInfo.jain" /></html:option>   
                          <html:option value="OTHERS" > <bean:message key="Payroll.EmpInfo.othr" /></html:option> -->
                          
                          <logic:present name="NWNPLabourList">
                              <html:optionsCollection label="label" value="value" property="valueReligionList" name="NWNPLabourList"/>
                              </logic:present>

                          </html:select>
                          
                          
                    </tr>
                    
                     <TR>                            
                         
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.exsrvc" /></td>
                          <td colspan="1" ><html:select  property="txtExsrvcman" titleKey="Payroll.EmpInfo.exsrvc" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                          <html:option value="N" > <bean:message key="Payroll.EmpInfo.No" /></html:option>   
                                                      
                          </html:select>
                          </td>
                          
                        <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.aadhar" /></td>
                        <td ><html:text  property="txtAadharNum" alt="<%=String.valueOf(i)%>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.aadhar" styleClass="optional" onkeypress="                            
                          if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                         
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkAadharNum(this.value);lfnChanged(this.value);" /></td>   
                     <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.uan" /></td>
                        <td ><html:text  property="txtUanNum" alt="<%=String.valueOf(i)%>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.uan" styleClass="optional" onkeypress="                            
                            if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                         
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkUANum(this.value);lfnChanged(this.value);" /></td>   
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
<html:hidden name="frmNWNPInfoForm"  property="screenName" value="NWNPInfoAdminScreen" />
<html:hidden name="frmNWNPInfoForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmNWNPInfoForm" />
<html:hidden property="positionRequested" name="frmNWNPInfoForm" />
<html:hidden property="userPositionRequested" name="frmNWNPInfoForm" />
<html:hidden property="buttonFlag" name="frmNWNPInfoForm"  />
<html:hidden property="lovKey" name="frmNWNPInfoForm"  />
<html:hidden property="txtFields" name="frmNWNPInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmNWNPInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmNWNPInfoForm"  />
<html:hidden property="txtIndex" name="frmNWNPInfoForm"  />
<html:hidden property="loginLocCode" name="frmNWNPInfoForm" />
<html:hidden property="txtInputField" name="frmNWNPInfoForm"  />
<html:hidden property="txtCateg" name="frmNWNPInfoForm"  />

<html:hidden property="txtCurMGW" name="frmNWNPInfoForm"  />
<html:hidden property="txtPayStatus" name="frmNWNPInfoForm"  />
<html:hidden property="txtPayMode" name="frmNWNPInfoForm"  />
<html:hidden property="txtPayStsChnDate" name="frmNWNPInfoForm"  />

<html:hidden property="hdnIRFlag" name="frmNWNPInfoForm"  /> 
<html:hidden property="hdnBFFlag" name="frmNWNPInfoForm"  />
<html:hidden property="hdnSocRecFlag" name="frmNWNPInfoForm"  />
<html:hidden property="txtSocRecAmt" name="frmNWNPInfoForm"  />

<html:hidden property="txtFpsNo" name="frmNWNPInfoForm"/>
<html:hidden property="txtEpsFlag" name="frmNWNPInfoForm"/>
<html:hidden property="txtEpsSepRsn" name="frmNWNPInfoForm"/>
<html:hidden property="txtEpsEntDt" name="frmNWNPInfoForm"/>
<html:hidden property="txtEpsSepDt" name="frmNWNPInfoForm"/>

<html:hidden property="txtAddId" name="frmNWNPInfoForm"  />
<html:hidden property="txtPermAddL1" name="frmNWNPInfoForm"  />
<html:hidden property="txtPermAddL2" name="frmNWNPInfoForm"  />
<html:hidden property="txtPermCity" name="frmNWNPInfoForm"  />
<html:hidden property="txtPermState" name="frmNWNPInfoForm"  />
<html:hidden property="txtPermStateDesc" name="frmNWNPInfoForm"  />
<html:hidden property="txtPermCountry" name="frmNWNPInfoForm"  />
<html:hidden property="txtPermPin" name="frmNWNPInfoForm"  />
<html:hidden property="txtTempAddL1" name="frmNWNPInfoForm"  />
<html:hidden property="txtTempAddL2" name="frmNWNPInfoForm"  />
<html:hidden property="txtTempCity" name="frmNWNPInfoForm"  />
<html:hidden property="txtTempState" name="frmNWNPInfoForm"  />
<html:hidden property="txtTempStateDesc" name="frmNWNPInfoForm"  />
<html:hidden property="txtTempCountry" name="frmNWNPInfoForm"  />
<html:hidden property="txtTempPin" name="frmNWNPInfoForm"  />
<html:hidden property="txtFathHusflag" name="frmNWNPInfoForm"  />
<html:hidden property="txtEmpNo" name="frmNWNPInfoForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">


function FathHusFlag(name)

{
// alert ("in function");
 frmNWNPInfoForm.txtFathHusflag.value = name;
// alert (frmNWNPInfoForm.txtFathHusflag.value);
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