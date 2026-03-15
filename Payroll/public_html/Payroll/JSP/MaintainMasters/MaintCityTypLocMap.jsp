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


<html:form  action="MaintCityLocMap" name="frmMaintCityLocMap" type="FCIPAY.Payroll.WEBTIER.Form.MaintCityLocMapForm" scope="session">
<bean:define id="ParentForm" name="frmMaintCityLocMap" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN CITY TYPE LOCATION MAPPING</TD>
  </TR>

<!--Added by Swapnendu Dt 20- Aug 2010 -->
<tr>
	<tr><td colspan=2 height=10></td></tr>
	<td class="labelText"  width="20%" ><bean:message key="Payroll.MaintCityTypLocMap.Location" /></td>
	<td width="30%"><html:text  property="txtLocidSrch" altKey="" maxlength="10" size="10" styleClass="required" readonly="true" />
	<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovLocation();" >
	&nbsp;&nbsp;<html:text  property="txtLocSrch" name="frmMaintCityLocMap" maxlength="10" size="26" styleClass="locked" readonly="true" /></td>
</tr>
<!--Added by Swapnendu Dt 20- Aug 2010 -->



 <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Mapping Information<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                              <TD class=tableHeader width="4%">Location</TD>
                                              <TD class=tableHeader width="3%">HRA City Type</TD>
                                              <TD class=tableHeader width="3%">Remote Area Type</td>
                                              <TD class=tableHeader width="3%">Transport City Type</td>	  <!--Added by Swapnendu Dt 27-Aug 2010-->
                                              <TD class=tableHeader width="3%">Population Type</td>
                                              <TD class=tableHeader width="3%">MGW Type</TD>
                                              <td class=tableHeader width="2%">Effective From</td> 
                                              <td class=tableHeader width="2%">Effective To</td>   <!--Added by Swapnendu Dt 27-Aug 2010-->
                                      </TR>    

                         <logic:iterate id="mapInfo" name="frmMaintCityLocMap" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintCityLocMapBean" >
                              <% ++i; %>
                                <logic:notEqual name="mapInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>

                                      <td align=center ><html:checkbox property="checked" name="frmMaintCityLocMap" onclick="checkRecord();" value="false" /></td>
                                      <logic:equal name="mapInfo" property="status" value="N" >

										  <td ><html:text property="txtLoc" name="mapInfo" size="9" styleClass="locked" readonly="true" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="checkDuplicacy('txtLocId',this.alt); changed(this.alt)" />
                                           <!--img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtPayCode" onclick="ShowLovLoc(this.alt);" /-->
                                           <html:hidden property="txtLocId" name="mapInfo" />
                                          </td>  
                  
                                           <td colspan="1" align="center"><html:select property="txtCityTyp" name="mapInfo" styleClass="required" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt)"  style="WIDTH: 70%"  >
                                              <html:option value="" >-----Please Select-----</html:option>      
                                              <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="cityTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>

                                          <td colspan="1" align="center"><html:select property="txtAreaTyp" name="mapInfo" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 80%"  >
                                              <html:option value="" >-----Please Select-----</html:option>      
                                              <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="areaTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>
<!--Added By Swapnendu Dt 27-aug 2010-->
										  <td colspan="1" align="center"><html:select property="txtTranCityTyp" name="mapInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                              <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="tranCityTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>
<!--Added By Swapnendu Dt 27-aug 2010-->
                                         
                                          <td colspan="1" align="center"><html:select property="txtPopTyp" name="mapInfo" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                                <html:option value=""><bean:message key="pr.pleaseSelect" /></html:option>
                                              <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="popTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>
										
                                           <td colspan="1" align="center"><html:select property="txtMgwCityTyp" name="mapInfo" styleClass="optional" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt)"  style="WIDTH: 70%"  >
                                              <html:option value="" >-----Please Select-----</html:option>      
                                              <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="mgwCityTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>
                                         
                                           <td align="center"><html:text property="txtFrom" name="mapInfo" size="9" styleClass="required" readonly="true" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="chkFromDt(this.alt)" />
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" onclick="showCalendar('txtFrom',this)" />
                                           </td>
<!--Added By Swapnendu Dt 27-aug 2010-->
										   <td align="center"><html:text property="txtTo" name="mapInfo" size="9" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" readonly="true" onchange="chkToDt(this.alt)"  />
                                           <img src="..\INCLUDES\IMAGES\cal.gif" name="imgTxtTo"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=i-1 %>" onclick="showCalendar('txtTo',this)" />
                                           </td>
<!--Added By Swapnendu Dt 27-aug 2010-->
                                        </logic:equal>
                                           
                                        <logic:notEqual name="mapInfo" property="status" value="N" >
                                           <td ><html:text property="txtLoc" name="mapInfo" size="9" styleClass="locked" readonly="true" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="checkDuplicacy('txtLocId',this.alt); changed(this.alt)" />
                                           <!--img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtPayCode"  /-->
                                           <html:hidden property="txtLocId" name="mapInfo" />
                                          </td>  

                                           <td colspan="1" align="center"><html:select property="txtCityTyp" name="mapInfo"  styleClass="required" disabled="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 70%"  >
                                              <html:option value="" >-----Please Select-----</html:option>      
                                              <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="cityTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>

                                          <td colspan="1" align="center"><html:select property="txtAreaTyp" name="mapInfo"  disabled="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 80%"  >
                                              <html:option value="" >-----Please Select-----</html:option>      
                                              <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="areaTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>
<!--Added By Swapnendu Dt 27-aug 2010-->
										  <td colspan="1" align="center"><html:select property="txtTranCityTyp" name="mapInfo" styleClass="required" disabled="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                              <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="tranCityTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>
<!--Added By Swapnendu Dt 27-aug 2010-->
                                          <td colspan="1" align="center"><html:select property="txtPopTyp" name="mapInfo"  alt="<%=String.valueOf(i)%>" disabled="true" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                                <html:option value=""><bean:message key="pr.pleaseSelect" /></html:option>
                                               <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="popTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>

                                           <td colspan="1" align="center"><html:select property="txtMgwCityTyp" name="mapInfo" styleClass="optional" alt="<%=String.valueOf(i)%>" disabled="true" onchange="return changed(this.alt)"  style="WIDTH: 70%"  >
                                              <html:option value="" >-----Please Select-----</html:option>      
                                              <logic:present name="CityLocMapCombo">
                                                <html:optionsCollection label="label" value="value" property="mgwCityTypList" name="CityLocMapCombo"/>
                                              </logic:present>
                                            </html:select></td>
                                        
										   <td align="center"><html:text property="txtFrom" name="mapInfo" size="9" styleClass="required" readonly="true" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="chkFromDt(this.alt)" />
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i)%>"  />
                                           </td>
<!--Added By Swapnendu Dt 27-aug 2010-->
										   <td align="center">
										   <logic:equal name="mapInfo" property="txtTo" value="" >
												<html:text property="txtTo" name="mapInfo" size="9" readonly="true" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="chkToDt(this.alt)" />
										   </logic:equal>
										   <logic:notEqual name="mapInfo" property="txtTo" value="" >
												<html:text property="txtTo" name="mapInfo" size="9" readonly="true" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="chkToDt(this.alt)" styleClass="locked" />
										   </logic:notEqual> 

										   <logic:equal name="frmMaintCityLocMap" property="addBtnFlag" value="" >
											   <img src="..\INCLUDES\IMAGES\cal.gif" name="imgTxtTo" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i)%>"  />
										   </logic:equal>
										   <logic:equal name="frmMaintCityLocMap" property="addBtnFlag" value="A" >
											   <img src="..\INCLUDES\IMAGES\cal.gif" name="imgTxtTo" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i)%>" />
										   </logic:equal>
										   <logic:equal name="frmMaintCityLocMap" property="addBtnFlag" value="D" >
											   <img src="..\INCLUDES\IMAGES\cal.gif" name="imgTxtTo" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i)%>" onclick="showCalendar('txtTo',this.alt)" />
										   </logic:equal>
                                           </td>
<!--Added By Swapnendu Dt 27-aug 2010-->
                                       </logic:notEqual>
                                       <!--html:hidden property="txtTo" name="mapInfo" /--> 
                                       <html:hidden property="itemChecked" name="mapInfo" />
                                       <html:hidden property="status" name="mapInfo" />
                                       <html:hidden property="detailId" name="mapInfo" />
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="mapInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintCityLocMap" value="notchecked" /></td>
                                       <td ><html:hidden property="txtLoc" name="mapInfo" /></td>
                                       <td ><html:hidden property="txtLocId" name="mapInfo" /></td>
                                       <td ><html:hidden property="txtCityTyp" name="mapInfo" /></td>
                                       <td ><html:hidden property="txtAreaTyp" name="mapInfo" /></td>
                                       <td ><html:hidden property="txtPopTyp" name="mapInfo" /></td>
                                       <td ><html:hidden property="txtTranCityTyp" name="mapInfo" /></td>
                                       <td ><html:hidden property="txtFrom" name="mapInfo" /></td> 
                                       <td ><html:hidden property="txtMgwCityTyp" name="mapInfo" /></td> 
                                       <html:hidden property="txtTo" name="mapInfo" />
                                       <html:hidden property="itemChecked" name="mapInfo" />
                                       <html:hidden property="status" name="mapInfo" />
                                       <html:hidden property="detailId" name="mapInfo" />
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
<html:hidden property="headerPrimaryKey" name="frmMaintCityLocMap" />
<html:hidden property="loginLocCode" name="frmMaintCityLocMap"  />
<html:hidden property="screenMode" name="frmMaintCityLocMap"  />
<html:hidden name="frmMaintCityLocMap"  property="screenName" value="CityLocMapScreen" />
<html:hidden name="frmMaintCityLocMap"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmMaintCityLocMap"  />
<html:hidden property="lovKey" name="frmMaintCityLocMap"  />
<html:hidden property="txtFields" name="frmMaintCityLocMap"  />   
<html:hidden property="txtSearchFields" name="frmMaintCityLocMap"  />
<html:hidden property="txtDisplayFields" name="frmMaintCityLocMap"  />
<html:hidden property="txtIndex" name="frmMaintCityLocMap"  />
<html:hidden property="txtInputField" name="frmMaintCityLocMap"  />
<html:hidden property="userPageRequested" name="frmMaintCityLocMap"  />
<html:hidden property="pageRequested" name="frmMaintCityLocMap"  />
<html:hidden property="positionRequested" name="frmMaintCityLocMap" />
<html:hidden property="userPositionRequested" name="frmMaintCityLocMap" />
<html:hidden property="totalDetailRecord" name="frmMaintCityLocMap"  />

<!--html:hidden property="headerMode" name="frmMaintCityLocMap" /-->
<!--html:hidden property="headerMode1" name="frmMaintCityLocMap" /-->


<html:hidden property="addBtnFlag" name="frmMaintCityLocMap"  />
<html:hidden property="exeBtnFlag" name="frmMaintCityLocMap"  />
<html:hidden property="imgTxtTo" name="frmMaintCityLocMap" />

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
 if(screenmode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }
  if(screenmode=='U')
  {
	  setLocation();
	  enableEndDt();
      document.all.butGetDetail.disabled="disabled";
      if (document.getElementById("exeBtnFlag").value == "E") {
		  document.all.butInsert.disabled="true";
		  document.all.butGetDetail.disabled="";
	  }
	  else {
		  document.all.butInsert.disabled="";
		  document.all.butGetDetail.disabled="true";
	  }
  }
  if(screenmode=='Q')
  {
	 document.getElementById("exeBtnFlag").value = "";
     document.all.butInsert.disabled="disabled";
  } 
  document.all.butDelete.disabled="disabled";
  
  menuHandling(screenmode);

  document.all.butInsertMode.disabled="disabled";
  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
  
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

//Added by Swapnendu Dt 15 -Sep 2010 Start
function setLocation() {
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	if(iTr2>1) {
		var i=<%=i%>;
		var loc=document.getElementById("txtLocSrch").value;
		var locid=document.getElementById("txtLocidSrch").value;
		document.getElementsByName("txtLoc")[i-1].value=loc;
		document.getElementsByName("txtLocId")[i-1].value=locid;
	}
}

function enableEndDt() {
	var addBtn = document.getElementById("addBtnFlag").value;
	if(addBtn == "") {
		var oTable = document.getElementById("Detail");
		if(oTable == null)
		{
			return;
		}
		var iTr2 = oTable.rows.length;
		var indx = <%=i-1%>;
		if(iTr2 > 1) {
			var endDt = document.getElementsByName("txtTo")[indx];
			if(endDt.value == "") {
				//endDt.readOnly=false;
				var imgTxtTo =  document.getElementsByName("imgTxtTo")[indx]; 
				imgTxtTo.onclick = function() {showCalendar(endDt,this);}; 
			}
		}
	}
}

function chkEndDtStatus(){
	var btnFlg = document.getElementById("addBtnFlag").value;
	if(btnFlg == "" ){
		var oTable = document.getElementById("Detail");
		if(oTable == null)
		{
			return;
		}
		var iTr2 = oTable.rows.length;
		if(iTr2 > 1){
			var temp = <%=j%>;
			var temp1 = <%=i%>;  
			var indx = <%=i-1%>
			if(temp < temp1) indx = <%=j-1%>;

			var prvEndDt = document.getElementsByName("txtTo")[indx].value;
			if(prvEndDt!=""){
				return true;
			}else{
				alert("Please End Date the Previous Record");
				disable();
				document.getElementsByName("txtTo")[indx].focus();
				return false;
			}
		}else{
			return true;
		}
	}else{
		return true;
	}
}

//Added by Swapnendu Dt 15 -Sep 2010 End

function changed(val)
{
   frmMaintCityLocMap.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[val-1].value == 'Q')
		document.getElementsByName("status")[val-1].value = 'U';
}

function changedDt(val)
{

   frmMaintCityLocMap.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[val-1].value == 'Q')
		document.getElementsByName("status")[val-1].value = 'U';
   flgResult=confirm("This will make the record obsolete ");
   if(!flgResult)
   {
        document.getElementsByName("txtTo")[val-1].value = '';
   }
}
    
function doBaseAddRow()
{
  enable();
  if(mandatory_Check("frmMaintCityLocMap"))
  {
	var addBtn = document.getElementById("addBtnFlag");
	if(addBtn.value!="A"){
		if(chkEndDtStatus()){
			addBtn.value="A";
			document.forms[0].action = "../../../CityLocMapAddRowAction.do";
			document.forms[0].submit();
		}
	}else{
		alert("Save The Record First.");
		disable();
		return false;
	}
  }
  else
  {
	  disable();
	  return false;
  }
}

function SaveRecord()
{
  enable();
  if(mandatory_Check("frmMaintCityLocMap"))
  { 
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  frmMaintCityLocMap.detailDataChanged.value = "true";
  frmMaintCityLocMap.headerFields.value = "false";
  document.getElementById("addBtnFlag").value="";
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintCityLocMap.action = "../../../CityLocMapSaveAction.do";
  frmMaintCityLocMap.submit();
}
 else
  {
	disable();
    return false;
  }
}


function doQueryMode()
{
  
  frmMaintCityLocMap.action="../../../CityLocMapQueryAction.do";
  frmMaintCityLocMap.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value='';
  document.all.headerMode.value  = "N";
  document.all.headerMode1.value  = "N";
  document.all.screenMode.value = "N";

  frmMaintCityLocMap.action="../../../CityLocMapNewMode.do"
  frmMaintCityLocMap.submit();
}

//added by swapnendu Dt 16 sep-2010 (Start)
function getHeaderRecord()
{
	document.getElementById("exeBtnFlag").value = "E";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmMaintCityLocMap.action="../../../CityLocMapHeaderAction.do"
	frmMaintCityLocMap.submit();
}
//added by swapnendu Dt 16 sep-2010 (End)

function GetDetail()
{
	var locid=document.getElementById("txtLocidSrch");
	
	if(locid.value!=""){
		  document.all.screenMode.value='U'; 
		  frmMaintCityLocMap.headerPrimaryKey.value = frmMaintCityLocMap.txtLocidSrch.value ;  
		  frmMaintCityLocMap.action="../../../CityLocMapGetDetailAction.do";
		  frmMaintCityLocMap.submit();
	}else{
		alert("Enter Location.");
		locid.focus();
		return false;
	}
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
    document.getElementsByName("txtCityTyp")[i].disabled="";
    document.getElementsByName("txtAreaTyp")[i].disabled="";
    document.getElementsByName("txtPopTyp")[i].disabled="";
	document.getElementsByName("txtTranCityTyp")[i].disabled="";
	document.getElementsByName("txtMgwCityTyp")[i].disabled="";
  }
 }

function disable(){
	 var oTable = document.getElementById("Detail");
	  if(oTable == null)
	  {
		return;
	  }
	  var iTr2 = oTable.rows.length;
	  var i = 0;
	  var addBtn = document.getElementById("addBtnFlag").value;
	  if (addBtn == "" || addBtn == "D") {
		  for(i=0; i < iTr2 -1; i++)
		  {
			document.getElementsByName("txtCityTyp")[i].disabled=true;
			document.getElementsByName("txtAreaTyp")[i].disabled=true;
			document.getElementsByName("txtPopTyp")[i].disabled=true;
			document.getElementsByName("txtTranCityTyp")[i].disabled=true;
			document.getElementsByName("txtMgwCityTyp")[i].disabled=true;
		  }
	  }
	  else if (addBtn == "A") {
		  for(i=0; i < iTr2 -2; i++)
		  {
			document.getElementsByName("txtCityTyp")[i].disabled=true;
			document.getElementsByName("txtAreaTyp")[i].disabled=true;
			document.getElementsByName("txtPopTyp")[i].disabled=true;
			document.getElementsByName("txtTranCityTyp")[i].disabled=true;
			document.getElementsByName("txtMgwCityTyp")[i].disabled=true;
		  }
	  }
 }
 
function doRefresh()
{
  frmMaintCityLocMap.action="../../../CityLocMapRefresh.do"
  frmMaintCityLocMap.submit();
}
     
function doBaseDelRow()
{
  enable();
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
      if(document.getElementsByName("detailId")[i].value=='')
        document.getElementsByName("itemChecked")[i].value = "Y";
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }   
  
  document.getElementById("addBtnFlag").value="D";
  document.forms[0].action = "../../../CityLocMapDeleteRowAction.do";
  document.forms[0].submit();
}

function ShowLovLoc(i)
{
   if(document.getElementsByName("status")[i-1].value=='N')
   {
     frmMaintCityLocMap.lovKey.value = "LocDtls" +frmMaintCityLocMap.screenName.value + frmMaintCityLocMap.screenMode.value;
     frmMaintCityLocMap.txtDisplayFields.value = "txtLocId,txtLoc";
     frmMaintCityLocMap.txtIndex.value=i-1;
     frmMaintCityLocMap.txtInputField.value="txtLoc";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintCityLocMap');
     frmMaintCityLocMap.detailDataChanged.value = "true";
    }
   return true;
}

function checkDuplicacy(that,rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName("txtLoc")[rInd-1].value;
  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(rInd != ind)
    {
      oldComb = document.getElementsByName("txtLoc")[ind-1].value;
      if(oldComb.toUpperCase()==newComb.toUpperCase())
      {
        var response=confirm("Record Already Exists.. Do you still want to continue ?");
        if(response==false)
        {
          document.getElementsByName(that)[rInd-1].value="";
          document.getElementsByName("txtLoc")[rInd-1].value="";
        }
      }
    }
  }
  return true;
}

function chkFromDt(i)
{
  var fromDt=document.getElementsByName("txtFrom")[i-1].value;
  if(!cmpSysDate(fromDt,0))
    { 
      document.getElementsByName("txtFrom")[i-1].value="";
      return false;
    }
	setEndDt(i);
}

function chkToDt(i)
{
  var fromDt=document.getElementsByName("txtTo")[i-1].value;
  if(!cmpSysDate(fromDt,0))
    { 
      document.getElementsByName("txtTo")[i-1].value="";
      return false;
    }

	comprDate(i);
}

function comprDate(indx){
	var frmDt = document.getElementsByName("txtFrom")[indx-1].value;
	if(frmDt != ""){
		var toDt = document.getElementsByName("txtTo")[indx-1].value;
		if (!cmpDate(frmDt,toDt,0)){
			alert("Effective to must be greater than effective from.");
			document.getElementsByName("txtTo")[indx-1].value="";
			return false;
		}
	}else{
		alert("Enter Effective From Date First");
		document.getElementsByName("txtTo")[indx-1].value="";
		document.getElementsByName("txtFrom")[indx-1].focus();
		return false;
	}
}

 function setEndDt(rInd)
 {
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  if(iTr2 > 2){
		var btnFlg = document.getElementById("addBtnFlag").value;
		var temp = <%=j%>;
		var temp1 = <%=i%>;  
		//alert(temp+"=="+temp1)
		var frmDt = document.getElementsByName("txtFrom")[rInd-1].value;
		if(temp < temp1) rInd = <%=j%>;
		var prvToDt = document.getElementsByName("txtTo")[rInd-2].value;
		if (prvToDt == frmDt) {
			alert("Current Effective From Must Be Greater Than Previous Effective To .");
			document.getElementsByName("txtFrom")[temp1-1].value = "";
			return false;
		} else {
			if (!cmpDate(prvToDt,frmDt,0)){
				alert("Current Effective From Must Be Greater Than Previous Effective To .");
				document.getElementsByName("txtFrom")[temp1-1].value = "";
				return false;
			}
		}
  }
  else  return ;
}

 function JumpDetail()
 {
    frmMaintCityLocMap.userPageRequested.value = 1*frmMaintCityLocMap.newPageRequested.value ;
    frmMaintCityLocMap.action = "../../../CityLocMapNextDetailAction.do";
    frmMaintCityLocMap.submit();

 }

function doBasePrevDetail()
{
    frmMaintCityLocMap.userPageRequested.value = 1*frmMaintCityLocMap.pageRequested.value - 1;
    frmMaintCityLocMap.action = "../../../CityLocMapNextDetailAction.do";
    frmMaintCityLocMap.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmMaintCityLocMap.userPageRequested.value = 1*frmMaintCityLocMap.pageRequested.value + 1;
    frmMaintCityLocMap.action = "../../../CityLocMapNextDetailAction.do";
    frmMaintCityLocMap.submit();
}

function ShowLovLocation(){
	if(frmMaintCityLocMap.screenMode.value == "Q"){
		frmMaintCityLocMap.lovKey.value = "Location" +frmMaintCityLocMap.screenName.value + frmMaintCityLocMap.screenMode.value;
		frmMaintCityLocMap.txtSearchFields.value = "Payroll.MaintCityTypLocMap.Location,Payroll.MaintCityTypLocMap.LocDesc";
		frmMaintCityLocMap.txtDisplayFields.value = "txtLocidSrch,txtLocSrch";
		showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmMaintCityLocMap');
		return true;
	} else {
		alert("Go to Query Mode .");
		return false;
	}
}

//added by swapnendu Dt 17 sep-2010 (Start)
function doGetNextHeader()
{
	document.all.buttonFlag.value='';
    frmMaintCityLocMap.userPositionRequested.value = 1*frmMaintCityLocMap.positionRequested.value + 1;  
    frmMaintCityLocMap.action="../../../CityLocMapGetNextHeader.do";
    frmMaintCityLocMap.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmMaintCityLocMap.userPositionRequested.value = frmMaintCityLocMap.positionRequested.value - 1;
  frmMaintCityLocMap.action = "../../../CityLocMapGetNextHeader.do";
  frmMaintCityLocMap.submit();
}

//added by swapnendu Dt 17 sep-2010 (End)
</script>

