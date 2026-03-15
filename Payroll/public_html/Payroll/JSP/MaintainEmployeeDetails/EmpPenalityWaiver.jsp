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
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE PENALTY</TD>
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
                  <logic:equal property= "screenMode" name= "frmEmpPenalityForm" value="N">                   
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmEmpPenalityForm" value="N">
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
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
      <TABLE cellspacing="0" cellPadding="0">
           <TR>
			  <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
			  <td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("detail")>Penalty Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
			  <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
              
			  <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
			  <td bgcolor="#4682B4" nowrap class=actTabText>Penalty Waiver<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
			  <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
              
			  <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
			  <td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("instate")>Increment Re-instate<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
			  <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
              
              <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
			  <td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("dismiss")>Dismissal Re-instate<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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

                    <tr>                      
                        <TD width="20%" class=labelText >Penalty Amount Recovered</TD>
                        <td align="left" colspan="1"  width="23%">
                        <html:text  property="txtWaiveAmt" name="frmEmpPenalityForm" size="23" styleClass="locked" readonly="true" style="text-align:right"/> 
                        </td>
                        <TD width="20%" class=labelText >Part Waiver Amount</TD>
                        <td align="left" colspan="1"  width="23%">
						<logic:equal property="screenMode" name="frmEmpPenalityForm" value="U">
							<logic:equal property="txtWaiveAmtRmn" name="frmEmpPenalityForm" value="0">
								<html:text  property="txtWaiveAmtPrt" name="frmEmpPenalityForm" size="23" readonly="true" styleClass="locked" style="text-align:right"/> 
							</logic:equal>
							<logic:notEqual property="txtWaiveAmtRmn" name="frmEmpPenalityForm" value="0">
								<html:text  property="txtWaiveAmtPrt" name="frmEmpPenalityForm" size="23" styleClass="optional" style="text-align:right"/> 
							</logic:notEqual>
						</logic:equal>
						<logic:notEqual property="screenMode" name="frmEmpPenalityForm" value="U">
							<html:text  property="txtWaiveAmtPrt" name="frmEmpPenalityForm" size="23" readonly="true" styleClass="locked" style="text-align:right"/> 
						</logic:notEqual>
                        </td>
                    </tr>
					
                    <tr>                      
                        <TD width="20%" class=labelText >Waive off Date</TD>
                        <td align="left" colspan="1"  width="23%">
						<logic:equal property="screenMode" name="frmEmpPenalityForm" value="U">
							<logic:equal property="txtWaiveAmtRmn" name="frmEmpPenalityForm" value="0">
								<html:text  property="txtWaiveDt" name="frmEmpPenalityForm" size="23" styleClass="locked" readonly="true" style="text-align:right"/> 
								<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="waveDt" disabled="true" />
						</logic:equal>
						<logic:notEqual property="txtWaiveAmtRmn" name="frmEmpPenalityForm" value="0">
								<html:text  property="txtWaiveDt" name="frmEmpPenalityForm" size="23" styleClass="optional" readonly="true" style="text-align:right"/> 
								<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="waveDt" onclick="showCalendar('txtWaiveDt',this)" />
						</logic:notEqual>
						</logic:equal>
						<logic:notEqual property="screenMode" name="frmEmpPenalityForm" value="U">
							<html:text  property="txtWaiveDt" name="frmEmpPenalityForm" size="23" styleClass="locked" readonly="true" style="text-align:right"/> 
							<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="waveDt" disabled="true" />
						</logic:notEqual>

                        </td>
                        <TD width="20%" class=labelText >Remaining Waiver Amount</TD>
                        <td align="left" colspan="1"  width="23%">
                        <html:text  property="txtWaiveAmtRmn" name="frmEmpPenalityForm" size="23" styleClass="locked" readonly="true" style="text-align:right"/> 
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
		 <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />
		 <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
		  <% if(smode.equals(new String("U"))) {%> 
		  Update Mode
		 <%} else if(smode.equals(new String("N"))) {  %>
		  New Mode
		 <%} else if(smode.equals(new String("Q"))) {  %>
		  Query Mode
		 <%}  %>
		 </td> 
		 <td  bgcolor=#4682b4 width="35%"></td>
         <td bgcolor=#4682b4>
		 <logic:equal property="penaType" name="frmEmpPenalityForm" value="PENALTY$RECVRY">
			 <logic:equal property="screenMode" name="frmEmpPenalityForm" value="U">
				 <logic:equal property="txtWaiveAmtRmn" name="frmEmpPenalityForm" value="0">
					 <html:button value='Waive Off' disabled="true" property="butWaveOff" styleClass="bottomBarText" />
				 </logic:equal>
				 <logic:notEqual property="txtWaiveAmtRmn" name="frmEmpPenalityForm" value="0">
					 <html:button value='Waive Off' onclick="waiveoff()" property="butWaveOff" styleClass="bottomBarText" />
				 </logic:notEqual>
			 </logic:equal>
			 <logic:notEqual property="screenMode" name="frmEmpPenalityForm" value="U">
				 <html:button value='Waive Off' disabled="true" property="butWaveOff"  styleClass="bottomBarText" />
			 </logic:notEqual>
		 </logic:equal>
		<logic:equal property="penaType" name="frmEmpPenalityForm" value="PENALTY$ALL">
			 <logic:equal property="screenMode" name="frmEmpPenalityForm" value="U">
				 <logic:equal property="txtWaiveAmtRmn" name="frmEmpPenalityForm" value="0">
					 <html:button value='Waive Off' disabled="true" property="butWaveOff" styleClass="bottomBarText" />
				 </logic:equal>
				 <logic:notEqual property="txtWaiveAmtRmn" name="frmEmpPenalityForm" value="0">
					 <html:button value='Waive Off' onclick="waiveoff()" property="butWaveOff" styleClass="bottomBarText" />
				 </logic:notEqual>
			 </logic:equal>
			 <logic:notEqual property="screenMode" name="frmEmpPenalityForm" value="U">
				 <html:button value='Waive Off' disabled="true" property="butWaveOff"  styleClass="bottomBarText" />
			 </logic:notEqual>
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
<html:hidden property="txtEmpNo" name="frmEmpPenalityForm"  />
<html:hidden property="newCateg" name="frmEmpPenalityForm"  />
<html:hidden property="newCategDesc" name="frmEmpPenalityForm"  />
<html:hidden property="payScaleCode" name="frmEmpPenalityForm"  />
<html:hidden property="newPayScaleCode" name="frmEmpPenalityForm"  />
<html:hidden property="hdnStartBasic" name="frmEmpPenalityForm"  />
<html:hidden property="newGradePay" name="frmEmpPenalityForm"  />
<html:hidden property="hdnEndBasic" name="frmEmpPenalityForm"  />
<html:hidden property="txtGradePay" name="frmEmpPenalityForm"  />
<html:hidden property="txtInputField" name="frmEmpPenalityForm"  />
<html:hidden property="hdnAction" name="frmEmpPenalityForm"  />
<html:hidden property="penaType" name="frmEmpPenalityForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function lfnLoad()
{
	//alert(document.all.screenMode.value);
	onChangePenalityType();
    mode = document.all.screenMode.value;    
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {        
        document.all.txtCateg.disabled = "true";
		var penaType = document.getElementById("penaType").value;
		if(penaType!='PENALTY$ALL')
		{
			if(penaType!='PENALTY$RECVRY')
			{
				alert("Wave Off is not permitted for the selected Penalty type.");
			}
			else if(penaType=='PENALTY$RECVRY')
			{
				var waveAmt = document.getElementById("txtWaiveAmt").value;
				if(waveAmt==0 || waveAmt=="")
				{
					document.getElementById("butWaveOff").disabled="true";
				}
			}
		}
		else if(penaType=='PENALTY$ALL')
		{
			var waveAmt = document.getElementById("txtWaiveAmt").value;
			if(waveAmt==0 || waveAmt=="")
			{
				document.getElementById("butWaveOff").disabled="true";
			}
		}
    } 
  document.all.butSave.disabled="true";    
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
  document.all.butInsertMode.disabled="true";    
  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
}

function ShowEmpNum()
{
    frmEmpPenalityForm.lovKey.value = "EmpPenality" + frmEmpPenalityForm.screenName.value + frmEmpPenalityForm.screenMode.value;    
    frmEmpPenalityForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtDsgnDesc,txtCateg,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtCurtBasic,payScaleCode,txtPayType,txtGradePay,txtDsgn,txtDOJSite";
    frmEmpPenalityForm.queryParam.value = "txtSiteID="+frmEmpPenalityForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpPenalityForm.hdnEmpLbrFlag.value;
    frmEmpPenalityForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName";
    frmEmpPenalityForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPenalityForm');
    return true;
}    
function ShowLovDsgn()
{
	if(frmEmpPenalityForm.txtEmpNo.value=="")
	{
		alert("Please Select an Employee");
		return false;
	}
	if(frmEmpPenalityForm.txtPayType.value == 'IDA')
	{
		ShowLovDsgnIDA();
	}
	if(frmEmpPenalityForm.txtPayType.value == 'CDA')
	{
		ShowLovDsgnCDA();
	}
}
function ShowLovDsgnIDA()
{
    if(frmEmpPenalityForm.penaType.value=="")
    {
        alert("Please Select Penalty Type First!");
        frmEmpPenalityForm.penaType.focus();
        return false;
    }
    else
    {
        frmEmpPenalityForm.lovKey.value = "EmpPenalityDsgnIDA" + frmEmpPenalityForm.screenName.value + frmEmpPenalityForm.screenMode.value;
        frmEmpPenalityForm.txtDisplayFields.value = "newDsgn,newDsgnDesc,newCateg,newCategDesc,newPayScaleCode,newGradePay";
        frmEmpPenalityForm.queryParam.value = "txtPromoType="+frmEmpPenalityForm.penaType.value+",txtCategory="+frmEmpPenalityForm.txtCateg.value+" ";   
        frmEmpPenalityForm.txtSearchFields.value = "";
        frmEmpPenalityForm.txtInputField.value =""; 
        frmEmpPenalityForm.txtIndex.value =""; 
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPenalityForm');
        return true;
    }
}


function ShowLovDsgnCDA()
{
    if(frmEmpPenalityForm.penaType.value=="")
    {
        alert("Please Select Penalty Type First!");
        frmEmpPenalityForm.penaType.focus();
        return false;
    }
    else
    {
        frmEmpPenalityForm.lovKey.value = "EmpPenalityDsgnCDA" + frmEmpPenalityForm.screenName.value + frmEmpPenalityForm.screenMode.value;
        frmEmpPenalityForm.txtDisplayFields.value = "newDsgn,newDsgnDesc,newCateg,newCategDesc,newPayScaleCode,newGradePay";
        frmEmpPenalityForm.queryParam.value = "txtPromoType="+frmEmpPenalityForm.penaType.value+",txtCategory="+frmEmpPenalityForm.txtCateg.value+" ";   
        frmEmpPenalityForm.txtSearchFields.value = "";
        frmEmpPenalityForm.txtInputField.value =""; 
        frmEmpPenalityForm.txtIndex.value =""; 
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPenalityForm');
        return true;
    }
}
function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.action="../../../EmpPenalityQueryMode.do"
    frmEmpPenalityForm.submit();
}

function doRefresh()
{

    document.all.buttonFlag.value=''; 
    frmEmpPenalityForm.action="../../../EmpPenalityWaiveOffRefresh.do"
    frmEmpPenalityForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.action="../../../EmpPenalityNewMode.do"
    frmEmpPenalityForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    document.getElementById("hdnAction").value = "GET_HDR_WAVE";
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

	frmEmpPenalityForm.action="../../../EmpPenalityWaveoffHeaderAction.do",
    frmEmpPenalityForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.userPositionRequested.value = 1*frmEmpPenalityForm.positionRequested.value + 1;
    frmEmpPenalityForm.action="../../../PenalityWaiveOffGetNextHeader.do";
    frmEmpPenalityForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.userPositionRequested.value = 1*frmEmpPenalityForm.positionRequested.value - 1;
    frmEmpPenalityForm.action = "../../../PenalityWaiveOffGetPrevHeader.do";
    frmEmpPenalityForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPenalityForm.userPositionRequested.value = 1*frmEmpPenalityForm.newPositionRequested.value;
    frmEmpPenalityForm.action = "../../../PenalityWaiveOffGetNextHeader.do";
    frmEmpPenalityForm.submit();
}


function cancelPromotion()
{
    alert("Cancel Promotion");
}

function SaveRecord()
{
    document.all.buttonFlag.value=''; 
	enableAll();
	if(mandatory_Check("frmEmpPenalityForm"))
	{
		frmEmpPenalityForm.detailDataChanged.value = "false";             
		frmEmpPenalityForm.headerDataChanged.value = "true";    
		frmEmpPenalityForm.headerFields.value = "true"; 
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
		frmEmpPenalityForm.action = "../../../EmpPenalitySaveAction.do";            
		frmEmpPenalityForm.submit();
	}
    else
    {
        return false;
    }
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

function checkAdhocPromEffDate(cdate)
{
    
    if(frmEmpPenalityForm.newPenaEffDate.value!= '')
    {
        firstIndex=cdate.indexOf("-");
        lastIndex=cdate.lastIndexOf("-");        
        if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
        {
            var arr=cdate.split("-");
            var arrDOJF=frmEmpPenalityForm.newPenaEffDate.value.split("-");
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
        
        sysDate = getSysDate(); 
                  
        return true;
    }
}

function checkCurBasicLimit()
{
    var curBasic;
    var startBasic;
    var endBasic;
    var curBasic;     
    curBasic = parseInt(frmEmpPenalityForm.newBasic.value);
    startBasic =parseInt(frmEmpPenalityForm.hdnStartBasic.value); 
    endBasic = parseInt(frmEmpPenalityForm.hdnEndBasic.value); 
    //alert(startBasic);
    //alert(endBasic);
    if(curBasic < startBasic || curBasic > endBasic)
    {
        alert("New Basic Should be In Range "+startBasic+" To "+endBasic);
        frmEmpPenalityForm.newBasic.select();
        frmEmpPenalityForm.newBasic.focus();
        return false;
    }    
    else
        return true;
}

function onChangePenalityType()
{   
	if(frmEmpPenalityForm.screenMode.value == 'N')
	{
		if (frmEmpPenalityForm.penaType.value=='PENALTY$DEMO')
		{       
			
			document.getElementById("newDsgnDesc").disabled = ""; 
			document.getElementById("newDsgnDesc").style.background="#ffffd3";
			document.getElementById("newDsgnDesc").className="required";
			document.getElementById("buttxtDesig").disabled="";
			document.getElementById("newPayScaleCode").disabled = "";       
			document.getElementById("newPayScaleCode").style.background="#ffffd3";
			document.getElementById("newPayScaleCode").className="required";
			document.getElementById("newBasic").disabled = "";     
			document.getElementById("newBasic").value = "";
			document.getElementById("newBasic").style.background="#ffffd3";
			document.getElementById("newBasic").className="required";
			document.getElementById("newPenaEffDate").style.background="#ffffd3";
			document.getElementById("newPenaEffDate").className="required";
			document.getElementById("effDate").disabled = "";
			document.getElementById("recvdAmt").value = ""; 
			document.getElementById("recvdAmt").disabled = "true"; 
			document.getElementById("recvdAmt").className = "locked";
			document.getElementById("recvdAmt").style.background = "#e0e0e0";
			document.getElementById("instalmntAmt").value = ""; 
			document.getElementById("instalmntAmt").disabled = "true"; 
			document.getElementById("instalmntAmt").className = "locked";
			document.getElementById("instalmntAmt").style.background = "#e0e0e0";
			document.getElementById("noOfInstalmnt").value = ""; 
			document.getElementById("noOfInstalmnt").disabled = "true"; 
			document.getElementById("noOfInstalmnt").className = "locked";
			document.getElementById("noOfInstalmnt").style.background = "#e0e0e0";
			document.getElementById("fstInstamntAmt").value = ""; 
			document.getElementById("fstInstamntAmt").disabled = "true"; 
			document.getElementById("fstInstamntAmt").className = "locked";
			document.getElementById("fstInstamntAmt").style.background = "#e0e0e0";
			document.getElementById("recvYYMM").value = ""; 
			document.getElementById("recvYYMM").disabled = "true"; 
			document.getElementById("recvYYMM").className = "locked";
			document.getElementById("recvYYMM").style.background = "#e0e0e0";
			document.getElementById("balAmt").value = "";
			document.getElementById("balAmt").disabled = "true";
			document.getElementById("balAmt").className = "locked";
			document.getElementById("balAmt").style.background = "#e0e0e0";
		}
		else if(frmEmpPenalityForm.penaType.value=='PENALTY$RECVRY')
		{
			document.getElementById("recvdAmt").disabled = "";
			document.getElementById("recvdAmt").style.background="#ffffd3";
			document.getElementById("recvdAmt").className="required";        
			document.getElementById("instalmntAmt").disabled = "";
			document.getElementById("instalmntAmt").style.background="#ffffd3";
			document.getElementById("instalmntAmt").className="required";        
			document.getElementById("noOfInstalmnt").disabled = "";
			document.getElementById("noOfInstalmnt").style.background="#ffffd3";
			document.getElementById("noOfInstalmnt").className="required";        
			document.getElementById("fstInstamntAmt").disabled = "";
			document.getElementById("fstInstamntAmt").style.background="#ffffd3";
			document.getElementById("fstInstamntAmt").className="required";        
			document.getElementById("recvYYMM").disabled = "";
			document.getElementById("recvYYMM").style.background="#ffffd3";
			document.getElementById("recvYYMM").className="required";        
			document.getElementById("balAmt").disabled = "";
			document.getElementById("balAmt").style.background="#ffffd3";
			document.getElementById("balAmt").className="required";        
			document.getElementById("newDsgnDesc").disabled = "true"; 
			document.getElementById("newDsgnDesc").value = "";
			document.getElementById("newDsgnDesc").style.background="#e0e0e0";
			document.getElementById("newDsgnDesc").className="locked";
			document.getElementById("newDsgn").value = "";
			document.getElementById("buttxtDesig").disabled="true";
			
			document.getElementById("newPayScaleCode").disabled = "true";
			document.getElementById("newPayScaleCode").value = "";
			document.getElementById("newPayScaleCode").style.background="#e0e0e0";
			document.getElementById("newPayScaleCode").className="locked";
			document.getElementById("newBasic").disabled = "true";
			document.getElementById("newBasic").value = "";
			document.getElementById("newBasic").style.background="#e0e0e0";
			document.getElementById("newBasic").className="locked";
			document.getElementById("newPenaEffDate").value = "";
			document.getElementById("newPenaEffDate").style.background="#e0e0e0";
			document.getElementById("newPenaEffDate").className="locked";
			document.getElementById("effDate").disabled = "true";
		}
	}
}

function chk_YearMonth(recVal,Ind)
{       
    var  yearM = recVal;      
    var month =  yearM.substring(4,6);      
    if (num_Check(yearM,1))
    {                                       
        if (yearM.length != 6)
        {         
            alert(" Year Month should be a Six digit Number");
            document.getElementById("recvYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                    
            return false;        
        }    
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("recvYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        }
        else
        {
            return true;
        }
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;     
        return false;
    }
}

function checkInstAmt()
{           
          // alert(frmEmpPenalityForm.screenMode.value == "N");
           
            
            if (frmEmpPenalityForm.screenMode.value == "N")
            {  
			
                var tempTotalAmt = parseInt(document.getElementById("recvdAmt").value,10);
                //var tempInstAmt = parseInt(document.getElementById("instalmntAmt").value,10);               
                document.getElementById("balAmt").value=document.getElementById("recvdAmt").value;
		

             
			} 
                              
        return true;
		
}

function checkAmountCalculation()
{
	var tempTotalAmt = document.getElementById("recvdAmt").value==""?0:parseInt(document.getElementById("recvdAmt").value,10);
	var tempFstInstamntAmt = document.getElementById("fstInstamntAmt").value==""?0:parseInt(document.getElementById("fstInstamntAmt").value,10);
	var tempNoOfInstalmnt =document.getElementById("noOfInstalmnt").value==""?0:parseInt(document.getElementById("noOfInstalmnt").value,10);
	var tempInstalmntAmt =document.getElementById("instalmntAmt").value==""?0:parseInt(document.getElementById("instalmntAmt").value,10);
	var calcAmt=tempFstInstamntAmt+(tempNoOfInstalmnt-1)*tempInstalmntAmt;
	if(tempInstalmntAmt==0)
	{
		alert("Installment amount cannot be 0");
		document.getElementsByName("instalmntAmt")[i-1].value='';
		return false;
	}
	if(tempTotalAmt!=calcAmt)
	{
		alert("Please Enter the correct Amount");
		document.getElementById("fstInstamntAmt").value='';
		document.getElementById("noOfInstalmnt").value='';
		document.getElementById("instalmntAmt").value='';
		return false;
	}
}

function getTab(arg)
{
	document.all.forwardedPage.value=arg;
	//document.forms[0].action="../../../PenaltyWaiverTabAction.do";
	document.forms[0].action="../../../PenaltyDetailTabAction.do";
	document.forms[0].submit();
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

</script>