var formMode;

function initToolBar()
{
  formMode="A"  
  DisplayToolBar()
	ResetImage()
	SetNavigation()
	DisplayGoBut()
}


function DisplayToolBar()
{
 if (formMode =="A")
		{
		   str = "<a href='javascript:void(QueryClick())'>"
		   str+="<img alt='Query' border='0' src='../INCLUDES/IMAGES/query.jpg' hsrc='../INCLUDES/IMAGES/query_act.jpg' style='CURSOR: default'></a>"
		   str+= "<a href='#'><img alt='Insert' border='0' src='../INCLUDES/IMAGES/insert_dis.jpg' style='CURSOR: default'></a>"
		   TBar.innerHTML=str;
		}
		else if (formMode =="Q")
		{
		   str = "<a href='#'><img alt='Query' border='0' src='../INCLUDES/IMAGES/query_dis.jpg' style='CURSOR: default'></a>"
		   str+= "<a href='javascript:void(InsertClick())'>"
		   str+="<img alt='Insert' border='0' src='../INCLUDES/IMAGES/insert.jpg'	hsrc='../INCLUDES/IMAGES/insert_act.jpg' style='CURSOR: default'></a>"
		   TBar.innerHTML=str;
		}
		else if (formMode == "U")
		{
		   str = "<a href='javascript:void(QueryClick())'>"
		   str+="<img alt='Query' border='0' src='../INCLUDES/IMAGES/query.jpg' hsrc='../INCLUDES/IMAGES/query_act.jpg' style='CURSOR: default'></a>"
		   str+= "<a href='javascript:void(InsertClick())'>"
		   str+="<img alt='Insert' border='0' src='../INCLUDES/IMAGES/insert.jpg'	hsrc='../INCLUDES/IMAGES/insert_act.jpg' style='CURSOR: default'></a>"
	     TBar.innerHTML=str;
    }
}

function QueryClick()
{
   var bResponse=doModeChange("Q") //call to frmBody frame page.
   if(bResponse){
  	 formMode = "Q"
     DisplayToolBar()
     SetNavigation()
     DisplayGoBut() 
     ResetImage()
     doRefresh();
  }
}

function InsertClick()
{
	 var bResponse=doModeChange("A") //call to frmBody frame page.
   if(bResponse){
     formMode = "A";
     DisplayToolBar()
     SetNavigation()
     ResetImage()
     DisplayGoBut()
     doRefresh();
   }
}

function ResetImage()
{
   if (!document.getElementById) return
   var imgOriginSrc;
   var imgTemp = new Array();
   var imgarr = document.getElementsByTagName('img');
   for (var i = 0; i < imgarr.length; i++)
   {
     if (imgarr[i].getAttribute('hsrc'))
     {
	    imgTemp[i] = new Image();
	    imgTemp[i].src = imgarr[i].getAttribute('hsrc');
        imgarr[i].onmouseover = function()
                   {imgOriginSrc = this.getAttribute('src'); this.setAttribute('src',this.getAttribute('hsrc'))}
        imgarr[i].onmouseout = function()
                   {this.setAttribute('src',imgOriginSrc) }
     }
  }
}

function DisplayGoBut()
{
  var str=doGetButtons(formMode);
	GoBut.innerHTML=str;
}

function PopulateRec()
{
   var bResponse=doModeChange("U") //call to frmBody frame page.
   formMode = "U";
   DisplayToolBar();
   SetNavigation();
   ResetImage();
   DisplayGoBut();
}

function SetNavigation()
{
  var str="";
	if (formMode =="U")
	{
    str=doSetNavigation();
	}
	else
	{
		str= "<img alt='First' src='../INCLUDES/IMAGES/butn_first_dis.jpg' style='CURSOR: default'>"
		str+= "<img alt='Previous' src='../INCLUDES/IMAGES/butn_prev_dis.jpg' style='CURSOR: default'>"
	  str+= "<img alt='Next' src='../INCLUDES/IMAGES/butn_next_dis.jpg' style='CURSOR: default'>"
		str+= "<img alt='Last' src='../INCLUDES/IMAGES/butn_last_dis.jpg' style='CURSOR: default'>"
	}

	NavBar.innerHTML=str;
}


