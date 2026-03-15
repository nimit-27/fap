<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
    <html:base/>
      <TITLE><bean:message key="Payroll.title" /></TITLE>
      <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
      <link rel="S6+TYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
      <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
  </head>
  <BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
    <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

    <html:form  action="IncentiveOperationsDtlAction" name="frmIncentiveOperationsDtl" type="FCIPAY.Payroll.Labour.WEBTIER.Form.IncentiveOperationsDtlKotForm" scope="session">
      <bean:define id="ParentForm" name="frmIncentiveOperationsDtl" toScope="request" />
      <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
      <html:errors/>
      <html:hidden property="detailDataChanged" />
      <html:hidden property="headerFields" value="false" />
      <%! int i=0,j=0; %>
      <% i = 0;j=0; %>

      <TABLE cellSpacing=0 bgColor=#bdd0ef>
        <TR height=30>
          <TD  colSpan=11 class=mainHeader height=10>LABOUR OPERATION DETAILS</TD>
        </TR>
        <tr height="10"><td class=userText colspan="11"></td></tr>
      </TABLE>
<!--container table starts -->
      <TABLE cellSpacing=0 cellPadding=0 border=0 >
        <TBODY>
          <TR>
            <TD>
       <!-- Body table Starts -->
              <TABLE cellSpacing=0 cellPadding=0 border="0">
       <!--  Header Row Starts -->
                <TR>
                  <TD class=subHeader colspan=6>Header For Labour Operation Details</TD>
                </TR>
                <TR>
                  <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>

                <tr height="15" >
                  <td colspan="2"></td>
                </tr>
         
                <tr>
                  <td class="labelText"  width="20%" >Effective From Date</td>
                  <td align="left" width="15%" >
                  <html:text  property="txtEffFromDt"  readonly="true" maxlength="10" size="16" styleClass="required" />
                  <logic:equal property= "screenMode" name= "frmIncentiveOperationsDtl" value="Q">            
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="locked" readonly="true" property="buttxtEmpInSubDateFrm" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffFromDt',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
                  </logic:equal>
                  
                  <logic:equal property= "screenMode" name= "frmIncentiveOperationsDtl" value="N">            
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDateFrm" alt="<%=(i-1) %>"  onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtEffFromDt',this)" />
                  </logic:equal>               
                  </td>        
  
                  <td class="labelText"  width="20%" >Effective To</td>
                  <td align="left" width="15%">
                  <html:text  property="txtEffToDt"  readonly="true" maxlength="10" size="16" styleClass="optional" />
                  <logic:equal property= "screenMode" name= "frmIncentiveOperationsDtl" value="Q">            
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffToDt',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmIncentiveOperationsDtl" value="N">            
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" disabled="true" property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtEffToDt',this)" />
                  </logic:equal>
                  
                  <td class="labelText"  width="20%" >Datum Value</td>
                  <td align="left">
                  <logic:equal property= "screenMode" name= "frmIncentiveOperationsDtl" value="N">
                  <html:text  property="txtDatumVal"  readonly="" maxlength="10" size="16" styleClass="required" />  
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmIncentiveOperationsDtl" value="N">
                  <html:text  property="txtDatumVal"  readonly="" maxlength="10" size="16" styleClass="optional" />  
                  </logic:notEqual>
                  
                </tr> 
                <tr>            
                  <td class="labelText"  width="20%" >Bag Type</td>
                  <td align="left">                
                  <html:select property="txtBagType"   styleClass="required" alt="<%=String.valueOf(i)%>"  style="WIDTH: 98%"  >                  
                  <html:option value="" >  <bean:message key="Payroll.pleaseSelect" /></html:option>   
                  <html:option value="S" > Small Bag Type </html:option>
                  <html:option value="B" > Big Bag Type</html:option>
                  </html:select>
                </td>    
                                                
               <TD class=labelText>Operation Type</TD>
                  <td align="left" >
                  <html:text  property="txtOperationID"   size="11" styleClass="required" readonly="true" />
                  <logic:equal property= "screenMode" name= "frmIncentiveOperationsDtl" value="Q">
                  <img src="../INCLUDES/IMAGES/lov.jpg"  height="16" align="center" name="buttxtEmpNo" onclick ="ShowOperationType();">
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmIncentiveOperationsDtl" value="N">
                  <img src="../INCLUDES/IMAGES/lov.jpg"  height="16" align="center" name="buttxtEmpNo" onclick ="ShowOperationType();">
                  </logic:equal>
                  </td>
                  <td align="left" colspan="2">                
                  <html:text property="txtOperationDesc" readonly = "true" styleClass = "locked"  size = "50" /> </td>  
                </tr>

                <tr height="10">		    
                  <TD colspan="2" > </TD>
                </tr>
              </table>
    
              <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
                <TR height="200">
                  <TD colspan=6>
                    <TABLE cellSpacing=0 cellPadding=0 >                    
                        <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                      </tr>                      
                      <tr> <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                      <td bgcolor="#4682B4" nowrap class=actTabText>Labour Operation Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                  <DIV id=divDtlTable style="height:280px" >
  		                        	<!-- Detail table starts -->
                                    <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                      <TBODY>
                                        <TR height="22">
                                        
                                        <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"   /></td>                                       
                                        <TD class=tableHeader width="7%">Datum From</td>
                                        <TD class=tableHeader width="7%">Datum To</TD>                                         
                                        <TD class=tableHeader width="7%">L1</TD>
                                        <TD class=tableHeader width="7%">L2</td>
                                        <TD class=tableHeader width="7%">L3</td>
                                        <TD class=tableHeader width="7%">L4</td>
                                        <TD class=tableHeader width="7%">L5</td>
                                        <TD class=tableHeader width="7%">L6</td>                                     
                                              
                                      </TR>   
                                                                                                           <!--  property="categorylocationmap" -->
                                   <logic:iterate id="intInfo" name="frmIncentiveOperationsDtl"  property="incentiveoperationsdtl" type="FCIPAY.Payroll.Labour.Utility.IncentiveOperationsDtlKotBean" indexId="idx" >
                                   <% ++i; %>
                                   <logic:notEqual name="intInfo" property="status" value="D" >                                
                                   <tr>
                                      <td ><html:checkbox property="checked" name="frmIncentiveOperationsDtl" onclick="checkRecord();"  /></td>               
                                      <td  width="10%">   <html:text  property="txtDatumFrom" name="intInfo"  readonly="" style="width:100%;text-align:right" maxlength="10"  styleClass="required" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"/> </td>
                                      <td  width="10%">   <html:text  property="txtDatumTo" name="intInfo"  readonly="" style="width:100%;text-align:right" maxlength="10"   styleClass="required" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"/>  </td>
                                      <td  width="10%">   <html:text  property="txtL1"   name="intInfo"     readonly="" style="width:100%;text-align:right" maxlength="10"  styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57))return false;"/>  </td>
                                      <td  width="10%">   <html:text  property="txtL2"  name="intInfo"      readonly="" style="width:100%;text-align:right" maxlength="10"  styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57))return false;"/> </td>
                                      <td  width="10%">   <html:text  property="txtL3"  name="intInfo"      readonly="" style="width:100%;text-align:right" maxlength="10"  styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57))return false;"/> </td>
                                      <td  width="10%">   <html:text  property="txtL4"  name="intInfo"      readonly="" style="width:100%;text-align:right" maxlength="10" size="15" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57))return false;"/> </td>
                                      <td  width="10%">   <html:text  property="txtL5"  name="intInfo"      readonly=""  style="width:100%;text-align:right" maxlength="10" size="15" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57))return false;"/> </td> 
                                      <td  width="10%">   <html:text  property="txtL6"   name="intInfo"     readonly="" style="width:100%;text-align:right" maxlength="10" size="15" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57))return false;"/> </td>
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo"  />
                                      <td>  <html:hidden property="txtOpr_Sequence" name="intInfo"  /> </td>  
                                
                                   </logic:notEqual>     
                                   </tr>
                                  <logic:equal name="intInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmIncentiveOperationsDtl" value="notchecked" /></td>
                                       <td ><html:hidden property="txtDatumFrom" name="intInfo"  /></td>
                                  
                                       <td ><html:hidden property="txtDatumTo" name="intInfo" /></td>
                                        
                                       <td ><html:hidden property="txtL1" name="intInfo" /></td>
                                       <td ><html:hidden property="txtL2" name="intInfo" /></td>
                                       <td ><html:hidden property="txtL3" name="intInfo" /></td>
                                       <td ><html:hidden property="txtL4" name="intInfo" /></td>
                                       <td ><html:hidden property="txtL5" name="intInfo" /></td>
                                       <td ><html:hidden property="txtL6" name="intInfo" /></td>
                                      <td> <html:hidden property="txtOpr_Sequence" name="intInfo"  /> </td>
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
<html:hidden property="headerPrimaryKey" name="frmIncentiveOperationsDtl"  />

<html:hidden property="screenMode" name="frmIncentiveOperationsDtl"  />
<html:hidden name="frmIncentiveOperationsDtl"  property="screenName" value="IncentiveOperationsDtlMap" />
<html:hidden name="frmIncentiveOperationsDtl"  property="forwardedPage" />


<html:hidden property="lovKey" name="frmIncentiveOperationsDtl"  />
<html:hidden property="txtFields" name="frmIncentiveOperationsDtl"  />
<html:hidden property="txtSearchFields" name="frmIncentiveOperationsDtl"  />
<html:hidden property="txtDisplayFields" name="frmIncentiveOperationsDtl"  />
<html:hidden property="txtIndex" name="frmIncentiveOperationsDtl"  />
<html:hidden property="txtInputField" name="frmIncentiveOperationsDtl"  />
<html:hidden property="buttonFlag" name="frmIncentiveOperationsDtl"  />
<html:hidden property="userPageRequested" name="frmIncentiveOperationsDtl" />
<html:hidden property="pageRequested" name="frmIncentiveOperationsDtl" />
<html:hidden property="loginLocCode" name="frmIncentiveOperationsDtl" />
<html:hidden property="positionRequested" name="frmIncentiveOperationsDtl" />
<html:hidden property="userPositionRequested" name="frmIncentiveOperationsDtl" />
<input type="hidden" name="queryParam" />
                                      
</html:form>
</body>
</html:html>
<script language="javascript">
function lfnLoad()
{
  
    frmIncentiveOperationsDtl.butGetDetail.disabled="";  
    frmIncentiveOperationsDtl.butInsert.disabled="true";
    frmIncentiveOperationsDtl.butDelete.disabled="true";
 
    mode=document.all.screenMode.value;  
 
    if(mode=='')
    {
        doQueryMode();
    }
    if (mode == 'U')
    {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="";
    }
    
    if (mode == 'Q')
    {
      document.all.txtEffToDt.disabled="true"; 
    }
    if (frmIncentiveOperationsDtl.screenMode.value == 'U')
    { 
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;        
    }
        if (frmIncentiveOperationsDtl.screenMode.value == 'N')
    {
        frmIncentiveOperationsDtl.butInsert.disabled="";
    }

    menuHandling(mode);
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";   
    if(document.all.hdnEmpLbrFlag.value=='V')
    {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      frmIncentiveOperationsDtl.butInsert.disabled="true";
      frmIncentiveOperationsDtl.butDelete.disabled="true";
    }
}
function doQueryMode()
{
    
    document.all.buttonFlag.value='';    
    frmIncentiveOperationsDtl.action="../../../IncentiveOperationsDtlQueryMode.do"
    frmIncentiveOperationsDtl.submit();
}

function doRefresh()
{
    frmIncentiveOperationsDtl.action="../../../IncentiveOperationsDtlRefresh.do"
    frmIncentiveOperationsDtl.submit();
}

function GetDetail()
{
    if(mandatory_Check("frmIncentiveOperationsDtl"))
    {
      frmIncentiveOperationsDtl.screenMode.value='U';    
      frmIncentiveOperationsDtl.action="../../../IncentiveOperationsDtlGetDetailAction.do"
      frmIncentiveOperationsDtl.submit();
    }
    else
    {
      return false;
    }
}

function SaveRecord()
{ 
  
  AmtCheck();
 if(mandatory_Check("frmIncentiveOperationsDtl"))
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
           frmIncentiveOperationsDtl.detailDataChanged.value = "true";
           
        }    
        document.all.buttonFlag.value='';
        
        frmIncentiveOperationsDtl.headerFields.value = "false";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmIncentiveOperationsDtl.action = "../../../IncentiveOperationsDtlSaveAction.do";
        frmIncentiveOperationsDtl.submit();
    }
    else
    {
        return false;
    }
 
}
function doBaseAddRow()
{
     
    if(mandatory_Check("frmIncentiveOperationsDtl"))
    {
        document.all.buttonFlag.value='';
        frmIncentiveOperationsDtl.screenMode.value = "U";  
        document.forms[0].action = "../../../IncentiveOperationsDtlAddRowAction.do";
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
           frmIncentiveOperationsDtl.detailDataChanged.value = "true";      
        }
    }    
   // enable(); 
    document.forms[0].action = "../../../IncentiveOperationsDtlDeleteRowAction.do";
    document.forms[0].submit();  
}

function doBasePrevDetail()
{
    frmIncentiveOperationsDtl.userPageRequested.value = 1*frmIncentiveOperationsDtl.pageRequested.value - 1;
    frmIncentiveOperationsDtl.action = "../../../IncentiveOperationsDtlPrevAction.do";
    frmIncentiveOperationsDtl.submit();
}


function doBaseNextDetail()
{
    frmIncentiveOperationsDtl.userPageRequested.value = 1*frmIncentiveOperationsDtl.pageRequested.value + 1;
    frmIncentiveOperationsDtl.action = "../../../IncentiveOperationsDtlNextAction.do";
    frmIncentiveOperationsDtl.submit();
}

function JumpDetail()
{
    frmIncentiveOperationsDtl.userPageRequested.value = 1*frmIncentiveOperationsDtl.newPageRequested.value ;
    frmIncentiveOperationsDtl.action = "../../../IncentiveOperationsDtlJumpAction.do";
    frmIncentiveOperationsDtl.submit();
}

function ShowOperationType()
{
   frmIncentiveOperationsDtl.lovKey.value = "OperationIDLOV" + frmIncentiveOperationsDtl.screenName.value + frmIncentiveOperationsDtl.screenMode.value;
   frmIncentiveOperationsDtl.txtDisplayFields.value = "txtOperationID,txtOperationDesc";
   frmIncentiveOperationsDtl.txtIndex.value ="";      
   frmIncentiveOperationsDtl.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmIncentiveOperationsDtl');
   return true;
}

function doInsertMode()
{
    frmIncentiveOperationsDtl.action="../../../IncentiveOperationsDtlNewmode.do"
    frmIncentiveOperationsDtl.submit();
}


function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmIncentiveOperationsDtl.action="../../../IncentiveOperationsDtlGetHeaderAction.do"
    frmIncentiveOperationsDtl.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmIncentiveOperationsDtl.userPositionRequested.value = 1*frmIncentiveOperationsDtl.positionRequested.value + 1;
    frmIncentiveOperationsDtl.action="../../../IncentiveOperationsDtlGetNextHeader.do";
    frmIncentiveOperationsDtl.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmIncentiveOperationsDtl.userPositionRequested.value = 1*frmIncentiveOperationsDtl.positionRequested.value - 1;
    frmIncentiveOperationsDtl.action = "../../../IncentiveOperationsDtlGetNextHeader.do";
    frmIncentiveOperationsDtl.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmIncentiveOperationsDtl.userPositionRequested.value = 1*frmIncentiveOperationsDtl.newPositionRequested.value;
    frmIncentiveOperationsDtl.action = "../../../IncentiveOperationsDtlGetNextHeader.do";
    frmIncentiveOperationsDtl.submit();
}

function AmtCheck()
{
      //    alert("INSIDE AMT CHECK");
            var oTable = document.getElementById("Detail");
            var iTR = oTable.rows.length;
            var flag =0;

            for(i=0;i<iTR-1;i++)
            {   
                var m = parseInt(document.getElementsByName("txtDatumFrom")[i].value);
                var n= parseInt(document.getElementsByName("txtDatumTo")[i].value);               
                if((document.getElementsByName("status")[i].value) != "D")
                {
                  if (m >= n)
                  {
                     alert("Datum To should be greater than Datum From");
                     document.getElementsByName("txtDatumTo")[i].focus(); 
                     document.getElementsByName("txtDatumTo")[i].value ="";
                     return false;
                  }     
                }                                             
            }             
 
        return true;
}

</script>