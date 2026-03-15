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
  <html:form  action="MaintEmpLaptopAMC" name="frmEmpLaptopAMCForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpLaptopAMCForm">
  <bean:define id="ParentForm" name="frmEmpLaptopAMCForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>LAPTOP AMC REIMBURSEMENT</TD>
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
          <TD class=subHeader colspan=6>Laptop Reimbursement</TD>
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
              <!-- <tr>
                  <td class=labelText width="18%"  ><bean:message key="Payroll.MediClaim.code"/></TD>
                  <td >
					  <logic:equal property= "screenMode" name= "frmEmpLaptopAMCForm" value="N">                              
						  <html:select property="txtPayCode" name="frmEmpLaptopAMCForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" readonly="true" onchange="onChangePayCode(this.value)"  style="WIDTH:60%"  >
						  <html:option value="" >---------Please Select---------</html:option>      
						  <logic:present name="MediBillPayCode">
						  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
						  </logic:present>
						  </html:select>
					  </logic:equal>
					  <logic:notEqual property= "screenMode" name= "frmEmpLaptopAMCForm" value="N">  
							<logic:equal property= "screenMode" name= "frmEmpLaptopAMCForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpLaptopAMCForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmEmpLaptopAMCForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpLaptopAMCForm"  titleKey="Payroll.MediClaim.code" styleClass="optional" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:notEqual>
					  </logic:notEqual>
                  </td>
                  </tr>-->
                  <tr>

                <TD class=labelText width="18%"><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" width="35%" >
						<logic:equal property= "screenMode" name= "frmEmpLaptopAMCForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpLaptopAMCForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="" size="15" styleClass="required"  readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmEmpLaptopAMCForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpLaptopAMCForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="" size="15" styleClass="required"  readonly="true"/>
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
                  <logic:notEqual property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q">
					  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="locked" />
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q">                              
					  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:equal>
                  </td>
                  <TD class=labelText>Bill Number</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q"> 
                  <html:text  property="txtBillNum" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q">
                  <html:text  property="txtBillNum" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  </tr>

<!--end-->                
                <tr>
                <TD class=labelText>Sanction Amount</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q"> 
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true" onkeypress="
                    if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }               
                    ;" /></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q">
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <td class=labelText >Sanction Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q">
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite"  titleKey=""  maxlength="15" size="23"  styleClass="locked" readonly="true"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q">                              
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="optional"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:equal>
                  </td>
                  
                                
                  
                </tr>
                <tr>
                  <TD class=labelText>Sanction Number</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q"> 
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q">
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <TD class=labelText>Remarks</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q"> 
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="optional" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpLaptopAMCForm" value="Q">
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
<html:hidden name="frmEmpLaptopAMCForm"  property="screenName" value="EmpLaptopAMCScreen" />
<html:hidden property="loginLocCode" name="frmEmpLaptopAMCForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpLaptopAMCForm"  />
<html:hidden name="frmEmpLaptopAMCForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpLaptopAMCForm"/>
<html:hidden property="positionRequested" name="frmEmpLaptopAMCForm" />
<html:hidden property="userPositionRequested" name="frmEmpLaptopAMCForm" />
<html:hidden property="buttonFlag" name="frmEmpLaptopAMCForm"  />
<html:hidden property="lovKey" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtFields" name="frmEmpLaptopAMCForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtIndex" name="frmEmpLaptopAMCForm"  />
<html:hidden property="hdnPayYYMM" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtPayCode" name="frmEmpLaptopAMCForm"  />
<html:hidden property="hdnITFlag" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtCpfCode" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtInputField" name="frmEmpLaptopAMCForm"  />
<html:hidden property="reqAlreadyRaised" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE1" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE2" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE3" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE4" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE5" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE6" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE7" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE8" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE9" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE10" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE11" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE12" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE13" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE14" name="frmEmpLaptopAMCForm"  />
<html:hidden property="txtATTRIBUTE15" name="frmEmpLaptopAMCForm"  />



<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">
function lfnLoad()

{mode = document.all.screenMode.value;
        //alert(mode);
	 document.all.butDel.disabled="true";
	 document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
       // alert(mode);
        
    if(mode== '')
    {
        doQueryMode();
    }
    if(mode=='N'|| frmEmpLaptopAMCForm.headerPrimaryKey.value=='' )
    { 
      document.all.butSendInv.disabled = "true"; 
      document.all.butCancelInv.disabled = "true";  
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
//Disabling INsert Mode  and Delete Mode 
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";}

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
	frmEmpLaptopAMCForm.lovKey.value = "EmpLaptopAMC" + document.all.screenName.value + document.all.screenMode.value;
	frmEmpLaptopAMCForm.queryParam.value = qryprm;
	frmEmpLaptopAMCForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode";
	frmEmpLaptopAMCForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
	frmEmpLaptopAMCForm.txtInputField.value ="txtEmpNo";
	document.all.txtIndex.value ="";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpLaptopAMCForm');
	return true;
}    


function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpLaptopAMCForm.action="../../../EmpLaptopAMCNewMode.do"
    frmEmpLaptopAMCForm.submit();
}

function getHeaderRecord()
{
    if(mandatory_Check("frmEmpLaptopAMCForm"))
    {   
		document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmEmpLaptopAMCForm.action="../../../EmpLaptopAMCGetHeaderAction.do"
                frmEmpLaptopAMCForm.submit();
                
                
    }
  
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpLaptopAMCForm.userPositionRequested.value = 1*frmEmpLaptopAMCForm.positionRequested.value + 1;
    frmEmpLaptopAMCForm.action="../../../EmpLaptopAMCGetNextHeader.do";
    frmEmpLaptopAMCForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpLaptopAMCForm.userPositionRequested.value = 1*frmEmpLaptopAMCForm.positionRequested.value - 1;
    frmEmpLaptopAMCForm.action = "../../../EmpLaptopAMCGetNextHeader.do";
    frmEmpLaptopAMCForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpLaptopAMCForm.userPositionRequested.value = 1*frmEmpLaptopAMCForm.newPositionRequested.value;
    frmEmpLaptopAMCForm.action = "../../../EmpLaptopAMCGetNextHeader.do";
    frmEmpLaptopAMCForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpLaptopAMCForm.action="../../../EmpLaptopAMCQueryMode.do"
    frmEmpLaptopAMCForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpLaptopAMCForm.action="../../../EmpLaptopAMCRefresh.do"
    frmEmpLaptopAMCForm.submit();
}
function sendInv()
{
    if(!mandatory_Check("frmEmpLaptopAMCForm"))
    {
      return false;
    }
    document.all.butSendInv.disabled="true";
    frmEmpLaptopAMCForm.action="../../../EmpLaptopAMCSendInv.do"
    frmEmpLaptopAMCForm.submit();
}

function cancelInv()
{
    if(confirm("Do you want to cancel Invoice"))
    {
    document.all.butCancelInv.disabled="true";
    frmEmpLaptopAMCForm.action="../../../EmpLaptopAMCCancelInv.do"
    frmEmpLaptopAMCForm.submit();
    }
}
function SaveRecord()
{   
    document.all.buttonFlag.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE1.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE2.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE3.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE4.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE5.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE6.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE7.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE8.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE9.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE10.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE11.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE12.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE13.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE14.value='';
    frmEmpLaptopAMCForm.txtATTRIBUTE15.value='';
    
    if(frmEmpLaptopAMCForm.txtInvID.value=='')
    {
      if(mandatory_Check("frmEmpLaptopAMCForm"))
      {   
		  var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}
        frmEmpLaptopAMCForm.detailDataChanged.value = "false";            
        if(frmEmpLaptopAMCForm.screenMode.value == 'N')
          frmEmpLaptopAMCForm.headerDataChanged.value = "true";
        else 
          frmEmpLaptopAMCForm.headerDataChanged.value = "false";
        frmEmpLaptopAMCForm.headerFields.value = "true";        
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpLaptopAMCForm.action = "../../../EmpLaptopAMCSaveAction.do";            
        frmEmpLaptopAMCForm.submit();
    }
    else
    {
        return false;
    }
  }   
      
}
function onChangePayCode(val)
{
document.getElementById("txtEmpName").value = "";

}
</script>