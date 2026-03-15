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
  <BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
    <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
    <%! int i=0,j=0 ;%>
    <% i = 0; j=0; %>

    <html:form  action="MaintTrblAreaAllow" name="frmMaintTrblAreaAllow" type="FCIPAY.Payroll.WEBTIER.Form.MaintTrblAreaAllowForm" scope="session">
      <bean:define id="ParentForm" name="frmMaintTrblAreaAllow" toScope="request" />
      <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
      <html:errors/>  
      <html:hidden property="detailDataChanged"  />
      <html:hidden property="headerFields" value="false" />

      <table>
        <TR height=30>
          <TD  colSpan=11 class=mainHeader height=10>TRIBAL AREA ALLOWANCE</TD>
        </TR>

        <tr height="10"><td class=userText colspan="11"></td></tr>
      </TABLE>
    <!--container table starts -->
      <TABLE cellSpacing=0 cellPadding=0 border=0 >
        <TBODY>
  
          <TR>
            <TD>
                      <TABLE cellSpacing=0 cellPadding=0>
          <!--Account  Header Row Starts -->
            <TR>
              <TD class=subHeader colspan=2>Header For Tribal Area Allowance</TD>
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
              <html:text  property="txtEffDt" altKey="Payroll.MaintTransport.date" readonly="true" maxlength="10" size="16" styleClass="required" />
              <logic:equal property= "screenMode" name= "frmMaintTrblAreaAllow" value="Q">            
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffDt',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
              </logic:equal>
              <logic:equal property= "screenMode" name= "frmMaintTrblAreaAllow" value="N">            
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtEffDt',this)" />
              </logic:equal>               
              </td>        
           </tr>
            
            <tr height="10">		    
              <TD colspan="2" > </TD>
            </tr>
          </table>      
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
                        <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#4682B4" nowrap class=actTabText>CDA<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                        <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#76A2C7" nowrap class=disTabText onclick=getTab("IDA")> IDA<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                  <DIV id=divDtlTable style="height:320px" >
                                  <!-- Detail table starts -->
                                    <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                      <TBODY>
                                        <TR height="20">
                                          <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"   /></td>
                                          <TD class=tableHeader width="10%">Basic From</TD>
                                          <TD class=tableHeader width="10%">Basic To</TD>
                                          <TD class=tableHeader width="8%">Allowance</td>
                                        </TR>    

                                        <logic:iterate id="trblAreaAllowInfo" name="frmMaintTrblAreaAllow" property="lstInstrCdaDtls" type="FCIPAY.Payroll.UTILITY.MaintTrblAreaAllowBean" >
                                        <% ++i; %>
                                          <logic:notEqual name="trblAreaAllowInfo" property="status" value="D" >                              
                                            <tr>
                                              <td align=center ><html:checkbox property="checked" name="frmMaintTrblAreaAllow" onclick="checkRecord();" value="false" /></td>
                                              
                                              <logic:notEqual name="trblAreaAllowInfo" property="status" value="N" >
                                              <td ><html:text property="txtBasicFrom" name="trblAreaAllowInfo" size="9" readonly="true" maxlength="10" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" onblur="
                                                    if(!(chk_FromAmount(this.value, this.alt)))
                                                    {
                                                      this.focus();
                                                      return false;
                                                    }
                                                    else
                                                    {
                                                      return true;
                                                    }                                                                                                                    
                                                  " />
                                              </td> 
                                              <td colspan="1"><html:text property="txtBasicTo" name="trblAreaAllowInfo" maxlength="10" readonly="true" styleClass="required" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" style="width:100%;text-align:right" onblur="
                                                               if(!(chk_ToAmount(this.value, this.alt)))
                                                                    {
                                                                      this.focus();
                                                                      return false;
                                                                    }
                                                                    else
                                                                    {
                                                                      return true;
                                                                    }                                        
                                                                "  />
                                              </td>  
                                              <td ><html:text property="txtAllow" name="trblAreaAllowInfo" size="9" maxlength="10" readonly="true" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" />
                                              </td>
                                              </logic:notEqual>
                                              
                                              <logic:equal name="trblAreaAllowInfo" property="status" value="N" >
                                              <td ><html:text property="txtBasicFrom" name="trblAreaAllowInfo" size="9" maxlength="10" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" onblur="
                                                    if(!(chk_FromAmount(this.value, this.alt)))
                                                    {
                                                      this.focus();
                                                      return false;
                                                    }
                                                    else
                                                    {
                                                      return true;
                                                    }                                                                                                                    
                                                  " />
                                              </td> 
                                              <td colspan="1"><html:text property="txtBasicTo" name="trblAreaAllowInfo" maxlength="10" styleClass="required" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" style="width:100%;text-align:right" onblur="
                                                               if(!(chk_ToAmount(this.value, this.alt)))
                                                                    {
                                                                       this.focus();
                                                                       return false;
                                                                    }
                                                                    else
                                                                    {
                                                                      return true;
                                                                    }                                        
                                                                "  />
                                              </td>  
                                              <td ><html:text property="txtAllow" name="trblAreaAllowInfo" size="9" maxlength="10" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" />
                                              </td>
                                              </logic:equal>
                                              <html:hidden property="txtStartDt" name="trblAreaAllowInfo" />
                                              <html:hidden property="txtEndDt" name="trblAreaAllowInfo" />
                                              <html:hidden property="itemChecked" name="trblAreaAllowInfo" />
                                              <html:hidden property="status" name="trblAreaAllowInfo" />
                                              <html:hidden property="detailId" name="trblAreaAllowInfo" />
                                              <html:hidden property="txtCtgry" name="trblAreaAllowInfo"  />
                                            </tr>
                                          </logic:notEqual>

                                          <logic:equal name="trblAreaAllowInfo" property="status" value="D" >
                                            <tr>
                                              <td ><html:hidden property="checked" name="frmMaintTrblAreaAllow" value="notchecked" /></td>
                                              <td ><html:hidden property="txtBasicFrom" name="trblAreaAllowInfo" /></td>
                                              <td ><html:hidden property="txtBasicTo" name="trblAreaAllowInfo"  value="A" /></td>
                                              <td ><html:hidden property="txtAllow" name="trblAreaAllowInfo" /></td>
                                              <html:hidden property="txtStartDt" name="trblAreaAllowInfo" />
                                              <html:hidden property="txtEndDt" name="trblAreaAllowInfo" />
                                              <html:hidden property="itemChecked" name="trblAreaAllowInfo" />
                                              <html:hidden property="status" name="trblAreaAllowInfo" />
                                              <html:hidden property="detailId" name="trblAreaAllowInfo" />
                                              <html:hidden property="txtCtgry" name="trblAreaAllowInfo"  />
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
              </TABLE>
    <!-- Container Table Ending Columns Starts-->
            </TD>
          </TR>
        </TBODY>
      </TABLE>
   <!-- Container Table Ends -->
   
      <html:hidden property="headerPrimaryKey" name="frmMaintTrblAreaAllow" value="Default" />
      <html:hidden property="screenMode" name="frmMaintTrblAreaAllow"  />
      <html:hidden name="frmMaintTrblAreatAllow"  property="screenName" value="TrblAreaCdaScreen" />
      <html:hidden name="frmMaintTrblAreaAllow"  property="forwardedPage" />
      <html:hidden property="buttonFlag" name="frmMaintTrblAreaAllow"  />
      <html:hidden property="pageRequested" name="frmMaintTrblAreaAllow" />
      <html:hidden property="userPageRequested" name="frmMaintTrblAreaAllow" />
      <html:hidden property="userPositionRequested" name="frmMaintTrblAreaAllow" />
      <html:hidden property="positionRequested" name="frmMaintTrblAreaAllow" />
      <html:hidden property="flagIda" name="frmMaintTrblAreaAllow"  />
      <html:hidden property="flagCda" name="frmMaintTrblAreaAllow"  />
    </html:form>
  </body>
</html:html>

<script language="javascript">
function lfnLoad()
{
    mode1=document.all.flagCda.value;
    frmMaintTrblAreaAllow.butGetDetail.disabled="true";
    frmMaintTrblAreaAllow.butInsert.disabled="true";
    frmMaintTrblAreaAllow.butDelete.disabled="true";
    if(mode1 == 'true' || document.all.flagCda.value == 'true')
    {
      //  frmMaintCCARate.headerPrimaryKey.disabled=true;
    }
    mode=document.all.screenMode.value;  
    if(mode=='')
    {
        doQueryMode();
    }
    if (frmMaintTrblAreaAllow.screenMode.value == 'U')
    { 
          if(mode1=='false')
          {
              frmMaintTrblAreaAllow.butGetDetail.disabled="";
              frmMaintTrblAreaAllow.butInsert.disabled="true";
              frmMaintTrblAreaAllow.butDelete.disabled="true";
          }    
          if(mode1=='true')
          {
              frmMaintTrblAreaAllow.butGetDetail.disabled="true";
              frmMaintTrblAreaAllow.butInsert.disabled="";
              frmMaintTrblAreaAllow.butDelete.disabled="";
          }
    
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;        
    }
        if (frmMaintTrblAreaAllow.screenMode.value == 'N')
    {
        frmMaintTrblAreaAllow.butInsert.disabled="";
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
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
    }
}

  function changed(val)
  {
    frmMaintTrblAreaAllow.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
  }

  function doBaseAddRow()
  {
    if(mandatory_Check("frmMaintTrblAreaAllow"))
    {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      document.all.screenMode.value='U';
      document.all.flagCda.value=true;
      document.forms[0].action = "../../../TrblAreaCdaAddRowAction.do";
      document.forms[0].submit();
    }
    else
    {
      return false;
    }
  }

  function SaveRecord()
  {
    if(mandatory_Check("frmMaintTrblAreaAllow"))
    { 
      if(validateRecords()!=true)
        return false;
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
  
      frmMaintTrblAreaAllow.headerFields.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintTrblAreaAllow.action = "../../../TrblAreaCdaSaveAction.do";
      // frmMaintHraRate.totalDetailRecord.value=parseInt(iTr2)-1;
      frmMaintTrblAreaAllow.submit();
    }
    else
    {
      return false;
    }
  }

  function doQueryMode()
  {
    document.all.flagIda.value='false';
    document.all.flagCda.value='false';
    frmMaintTrblAreaAllow.action="../../../TrblAreaCdaQueryAction.do"
    frmMaintTrblAreaAllow.submit();
  }

  function GetDetail()
  {
    document.all.screenMode.value='U';
    document.all.flagCda.value=true;
    frmMaintTrblAreaAllow.action="../../../TrblAreaCdaGetDetailAction.do"
    frmMaintTrblAreaAllow.submit();
  }

  function doRefresh()
  {
    frmMaintTrblAreaAllow.action="../../../TrblAreaCdaRefresh.do"
    frmMaintTrblAreaAllow.submit();
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
        if(document.getElementsByName("detailId")[i].value=="" )
        {         
          document.getElementsByName("itemChecked")[i].value = "Y";
          frmMaintTrblAreaAllow.detailDataChanged.value = "true"; 
        }
        else
          strRecList=strRecList+(i+1)+",";
      }
    }
   if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
  
    document.forms[0].action = "../../../TrblAreaCdaDeleteRowAction.do";
    document.forms[0].submit();  
  }

  function getTab(arg)
  {
     // frmMaintHillCmpnstryAllow.headerPrimaryKey[0].disabled="";
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../TrblAreaCdaTabAction.do";
    document.forms[0].submit();
  }
 
  function chk_FromAmount(fieldval, rowval)
  {
    if(num_Check(fieldval,0))  
    {
      if (chk_PrevAmount(rowval))
      {
     /*   if (chk_FromToAmount(rowval)) 
        {
          changed(rowval);
          return true;            
        }
        else
        {
          return false;
        }
        */ 
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

  function chk_ToAmount(fieldval, rowval)
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

  function chk_PrevAmount(i)
  {       
    var newCtgry=document.getElementsByName("txtCtgry")[i-1].value;
    var from = parseInt(document.getElementsByName("txtBasicFrom")[i-1].value);
    if (i>1)
    {
      var j=i-1;
      while(j>=1)
      {
        var ctgry=document.getElementsByName("txtCtgry")[j-1].value;
        if(ctgry!=newCtgry)
        {
          j=j-1;
        }
        else
          break;
      }
      if(j>0)
      {
        var p = parseInt(document.getElementsByName("txtBasicTo")[j-1].value);
        if (from != p+1)
        {
          alert(" Start Basic Should Be One Greater Than Previous Rows End Basic ");
          //document.getElementsByName("txtBasicFrom")[i-1].select(); 
          document.getElementsByName("txtBasicFrom")[i-1].focus(); 
          return false;                      
        }
      }                 
    }
    return true;
  }

  function chk_FromToAmount(i)
  {              
    var from = parseInt(document.getElementsByName("txtBasicFrom")[i-1].value);          
    var to = parseInt(document.getElementsByName("txtBasicTo")[i-1].value);
    if(to <= from )
    {
      alert("End Basic Should be greater than Start Basic ");
      document.getElementsByName("txtBasicTo")[i-1].focus();             
      return false;                        
    }
    else
      return true;
  }

  function chk_ToFromAmount(i)
  {              
    var from = parseInt(document.getElementsByName("txtBasicFrom")[i-1].value);          
    var to = parseInt(document.getElementsByName("txtBasicTo")[i-1].value);
    if(to <= from )
    {
      alert("End Basic Should be greater than Start Basic ");
      document.getElementsByName("txtBasicTo")[i-1].focus();             
      return false;                        
    }
    else
      return true;
  }

  function JumpDetail()
  {
    frmMaintTrblAreaAllow.userPageRequested.value = 1*frmMaintTrblAreaAllow.newPageRequested.value ;
    frmMaintTrblAreaAllow.action = "../../../TrblAreaCdaNextDetailAction.do";
    frmMaintTrblAreaAllow.submit();
  }
  
  function chkFromDt(i)
{
  var fromDt=document.getElementsByName("txtStartDt")[i-1].value;
  var toDt=document.getElementsByName("txtEndDt")[i-1].value; 
  if(!cmpSysDate(toDt,0))
    { 
      document.getElementsByName("txtEndDt")[i-1].value="";
      return false;
    }
 
  if (!cmpDate(fromDt,toDt,0))
  {
    alert("To Date must be greater than From Date");
    document.getElementsByName("txtEndDt")[i-1].value="";
    return false;                      
  }
}

 function getHeaderRecord()
{
    document.all.flagCda.value="false";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmMaintTrblAreaAllow.action="../../../TrblAreaCdaGetHeaderAction.do"
    frmMaintTrblAreaAllow.submit();
}

function doGetNextHeader()
{ 
    document.all.flagIda.value='false';
    document.all.flagCda.value='false';
    frmMaintTrblAreaAllow.userPositionRequested.value = 1*frmMaintTrblAreaAllow.positionRequested.value + 1;
    frmMaintTrblAreaAllow.action="../../../TrblAreaCdaGetNextHeader.do";
    frmMaintTrblAreaAllow.submit();
}

function PrevHeader()
{  
    document.all.flagIda.value='false';
    document.all.flagCda.value='false';
    frmMaintTrblAreaAllow.userPositionRequested.value = 1*frmMaintTrblAreaAllow.positionRequested.value - 1;
    frmMaintTrblAreaAllow.action = "../../../TrblAreaCdaGetNextHeader.do";
    frmMaintTrblAreaAllow.submit();
}

function JumpHeader()
{
    document.all.flagIda.value='false';
    document.all.flagCda.value='false';
    frmMaintTrblAreaAllow.userPositionRequested.value = 1*frmMaintTrblAreaAllow.newPositionRequested.value;
    frmMaintTrblAreaAllow.action = "../../../TrblAreaCdaGetNextHeader.do";
    frmMaintTrblAreaAllow.submit();
}

function doInsertMode()
{
  frmMaintTrblAreaAllow.action="../../../TrblAreaCdaInsertAction.do";
  frmMaintTrblAreaAllow.submit();
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
      for(i=0; i < iTr2 -1; i++)
      {
        if(document.getElementsByName("status")[i].value=='N')
        {
            if(chk_PrevAmount(i+1)!=true || chk_ToFromAmount(i+1)!=true)
            {
                return false;
            }
        }
      }
  return true;
}
</script>

