<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>        
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../INCLUDES/ENRGISE.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/Payroll.js"></script>    
<!--    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>  -->       


</head>
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="LeaseAccomBase" name="frmLeaseAccDtls" type="FCIPAY.Payroll.WEBTIER.Form.LeaseAccomForm" scope="session">
<bean:define id="ParentForm" name="frmLeaseAccDtls" toScope="request" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="lovKey" name="frmLeaseAccDtls"  />
<html:hidden property="txtFields" name="frmLeaseAccDtls"  />   
<html:hidden property="txtSearchFields" name="frmLeaseAccDtls"  />
<html:hidden property="txtDisplayFields" name="frmLeaseAccDtls"  />
<html:hidden property="txtIndex" name="frmLeaseAccDtls"  />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
 <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>LEASE ACCOMODATION ENTRY</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
  <html:errors/>
 
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
   <TR>
    <TD>

 <!-- <div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--pay Scale Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>Lease Accomodation Details</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="6"></td>
            </tr>
        <TR>                
                 <TD class=labelText width="45%" ><bean:message key="Payroll.Common.empNo" /></td>
                 <td><html:text  property="txtEmpNo" altKey="Payroll.Common.empNo" maxlength="10" size="23" styleClass="required" readonly="true" />
                 <logic:equal property= "screenModeLease" name= "frmLeaseAccDtls" value="">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNO"  onclick="ShowLovEmpNo();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenModeLease" name= "frmLeaseAccDtls" value="Q">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNO"  onclick="ShowLovEmpNo();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenModeLease" name= "frmLeaseAccDtls" value="N">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNO"  onclick="ShowLovEmpNo();">                                  
                 </logic:equal> 
                  <logic:equal property= "screenModeLease" name= "frmLeaseAccDtls" value="U">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNO"  disabled onclick="ShowLovEmpNo();">                                  
                 </logic:equal>
                 <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="26" styleClass="locked" readonly="true" />
				 <html:hidden property="txtCpfCode" name="frmLeaseAccDtls"/>
                 </td>  
       </tr>                  
       <tr height="15" >
            <td colspan="6"></td>
            </tr>                                 
       </table>        
       </div>     
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText >Lease Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 <TR height=10>
                   <!-- Detail table Container starts -->
                    <TD colspan=11>
                      <TABLE cellSpacing=0 cellPadding=0 border=0>
                        <TBODY>
                          <TR>
                           <TD >
                            <DIV id=divDtlTable style="height:320px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                <TBODY>
                                  <TR>
                                    <td class=tableHeader width="1%"><html:checkbox property="selectAll" value="" onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                    <td class=tableHeader width="10%"><bean:message key="pay.LeaseAccDtls.accomType" /></td>
                                    <td class=tableHeader width="10%"><bean:message key="pay.LeaseAccDtls.licFee" /></td>
                                    <td class=tableHeader width="10%"><bean:message key="pay.LeaseAccDtls.leaseAmt" /></td>
                                    <td class=tableHeader width="10%"><bean:message key="pay.LeaseAccDtls.Percentage" /></td>
                                    <td class=tableHeader width="10%"><bean:message key="pay.LeaseAccDtls.fromdate" /> </td>
                                    <td class=tableHeader width="10%"><bean:message key="pay.LeaseAccDtls.todate" /></td>
                                  </tr>                                                      
                          <logic:iterate id="LeaseAccInfo" name="frmLeaseAccDtls" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.LeaseAccomBean" indexId="idx" >
                          <% ++i; %>
                          <logic:notEqual name="LeaseAccInfo" property="status" value="D" >                              
                            <tr> <% ++j; %>                                                          
                                   <td ><html:checkbox property="checked" onclick="checkRecord();" name="frmLeaseAccDtls" /></td>
                                    <td>
										<logic:notEqual name="LeaseAccInfo" property="status" value="N" >
											<html:select property="txtAccomTyp" name="LeaseAccInfo" style="width:100%;" disabled="true" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="checkAccomType(this.alt);changed(this.alt)" >
											<html:option value="" >----<bean:message   key="Payroll.pleaseSelect" />----</html:option>  
											<logic:present name="LeaseAccomCombo">
											<html:optionsCollection label="label" value="value" property="accomTypList" name="LeaseAccomCombo"/>
											</logic:present>
											</html:select>
										</logic:notEqual>
										<logic:equal name="LeaseAccInfo" property="status" value="N" >
											<html:select property="txtAccomTyp" name="LeaseAccInfo" style="width:100%;" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="checkAccomType(this.alt);changed(this.alt)" >
											<html:option value="" >----<bean:message   key="Payroll.pleaseSelect" />----</html:option>  
											<logic:present name="LeaseAccomCombo">
											<html:optionsCollection label="label" value="value" property="accomTypList" name="LeaseAccomCombo"/>
											</logic:present>
											</html:select>
										</logic:equal>
                                    </td>
	                                    <html:hidden property="txtHraAmt" name="LeaseAccInfo" />
                                    <td>
	                                    <logic:equal name="LeaseAccInfo" property="status" value="N" >
											<html:text property="txtLicenseFee" name="LeaseAccInfo" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />
	                                    </logic:equal>
	                                    <logic:notEqual name="LeaseAccInfo" property="status" value="N" >
											<html:text property="txtLicenseFee" name="LeaseAccInfo" readonly="true" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" styleClass="locked" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />
	                                    </logic:notEqual>
									</td>

                                    <td>
	                                    <logic:equal name="LeaseAccInfo" property="status" value="N" >
											<html:text property="txtLeaseAmt" name="LeaseAccInfo" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />
	                                    </logic:equal>
	                                    <logic:notEqual name="LeaseAccInfo" property="status" value="N" >
											<html:text property="txtLeaseAmt" name="LeaseAccInfo" readonly="true" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" styleClass="locked" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />
	                                    </logic:notEqual>
									</td>

                                    <td>
	                                    <logic:equal name="LeaseAccInfo" property="status" value="N" >
											<html:select property="txtLeasePerc" name="LeaseAccInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="checkAccomType(this.alt),changed(this.alt)"  style="WIDTH: 100%"  >
											  <html:option value="" >-----------Please Select-----------</html:option>      
											  <logic:present name="LeaseAccomCombo">
												<html:optionsCollection label="label" value="value" property="accomPerList" name="LeaseAccomCombo"/>
											  </logic:present>
											</html:select>
	                                    </logic:equal>
	                                    <logic:notEqual name="LeaseAccInfo" property="status" value="N" >
											<html:select property="txtLeasePerc" name="LeaseAccInfo" styleClass="locked" disabled="true" alt="<%=String.valueOf(i)%>" onchange="checkAccomType(this.alt),changed(this.alt)"  style="WIDTH: 100%"  >
											  <html:option value="" >-----------Please Select-----------</html:option>      
											  <logic:present name="LeaseAccomCombo">
												<html:optionsCollection label="label" value="value" property="accomPerList" name="LeaseAccomCombo"/>
											  </logic:present>
											</html:select>
	                                    </logic:notEqual>
								    </td>

									<td>
										<html:text property="txtFromDate" name="LeaseAccInfo" readonly="true"  styleClass="required" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />
                                        <logic:equal name="LeaseAccInfo" property="status" value="N">
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" onclick="showCalendar('txtFromDate',this)" />
                                         </logic:equal>                                      
                                        <logic:equal name="LeaseAccInfo" property="status" value="Q">
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" disabled="true"  onclick="showCalendar('txtFromDate',this)" />
                                        </logic:equal>                                      
                                        <logic:equal name="LeaseAccInfo" property="status" value="U">
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" disabled="true"  onclick="showCalendar('txtFromDate',this)" />
                                        </logic:equal>  
                                    </td>         

                                    <td>
										<html:text property="txtToDate" name="LeaseAccInfo" readonly="true"  styleClass="optional" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i)%>" onchange=
										" if(!(chk_DateRange(parseInt(this.alt)-1)))
											  {
											  this.focus();
											  return false;                         
											  }
											  else
											  return changed(this.alt);     
										" />
										<img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtToDate" alt="<%=(i-1) %>" onclick="showCalendar('txtToDate',this)" />
										  <!-- <logic:equal name="LeaseAccInfo" property="txtToDate" value="">
											<img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtToDate" alt="<%=(i-1) %>" onclick="showCalendar('txtToDate',this)" />
										   </logic:equal>                                      
										   <logic:notEqual name="LeaseAccInfo" property="txtToDate" value="">
										   <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtToDate" alt="<%=(i-1) %>" disabled="true"  onclick="showCalendar('txtToDate',this)" />
										   </logic:notEqual>   -->              
									   <!-- <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" onclick="showCalendar('txtFromDate',this)" />  -->
                                    </td>                                           
                                    
                                   <html:hidden property="hdnSrlNo" name="LeaseAccInfo" />                                                                     
                                   <html:hidden property="itemChecked" name="LeaseAccInfo" />
                                   <html:hidden property="status" name="LeaseAccInfo" />
                                   <html:hidden property="detailId" name="LeaseAccInfo" />
								     <!--Added by Varalika on 03-Oct-2011-->     
									<html:hidden property="txtUpdatedSite"  name="LeaseAccInfo" />
									<html:hidden property="txtCreationDate" name="LeaseAccInfo" />
									<html:hidden property="txtCreatedBy"    name="LeaseAccInfo" />
									<html:hidden property="txtCreatedSite"  name="LeaseAccInfo" />
									<html:hidden property="txtUpdationDate" name="LeaseAccInfo" />
									<html:hidden property="txtUpdatedBy"    name="LeaseAccInfo" />
									<!--ended by varalika -->
                               </tr>
                          </logic:notEqual>
                          <logic:equal name="LeaseAccInfo" property="status" value="D" >                              
                                   <tr>
                                   <td ><html:hidden property="checked" name="frmLeaseAccDtls" /></td>
                                   <td><html:hidden property="txtAccomTyp" name="LeaseAccInfo"  /></td>
                                  <html:hidden property="txtHraAmt" name="LeaseAccInfo"  />
                                   <td><html:hidden property="txtLicenseFee" name="LeaseAccInfo"    /></td>
                                   <td><html:hidden property="txtLeaseAmt" name="LeaseAccInfo"  /></td>
                                   <td><html:hidden property="txtFromDate" name="LeaseAccInfo"  /></td>
                                   <td ><html:hidden property="txtToDate" name="LeaseAccInfo" /></td>
                                   <html:hidden property="hdnSrlNo" name="LeaseAccInfo" />                                   
                                   <html:hidden property="itemChecked" name="LeaseAccInfo" />
                                   <html:hidden property="status" name="LeaseAccInfo" />
                                   <html:hidden property="detailId" name="LeaseAccInfo" />
								    <!--Added by Varalika on 03-Oct-2011-->     
									<html:hidden property="txtUpdatedSite"  name="LeaseAccInfo" />
									<html:hidden property="txtCreationDate" name="LeaseAccInfo" />
									<html:hidden property="txtCreatedBy"    name="LeaseAccInfo" />
									<html:hidden property="txtCreatedSite"  name="LeaseAccInfo" />
									<html:hidden property="txtUpdationDate" name="LeaseAccInfo" />
									<html:hidden property="txtUpdatedBy"    name="LeaseAccInfo" />
									<!--ended by varalika -->
                                   </tr>
                          </logic:equal>                                                                   
                          </logic:iterate>
                                 </TBODY>
                                </TABLE>
                              </DIV>
                             </TD>
                            </TR>                     
          
              <!-- Get details starts -->
                            <tr>
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
                                  <tr>
                                   <td colspan=11>	
                                   <jsp:include  page = "../INCLUDES/GenDetailRecHistMenu.jsp" flush="true" />
								   <!-- changed GenDetailMenu by varalika on 03-Oct-2011 -->
                                   </TD>
                                 </tr>
                                </TBODY>
                              </TABLE>
                             </TD>
                            </tr>
                          
                          </TBODY>
                        </TABLE>
                      </td>
                    </tr>
                  </TABLE>
                </td>
	            </tr>


	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->
<html:hidden property="headerPrimaryKey" name="frmLeaseAccDtls" />
<html:hidden property="screenMode" name="frmLeaseAccDtls"  />
<html:hidden property="screenModeLease" name="frmLeaseAccDtls"  />
<html:hidden name="frmLeaseAccDtls"  property="screenName" value="LeaseAccomScreen" />
<html:hidden name="frmLeaseAccDtls"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmLeaseAccDtls" />
<html:hidden property="userPositionRequested" name="frmLeaseAccDtls" />
<html:hidden property="totalDetailRecord" name="frmLeaseAccDtls"  />
<html:hidden property="buttonFlag" name="frmLeaseAccDtls"  />
<html:hidden property="userPageRequested" name="frmLeaseAccDtls" />
<html:hidden property="pageRequested" name="frmLeaseAccDtls" />
<html:hidden property="butAction" name="frmLeaseAccDtls" />
<html:hidden property="loginLocCode" name="frmLeaseAccDtls" />
 <!--Added by Varalika on 03-Oct-2011-->     
<html:hidden property="txtUpdatedSite"  name="frmLeaseAccDtls" />
<html:hidden property="txtCreationDate" name="frmLeaseAccDtls" />
<html:hidden property="txtCreatedBy"    name="frmLeaseAccDtls" />
<html:hidden property="txtCreatedSite"  name="frmLeaseAccDtls" />
<html:hidden property="txtUpdationDate" name="frmLeaseAccDtls" />
<html:hidden property="txtUpdatedBy"    name="frmLeaseAccDtls" />
<!--ended by varalika -->


<input type="hidden" name="queryParam">
</html:form>
</body>
</html:html>

                        
              

<script language="javascript">


var formMode="Q";
var oElemName=new Object();
var sSaveFlag=1;


var chkMes;


function changed(val)
{  
	frmLeaseAccDtls.detailDataChanged.value = "true";
	if (document.getElementsByName("status")[val-1].value == 'Q')
	document.getElementsByName("status")[val-1].value = 'U';
}

  function GetDetail()
  {
    document.all.buttonFlag.value='';
 // document.all.screenMode.value='U';
    document.all.screenModeLease.value='UG';

    frmLeaseAccDtls.headerPrimaryKey.value = frmLeaseAccDtls.txtEmpNo.value ;  
    frmLeaseAccDtls.action="../../../LeaseAccomGetDetailAction.do"
    frmLeaseAccDtls.submit();
  }

  function getHeaderRecord()
  {
	document.all.buttonFlag.value='';
	document.all.screenModeLease.value='U';
	//document.all.screenMode.value='U';  
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmLeaseAccDtls.action="../../../LeaseAccomGetHeader.do";
	frmLeaseAccDtls.submit();
  }


function doGetNextHeader()
{ 
  document.all.buttonFlag.value='';
  frmLeaseAccDtls.screenMode.value='U';
  document.all.screenModeLease.value='U';
  frmLeaseAccDtls.userPositionRequested.value = 1*frmLeaseAccDtls.positionRequested.value + 1;  
  frmLeaseAccDtls.action="../../../LeaseAccomGetNextHeader.do";
  frmLeaseAccDtls.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  document.all.screenModeLease.value='U';
  frmLeaseAccDtls.userPositionRequested.value = frmLeaseAccDtls.positionRequested.value - 1;
  frmLeaseAccDtls.action = "../../../LeaseAccomGetNextHeader.do";
  frmLeaseAccDtls.submit();
}


function JumpHeader()
{

  document.all.buttonFlag.value='';
  document.all.screenModeLease.value='U';
  document.all.screenModeLease.value='U';
  frmLeaseAccDtls.userPositionRequested.value = 1*frmLeaseAccDtls.newPositionRequested.value;
  frmLeaseAccDtls.action = "../../../LeaseAccomGetNextHeader.do";
  frmLeaseAccDtls.submit();
}



  function doBaseAddRow()
  {
   document.all.buttonFlag.value='D';

    var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
    var iTr2 = oTable.rows.length;
    var i = 0;
    document.all.screenMode.value="UG";
    frmLeaseAccDtls.screenModeLease.value='UG';

      for(i=0; i < iTr2 -1; i++)
          {
             if (document.getElementsByName("status")[i].value != 'D' && document.getElementsByName("txtToDate")[i].value == '')
              {                
                 alert("Please end date all the records before new insertion");
                 return false;
              }
         }


  
   if(!mandatory_Check("frmLeaseAccDtls"))
    return false;

   document.getElementById("txtEmpNo").disabled="";
 
    EnableFields();
    frmLeaseAccDtls.action = "../../../LeaseAccomAddRowAction.do";
    frmLeaseAccDtls.submit();
  }

function doBaseDelRow()
{
  document.all.buttonFlag.value='D';
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

   var flag = 0;
   for(i=0; i < iTr2 -1; i++)
    {
        if(document.getElementsByName("checked")[i].checked)
        {
            flag=flag+1;
        }
    }  
    if ( flag == 0)
    {
        alert("Please check the rows to be deleted");
        return false;
    }

  var strRecList='';  
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("detailId")[i].value=="")
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        frmLeaseAccDtls.detailDataChanged.value = "true"; 
      }
      else
      {
        strRecList=strRecList+(i+1)+",";
      }
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }


    EnableFields();
  document.forms[0].action = "../../../LeaseAccomDeleteRow.do";
  document.forms[0].submit();  
}

  


function SaveRecord()
{
document.all.buttonFlag.value='';
document.all.screenMode.value = "U";


//   if(!DupliCheck())
//      return false;


   if(!mandatory_Check("frmLeaseAccDtls"))
        return false;      

   if(!DetailRecordNo_check())
        return false;  

   if(!validateRecords())
        return false; 
        
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  for(i=0;i<iTr2-1;i++)
  {
      if(!chk_DateRange(i))
      {
        return false;
      }
    if(document.getElementsByName("status")[i].value=='N' )
      {
        flagContinue=confirm("The employee "+document.all.txtEmpName.value+" has "+document.getElementsByName("txtAccomTyp")[i].value+" with effect from "+document.getElementsByName("txtFromDate")[i].value+". Please Confirm...");
        if(!flagContinue)
          return false;
      }
    if(document.getElementsByName("status")[i].value=='U')
      {
        flagContinue=confirm("The employee "+document.all.txtEmpName.value+" had "+document.getElementsByName("txtAccomTyp")[i].value+" uptill "+document.getElementsByName("txtToDate")[i].value+". Please Confirm...");
        if(!flagContinue)
          return false;
      }
  }
    document.getElementById("txtEmpNo").disabled="";  
    document.all.butSave.disabled="true";        
    document.all.screenModeLease.value = "UG";
    document.all.screenMode.value = "U";   
  EnableFields();
  document.all.butSave.disabled="true";          
  frmLeaseAccDtls.headerPrimaryKey.value = frmLeaseAccDtls.txtEmpNo.value ;
  frmLeaseAccDtls.totalDetailRecord.value = parseInt(iTr2,10) - 1;
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmLeaseAccDtls.action = "../../../LeaseAccomSaveAction.do";
  frmLeaseAccDtls.submit();
}


   function DetailRecordNo_check()
    {

          var oTable = document.getElementById("Detail");
                    var iTr2 = oTable.rows.length;
                    var flag =0;
                  
          frmLeaseAccDtls.totalDetailRecord.value = parseInt(iTr2,10) - 1;
          if( frmLeaseAccDtls.totalDetailRecord.value==0)
          {
          alert("Atleast one Detail Reord is Mandatory");
          return false;
          }
       return true;
    }
 

function doSaveChange(){
  sSaveFlag*=0;
  return (sSaveFlag==0)?true:false;  
}



function  doInsertMode()
{
  document.all.buttonFlag.value='';
  document.all.screenMode.value = "N";
  document.all.screenModeLease.value = "N";
  frmLeaseAccDtls.action="../../../LeaseAccomNewMode.do"
  frmLeaseAccDtls.submit();

}

function doQueryMode()
{
 document.all.buttonFlag.value='';
 document.all.screenModeLease.value = "Q";
 document.all.screenMode.value = "Q";
  //document.all.screenModePayScale.value = "Q";
  frmLeaseAccDtls.action="../../../LeaseAccomQueryMode.do"
  frmLeaseAccDtls.submit();

}



function lfnLoad()
{  
  mode = frmLeaseAccDtls.screenMode.value;

  if(mode == '')
  {
    doQueryMode();
  }


 if (frmLeaseAccDtls.screenMode.value == "Q")

     frmLeaseAccDtls.screenModeLease.value="Q";

    
  mode = frmLeaseAccDtls.screenModeLease.value;
   if(mode=='')
   {
     document.all.butGetDetail.disabled="disabled";   
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
   }
  if(mode=='Q')
  {
     document.all.butGetDetail.disabled="disabled";
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";     
  }

 
  if(mode=='U')
  {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";  
  }

  if(mode=='N')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";      
  }

  if(mode=='UG')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
      if(document.all.pageRequested.value>1)
      {
        document.all.butInsert.disabled="disabled";
      }
      else
      {
        for(i=0; i < iTr2 -1; i++)
        {
			//checkAccomType(i+1);
          if (document.getElementsByName("txtToDate")[i].value == '')
          {
            document.all.butInsert.disabled="disabled";
            break;
          }
        } 
      }
  }  

 if (frmLeaseAccDtls.screenMode.value == 'U')
  { 
      document.getElementById("txtEmpNo").disabled = "true";
  }
  else
  {  
    document.getElementById("txtEmpNo").disabled="";       
  }  
  mode1 = document.all.screenMode.value;
  menuHandling(mode1); 
  //Disabling INsert Mode  and Delete Mode 
  if (frmLeaseAccDtls.hdnEmpLbrFlag.value=="E"){
//    document.all.butInsertMode.disabled="true";
//    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    disableInsert();
    }
 }
function disableInsert(){
    //Disabling INsert Mode  and Delete Mode 
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butDel.disabled="true";
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
    document.all.butDelete.disabled="true";
    document.all.butInsert.disabled="true";

}

  
function ShowLovEmpNo()
{
   frmLeaseAccDtls.lovKey.value = "LeaseAccom" + frmLeaseAccDtls.screenName.value + frmLeaseAccDtls.screenMode.value;
   frmLeaseAccDtls.txtDisplayFields.value = "txtEmpNo,txtCpfCode,txtEmpName";      
   frmLeaseAccDtls.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";  
   frmLeaseAccDtls.queryParam.value ="txtSiteId="+frmLeaseAccDtls.loginLocCode.value+",hdnEmpLbrFlag="+frmLeaseAccDtls.hdnEmpLbrFlag.value;
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLeaseAccDtls');
   return true;
}


function chk_DateRange(i)
{
      var m = document.getElementsByName("txtFromDate")[i].value;
      var k = document.getElementsByName("txtToDate")[i].value;
     if(k != "") 
     {                
        var d=parseDate(m);
        var e=parseDate(k);                  
        
        if(d > e)
        {
          document.getElementsByName("txtToDate")[i].value="";
          alert("To Date should be greater than or equal to From Date");
          return false;
        }
      }
   return true;   
}


function DupliCheck()
{
            var oTable = document.getElementById("Detail");
            var iTr2 = oTable.rows.length;
            var flag =0;
             var i = 0;
            var j;
            j = 0;
           

             for(i=0;i<iTr2-2;i++)
            {   
       
                var EmpNo1 = parseInt(document.getElementsByName("txtEmployeeNo")[i].value);
                for(j=i+1;j<iTr2-1;j++)                
                {                       
                      var EmpNo2 = parseInt(document.getElementsByName("txtEmployeeNo")[j].value);
                      if(EmpNo1==EmpNo2)
                      {
                       alert("Duplication of Employee No. is not allowed"); 
                       document.getElementsByName("txtEmployeeNo")[j].focus();
                       return false;
                      }                                               
                 }                              
             }
        return true;
}



function doBasePrevDetail()
{
    frmLeaseAccDtls.userPageRequested.value = 1*frmLeaseAccDtls.pageRequested.value - 1;
    frmLeaseAccDtls.action = "../../../LeaseAccomNextDetailAction.do";
    frmLeaseAccDtls.submit();
}


function doBaseNextDetail()
{
    frmLeaseAccDtls.userPageRequested.value = 1*frmLeaseAccDtls.pageRequested.value + 1;
    frmLeaseAccDtls.action = "../../../LeaseAccomNextDetailAction.do";
    frmLeaseAccDtls.submit();
}

// Added by varalika on 03-Oct-2011
function doBaseShowHistory()
{

      var oTable = document.getElementById("Detail");
    
      if(oTable == null)
      {
       document.all.butHistory.disabled="true";
       return;
      }
    
      var iTr2 = oTable.rows.length;
      var i = 0;
      var f2=0;
	   var noRowSel=0;

      for(i=0; i < iTr2 - 1; i++)
      {
		   if(document.getElementsByName("checked")[i].checked)
          { 
		noRowSel =noRowSel + 1;
		  }
	  }

      for(i=0; i < iTr2 - 1; i++)
      {
           if(document.getElementsByName("checked")[i].checked)
          {          
              f2=f2+1;
		if(noRowSel == 1)
        {
              if(iTr2 <= 2)
              {
				  if(!(frmLeaseAccDtls.txtCreationDate[i].value&&frmLeaseAccDtls.txtCreatedBy[i].value&&frmLeaseAccDtls.txtCreatedSite[i].value))
				  {
				  alert("No history exists for the selected record");
				  }
				  else
				  {
				
				  alert("Record History "+"\n"
				  +"Creation Date :  "+ frmLeaseAccDtls.txtCreationDate[i].value
				  +"\n"
				  +"Created By      :  "+frmLeaseAccDtls.txtCreatedBy[i].value
				  +"\n"
				  +"Created Site    :  "+frmLeaseAccDtls.txtCreatedSite[i].value
				  +"\n"
				  +"Updation Date:  "+frmLeaseAccDtls.txtUpdationDate[i].value
				  +"\n"
				  +"Updated By     :  "+frmLeaseAccDtls.txtUpdatedBy[i].value
				  +"\n"
				  +"Updated Site   :  "+frmLeaseAccDtls.txtUpdatedSite[i].value
				  );
				}
              }
              else
              {
              if(!(frmLeaseAccDtls.txtCreationDate[i].value&&frmLeaseAccDtls.txtCreatedBy[i].value&&frmLeaseAccDtls.txtCreatedSite[i].value))
              {
              alert("No history exists for the selected record");
              }
              else
              {
              alert("Record History"+"\n"
              +"Creation Date :  "+ frmLeaseAccDtls.txtCreationDate[i].value+"\n"
              +"Created By      :  "+frmLeaseAccDtls.txtCreatedBy[i].value
              +"\n"
              +"Created Site    :  "+frmLeaseAccDtls.txtCreatedSite[i].value
              +"\n"
              +"Updation Date:  "+frmLeaseAccDtls.txtUpdationDate[i].value
              +"\n"
              +"Updated By     :  "+frmLeaseAccDtls.txtUpdatedBy[i].value
              +"\n"
              +"Updated Site   :  "+frmLeaseAccDtls.txtUpdatedSite[i].value
              );
            }
           }
          }
		  }
      }
    if(noRowSel == 0 )
	{
	       alert("Select atleast one row for history !");
           document.all.butHistory.disabled="";
           return false;
	}
     if(noRowSel > 1)
        {
           alert("Select only one row for history !");
           document.all.butHistory.disabled="";
           return false;
        }
        
    if(f2 == 1)
      {
          document.all.butHistory.disabled="";
        //  showHistWin('<html:rewrite page="/Payroll/JSP/COMMON/JSP/ShowHistory.jsp" />', 'frmLeaseAccDtls');
          return true;
      }
    
    if(f2 == 0)
      {
		   document.all.butHistory.disabled="true";
       return false;
      }
}
//Added By Varalika Ends here

function JumpDetail()
{
    frmLeaseAccDtls.userPageRequested.value = 1*frmLeaseAccDtls.newPageRequested.value ;
    frmLeaseAccDtls.action = "../../../LeaseAccomNextDetailAction.do";
    frmLeaseAccDtls.submit();
}

function EnableFields()
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    } 
    var iTr2 = oTable.rows.length;
    var i = 0;
    for(i=0; i < iTr2 -1; i++)
    {
      document.getElementsByName("txtAccomTyp")[i].disabled="";
     // document.getElementsByName("txtHraAmt")[i].disabled="";
      document.getElementsByName("txtLicenseFee")[i].disabled=""; 
      document.getElementsByName("txtLeaseAmt")[i].disabled=""; 
      document.getElementsByName("txtFromDate")[i].disabled=""; 
      document.getElementsByName("txtToDate")[i].disabled=""; 
      document.getElementsByName("txtLeasePerc")[i].disabled="";
    }
}

function doRefresh()
{

  frmLeaseAccDtls.action = "../../../LeaseAccomRefresh.do";
  frmLeaseAccDtls.submit();
}

function checkAccomType(indx)
{
  var accomTyp=document.getElementsByName("txtAccomTyp")[indx-1].value;
  if(accomTyp=='ACCOMTYPE$RENT')
  {
   // document.getElementsByName("txtHraAmt")[indx-1].disabled="";
    //document.getElementById("txtLeasePerc").options[0].selected="true";
    document.getElementsByName("txtLicenseFee")[indx-1].value="";
    document.getElementsByName("txtLicenseFee")[indx-1].disabled="true";
    document.getElementsByName("txtLeaseAmt")[indx-1].disabled="true";
    document.getElementsByName("txtLeasePerc")[indx-1].disabled="";
    document.getElementsByName("txtLeasePerc")[indx-1].style.background="#ffffd3";
	
  }else if(accomTyp=='ACCOMTYPE$SPOUSE')
  {
   // document.getElementsByName("txtHraAmt")[indx-1].disabled="true";
    document.getElementsByName("txtLicenseFee")[indx-1].value="";
    document.getElementsByName("txtLicenseFee")[indx-1].disabled="true";
    document.getElementsByName("txtLicenseFee")[indx-1].style.background="#e0e0e0";
    document.getElementsByName("txtLeaseAmt")[indx-1].disabled="true";
    document.getElementsByName("txtLeaseAmt")[indx-1].style.background="#e0e0e0";
	document.getElementById("txtLeasePerc").options[0].selected="true";
    document.getElementsByName("txtLeasePerc")[indx-1].disabled="true";
    document.getElementsByName("txtLeasePerc")[indx-1].style.background="#e0e0e0";
  }else if(accomTyp=='ACCOMTYPE$THIRDP' || accomTyp=='ACCOMTYPE$SELF')
  { 
    document.getElementsByName("txtLicenseFee")[indx-1].value="";
    getLeaseAmmtCalAjax(indx-1);
   // document.getElementsByName("txtHraAmt")[indx-1].disabled="true";
    document.getElementById("txtLeasePerc").options[3].selected="true";
    document.getElementsByName("txtLicenseFee")[indx-1].disabled="";
    document.getElementsByName("txtLicenseFee")[indx-1].style.background="#ffffd3";
    document.getElementsByName("txtLeaseAmt")[indx-1].disabled="";  
    document.getElementsByName("txtLeaseAmt")[indx-1].style.background="#ffffd3";
    document.getElementsByName("txtLeasePerc")[indx-1].disabled="";
    document.getElementsByName("txtLeasePerc")[indx-1].style.background="#ffffd3";
  }else if(accomTyp=='ACCOMTYPE$GOVT' || accomTyp=='ACCOMTYPE$RSSGA' || accomTyp=='ACCOMTYPE$FCI')
  {
    //document.getElementsByName("txtHraAmt")[indx-1].disabled="true";
    //document.getElementById("txtLeasePerc").options[0].selected="true";
    document.getElementsByName("txtLicenseFee")[indx-1].value="";
    document.getElementsByName("txtLicenseFee")[indx-1].disabled="";
    document.getElementsByName("txtLicenseFee")[indx-1].style.background="#ffffd3";
    document.getElementsByName("txtLeaseAmt")[indx-1].disabled="true"; 
    document.getElementsByName("txtLeaseAmt")[indx-1].style.background="#e0e0e0";
    document.getElementsByName("txtLeasePerc")[indx-1].disabled="";
    document.getElementsByName("txtLeasePerc")[indx-1].style.background="#ffffd3";
  }
}

function validateRecords()
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    } 
    var iTr2 = oTable.rows.length;
    var i = 0;
    var count=0;
    for(i=0; i < iTr2 -1; i++)
    {
      if(document.getElementsByName("txtToDate")[i].value=='')
      {
        count=count+1;
      }
      else
      {
        if(!chk_DateRange(i))
        {
          return false;
        }
      }
    }
    if(count>1)
    {
        alert("More than one Records have End date null. Please verify!!!");
        return false;
    }
  return true;
}


function getLeaseAmmtCalAjax(index)
{
	url="../../../GetEmpDtlRetroParZone.do";
    prm="mode=1&txtEmpNo="+frmLeaseAccDtls.txtEmpNo.value+"&screenName="+frmLeaseAccDtls.screenName.value;;
	xml=getXML(url,prm);
	Tags=xml.getElementsByTagName("record");
        if(Tags.length > 0)
	{ 
       		//frmLeaseAccDtls.txtLicenseFee.value=Tags[0].childNodes[0].nodeValue;
                 document.getElementsByName("txtLicenseFee")[index].value=Tags[0].childNodes[0].nodeValue;
        }
	else
	{
		alert("Somthing Wrong Please Contact Administrator");
	}

}

</script>
