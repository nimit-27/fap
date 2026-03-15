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
<BODY onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">

<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>


<html:form  action="payHist" name="historyInfo" type="FCIPAY.Payroll.WEBTIER.Form.PaymentHistoryForm" scope="session">
 <bean:define id="ParentForm" name="historyInfo" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />




<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>PAYMENT HISTORY</TD>
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
              <html:hidden property="txtPayHead" name="historyInfo" />
              <html:hidden property="txtEmpNo" name="historyInfo" />                
            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText>Payment History Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                            <DIV id=divDtlTable style="height:220px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                <TBODY>
                                     <TR height="20">
                                              <td class=tableHeader width="4%"><html:checkbox property="selectAll" value="" onclick="toggleCheckBox('selectAll');changeDelete();" /></td>
                                              <TD class=tableHeader width="8%"><bean:message  key="Payroll.ComFinalSet.amount" /></TD>
                                              <TD class=tableHeader width="8%"><bean:message  key="Payroll.ComFinalSet.date" /></td>
                                              <TD class=tableHeader width="8%"><bean:message  key="Payroll.ComFinalSet.rem" /></td>
                                      </TR>    

                         <logic:iterate id="history" name="historyInfo" property="lstInstrDtls1" type="FCIPAY.Payroll.UTILITY.PaymentHistoryBean" >
                              <% ++i; %>
                                <logic:notEqual name="history" property="status" value="D" >                              
                                   <tr>   <% ++j; %> 
                                      
                                       <html:hidden property="txtSerialNo" name="history" />
                                       <td  width="1%" align="center"><html:checkbox property="checked" onclick="changeDelete();" /></td>
                                       <td ><html:text property="txtPayAmt" name="history" size="9"  styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.value,this.alt)" /></td>                                               
                                       <td ><html:text property="txtPayDate" name="history" size="9"  styleClass="required" style="width:90%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.value,this.alt)" />&nbsp;<img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butPayDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('txtPayDate',this)"  ></td>                                              
                                       <td ><html:text property="txtRemark" name="history" size="9"  styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.value,this.alt)" /></td>                                               

                          
                                       <html:hidden property="itemChecked" name="history" />
                                       <html:hidden property="status" name="history" />
                                       <html:hidden property="detailId" name="history" value="Default"/>
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="history" property="status" value="D" >
                                   <tr>
                                       <html:hidden property="txtSerialNo" name="history" />
                                       <td  width="1%" ><html:hidden property="checked" name="history" value="notchecked"  /></td>
                                       <td ><html:hidden property="txtPayAmt" name="history" /></td>
                                       <td ><html:hidden property="txtPayDate" name="history" /></td>
                                       <td ><html:hidden property="txtRemark" name="history" /></td>
                                        
                                       <html:hidden property="itemChecked" name="history" />
                                       <html:hidden property="status" name="history" />
                                       <html:hidden property="detailId" name="history" value="Default"/>
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
                                    <TD><html:button value='Get Detail'  onclick="doGetDetail()" property="butDetail" styleClass="bottomBarText" /><html:button value=' Add Row ' onclick="doBaseAddRow()" property="butInsert" styleClass="bottomBarText" /><html:button value='Delete Row' onclick="doBaseDelRow()" property="butDelete" styleClass="bottomBarText" disabled="true" /></TD>
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
<html:hidden property="headerPrimaryKey" name="historyInfo" value="Default" />
<html:hidden property="screenMode" name="historyInfo"  />
<html:hidden name="historyInfo"  property="screenName" value="PaymentHistoryScreen" />
<html:hidden name="historyInfo"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="historyInfo"  />
<html:hidden property="flag" name="historyInfo"  />
<html:hidden property="buttonFlag" name="historyInfo"  />
</html:form>
</body>
</html:html>
<script language="javascript">
function lfnLoad()
{ 
  if(opener.document.all.hdnClick.value == '0')
  {
    opener.document.all.hdnClick.value = '1';
    doQueryMode();
  }
  document.all.txtEmpNo.value=opener.document.all.txtEmpNo.value;
  document.all.txtPayHead.value=opener.document.all.hdnHead.value;
  mode = document.all.screenMode.value;
  if(mode == '')
  {
    doQueryMode();
  }
  menuHandling(mode);
  if(mode=='Q')
  {
      document.all.butInsert.disabled="true";
  }
  if(mode=='U')
  {
    if(document.all.flag.value=='')
    {
      document.all.butDetail.disabled="";
      document.all.butInsert.disabled="true";
    }
    if(document.all.flag.value=='G')
    {
      document.all.butDetail.disabled="true";
      document.all.butInsert.disabled="";
    }
  }
  document.all.butQueryMode.disabled="true";    
  document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg"; 
  document.all.butDel.disabled="true";    
  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";  
  document.all.butExecute.disabled="true";    
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";     
  document.all.butInsertMode.disabled="true";    
  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
}
function changed(val,ind)
{  
  historyInfo.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[ind-1].value == 'Q')
    document.getElementsByName("status")[ind-1].value = 'U';
}
function doBaseAddRow()
{
  if(mandatory_Check("historyInfo"))
  {  
    document.forms[0].action = "../../../PayHistAddRowAction.do";
    document.all.flag.value='G';
    document.forms[0].submit();  
  }
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
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      historyInfo.detailDataChanged.value = "true";  
      document.all.buttonFlag.value='D';  
    }
  }
  document.all.flag.value='G';  
  document.forms[0].action = "../../../PayHistDelRowAction.do";
  document.forms[0].submit();  
}
function doQueryMode()
{
  historyInfo.action="../../../payHistQueryMode.do";
  document.all.flag.value='';
  historyInfo.submit();
}  
function doGetDetail()
{
  historyInfo.screenMode.value = 'U';
  historyInfo.action="../../../PayHistGetDetail.do";
  document.all.flag.value='G';
  historyInfo.submit();
}  
function changeDelete()
{
  var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
      var fl = 0;
      for(i=0; i < iTr2 - 1; i++)
      {

        if(document.getElementsByName("checked")[i].checked)
        {
            document.all.butDelete.disabled="";
            return true;
        }
      }
      if(fl == 0)   
      {      
          document.all.butDelete.disabled="true";
          return false;
      }
}
function SaveRecord()
{
  if(mandatory_Check("historyInfo"))
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
          historyInfo.detailDataChanged.value = "true";
        if (document.getElementsByName("status")[i].value == 'N')
          historyInfo.detailDataChanged.value = "true";
        if (document.getElementsByName("status")[i].value == 'U')
          historyInfo.detailDataChanged.value = "true";
      }
      historyInfo.headerPrimaryKey.value = document.all.txtEmpNo.value + "," + document.all.txtPayHead.value;   
      historyInfo.totalDetailRecord.value = parseInt(iTr2,10)-1; 
      historyInfo.buttonFlag.value='';
      var type = document.all.txtPayHead.value;
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var amt = 0;
      if(oTable.rows.length == 2)
      {
        amt = amt + parseInt(document.all.txtPayAmt.value,10);
      }
      else
      {
        for(i=1; i < oTable.rows.length; i++)
        {
          amt = amt + parseInt(document.all.txtPayAmt[i-1].value,10);
        }
      }
      if(type == '1')
      {
        opener.document.all.txtPenPaidAmt.value=amt;
      }
      if(type == '2')
      {
        opener.document.all.txtGraPaidAmt.value=amt;
      }
      if(type == '3')
      {
        opener.document.all.txtLeavePaidAmt.value=amt;
      }
      if(type == '4')
      {
        opener.document.all.txtPFSettlePaidAmt.value=amt;
      }
      if(type == '5')
      {
        opener.document.all.txtGISPaidAmt.value=amt;
      }
      opener.document.all.headerDataChanged.value = 'true';
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      historyInfo.action = "../../../PayHistSaveAction.do";
      historyInfo.submit();
  }
  else
  {
    return false;
  }
}
function doRefresh()
{  
  document.all.buttonFlag.value='';
  historyInfo.action="../../../PayHistRefresh.do"
  historyInfo.submit();
}
function showCalendar(inputId, butId) {  
   if(butId.alt)
   {
    iIndex=butId.alt;
   }
   else
   {
    iIndex="-1";
   }
   Calendar.setup({inputField	: inputId,
		   ifFormat	: "%d-%b-%Y",
		   button	: butId,
       position: iIndex
  		  });
        
   return false;
}
function doOnChangeCalendar(buttonName)
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
    historyInfo.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[i].value == 'Q')
       document.getElementsByName("status")[i].value = 'U';  
  }
}
</script>

