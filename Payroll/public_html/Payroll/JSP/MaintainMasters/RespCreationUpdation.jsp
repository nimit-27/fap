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
  <BODY  onload="lfnLoad();"  >
    <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

    <html:form  action="MaintRespAction" name="frmRespCreatUpdt" type="FCIPAY.COMMON.WEBTIER.Form.RespCreatUpdtForm" scope="session">
      <bean:define id="ParentForm" name="frmRespCreatUpdt" toScope="request" />
	  <bean:define name="frmRespCreatUpdt" id="headerList" property="headerList" />
      <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
      <html:errors/>
	  <html:hidden property="headerDataChanged" value="false" />
      <html:hidden property="detailDataChanged" />
      <html:hidden property="headerFields" value="false" />
      <%! int i=0,j=0; %>
      <% i = 0;j=0; %>

      <TABLE cellSpacing=0 bgColor=#bdd0ef>
        <TR height=30>
          <TD  colSpan=11 class=mainHeader height=10>Responsibility Creation/Updation Screen</TD>
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
                  <TD class=subHeader colspan=6>Responsibility  Header</TD>
                </TR>
                <TR>
                  <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>

                <tr height="15" >
                  <td colspan="2"></td>
                </tr>
         
	<table>
			<table border=0>
			<tr>
				<td width="20%" class="labelText">Responsibility name</td>
				<td width="35%">
				<logic:equal property="screenMode" name="frmRespCreatUpdt" value="N">
					<html:text  property="txtRespName" name="frmRespCreatUpdt" maxlength="50" size="39" styleClass="required" onkeyup="upper(this)" />
				</logic:equal>
				<logic:notEqual property="screenMode" name="frmRespCreatUpdt" value="N">
				    <logic:equal property="screenMode" name="frmRespCreatUpdt" value="Q">
						<html:text  property="txtRespName" name="frmRespCreatUpdt" maxlength="50" size="39" styleClass="required" onkeyup="upper(this)" />
					</logic:equal>
				    <logic:notEqual property="screenMode" name="frmRespCreatUpdt" value="Q">
						<html:text  property="txtRespName" name="frmRespCreatUpdt" maxlength="50" size="39" styleClass="locked" readonly="true" />
					</logic:notEqual>
     			</logic:notEqual>
				<html:hidden  property="hdnRespId" name="frmRespCreatUpdt"  />
				</td>
				<td width="20%" class="labelText">Responsibility end date</td>
				<td ><html:text property="txtRespEndDt" name="frmRespCreatUpdt" size="10" readonly="true" alt='<%=strSystemDate%>' onchange="lfnChanged(this.value);displayDate(this.alt);" styleClass="option" />
				<img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" styleClass="lov" property="buttxtInvalidDate" alt="<%=(i-1)%>" onclick="showCalendar('txtRespEndDt',this)" /></td>
			</tr>

			<tr >
				<td width="15%" class="labelText" >Module Name : <i><font color="red">*</font></i></td>
				<td width="35%" >
					  <html:select property="lstModule" name="frmRespCreatUpdt" styleClass="required"  style="WIDTH: 52%" onchange="getHeaderList()" >
					  <html:option value="" >-----------Please Select-----------</html:option>      
					  <logic:present name="combolist">
					  <html:optionsCollection label="label" value="value" property="moduleList" name="combolist"/>
					  </logic:present>
					  </html:select>
				</td>
				<td width="15%" class="labelText" >Header Name : <i><font color="red">*</font></i></td>
				<td width="35%" >
					<html:select property="lstHeader" name="frmRespCreatUpdt" styleClass="required" >
						<html:option value="">--------------All Screens---------------</html:option>
						<html:options collection="headerList" labelProperty="code" property="idString" />
					</html:select>
				</td>
				
			</tr>
	</table>

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
						<td bgcolor="#4682B4" nowrap class=actTabText>Assigned Screen(s)<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
										  <TD class=tableHeader width="20%">Level1</TD>
										  <TD class=tableHeader width="20%">Level2</TD>
                                          <TD class=tableHeader width="15%">Screen End Date</td>
                                        </tr> 
                                        <logic:iterate id="usrRespDtlId" name="frmRespCreatUpdt" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.ResponsCreaBean" indexId="idx">
                                        <% ++i; %>
                                          <logic:notEqual name="usrRespDtlId" property="status" value="D" >                              
                                            <tr>
                                              <td align=center ><html:checkbox property="checked" name="frmRespCreatUpdt" onclick="checkRecord();" value="false" /></td>
                                              <logic:equal name="usrRespDtlId" property="status" value="N" >
												<td>
												    <html:text  property="txtLevel1" name="usrRespDtlId" onchange="Duplicacy_Chk()" style="width:92%;text-align:left" maxlength="10" size="10" styleClass="required" readonly="true" />
													<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" alt="<%=idx%>" name="butLoanType" onclick="ShowLovScreen(this.alt);" >
												</td>
												<td>
												    <html:text  property="txtLevel2" name="usrRespDtlId" style="width:97%;text-align:left" maxlength="10" size="10" styleClass="locked" readonly="true" />
												</td>
												<td>
													<html:text property="txtScrEndDt" name="usrRespDtlId" styleClass="optional" readonly="true" maxlength="10" alt="<%=String.valueOf(i)%>" onchange="displayScrDate(this.alt);return changed(this.alt);" style="width:94%;text-align:right" />
													<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="respEndDate" alt="<%=(i-1) %>" onclick="showCalendar('txtScrEndDt',this)" />
												</td>
                                              </logic:equal>
                                              <logic:notEqual name="usrRespDtlId" property="status" value="N" >
												<td>
												    <html:text  property="txtLevel1" name="usrRespDtlId" style="width:92%;text-align:left" maxlength="10" size="10" styleClass="required" readonly="true" />
													<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" alt="<%=idx%>" name="butLoanType" onclick="ShowLovScreen(this.alt);" >
												</td>
												<td>
												    <html:text  property="txtLevel2" name="usrRespDtlId" style="width:97%;text-align:left" maxlength="10" size="10" styleClass="locked" readonly="true" />
												</td>
												<td>
													<html:text property="txtScrEndDt" name="usrRespDtlId" styleClass="optional" readonly="true" maxlength="10" alt="<%=String.valueOf(i)%>" onchange="displayScrDate(this.alt);return changed(this.alt);" style="width:94%;text-align:right" />
													<img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" name="respEndDate" alt="<%=(i-1) %>" onclick="showCalendar('txtScrEndDt',this)" />
												</td>
											  </logic:notEqual>
                                              <html:hidden property="hdnScreenId" name="usrRespDtlId" />
                                              <html:hidden property="itemChecked" name="usrRespDtlId" />
                                              <html:hidden property="status" name="usrRespDtlId" />
                                              <html:hidden property="detailId" name="usrRespDtlId" />
                                            </tr>
                                          </logic:notEqual>
                                          <logic:equal name="usrRespDtlId" property="status" value="D" >
                                            <tr>
											  <td><html:hidden property="checked" name="frmRespCreatUpdt" value="notchecked" /></td>	
											  <td><html:hidden property="txtLevel1" name="frmRespCreatUpdt" /></td>
											  <td><html:hidden property="txtLevel2" name="frmRespCreatUpdt" /></td>
											  <td><html:hidden property="txtScrEndDt" name="frmRespCreatUpdt" /></td>
											  <td><html:hidden property="hdnScreenId" name="usrRespDtlId" /></td>
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

      <html:hidden property="headerPrimaryKey" name="frmRespCreatUpdt" value="Default" />
      <html:hidden property="screenMode" name="frmRespCreatUpdt"  />
      <html:hidden name="frmRespCreatUpdt" property="screenName" value="RespMasterScreen" />
      <html:hidden name="frmRespCreatUpdt" property="forwardedPage" />
      <html:hidden property="buttonFlag" name="frmRespCreatUpdt"  />
      <html:hidden property="pageRequested" name="frmRespCreatUpdt" />
      <html:hidden property="userPageRequested" name="frmRespCreatUpdt" />
      <html:hidden property="positionRequested" name="frmRespCreatUpdt" />
      <html:hidden property="userPositionRequested" name="frmRespCreatUpdt" />
	  <html:hidden property="lovKey" name="frmRespCreatUpdt"  />
	  <html:hidden property="txtSearchFields" name="frmRespCreatUpdt"  />
	  <html:hidden property="txtDisplayFields" name="frmRespCreatUpdt"  />
	  <html:hidden property="txtIndex" name="frmRespCreatUpdt"  />
	  <html:hidden property="txtInputField" name="frmRespCreatUpdt"  />
	  <html:hidden property="hdnAction" name="frmRespCreatUpdt"  />
      <html:hidden value="<%=strSystemDate%>" property="systemDt" name="frmRespCreatUpdt"  />
    
	  <input type="hidden" name="queryParam" />

    </html:form>
  </body>
</html:html>
         
<script language="javascript">


function lfnLoad()
{
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
      doQueryMode();
  }  
  menuHandling(screenmode);
	if(screenmode=='Q')
	{
		document.all.butGetDetail.disabled="disabled";
		document.all.butInsert.disabled="disabled";
		document.all.butDelete.disabled="disabled";     
	}
	if(screenmode=='U')
	{
		document.all.butGetDetail.disabled="";
		document.all.butInsert.disabled="";
		document.all.butDelete.disabled="disabled";  
	}

	if(screenmode=='N')
	{
		document.all.butGetDetail.disabled="disabled";
		document.all.butInsert.disabled="";
		document.all.butDelete.disabled="true";      
	}
}

function ShowLovScreen(i)
{
    frmRespCreatUpdt.lovKey.value = "GetScreenList" + frmRespCreatUpdt.screenName.value + frmRespCreatUpdt.screenMode.value;
    frmRespCreatUpdt.queryParam.value="lstModule="+frmRespCreatUpdt.lstModule.value+",lstHeader="+frmRespCreatUpdt.lstHeader.value;   // added by yogesh
    frmRespCreatUpdt.txtDisplayFields.value = "hdnScreenId,txtLevel1,txtLevel2";
    frmRespCreatUpdt.txtSearchFields.value = "Payroll.Respmaster.screen,Payroll.Respmaster.level1,Payroll.Respmaster.level2";
    frmRespCreatUpdt.txtIndex.value = i;
    frmRespCreatUpdt.txtInputField.value ="txtLevel1";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmRespCreatUpdt');
    return true;
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
			var level1_i = document.getElementsByName("hdnScreenId")[i].value;
			//var level2_i = document.getElementsByName("txtLevel2")[i].value;
			for(j=i+1; j < (iTr2-1); j++)
			{
				var level1_j = document.getElementsByName("hdnScreenId")[j].value;
				//var level2_j = document.getElementsByName("txtLevel2")[j].value;
				if(document.getElementsByName("status")[j].value != 'D')
				{
					if (level1_i == level1_j)
					{
						count++;
						document.getElementsByName("txtLevel1")[j].value="";
						document.getElementsByName("txtLevel2")[j].value="";
						document.getElementsByName("hdnScreenId")[j].value="";
					}
				}
			}
		}
	}

	if (count > 0)
	{
		alert("Duplicate Screen is not allowed");
		return false;
	}
	return true;
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
		document.getElementsByName("txtPayCode")[i].disabled=true;
		document.getElementsByName("txtPayDesc")[i].disabled=true;
		document.getElementsByName("txtYYMM")[i].disabled=true;
		document.getElementsByName("txtPayMode")[i].disabled=true;
		document.getElementsByName("txtAmt")[i].disabled=true;
  }
 }

function getHeaderList()
{
	 document.getElementById("hdnAction").value="headerlist";
     document.forms[0].action = "../../../RespCreateAction.do";
     document.forms[0].submit();
}

function doBaseAddRow()
{
  if(mandatory_Check("frmRespCreatUpdt"))
  {
	//document.all.screenMode.value='U';
	document.forms[0].action = "../../../RespCrtAddRowAction.do";
	document.forms[0].submit();
  }
  else
  {
	  return false;
  }
}

function changed(val)
{
    frmRespCreatUpdt.detailDataChanged.value = "true";
    if(document.getElementsByName("status")[val-1].value=='Q')
    {
      document.getElementsByName("status")[val-1].value='U';
    }
}

function SaveRecord()
{
  if(mandatory_Check("frmRespCreatUpdt"))
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
		   frmRespCreatUpdt.detailDataChanged.value = "true";
	}    

  frmRespCreatUpdt.headerPrimaryKey.value = "";

  if(iTr2 > 1)
  {
	  frmRespCreatUpdt.headerFields.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	  frmRespCreatUpdt.action = "../../../RespCrtSaveAction.do";
	  frmRespCreatUpdt.submit();
  }
  else 
  {
	  return false;
  }
}
 else
  {
	//disable();
    return false;
  }
}

function doQueryMode()
{
  document.all.screenMode.value = "Q";
  frmRespCreatUpdt.action="../../../RespCrtQueryMode.do";
  frmRespCreatUpdt.submit();
}

function doInsertMode()
{
  frmRespCreatUpdt.action="../../../RespCrtNewMode.do"
  frmRespCreatUpdt.submit();
}

function getHeaderRecord()
{
	frmRespCreatUpdt.detailDataChanged.value = "false";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmRespCreatUpdt.action="../../../RespCrtGetHeaderAction.do"
	frmRespCreatUpdt.submit();
}

function GetDetail()
{
	
	  document.all.screenMode.value='U'; 
	  frmRespCreatUpdt.headerPrimaryKey.value = "";
	  frmRespCreatUpdt.action="../../../RespCrtDetailAction.do";
	  frmRespCreatUpdt.submit();
	
}
 
function doRefresh()
{
  frmRespCreatUpdt.action="../../../RespCrtRefresh.do"
  frmRespCreatUpdt.submit();
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
    document.forms[0].action = "../../../RespCrtDeleteRowAction.do";
    document.forms[0].submit();
}

function JumpDetail()
{
    frmRespCreatUpdt.userPageRequested.value = 1*frmRespCreatUpdt.newPageRequested.value ;
    frmRespCreatUpdt.action = "../../../RespCrtNextDetailAction.do";
    frmRespCreatUpdt.submit();

}

function doBasePrevDetail()
{
    frmRespCreatUpdt.userPageRequested.value = 1*frmRespCreatUpdt.pageRequested.value - 1;
    frmRespCreatUpdt.action = "../../../RespCrtNextDetailAction.do";
    frmRespCreatUpdt.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmRespCreatUpdt.userPageRequested.value = 1*frmRespCreatUpdt.pageRequested.value + 1;
    frmRespCreatUpdt.action = "../../../RespCrtNextDetailAction.do";
    frmRespCreatUpdt.submit();
}

function doGetNextHeader()
{
	document.all.buttonFlag.value='';
    frmRespCreatUpdt.userPositionRequested.value = 1*frmRespCreatUpdt.positionRequested.value + 1;
    frmRespCreatUpdt.action="../../../RespCrtGetNextHeader.do";
    frmRespCreatUpdt.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmRespCreatUpdt.userPositionRequested.value = frmRespCreatUpdt.positionRequested.value - 1;
  frmRespCreatUpdt.action = "../../../RespCrtGetNextHeader.do";
  frmRespCreatUpdt.submit();
}

function JumpHeader()
{
    document.all.flagIda.value="false";
    document.all.flagCda.value="false";
    frmRespCreatUpdt.userPositionRequested.value = 1*frmRespCreatUpdt.newPositionRequested.value;
    frmRespCreatUpdt.action = "../../../RespCrtGetNextHeader.do";
    frmRespCreatUpdt.submit();
}
function upper(val)
{
   val.value=val.value.toUpperCase();
}
function lfnChanged(val)
{
    frmRespCreatUpdt.headerDataChanged.value = "true";
}

function displayDate(sysdate)
{
	var respDt=document.all.txtRespEndDt.value;
	if (!cmpDate(sysdate,respDt,0))
	  {
		alert("Responsibility End Date cannnot be less than System Date");
		document.all.txtRespEndDt.value="";
		return false;                      
	  }
	return true;
}

function displayScrDate(indx)
{
	var scrDt = document.getElementsByName("txtScrEndDt")[indx-1].value;
	var sysdat = document.all.systemDt.value;
	alert(sysdat + ' ' + scrDt)
	if (!cmpDate(sysdat,scrDt,0))
	  {
		alert("Screen End Date cannnot be less than System Date");
		document.all.txtScrEndDt.value="";
		return false;                      
	  }
	return true;
}

</script>
