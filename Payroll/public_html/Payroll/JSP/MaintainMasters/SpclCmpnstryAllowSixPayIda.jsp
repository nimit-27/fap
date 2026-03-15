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
  <BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
    <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

    <html:form  action="SpclCmpnstryAllowSixPay" name="frmSpclCmpnstryAllowSixPay" type="FCIPAY.Payroll.WEBTIER.Form.SpclCmpnstryAllowSixPayForm" scope="session">
      <bean:define id="ParentForm" name="frmSpclCmpnstryAllowSixPay" toScope="request" />
      <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
      <html:errors/>
      <html:hidden property="detailDataChanged" />
      <html:hidden property="headerFields" value="false" />
      <%! int i=0,j=0; %>
      <% i = 0;j=0; %>

      <TABLE cellSpacing=0 bgColor=#bdd0ef>
        <TR height=30>
          <TD  colSpan=11 class=mainHeader height=10>SPECIAL COMPENSATORY ALLOWANCE</TD>
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
                  <TD class=subHeader colspan=6>Header For Special Compensatory Allowance</TD>
                </TR>
                <TR>
                  <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>

                <tr height="15" >
                  <td colspan="2"></td>
                </tr>
         
            <tr>
				<td class="labelText" align="right" width="20%" >Allowance Type</td>
				<td align="left">
					<logic:equal property= "screenMode" name= "frmSpclCmpnstryAllowSixPay" value="U" >
						<html:select property="cboAllowType" styleClass="required" onchange="chk_Status_AreaType()" disabled="true">
						<logic:present name="AllowType">
							<html:optionsCollection label="label" value="value" property="allowanceList" name="AllowType"/>
						</logic:present>
						</html:select>
					</logic:equal> 
					<logic:notEqual property= "screenMode" name= "frmSpclCmpnstryAllowSixPay" value="U" >
						<html:select property="cboAllowType" styleClass="required" onchange="chk_Status_AreaType()">
						<logic:present name="AllowType">
							<html:optionsCollection label="label" value="value" property="allowanceList" name="AllowType"/>
						</logic:present>
						</html:select>
					</logic:notEqual>
				</td>
              
				<td class="labelText" align="right" width="20%" >Area Type</td>
				<td align="left">
					<logic:equal property= "screenMode" name= "frmSpclCmpnstryAllowSixPay" value="Q" >
						<html:select property="cboAreaType" disabled="true">
						<html:option value="" >-----------Please Select-----------</html:option>      
						<logic:present name="AreaType">
						<html:optionsCollection label="label" value="value" property="areaTypeList" name="AreaType"/>
						</logic:present>
						</html:select>
					</logic:equal> 
					<logic:notEqual property= "screenMode" name= "frmSpclCmpnstryAllowSixPay" value="Q" >
						<html:select property="cboAreaType" styleClass="required" disabled="true">
						<html:option value="" >-----------Please Select-----------</html:option>      
						<logic:present name="AreaType">
						<html:optionsCollection label="label" value="value" property="areaTypeList" name="AreaType"/>
						</logic:present>
						</html:select>
					</logic:notEqual>
				</td>
            </tr>
            
            <tr>
              <td class="labelText" align="right" width="20%" >Effective From</td>
              <td align="left">
				  <logic:equal property= "screenMode" name= "frmSpclCmpnstryAllowSixPay" value="Q">            
					  <html:text property="txtEffFrmDt" altKey="Payroll.MaintTransport.date" readonly="true" maxlength="10" size="16" />
					  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>" onclick="showCalendar('txtEffFrmDt',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
				  </logic:equal>
				  <logic:notEqual property= "screenMode" name= "frmSpclCmpnstryAllowSixPay" value="Q">
					<logic:equal property= "screenMode" name= "frmSpclCmpnstryAllowSixPay" value="N">
						  <html:text property="txtEffFrmDt" altKey="Payroll.MaintTransport.date"  styleClass="required" readonly="true" maxlength="10" size="16" />
						  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtEffFrmDt',this)" />
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmSpclCmpnstryAllowSixPay" value="N">
						  <html:text property="txtEffFrmDt" altKey="Payroll.MaintTransport.date"  styleClass="required" readonly="true" maxlength="10" size="16" />
						  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" />
					</logic:notEqual>
				  </logic:notEqual>
              </td>
              
              <td class="labelText" align="right" width="20%" >Effective To</td>
              <td align="left">
					<html:text  property="txtEffToDt" altKey="Payroll.MaintTransport.date" readonly="true" maxlength="10" size="16" onchange="return chkFromDt()" />              
					<img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>" onclick="showCalendar('txtEffToDt',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
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
							<td bgcolor="#4682B4" nowrap class=disTabText onclick=getTab("CDA")>CDA<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
							<td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
							<td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
							<td bgcolor="#76A2C7" nowrap class=actTabText>IDA<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
							<td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
							<td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
							<td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
						</TR> 
                      <TR height=10>
                   <!-- Detail table Container starts -->
                        <TD colspan=11>
                          <TABLE cellSpacing=0 cellPadding=0 border=1>
                            <TBODY>
                              <TR>
                                <TD >
                                  <DIV id=divDtlTable style="height:280px" >
  		                        	<!-- Detail table starts -->
                                    <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                      <TBODY>
                                        <TR height="22">
                                          <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                          <TD class=tableHeader width="15%">Category</TD>
                                          <TD class=tableHeader width="15%">Pay Band/Pay Scale</td>
                                          <TD class=tableHeader width="15%">Rate</td>
                                        </tr> 
                                        <logic:iterate id="spclCompAllowId" name="frmSpclCmpnstryAllowSixPay" property="lstSCADtlsIDA" type="FCIPAY.Payroll.UTILITY.SpclCmpnstryAllowSixPayBean" indexId="idx">
                                        <% ++i; %>
                                          <logic:notEqual name="spclCompAllowId" property="status" value="D" >
                                            <tr>
                                              <td align=center ><html:checkbox property="checked" name="frmSpclCmpnstryAllowSixPay" onclick="checkRecord();" value="false" /></td>
                                              
                                              <logic:equal name="spclCompAllowId" property="status" value="N" >
													<td>
														<html:select property="cboCatg" name="spclCompAllowId" style="width:98%" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" >
														<logic:present name="Category">
														<html:optionsCollection label="label" value="value" property="ctgryList" name="Category"/>
														</logic:present>
														</html:select>
													</td> 

													<td colspan="1">
														<html:text property="txtPayBand" name="spclCompAllowId" size="9" maxlength="10" styleClass="required" style="width:94%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
														<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode" onclick="ShowPayBand(this.alt);"  />
													</td> 
													<td>
														<html:text property="txtRate" name="spclCompAllowId" size="9" maxlength="10"  styleClass="required" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
													</td>
                                              </logic:equal>
                                              <logic:notEqual name="spclCompAllowId" property="status" value="N" >
													<td>
														<html:select property="cboCatg" name="spclCompAllowId" style="width:98%" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)">
														<logic:present name="Category">
														<html:optionsCollection label="label" value="value" property="ctgryList" name="Category"/>
														</logic:present>
														</html:select>
													</td> 

													<td colspan="1">
														<html:text property="txtPayBand" name="spclCompAllowId" size="9" maxlength="10" styleClass="required" style="width:94%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
														<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode" onclick="ShowPayBand(this.alt);"  />
													</td> 
													<td>
														<html:text property="txtRate" name="spclCompAllowId" size="9" maxlength="10"  styleClass="required" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
													</td>
											  </logic:notEqual>
                                              <html:hidden property="itemChecked" name="spclCompAllowId" />
                                              <html:hidden property="status" name="spclCompAllowId" />
                                              <html:hidden property="detailId" name="spclCompAllowId" />
											  <html:hidden property="txtGrade" name="spclCompAllowId" />
                                            </tr>
                                          </logic:notEqual>

                                          <logic:equal name="spclCompAllowId" property="status" value="D" >
                                            <tr>
                                              <td ><html:hidden property="checked" name="frmSpclCmpnstryAllowSixPay" value="notchecked" /></td>
                                              <td ><html:hidden property="txtPayBand" name="spclCompAllowId" /></td>
                                              <td ><html:hidden property="txtGrade" name="spclCompAllowId" /></td>
                                              <td ><html:hidden property="txtRate" name="spclCompAllowId" /></td>
                                              <td ><html:hidden property="cboCatg" name="spclCompAllowId" /></td>
                                              <html:hidden property="itemChecked" name="spclCompAllowId" />
                                              <html:hidden property="status" name="spclCompAllowId" />
                                              <html:hidden property="detailId" name="spclCompAllowId" />
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

      <html:hidden property="headerPrimaryKey" name="frmSpclCmpnstryAllowSixPay" value="Default" />
      <html:hidden property="screenMode" name="frmSpclCmpnstryAllowSixPay"  />
      <html:hidden property="txtPayScaleTyp" name="frmSpclCmpnstryAllowSixPay" value="IDA"  />
      <html:hidden name="frmSpclCmpnstryAllowSixPay" property="screenName" value="SpclCmpnstryAllowScreenIDA" />
      <html:hidden name="frmSpclCmpnstryAllowSixPay" property="forwardedPage" />
      <html:hidden property="buttonFlag" name="frmSpclCmpnstryAllowSixPay"  />
      <html:hidden property="pageRequested" name="frmSpclCmpnstryAllowSixPay" />
      <html:hidden property="userPageRequested" name="frmSpclCmpnstryAllowSixPay" />
      <html:hidden property="positionRequested" name="frmSpclCmpnstryAllowSixPay" />
      <html:hidden property="userPositionRequested" name="frmSpclCmpnstryAllowSixPay" />
	  <html:hidden property="lovKey" name="frmSpclCmpnstryAllowSixPay"  />
	  <html:hidden property="txtSearchFields" name="frmSpclCmpnstryAllowSixPay"  />
	  <html:hidden property="txtDisplayFields" name="frmSpclCmpnstryAllowSixPay"  />
	  <html:hidden property="txtIndex" name="frmSpclCmpnstryAllowSixPay"  />
	  <html:hidden property="txtInputField" name="frmSpclCmpnstryAllowSixPay"  />

      <html:hidden property="flagIda" name="frmSpclCmpnstryAllowSixPay"  />
      <html:hidden property="flagCda" name="frmSpclCmpnstryAllowSixPay"  />
	  <input type="hidden" name="queryParam" />

    </html:form>
  </body>
</html:html>
         
<script language="javascript">


function lfnLoad()
{
    mode1=document.all.flagCda.value;
    frmSpclCmpnstryAllowSixPay.butGetDetail.disabled="true";
    frmSpclCmpnstryAllowSixPay.butInsert.disabled="true";
    frmSpclCmpnstryAllowSixPay.butDelete.disabled="true";
    if(mode1 == 'true' || document.all.flagIda.value == 'true')
    {
        frmSpclCmpnstryAllowSixPay.headerPrimaryKey.disabled=true;
    }
    mode=document.all.screenMode.value;
    if(mode=='')
    {
        doQueryMode();
    }
    if (frmSpclCmpnstryAllowSixPay.screenMode.value == 'U')
    { 
    
          if(mode1=='false')
          {
              frmSpclCmpnstryAllowSixPay.butGetDetail.disabled="";
              frmSpclCmpnstryAllowSixPay.butInsert.disabled="true";
              frmSpclCmpnstryAllowSixPay.butDelete.disabled="true";
          }    
          if(mode1=='true')
          {
              frmSpclCmpnstryAllowSixPay.butGetDetail.disabled="true";
              frmSpclCmpnstryAllowSixPay.butInsert.disabled="";
              frmSpclCmpnstryAllowSixPay.butDelete.disabled="";
          }

        
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
    if (frmSpclCmpnstryAllowSixPay.screenMode.value == 'N')
    {
        frmSpclCmpnstryAllowSixPay.butInsert.disabled="";
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

function chk_Status_AreaType()
{
	var allowance = frmSpclCmpnstryAllowSixPay.cboAllowType.value;
	var areaType = frmSpclCmpnstryAllowSixPay.cboAreaType;

	if(allowance == 'EMPCOMP$RMTAREA') areaType.disabled = false; 
	else 
	{
		areaType.disabled = true; 
		areaType.selectedIndex = 0;
	}
}

	function ShowPayBand(i)
	{
		frmSpclCmpnstryAllowSixPay.lovKey.value = "SpclCompAllowPayBand" + "SpclCmpnstryAllowScreenCDA" + frmSpclCmpnstryAllowSixPay.screenMode.value;
		frmSpclCmpnstryAllowSixPay.txtDisplayFields.value = "txtPayBand";
		frmSpclCmpnstryAllowSixPay.txtSearchFields.value = "SpclCompAllow.PayBand,SpclCompAllow.StartBasic,SpclCompAllow.EndBasic";
		frmSpclCmpnstryAllowSixPay.queryParam.value = "txtPayScaleTyp="+frmSpclCmpnstryAllowSixPay.txtPayScaleTyp.value;
		frmSpclCmpnstryAllowSixPay.txtIndex.value = i;
		frmSpclCmpnstryAllowSixPay.txtInputField.value ="txtPayBand";
		showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmSpclCmpnstryAllowSixPay');
		return true;
	}
 
  function changed(val)
  {
    frmSpclCmpnstryAllowSixPay.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
  }

function changedDt(val)
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}

	var iTr2 = oTable.rows.length;
	if (iTr2 > 1){
	    frmSpclCmpnstryAllowSixPay.detailDataChanged.value = "true";
		if(document.getElementsByName("status")[val-1].value=='Q')
		{
		  document.getElementsByName("status")[val-1].value='U';
		}

		flgResult=confirm("This will make the record obsolete ");
		if(!flgResult)
		{
			 document.getElementById("txtEffToDt").value = '';
		}
	}
}

function changeFrDt(val)
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}

    frmSpclCmpnstryAllowSixPay.detailDataChanged.value = "true";
	var iTr2 = oTable.rows.length;
	if (iTr2 > 1){
		if(document.getElementsByName("status")[val-1].value=='Q')
		{
		  document.getElementsByName("status")[val-1].value='U';
		}
	}
}

function chkFromDt(i)
{
	var fromDt=document.getElementById("txtEffFrmDt").value;
	var toDt=document.getElementById("txtEffToDt").value; 
	if(!cmpSysDate(toDt,0))
	{ 
		document.getElementById("txtEffToDt").value="";
		return false;
	}

	if (!cmpDate(fromDt,toDt,0))
	{
		alert("To Date must be greater than From Date");
		document.getElementById("txtEffToDt").value="";
		return false;                      
	}

	changedDt(1);
}

  function doBaseAddRow()
  {
    if(mandatory_Check("frmSpclCmpnstryAllowSixPay"))
    {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }

	  frmSpclCmpnstryAllowSixPay.cboAreaType.disabled = false;
      var iTr2 = oTable.rows.length;
      document.all.screenMode.value='U';
      document.all.flagCda.value=true;
      document.forms[0].action = "../../../SpclCmpnstryAllowSixPayIdaAddRowAction.do";
      document.forms[0].submit();
    }
    else
    {
      return false;
    }
  }

  function SaveRecord()
  {
		if(mandatory_Check("frmSpclCmpnstryAllowSixPay"))
		{
			//if(validateRecords()!=true) return false;
			var oTable = document.getElementById("Detail");
		if(oTable == null)
		{
			return;
		}
		var iTr2 = oTable.rows.length;
		var i = 0;

        frmSpclCmpnstryAllowSixPay.cboAreaType.disabled = false;
		frmSpclCmpnstryAllowSixPay.headerFields.value = "false";
		frmSpclCmpnstryAllowSixPay.screenMode.value = "U";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
		frmSpclCmpnstryAllowSixPay.action = "../../../SpclCmpnstryAllowSixPayIdaSaveAction.do";
		// frmMaintHraRate.totalDetailRecord.value=parseInt(iTr2)-1;
		frmSpclCmpnstryAllowSixPay.submit();
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
    frmSpclCmpnstryAllowSixPay.action="../../../SpclCmpnstryAllowSixPayIdaQueryMode.do"
    frmSpclCmpnstryAllowSixPay.submit();
  }

  function doInsertMode()
  {
    frmSpclCmpnstryAllowSixPay.action="../../../SpclCmpnstryAllowSixPayIdaNewMode.do"
    frmSpclCmpnstryAllowSixPay.submit();
  }

  function GetDetail()
  {
    frmSpclCmpnstryAllowSixPay.cboAreaType.disabled = false;
    document.all.screenMode.value='U';
    document.all.flagCda.value=true;
    frmSpclCmpnstryAllowSixPay.action="../../../SpclCmpnstryAllowSixPayIdaDetailAction.do"
    frmSpclCmpnstryAllowSixPay.submit();
  }

  function doRefresh()
  {
    frmSpclCmpnstryAllowSixPay.action="../../../SpclCmpnstryAllowSixPayIdaRefresh.do"
    frmSpclCmpnstryAllowSixPay.submit();
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
          frmSpclCmpnstryAllowSixPay.detailDataChanged.value = "true";
        }
        else
          strRecList=strRecList+(i+1)+",";
      }
    }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
	return;
  }
   
    document.forms[0].action = "../../../SpclCmpnstryAllowSixPayIdaDeleteRowAction.do";
    document.forms[0].submit();  
  }

  function getTab(arg)
  {
    //document.all.screenMode.value="Q";
    //document.all.txtEffDt.value="";
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../SpclCmpnstryIdaTabAction.do";
    document.forms[0].submit();
  }
 
  function JumpDetail()
  {
    frmSpclCmpnstryAllowSixPay.cboAreaType.disabled = false;
    frmSpclCmpnstryAllowSixPay.userPageRequested.value = 1*frmSpclCmpnstryAllowSixPay.newPageRequested.value ;
    frmSpclCmpnstryAllowSixPay.action = "../../../SpclCmpnstryAllowSixPayIdaDetailAction.do";
    frmSpclCmpnstryAllowSixPay.submit();
  }
  
 function getHeaderRecord()
{
    frmSpclCmpnstryAllowSixPay.cboAreaType.disabled = false;
    document.all.flagCda.value="false";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmSpclCmpnstryAllowSixPay.action="../../../SpclCmpnstryAllowSixPayIdaGetHeaderAction.do"
    frmSpclCmpnstryAllowSixPay.submit();
}

function doGetNextHeader()
{ 
    frmSpclCmpnstryAllowSixPay.cboAreaType.disabled = false;
    document.all.flagCda.value="false";
    document.all.flagIda.value="false";
    frmSpclCmpnstryAllowSixPay.userPositionRequested.value = 1*frmSpclCmpnstryAllowSixPay.positionRequested.value + 1;
    frmSpclCmpnstryAllowSixPay.action="../../../SpclCmpnstryAllowSixPayIdaGetNextHeader.do";
    frmSpclCmpnstryAllowSixPay.submit();
}

function PrevHeader()
{
    frmSpclCmpnstryAllowSixPay.cboAreaType.disabled = false;
    document.all.flagCda.value="false";
    document.all.flagIda.value="false";
    frmSpclCmpnstryAllowSixPay.userPositionRequested.value = 1*frmSpclCmpnstryAllowSixPay.positionRequested.value - 1;
    frmSpclCmpnstryAllowSixPay.action = "../../../SpclCmpnstryAllowSixPayIdaGetNextHeader.do";
    frmSpclCmpnstryAllowSixPay.submit();
}

function JumpHeader()
{
    frmSpclCmpnstryAllowSixPay.cboAreaType.disabled = false;
    document.all.flagCda.value="false";
    document.all.flagIda.value="false";
    frmSpclCmpnstryAllowSixPay.userPositionRequested.value = 1*frmSpclCmpnstryAllowSixPay.newPositionRequested.value;
    frmSpclCmpnstryAllowSixPay.action = "../../../SpclCmpnstryAllowSixPayIdaGetNextHeader.do";
    frmSpclCmpnstryAllowSixPay.submit();
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
