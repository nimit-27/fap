<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
    <html:base/>
    <TITLE><bean:message key="pay.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>        
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
  </HEAD>

  <BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
    <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />    

    <html:form  action="EnqPayImgBase" name="frmEnqPayImg" type="FCIPAY.Payroll.WEBTIER.Form.EnqPayImgForm" scope="session">
    <bean:define id="ParentForm" name="frmEnqPayImg" toScope="request" />
    <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
    <html:errors/>
    <html:hidden property="detailDataChanged" />
    <html:hidden property="headerFields" value="false" />
    <%! int i=0,j=0; %>
    <% i = 0;j=0; %>
    <!--Table 10 starts-->
    <TABLE cellSpacing=0 bgColor="#bdd0ef">
      <TR height=30>
        <TD  colSpan=11 class=mainHeader height=10>ENQUIRE PAY IMAGE</TD>
      </TR>
      <tr height="10">
        <td class=userText colspan="11">
        </td>
      </tr>
    </TABLE>
    <!--Table 10 ends-->
    <!--container table starts -->
    <div id=divDtlTable  style="height:600px" >
      <!--Table 11 starts-->
      <TABLE cellSpacing=0 cellPadding=0 border=0 >
        <TBODY>
          <TR>
            <TD>     
              <!-- Body table Starts -->
              <!--Table 20 starts-->
              <TABLE cellSpacing=0 cellPadding=0 border = 0>
              <!--pay Scale Header Row Starts -->
                <TR>
                  <TD class=subHeader colspan=6> PAY IMAGE HEADERS </TD>
                </TR>
                <TR>
                  <TD colspan=6 bgColor="#4682b4"><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>
                <tr height="5" >
                  <td colspan="6"></td>
                </tr>
                <TR>                
                  <TD class=labelText width="15%"><bean:message key="Payroll.EnqPayImg.txtEmpNo" /></TD>
                  <td align="left" width="55%">
				  <logic:equal name="frmEnqPayImg" property="screenMode" value="Q"> 
				  <html:text  property="txtEmpNo" altKey="pay.EnqPayImg.txtEmpNo" maxlength="10" size="23" styleClass="required"
				    onchange=
                      "if(!(checkEmployee(frmEnqPayImg.txtEmpNo.value,frmEnqPayImg.loginLocCode.value)))
                      {
                        frmEnqPayImg.txtEmpNo.value='';
                      }"
					/>
				  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick=" return ShowLovEmpNo();">&nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="32" styleClass="locked" readonly="true" />
				  </logic:equal>
				  <logic:notEqual name="frmEnqPayImg" property="screenMode" value="Q">
				  <html:text  property="txtEmpNo" altKey="pay.EnqPayImg.txtEmpNo" maxlength="10" size="23" styleClass="locked" readonly="true" />
				  </logic:notEqual>
				  </td>

                  <td class=labelText width="8%"><bean:message key="Payroll.EnqPayImg.lstCadre" /></td>
                  <td width="22%">
                    <html:text  property="lstGroup" altKey="pay.EnqPayImg.lstCadre" maxlength="10" size="23" styleClass="locked" readonly="true" />                    
                  </td>                                   
                </TR> 

                <TR> 
                  <td class=labelText width="15%" ><bean:message key="Payroll.EnqPayImg.lstCateg" /> </td>
                  <td width="55%">
                    <html:text  property="lstCateg" altKey="pay.EnqPayImg.lstCateg" maxlength="10" size="23" styleClass="locked" readonly="true" />                                                         
                  </td>
                  <TD class=labelText  width="8%"><bean:message key="Payroll.EnqPayImg.txtDesig" /></TD>
                  <td align="left" width="22%">
                    <html:text  property="txtDesig" altKey="pay.EnqPayImg.txtDesig" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </td>
                </TR>    
				<TR>
                  <TD class=labelText width="15%" ><bean:message key="Payroll.EnqPayImg.txtBasic" /></TD>
                  <td align="left" width="55%">
                    <html:text  property="txtCurrBas" altKey="Payroll.EnqPayImg.txtBasic" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </td>
				</TR>
                
                  <html:hidden  property="txtrs1"  />                              
                  <html:hidden  property="txtrs2" />                              


                <tr height = 5><td></td></tr>  

                <TR>
					<td width="15%" class=labelText><bean:message key="Payroll.LPC.FrYYMM" /></td>
					<td width="55%" align="left">
 				    <logic:equal name="frmEnqPayImg" property="screenMode" value="Q"> 
						<html:text  property="txtYtm" styleClass = "required" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" onblur="checkYYYYMM(this);" />
						<!--<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtYtm"  onclick=" return  ShowLovYYMM()">-->
				    </logic:equal>
				    <logic:notEqual name="frmEnqPayImg" property="screenMode" value="Q">
						<html:text  property="txtYtm" styleClass = "locked" readonly="true" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" onblur="checkYYYYMM(this);" />
				    </logic:notEqual>
					</td>
					<td width="15%" class=labelText><bean:message key="Payroll.LPC.ToYYMM" /></td>
					<td width="22%" align="left">
				    <logic:equal name="frmEnqPayImg" property="screenMode" value="Q"> 
						<html:text property="txtUptoYYMM" styleClass = "required" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" onblur="checkYYYYMM(this);" />
     				</logic:equal>
				    <logic:notEqual name="frmEnqPayImg" property="screenMode" value="Q"> 
						<html:text property="txtUptoYYMM" styleClass = "locked" readonly="true" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" onblur="checkYYYYMM(this);" />
     				</logic:notEqual>
					</td>
					<TD align="center"><html:button value='   Get Detail   ' onclick="GetDetail()" property="butInsert" styleClass="bottomBarText" /></TD>                         
                </TR>
                <TR>
                  <TD colspan=6 bgColor="#4682b4"><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR> 
                <tr height = 2><td></td></tr>        
                <tr height="15" >
                  <td colspan="6"></td>
                </tr>
                                 
              </TABLE>
              <!--Table 20 starts-->
              <!--Body table ends-->
    
              <!--Table 21 starts-->
              <table cellspacing=0 cellpadding=0 border=0>
              <!-- Detail Information Row starts -->
                <TR>
                  <TD colspan=6>
                    <!--Table 31 starts-->
                    <table cellspacing=0 cellpadding=0 border=0>
                      <TBODY>
                        <TR>
                          <td width = 50%>
                            <!-- Purchase Requisition Info Table Starts -->
                            <!--Table 40 starts-->
                            <TABLE cellSpacing=0 cellPadding=0 >
                              <TR>
                                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td bgcolor="#4682B4" nowrap class=actTabText>Earning Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                              </TR> 
                              <TR>
                                <TD colspan=5>
                                  <!--Table 50 starts-->
                                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                                    <TBODY>
                                      <TR>
                                        <TD >   
                                          <DIV id=divDtlTable style="height:300px" >
                                          <!-- Detail table starts -->
                                            <!--Table 60 starts-->
                                            <TABLE cellSpacing=0 cellPadding=0>
                                              <TBODY>
                                                <TR height=20>
                                                  <td class=tableHeader width="9%"><bean:message key="Payroll.EnqPayImg.txtPayCode" /></td>
                                                  <td class=tableHeader width="15%"><bean:message key="Payroll.EnqPayImg.txtDesc" /></td>
                                                  <td class=tableHeader width="5%"><bean:message key="Payroll.EnqPayImg.txtSrlNo" /></td>
                                                  <td class=tableHeader width="5%"><bean:message key="Payroll.EnqPayImg.txtPayMode" /></td>
                                                  <td class=tableHeader width="6%"><bean:message key="Payroll.EnqPayImg.txtAmt" /></td>                              
                                                </TR> 
                                                
                                                <logic:iterate id="payImage" name="frmEnqPayImg" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                                                <logic:lessThan name="payImage" property="txtPayCode" value="997">
                                                <logic:equal name="payImage" property="txtPayMode" value="1">
                                                   <tr>
                                                      <td width="9%"><html:text property="txtPayCode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="15%"><html:text property="txtDesc" name="payImage" size = "31" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtSrlNo" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtPayMode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="6%"><html:text property="txtAmt" name="payImage" style="width:100%;text-align:right" readonly="true" /></td>
                                                  </tr>    
                                                </logic:equal>
                                                <logic:equal name="payImage" property="txtPayMode" value="4">
                                                   <tr>
                                                      <td width="9%"><html:text property="txtPayCode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="15%"><html:text property="txtDesc" name="payImage" size = "31" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtSrlNo" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtPayMode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="6%"><html:text property="txtAmt" name="payImage" style="width:100%;text-align:right" readonly="true" /></td>
                                                  </tr>    
                                                </logic:equal>
                                                </logic:lessThan>
                                               </logic:iterate>   
                                              </TBODY>
                                            </TABLE>
                                            <!--Table 60 ends-->
                                          </DIV>
                                        </TD>
                                      </TR>                       
                                    </TBODY>
                                  </TABLE> 
                                  <!--Table 50 ends-->
                                </TD>
                              </TR>
                            </TABLE>
                            <!--Table 40 ends-->
                          </td>
                          <td width = 50%>
                            <!--Table 41 starts-->
                            <TABLE cellSpacing=0 cellPadding=0 >
                              <TR>
                                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td bgcolor="#4682B4" nowrap class=actTabText>Deduction Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                              </TR> 
                              <TR>
                                <TD colspan=5>
                                  <!--Table 51 starts-->
                                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                                    <TBODY>
                                      <TR>
                                        <TD >   
                                          <!-- Detail table starts -->
                                            <!--Table 61 starts-->
                                          <DIV id=divDtlTable style="height:300px" >
                                            <TABLE cellSpacing=0 cellPadding=0>
                                              <TBODY>
                                                 <TR height=20>
                                                  <td class=tableHeader width="9%"><bean:message key="Payroll.EnqPayImg.txtPayCode" /></td>
                                                  <td class=tableHeader width="15%"><bean:message key="Payroll.EnqPayImg.txtDesc" /></td>
                                                  <td class=tableHeader width="5%"><bean:message key="Payroll.EnqPayImg.txtSrlNo" /></td>
                                                  <td class=tableHeader width="5%"><bean:message key="Payroll.EnqPayImg.txtPayMode" /></td>
                                                  <td class=tableHeader width="6%"><bean:message key="Payroll.EnqPayImg.txtAmt" /></td>                              
                                                </TR>   
                                                <logic:iterate id="payImage" name="frmEnqPayImg" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                                                <logic:lessThan name="payImage" property="txtPayCode" value="997">
                                                <logic:equal name="payImage" property="txtPayMode" value="2">
                                                   <tr>
                                                      <td width="9%"><html:text property="txtPayCode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="15%"><html:text property="txtDesc" name="payImage" size = "31" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtSrlNo" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtPayMode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="6%"><html:text property="txtAmt" name="payImage" style="width:100%;text-align:right" readonly="true" /></td>
                                                  </tr>      
                                                  </logic:equal>
                                                <logic:equal name="payImage" property="txtPayMode" value="5">
                                                   <tr>
                                                      <td width="9%"><html:text property="txtPayCode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="15%"><html:text property="txtDesc" name="payImage" size = "31" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtSrlNo" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="5%"><html:text property="txtPayMode" name="payImage" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="6%"><html:text property="txtAmt" name="payImage" style="width:100%;text-align:right" readonly="true" /></td>
                                                  </tr>      
                                                  </logic:equal>
                                                  </logic:lessThan>
                                               </logic:iterate>                                            
                                              </TBODY>
                                            </TABLE>
                                            <!--Table 61 ends-->
                                          </DIV>
                                        </TD>
                                      </TR>                       
                                    </TBODY>
                                  </TABLE> 
                                  <!--Table 51 ends-->
                                </TD>
                              </TR>
                            </TABLE>  
                            <!--Table 41 ends-->
                          </td>
                        </TR>   
                      </TBODY>
                    </table>
                    <!--Table 31 ends--> 
                  </TD>
                </TR>
                <TR >
                  <td colspan = 6>     
                    <!--Table 32 starts-->            
                    <table width = "100%"  cellspacing="0" cellpadding="0" border = 0>
                      <tr height = 5><td></td></tr>
                      <tr>
                        <td class=labelLeftAlign width = "9%" align = "left"><bean:message key="pay.EnqPayImg.txtNetEar" /></td>
                        <% int flg = 0; %>     
                        <logic:iterate id="payImage" name="frmEnqPayImg" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                        <logic:equal name="payImage" property="txtPayCode" value="999">
                              <% flg = 1; %>
                              <td width="11%"><html:text property="txtAmt" name="payImage" size = "9" style="text-align:right" readonly="true"/></td>
                          </logic:equal>
                       </logic:iterate>    
                       <% if (flg ==0) { %>
                          <td width="11%"><html:text size = "9" property = "txtAmt" value = "" style="text-align:right" readonly="true" /></td>                       
                       <%  } %>
                          <% flg = 0; %>
                        <td class=labelText width = "18%"><bean:message key="pay.EnqPayImg.txtGrossEar" /></td>     
                        <logic:iterate id="payImage" name="frmEnqPayImg" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                        <logic:equal name="payImage" property="txtPayCode" value="997">
                              <% flg = 1; %>                        
                              <td width="10%" align = "right" ><html:text property="txtAmt" name="payImage" size = "9" style="text-align:right" readonly="true"/></td>
                         </logic:equal>
                       </logic:iterate>
                       <% if (flg ==0) { %>
                          <td width="10%" align = "right" ><html:text size = "9" property = "txtAmt" value = "" style="text-align:right" readonly="true" /></td>                       
                       <%  } %>         
                       <% flg = 0; %>                       
                        <td class=labelText width = "41%"><bean:message key="pay.EnqPayImg.txtGrossDed" /></td>     
                        <logic:iterate id="payImage" name="frmEnqPayImg" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                        <logic:equal name="payImage" property="txtPayCode" value="998">
                          <% flg = 1; %>
                          <td width="9%" align = "right"><html:text property="txtAmt" name="payImage" size = "9" style="text-align:right" readonly="true"/></td>
                          </logic:equal>
                       </logic:iterate>                  
                       <% if (flg ==0) { %>
                          <td width="9%" align = "right"><html:text size = "9" property = "txtAmt" value = "" style="text-align:right" readonly="true" /></td>                       
                       <%  } %>                                              
                       <td width="2%">&nbsp;</td>                       
                      </tr> 
                    </table>
                    <!--Table 32 ends-->
                  </td>
                </TR>
                <!-- Bottom Blue Bar -->
                <TR >
                  <td width="40%" bgColor="#4682b4"></td>
                  <td align=right bgColor="#4682b4"><img src="../INCLUDES/IMAGES/man.jpg"></td>  
                </TR>
              </table>
              <!--Table 20 ends-->
			  <!--Added by Vibhuti-PayCode 902,952-->
			   <table width = "100%"  cellspacing="0" cellpadding="0">
                      <tr height = 5><td></td></tr>
                      <tr>
                                                <td class=labelText width = "22%" align = "right"><bean:message key="pay.EnqPayImg.txtPenDed"/></td>
						<td><html:text size = "9" property="txtPenDed" name="frmEnqPayImg" style="text-align:right" readonly="true"/></td>
						<td class=labelText width = "62%" align = "right"><bean:message key="pay.EnqPayImg.txtEPSDed"/></td>
						<td><html:text size = "9" property="txtEPSDed" name="frmEnqPayImg" style="text-align:right" readonly="true"/></td>
						<td class=labelText width = "18%" align = "right"><bean:message key="pay.EnqPayImg.txtPFContr"/></td>
						<td><html:text size = "9" property="txtPFContr" name="frmEnqPayImg" style="text-align:right" readonly="true"/></td>
						<td width="2%">&nbsp;</td> 
					   </tr>
			   </table>
			   <!--Addition ends-->
              <!-- Container Table Ending Columns Starts-->
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!--Table 11 ends-->
    </div>

    <!-- Container Table Ends -->
    <html:hidden name="frmEnqPayImg"  property="headerPrimaryKey" value="Default" />
    <html:hidden name="frmEnqPayImg"  property="screenMode"/>
    <html:hidden name="frmEnqPayImg"  property="screenName" value="EnqPayImgScreen" />
    <html:hidden name="frmEnqPayImg"  property="forwardedPage" />
    <html:hidden name="frmEnqPayImg"  property="positionRequested" />
    <html:hidden property="userPositionRequested" name="frmEnqPayImg" />
    <html:hidden property="pageRequested" name="frmEnqPayImg" />
    <html:hidden property="userPageRequested" name="frmEnqPayImg" />
    <html:hidden property="loginLocCode" name="frmEnqPayImg"  />
    
    <html:hidden property="lovKey" name="frmEnqPayImg"  />
    <html:hidden property="txtFields" name="frmEnqPayImg"  />   
    <html:hidden property="txtSearchFields" name="frmEnqPayImg"  />
    <html:hidden property="txtDisplayFields" name="frmEnqPayImg"  />
    <html:hidden property="txtIndex" name="frmEnqPayImg"  />
    <html:hidden property="buttonFlag" name="frmEnqPayImg"  />
	<html:hidden property="payYYMM" name="frmEnqPayImg"  />

    <input type="hidden" name="queryParam" />

    </html:form>
  </BODY>
</html:html>

                        
                        
         


<script language="javascript">

function lfnLoad()
{
  var sMode = document.frmEnqPayImg.screenMode.value;
  if(sMode == "")
  {
    doQueryMode();
  }
  if(sMode == "Q")
  {
    document.frmEnqPayImg.butInsert.disabled="true";
	document.getElementById("txtUptoYYMM").value=document.getElementById("payYYMM").value; //added by swapnendu 17-jan-17
  }
  if(sMode == "U")
  {
    document.frmEnqPayImg.buttxtEmpNo.disabled="true";
    document.frmEnqPayImg.buttxtYtm.disabled="true";
  }
  hedMenuHandling(sMode);
  
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";   
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
}
 function changed(val)
{
 
  frmEnqPayImg.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}
 
function doQueryMode()
{
  frmEnqPayImg.action="../../../EnqPayImageQueryMode.do"
  frmEnqPayImg.submit();
}
  function GetDetail()
{
	frmEnqPayImg.butInsert.disabled="true";
  frmEnqPayImg.action="../../../EnqPayImgFirstGetDetailAction.do"
  frmEnqPayImg.submit();
}

 function getHeaderRecord()
  {
	if(mandatory_Check("frmEnqPayImg")){
		frmEnqPayImg.action="../../../EnqPayImgFirstGetHeaderAction.do";
		frmEnqPayImg.submit();
	}
  }

function doGetNextHeader()
{ 
    frmEnqPayImg.userPositionRequested.value = 1*(frmEnqPayImg.positionRequested.value) + 1;  
    frmEnqPayImg.action="../../../EnqPayImgGetNextHeader.do";
    frmEnqPayImg.submit();
}



function PrevHeader()
{
  frmEnqPayImg.userPositionRequested.value = frmEnqPayImg.positionRequested.value - 1;
  frmEnqPayImg.action = "../../../EnqPayImgGetNextHeader.do";
  frmEnqPayImg.submit();
}

function JumpHeader()
{
  frmEnqPayImg.userPositionRequested.value = 1*frmEnqPayImg.newPositionRequested.value;
  frmEnqPayImg.action = "../../../EnqPayImgGetNextHeader.do";
  frmEnqPayImg.submit();
}


function ShowLovYYMM()
{
   frmEnqPayImg.lovKey.value = "EnqPayImageYtm" + frmEnqPayImg.screenName.value + frmEnqPayImg.screenMode.value;   
   frmEnqPayImg.queryParam.value="txtSiteID="+ frmEnqPayImg.loginLocCode.value;
   frmEnqPayImg.txtDisplayFields.value = "txtYtm";
   frmEnqPayImg.txtSearchFields.value = "";   
   frmEnqPayImg.txtIndex.value ="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEnqPayImg');
   return true;
}

function ShowLovEmpNo()
{
   frmEnqPayImg.lovKey.value = "EnqPayImageEmp" + frmEnqPayImg.screenName.value + frmEnqPayImg.screenMode.value;
   frmEnqPayImg.queryParam.value="txtSiteID="+ frmEnqPayImg.loginLocCode.value +",hdnEmpLbrFlag="+ frmEnqPayImg.hdnEmpLbrFlag.value ;
   frmEnqPayImg.txtDisplayFields.value = "txtEmpNo,txtEmpName"; 
   frmEnqPayImg.txtSearchFields.value = "Payroll.EnqPayImg.txtEmpNo,Payroll.EnqPayImg.txtEmpName,Payroll.EnqPayImg.txtCpfCode";        // cpf code added by dushyant on 01-10-2010
   frmEnqPayImg.txtIndex.value ="";   
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEnqPayImg');
   return true;
}

function ShowLovDsgn()
{
   frmEnqPayImg.lovKey.value = "EnqPayImageDsgn" + frmEnqPayImg.screenName.value + frmEnqPayImg.screenMode.value;
   frmEnqPayImg.txtDisplayFields.value = "txtDesig";
   frmEnqPayImg.txtSearchFields.value = "";
   frmEnqPayImg.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEnqPayImg');
   return true;
}

function checkYYYYMM(me)
{
  var yymm = me.value; //document.all.txtYtm.value;
  var currYYMM = document.getElementById("payYYMM").value;
  var frmYYMM = document.getElementById("txtYtm").value;
  var toYYMM = document.getElementById("txtUptoYYMM").value;

  if(yymm.length == 0)
  {
    return;
  }
  if(yymm.length != 6)
  {
    alert("Please give proper year-month in YYYYMM format");
    me.value="";
	me.focus();
    return;
  }
  if(parseInt(yymm,10)/100000 > 1)
  {
  }
  else
  {
    alert("Please give proper year-month in YYYYMM format");
	me.value="";
	me.focus();
	return;
  }
  var mon=parseInt(yymm.substring(4,6),10);
  if(mon<1 || mon>12)
  {
    alert("MM should be from 01 to 12");
	me.value="";
	me.focus();
    return;
  }
  if(toYYMM != ""){
	  if(parseInt(toYYMM)>parseInt(currYYMM))
	  {
		  alert("To Year Month can't exceed the current month, i.e "+currYYMM);
		  document.all.txtUptoYYMM.select();
		  document.all.txtUptoYYMM.focus();
		  return false;
	  }
  }
  if(frmYYMM != "" && toYYMM != ""){
	  if(parseInt(frmYYMM)>parseInt(toYYMM))
	  {
		  alert("'From Year Month' can't exceed 'To Year Month'");
		  document.all.txtYtm.select();
		  document.all.txtYtm.focus();
		  return false;
	  }
	  var cnt=0;
	  if((parseInt(toYYMM.substring(0,4),10)-parseInt(frmYYMM.substring(0,4),10))==0)
	  {
		 cnt=0;
	  }
	  else if((parseInt(toYYMM.substring(0,4),10)-parseInt(frmYYMM.substring(0,4),10))==1)
	  {
		if(((12-parseInt(frmYYMM.substring(4,6),10))+1) + (parseInt(toYYMM.substring(4,6),10)) > 12)
		{
			cnt=1;
		}
	  }
	  else{
		  cnt=1;
	  }

	  if(cnt==1)
	  {
		  alert("The range should not exceed more than 12 months; Please change 'From Year Month' or 'To Year Month' accordingly.");
		  me.value="";
		  me.focus();
		  return;
	  }
  }
}

</script>














































