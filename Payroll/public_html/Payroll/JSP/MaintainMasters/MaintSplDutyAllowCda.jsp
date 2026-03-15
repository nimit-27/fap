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

    <html:form  action="MaintSplDutyAllow" name="frmMaintSplDutyAllow" type="FCIPAY.Payroll.WEBTIER.Form.MaintSplDutyAllowForm" scope="session">
      <bean:define id="ParentForm" name="frmMaintSplDutyAllow" toScope="request" />
      <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
      <html:errors/>  
      <html:hidden property="detailDataChanged"  />
      <html:hidden property="headerFields" value="false" />

      <table>
        <TR height=30>
          <TD  colSpan=11 class=mainHeader height=10>SPECIAL DUTY ALLOWANCE</TD>
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
              <TD class=subHeader colspan=2>Header For Special Duty Allowance</TD>
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
              <logic:equal property= "screenMode" name= "frmMaintSplDutyAllow" value="Q">            
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffDt',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
              </logic:equal>
              <logic:equal property= "screenMode" name= "frmMaintSplDutyAllow" value="N">            
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
                                          <TD class=tableHeader width="8%">Category</TD>
                                          <TD class=tableHeader width="10%">Designation</TD>
                                          <TD class=tableHeader width="10%">Area Type</TD>
                                          <TD class=tableHeader width="5%">Allowance</td>
                                          <TD class=tableHeader width="10%">Param/Rate</td>
                                          <TD class=tableHeader width="12%">Remarks</td>
                                        </TR>    

                                        <logic:iterate id="splDutyAllowInfo" name="frmMaintSplDutyAllow" property="lstInstrCdaDtls" type="FCIPAY.Payroll.UTILITY.MaintSplDutyAllowBean" >
                                        <% ++i; %>
                                          <logic:notEqual name="splDutyAllowInfo" property="status" value="D" >                              
                                            <tr>   
                                              <td align=center ><html:checkbox property="checked" name="frmMaintSplDutyAllow" onclick="checkRecord();" value="false" /></td>
                                          
                                          <logic:notEqual name="splDutyAllowInfo" property="status" value="N" >                                                
                                              <td colspan="1"><html:select property="txtCtgry" name="splDutyAllowInfo" disabled="true" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                                                <logic:present name="SplDutyCombo">
                                                                  <html:optionsCollection label="label" value="value" property="ctgryList" name="SplDutyCombo"/>
                                                                </logic:present>
                                                            </html:select>
                                              </td>
                                              <td ><html:text property="txtDsgn" readonly="true" name="splDutyAllowInfo" size="9" styleClass="optional" style="width:87%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
                                                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(i)%>" property="buttxtDsgn" >
                                                <html:hidden property="txtDsgnId" name="splDutyAllowInfo" />
                                              </td> 
                                              <td colspan="1"><html:select property="txtArea" name="splDutyAllowInfo" disabled="true" styleClass="optional" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                                                <logic:present name="SplDutyCombo">
                                                                  <html:optionsCollection label="label" value="value" property="areaTypList" name="SplDutyCombo"/>
                                                                </logic:present>
                                                            </html:select>
                                              </td>
                                              <td ><html:text property="txtAllow" name="splDutyAllowInfo" readonly="true" size="9" maxlength="10" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 && event.keyCode!=46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" />
                                              </td>
                                              <td colspan="1"><html:select property="txtParamFlg" name="splDutyAllowInfo" disabled="true"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                                                <html:option value="" >-----------Please Select-----------</html:option>
                                                                <html:option value="Rs" >Rs. </html:option>
                                                                <html:option value="%" >%(BP)+NPA + Stagnation Increment</html:option>  
                                                              </html:select>
                                              </td>  
                                              <td ><html:text property="txtRmrks" name="splDutyAllowInfo" size="9" readonly="true" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
                                              </td>
                                              </logic:notEqual>
                                              
                                              <logic:equal name="splDutyAllowInfo" property="status" value="N" >                                                
                                              <td colspan="1"><html:select property="txtCtgry" name="splDutyAllowInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="checkDuplicacy(this.alt); return changed(this.alt)"  style="WIDTH: 100%"  >
                                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                                                <logic:present name="SplDutyCombo">
                                                                  <html:optionsCollection label="label" value="value" property="ctgryList" name="SplDutyCombo"/>
                                                                </logic:present>
                                                            </html:select>
                                              </td>
                                              <td ><html:text property="txtDsgn" readonly="true" name="splDutyAllowInfo" size="9" styleClass="optional" style="width:87%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="checkDuplicacy(this.alt); return changed(this.alt)" />
                                                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(i)%>" property="buttxtDsgn"  onclick="ShowLovDsgn(this.alt);" >
                                                <html:hidden property="txtDsgnId" name="splDutyAllowInfo" />
                                              </td>
                                              <td colspan="1"><html:select property="txtArea" name="splDutyAllowInfo"  styleClass="optional" alt="<%=String.valueOf(i)%>" onchange="checkDuplicacy(this.alt); return changed(this.alt)"  style="WIDTH: 100%"  >
                                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                                                <logic:present name="SplDutyCombo">
                                                                  <html:optionsCollection label="label" value="value" property="areaTypList" name="SplDutyCombo"/>
                                                                </logic:present>
                                                            </html:select>
                                              </td>
                                              <td ><html:text property="txtAllow" name="splDutyAllowInfo" size="9" maxlength="10" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 && event.keyCode!=46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" />
                                              </td>
                                              <td colspan="1"><html:select property="txtParamFlg" name="splDutyAllowInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                                                <html:option value="" >-----------Please Select-----------</html:option>
                                                                <html:option value="Rs" >Rs. </html:option>
                                                                <html:option value="%" >%(BP)+NPA + Stagnation Increment</html:option>  
                                                              </html:select>
                                              </td>  
                                              <td ><html:text property="txtRmrks" name="splDutyAllowInfo" size="9" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" />
                                              </td>
                                              </logic:equal>
                                              <html:hidden property="txtStartDt" name="splDutyAllowInfo" />
                                              <html:hidden property="txtEndDt" name="splDutyAllowInfo" />
                                              <html:hidden property="txtPayScale" name="splDutyAllowInfo" />
                                              <html:hidden property="itemChecked" name="splDutyAllowInfo" />
                                              <html:hidden property="status" name="splDutyAllowInfo" />
                                              <html:hidden property="detailId" name="splDutyAllowInfo" />
                                            </tr>
                                          </logic:notEqual>

                                          <logic:equal name="splDutyAllowInfo" property="status" value="D" >
                                            <tr>
                                              <td ><html:hidden property="checked" name="frmMaintSplDutyAllow" value="notchecked" /></td>
                                              <td ><html:hidden property="txtCtgry" name="splDutyAllowInfo"  /></td>
                                              <td ><html:hidden property="txtDsgn" name="splDutyAllowInfo" /></td>
                                              <html:hidden property="txtDsgnId" name="splDutyAllowInfo" />
                                              <html:hidden property="txtArea" name="splDutyAllowInfo" />
                                              <td ><html:hidden property="txtParamFlg" name="splDutyAllowInfo" /></td>
                                              <td ><html:hidden property="txtAllow" name="splDutyAllowInfo" /></td>
                                              <td ><html:hidden property="txtRmrks" name="splDutyAllowInfo" /></td>
                                              <html:hidden property="txtStartDt" name="splDutyAllowInfo" />
                                              <html:hidden property="txtEndDt" name="splDutyAllowInfo" />
                                              <html:hidden property="txtPayScale" name="splDutyAllowInfo" />
                                              <html:hidden property="itemChecked" name="splDutyAllowInfo" />
                                              <html:hidden property="status" name="splDutyAllowInfo" />
                                              <html:hidden property="detailId" name="splDutyAllowInfo" />
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
   
      <html:hidden property="headerPrimaryKey" name="frmMaintSplDutyAllow" value="Default" />
      <html:hidden property="screenMode" name="frmMaintSplDutyAllow"  />
      <html:hidden name="frmMaintSplDutyAllow"  property="screenName" value="SplDutyCdaScreen" />
      <html:hidden name="frmMaintSplDutyAllow"  property="forwardedPage" />
      <html:hidden property="buttonFlag" name="frmMaintSplDutyAllow"  />
      <html:hidden property="pageRequested" name="frmMaintSplDutyAllow" />
      <html:hidden property="userPageRequested" name="frmMaintSplDutyAllow" />
      <html:hidden property="userPositionRequested" name="frmMaintSplDutyAllow" />
      <html:hidden property="positionRequested" name="frmMaintSplDutyAllow" />
      <html:hidden property="lovKey" name="frmMaintSplDutyAllow"  />
      <html:hidden property="txtFields" name="frmMaintSplDutyAllow"  />   
      <html:hidden property="txtSearchFields" name="frmMaintSplDutyAllow"  />
      <html:hidden property="txtDisplayFields" name="frmMaintSplDutyAllow"  />
      <html:hidden property="txtIndex" name="frmMaintSplDutyAllow"  />
      <html:hidden property="flagIda" name="frmMaintSplDutyAllow"  />
      <html:hidden property="flagCda" name="frmMaintSplDutyAllow"  />
      
      <input type="hidden" name="queryParam">
    </html:form>
  </body>
</html:html>

<script language="javascript">
function lfnLoad()
{
    mode1=document.all.flagCda.value;
    frmMaintSplDutyAllow.butGetDetail.disabled="true";
    frmMaintSplDutyAllow.butInsert.disabled="true";
    frmMaintSplDutyAllow.butDelete.disabled="true";
    if(mode1 == 'true' || document.all.flagCda.value == 'true')
    {
      //  frmMaintCCARate.headerPrimaryKey.disabled=true;
    }
    mode=document.all.screenMode.value;  
    if(mode=='')
    {
        doQueryMode();
    }
    if (frmMaintSplDutyAllow.screenMode.value == 'U')
    { 
          if(mode1=='false')
          {
              frmMaintSplDutyAllow.butGetDetail.disabled="";
              frmMaintSplDutyAllow.butInsert.disabled="true";
              frmMaintSplDutyAllow.butDelete.disabled="true";
          }    
          if(mode1=='true')
          {
              frmMaintSplDutyAllow.butGetDetail.disabled="true";
              frmMaintSplDutyAllow.butInsert.disabled="";
              frmMaintSplDutyAllow.butDelete.disabled="";
          }
    
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;        
    }
        if (frmMaintSplDutyAllow.screenMode.value == 'N')
    {
        frmMaintSplDutyAllow.butInsert.disabled="";
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
    frmMaintSplDutyAllow.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
  }

  function changedDt(val)
  {
    frmMaintSplDutyAllow.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
    flgResult=confirm("This will make the record obsolete ");
    if(!flgResult)
    {
      document.getElementsByName("txtEndDt")[val-1].value = '';
    }
  }

  function doBaseAddRow()
  {
    if(mandatory_Check("frmMaintSplDutyAllow"))
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
        document.getElementsByName("txtParamFlg")[indx].disabled = "";
        document.getElementsByName("txtCtgry")[indx].disabled = "";
        document.getElementsByName("txtArea")[indx].disabled = "";
       }
     }
      document.all.screenMode.value='U';
      document.all.flagCda.value=true;
      document.forms[0].action = "../../../SplDutyCdaAddRowAction.do";
      document.forms[0].submit();
    }
    else
    {
      return false;
    }
  }

  function SaveRecord()
  {
    if(mandatory_Check("frmMaintSplDutyAllow"))
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
        if(!checkDuplicacy(indx+1))
          return false;
        document.getElementsByName("txtParamFlg")[indx].disabled = "";
        document.getElementsByName("txtCtgry")[indx].disabled = "";
        document.getElementsByName("txtArea")[indx].disabled = "";
      }
     }
      frmMaintSplDutyAllow.headerFields.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintSplDutyAllow.action = "../../../SplDutyCdaSaveAction.do";
      // frmMaintHraRate.totalDetailRecord.value=parseInt(iTr2)-1;
      frmMaintSplDutyAllow.submit();
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
    frmMaintSplDutyAllow.action="../../../SplDutyCdaQueryAction.do"
    frmMaintSplDutyAllow.submit();
  }

  function GetDetail()
  {
    document.all.flagCda.value="true";
    document.all.screenMode.value='U'; 
    frmMaintSplDutyAllow.action="../../../SplDutyCdaGetDetailAction.do"
    frmMaintSplDutyAllow.submit();
  }

  function doRefresh()
  {
    frmMaintSplDutyAllow.action="../../../SplDutyCdaRefresh.do"
    frmMaintSplDutyAllow.submit();
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
        document.getElementsByName("txtParamFlg")[i].disabled = "";
        document.getElementsByName("txtCtgry")[i].disabled = "";
        document.getElementsByName("txtArea")[i].disabled = "";
      }
      if(document.getElementsByName("checked")[i].checked)
      {
        if(document.getElementsByName("detailId")[i].value=="" )
        {
          document.getElementsByName("itemChecked")[i].value = "Y";
          frmMaintSplDutyAllow.detailDataChanged.value = "true"; 
        }
        else
          strRecList=strRecList+(i+1)+",";
      }
    }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
   
    document.forms[0].action = "../../../SplDutyCdaDeleteRowAction.do";
    document.forms[0].submit();  
  }

  function getTab(arg)
  {
     // frmMaintHillCmpnstryAllow.headerPrimaryKey[0].disabled="";
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../SplDutyCdaTabAction.do";
    document.forms[0].submit();
  }

  function JumpDetail()
  {
    frmMaintSplDutyAllow.userPageRequested.value = 1*frmMaintSplDutyAllow.newPageRequested.value ;
    frmMaintSplDutyAllow.action = "../../../SplDutyCdaNextDetailAction.do";
    frmMaintSplDutyAllow.submit();
  }
  
  function ShowLovDsgn(i)
  {
   frmMaintSplDutyAllow.lovKey.value = "SCADsgnId" +frmMaintSplDutyAllow.screenName.value + "N";
   frmMaintSplDutyAllow.txtDisplayFields.value = "txtDsgn,txtDsgnId";
   frmMaintSplDutyAllow.txtSearchFields.value = "";
   frmMaintSplDutyAllow.txtIndex.value=i-1;
   if(frmMaintSplDutyAllow.txtCtgry.value)
   {
    frmMaintSplDutyAllow.queryParam.value="txtCtgry="+frmMaintSplDutyAllow.txtCtgry.value+" ";
   }
   else
   {
    frmMaintSplDutyAllow.queryParam.value="txtCtgry="+frmMaintSplDutyAllow.txtCtgry[i-1].value+" ";
   }
   
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintSplDutyAllow');
   frmMaintSplDutyAllow.detailDataChanged.value = "true";
   changed(i);
   return true;
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
    frmMaintSplDutyAllow.action="../../../SplDutyCdaGetHeaderAction.do"
    frmMaintSplDutyAllow.submit();
}

function doGetNextHeader()
{ 
    document.all.flagIda.value='false';
    document.all.flagCda.value='false';
    frmMaintSplDutyAllow.userPositionRequested.value = 1*frmMaintSplDutyAllow.positionRequested.value + 1;
    frmMaintSplDutyAllow.action="../../../SplDutyCdaGetNextHeader.do";
    frmMaintSplDutyAllow.submit();
}

function PrevHeader()
{
    document.all.flagIda.value='false';
    document.all.flagCda.value='false';
    frmMaintSplDutyAllow.userPositionRequested.value = 1*frmMaintSplDutyAllow.positionRequested.value - 1;
    frmMaintSplDutyAllow.action = "../../../SplDutyCdaGetNextHeader.do";
    frmMaintSplDutyAllow.submit();
}

function JumpHeader()
{
    document.all.flagIda.value='false';
    document.all.flagCda.value='false';
    frmMaintSplDutyAllow.userPositionRequested.value = 1*frmMaintSplDutyAllow.newPositionRequested.value;
    frmMaintSplDutyAllow.action = "../../../SplDutyCdaGetNextHeader.do";
    frmMaintSplDutyAllow.submit();
}

function doInsertMode()
{
  frmMaintSplDutyAllow.action="../../../SplDutyCdaInsertAction.do"
  frmMaintSplDutyAllow.submit();
}

function checkDuplicacy(rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb1 = document.getElementsByName("txtCtgry")[rInd-1].value;
  newComb2 = document.getElementsByName("txtPayScale")[rInd-1].value;
  newComb3 = document.getElementsByName("txtArea")[rInd-1].value;
  newComb=newComb1+"-"+newComb2+"-"+newComb3;
  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(rInd != ind && document.getElementsByName("status")[ind-1].value!='D')
    {
      oldComb1 = document.getElementsByName("txtCtgry")[ind-1].value;
      oldComb2 = document.getElementsByName("txtPayScale")[ind-1].value;
      oldComb3 = document.getElementsByName("txtArea")[ind-1].value;
      oldComb=oldComb1+"-"+oldComb2+"-"+oldComb3;
      if(oldComb.toUpperCase()==newComb.toUpperCase())
      {
        alert("Record Already Exists...");
          document.getElementsByName("txtCtgry")[rInd-1].value="";
      }
    }
  }
  return true;
}
</script>

