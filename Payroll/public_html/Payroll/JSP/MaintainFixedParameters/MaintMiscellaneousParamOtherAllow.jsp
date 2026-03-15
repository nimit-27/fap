<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
     
</head>
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintMiscellaneousParam" name="frmMaintMiscellaneousParam" type="FCIPAY.Payroll.WEBTIER.Form.MaintMiscellaneousParamForm" scope="session">
<bean:define id="ParentForm" name="frmMaintMiscellaneousParam" toScope="request" />
 <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>


<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN MISCELLANEOUS PARAMETERS</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
   <TR>
    <TD>

 <TABLE cellSpacing=0 cellPadding=0 >
       <!--General Information Row Starts -->
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="6"></td>
         </tr>
          
                                 
        </table>
        

    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="20">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("wash") > Washing Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("proj")> Project Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
<!--                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("over")> Over Time Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>  -->
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("nduty")> Night Duty Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    <!--<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > Other Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>-->
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText  onclick=doGetTab("upgrade") > Upgrade Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText >      Others     <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>


                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 </TABLE>
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                          <TBODY>
                       

                        <TR height=20>
                          <TD  class=subHeader colSpan=11  align = "center" height=5>Deputation Allowance</TD>
                        </TR>                                
                          <TR>                            
                              <td  width="20%" class=labelText><bean:message key="pay.MaintMiscellaneousParam.txtWSameSt" /></td>
                              <td td  width="30%"> <html:text  property="txtWSameSt"  style="text-align:right" styleClass="optional" altKey="pay.MaintMiscellaneousParam.txtWSameSt" maxlength="10" size="23"  onchange="perCheck(this.value);"  />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.basic" />
                              </td>
                              <td  width="25%" class=labelText><bean:message key="pay.MaintMiscellaneousParam.txtOutSt" /></td>
                              <td td  width="25%"><html:text  property="txtOutSt" style="text-align:right"   styleClass = "optional" altKey="pay.MaintMiscellaneousParam.txtOutSt" maxlength="10" size="23" onchange="perCheck(this.value);"  />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.basic" />
                              </td>                              
                          </tr> 


                         <TR>                            
                              <td width="20%" class=labelText><bean:message key="pay.MaintMiscellaneousParam.txtDA" /></td>
                              <td td width="30%"><html:text  property="txtDASame"  style="text-align:right" styleClass = "optional" altKey="pay.MaintMiscellaneousParam.txtDA" maxlength="10"   size="23" onchange="lfnChange(this.value);"  />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.rs" />
                              </td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintMiscellaneousParam.txtDA" /></td>
                              <td td width="25%"><html:text  property="txtDAOut" altKey="pay.MaintMiscellaneousParam.txtDA" maxlength="10" style="text-align:right" size="23" styleClass="optional" onchange="lfnChange(this.value);"  />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.rs" />
                              </td>
                          </tr> 
                      
	                        <tr height = 10><td></td></tr>
                          
                          <tr height = 10><td></td></tr>                                                   
                            
                      <TR>
                            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                      </TR> 
                       <tr height = 10><td></td></tr>  
                          <TR>
                            <td colspan=6 >
                            <table>
                            <tr>
                              <td  width="15%" class=labelText><bean:message key="pay.MaintMiscellaneousParam.txtEdAllow" /><br />( per child ) </td>
                              <td align="left" ><html:text  property="txtEdAllow" style="text-align:right" styleClass = "optional" altKey="pay.MaintMiscellaneousParam.txtEdAllow" maxlength="10" size="23" onchange="lfnChange(this.value);"  /></td>
                              <td  width="15%" class=labelText>EPF Deduction</td>
                              <td align="left" ><html:text  property="txtPf" style="text-align:right" altKey="pay.MaintMiscellaneousParam.txtPf" maxlength="10" size="23" styleClass="optional" onchange="percentCheck(this.value);"  />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.p" /></td>
                              <td  class="labelText"  width="20%" >GPF Deduction </td>
                              <td  align="left" ><html:text  property="txtGPF" style="text-align:right" altKey="pay.MaintMiscellaneousParam.txtHosSub" maxlength="10" size="23" styleClass="optional" onchange="percentCheck(this.value);"  />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.p" /></td>                              
                          </tr> 

                         <TR>
                            
                              <td  width="15%" class=labelText><bean:message key="pay.MaintMiscellaneousParam.txtMaxChild" /></td>
                              <td  align="left" ><html:text  property="txtMaxChild" style="text-align:right" styleClass = "optional" altKey="pay.MaintMiscellaneousParam.txtMaxChild" maxlength="10" size="23" onchange="lfnChange(this.value);"  /></td>
                              <td  width="15%" class=labelText><bean:message key="pay.MaintMiscellaneousParam.txtCPf" /></td>
                              <td  align="left" ><html:text  property="txtCPF" style="text-align:right" altKey="pay.MaintMiscellaneousParam.txtCPf" maxlength="10" size="23" styleClass="optional" onchange="percentCheck(this.value);"  />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.p" /></td>
                              <td class="labelText"  width="20%" >ENCPF Deduction </td>
                               <td align="left" ><html:text  property="txtENCPF" style="text-align:right" altKey="pay.MaintMiscellaneousParam.txtOldCant" maxlength="10" size="23" styleClass="optional" onchange="percentCheck(this.value);"  />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.p" /></td>
                              
                          </tr> 


                         <TR>
                            
                              <td  width="15%" class=labelText><bean:message key="pay.MaintMiscellaneousParam.txtMaxAbsRate" /></td>
                              <td  align="left" ><html:text  property="txtMaxAbsRate" style="text-align:right" styleClass = "optional" altKey="pay.MaintMiscellaneousParam.txtMaxChild" maxlength="7" size="23" onchange="lfnChange(this.value);"  /></td>
                         </tr>                          

                        
                        </table>
                        </td>
                        </tr>
                                
                        
                          
                          <tr height = 10><td></td></tr>                                                   
                            
                         </TBODY>
                          </TABLE>
                        





 


  

                <!-- Bottom Blue Bar -->
             <TR>
                 <td>
                      <jsp:include  page = "../INCLUDES/BottomBlueBar.jsp" flush="true" />
                 </td>
             </TR>
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->
<html:hidden name="frmMaintMiscellaneousParam"  property="screenName" value="MiscOtherParamScreen" />
<html:hidden name="frmMaintMiscellaneousParam"  property="forwardedPage" />
<html:hidden property="headerPrimaryKey" name="frmMaintMiscellaneousParam" />
<html:hidden property="screenMode" name="frmMaintMiscellaneousParam" />
<html:hidden property="positionRequested" name="frmMaintMiscellaneousParam" />
<html:hidden property="buttonFlag" name="frmMaintMiscellaneousParam"  />
<html:hidden property="flagOther" name="frmMaintMiscellaneousParam" />


</html:form>
</body>
</html:html>      


<script language="javascript">

function lfnLoad()
{
  mode = document.all.screenMode.value;
  tot = document.all.flagOther.value;
  if(mode=='' )
  {
      doQueryMode();
  }

  if(tot=='true')
  {
      hedMenuHandling('U');
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      
  }
  else
  {
      hedMenuHandling('Q');
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
  }

//    frmMaintMiscellaneousParam.tempOldCant.value = frmMaintMiscellaneousParam.txtCurrCant.value;
  
}

 function lfnChange(val)
{
  if(num_Check(val,1))
    frmMaintMiscellaneousParam.headerDataChanged.value = "true";
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}


function diffChange(val)
{
  if(num_Check(val,1))
  {
//    frmMaintMiscellaneousParam.txtOldCant.value = frmMaintMiscellaneousParam.tempOldCant.value;
    frmMaintMiscellaneousParam.headerDataChanged.value = "true";
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}



 function perCheck(val)
{
  if(num_Check(val,1))
  {
    var num = parseInt(val);
    if(num>0 && num<100)
      frmMaintMiscellaneousParam.headerDataChanged.value = "true";
    else 
    {
      alert("Value Should be greater than 0 and less than 100");
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
    }
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}


 function percentCheck(val)
{
   if(!percent_Check(val))
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;
    }
   else
   return true;
}


function doInsertMode()
{
  frmMaintMiscellaneousParam.action="../../../otherNewMode.do"
  frmMaintMiscellaneousParam.submit();
}

function doQueryMode()
{
  frmMaintMiscellaneousParam.action="../../../otherQueryMode.do"
  frmMaintMiscellaneousParam.submit();
}


function doRefresh()
{
  frmMaintMiscellaneousParam.action="../../../otherRefresh.do"
  frmMaintMiscellaneousParam.submit();
}

function getHeaderRecord()
{
	frmMaintMiscellaneousParam.flagOther.value="true";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";

	frmMaintMiscellaneousParam.action="../../../otherFirstGetHeaderAction.do"
	frmMaintMiscellaneousParam.submit();
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintMiscellaneousParam"))
  {
      frmMaintMiscellaneousParam.headerPrimaryKey.value = "##";
      frmMaintMiscellaneousParam.detailDataChanged.value = "false";  
      if(frmMaintMiscellaneousParam.screenMode.value == "N")
        frmMaintMiscellaneousParam.headerDataChanged.value = "true";  
  
      frmMaintMiscellaneousParam.headerFields.value = "true";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintMiscellaneousParam.action = "../../../otherSaveAction.do";
      frmMaintMiscellaneousParam.submit();
  }
  else
  {
    return false;
  }
}


 function doGetTab(arg)
 {
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../OtherTabAction.do";
    document.forms[0].submit();
 }
</script>
