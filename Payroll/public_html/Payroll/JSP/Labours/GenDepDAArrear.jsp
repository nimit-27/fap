<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
  
</head>
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="GenDepDAArrear" name="frmDAArrear" type="FCIPAY.Payroll.WEBTIER.Form.GenDaArrearForm" scope="session">
<bean:define id="ParentForm" name="frmDAArrear" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="headerDataChanged"  />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<html:hidden property="payrollFlag" />
<html:hidden property="buttonFlag" />



<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>GENERATE DA ARREAR FOR <bean:write name="frmDAArrear" property="payYYMM" /></TD>
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
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText >Generate DA Arrear Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
         <tr height="20" >
            <td colspan="14"></td>
         </tr>
          <tr>
          <td colspan="14">
          <table>
          <tr>
              <td class="labelText"   ><bean:message key="Pay.DAArr.YMonth" /></td>
              <td align="left"><html:text  property="txtPayYYMM" maxlength="10" size="20" styleClass="required" readonly=""  onchange="chk_YearMonth(this);" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayYYMM" onclick="showLovYYMM();"  >&nbsp;&nbsp;<bean:message key="Pay.DAArr.YyMm" /></td>
              <td class="labelText"  ><bean:message key="Pay.DAArr.SYMonth" />&nbsp;<html:text  property="txtStYYMM" maxlength="10" size="20" styleClass="required" onchange="chk_YearMonth(this); " />&nbsp;&nbsp;<bean:message key="Pay.DAArr.YyMm" /></td>
          </tr>
          <tr>
              <td class="labelText"   ><bean:message key="Pay.DAArr.DAType" /></td>
              <td align="left"><html:select property="txtDAType" styleClass="required" >
                   <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                   <html:option value="IDA" > <bean:message key="Pay.DAArr.Ida" /></html:option>
                   <html:option value="CDA" > <bean:message key="Pay.DAArr.Cda" /></html:option>
                   </html:select>
              </td>
              <td class="labelText"  ><bean:message key="Pay.DAArr.EYMonth" />&nbsp;<html:text  property="txtEndYYMM" maxlength="10" size="20" styleClass="required" onchange="chk_YearMonth(this); " />&nbsp;&nbsp;<bean:message key="Pay.DAArr.YyMm" /></td>
          </tr>
          </table>
          </td>
          </tr>
         <tr height="20" >
            <td colspan="14"></td>
         </tr>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="14">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                   </TD>
                  </TR>                     
                  
   <!-- Get details starts -->
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
               <td  bgcolor=#4682b4><html:button value='Generate DA Arrear'  onclick="genDAArrear()" property="butGenDAArrear" styleClass="bottomBarText" /><html:button value=' Undo DA Arrear '  onclick="undoDAArrear()" property="butUndoDAArrear" styleClass="bottomBarText" /></td>
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
<!-- These four hidden fields must be present in pages where there is a detail part -->
<html:hidden name="frmDAArrear"  property="screenName" value="GenDepDAArrScreen" />
<html:hidden name="frmDAArrear"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDAArrear" />
<html:hidden property="butAction" name="frmDAArrear" />



<html:hidden property="positionRequested" name="frmDAArrear" />
<html:hidden property="userPositionRequested" name="frmDAArrear" />
<html:hidden property="loginLocCode" name="frmDAArrear" />

<html:hidden property="lovKey" name="frmDAArrear"  />
<html:hidden property="txtFields" name="frmDAArrear"  />   
<html:hidden property="txtSearchFields" name="frmDAArrear"  />
<html:hidden property="txtDisplayFields" name="frmDAArrear"  />
<html:hidden property="txtIndex" name="frmDAArrear"  />
<html:hidden name="frmDAArrear"  property="hdnAction" /><!--///////////added by swapnendu///////////////-->
<html:hidden name="frmDAArrear"  property="txtEmp" value="" /><!--///////////added by swapnendu///////////////-->

<input type="hidden" name="queryParam" >
<!-- Hidden fields end -->

</html:form>
</body>
</html:html>

 
<script language="javascript">

 function lfnChange(val)
{
  if(num_Check(val,1))
    frmDAArrear.headerDataChanged.value = "true";
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

function getHeaderRecord()
{
	frmDAArrear.txtDAType.disabled = "";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmDAArrear.action="../../../DAArrearDepFirstGetHeaderAction.do"
	frmDAArrear.submit();
}


function doGetNextHeader()
{ 
    frmDAArrear.userPositionRequested.value = 1*frmDAArrear.positionRequested.value + 1;
    frmDAArrear.action="../../../DAArrearDepGetNextHeader.do";
    frmDAArrear.submit();
}


function PrevHeader()
{
  frmDAArrear.userPositionRequested.value = 1*frmDAArrear.positionRequested.value - 1;
  frmDAArrear.action = "../../../DAArrearDepGetPrevHeader.do";
  frmDAArrear.submit();
}


function JumpHeader()
{
  frmDAArrear.userPositionRequested.value = 1*frmDAArrear.newPositionRequested.value;
  frmDAArrear.action = "../../../DAArrearDepGetNextHeader.do";
  frmDAArrear.submit();
}

function doInsertMode()
{
  frmDAArrear.action="../../../DAArrearDepNewMode.do"
  frmDAArrear.submit();
}

function doQueryMode()
{
  frmDAArrear.action="../../../DAArrearDepQueryMode.do"
  frmDAArrear.submit();
}

function doRefresh()
{  
  alert("Refresh");
  frmDAArrear.action="../../../GenDepDAArrearRefresh.do"
  frmDAArrear.submit();
}


function SaveRecord()
{
    
	frmDAArrear.headerDataChanged.value = "true";    
	frmDAArrear.headerFields.value = "true";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	frmDAArrear.action = "../../../DAArrearDepSaveAction.do";
	frmDAArrear.submit();

}

function lfnLoad()
{
  
  //alert("screenmode "+ document.all.screenMode.value);
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {   
      doQueryMode();
	  frmDAArrear.hdnAction.value='';  //added by swapnendu Dt 30 nov 2011
  }

  if(document.frmDAArrear.screenMode.value == 'U')
  {
    document.frmDAArrear.txtDAType.disabled="true";
    document.frmDAArrear.txtPayYYMM.disabled="true";
    //document.frmDAArrear.txtStYYMM.disabled="true";
    //document.frmDAArrear.txtEndYYMM.disabled="true";
  }
  if(document.frmDAArrear.screenMode.value == 'Q')
  {
    document.frmDAArrear.txtDAType.disabled="true";
    document.frmDAArrear.txtPayYYMM.disabled="";    
    document.frmDAArrear.txtStYYMM.disabled="true";
    document.frmDAArrear.txtEndYYMM.disabled="true";
  }
  

  menuHandling(screenmode);
  
  if (frmDAArrear.hdnAction.value=='S') 
	{
		document.all.butGenDAArrear.disabled="true";
		frmDAArrear.hdnAction.value='SUB';
		genDAArrear(); 
	}

}

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
   /*   document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";  
   */ 
   /*   
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";  
   */ 
      
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
      document.all.newPositionRequested.disabled="true";    
  }
  if(mode=='N')
  {
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg"; 
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
  
  //document.all.butDelete.disabled="true";
}

function showLovYYMM()
{ 
   frmDAArrear.lovKey.value = "daArrear" + frmDAArrear.screenName.value + frmDAArrear.screenMode.value;
   frmDAArrear.txtDisplayFields.value = "txtPayYYMM";
   frmDAArrear.txtSearchFields.value = ""; 
   frmDAArrear.queryParam.value="txtSiteID="+ frmDAArrear.loginLocCode.value +",hdnEmpLbrFlag="+frmDAArrear.hdnEmpLbrFlag.value ;
   frmDAArrear.txtIndex.value ="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDAArrear');
   return true;
}

function chk_YearMonth(that)
{
       var yearM = that.value;
       var month =  yearM.substring(4,6);
      
    if (num_Check(yearM,1))
     {                                   
        if (yearM.length != 6)
        {
        alert(" Year Month should be a Six digit Number");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

      else if(month < 1 || month > 12)
       {
           alert("  Month should be Within 1 to 12");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
          return false;
       }
       else
       {
          
//          return changed(val);
          return true;
        }
     }
     else
     {
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;     
    return false;
     }
}

function genDAArrear()
{
	var str="";
    if(frmDAArrear.payrollFlag.value == 'Y')
    {
      alert("DA Arrear Has Been Already Generated For This Record. Cannot Generate Again Without Undoing.");
      return false;
    } 
    frmDAArrear.butAction.value = "Generate";
    //frmDAArrear.action = "../../../GenerateDepDAArrear.do";
    //frmDAArrear.submit();
    if (frmDAArrear.hdnAction.value != 'SUB') 
    {
	     
        frmDAArrear.hdnAction.value = 'S'; 
        ac="../../../GenerateDepDAArrear.do?param1="+str+"&param2="+document.all.txtEmp.value;      
        document.forms[0].action=ac;
        document.forms[0].submit();
		
    }
    else
    {
        frmDAArrear.hdnAction.value='SUB';       
        ac="../../../GenerateDepDAArrear.do?param1="+str+"&param2="+document.all.txtEmp.value;
        document.forms[0].action=ac;
        document.forms[0].submit();
    }        
}


function undoDAArrear()
{
    if(frmDAArrear.payrollFlag.value == 'N')
    {
        alert("DA Arrear Has Not Been Generated For This Record. Cannot Undo.");
        return false;
    }

    frmDAArrear.butAction.value = "Undo";
    frmDAArrear.action = "../../../GenerateDepDAArrear.do";
    frmDAArrear.submit();
}

function doQueryMode()
{
 //alert("hi");
 //DAArrearQueryMode GenDAQueryAction
  frmDAArrear.action="../../../DAArrearDepQueryMode.do"
  frmDAArrear.submit();
}

</script>
