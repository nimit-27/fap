<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
   <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>


<html:form  action="MaintInterestRate" name="frmMaintInterestRate" type="FCIPAY.Payroll.WEBTIER.Form.MaintInterestRateForm" scope="session">
<bean:define id="ParentForm" name="frmMaintInterestRate" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:errors/>


<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN PF INTEREST RATES</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       <!--<div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Date Range </TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="2"></td>
         </tr>
        <tr>

            <td class="labelText"  width="15%" >Date From</td>
            <td><html:text property="txtDateFrom"  size="23" readonly="true" styleClass="required" /><img src="..\INCLUDES\IMAGES\cal.gif"   width=15 height=19 align="top" styleClass="lov" property="butTxtDateFrom" alt="<%=(i-1) %>" onclick="showCalendar('txtDateFrom',this)" /></td>
   

            <td class=labelText width="20%" >Date To</td>
            <td><html:text property="txtDateTo"  size="23" readonly="true" styleClass="optional" onchange="changed()" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" name="butTxtDateTo" alt="<%=(i-1) %>" onclick="showCalendar('TxtDateTo',this)" /></td>
            
         <td class=labelText width="15%" >MEMBER TYPE</td>
         <td>                             
                  <html:select  property="memberType" alt="memberType" styleClass="required" > 
                  <!--<html:option value="" >-----------Please Select-----------</html:option>  -->
                  <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option> 
               
                 <html:option value="RPFCRATES" > <bean:message key="Payroll.PFRate.RPFCRATES" /></html:option>
		<html:option value="FCICPFTRUSTRATES" > <bean:message key="Payroll.PFRate.FCICPFTRUSTRATES" /></html:option>
                  </html:select>
                  </td>
        </tr>

          
           <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>
    </div>
    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>PF Slab Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="11">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0"id="Detail">
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintInterest.afr" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintInterest.ato" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintInterest.inrate" /></TD>
                            
                            </TR>

                           <logic:iterate id="pfrInfo" name="frmMaintInterestRate" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintInterestRateBean" >
                              <% ++i; %>
                                <logic:notEqual name="pfrInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                       <td align=center ><html:checkbox property="checked" name="frmMaintInterestRate" onclick="checkRecord();" /></td>
                                       <td ><html:text property="startField" name="pfrInfo" size="9" readonly="true"  styleClass="required" style="width:100%;  text-align:right" alt="<%=String.valueOf(i)%>"  onchange="lfnChange(this.value,this.alt); " /></td>         
                                       <td ><html:text property="endField" name="pfrInfo" size="9"  styleClass="required" style="width:100%; text-align:right" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);  changeDtlStartField('startField','endField',this.alt,'0');" /></td>         
                                       <td ><html:text property="txtInrRate" name="pfrInfo" size="9"    styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>         
                                       <html:hidden property="txtSrlNo" name="pfrInfo" />
                                       <html:hidden property="itemChecked" name="pfrInfo" />
                                       <html:hidden property="status" name="pfrInfo" />
                                       <html:hidden property="detailId" name="pfrInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>
                                  <logic:equal name="pfrInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintInterestRate" value="notchecked" /></td>
                                       <td ><html:hidden property="startField" name="pfrInfo"  /></td>
                                       <td ><html:hidden property="endField" name="pfrInfo" /></td>
                                       <td ><html:hidden property="txtInrRate" name="pfrInfo" /></td>
                                       <html:hidden property="txtSrlNo" name="pfrInfo" />
                                       <html:hidden property="itemChecked" name="pfrInfo" />
                                       <html:hidden property="status" name="pfrInfo" />
                                       <html:hidden property="detailId" name="pfrInfo" value="Default"/>
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
                    <TR>
                           <TD><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" /></td>                  </TR>
                  </TBODY>
                </TABLE>
                </TD>
               
                  </tr>
  </TBODY>
		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
               <tr>
		<TD background="../INCLUDES/IMAGES/line_r.gif"><IMG src="../INCLUDES/IMAGES/pixel.gif" border=0></TD>
		</TR>
    <TR>
     <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
               <td align=center bgcolor=#4682b4 width="40%"></td>
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


<html:hidden name="frmMaintInterestRate"  property="screenName" value="InterestRateScreen" />
<html:hidden name="frmMaintInterestRate"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintInterestRate" />
<html:hidden property="headerPrimaryKey" name="frmMaintInterestRate" />
<html:hidden property="screenMode" name="frmMaintInterestRate" />
<html:hidden property="buttonFlag" name="frmMaintInterestRate"  />
<html:hidden name="frmMaintInterestRate"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmMaintInterestRate" />
<html:hidden property="userPositionRequested" name="frmMaintInterestRate" />
<html:hidden property="pageRequested" name="frmMaintInterestRate" />
<html:hidden property="userPageRequested" name="frmMaintInterestRate" />
<html:hidden property="flag" name="frmMaintInterestRate" />


</html:form>
</body>
</html:html>

 
<script language="javascript">

function changed()
{
  document.all.headerDataChanged.value="true";
}

function lfnChange(val,ind)
{
    if(num_Check(val,1))
    {
      maxCheck(ind);
      frmMaintInterestRate.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
    }
    else
    {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
    }
}

function lfnChangePer(val,ind)
{
   if(percent_Check(val))
  {
      frmMaintInterestRate.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

function maxCheck(i)
{
     var low = parseInt(document.getElementsByName("startField")[i-1].value);
     var high = parseInt(document.getElementsByName("endField")[i-1].value);

    if(high <= low )
    {
      alert("Amount To Should be greater than Amount From")
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;                        
    }
    return true;
}

function getHeaderRecord()
{
  document.all.buttonFlag.value='';
    document.all.screenMode.value='U';   
  frmMaintInterestRate.flag.value = "false";
  document.all.butExecute.disabled="true";
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
  frmMaintInterestRate.action="../../../InterestRateFirstGetHeaderAction.do"
  frmMaintInterestRate.submit();
}
 function doGetNextHeader()
{
//    alert("Hi next header");    
   document.all.buttonFlag.value='';
frmMaintInterestRate.flag.value = "false";
    frmMaintInterestRate.userPositionRequested.value = 1*frmMaintInterestRate.positionRequested.value + 1;  
    frmMaintInterestRate.action="../../../InterestRateRateGetNextHeader.do";
    frmMaintInterestRate.submit();
}

function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmMaintInterestRate.flag.value = "false";
  frmMaintInterestRate.userPositionRequested.value = 1*frmMaintInterestRate.newPositionRequested.value;
  frmMaintInterestRate.action = "../../../InterestRateRateGetNextHeader.do";
  frmMaintInterestRate.submit();
}



function PrevHeader()
{
  document.all.buttonFlag.value='';
frmMaintInterestRate.flag.value = "false";
  frmMaintInterestRate.userPositionRequested.value = frmMaintInterestRate.positionRequested.value - 1;
  frmMaintInterestRate.action = "../../../InterestRateRateGetNextHeader.do";
  frmMaintInterestRate.submit();
}
  function doRefresh()
{  
  document.all.buttonFlag.value='';
  frmMaintInterestRate.action="../../../InterestRateRefresh.do"
  frmMaintInterestRate.submit();
}
function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmMaintInterestRate.flag.value = "false";
  frmMaintInterestRate.userPositionRequested.value = 1*frmMaintInterestRate.newPositionRequested.value;
  frmMaintInterestRate.action = "../../../InterestRateRateGetNextHeader.do";
  frmMaintInterestRate.submit();
} 

function doBaseAddRow()
{
 
  if(mandatory_Check("frmMaintInterestRate"))
  {
    document.all.buttonFlag.value='D'; 
    document.forms[0].action = "../../../InterestRateAddRowAction.do";
    document.forms[0].submit();
  }
  else
  {
      return false;
  }
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
    var strRecList='';
    for(i=0; i < iTr2 -1; i++)
    {
      if(document.getElementsByName("checked")[i].checked)
      {
        if(document.getElementsByName("txtSrlNo")[i].value=="" )
        {
          document.getElementsByName("itemChecked")[i].value = "Y";
          frmMaintInterestRate.detailDataChanged.value = "true";
        }
        else
          strRecList=strRecList+(i+1)+",";
      }
    }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
   
    document.forms[0].action = "../../../InterestRateDeleteRowAction.do";
    document.forms[0].submit();  
  }

function SaveRecord()
{
  if(mandatory_Check("frmMaintInterestRate"))
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
      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintInterestRate.detailDataChanged.value = "true";
  }
      document.all.buttonFlag.value=''; 
  document.all.screenMode.value='U';      
  frmMaintInterestRate.headerFields.value = "false";
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintInterestRate.action = "../../../InterestRateSaveAction.do";
  frmMaintInterestRate.submit();
}
 else
  {
    return false;
  }
}

function GetDetail()
{
  document.all.buttonFlag.value=''; 
 frmMaintInterestRate.flag.value = "true";
  frmMaintInterestRate.action="../../../InterestRateGetDetailAction.do"
  frmMaintInterestRate.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value='';    
  document.all.screenMode.value='N';  
  frmMaintInterestRate.action="../../../InrRateNewMode.do"
  frmMaintInterestRate.submit();
}

function doRefresh()
{
  document.all.buttonFlag.value=''; 
  frmMaintInterestRate.action="../../../InterestRateRefresh.do"
  frmMaintInterestRate.submit();
}
     
function doQueryMode()
{
  document.all.screenMode.value='Q';  
  document.all.buttonFlag.value=''; 
  frmMaintInterestRate.action="../../../InrRateQueryMode.do"
  frmMaintInterestRate.submit();
}

function showCalendar(inputId, butId) {  
   if(butId.alt)
   {
    iIndex=butId.alt;
   }
   else
   {
    iIndex="-1";
   }
   Calendar.setup({inputField	: inputId,
		   ifFormat	: "%d-%b-%Y",
		   button	: butId,
       position: iIndex
  		  });
        
   return false;
}

function AmtCheck()
{
            var oTable = document.getElementById("Detail");
            var iTR = oTable.rows.length;
            var flag =0;
            
            for(i=0;i<iTR-1;i++)
            {   
                var m = parseInt(document.getElementsByName("startField")[i].value);
                var n= parseInt(document.getElementsByName("endField")[i].value);               

                if (m >= n)
                {
                   alert("Amount To Should Be Greater Than Amount From");
                   document.getElementsByName("endField")[i].focus(); 
                   return false;
                }                             

             
                                 
            }             
 
        return true;
}


function lfnLoad()
{
  //alert(document.all.screenMode.value);
  mode = document.all.screenMode.value;
  if(mode == '')
  {
      doQueryMode();
  }
  flag = document.all.flag.value;
  if(mode=='U')
  {

     // document.all.txtDateFrom.disabled="true";
   //   document.all.txtDateTo.disabled="true";
      if(flag == 'true')
      {
        document.all.butGetDetail.disabled="true";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";
      }
      else
      {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="true";
        document.all.butDelete.disabled="true";
      }

  }

  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
      document.all.txtDateFrom.disabled="";
      document.all.txtDateTo.disabled="";
  }
  if(mode=='Q')
  {
      document.all.butGetDetail.disabled="true";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
  }

  menuHandling(mode);
  
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
 

</script>
 
