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
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="ComputeFscBase" name="frmComputeFSC" type="FCIPAY.Payroll.WEBTIER.Form.ComputeFSCForm" scope="session">
<bean:define id="ParentForm" name="frmComputeFSC" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>COMPUTE FOREIGN SERVICE CONTRIBUTION</TD>
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
          <TD class=subHeader colspan=6> Compute FSC </TD>
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

 	 <TR height="100">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
          
                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    <tr height = 10><td></td></tr>

    <tr></tr>
                     <TD class=labelText width="45%" ><bean:message key="pay.MaintainAnnualIncome.FinYYMM" /></td>
                     <td><html:text  property="txtFinYear" altKey="pay.MaintainAnnualIncome.FinYYMM" maxlength="10" size="23" styleClass="required" 
                     onchange="                                                  
                       if(!(chk_FinYear(this.value)))
                          {
                          }" />
          </tr>                    
                    <tr height = 20><td></td></tr>     

     <tr height = 10> <td>&nbsp; </td>  </tr>                          
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
               <td  bgcolor=#4682b4><html:button value=' Compute FSC'  onclick="ComputeFsc();" property="butInitTran" styleClass="bottomBarText" /></td>
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
<html:hidden name="frmComputeFSC"  property="forwardedPage" />
<html:hidden name="frmComputeFSC"  property="screenMode" />
<html:hidden name="frmComputeFSC"  property="hdnAction" />
<html:hidden name="frmComputeFSC"  property="screenName" value="ComputeFscScreen" />

<html:hidden property="lovKey" name="frmComputeFSC"  />
<html:hidden property="txtFields" name="frmComputeFSC"  />   
<html:hidden property="txtSearchFields" name="frmComputeFSC"  />
<html:hidden property="txtDisplayFields" name="frmComputeFSC"  />
<html:hidden property="txtIndex" name="frmComputeFSC"  />


</html:form>
</body>
</html:html>


 
<script language="javascript">

  function lfnLoads()
  {
      var sMode = frmComputeFSC.screenMode.value;

/*      if(mode == '')
      {
        frmComputeFSC.screenMode.value='Q';      
        frmComputeFSC.action = "../../../InitPayrollQuery.do";
        frmComputeFSC.submit();
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
    frmComputeFSC.hdnAction.value='';
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
      frmComputeFSC.hdnAction.value='';
  }

  if (frmComputeFSC.hdnAction.value=='S') 
  {
     frmComputeFSC.hdnAction.value='SUB';
     ComputeFsc(); 
  }

      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";       
    
}
  


function doQueryMode()
{
  frmComputeFSC.hdnAction.value='Q'
  frmComputeFSC.action="../../../ComputeFscQuery.do"
  frmComputeFSC.submit();
}
  


  function ComputeFsc()
  {
     if(mandatory_Check("frmComputeFSC"))
    {
      if (frmComputeFSC.hdnAction.value != 'SUB') 
      {
        frmComputeFSC.hdnAction.value = 'S'; 
        frmComputeFSC.action = "../../../ComputeFSC.do";
        frmComputeFSC.submit();
      }
      else
      {
        frmComputeFSC.hdnAction.value='SUB';       
        frmComputeFSC.action = "../../../ComputeFSC.do";
        frmComputeFSC.submit();
      }      
    }
  }

function chk_FinYear(val)
{
    var  yearM = document.getElementById("txtFinYear").value;          
    var Year1;
    var Year2;

    if ( yearM != "") 
    {
    if (num_Check(yearM,1))
     {                                   
        if (yearM.length != 6)
        {
        alert(" Year Month should be a Six digit Number");
        document.getElementById("txtFinYear").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;    
        }

       Year1 =  yearM.substring(2,4);
       Year2 =  yearM.substring(4,6);
       
       var TempYr1 = parseInt(Year1) + 1; 
       var TempYr2 = parseInt(Year2);              

       if (parseInt(TempYr1,10) != parseInt(TempYr2,10))
       {
         alert("  Year Range Should be in the format of a Financial Period Eg. 200607");
            document.getElementById("txtFinYear").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                   
            return false;       
       }

       return true;                                     
    }  

     else
     {
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;     
    return false;
     }
    }
}

  

</script>

