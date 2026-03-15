    
 function changed(val)
{
  frmMaintSiteDetail.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}
   
function doBaseAddRow()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
      
        document.getElementsByName("txtSiteName")[i].disabled="";
   
   
  }
  document.forms[0].action = "/Payroll/SiteAddRowAction.do";
  document.forms[0].submit();
}

function doBaseDelRow()
{
  


  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;


  
  for(i=0; i < iTr2 -1; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintSiteDetail.detailDataChanged.value = "true";      
    }

  }
   
  enable();
  document.forms[0].action = "/Payroll/SiteDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;


  
  for(i=0; i < iTr2 -1; i++)
  {
      document.getElementsByName("txtSiteName")[i].disabled="";

        if (document.getElementsByName("status")[i].value == 'D')
        frmMaintSiteDetail.detailDataChanged.value = "true";
  }

  frmMaintSiteDetail.headerFields.value = "false";
  frmMaintSiteDetail.action = "/Payroll/SiteSaveAction.do";
  frmMaintSiteDetail.totalDetailRecord.value=parseInt(iTr2)-1;
  frmMaintSiteDetail.submit();
}

function GetDetail()
{
  document.all.screenMode.value='U';
  frmMaintSiteDetail.action="/Payroll/SiteGetDetailAction.do"
  frmMaintSiteDetail.submit();
}

function Chk_Char(ind,name)
{
 that=document.getElementsByName(name)[ind-1];
 str=that.value;
 for(i=0; i<str.length; i++)
 {
  var city =str.charAt(i);
  if((city >= 'A' && city <= 'Z') ||(city >= 'a' && city <= 'z') || (city == ',') || (city == ' '))
  {}
  else
  {
    alert("Invalid Input");
    that.select();
    that.select();
    that.select();
    that.select();
    that.select();
    that.select();
    return true;
  }
  }
}





function checkDuplicacy(that,rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName(that)[rInd-1].value;
  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(rInd != ind)
    {
      oldComb = document.getElementsByName(that)[ind-1].value;
      if(oldComb.toUpperCase()==newComb.toUpperCase())
      {
        alert("You can\'t enter duplicate value");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
        return false;
      }
    }
  }
  return true;
}

function siteLoad()
{
  //alert("inside");
 // doQueryMode();
  mode = document.all.screenMode.value;
  alert(mode);
  if(mode=='')
  {
      doQueryMode();
   }
  
if(mode=='Q')
     {
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
     } 


  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }


  if(mode=='U')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";

  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
     if (document.getElementsByName("status")[i].value == 'Q')
      {      
          
        document.getElementsByName("txtSiteName")[i].disabled="disabled";
       
        
      }
  }

  }
detMenuHandling(mode);
}
function upper(val)
{
   val.value=val.value.toUpperCase();
}
     
function doBasePrevDetail()
{
    frmMaintSiteDetail.userPageRequested.value = 1*frmMaintSiteDetail.pageRequested.value - 1;
    frmMaintSiteDetail.action = "/Payroll/SitePrevDetailAction.do";
    frmMaintSiteDetail.submit();
}


function doBaseNextDetail()
{
    frmMaintSiteDetail.userPageRequested.value = 1*frmMaintSiteDetail.pageRequested.value + 1;
    frmMaintSiteDetail.action = "/Payroll/SiteNextDetailAction.do";
    frmMaintSiteDetail.submit();
}

function JumpDetail()
{
    frmMaintSiteDetail.userPageRequested.value = 1*frmMaintSiteDetail.newPageRequested.value ;
    frmMaintSiteDetail.action = "/Payroll/SiteNextDetailAction.do";
    frmMaintSiteDetail.submit();
}
/*function menuHandling(mode)
{
  if(mode=='')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    

      document.all.butnGo.disabled="true";    
  }
  else
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butSave.disabled="";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_act.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    



  }
 

}*/

function doQueryMode()
{
    
     alert("ins qry);
     frmMaintSiteDetail.action="/Payroll/SiteQueryMode.do";
     frmMaintSiteDetail.submit();

}

function enable()
{
   var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
      
        document.getElementsByName("txtSiteName")[i].disabled="";
   
   
  }
 }
function doRefresh()
{
 
  frmMaintSiteDetail.action="/Payroll/SiteRefresh.do";
  frmMaintSiteDetail.submit();
}
