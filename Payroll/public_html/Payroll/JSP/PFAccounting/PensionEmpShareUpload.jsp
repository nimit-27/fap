
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
         <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>
<!--<BODY scroll=no onload="lfnLoad();">-->
 <BODY scroll=yes  onload="lfnLoad(); " onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false"></BODY>
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>

<html:form  action="PensionEmpShareUploadAction" name="frmPensionEmpShareUpload" type="FCIPAY.Payroll.WEBTIER.Form.PensionEmpShareUploadForm" scope="session">
<bean:define id="ParentForm" name="frmPensionEmpShareUpload" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>Pension Employer Share Upload</TD>
  </TR>

  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
          
   <TR>
    <TD>
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                 <!-- <TD class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></TD>
                    <!--<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>-->
                    <td bgcolor="#4682B4" nowrap class=actTabText>Pension Employer Share Upload<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
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
                                     <TR height="20">
                                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"   /></td>
                                            <TD class=tableHeader width="7%">Employee Number</td>
                                            <TD class=tableHeader width="9%">Employee Name</td>
                                            <TD class=tableHeader width="9%">Gross Employer Share Amount</TD>
                                            <TD class=tableHeader width="9%">Taxable Employer Share Amount</td>
                                            <TD class=tableHeader width="11%">Tax Adjusted from Employer OB</td>
                                            <td class=tableHeader width="9%">Net Employer OB Amount</td>  
                                            <td class=tableHeader width="11%">Remarks</td> 
                                      </TR>    
                                 
                          <logic:iterate id="intInfo" name="frmPensionEmpShareUpload"  property="pensionEmpShareUpload" type="FCIPAY.Payroll.UTILITY.PensionEmpShareUploadBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="intInfo" property="status" value="D" > 
                                        <logic:equal name="intInfo" property="status" value="N" >
                                        <tr> 
                                          <td ><html:checkbox property="checked" name="frmPensionEmpShareUpload" onclick="checkRecord();"  /></td>
                                          
                                          <td ><html:text property="txtEmployeeNo" name="intInfo" styleClass="required" style="width:60%" readonly="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);"  />
                                          <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  onclick="ShowEmployeeNo(this.alt);" >
                                           </td>
                                          
                                          <td > <html:text property="txtEmployeeNoDesc" name="intInfo"  styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td> 
                                        
                                          <td >  <html:text property="txtGrossAmount" name="intInfo" styleClass="required" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="checkgrossamt(this.alt);" /></td> 
                                         
                                           <td >   <html:text property="txtTaxableAmount" name="intInfo" styleClass="required" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="checktaxamt(this.alt);" /></td> 
                                         
                                           <td >   <html:text property="txtIncomeTax" name="intInfo"  styleClass="required" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="checkinctaxamt(this.alt);" /></td> 
                                         
                                           <td >   <html:text property="txtNetAmount" name="intInfo"  styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td> 
                                        
                                            <td >   <html:text property="txtRemarks" name="intInfo"   size="30" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td> 

                                           <html:hidden property="itemChecked" name="intInfo" />
                                           <html:hidden property="status" name="intInfo" />
                                           <html:hidden property="detailId" name="intInfo" />
                                        </tr>
                                        </logic:equal>
                                        <logic:notEqual name="intInfo" property="status" value="N" >
                                        <tr> 
                                            <td ><html:checkbox property="checked" name="frmPensionEmpShareUpload"  onclick="checkRecord();" value="false"  /></td>
                                            <td><html:text property="txtEmployeeNo" name="intInfo" styleClass="locked" style="width:60%" readonly="true" alt="<%=String.valueOf(i)%>" /></td>
                                            <td><html:text property="txtEmployeeNoDesc" name="intInfo" styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" /></td> 
                                            <td><html:text property="txtGrossAmount" name="intInfo" styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" /></td> 
                                            <td><html:text property="txtTaxableAmount" name="intInfo" styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" /></td> 
                                            <td><html:text property="txtIncomeTax" name="intInfo" styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" /></td> 
                                            <td><html:text property="txtNetAmount" name="intInfo" styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" /></td> 
                                            <td><html:text property="txtRemarks" name="intInfo" styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" /></td> 

                                            <html:hidden property="itemChecked" name="intInfo" />
                                            <html:hidden property="status" name="intInfo" />
                                            <html:hidden property="detailId" name="intInfo" />
                                        </tr>
                                        </logic:notEqual>

                                  </logic:notEqual>
                                <logic:equal name="intInfo" property="status" value="D" >
                                   <tr>
                                         <td ><html:hidden property="checked" name="frmPensionEmpShareUpload" value="notchecked" /></td>
                                 
                                         <td ><html:hidden property="txtGrossAmount" name="intInfo" /></td>
                                         <td ><html:hidden property="txtTaxableAmount" name="intInfo" /></td>
                                         <td ><html:hidden property="txtIncomeTax" name="intInfo" /></td>
                                         <td ><html:hidden property="txtNetAmount" name="intInfo" /></td>
                                         <td ><html:hidden property="txtRemarks" name="intInfo" /></td>
                                         <td ><html:hidden property="txtEmployeeNo" name="intInfo" /></td>
                                         <td ><html:hidden property="txtEmployeeNoDesc" name="intInfo" /></td>
                                       
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo"  />
                                    </tr>
                                  </logic:equal>                                    
                          </logic:iterate>
                                
                            </TBODY>
                          </TABLE>
                        </DIV>
                      </TD>
                    </TR> 
                                        
                                <td colspan=11>	
                                  <TABLE border=0>
                                    <TBODY>
                                      <TR>
                                        <td colspan=11>	
                                          <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                                        </TD>                                  
                                      </TR>
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
                <!-- Tab Table Ends -->
 
                                        <!-- Bottom Blue Bar -->
                                         
                <TR>
                  <td align=center bgcolor=#4682b4 width="40%"></td>
                  <td  bgcolor=#4682b4></td>
                  <td bgColor=#4682b4></td>
                  <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
                </TR>
                  </TBODY>
              </TABLE>
            <!-- Container Table Ends-->
<html:hidden property="headerPrimaryKey" name="frmPensionEmpShareUpload"  />

<html:hidden property="screenMode" name="frmPensionEmpShareUpload"  />
<html:hidden name="frmPensionEmpShareUpload"  property="screenName" value="PensionEmpShareUpload" />
<html:hidden name="frmPensionEmpShareUpload"  property="forwardedPage" />

 
<html:hidden property="lovKey" name="frmPensionEmpShareUpload"  />
<html:hidden property="txtFields" name="frmPensionEmpShareUpload"  />
<html:hidden property="txtSearchFields" name="frmPensionEmpShareUpload"  />
<html:hidden property="txtDisplayFields" name="frmPensionEmpShareUpload"  />
<html:hidden property="txtIndex" name="frmPensionEmpShareUpload"  />
<html:hidden property="txtInputField" name="frmPensionEmpShareUpload"  />
<html:hidden property="buttonFlag" name="frmPensionEmpShareUpload"  />
<html:hidden property="userPageRequested" name="frmPensionEmpShareUpload" />
<html:hidden property="pageRequested" name="frmPensionEmpShareUpload" />
<html:hidden property="loginLocCode" name="frmPensionEmpShareUpload" />
<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>

<script language="javascript">

function lfnLoad()
{
   var mode = document.all.screenMode.value;
    
    if(mode=='')
    {
        
        doQueryMode();
    }    
    if(mode=='Q')
    {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="true";
    }
    if(mode=='U')
    {
      document.all.butGetDetail.disabled="true";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
    }

     detMenuHandling(mode);
    if(document.all.hdnEmpLbrFlag.value=='V')
    {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
    }
}

function changed(i)
{
  frmPensionEmpShareUpload.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[i-1].value == 'Q')
     document.getElementsByName("status")[i-1].value = 'U';
}
function doQueryMode()
{ 
    
    document.all.buttonFlag.value='';    
    frmPensionEmpShareUpload.action="../../../PensionEmpShareUploadQueryMode.do"
    frmPensionEmpShareUpload.submit();
}

function doRefresh()
{
    frmPensionEmpShareUpload.action="../../../PensionEmpShareUploadRefresh.do"
    frmPensionEmpShareUpload.submit();
}

function GetDetail()
{
   frmPensionEmpShareUpload.headerPrimaryKey.value = document.getElementById("loginLocCode").value;
   frmPensionEmpShareUpload.screenMode.value='U';    
   frmPensionEmpShareUpload.action="../../../PensionEmpShareUploadGetDetailAction.do"
   frmPensionEmpShareUpload.submit();
}

function SaveRecord()
{ 
    if(mandatory_Check("frmPensionEmpShareUpload"))
    {
        //enableAll(); 
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;       
        for(i=0; i < iTr2 -1; i++)
        {
            if (document.getElementsByName("status")[i].value == 'D')
               frmPensionEmpShareUpload.detailDataChanged.value = "true";
        }    
        document.all.buttonFlag.value='';
       frmPensionEmpShareUpload.headerFields.value = "false";
       document.all.butSave.disabled="true";
       document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
       frmPensionEmpShareUpload.action = "../../../PensionEmpShareUploadSaveAction.do";
       frmPensionEmpShareUpload.submit();
    }
    else
    {
        return false;
    }
    
}

function doBaseAddRow()
{
    if(mandatory_Check("frmPensionEmpShareUpload"))
    { 
    
        document.all.buttonFlag.value='';
        frmPensionEmpShareUpload.screenMode.value = "U";  
        document.forms[0].action = "../../../PensionEmpShareUploadAddRowAction.do";
        //enableAll(); 
        
        document.forms[0].submit();
    }
    else
    {
        return false;
    }
}

function doBaseDelRow()
{
    document.all.buttonFlag.value='';
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;    
    for(i=0; i < iTr2 -1; i++)
    {    
        if(document.getElementsByName("checked")[i].checked)
        {
            document.getElementsByName("itemChecked")[i].value = "Y";
            frmPensionEmpShareUpload.detailDataChanged.value = "true";      
        }
    }    
   // enable(); 
    document.forms[0].action = "../../../PensionEmpShareUploadDeleteRowAction.do";
    document.forms[0].submit();  
}


function ShowEmployeeNo(i)
{
   frmPensionEmpShareUpload.lovKey.value = "PensionEmpShareEmployeeNo" + frmPensionEmpShareUpload.screenName.value + frmPensionEmpShareUpload.screenMode.value;
   frmPensionEmpShareUpload.queryParam.value = "txtSiteID="+frmPensionEmpShareUpload.loginLocCode.value;
   frmPensionEmpShareUpload.txtDisplayFields.value = "txtEmployeeNo,txtEmployeeNoDesc";
   frmPensionEmpShareUpload.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.PaycodeVSAgencycode.EmployeeName,Payroll.LoanForeclosure.CPFCode";
   frmPensionEmpShareUpload.txtIndex.value =i;      
   frmPensionEmpShareUpload.txtInputField.value ="txtEmployeeNo"; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPensionEmpShareUpload');
    return true;
}

function doBasePrevDetail()
{
    frmPensionEmpShareUpload.userPageRequested.value = 1*frmPensionEmpShareUpload.pageRequested.value - 1;
    frmPensionEmpShareUpload.action = "../../../PensionEmpShareUploadPrevAction.do";
    frmPensionEmpShareUpload.submit();
}


function doBaseNextDetail()
{
    frmPensionEmpShareUpload.userPageRequested.value = 1*frmPensionEmpShareUpload.pageRequested.value + 1;
    frmPensionEmpShareUpload.action = "../../../PensionEmpShareUploadNextAction.do";
    frmPensionEmpShareUpload.submit();
}

function JumpDetail()
{
    frmPensionEmpShareUpload.userPageRequested.value = 1*frmPensionEmpShareUpload.newPageRequested.value ;
    frmPensionEmpShareUpload.action = "../../../PensionEmpShareUploadJumpAction.do";
    frmPensionEmpShareUpload.submit();
}




function checkgrossamt(i)
{
 
  var grossamt = document.getElementsByName("txtGrossAmount")[i-1].value;
  if (grossamt< 0 || grossamt > 1000000)
  {
    alert("Please enter amount in between 0 to 10 lakhs");
    document.getElementsByName("txtGrossAmount")[i-1].value="";
    return false;
    
  }
}

 function checktaxamt(i)
{

  var taxamt = document.getElementsByName("txtTaxableAmount")[i-1].value;
  var grossamt = document.getElementsByName("txtGrossAmount")[i-1].value;
 
  if (taxamt < 0 || taxamt > 1000000)
  {
    alert("Please enter amount in between 0 to 10 Lakhs");
    document.getElementsByName("txtTaxableAmount")[i-1].value="";
    return false;
  }
 
  if(taxamt > 0 || taxamt < 1000000) 
  {
     
      if( parseInt((taxamt),10) > parseInt((grossamt),10))
      {
             alert("Taxable amount can't be greater than gross amount");
             document.getElementsByName("txtTaxableAmount")[i-1].value="";
             return false;
      }
  
      else 
      {
         return true;
      }
      
   }
}  
   
 function checkinctaxamt(i) 
 {
     var incometax = document.getElementsByName("txtIncomeTax")[i-1].value;
     var taxamt = document.getElementsByName("txtTaxableAmount")[i-1].value;
     if (incometax < 0 || incometax > 1000000) 
       {
           alert("Please enter amount in between 0 to 1 lakhs");
           document.getElementsByName("txtIncomeTax")[i-1].value="";
           return false;
        }
      if(incometax > 0 || incometax <1000000) 
       {
           if( parseInt((incometax),10) > parseInt((taxamt),10))
              {
                alert("Income Tax amount can't be greater than taxable amount");
                document.getElementsByName("txtIncomeTax")[i-1].value="";
                return false;
              }
           else
           {
               return true;
           }
       }
 }
  
  
 /* lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName("txtPayCode")[rInd-1].value;
  newpay=newComb;
  newComb = newComb + "-";
  newComb = newComb + document.getElementsByName("txtAgency")[rInd-1].value + "-" + document.getElementsByName("txtEmployeeNo")[rInd-1].value;
   var newEmp= document.getElementsByName("txtEmployeeNo")[rInd-1].value;
   var newagncy=document.getElementsByName("txtAgency")[rInd-1].value;
  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(ind != rInd && document.getElementsByName("status")[ind-1].value!='D')
    {
      oldComb = document.getElementsByName("txtPayCode")[ind-1].value;
      oldpay=oldComb;
      oldComb = oldComb + "-";
      oldComb = oldComb + document.getElementsByName("txtAgency")[ind-1].value + "-" + document.getElementsByName("txtEmployeeNo")[ind-1].value;
     var oldEmp= document.getElementsByName("txtEmployeeNo")[ind-1].value;
     var oldagncy=document.getElementsByName("txtAgency")[ind-1].value;
      
      if((oldComb == newComb) || ((newpay == oldpay) && (newEmp == oldEmp) && (newagncy != oldagncy)))
      {
        alert("You can't enter duplicate paycode.If you entering for a particular employee.Kindly enter employee number first.");
        document.getElementsByName("txtAgency")[rInd-1].value="";
        document.getElementsByName("txtAgencyDesc")[rInd-1].value="";
        return;
      }
      
   }

  } */

</script>