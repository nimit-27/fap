function menuHandling(mode)
{
  if(document.all.buttonFlag.value!='D')    
    document.all.buttonFlag.value='ND';  
  if(mode=='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
   /*   document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";  */  
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
      document.all.newPositionRequested.disabled="true";    
	  
  }
  if(mode=='N')
  {
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
//      document.all.butRefresh.disabled="true";    
//      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg"; 
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
  if(mode=='U')
  {
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";   
  }
  if(document.all.buttonFlag.value=='D')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  }
  
  document.all.butDelete.disabled="true";
}

function hedMenuHandling(mode)
{
  if(document.all.buttonFlag.value != 'D')    
    document.all.buttonFlag.value='ND';  
    
  if(mode=='Q')
  {
	//alert('inside hedMenuHandling , mode:::'+mode);
	//alert('screenFlag value:::'+document.all.screenFlag.value);
	
		//property="screenFlag" value="MaintainEmpFinDetailScreen"


	  document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
      document.all.newPositionRequested.disabled="true";  
/* commented out to move code in emp admin jsp
	  var screenName = document.all.screenFlag.value;
	  if(screenName =='MaintainEmpAdminFinDetailScreen')
	  {
		document.all.butInsertMode.disabled="true"; //added by devendra
		document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";   // added by devendra
	  }
	  */
  }
  if(mode=='N')
  {
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
//      document.all.butRefresh.disabled="true";    
//      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg"; 
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
  if(mode=='U')
  {
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	  /* commented out to move code in emp admin jsp

	  document.all.butInsertMode.disabled="true"; //added by devendra
	  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";   // added by devendra
	  */
  }
  if(document.all.buttonFlag.value=='D')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  }

}


function detMenuHandling(mode)
{
  if(document.all.buttonFlag.value!='D')    
    document.all.buttonFlag.value='ND'; 
 
  if(mode=='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";    
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
      document.all.newPositionRequested.disabled="true";    
  }
  
  if(mode=='N')
  {
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
  if(mode=='U')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrint.disabled="true";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
      document.all.newPositionRequested.disabled="true";    
  }
  
  if(document.all.buttonFlag.value=='D')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  }
  document.all.butDelete.disabled="true";  
}

function changeDtlStartField(startFieldName, endFieldName, index, y)
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  if(oTable.rows.length <= index)
  {
    return;
  }
  for(i=index; i < oTable.rows.length-1; i ++)
  {  
    if(document.getElementsByName("status")[i].value != 'D')
    {
      if(y == '0')
      {
        document.getElementsByName(startFieldName)[i].value = parseInt(document.getElementsByName(endFieldName)[index-1].value, 10) + 1; 
      }
      else
      {        
        val = parseInt(document.getElementsByName(endFieldName)[index-1].value, 10) + 1;
        
        if(val % 100 > 12 ) 
        {
          if(val % 100 > 13)
          {
            alert("Please enter the year month in proper format");event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;
            return false;
          }
          val = (parseInt(val / 100, 10) + 1) * 100 + 1;
        } 
        document.getElementsByName(startFieldName)[i].value = val; 
      }
       if( document.getElementsByName("status")[i].value != 'N')       
        document.getElementsByName("status")[i].value = 'U'; 
      return;
    }
  }
}

function toggleCheckBox(param)
{  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  for(i = 0; i < oTable.rows.length - 1; i ++)
  {
    if(document.getElementsByName(param)[0].checked == true)
    {
      if(document.getElementsByName("checked")[i].disabled!=true)
        document.getElementsByName("checked")[i].checked="true";
    }
    else
    {
      document.getElementsByName("checked")[i].checked="";
    }
  }
}

function batchMenuHandling()
{
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";
      
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";   
      
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";  

      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    

/*      
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/query_dis.jpg";    
      
      document.all.butExit.disabled="true";    
      document.all.butExit.src="../INCLUDES/IMAGES/query_dis.jpg"; 
      
      document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/query_dis.jpg";    

      document.all.butHelp.disabled="true";    
      document.all.butHelp.src="../INCLUDES/IMAGES/query_dis.jpg";    
*/      

  //document.all.butDelete.disabled="true";
}


  function checkRecord()
  {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
      var fl = 0;
      for(i=0; i < iTr2 - 1; i++)
      {

        if(document.getElementsByName("checked")[i].checked)
        {
            document.all.butDelete.disabled="";
            return true;
        }
      }
      if(fl == 0)   
      {      
          document.all.butDelete.disabled="true";
          return false;
      }
  }
  //Added by Neeraj on 25oct 2010 starts//
function disableHistory()
{
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
            document.all.butHistory.disabled="true";
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
  var f2=0;
//  alert("No. of  rows--->"+iTr2);
	    for(i=0; i < iTr2 - 1; i++)
      {
        if(document.getElementsByName("checked")[i].checked)
        {
            f2=f2+1;
        }
      }
//alert("f2 val---->"+f2);
        if(f2>1)
        {
//           alert("Select only one row for history!");
            document.all.butHistory.disabled="true";
            return false;
        }
if(f2 == 1)
	{
//alert("Only 1 row selected");
            document.all.butHistory.disabled="";
            return true;
	}
      if(f2 == 0)
      {
//		  alert("No rows selected");
         document.all.butHistory.disabled="true";
          return false;
      }
}
//Added by Neeraj on 25oct 2010 ends//

  function disableMenu()
  { 
        document.all.butQueryMode.disabled="true";    
        document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
        document.all.butInsertMode.disabled="true";    
        document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
        document.all.butExecute.disabled="true";    
        document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
        document.all.butSave.disabled="true";    
        document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
        document.all.butDel.disabled="true";    
        document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
        document.all.butPrint.disabled="true";    
        document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";    
        document.all.butRefresh.disabled="true";    
        document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     
        document.all.butPrevHeader.disabled="true";    
        document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
        document.all.butNextHeader.disabled="true";    
        document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
        
}