//Global to save previous setting
var origCols;
var origLeft;
var isMinimized=false;
var flag=true;

/*Resizing the menu
function toggleFrame(){
         if(isMinimized)
            restoreFrame();
         else
            resizeFrame(15);
}*/


//Minimizing the TreeMenu
function minimizeFrame(evt){
	 if(!isMinimized)
	    resizeFrame(05); //How numch the menu should be sqeezed (default=5)
}

//Restoring the TreeMenu
function maximizeFrame(){
         if(isMinimized && event.srcElement.tagName.toLowerCase() != "img" )
            restoreFrame();
}

//resize lefthand frame
function resizeFrame(left){
 var frameset=parent.document.getElementById("frmsetCol");
 origCols=frameset.cols;
 frameset.cols=left+ ",*";
 origLeft=document.getElementById("divCross").style.left;
 document.getElementById("divCross").style.left=0;
 document.getElementById("cross").src="../INCLUDES/IMAGES/pixel.gif";
 isMinimized=true;
 
}

function restoreFrame(){
parent.document.getElementById("frmsetCol").cols=origCols;
document.getElementById("divCross").style.left=origLeft;
origCols=null;
 document.getElementById("cross").src="../INCLUDES/IMAGES/cross.jpg";
isMinimized=false;
}
