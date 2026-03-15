<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" errorPage="../../../COMMON/JSP/failure.jsp" %>
<script>
/*** 
This is the menu creation code - place it right after you body tag
Feel free to add this to a stand-alone js file and link it to your page.


//Extra code to find position:
function findPos(){
  if(bw.ns4){   //Netscape 4
    x = document.layers.layerMenu.pageX
    y = document.layers.layerMenu.pageY
  }else{ //other browsers
    x=0; y=0; var el,temp
    el = bw.ie4?document.all["divMenu"]:document.getElementById("divMenu");
    if(el.offsetParent){
      temp = el
      while(temp.offsetParent){ //Looping parent elements to get the offset of them as well
        temp=temp.offsetParent; 
        x+=temp.offsetLeft
        y+=temp.offsetTop;
      }
    }
    x+=el.offsetLeft
    y+=el.offsetTop
  }
  //Returning the x and y as an array
  return [x,y]
}

pos = findPos()
**/
//Menu object creation
MyMenu=new makeCM("MyMenu") //Making the menu object. Argument: menuname

FinMenu = "/Payroll/Finance/JSP/";
HRMenu = "/Payroll/HRMS/JSP/";
var cmmMenu="/Payroll/CMM/JSP/";
ComMenu = "/Payroll/COMMON/JSP/";
var mmm="/Payroll/";
var RepMenu = "";

MyMenu.frames = 0

//Menu properties   
MyMenu.pxBetween=10
MyMenu.fromLeft=20 
MyMenu.fromTop=0   
MyMenu.rows=1 
MyMenu.menuPlacement="center"
                                                             
MyMenu.offlineRoot="" 
MyMenu.onlineRoot="" 
MyMenu.resizeCheck=1 
MyMenu.wait=1000 
MyMenu.fillImg="cm_fill.gif"
MyMenu.zIndex=5000

//Background bar properties
MyMenu.useBar=1
MyMenu.barWidth="100%"
MyMenu.barHeight="menu" 
MyMenu.barClass="clBar"
MyMenu.barX=0 
MyMenu.barY=0
MyMenu.barBorderX=0
MyMenu.barBorderY=0
MyMenu.barBorderClass=""

MyMenu.onresize="makeCM('MyMenu'); MyMenu.construct(1);"

//Level properties - ALL properties have to be spesified in level 0
MyMenu.level[0]=new cm_makeLevel() //Add this for each new level
MyMenu.level[0].width=90
MyMenu.level[0].height=29 
MyMenu.level[0].regClass="clLevel0"
MyMenu.level[0].overClass="clLevel0over"
MyMenu.level[0].borderX=0
MyMenu.level[0].borderY=1
MyMenu.level[0].borderClass="clLevel0border"
MyMenu.level[0].offsetX=0
MyMenu.level[0].offsetY=0
MyMenu.level[0].rows=0
MyMenu.level[0].arrow=0
MyMenu.level[0].arrowWidth=0
MyMenu.level[0].arrowHeight=0
MyMenu.level[0].align="bottom"

//EXAMPLE SUB LEVEL[1] PROPERTIES - You have to specify the properties you want different from LEVEL[0] - If you want all items to look the same just remove this
MyMenu.level[1]=new cm_makeLevel() //Add this for each new level (adding one to the number)
MyMenu.level[1].width=170
MyMenu.level[1].height=28
MyMenu.level[1].regClass="clLevel1"
MyMenu.level[1].overClass="clLevel1over"
MyMenu.level[1].borderX=1
MyMenu.level[1].borderY=1
MyMenu.level[1].align="right" 
MyMenu.level[1].offsetX=0//-(MyMenu.level[0].width-2)/2+20
MyMenu.level[1].offsetY=0
MyMenu.level[1].borderClass="clLevel1border"


//EXAMPLE SUB LEVEL[2] PROPERTIES - You have to spesify the properties you want different from LEVEL[1] OR LEVEL[0] - If you want all items to look the same just remove this
MyMenu.level[2]=new cm_makeLevel() //Add this for each new level (adding one to the number)
MyMenu.level[2].width=160
MyMenu.level[2].height=21
MyMenu.level[2].offsetX=0
MyMenu.level[2].offsetY=0
MyMenu.level[2].regClass="clLevel2"
MyMenu.level[2].overClass="clLevel2over"
MyMenu.level[2].borderClass="clLevel2border"


/******************************************
Menu item creation:

*************************************/
<% session.getAttribute("menuList"); %>

<logic:iterate name="frmMainPage" id="DynamicMenuBean" property="menuList" >
    <bean:write name="DynamicMenuBean" property="dynamicMenu" filter="false" />
</logic:iterate>

//Leave this line - it constructs the menu
MyMenu.construct()		

//MyMenu.showsub("top3")
MyMenu.hidesub()
                                                             
</script>
