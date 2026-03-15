<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
	<HEAD>
    <html:base/>
	<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />  
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>           
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintOverAbvArrear" name="frmOverAbvArrearForm" type="FCIPAY.Payroll.WEBTIER.Form.OverAbvArrearForm">
  <bean:define id="ParentForm" name="frmOverAbvArrearForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>OVER & ABOVE ARREAR PAYMENTS</TD>
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
          <TD class=subHeader colspan=6>Over & Above Arrear Payments</TD>
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
 	 <TR height="50">
       <TD colspan=11>
          <!-- Account Config Detail Table Starts -->
         <TABLE cellspacing="0" cellPadding="0" >          
            <TR height=10>                
              <!-- Detail table Container starts -->
              <TD colspan="16">
               <TABLE cellSpacing="0" cellPadding="0" border="0" >

                <tr>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" >
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>  
                  
                  <td class=labelText  >Pay Code </td>
                  <td>                             
                  <html:select  property="txtPayCode" altKey="Payroll.EmpInfo.StaffCode"styleClass="required" > 
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="OverAbvArrearCombo">
                  <html:optionsCollection label="label" value="value" property="payCodeList" name="OverAbvArrearCombo"/>
                  </logic:present>
                  </html:select>
                  </td>
               </TR> 
			    <tr>
                  <TD class=labelText>Start Year Month  </TD>
                  <td align="left" >
                  <html:text  property="txtStartYr" altKey='Start Year Month' maxlength="6" size="23"  styleClass="optional" 
                  onblur="                                                  
                       if(!(chk_StartYearMonth()))
                          {
                          }                                            
              " 
              />
                  </td>  
                  
                  <td class=labelText  >Upto Year Month </td>
                  <td>                             
                   <html:text  property="txtEndYr" altKey='Upto Year Month' maxlength="6" size="23"  styleClass="optional" 
                   onblur="                                                  
                       if(!(chk_EndYearMonth()))
                          {
                          }                                            
              " 
              />
                  </td>
               </TR> 
               <TR>
                  <TD class=labelText>Arrear Amount</TD>
                  <td align="left" >
                  <html:text  property="txtArrAmt" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </td>  
                  
                  <td class=labelText  >Invoice Id</td>
                  <td>                             
                  <html:text  property="txtInvID" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
               </tr>
               <TR>
                  <TD class=labelText>IT Deductions</TD>
                  <td align="left" >
                  <html:text  property="txtDedIT" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" style="text-align:right" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " styleClass="optional" />
                  </td>  
                  
                  <td class=labelText  >CPF Deduction</td>
                  <td>                             
                  <html:text  property="txtDedCPF" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                </tr>
              <TR height="50"><td>&nbsp;</td></tr> 
                           
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
           <td  bgcolor=#4682b4><html:button value='Send Invoice'  onclick="sendInv()" property="butSendInv" styleClass="bottomBarText" /></td>
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
<html:hidden name="frmOverAbvArrearForm"  property="screenName" value="OverAbvArrearScreen" />
<html:hidden property="loginLocCode" name="frmOverAbvArrearForm"  />
<html:hidden property="headerPrimaryKey" name="frmOverAbvArrearForm"  />
<html:hidden name="frmOverAbvArrearForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmOverAbvArrearForm" />
<html:hidden property="positionRequested" name="frmOverAbvArrearForm" />
<html:hidden property="userPositionRequested" name="frmOverAbvArrearForm" />
<html:hidden property="buttonFlag" name="frmOverAbvArrearForm"  />
<html:hidden property="lovKey" name="frmOverAbvArrearForm"  />
<html:hidden property="txtFields" name="frmOverAbvArrearForm"  />   
<html:hidden property="txtSearchFields" name="frmOverAbvArrearForm"  />
<html:hidden property="txtDisplayFields" name="frmOverAbvArrearForm"  />
<html:hidden property="txtIndex" name="frmOverAbvArrearForm"  />
<html:hidden property="hdnPayYYMM" name="frmOverAbvArrearForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">

function ShowEmpNum()
{
   frmOverAbvArrearForm.lovKey.value = "OverAbvArrearEmp" + frmOverAbvArrearForm.screenName.value + "Q";
   frmOverAbvArrearForm.queryParam.value="txtSiteID="+ frmOverAbvArrearForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmOverAbvArrearForm.hdnEmpLbrFlag.value ;
   frmOverAbvArrearForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
   frmOverAbvArrearForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
   frmOverAbvArrearForm.txtIndex.value ="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmOverAbvArrearForm');
   return true;
}    

function lfnLoad()
{   
    mode = document.all.screenMode.value;
    if(mode == '')
    {
        doQueryMode();
    }
    hedMenuHandling(mode);
    document.all.butSave.disabled="true";    
    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    document.all.butInsertMode.disabled="true";    
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    

    if(document.all.txtInvID.value=='')
    {
      document.all.butSendInv.disabled="";
    }else
    {
      document.all.butSendInv.disabled="true";
    }
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmOverAbvArrearForm.action="../../../OverAbvArrearGetHeaderAction.do"
    frmOverAbvArrearForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmOverAbvArrearForm.userPositionRequested.value = 1*frmOverAbvArrearForm.positionRequested.value + 1;
    frmOverAbvArrearForm.action="../../../OverAbvArrearGetNextHeader.do";
    frmOverAbvArrearForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmOverAbvArrearForm.userPositionRequested.value = 1*frmOverAbvArrearForm.positionRequested.value - 1;
    frmOverAbvArrearForm.action = "../../../OverAbvArrearGetNextHeader.do";
    frmOverAbvArrearForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmOverAbvArrearForm.userPositionRequested.value = 1*frmOverAbvArrearForm.newPositionRequested.value;
    frmOverAbvArrearForm.action = "../../../OverAbvArrearGetNextHeader.do";
    frmOverAbvArrearForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmOverAbvArrearForm.action="../../../OverAbvArrearQueryMode.do"
    frmOverAbvArrearForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmOverAbvArrearForm.action="../../../OverAbvArrearRefresh.do"
    frmOverAbvArrearForm.submit();
}

function sendInv()
{
    if(!mandatory_Check("frmOverAbvArrearForm"))
    {
      return false;
    }
    
    var res = validStartUptoYYMM();
    if(res==false)
    {
     return false;
    }
	  document.getElementById("butSendInv").disabled="true";
    frmOverAbvArrearForm.action="../../../OverAbvArrearSendInv.do"
    frmOverAbvArrearForm.submit();
}

function chk_StartYearMonth()                                                   
{
       var  startYYMM = document.getElementById("txtStartYr").value;          
       var  startYear =  parseInt(startYYMM.substring(0,4),10);
       var  startMnth =  parseInt(startYYMM.substring(4,6),10);    
       var  currDate= new Date();
       var  currYear= currDate.getFullYear();
       var  currMnth= currDate.getMonth()+1;
       
    if(startYYMM!="")
    {     
    if (num_Check(startYYMM,1))
     {                                   
           
        if (startYYMM.length != 6)
        {
        alert("Financial Year should be a Six digit Number");                  
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;            
        return false;
        }        
                                                                                
        if(startYear > currYear)
        {
          alert("Start Year Month must be less than Current Year Month.");                    
          event.srcElement.select();
          event.srcElement.focus();
          event.returnValue=false;            
          return false;
        } 
        
        if(startYear == currYear)
        {
          if(startMnth > currMnth)
          {
          alert("Start Year Month must be less than Current Year Month.");                    
          event.srcElement.select();
          event.srcElement.focus();
          event.returnValue=false;            
          return false;
          }
        } 
        
        if(startMnth < 1 || startMnth > 12)
        {
          alert("Enter a valid month in Start Year Month field.");                    
          event.srcElement.select();
          event.srcElement.focus();
          event.returnValue=false;            
          return false;
        }
        
        return true;
     }
     else
     {
       document.getElementById("txtStartYr").select();   
       return false;
     }
    }
}

function chk_EndYearMonth()                                                        
{
     var  uptoYYMM = document.getElementById("txtEndYr").value;          
     var  uptoYear =  parseInt(uptoYYMM.substring(0,4),10);
     var  uptoMnth =  parseInt(uptoYYMM.substring(4,6),10);    
     var  currDate= new Date();
     var  currYear= currDate.getFullYear();
     var  currMnth= currDate.getMonth()+1;
     var  startYYMM = document.getElementById("txtStartYr").value;          
     var  startYear =  parseInt(startYYMM.substring(0,4),10);
     var  startMnth =  parseInt(startYYMM.substring(4,6),10); 
       
    if(uptoYYMM!="")
    {     
    if (num_Check(uptoYYMM,1))
     {                                   
           
        if (uptoYYMM.length != 6)
        {
        alert("Financial Year should be a Six digit Number");                  
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;            
        return false;
        }        
                                                                                
        if(uptoYear > currYear)
        {
          alert("Upto Year Month must be less than Current Year Month.");                    
          event.srcElement.select();
          event.srcElement.focus();
          event.returnValue=false;            
          return false;
        } 
        
        if(uptoYear == currYear)
        {
          if(uptoMnth > currMnth)
          {
          alert("Upto Year Month must be less than Current Year Month.");                    
          event.srcElement.select();
          event.srcElement.focus();
          event.returnValue=false;            
          return false;
          }
        } 
        
        if(uptoMnth < 1 || uptoMnth > 12)
        {
          alert("Enter a valid month in Upto Year Month field.");                    
          event.srcElement.select();
          event.srcElement.focus();
          event.returnValue=false;            
          return false;
        }
        
      var res = validStartUptoYYMM();
       if(res==false)
       {
        return false;
       }
      
      return true;
     }
     else
     {
       document.getElementById("txtEndYr").select();   
       return false;
     }
    }
}

function validStartUptoYYMM()
{
  var  uptoYYMM = document.getElementById("txtEndYr").value;          
  var  uptoYear =  parseInt(uptoYYMM.substring(0,4),10);
  var  uptoMnth =  parseInt(uptoYYMM.substring(4,6),10);
  var  startYYMM = document.getElementById("txtStartYr").value;          
  var  startYear =  parseInt(startYYMM.substring(0,4),10);
  var  startMnth =  parseInt(startYYMM.substring(4,6),10); 
   if(startYear > uptoYear)
   {
     alert("Start Year Month must be less than Upto Year Month.");
     return false;         
   }
        
   if(startYear == uptoYear)
   {
     if(startMnth > uptoMnth)
     {
       alert("Start Year Month must be less than Upto Year Month.");
       return false; 
     }
    }
    return true;
}
</script>