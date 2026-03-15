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
  <html:form  action="MaintOTARate" name="frmMaintOTARate" type="FCIPAY.Payroll.WEBTIER.Form.MaintOTARateForm" scope="session">
    <bean:define id="ParentForm" name="frmMaintOTARate" toScope="request" />
    <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
    <html:errors/>  
    <html:hidden property="detailDataChanged"  />
    <html:hidden property="headerFields" value="false" />
    <table>
      <TR height=30>
        <TD  colSpan=11 class=mainHeader height=10>OVERTIME ALLOWANCE RATES</TD>
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
              <TD class=subHeader colspan=2>Header For OTA Rates</TD>
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
              <html:text  property="headerPrimaryKey" altKey="Payroll.MaintTransport.date" readonly="true" maxlength="10" size="16" styleClass="required" />
              <logic:equal property= "screenMode" name= "frmMaintOTARate" value="Q">            
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onclick="showCalendar('headerPrimaryKey',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
              </logic:equal>
              <logic:equal property= "screenMode" name= "frmMaintOTARate" value="N">            
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('headerPrimaryKey',this)" />
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
                      <td bgcolor="#4682B4" ><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#4682B4" nowrap class=actTabText>OTA Rates<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                        <TD class=tableHeader width="6%">OTA Type</TD>
                                        <TD class=tableHeader width="6%">Rate</TD>
                                      </TR>    

                                      <logic:iterate id="oOTARateInfo" name="frmMaintOTARate" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintOTARateBean" >
                                      <% ++i; %>
                                        <logic:notEqual name="oOTARateInfo" property="status" value="D" >                              
                                          <tr> 
                                            <td align=center ><html:checkbox property="checked" name="frmMaintOTARate" onclick="checkRecord();" value="false" /></td>
                                            
                                            <logic:notEqual name="oOTARateInfo" property="status" value="N" >
                                            <td colspan="1"><html:select property="txtOTATyp" name="oOTARateInfo" disabled="true" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                                                <logic:present name="OTAType">
                                                                  <html:optionsCollection label="label" value="value" property="otaTypList" name="OTAType"/>
                                                                </logic:present>
                                                            </html:select>
                                            </td>
                                            <td ><html:text property="txtRate" name="oOTARateInfo" readonly="true" size="9" maxlength="10" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  />
                                            </td>
                                            </logic:notEqual>
                                            
                                            <logic:equal name="oOTARateInfo" property="status" value="N" >
                                            <td colspan="1"><html:select property="txtOTATyp" name="oOTARateInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                                                <logic:present name="OTAType">
                                                                  <html:optionsCollection label="label" value="value" property="otaTypList" name="OTAType"/>
                                                                </logic:present>
                                                            </html:select>
                                            </td> 
                                            <td ><html:text property="txtRate" name="oOTARateInfo" size="9" maxlength="10" styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  />
                                            </td>
                                            </logic:equal>
                                            <html:hidden property="itemChecked" name="oOTARateInfo" />
                                            <html:hidden property="status" name="oOTARateInfo" />
                                            <html:hidden property="detailId" name="oOTARateInfo" />
                                          </tr>
                                        </logic:notEqual>

                                        <logic:equal name="oOTARateInfo" property="status" value="D" >
                                          <tr>
                                            <td ><html:hidden property="checked" name="frmMaintOTARate" value="notchecked" /></td>
                                            <td ><html:hidden property="txtOTATyp" name="oOTARateInfo" /></td>
                                            <td ><html:hidden property="txtRate" name="oOTARateInfo" /></td>
                                            <html:hidden property="itemChecked" name="oOTARateInfo" />
                                            <html:hidden property="status" name="oOTARateInfo" />
                                            <html:hidden property="detailId" name="oOTARateInfo" />
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
    <html:hidden property="screenMode" name="frmMaintOTARate"  />
    <html:hidden name="frmMaintOTARate"  property="screenName" value="OTARateScreen" />
    <html:hidden name="frmMaintOTARate"  property="forwardedPage" />
    <html:hidden property="buttonFlag" name="frmMaintOTARate"  />
    <html:hidden property="pageRequested" name="frmMaintOTARate" />
    <html:hidden property="userPageRequested" name="frmMaintOTARate" />
    <html:hidden property="userPositionRequested" name="frmMaintOTARate" />
    <html:hidden property="positionRequested" name="frmMaintOTARate" />
  </html:form>
  </body>
</html:html>

<script language="javascript">

function lfnLoad()
{
    frmMaintOTARate.butGetDetail.disabled="true";
    frmMaintOTARate.butInsert.disabled="true";
    frmMaintOTARate.butDelete.disabled="true";

    mode=document.all.screenMode.value;  
    if(mode=='')
    {
        doQueryMode();
    }
    if (frmMaintOTARate.screenMode.value == 'U')
    { 
       frmMaintOTARate.butGetDetail.disabled="true";
       frmMaintOTARate.butInsert.disabled="";
       frmMaintOTARate.butDelete.disabled="";
    
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;        
    }
        if (frmMaintOTARate.screenMode.value == 'N')
    {
        frmMaintOTARate.butInsert.disabled="";
    }

    menuHandling(mode);
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";   
 }

 function changed(val)
{
   frmMaintOTARate.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}

function doBaseAddRow()
{
  if(mandatory_Check("frmMaintOTARate"))
  {
     var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
     var iTr2 = oTable.rows.length;
     for(indx=0;indx < iTr2-1;indx++)
     {
       if(document.getElementsByName("status")[indx].value!='D')
       {
        document.getElementsByName("txtOTATyp")[indx].disabled = "";
       }
     }
      
    document.forms[0].action = "../../../OTARateAddRowAction.do";
    document.forms[0].submit();
  }
  else
  {
      return false;
  }
}




function SaveRecord()
{
  if(mandatory_Check("frmMaintOTARate"))
  { 
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
     for(indx=0;indx < iTr2-1;indx++)
     {
      if(document.getElementsByName("status")[indx].value!='D')
      {
        document.getElementsByName("txtOTATyp")[indx].disabled = "";
      }
     }

	frmMaintOTARate.headerFields.value = "false";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	frmMaintOTARate.action = "../../../OTARateSaveAction.do";
	frmMaintOTARate.submit();
}
 else
  {
    return false;
  }
}


function doQueryMode()
{
  
  frmMaintOTARate.action="../../../OTARateQueryAction.do"
  frmMaintOTARate.submit();
}

function GetDetail()
{
  document.all.screenMode.value='U';
  frmMaintOTARate.action="../../../OTARateGetDetailAction.do"
  frmMaintOTARate.submit();
}

function doRefresh()
{
  frmMaintOTARate.action="../../../OTARateRefresh.do"
  frmMaintOTARate.submit();
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
    if(document.getElementsByName("status")[i].value!='D')
    {
      document.getElementsByName("txtOTATyp")[i].disabled = ""; 
    }
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("detailId")[i].value=="" )
      {  
        document.getElementsByName("itemChecked")[i].value = "Y";
        frmMaintRmtAreaAllow.detailDataChanged.value = "true"; 
      }
      else
        strRecList=strRecList+(i+1)+",";
    }

  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
   
  document.forms[0].action = "../../../OTARateDeleteRowAction.do";
  document.forms[0].submit();  
}

  function JumpDetail()
 {
    frmMaintOTARate.userPageRequested.value = 1*frmMaintRmtAreaAllow.newPageRequested.value ;
    frmMaintOTARate.action = "../../../OTARateNextDetailAction.do";
    frmMaintOTARate.submit();

 }
 function getHeaderRecord()
{
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmMaintOTARate.action="../../../OTARateGetHeaderAction.do"
    frmMaintOTARate.submit();
}

function doGetNextHeader()
{ ;
    frmMaintOTARate.userPositionRequested.value = 1*frmMaintOTARate.positionRequested.value + 1;
    frmMaintOTARate.action="../../../OTARateGetNextHeader.do";
    frmMaintOTARate.submit();
}

function PrevHeader()
{
    frmMaintOTARate.userPositionRequested.value = 1*frmMaintOTARate.positionRequested.value - 1;
    frmMaintOTARate.action = "../../../OTARateGetNextHeader.do";
    frmMaintOTARate.submit();
}

function JumpHeader()
{
    frmMaintOTARate.userPositionRequested.value = 1*frmMaintOTARate.newPositionRequested.value;
    frmMaintOTARate.action = "../../../OTARateGetNextHeader.do";
    frmMaintOTARate.submit();
}

function doInsertMode()
{
  frmMaintOTARate.action="../../../OTARateInsertAction.do"
  frmMaintOTARate.submit();
}

</script>

