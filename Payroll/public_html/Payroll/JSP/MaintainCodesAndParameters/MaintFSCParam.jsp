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
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>

<html:form  action="MaintFSCParamBase" name="frmMaintFSCParam" type="FCIPAY.Payroll.WEBTIER.Form.MaintFSCParamForm" scope="session">
<bean:define id="ParentForm" name="frmMaintFSCParam" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<html:errors/>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN FOREIGN SERVICE CONTRIBUTION PARAMETERS</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
   <TR>
    <TD >
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=5 >

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText>Rates of Contribution Payable During Foreign Service<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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

                                        <TR >
                                              <TD align=center class=tableTOP  width =4% bgcolor=#AAccdd></TD>                                             
                                              <TD align=center class=tableTOP width =24% colspan = 2 bgcolor=#AAccdd></TD>
                                              <TD bgcolor=#AAFFDD class=tableTOP  COLSPAN = 2 align=center width = 18%>Group 'A' Employees</TD>
                                              <TD bgcolor=#AAFFFF class=tableTOP COLSPAN = 2 align=center width = 18%>Group 'B' Employees</TD>
                                              <TD bgcolor=#AAFFDD class=tableTOP COLSPAN = 2 align=center width = 18%>Group 'C' Employees</TD>
                                              <TD bgcolor=#AAFFFF class=tableTOP COLSPAN = 2 align=center width = 18%>Group 'D' Employees</TD>
                                              <TD align=center class=tableTOP  width = 2%></TD>                                             
                                        </TR>

                            <TR>
                            <td align=center class=tableHeader width="4%"><html:checkbox property="selectAll" onclick="toggleFscCheckBox('selectAll');checkFSCRecord();"  /></td>
                            <TD align=center width = 12% class=tableHeader>From Year</TD>
                            <TD align=center width = 12% class=tableHeader>To Year</TD>
                            <TD align=center width = 9% class=tableHeader>Pension Contribution (%)</TD>
                            <TD align=center width = 9% class=tableHeader>Leave Contribution (%)</TD>
                            <TD align=center width = 9% class=tableHeader>Pension Contribution (%)</TD>
                            <TD align=center width = 9% class=tableHeader>Leave Contribution (%)</TD>
                            <TD align=center width = 9% class=tableHeader>Pension Contribution (%)</TD>
                            <TD align=center width = 9% class=tableHeader>Leave Contribution (%)</TD>
                            <TD align=center width = 9% class=tableHeader>Pension Contribution (%)</TD>
                            <TD align=center width = 9% class=tableHeader>Leave Contribution (%)</TD>
                            <TD align=center width = 9% class=tableHeader></TD>                            
                           </TR>    

                           <logic:iterate id="fscInfo" name="frmMaintFSCParam" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintFSCParamBean" >
                              <% ++i; %>
                                <logic:notEqual name="fscInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                       <td align=center ><html:checkbox property="checked" name="frmMaintFSCParam" onclick="checkFSCRecord();" /></td>
                                       <td ><html:text property="startField" name="fscInfo" size="9"    styleClass="required" style="width:100%" maxlength="2" alt="<%=String.valueOf(i)%>"  onchange="lfnChange(this.value,this.alt);" /></td>         
                                       
                                       <td ><html:text property="endField" name="fscInfo" size="9"  styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" maxlength="2" onchange="lfnChangeYR(this.value,this.alt);  changeDtlStartFieldFSC('startField','endField',this.alt,'0');" /></td>         
                                       <td ><html:text property="txtRateOfPenConForGrpA" name="fscInfo" size="9"    styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>         
                                       <td ><html:text property="txtRateOfLeaveConForGrpA" name="fscInfo" size="9"   styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>         
                                       <td ><html:text property="txtRateOfPenConForGrpB" name="fscInfo" size="9"   styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>         
                                       <td ><html:text property="txtRateOfLeaveConForGrpB" name="fscInfo" size="9"    styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>         
                                       <td ><html:text property="txtRateOfPenConForGrpC" name="fscInfo" size="9"    styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>         
                                       <td ><html:text property="txtRateOfLeaveConForGrpC" name="fscInfo" size="9"    styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>         
                                       <td ><html:text property="txtRateOfPenConForGrpD" name="fscInfo" size="9"   styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>         
                                       <td ><html:text property="txtRateOfLeaveConForGrpD" name="fscInfo" size="9"    styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>         
                                       <html:hidden property="txtSrlNo" name="fscInfo" />
                                       <html:hidden property="itemChecked" name="fscInfo" />
                                       <html:hidden property="status" name="fscInfo" />
                                       <html:hidden property="detailId" name="fscInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>
                                  <logic:equal name="fscInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintFSCParam" value="notchecked" /></td>
                                       <td ><html:hidden property="startField" name="fscInfo" value = "Default" /></td>
                                       <td ><html:hidden property="endField" name="fscInfo" /></td>
                                       <td ><html:hidden property="txtRateOfPenConForGrpA" name="fscInfo" /></td>
                                       <td ><html:hidden property="txtRateOfLeaveConForGrpA" name="fscInfo" /></td>
                                       <td ><html:hidden property="txtRateOfPenConForGrpB" name="fscInfo" /></td>
                                       <td ><html:hidden property="txtRateOfLeaveConForGrpB" name="fscInfo" /></td>
                                       <td ><html:hidden property="txtRateOfPenConForGrpC" name="fscInfo" /></td>
                                       <td ><html:hidden property="txtRateOfLeaveConForGrpC" name="fscInfo" /></td>
                                       <td ><html:hidden property="txtRateOfPenConForGrpD" name="fscInfo" /></td>
                                       <td ><html:hidden property="txtRateOfLeaveConForGrpD" name="fscInfo" /></td>
                                       <html:hidden property="txtSrlNo" name="fscInfo" />
                                       <html:hidden property="itemChecked" name="fscInfo" />
                                       <html:hidden property="status" name="fscInfo" />
                                       <html:hidden property="detailId" name="fscInfo" value="Default"/>
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
                                    <TD><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" /></td>		     
                                 
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
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->
<html:hidden property="headerPrimaryKey" name="frmMaintFSCParam" value="Default" />
<html:hidden property="screenMode" name="frmMaintFSCParam" />
<html:hidden name="frmMaintFSCParam"  property="screenName" value="FSCParamScreen" />
<html:hidden name="frmMaintFSCParam"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintFSCParam"  />
<html:hidden property="pageRequested" name="frmMaintFSCParam" />
<html:hidden property="userPageRequested" name="frmMaintFSCParam" />
<html:hidden property="userPositionRequested" name="frmMaintFSCParam" />
<html:hidden property="buttonFlag" name="frmMaintFSCParam"  />
</html:form>
</body>
</html:html>

 

<script language="javascript">


  
 function lfnChange(val,ind)
{
    if(num_Check(val,1))
    {
      
      frmMaintFSCParam.detailDataChanged.value = "true";
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
      frmMaintFSCParam.detailDataChanged.value = "true";
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
function lfnChangeYR(val,ind)
{
    if(num_Check(val,1))
    {
      maxCheck(ind);
      frmMaintFSCParam.detailDataChanged.value = "true";
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
      alert("To Year  Should be greater than From Year")
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;                        
    }
    return true;
}

    

function doBaseAddRow()
{
  if(mandatory_Check("frmMaintFSCParam"))
  {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
     var iTr2 = oTable.rows.length;
    
    document.forms[0].action = "../../../FscParamAddRowAction.do";
    document.forms[0].submit();
  }
  else
  {
      return false;
  }
}



function doBaseDelRow()
{
    
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
 
  for(i=0; i < iTr2 -2; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintFSCParam.detailDataChanged.value = "true";      
    }

  }
   
  document.forms[0].action = "../../../FscParamDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintFSCParam"))
  { 
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;


  
  for(i=0; i < iTr2 -2; i++)
  {
      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintFSCParam.detailDataChanged.value = "true";
  }

	frmMaintFSCParam.headerFields.value = "false";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmMaintFSCParam.action = "../../../FscParamSaveAction.do";
	frmMaintFSCParam.totalDetailRecord.value=parseInt(iTr2)-2;
	frmMaintFSCParam.submit();
}
 else
  {
    return false;
  }
}


function GetDetail()
{
  document.all.screenMode.value='U';
  frmMaintFSCParam.action="../../../FscParamGetDetailAction.do"
  frmMaintFSCParam.submit();
}


function lfnLoad()
{
  mode = document.all.screenMode.value;
  if(mode=='')
  {
   doQueryMode();
   }
  

  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }
  if(mode=='U')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";

  
  }
  if(mode=='Q')
     {
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
     } 

 detMenuHandling(mode);
}
function doBasePrevDetail()
{
    frmMaintFSCParam.userPageRequested.value = 1*frmMaintFSCParam.pageRequested.value - 1;
    frmMaintFSCParam.action = "../../../FSCPrevDetailAction.do";
    frmMaintFSCParam.submit();
}


function doBaseNextDetail()
{
    frmMaintFSCParam.userPageRequested.value = 1*frmMaintFSCParam.pageRequested.value + 1;
    frmMaintFSCParam.action = "../../../FSCNextDetailAction.do";
    frmMaintFSCParam.submit();
}

function JumpDetail()
{
    frmMaintFSCParam.userPageRequested.value = 1*frmMaintFSCParam.newPageRequested.value ;
    frmMaintFSCParam.action = "../../../FSCNextDetailAction.do";
    frmMaintFSCParam.submit();
}



function doQueryMode()
{
     frmMaintFSCParam.action="../../../FSCParamQueryMode.do"
     frmMaintFSCParam.submit();
}

function doRefresh()
{
  frmMaintFSCParam.action="../../../FSCParamRefresh.do"
  frmMaintFSCParam.submit();
}


function toggleFscCheckBox(param)
{  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  for(i = 1; i < oTable.rows.length - 1; i ++)
  {
    if(document.getElementsByName(param)[0].checked == true)
    {
      document.getElementsByName("checked")[i-1].checked="true";
    }
    else
    {
      document.getElementsByName("checked")[i-1].checked="";
    }
  }
}

function checkFSCRecord()
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    var fl = 0;
    for(i=0; i < iTr2 - 2; i++)
    {
      if(document.getElementsByName("checked")[i].checked)
      {
          document.all.butDelete.disabled="";
          return true;
      }
    }
    if(fl == 0)   
    {      
        document.all.butDelete.disabled="true";
        return false;
    }
}

function changeDtlStartFieldFSC(startFieldName, endFieldName, index, y)
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  if(oTable.rows.length <= index)
  {
    return;
  }
  for(i=index; i < oTable.rows.length-2; i ++)
  {  
    if(document.getElementsByName("status")[i].value != 'D')
    {
      if(y == '0')
      {
        document.getElementsByName(startFieldName)[i].value = parseInt(document.getElementsByName(endFieldName)[index-1].value, 10) + 1; 
      }
      else
      {        
        val = parseInt(document.getElementsByName(endFieldName)[index-1].value, 10) + 1;
        
        if(val % 100 > 12 ) 
        {
          if(val % 100 > 13)
          {
            alert("Please enter the year month in proper format");event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;
            return false;
          }
          val = (parseInt(val / 100, 10) + 1) * 100 + 1;
        } 
        document.getElementsByName(startFieldName)[i].value = val; 
      }
       if( document.getElementsByName("status")[i].value != 'N')       
        document.getElementsByName("status")[i].value = 'U'; 
      return;
    }
  }
}
  
</script>
