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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintConvAllowAndRecRates" name="frmMaintConvAllowAndRecRates" type="FCIPAY.Payroll.WEBTIER.Form.MaintConvParamForm" scope="session">
<bean:define id="ParentForm" name="frmMaintConvAllowAndRecRates" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="payScaleType" value="CDA" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN TRANSPORT ALLOWANCE</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  
 </TABLE>
<!--container table starts -->
  <TABLE cellSpacing=0 cellPadding=0 border=0 >
    <TBODY>
      <TR>
        <TD>    
           <!-- Body table Starts -->
          <TABLE cellSpacing=0 cellPadding=0>
          <!--Account  Header Row Starts -->
            <TR>
              <TD class=subHeader colspan=2>Header For Maintain Transport Allowance</TD>
            </TR>
            <TR>
              <TD colspan=8 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR>            
            <tr height="15" >
              <td colspan="2"></td>
            </tr>
            
            <tr>
              <td class="labelText" align="right" width="20%" ><bean:message key="Payroll.MaintTransport.date" /></td>
              <td align="left">
              <html:text  property="txtEffectDate" altKey="Payroll.MaintTransport.date" maxlength="10" size="16" styleClass="required" readonly="true" onchange="checkEffecDate(this.value);" />
              <logic:equal property= "screenMode" name= "frmMaintConvAllowAndRecRates" value="Q">            
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov"  property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffectDate',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
              </logic:equal>
              <logic:equal property= "screenMode" name= "frmMaintConvAllowAndRecRates" value="N">            
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov"  property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtEffectDate',this)" />
              </logic:equal>               
              </td>        

              <td class="labelText"  width="20%" align="right">Type Of City</td>
              <td align="left"><html:select property="headerPrimaryKey" styleClass="required" >
              <html:option value="" >-----------Please Select-----------</html:option>      
              <logic:present name="ConvAllowCity">
              <html:optionsCollection label="label" value="value" property="cityList" name="ConvAllowCity"/>
              </logic:present>
              </html:select></td>                                    
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
                    <td bgcolor="#4682B4" nowrap class=actTabText > CDA <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("ida") > IDA <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    
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
                                      <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>                                      
                                      <TD class=tableHeader width="25%">PayScale Grade</TD>  
                                      <TD class=tableHeader width="5%">Handicapped</TD>                                              
                                      <TD class=tableHeader width="15%">Allowance</td>
                                    </tr> 
                                    <logic:iterate id="convallowinfo" name="frmMaintConvAllowAndRecRates" property="lstInstrDtlsCDA" type="FCIPAY.Payroll.UTILITY.MaintConvAllowBean" >
                                    <% ++i; %>
                                    <logic:notEqual name="convallowinfo" property="status" value="D" >  
                                    <tr>
                                      <td ><html:checkbox property="checked" onclick="checkRecord();"  value="false" name="frmMaintConvAllowAndRecRates" /></td>
                                      <td> <html:select property="txtPayScale"  styleClass="required" name="convallowinfo" style="width:100%"  alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);"  >
                                      <html:option value="" >-----------Please Select-----------</html:option>      
                                      <logic:present name="ConvAllowCity">
                                      <html:optionsCollection label="label" value="value" property="payScaleList" name="ConvAllowCity"/>
                                      </logic:present>
                                      </html:select>
                                      </td>                                 
                                  
                                      <td colspan="1" ><html:select  property="txtHandicap" name="convallowinfo" styleClass = "required" alt="<%=String.valueOf(i)%>" style="width:100%" onchange="return changed(this.alt); " >   
                                      <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>
                                      <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                                      </html:select>
                                      </td>
                               
                                      <td ><html:text property="txtAllow" name="convallowinfo" maxlength="9"  styleClass="required" size="6" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                      if (!num_Check(this.value,1))
                                      {
                                      this.focus();
                                      return false;
                                      }                                      
                                      else
                                      return changed(this.alt);
                                      " /></td>
                                      <html:hidden property="itemChecked" name="convallowinfo" />
                                      <html:hidden property="txtSrlNo" name="convallowinfo" />                                        
                                      <html:hidden property="status" name="convallowinfo" />
                                      <html:hidden property="txtCategory" name="convallowinfo" />
                                      <html:hidden property="detailId" name="convallowinfo" value="Default"/>                                      
                                    </tr>
                                    </logic:notEqual>                               
                                 
                                    <logic:equal name="convallowinfo" property="status" value="D" >
                                      <tr>
                                        <td ><html:hidden property="checked" name="frmMaintConvAllowAndRecRates" value="notchecked" /></td>                                      
                                        <td ><html:hidden property="txtPayScale" name="convallowinfo" /></td> 
                                        <td ><html:hidden property="txtHandicap" name="convallowinfo" /></td>
                                        <td ><html:hidden property="txtAllow" name="convallowinfo" /></td>
                                        <html:hidden property="itemChecked" name="convallowinfo" />
                                        <html:hidden property="txtSrlNo" name="convallowinfo" />                                        
                                        <html:hidden property="status" name="convallowinfo" />
                                        <html:hidden property="txtCategory" name="convallowinfo" />
                                        <html:hidden property="detailId" name="convallowinfo" value="Default"/>
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
<html:hidden name="frmMaintConvAllowAndRecRates"  property="screenMode"  />
<html:hidden property="headerClick" name="frmMaintConvAllowAndRecRates"  />
<html:hidden name="frmMaintConvAllowAndRecRates"  property="screenModeAll"  />
<html:hidden name="frmMaintConvAllowAndRecRates"  property="screenModeCDA"  />
<html:hidden name="frmMaintConvAllowAndRecRates"  property="screenModeIDA"  />
<html:hidden property="positionRequested" name="frmMaintConvAllowAndRecRates" />
<html:hidden property="userPositionRequested" name="frmMaintConvAllowAndRecRates" />
<html:hidden name="frmMaintConvAllowAndRecRates"  property="screenModeConvAllow"  />
<html:hidden name="frmMaintConvAllowAndRecRates"  property="screenName" value="ConvAllowCDAScreen" />
<html:hidden name="frmMaintConvAllowAndRecRates"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintConvAllowAndRecRates"  />
<html:hidden property="flagIda" name="frmMaintConvAllowAndRecRates"  />
<html:hidden property="flagCda" name="frmMaintConvAllowAndRecRates"  />
<html:hidden property="flagAll" name="frmMaintConvAllowAndRecRates"  />
<html:hidden property="buttonFlag" name="frmMaintConvAllowAndRecRates"  />
<html:hidden property="userPageRequested" name="frmMaintConvAllowAndRecRates" />
<html:hidden property="pageRequested" name="frmMaintConvAllowAndRecRates" />
</html:form>
</body>
</html:html>

<script language="javascript">
  var chkMes =0;
  
function changed(val)
{
    frmMaintConvAllowAndRecRates.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
        document.getElementsByName("status")[val-1].value = 'U';
}

function doBaseAddRow()
{
    document.all.buttonFlag.value='D'; 
    document.all.screenMode.value='U';
    document.all.flagCda.value='true';
    if(mandatory_Check("frmMaintConvAllowAndRecRates"))
    {
        frmMaintConvAllowAndRecRates.headerPrimaryKey[0].disabled="";
        document.forms[0].action = "../../../ConvAllowCdaAddRowAction.do";
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
      if(document.getElementsByName("txtSrlNo")[i].value=="" )
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        document.all.detailDataChanged.value="true";
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
   
  
  frmMaintConvAllowAndRecRates.headerPrimaryKey.disabled="";
  document.forms[0].action = "../../../ConvAllowCdadeleteRowAction.do";
  document.forms[0].submit();  
}

function GetDetail()
{
    document.all.buttonFlag.value='';  
    document.all.screenModeCDA.value='UG';
    //document.all.screenModePay1.value = document.all.screenModePay2.value;        
    //frmMaintConvAllowAndRecRates.headerPrimaryKey.value = frmMaintConvAllowAndRecRates.txtRevYYMM.value + "," + frmMaintConvAllowAndRecRates.lstPayScale.value;  
    frmMaintConvAllowAndRecRates.action="../../../ConvAllowCDAFirstGetDetailAction.do";
    frmMaintConvAllowAndRecRates.submit();
}

function GetDetails()
{
    document.all.buttonFlag.value='';  
    if(frmMaintConvAllowAndRecRates.headerPrimaryKey.value == '')
    {
        alert("Mandatory Field is empty");
        frmMaintConvAllowAndRecRates.headerPrimaryKey.focus();
        return;
    }
    else
    {
        frmMaintConvAllowAndRecRates.flagCda.value="true";
        frmMaintConvAllowAndRecRates.headerPrimaryKey.value=frmMaintConvAllowAndRecRates.headerPrimaryKey.value;
        frmMaintConvAllowAndRecRates.screenModeCDA.value='U';
        document.all.screenMode.value='U';
        frmMaintConvAllowAndRecRates.headerPrimaryKey.disabled="";
        frmMaintConvAllowAndRecRates.action="../../../ConvAllowCdaFirstGetDetailAction.do"
        frmMaintConvAllowAndRecRates.submit();
    }
}

function SaveRecord()
{    
    document.all.buttonFlag.value='';    
    if(!mandatory_Check("frmMaintConvAllowAndRecRates"))
        return false;          
    frmMaintConvAllowAndRecRates.screenMode.value = 'U';
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    
    if(!DupliCheck())
        return false;    
    
    frmMaintConvAllowAndRecRates.totalDetailRecord.value = parseInt(iTr2,10) - 1;  
    frmMaintConvAllowAndRecRates.headerFields.value = "true";
    frmMaintConvAllowAndRecRates.payScaleType.value = "CDA";      
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmMaintConvAllowAndRecRates.action = "../../../ConvAllowCDASaveAction.do";
    frmMaintConvAllowAndRecRates.submit();
}


function SaveRecords()
{
    document.all.buttonFlag.value='';  
    if(!mandatory_Check("frmMaintConvAllowAndRecRates"))
        return false;      
    
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    
    //if(!DupliCheck())
    //return false;
    
    var iTr2 = oTable.rows.length;
    var i = 0;  
    
    for(i=0; i < iTr2 -2; i++)
    {
        if (document.getElementsByName("status")[i].value == 'D')
            frmMaintConvAllowAndRecRates.detailDataChanged.value = "true";
    }    
    frmMaintConvAllowAndRecRates.headerPrimaryKey.value=frmMaintConvAllowAndRecRates.headerPrimaryKey.value;
    frmMaintConvAllowAndRecRates.headerFields.value = "false";
    frmMaintConvAllowAndRecRates.totalDetailRecord.value = parseInt(iTr2,10) - 1;
    frmMaintConvAllowAndRecRates.action = "../../../ConvAllowCdaSaveAction.do";
    frmMaintConvAllowAndRecRates.submit();
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
        if (i>0)
        {
            var p = parseInt(document.getElementsByName("endField")[i-1].value);
            if (m != p+1)
            {
                alert("Amount From Should Be One Greater Than Previous Rows Amount To");
                document.getElementsByName("startField")[i].focus(); 
                return false;                      
            }                 
        }    
    }                 
    return true;
}

function doGetTab(arg)
{
    document.all.buttonFlag.value='';  
    /* if(frmMaintConvAllowAndRecRates.detailDataChanged.value == "true")
    {
        alert("Please save the data");
        return false;                        
    }*/
    
    frmMaintConvAllowAndRecRates.headerPrimaryKey[0].disabled="";
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../ConvCdaTabAction.do";
    document.forms[0].submit();
}


function chk_FromAmount(fieldval, rowval)
{
    if(num_Check(fieldval,0))  
    {
        if (chk_PrevAmount(rowval))
        {
            if (chk_FromToAmount(rowval)) 
            {
                changed(rowval);
                chkMes = 0;
                return true;            
            }
            else
            {
                chkMes = 1;
                return false;
            }
        }
        else
        {
            chkMes = 1;        
            return false;        
        }
    }
    else
    {
        chkMes = 1;      
        return false;
    }
}

function chk_ToAmount(fieldval, rowval)
{
    if (chkMes == 0)
    {
        if(num_Check(fieldval,0))  
        {
            if (chk_ToFromAmount(rowval)) 
            {
                changed(rowval);
                return true;
            }
            else
            {
                return false;        
            }
        }
        else
        {
            return false;
        }
        return true;
    }
    return true;
}

function chk_PrevAmount(i)
{      
    var from = parseInt(document.getElementsByName("txtAmtFrom")[i-1].value);
    if (i>1)
    {
        var p = parseInt(document.getElementsByName("txtAmtTo")[i-2].value);
        if (from != p+1)
        {
            // alert(" Amount From  Should Be One Greater Than Previous Rows Amount To ");
            //                   document.getElementsByName("txtAmtFrom")[i-1].select(); 
            document.getElementsByName("txtAmtFrom")[i-1].focus(); 
            chkMes = 1;
            return false;                      
        }                 
    }
    return true;
}


function chk_FromToAmount(i)
{   
    var from = parseInt(document.getElementsByName("txtAmtFrom")[i-1].value);          
    var to = parseInt(document.getElementsByName("txtAmtTo")[i-1].value);
    
    if(to <= from )
    {
        alert("Amount To Should be greater than Amount From ");
        document.getElementsByName("txtAmtTo")[i-1].focus();             
        return false;                        
    }
    else
        return true;
}

function chk_ToFromAmount(i)
{              
    var from = parseInt(document.getElementsByName("txtAmtFrom")[i-1].value);          
    var to = parseInt(document.getElementsByName("txtAmtTo")[i-1].value);
    
    if(to <= from )
    {
        alert("Amount To Should be greater than Amount From ");
        document.getElementsByName("txtAmtTo")[i-1].focus();             
        return false;                        
    }
    else
    return true;
}


function doInsertMode()
{
    document.all.buttonFlag.value='';    
    document.all.screenModeAll.value = "N";
    document.all.screenModeIDA.value = "N";
    document.all.screenModeCDA.value = "N";   
    
    //  document.all.screenModePay1.value  = "N";
    //  document.all.screenModePay2.value  = "N";
    //  document.all.screenModeCDA.value  = "N";
    document.all.screenMode.value = "N";
    document.all.screenModeConvAllow.value = "I";
    frmMaintConvAllowAndRecRates.action="../../../ConvAllowCdaNewMode.do"
    frmMaintConvAllowAndRecRates.submit();
}


function doQueryMode()
{
    document.all.screenModeAll.value = "Q";
    document.all.screenModeIDA.value = "Q";
    document.all.screenModeCDA.value = "Q";   
    
    document.all.buttonFlag.value='';  
    //document.all.screenModeCDA.value = "Q";
    document.all.screenModeConvAllow.value = "Q";   
    frmMaintConvAllowAndRecRates.flagAll.value="false";
    frmMaintConvAllowAndRecRates.flagCda.value="false";
    frmMaintConvAllowAndRecRates.flagIda.value="false";
    frmMaintConvAllowAndRecRates.headerPrimaryKey.value="";
    frmMaintConvAllowAndRecRates.butGetDetail.disabled="";
    frmMaintConvAllowAndRecRates.butInsert.disabled="true";
    frmMaintConvAllowAndRecRates.butDelete.disabled="true";
    frmMaintConvAllowAndRecRates.action="../../../ConvAllowCdaQueryMode.do"
    frmMaintConvAllowAndRecRates.submit();
}

function doInsertModes()
{
    //  alert("new");
    // frmMaintConvAllowAndRecRates.action="../../../ConvAllowCdaNewMode.do"
    //frmMaintConvAllowAndRecRates.submit();
}

function doQueryModes()
{
    document.all.buttonFlag.value='';  
    frmMaintConvAllowAndRecRates.flagAll.value="false";
    frmMaintConvAllowAndRecRates.flagCda.value="false";
    frmMaintConvAllowAndRecRates.flagIda.value="false";
    frmMaintConvAllowAndRecRates.headerPrimaryKey.value="";
    frmMaintConvAllowAndRecRates.butGetDetail.disabled="";
    frmMaintConvAllowAndRecRates.butInsert.disabled="true";
    frmMaintConvAllowAndRecRates.butDelete.disabled="true";
    frmMaintConvAllowAndRecRates.action="../../../ConvAllowCdaQueryMode.do"
    frmMaintConvAllowAndRecRates.submit();    
}


function lfnLoad()
{  
    var sMode  = frmMaintConvAllowAndRecRates.screenMode.value;
    alert (sMode);
    if(sMode == "")
    {
       
        //doQueryMode();
    }    
    mode = frmMaintConvAllowAndRecRates.screenModeCDA.value;    
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
    if (frmMaintConvAllowAndRecRates.screenMode.value == 'U')
    { 
        document.getElementById("txtEffectDate").disabled = "true";
        document.getElementById("headerPrimaryKey").disabled = "true";      
    }
    else
    {  
        document.getElementById("txtEffectDate").disabled="";
        document.getElementById("headerPrimaryKey").disabled="";
    } 

    if(mode=='U')
    {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";
        
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
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
    }  
    mode = frmMaintConvAllowAndRecRates.screenMode.value;  
    menuHandling(mode); 
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";   
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

function lfnLoads()
{
  var sMode  = frmMaintConvAllowAndRecRates.screenMode.value;
  if(sMode == "")
  {
    doQueryMode();
  }

  /*
  mode = document.all.screenModeCDA.value;
  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }
  if(mode=='U')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";

      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
 
 
  }

  
  mode = document.all.screenMode.value;
  if(mode=='' || mode=='Q')
   {
 frmMaintConvAllowAndRecRates.butGetDetail.disabled="";
 frmMaintConvAllowAndRecRates.butInsert.disabled="true";
 frmMaintConvAllowAndRecRates.butDelete.disabled="true";
   }*/
   mode=document.all.flagCda.value;
   if(mode=='false')
   {
 frmMaintConvAllowAndRecRates.butGetDetail.disabled="";
 frmMaintConvAllowAndRecRates.butInsert.disabled="true";
 frmMaintConvAllowAndRecRates.butDelete.disabled="true";
   }
  
   if(mode=='true')
   {
 frmMaintConvAllowAndRecRates.butGetDetail.disabled="true";
 frmMaintConvAllowAndRecRates.butInsert.disabled="";
 frmMaintConvAllowAndRecRates.butDelete.disabled="";
   }
  if(mode == 'true' || document.all.flagIda.value == 'true' || document.all.flagAll.value == 'true')
  {
    frmMaintConvAllowAndRecRates.headerPrimaryKey.disabled=true;
  }


  mode1 = document.all.screenMode.value;
  menuHandling(mode1); 
  
}


function menuHandlings(mode1)
{
  if(mode1=='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
/*      document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";  */  
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
   if(mode1=='')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
/*      document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";  */  
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";   
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
/*  if(mode1=='N')
  {
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }*/
  if(mode1=='U')
  {
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";  
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg"; 
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true"; 
          
  }
 
if(document.all.buttonFlag.value=='D')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  
  }
}

function doBasePrevDetail()
{
    frmMaintConvAllowAndRecRates.userPageRequested.value = 1*frmMaintConvAllowAndRecRates.pageRequested.value - 1;
    frmMaintConvAllowAndRecRates.action = "../../../ConvAllowCdaPrevDetailAction.do";
    frmMaintConvAllowAndRecRates.submit();
}


function doBaseNextDetail()
{
    frmMaintConvAllowAndRecRates.userPageRequested.value = 1*frmMaintConvAllowAndRecRates.pageRequested.value + 1;
    frmMaintConvAllowAndRecRates.action = "../../../ConvAllowCdaNextDetailAction.do";
    frmMaintConvAllowAndRecRates.submit();
}

function JumpDetail()
{
    frmMaintConvAllowAndRecRates.userPageRequested.value = 1*frmMaintConvAllowAndRecRates.newPageRequested.value ;
    frmMaintConvAllowAndRecRates.action = "../../../ConvAllowCdaNextDetailAction.do";
    frmMaintConvAllowAndRecRates.submit();
}

function doRefresh()
{   
    frmMaintConvAllowAndRecRates.action = "../../../ConvAllowCdaRefresh.do";
    frmMaintConvAllowAndRecRates.submit();
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
        if (document.getElementsByName("status")[i].value != "D")
        {
            var Group1 = document.getElementsByName("txtPayScale")[i].value;
            var flag1 = document.getElementsByName("txtHandicap")[i].value;
            for(j=i+1;j<iTr2-1;j++)                
            {                                               
                if (document.getElementsByName("status")[j].value != "D")
                {                    
                    var Group2 = document.getElementsByName("txtPayScale")[j].value;
                    var flag2 = document.getElementsByName("txtHandicap")[j].value;
                    if(Group1==Group2 && flag1==flag2)
                    {
                        alert("Duplication of record is not allowed"); 
                        document.getElementsByName("txtPayScale")[j].focus();
                        return false;
                    }                                               
                }
            }                              
        }
    }
    return true;
}

function getHeaderRecord()
{
    document.all.screenModeAll.value = "U";
    document.all.screenModeIDA.value = "U";
    document.all.screenModeCDA.value = "U";
    
    document.all.buttonFlag.value='';         
    document.all.screenModeCDA.value='U';    
    
    document.all.screenModeConvAllow.value = "U1";    
    document.all.headerClick.value = "CDA";  
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmMaintConvAllowAndRecRates.action="../../../ConvAllowCdaGetHeaderAction.do";
    frmMaintConvAllowAndRecRates.submit();
}

function doGetNextHeader()
{    
    document.all.screenModeAll.value = "U";
    document.all.screenModeIDA.value = "U";
    document.all.screenModeCDA.value = "U";   
    
    document.all.buttonFlag.value='';
    frmMaintConvAllowAndRecRates.screenModeCDA.value='U';
    frmMaintConvAllowAndRecRates.headerClick.value = "CDA";
    document.all.screenModeConvAllow.value = "U1"; 
    frmMaintConvAllowAndRecRates.userPositionRequested.value = 1*frmMaintConvAllowAndRecRates.positionRequested.value + 1;   
    frmMaintConvAllowAndRecRates.action="../../../ConvAllowCdaGetNextHeader.do";
    frmMaintConvAllowAndRecRates.submit();
}

function PrevHeader()
{    
    document.all.screenModeAll.value = "U";
    document.all.screenModeIDA.value = "U";
    document.all.screenModeCDA.value = "U";   
    
    document.all.buttonFlag.value='';
    frmMaintConvAllowAndRecRates.screenModeIDA.value='U';
    document.all.screenModeConvAllow.value = "U1"; 
    frmMaintConvAllowAndRecRates.headerClick.value = "CDA";
    frmMaintConvAllowAndRecRates.userPositionRequested.value = frmMaintConvAllowAndRecRates.positionRequested.value - 1;
    frmMaintConvAllowAndRecRates.action = "../../../ConvAllowCdaGetNextHeader.do";
    frmMaintConvAllowAndRecRates.submit();
} 

function JumpHeader()
{    
    document.all.screenModeAll.value = "U";
    document.all.screenModeIDA.value = "U";
    document.all.screenModeCDA.value = "U";   
    
    document.all.buttonFlag.value='';
    frmMaintConvAllowAndRecRates.screenModeIDA.value='U';
    document.all.screenModeConvAllow.value = "U1"; 
    frmMaintConvAllowAndRecRates.headerClick.value = "CDA";
    frmMaintConvAllowAndRecRates.userPositionRequested.value = frmMaintConvAllowAndRecRates.newPositionRequested.value ;
    frmMaintConvAllowAndRecRates.action = "../../../ConvAllowCdaGetNextHeader.do";
    frmMaintConvAllowAndRecRates.submit();
} 
function checkEffecDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,systDate,0,"Date cannot be Greater then the Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtEffectDate.value="";     
        return false;
    }    
}

</script>
