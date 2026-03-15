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
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>


</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="MaintHandlingNormBase" name="frmMaintHandlingNorm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.MaintHandlingNormForm" scope="session">
<bean:define id="ParentForm" name="frmMaintHandlingNorm" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN HANDLING NORM </TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
   <TR>
    <TD> 

              <TABLE cellSpacing=0 cellPadding=0>
       <!--  Header Row Starts -->
                <TR>
                  <TD class=subHeader colspan=4>Header For Maintain Handling Norms</TD>
                </TR>
                <TR>
                  <TD colspan=4 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>

                <tr height="15" >
                  <td colspan="2"></td>
                </tr>
         
                <tr>
                 <td class="labelText"  width="25%" >Effective Date</td>
                  <td align="left">
                  <html:text  property="txtEffDate" altKey="Payroll.MaintTransport.date" readonly="true" maxlength="10" size="16" styleClass="required" />
                  <logic:equal property= "screenMode" name= "frmMaintHandlingNorm" value="N">            
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtEffDate',this)" />
                  </logic:equal>               
                  </td>        

                  <td class="labelText"  width="25%" >MOU</td>
                  <td>
                  <logic:equal property="screenMode" name= "frmMaintHandlingNorm" value="U"> 
                  <html:select property="txtMou" disabled="true" styleClass="required" >
                        <html:option value="" >-----------Please Select-----------</html:option>      
                        <logic:present name="HndlingNormCombo">
                          <html:optionsCollection label="label" value="value" property="mouList" name="HndlingNormCombo"/>
                        </logic:present>
                      </html:select>
                  </logic:equal>
                  <logic:notEqual property="screenMode" name= "frmMaintHandlingNorm" value="U"> 
                  <html:select property="txtMou" styleClass="required" >
                        <html:option value="" >-----------Please Select-----------</html:option>      
                        <logic:present name="HndlingNormCombo">
                          <html:optionsCollection label="label" value="value" property="mouList" name="HndlingNormCombo"/>
                        </logic:present>
                      </html:select>
                  </logic:notEqual>
                  </td>
                </tr>

                <tr height="10">		    
                  <TD colspan="2" > </TD>
                </tr>
              </table>

       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	       <TR height="200">
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText>Labour Handling Norm Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                      <td class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                      <td class=tableHeader width="31%"><bean:message key="Payroll.HandlingNorm.desc" /></td>
                                      <td class=tableHeader width="10%"><bean:message key="Payroll.HandlingNorm.unit" /></td>
                                      <td class=tableHeader width="10%"><bean:message key="Payroll.HandlingNorm.bel66kg" /></td>
                                      <td class=tableHeader width="10%"><bean:message key="Payroll.HandlingNorm.abv66kg" /></td>
                                      <td class=tableHeader width="10%"><bean:message key="Payroll.HandlingNorm.rate" /></td>
                                   </tr> 
                           <logic:iterate id="HandlingNormInfo" name="frmMaintHandlingNorm" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.MaintHandlingNormBean" >
                              <% ++i; %>
                                <logic:notEqual name="HandlingNormInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                       <td align=center ><html:checkbox property="checked" value="false" name="frmMaintHandlingNorm" onclick="checkRecord();" /></td>
                                       <td >
                                       <logic:equal name="HandlingNormInfo" property="status" value="N">
                                       <html:text property="txtNormDesc" name="HandlingNormInfo"  styleClass="required" size="9" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="checkDuplicacy('txtNormDesc',this.alt); return changed(this.alt);" />
                                       </logic:equal>
                                       <logic:notEqual name="HandlingNormInfo" property="status" value="N">
                                       <html:text property="txtNormDesc" name="HandlingNormInfo" readonly="true"  styleClass="required" size="9" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="checkDuplicacy('txtNormDesc',this.alt); return changed(this.alt);" />
                                       </logic:notEqual>
                                       </td>
                                       <td >
                                       <logic:equal name="HandlingNormInfo" property="status" value="N">
                                       <html:select property="txtNormUnit" name="HandlingNormInfo" styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="setFields(this.alt)" >
                                          <html:option value="" >-----------Please Select-----------</html:option>      
                                          <logic:present name="HndlingNormCombo">
                                            <html:optionsCollection label="label" value="value" property="normUnitList" name="HndlingNormCombo"/>
                                          </logic:present>
                                        </html:select>
                                        </logic:equal>
                                        <logic:notEqual name="HandlingNormInfo" property="status" value="N">
                                       <html:select property="txtNormUnit" name="HandlingNormInfo" disabled="true" styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="setFields(this.alt)" >
                                          <html:option value="" >-----------Please Select-----------</html:option>      
                                          <logic:present name="HndlingNormCombo">
                                            <html:optionsCollection label="label" value="value" property="normUnitList" name="HndlingNormCombo"/>
                                          </logic:present>
                                        </html:select>
                                        </logic:notEqual>
                                       </td>
                                       <td ><html:text property="txtNormBel66kg" name="HandlingNormInfo" size="15" disabled="true"  styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        } else
                                        {
                                          return changed(this.alt);
                                        } " /></td>
                                       <td ><html:text property="txtNormAbv66kg" name="HandlingNormInfo" size="15" disabled="true" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        } else
                                        {
                                          return changed(this.alt);
                                        } " /></td>
                                        <td ><html:text property="txtNormRate" name="HandlingNormInfo" size="15" disabled="true"  styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        } else
                                        {
                                          return changed(this.alt);
                                        } " /></td>
                                       <html:hidden property="txtNormId" name="HandlingNormInfo" />
                                       <html:hidden property="itemChecked" name="HandlingNormInfo" />
                                       <html:hidden property="status" name="HandlingNormInfo" />
                                       <html:hidden property="detailId" name="HandlingNormInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>
                                  <logic:equal name="HandlingNormInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintHandlingNorm" value="notchecked" /></td>
                                       <html:hidden property="txtNormId" name="HandlingNormInfo" />
                                       <td ><html:hidden property="txtNormUnit" name="HandlingNormInfo" /></td>
                                       <td ><html:hidden property="txtNormDesc" name="HandlingNormInfo" /></td>
                                       <td ><html:hidden property="txtNormBel66kg" name="HandlingNormInfo" /></td>
                                       <td ><html:hidden property="txtNormAbv66kg" name="HandlingNormInfo" /></td>
                                       <td ><html:hidden property="txtNormRate" name="HandlingNormInfo" /></td>
                                       <html:hidden property="itemChecked" name="HandlingNormInfo" />
                                       <html:hidden property="status" name="HandlingNormInfo" />
                                       <html:hidden property="detailId" name="HandlingNormInfo" value="Default"/>
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
<html:hidden property="headerPrimaryKey" name="frmMaintHandlingNorm" value="Default" />
<html:hidden property="screenMode" name="frmMaintHandlingNorm" />
<html:hidden name="frmMaintHandlingNorm"  property="screenName" value="HandlingNormMasterScreen" />
<html:hidden name="frmMaintHandlingNorm"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintHandlingNorm"  />
<html:hidden property="pageRequested" name="frmMaintHandlingNorm" />
<html:hidden property="userPageRequested" name="frmMaintHandlingNorm" />
<html:hidden property="positionRequested" name="frmMaintHandlingNorm" />
<html:hidden property="userPositionRequested" name="frmMaintHandlingNorm" />
<html:hidden property="buttonFlag" name="frmMaintHandlingNorm"  />

</html:form>
</body>
</html:html>                   


<script language="javascript">
    
function changed(val)
{
    frmMaintHandlingNorm.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
       document.getElementsByName("status")[val-1].value = 'U';
}
   
function doBaseAddRow()
{
    enable();
    document.forms[0].action = "../../../HandlingNormAddRowAction.do";
    document.forms[0].submit();
}

function doBaseDelRow()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  
  var strRecList='';
  var iTr2 = oTable.rows.length;
  var i = 0;
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("txtNormId")[i].value=='')
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        frmMaintHandlingNorm.detailDataChanged.value = "true";  
      }
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
    enable();
    document.forms[0].action = "../../../HandlingNormDeleteRowAction.do";
    document.forms[0].submit();  
}

function SaveRecord()
{
    if(!mandatory_Check('frmMaintHandlingNorm'))
    {
      return false;
    }
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    if(iTr2<=1)
    {
      alert("Please add at least one record.");
      return false;
    }
    
    for(i=0; i < iTr2 -1; i++)
    {
        document.getElementsByName("txtNormId")[i].disabled="";    
        if (document.getElementsByName("status")[i].value == 'D')
            frmMaintHandlingNorm.detailDataChanged.value = "true";
    }
    enable();
    frmMaintHandlingNorm.headerFields.value = "false";
    frmMaintHandlingNorm.screenMode.value = "U";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmMaintHandlingNorm.action = "../../../HandlingNormSaveAction.do";
    frmMaintHandlingNorm.totalDetailRecord.value=parseInt(iTr2)-1;
    frmMaintHandlingNorm.submit();
}

function GetDetail()
{  
    document.all.screenMode.value='U';
    frmMaintHandlingNorm.action="../../../HandlingNormGetDetailAction.do"
    frmMaintHandlingNorm.submit();
}

function Chk_Char(ind,name)
{
    that=document.getElementsByName(name)[ind-1];
    str=that.value;
    for(i=0; i<str.length; i++)
    {
        var city =str.charAt(i);
        if((city >= 'A' && city <= 'Z') ||(city >= 'a' && city <= 'z') || (city == ',') || (city == ' '))
        {}
        else
        {
            alert("Invalid Input");
            that.select();
            that.select();
            that.select();
            that.select();
            that.select();
            that.select();
            return true;
        }
    }
}

function checkDuplicacy(that,rInd)
{
    lengthOfTable = document.getElementById("Detail").rows.length;
    newComb = document.getElementsByName(that)[rInd-1].value;
    for(ind = lengthOfTable - 1; ind > 0; ind --)
    {
        if(rInd != ind)
        {
            oldComb = document.getElementsByName(that)[ind-1].value;
            if(trim(oldComb.toUpperCase())==trim(newComb.toUpperCase()))
            {
                alert("You can\'t enter duplicate value");
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;
                return false;
            }
        }
    }
    return true;
}


function lfnLoad()
{
    mode = document.all.screenMode.value;    
    if(mode=='')
    {
        doQueryMode();
    }
    
    if(mode=='Q')
    {
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";
    }
    
    if(mode=='N')
    {
        document.all.butGetDetail.disabled="true";
    }  
  
    if(mode=='U')
    {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";    
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
                document.getElementsByName("txtNormId")[i].disabled="disabled";
               // setFields(i+1);
            }
        }  
    }
    menuHandling(mode);
}


function upper(val)
{
     val.value=val.value.toUpperCase();
}
     
function doBasePrevDetail()
{
    frmMaintHandlingNorm.userPageRequested.value = 1*frmMaintHandlingNorm.pageRequested.value - 1;
    frmMaintHandlingNorm.action = "../../../HandlingNormPrevDetailAction.do";
    frmMaintHandlingNorm.submit();
}


function doBaseNextDetail()
{
    frmMaintHandlingNorm.userPageRequested.value = 1*frmMaintHandlingNorm.pageRequested.value + 1;
    frmMaintHandlingNorm.action = "../../../HandlingNormNextDetailAction.do";
    frmMaintHandlingNorm.submit();
}

function JumpDetail()
{
    frmMaintHandlingNorm.userPageRequested.value = 1*frmMaintHandlingNorm.newPageRequested.value ;
    frmMaintHandlingNorm.action = "../../../HandlingNormNextDetailAction.do";
    frmMaintHandlingNorm.submit();
}

function doQueryMode()
{     
     frmMaintHandlingNorm.action="../../../HandlingNormQueryMode.do"
     frmMaintHandlingNorm.submit();
}

function doInsertMode()
{     
     frmMaintHandlingNorm.action="../../../HandlingNormInsertMode.do"
     frmMaintHandlingNorm.submit();
}

function getHeaderRecord()
{     
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmMaintHandlingNorm.action="../../../HandlingNormGetHeader.do"
	frmMaintHandlingNorm.submit();
}

function enable()
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
        document.getElementsByName("txtNormId")[i].disabled="";
        document.getElementsByName("txtNormRate")[i].disabled="";
        document.getElementsByName("txtNormUnit")[i].disabled="";
        document.getElementsByName("txtNormDesc")[i].disabled="";
        document.getElementsByName("txtNormBel66kg")[i].disabled="";
        document.getElementsByName("txtNormAbv66kg")[i].disabled="";
    }
}
 
 
function doRefresh()
{ 
    frmMaintHandlingNorm.action="../../../HandlingNormRefresh.do"
    frmMaintHandlingNorm.submit();
}

function doGetNextHeader()
{   
    document.all.buttonFlag.value='';
    frmMaintHandlingNorm.userPositionRequested.value = 1*frmMaintHandlingNorm.positionRequested.value + 1;
    document.forms[0].action="../../../HandlingNormGetNextHeader.do";
    document.forms[0].submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmMaintHandlingNorm.userPositionRequested.value = 1*frmMaintHandlingNorm.positionRequested.value - 1;
    document.forms[0].action="../../../HandlingNormGetNextHeader.do";
    document.forms[0].submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmMaintHandlingNorm.userPositionRequested.value =  1*frmMaintHandlingNorm.newPositionRequested.value;;
    document.forms[0].action="../../../HandlingNormGetNextHeader.do";
    document.forms[0].submit();
}

function setFields(i)
{
  var unit=document.getElementsByName("txtNormUnit")[i-1].value;
  if(unit=='')
    return;
  if(unit=='BAG')
  {
    document.getElementsByName("txtNormBel66kg")[i-1].disabled="";
    document.getElementsByName("txtNormBel66kg")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtNormAbv66kg")[i-1].disabled="";
    document.getElementsByName("txtNormAbv66kg")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtNormRate")[i-1].disabled="true";
    document.getElementsByName("txtNormRate")[i-1].style.background="#e0e0e0";
  }else
  {
    document.getElementsByName("txtNormRate")[i-1].disabled="";
    document.getElementsByName("txtNormRate")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtNormBel66kg")[i-1].disabled="true";
    document.getElementsByName("txtNormBel66kg")[i-1].style.background="#e0e0e0";
    document.getElementsByName("txtNormAbv66kg")[i-1].disabled="true";
    document.getElementsByName("txtNormAbv66kg")[i-1].style.background="#e0e0e0";
  }
}
</script>

