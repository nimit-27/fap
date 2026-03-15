package FCIPAY.HRMS.UTILITY;


 /*
   * Module:        VenueList.java
   * Author:        Moon Nag Sarkar
   * Date Written:  05-09-2003
  * Description:  Following method is used to set list object with values
  * Revision Log  (05/09/03 initials description)
  * --------------------------------------------------------
  * mm/dd/yy xxx  What you changed
  */





public class VenueList
{
  private long DName=0;
  private long DId=0;
  
  public VenueList(long plGradeid,long psGradeName)
  { 
    this.DId=plGradeid;
    this.DName=psGradeName;
    
    System.out.println("List: in Gradelist.java");
      
  }
  
  public void setDId(long plGradeId){this.DId=plGradeId;}
  
  public long getDId(){return this.DId;}
  
  public void setDName(long psGradeName){this.DName=psGradeName;}

  public long getDName(){return this.DName;}
  
}