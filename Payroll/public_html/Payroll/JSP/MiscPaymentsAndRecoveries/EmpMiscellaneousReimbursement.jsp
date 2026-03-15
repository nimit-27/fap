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
  <html:form  action="MaintEmpMiscellaneousReimbursement" name="frmEmpMiscellaneousReimbursementForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpMiscellaneousReimbursementForm">
  <bean:define id="ParentForm" name="frmEmpMiscellaneousReimbursementForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>EMPLOYEE MISCELLANEOUS REIMBURSEMENT</TD>
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
          <TD class=subHeader colspan=6>Employee Miscellaneous Reimbursement</TD>
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
					  <logic:equal property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="N">                              
						  <html:select property="txtPayCode" name="frmEmpMiscellaneousReimbursementForm"  titleKey="Payroll.MediClaim.code" styleClass="required" onchange="onChangePayCode(this.value)"  style="WIDTH:60%"  >
						  <html:option value="" >---------Please Select---------</html:option>      
						  <logic:present name="MediBillPayCode">
						  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
						  </logic:present>
						  </html:select>
					  </logic:equal>
					  <logic:notEqual property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="N">  
							<logic:equal property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpMiscellaneousReimbursementForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpMiscellaneousReimbursementForm"  titleKey="Payroll.MediClaim.code" styleClass="optional" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:notEqual>
					  </logic:notEqual>
                  </td>
                  </tr>
                  <tr>

                <TD class=labelText width="18%"><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" width="35%" >
						<logic:equal property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpMiscellaneousReimbursementForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="setDependentVal()" size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpMiscellaneousReimbursementForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="setDependentVal() " size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:notEqual>
                  </td> 
                  <td class=labelText  >Invoice Number</td>
                  <td>                             
                  <html:text  property="txtInvID" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  
              </TR> 
			  

<tr>
                  <td class=labelText >Bill Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q">
					  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="required"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q">                              
					  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:equal>
                  </td>
                  <TD class=labelText>Bill Number</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q"> 
                  <html:text  property="txtBillNum" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="required"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q">
                  <html:text  property="txtBillNum" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  </tr>

<!--end-->                
                <tr>
                <TD class=labelText>Sanction Amount</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q"> 
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="required" onkeypress="
                    if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }               
                    ;" /></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q">
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <td class=labelText >Sanction Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q">
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="required"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q">                              
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:equal>
                  </td>
                  
                                
                  
                </tr>
                <tr>
                  <TD class=labelText>Sanction Number</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q"> 
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="required"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q">
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <TD class=labelText>Remarks</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q"> 
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="optional" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpMiscellaneousReimbursementForm" value="Q">
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td> 
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
<html:hidden name="frmEmpMiscellaneousReimbursementForm"  property="screenName" value="EmpMiscellaneousReimbursementScreen" />
<html:hidden property="loginLocCode" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden name="frmEmpMiscellaneousReimbursementForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpMiscellaneousReimbursementForm" />
<html:hidden property="positionRequested" name="frmEmpMiscellaneousReimbursementForm" />
<html:hidden property="userPositionRequested" name="frmEmpMiscellaneousReimbursementForm" />
<html:hidden property="buttonFlag" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="lovKey" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtFields" name="frmEmpMiscellaneousReimbursementForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtIndex" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="hdnPayYYMM" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtPayCode" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="hdnITFlag" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtCpfCode" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtInputField" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="reqAlreadyRaised" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE1" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE2" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE3" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE4" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE5" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE6" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE7" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE8" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE9" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE10" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE11" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE12" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE13" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE14" name="frmEmpMiscellaneousReimbursementForm"  />
<html:hidden property="txtATTRIBUTE15" name="frmEmpMiscellaneousReimbursementForm"  />



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
    if(mode=='N'|| frmEmpMiscellaneousReimbursementForm.headerPrimaryKey.value=='' )
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
        frmEmpMiscellaneousReimbursementForm.txtPayCode.value='';
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
	frmEmpMiscellaneousReimbursementForm.lovKey.value = "EmpMiscellaneousReimbursement" + document.all.screenName.value + document.all.screenMode.value;
	frmEmpMiscellaneousReimbursementForm.queryParam.value = qryprm;
	frmEmpMiscellaneousReimbursementForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode";
	frmEmpMiscellaneousReimbursementForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
	frmEmpMiscellaneousReimbursementForm.txtInputField.value ="txtEmpNo";
	document.all.txtIndex.value ="";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpMiscellaneousReimbursementForm');
	return true;
}    


function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpMiscellaneousReimbursementForm.action="../../../EmpMiscellaneousReimbursementNewMode.do"
    frmEmpMiscellaneousReimbursementForm.submit();
}

function getHeaderRecord()
{
    if(mandatory_Check("frmEmpMiscellaneousReimbursementForm"))
    {   
		document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmEmpMiscellaneousReimbursementForm.action="../../../EmpMiscellaneousReimbursementGetHeaderAction.do"
                frmEmpMiscellaneousReimbursementForm.submit();
                
                
    }
  
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpMiscellaneousReimbursementForm.userPositionRequested.value = 1*frmEmpMiscellaneousReimbursementForm.positionRequested.value + 1;
    frmEmpMiscellaneousReimbursementForm.action="../../../EmpMiscellaneousReimbursementGetNextHeader.do";
    frmEmpMiscellaneousReimbursementForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpMiscellaneousReimbursementForm.userPositionRequested.value = 1*frmEmpMiscellaneousReimbursementForm.positionRequested.value - 1;
    frmEmpMiscellaneousReimbursementForm.action = "../../../EmpMiscellaneousReimbursementGetNextHeader.do";
    frmEmpMiscellaneousReimbursementForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpMiscellaneousReimbursementForm.userPositionRequested.value = 1*frmEmpMiscellaneousReimbursementForm.newPositionRequested.value;
    frmEmpMiscellaneousReimbursementForm.action = "../../../EmpMiscellaneousReimbursementGetNextHeader.do";
    frmEmpMiscellaneousReimbursementForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpMiscellaneousReimbursementForm.action="../../../EmpMiscellaneousReimbursementQueryMode.do"
    frmEmpMiscellaneousReimbursementForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpMiscellaneousReimbursementForm.action="../../../EmpMiscellaneousReimbursementRefresh.do"
    frmEmpMiscellaneousReimbursementForm.submit();
}
function sendInv()
{
    if(!mandatory_Check("frmEmpMiscellaneousReimbursementForm"))
    {
      return false;
    }
    document.all.butSendInv.disabled="true";
    frmEmpMiscellaneousReimbursementForm.action="../../../EmpMiscellaneousReimbursementSendInv.do"
    frmEmpMiscellaneousReimbursementForm.submit();
}

function cancelInv()
{
    if(confirm("Do you want to cancel Invoice"))
    {
    document.all.butCancelInv.disabled="true";
    frmEmpMiscellaneousReimbursementForm.action="../../../EmpMiscellaneousReimbursementCancelInv.do"
    frmEmpMiscellaneousReimbursementForm.submit();
    }
}
function SaveRecord()
{   
    document.all.buttonFlag.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE1.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE2.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE3.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE4.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE5.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE6.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE7.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE8.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE9.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE10.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE11.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE12.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE13.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE14.value='';
    frmEmpMiscellaneousReimbursementForm.txtATTRIBUTE15.value='';
    
    if(frmEmpMiscellaneousReimbursementForm.txtInvID.value=='')
    {
      if(mandatory_Check("frmEmpMiscellaneousReimbursementForm"))
      {   
		  var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}
        //alert(frmEmpMiscellaneousReimbursementForm.txtEmpNo.value);
        frmEmpMiscellaneousReimbursementForm.detailDataChanged.value = "false";            
        if(frmEmpMiscellaneousReimbursementForm.screenMode.value == 'N')
          frmEmpMiscellaneousReimbursementForm.headerDataChanged.value = "true";
        else 
          frmEmpMiscellaneousReimbursementForm.headerDataChanged.value = "false";
        frmEmpMiscellaneousReimbursementForm.headerFields.value = "true";        
       // document.all.txtDedIT.disabled ="";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpMiscellaneousReimbursementForm.action = "../../../EmpMiscellaneousReimbursementSaveAction.do";            
        frmEmpMiscellaneousReimbursementForm.submit();
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
//		frmEmpMiscellaneousReimbursementForm.txtStartDate.value = "";
//		frmEmpMiscellaneousReimbursementForm.txtEndDate.value = "";
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