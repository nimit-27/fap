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

    <html:form  action="EditPayImgBase" name="frmEditPayImg" type="FCIPAY.Payroll.WEBTIER.Form.EditPayImgForm" scope="session">
    <bean:define id="ParentForm" name="frmEditPayImg" toScope="request" />
    <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
    <html:errors/>
    <html:hidden property="detailDataChanged" />
    <html:hidden property="headerFields" value="false" />
    <%! int i=0,j=0; String sId=""; %>
    <% i = 0;j=0; %>
    
    <!--Table 10 starts-->
    <TABLE cellSpacing=0 bgColor="#bdd0ef">
      <TR height=30>
        <TD  colSpan=11 class=mainHeader height=10>ENQUIRE PAY IMAGE(Editable)</TD>
      </TR>
      <tr height="10">
        <td class=userText colspan="11">
        </td>
      </tr>
    </TABLE>
    <!--Table 10 ends-->
    <!--container table starts -->
    <div id=divDtlTable  style="height:500px" >
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
                  <td align="left" width="55%"><html:text  property="txtEmpNo" altKey="pay.EnqPayImg.txtEmpNo" maxlength="10" size="23" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick=" return ShowLovEmpNo();">&nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="32" styleClass="locked" readonly="true" /></td>
                  <td class=labelText width="8%"><bean:message key="Payroll.EnqPayImg.lstCadre" /></td>
                  <td width="22%">
                    <html:text  property="lstGroup" altKey="pay.EnqPayImg.lstCadre" maxlength="10" size="23" styleClass="locked" readonly="true" />                    
                  </td>                                   
                </TR> 

                <TR > 
                  <td width="100%" colspan="4">
                  <table width="100%" border=0><tr>
                  <td class=labelText width="14%" ><bean:message key="Payroll.EnqPayImg.lstCateg" /> </td>
                  <td width="22%">
                    <html:text  property="lstCateg" altKey="pay.EnqPayImg.lstCateg" maxlength="10" size="23" styleClass="locked" readonly="true" />                                                         
                  </td>
                  
                  <TD class=labelText width="11%" ><bean:message key="Payroll.EnqPayImg.txtBasic" /></TD>
                  <td align="left" width="22%">
                    <html:text  property="txtCurrBas" altKey="Payroll.EnqPayImg.txtBasic" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </td>
                  
                  <TD class=labelText  width="8%"><bean:message key="Payroll.EnqPayImg.txtDesig" /></TD>
                  <td align="left" width="22%">
                    <html:text  property="txtDesig" altKey="pay.EnqPayImg.txtDesig" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </td>
                  </tr>
                  </table>
                  </td>
                </TR>    
                
                  <html:hidden  property="txtrs1"  />                              
                  <html:hidden  property="txtrs2" />                              
                  <html:hidden  property="txtCpfCode"  name= "frmEditPayImg" />

                <TR>
                  <TD colspan=6 bgColor="#4682b4"><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR> 

                <tr height = 2><td></td></tr>  
                <TR>
                  <td colspan = 10>
                  <!--Table 30 starts-->
                    <table>
                      <tr>
                      <td width = "30%"></td>
                        <td  width="10%" class=labelText><bean:message key="Payroll.EnqPayImg.txtYtm" /></td>
                        <logic:equal property= "screenMode" name= "frmEditPayImg" value="N">                        
                          <td ><html:text  property="txtYtm" name= "frmEditPayImg" styleClass = "locked" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" onblur="checkYYYYMM();" /></td>                              
                                                     
                        </td>    
                        </logic:equal>
                        <logic:notEqual property= "screenMode" name= "frmEditPayImg" value="N">
                        <td ><html:text  property="txtYtm" styleClass = "optional" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" onblur="checkYYYYMM();" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtYtm"  onclick=" return  ShowLovYYMM()"></td>                              
                        </logic:notEqual>                         
                        <td width = "30%"></td>                 
                      </tr> 
                    </table>
                  <!--Table 30 ends-->
                  </td>
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
                          <td width = 100%>
                            <!-- Purchase Requisition Info Table Starts -->
                            <!--Table 40 starts-->
                            <TABLE cellSpacing=0 cellPadding=0 >
                              <TR>
                                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td bgcolor="#4682B4" nowrap class=actTabText>Earning & Deduction Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                          <DIV id=divDtlTable style="height:210px" >
                                          <!-- Detail table starts -->
                                            <!--Table 60 starts-->
                                            <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                              <TBODY>
                                                <TR>
                                                  <td class=tableHeader width="1%"><html:checkbox property="selectAll"    /></td>
                                                  <td class=tableHeader width="10%"><bean:message key="Payroll.EnqPayImg.txtPayCode" /></td>
                                                  <td class=tableHeader width="50%"><bean:message key="Payroll.EnqPayImg.txtDesc" /></td>
                                                  <td class=tableHeader width="8%"><bean:message key="Payroll.EnqPayImg.txtSrlNo" /></td>
                                                  <td class=tableHeader width="8%"><bean:message key="Payroll.EnqPayImg.txtPayMode" /></td>
                                                  <td class=tableHeader width="10%"><bean:message key="Payroll.EnqPayImg.txtAmt" /></td>                              
                                                </TR> 
                                                
                                                <logic:iterate id="payImage" name="frmEditPayImg" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EnqPayImgBean" >
                                                  <% ++i; %>                                                 
                                                  <logic:notEqual name="payImage" property="status" value="D" >
                                                  <tr width="100%">                                                                                         
                                                  
                                                      <td  width="1%" align="center"><html:checkbox property="checked" onclick="checkRecord();" value="false" /></td>
                                                      <td width="10%">
                                                      <logic:equal name="payImage" property="status" value="N" >
                                                      <html:text property="txtPayCode" name="payImage" styleClass="required" alt="<%=String.valueOf(i)%>" style="width:70%;text-align:left" onkeypress="                  
                                                       if((event.keyCode < 48 || event.keyCode > 57))
                                                        {                     
                                                          return false;
                                                        };" onchange=" getPayCodeDetail(this.value, this.alt); return changed(this.alt);" maxlength="5" />
                                                       <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center"  property="buttxtEmpNo" alt="<%=String.valueOf(i)%>" onclick="ShowLovPayCode1(this.alt);" >
                                                      </logic:equal>
                                                      
                                                      <logic:equal name="payImage" property="status" value="U" >
                                                      <html:text property="txtPayCode" name="payImage" styleClass="required" alt="<%=String.valueOf(i)%>" style="width:70%;text-align:left"  onchange="" readonly="true" maxlength="5" />
                                                       <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center"  property="buttxtEmpNo" alt="<%=String.valueOf(i)%>" onclick="" >
                                                      </logic:equal>
                                                      
                                                      <logic:equal name="payImage" property="status" value="Q" >
                                                      <html:text property="txtPayCode" name="payImage" styleClass="required" alt="<%=String.valueOf(i)%>" style="width:70%;text-align:left" onchange="return changed(this.alt);" maxlength="5" readonly="true" />
                                                       <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center"  property="buttxtEmpNo" alt="<%=String.valueOf(i)%>"  >
                                                      </logic:equal>
                                                      </td>                                                     
                                                      
                                                      <td width="50%"><html:text property="txtDesc" name="payImage" styleClass = "locked" alt="<%=String.valueOf(i)%>" style="width:100%;text-align:left"  readonly="true" /></td>
                                                      <td width="8%"><html:text property="txtSrlNo" name="payImage" styleClass = "locked" alt="<%=String.valueOf(i)%>" style="width:100%;text-align:center" readonly="true" /></td>
                                                      <td width="20%"><html:select property="txtPayMode" name="payImage" alt="<%=String.valueOf(i)%>" style="width:100%;" styleClass = "required" onchange = "calcEarnDedAmt(); changed(this.alt);" >
                                                      <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                                                      <html:option value="1" ><bean:message key="Payroll.PayImage.PayCurrent" /></html:option>
                                                      <html:option value="2" ><bean:message key="Payroll.PayImage.RecCurrent" /></html:option>                              
                                                      <html:option value="4" ><bean:message key="Payroll.PayImage.PayArrear" /></html:option>                              
                                                      <html:option value="5" ><bean:message key="Payroll.PayImage.RecArrear" /></html:option>
                                                      </html:select></td>
                                                      
                                                      
                                                      <td width="10%"><html:text property="txtAmt" name="payImage" alt="<%=String.valueOf(i)%>" styleClass = "required" style="width:100%;text-align:right" onkeypress="                  
                                                       if((event.keyCode < 48 || event.keyCode > 57))
                                                        {                     
                                                          return false;
                                                        };" onchange="calcEarnDedAmt(); changed(this.alt);" /></td>
                                                        
                                                      <html:hidden property="itemChecked" name="payImage" alt="<%=String.valueOf(i)%>"/>                                                                                            
                                                      <html:hidden property="status" name="payImage" alt="<%=String.valueOf(i)%>"/>                                                      
                                                      <html:hidden property="detailId" alt="<%=String.valueOf(i)%>" name="payImage" value="Default"/>
                                                  </tr> 
                                                  </logic:notEqual>                                                                
                                                  <logic:equal name="payImage" property="status" value="D" >                                                                                                   
                                                
                                                  <tr>
                                                    <td ><html:hidden property="checked" name="frmEditPayImg" value="notchecked" /></td>                                      
                                                    <td ><html:hidden property="txtPayCode" name="payImage" /></td> 
                                                    <td ><html:hidden property="txtDesc" name="payImage" /></td>
                                                    <td ><html:hidden property="txtSrlNo" name="payImage" /></td>
                                                    <td ><html:hidden property="txtPayMode" name="payImage" /></td>
                                                    <td ><html:hidden property="txtAmt" name="payImage" /></td>
                                                    <html:hidden property="itemChecked" name="payImage" />                                                                                            
                                                    <html:hidden property="status" name="payImage" />                                                      
                                                    <html:hidden property="detailId" name="payImage" value="Default"/>
                                                  </tr>    
                                                  </logic:equal>
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
                          
                </TR>
                <tr height = 3><td></td></tr>
                <tr>
                 <td colspan=8>	
                  <TABLE border=0>
                    <TBODY>
                    <TR><td><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                    </td></TR>
                  </TBODY>
                </TABLE>
                </TD>               
              </tr>              
                
                <TR >
                  <td colspan = 6>     
                    <!--Table 32 starts-->            
                    <table width = "100%"  cellspacing="0" cellpadding="0" border = 0>
                      <tr height = 5><td></td></tr>                      
                      <tr>
                        <td class=labelLeftAlign width = "9%" align = "left"><bean:message key="pay.EnqPayImg.txtNetEar" /></td>                         
                        <td width="11%"><html:text size = "9" property = "txtNetEar" value = "" style="text-align:right" readonly="true" /></td>                                              
                        <td class=labelText width = "18%"><bean:message key="pay.EnqPayImg.txtGrossEar" /></td>                                                         
                        <td width="10%" align = "right" ><html:text size = "9" property = "txtGrossEar" value = "" style="text-align:right" readonly="true" /></td>                     
                        <td class=labelText width = "41%"><bean:message key="pay.EnqPayImg.txtGrossDed" /></td>                                                         
                        <td width="9%" align = "right"><html:text size = "9" property = "txtGrossDed" value = "" style="text-align:right" readonly="true" /></td>                      
                          
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
              <!-- Container Table Ending Columns Starts-->
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!--Table 11 ends-->
    </div>

    <!-- Container Table Ends -->
    <html:hidden name="frmEditPayImg"  property="headerPrimaryKey" value="Default" />
    <html:hidden property="totalDetailRecord" name="frmEditPayImg" />
    <html:hidden name="frmEditPayImg"  property="screenMode"/>
    <html:hidden name="frmEditPayImg"  property="screenName" value="EditPayImgScreen"/>
    <html:hidden name="frmEditPayImg"  property="forwardedPage" />
    <html:hidden name="frmEditPayImg"  property="positionRequested" />
    <html:hidden property="userPositionRequested" name="frmEditPayImg" />
    <html:hidden property="pageRequested" name="frmEditPayImg" />
    <html:hidden property="userPageRequested" name="frmEditPayImg" />
    <html:hidden property="loginLocCode" name="frmEditPayImg"  />    
    <html:hidden name="frmEditPayImg"  property="screenModeId"  />
    <html:hidden name="frmEditPayImg"  property="payYYMM"  />
    <html:hidden property="lovKey" name="frmEditPayImg"  />
    <html:hidden property="txtFields" name="frmEditPayImg"  />   
    <html:hidden property="txtSearchFields" name="frmEditPayImg"  />
    <html:hidden property="txtDisplayFields" name="frmEditPayImg"  />
    <html:hidden property="txtIndex" name="frmEditPayImg"  />
    <html:hidden property="buttonFlag" name="frmEditPayImg"  />

    <input type="hidden" name="queryParam" />

    </html:form>
  </BODY>
</html:html>

                        
                        
         


<script language="javascript">

function lfnLoad()
{
   var sMode  = frmEditPayImg.screenMode.value;
    if(sMode == "")
    {
        doQueryMode();
    } 
    
    mode = frmEditPayImg.screenModeId.value;        
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
    if (frmEditPayImg.screenMode.value == 'U')
    { 
        //document.getElementById("txtEffectDate").disabled = "true";
        //document.getElementById("headerPrimaryKey").disabled = "true";      
    }
    else
    {  
        //document.getElementById("txtEffectDate").disabled="";
        //document.getElementById("headerPrimaryKey").disabled="";
    } 

    if(mode=='U')
    {      
      calcEarnDedAmt();
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";        
     
    }
 //alert(mode);
    if(mode=='N')
    {
        frmEditPayImg.txtYtm.value = frmEditPayImg.payYYMM.value;
        calcEarnDedAmt();
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled=""; 
        
        
    }
    
    if(mode=='UG')
    {   calcEarnDedAmt();
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";
    }  
    mode = frmEditPayImg.screenMode.value;     
        
    if(mode == "Q")
    {
      frmEditPayImg.txtYtm.value = '';
      if(frmEditPayImg.screenModeId.value = 'U')
        document.all.butGetDetail.disabled="disabled";
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
 
function calcEarnDedAmt()
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    var netEarn =0;
    var grossEarn =0;
    var grossDed =0;
    
    for(i=0; i < iTr2 -1; i++)
    {          
      if (document.getElementsByName("status")[i].value != 'D')
      { 
        if (parseInt(document.getElementsByName("txtPayMode")[i].value) == 1 || parseInt(document.getElementsByName("txtPayMode")[i].value) ==4 )
        {
          netEarn = netEarn + parseInt(document.getElementsByName("txtAmt")[i].value,10);
        }
        if (parseInt(document.getElementsByName("txtPayMode")[i].value) == 2 || parseInt(document.getElementsByName("txtPayMode")[i].value) ==5 )
        {
          grossDed = grossDed + parseInt(document.getElementsByName("txtAmt")[i].value,10);
        } 
      }
    }    
    document.all.txtGrossEar.value = isNaN(netEarn)?0:netEarn;
    document.all.txtGrossDed.value = isNaN(grossDed)?0:grossDed;
    document.all.txtNetEar.value = parseInt(document.all.txtGrossEar.value,10) - parseInt(document.all.txtGrossDed.value,10);
}

function changed(val)
{
 
  frmEditPayImg.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}

function doQueryMode()
{
  frmEditPayImg.screenModeId.value = 'Q';
  frmEditPayImg.action="../../../EditPayImageQueryMode.do"
  frmEditPayImg.submit();
}

function GetDetail()
{
  document.all.buttonFlag.value='';  
  document.all.screenModeId.value='UG';
  frmEditPayImg.action="../../../EditPayImgFirstGetDetailAction.do"
  frmEditPayImg.submit();
}

function getHeaderRecord()
{
  document.all.screenModeId.value='U';
  frmEditPayImg.action="../../../EditPayImgFirstGetHeaderAction.do";
  frmEditPayImg.submit();
}

function doGetNextHeader()
{ 
    document.all.screenModeId.value='U';
    frmEditPayImg.userPositionRequested.value = 1*(frmEditPayImg.positionRequested.value) + 1;  
    frmEditPayImg.action="../../../EditPayImgGetNextHeader.do";
    frmEditPayImg.submit();
}

function PrevHeader()
{
  document.all.screenModeId.value='U';
  frmEditPayImg.userPositionRequested.value = frmEditPayImg.positionRequested.value - 1;
  frmEditPayImg.action = "../../../EditPayImgGetNextHeader.do";
  frmEditPayImg.submit();
}

function JumpHeader()
{
  document.all.screenModeId.value='U';
  frmEditPayImg.userPositionRequested.value = 1*frmEditPayImg.newPositionRequested.value;
  frmEditPayImg.action = "../../../EditPayImgGetNextHeader.do";
  frmEditPayImg.submit();
}

function ShowLovYYMM()
{
   frmEditPayImg.lovKey.value = "EditPayImageYtm" + frmEditPayImg.screenName.value + frmEditPayImg.screenMode.value;   
   frmEditPayImg.queryParam.value="txtSiteID="+ frmEditPayImg.loginLocCode.value;
   frmEditPayImg.txtDisplayFields.value = "txtYtm";
   frmEditPayImg.txtSearchFields.value = "";   
   frmEditPayImg.txtIndex.value ="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEditPayImg');
   return true;
}

function ShowLovEmpNo()
{   
    frmEditPayImg.lovKey.value = "EditPayImageEmp" + frmEditPayImg.screenName.value + frmEditPayImg.screenMode.value;   
    
    if(frmEditPayImg.screenMode.value =='N')
    {
      frmEditPayImg.queryParam.value="txtSiteID="+ frmEditPayImg.loginLocCode.value +",hdnEmpLbrFlag="+ frmEditPayImg.hdnEmpLbrFlag.value + ",payYrMonth="+ frmEditPayImg.payYYMM.value ;
      frmEditPayImg.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,lstGroup,lstCateg,txtCurrBas,txtDesig"; 
      frmEditPayImg.txtSearchFields.value = "Payroll.EnqPayImg.txtEmpNo,Payroll.Common.cpfCode,Payroll.EnqPayImg.txtEmpName";
    }
    else
    {
      frmEditPayImg.queryParam.value="txtSiteID="+ frmEditPayImg.loginLocCode.value +",hdnEmpLbrFlag="+ frmEditPayImg.hdnEmpLbrFlag.value ;
      frmEditPayImg.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode"; 
      frmEditPayImg.txtSearchFields.value = "Payroll.EnqPayImg.txtEmpNo,Payroll.Common.cpfCode,Payroll.EnqPayImg.txtEmpName";
    }
    frmEditPayImg.txtIndex.value ="";   
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEditPayImg');
    return true;   
}

function ShowLovDsgn()
{
    frmEditPayImg.lovKey.value = "EnqPayImageDsgn" + frmEditPayImg.screenName.value + frmEditPayImg.screenMode.value;
    frmEditPayImg.txtDisplayFields.value = "txtDesig";
    frmEditPayImg.txtSearchFields.value = "";
    frmEditPayImg.txtIndex.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEditPayImg');
    return true;
}

function ShowLovPayCode1(i)
{   
    frmEditPayImg.lovKey.value = "EditPayImgPayCode" + frmEditPayImg.screenName.value + frmEditPayImg.screenMode.value;
    frmEditPayImg.txtDisplayFields.value = "txtPayCode,txtDesc";
    frmEditPayImg.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";    
    frmEditPayImg.txtIndex.value= i-1;  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEditPayImg');
    return true;
}

function checkYYYYMM()
{
  var yymm = document.all.txtYtm.value;
  if(yymm.length == 0)
  {
    return;
  }
  if(yymm.length != 6)
  {
    alert("Please give proper year-month in YYYYMM format");
    document.all.txtYtm.select();
    document.all.txtYtm.focus();
    return;
  }
  if(parseInt(yymm,10)/100000 > 1)
  {
  }
  else
  {
    alert("Please give proper year-month in YYYYMM format");
    document.all.txtYtm.select();
    document.all.txtYtm.focus();
    return;
  }
  var mon=parseInt(yymm.substring(4,6),10);
  if(mon<1 || mon>12)
  {
    alert("MM should be from 01 to 12");
    document.all.txtYtm.select();
    document.all.txtYtm.focus();
    return;
  }
}


function doInsertMode()
{
  document.all.buttonFlag.value='';
  frmEditPayImg.screenModeId.value='N';  
  frmEditPayImg.txtYtm.value = frmEditPayImg.payYYMM.value;
  frmEditPayImg.action="../../../EditPayImgNewMode.do"
  frmEditPayImg.submit();
}

function doBaseAddRow()
{
    document.all.buttonFlag.value='D';    
    if(mandatory_Check("frmEditPayImg"))
    {
      document.forms[0].action = "../../../EditPayImgAddRowAction.do";
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
    
    for(i=0; i < iTr2 -1; i++)
    {    
      if(document.getElementsByName("checked")[i].checked)
      {      
          document.getElementsByName("itemChecked")[i].value = "Y";
          document.all.detailDataChanged.value="true";           
      }
    }  
   
    document.forms[0].action = "../../../EditPayImgDelRowAction.do";
    document.forms[0].submit();      
}

function doRefresh()
{   
    frmEditPayImg.action = "../../../EditPayImgRefreshAction.do";
    frmEditPayImg.submit();
}

function SaveRecord()
{
  if(mandatory_Check("frmEditPayImg"))
  {
      if (frmEditPayImg.txtNetEar.value < 0)
      {
        alert("Net Earning cannot be less than 0");
        return;
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
        document.getElementsByName("checked")[i].disabled = "";
        if (document.getElementsByName("status")[i].value == 'D')
          frmEditPayImg.detailDataChanged.value = "true";
        if (document.getElementsByName("status")[i].value == 'N')
        {
          frmEditPayImg.detailDataChanged.value = "true";         
        }   
        if (document.getElementsByName("status")[i].value == 'U')
        {
          frmEditPayImg.detailDataChanged.value = "true";             
        }           
    }      
      if(frmEditPayImg.screenMode.value == "N" )
      {     
          frmEditPayImg.detailDataChanged.value = "true";          
      }
      
      frmEditPayImg.screenMode.value ="U";                    
      frmEditPayImg.headerPrimaryKey.value = "##";      
      frmEditPayImg.headerFields.value = "true";
      frmEditPayImg.totalDetailRecord.value = parseInt(iTr2)-1;       
      frmEditPayImg.buttonFlag.value='';
      
      frmEditPayImg.action = "../../../EditPayImgSaveAction.do";
      frmEditPayImg.submit();
  }
  else
  {
    return false;
  }
}

function getPayCodeDetail(val,indx)
{
    var ind = parseInt(indx)+1;       
    retrieveURL("../../../getEditPayImgPayCodeAction.do?payCodeVal="+escape(val), indx);
}

function retrieveURL(url,indx) {
  var idx=indx;    
    if (window.XMLHttpRequest) { // Non-IE browsers    
      req = new XMLHttpRequest();      
      req.onreadystatechange = function () { 
                                    processStateChange(idx);
                                    }

      try {        
        req.open("GET", url, true);
      } catch (e) {
        alert(e);
      }
      req.send(null);
    } else if (window.ActiveXObject) { // IE      
      req = new ActiveXObject("Microsoft.XMLHTTP");      
      if (req) {                       
        req.open("GET", url, true);
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded ");
        req.onreadystatechange = function () { 
                                    processStateChange(idx);
                                    }
        req.send(null);
        
      }
    }
  }

function processStateChange(indx) {
  if (req.readyState == 4) { // Complete
    if (req.status == 200) { // OK response        
       var payCodeResponse = req.responseText;             
       var codeDesc = payCodeResponse.split("|");         
      if(codeDesc[0] == ''){
        alert("Pay Code does not Exist");    
        document.getElementsByName("txtPayCode")[indx-1].value = '';
        document.getElementsByName("txtDesc")[indx-1].value = '';       
        return;
        }
        document.getElementsByName("txtDesc")[indx-1].value = codeDesc[0];       
      } else {
      alert("Problem: " + req.statusText);
    }
  }       
}



</script>