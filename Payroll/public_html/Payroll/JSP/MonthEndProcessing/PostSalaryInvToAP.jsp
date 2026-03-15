<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.Calendar,java.text.SimpleDateFormat"%>
 <%! int i=0; %>
 <%
 Calendar cal = Calendar.getInstance();
 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
 String now=sdf.format(cal.getTime());
 %>
<html:html>
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
<html:form  action="PostSalaryInvToAP" name="frmPostSalaryInvToAP" type="FCIPAY.Payroll.WEBTIER.Form.PostSalaryInvToAPForm">
<bean:define id="ParentForm" name="frmPostSalaryInvToAP" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
 <html:hidden property="fromFlag" name="frmPostSalaryInvToAP" value="First" />
<input type="hidden" name="sysdate" value="<%=sdf.format(cal.getTime())%>">
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
<TR height=30>
  <TD  colSpan=11 class=mainHeader height=10>POST SALARY INVOICES TO AP FOR <bean:write name="frmPostSalaryInvToAP" property="payYYMM" /></TD>
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
       <TABLE cellSpacing=0 cellPadding=0 border=0>
       <!--pay Scale Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>POST SALARY INVOICES TO AP</TD>


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
                            <logic:equal name="frmPostSalaryInvToAP" property="formFlag" value="First">
                            <html:text  property="txtInvDt" styleClass = "optional" maxlength="10"  size="23"  readonly="true" onchange="checkfuturedate(this)"  />
                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butInvDt1" alt="<%=(i-1) %>" onclick="showCalendar('txtInvDt',this)" />
                            </logic:equal>
                            
                            <logic:notEqual name="frmPostSalaryInvToAP" property="formFlag" value="First" >
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
           
               <td  bgcolor=#4682b4 width="25%"><html:button value='Post Salary Invoices to AP'  onclick="PostSalInvTransaction()" disabled="false" property="butInsert" styleClass="bottomBarText" /></td>
               <td  bgcolor=#4682b4 width="25%">
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>


</TD>
   </TR>
   </TBODY>
   </table>

 <html:hidden name="frmPostSalaryInvToAP"  property="screenName" value="PostSalaryInvToAPScreen" />
<html:hidden name="frmPostSalaryInvToAP"  property="forwardedPage" />
<html:hidden name="frmPostSalaryInvToAP"  property="hdnAction" />    <!--added by devendra on 29t sept-->
<html:hidden property="screenMode" name="frmPostSalaryInvToAP" />
<html:hidden property="payYYMM" name="frmPostSalaryInvToAP" /><!--added by sonia on 17 jan-->

</html:form>
</body>
</html:html>

<script language="javascript">
//Added by Neeraj Starts
function checkfuturedate(seldate)
{
//alert("inside function--->"+seldate.value);
//alert("cur date"+document.all.sysdate.value);
var date1=new Date(seldate.value.replace(/[-]/g," "));
//alert(date1);
var date2=new Date(document.all.sysdate.value.replace(/[-]/g," "));
//alert(date2);
if(date1.getTime() > date2.getTime())
{
alert("Invoice date cannot be more than the system date!");
document.all.txtInvDt.value=document.all.sysdate.value;
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
	  frmPostSalaryInvToAP.hdnAction.value='';  // added by devendra on 29 sept 2010
  }
  // added by devendra on 29th sept 2010 start
  if (frmPostSalaryInvToAP.hdnAction.value=='S') 
  {
     document.all.butInsert.disabled="true";
	 frmPostSalaryInvToAP.hdnAction.value='SUB';
     PostSalInvTransaction(); 
  }
  // added by devendra on 29 sept 2010 end
  batchMenuHandling();
   lastdate();
}


function doQueryMode()
{
  frmPostSalaryInvToAP.action="../../../PostSalAPQueryMode.do";
  frmPostSalaryInvToAP.submit();
}

 function PostSalInvTransaction()
{  
     //if(!checkMonth())
      //return false;
   
  //document.forms[0].action="../../../PostSalaryAP.do"; commented by devendra on 29th sept 2010
  //document.forms[0].submit(); commented by devendra on 29th sept 2010


 var yymm=frmPostSalaryInvToAP.payYYMM.value;
 var curDate=frmPostSalaryInvToAP.txtInvDt.value;
 var mnth=curDate.substring(3,6);
 var year1=curDate.substring(7,11);
 var month=getMonth(mnth);

		 if(month < 10){
		 var postyyyymm=year1+"0"+month;
		 }
		 if(month > 9){
		 var postyyyymm=year1+month;
		 }
		
		if(postyyyymm != yymm ){
		 alert("Please change the invoice date!!!");
		 return false; 				
		 }

  // added by devendra on 29 sept 2010 start
 
 if (frmPostSalaryInvToAP.hdnAction.value != 'SUB') 
      {        
		frmPostSalaryInvToAP.hdnAction.value = 'S'; 
        frmPostSalaryInvToAP.action = "../../../PostSalaryAP.do";
        frmPostSalaryInvToAP.submit();
      }
      else
      {
        frmPostSalaryInvToAP.hdnAction.value='SUB';       
        frmPostSalaryInvToAP.action = "../../../PostSalaryAP.do";
        frmPostSalaryInvToAP.submit();
      }      
  //added by devendra on 29 th sept 2010 end
}

//start added by sonia 

function lastdate(){
	var curdate='<%=now%>';
	var yymm=frmPostSalaryInvToAP.payYYMM.value;	
    var mm=yymm.substring(4,6);	
    var yyyy=yymm.substring(0,4);		
	var varday=getLastDayOfMonth(mm,yyyy);	
	var month1=getMonth(mm);
	var curmnth=curdate.substring(3,6);
	var curyr=curdate.substring(7,11);
	
    var month2=getMonth(curmnth);
	if(month2<9){
	month2="0"+month2;	
	}
	//alert(month2)
	
	var curyymm=curyr+month2;
	//alert("curyymm" + curyymm +"---yymm" +yymm )
		if(curyymm==yymm){
		frmPostSalaryInvToAP.txtInvDt.value=curdate;
		}	
		else{
		frmPostSalaryInvToAP.txtInvDt.value=varday+"-"+month1+"-"+yyyy;
		}
}
  
function getMonth(mm) {
	
	var month;
        if (mm == 'Jan'){       
        month=1;
        }
         if (mm=='Feb') {		
        month=2;			
        }
         if (mm=='Mar') {
        month=3;
        }
         if (mm=='Apr') {
        month=4;
        }
         if (mm=='May') {
        month=5;
        }
         if (mm=='Jun') {
        month=6;
        }
         if (mm=='Jul') {
        month=7;
        }         
         if (mm=='Oct') {
        month=10;
        }
         if (mm=='Nov') {
        month=11;
        }
         if (mm=='Dec') {
        month=12;
        }
        if (mm=='Aug') {
        month=8;
        }
         if (mm=='Sep') {
        month=9;
        }   
		if (mm == '11'){   
			
        month='Nov';		
        }
		if (mm == '12'){       
        month='Dec';
        }
		if (mm == '10'){       
        month='Oct';
        }
		if (mm == '09'){       
        month='Sep';
        }
		if (mm == '08'){       
        month='Aug';
        }
		if (mm == '07'){       
        month='Jul';
        }
		if (mm == '06'){       
        month='Jun';
        }
		if (mm == '05'){       
        month='May';
        }
		if (mm == '04'){       
        month='Apr';
        }
		if (mm == '03'){       
        month='Mar';
        }
		if (mm == '02'){       
        month='Feb';
        }
		if (mm == '01'){       
        month='Jan';
        } 		
        return month;     
        
 }

 /*function checkMonth(){	
 var yymm=frmPostSalaryInvToAP.payYYMM.value;
 var curDate=frmPostSalaryInvToAP.txtInvDt.value;
 var mnth=curDate.substring(3,6);
 var year1=curDate.substring(7,11);
 var month=getMonth(mnth);

		 if(month < 10){
		 var postyyyymm=year1+"0"+month;
		 }
		 if(month > 9){
		 var postyyyymm=year1+month;
		 }
		
		if(postyyyymm != yymm ){
		 alert("Please change the invoice date!!!");
		 return false; 				
		 }
 }*/
 
function getLastDayOfMonth(month,year) {
var m = [31,28,31,30,31,30,31,31,30,31,30,31];
if (month != 2) return m[month - 1];
if (year%4 != 0) return m[1];
if (year%100 == 0 && year%400 != 0) return m[1];
return m[1] + 1;
} 
  //end added by sonia 
</script>  