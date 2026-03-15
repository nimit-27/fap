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
  <html:form  action="MaintDpsLbrSORDetailBase" name="frmDpsLbrSORForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.DpsLabourSORInfoForm">
  <bean:define id="ParentForm" name="frmDpsLbrSORForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>  
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>  
  <% i = 0;j=0; %>       

  <table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>DPS LABOUR SOR INFORMATION</TD>
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
         
            <td  width="15%" class=labelText><bean:message key="Payroll.Labour.region" /></td>
            <td ><html:text  property="txtRegName" styleClass = "locked" altKey="Payroll.Labour.region" readonly="true" maxlength="100" size="23" onchange=""/>
            </td>
               
            
            <td class=labelText width=15%><bean:message key="Payroll.Labour.effDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmDpsLbrSORForm" value="Q">
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required" />
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmDpsLbrSORForm" value="Q">                              
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required"/>
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:notEqual>            
            
            <td class=labelText width=15%><bean:message key="Payroll.Labour.effEndDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmDpsLbrSORForm" value="Q">
            <html:text  property="txtEndDate" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effEndDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" />            
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmDpsLbrSORForm" value="Q">                              
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
                    <td bgcolor="#4682B4" nowrap class=actTabText > DPS Labour SOR Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                    <td class=tableHeader width="20%">Orig Rate(Bag upto 65kg)</td>
                                    <td class=tableHeader width="20%">Orig Rate(Bag Above 65kg)</td>
                                </tr> 
                             <logic:iterate id="DpsLbrSORInfo" name="frmDpsLbrSORForm" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.DpsLabourSORDtlBean" indexId="idx" >
                              <% ++i; %>
                               <logic:notEqual name="DpsLbrSORInfo" property="status" value="D" > 
                                    <logic:equal name="DpsLbrSORInfo" property="status" value="N" >
                                   <tr>
                                        <td align = "center"><html:checkbox property="checked" onclick="checkRecord();" name="frmDpsLbrSORForm" /></td>                                        
                                     <!--   <td colspan="1"><html:select property="txtOperation" name="DpsLbrSORInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                        <html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>      
                                        <logic:present name="DpsLabourSORList">
                                        <html:optionsCollection label="label" value="value" property="valueServiceList" name="DpsLabourSORList"/>
                                        </logic:present>
                                        </html:select></td>      
                                    -->
                                     <td colspan="1"><html:text property="txtOperation" name="DpsLbrSORInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  />
                                        </td>
                                        
                                        <td ><html:text property="txtBagRateBlw65" maxlength="9" name="DpsLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          return changed(this.alt);" />
                                        </td>
                                        
                                        <td ><html:text property="txtBagRateAbv65" maxlength="9" name="DpsLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         return changed(this.alt);" />
                                        </td>                                                                                                                      
                                   </tr>
                                  </logic:equal>
                                  <logic:notEqual name="DpsLbrSORInfo" property="status" value="N" >
                                   <tr>
                                        <td align = "center"><html:checkbox property="checked" onclick="checkRecord()" name="frmDpsLbrSORForm" /></td>                                        
                                     <!--   <td colspan="1"><html:select property="txtOperation" name="DpsLbrSORInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                        <html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>      
                                        <logic:present name="DpsLabourSORList">
                                        <html:optionsCollection label="label" value="value" property="valueServiceList" name="DpsLabourSORList"/>
                                        </logic:present>
                                        </html:select></td>      
                                    -->
                                        <td colspan="1"><html:text property="txtOperation" name="DpsLbrSORInfo" readonly="false" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)" style="WIDTH: 100%" />
                                        </td>
                                        
                                        <td ><html:text property="txtBagRateBlw65" maxlength="9" name="DpsLbrSORInfo" readonly="false" styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt); " />
                                        </td>
                                        
                                        <td ><html:text property="txtBagRateAbv65" maxlength="9" name="DpsLbrSORInfo" readonly="false" styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt); " />
                                        </td>                                                                                                                      
                                       
                                </tr>
                                  </logic:notEqual>
                                       <html:hidden property="itemChecked" name="DpsLbrSORInfo"  />
                                       <html:hidden property="status" name="DpsLbrSORInfo" />
                                       <html:hidden property="detailId" name="DpsLbrSORInfo" />                                   
                              </logic:notEqual>                               
                                 
                                <logic:equal name="DpsLbrSORInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmDpsLbrSORForm" value="notchecked" /></td>
                                       <td ><html:hidden property="txtOperation" name="DpsLbrSORInfo" /></td>
                                       <td ><html:hidden property="txtBagRateAbv65" name="DpsLbrSORInfo" /></td>
                                       <td ><html:hidden property="txtBagRateBlw65" name="DpsLbrSORInfo" /></td>                                                                        
                                                                       
                                       <html:hidden property="itemChecked" name="DpsLbrSORInfo" />
                                       <html:hidden property="status" name="DpsLbrSORInfo" />
                                       <html:hidden property="detailId" name="DpsLbrSORInfo" />
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
<html:hidden name="frmDpsLbrSORForm"  property="screenName" value="MaintDpsLbrSORDtlScreen" />
<html:hidden name="frmDpsLbrSORForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDpsLbrSORForm" />
<html:hidden property="positionRequested" name="frmDpsLbrSORForm" />
<html:hidden property="userPositionRequested" name="frmDpsLbrSORForm"/>
<html:hidden property="pageRequested" name="frmDpsLbrSORForm" />
<html:hidden property="userPageRequested" name="frmDpsLbrSORForm"/>
<html:hidden property="totalDetailRecord" name="frmDpsLbrSORForm"  />
<html:hidden property="screenModeSOR" name="frmDpsLbrSORForm"  />
<html:hidden property="screenModeSOR1" name="frmDpsLbrSORForm"  />
<html:hidden property="screenModeSOR2" name="frmDpsLbrSORForm"  />

<html:hidden property="buttonFlag" name="frmDpsLbrSORForm"  />
<html:hidden property="lovKey" name="frmDpsLbrSORForm"  />
<html:hidden property="txtFields" name="frmDpsLbrSORForm"  />   
<html:hidden property="txtSearchFields" name="frmDpsLbrSORForm"  />
<html:hidden property="txtDisplayFields" name="frmDpsLbrSORForm" />
<html:hidden property="txtIndex" name="frmDpsLbrSORForm"  />
<html:hidden property="loginLocCode" name="frmDpsLbrSORForm" />
<html:hidden property="txtRegCode" name="frmDpsLbrSORForm" />
<html:hidden property="effStartDate" name="frmDpsLbrSORForm" />                                         

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
    if (frmDpsLbrSORForm.screenMode.value == "Q")
    {
        frmDpsLbrSORForm.screenModeSOR.value="Q";
        document.all.butGetDetail.disabled="disabled";  
        document.all.butInsert.disabled="true";
    }
        
    mode = frmDpsLbrSORForm.screenModeSOR.value;        
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
        frmDpsLbrSORForm.screenModeSOR2.value="U";
    }
     if (frmDpsLbrSORForm.screenMode.value == 'U')
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
    if(!mandatory_Check("frmDpsLbrSORForm"))
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
            frmDpsLbrSORForm.detailDataChanged.value = "true";
    }
    
    
    frmDpsLbrSORForm.screenModeSOR1.value = frmDpsLbrSORForm.screenModeSOR2.value;
    if (document.all.screenMode.value == "N")
    {
        document.all.screenModeSOR.value = "UG";
        document.all.screenMode.value = "U";    
    }  
    document.all.buttonFlag.value='';    
    frmDpsLbrSORForm.effStartDate.value = frmDpsLbrSORForm.headerPrimaryKey.value;
    frmDpsLbrSORForm.headerFields.value = "true";       
    frmDpsLbrSORForm.totalDetailRecord.value = parseInt(iTr2,10) - 1;    
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmDpsLbrSORForm.action = "../../../DpsLbrSORSaveAction.do";  
    frmDpsLbrSORForm.submit();
    
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmDpsLbrSORForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmDpsLbrSORForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmDpsLbrSORForm.action="../../../DpsLbrSORGetHeaderAction.do"
    frmDpsLbrSORForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmDpsLbrSORForm.screenModeSOR.value="Q";
    frmDpsLbrSORForm.userPositionRequested.value = 1*frmDpsLbrSORForm.positionRequested.value + 1;    
    frmDpsLbrSORForm.action="../../../DpsLbrSORGetNextHeader.do";
    frmDpsLbrSORForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmDpsLbrSORForm.screenModeSOR.value="Q";
    frmDpsLbrSORForm.userPositionRequested.value = 1*frmDpsLbrSORForm.positionRequested.value - 1;
    frmDpsLbrSORForm.action = "../../../DpsLbrSORGetPrevHeader.do";
    frmDpsLbrSORForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmDpsLbrSORForm.screenModeSOR.value="Q";
    frmDpsLbrSORForm.userPositionRequested.value = 1*frmDpsLbrSORForm.newPositionRequested.value;
    frmDpsLbrSORForm.action = "../../../DpsLbrSORGetNextHeader.do";
    frmDpsLbrSORForm.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmDpsLbrSORForm.userPageRequested.value = 1*frmDpsLbrSORForm.newPageRequested.value ;
    frmDpsLbrSORForm.action = "../../../DpsLbrSORNextDetailAction.do";
    frmDpsLbrSORForm.submit();
}

function doInsertMode()
{    
    document.all.screenMode.value = "N";
    document.all.screenModeSOR.value = "N";    
    document.all.screenModeSOR1.value = "N";
    document.all.screenModeSOR2.value = "N";
    document.all.buttonFlag.value='';
    
    frmDpsLbrSORForm.action="../../../DpsLbrSORNewMode.do"
    frmDpsLbrSORForm.submit();
}

function doQueryMode()
{   
    frmDpsLbrSORForm.headerPrimaryKey.value="";
    document.all.buttonFlag.value='';
    document.all.screenModeSOR.value = "Q";
    document.all.screenMode.value = "Q";    
    frmDpsLbrSORForm.action="../../../DpsLbrSORQueryMode.do"
    frmDpsLbrSORForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmDpsLbrSORForm.action="../../../DpsLbrSORRefresh.do"
    frmDpsLbrSORForm.submit();
}

function GetDetail()
{
    document.all.buttonFlag.value='';      
    document.all.screenModeSOR.value='UG';
    frmDpsLbrSORForm.action="../../../DpsLbrSORGetDetailAction.do"
    frmDpsLbrSORForm.submit();
}

  function doBaseAddRow()
{
    document.all.buttonFlag.value='D';      
    if(mandatory_Check("frmDpsLbrSORForm"))
    { 
        if (frmDpsLbrSORForm.screenModeSOR.value=="UG")
            frmDpsLbrSORForm.screenModeSOR2.value=="U";
        frmDpsLbrSORForm.screenModeSOR.value="N1";
        document.getElementById("headerPrimaryKey").disabled="";
        document.forms[0].action = "../../../DpsLbrSORAddRowAction.do";
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
      //frmDpsLbrSORForm.detailDataChanged.value = "true";
    }
  }
  document.forms[0].action = "../../../DpsLbrSORDeleteRowAction.do";
  document.forms[0].submit();  
}

function changed(val)
{ 
    frmDpsLbrSORForm.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
        document.getElementsByName("status")[val-1].value = 'U';
} 

</script>

