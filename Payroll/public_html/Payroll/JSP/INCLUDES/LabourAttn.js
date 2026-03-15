function lfnLoad()
{  
  mode1 = document.all.screenMode.value;
  //alert("screenMode----"+document.all.screenMode.value);  
  //alert("screenModeID----"+frmLbrAncllryAttndForm.screenModeID.value);  
  if(mode1 == "" && frmLbrAncllryAttndForm.screenModeID.value == "")
  {
    doQueryMode();
  }
  document.all.butInsert.disabled="true";
  document.all.butDelete.disabled="true"; 

  if(frmLbrAncllryAttndForm.screenModeID.value=='UG')
  {
      document.all.butGetDetail.disabled="true";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      } 
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";  
  }  
  
  mode = frmLbrAncllryAttndForm.screenMode.value;  
  if(mode=='Q')
  {
     document.all.butGetDetail.disabled="true";
     document.all.butInsert.disabled="true";
     document.all.butDelete.disabled="true";     
  }
  
    if(mode=='U')
    {
        document.all.butGetDetail.disabled="true";
        document.all.butInsert.disabled="true";
        document.all.butDelete.disabled="true";
       // alert();
        var  yearM = document.getElementById("txtYYMM").value;          
        var month =  yearM.substring(4,6);
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
          return;
        }
        else
        {
            var iTr2 = oTable.rows.length;
            var i = 0;
            var noDays = daysTearMonth(month, yearM.substring(0,4));
           // alert(noDays);
            var ctrl;
            var fieldVal;
            for(i=0; i < iTr2 -2; i++)
            {   
                for(j=noDays+1; j < 32; j++)    
                {
                    ctrl="selectDays"+j;              
                    fieldVal="txtDays"+j;
                    //alert("ctrl---"+ctrl);
                    //document.getElementsByName(ctrl)[i].checked = false;
                    document.getElementsByName(fieldVal)[i].value="";                             
                    document.getElementsByName(fieldVal)[i].disabled = "true";                    
                }
            }
        }
    } 
    
    if(frmLbrAncllryAttndForm.screenModeID.value=='UI' )
    {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="true";
        document.all.butDelete.disabled="true";
    }
  
  menuHandling(mode);
  document.all.butDel.disabled="true";    
  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";

}

function daysTearMonth(mnth, years )
{
    var intMonth = mnth;//given month
    var intYear = years;//given year    
    
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


function getHeaderRecord()
{
    if(mandatory_Check("frmLbrAncllryAttndForm"))
    {
      document.all.buttonFlag.value='';
      document.all.headerMode.value = "U";
      document.all.headerMode1.value = "U";
      document.all.screenModeID.value='UI';  
      document.all.screenModeDARate.value = "U1";    
      document.all.headerClick.value = "IDA";  
      
      frmLbrAncllryAttndForm.action="/Payroll/LbrAncllryAttndGetHeaderAction.do"
      frmLbrAncllryAttndForm.submit();
    }
}   

function onclickCheck(checkFlag,hdnFlag, ind)
{       
    lfnChange('1', ind);     
    //alert(ind);    
    if (document.getElementsByName(checkFlag)[ind-1].checked==true)
    {   
        document.getElementsByName(hdnFlag)[ind-1].value="Y";                        
    }  
    else 
    {           
        document.getElementsByName(hdnFlag)[ind-1].value="N";           
    }        
}

function lfnChange(val,ind)
{   
      
      frmLbrAncllryAttndForm.detailDataChanged.value = "true";      
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
  
}

function lfnChangeAmt(val,ind)
{
    if(num_Check(val,1))
    {
      maxCheck(ind);
      frmLbrAncllryAttndForm.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
    }
    else
    {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
    }
}

function maxCheck(i)
{
     var low = parseInt(document.getElementsByName("startField")[i-1].value);
     var high = parseInt(document.getElementsByName("endField")[i-1].value);

    if(high <= low )
    {
      alert("High Basic Should be greater than Low Basic")
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;                        
    }
    return true;
}

function lfnChangePer(val,ind)
{
   if(percent_Check(val))
  {
      frmLbrAncllryAttndForm.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}


function doGetNextHeader()
{
    document.all.buttonFlag.value='';
    frmLbrAncllryAttndForm.screenModeID.value='U';
    
    frmLbrAncllryAttndForm.headerClick.value = "IDA";
    document.all.screenModeDARate.value = "U1"; 
    
    frmLbrAncllryAttndForm.userPositionRequested.value = 1*frmLbrAncllryAttndForm.positionRequested.value + 1;  
    frmLbrAncllryAttndForm.action="/Payroll/LbrAncllryAttndGetNextHeader.do";    
    
    frmLbrAncllryAttndForm.submit();
}


function PrevHeader()
{
 document.all.buttonFlag.value='';
  frmLbrAncllryAttndForm.screenModeID.value='U';
  document.all.screenModeDARate.value = "U1"; 
  frmLbrAncllryAttndForm.headerClick.value = "IDA";

  frmLbrAncllryAttndForm.userPositionRequested.value = frmLbrAncllryAttndForm.positionRequested.value - 1;  
  frmLbrAncllryAttndForm.action = "/Payroll/LbrAncllryAttndGetNextHeader.do";
  frmLbrAncllryAttndForm.submit();
}





function doBaseAddRow()
{
   document.all.buttonFlag.value='D';
  //if(mandatory_Check("frmLbrAncllryAttndForm"))
  //{
  //   document.all.screenMode.value='U';
    frmLbrAncllryAttndForm.screenModeDARate.value = "N1";
    
      document.forms[0].action = "/Payroll/LbrAncllryAttndAddRowAction.do";
      document.forms[0].submit();
 // }
 // else
 // {
  //    return false;
  //}
}

function doBaseDelRow()
{
   document.all.buttonFlag.value='D';
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;


  for(i=0; i < iTr2 -2; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmLbrAncllryAttndForm.detailDataChanged.value = "true";      
    }

  }
  
  
  document.forms[0].action = "/Payroll/daRatesDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{

 document.all.buttonFlag.value='';

  if(mandatory_Check("frmLbrAncllryAttndForm"))
  {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
      
      for(i=0; i < iTr2 -2; i++)
      {          
          if (document.getElementsByName("status")[i].value == 'D')
              frmLbrAncllryAttndForm.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'N')
              frmLbrAncllryAttndForm.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'U')
              frmLbrAncllryAttndForm.detailDataChanged.value = "true";
          document.getElementsByName("txtDays29")[i].disabled="";
          document.getElementsByName("txtDays30")[i].disabled="";
          document.getElementsByName("txtDays31")[i].disabled="";
          
      }      
      document.all.screenMode.value='U';      
      document.all.headerMode.value=document.all.headerMode1.value;
      //frmLbrAncllryAttndForm.headerPrimaryKey.value = frmLbrAncllryAttndForm.txtYYMM.value + "#" + frmLbrAncllryAttndForm.txtGangId.value;
      
      frmLbrAncllryAttndForm.totalDetailRecord.value = parseInt(iTr2)-2; 
      
      document.all.screenModeFlag.value=false;  
      
      frmLbrAncllryAttndForm.headerFields.value="false";
      frmLbrAncllryAttndForm.action = "/Payroll/LbrAncllryAttndSaveAction.do";
      frmLbrAncllryAttndForm.submit();
  }
  else
  {
    return false;
  }
}

function GetDetail()
{
  document.all.buttonFlag.value='';
  if(mandatory_Check("frmLbrAncllryAttndForm"))
  {
      document.all.screenModeID.value='UG';
      if (document.all.screenMode.value=='N')
          document.all.screenModeFlag.value=true;
      else
          document.all.screenModeFlag.value=false;     
      
      
      if (document.all.screenMode.value=='N')
          document.all.screenMode.value='U';
      //document.all.headerMode.value = document.all.headerMode1.value;
      //frmLbrAncllryAttndForm.headerPrimaryKey.value = frmLbrAncllryAttndForm.txtYYMM.value + "#" + frmLbrAncllryAttndForm.txtDAType.value;  
      frmLbrAncllryAttndForm.action="/Payroll/LbrAncllryAttndDetailAction.do"
      frmLbrAncllryAttndForm.submit();
  }
}

function doInsertMode()
{
 document.all.buttonFlag.value='';
     document.all.headerMode.value  = "N";
     document.all.headerMode1.value  = "N";
     document.all.screenModeID.value  = "N";
     document.all.screenMode.value = "N";
     document.all.screenModeDARate.value = "I";

  frmLbrAncllryAttndForm.action="/Payroll/LbrAncllryAttndNewMode.do"
  frmLbrAncllryAttndForm.submit();

}

function doQueryMode()
{
    document.all.buttonFlag.value='';
     document.all.screenModeID.value  = "Q";
     document.all.screenMode.value = "Q";
     document.all.screenModeDARate.value = "Q";
     document.all.headerMode.value  = "Q";
     document.all.headerMode1.value  = "Q";
 
  frmLbrAncllryAttndForm.action="/Payroll/LbrAncllryAttndQueryMode.do"
  frmLbrAncllryAttndForm.submit();

}

function chk_YearMonth()
{      
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);    
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

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmLbrAncllryAttndForm.userPageRequested.value = 1*frmLbrAncllryAttndForm.pageRequested.value - 1;
    frmLbrAncllryAttndForm.action = "/Payroll/DAIDAPrevDetailAction.do";
    frmLbrAncllryAttndForm.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmLbrAncllryAttndForm.userPageRequested.value = 1*frmLbrAncllryAttndForm.pageRequested.value + 1;
    frmLbrAncllryAttndForm.action = "/Payroll/DAIdaNextDetailAction.do";
    frmLbrAncllryAttndForm.submit();
}


function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmLbrAncllryAttndForm.flag.value = "false";
  frmLbrAncllryAttndForm.userPositionRequested.value = 1*frmLbrAncllryAttndForm.newPositionRequested.value;
  frmLbrAncllryAttndForm.action = "/Payroll/LbrAncllryAttndGetNextHeader.do";
  frmLbrAncllryAttndForm.submit();
}

function JumpDetail()
{
     document.all.buttonFlag.value='';
    frmLbrAncllryAttndForm.userPageRequested.value = 1*frmLbrAncllryAttndForm.newPageRequested.value ;
    frmLbrAncllryAttndForm.action = "/Payroll/DAIdaNextDetailAction.do";
    frmLbrAncllryAttndForm.submit();
}

function doRefresh()
    {
   
        frmLbrAncllryAttndForm.action = "/Payroll/LbrAncllryAttndRefresh.do";
        frmLbrAncllryAttndForm.submit();
    }

function AmtCheck()
{
            var oTable = document.getElementById("Detail");
            var iTR = oTable.rows.length;
            var flag =0;
            
            for(i=0;i<iTR-1;i++)
            {   
                var m = parseInt(document.getElementsByName("startField")[i].value);
                var n= parseInt(document.getElementsByName("endField")[i].value);               

                if (m >= n)
                {
                   alert("Amount To Should Be Greater Than Amount From");
                   document.getElementsByName("endField")[i].focus(); 
                   return false;
                }                             

            }             
 
        return true;
}

function checkAttndType()
{
    var keyArr=[65,77,80,87,97,109,112,119];
    var i;
    var flag='false';
    for(i=0; i<keyArr.length+1; i++)
    {
        if (event.keyCode == keyArr[i])
        {
            flag='true';
            break;
        }
    }    
    if (flag=='true')
        return true;
    else 
        return false;    
}
 
function upper(val)
{
    val.value=val.value=='' ? 'W' : val.value.toUpperCase();   
}