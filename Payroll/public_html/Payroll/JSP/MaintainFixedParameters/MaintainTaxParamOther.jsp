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
   
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


  <html:form  action="MaintainOtherTaxParam" name="frmTaxParamOther" type="FCIPAY.Payroll.WEBTIER.Form.TaxParamOtherForm" scope="session">
  <bean:define id="ParentForm" name="frmTaxParamOther" toScope="request" />
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" />
<html:hidden property="headerFields" value="true" />



<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN INCOME TAX RATES</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD> 
	
       <!--<div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6></TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="20" >
            <td colspan="2"></td>
         </tr>
        <tr>

  
        </tr>
      
       
       
           <tr height="10">		    
        <TD colspan="2" > </TD>
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
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("incTax")>Income Tax Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                <!--
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("stand")>Standard Deduction Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                -->
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("profTax")>Professional Tax Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>Other Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
         <tr height="20" >
            <td colspan="14"></td>
         </tr>

          <tr>
            <td colspan="9" class="labelText"  width="50%"><bean:message key="Pay.TaxParam.yymm" /></td>
            <td colspan="5" width="50%">
<!--            <html:select property="txtOtherYYMM" styleClass="required">
                   <html:option value="--Please Select--" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                   </html:select>  -->
                  <html:text  property="headerPrimaryKey" maxlength="10" size="23" styleClass="required"  onchange="lfnChange()" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtYYMM"  onclick="ShowLovYYMM();" />                                     
            </td>
          </tr>
         <tr height="8" >
            <td colspan="14"></td>
         </tr>
         <tr height="20" >
            <td colspan="14"></td>
         </tr>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="14">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <tr>
                        <td colspan="7" class="labelText"  width="50%">
                             <bean:message key="Pay.Other.SavLmt" />
                        </td>
                        <td>
                            <html:text  property="txtRebLimitAmt" maxlength="10" size="16" style="text-align:right" onchange="lfnChange()" styleClass="optional" />
                        </td>
                    </tr> 
                    <tr>
                        <td colspan="7" class="labelText"  width="50%">
                             <bean:message key="Pay.Other.FemAddl" />
                        </td>
                        <td>
                            <html:text  property="txtFemAddl" maxlength="10" size="16" style="text-align:right" onchange="lfnChange()" styleClass="optional" />
                        </td>
                    </tr> 
                    <tr>
                        <td colspan="7" class="labelText"  width="50%">
                             <bean:message key="Pay.Other.AddlLmt" />
                        </td>
                        <td>
                            <html:text  property="txtAddlLimit" maxlength="10" size="16" style="text-align:right" onchange="lfnChange()" styleClass="optional" />
                        </td>
                    </tr> 
                    
                    <td colspan="7" class="labelText"  width="50%">
                             Medical Claim Limit
                        </td>
                        <td>
                            <html:text  property="txtMediClaimLimit" maxlength="10" size="16" style="text-align:right" onchange="lfnChange()" styleClass="optional" />
                        </td>
                    </tr> 
                  
                  
         <tr height="180px" >
            <td colspan="14"></td>
         </tr>
   <!-- Get details starts -->
	          <tr>
		          <td colspan=14>	
                </TD>
               
                  </tr>
  </TBODY>
		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
    <TR>
     <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
               <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />

               <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
                <% if(smode.equals(new String("U"))) {%> 
                Update Mode
               <%} else if(smode.equals(new String("N"))) {  %>
                New Mode
               <%} else if(smode.equals(new String("Q"))) {  %>
                Query Mode
               <%}  %>
               </td> 
               <td align=center bgcolor=#4682b4 width="20%"></td>
               <td  bgcolor=#4682b4> </td>
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
<!-- Hidden fields end -->

<html:hidden name="frmTaxParamOther"  property="screenName" value="TaxParamOtherScreen" />
<html:hidden name="frmTaxParamOther"  property="forwardedPage" />
<html:hidden property="txtOtherYYMM" name="frmTaxParamOther" />


<html:hidden property="screenMode" name="frmTaxParamOther" />
<html:hidden property="screenType" name="frmTaxParamOther" />
<html:hidden property="positionRequested" name="frmTaxParamOther" />
<html:hidden property="userPositionRequested" name="frmTaxParamOther" />
<html:hidden property="pageRequested" name="frmTaxParamOther" />
<html:hidden property="userPageRequested" name="frmTaxParamOther" />
<html:hidden property="buttonFlag" name="frmTaxParamOther"  />
<html:hidden property="lovKey" name="frmTaxParamOther"  />
<html:hidden property="txtSearchFields" name="frmTaxParamOther"  />
<html:hidden property="txtDisplayFields" name="frmTaxParamOther"  />
<html:hidden property="txtIndex" name="frmTaxParamOther"  />

</html:form>
</body>
</html:html>

 
<script language="javascript">

var formMode="A";
var oElemName=new Object();
var sSaveFlag=1;

function menuHandling(mode)
{
  if(document.all.buttonFlag.value!='D')    
    document.all.buttonFlag.value='ND';  
  if(mode=='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
/*      document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";    
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     */
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
  if(mode=='N')
  {
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
  if(mode=='U')
  {
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";        
  }
  if(document.all.buttonFlag.value=='D')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  }
}



function lfnLoad()
{
 mode1 = document.all.screenMode.value;
 if(mode1 == '')
  {
      doQueryMode();
  }

  mode = document.all.screenMode.value;

  if(mode=='' || mode == 'Q')
   {
     //document.all.butGetDetail.disabled="disabled";   
     //document.all.butInsert.disabled="disabled";
     //document.all.butDelete.disabled="disabled";
   }
  
  if(mode=='N')
  {
     document.all.buttxtYYMM.disabled="disabled"; 
     //alert(document.all.buttxtYYMM);
     
     //document.all.butGetDetail.disabled="true";
     //document.all.butInsert.disabled="";
     //document.all.butDelete.disabled="";      
  }
  
  if(mode == 'U')
  {
    document.all.headerPrimaryKey.disabled="disabled"; 
  }

    if(mode=='UG')
  {
     //document.all.butGetDetail.disabled="true";
     //document.all.butInsert.disabled="";
     //document.all.butDelete.disabled="";      
  }

  if(mode=='UNG')
  {
      document.all.txtIncTaxYYMM.disabled="disabled";
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
  }
  if(mode=='UNG' || mode=='UG')
  {
    menuHandling('U');
  }
  else
  {
    menuHandling(mode);
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
}


function getHeaderRecord()
{
	document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";

	frmTaxParamOther.action="../../../taxParamOtherFirstGetHeaderAction.do";
	frmTaxParamOther.submit();
}

function SaveRecord()
{
  document.all.detailDataChanged.value= false;
  document.all.buttonFlag.value='';
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmTaxParamOther.action = "../../../taxParamOtherSaveAction.do";
  frmTaxParamOther.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value='';
  frmTaxParamOther.action="../../../TaxParamOtherNewMode.do"
  frmTaxParamOther.submit();
}

function doQueryMode()
{
  document.all.buttonFlag.value='';
  frmTaxParamOther.action="../../../TaxParamOtherQueryMode.do"
  frmTaxParamOther.submit();
}

function lfnChange()
{
  frmTaxParamOther.headerDataChanged.value = "true";
}

function doExecute()
{
  //alert("Execute");
  frmTaxParamOther.frmTaxParamOther.value = "U";
  document.all.buttonFlag.value='';
  document.forms[0].action="/enrgise/getFinConfigChartOfAccountHeaderInfo.do";
  document.forms[0].submit();
}

function doGetDetail()
{
  //alert("Getting Details");
  document.all.buttonFlag.value='';
  document.forms[0].action="/enrgise/getFinConfigChartOfAccountDetailInfo.do";
  document.forms[0].submit();
}

function doGetNextHeader()
{ 
  document.all.buttonFlag.value='';
  document.all.screenType.value  = "UNG";
  document.forms[0].userPositionRequested.value = 1*frmTaxParamOther.positionRequested.value + 1;      
  document.forms[0].action="../../../getTaxNextHeaderInfo.do";
  document.forms[0].submit();
}

function doGetNextDetail()
{
  
  //alert("Next Detail");    
  document.all.buttonFlag.value='';
  document.forms[0].action="/enrgise/getNextDetailInfo.do";
  document.forms[0].submit();
}

function PrevHeader()
{
  document.all.screenType.value  = "UNG";    
  document.forms[0].userPositionRequested.value = frmTaxParamOther.positionRequested.value - 1;
  document.all.buttonFlag.value='';
  document.forms[0].action = "../../../getTaxNextHeaderInfo.do";
  document.forms[0].submit();
}

function doFirst()
{
  //alert("First Record");  
}

function doGetTab(arg)
{
  document.all.buttonFlag.value=''; 
  document.all.forwardedPage.value=arg;
  document.forms[0].action="../../../taxParamOthTabAction.do";
  document.forms[0].submit();
}

function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmTaxParamOther.userPositionRequested.value = 1*frmTaxParamOther.newPositionRequested.value;
  frmTaxParamOther.action = "../../../getTaxNextHeaderInfo.do";
  frmTaxParamOther.submit();
}

function ShowLovYYMM()
{  //alert("hi");
   frmTaxParamOther.lovKey.value = "MaintOtherDtl" + frmTaxParamOther.screenName.value + "Q";
   frmTaxParamOther.txtDisplayFields.value = "headerPrimaryKey";
   frmTaxParamOther.txtSearchFields.value = "Pay.TaxParam.yymm";
   frmTaxParamOther.txtIndex.value="";  
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmTaxParamOther');
   return true;
} 

function doRefresh()
{
  frmTaxParamOther.action="../../../TaxParamOtherRefresh.do"
  frmTaxParamOther.submit();
}
       
</script>
