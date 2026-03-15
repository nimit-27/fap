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
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintEmpPenalityDetailBase" name="frmEmpPenalityForm" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpPenalityForm">
<bean:define id="ParentForm" name="frmEmpPenalityForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>DISMISSAL RE-INSTATEMENT</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:700px">
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
                  <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">                   
					  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" name= "frmEmpPenalityForm" maxlength="10" size="23" styleClass="required" readonly="true"/>
					  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N">
					  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" name= "frmEmpPenalityForm" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="Q">                              
	                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" onclick="return ShowEmpNum();">
                  </logic:equal>
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td> 
              </TR> 
                                
              <TR>              
                  <TD width="23%" class=labelText><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgnDesc" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/></td>
  				  <html:hidden property="txtDsgn" name="frmEmpPenalityForm" />

				  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/></td>  
				  <html:hidden property="txtCateg" name="frmEmpPenalityForm" />
              </tr>
                      
              <tr> 
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                    
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
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.curbas" /> </td>            
                  <td>
                  <html:text  property="txtCurtBasic" altKey="Payroll.EmpInfo.curbas" maxlength="15" size="23" styleClass="locked"  readonly="true"/>
                  </td>
              </tr>
                  <td width="15%" class=labelText  >Pay Band/Pay Scale code </td>            
                  <td>
                  <html:text  property="payScaleCode"  maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>

				  <td width="15%" class=labelText  >Pay Scale</td>            
                  <td>
                  <html:text  property="txtPayType"  maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
				  </tr>
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
				<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("detail")>Penalty Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
				<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("waiver")>Penalty Waiver<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
				<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("instate")>Increment Re-instate<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
				<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td bgcolor="#4682B4" nowrap class=actTabText>Dismissal Re-instate<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
					 <tr>
						  <logic:equal property="screenMode" name="frmEmpPenalityForm" value="N">
							  <td class=labelText width="23%">Dismiss Re-instate Effective From</td>
							  <td>
								  <html:text  property="txtReinstateDt"  maxlength="10" size="23"  styleClass= "required" onchange="chkValidDateFrm(this)" readonly="false"/>
								  <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="effDate" onclick="showCalendar('txtReinstateDt',this)" />
							  </td>
							  <td class=labelText width="28%">Reason</td>
							  <td>
								  <html:textarea  property="txtReinstRsn" styleClass = "optional" readonly="false" rows="3" cols="50" style="text-align:left;width:200px;" onkeypress="return textCounter(this,1000);" />
							  </td>
						  </logic:equal>
						  <logic:notEqual property="screenMode" name="frmEmpPenalityForm" value="N">
							  <td class=labelText width="23%">Dismiss Re-instate Effective From</td>
							  <td>
								  <html:text  property="txtReinstateDt"  maxlength="10" size="23"  styleClass= "locked" onchange="chkValidDateFrm(this)" readonly="true"/>
								  <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="effDate"  />
							  </td>
							  <td class=labelText width="28%">Reason</td>
							  <td>
								  <html:textarea  property="txtReinstRsn" styleClass = "locked" readonly="true" rows="3" cols="50" style="text-align:left;width:200px;" onkeypress="return textCounter(this,1000);" />
							  </td>
						  </logic:notEqual>
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
<!-- Tab Table Ends -->
<!-- Fields in Middle Section -->

<!-- Bottom Blue Bar -->
      <TR>
		 <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />
		 <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
		  <% if(smode.equals(new String("U"))) {%> 
		  Update Mode
		 <%} else if(smode.equals(new String("N"))) {  %>
		  New Mode
		 <%} else if(smode.equals(new String("Q"))) {  %>
		  Query Mode
		 <%}  %>

		 
		<td  bgcolor=#4682b4 width="35%"></td>
         <td bgcolor=#4682b4>
		  <logic:equal property="screenMode" name="frmEmpPenalityForm" value="N">
			 <html:button value='Dismiss Re-Instate'  onclick="dismissReinstate()" property="butDisReinst" styleClass="bottomBarText" />
		  </logic:equal>
		  </td>
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
<html:hidden name="frmEmpPenalityForm"  property="screenName" value="MaintEmpPenalityScreen" />
<html:hidden name="frmEmpPenalityForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpPenalityForm" />
<html:hidden property="loginLocCode" name="frmEmpPenalityForm" />
<html:hidden property="positionRequested" name="frmEmpPenalityForm" />
<html:hidden property="userPositionRequested" name="frmEmpPenalityForm" />
<html:hidden property="buttonFlag" name="frmEmpPenalityForm"  />
<html:hidden property="lovKey" name="frmEmpPenalityForm"  />
<html:hidden property="txtFields" name="frmEmpPenalityForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpPenalityForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpPenalityForm"  />
<html:hidden property="txtIndex" name="frmEmpPenalityForm"  />
<html:hidden property="newCateg" name="frmEmpPenalityForm"  />
<html:hidden property="newCategDesc" name="frmEmpPenalityForm"  />
<html:hidden property="payScaleCode" name="frmEmpPenalityForm"  />
<html:hidden property="newPayScaleCode" name="frmEmpPenalityForm"  />
<html:hidden property="hdnStartBasic" name="frmEmpPenalityForm"  />
<html:hidden property="newGradePay" name="frmEmpPenalityForm"  />
<html:hidden property="hdnEndBasic" name="frmEmpPenalityForm"  />
<html:hidden property="txtGradePay" name="frmEmpPenalityForm"  />
<html:hidden property="txtInputField" name="frmEmpPenalityForm"  />
<html:hidden property="txtPenaltyId" name="frmEmpPenalityForm"  />
<html:hidden property="hdnAction" name="frmEmpPenalityForm"  />
<html:text property="payYYMM" name="frmEmpPenalityForm"  />

<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>

<script language="javascript">
function lfnLoad()
{
	//alert(document.all.screenMode.value);
	//onChangePenalityType();
    mode = document.all.screenMode.value;    
    if(mode == '')
    {
        doQueryMode();
    }  
	
    if(mode=='U')
    {        
        document.all.txtCateg.disabled = "true";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    } 

    if(mode=='E')
		disableMenu();
    else
		hedMenuHandling(mode);    

	document.all.butSave.disabled="true";    
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
	//document.all.butInsertMode.disabled="true";    
	//document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    

}

function ShowEmpNum()
{
    frmEmpPenalityForm.lovKey.value = "EmpDismissReinstate" + frmEmpPenalityForm.screenName.value + frmEmpPenalityForm.screenMode.value;    
    frmEmpPenalityForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgnDesc,txtCateg,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtCurtBasic,payScaleCode,txtPayType,txtGradePay,txtDsgn,txtDOJSite";
    frmEmpPenalityForm.queryParam.value = "txtSiteID="+frmEmpPenalityForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpPenalityForm.hdnEmpLbrFlag.value;
    frmEmpPenalityForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName";
    frmEmpPenalityForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPenalityForm');
    return true;
}    

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.action="../../../EmpReinstateDismissQueryMode.do"
    frmEmpPenalityForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpPenalityForm.action="../../../EmpReinstateDismissRefresh.do"
    frmEmpPenalityForm.submit();
}

function doInsertMode()
{
    if (document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.action="../../../EmpReinstateDismissNewMode.do"
    frmEmpPenalityForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.getElementById("hdnAction").value = "GET_HDR_DISMISS";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		
    frmEmpPenalityForm.action="../../../EmpDismissReinstateHeaderAction.do"
    frmEmpPenalityForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.userPositionRequested.value = 1*frmEmpPenalityForm.positionRequested.value + 1;
    frmEmpPenalityForm.action="../../../EmpDismissReinstateNextHeader.do";
    frmEmpPenalityForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.userPositionRequested.value = 1*frmEmpPenalityForm.positionRequested.value - 1;
    frmEmpPenalityForm.action = "../../../EmpDismissReinstatePrevHeader.do";
    frmEmpPenalityForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.userPositionRequested.value = 1*frmEmpPenalityForm.newPositionRequested.value;
    frmEmpPenalityForm.action = "../../../EmpDismissReinstateNextHeader.do";
    frmEmpPenalityForm.submit();
}

function cancelPromotion()
{
    alert("Cancel Promotion");
}

function enableAll()
{
	frmEmpPenalityForm.penaType.disabled="";
	frmEmpPenalityForm.recvdAmt.disabled="";
	frmEmpPenalityForm.instalmntAmt.disabled="";
	frmEmpPenalityForm.noOfInstalmnt.disabled="";
	frmEmpPenalityForm.fstInstamntAmt.disabled="";
	frmEmpPenalityForm.recvYYMM.disabled="";
	frmEmpPenalityForm.balAmt.disabled="";
	frmEmpPenalityForm.newDsgn.disabled="";
	frmEmpPenalityForm.newPayScaleCode.disabled="";
	frmEmpPenalityForm.newBasic.disabled="";
	frmEmpPenalityForm.newPenaEffDate.disabled="";
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
    if (trim(cdate) == "" || frmEmpPenalityForm.txtPrvPromDate.value=='N')
    {
        return true;
    }
   
    
    var prevDate=frmEmpPenalityForm.txtPrvPromDate.value;
    var promDate=frmEmpPenalityForm.newPromEffDate.value;
    
    if (!cmpDate(prevDate,promDate,0))
    {
      alert("Promotion Date Cannot be Less then Prev. Promotion Date"); 
      document.all.newPromEffDate.value="";
      return false;                      
    }      
        return true;
}

function waiveoff()
{
	if(confirm("Do you want to waive the penalty.?"))
	{
		document.getElementById("hdnAction").value = "WAIVEOFF";
		document.forms[0].action="../../../PenaltyWaiveOffAction.do";
		document.forms[0].submit();
	}
}


//added by nand on 23-may-2013
function getTab(arg)
{
	document.all.forwardedPage.value=arg;
	//document.forms[0].action="../../../DismissalReinstateTabAction.do";
	document.forms[0].action="../../../PenaltyDetailTabAction.do";
	document.forms[0].submit();
	//nullAllFields();
}

function dismissReinstate()
{
	var emp = document.getElementById("txtEmpNo").value;
	if(emp == "")
	{
		alert("Please select employee first");
		return;
	}
	if(confirm("Do you want to do Re-instate the Dismissed employee.?"))
	{
		if(mandatory_Check("frmEmpPenalityForm"))
		{
			
			document.forms[0].action="../../../DsimissReinstateAction.do";
			document.forms[0].submit();
		}
	}
}

function nullAllFields()
{
frmEmpPenalityForm.txtEmpNo.value='';
frmEmpPenalityForm.txtEmpName.value='';	
frmEmpPenalityForm.txtDsgnDesc.value='';
frmEmpPenalityForm.txtCateg.value='';
frmEmpPenalityForm.txtCategDesc.value='';
frmEmpPenalityForm.txtEmpType.value='';
frmEmpPenalityForm.txtCpfCode.value='';
frmEmpPenalityForm.txtPresentPOP.value='';
frmEmpPenalityForm.txtEmpStatus.value='';
frmEmpPenalityForm.txtCurtBasic.value='';
frmEmpPenalityForm.payScaleCode.value='';
frmEmpPenalityForm.txtPayType.value='';
frmEmpPenalityForm.txtGradePay.value='';
frmEmpPenalityForm.txtDsgn.value='';
frmEmpPenalityForm.txtDOJSite.value='';
}


function chkValidDateFrm(me)
{
	var toDate = me.value;
	var months = {Jan:1,Feb:2,Mar:3,Apr:4,May:5,Jun:6,Jul:7,Aug:8,Sep:9,Oct:10,Nov:11,Dec:12};
	var currYYMM = document.getElementById("payYYMM").value;
	var currYY = currYYMM.substring(0,4);
	var currM = currYYMM.substring(4,6);
	var arr=toDate.split("-");
	var vYear = arr[2];
	var vMon = months[arr[1]];
	//alert(vYear+","+currYY)
	//alert(vMon+","+currM)
	if(eval(vYear) > eval(currYY))
    {
		alert("Effective From Date can not be Greater than the Current Payroll month ("+currYYMM+")");
		me.value="";
		return false;
	}
	else if((eval(vYear) == eval(currYY)) && (eval(vMon) > eval(currM)) )
	{
		alert("Effective From Date can not be Greater than the Current Date.");
		me.value="";
		return false;
	}
}

</script>