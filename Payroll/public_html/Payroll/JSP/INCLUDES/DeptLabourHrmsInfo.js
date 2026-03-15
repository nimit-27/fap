function lfnHrLoad()
{
    mode = document.all.screenMode.value;
	// added by devendra on 21 sept 2010 start
	document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";   
	// added by devendra on 21 sept 2010 end
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {   
   
        document.all.headerPrimaryKey.disabled = "true";     
        document.getElementById("txtHandi").disabled = true;
       document.getElementById("txtHandi").style.background="#e0e0e0";
       document.getElementById("txtHandi").style.className="locked";
                document.getElementById("txtHandiType").disabled = true;

        
       
    }
    checkHandicap();    
   // checkHraStatus();        
    hedMenuHandling(mode);    
}

function checkDepuType()
{
    if (document.all.txtEmpStatus.value=="EMPSTATUS$DEPU")
    {
       document.getElementById("txtDepuType").disabled = "";
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {
       document.getElementById("txtDepuType").disabled = "true";
       document.getElementById("txtDepuType").value = "";
       document.getElementById("txtDepuType").style.background="#ffffff";
       document.getElementById("txtDepuType").style.className="locked";           
    }  
}

function enableDepuType(val)
{
    if (val=="EMPSTATUS$DEPU")
    {
       document.getElementById("txtDepuType").disabled = "";
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {
       document.getElementById("txtDepuType").disabled = "true";
       document.getElementById("txtDepuType").value = "";
       document.getElementById("txtDepuType").style.background="#ffffff";
       document.getElementById("txtDepuType").style.className="locked";           
    }  
}

function checkPFType(){     
    if (document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=='')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';
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

function onChangePFType(val)
{
    if (val=='PFTYPE$GPF')
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';
        document.getElementById("vgpf").style.display='';
        document.getElementById("vcpf").style.display='none';    
         document.getElementById("txtUanNum").style.background="#e0e0e0";
       document.getElementById("txtUanNum").style.className="locked"; 
       document.getElementById("txtUanNum").disabled = "true";
       
    }
    if (val=='PFTYPE$CPF')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';
        document.getElementById("vcpf").style.display='';
        document.getElementById("vgpf").style.display='none';
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
       
       document.getElementById("txtHandiType").disabled = true;
       document.getElementById("txtHandiType").style.background="#e0e0e0";
       document.getElementById("txtHandiType").style.className="locked";
    }    
}

function checkHraStatus()
{
    if (document.all.txtHRAStat.value=="Y")
    {
       document.getElementById("txtHRAEffDate").disabled = "";
       document.getElementById("txtHRAEffDate").style.background="#ffffd3";
       document.getElementById("txtHRAEffDate").style.className="required"; 
    }  
    if (document.all.txtHRAStat.value=="N")
    {
       //document.getElementById("txtHRAEffDate").disabled = "true";
       document.getElementById("txtHRAEffDate").value = "";
       document.getElementById("txtHRAEffDate").style.background="#e0e0e0";
       document.getElementById("txtHRAEffDate").style.className="locked"; 
    }    
}

function onChangeAccomType()
{
    if (document.all.lstAccomType.value=="ACCOMTYPE$SELF" || document.all.lstAccomType.value=="ACCOMTYPE$THIRDP")
    {
       document.getElementById("txtLeaseAmt").disabled = "";
       document.getElementById("txtLeaseAmt").style.background="#ffffd3";
       document.getElementById("txtLeaseAmt").style.className="required";
    }
    else
    {
       document.getElementById("txtLeaseAmt").disabled = "true";
       document.getElementById("txtLeaseAmt").value = "";
       document.getElementById("txtLeaseAmt").style.background="#e0e0e0";
       document.getElementById("txtLeaseAmt").style.className="locked";
    }
    if (document.all.lstAccomType.value!="ACCOMTYPE$SPOUSE")
    {
       document.getElementById("txtLicFeeDEM").disabled = "";
       document.getElementById("txtLicFeeDEM").style.background="#ffffd3";
       document.getElementById("txtLicFeeDEM").style.className="required";
    }
    else
    {
       document.getElementById("txtLicFeeDEM").disabled = "true";
       document.getElementById("txtLicFeeDEM").value = "";
       document.getElementById("txtLicFeeDEM").style.background="#e0e0e0";
       document.getElementById("txtLicFeeDEM").style.className="locked"; 
    }
}

function checkGenPrefix(val)
{
    if(val=='M' && document.all.prefix.value!="")
    {
        if(document.all.prefix.value=='MISS' || document.all.prefix.value=='MRS' || document.all.prefix.value=='MS')
        {
            alert("Please Select Female")
            document.all.txtGender.value="";
            document.all.txtGender.focus();
        }
    }
    if(val=='F' && document.all.prefix.value!="")
    {
        if(document.all.prefix.value=='MR')
        {
            alert("Please Select Male")
            document.all.txtGender.value="";
            document.all.txtGender.focus();
        }
    }
    comboChange();
}
function getyrmm(varDate)
{ 
    
    date1 = change_DateFormatMon(varDate);
    firstindex=date1.indexOf("/");
    lastindex=date1.lastIndexOf("/");
    if(lastindex==4)
    {
        MM1=date1.substring(firstindex+1,lastindex);
        YYYY1=date1.substring(lastindex+1,date1.length+1);
        return (YYYY1+'0'+MM1);
    }
    else
    {
        MM1=date1.substring(firstindex+1,lastindex);
        YYYY1=date1.substring(lastindex+1,date1.length+1);
        return (YYYY1+MM1);
    }
}
function SaveRecord()
{


  retirDate=getyrmm(frmDeptLabourInfoForm.txtRetireDate.value);
  currDate=document.all.payYYMM.value;
  document.all.buttonFlag.value='';
   // commented by manish jindal reference issue 43490
   /* if(!(currDate==retirDate))
     {
       if(cmpDOBSysDate(frmDeptLabourInfoForm.txtDOB.value)!=true)
        return false;    
     } */
    
    if(mandatory_Check("frmDeptLabourInfoForm"))
    {     
		//added by devendra on 23 sept 2010 start
			if(frmDeptLabourInfoForm.txtCurtBasic.value=="")
            {
                alert("Mandatory Field Current Basic in Payroll Details is Empty! ");
                return;
            }
			/*if(frmDeptLabourInfoForm.txtPayStatus.value=="")
            {
                alert("Mandatory Field Pay Status in Payroll Details is Empty! ");
                return;
            }*/  // Commented by dushyant on 18-May-2013
			if(frmDeptLabourInfoForm.txtPayMode.value=="")
            {
                alert("Mandatory Field Pay Mode in Payroll Details is Empty! ");
                return;
            }
			if(frmDeptLabourInfoForm.txtPayStsChnDate.value=="")
            {
                alert("Mandatory Field Pay Status Changed Date in Payroll Details is Empty! ");
                return;
            }
			if(frmDeptLabourInfoForm.txtInrSt.value=="")
            {
                alert("Mandatory Field Increment Status in Payroll Details is Empty! ");
                return;
            }
			if(frmDeptLabourInfoForm.txtMHSTyp.value=="")
            {
                alert("Mandatory Field MHS Member in Payroll Details is Empty! ");
                return;
            }
			// added by devendra on 23 sept 2010 end

        document.getElementById("txtPFType").disabled= "";
        //document.all.hdnCCAFlag.value='Y';         commented by devendra on 21 sept 2010
		document.all.hdnCCAFlag.value='';         //added by devendra on 21 sept 2010
        //document.all.hdnStationCompFlag.value=document.all.txtPayType.value=='IDA'? 'Y' : 'N';  commented by devendra on 21 sept 2010  
		document.all.hdnStationCompFlag.value='';       //added by devendra on 21 sept 2010 
        document.all.hdnPLIFlag.value=frmDeptLabourInfoForm.hdnBoardFlag.value=='N' ? 'Y' : 'N';   
        frmDeptLabourInfoForm.detailDataChanged.value = "false";  
        if(frmDeptLabourInfoForm.screenMode.value == "N")
            frmDeptLabourInfoForm.headerDataChanged.value = "true";      
        frmDeptLabourInfoForm.headerFields.value = "true";                
        
        frmDeptLabourInfoForm.action = "../../../DeptLbrHrSaveAction.do";                
        document.all.txtCateg.disabled = "";
        document.all.txtDsgn.disabled = "";              
        document.all.txtEmpStatus.disabled='';
		//document.getElementById("txtPayStatus").disabled="";   // Added by dushyant on 18-May-2013
		document.all.txtPayStatus.disabled="";
        document.all.parentZone.disabled='';  
        
        document.all.txtCasteCateg.disabled = false;
       document.all.txtReligion.disabled = false;
      document.all.txtHandiType.disabled = false;
             document.all.txtHandi.disabled = false;

      document.all.txtExsrvcman.disabled=false;
       
       document.all.txtUanNum.disabled = false;
        
        frmDeptLabourInfoForm.submit();
    }
    else
    {
        return false;
    }
}

function comboChange(val)
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
}

function upper(val)
{
   val.value=val.value.toUpperCase();
}

function saveCheckBox()
{   alert(1);
    
}

function lfnChangeNegNum(val)
{
    if(NegNum_Check(val,1))
    { 
        frmDeptLabourInfoForm.headerDataChanged.value = "true";
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

retirDate=getyrmm(frmDeptLabourInfoForm.txtRetireDate.value);
 
 currDate=document.all.payYYMM.value;

    document.all.buttonFlag.value='';
  
    mode = document.all.screenMode.value;      
    if(mode == 'N' || mode == 'U')
    { 

// commented by manish jindal reference issue 43490
       /* if(!(currDate==retirDate))
        {
            if(cmpDOBSysDate(frmDeptLabourInfoForm.txtDOB.value)!=true)
             return false;  
        } */
           //if(mandatory_Check("frmDeptLabourInfoForm")) commented by devendra on 20 sept 2010
           
        {
          document.all.forwardedPage.value=arg;
          document.forms[0].action="../../../DeptLbrHrTabAction.do";
          document.forms[0].submit(); 
        }
    }
    else
    {
        document.all.forwardedPage.value=arg;
        document.forms[0].action="../../../DeptLbrHrTabAction.do";
        document.forms[0].submit();     
    }
}


function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../DeptLbrHrTabAction.do";
    document.forms[0].submit(); 
}

/*function lfnChange(val)
{
    if(num_Check(val,1))
        frmDeptLabourInfoForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}*/

function lfnChanged(val)
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.action="../../../DeptLbrHrGetHeaderAction.do"
    frmDeptLabourInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.positionRequested.value + 1;
    frmDeptLabourInfoForm.action="../../../DeptLbrHrGetNextHeader.do";
    frmDeptLabourInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.positionRequested.value - 1;
    frmDeptLabourInfoForm.action = "../../../DeptLbrHrGetPrevHeader.do";
    frmDeptLabourInfoForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.newPositionRequested.value;
    frmDeptLabourInfoForm.action = "../../../DeptLbrHrGetNextHeader.do";
    frmDeptLabourInfoForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmDeptLabourInfoForm.action="../../../DeptLbrFinNewMode.do"
    frmDeptLabourInfoForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmDeptLabourInfoForm.action="../../../DeptLabourQueryMode.do"
    frmDeptLabourInfoForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmDeptLabourInfoForm.action="../../../DeptLbrHrRefresh.do"
    frmDeptLabourInfoForm.submit();
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

function checkHRAEffDate(val)
{
    var systDate = getSysDate();  
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtHRAEffDate.value="";     
        return false;
    }        
}

function checkPrevPromDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtPrvPromDate.value="";     
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

