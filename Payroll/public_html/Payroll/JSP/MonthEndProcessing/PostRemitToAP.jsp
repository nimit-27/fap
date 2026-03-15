<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.Calendar,java.text.SimpleDateFormat"%>
<%! int i=0;%>
<html:html>
 <%
 Calendar cal = Calendar.getInstance();
 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
 String now=sdf.format(cal.getTime());
 SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
 String now1=sdf1.format(cal.getTime());
 %>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
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

</head>

<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="PostRemitToAP" name="frmPostRemitToAP" type="FCIPAY.Payroll.WEBTIER.Form.PostRemitToAPForm">
<bean:define id="ParentForm" name="frmPostRemitToAP" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
 <html:hidden property="fromFlag" name="frmPostRemitToAP" value="First" />
<input type="hidden" name="sysdate" value="<%=sdf.format(cal.getTime())%>">
<input type="hidden" name="sysdate1" value="<%=now1%>">
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
<TR height=30>
  <TD  colSpan=11 class=mainHeader height=10>POST REMITTANCES TO AP FOR <bean:write name="frmPostRemitToAP" property="payYYMM" /></TD>
</TR>
<tr height="10"><td class=userText colspan="11"></td></tr>
</TABLE>


<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
      <!-- <div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--pay Scale Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>POST REMITTANCES TO AP</TD>


        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

        
<TR height=220>
 <!-- Detail table Container starts -->
<TD colspan=11>
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                      <TD >

                     </TD>
                     </TR>
 </TBODY>
</TABLE>
</TD>
                     </TR>

        <tr>

                            <td class=labelText align=left  width="35%" bgcolor=#4682b4> </td>                
                            <td width="25%" bgcolor=#4682b4><font color="#FFFFFF">Invoice Date &nbsp;&nbsp;</font>
                            <logic:equal name="frmPostRemitToAP" property="formFlag" value="First">
                            <html:text  property="txtInvDt" styleClass = "optional" maxlength="10"  size="23"  readonly="true" onchange="checkfuturedate(this)" value="<%=now%>" />
                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butInvDt1" alt="<%=(i-1) %>" onclick="showCalendar('txtInvDt',this)" />
                            </logic:equal>
                            
                            <logic:notEqual name="frmPostRemitToAP" property="formFlag" value="First">
                            <html:text  property="txtInvDt" styleClass = "optional" maxlength="10"  size="23"  readonly="true" onchange="checkfuturedate(this)"/>
                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butInvDt" alt="<%=(i-1) %>" onclick="showCalendar('txtInvDt',this)" />
                            </logic:notEqual>
                                                                                 
                           </td>
                            <td bgcolor=#4682b4>&nbsp;</td>
                             <td bgcolor=#4682b4>&nbsp;</td>  
                            <!--td>&nbsp;</td-->
                            </tr>
                            
                            <tr>
                             <td>&nbsp;</td>
                             <td>&nbsp;</td>
                             <td>&nbsp;</td>
                             <td>&nbsp;</td>
                            </tr>
                            
               <TR>
               <td align=center bgcolor=#4682b4 width="35%"></td>
           
               <td  bgcolor=#4682b4 width="25%"><html:button value='Post Remittances to AP'  onclick="PostRemitTransaction()" disabled="false" property="butInsert" styleClass="bottomBarText" /></td>
               <td  bgcolor=#4682b4 width="25%">
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
               </TR>
</TD>
   </TR>
   </TBODY>
   </table>

<html:hidden name="frmPostRemitToAP"  property="screenName" value="PostRemitToAPScreen" />
<html:hidden name="frmPostRemitToAP"  property="forwardedPage" />
<html:hidden name="frmPostRemitToAP"  property="hdnAction" />    <!--added by devendra on 29t sept-->
<html:hidden property="screenMode" name="frmPostRemitToAP" />

<html:hidden property="payYYMM" name="frmPostRemitToAP" />

</html:form>
</body>
</html:html>

<script language="javascript">

//Added by Neeraj Starts
function checkfuturedate(seldate)
{
//alert("inside function--->"+seldate.value);
//alert("cur date"+frmPostRemitToAP.sysdate.value);
var date1=new Date(seldate.value.replace(/[-]/g," "));
//alert(date1);
var date2=new Date(frmPostRemitToAP.sysdate.value.replace(/[-]/g," "));
//alert(date2);
if(date1.getTime()>date2.getTime())
{
alert("Invoice date cannot be more than the system date!");
frmPostRemitToAP.txtInvDt.value=frmPostRemitToAP.sysdate.value;
}
}
//Added By Neeraj Ends

function lfnLoad()
{
  
 
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
     enableForm();
	  doQueryMode();

	  frmPostRemitToAP.hdnAction.value='';  // added by devendra on 29 sept 2010
  }
  // added by devendra on 29th sept 2010 start
  if (frmPostRemitToAP.hdnAction.value=='S') 
  {
     document.all.butInsert.disabled="true";
	 frmPostRemitToAP.hdnAction.value='SUB';
     PostRemitTransaction(); 
  }
  // added by devendra on 29 sept 2010 end
  batchMenuHandling();
}

function doQueryMode()
{
  frmPostRemitToAP.action="../../../PostRemitQueryMode.do";
  frmPostRemitToAP.submit();
}

 function PostRemitTransaction()
{
	
 // document.forms[0].action="../../../PostRemitAction.do"; commented by devendra on 29th sept 2010
 // document.forms[0].submit();  commented by devendra on 29th sept 2010

	 if(validateYYYYMM()) return;  //added by swapnendu Dt 01 FEB 2011.
	// added by devendra on 29 sept 2010 start
	 if (frmPostRemitToAP.hdnAction.value != 'SUB') 
	  {
		frmPostRemitToAP.hdnAction.value = 'S'; 
		frmPostRemitToAP.action = "../../../PostRemitAction.do";
		frmPostRemitToAP.submit();
	  }
	  else
	  {
		frmPostRemitToAP.hdnAction.value='SUB';       
		frmPostRemitToAP.action = "../../../PostRemitAction.do";
		frmPostRemitToAP.submit();
	  }
	//added by devendra on 29 th sept 2010 end
}

function validateYYYYMM() //added by swapnendu Dt 01 Dec 2010.
{
	var arr = new Array();
	var currDate = frmPostRemitToAP.sysdate1.value;
	arr = currDate.split("/");
	var curr_month = arr[1];
	var curr_year = arr[2];
	
	var yyyymm = frmPostRemitToAP.payYYMM.value;
	if (yyyymm == "") return true;
	//alert("post remitances to ap for :"+yyyymm)
	var yyyy = yyyymm.substring(0,4);
	var mm = yyyymm.substring(4,6);
	//alert(curr_month+"=============="+curr_year);

	var mon_arr = new Array();
	var msg_mon1 = "";
	var msg_mon2 = "";
	var msg_year2 = "";
	mon_arr = ["","Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"];
	msg_mon1 = mon_arr[eval(mm)];;
	if (eval(mm)==12)
	{
		msg_year2 = eval(yyyy)+1;
		msg_mon2 = mon_arr[1];
	}
	else
	{
		msg_year2 = yyyy;
		msg_mon2 = mon_arr[eval(mm)+1];
	}
	//alert(msg_mon+"-"+msg_year);

	if (eval(yyyy) >= eval(curr_year))
	{
		if (eval(yyyy) > eval(curr_year))
		{
			alert("You can Post Remittances to AP For '"+msg_mon1+"-"+yyyy+"' From '01-" +msg_mon2+ "-" +msg_year2+ "' onwords Only.");
			return true;
		}

		if (eval(yyyy) == eval(curr_year))
		{
			if (eval(mm) >= eval(curr_month))
			{
				alert("You can Post Remittances to AP For '"+msg_mon1+"-"+yyyy+"' From '01-" +msg_mon2+ "-" +msg_year2+ "' onwords Only.");
				return true;
			}
		}
	}
	return false;
}
  
</script>