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
<html:form  action="MaintEmpStopRlsIncrDetailBase" name="frmEmpIncrForm" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpIncrForm">
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
                <td bgcolor="#76A2C7" id="adv1" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap id="adv2" class=disTabText onclick=doGetTabs("IncrDet")>Advance Increment Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td id="adv3" ><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText > Stop/Release Increment<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                    <TD>
  			<!-- Detail table starts -->
                     <TABLE width="100%" cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR width="100%">    
                          
                          <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.inrstat" /></td>             
                          <logic:notEqual property= "screenMode" name= "frmEmpIncrForm" value="N"> 
                          <td colspan="1" width="23%" >
                          <html:select  property="incrAction" styleClass="optional"  disabled="true" style="width:50%" onchange="comboChange();" >                             
                          <html:option value="R" > <bean:message key="Payroll.EmpInfo.rls" /></html:option>  
                          </html:select>
                          </logic:notEqual> 
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="N"> 
                          <td colspan="1" width="23%" >
                          <html:select  property="incrAction" styleClass="optional"  disabled="true" style="width:50%" onchange="comboChange();" >                             
                          <html:option value="S" > <bean:message key="Payroll.EmpInfo.stp" /></html:option> 
                          </html:select>
                          </logic:equal> 
                          </td>
                      
                          <td width="15%" class=labelText  >Effective From </td>            
                          <td width="23%">
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="N">                                                      
                          <html:text  property="txtAdvIncrEffDate"  maxlength="10" size="23" styleClass="required" readonly="true" onchange="lfnChanged(this.value);" /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="txtIncrEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtAdvIncrEffDate',this)" /></td>
                          </logic:equal>
                          <logic:notEqual property= "screenMode" name= "frmEmpIncrForm" value="N"> 
                          <html:text  property="txtAdvIncrEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true" onchange="lfnChanged(this.value);" /></td>
                          </logic:notEqual>                         
                          
                    </tr>                       
                    
                    <TR width="100%">    
                      
                          <td width="15%" class=labelText  >Effective Till </td>            
                          <td width="23%">
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="N">                                                      
                          <html:text  property="txtIncrEffTill"  maxlength="10" size="23" styleClass="optional" readonly="true" onchange="lfnChanged(this.value);" /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="butTxtIncrEffTill" alt="<%=(i-1) %>" onclick="showCalendar('txtIncrEffTill',this)" />
                          </logic:equal>
                          <logic:notEqual property= "screenMode" name= "frmEmpIncrForm" value="N"> 
                          <html:text  property="txtIncrEffTill"  maxlength="10" size="23" styleClass="locked" readonly="true" onchange="lfnChanged(this.value);" />
                          </logic:notEqual>                         
                          </td>
                          
                          <td width="15%" class=labelText  >No of Increment </td>            
                          <td width="23%">
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="N">                                                                                                            
                          <html:text  property="txtAdvIncrNo"  maxlength="10" size="23" styleClass="locked" onchange="lfnChanged(this.value);" />
                          </logic:equal>
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="Q">                                                                                                            
                          <html:text  property="txtAdvIncrNo"  maxlength="10" size="23" styleClass="locked" onchange="lfnChanged(this.value);" />
                          </logic:equal>
                          
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="U">
                          <logic:notEqual property= "txtInrSt" name= "frmEmpIncrForm" value="RELEASED">
                          <html:text  property="txtAdvIncrNo"  maxlength="10" size="23" styleClass="required" onchange="lfnChanged(this.value);" />
                          </logic:notEqual>
                          
                          <logic:notEqual property= "txtInrSt" name= "frmEmpIncrForm" value="STOPPED">
                          <html:text  property="txtAdvIncrNo"  maxlength="10" size="23" styleClass="locked" onchange="lfnChanged(this.value);" />
                          </logic:notEqual>
                          </logic:equal>                         
                          </td>
                    </tr>
                    
                    <TR width="100%">    
                      
                          <td width="15%" class=labelText  >Released on </td>            
                          <td width="23%">
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="N">                                                                                                            
                          <html:text  property="txtIncrRlsEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true" onchange="lfnChanged(this.value);" />
                          </logic:equal>
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="Q">                                                                                                            
                          <html:text  property="txtIncrRlsEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true" onchange="lfnChanged(this.value);" />
                          </logic:equal>
                          
                          <logic:equal property= "screenMode" name= "frmEmpIncrForm" value="U">    
                          <logic:notEqual property= "txtInrSt" name= "frmEmpIncrForm" value="RELEASED"> 
                          <html:text  property="txtIncrRlsEffDate"  maxlength="10" size="23" styleClass="required" readonly="true" onchange="lfnChanged(this.value);" /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="butTxtIncrEffTill" alt="<%=(i-1) %>" onclick="showCalendar('txtIncrRlsEffDate',this)" />
                          </logic:notEqual>
                          
                          <logic:notEqual property= "txtInrSt" name= "frmEmpIncrForm" value="STOPPED"> 
                          <html:text  property="txtIncrRlsEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true" onchange="lfnChanged(this.value);" />
                          </logic:notEqual>
                          </logic:equal>
                          
                          </td>
                          
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
<html:hidden name="frmEmpIncrForm"  property="screenName" value="MaintEmpIncrScreen" />
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

<html:hidden property="txtAdvIncrType" name="frmEmpIncrForm" value="N" />
<html:hidden property="txtAdvIncrAmnt" name="frmEmpIncrForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function ShowEmpNum()
{
    frmEmpIncrForm.lovKey.value = "EmpIncr" + frmEmpIncrForm.screenName.value + frmEmpIncrForm.screenMode.value;   
    frmEmpIncrForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtStaffCode,txtDsgn,txtCateg,txtPresentPOP,txtCurtBasic,txtPayScaleCode,txtInrSt,txtPayStsChnDate";
    frmEmpIncrForm.queryParam.value = "txtSiteID="+frmEmpIncrForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpIncrForm.hdnEmpLbrFlag.value;
    frmEmpIncrForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
    frmEmpIncrForm.txtIndex.value ="";     
    
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpIncrForm');
    return true;
}

function ShowEmpNumNew()
{
    frmEmpIncrForm.lovKey.value = "EmpIncr" + frmEmpIncrForm.screenName.value + frmEmpIncrForm.screenMode.value;     
    frmEmpIncrForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtStaffCode,txtDsgn,txtCateg,txtPresentPOP,txtCurtBasic,txtPayScaleCode,txtInrSt,txtPayStsChnDate,txtAdvIncrAmnt";
    frmEmpIncrForm.queryParam.value = "txtSiteID="+frmEmpIncrForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpIncrForm.hdnEmpLbrFlag.value;
    frmEmpIncrForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
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
    
    if(mode == '')
    {
        doQueryMode();
    }
        
    hedMenuHandling(mode);
    //comboChange();
    if(document.all.hdnEmpLbrFlag.value!='E')
    {
      document.getElementById("adv1").style.display='none';
      document.getElementById("adv2").style.display='none';
      document.getElementById("adv3").style.display='none';
    }
    
    
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpIncrForm.action="../../../EmpStopRlsIncrQueryMode.do"    
    frmEmpIncrForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpIncrForm.action="../../../EmpStopRlsIncrRefresh.do"
    frmEmpIncrForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpIncrForm.action="../../../EmpStopRlsIncrNewMode.do"
    frmEmpIncrForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

    frmEmpIncrForm.action="../../../EmpStopRlsIncrFirstGetHeaderAction.do"
    frmEmpIncrForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpIncrForm.userPositionRequested.value = 1*frmEmpIncrForm.positionRequested.value + 1;
    frmEmpIncrForm.action="../../../EmpStopRlsIncrGetNextHeader.do";
    frmEmpIncrForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpIncrForm.userPositionRequested.value = 1*frmEmpIncrForm.positionRequested.value - 1;
    frmEmpIncrForm.action = "../../../EmpStopRlsIncrGetPrevHeader.do";
    frmEmpIncrForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpIncrForm.userPositionRequested.value = 1*frmEmpIncrForm.newPositionRequested.value;
    frmEmpIncrForm.action = "../../../EmpStopRlsIncrGetNextHeader.do";
    frmEmpIncrForm.submit();
}

function SaveRecord()
{  
   /* if(document.all.screenMode.value=='N')
        document.all.screenMode.value='U';*/
    if(mandatory_Check("frmEmpIncrForm"))
    {          
            frmEmpIncrForm.txtEmpNo.value=frmEmpIncrForm.headerPrimaryKey.value; 
            document.all.incrAction.disabled="";
            frmEmpIncrForm.detailDataChanged.value = "false";             
            frmEmpIncrForm.headerDataChanged.value = "true";    
            frmEmpIncrForm.headerFields.value = "true";                 
			document.all.butSave.disabled="true";
			document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
            frmEmpIncrForm.action = "../../../EmpStopRlsIncrSaveAction.do";            
            frmEmpIncrForm.submit();
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
    document.forms[0].action="../../../EmpIncrTabAction.do";
    document.forms[0].submit(); 
}


function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
   // document.all.screenMode.value="Q";
    document.forms[0].action="../../../EmpIncrTabAction.do";     
    document.forms[0].submit(); 
}

function comboChange()
{
    if(document.all.incrAction.value=='S')
    { 
      document.all.txtAdvIncrNo.disabled="true";
      document.all.txtAdvIncrNo.style.background="#e0e0e0";
      document.all.txtAdvIncrNo.style.className="locked";
      
      document.all.txtIncrEffTill.style.background="#ffffd3";
      document.all.txtIncrEffTill.style.className="required";
     // document.all.butTxtIncrEffTill.disabled="";
    }
    else
    {
      document.all.txtAdvIncrNo.disabled="";
      document.all.txtAdvIncrNo.style.background="#ffffd3";
      document.all.txtAdvIncrNo.style.className="required";
      
      document.all.txtIncrEffTill.style.background="#e0e0e0";
      document.all.txtIncrEffTill.style.className="locked";
    //  document.all.butTxtIncrEffTill.disabled="true";
    }
  //  frmDeptLabourInfoForm.headerDataChanged.value = "true";
}
    
</script>