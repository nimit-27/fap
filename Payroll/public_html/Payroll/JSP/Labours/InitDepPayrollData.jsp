<%@ page import="java.util.*"%>
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
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="InitDepLbrPayData" name="frmInitPayroll" type="FCIPAY.Payroll.WEBTIER.Form.InitPayDataForm" scope="session">
<bean:define id="ParentForm" name="frmInitPayroll" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>INITIALIZE PAYROLL TRANSACTION FOR <bean:write name="frmInitPayroll" property="payYYMM" /></TD>
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
          <TD class=subHeader colspan=6> Initialize Payroll Transaction</TD>
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
        
               <td align=center bgcolor=#4682b4 width="30%"></td>
               <td  bgcolor=#4682b4><html:button value=' Initialize Transaction'  onclick="InitTransaction();" property="butInitTran" styleClass="bottomBarText" /></td>
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
<html:hidden name="frmInitPayroll"  property="forwardedPage" />
<html:hidden name="frmInitPayroll"  property="screenMode" />
<html:hidden name="frmInitPayroll"  property="hdnAction" />
<html:hidden name="frmInitPayroll"  property="screenName" value="InitPayDepLbrScreen" />

<html:hidden property="lovKey" name="frmInitPayroll"  />
<html:hidden property="txtFields" name="frmInitPayroll"  />   
<html:hidden property="txtSearchFields" name="frmInitPayroll"  />
<html:hidden property="txtDisplayFields" name="frmInitPayroll"  />
<html:hidden property="txtIndex" name="frmInitPayroll"  />
<html:hidden property="txtSepEmpList" name="frmInitPayroll"  />
<html:hidden property="txtButFlg" name="frmInitPayroll"  />


</html:form>
</body>
</html:html>


 
<script language="javascript">

  function lfnLoads()
  {
      var sMode = frmInitPayroll.screenMode.value;

/*      if(mode == '')
      {
        frmInitPayroll.screenMode.value='Q';      
        frmInitPayroll.action = "../../../InitDepLbrPayrollQuery.do";
        frmInitPayroll.submit();
      }
      else
      {
        batchMenuHandling();
      }  */

/*  if(sMode == "")
  {
    doQueryMode();
  }  */

      batchMenuHandling();      
      doQueryMode();      
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     
  }

function lfnLoader()
{
  mode=document.all.screenMode.value;
  if(mode=='Q'){}
  else
  {
    doQueryMode();
    frmInitPayroll.hdnAction.value='';
  } 
      batchMenuHandling();
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";       
//    doQueryMode();      
}

function lfnLoad()
{
  batchMenuHandling();
 
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
      doQueryMode();
      frmInitPayroll.hdnAction.value='';
  }

  if (frmInitPayroll.hdnAction.value=='S') 
  {
     frmInitPayroll.hdnAction.value='SUB';
     InitTransaction(); 
  }

      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg"; 
      if(document.getElementById("txtButFlg").value == "" && screenmode == 'Q')
	{
		 
		document.getElementById("txtButFlg").value = "FirstLoad";
		document.getElementById("butInitTran").disabled="true";
	   get_PenaltyEmpList();
	}
	
	var empList = frmInitPayroll.txtSepEmpList.value;
	
	if(empList != "")
	{
		   
		var vAlert = "Retirement due for the following Employees(s)." +"\n"
						+empList +  "\n" 
						+ " Please Separate the employee(s) to continue Initialisation Procss.";
        alert(vAlert);
		document.getElementById("butInitTran").disabled="true";
		return false;
		
	}

   

    
}
function get_PenaltyEmpList()
{
	document.forms[0].action="../../../ChkPenaltyEmpList.do";
	document.forms[0].submit();
}
function show_TobeSeparateEmpList()
{

	var empList = frmInitPayroll.txtSepEmpList.value;

	//alert("show_TobeSeparateEmpList="+empList)


	if(empList != "")
	{
		var vAlert = "Retirement due for the following Employees(s)." +"\n"
						+empList +  "\n" 
						+ " Please Separate the employee(s) to continue Initialisation Procss.";
        alert(vAlert);
		return true;
	}
}
  
function chk_SeparatedEmp()
{	
	frmInitPayroll.action = "../../../CheckSeparationEmpAction.do?param1=Separation";
	frmInitPayroll.submit();
}

function doQueryMode()
{
  frmInitPayroll.hdnAction.value='Q'
  frmInitPayroll.action="../../../InitDepLbrPayrollQuery.do"
  frmInitPayroll.submit();
}
  


  function InitTransaction()
  {
	  frmInitPayroll.butInitTran.disabled="true";
      if (frmInitPayroll.hdnAction.value != 'SUB') 
      {
        /*if(!chk_SeparationEmp()) return false;*/
        frmInitPayroll.hdnAction.value = 'S'; 
        frmInitPayroll.action = "../../../InitDepLbrPayroll.do";
        frmInitPayroll.submit();
      }
      else
      {
        frmInitPayroll.hdnAction.value='SUB';       
        frmInitPayroll.action = "../../../InitDepLbrPayroll.do";
        frmInitPayroll.submit();
      }      
  }

 function chk_SeparationEmp()
 {
	var EmpNumLstArr1 = new Array();
	var flag = 0;
	<%
	ArrayList EmpNumLst = (ArrayList)request.getSession().getAttribute("EmpNumList");
	if(EmpNumLst != null)
	{
		for(int i=0; i<EmpNumLst.size(); i++)
		{
			String empNum=EmpNumLst.get(i).toString();
			%>
			var empNumJS="<%=empNum%>";
			EmpNumLstArr1.push(empNumJS);
			<%
		}
	}
	%>
	var separatedEmp;
	var allSepEmp ="";
	for(var s=0; s<EmpNumLstArr1.length; s++)
	{
		var separatedEmp = EmpNumLstArr1[s];
		if(allSepEmp != "")
		{
			allSepEmp = allSepEmp +','+separatedEmp;
		}
		else
		{
			allSepEmp = separatedEmp;
		}
	}
	if(allSepEmp != "")
	{
		var msg = confirm("Retirement due for the following Employee(s)." +"\n"+allSepEmp +  "\n" + " Press OK to continue and CANCEL to Initiate the Separation process.")
		if (!msg)
		{    
			flag=flag+1;
		}
	}

	if(flag > 0) return false;
	else return true;
 }

</script>

