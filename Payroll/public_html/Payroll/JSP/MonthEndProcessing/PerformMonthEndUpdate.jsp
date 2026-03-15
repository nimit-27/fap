<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script> 
	<script type = "text/javascript">
       function enableForm()
        {
            document.forms[0].disabled=true;
        }
        window.onload=enableForm;
    </script> 

   <style type="text/css">
	.black_overlay{
		display: none;
		position: absolute;  
		top: 0px;
		left: 0px;
		width: 100%;
		background-color: black;
		z-index:1001;
		-moz-opacity: 0.7;
		opacity:.7;
		filter: alpha(opacity=70);
	}
	.white_content { 
		display: none;  
		position: absolute;
		padding: 5px;
		height:40px;
		border: 1px solid blue;
		background-color: white;
		z-index:1002;
	
		/*overflow: auto;*/
	}
	</style>

   
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);"  onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MonthUpdate" name="frmMonthUpdate" type="FCIPAY.Payroll.WEBTIER.Form.PerformMonthEndUpdateForm" scope="session" >
<bean:define id="ParentForm" name="frmMonthUpdate" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<html:errors/>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>PERFORM MONTH END UPDATE FOR <bean:write name="frmMonthUpdate" property="payYYMM" /></TD>
</TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> MONTH END DETAILS</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
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
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    <tr height = 10><td></td></tr>
                    <tr height = 10><td></td></tr>                  
        		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
               
    <TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
          <td align=center bgcolor=#4682b4 width="40%"></td>
           
               <td bgcolor=#4682b4 width="20%"><html:button value='Perform Month End'  onclick="MonthEndTransaction()" disabled="false" property="butInsert" styleClass="bottomBarText" /></td>
               <td bgcolor=#4682b4 width="20%">
               <td bgcolor=#4682b4 width="20%"></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>	     </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden property="screenMode" name="frmMonthUpdate" />
<html:hidden name="frmMonthUpdate" property="hdnAction" />    
<html:hidden name="frmMonthUpdate" property="screenName" value="MonthUpdateScreen" />

<html:hidden property="lovKey" name="frmMonthUpdate"  />
<html:hidden property="txtFields" name="frmMonthUpdate"  />   
<html:hidden property="txtSearchFields" name="frmMonthUpdate"  />
<html:hidden property="txtDisplayFields" name="frmMonthUpdate"  />
<html:hidden property="txtIndex" name="frmMonthUpdate"  />
<html:hidden property="txtEmpWaitJoin" name="frmMonthUpdate"  />

<html:hidden property="payYYMM" name="frmMonthUpdate"  />

<html:hidden property="loginEmployeeNo" name="ParentForm"  />
</html:form>

<div id="fade" style="display: none; position: absolute; top: 0px; left: 0px; width: 100%; background-color: black; z-index:1001; -moz-opacity: 0.7; opacity:.7; filter: alpha(opacity=70)"></div>
<div id="light" class="white_content" >
	Enter User id : <input name="txt1" id="txt1" type="text">
	<input name="xyz" type="button" value="Check" onClick="verifyUser()" >
	<!--<input type="submit" name="button" id="button" value="Close" onClick="close_div()">-->
</div>


</body>
</html:html>

 
<script language="javascript">

function lfnLoad()
{
  
  batchMenuHandling();
 
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
	  enableForm(); 
      doQueryMode();
      frmMonthUpdate.hdnAction.value='';      
  }

  if (frmMonthUpdate.hdnAction.value=='Q') //added by Swapnendu Dt 15 Feb 2011.
  {
	 frmMonthUpdate.hdnAction.value="EMPTJ";
     getEmpWaitingToJoin(); 
  }

  if (frmMonthUpdate.hdnAction.value=='S') 
  {
     document.all.butInsert.disabled="true"; // added by devendra on 1 0ct 2010
	 frmMonthUpdate.hdnAction.value='SUB';
     MonthEndTransaction(); 
  }
  
}

function getEmpWaitingToJoin() //added by Swapnendu Dt 15 Feb 2011.
{
  frmMonthUpdate.action="../../../EmpWaitingToJoin.do"
  frmMonthUpdate.submit();
}

function doQueryMode()
{
  frmMonthUpdate.hdnAction.value='Q' 
  frmMonthUpdate.action="../../../ComputeMonthEndQuery.do"
  frmMonthUpdate.submit();
}

function MonthEndTransaction()
{
	var no_emp_join = frmMonthUpdate.txtEmpWaitJoin.value;
	if(validateYYYYMM()) return;  //added by swapnendu Dt 01 Dec 2010.
	frmMonthUpdate.butInsert.disabled = "true";
	if (frmMonthUpdate.hdnAction.value != 'SUB') 
	{
		if(confirm("Have you transferred out the employees ?")) //added by Swapnendu Dt 15 Feb 2011.
		{
			if (no_emp_join > 0)
			{
				if(!confirm("You have "+no_emp_join+" employees waiting to join. Do you want to join them ?"+ '\n' + "" +'\n'+
							"Press OK to abort Monthend and Go for employee joinning." + '\n' +
							"Press Cancel to proceed to month end update.")) //added by Swapnendu Dt 15 Feb 2011.
				{
					frmMonthUpdate.hdnAction.value = 'S'; 
					frmMonthUpdate.action = "../../../ComputeMonthEnd.do";
					frmMonthUpdate.submit();
				}
			}
			else
			{
				frmMonthUpdate.hdnAction.value = 'S'; 
				frmMonthUpdate.action = "../../../ComputeMonthEnd.do";
				frmMonthUpdate.submit();
			}
		}
	}
	else
	{
		validateUser();
	}
}
  
function validateYYYYMM() //added by swapnendu Dt 01 Dec 2010.
{
	var yyyymm = frmMonthUpdate.payYYMM.value;
	var yyyy = yyyymm.substring(0,4);
	var mm = yyyymm.substring(4,6);
	var d = new Date();
	var curr_month = d.getMonth();
	curr_month = eval(curr_month)+1;
	var curr_year = d.getFullYear();
	if (eval(yyyy) > eval(curr_year))
	{
		alert("you are not allowed to Perform Month End Update for : "+yyyymm);
		return true;
	}
	if (eval(yyyy) == eval(curr_year))
	{
		if (eval(mm) > eval(curr_month))
		{
			alert("you are not allowed to Perform Month End Update for : "+yyyymm);
			return true;
		}
	}
	return false;
}

function validateUser()
{
	var userid = document.getElementById("loginEmployeeNo").value;
	if (userid == 0 || userid == "")
	{
		alert("please reload the page");
		return false;
	}
	else
	{
		createDiv();
		return false;
	}
	return true;
}

function createDiv()
{
	var fade_div=document.getElementById('fade');
	var light_div=document.getElementById('light');
	var y=getWindowHeight();
	var x=getWindowWidth();
	fade_div.style.height=y;
	var height=100;//575;
	var width=300;//300;
	var top=(eval(y)-eval(height))/2;
	var left=(eval(x)-eval(width))/2;
	light_div.style.top=top;
	light_div.style.left=left;
	light_div.style.display='block';
	fade_div.style.display='block';
	document.getElementById('txt1').focus();
}

function getWindowHeight(){
	if(document.all) return (document.documentElement.clientHeight) ? document.documentElement.clientHeight : document.body.clientHeight;
	else return window.innerHeight;
}

function getWindowWidth(){
	if(document.all) return (document.documentElement.clientWidth) ? document.documentElement.clientWidth : document.body.clientWidth;
	else return window.innerWidth;
}

function close_div()
{
	document.getElementById('light').style.display='none';
	document.getElementById('fade').style.display='none';
}
function verifyUser()
{
	var vUser = document.getElementById("txt1").value;
	var vLoginUser = frmMonthUpdate.loginEmployeeNo.value;
	if (vUser == vLoginUser)
	{
		close_div();
		frmMonthUpdate.hdnAction.value='SUB';       
		frmMonthUpdate.action = "../../../ComputeMonthEnd.do";
		frmMonthUpdate.submit();
	}
	else
	{
		alert("Incorrect user id. Please re-enter.");
		document.getElementById('txt1').select();
	}
}


</script>