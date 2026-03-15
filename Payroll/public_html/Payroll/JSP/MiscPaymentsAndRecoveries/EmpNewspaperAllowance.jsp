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
  <html:form  action="MaintEmpNewspaperAllowance" name="frmEmpNewspaperAllowanceForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpNewspaperAllowanceForm">
  <bean:define id="ParentForm" name="frmEmpNewspaperAllowanceForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>NEWSPAPER ALLOWANCE</TD>
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
          <TD class=subHeader colspan=6>Newspaper Allowance</TD>
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
					  <logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="N">                              
						  <html:select property="txtPayCode" name="frmEmpNewspaperAllowanceForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" onchange="onChangePayCode(this.value)"  style="WIDTH:60%"  >
						  <html:option value="" >---------Please Select---------</html:option>      
						  <logic:present name="MediBillPayCode">
						  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
						  </logic:present>
						  </html:select>
					  </logic:equal>
					  <logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="N">  
							<logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpNewspaperAllowanceForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpNewspaperAllowanceForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:notEqual>
					  </logic:notEqual>
                  </td>
                  <TD class=labelText>Newspaper Name</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q"> 
                  <html:text  property="txtNewspaperName" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" disabled="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q">
                  <html:text  property="txtNewspaperName" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  </tr>
                  <tr>

                <TD class=labelText width="18%"><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" width="35%" >
						<logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpNewspaperAllowanceForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="" size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpNewspaperAllowanceForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange=" " size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:notEqual>
                  </td> 
                   <td class=labelText  >Invoice Number</td>
                  <td>                             
                  <html:text  property="txtInvID" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" disabled="true" />                 
                  </td>
                  
              </TR> 

<tr>
                  <TD class=labelText>From Month (YYMM)</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q"> 
                  <html:text  property="txtStartDate" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" disabled="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q">
                  <html:text  property="txtStartDate" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <TD class=labelText>To Month (YYMM)</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q"> 
                  <html:text  property="txtEndDate" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" disabled="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q">
                  <html:text  property="txtEndDate" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  </tr>

<!--end-->                
                <tr>
                <TD class=labelText>Sanction Amount</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q"> 
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" disabled="true" onkeypress="
                    if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }               
                    ;" /></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q">
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                   <td class=labelText >Sanction Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q">
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="locked" readonly="true"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q">                              
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" readonly="true"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:equal>
                  </td>
                                
                 
                </tr>
                <tr>
                 <TD class=labelText>Sanction Number</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q"> 
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q">
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <TD class=labelText>Remarks</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q"> 
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpNewspaperAllowanceForm" value="Q">
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
<html:hidden name="frmEmpNewspaperAllowanceForm"  property="screenName" value="EmpNewspaperAllowanceScreen" />
<html:hidden property="loginLocCode" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden name="frmEmpNewspaperAllowanceForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpNewspaperAllowanceForm" />
<html:hidden property="positionRequested" name="frmEmpNewspaperAllowanceForm" />
<html:hidden property="userPositionRequested" name="frmEmpNewspaperAllowanceForm" />
<html:hidden property="buttonFlag" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="lovKey" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtFields" name="frmEmpNewspaperAllowanceForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtIndex" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="hdnPayYYMM" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtPayCode" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="hdnITFlag" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtCpfCode" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtInputField" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="reqAlreadyRaised" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE1" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE2" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE3" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE4" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE5" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE6" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE7" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE8" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE9" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE10" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE11" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE12" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE13" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE14" name="frmEmpNewspaperAllowanceForm"  />
<html:hidden property="txtATTRIBUTE15" name="frmEmpNewspaperAllowanceForm"  />



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
    if(mode=='N'|| frmEmpNewspaperAllowanceForm.headerPrimaryKey.value=='' )
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
	frmEmpNewspaperAllowanceForm.lovKey.value = "EmpNewspaperAllowance" + document.all.screenName.value + document.all.screenMode.value;
	frmEmpNewspaperAllowanceForm.queryParam.value = qryprm;
	frmEmpNewspaperAllowanceForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode";
	frmEmpNewspaperAllowanceForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
	frmEmpNewspaperAllowanceForm.txtInputField.value ="txtEmpNo";
	document.all.txtIndex.value ="";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpNewspaperAllowanceForm');
	return true;
}    


function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpNewspaperAllowanceForm.action="../../../EmpNewspaperAllowanceNewMode.do"
    frmEmpNewspaperAllowanceForm.submit();
}

function getHeaderRecord()
{
    if(mandatory_Check("frmEmpNewspaperAllowanceForm"))
    {   
		document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmEmpNewspaperAllowanceForm.action="../../../EmpNewspaperAllowanceGetHeaderAction.do"
                frmEmpNewspaperAllowanceForm.submit();
                
                
    }
  
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpNewspaperAllowanceForm.userPositionRequested.value = 1*frmEmpNewspaperAllowanceForm.positionRequested.value + 1;
    frmEmpNewspaperAllowanceForm.action="../../../EmpNewspaperAllowanceGetNextHeader.do";
    frmEmpNewspaperAllowanceForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpNewspaperAllowanceForm.userPositionRequested.value = 1*frmEmpNewspaperAllowanceForm.positionRequested.value - 1;
    frmEmpNewspaperAllowanceForm.action = "../../../EmpNewspaperAllowanceGetNextHeader.do";
    frmEmpNewspaperAllowanceForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpNewspaperAllowanceForm.userPositionRequested.value = 1*frmEmpNewspaperAllowanceForm.newPositionRequested.value;
    frmEmpNewspaperAllowanceForm.action = "../../../EmpNewspaperAllowanceGetNextHeader.do";
    frmEmpNewspaperAllowanceForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpNewspaperAllowanceForm.action="../../../EmpNewspaperAllowanceQueryMode.do"
    frmEmpNewspaperAllowanceForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpNewspaperAllowanceForm.action="../../../EmpNewspaperAllowanceRefresh.do"
    frmEmpNewspaperAllowanceForm.submit();
}
function sendInv()
{
    if(!mandatory_Check("frmEmpNewspaperAllowanceForm"))
    {
      return false;
    }
    document.all.butSendInv.disabled="true";
    frmEmpNewspaperAllowanceForm.action="../../../EmpNewspaperAllowanceSendInv.do"
    frmEmpNewspaperAllowanceForm.submit();
}

function cancelInv()
{
    if(confirm("Do you want to cancel Invoice"))
    {
    document.all.butCancelInv.disabled="true";
    frmEmpNewspaperAllowanceForm.action="../../../EmpNewspaperAllowanceCancelInv.do"
    frmEmpNewspaperAllowanceForm.submit();
    }
}
function SaveRecord()
{   
    document.all.buttonFlag.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE1.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE2.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE3.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE4.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE5.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE6.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE7.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE8.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE9.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE10.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE11.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE12.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE13.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE14.value='';
    frmEmpNewspaperAllowanceForm.txtATTRIBUTE15.value='';
    
    if(frmEmpNewspaperAllowanceForm.txtInvID.value=='')
    {
      if(mandatory_Check("frmEmpNewspaperAllowanceForm"))
      {   
		  var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}
        //alert(frmEmpNewspaperAllowanceForm.txtEmpNo.value);
        frmEmpNewspaperAllowanceForm.detailDataChanged.value = "false";            
        if(frmEmpNewspaperAllowanceForm.screenMode.value == 'N')
          frmEmpNewspaperAllowanceForm.headerDataChanged.value = "true";
        else 
          frmEmpNewspaperAllowanceForm.headerDataChanged.value = "false";
        frmEmpNewspaperAllowanceForm.headerFields.value = "true";        
       // document.all.txtDedIT.disabled ="";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpNewspaperAllowanceForm.action = "../../../EmpNewspaperAllowanceSaveAction.do";            
        frmEmpNewspaperAllowanceForm.submit();
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
//		frmEmpNewspaperAllowanceForm.txtStartDate.value = "";
//		frmEmpNewspaperAllowanceForm.txtEndDate.value = "";
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