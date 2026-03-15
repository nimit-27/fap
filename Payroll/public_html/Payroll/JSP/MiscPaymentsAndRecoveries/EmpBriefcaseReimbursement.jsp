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
  <html:form  action="MaintEmpBriefcaseReimbursement" name="frmEmpBriefcaseReimbursementForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpBriefcaseReimbursementForm">
  <bean:define id="ParentForm" name="frmEmpBriefcaseReimbursementForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>BRIEFCASE REIMBURSEMENT</TD>
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
          <TD class=subHeader colspan=6>Briefcase Reimbursement</TD>
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
					  <logic:equal property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="N">                              
						  <html:select property="txtPayCode" name="frmEmpBriefcaseReimbursementForm"  titleKey="Payroll.MediClaim.code" styleClass="required" onchange="onChangePayCode(this.value)"  style="WIDTH:60%"  >
						  <html:option value="" >---------Please Select---------</html:option>      
						  <logic:present name="MediBillPayCode">
						  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
						  </logic:present>
						  </html:select>
					  </logic:equal>
					  <logic:notEqual property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="N">  
							<logic:equal property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpBriefcaseReimbursementForm"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="MediBillPayCode">
								  <html:optionsCollection label="label" value="value" property="payCodeList" name="MediBillPayCode"/>
								  </logic:present>
								  </html:select>
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="U">
								  <html:select property="txtPayCode" name="frmEmpBriefcaseReimbursementForm"  titleKey="Payroll.MediClaim.code" styleClass="optional" onchange="onChangePayCode(this.value)" style="WIDTH:60%" >
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
						<logic:equal property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpBriefcaseReimbursementForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="" size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="N">
						  <html:text  property="txtEmpNo" name= "frmEmpBriefcaseReimbursementForm" altKey="Payroll.EmpInfo.Empno" maxlength="10" onchange="" size="15" styleClass="required" readonly="true"/>
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
                  <logic:notEqual property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q">
					  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="locked" readonly="true"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q">                              
					  <html:text  property="txtBillDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" readonly="true"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:equal>
                  </td>
                  <TD class=labelText>Bill Number</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q"> 
                  <html:text  property="txtBillNum" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q">
                  <html:text  property="txtBillNum" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  </tr>

<!--end-->                
                <tr>
                <TD class=labelText>Sanction Amount</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q"> 
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true" onkeypress="
                    if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }               
                    ;" /></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q">
                  <html:text  property="txtsanctionAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <td class=labelText >Sanction Date</td>            
                  <td>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q">
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite"  titleKey="" readonly="true" maxlength="15" size="23"  styleClass="locked" readonly="true"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" id="txtDate1" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:notEqual>
                  <logic:equal property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q">                              
					  <html:text  property="txtSancDate" altKey="Payroll.EmpInfo.DojSite" titleKey="" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" readonly="true"/>
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSancDate" title="Calender" onclick="showCalendar('txtSancDate',this)" />
                  </logic:equal>
                  </td>
                  
                                
                  
                </tr>
                <tr>
                  <TD class=labelText>Sanction Number</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q"> 
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="8" style="text-align:right" size="23" styleClass="locked" readonly="true"/></logic:notEqual>
                  
                  <logic:equal property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q">
                  <html:text  property="txtSancNum" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                  <TD class=labelText>Remarks</TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q"> 
                  <html:text  property="txtRemark" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpBriefcaseReimbursementForm" value="Q">
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
<html:hidden name="frmEmpBriefcaseReimbursementForm"  property="screenName" value="EmpBriefcaseReimbursementScreen" />
<html:hidden property="loginLocCode" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden name="frmEmpBriefcaseReimbursementForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpBriefcaseReimbursementForm" />
<html:hidden property="positionRequested" name="frmEmpBriefcaseReimbursementForm" />
<html:hidden property="userPositionRequested" name="frmEmpBriefcaseReimbursementForm" />
<html:hidden property="buttonFlag" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="lovKey" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtFields" name="frmEmpBriefcaseReimbursementForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtIndex" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="hdnPayYYMM" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtPayCode" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="hdnITFlag" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtCpfCode" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtInputField" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="reqAlreadyRaised" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE1" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE2" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE3" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE4" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE5" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE6" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE7" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE8" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE9" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE10" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE11" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE12" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE13" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE14" name="frmEmpBriefcaseReimbursementForm"  />
<html:hidden property="txtATTRIBUTE15" name="frmEmpBriefcaseReimbursementForm"  />



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
    if(mode=='N'|| frmEmpBriefcaseReimbursementForm.headerPrimaryKey.value=='' )
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
	frmEmpBriefcaseReimbursementForm.lovKey.value = "EmpBriefcaseReimbursement" + document.all.screenName.value + document.all.screenMode.value;
	frmEmpBriefcaseReimbursementForm.queryParam.value = qryprm;
	frmEmpBriefcaseReimbursementForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode";
	frmEmpBriefcaseReimbursementForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
	frmEmpBriefcaseReimbursementForm.txtInputField.value ="txtEmpNo";
	document.all.txtIndex.value ="";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpBriefcaseReimbursementForm');
	return true;
}    


function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpBriefcaseReimbursementForm.action="../../../EmpBriefcaseReimbursementNewMode.do"
    frmEmpBriefcaseReimbursementForm.submit();
}

function getHeaderRecord()
{
    if(mandatory_Check("frmEmpBriefcaseReimbursementForm"))
    {   
		document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmEmpBriefcaseReimbursementForm.action="../../../EmpBriefcaseReimbursementGetHeaderAction.do"
                frmEmpBriefcaseReimbursementForm.submit();
                
                
    }
  
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpBriefcaseReimbursementForm.userPositionRequested.value = 1*frmEmpBriefcaseReimbursementForm.positionRequested.value + 1;
    frmEmpBriefcaseReimbursementForm.action="../../../EmpBriefcaseReimbursementGetNextHeader.do";
    frmEmpBriefcaseReimbursementForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpBriefcaseReimbursementForm.userPositionRequested.value = 1*frmEmpBriefcaseReimbursementForm.positionRequested.value - 1;
    frmEmpBriefcaseReimbursementForm.action = "../../../EmpBriefcaseReimbursementGetNextHeader.do";
    frmEmpBriefcaseReimbursementForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpBriefcaseReimbursementForm.userPositionRequested.value = 1*frmEmpBriefcaseReimbursementForm.newPositionRequested.value;
    frmEmpBriefcaseReimbursementForm.action = "../../../EmpBriefcaseReimbursementGetNextHeader.do";
    frmEmpBriefcaseReimbursementForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpBriefcaseReimbursementForm.action="../../../EmpBriefcaseReimbursementQueryMode.do"
    frmEmpBriefcaseReimbursementForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpBriefcaseReimbursementForm.action="../../../EmpBriefcaseReimbursementRefresh.do"
    frmEmpBriefcaseReimbursementForm.submit();
}
function sendInv()
{
    if(!mandatory_Check("frmEmpBriefcaseReimbursementForm"))
    {
      return false;
    }
    document.all.butSendInv.disabled="true";
    frmEmpBriefcaseReimbursementForm.action="../../../EmpBriefcaseReimbursementSendInv.do"
    frmEmpBriefcaseReimbursementForm.submit();
}

function cancelInv()
{
    if(confirm("Do you want to cancel Invoice"))
    {
    document.all.butCancelInv.disabled="true";
    frmEmpBriefcaseReimbursementForm.action="../../../EmpBriefcaseReimbursementCancelInv.do"
    frmEmpBriefcaseReimbursementForm.submit();
    }
}
function SaveRecord()
{   
    document.all.buttonFlag.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE1.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE2.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE3.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE4.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE5.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE6.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE7.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE8.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE9.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE10.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE11.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE12.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE13.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE14.value='';
    frmEmpBriefcaseReimbursementForm.txtATTRIBUTE15.value='';
    
    if(frmEmpBriefcaseReimbursementForm.txtInvID.value=='')
    {
      if(mandatory_Check("frmEmpBriefcaseReimbursementForm"))
      {   
		  var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}
        //alert(frmEmpBriefcaseReimbursementForm.txtEmpNo.value);
        frmEmpBriefcaseReimbursementForm.detailDataChanged.value = "false";            
        if(frmEmpBriefcaseReimbursementForm.screenMode.value == 'N')
          frmEmpBriefcaseReimbursementForm.headerDataChanged.value = "true";
        else 
          frmEmpBriefcaseReimbursementForm.headerDataChanged.value = "false";
        frmEmpBriefcaseReimbursementForm.headerFields.value = "true";        
       // document.all.txtDedIT.disabled ="";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpBriefcaseReimbursementForm.action = "../../../EmpBriefcaseReimbursementSaveAction.do";            
        frmEmpBriefcaseReimbursementForm.submit();
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
//		frmEmpBriefcaseReimbursementForm.txtStartDate.value = "";
//		frmEmpBriefcaseReimbursementForm.txtEndDate.value = "";
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