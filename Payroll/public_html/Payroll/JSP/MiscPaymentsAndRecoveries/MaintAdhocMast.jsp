<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />


    <link rel="STYLESHEET" type="text/css" href="../../CSS/PayrollMenucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />



<html:form  action="MaintAdhocPayBase" name="frmMaintAdhocPay" type="FCIPAY.Payroll.WEBTIER.Form.MaintAdhocPayForm" scope="session">
<bean:define id="ParentForm" name="frmMaintAdhocPay" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN ADHOC PAYMENTS/RECOVERIES</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       <!--<div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 border="0">
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Header</TD>
        </TR>
        <TR>
              <TD colspan=8 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="8"></td>
         </tr>
        <tr>

            <td class="labelText" width="8%"><bean:message key="Payroll.MaintAdhoc.Code" /></td>
            <td width="18%"><html:text  property="txtPayCode" altKey="Payroll.MaintAdhoc.Code" maxlength="10" size="23" styleClass="required"  />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayCode" name="butPayCode" onclick="return ShowPayCode();" ></td><td width="16%"><html:text  property="txtPayCodeDesc"  maxlength="10" size="26" styleClass="locked" readonly="true" /></td>

         <td width="16%" class="labelText"><bean:message key="Payroll.MaintAdhoc.mode" /></td>
                   <td colspan="1"  width="16%"><html:select  property="txtPayMode" alt="lstPayScaleType" styleClass="required" >
                   <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                   <html:option value="1" > <bean:message key="Payroll.MaintAdhoc.current" /></html:option>
                   <html:option value="2" > <bean:message key="Payroll.MaintAdhoc.arr" /></html:option>
                   <html:option value="3" > <bean:message key="Payroll.MaintAdhoc.currec" /></html:option>
                   <html:option value="4" > <bean:message key="Payroll.MaintAdhoc.arrrec" /></html:option>
                   </html:select>
            </td>
         
            <td class="labelText" ><bean:message key="Payroll.MaintAdhoc.yymm" /></td>
            <td ><html:text  property="txtPayYYMM" altKey="Payroll.MaintAdhoc.yymm" maxlength="10" size="23" styleClass="required" onchange="" />  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayYYMM" name="butYYMM" onclick="return ShowLovYYMM();" /></td>

        </tr>
       
       
           <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>
    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > Payments/Recovery Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>

                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="8">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail" >
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintAdhoc.option" /></TD>
                        <!--    <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintAdhoc.group" /></td> -->
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintAdhoc.cat" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintAdhoc.desg" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintAdhoc.amt" /></TD>
                            </TR>

                          
                          <logic:iterate id="adhocpay" name="frmMaintAdhocPay" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintAdhocPayBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="adhocpay" property="status" value="D" >                                                        
                           <tr>     <% ++j; %>
                              <td  width="1%" align="center"><html:checkbox property="checked" name="frmMaintAdhocPay" onclick="checkRecord();" /></td>
                              
                             <td colspan="1"><html:select property="txtOptCode" name="adhocpay"  styleClass="required" alt="<%=String.valueOf(i)%>"  onchange=" checkOptCode(this.alt);"  style="WIDTH: 100%"  >
                                        <html:option value="">-----------Please Select-----------</html:option>
                                        <html:option value="1">ALL</html:option>
                                 <!--       <html:option value="2">Group</html:option> -->
                                        <html:option value="3">Category</html:option>
                                        <html:option value="4">Designation</html:option>

                                            </html:select></td>  
          <!--               <td>
                                      <html:select property="txtGroupCode" name="adhocpay" styleClass="required"  style="width:100%"  alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);"  >
                                          <html:option value="" >-----------Please Select-----------</html:option>      
                                          <logic:present name="Pay">
                                            <html:optionsCollection label="label" value="value" property="groupList" name="Pay"/>
                                          </logic:present>
                                        </html:select>
                                  </td>
            -->
                                  <td>
                                      <html:select property="txtCategCode"  styleClass="required" name="adhocpay" style="width:100%"  alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);"  >
                                          <html:option value="" >-----------Please Select-----------</html:option>      
                                          <logic:present name="Pay">
                                            <html:optionsCollection label="label" value="value" property="categList" name="Pay"/>
                                          </logic:present>
                                        </html:select>
                                  </td>




                              
                             <td  width="5%" ><html:text property="txtDesigCode" name="adhocpay"  styleClass="required" size="6" style="width:82%" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt);" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" name="buttxtDesigCode" onclick="ShowLovDsgnCode(this.alt);" ></td>




                              <td  width="5%" ><html:text property="txtAmount" name="adhocpay" styleClass="required" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);" /></td>

                               <html:hidden property="txtSrlNo" name="adhocpay" />
                               <html:hidden property="txtGroupCode" name="adhocpay"  />
                               <html:hidden property="itemChecked" name="adhocpay" />
                               <html:hidden property="status" name="adhocpay" />    
                               <html:hidden property="detailId" name="adhocpay" value="Default"/>
                          </tr>
                        </logic:notEqual>
                        <logic:equal name="adhocpay" property="status" value="D" >
                         <tr>
                              <td  width="1%" ><html:hidden property="checked" value="notchecked" /></td>
                              <td  width="5%" ><html:hidden property="txtOptCode" name="adhocpay"  /></td>
                              <td  width="5%" ><html:hidden property="txtGroupCode" name="adhocpay"  /></td>
                              <td  width="5%" ><html:hidden property="txtCategCode" name="adhocpay"  /></td>
                              <td  width="5%" ><html:hidden property="txtDesigCode" name="adhocpay"  /></td>
                              <td  width="5%" ><html:hidden property="txtAmount" name="adhocpay"  /></td>                              
                               <html:hidden property="txtSrlNo" name="adhocpay" />
                               <html:hidden property="itemChecked" name="adhocpay" />
                               <html:hidden property="status" name="adhocpay" />
                               <html:hidden property="detailId" name="adhocpay" value="Default"/>
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
		          <td colspan=8>	
                  <TABLE border=0>
                    <TBODY>
                    <TR>
                                    <TD><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" /></td>		     
                     </TR>
                  </TBODY>
                </TABLE>
                </TD>
               
                  </tr>
  </TBODY>
		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
               <tr>
                  <TD background="../INCLUDES/IMAGES/line_r.gif"><IMG src="../INCLUDES/IMAGES/pixel.gif" border=0></TD>
                  </TR>
                  <TR>
                   <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
                  </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
              
                      <td width=40% align=center bgColor=#4682b4></td>
                      <td  bgColor=#4682b4></td>
                      <td  bgColor=#4682b4><button   onclick="doCreateAdhocTrans()" name="butCreate" class="bottomBarText">Create Transaction  </button> <button    onclick="doUndoAdhocTrans()" name="butUndo" class="bottomBarText">&nbsp;&nbsp;Undo Transaction&nbsp;</button>  </td> 
                                     
                      <td bgColor=#4682b4></td>
                      <td class="icon" align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
                </TR>
	     </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden property="totalDetailRecord" name="frmMaintAdhocPay" />
<html:hidden property="headerPrimaryKey" name="frmMaintAdhocPay" value="Default" />
<html:hidden property="screenMode" name="frmMaintAdhocPay" />
<html:hidden name="frmMaintAdhocPay"  property="screenName" value="AdhocPayScreen" />
<html:hidden name="frmMaintAdhocPay"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmMaintAdhocPay" />
<html:hidden property="userPositionRequested" name="frmMaintAdhocPay" />
<html:hidden property="headerMode" name="frmMaintAdhocPay" />
<html:hidden property="headerMode1" name="frmMaintAdhocPay" />
<html:hidden property="hdnPayrollFlag" name="frmMaintAdhocPay" />

<html:hidden property="lovKey" name="frmMaintAdhocPay"  />
<html:hidden property="txtFields" name="frmMaintAdhocPay"  />   
<html:hidden property="txtSearchFields" name="frmMaintAdhocPay"  />
<html:hidden property="txtDisplayFields" name="frmMaintAdhocPay"  />
<html:hidden property="txtIndex" name="frmMaintAdhocPay"  />
<html:hidden property="buttonFlag" name="frmMaintAdhocPay"  />
<html:hidden property="flag" name="frmMaintAdhocPay" />

</html:form>
</body>
</html:html>

 
<script language="javascript">


function changed(val)
{
  frmMaintAdhocPay.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}



function lfnChange(val,ind)
{
   if(num_Check(val,1))
  {
      frmMaintAdhocPay.detailDataChanged.value = "true";
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


function doQueryMode()
{
    document.all.buttonFlag.value='';
 
  frmMaintAdhocPay.action="../../../AdhocPayQueryMode.do";
  frmMaintAdhocPay.submit();

}

function doInsertMode()
{
    document.all.buttonFlag.value='';
     
  frmMaintAdhocPay.action="../../../AdhocPayNewMode.do";
  frmMaintAdhocPay.submit();

}

function getHeaderRecord()
{
	document.all.buttonFlag.value='';
	frmMaintAdhocPay.flag.value = "false";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmMaintAdhocPay.action="../../../AdhocPayGetHeaderAction.do";
	frmMaintAdhocPay.submit();
}

function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmMaintAdhocPay.flag.value = "false";
  frmMaintAdhocPay.userPositionRequested.value = 1*frmMaintAdhocPay.newPositionRequested.value;
  frmMaintAdhocPay.action = "../../../AdhocPayGetNextHeader.do";
  frmMaintAdhocPay.submit();
}

function doGetNextHeader()
{
       document.all.buttonFlag.value=''; 
  frmMaintAdhocPay.flag.value = "false";
    frmMaintAdhocPay.userPositionRequested.value = 1*frmMaintAdhocPay.positionRequested.value + 1;  
    frmMaintAdhocPay.action="../../../AdhocPayGetNextHeader.do";
    frmMaintAdhocPay.submit();
}


function PrevHeader()
{
    document.all.buttonFlag.value='';  
  frmMaintAdhocPay.flag.value = "false";
  frmMaintAdhocPay.userPositionRequested.value = frmMaintAdhocPay.positionRequested.value - 1;
  frmMaintAdhocPay.action = "../../../AdhocPayGetNextHeader.do";
  frmMaintAdhocPay.submit();
}
function GetDetail()
{
    document.all.buttonFlag.value='';
   frmMaintAdhocPay.flag.value = "true";

  // frmMaintAdhocPay.headerPrimaryKey.value = frmMaintAdhocPay.txtYYMM.value + "#" + frmMaintAdhocPay.txtDAType.value;
  frmMaintAdhocPay.action="../../../AdhocPayGetDetailAction.do";
  frmMaintAdhocPay.submit();
}
function doRefresh()
    {
        frmMaintAdhocPay.action = "../../../AdhocPayRefresh.do";
        frmMaintAdhocPay.submit();
    }

function doBaseAddRow()
{
      document.all.buttonFlag.value='D';   
if(!mandatory_Check("frmMaintAdhocPay"))
        return false;   

  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  
  for(i=0; i < iTr2 -1; i++)
  {
//          document.getElementsByName("buttxtDesigCode")[i].disabled="";
          document.getElementsByName("txtDesigCode")[i].disabled="";
          document.getElementsByName("txtCategCode")[i].disabled="";
          document.getElementsByName("txtGroupCode")[i].disabled="";
          document.getElementsByName("txtOptCode")[i].disabled="";
   }



      document.forms[0].action = "../../../AdhocPayAddRowAction.do";
      document.forms[0].submit();
  
}

function SaveRecord()
{ 
    document.all.buttonFlag.value='';
   if(mandatory_Check("frmMaintAdhocPay"))
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
          document.getElementsByName("buttxtDesigCode")[i].disabled="";
          document.getElementsByName("txtDesigCode")[i].disabled="";
          document.getElementsByName("txtCategCode")[i].disabled="";
       //   document.getElementsByName("txtGroupCode")[i].disabled="";
          document.getElementsByName("txtOptCode")[i].disabled="";

      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintAdhocPay.detailDataChanged.value = "true";
  }

     frmMaintAdhocPay.screenMode.value ='U';     
    frmMaintAdhocPay.headerFields.value = "true";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintAdhocPay.action = "../../../AdhocPaySaveAction.do";
  frmMaintAdhocPay.submit();
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


  for(i=0; i < iTr2 -1; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintAdhocPay.detailDataChanged.value = "true";      
    }

  }

  for(i=0; i < iTr2 -1; i++)
  {
          document.getElementsByName("buttxtDesigCode")[i].disabled="";
          document.getElementsByName("txtDesigCode")[i].disabled="";
          document.getElementsByName("txtCategCode")[i].disabled="";
     //     document.getElementsByName("txtGroupCode")[i].disabled="";
          document.getElementsByName("txtOptCode")[i].disabled="";
   }
  
  
  
  document.forms[0].action = "../../../AdhocPayDeleteRowAction.do";
  document.forms[0].submit();  
}

function ShowPayCode()
{
   frmMaintAdhocPay.lovKey.value = "AdhocPay" + frmMaintAdhocPay.screenName.value + frmMaintAdhocPay.screenMode.value;
   frmMaintAdhocPay.txtDisplayFields.value = "txtPayCode,txtPayCodeDesc";
   frmMaintAdhocPay.txtSearchFields.value = "Payroll.MaintAdhoc.Code,Payroll.Common.Desc";
   frmMaintAdhocPay.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintAdhocPay');
   return true;
}


function ShowLovYYMM()
{
   frmMaintAdhocPay.lovKey.value = "AdhocYear" + frmMaintAdhocPay.screenName.value + frmMaintAdhocPay.screenMode.value;
   frmMaintAdhocPay.txtDisplayFields.value = "txtPayYYMM";
   frmMaintAdhocPay.txtSearchFields.value = ""; 
   frmMaintAdhocPay.txtIndex.value ="";  
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintAdhocPay');
   return true;
}


function ShowLovDsgnCode(i)
{
   frmMaintAdhocPay.lovKey.value = "AdhocDesg" + frmMaintAdhocPay.screenName.value + frmMaintAdhocPay.screenMode.value;
   frmMaintAdhocPay.txtDisplayFields.value = "txtDesigCode";
   frmMaintAdhocPay.txtSearchFields.value = "Payroll.MaintAdhoc.desg";
   frmMaintAdhocPay.txtIndex.value=i;  
   if(!(document.getElementsByName("status")[i].value == "N"))
   document.getElementsByName("status")[i].value = "U";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintAdhocPay');
   return true;
}

function lfnLoad()
{
mode = document.all.screenMode.value;
if(mode == '')
  {
      doQueryMode();
  }

 flag = document.all.flag.value;

 if (frmMaintAdhocPay.screenMode.value == 'U')
      { 
        document.getElementById("txtPayCode").disabled = "true";
        document.getElementById("txtPayMode").disabled = "true";      
        document.getElementById("txtPayYYMM").disabled = "true";
        document.all.butPayCode.disabled="true";           
        document.all.butYYMM.disabled="true";           
     
      if(flag == 'true')
      {
        document.all.butGetDetail.disabled="true";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";
      }
      else
      {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="true";
        document.all.butDelete.disabled="true";
      }
   }

if(frmMaintAdhocPay.screenMode.value =='N')
  {
      document.all.butGetDetail.disabled="true";
      document.all.txtPayCode.disabled="";
      document.all.txtPayMode.disabled="";
      document.all.txtPayYYMM.disabled="";           
      document.all.butPayCode.disabled="";           
      document.all.butYYMM.disabled="true";           
  }
  if(frmMaintAdhocPay.screenMode.value =='Q')
  {
      document.all.butGetDetail.disabled="true";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
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
    checkOptCode(i+1);
    if (document.getElementsByName("status")[i].value == 'Q')
      {                
        document.getElementsByName("txtOptCode")[i].disabled="disabled";     
      }
    else
     document.getElementsByName("txtOptCode")[i].disabled="";
  }  

        menuHandling(mode);
        
        if ( document.getElementById("hdnPayrollFlag").value ==  "Y" ) 
        {
            for(i=0; i < iTr2 -1; i++)
            {
              var val = i+1;
           //   document.getElementsByName("txtGroupCode")[val - 1].style.background="#ffffff";
              document.getElementsByName("txtCategCode")[val - 1].style.background="#ffffd3";
              document.getElementsByName("txtDesigCode")[val - 1].style.background="#ffffff";
           //   document.getElementsByName("txtGroupCode")[val - 1].className="optional";
              document.getElementsByName("txtCategCode")[val - 1].className="required";
              document.getElementsByName("txtDesigCode")[val - 1].className="optional";
              if (document.getElementsByName("status")[val-1].value != 'D')                              
              document.getElementsByName("buttxtDesigCode")[val - 1].disabled="true";
              document.getElementsByName("txtDesigCode")[val - 1].disabled="true";
              document.getElementsByName("txtCategCode")[val - 1].disabled="true";
           //   document.getElementsByName("txtGroupCode")[val - 1].disableqd="true";
              document.getElementsByName("txtAmount")[val - 1].disabled="true";              

              document.all.butInsert.disabled="true";
              document.all.butDelete.disabled="true";
            }          
        }
        return true;
 
}

function checkOptCode(val)
{
      var select=document.getElementsByName("txtOptCode")[val-1].value;

      if (select=="")
        {
        
        //  document.getElementsByName("txtGroupCode")[val - 1].style.background="#ffffff";
          document.getElementsByName("txtCategCode")[val - 1].style.background="#ffffff";
          document.getElementsByName("txtDesigCode")[val - 1].style.background="#ffffff";
        //  document.getElementsByName("txtGroupCode")[val - 1].className="optional";
          document.getElementsByName("txtCategCode")[val - 1].className="optional";
          document.getElementsByName("txtDesigCode")[val - 1].className="optional";
          document.getElementsByName("txtDesigCode")[val - 1].value="";
          document.getElementsByName("txtCategCode")[val - 1].value="";
       //   document.getElementsByName("txtGroupCode")[val - 1].value="";

          if (document.getElementsByName("status")[val-1].value == 'D')          
          document.getElementsByName("buttxtDesigCode")[val - 1].disabled="true";
          
          document.getElementsByName("txtDesigCode")[val - 1].disabled="true";
          document.getElementsByName("txtCategCode")[val - 1].disabled="true";
       //   document.getElementsByName("txtGroupCode")[val - 1].disabled="true";
          return true;
        }

       
      else if (select==1)
        {
        //  document.getElementsByName("txtGroupCode")[val - 1].style.background="#ffffff";
          document.getElementsByName("txtCategCode")[val - 1].style.background="#ffffff";
          document.getElementsByName("txtDesigCode")[val - 1].style.background="#ffffff";
        //  document.getElementsByName("txtGroupCode")[val - 1].className="optional";
          document.getElementsByName("txtCategCode")[val - 1].className="optional";
          document.getElementsByName("txtDesigCode")[val - 1].className="optional";
          if (document.getElementsByName("status")[val-1].value != 'D')                    
            document.getElementsByName("buttxtDesigCode")[val - 1].disabled="true";
          document.getElementsByName("txtDesigCode")[val - 1].disabled="true";
          document.getElementsByName("txtCategCode")[val - 1].disabled="true";
       //   document.getElementsByName("txtGroupCode")[val - 1].disabled="true";
          return true;
        }



       else if (select==2)
        {
        
        //  document.getElementsByName("txtGroupCode")[val - 1].style.background="#ffffd3";
          document.getElementsByName("txtCategCode")[val - 1].style.background="#ffffff";
          document.getElementsByName("txtDesigCode")[val - 1].style.background="#ffffff";
       //   document.getElementsByName("txtGroupCode")[val - 1].className="required";
          document.getElementsByName("txtCategCode")[val - 1].className="optional";
          document.getElementsByName("txtDesigCode")[val - 1].className="optional";
          document.getElementsByName("txtDesigCode")[val - 1].value="";
          document.getElementsByName("txtCategCode")[val - 1].value="";
//          document.getElementsByName("txtGroupCode")[val - 1].value="";
          if (document.getElementsByName("status")[val-1].value != 'D')                    
          document.getElementsByName("buttxtDesigCode")[val - 1].disabled="true";
          document.getElementsByName("txtDesigCode")[val - 1].disabled="true";
          document.getElementsByName("txtCategCode")[val - 1].disabled="true";
      //    document.getElementsByName("txtGroupCode")[val - 1].disabled="";
          return true;
        }
        
        else if(select==3) 
        {
       //   document.getElementsByName("txtGroupCode")[val - 1].style.background="#ffffff";
          document.getElementsByName("txtCategCode")[val - 1].style.background="#ffffd3";
          document.getElementsByName("txtDesigCode")[val - 1].style.background="#ffffff";
      //    document.getElementsByName("txtGroupCode")[val - 1].className="optional";
          document.getElementsByName("txtCategCode")[val - 1].className="required";
          document.getElementsByName("txtDesigCode")[val - 1].className="optional";
          document.getElementsByName("txtDesigCode")[val - 1].value="";
//          document.getElementsByName("txtCategCode")[val - 1].value="";
     //     document.getElementsByName("txtGroupCode")[val - 1].value="";
          if (document.getElementsByName("status")[val-1].value != 'D')                              
          document.getElementsByName("buttxtDesigCode")[val - 1].disabled="true";
          document.getElementsByName("txtDesigCode")[val - 1].disabled="true";
          document.getElementsByName("txtCategCode")[val - 1].disabled="";
      //    document.getElementsByName("txtGroupCode")[val - 1].disabled="true";
          return true;
        }
        else if (select==4) 
        {
        
     //     document.getElementsByName("txtGroupCode")[val - 1].style.background="#ffffff";
          document.getElementsByName("txtCategCode")[val - 1].style.background="#ffffff";
          document.getElementsByName("txtDesigCode")[val - 1].style.background="#ffffd3";
    //      document.getElementsByName("txtGroupCode")[val - 1].className="optional";
          document.getElementsByName("txtCategCode")[val - 1].className="optional";
          document.getElementsByName("txtDesigCode")[val - 1].className="required";
           document.getElementsByName("txtDesigCode")[val - 1].value="";
          document.getElementsByName("txtCategCode")[val - 1].value="";
    //      document.getElementsByName("txtGroupCode")[val - 1].value="";
          document.getElementsByName("buttxtDesigCode")[val - 1].disabled="";
           document.getElementsByName("txtDesigCode")[val - 1].disabled="";
          document.getElementsByName("txtCategCode")[val - 1].disabled="true";
     //     document.getElementsByName("txtGroupCode")[val - 1].disabled="true";
          return true;
        }        
       
        return true;
}

function doCreateAdhocTrans()
{
  document.forms[0].action = "../../../AdhocTrans.do?param1=1";
  document.forms[0].submit();
}
function doUndoAdhocTrans()
{
  document.forms[0].action = "../../../AdhocTrans.do?param1=0";
  document.forms[0].submit();
}



</script> 
