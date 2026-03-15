<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%
	String lbrType = (String)session.getAttribute("hdnEmpLbrFlag"); 

%>
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
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="GenDAArrear" name="frmDAArrear" type="FCIPAY.Payroll.WEBTIER.Form.GenDaArrearForm" scope="session">
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
<%
if(lbrType.equals("D")){
%>
  <TD  colSpan=12 class=mainHeader height=10>GENERATE MGW/ASOR ARREAR FOR <bean:write name="frmDAArrear" property="payYYMM" /></TD>
 <%}else{%>
   <TD  colSpan=12 class=mainHeader height=10>GENERATE HRA/DA ARREAR FOR <bean:write name="frmDAArrear" property="payYYMM" /></TD>
  <%}%>
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
                <td bgcolor="#4682B4" nowrap class=actTabText >Generate HRA/DA Arrear Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
			  <logic:notEqual name='frmDAArrear' property='screenMode' value='N'>
              <td align="left"><html:text  property="txtPayYYMM" maxlength="10" size="20" styleClass="required" readonly=""  onchange="chk_YearMonth(this);" />
			  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayYYMM" onclick="showLovYYMM();"  >&nbsp;&nbsp;<bean:message key="Pay.DAArr.YyMm" /></td> 
			  </logic:notEqual>
			   <logic:equal name='frmDAArrear' property='screenMode' value='N'>
			   <td align="left"><html:text  property="txtPayYYMM" maxlength="10" size="20" styleClass="locked" readonly="true" /></td> 
			   </logic:equal>
              <td class="labelText"  ><bean:message key="Pay.DAArr.SYMonth" />&nbsp;<html:text  property="txtStYYMM" maxlength="10" size="20" styleClass="required" onchange="chk_YearMonth(this); " />&nbsp;&nbsp;<bean:message key="Pay.DAArr.YyMm" /></td>
          </tr>
          <tr>
              <td class="labelText"   ><bean:message key="Pay.DAArr.DAType" /></td>
              <td align="left"><html:select property="txtDAType" styleClass="required" >
                   <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                   <html:option value="IDA" > <bean:message key="Pay.DAArr.Ida" /></html:option>
                   <html:option value="CDA" > <bean:message key="Pay.DAArr.Cda" /></html:option>
                   <html:option value="HRAIDA" > <bean:message key="Pay.DAArr.HRAIda" /></html:option>
                   <html:option value="HRACDA" > <bean:message key="Pay.DAArr.HRACda" /></html:option>
                 
                   </html:select>
              </td>
              <td class="labelText"  ><bean:message key="Pay.DAArr.EYMonth" />&nbsp;<html:text  property="txtEndYYMM" maxlength="10" size="20" styleClass="required" onchange="chk_YearMonthEnd(this); " />&nbsp;&nbsp;<bean:message key="Pay.DAArr.YyMm" /></td>
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
               <td  bgcolor=#4682b4>
			   <logic:equal property="screenMode"  name="frmDAArrear" value="N">
				<html:button value="Generate DA/HRA Arrear" property="butGenDAArrear" styleClass="bottomBarText" disabled="true"/>
				<html:button value="Undo DA/HRA Arrear" property="butUndoDAArrear" styleClass="bottomBarText" disabled="true"/>
				</logic:equal>
				<logic:notEqual property="screenMode"  name="frmDAArrear" value="N">
				<html:button value="Generate DA/HRA Arrear"  onclick="genDAArrear()" property="butGenDAArrear" styleClass="bottomBarText" />
				<html:button value="Undo DA/HRA Arrear" onclick="undoDAArrear()" property="butUndoDAArrear" styleClass="bottomBarText" />
				</logic:notEqual>
			   </td>
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
<html:hidden name="frmDAArrear"  property="screenName" value="GenDAArrScreen" />
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
<html:hidden name="frmDAArrear"  property="hdnAction" /><!--///////////added by sonia///////////////-->
<html:hidden name="frmDAArrear"  property="txtEmp" value="" /><!--///////////added by sonia///////////////-->
<html:hidden name="frmDAArrear"  property="payYYMM"/><!--///////////added by gagan///////////////-->
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
  frmDAArrear.action="../../../DAArrearFirstGetHeaderAction.do"
  frmDAArrear.submit();
}


function doGetNextHeader()
{ 
    frmDAArrear.userPositionRequested.value = 1*frmDAArrear.positionRequested.value + 1;
    frmDAArrear.action="../../../DAArrearGetNextHeader.do";
    frmDAArrear.submit();
}


function PrevHeader()
{
  frmDAArrear.userPositionRequested.value = 1*frmDAArrear.positionRequested.value - 1;
  frmDAArrear.action = "../../../DAArrearGetPrevHeader.do";
  frmDAArrear.submit();
}


function JumpHeader()
{
  frmDAArrear.userPositionRequested.value = 1*frmDAArrear.newPositionRequested.value;
  frmDAArrear.action = "../../../DAArrearGetNextHeader.do";
  frmDAArrear.submit();
}

function doInsertMode()
{
  frmDAArrear.action="../../../DAArrearNewMode.do"
  frmDAArrear.submit();
}

function doQueryMode()
{
  frmDAArrear.action="../../../DAArrearQueryMode.do"
  frmDAArrear.submit();
}

function doRefresh()
{  
  alert("Refresh");
  frmDAArrear.action="../../../GenDAArrearRefresh.do"
  frmDAArrear.submit();
}


function SaveRecord()
{
if(!mandatory_Check("frmDAArrear"))
{
return false;
}
else
{
	frmDAArrear.txtDAType.disabled="";
    frmDAArrear.headerDataChanged.value = "true";    
    frmDAArrear.headerFields.value = "true";
    frmDAArrear.action = "../../../DAArrearSaveAction.do";
    frmDAArrear.submit();
	return true;
}
}

function lfnLoad()
{
            frmDAArrear.butGenDAArrear.value='Generate DA/HRA Arrear';
            frmDAArrear.butUndoDAArrear.value='Undo DA/HRA Arrear'
  //alert("screenmode "+ document.all.screenMode.value);
  var screenmode = document.all.screenMode.value;
  
  if(screenmode == '')
  {   
      doQueryMode();
	  frmDAArrear.hdnAction.value='';  ///////////added by sonia///////////////
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
   // document.frmDAArrear.txtDAType.disabled="true";
    document.frmDAArrear.txtPayYYMM.disabled="";    
    document.frmDAArrear.txtStYYMM.disabled="true";
    document.frmDAArrear.txtEndYYMM.disabled="true";
  }
  menuHandling(screenmode);

///////////added by sonia///////////////
  if (frmDAArrear.hdnAction.value=='S') 
	{
		document.all.butGenDAArrear.disabled="true";
		frmDAArrear.hdnAction.value='SUB';
		genDAArrear(); 
	}
///////////added by sonia///////////////

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
	  frmDAArrear.txtPayYYMM.value=frmDAArrear.payYYMM.value;
	  if(frmDAArrear.hdnEmpLbrFlag.value=='D')
	  {
	  frmDAArrear.txtDAType.value='IDA';
	  document.all.txtDAType.disabled='true';
	  }
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

function chk_YearMonthEnd(that)
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
			   else if(frmDAArrear.txtStYYMM.value=='')
						   {
									   alert('First fill value in "Start Year Month"  ');
									   frmDAArrear.txtStYYMM.focus();
									   that.value='';
									   return false;
						   }
			   else if(frmDAArrear.txtStYYMM.value>that.value)
						   {
											alert('"Start Year Month" can not be greater than "Upto Year Month "  ');
											that.value='';
											frmDAArrear.txtStYYMM.value='';
											return false;
						   }

			   else if(frmDAArrear.payYYMM.value<=that.value)
						   {
										alert('"Upto Year Month" can not be greater than or equals to "Payroll Year Month "  ');
										that.value='';
										that.focus();										
										return false;
						   }
			   
			   else
						   {
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
if(mandatory_Check('frmDAArrear'))
{
			 var str="";
			if(frmDAArrear.payrollFlag.value == 'Y')
			{
			  alert("DA Arrear Has Been Already Generated For This Record. Cannot Generate Again Without Undoing.");
			  return false;
			} 
			frmDAArrear.butAction.value = "Generate";
			if (frmDAArrear.hdnAction.value != 'SUB') 
			  {
				 
				frmDAArrear.hdnAction.value = 'S'; 
				ac="../../../GenerateDAArrear.do?param1="+str+"&param2="+document.all.txtEmp.value;      
				document.forms[0].action=ac;
				document.forms[0].submit();
				
			  }
			  else
			  {
				frmDAArrear.hdnAction.value='SUB';       
				ac="../../../GenerateDAArrear.do?param1="+str+"&param2="+document.all.txtEmp.value;
				document.forms[0].action=ac;
				document.forms[0].submit();
			  }  
}			  
else
	{
	 return false;
	}
///////////end added by sonia///////////////

}


function undoDAArrear()
{
    if(frmDAArrear.payrollFlag.value == 'N')
    {
        alert("DA Arrear Has Not Been Generated For This Record. Cannot Undo.");
        return false;
    }

    frmDAArrear.butAction.value = "Undo";
    frmDAArrear.action = "../../../GenerateDAArrear.do";
    frmDAArrear.submit();
}

function doQueryMode()
{
 //alert("hi");
 //DAArrearQueryMode GenDAQueryAction
  frmDAArrear.hdnAction.value='Q'///////////added by sonia///////////////
  frmDAArrear.action="../../../DAArrearQueryMode.do"
  frmDAArrear.submit();
}

</script>
