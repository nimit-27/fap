<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
</head>
<BODY scroll=no onload="lfnLoad()" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintPayCodesBase" name="frmMaintPayCodes" type="FCIPAY.Payroll.WEBTIER.Form.MaintPayCodesForm" scope="session">
<bean:define id="ParentForm" name="frmMaintPayCodes" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN PAY CODES</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
    <TR>
      <TD>	
        <!--<div id=divBody>-->
        <!-- Body table Starts -->
        <TABLE cellSpacing=0 cellPadding=0 border=0>
        <!--Account  Header Row Starts -->
          <TR>
            <TD class=subHeader colspan=6>Pay Codes</TD>
          </TR>
          <TR>
            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
          </TR>

          <tr height="15" >
            <td colspan="4"></td>
          </tr>
       
          <TR>                            
            <td width="50%" class="radioText" colspan=2><input type="radio" name="radioSave" value="S" onclick="OptClick(1)"   >Pay Code Wise
            
            <td width="50%" class="radioText" colspan=2><input type="radio" name="radioMisc" value="M" onclick="OptClick(2)" >All
          <td colspan="4" ></td>          
          </TR>
          
          <tr height="10">	
            <td></td>
          </tr>       
          
          <logic:equal property= "optVal" name= "frmMaintPayCodes" value="1">
          <tr>
          <td class="labelText"  width="20%" >From</td>
          <td><html:text  property="txtFromPayCode" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="5" size="23" styleClass="required" /></td>
          <td class="labelText"  width="20%" >To</td>
          <td><html:text  property="txtToPayCode" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="5" size="23" styleClass="required" /></td>
          </tr>
          </logic:equal>
          
          <logic:notEqual property= "optVal" name= "frmMaintPayCodes" value="1">
          <tr>
          <html:hidden  property="txtFromPayCode" value="" />
          <html:hidden  property="txtToPayCode" value="" />
          </tr>
          </logic:notEqual>
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Pay Codes Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                            <DIV id=divDtlTable style="height:340px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                <TBODY>
                                  <TR height="22" >
                                      <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                      <td class=tableHeader width="5%"><bean:message key="pr.PayCode.code" /></td>
                                      <td class=tableHeader width="5%"><bean:message key="pr.PayCode.description" /></td>
                                      <td class=tableHeader width="5%"><bean:message key="pr.PayCode.taxindicator" /></td>
                                      <td class=tableHeader width="5%"><bean:message key="pr.PayCode.savrebate" /></td>
                                      <td class=tableHeader width="5%"><bean:message key="pr.PayCode.reblmt" /></td>
                                      <td class=tableHeader width="5%"><bean:message key="pr.PayCode.adjpriority" /></td>
                                      <td class=tableHeader width="5%"><bean:message key="Pay.Paycode.ProfTaxFlag" /></td>                                      
                                   </tr> 
                           <logic:iterate id="paycodeInfo" name="frmMaintPayCodes" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintPayCodesBean" >
                              <% ++i; %>
                                <logic:notEqual name="paycodeInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                       <td align="center" ><html:checkbox property="checked" name="frmMaintPayCodes" onclick="checkRecord();" /></td>
                                       <html:hidden property="txtSrlNo" name="paycodeInfo"  alt="<%=String.valueOf(i)%>" />
                                       <td ><html:text property="txtPayCode" name="paycodeInfo"  styleClass="required" size="19" style="width:100%" alt="<%=String.valueOf(i)%>"  onblur="checkPayCode(this.alt); checkDuplicacy('txtPayCode',this.alt);"  onchange="lfnChange(this.value,this.alt);" /></td>
                                       <td ><html:text property="txtPayCodeDesc" name="paycodeInfo" size="5" styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>"  onchange="checkDuplicacy('txtPayCodeDesc',this.alt); return changed(this.alt);" /></td>
                                       <td ><html:select property="lstTaxableIndicator" name="paycodeInfo" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
                                             <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                                             <html:option value="Y" > <bean:message key="Pay.Paycode.Yes" /></html:option>
                                             <html:option value="N" > <bean:message key="Pay.Paycode.No" /></html:option>
                                             </html:select>
                                      </td>
                                       <td ><html:select property="lstSavingsRebate" name="paycodeInfo" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
                                             <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                                             <html:option value="R" > <bean:message key="Pay.Paycode.Rebate" /></html:option>                                             
                                             <html:option value="I" > <bean:message key="Pay.Paycode.Inc" /></html:option>
                                             <html:option value="D" > <bean:message key="Pay.Paycode.Deduction" /></html:option>
                                             </html:select>
                                      </td>
                                       <td ><html:text property="txtRebateLimit" name="paycodeInfo" size="5" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="changeData(this.value,this.alt);" /></td>
                                       <td ><html:text property="txtAdjPriority" name="paycodeInfo" size="5" styleClass="optional" maxlength="5" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);" /></td>

                                       <td ><html:select property="lstProfTaxFlag" name="paycodeInfo" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
                                             <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                                             <html:option value="Y" > <bean:message key="Pay.Paycode.Yes" /></html:option>
                                             <html:option value="N" > <bean:message key="Pay.Paycode.No" /></html:option>
                                             </html:select>
                                      </td>                                       

                                       
                                       <html:hidden property="itemChecked" name="paycodeInfo" />
                                       <html:hidden property="status" name="paycodeInfo" />
                                       <html:hidden property="detailId" name="paycodeInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>
                                  <logic:equal name="paycodeInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintPayCodes" value="notchecked" /></td>
                                       <html:hidden property="txtSrlNo" name="paycodeInfo" />
                                       <td ><html:hidden property="txtPayCode" name="paycodeInfo" /></td>
                                       <td ><html:hidden property="txtPayCodeDesc" name="paycodeInfo" /></td>
                                       <td ><html:hidden property="lstTaxableIndicator" name="paycodeInfo" /></td>
                                       <td ><html:hidden property="lstSavingsRebate" name="paycodeInfo" /></td>
                                       <td ><html:hidden property="txtRebateLimit" name="paycodeInfo" /></td>
                                       <td ><html:hidden property="txtAdjPriority" name="paycodeInfo" /></td>
                                       <td ><html:hidden property="lstProfTaxFlag" name="paycodeInfo" /></td>                                                                              
                                       <html:hidden property="itemChecked" name="paycodeInfo" />
                                       <html:hidden property="status" name="paycodeInfo" />
                                       <html:hidden property="detailId" name="paycodeInfo" value="Default"/>
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
                                  <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
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
<html:hidden property="headerPrimaryKey" name="frmMaintPayCodes" value="Default" />
<html:hidden property="screenMode" name="frmMaintPayCodes" />
<html:hidden name="frmMaintPayCodes"  property="screenName" value="PayCodeScreen" />
<html:hidden name="frmMaintPayCodes"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintPayCodes" />
<html:hidden property="pageRequested" name="frmMaintPayCodes" />
<html:hidden property="positionRequested" name="frmMaintPayCodes" />
<html:hidden property="totalCount" name="frmMaintPayCodes" />
<html:hidden property="userPageRequested" name="frmMaintPayCodes" />
<html:hidden property="userPositionRequested" name="frmMaintPayCodes" />
<html:hidden property="buttonFlag" name="frmMaintPayCodes"  />
<html:hidden property="optVal" name="frmMaintPayCodes"  />


</html:form>
</body>
</html:html>

                        
                        
         


<script language="javascript">
    
 function changed(val)
{
  frmMaintPayCodes.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}

function checkDuplicacy(that,rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName(that)[rInd-1].value;
  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(rInd != ind)
    {
      oldComb = document.getElementsByName(that)[ind-1].value;
      if(oldComb.toUpperCase()==newComb.toUpperCase())
      {
        alert("You can\'t enter duplicate value");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
        return false;
      }
    }
  }
  return true;
}

function getHeaderRecord()
{
}


function lfnChange(val,ind)
{
  if(num_Check(val,1))
  {
      frmMaintPayCodes.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}


function changeData(val,ind)
{
  if(validate_Float(val, 9, 2))
  {
      frmMaintPayCodes.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

function doGetNextHeader()
{
}

function doBaseAddRow()
{

  if(mandatory_Check("frmMaintPayCodes"))
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
          document.getElementsByName("lstSavingsRebate")[i].disabled="";
          document.getElementsByName("lstTaxableIndicator")[i].disabled="";
          document.getElementsByName("txtRebateLimit")[i].disabled="";        
          document.getElementsByName("txtPayCode")[i].disabled="";      
          document.getElementsByName("lstProfTaxFlag")[i].disabled="";                    
      }
      //  var response=confirm("You might not have the permission to insert a pay code & it might not get reflected further.Do you still want to continue??"); 
   //     if(response==true)
    //    {
          document.forms[0].action = "../../../payCodesAddRowAction.do";
          document.forms[0].submit();
     //   }
     //   else
     //     return false;
  }
  else
  {
    return false;
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
      frmMaintPayCodes.detailDataChanged.value = "true";      
    }

          document.getElementsByName("lstSavingsRebate")[i].disabled="";
          document.getElementsByName("lstTaxableIndicator")[i].disabled="";
          document.getElementsByName("txtRebateLimit")[i].disabled="";        
          document.getElementsByName("txtPayCode")[i].disabled="";      
          document.getElementsByName("lstProfTaxFlag")[i].disabled="";                    
  }
  
  document.forms[0].action = "../../../payCodeDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintPayCodes"))
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
          document.getElementsByName("lstSavingsRebate")[i].disabled="";
          document.getElementsByName("lstTaxableIndicator")[i].disabled="";
          document.getElementsByName("txtRebateLimit")[i].disabled="";        
          document.getElementsByName("txtPayCode")[i].disabled="";      
          document.getElementsByName("lstProfTaxFlag")[i].disabled="";                                      

          if (document.getElementsByName("status")[i].value == 'D')
            frmMaintPayCodes.detailDataChanged.value = "true";
      }

      frmMaintPayCodes.totalDetailRecord.value = parseInt(iTr2)-1;  
      frmMaintPayCodes.headerFields.value = "false";  
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintPayCodes.action = "../../../payCodeSaveAction.do";
      frmMaintPayCodes.submit();
  }
  else
  {
    return false;
  }
}

function GetDetail()
{
  if(mandatory_Check("frmMaintPayCodes"))
  {
  frmMaintPayCodes.screenMode.value="U";
  frmMaintPayCodes.action="../../../payCodeFirstGetDetailAction.do";
  frmMaintPayCodes.submit();
  }
}

function doInsertMode()
{
//  frmMaintPayCodes.action="../../../PayCodeNewMode.do"
//  frmMaintPayCodes.submit();
}

function doQueryMode()
{
  frmMaintPayCodes.action="../../../PayCodeQueryMode.do"
  frmMaintPayCodes.submit();
}

function doRefresh()
{
  frmMaintPayCodes.action="../../../PayCodeRefresh.do"
  frmMaintPayCodes.submit();
}
function checkPayCode(val)
{
        var tempPayCode = document.getElementsByName("txtPayCode")[val -1].value;
        if (parseInt(tempPayCode,10) > 999)
        {
            alert("Pay Code should always be a 3 digit no.");            
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;
        }
        else if(parseInt(tempPayCode.substring(0,1),10) == 5) 
        {
                if(parseInt(tempPayCode) >=550 && parseInt(tempPayCode) <=599 )
                {
                  document.getElementsByName("txtRebateLimit")[val - 1].disabled="";        
                }
                else
                {
                  document.getElementsByName("txtRebateLimit")[val - 1].disabled="true";        
                }
        
          document.getElementsByName("lstSavingsRebate")[val - 1].style.background="#ffffd3";
          document.getElementsByName("lstTaxableIndicator")[val - 1].style.background="#ffffff";
          document.getElementsByName("lstSavingsRebate")[val - 1].className="required";
          document.getElementsByName("lstTaxableIndicator")[val - 1].className="optional";
          document.getElementsByName("lstTaxableIndicator")[val - 1].disabled="true";        
          document.getElementsByName("lstSavingsRebate")[val - 1].disabled="";

          document.getElementsByName("lstProfTaxFlag")[val - 1].className="optional";
          document.getElementsByName("lstProfTaxFlag")[val - 1].disabled="true";        
          
          return true;
        }
        else if((parseInt(tempPayCode.substring(0,1),10) > 0) && (parseInt(tempPayCode.substring(0,1),10) < 4)||(parseInt(tempPayCode.substring(9,1),10))) 
        {
          document.getElementsByName("lstSavingsRebate")[val - 1].style.background="#ffffff";
          document.getElementsByName("lstTaxableIndicator")[val - 1].style.background="#ffffd3";
          document.getElementsByName("lstSavingsRebate")[val - 1].className="optional";
          document.getElementsByName("lstTaxableIndicator")[val - 1].className="required";
          document.getElementsByName("lstTaxableIndicator")[val - 1].disabled="";
          document.getElementsByName("lstSavingsRebate")[val - 1].disabled="true";
          document.getElementsByName("txtRebateLimit")[val - 1].disabled="true";        

          document.getElementsByName("lstProfTaxFlag")[val - 1].className="required";
          document.getElementsByName("lstProfTaxFlag")[val - 1].disabled="";
          
          return true;
        }
        else
        {
          document.getElementsByName("lstSavingsRebate")[val - 1].style.background="#ffffff";
          document.getElementsByName("lstTaxableIndicator")[val - 1].style.background="#ffffff";
          document.getElementsByName("lstSavingsRebate")[val - 1].className="optional";
          document.getElementsByName("lstTaxableIndicator")[val - 1].className="optional";
          document.getElementsByName("lstTaxableIndicator")[val - 1].disabled="true";
          document.getElementsByName("txtRebateLimit")[val - 1].disabled="true";        
          document.getElementsByName("lstSavingsRebate")[val - 1].disabled="true";


          document.getElementsByName("lstProfTaxFlag")[val - 1].className="optional";
          document.getElementsByName("lstProfTaxFlag")[val - 1].disabled="true";
          
          return true;
        }
   
    return true;
}

function lfnLoad()
{  
  mode = document.all.screenMode.value;
  if(mode == '')
  {
      doQueryMode();
  }
  
  if(mode=='Q')
  {
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
  }

  if(mode=='U')
  {
      document.all.butInsert.disabled="";
      document.all.butGetDetail.disabled="true";
  }
  detMenuHandling(mode);

    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;


    for(i=0; i < iTr2 -1; i++)
    {
      checkPayCode(i+1);
      sta = document.getElementsByName("status")[i].value;
      if(sta == 'N')
      {
          document.getElementsByName("txtPayCode")[i].disabled="";      
      }
      else
      {
          document.getElementsByName("txtPayCode")[i].disabled="true";      
      }
    }
    if(document.all.hdnEmpLbrFlag.value=='V')
    {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
    }
    
    if(document.all.optVal.value==1)
    {
      document.all.radioSave.checked=true;
    }
    else
    {
      document.all.radioMisc.checked=true;
    }
}


function doBasePrevDetail()
{
    frmMaintPayCodes.userPageRequested.value = 1*frmMaintPayCodes.pageRequested.value - 1;
    frmMaintPayCodes.action = "../../../pCodePrevDetailAction.do";
    frmMaintPayCodes.submit();
}


function doBaseNextDetail()
{
    frmMaintPayCodes.userPageRequested.value = 1*frmMaintPayCodes.pageRequested.value + 1;
    frmMaintPayCodes.action = "../../../pCodeNextDetailAction.do";
    frmMaintPayCodes.submit();
}

function JumpDetail()
{
    frmMaintPayCodes.userPageRequested.value = 1*frmMaintPayCodes.newPageRequested.value ;
    frmMaintPayCodes.action = "../../../pCodeNextDetailAction.do";
    frmMaintPayCodes.submit();
}

function OptClick(arg) 
{
    document.all.screenMode.value='Q';
    document.all.txtFromPayCode.value='';
    document.all.txtToPayCode.value='';
    document.frmMaintPayCodes.action="../../../payCodeOptionClickAction.do";
    document.all.optVal.value=arg;        
    document.frmMaintPayCodes.submit(); 
}
</script>