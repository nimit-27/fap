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
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="PayOverAboveNewBaseAction" name="frmOverNAboveArrear" type="FCIPAY.Payroll.WEBTIER.Form.OverNAboveArrearfrm" scope="session">
<bean:define id="ParentForm" name="frmOverNAboveArrear" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="headerDataChanged"  />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<html:hidden property="payrollFlag" />
<html:hidden property="buttonFlag" />



<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>GENERATE OVER AND ABOVE ARREAR PAYMENT </TD>
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
                <td bgcolor="#4682B4" nowrap class=actTabText >Over And Above Arrear Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
              <td align="left"><html:text  property="txtPayYYMM" maxlength="10" readonly="true" size="20" styleClass="locked"   onchange="chk_YearMonth(this);" />
              &nbsp;&nbsp;<bean:message key="Pay.DAArr.YyMm" /></td>
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
               <td  bgcolor=#4682b4><html:button value='Generate Arrear' disabled="true"  onclick="genDAArrear()" property="butGenDAArrear" styleClass="bottomBarText" />
			   <html:button value='Undo Arrear' disabled="true" onclick="undoArrear()" property="butUndoArrear" styleClass="bottomBarText" />
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
<html:hidden name="frmOverNAboveArrear"  property="screenName" value="OverNAboveArrearScreen" />
<html:hidden name="frmOverNAboveArrear"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmOverNAboveArrear" />
<html:hidden property="butAction" name="frmOverNAboveArrear" />

<html:hidden property="positionRequested" name="frmOverNAboveArrear" />
<html:hidden property="userPositionRequested" name="frmOverNAboveArrear" />
<html:hidden property="loginLocCode" name="frmOverNAboveArrear" />

<html:hidden property="lovKey" name="frmOverNAboveArrear"  />
<html:hidden property="txtFields" name="frmOverNAboveArrear"  />   
<html:hidden property="txtSearchFields" name="frmOverNAboveArrear"  />
<html:hidden property="txtDisplayFields" name="frmOverNAboveArrear"  />
<html:hidden property="txtIndex" name="frmOverNAboveArrear"  />
<html:hidden name="frmOverNAboveArrear"  property="payYYMM"/>

<html:hidden name="frmOverNAboveArrear"  property="hdnAction" />


<input type="hidden" name="queryParam" >

<!-- Hidden fields end -->

</html:form>
</body>
</html:html>

 
<script language="javascript">

  function lfnLoad()
  {
    
mode=document.all.screenMode.value;

if (mode=='')
{
doQueryMode();
frmOverNAboveArrear.hdnAction.value='';    
}
else if(mode=='Q'){
	//    optClick('A');
	hedMenuHandling('Q');
	document.getElementById('txtPayYYMM').className = 'optional';
	document.getElementById('txtStYYMM').className = 'optional';
	document.getElementById('txtEndYYMM').className = 'optional';
		document.getElementById('txtDAType').className = 'optional';
			document.getElementById('txtPayYYMM').readOnly = false;

	}
	else if (mode=='N')
	{
	document.getElementById('txtPayYYMM').value=document.getElementById('payYYMM').value;
		hedMenuHandling('N');
		document.getElementById('butGenDAArrear').disabled = "";
	}
	else if (mode=='U')
	{
	document.getElementById('txtStYYMM').className = 'locked';
	document.getElementById('txtEndYYMM').className = 'locked';
		document.getElementById('txtDAType').className = 'locked';
document.getElementById('butUndoArrear').disabled = "";
	document.getElementById('txtDAType').disabled = true;
	document.getElementById('txtStYYMM').readOnly = true;
	document.getElementById('txtEndYYMM').readOnly = true;

	}	
	
	if (frmOverNAboveArrear.hdnAction.value=='S') 
	{
		document.all.butGenDAArrear.disabled="true";
		frmOverNAboveArrear.hdnAction.value='SUB';
		genDAArrear(); 
	}
	
	//hedMenuHandling('Q');
	//hedMenuHandling('N');

    
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
            event.srcElement.value ='';
        
        return false;
    
        }

      else if(month < 1 || month > 12)
       {
           alert("  Month should be Within 1 to 12");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;   
             event.srcElement.value ='';
        
          return false;
       }
         else if(year > d.getFullYear())
	{ 

	  alert("  Year should be before or same as current year");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;  
             event.srcElement.value ='';
        
          return false;
}

else if(year == d.getFullYear())
{
	if(month > d.getMonth()+1)
	{ 

	  alert("  Month should be before or same as current month");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false; 
             event.srcElement.value ='';
        
          return false;
}
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
             event.srcElement.value ='';
    return false;
     }
}


/*function genDAArrear()
{
	 var str="";  
    frmOverNAboveArrear.butAction.value = "Generate";    
    frmOverNAboveArrear.action = "../../../OverNAboveArrearPay.do";
    frmOverNAboveArrear.submit();
}
*/


function genDAArrear()
{  
   if(!mandatory_Check("frmOverNAboveArrear"))
  {
    return false;
  }
      frmOverNAboveArrear.butAction.value = "Generate";
      if (frmOverNAboveArrear.hdnAction.value != 'SUB') 
      {
        frmOverNAboveArrear.hdnAction.value = 'S'; 
        ac="../../../OverNAboveArrearPay.do";
        document.forms[0].action=ac;
		document.forms[0].submit();
		
      }
      else
      {
        frmOverNAboveArrear.hdnAction.value='SUB';       
        ac="../../../OverNAboveArrearPay.do";
        document.forms[0].action=ac;
		document.forms[0].submit();
      }        
}

function undoArrear()
{  
  document.getElementById('txtDAType').disabled = "";
      frmOverNAboveArrear.butAction.value = "Undo";

        document.forms[0].action="../../../OverNAboveUndoArrear.do";
		document.forms[0].submit();

}




function doQueryMode()
{ 
  frmOverNAboveArrear.hdnAction.value='Q'
  frmOverNAboveArrear.action="../../../OverNAboveArrearPayQueryMode.do";
  frmOverNAboveArrear.submit();
}
function doInsertMode()
{

frmOverNAboveArrear.hdnAction.value='N'
  frmOverNAboveArrear.action="../../../OverNAboveArrearPayNewMode.do";
  frmOverNAboveArrear.submit();
}
function doRefresh()
{
  frmOverNAboveArrear.action="../../../OverNAboveArrearPayRefresh.do";
  frmOverNAboveArrear.submit();
}
function getHeaderRecord()
{
 
  frmOverNAboveArrear.action="../../../OverNAboveArrearGetHeader.do";
  frmOverNAboveArrear.submit();
}
function doGetNextHeader()
{ 
    frmOverNAboveArrear.userPositionRequested.value = 1*frmOverNAboveArrear.positionRequested.value + 1;
    frmOverNAboveArrear.action="../../../OverNAboveArrearGetNextHeader.do";
    frmOverNAboveArrear.submit();
}


function PrevHeader()
{
  frmOverNAboveArrear.userPositionRequested.value = 1*frmOverNAboveArrear.positionRequested.value - 1;
  frmOverNAboveArrear.action = "../../../OverNAboveArrearGetPrevHeader.do";
  frmOverNAboveArrear.submit();
}


function JumpHeader()
{
  frmOverNAboveArrear.userPositionRequested.value = 1*frmOverNAboveArrear.newPositionRequested.value;
  frmOverNAboveArrear.action = "../../../OverNAboveArrearGetNextHeader.do";
  frmOverNAboveArrear.submit();
}


function chk_YearMonthEnd(that)
{

     
       var yearM = that.value;
	     var year  = yearM.substring (0,4);
       var month =  yearM.substring(4,6);
       var d = new Date ();
    
    if(frmOverNAboveArrear.txtStYYMM.value=='')
	  {
					alert('First fill value in "Start Year Month"  ');
					frmOverNAboveArrear.txtStYYMM.focus();
					that.value='';
					return false;
	 }
    if (num_Check(yearM,1))
     {                              
		if (yearM.length != 6)
		{
									alert(" Year Month should be a Six digit Number");
									event.srcElement.select();
									event.srcElement.focus();
									event.returnValue=false; 
                   event.srcElement.value ='';
								
									return false;
							
						}

			  else if(month < 1 || month > 12)
						   {
												   alert("  Month should be Within 1 to 12");
													event.srcElement.select();
													event.srcElement.focus();
													event.returnValue=false;
                           event.srcElement.value ='';
												
												  return false;
						   }
else if(year > d.getFullYear())
	{ 

	  alert("  Year should be before or same as current year");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false; 
             event.srcElement.value ='';
        
          return false;
}
else if(year == d.getFullYear())
{
	 if(month > d.getMonth()+1)
	{ 

	  alert("  Month should be before or same as current month");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;  
             event.srcElement.value ='';
        
          return false;
}
}

			   else if(frmOverNAboveArrear.txtStYYMM.value=='')
						   {
									   alert('First fill value in "Start Year Month"  ');
									   frmOverNAboveArrear.txtStYYMM.focus();
									   that.value='';
									   return false;
						   }
			   else if(frmOverNAboveArrear.txtStYYMM.value>yearM)
						   {
											alert('"Start Year Month" can not be greater than "Upto Year Month "  ');
											that.value='';
											frmOverNAboveArrear.txtStYYMM.value='';
											return false;
						   }

			   else if(frmOverNAboveArrear.payYYMM.value <= yearM)
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


</script>
