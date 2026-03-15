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
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintEmpIncrDetailBase" name="frmEmpIncrForm" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpIncrForm">
<bean:define id="ParentForm" name="frmEmpIncrForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE INCREMENT INFORMATION</TD>
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
                  <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="N">                   
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNumNew();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmEmpIncrForm" value="N">
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>                  
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td>                                 
              </TR> 
                                
              <TR>              
                  <TD width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.StaffCode" /></TD>
                  <td align="left">
                  <html:text property="txtStaffCode" styleClass="locked" readonly="true" size="23"/>                                                                       
                  </td>
                  
                  <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /> </td>                            
                  <td ><html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/></td>                                     
              </tr>
                      
              <tr>              
                  <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCateg" styleClass="locked" readonly="true" size="23"/><html:hidden property="txtCategDesc"  styleClass="locked" /></td>                                     
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td><html:text  property="txtPresentPOP" altKey="pay.EmpInfo.PresentPOP" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   />                  
                  </td> 
              </tr>    
              <tr>
                  <td class=labelText width="20%" ><bean:message key="Payroll.EmpInfo.pcode" /> </td>            
                  <td><html:text  property="txtPayScaleCode" altKey="Payroll.EmpInfo.pcode" maxlength="10" size="23" styleClass="locked" onchange="lfnChanged(this.value);" readonly="true"/>                                               
                  </td>                                                            
      
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.curbas" /> </td>            
                  <td>
                  <html:text  property="txtCurtBasic" altKey="Payroll.EmpInfo.curbas" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>   
      
              <tr>
                  <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.inrstat" /> </td>                            
                  <td ><html:text  property="txtInrSt" altKey="Payroll.EmpInfo.inrstat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td> 
                  
                  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pstchdate" /></td>
                  <td ><html:text  property="txtPayStsChnDate" styleClass = "locked" altKey="Payroll.EmpInfo.pstchdate" maxlength="15" size="23" onchange="checkPayStatDate(this.value); lfnChanged(this.value)" readonly="true"/></td>
                  
              </tr>             
              
           <tr>
              
              <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.gpay" /> </td>                            
                  <td ><html:text  property="txtGradePay" altKey="Payroll.EmpInfo.gpay" maxlength="15" size="23" styleClass="locked" readonly="true"/>
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
                <td bgcolor="#4682B4" nowrap class=actTabText >Advance Increment Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("stagnation")> Stagnation Increment Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <!-- <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("StopRlsIncrDet")> Stop/Release Increment<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td> -->
                
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
                    <TD>
  			<!-- Detail table starts -->
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR width="100%">                          
                          <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.advIncrType" /></td>                          
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="N">                              
                          <td colspan="1" ><html:select  property="txtAdvIncrType" styleClass = "required" style="width:50%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>                              
                          <html:option value="C" > <bean:message key="Payroll.EmpInfo.cumulative" /></html:option>                               
                          <html:option value="W" > <bean:message key="Payroll.EmpInfo.wCumulative" /></html:option>
                          </html:select>
                          </td>
                          </logic:equal>                                                                                                 
                          <logic:notEqual property= "screenMode" name= "frmEmpIncrForm" value="N"> 
                          <td colspan="1" ><html:select  property="txtAdvIncrType" styleClass="optional"  disabled="true" style="width:49%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>                              
                          <html:option value="C" > <bean:message key="Payroll.EmpInfo.cumulative" /></html:option>                               
                          <html:option value="W" > <bean:message key="Payroll.EmpInfo.wCumulative" /></html:option>
                          </html:select>
                          </logic:notEqual> 
                          </td>
                          
                          
                          <!--td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.advIncrAmnt"  /></td-->
                          <!--td colspan="1"  maxlength="50" size="23"  style="text-align:right" readonly="true"-->                        
                          <html:hidden property="txtAdvIncrAmnt"  styleClass = "locked" alt="<%=String.valueOf(i)%>"   /></td>                                                                                 
                                              
                      </tr> 

                      <tr>   
                          <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.advIncrNo" /></td>                          
                          <td colspan="1" >
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="N">                              
                          <html:text property="txtAdvIncrNo" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="2" size="23" onkeypress="
                           if((event.keyCode < 49 || event.keyCode > 57))
                            {
                              return false;
                            };                            
                                  lfnChanged(this.value);
                             "  style="text-align:right" /></td>                                                                                 
                          </logic:equal>
                          <logic:notEqual property= "screenMode" name= "frmEmpIncrForm" value="N"> 
                          <html:text property="txtAdvIncrNo" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="2" size="23" style="text-align:right" readonly="true"/></td>                                                                                 
                          </logic:notEqual>
                        
                          <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.incrEffDate" /> </td>            
                          <td colspan="1">
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="N">                                                      
                          <html:text  property="txtAdvIncrEffDate"  maxlength="10" size="23" styleClass="required" readonly="true" onchange="lfnChanged(this.value); dateValidationCheck(this.value);" /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="txtAdvIncrEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtAdvIncrEffDate',this)" /></td>
                          </logic:equal>
                          <logic:notEqual property= "screenMode" name= "frmEmpIncrForm" value="N"> 
                          <html:text  property="txtAdvIncrEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true" onchange="lfnChanged(this.value);" /></td>
                          </logic:notEqual>
                      </tr>
                    
                      <tr height = 3><td colspan=4>&nbsp;</td></tr>                    
                      <tr height = 3><td colspan=4>&nbsp;</td></tr>                    
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
<html:hidden name="frmEmpIncrForm"  property="screenName" value="MaintEmpAdvIncrScreen" />
<html:hidden name="frmEmpIncrForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpIncrForm" />
<html:hidden property="loginLocCode" name="frmEmpIncrForm" />
<html:hidden property="positionRequested" name="frmEmpIncrForm" />
<html:hidden property="userPositionRequested" name="frmEmpIncrForm" />
<html:hidden property="buttonFlag" name="frmEmpIncrForm"  />
<html:hidden property="lovKey" name="frmEmpIncrForm"  />
<html:hidden property="txtFields" name="frmEmpIncrForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpIncrForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpIncrForm"  />
<html:hidden property="txtIndex" name="frmEmpIncrForm"  />
<html:hidden property="txtEmpNo" name="frmEmpIncrForm"  />

<html:hidden property="incrAction" name="frmEmpIncrForm"  />
<html:hidden property="txtIncrEffTill" name="frmEmpIncrForm"  />
<html:hidden property="payYYMM" name="frmEmpIncrForm"  />
<!--html:hidden property="txtGradePay" name="frmEmpIncrForm"  /-->




<input type="hidden" name="queryParam" />
<input type="hidden" name="cpfCode" />
<!--input type="hidden" name="gradePay" /-->




</html:form>
</body>
</html:html>

<script language="javascript">

function ShowEmpNum()
{
    frmEmpIncrForm.lovKey.value = "EmpIncr" + frmEmpIncrForm.screenName.value + frmEmpIncrForm.screenMode.value;     
    frmEmpIncrForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtStaffCode,txtDsgn,txtCateg,txtPresentPOP,txtCurtBasic,txtPayScaleCode,txtInrSt,txtPayStsChnDate,txtGradePay";
    frmEmpIncrForm.queryParam.value = "txtSiteID="+frmEmpIncrForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpIncrForm.hdnEmpLbrFlag.value;
    frmEmpIncrForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
    frmEmpIncrForm.txtIndex.value ="";     
    
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpIncrForm');
    return true;
}

function ShowEmpNumNew()
{
    
    frmEmpIncrForm.lovKey.value = "EmpIncr" + frmEmpIncrForm.screenName.value + frmEmpIncrForm.screenMode.value;     
    frmEmpIncrForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtStaffCode,txtDsgn,txtCateg,txtPresentPOP,txtCurtBasic,txtPayScaleCode,txtInrSt,txtPayStsChnDate,txtGradePay";
    frmEmpIncrForm.queryParam.value = "txtSiteID="+frmEmpIncrForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpIncrForm.hdnEmpLbrFlag.value;
    frmEmpIncrForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
    frmEmpIncrForm.txtIndex.value ="";     
    
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpIncrForm');
    return true;
}

function fillSubsEffDate(val)
{    
    document.all.subsEffDate.value=val;
}

function lfnChanged(val)
{
    frmEmpIncrForm.headerDataChanged.value = "true";
}

function lfnLoad()
{
    mode = document.all.screenMode.value;
  //  alert('mode '+mode);
    if(mode == '')
    {
        doQueryMode();
    }
    hedMenuHandling(mode); 
    
    if(mode != 'N')
    {
      document.all.forwardedPage.value="advincrdtl";
      document.all.butSave.disabled = "true";
    }
    
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpIncrForm.action="../../../EmpIncrQueryMode.do"
    frmEmpIncrForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpIncrForm.action="../../../EmpIncrRefresh.do"
    frmEmpIncrForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpIncrForm.action="../../../EmpIncrNewMode.do"
    frmEmpIncrForm.submit();
}

function getHeaderRecord()
{
  //  if(mandatory_Check("frmEmpIncrForm"))
   // { 
        document.all.buttonFlag.value='';
        frmEmpIncrForm.action="../../../EmpIncrFirstGetHeaderAction.do"
        frmEmpIncrForm.submit();
    //}
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpIncrForm.userPositionRequested.value = 1*frmEmpIncrForm.positionRequested.value + 1;
    frmEmpIncrForm.action="../../../EmpIncrGetNextHeader.do";
    frmEmpIncrForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpIncrForm.userPositionRequested.value = 1*frmEmpIncrForm.positionRequested.value - 1;
    frmEmpIncrForm.action = "../../../EmpIncrGetPrevHeader.do";
    frmEmpIncrForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpIncrForm.userPositionRequested.value = 1*frmEmpIncrForm.newPositionRequested.value;    
    frmEmpIncrForm.action = "../../../EmpIncrGetNextHeader.do";
    frmEmpIncrForm.submit();
}

function cancelSuspension()
{
    alert("Cancel Suspension");
}

function SaveRecord()
{     
    //var sEffdate=document.all.suspEffDate.value;
    //var subEffdate=document.all.subsEffDate.value;
//    alert('hi');
    if(mandatory_Check("frmEmpIncrForm"))
    {          
        //if (cmpSuspDate(sEffdate, subEffdate, 0))
       // {
            frmEmpIncrForm.txtEmpNo.value=frmEmpIncrForm.headerPrimaryKey.value;                     
            frmEmpIncrForm.detailDataChanged.value = "false";             
            frmEmpIncrForm.headerDataChanged.value = "true";    
            frmEmpIncrForm.headerFields.value = "true";                 
			document.all.butSave.disabled="true";
			document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
            document.all.forwardedPage.value="advincrdtl";
            frmEmpIncrForm.action = "../../../EmpIncrSaveAction.do";            
            frmEmpIncrForm.submit();
      //  }    
    }
    else
    {
        return false;
    }
}

function cmpSuspDate(date1,date2, flag)
{
	if (trim(date1) == "")
	{
		return true;
	}

	date1 = change_DateFormatMon(date1);
	sysDate = change_DateFormatMon(date2);
	
	if (flag == 0)
	{
		if (dateDiff(sysDate, date1) > 0)
		{
			alert("Subsistence Date cannot be Less than the Suspension date!");
      document.all.subsEffDate.select();
      document.all.subsEffDate.focus();
		//	event.srcElement.select();
		//	event.srcElement.focus();
			return false;
		}
	}
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

function doGetTab(arg)
{  
    if(document.all.screenMode.value=='U')
    {
      return false;
    }
    document.all.forwardedPage.value=arg;
   // document.all.screenMode.value="Q";
    document.forms[0].action="../../../EmpStopRlsIncrTabAction.do";
    document.forms[0].submit(); 
}



function getTab(arg)
{    
	document.all.forwardedPage.value=arg;
	//document.forms[0].action="../../../PenaltyWaiverTabAction.do";
	document.forms[0].action="../../../AdvanceIncrementDetailsTabAction.do";
	document.forms[0].submit();
}


function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
   // document.all.screenMode.value="Q";
    document.forms[0].action="../../../EmpStopRlsIncrTabAction.do";
    document.forms[0].submit(); 
}

function comboChange()
{
    document.all.headerDataChanged.value = "true";
}
//Added By Abdul on 20-may-2015
function dateValidationCheck(val)
{

   payyyMM=frmEmpIncrForm.payYYMM.value;
    curDate=getyrmm(val);
   
    if(!(payyyMM==curDate || curDate < payyyMM))
    {
        alert("Date should be within current payroll month \n Current Payroll Year Month is "+payyyMM);
        document.all.txtAdvIncrEffDate.value='';
    }


}   
    
</script>