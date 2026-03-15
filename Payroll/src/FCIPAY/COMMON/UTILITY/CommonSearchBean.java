package FCIPAY.COMMON.UTILITY;

public class CommonSearchBean 
{
   private String txtIds="";
   private String txtDescs="";

   public CommonSearchBean(String tempTxtIds,String tempTxtDescs)
   {
      this.txtIds=tempTxtIds;
      this.txtDescs=tempTxtDescs;
   }

   public String gettxtIds() 
   {
      return this.txtIds;
   }
   public String gettxtDescs() 
   {
      return this.txtDescs;
   }
}
 
   
   