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
  <BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintNWNPLbrOperationBase" name="frmNWNPLbrOprtnForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.NWNPLabourOperationForm">
  <bean:define id="ParentForm" name="frmNWNPLbrOprtnForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>  
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>  
  <% i = 0;j=0; %>       

  <table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>NWNP LABOUR OPERATION INFO</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
   <TR>
    <TD>
    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
         <tr>
            <td class=labelText width=15%><bean:message key="Payroll.Labour.effDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrOprtnForm" value="Q">
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required" />
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrOprtnForm" value="Q">                              
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required"/>
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:notEqual>            
            
            <td class=labelText width=15%><bean:message key="Payroll.Labour.effEndDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrOprtnForm" value="Q">
            <html:text  property="txtEndDate" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effEndDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" />            
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrOprtnForm" value="Q">                              
            <html:text  property="txtEndDate" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effEndDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked"/>      
            </logic:notEqual>
                                           
        </tr>
        <tr height=5>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >               
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > NWNP Labour Operation Detail <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                <TBODY>
                                <TR height="22">
                                    <td class=tableHeader width="3%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                    <td class=tableHeader width="40%">Kind of Service/Operation</td>
                                    <!--
                                    <td class=tableHeader width="20%">Orig Rate(Bag upto 65kg)</td>
                                    <td class=tableHeader width="20%">Orig Rate(Bag Above 65kg)</td>
                                    -->
                                </tr> 
                             <logic:iterate id="NWNPLbrOprtnInfo" name="frmNWNPLbrOprtnForm" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.NWNPLabourOprtnDtlBean" indexId="idx" >
                              <% ++i; %>
                               <logic:notEqual name="NWNPLbrOprtnInfo" property="status" value="D" > 
                                    <logic:equal name="NWNPLbrOprtnInfo" property="status" value="N" >
                                   <tr>
                                        <td align = "center"><html:checkbox property="checked" onclick="checkRecord();" name="frmNWNPLbrOprtnForm" /></td>                                        
                                     
                                     <td colspan="1"><html:text property="txtOperation" name="NWNPLbrOprtnInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  />
                                        </td>
                                       
                                   </tr>
                                  </logic:equal>
                                  <logic:notEqual name="NWNPLbrOprtnInfo" property="status" value="N" >
                                   <tr>
                                        <td align = "center"><html:checkbox property="checked" onclick="checkRecord()" name="frmNWNPLbrOprtnForm" /></td>                                        
                                     
                                        <td colspan="1"><html:text property="txtOperation" name="NWNPLbrOprtnInfo" readonly="false" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)" style="WIDTH: 100%" />
                                        </td>
                                        
                                </tr>
                                  </logic:notEqual>
                                       <html:hidden property="itemChecked" name="NWNPLbrOprtnInfo"  />
                                       <html:hidden property="status" name="NWNPLbrOprtnInfo" />
                                       <html:hidden property="detailId" name="NWNPLbrOprtnInfo" />                                   
                              </logic:notEqual>                               
                                 
                                <logic:equal name="NWNPLbrOprtnInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmNWNPLbrOprtnForm" value="notchecked" /></td>
                                       <td ><html:hidden property="txtOperation" name="NWNPLbrOprtnInfo" /></td>
                                       <html:hidden property="itemChecked" name="NWNPLbrOprtnInfo" />
                                       <html:hidden property="status" name="NWNPLbrOprtnInfo" />
                                       <html:hidden property="detailId" name="NWNPLbrOprtnInfo" />
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
                                  <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
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
          <!-- Tab Table Ends -->

          <!-- Bottom Blue Bar -->
          <TR>
            <td colspan=11>
              <jsp:include  page = "../INCLUDES/BottomBlueBar.jsp" flush="true" />
            </td>
          </TR>
        </TABLE> 
<!-- Container Table Ending Columns Starts-->
    </TD>    
</TR>
</TBODY>
</TABLE>
</div>
<!-- Container Table Ends -->
<html:hidden name="frmNWNPLbrOprtnForm"  property="screenName" value="MaintNWNPLbrOprtnScreen" />
<html:hidden name="frmNWNPLbrOprtnForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmNWNPLbrOprtnForm" />
<html:hidden property="positionRequested" name="frmNWNPLbrOprtnForm" />
<html:hidden property="userPositionRequested" name="frmNWNPLbrOprtnForm"/>
<html:hidden property="pageRequested" name="frmNWNPLbrOprtnForm" />
<html:hidden property="userPageRequested" name="frmNWNPLbrOprtnForm"/>
<html:hidden property="totalDetailRecord" name="frmNWNPLbrOprtnForm"  />
<html:hidden property="screenModeSOR" name="frmNWNPLbrOprtnForm"  />
<html:hidden property="screenModeSOR1" name="frmNWNPLbrOprtnForm"  />
<html:hidden property="screenModeSOR2" name="frmNWNPLbrOprtnForm"  />

<html:hidden property="buttonFlag" name="frmNWNPLbrOprtnForm"  />
<html:hidden property="lovKey" name="frmNWNPLbrOprtnForm"  />
<html:hidden property="txtFields" name="frmNWNPLbrOprtnForm"  />   
<html:hidden property="txtSearchFields" name="frmNWNPLbrOprtnForm"  />
<html:hidden property="txtDisplayFields" name="frmNWNPLbrOprtnForm" />
<html:hidden property="txtIndex" name="frmNWNPLbrOprtnForm"  />
<html:hidden property="loginLocCode" name="frmNWNPLbrOprtnForm" />
<html:hidden property="effStartDate" name="frmNWNPLbrOprtnForm" />                                         

<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>


<script language="javascript">

function lfnLoad()
{   
    mode = document.all.screenMode.value;         
    if(mode == '')
    {
        doQueryMode();
    }
    if (frmNWNPLbrOprtnForm.screenMode.value == "Q")
    {
        frmNWNPLbrOprtnForm.screenModeSOR.value="Q";
        document.all.butGetDetail.disabled="disabled";  
        document.all.butInsert.disabled="true";
    }
        
    mode = frmNWNPLbrOprtnForm.screenModeSOR.value;        
  //  alert("screenModeSOR-----"+mode);
    if(mode=='')
   {
     document.all.butGetDetail.disabled="disabled";   
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
   }
    if(mode=='Q' && document.all.screenMode.value=='U')
    {
       document.all.butGetDetail.disabled="";
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
        document.all.butDelete.disabled="true";
    }
    if(mode=='N1')
    {
        document.all.butGetDetail.disabled="true";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="true";
    }
  
    if(mode=='UG')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="true";
        frmNWNPLbrOprtnForm.screenModeSOR2.value="U";
    }
     if (frmNWNPLbrOprtnForm.screenMode.value == 'U')
     { 
          document.getElementById("headerPrimaryKey").disabled = "true";
          var oTable = document.getElementById("Detail");
          if(oTable == null)
          {
              return;
          }
          var iTr2 = oTable.rows.length;
          var i = 0;
          
          for(i=0; i < iTr2 -1; i++)
          {
              if (document.getElementsByName("status")[i].value == 'Q')
              {              
              }
          }        
      }
      else
      {  
         document.getElementById("headerPrimaryKey").disabled="";       
      }  
  mode1 = document.all.screenMode.value;  
  menuHandling(mode1);      
    
}

function checkDuplicacy(that,rInd)
{
    lengthOfTable = document.getElementById("Detail").rows.length;
    newComb = document.getElementsByName("txtOperation")[rInd-1].value;
    
    for(ind = lengthOfTable - 1; ind > 0; ind --)
    {
        if(ind != rInd)
        {
            oldComb = document.getElementsByName("txtOperation")[ind-1].value;
            
            if(oldComb == newComb)
            {
                alert("You can\'t enter duplicate value");
                document.getElementsByName("txtOperation")[rInd-1].focus();                
                return;
            }
        }
    }
}

function SaveRecord()
{    
    if(!mandatory_Check("frmNWNPLbrOprtnForm"))
        return false;  
  //if(!AmtCheck())
      //return false;  
  
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
            frmNWNPLbrOprtnForm.detailDataChanged.value = "true";
    }
    
    
    frmNWNPLbrOprtnForm.screenModeSOR1.value = frmNWNPLbrOprtnForm.screenModeSOR2.value;
    if (document.all.screenMode.value == "N")
    {
        document.all.screenModeSOR.value = "UG";
        document.all.screenMode.value = "U";    
    }  
    document.all.buttonFlag.value='';    
    frmNWNPLbrOprtnForm.effStartDate.value = frmNWNPLbrOprtnForm.headerPrimaryKey.value;
    frmNWNPLbrOprtnForm.headerFields.value = "true";       
    frmNWNPLbrOprtnForm.totalDetailRecord.value = parseInt(iTr2,10) - 1;    
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmNWNPLbrOprtnForm.action = "../../../NWNPLbrOprtnSaveAction.do";  
    frmNWNPLbrOprtnForm.submit();
    
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmNWNPLbrOprtnForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmNWNPLbrOprtnForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmNWNPLbrOprtnForm.action="../../../NWNPLbrOprtnGetHeaderAction.do"
    frmNWNPLbrOprtnForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmNWNPLbrOprtnForm.screenModeSOR.value="Q";
    frmNWNPLbrOprtnForm.userPositionRequested.value = 1*frmNWNPLbrOprtnForm.positionRequested.value + 1;    
    frmNWNPLbrOprtnForm.action="../../../NWNPLbrOprtnGetNextHeader.do";
    frmNWNPLbrOprtnForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmNWNPLbrOprtnForm.screenModeSOR.value="Q";
    frmNWNPLbrOprtnForm.userPositionRequested.value = 1*frmNWNPLbrOprtnForm.positionRequested.value - 1;
    frmNWNPLbrOprtnForm.action = "../../../NWNPLbrOprtnGetPrevHeader.do";
    frmNWNPLbrOprtnForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmNWNPLbrOprtnForm.screenModeSOR.value="Q";
    frmNWNPLbrOprtnForm.userPositionRequested.value = 1*frmNWNPLbrOprtnForm.newPositionRequested.value;
    frmNWNPLbrOprtnForm.action = "../../../NWNPLbrOprtnGetNextHeader.do";
    frmNWNPLbrOprtnForm.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmNWNPLbrOprtnForm.userPageRequested.value = 1*frmNWNPLbrOprtnForm.newPageRequested.value ;
    frmNWNPLbrOprtnForm.action = "../../../NWNPLbrOprtnNextDetailAction.do";
    frmNWNPLbrOprtnForm.submit();
}

function doInsertMode()
{    
    document.all.screenMode.value = "N";
    document.all.screenModeSOR.value = "N";    
    document.all.screenModeSOR1.value = "N";
    document.all.screenModeSOR2.value = "N";
    document.all.buttonFlag.value='';
    
    frmNWNPLbrOprtnForm.action="../../../NWNPLbrOprtnNewMode.do"
    frmNWNPLbrOprtnForm.submit();
}

function doQueryMode()
{   
    frmNWNPLbrOprtnForm.headerPrimaryKey.value="";
    document.all.buttonFlag.value='';
    document.all.screenModeSOR.value = "Q";
    document.all.screenMode.value = "Q";    
    frmNWNPLbrOprtnForm.action="../../../NWNPLbrOprtnQueryMode.do"
    frmNWNPLbrOprtnForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmNWNPLbrOprtnForm.action="../../../NWNPLbrOprtnRefresh.do"
    frmNWNPLbrOprtnForm.submit();
}

function GetDetail()
{
    document.all.buttonFlag.value='';      
    document.all.screenModeSOR.value='UG';
    frmNWNPLbrOprtnForm.action="../../../NWNPLbrOprtnGetDetailAction.do"
    frmNWNPLbrOprtnForm.submit();
}

  function doBaseAddRow()
{
    document.all.buttonFlag.value='D';      
    if(mandatory_Check("frmNWNPLbrOprtnForm"))
    { 
        if (frmNWNPLbrOprtnForm.screenModeSOR.value=="UG")
            frmNWNPLbrOprtnForm.screenModeSOR2.value=="U";
        frmNWNPLbrOprtnForm.screenModeSOR.value="N1";
        document.getElementById("headerPrimaryKey").disabled="";
        document.forms[0].action = "../../../NWNPLbrOprtnAddRowAction.do";
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
  var strRecList='';
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
	  //alert(document.getElementsByName("itemChecked")[i].value)
      document.getElementsByName("itemChecked")[i].value = "Y";
    }
  }
  document.forms[0].action = "../../../NWNPLbrOprtnDeleteRowAction.do";
  document.forms[0].submit();  
}

function changed(val)
{ 
    frmNWNPLbrOprtnForm.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
        document.getElementsByName("status")[val-1].value = 'U';
} 

</script>

