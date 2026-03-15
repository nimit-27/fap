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
  <html:form  action="MaintEmpLocalTravelAllowance" name="frmEmpLocalTravelAllowanceForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpLocalTravelAllowanceForm">
  <bean:define id="ParentForm" name="frmEmpLocalTravelAllowanceForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>LOCAL TRAVEL ALLOWANCE</TD>
</TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>Local Travel Allowance</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
            <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	 <TR height="50">
            <TD colspan=11>
            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >          
              <TR height=10>                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                 <TABLE cellSpacing="0" cellPadding="0" border="0" >
               <tr>
                  <td class=labelText width="18%"  ><bean:message key="Payroll.MediClaim.code"/></TD>
                  <td >
					  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="N">                              
						  <html:select property="txtPayCode" name="frmEmpLocalTravelAllowanceForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" readonly="true" onchange="onChangePayCode(this.value)"  style="WIDTH:60%"  >
						  <html:option value="" >---------Please Select---------</html:option>      
						  <logic:present name="MediBillPayCode">
						  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
						  </logic:present>
						  </html:select>
					  </logic:equal>
					  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="N">  
							<logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpLocalTravelAllowanceForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpLocalTravelAllowanceForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" readonly="true" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:notEqual>
					  </logic:notEqual>
                  </td>
                  <TD class=labelText width="18%"><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" width="35%" >
						<logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpLocalTravelAllowanceForm" altKey="Payroll.EmpInfo.Empno" maxlength="10"  size="15" onchange=" " styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpLocalTravelAllowanceForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="15" onchange=" " styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:notEqual>
                  </td> 
                  </tr>
                  <tr></TR> 
<tr>
                  <td class=labelText >Travel Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">
					  <html:text  property="txtTravelDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="locked"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtTravelDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">                              
					  <html:text  property="txtTravelDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" />
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtTravelDate',this)" />
                  </logic:equal>
                  </td>
                  <TD class=labelText>Travel Mode</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q"> 
                  <html:text  property="txtTravelMode" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">
                  <html:text  property="txtTravelMode" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  
                  </tr>
<tr>
                  <TD class=labelText>Travel From Date</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q"> 
                  <html:text  property="txtTravelFrom" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">
                  <html:text  property="txtTravelFrom" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <TD class=labelText>Travel To Date </TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q"> 
                  <html:text  property="txtTravelTo" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">
                  <html:text  property="txtTravelTo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  </tr>

<!--end-->                
                <tr>
                <TD class=labelText>Sanction Amount</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q"> 
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true" onkeypress="
                    if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }               
                    ;" /></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  
                                
                  <td class=labelText  >Invoice Number</td>
                  <td>                             
                  <html:text  property="txtInvID" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                </tr>
                <tr>
                <TD class=labelText>Travel Distance(KM)</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q"> 
                  <html:text  property="txtTrvelDistance" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">
                  <html:text  property="txtTrvelDistance" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <TD class=labelText>Remarks</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q"> 
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="optional" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td> 
                  
                  
                  <tr>
                  <td class=labelText >Sanction Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="locked" />
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">                              
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" />
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:equal>
                  </td>
                  <TD class=labelText>Sanction Order</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q"> 
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpLocalTravelAllowanceForm" value="Q">
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  </tr>
                  
                  

                <TR height="50"><td>&nbsp;</td></tr>
        		</TABLE>
                        
            
          </td>
        </tr>
<!-- Tab table Row 3 starts -->               
      <TR>
       <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
      </TR>  
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
    
           <td align=center bgcolor=#4682b4 width="30%"></td>
           <td  bgcolor=#4682b4><html:button value='Send Invoice'  onclick="sendInv()" property="butSendInv" styleClass="bottomBarText" /></td>
           <td  bgcolor=#4682b4><html:button value='Cancel Invoice' onclick="cancelInv()" property="butCancelInv" styleClass="bottomBarText" /></td>
           <td bgColor=#4682b4></td>
           <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
        </TR>	
      </TABLE> 
      <!-- Container Table Ending Columns Starts-->
    </TD>    
  </TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="frmEmpLocalTravelAllowanceForm"  property="screenName" value="EmpLocalTravelAllowanceScreen" />
<html:hidden property="loginLocCode" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden name="frmEmpLocalTravelAllowanceForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpLocalTravelAllowanceForm" />
<html:hidden property="positionRequested" name="frmEmpLocalTravelAllowanceForm" />
<html:hidden property="userPositionRequested" name="frmEmpLocalTravelAllowanceForm" />
<html:hidden property="buttonFlag" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="lovKey" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtFields" name="frmEmpLocalTravelAllowanceForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtIndex" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="hdnPayYYMM" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtPayCode" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="hdnITFlag" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtCpfCode" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtInputField" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="reqAlreadyRaised" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE1" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE2" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE3" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE4" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE5" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE6" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE7" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE8" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE9" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE10" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE11" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE12" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE13" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE14" name="frmEmpLocalTravelAllowanceForm"  />
<html:hidden property="txtATTRIBUTE15" name="frmEmpLocalTravelAllowanceForm"  />



<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">
function lfnLoad()
{//alert(1);
    mode = document.all.screenMode.value;
       // alert(mode);
         //document.all.txtEmpNo.value="";
	 document.all.butDel.disabled="true";
	 document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
	//var pay_code = document.all.txtPayCode.value;
        
    if(mode== '')
    {
        doQueryMode();
        

    }
    if(mode=='N'|| frmEmpLocalTravelAllowanceForm.headerPrimaryKey.value=='' )
    { 
      document.all.butSendInv.disabled = "true"; 
      document.all.butCancelInv.disabled = "true";
//      document.getElementById("txtSancOrder").style.background="#e0e0e0";
//      document.getElementById("txtSancOrder").style.className="required";
//      document.getElementById("txtSancDate").style.background="#e0e0e0";
//      document.getElementById("txtSancDate").style.className="required";
      


    }
    hedMenuHandling(mode);        
    
    if(document.all.txtInvID.value=='' && mode=='U')
    {
        document.all.butSendInv.disabled="";
        document.all.butCancelInv.disabled = "true"; 
    }
	else if(document.all.txtInvID.value!='' && mode=='U')
    {
      document.all.butSendInv.disabled="true";
      document.all.butCancelInv.disabled ="";
    }
	//var val = document.getElementById("txtPayCode").value;
//Disabling INsert Mode  and Delete Mode 
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    //menuHandling(mode); 
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
	}

function ShowEmpNum()
{   
	var qryprm = "";
	if(document.all.screenMode.value == 'N')
	{
		qryprm = "txtSiteID="+ document.all.loginLocCode.value +",hdnEmpLbrFlag="+ document.all.hdnEmpLbrFlag.value+",txtPayCode="+ document.all.txtPayCode.value ;
	}
	else
	{
		
            qryprm = "txtSiteID="+ document.all.loginLocCode.value +",hdnEmpLbrFlag="+ document.all.hdnEmpLbrFlag.value+",txtPayCode="+"00";
	}
	frmEmpLocalTravelAllowanceForm.lovKey.value = "EmpLocalTravelAllowance" + document.all.screenName.value + document.all.screenMode.value;
	frmEmpLocalTravelAllowanceForm.queryParam.value = qryprm;
	frmEmpLocalTravelAllowanceForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode";
	frmEmpLocalTravelAllowanceForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
	frmEmpLocalTravelAllowanceForm.txtInputField.value ="txtEmpNo";
	document.all.txtIndex.value ="";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpLocalTravelAllowanceForm');
	return true;
}    


function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpLocalTravelAllowanceForm.action="../../../EmpLocalTravelAllowanceNewMode.do"
    frmEmpLocalTravelAllowanceForm.submit();
}

function getHeaderRecord()
{
    if(mandatory_Check("frmEmpLocalTravelAllowanceForm"))
    {   
		document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmEmpLocalTravelAllowanceForm.action="../../../EmpLocalTravelAllowanceGetHeaderAction.do"
                frmEmpLocalTravelAllowanceForm.submit();
                
                
    }
  
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpLocalTravelAllowanceForm.userPositionRequested.value = 1*frmEmpLocalTravelAllowanceForm.positionRequested.value + 1;
    frmEmpLocalTravelAllowanceForm.action="../../../EmpLocalTravelAllowanceGetNextHeader.do";
    frmEmpLocalTravelAllowanceForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpLocalTravelAllowanceForm.userPositionRequested.value = 1*frmEmpLocalTravelAllowanceForm.positionRequested.value - 1;
    frmEmpLocalTravelAllowanceForm.action = "../../../EmpLocalTravelAllowanceGetNextHeader.do";
    frmEmpLocalTravelAllowanceForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpLocalTravelAllowanceForm.userPositionRequested.value = 1*frmEmpLocalTravelAllowanceForm.newPositionRequested.value;
    frmEmpLocalTravelAllowanceForm.action = "../../../EmpLocalTravelAllowanceGetNextHeader.do";
    frmEmpLocalTravelAllowanceForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpLocalTravelAllowanceForm.action="../../../EmpLocalTravelAllowanceQueryMode.do"
    frmEmpLocalTravelAllowanceForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpLocalTravelAllowanceForm.action="../../../EmpLocalTravelAllowanceRefresh.do"
    frmEmpLocalTravelAllowanceForm.submit();
}
function sendInv()
{
    if(!mandatory_Check("frmEmpLocalTravelAllowanceForm"))
    {
      return false;
    }
    document.all.butSendInv.disabled="true";
    frmEmpLocalTravelAllowanceForm.action="../../../EmpLocalTravelAllowanceSendInv.do"
    frmEmpLocalTravelAllowanceForm.submit();
}

function cancelInv()
{
    if(confirm("Do you want to cancel Invoice"))
    {
    document.all.butCancelInv.disabled="true";
    frmEmpLocalTravelAllowanceForm.action="../../../EmpLocalTravelAllowanceCancelInv.do"
    frmEmpLocalTravelAllowanceForm.submit();
    }
}
function SaveRecord()
{   
    document.all.buttonFlag.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE1.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE2.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE3.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE4.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE5.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE6.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE7.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE8.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE9.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE10.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE11.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE12.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE13.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE14.value='';
    frmEmpLocalTravelAllowanceForm.txtATTRIBUTE15.value='';
    
    if(frmEmpLocalTravelAllowanceForm.txtInvID.value=='')
    {
      if(mandatory_Check("frmEmpLocalTravelAllowanceForm"))
      {   
		  var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}
        //alert(frmEmpLocalTravelAllowanceForm.txtEmpNo.value);
        frmEmpLocalTravelAllowanceForm.detailDataChanged.value = "false";            
        if(frmEmpLocalTravelAllowanceForm.screenMode.value == 'N')
          frmEmpLocalTravelAllowanceForm.headerDataChanged.value = "true";
        else 
          frmEmpLocalTravelAllowanceForm.headerDataChanged.value = "false";
        frmEmpLocalTravelAllowanceForm.headerFields.value = "true";        
       // document.all.txtDedIT.disabled ="";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpLocalTravelAllowanceForm.action = "../../../EmpLocalTravelAllowanceSaveAction.do";            
        frmEmpLocalTravelAllowanceForm.submit();
    }
    else
    {
        return false;
    }
  }   
      
}
function onChangePayCode(val)
{//alert(1);
//document.getElementById("txtEmpNo").value = "";
document.getElementById("txtEmpName").value = "";
//dateStateChng(val);
//}
//
//function dateStateChng(val)
//{
//	if(val=="263")
//	{
//		if(document.all.txtDate1) document.all.txtDate1.disabled = "true";
//		if(document.all.txtDate2) document.all.txtDate2.disabled = "true";
//		frmEmpLocalTravelAllowanceForm.txtStartDate.value = "";
//		frmEmpLocalTravelAllowanceForm.txtEndDate.value = "";
//		document.getElementById("txtStartDate").className="locked";
//		document.getElementById("txtEndDate").className="locked";
//		document.all.txtStartDate.style.background="#e0e0e0";
//		document.all.txtEndDate.style.background="#e0e0e0";
//	}
//	else
//	{
//		if(document.all.screenMode.value!='Q')
//		{
//			if(document.all.txtDate1) document.all.txtDate1.disabled = "";
//			if(document.all.txtDate2) document.all.txtDate2.disabled = "";
//			document.getElementById("txtStartDate").className="required";
//			document.getElementById("txtEndDate").className="required";
//			document.all.txtStartDate.style.background="#ffffd3";
//			document.all.txtEndDate.style.background="#ffffd3";
//		}
//	}
//
}
</script>