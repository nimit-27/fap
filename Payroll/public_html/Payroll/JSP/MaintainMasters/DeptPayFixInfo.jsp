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
<BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintDeptPayFixDetailBase" name="frmDeptPayFixForm" type="FCIPAY.Payroll.WEBTIER.Form.DeptPayFixForm">
<bean:define id="ParentForm" name="frmDeptPayFixForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>LABOUR PAY FIXATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
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
                  <logic:equal property= "screenMode" name= "frmDeptPayFixForm" value="N">                   
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmDeptPayFixForm" value="N">
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmDeptPayFixForm" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td> 
              </TR> 
                                
              <TR>              
                  <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  <html:hidden property="txtDsgnDesc"  styleClass="locked" />
                  </td>
                  
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/><html:hidden property="txtCateg"  styleClass="locked" /></td>                                                                        
              </tr>
                      
              <tr> 
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23"  styleClass="locked" readonly="true" />                                    
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
                  
                  <td width="15%" class=labelText  >PayScale/PayBand Code </td>            
                  <td>
                  <html:text  property="payScaleCode" altKey="Payroll.EmpInfo.curbas" maxlength="15" size="23" styleClass="locked" style="text-align:right" readonly="true"/>
                  </td>
              </tr>
              
              <tr>
                  <td width="23%" class=labelText  >Employee Basic  </td>                            
                  <td >
                  <html:text  property="txtCurtBasic" altKey="Payroll.EmpInfo.curbas" maxlength="15" size="23" styleClass="locked" style="text-align:right" readonly="true"/>
                  </td>             
                  
                  <td width="15%" class=labelText  >Current Grade Pay</td>            
                  <td>
                  <html:hidden  property="txtStagInc" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  <html:text  property="gradePay" altKey="Payroll.EmpInfo.payscalecode" styleClass="locked" readonly="true" />
                  </td>
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
                <td bgcolor="#4682B4" nowrap class=actTabText>Pay Fixation Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                  
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
                    <TD >
  			<!-- Detail table starts -->
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        
                    <tr>                      
                       	<!--  <TD width="23%" class=labelText  >Pay Band/Grade Pay</TD> -->
                        <TD width="23%" class=labelText  >New Grade Pay</TD>
                        <td align="left" colspan="1">
                        <html:hidden  property="payBand" altKey="Payroll.EmpInfo.payscalecode" size="2" styleClass="locked" readonly="true"/>                                         
                        <html:text  property="newGradePay" altKey="Payroll.EmpInfo.payscalecode" styleClass="locked" readonly="true"/>
                        </td>
                        <TD width="23%" class=labelText  > Fixation Finalized Flag <!-- <bean:message key="Payroll.EmpInfo.StrInc" /> --></TD>
                        <td align="left" colspan="1">                        
                        <logic:equal property= "screenMode" name= "frmDeptPayFixForm" value="N">  
                            
                        
                        <html:hidden  property="newStagInc"  maxlength="10" size="23" styleClass="required" value="0" readonly="true" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };  
                           "  style="text-align:right"   />
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmDeptPayFixForm" value="N">
                        <html:select property="txtFixationFlag" alt="txtFixationFlag" onchange="onExclude();" styleClass="required" style="WIDTH: 39%" >
                             <html:option value="" >--Please select--</html:option>     
                            <html:option value="Y" >  Final  </html:option>
                          <!--  <html:option value="N" >  Not Final  </html:option> -->
                            <!-- <html:option value="E" >  Excluded  </html:option>-->
                            </html:select>
                        <html:hidden  property="newStagInc"  maxlength="10" size="23" styleClass="optional" readonly="true"/>
                        </logic:notEqual>
                        </td>
                    
                        
                    </tr>
                    <tr>                      
                        <td width="23%" class=labelText>Revised Basic As On Pay Fixation Effective Date<!-- <bean:message key="Payroll.EmpInfo.newBasic" />--></td>
                        <td colspan="1">
                        <logic:equal property= "screenMode" name= "frmDeptPayFixForm" value="N">  
                        <html:text  property="newBasic" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="10" size="23" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "  style="text-align:right"   />                      
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmDeptPayFixForm" value="N">
                       <!-- <html:text  property="newBasic" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:right" readonly="true" />-->
                       <html:text  property="newBasic" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="10" size="23" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "  style="text-align:right"   />  
                        </logic:notEqual>
                        </td>
                        
                        <td width="23%" class=labelText  >Pay Fixation Effective Date </td>      
                        
                       <td colspan="1">
                        <logic:equal property= "screenMode" name= "frmDeptPayFixForm" value="N">  
                        <html:text  property="newPromEffDate"  maxlength="10" size="23" styleClass="required" readonly="true" /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="newPromEffDate" alt="<%=(i-1) %>" onclick="showCalendar('newPromEffDate',this)" />
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmDeptPayFixForm" value="N">
                        <!-- <html:text  property="newPromEffDate"  maxlength="10" size="23" styleClass="optional" readonly="true"/> -->
                        <html:text  property="newPromEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true" /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="newPromEffDate" alt="<%=(i-1) %>" onclick="showCalendar('newPromEffDate',this)" />
                        </logic:notEqual>
                        </td>  
                    </tr>
                    <tr>          <td width="23%" class=labelText>Revised Basic As On Pay Fixation Effective Date<!-- <bean:message key="Payroll.EmpInfo.newBasic" />--></td>
                        <td colspan="1">
                        <logic:equal property= "screenMode" name= "frmDeptPayFixForm" value="N">  
                        <html:text  property="newBasic1" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="10" size="23" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "  style="text-align:right"   />                      
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmDeptPayFixForm" value="N">
                       <!-- <html:text  property="newBasic" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:right" readonly="true" />-->
                       <html:text  property="newBasic1" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="10" size="23" onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "  style="text-align:right"   />  
                        </logic:notEqual>
                        </td>
                        
                        <td width="23%" class=labelText  >Pay Fixation Effective Date </td>      
                        
                       <td colspan="1">
                        <logic:equal property= "screenMode" name= "frmDeptPayFixForm" value="N">  
                        <html:text  property="newPromEffDate1"  maxlength="10" size="23" styleClass="required" readonly="true" /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="newPromEffDate1" alt="<%=(i-1) %>" onclick="showCalendar('newPromEffDate1',this)" />
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmDeptPayFixForm" value="N">
                        <!-- <html:text  property="newPromEffDate"  maxlength="10" size="23" styleClass="optional" readonly="true"/> -->
                        <html:text  property="newPromEffDate1"  maxlength="10" size="23" styleClass="locked" readonly="true" /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="newPromEffDate1" alt="<%=(i-1) %>" onclick="showCalendar('newPromEffDate1',this)" />
                        </logic:notEqual>
                        </td>  </tr>                    
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
        <td align=center bgcolor=#4682b4 width="40%"></td>
        <td  bgcolor=#4682b4>
       
       
        <logic:equal property= "screenMode" name= "frmDeptPayFixForm" value="U"> 
        <!-- <html:button property="butCncel" value="Cancel Fixation" onclick="SaveRecord()" disabled="true" /> -->
          <logic:notEqual property= "txtFixationFlag" name= "frmDeptPayFixForm" value="Y"> 
        <!-- <html:button property="butCncel" value="Cancel Fixation" onclick="SaveRecord()" disabled="true" /> -->
        <html:button property="butCncel" value="Update Fixation" onclick="SaveRecord()" /> 
        </logic:notEqual>
         <logic:equal property= "txtFixationFlag" name= "frmDeptPayFixForm" value="Y"> 
        <html:button property="butCncel" value="Update Fixation" onclick="SaveRecord()"  disabled="true" /> 
        </logic:equal>
        </logic:equal>
        <logic:notEqual property= "screenMode" name= "frmDeptPayFixForm" value="U"> 
          <logic:equal property= "cancelStatus" name= "frmDeptPayFixForm" value="">
       <!--   <html:button property="butCncel" value="Cancel Fixation" onclick="SaveRecord()" /> -->
           <html:button property="butCncel" value="Update Fixation" onclick="SaveRecord()" disabled="true" />
          </logic:equal>
          <logic:notEqual property= "cancelStatus" name= "frmDeptPayFixForm" value="">
          <html:button property="butCncel" value="Cancel Fixation" onclick="SaveRecord()" disabled="true" />
          </logic:notEqual>
        </logic:notEqual>
        </td>
        <td bgColor=#4682b4></td>
        <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
      </TR>
	<table>
				
				</br></br></br>
        			<TR style="color:blue;font-size:14px" >&nbsp;&nbsp;IMPORTANT NOTICE</TR>
				<TR style="font-size:12px">&nbsp;&nbsp;&nbsp;1. User should enter the Revised Basic (Fixation Basic) as on 01-Jan-2017 i.e including the increment, promotion effect (if any) held on 01-Jan-2017.</TR></br>
				<TR style="font-size:12px">&nbsp;&nbsp;&nbsp;2. User should enter the Revised Basic (Fixation Basic) as on 01-July-2019 i.e including the increment, promotion effect (if any) held between 01-Jan-2017 to 01-July-2019 .</TR>
			 </table>
  </TABLE> 
<!-- Container Table Ending Columns Starts-->
  </TD>
    
</TR>
</TBODY>
</TABLE>

</div>


<!-- Container Table Ends -->
<html:hidden name="frmDeptPayFixForm"  property="screenName" value="DeptPayFixScreen" />
<html:hidden name="frmDeptPayFixForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDeptPayFixForm" />
<html:hidden property="loginLocCode" name="frmDeptPayFixForm" />
<html:hidden property="positionRequested" name="frmDeptPayFixForm" />
<html:hidden property="userPositionRequested" name="frmDeptPayFixForm" />
<html:hidden property="buttonFlag" name="frmDeptPayFixForm"  />
<html:hidden property="lovKey" name="frmDeptPayFixForm"  />
<html:hidden property="txtFields" name="frmDeptPayFixForm"  />   
<html:hidden property="txtSearchFields" name="frmDeptPayFixForm"  />
<html:hidden property="txtDisplayFields" name="frmDeptPayFixForm"  />
<html:hidden property="txtIndex" name="frmDeptPayFixForm"  />
<html:hidden property="txtEmpNo" name="frmDeptPayFixForm"  />
<html:hidden property="newCateg" name="frmDeptPayFixForm"  />
<html:hidden property="newCategDesc" name="frmDeptPayFixForm"  />
<html:hidden property="payScaleCode" name="frmDeptPayFixForm"  />
<html:hidden property="hdnStartBasic" name="frmDeptPayFixForm"  />
<html:hidden property="hdnEndBasic" name="frmDeptPayFixForm"  />
<html:hidden property="txtPayType" name="frmDeptPayFixForm"  />
<html:hidden property="txtInputField" name="frmDeptPayFixForm"  />
<html:hidden property="cancelStatus" name="frmDeptPayFixForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function ShowEmpNum()
{
    frmDeptPayFixForm.lovKey.value = "DeptPayFix" + frmDeptPayFixForm.screenName.value + frmDeptPayFixForm.screenMode.value; 
    if(document.all.screenMode.value=='N')
      frmDeptPayFixForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtDsgn,txtCateg,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtDOJSite,txtCurtBasic,txtPayType,txtStagInc,txtDsgnDesc,payScaleCode,payBand,gradePay";
    else
      frmDeptPayFixForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
    frmDeptPayFixForm.queryParam.value = "txtSiteID="+frmDeptPayFixForm.loginLocCode.value+",hdnEmpLbrFlag="+frmDeptPayFixForm.hdnEmpLbrFlag.value;
    frmDeptPayFixForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
    frmDeptPayFixForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptPayFixForm');
    return true;
}    
function onExclude()
{

  if (frmDeptPayFixForm.txtFixationFlag.value=='E')
  {

        document.getElementById("newBasic").style.background="#E8E8E8";
        document.getElementById("newBasic").readonly="true"
        document.getElementById("newBasic").disabled="true"
  }
  else
  { 
       
       document.getElementById("newBasic").style.background="#ffffd3";
       document.getElementById("newBasic").readonly="false"
       document.getElementById("newBasic").disabled=""
  }
}

function ShowLovDsgn()
{
    if(frmDeptPayFixForm.promType.value=="")
    {
        alert("Please Select Promotion/Reversal Type First!");
        frmDeptPayFixForm.promType.focus();
        return false;
    }
    else
    {
        frmDeptPayFixForm.lovKey.value = "DeptPromoDsgn" + frmDeptPayFixForm.screenName.value + frmDeptPayFixForm.screenMode.value;
        frmDeptPayFixForm.txtDisplayFields.value = "newDsgnDesc,newDsgn,newCateg,newCategDesc,payScaleCode,payScaleCodeDesc";
        frmDeptPayFixForm.queryParam.value = "txtPromoType="+frmDeptPayFixForm.promType.value+",txtCategory="+frmDeptPayFixForm.txtCateg.value+" ";   
        frmDeptPayFixForm.txtSearchFields.value = "";
        frmDeptPayFixForm.txtInputField.value =""; 
        frmDeptPayFixForm.txtIndex.value =""; 
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptPayFixForm');
        return true;
    }
}
function chkIDAType()
{

var emptype=frmDeptPayFixForm.txtEmpType.value
if (emptype=="IDA") 
{
 document.getElementById("newGradePay").style.background="#E8E8E8";

 document.getElementById("newGradePay").readonly="true"
  document.getElementById("newGradePay").disabled="true"
}
}

function lfnLoad()
{
    mode = document.all.screenMode.value;    
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {  
        chkIDAType();
        onExclude();
        document.all.txtCateg.disabled = "true";
        //document.all.txtDsgn.disabled = "true";      
        //document.all.headerPrimaryKey.disabled = "true";          
    } 
    //checkPromoType();
    if(mode=='E')
      disableMenu();
      else
      hedMenuHandling(mode);   
    document.all.butInsertMode.disabled = "true"; 
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg"; 
    document.getElementById("newGradePay").disabled="true"
    document.all.butSave.disabled="true";
    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.butInsertMode.disabled='true'; 
    frmDeptPayFixForm.action="../../../DeptPayFixQueryMode.do"
    frmDeptPayFixForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmDeptPayFixForm.action="../../../DeptPayFixRefresh.do"
    frmDeptPayFixForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmDeptPayFixForm.action="../../../DeptPayFixNewMode.do"
    frmDeptPayFixForm.submit();
}

function getHeaderRecord()
{
        document.all.buttonFlag.value='';
        document.all.butExecute.disabled="true";
        document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		
        
        frmDeptPayFixForm.action="../../../DeptPayFixGetHeaderAction.do"
        frmDeptPayFixForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmDeptPayFixForm.userPositionRequested.value = 1*frmDeptPayFixForm.positionRequested.value + 1;
    frmDeptPayFixForm.action="../../../DeptPayFixGetNextHeader.do";
    frmDeptPayFixForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmDeptPayFixForm.userPositionRequested.value = 1*frmDeptPayFixForm.positionRequested.value - 1;
    frmDeptPayFixForm.action = "../../../DeptPayFixGetPrevHeader.do";
    frmDeptPayFixForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmDeptPayFixForm.userPositionRequested.value = 1*frmDeptPayFixForm.newPositionRequested.value;
    frmDeptPayFixForm.action = "../../../DeptPayFixGetNextHeader.do";
    frmDeptPayFixForm.submit();
}


function cancelPromotion()
{
    alert("Cancel Promotion");
}

function SaveRecord()
{
    document.all.buttonFlag.value=''; 
     
        if(mandatory_Check("frmDeptPayFixForm"))
        {
            frmDeptPayFixForm.txtEmpNo.value=frmDeptPayFixForm.headerPrimaryKey.value;                                 
            frmDeptPayFixForm.detailDataChanged.value = "false";             
            frmDeptPayFixForm.headerDataChanged.value = "true";    
            frmDeptPayFixForm.headerFields.value = "true"; 
            document.getElementById("newStagInc").disabled = "";
			  document.all.butSave.disabled="true";
			  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";

            frmDeptPayFixForm.action = "../../../DeptPayFixSaveAction.do";            
            frmDeptPayFixForm.submit();
          }
    //}  
    else
    {
        return false;
    }
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

function checkPromEffDate(cdate)
{
    if (trim(cdate) == "" || frmDeptPayFixForm.txtPrvPromDate.value=='N')
    {
        return true;
    }
    if (frmDeptPayFixForm.promType.value=="PROMTYPE$ADHOC")
    {
        var arr=cdate.split("-");
        var uyear=arr[2];                
        uyear=parseInt(uyear)+1;                
        var retDate=arr[0] + "-" + arr[1] + "-" + uyear;       
        frmDeptPayFixForm.adhcPromEndDate.value=retDate;
    }
    
    var prevDate=frmDeptPayFixForm.txtPrvPromDate.value;
    var promDate=frmDeptPayFixForm.newPromEffDate.value;
     var promDate1=frmDeptPayFixForm.newPromEffDate1.value;
    if (!cmpDate(prevDate,promDate,0))
    {
      alert("Promotion Date Cannot be Less then Prev. Promotion Date"); 
      document.all.newPromEffDate.value="";
      document.all.newPromEffDate1.value="";
      return false;                      
    }      
        return true;
}

function checkAdhocPromEffDate(cdate)
{
    if (trim(cdate) == "" || frmDeptPayFixForm.txtPrvPromDate.value=='N')
    {
        return true;
    }
    if(frmDeptPayFixForm.newPromEffDate.value!= '')
    {
        firstIndex=cdate.indexOf("-");
        lastIndex=cdate.lastIndexOf("-");        
        if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
        {
            var arr=cdate.split("-");
            var arrDOJF=frmDeptPayFixForm.newPromEffDate.value.split("-");
            var cyear= arr[2];            
            var dyear=arrDOJF[2];
            var monIndx=getMonthIndx(arr[1]);            
            var dmonIndx=getMonthIndx(arrDOJF[1]);  
             
            if(monIndx!=-1)
            {
                cdate = arr[0] + "/" + monIndx + "/" + cyear;  		
                ddate = arrDOJF[0] + "/" + dmonIndx + "/" + dyear;  		
            }    
        }
        //cdate = change_DateFormat(cdate);  
        sysDate = getSysDate(); 
        if (dateDiff(ddate, cdate) < 0 )
        {
            alert("Adhoc Promotion Date Cannot be Less then New Promotion Date");        
            
            frmDeptPayFixForm.adhcPromEndDate.value="";
            return false;
        }          
        return true;
    }
    
    
}

function checkCurBasicLimit()
{
    var curBasic;
    var startBasic;
    var endBasic;
    var curBasic;     
    curBasic = parseInt(frmDeptPayFixForm.newBasic.value);
    startBasic =parseInt(frmDeptPayFixForm.hdnStartBasic.value); 
    endBasic = parseInt(frmDeptPayFixForm.hdnEndBasic.value); 
    alert(startBasic);
    alert(endBasic);
    if(curBasic < startBasic || curBasic > endBasic)
    {
        alert("New Basic Should be In Range "+startBasic+" To "+endBasic);
        frmDeptPayFixForm.newBasic.select();
        frmDeptPayFixForm.newBasic.focus();
        return false;
    }    
    else
        return true;
}

function onChangePromoType(val)
{   
    if (val=='PROMTYPE$ADHOC')
    {        
        document.getElementById("adhcPromEndDate").disabled = ""; 
        document.getElementById("adhcPromEndDate").style.background="#ffffd3";
        document.getElementById("adhcPromEndDate").style.className="required";        
        
        document.getElementById("remarks").disabled = "";     
        document.getElementById("remarks").value = "";
        document.getElementById("remarks").style.background="#ffffff";
        document.getElementById("remarks").style.className="optional";
        
        document.getElementById("newStagInc").disabled = "true";     
        document.getElementById("newStagInc").value = "0";
        document.getElementById("newStagInc").style.background="#ffffff";
        document.getElementById("newStagInc").style.className="locked";
    }
    else if (val=='PROMTYPE$OTHER')
    {
        document.getElementById("remarks").disabled = ""; 
        document.getElementById("remarks").style.background="#ffffd3";
        document.getElementById("remarks").style.className="required";
        
        document.getElementById("adhcPromEndDate").disabled = "true";     
        document.getElementById("adhcPromEndDate").value = "";
        document.getElementById("adhcPromEndDate").style.background="#ffffff";
        document.getElementById("adhcPromEndDate").style.className="optional";
        
        document.getElementById("newStagInc").disabled = "true";     
        document.getElementById("newStagInc").value = "0";
        document.getElementById("newStagInc").style.background="#ffffff";
        document.getElementById("newStagInc").style.className="locked";
    }    
    else if (val=='PROMTYPE$REVRS')
    {
        document.getElementById("newStagInc").disabled = ""; 
        document.getElementById("newStagInc").value = "";
        document.getElementById("newStagInc").style.background="#ffffd3";
        document.getElementById("newStagInc").style.className="optional";
        
        document.getElementById("adhcPromEndDate").disabled = "true";     
        document.getElementById("adhcPromEndDate").value = "";
        document.getElementById("adhcPromEndDate").style.background="#ffffff";
        document.getElementById("adhcPromEndDate").style.className="optional";
        
        document.getElementById("remarks").disabled = "";     
        document.getElementById("remarks").value = "";
        document.getElementById("remarks").style.background="#ffffff";
        document.getElementById("remarks").style.className="optional";
    }
   else
   {
        document.getElementById("adhcPromEndDate").disabled = "true";     
        document.getElementById("adhcPromEndDate").value = "";
        document.getElementById("adhcPromEndDate").style.background="#ffffff";
        document.getElementById("adhcPromEndDate").style.className="optional"; 
        
        document.getElementById("remarks").disabled = "";     
        document.getElementById("remarks").value = "";
        document.getElementById("remarks").style.background="#ffffff";
        document.getElementById("remarks").style.className="optional"; 
        
        document.getElementById("newStagInc").disabled = "true";     
        document.getElementById("newStagInc").value = "0";
        document.getElementById("newStagInc").style.background="#ffffff";
        document.getElementById("newStagInc").style.className="locked";
    } 
}

function checkPromoType()
{
    if (document.all.promType.value=="PROMTYPE$ADHOC")
    {
        document.getElementById("adhcPromEndDate").disabled = "";
        document.getElementById("adhcPromEndDate").style.background="#ffffd3";
        document.getElementById("adhcPromEndDate").style.className="required";
    }
    else if (document.all.promType.value=="PROMTYPE$OTHER")
    {
        document.getElementById("remarks").disabled = "";
        document.getElementById("remarks").style.background="#ffffd3";
        document.getElementById("remarks").style.className="required";
    }
    else
    {    
        document.getElementById("adhcPromEndDate").disabled = "true";     
        document.getElementById("adhcPromEndDate").value = "";
        document.getElementById("adhcPromEndDate").style.background="#ffffff";
        document.getElementById("adhcPromEndDate").style.className="optional";
        
        document.getElementById("remarks").disabled = "true";     
        document.getElementById("remarks").value = "";
        document.getElementById("remarks").style.background="#ffffff";
        document.getElementById("remarks").style.className="optional";
    }
}
    
</script>