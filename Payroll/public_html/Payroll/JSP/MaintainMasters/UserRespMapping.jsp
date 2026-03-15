<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
	<%
	java.util.Date systemDate = new java.util.Date();

	java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("d-MMM-yyyy");
	String strSystemDate = dateFormat.format(systemDate);    
		
	%>
    <html:base/>
      <TITLE><bean:message key="Payroll.title" /></TITLE>
      <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
      <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
      <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
  </head>
  <BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" >
    <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

    <html:form  action="UsrRespMapBaseAction" name="frmUsrRespMap" type="FCIPAY.COMMON.WEBTIER.Form.UsrRespMapForm" scope="session">
      <bean:define id="ParentForm" name="frmUsrRespMap" toScope="request" />
	  <bean:define name="frmUsrRespMap" id="locList" property="locList" />

      <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
      <html:errors/>
      <html:hidden property="detailDataChanged" />
      <html:hidden property="headerFields" value="false" />
      <%! int i=0,j=0; %>
      <% i = 0;j=0; %>

      <TABLE cellSpacing=0 bgColor=#bdd0ef>
        <TR height=30>
          <TD  colSpan=11 class=mainHeader height=10>USER RESPONSIBILITY MAPPING</TD>
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
       <!--  Header Row Starts -->
                <TR>
                  <TD class=subHeader colspan=6>Header For User Responsibility Mapping</TD>
                </TR>
                <TR>
                  <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>

                <tr height="15" >
                  <td colspan="2"></td>
                </tr>
         
            <tr>
				<td class="labelText" align="right" width="20%" >User Id</td>
				<td align="left">
				   <html:text property="txtUserCode" name="frmUsrRespMap" styleClass="required" maxlength="10" size="20" onchange="validateUser()" />
				</td>
				<td class="labelText" align="right" width="20%" >Mapped location</td>
				<td width="35%" >
					<html:select property="txtMapLoc" styleClass="required" name="frmUsrRespMap">
					<html:option value="">Please Select </html:option>
					<html:options collection="locList" labelProperty="code" property="idLong" />
					</html:select>
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
                    <TABLE cellSpacing=0 cellPadding=0 >
					<TR>
						<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
						<td bgcolor="#4682B4" nowrap class=actTabText>Assigned Responsibility<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                          <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                          <TD class=tableHeader width="15%">Responsibility</TD>
                                          <TD class=tableHeader width="15%">Responsibility End Date</td>
                                        </tr> 
                                        <logic:iterate id="usrRespDtlId" name="frmUsrRespMap" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.UserRespBean" indexId="idx">
                                        <% ++i; %>
                                          <logic:notEqual name="usrRespDtlId" property="status" value="D" >                              
                                            <tr>
                                              <td align=center ><html:checkbox property="checked" name="frmUsrRespMap" onclick="checkRecord();" value="false" /></td>
                                              
                                              <logic:equal name="usrRespDtlId" property="status" value="N" >
												<td align="center">
												  <html:select property="txtRespId" name="usrRespDtlId" styleClass="required" onchange="Duplicacy_Chk()" style="WIDTH: 52%"  >
												  <html:option value="" >-----------Please Select-----------</html:option>      
												  <logic:present name="RespName">
												  <html:optionsCollection label="label" value="value" property="respList" name="RespName"/>
												  </logic:present>
												  </html:select>
												</td> 
												<td align="center">
													<html:text property="txtRespEndDt" name="usrRespDtlId" styleClass="optional" readonly="true" maxlength="10"  alt="<%=String.valueOf(i)%>" onchange="displayDate(this.alt);return changed(this.alt);" style="width:30%;text-align:right"  />
													<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="respEndDate" alt="<%=(i-1) %>" onclick="showCalendar('txtRespEndDt',this)" />
												</td>  
                                              </logic:equal>
                                              <logic:notEqual name="usrRespDtlId" property="status" value="N" >
												<td align="center">
												  <html:select property="txtRespId" name="usrRespDtlId" disabled="true" style="WIDTH: 52%"  >
												  <html:option value="" >-----------Please Select-----------</html:option>      
												  <logic:present name="RespName">
												  <html:optionsCollection label="label" value="value" property="respList" name="RespName"/>
												  </logic:present>
												  </html:select>
												</td> 
												<td align="center">
													<html:text property="txtRespEndDt" name="usrRespDtlId" styleClass="optional" readonly="true" maxlength="10"  alt="<%=String.valueOf(i)%>" onchange="displayDate(this.alt);return changed(this.alt);" style="width:30%;text-align:right"  />
													<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="respEndDate" alt="<%=(i-1) %>" onclick="showCalendar('txtRespEndDt',this)" />
												</td>  
											  </logic:notEqual>

                                              <html:hidden property="itemChecked" name="usrRespDtlId" />
                                              <html:hidden property="status" name="usrRespDtlId" />
                                              <html:hidden property="detailId" name="usrRespDtlId" />
                                            </tr>
                                          </logic:notEqual>

                                          <logic:equal name="usrRespDtlId" property="status" value="D" >
                                            <tr>
                                              <td ><html:hidden property="checked" name="frmUsrRespMap" value="notchecked" /></td>
											  <td ><html:hidden property="txtRespId" name="usrRespDtlId"  /></td>
											  <td ><html:hidden property="txtRespEndDt" name="usrRespDtlId"  /></td>
                                              <html:hidden property="itemChecked" name="usrRespDtlId" />
                                              <html:hidden property="status" name="usrRespDtlId" />
                                              <html:hidden property="detailId" name="usrRespDtlId" />
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
                                        <TD>
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
      <html:hidden property="headerPrimaryKey" name="frmUsrRespMap" value="Default" />
      <html:hidden property="screenMode" name="frmUsrRespMap"  />
      <html:hidden property="txtPayScaleTyp" name="frmUsrRespMap" value="CDA"  />
      <html:hidden name="frmUsrRespMap" property="screenName" value="UserRespMapping" />
      <html:hidden name="frmUsrRespMap" property="forwardedPage" />
      <html:hidden property="buttonFlag" name="frmUsrRespMap"  />
      <html:hidden property="pageRequested" name="frmUsrRespMap" />
      <html:hidden property="userPageRequested" name="frmUsrRespMap" />
      <html:hidden property="positionRequested" name="frmUsrRespMap" />
      <html:hidden property="userPositionRequested" name="frmUsrRespMap" />
	  <html:hidden property="lovKey" name="frmUsrRespMap"  />
	  <html:hidden property="txtSearchFields" name="frmUsrRespMap"  />
	  <html:hidden property="txtDisplayFields" name="frmUsrRespMap"  />
	  <html:hidden property="txtIndex" name="frmUsrRespMap"  />
	  <html:hidden property="txtInputField" name="frmUsrRespMap"  />
	  <html:hidden property="hdnAction" name="frmUsrRespMap"  />
	  <html:hidden value="<%=strSystemDate%>" property="systemDt" name="frmUsrRespMap"  />

	  <input type="hidden" name="queryParam" />

    </html:form>
  </body>
</html:html>
         
<script language="javascript">


function lfnLoad()
{
    mode=document.all.screenMode.value;
    if(mode=='')
    {
        doQueryMode();
    }
    menuHandling(mode);    
	if(mode=='Q')
	{
		document.all.butGetDetail.disabled="disabled";
		document.all.butInsert.disabled="disabled";
		document.all.butDelete.disabled="disabled";     
	}
	if(mode=='U')
	{
		document.all.butGetDetail.disabled="";
		document.all.butInsert.disabled="";
		document.all.butDelete.disabled="disabled";  
	}

	if(mode=='N')
	{
		document.all.butGetDetail.disabled="disabled";
		document.all.butInsert.disabled="";
		document.all.butDelete.disabled="true";      
	}
 }

function validateUser()
{
	 document.getElementById("hdnAction").value="validateuser";
     document.forms[0].action = "../../../UserRespAction.do";
     document.forms[0].submit();
}

function Duplicacy_Chk()
{
	var oTable = document.getElementById("Detail");

	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0, j = 0;
	var count = 0;
	var rows = 0;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value != 'D')
		{
			var level1_i = document.getElementsByName("txtRespId")[i].value;
			for(j=i+1; j < (iTr2-1); j++)
			{
				var level1_j = document.getElementsByName("txtRespId")[j].value;
				if(document.getElementsByName("status")[j].value != 'D')
				{
					if (level1_i == level1_j)
					{
						count++;
						document.getElementsByName("txtRespId")[j].value="";
					}
				}
			}
		}
	}

	if (count > 0)
	{
		alert("Duplicate Responsibility is not allowed");
		return false;
	}
	return true;
}

  function changed(val)
  {
    frmUsrRespMap.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
  }


  function doBaseAddRow()
  {
    if(mandatory_Check("frmUsrRespMap"))
    {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
	  enableAll();
      document.all.screenMode.value='U';
      document.forms[0].action = "../../../UsrRespMapAddRowAction.do";
      document.forms[0].submit();
    }
    else
    {
      return false;
    }
  }

  function SaveRecord()
  {
		if(mandatory_Check("frmUsrRespMap"))
		{
			var oTable = document.getElementById("Detail");
			if(oTable == null)
			{
				return;
			}
			var iTr2 = oTable.rows.length;
			var i = 0;
			enableAll();
			frmUsrRespMap.headerFields.value = "false";
			frmUsrRespMap.screenMode.value = "U";
			document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
			frmUsrRespMap.action = "../../../UsrRespMapSaveAction.do";
			frmUsrRespMap.submit();
		}
		else
		{
			return false;
		}
  }

  function enableAll()
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
		document.getElementsByName("txtRespId")[i].disabled="";
	}
  }

  function doQueryMode()
  {
    frmUsrRespMap.action="../../../UsrRespMapQueryMode.do"
    frmUsrRespMap.submit();
  }

  function doInsertMode()
  {
    frmUsrRespMap.action="../../../UsrRespMapNewMode.do"
    frmUsrRespMap.submit();
  }

  function GetDetail()
  {
    document.all.screenMode.value='U';
    frmUsrRespMap.action="../../../UsrRespMapDetailAction.do"
    frmUsrRespMap.submit();
  }

  function doRefresh()
  {
    frmUsrRespMap.action="../../../UsrRespMapRefresh.do"
    frmUsrRespMap.submit();
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
          document.getElementsByName("itemChecked")[i].value = "Y";
      }
    }
    enableAll();
    document.forms[0].action = "../../../UsrRespMapDeleteRowAction.do";
    document.forms[0].submit();  
  }

 
  function JumpDetail()
  {
    frmUsrRespMap.userPageRequested.value = 1*frmUsrRespMap.newPageRequested.value ;
    frmUsrRespMap.action = "../../../UsrRespMapNextDetailAction.do";
    frmUsrRespMap.submit();
  }
  
 function getHeaderRecord()
{
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmUsrRespMap.action="../../../UsrRespMapGetHeaderAction.do"
    frmUsrRespMap.submit();
}

function doGetNextHeader()
{ 
    frmUsrRespMap.userPositionRequested.value = 1*frmUsrRespMap.positionRequested.value + 1;
    frmUsrRespMap.action="../../../UsrRespMapGetNextHeader.do";
    frmUsrRespMap.submit();
}

function PrevHeader()
{
    frmUsrRespMap.userPositionRequested.value = 1*frmUsrRespMap.positionRequested.value - 1;
    frmUsrRespMap.action = "../../../UsrRespMapGetNextHeader.do";
    frmUsrRespMap.submit();
}

function JumpHeader()
{
    frmUsrRespMap.userPositionRequested.value = 1*frmUsrRespMap.newPositionRequested.value;
    frmUsrRespMap.action = "../../../UsrRespMapGetNextHeader.do";
    frmUsrRespMap.submit();
}

function displayDate(indx)
{
	var respDt=document.getElementsByName("txtRespEndDt")[indx-1].value;
	var sysdate =  document.all.systemDt.value;
	alert(sysdate + ' ' + respDt)
	if (!cmpDate(sysdate,respDt,0))
	  {
		alert("Responsibility End Date cannnot be less than System Date");
		document.all.txtRespEndDt.value="";
		return false;                      
	  }
	return true;
}

</script>
