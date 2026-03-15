<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>

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

  <BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />  
  <html:form  action="ReportLinkerAction" name="LabourIncentiveRepForm" type="FCIPAY.Payroll.WEBTIER.Form.LabourIncentiveRepForm" scope="session" >
  <bean:define id="ParentForm" name="LabourIncentiveRepForm" toScope="request" />  
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
  
  <enrgise:errors/>
  <logic:messagesPresent message="true">
  <Table>
    <html:messages id="message" message="true">
      <TR>
        <TD>
          <bean:write name="message"/>
        </TD>
      </TR>
    </html:messages>
  </Table>
  </logic:messagesPresent>
  <html:hidden property="detailDataChanged"  />
  <html:hidden property="headerFields" value="false" />

  <table>
    <TR height=30>
    
     <% String strEmpLbrFlg=(String)session.getAttribute("hdnEmpLbrFlag");
      if (strEmpLbrFlg.equals("L")){
    %>      
      <TD  colSpan=11 class=mainHeader height=10>LABOUR INCENTIVE DETAIL REPORT </td>
    <% }else{%>       
      <TD  colSpan=11 class=mainHeader height=10>ACTUAL WORK DONE REPORT </td>
    <%}%>  
     <!-- <TD  colSpan=12 class=mainHeader height=10>LABOUR INCENTIVE DETAIL REPORT</TD>  -->
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
             
            <%  if (strEmpLbrFlg.equals("L")){
            %>      
              <TD  class=subHeader colspan=6>Labour Incentive Report </td>
            <% }else{%>       
              <TD  class=subHeader colspan=6>Actual Work Done Report </td>
            <%}%>  
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
            </TR>
            <tr height="15" >
              <td colspan="2"></td>
            </tr>                    
          </table>

          <table cellspacing=0 cellpadding=0 border=0>
          <!-- Detail Information Row starts -->          
            <TR height="100">
              <TD colspan=11>          
                <!-- Account Config Detail Table Starts -->
                <TABLE cellspacing="5" cellPadding="0" border=0 >                      
                  <center>
                  <tr height="10">
                    <td width="100%" colspan=2>
                      <TABLE cellspacing="5" cellPadding="0" border=0 >
                        <tr width="100%">
                          <td width="40%" class="radioTextRight" align="right" ><input type="radio" name="radioEmp" id="radioEmp" value="E" CHECKED onclick="EmpWiseClick()" >Employee Wise</td>         
                          <td width="10%">&nbsp;</td>                          
                          <td width="10%" class="radioTextCenter" align="left"><input type="radio" name="radioGang" id="radioGang" value="G" onclick="GangWiseClick()" >Gang Wise</td>            
                          <td width="40%">&nbsp;</td>
                        </tr>                      
                      </table>
                    </td>               
                  </TR>                  
                  
                  <TR height=25 id="EmpInfoRow">         
                    <!-- Detail table Container starts -->                    
                    <TD class=labelText width="40%" ><bean:message key="Payroll.PaySlip.EmpNumber" /></td>
                    <td  align="left" ><html:text  property="txtEmp" maxlength="10" size="16" styleClass="required"  readonly="true" onchange="getLocationsAjax()"/>
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                  </TR>  
                  
                  <TR height=25 id="EmpInfoRow">         
                    <TD class=labelText width="40%" ><bean:message key="Payroll.PaySlip.Location" /></td>
                    <td  align="left" >
						<html:select property="location" name="LabourIncentiveRepForm">
						</html:select>
                    </td>                           
                  </TR>  

				  <TR height=25 id="GangInfoRow" >         
                    <td class="labelText">Gang Name</td>
                    <td>
                    <html:text  property="txtGangName" maxlength="10" size="26" styleClass="optional" readonly="true" />                    
                    <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
                    <html:hidden property="hdnGangId" />
                    <html:hidden property="hdnMou" />
                    </td>                         
                                      
                  </tr>    
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.PaySlip.Year" /></td><td >
                    <html:text  property="txtYYMM"  maxlength="6" size="16" styleClass="required"  
                   
                    
                    onblur="                                                  
                    if(!(chk_YearMonth()))
                    {
                    }                                            
                    " 
                    />
                    </td>              
                  </tr>                  
                  
                  </center>
                </table>
              </td>
            </tr>
            <!-- Tab table Row 3 starts -->          
            <TR>
              <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
            </TR>
            <tr height="15" >
              <td colspan="16"></td>
            </tr>            
            <TR>
              <td bgcolor=#4682b4></td>
              <td bgcolor=#4682b4 align="center"><html:button value='GENERATE REPORT'  onclick="doGetReport('1')" property="butInsert" styleClass="bottomBarText" />
              <html:button value='DAY WISE INCENTIVE REPORT'  onclick="doGetReport('2')"  property="butGenerate" styleClass="bottomBarText" /></td>
              <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
            </TR>  
           
          </table>
        </td>
      </tr>
    </TABLE>
    <!-- Tab Table Ends -->

 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
    

   
<script language="javascript">
	function doGetReport(val)
	{

	
		if(mandatory_Check('LabourIncentiveRepForm'))
		{
			var repName="";
			if( document.getElementById("radioGang").checked==false)
			{
				if(LabourIncentiveRepForm.hdnEmpLbrFlag.value=='L')
				{
					repName="wages.rdf";
                   if(document.getElementById("location").value=='')
                {  
                    var winurl=""+repName+"&P_YYMM="+LabourIncentiveRepForm.txtYYMM.value+"&P_EMP_NUM="+LabourIncentiveRepForm.txtEmp.value+"&P_GANG_ID="+LabourIncentiveRepForm.hdnGangId.value+"&P_LBR_TYPE="+LabourIncentiveRepForm.txtLbrType.value+"&P_SITE_ID="+LabourIncentiveRepForm.loginLocCode.value ; 
                }
               else
                {
                   var winurl=""+repName+"&P_YYMM="+LabourIncentiveRepForm.txtYYMM.value+"&P_EMP_NUM="+LabourIncentiveRepForm.txtEmp.value+"&P_GANG_ID="+LabourIncentiveRepForm.hdnGangId.value+"&P_LBR_TYPE="+LabourIncentiveRepForm.txtLbrType.value+"&P_SITE_ID="+document.getElementById("location").value;
                }
                    document.getElementById('butInsert').value="Please wait. File is being downloaded..";
					document.getElementById('butInsert').disabled="true";
					document.getElementById('submitParam').value = winurl;
					document.LabourIncentiveRepForm.submit();
				}
				else if (LabourIncentiveRepForm.hdnEmpLbrFlag.value=='D')
				{
					repName="dps_wages.rdf";
					var winurl=""+repName+"&P_YYMM="+LabourIncentiveRepForm.txtYYMM.value+"&P_EMP_NUM="+LabourIncentiveRepForm.txtEmp.value+"&P_GANG_ID="+LabourIncentiveRepForm.hdnGangId.value+"&P_LBR_TYPE="+LabourIncentiveRepForm.txtLbrType.value+"&P_SITE_ID="+document.getElementById("location").value;
					document.getElementById('butInsert').value="Please wait. File is being downloaded..";
					document.getElementById('butInsert').disabled="true";
					document.getElementById('submitParam').value = winurl;
					document.LabourIncentiveRepForm.submit();
            	}
			}
			else
			{
				if(val=="1")
				{
                                      if (LabourIncentiveRepForm.hdnEmpLbrFlag.value=='D')
                                      {
                                        repName="gang_dps.rdf";
                                      }
                                      else  
                                      {
					repName="gang.rdf";
                                      }
					var winurl=""+repName+"&P_YYMM="+LabourIncentiveRepForm.txtYYMM.value+"&P_EMP_NUM="+LabourIncentiveRepForm.txtEmp.value+"&P_GANG_ID="+LabourIncentiveRepForm.hdnGangId.value+"&P_LBR_TYPE="+LabourIncentiveRepForm.txtLbrType.value+"&P_SITE_ID="+LabourIncentiveRepForm.loginLocCode.value;
					document.getElementById('butInsert').value="Please wait. File is being downloaded..";
					document.getElementById('butInsert').disabled="true";
					document.getElementById('submitParam').value = winurl;
					document.LabourIncentiveRepForm.submit();
				}
				
				if (val=="2")
				{
                                      if (LabourIncentiveRepForm.hdnEmpLbrFlag.value=='D')
                                      {
                                        repName="labincentive_dps.rdf";
                                      }
                                      else
                                      {
					repName="labincentive.rdf";
                                      }
					var winurl=""+repName+"&P_YYMM="+LabourIncentiveRepForm.txtYYMM.value+"&P_GANG_ID="+LabourIncentiveRepForm.hdnGangId.value+"&P_LBR_TYPE="+LabourIncentiveRepForm.txtLbrType.value+"&P_SITE_ID="+LabourIncentiveRepForm.loginLocCode.value;
					document.getElementById('butGenerate').value="Please wait. File is being downloaded..";
					document.getElementById('butGenerate').disabled="true";
					document.getElementById('submitParam').value = winurl;
					document.LabourIncentiveRepForm.submit();
				}
			}
		}
		else
		{
			return false;
		}
}


</script>
	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="LabourIncentiveRepForm"  property="screenMode"/>
    <html:hidden name="LabourIncentiveRepForm"  property="screenName" value="LabourIncentiveReport" />
    <html:hidden property="buttonFlag" name="LabourIncentiveRepForm"  />  
    <html:hidden property="txtInputField" name="LabourIncentiveRepForm" />
    <html:hidden property="lovKey" name="LabourIncentiveRepForm"  />
    <html:hidden property="txtFields" name="LabourIncentiveRepForm"  />   
    <html:hidden property="txtSearchFields" name="LabourIncentiveRepForm"  />
    <html:hidden property="txtDisplayFields" name="LabourIncentiveRepForm"  />
    <html:hidden property="txtIndex" name="LabourIncentiveRepForm"  />
    <html:hidden property="txtLbrType" name="LabourIncentiveRepForm"  />
    <html:hidden property="txtCpfCode" name="LabourIncentiveRepForm"  />             <!-- added by dushyant 0n 17-02-2011 -->
    <html:hidden property="loginLocCode" name="LabourIncentiveRepForm"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />    
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{
  mode=document.all.screenMode.value;
  disableMenu();
  if(document.getElementById("radioEmp").checked)
  {
    document.getElementById("EmpInfoRow").style.display="";
    document.getElementById("GangInfoRow").style.display="none";
  document.getElementById("butGenerate").disabled="true";
    document.getElementById("butInsert").disabled="";
    
  }else
  {
    document.getElementById("EmpInfoRow").style.display="none";
    document.getElementById("GangInfoRow").style.display="";
      document.getElementById("butGenerate").disabled="";
    document.getElementById("butInsert").disabled="";
  }
   if(LabourIncentiveRepForm.hdnEmpLbrFlag.value=='D')
    LabourIncentiveRepForm.txtLbrType.value='DPS';
  else
    LabourIncentiveRepForm.txtLbrType.value='DEP';
  if(mode != 'Q' )
  {
	  
    LabourIncentiveRepForm.action="../../../LabourIncentiveGetAccess.do"
    LabourIncentiveRepForm.submit();  
  }
}

function ShowLovYYMM()
{
        LabourIncentiveRepForm.queryParam.value="hdnMaxYYMM="+ LabourIncentiveRepForm.hdnMaxYYMM.value +" " ;    
        LabourIncentiveRepForm.lovKey.value = "ReportGeneratePaySlipYear" + LabourIncentiveRepForm.screenName.value + "U";
        LabourIncentiveRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        LabourIncentiveRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LabourIncentiveRepForm');

        
        return true;
}

function ShowLovEmpNo()
{
        LabourIncentiveRepForm.lovKey.value = "LabourIncentiveEmp" + LabourIncentiveRepForm.screenName.value + "U";
        LabourIncentiveRepForm.queryParam.value="txtSiteID="+ LabourIncentiveRepForm.loginLocCode.value +",hdnEmpLbrFlag="+LabourIncentiveRepForm.hdnEmpLbrFlag.value ; 
        LabourIncentiveRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
        LabourIncentiveRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
		LabourIncentiveRepForm.txtInputField.value="txtEmp";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LabourIncentiveRepForm');
        return true;
}

function ShowLovGang()
{
       LabourIncentiveRepForm.lovKey.value = "LbrIncGangList" + LabourIncentiveRepForm.screenName.value + "Q";
       LabourIncentiveRepForm.queryParam.value="txtSiteID="+ LabourIncentiveRepForm.loginLocCode.value +",hdnEmpLbrFlag="+LabourIncentiveRepForm.txtLbrType.value ;           
       LabourIncentiveRepForm.txtDisplayFields.value = "hdnGangId,txtGangName,hdnMou";
       LabourIncentiveRepForm.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
       LabourIncentiveRepForm.txtIndex.value="";              
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'LabourIncentiveRepForm');
       return true;
}


function chk_YearMonth()
{      
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);    
   if(yearM!="")
   {
		if (num_Check(yearM,1))
		{                                     
			if (yearM.length != 6)
			{        
				alert(" Year Month should be a Six digit Number");
				document.getElementById("txtYYMM").focus();                     
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;                        
				return false;            
			}        
			else if(month < 1 || month > 12)
			{
				alert("  Month should be Within 1 to 12");
				document.getElementById("txtYYMM").focus();                     
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;                        
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
}

function GangWiseClick() 
{
	document.getElementById("txtEmp").className="optional";
    document.getElementById("radioGang").checked=true;
    document.getElementById("radioEmp").checked=false;
    document.getElementById("EmpInfoRow").style.display="none";
    document.getElementById("GangInfoRow").style.display="";
    document.getElementById("butGenerate").disabled="";
    document.getElementById("butInsert").disabled="";
	var locobj = document.getElementById("location");
	removeChild(locobj);
}

function EmpWiseClick() 
{
	document.getElementById("txtEmp").className="required";
    document.getElementById("radioGang").checked=false;
    document.getElementById("radioEmp").checked=true;
    document.getElementById("EmpInfoRow").style.display="";
    document.getElementById("GangInfoRow").style.display="none";
    document.getElementById("butGenerate").disabled="true";
    document.getElementById("butInsert").disabled="";
	var locobj = document.getElementById("location");
	removeChild(locobj);
}

function getLocationsAjax()
{

	url="../../../getLocationsAjax.do";
    prm="mode=1&p_emp_num="+document.getElementById("txtEmp").value;
	xml=getXML(url,prm);
	Tags=xml.getElementsByTagName("record");
	var if_valid="";
	var locobj = document.getElementById("location");
	if(Tags.length>0)
	{
		for(i=0; i<Tags.length; i++)
		{
			var voption = document.createElement("OPTION");
			locid=Tags[i].childNodes[0].childNodes[0].nodeValue;
			locdesc=Tags[i].childNodes[1].childNodes[0].nodeValue;
			voption.index=i+1;
			voption.value=locid;
			voption.text=locdesc;
			locobj.add(voption,i);
		}
	}
}
function removeChild(list)
{
	document.getElementById("txtEmp").value="";
	document.getElementById("txtEmpName").value="";
	var optlen=list.options.length;
	for(i=0;i<optlen;i++)
	{
		list.remove(0);
	}
}


</script>
