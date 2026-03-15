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


<html:form  action="MaintSCARate" name="frmMaintSCARate" type="FCIPAY.Payroll.WEBTIER.Form.MaintSCARateForm" scope="session">
<bean:define id="ParentForm" name="frmMaintSCARate" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN STATION COMPENSATORY ALLOWANCE RATES</TD>
  </TR>

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
                    <td bgcolor="#4682B4" nowrap class=actTabText>SCA Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                              <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintHraAll.city" /></TD>
                                              <TD class=tableHeader width="8%">SCA Rate</td>
                                              <td class=tableHeader width="10%">Effective From</td> 
                                      </TR>    

                         <logic:iterate id="scaInfo" name="frmMaintSCARate" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintSCARateBean" >
                              <% ++i; %>
                                <logic:notEqual name="scaInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                   <td align=center ><html:checkbox property="checked" name="frmMaintSCARate" onclick="checkRecord();" /></td>
                                     <logic:equal name="scaInfo" property="status" value="N" >
                      <!--                   <td colspan="1">
                                     <html:select property="txtType" name="scaInfo"  styleClass="required" alt="<%=String.valueOf(i) %>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                        <html:option value="">-----------Please Select-----------</html:option>
                                        <html:option value="ALL">ALL</html:option>
                                        <html:option value="CDA">CDA</html:option>
                                        <html:option value="IDA">IDA</html:option>
                                        </html:select>
                                        </td>  -->
                                      <html:hidden property="txtType" name="scaInfo" value="IDA" />
                                       <td colspan="1"><html:select property="txtTypeofCity" name="scaInfo"  styleClass="required" alt="<%=String.valueOf(i) %>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                      <html:option value="" >-----------Please Select-----------</html:option>      
                                      <logic:present name="SCACities">
                                        <html:optionsCollection label="label" value="value" property="cityList" name="SCACities"/>
                                      </logic:present>
                                    </html:select></td>
  
                                       <td ><html:text property="txtSCAAmt" name="scaInfo" size="9"  maxlength = "3" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i) %>" onchange="
                                       if (!percent_Check(this.value))
                                            return false;
                                       else
                                           changed(this.alt);
                                       " /></td>                                               

                                    <td><html:text property="txtStartDt" name="scaInfo"  styleClass="required" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i) %>" readonly="true" onchange="return chkFromDt(this.alt);" />       
                                        <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf((i-1)) %>" onclick="showCalendar('txtStartDt',this)" />
                                    </td>
                                      </logic:equal>
                                      <logic:notEqual name="scaInfo" property="status" value="N" >
                                      <html:hidden property="txtType" name="scaInfo" value="IDA" /> 
              
                                       <td colspan="1"><html:select property="txtTypeofCity" name="scaInfo" disabled="true"  styleClass="required" alt="<%=String.valueOf(i) %>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                      <html:option value="" >-----------Please Select-----------</html:option>      
                                      <logic:present name="SCACities">
                                        <html:optionsCollection label="label" value="value" property="cityList" name="SCACities"/>
                                      </logic:present>
                                    </html:select></td>
  
                                       <td ><html:text property="txtSCAAmt" name="scaInfo" size="9" readonly="true"  maxlength = "3" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i) %>" onchange="
                                       if (!percent_Check(this.value))
                                            return false;
                                       else
                                           changed(this.alt);
                                       " /></td>                                               

                                    <td><html:text property="txtStartDt" name="scaInfo" styleClass="required" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i) %>" readonly="true" onchange="return chkFromDt(this.alt);" />       
                                        <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf((i-1)) %>" />
                                    </td>
                                      </logic:notEqual>
                                     <html:hidden property="txtEndDt" name="scaInfo" />
                                       <html:hidden property="itemChecked" name="scaInfo" />
                                       <html:hidden property="status" name="scaInfo" />
                                       <html:hidden property="detailId" name="scaInfo" />
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="scaInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintSCARate" value="notchecked" /></td>
                                       <td ><html:hidden property="txtType" name="scaInfo" /></td>
                                       <td ><html:hidden property="txtTypeofCity" name="scaInfo" /></td>
                                       <td ><html:hidden property="txtSCAAmt" name="scaInfo" /></td>
                                       <td ><html:hidden property="txtStartDt" name="scaInfo" /></td>
                                       <td ><html:hidden property="txtEndDt" name="scaInfo" /></td>
                                       <html:hidden property="itemChecked" name="scaInfo" />
                                       <html:hidden property="status" name="scaInfo" />
                                       <html:hidden property="detailId" name="scaInfo" />
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
<html:hidden property="headerPrimaryKey" name="frmMaintSCARate" value="Default" />
<html:hidden property="screenMode" name="frmMaintSCARate"  />
<html:hidden name="frmMaintSCARate"  property="screenName" value="SCAScreen" />
<html:hidden name="frmMaintSCARate"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmMaintSCARate"  />
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
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
    }
    if(screenmode=='Q')
    {
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";
    } 
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;

    detMenuHandling(screenmode);
    
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

  function doQueryMode()
  {
    frmMaintSCARate.action="../../../ScaQueryAction.do";
    frmMaintSCARate.submit();
  }

  function changed(val)
  {
    frmMaintSCARate.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
  }
    
  function doBaseAddRow()
  {
    if(mandatory_Check("frmMaintSCARate"))
    {
      enable();
      document.forms[0].action = "../../../ScaAddRowAction.do";
      document.forms[0].submit();
    }
    else
    {
      return false;
    }
  }

  function SaveRecord()
  {
    if(mandatory_Check("frmMaintSCARate"))
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
        document.getElementsByName("txtType")[i].disabled="";
        document.getElementsByName("txtTypeofCity")[i].disabled="";
        if (document.getElementsByName("status")[i].value == 'D')
          frmMaintSCARate.detailDataChanged.value = "true";
      }
      frmMaintSCARate.headerFields.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintSCARate.action = "../../../ScaSaveAction.do";
      // frmMaintHraRate.totalDetailRecord.value=parseInt(iTr2)-1;
      frmMaintSCARate.submit();
    }
    else
    {
      return false;
    }
  }

  function doQueryMode()
  {
    frmMaintSCARate.action="../../../ScaQueryAction.do"
    frmMaintSCARate.submit();
  }

  function GetDetail()
  {
    document.all.screenMode.value='U'; 
    frmMaintSCARate.action="../../../ScaGetDetailAction.do"
    frmMaintSCARate.submit();
  }

  function checkDuplicacy(that,rInd)
  {
    lengthOfTable = document.getElementById("Detail").rows.length;
    newComb = document.getElementsByName("txtType")[rInd-1].value;
    newComb = newComb + "-";
    newComb = newComb + document.getElementsByName("txtTypeofCity")[rInd-1].value;

    for(ind = lengthOfTable - 1; ind > 0; ind --)
    {
      if(ind != rInd)
      {
        oldComb = document.getElementsByName("txtType")[ind-1].value;
        oldComb = oldComb + "-";
        oldComb = oldComb + document.getElementsByName("txtTypeofCity")[ind-1].value;
        if(oldComb == newComb)
        {
         // alert("You can\'t enter duplicate value");
          var response=confirm("There is already a record. Do You still want to continue ?");
          if(response==false)
          {
              document.getElementsByName("txtType")[rInd-1].value="";
              document.getElementsByName("txtTypeofCity")[rInd-1].value="";
              document.getElementsByName("txtType")[rInd-1].focus();
          }
          return;
        }
      }
    }
  }

  function doRefresh()
  {
    frmMaintSCARate.action="../../../ScaRefresh.do";
    frmMaintSCARate.submit();
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
        if(document.getElementsByName("detailId")[i].value=="" )
        {
          document.getElementsByName("itemChecked")[i].value = "Y";
          frmMaintSCARate.detailDataChanged.value = "true";
        }
        else
          strRecList=strRecList+(i+1)+",";

      }
    }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
    document.forms[0].action = "../../../ScaDeleteRowAction.do";
    document.forms[0].submit();  
  }
  
  function changedDt(val)
  {
    frmMaintSCARate.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
    flgResult=confirm("This will make the record obsolete ");
    if(!flgResult)
    {
      document.getElementsByName("txtEndDt")[val-1].value = '';
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
      for(i=0; i < iTr2-1; i++)
      {
        document.getElementsByName("txtType")[i].disabled="";
        document.getElementsByName("txtTypeofCity")[i].disabled="";
      }
}
  function setEndDt(rInd)
  {
    lengthOfTable = document.getElementById("Detail").rows.length;
    newComb = document.getElementsByName("txtType")[rInd-1].value;
    newComb = newComb + "-";
    newComb = newComb + document.getElementsByName("txtTypeofCity")[rInd-1].value;
    selDt= document.getElementsByName("txtStartDt")[rInd-1].value;
    for(ind = lengthOfTable - 1; ind > 0; ind --)
    {
      if(ind != rInd)
      {
        oldComb = document.getElementsByName("txtType")[ind-1].value;
        oldComb = oldComb + "-";
        oldComb = oldComb + document.getElementsByName("txtTypeofCity")[ind-1].value;
        startDt= document.getElementsByName("txtStartDt")[ind-1].value;
        if(oldComb == newComb)
        {
          if (!cmpDate(startDt,selDt,0))
          {
            alert("Start Date must be greater than prev start date");
            document.getElementsByName("txtStartDt")[rInd-1].value="";
            return false;                      
          }else
          {               
            document.getElementsByName("txtEndDt")[ind-1].value=selDt;
            frmMaintSCARate.detailDataChanged.value = "true";
            if (document.getElementsByName("status")[ind-1].value == 'Q')
              document.getElementsByName("status")[ind-1].value = 'U';
            return;
          }
        }
      }
    }
  }
  
  function chkFromDt(i)
{
  var fromDt=document.getElementsByName("txtStartDt")[i-1].value;
  if(!cmpSysDate(fromDt,0))
    { 
      document.getElementsByName("txtStartDt")[i-1].value="";
      return false;
    }
  setEndDt(i);
}
</script>

