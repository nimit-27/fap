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
<html:form  action="EmpReinstateDetailBase" name="frmEmpReinstForm" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpReinstateForm">
<bean:define id="ParentForm" name="frmEmpReinstForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE REINSTATE INFORMATION</TD>
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
                  <logic:equal property= "screenMode" name= "frmEmpReinstForm" value="N">                   
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmEmpReinstForm" value="N">
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmEmpReinstForm" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>                  
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td>               
                  
              </TR> 
                                
              <TR>              
                  <TD width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                                             
                  </td>
                  
                  <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/><html:hidden property="txtCateg"  styleClass="locked" /></td>                                     
              </tr>
                      
              <tr>              
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                    
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   /></td>                                                                  
              </tr>    
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td><html:text  property="txtPresentPOP" altKey="pay.EmpInfo.PresentPOP" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   />                  
                  </td>                                                            
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>   
      
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text  property="txtEmpStatus" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
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
                <td bgcolor="#4682B4" nowrap class=actTabText > Reinstate Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                        <TR width="100%">                          
                          <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.reinstEffDate" /></td>
                          <td >
                          <logic:equal property= "screenMode" name= "frmEmpReinstForm" value="N">                   
                          <html:text  property="reinstEffDate" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:left" readonly="true" onchange=""/>
                          <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="reinstEffDate" alt="<%=(i-1) %>" onclick="showCalendar('reinstEffDate',this)" />                                                   
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmEmpReinstForm" value="N"> 
                          <html:text  property="reinstEffDate" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:left" readonly="true" onchange=""/>
                          </logic:notEqual> 
                          </td>  
                          
                          <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.reinstReason" /></td>
                          <td colspan="1">
                          <logic:equal property= "screenMode" name= "frmEmpReinstForm" value="N"> 
                          <html:text property="reinstReason" styleClass = "optional" alt="<%=String.valueOf(i)%>" maxlength="190" size="23" style="text-align:left"  onchange="lfnChanged(this.value);"/>                                                                                
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmEmpReinstForm" value="N"> 
                          <html:text property="reinstReason" styleClass = "locked" alt="<%=String.valueOf(i)%>" size="23" style="text-align:left" readonly="true" onchange="lfnChanged(this.value);"/>                                                                                
                          </logic:notEqual> 
                          </td> 
                    </tr> 

                    <tr>   
                        <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.intervngPrd" /> </td>                            
                        <td  colspan="1">
                        <logic:equal property= "screenMode" name= "frmEmpReinstForm" value="N"> 
                        <html:select property="intervngPrd"  styleClass="required" alt="<%=String.valueOf(i)%>" style="width:50%" onchange="" >
                        <html:option value="" >-----------Please Select-----------</html:option>      
                        <logic:present name="Reinstate">
                        <html:optionsCollection label="label" value="value" property="intervPrdList" name="Reinstate"/>
                        </logic:present>                       
                        </html:select>
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmEmpReinstForm" value="N"> 
                        <html:select property="intervngPrd"  styleClass="optional" disabled="true" alt="<%=String.valueOf(i)%>" style="width:50%" onchange="" >
                        <html:option value="" >-----------Please Select-----------</html:option>      
                        <logic:present name="Reinstate">
                        <html:optionsCollection label="label" value="value" property="intervPrdList" name="Reinstate"/>
                        </logic:present>
                        </html:select>
                        </logic:notEqual> 
                        </td>                                                      
                    
                    </tr>
                    
                    <tr height = 3><td>&nbsp;</td></tr>                    
                    <tr height = 3><td>&nbsp;</td></tr>                    
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
<html:hidden name="frmEmpReinstForm"  property="screenName" value="EmpReinstateScreen" />
<html:hidden name="frmEmpReinstForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpReinstForm" />
<html:hidden property="loginLocCode" name="frmEmpReinstForm" />
<html:hidden property="positionRequested" name="frmEmpReinstForm" />
<html:hidden property="userPositionRequested" name="frmEmpReinstForm" />
<html:hidden property="buttonFlag" name="frmEmpReinstForm"  />
<html:hidden property="lovKey" name="frmEmpReinstForm"  />
<html:hidden property="txtFields" name="frmEmpReinstForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpReinstForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpReinstForm"  />
<html:hidden property="txtIndex" name="frmEmpReinstForm"  />
<html:hidden property="txtEmpNo" name="frmEmpReinstForm"  />

<html:hidden property="reinstId" name="frmEmpReinstForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function ShowEmpNum()
{
   frmEmpReinstForm.lovKey.value = "EmpReinst" + frmEmpReinstForm.screenName.value + frmEmpReinstForm.screenMode.value; 
   
       //frmEmpReinstForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,lstCateg,txtDsgn";
       frmEmpReinstForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtDOJSite";
       frmEmpReinstForm.queryParam.value = "txtSiteID="+frmEmpReinstForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpReinstForm.hdnEmpLbrFlag.value;
       frmEmpReinstForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName";
       frmEmpReinstForm.txtIndex.value ="";      
   
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpReinstForm');
   return true;
}

function fillSubsEffDate(val)
{    
    var systDate = getSysDate();      
    if(cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        document.all.subsEffDate.value=val;
        return true;        
    }
    else
    {
        document.all.suspEffDate.value="";     
        return false;
    }        
}

function lfnChanged(val)
{
    frmEmpReinstForm.headerDataChanged.value = "true";
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
         document.all.txtCateg.disabled = "true";
        //document.all.txtDsgn.disabled = "true";      
        //document.all.headerPrimaryKey.disabled = "true";          
    } 
    hedMenuHandling(mode);    
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpReinstForm.action="../../../EmpReinstQueryMode.do"
    frmEmpReinstForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpReinstForm.action="../../../EmpReinstRefresh.do"
    frmEmpReinstForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpReinstForm.action="../../../EmpReinstNewMode.do"
    frmEmpReinstForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

    frmEmpReinstForm.action="../../../EmpReinstGetHeaderAction.do"
    frmEmpReinstForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpReinstForm.userPositionRequested.value = 1*frmEmpReinstForm.positionRequested.value + 1;
    frmEmpReinstForm.action="../../../EmpReinstGetNextHeader.do";
    frmEmpReinstForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpReinstForm.userPositionRequested.value = 1*frmEmpReinstForm.positionRequested.value - 1;
    frmEmpReinstForm.action = "../../../EmpReinstGetNextHeader.do";
    frmEmpReinstForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpReinstForm.userPositionRequested.value = 1*frmEmpReinstForm.newPositionRequested.value;
    frmEmpReinstForm.action = "../../../EmpReinstGetNextHeader.do";
    frmEmpReinstForm.submit();
}


function cancelSuspension()
{
    alert("Cancel Suspension");
}

function SaveRecord()
{        
    if(mandatory_Check("frmEmpReinstForm"))
    {          
        
            frmEmpReinstForm.txtEmpNo.value=frmEmpReinstForm.headerPrimaryKey.value;                     
            frmEmpReinstForm.detailDataChanged.value = "false";             
            frmEmpReinstForm.headerDataChanged.value = "true";    
            frmEmpReinstForm.headerFields.value = "true";                 
			document.all.butSave.disabled="true";
			document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
            frmEmpReinstForm.action = "../../../EmpReinstSaveAction.do";            
            frmEmpReinstForm.submit();
        
    }
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
            return true;
        }
    }
}

function doGetTab(arg)
{  
    mode = document.all.screenMode.value;
    if(mode == 'N' || mode == 'Q')
    {
        return false;
    }
    else
    {
        document.all.forwardedPage.value=arg;
        document.forms[0].action="../../../EmpRevokTabAction.do";
        document.forms[0].submit(); 
    }    
}


function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpRevokTabAction.do";
    document.forms[0].submit(); 
}
    
</script>