
//define universal reference to "staticbanner"
//var crossobj=document.all? document.all.staticBanner : document.getElementById? document.getElementById("staticBanner") : //document.staticBanner

var crossobj=document.getElementById("staticBanner")

function positionit(){
	//define universal dsoc left point
	var dsocleft=document.all? document.body.scrollLeft : pageXOffset
	//define universal dsoc top point
	var dsoctop=document.all? document.body.scrollTop : pageYOffset
	//define universal browser window width
	var window_width=document.all? document.body.clientWidth : window.innerWidth

	//if the user is using IE 4+ or NS6+
	if (document.all||document.getElementById){
		staticBanner.style.left=parseInt(dsocleft)
		staticBanner.style.top=parseInt(dsoctop)
	}
	//else if the user is using NS 4
	//else if (document.layers){
	//crossobj.left=dsocleft
	//crossobj.top=dsoctop+80
	//}



}
window.setInterval("positionit()",1)