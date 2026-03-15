/* 
 * Module:        PeriodBean.java 
 * Author:        S. Muthu Subramaniam
 * Date Written:  Oct - 2003 
 * Description:   This is a simple bean which stores all the key-value pairs of the period in the Voucher Screens
 * Revision Log   (mm/dd/yy initials description) 
 * -------------------------------------------------------- 
 * mm/dd/yy xxx  What you changed … 
*/

package FCIPAY.HRMS.UTILITY;

public final class PeriodBean 
{
   private String pId="";
   private String pDesc="";
   private String startDate="";
   private String endDate="";
    private String clndr_stat_gbl;
    private String clndr_opn_ind_gbl;
   
   public PeriodBean(String tempId,String tempDesc)
   {
      this.pId=tempId;
      this.pDesc=tempDesc;
   }
   public PeriodBean(String tempPId,String tempStart,String tempEnd) 
   {
      this.pId=tempPId;
      this.startDate=tempStart;
      this.endDate=tempEnd;
   }

   public PeriodBean(String tempPId,String tempPDesc,  String tempStart,String tempEnd,String tempclndr_stat_gbl ,String tempclndr_opn_ind_gbl ) 
   {
      this.pId=tempPId;
      this.pDesc=tempPDesc;
      this.startDate=tempStart;
      this.endDate=tempEnd;
      this.clndr_stat_gbl=tempclndr_stat_gbl;
      this.clndr_opn_ind_gbl=tempclndr_opn_ind_gbl;
   }

   public String getpId() 
   {
      return this.pId;
   }
   public String getpDesc() 
   {
      return this.pDesc;
   }
   public String getStartDate() 
   {
      return this.startDate;
   }
   public String getEndDate() 
   {
      return this.endDate;
   }

   public String toString() 
   {
      StringBuffer strBuf=new StringBuffer();
      strBuf.append(this.pId);strBuf.append("|");
      strBuf.append(this.startDate);strBuf.append("|");
      strBuf.append(this.endDate);
      return strBuf.toString();
   }

    public String getClndr_stat_gbl()
    {
        return clndr_stat_gbl;
    }

    public void setClndr_stat_gbl(String newClndr_stat_gbl)
    {
        clndr_stat_gbl = newClndr_stat_gbl;
    }

    public String getClndr_opn_ind_gbl()
    {
        return clndr_opn_ind_gbl;
    }

    public void setClndr_opn_ind_gbl(String newClndr_opn_ind_gbl)
    {
        clndr_opn_ind_gbl = newClndr_opn_ind_gbl;
    }
}