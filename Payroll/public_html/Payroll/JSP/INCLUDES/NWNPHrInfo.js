function lfnHrLoad()
{
    mode = document.all.screenMode.value;
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {
        //document.all.txtDsgn.disabled = "true";      
        document.all.headerPrimaryKey.disabled = "true";   
        
        document.getElementById("txtHandi").disabled = true;
       document.getElementById("txtHandi").style.background="#e0e0e0";
       document.getElementById("txtHandi").style.className="locked";
        //document.getElementById("txtHandiType").disabled = true;
        
       
    }
    
    checkPFType();    
    hedMenuHandling(mode);    
}

function checkPFType(){     
    if (document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=='')
    {
        document.getElementById("cpf").style.display='';
        //document.getElementById("gpf").style.display='none';
        //document.getElementById("vcpf").style.display='';
        //document.getElementById("vgpf").style.display='none';
    }
    if (document.all.txtPFType.value=="PFTYPE$GPF")
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';           
        //document.getElementById("vgpf").style.display='';
        //document.getElementById("vcpf").style.display='none';  
         document.getElementById("txtUanNum").style.background="#e0e0e0";
       document.getElementById("txtUanNum").style.className="locked"; 
       document.getElementById("txtUanNum").disabled = "true";
       
    }    
}  

function checkHandicap()
{
    if (document.all.txtHandi.value=="Y")
    {
       document.getElementById("txtHandiEffDate").disabled = "";
       document.getElementById("txtHandiEffDate").style.background="#ffffd3";
       document.getElementById("txtHandiEffDate").className="required"; 
       
       document.getElementById("txtHandiType").disabled = "";
       document.getElementById("txtHandiType").style.background="#ffffd3";
       document.getElementById("txtHandiType").className="required";
    }  
    else 
    {
       //document.getElementById("txtHandiEffDate").disabled = "true";       
       document.all('txtHandi').options[document.all('txtHandi').selectedIndex].value="N";       
       document.getElementById("txtHandiEffDate").value = "";
       document.getElementById("txtHandiEffDate").style.background="#e0e0e0";
       document.getElementById("txtHandiEffDate").style.className="locked";   
       document.getElementById("txtHandiType").value = "";
       document.getElementById("txtHandiType").disabled = true;
       document.getElementById("txtHandiType").style.background="#e0e0e0";
       document.getElementById("txtHandiType").style.className="locked";
    }    
}

function checkGenPrefix(val)
{
    if(val=='M' && document.all.prefix.value!="")
    {
        if(document.all.prefix.value=='MISS' || document.all.prefix.value=='MRS' || document.all.prefix.value=='MS')
        {
            alert("Prefix is Miss, Please Choose Female")
            document.all.txtGender.value="";
            document.all.txtGender.focus();
        }
    }
    if(val=='F' && document.all.prefix.value!="")
    {
        if(document.all.prefix.value=='MR')
        {
            alert("Prefix is Mr, Please Choose Male")
            document.all.txtGender.value="";
            document.all.txtGender.focus();
        }
    }
    comboChange();
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if (frmNWNPInfoForm.txtHandi.value == 'Y')
    {
        if (frmNWNPInfoForm.txtHandiEffDate.value == '')
        {
            alert("Handicapped Effective Date is Mandatory if Handicapped is Yes");
            frmNWNPInfoForm.txtHandiEffDate.focus(); 
            return false;
        }
        
        if (frmNWNPInfoForm.txtHandiType.value == '')
        {
            alert("Handicapped Type is Mandatory if Handicapped is Yes");
            frmNWNPInfoForm.txtHandiType.focus(); 
            return false;
        }
    }
  // commented by manish jindal reference issue 43490
    /* if(cmpDOBSysDate(frmNWNPInfoForm.txtDOB.value)!=true)
      return false;   */  
    if(mandatory_Check("frmNWNPInfoForm"))
    {         
        frmNWNPInfoForm.txtPFType.disabled="";
        frmNWNPInfoForm.parentZone.disabled="";
        frmNWNPInfoForm.detailDataChanged.value = "false";  
        if(frmNWNPInfoForm.screenMode.value == "N")
          frmNWNPInfoForm.headerDataChanged.value = "true";      
        frmNWNPInfoForm.headerFields.value = "true";  
        frmNWNPInfoForm.action = "../../../NWNPHrSaveAction.do";        
        document.all.txtPFType.disabled = "";
        document.all.txtDsgn.disabled = "";   
        document.all.txtCasteCateg.disabled = false;
       document.all.txtReligion.disabled = false;
      document.all.txtHandiType.disabled = false;
       document.all.txtHandi.disabled = false;
      document.all.txtExsrvcman.disabled=false;
       
       document.all.txtUanNum.disabled = false;
        
        frmNWNPInfoForm.submit();
    }
    else
    {
        return false;
    }
}

function comboChange(val)
{
    frmNWNPInfoForm.headerDataChanged.value = "true";
}

function upper(val)
{
   val.value=val.value.toUpperCase();
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

function doGetTab(arg)
{
    mode = document.all.screenMode.value;      
    if(mode == 'N' || mode == 'U')
    {
		 // commented by manish jindal reference issue 43490
        /* if(cmpDOBSysDate(frmNWNPInfoForm.txtDOB.value)!=true)
            return false;  */   
        if(mandatory_Check("frmNWNPInfoForm"))
        {
          document.all.forwardedPage.value=arg;
          document.forms[0].action="../../../NWNPInfoHrTabAction.do";
          document.forms[0].submit(); 
        }
    }
    else
    {
      document.all.forwardedPage.value=arg;
      document.forms[0].action="../../../NWNPInfoHrTabAction.do";
      document.forms[0].submit(); 
    }
}

function lfnChanged(val)
{
    frmNWNPInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmNWNPInfoForm.action="../../../NWNPHrFirstGetHeaderAction.do"
    frmNWNPInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmNWNPInfoForm.userPositionRequested.value = 1*frmNWNPInfoForm.positionRequested.value + 1;
    frmNWNPInfoForm.action="../../../NWNPHrGetNextHeader.do";
    frmNWNPInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmNWNPInfoForm.userPositionRequested.value = 1*frmNWNPInfoForm.positionRequested.value - 1;
    frmNWNPInfoForm.action = "../../../NWNPHrGetNextHeader.do";
    frmNWNPInfoForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmNWNPInfoForm.userPositionRequested.value = 1*frmNWNPInfoForm.newPositionRequested.value;
    frmNWNPInfoForm.action = "../../../NWNPHrGetNextHeader.do";
    frmNWNPInfoForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmNWNPInfoForm.action="../../../NWNPPayNewMode.do"
    frmNWNPInfoForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmNWNPInfoForm.action="../../../NWNPPayQueryMode.do"
    frmNWNPInfoForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmNWNPInfoForm.action="../../../NWNPHrRefresh.do"
    frmNWNPInfoForm.submit();
}


function checkHandicapDate(val)
{
    if (trim(val) == "" || document.all.txtHandi.value=='N')
    {
        return true;
    }
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDOB.value,1,"Date cannot be Less than the Date of Birth!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtHandiEffDate.value="";     
        return false;
    }    
}

function cmpDOBSysDate(cdate)
{
    if (trim(cdate) == "")
    {
        return true;
    }    
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
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate();  	     
    if (dateDiff(sysDate, cdate) > 0 || dateDiff(sysDate, udate) < 0)
    {
        alert("Age cannot be Less than 18 or Greater then 60 Years!");
        document.getElementById("txtDOB").value = ""; 
		document.getElementById("txtRetireDate").value = "";
        return false;
    }    
	
    document.getElementById("txtRetireDate").value = retDate;

	 // Added by dushyant on 18-May-2013 for CR-161
	if (dateDiff(sysDate, epsDate) > 0)
	{
		document.getElementById("txtEpsFlag").value = 'N';
                document.getElementById("txtEpsFlag").disabled="true";
		document.getElementById("txtEpsFlag").style.background="#e0e0e0";
		document.getElementById("txtEpsFlag").style.className="locked";
		if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
				 document.getElementById("txtFpsNo").className="locked";
				 document.getElementById("txtFpsNo").readOnly="true"; 
				 document.getElementById("txtFpsNo").value = "TEMP"; 
				 document.getElementById("txtFpsNo").style.background="#e0e0e0";
				}
	} 
	if (dateDiff(sysDate, epsDate) < 0)
	{
		document.getElementById("txtEpsFlag").value= 'N';
	}
		    // Added by dushyant on 18-May-2013 For CR-161
    return true;
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

function GetMonth(nMonth)
{
	var Months = new Array("Jan","Feb","Mar","Apr","May","Jun",
	                       "Jul","Aug","Sep","Oct","Nov","Dec");
	return Months[nMonth] 	  	 
}
function chkAadharNum(val)
{
 var len =val.length;
 if(len==12)
 {
   
   return true;
   
 }
 else 
 {
  alert("Aadhar number should be 12 digit");
  document.getElementById("txtAadharNum").value ="";
  return false;
 }
 
}

function chkUANum(val)
{

 var len =val.length;
 if(len==12)
 {
   return true;
 }
 else 
 {
  alert("UAN number should be 12 digit");
  document.getElementById("txtUanNum").value ="";
  return false;
  }
 
}