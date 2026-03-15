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
<html:form  action="MaintEmpSuspensionDetailBase" name="frmEmpSuspensionForm" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpSuspensionForm">
<bean:define id="ParentForm" name="frmEmpSuspensionForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%
	String lbrType = (String)session.getAttribute("hdnEmpLbrFlag"); 
%>
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<% 
	String lbrDisplayName="";
	if (lbrType.equals("E"))
		lbrDisplayName = "EMPLOYEE";
	else 
		lbrDisplayName = "LABOUR";
%>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10><%=lbrDisplayName%> SUSPENSION/ABSCONDING/REVOCATION INFORMATION</TD>
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
            <TR>
     			<td colspan=2></td>
				<logic:equal name="frmEmpSuspensionForm" property="screenMode" value="U">
				<td width="10%" class="radioText"><input type="radio" name="radioPay" value="1" onclick="radClick()"  disabled ><bean:message  key="Payroll.Emp.Suspension" /></td>
				<td width="27%" class="radioText" ><input type="radio" name="radioPay" value="2" onclick="radClick()" disabled ><bean:message key="Payroll.Emp.Absconding"  /></td>
				</logic:equal>
				<logic:notEqual name="frmEmpSuspensionForm" property="screenMode" value="U">
				<td width="10%" class="radioText"><input type="radio" name="radioPay" value="1" onclick="radClick()"   ><bean:message  key="Payroll.Emp.Suspension" /></td>
				<td width="27%" class="radioText" ><input type="radio" name="radioPay" value="2" onclick="radClick()" ><bean:message key="Payroll.Emp.Absconding"  /></td>
				</logic:notEqual>
				<td colspan=2></td>
            </TR>
            <!--General Information Row Starts -->
            <TR>
              <TD class=subHeader colspan=6> Detail Information Of Employee</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="4"></td>
            </tr>           
            
            <tr></tr>
            <table  cellSpacing=0 cellPadding=0 border=0> 
            
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" colspan="3">
                  <logic:equal property= "screenMode" name= "frmEmpSuspensionForm" value="N">                   
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpSuspensionForm" value="N">
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpSuspensionForm" value="Q">                              
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
            <TR id="rowid1">   
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("SuspDet")> Suspension Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText > Revocation Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetSlrRlsTab("SalRlsDet")>Salary Release<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>

				<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetInvDtlsTab("InvDtlsDet")>Invoice Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>

                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
            <TR id="rowid2">   
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("SuspDet")> Suspension Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText > Revocation Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetInvDtlsTab("InvDtlsDet")>Invoice Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>

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
                        
                          <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.revokeEffDate" /></td>
                          <td >
                          <logic:equal name="frmEmpSuspensionForm" property="revokeDate" value="">
                          <html:text  property="revokeDate" styleClass = "required" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:left" onchange="checkSuspDate(this.value);" readonly="true" /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="revokeDate" alt="<%=(i-1) %>" onclick="showCalendar('revokeDate',this)" />
                          </logic:equal>
                          <logic:notEqual name="frmEmpSuspensionForm" property="revokeDate" value="">
                          <html:text  property="revokeDate" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:left" onchange="checkSuspDate(this.value);" readonly="true" />
                          </logic:notEqual>
                          </td> 
                          
						 <% if (lbrType.equals("E") || lbrType.equals("D")) { %>
                          <td  class=labelText  ><bean:message key="Payroll.EmpInfo.revokeType" /> </td>                            
                          <td  colspan="1">
                          <logic:equal name="frmEmpSuspensionForm" property="revokeType" value="">
                          <html:select property="revokeType"  styleClass="optional" alt="<%=String.valueOf(i)%>" style="width:60%" >
                          <html:option value="" >-----------Please Select-----------</html:option>      
                          <logic:present name="Suspension">
                          <html:optionsCollection label="label" value="value" property="valueRevokTypeList" name="Suspension"/>
                          </logic:present>
                          </html:select>
                          </logic:equal>
                          <logic:notEqual name="frmEmpSuspensionForm" property="revokeType" value="">
                          <html:select property="revokeType"  styleClass="locked" disabled="true" alt="<%=String.valueOf(i)%>" style="width:60%" >
                          <html:option value="" >-----------Please Select-----------</html:option>      
                          <logic:present name="Suspension">
                          <html:optionsCollection label="label" value="value" property="valueRevokTypeList" name="Suspension"/>
                          </logic:present>
                          </html:select>
                          </logic:notEqual>
                          </td>  
						 <% } %>
                    </tr> 

                    <tr>                    
                        <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.subsAllow" /></td>
                        <td colspan="1"><html:text  property="subsAllow" styleClass = "locked" readonly="true" alt="<%=String.valueOf(i)%>" maxlength="25" size="23" style="text-align:right" onchange="lfnChanged(val);" /></td>
                    
                        <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.subsEffDate" /> </td>            
                        <td>
                        <html:text  property="subsEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true"/>
                        </td>
                    </tr>
                    
                    <tr>                    
                        <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.revSubsAllow" /></td>
                        <td colspan="1"><html:text  property="revSubsAllow" styleClass = "locked" alt="<%=String.valueOf(i)%>" readonly="true" maxlength="25" size="23" style="text-align:right" onchange="lfnChanged(val);" /></td>
                    
                        <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.revSubsEffDate" /> </td>            
                        <td>
                        <html:text  property="revSubsEffDate"  maxlength="10" size="23" styleClass="locked" readonly="true"/>
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
<html:hidden name="frmEmpSuspensionForm"  property="screenName" value="EmpSuspensionScreen" />
<html:hidden name="frmEmpSuspensionForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpSuspensionForm" />
<html:hidden property="loginLocCode" name="frmEmpSuspensionForm" />
<html:hidden property="positionRequested" name="frmEmpSuspensionForm" />
<html:hidden property="userPositionRequested" name="frmEmpSuspensionForm" />
<html:hidden property="buttonFlag" name="frmEmpSuspensionForm"  />
<html:hidden property="lovKey" name="frmEmpSuspensionForm"  />
<html:hidden property="txtFields" name="frmEmpSuspensionForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpSuspensionForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpSuspensionForm"  />
<html:hidden property="txtIndex" name="frmEmpSuspensionForm"  />
<html:hidden property="txtEmpNo" name="frmEmpSuspensionForm"  />

<html:hidden property="suspId" name="frmEmpSuspensionForm"  />
<html:hidden property="suspEffDate" name="frmEmpSuspensionForm"  />
<html:hidden property="suspReason" name="frmEmpSuspensionForm"  />

<html:hidden property="txtYYMM" name="frmEmpSuspensionForm"  />
<html:hidden property="payYYMM" name="frmEmpSuspensionForm" />
<html:hidden property="radFlg" name="frmEmpSuspensionForm" />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function ShowEmpNum()
{
   frmEmpSuspensionForm.lovKey.value = "EmpSusp" + frmEmpSuspensionForm.screenName.value + frmEmpSuspensionForm.screenMode.value; 
   
       //frmEmpSuspensionForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,lstCateg,txtDsgn";
       frmEmpSuspensionForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtDOJSite";
       frmEmpSuspensionForm.queryParam.value = "txtSiteID="+frmEmpSuspensionForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpSuspensionForm.hdnEmpLbrFlag.value;
       frmEmpSuspensionForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName";
       frmEmpSuspensionForm.txtIndex.value ="";      
   
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpSuspensionForm');
   return true;
}

function lfnLoad()
{
    mode = document.all.screenMode.value;
    if(mode == '')
    {
        doQueryMode();
    }
    hedMenuHandling(mode);  
    document.all.butQueryMode.disabled="true";    
    document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";
    document.all.butInsertMode.disabled="true";    
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
	var radflg1=document.getElementsByName("radioPay");
	if(frmEmpSuspensionForm.radFlg.value==0)
	{
		radflg1[0].checked="true";
	}
	else
	{
		radflg1[1].checked="true";
	}

    if(document.all.revokeType.value!='')
    {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    }
	show_hideRow();
}

function show_hideRow()
{
	val = document.getElementById("radFlg").value;
	if(val=="1")
	{
		document.getElementById("rowid1").style.display='none';
		document.getElementById("rowid2").style.display='block';
	}
	else
	{
		document.getElementById("rowid1").style.display='block';
		document.getElementById("rowid2").style.display='none';
	}
}

function doQueryMode()
{
    return false;
    /*document.all.buttonFlag.value='';
    frmEmpSuspensionForm.action="../../../EmpRevocationQueryMode.do"
    frmEmpSuspensionForm.submit();*/
}

function doRefresh()
{
    /*document.all.buttonFlag.value=''; 
    frmEmpSuspensionForm.action="../../../EmpRevocationRefresh.do"
    frmEmpSuspensionForm.submit();*/
}

function doInsertMode()
{
    return false;
    /*if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.action="../../../EmpRevocationNewMode.do"
    frmEmpSuspensionForm.submit();*/
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

    frmEmpSuspensionForm.action="../../../EmpRevoFirstGetHeaderAction.do"
    frmEmpSuspensionForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.userPositionRequested.value = 1*frmEmpSuspensionForm.positionRequested.value + 1;
    frmEmpSuspensionForm.action="../../../EmpRevoGetNextHeader.do";
    frmEmpSuspensionForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.userPositionRequested.value = 1*frmEmpSuspensionForm.positionRequested.value - 1;
    frmEmpSuspensionForm.action = "../../../EmpRevoGetPrevHeader.do";
    frmEmpSuspensionForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.userPositionRequested.value = 1*frmEmpSuspensionForm.newPositionRequested.value;
    frmEmpSuspensionForm.action = "../../../EmpRevoGetNextHeader.do";
    frmEmpSuspensionForm.submit();
}


function cancelSuspension()
{
    alert("Cancel Suspension");
}

function SaveRecord()
{
     document.all.buttonFlag.value='';   
    if (document.getElementById("hdnEmpLbrFlag").value != 'L') //added by nitin on 11-02-2013
	{
		if(document.all.revokeType.value=="EMPREVOC$SUBALWREV" )
		{
			alert("Hello1");
			if (document.all.subsAllow.value=='')
			{
				alert("Hello2");
				alert("Subsistance Allowance is Mandatory ");
				frmEmpFinInfoForm.subsAllow.focus(); 
				return false;
			}
			 if (document.all.subsEffDate.value=='')
			{
				alert("Hello3");
				alert("Subsistance Effective Date is Mandatory ");
				frmEmpFinInfoForm.subsEffDate.focus(); 
				return false;
			}
		 } 
	}
	//added by nitin on 11-02-2013
	else
	{
		if (document.all.subsAllow.value=='')
        {
            alert("Subsistance Allowance is Mandatory ");
            frmEmpFinInfoForm.subsAllow.focus(); 
            return false;
        }
        if (document.all.subsEffDate.value=='')
        {
            alert("Subsistance Effective Date is Mandatory ");
            frmEmpFinInfoForm.subsEffDate.focus(); 
            return false;
        }
    }  
	//addition by nitin on 11-02-2013 ends

   var sEffdate=document.all.suspEffDate.value;
    var revDate=document.all.revokeDate.value;
    var subEffdate=document.all.subsEffDate.value;     
   if(mandatory_Check("frmEmpSuspensionForm"))
    {     
        frmEmpSuspensionForm.txtEmpNo.value=frmEmpSuspensionForm.headerPrimaryKey.value;         
         if (cmpRevokDate(revDate,sEffdate, 0) && cmpSuspDate(sEffdate, subEffdate, 0))
        { 
            frmEmpSuspensionForm.detailDataChanged.value = "false";          
            frmEmpSuspensionForm.headerDataChanged.value = "true";    
            frmEmpSuspensionForm.headerFields.value = "true";              
			document.all.butSave.disabled="true";
			document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
            frmEmpSuspensionForm.action = "../../../EmpRevoSaveAction.do";
            
            frmEmpSuspensionForm.submit();
        }    
    }
    else
    {
        return false;
    }  
}

function cmpRevokDate(date1,date2, flag)
{
	if (trim(date1) == "")
	{
		return true;
	}

	date1 = change_DateFormatMon(date1);
	sysDate = change_DateFormatMon(date2);
	if (flag == 0)
	{
		if (dateDiff(sysDate, date1) < 0)
		{
			alert("Revocation Date cannot be Less than the Suspension date!");
      document.all.revokeDate.select();
      document.all.revokeDate.focus();
		//	event.srcElement.select();
		//	event.srcElement.focus();
			return false;
		}
	}
	return true;
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

function lfnChanged(val)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
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

function doGetSlrRlsTab(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpSuspYrMonthAction.do";
    document.forms[0].submit(); 
}


function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpSuspTabAction.do";    
    document.forms[0].submit(); 
}

function checkSuspDate(val)
{
    var systDate = getSysDate();
	var payrollyymm = frmEmpSuspensionForm.payYYMM.value;
	var paylastdate=new Date( (new Date(payrollyymm.substring(0,4), payrollyymm.substring(4),1))-1 );
	var strdate=paylastdate.getDate()+'-'+(paylastdate.getMonth()+1)+'-'+paylastdate.getFullYear();
    if((cmpDateMsg(val,document.all.suspEffDate.value,1,"Date cannot be Less than the Suspension Date!" ) && cmpDateMsg(val,strdate,0,"Date cannot be greater than current payroll YYMM!" )) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.revokeDate.value="";     
        return false;
    }    
}

///added by sonia on 17-10-2011
function doGetInvDtlsTab(arg)
{   
     mode = document.all.screenMode.value;
    if(mode == 'N' || mode == 'Q')
    {
        return false;
    }
    else
    {
      document.all.forwardedPage.value=arg;
      document.forms[0].action="../../../EmpSuspInvDtlsAction.do";
      document.forms[0].submit(); 
    }  
}
///end by sonia

  
</script>