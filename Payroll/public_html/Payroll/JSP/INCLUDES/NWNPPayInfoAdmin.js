function EmpFinLoad()
{
    mode = document.all.screenMode.value; 
		// added by Dushaynt on 17 may 2013 start
		document.all.butInsertMode.disabled="true";    
		document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";   
		// added by Dushaynt on 17 may 2013 end
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='U')
    {         
       // document.all.headerPrimaryKey.disabled = "true";         
    }
    if(mode=='Q')
    {         
        document.all.prefix.disabled = "true";
        document.all.txtEmpMiddleName.disabled = "true";
        document.getElementById("prefix").style.background="#ffffff";
        document.getElementById("prefix").style.className="locked";
        document.all.txtPFType.disabled = "true";
        document.getElementById("txtPFType").style.background="#ffffff";
        document.getElementById("txtPFType").style.className="locked";        
        document.getElementById("txtFpsNo").disabled = "true";        
    }
    checkPFType();         
    //checkEpsFlag(); 
	checkEpsFlagOnLoad();
    hedMenuHandling(mode);    
   /*if(document.all.txtEpsFlag.value=='Y')    //added by swapnendu Dt 06 Dec 2012.
		document.getElementById("txtEpsFlag").disabled = "true";
	else
		document.getElementById("txtEpsFlag").disabled = "";*/

}

function updateFPSno(val)
{
	var len=val.length;
	if(len > 0)
	{
		if(isNaN(val))
		{
			if(confirm("do you want to modify FPS/EPS Number?"))
			{
				document.getElementById("txtFpsNo").value = val.substring(2);
			}
		}
	}
}

function checkPFType(){     
    if (document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=='')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';        
    }
    if (document.all.txtPFType.value=="PFTYPE$GPF")
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';                   
    }    
}  

function lfnChange(val)
{
    if(num_Check(val,1))
        frmNWNPInfoForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmNWNPInfoForm.headerDataChanged.value = "true";
}

function lfnChangeNegNum(val)
{
    if(NegNum_Check(val,1))
    { 
        frmNWNPInfoForm.headerDataChanged.value = "true";
        return true;
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function comboChange(val)
{
    frmNWNPInfoForm.headerDataChanged.value = "true";
}

function doOnChangeCalendar(buttonName)
{
    frmNWNPInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{    
    document.all.buttonFlag.value='';    
    frmNWNPInfoForm.action="../../../NWNPPayAdminGetHeaderAction.do"
    frmNWNPInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmNWNPInfoForm.userPositionRequested.value = 1*frmNWNPInfoForm.positionRequested.value + 1;
    frmNWNPInfoForm.action="../../../NWNPPayAdminGetNextHeader.do";
    frmNWNPInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmNWNPInfoForm.userPositionRequested.value = 1*frmNWNPInfoForm.positionRequested.value - 1;
    frmNWNPInfoForm.action = "../../../NWNPPayAdminGetPrevHeader.do";
    frmNWNPInfoForm.submit();
}

function JumpHeader()
{   
    document.all.buttonFlag.value='';
    frmNWNPInfoForm.userPositionRequested.value = 1*frmNWNPInfoForm.newPositionRequested.value;    
    frmNWNPInfoForm.action = "../../../NWNPPayAdminGetNextHeader.do";
    frmNWNPInfoForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmNWNPInfoForm.action="../../../NWNPPayAdminNewMode.do"
    frmNWNPInfoForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmNWNPInfoForm.action="../../../NWNPPayAdminQueryMode.do"
    frmNWNPInfoForm.submit();
}
function doRefresh()
{   
    document.all.buttonFlag.value=''; 
    frmNWNPInfoForm.action="../../../NWNPPayAdminRefresh.do"
    frmNWNPInfoForm.submit();
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
              
    if(mandatory_Check("frmNWNPInfoForm"))
    { 
      //  frmNWNPInfoForm.txtEmpNo.value=frmNWNPInfoForm.headerPrimaryKey.value;
        frmNWNPInfoForm.txtPFType.disabled="";
        frmNWNPInfoForm.parentZone.disabled="";
        frmNWNPInfoForm.detailDataChanged.value = "false";  
        if(frmNWNPInfoForm.screenMode.value == "N")
            frmNWNPInfoForm.headerDataChanged.value = "true";    
        frmNWNPInfoForm.headerFields.value = "true";        
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmNWNPInfoForm.action = "../../../NWNPPayAdminSaveAction.do";              
        frmNWNPInfoForm.submit();
    }
    
    else
    {
        return false;
    }
}

function SavePayrollTabData()
{
    document.all.buttonFlag.value='';
    
    if(mandatory_Check("frmNWNPInfoForm"))
    {     
        frmNWNPInfoForm.txtEmpNo.value=frmNWNPInfoForm.headerPrimaryKey.value; 
        frmNWNPInfoForm.detailDataChanged.value = "false";  
        if(frmNWNPInfoForm.screenMode.value == "N")
            frmNWNPInfoForm.headerDataChanged.value = "false";    
        frmNWNPInfoForm.headerFields.value = "true";        
        return true;
    }
    
    else
    {
        return false;
    }
}

function showCalendar(inputId, butId) 
{  
    if(butId.alt)
    {
        iIndex=butId.alt;
    }
    else
    {
        iIndex="-1";
    }
    Calendar.setup({inputField	: inputId,
    ifFormat	: "%d-%b-%Y",
    button	: butId,
    position: iIndex
    });        
    return false;
}

function doGetTab(arg)
{  
    //if(SavePayrollTabData())
    //{
        document.all.forwardedPage.value=arg;
        document.forms[0].action="../../../NWNPInfoPayAdminTabAction.do";
        document.forms[0].submit(); 
   // }
}


function doGetTabs(arg)
{
    if(mode == 'N' || mode == 'U')
    { 
        if(mandatory_Check("frmNWNPInfoForm"))
        {
          document.all.forwardedPage.value=arg;
          document.forms[0].action="../../../NWNPInfoPayAdminTabAction.do";
          document.forms[0].submit(); 
        }
    }
    else
    {
      document.all.forwardedPage.value=arg;
      document.forms[0].action="../../../NWNPInfoPayAdminTabAction.do";
      document.forms[0].submit(); 
    }
}

function checkDojFci(cdate)
{
    if (trim(cdate) == "")
    {
        return true;
    }    
    firstIndex=cdate.indexOf("-");
    lastIndex=cdate.lastIndexOf("-");
    var dojSite=cdate;
    if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
    {
        var arr=cdate.split("-");
        var cyear= arr[2];
        var lyear=1990;                
        var monIndx=getMonthIndx(arr[1]);
        var lmonthIndx=parseInt(01);
        var ldayIndx=parseInt(01);
        if(monIndx!=-1)
        {
            cdate = arr[0] + "/" + monIndx + "/" + cyear;  		
            udate = ldayIndx + "/" + lmonthIndx + "/" + lyear;  		
        }    
    }
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate(); 
    if (dateDiff(udate, cdate) < 0 || dateDiff(sysDate, cdate) >0)
    {
        alert("Date Of Joining FCI Cannot be Less then 1990! or Greater then Current Date");
        frmNWNPInfoForm.txtDojFCI.select();
        frmNWNPInfoForm.txtDojFCI.focus();
        frmNWNPInfoForm.txtDojFCI.value="";
        return false;
    }
    document.all.txtDOJSite.value=dojSite;
    return true;
}

function checkPostDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtDOJSite.value="";     
        return false;
    }    
}

function checkPayStatDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtPayStsChnDate.value="";     
        return false;
    }    
}

function disable()
{
    frmNWNPInfoForm.headerDataChanged.value = "true";
    if (document.all.selectSocRec.checked==true)
    {
        document.all.hdnSocRecFlag.value="Y";
        if(document.all.hdnSocRecFlag.value=="Y")
        {
        document.getElementById("txtSocRecAmt").disabled = "";
        document.getElementById("txtSocRecAmt").style.background="#ffffd3";
        document.getElementById("txtSocRecAmt").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtSocRecAmt").value = "";
        document.getElementById("txtSocRecAmt").disabled = "true";
        document.getElementById("txtSocRecAmt").style.background="#e0e0e0";
        document.getElementById("txtSocRecAmt").style.className="locked";       
    }
}

function checkEpsFlag()
{
  var mode = document.all.screenMode.value;  
  if(document.all.txtEpsFlag.value=='Y')
  {
	if (mode=='U')  //added by swapnendu Dt 06 Dec 2012
	{
		    document.getElementById("butEpsEntDt").disabled="";
			document.getElementById("txtFpsNo").readOnly="";
			document.getElementById("txtEpsEntDt").style.background="#ffffd3";
			document.getElementById("txtEpsEntDt").className="required";
			document.getElementById("txtFpsNo").style.background="#ffffd3";
			document.getElementById("txtFpsNo").className="required";

			if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
				 document.getElementById("txtFpsNo").className="locked";
				 document.getElementById("txtFpsNo").readOnly="true"; 
				 document.getElementById("txtFpsNo").value = "TEMP";
				 document.getElementById("txtFpsNo").style.background="#e0e0e0";
				}
	}
	if (mode=='N')
	{
		document.getElementById("butEpsEntDt").disabled="";
		document.getElementById("txtEpsEntDt").style.background="#ffffd3";
		document.getElementById("txtEpsEntDt").className="required";
		document.getElementById("txtFpsNo").style.background="#ffffd3";
		document.getElementById("txtFpsNo").className="required";
		document.getElementById("txtFpsNo").disabled="";
		document.getElementById("txtFpsNo").readOnly="";

            if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
			{
			 document.getElementById("txtFpsNo").className="locked";
			 document.getElementById("txtFpsNo").readOnly="true"; 
			 document.getElementById("txtFpsNo").value = "TEMP"; 
			 document.getElementById("txtFpsNo").style.background="#e0e0e0";
		    }


	}
		document.getElementById("txtEpsSepRsn").disabled="";
		document.getElementById("txtEpsSepRsn").style.background="#ffffff";
		document.getElementById("txtEpsSepRsn").style.className="optional";
		
		document.getElementById("butEpsSepDt").disabled="";
		document.getElementById("txtEpsSepDt").style.background="#ffffff";
		document.getElementById("txtEpsSepDt").style.className="optional";
  }
  else
  {
    document.getElementById("butEpsEntDt").disabled="true";
    //document.getElementById("txtEpsEntDt").value = "";
    document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
	document.getElementById("txtEpsEntDt").readOnly = "true";
    document.getElementById("txtEpsEntDt").className="locked";
    document.getElementById("txtFpsNo").style.background="#e0e0e0";
	document.getElementById("txtFpsNo").readOnly = "true";
    document.getElementById("txtFpsNo").className="locked";

    document.getElementById("txtEpsSepRsn").disabled="true";
    document.getElementById("txtEpsSepRsn").value = "";
    document.getElementById("txtEpsSepRsn").style.background="#e0e0e0";
    document.getElementById("txtEpsSepRsn").style.className="locked";
    
    document.getElementById("butEpsSepDt").disabled="true";
    document.getElementById("txtEpsSepDt").value = "";
    document.getElementById("txtEpsSepDt").style.background="#e0e0e0";
    document.getElementById("txtEpsSepDt").style.className="locked";

	  if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
			{
			 document.getElementById("txtFpsNo").value = "";   // Added by dushyant on 16-May-2013
		    }
  }
}

function checkEpsFlagOnLoad()  //added by swapnendu Dt 06 Dec 2012
{
	var mode = document.all.screenMode.value;
	var cdate = document.getElementById("txtDOB").value;
    if (trim(cdate) != "")
    {
		firstIndex=cdate.indexOf("-");
		lastIndex=cdate.lastIndexOf("-");
		
		if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
		{
			var arr=cdate.split("-");
			var cyear= arr[2];
			var uyear=arr[2];
			var lyear;        
			lyear=parseInt(cyear)+18;  
			uyear=parseInt(cyear)+60;    
			var uEpsyear =parseInt(cyear)+58;
			var epsDate;
			var monIndx=getMonthIndx(arr[1]);
			if(arr[0]==01 && arr[1]!='Jan')
			{ 
			  var noDays = daysYearMonth(monIndx-1,uyear);          
			  var rmonth = GetMonth(monIndx-2);          
			  var retDate=noDays + "-" + rmonth + "-" + uyear;  
			}
			else if(arr[0]==01 && arr[1]=='Jan')
			{
			  var retDate=31+ "-" + "Dec" + "-" + parseInt(uyear-1);        
			}
			else
			{
			  var noDays = daysYearMonth(monIndx,uyear);          
			  var retDate=noDays + "-" + arr[1] + "-" + uyear;
			}
			if(monIndx!=-1)
			{
				cdate = arr[0] + "/" + monIndx + "/" + lyear;  		
				udate = arr[0] + "/" + monIndx + "/" + uyear;  	
				epsDate = arr[0] + "/" + monIndx + "/" + uEpsyear;
			}    
		}
		var sysDate = getSysDate();

		if (eval(dateDiff(sysDate, epsDate)) > 0)
		{
			document.getElementById("txtEpsFlag").value = 'Y';
		} 
		if (eval(dateDiff(sysDate, epsDate)) < 0)
		{
			document.getElementById("txtEpsFlag").value= 'N';
		}
    }    

	if(document.all.txtEpsFlag.value=='Y')
	{
		if (mode=='U')
		{
			if (document.getElementById("txtEpsEntDt").value=="")
			{
				document.getElementById("butEpsEntDt").disabled="";
				document.getElementById("txtEpsEntDt").style.background="#ffffd3";
				document.getElementById("txtEpsEntDt").className="required";
			}
			else
			{
				document.getElementById("butEpsEntDt").disabled="true";
				document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
				document.getElementById("txtEpsEntDt").readOnly = "true"; 
				document.getElementById("txtEpsEntDt").className="locked";
			}
			if (document.getElementById("txtFpsNo").value=="")
			{
				document.getElementById("txtFpsNo").style.background="#ffffd3";
				document.getElementById("txtFpsNo").className="required";
				document.getElementById("txtFpsNo").disabled="";
				document.getElementById("txtFpsNo").readOnly="";
			}
			else 
			{
				document.getElementById("txtFpsNo").style.background="#e0e0e0";
				document.getElementById("txtFpsNo").readOnly = "true"; 
				document.getElementById("txtFpsNo").className="locked";
				document.getElementById("txtFpsNo").onclick="";
			}
			  if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
				 document.getElementById("txtEpsFlag").disabled="true";
				 document.getElementById("txtEpsFlag").readOnly="true"; 

				}  

		}
		if (mode=='N')
		{
			document.getElementById("butEpsEntDt").disabled="";
			document.getElementById("txtEpsEntDt").style.background="#ffffd3";
			document.getElementById("txtEpsEntDt").className="required";
			document.getElementById("txtFpsNo").style.background="#ffffd3";
			document.getElementById("txtFpsNo").className="required";
			document.getElementById("txtFpsNo").disabled="";
			document.getElementById("txtFpsNo").readOnly="";
		}
		document.getElementById("txtEpsSepRsn").disabled="";
		document.getElementById("txtEpsSepRsn").style.background="#ffffff";
		document.getElementById("txtEpsSepRsn").style.className="optional";

		document.getElementById("butEpsSepDt").disabled="";
		document.getElementById("txtEpsSepDt").style.background="#ffffff";
		document.getElementById("txtEpsSepDt").style.className="optional";
	}
	else
	{
		document.getElementById("butEpsEntDt").disabled="true";
		document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
		document.getElementById("txtEpsEntDt").readOnly = "true";
		document.getElementById("txtEpsEntDt").className="locked";
		document.getElementById("txtFpsNo").style.background="#e0e0e0";
		document.getElementById("txtFpsNo").readOnly = "true";
		document.getElementById("txtFpsNo").className="locked";
		document.getElementById("txtFpsNo").onclick="";

		document.getElementById("txtEpsSepRsn").disabled="true";
		document.getElementById("txtEpsSepRsn").value = "";
		document.getElementById("txtEpsSepRsn").style.background="#e0e0e0";
		document.getElementById("txtEpsSepRsn").style.className="locked";

		document.getElementById("butEpsSepDt").disabled="true";
		document.getElementById("txtEpsSepDt").value = "";
		document.getElementById("txtEpsSepDt").style.background="#e0e0e0";
		document.getElementById("txtEpsSepDt").style.className="locked";
		   if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
				 document.getElementById("txtEpsFlag").disabled="true";
				 document.getElementById("txtEpsFlag").readOnly="true"; 
				}  
	}
}

function daysYearMonth(mnth, years )
{
    var intMonth = mnth; //given month
    var intYear = years; //given year        
    if (1 == intMonth || 3 == intMonth || 5 == intMonth || 7 == intMonth || 8 == intMonth ||
    10 == intMonth || 12 == intMonth)
    {
        return 31;
    }
    else if (2 == intMonth)
    {
        // Check for leap year
        if (0 == (intYear % 4))
        {
            // If date is divisible by 400, it's a leap year.
            // Otherwise, if it's divisible by 100 it's not.
            if (0 == (intYear % 400))
            {     
               return 29;
            }
            else if (0 == (intYear % 100))
            {             
                return 28;
            }    
            // Divisible by 4 but not by 100 or 400
            // so it leaps            
            return 29;
        }
        // Not a leap year        
        return 28;
    }
    return 30;     
}
function panNA()
{
	document.getElementById("butNA").disabled="true";
	document.getElementById("txtPanNo").value = "Not Applicable";
	document.getElementById("txtPanNo").readOnly="true";

}
