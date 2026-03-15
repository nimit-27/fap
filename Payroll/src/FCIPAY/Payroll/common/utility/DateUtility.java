package FCIPAY.Payroll.common.utility;
import java.util.Calendar;
import java.sql.Date;
import java.util.StringTokenizer;

public class DateUtility 
{
 public final int DATE  =1;
    public final int MONTH =2;
    public final int YEAR  =3;

  
    public DateUtility() {}
    
    public String getSysDate() {
        Calendar cal=Calendar.getInstance();
        String sysDate=lPad(String.valueOf(cal.get(cal.DATE)),2)+"/"+lPad(String.valueOf(cal.get(cal.MONTH)+1),2)+"/"+lPad(String.valueOf(cal.get(cal.YEAR)),4);
        cal=null;
        return sysDate;
    }
    
    public int dateDiff(String fromDate,String toDate) {
        Calendar cal=Calendar.getInstance();
        cal.set(Integer.parseInt(this.get(fromDate,this.YEAR)),Integer.parseInt(this.get(fromDate,this.MONTH))-1,Integer.parseInt(this.get(fromDate,this.DATE)));
        long fromDateInMilliSec =cal.getTime().getTime();
        cal.set(Integer.parseInt(this.get(toDate,this.YEAR)),Integer.parseInt(this.get(toDate,this.MONTH))-1,Integer.parseInt(this.get(toDate,this.DATE)));        
        long toDateInMilliSec   =cal.getTime().getTime();
        cal=null;
        if(fromDateInMilliSec==toDateInMilliSec) {
            return 1;
        }
        int noOfDays=Math.abs((int)((toDateInMilliSec-fromDateInMilliSec)/(24*3600*1000)));
        return noOfDays;
    }

public int dateDiff1(String fromDate,String toDate) {
        Calendar cal=Calendar.getInstance();
        cal.set(Integer.parseInt(this.get(fromDate,this.YEAR)),Integer.parseInt(this.get(fromDate,this.MONTH))-1,Integer.parseInt(this.get(fromDate,this.DATE)));
        long fromDateInMilliSec =cal.getTime().getTime();
        cal.set(Integer.parseInt(this.get(toDate,this.YEAR)),Integer.parseInt(this.get(toDate,this.MONTH))-1,Integer.parseInt(this.get(toDate,this.DATE)));        
        long toDateInMilliSec   =cal.getTime().getTime();
        cal=null;
       /* if(fromDateInMilliSec==toDateInMilliSec) {
            return 1;
        }*/
        int noOfDays=Math.abs((int)((toDateInMilliSec-fromDateInMilliSec)/(24*3600*1000)));
        return noOfDays;
    }




    public long dateDiffLong(String fromDate,String toDate) {
        Calendar cal=Calendar.getInstance();
        cal.set(Integer.parseInt(this.get(fromDate,this.YEAR)),Integer.parseInt(this.get(fromDate,this.MONTH))-1,Integer.parseInt(this.get(fromDate,this.DATE)));
        long fromDateInMilliSec =cal.getTime().getTime();
        cal.set(Integer.parseInt(this.get(toDate,this.YEAR)),Integer.parseInt(this.get(toDate,this.MONTH))-1,Integer.parseInt(this.get(toDate,this.DATE)));        
        long toDateInMilliSec   =cal.getTime().getTime();
        cal=null;
        long noOfDaysInSec=(toDateInMilliSec-fromDateInMilliSec)/1000;
        return noOfDaysInSec;
    }

    public int dateGTcurrent(String fromDate,String toDate) {
        Calendar cal=Calendar.getInstance();
        cal.set(Integer.parseInt(this.get(fromDate,this.YEAR)),Integer.parseInt(this.get(fromDate,this.MONTH))-1,Integer.parseInt(this.get(fromDate,this.DATE)));
        long fromDateInMilliSec = cal.getTime().getTime();
        cal.set(Integer.parseInt(this.get(toDate,this.YEAR)),Integer.parseInt(this.get(toDate,this.MONTH))-1,Integer.parseInt(this.get(toDate,this.DATE)));        
        long toDateInMilliSec = cal.getTime().getTime();
        cal=null;
        int noOfDays=(int)((toDateInMilliSec-fromDateInMilliSec)/(24*3600*1000));
        return noOfDays;
    }        
    
    public String get(String inDate,int Type) {
        String[] strArr=new String[4];
        String retVal="";
        strArr=this.getDateArray(inDate);
        switch (Type) {
            case YEAR:
                retVal=lPad(strArr[2],4);
                break;    
            case MONTH:
                retVal=lPad(strArr[1],2);
                break;
            case DATE:
                retVal=lPad(strArr[0],2);
                break;
        }
        return retVal;
    }

    public String reverseFormat(String tDate) {
      String[] strArr=new String[4];
      strArr=this.getDateArray(tDate);
      return (lPad(strArr[1],2)+"/"+lPad(strArr[0],2)+"/"+lPad(strArr[2],4));
    }

    private String lPad (String inStr, int len) {
		int count = len - inStr.length();
		for (int i = 0; i < count; i++) {
			inStr = "0" + inStr;	
		}
		return inStr;
	}

    private String[] getDateArray(String tDate) {
        int j=0;
        StringTokenizer strTok=new StringTokenizer(tDate,"/");
        String[] strArr=new String[4];
        if(strTok.countTokens()<=0) {
            strTok=new StringTokenizer(tDate,"-");
        }
        while(strTok.hasMoreTokens()) {
             strArr[j]=strTok.nextToken();
             j+=1;
        }
        return strArr;
    }

    public long getDateLong(String tDate) {
        Calendar cal=Calendar.getInstance();
        cal.set(Integer.parseInt(this.get(tDate,this.YEAR)),Integer.parseInt(this.get(tDate,this.MONTH))-1,Integer.parseInt(this.get(tDate,this.DATE)));
        return cal.getTime().getTime();
    }

    public long[] months_between(String fromDate,String toDate) {
        long[] retArr=new long[2];
        retArr[0]=-1;
        retArr[1]=-1;
        long noOfDaysInSecs=dateDiffLong(fromDate,toDate);
        double totNoOfDays=noOfDaysInSecs/(24*3600);   
        retArr[0]=(long)Math.floor(totNoOfDays/30);
        retArr[1]=Math.round(totNoOfDays%30);
        return retArr;
    }

    public long[] months_between1(String fromDate,String toDate) {
        long[] retArr=new long[2];
        retArr[0]=-1;
        retArr[1]=-1;
        long noOfDaysInSecs=dateDiffLong(fromDate,toDate);
        double totNoOfDays=noOfDaysInSecs/(24*3600);   
        retArr[0]=(long)Math.floor(totNoOfDays/30.4);
        retArr[1]=Math.round(totNoOfDays%30);
        return retArr;
    }


   public static void main(String[] args) {
        DateUtility d=new DateUtility();
        System.out.println(d.reverseFormat(d.getSysDate()));
        System.out.println(d.dateDiff1("29/11/2003","2/12/2003"));
        System.out.println(d.dateDiff1("29/10/2003","2/11/2003"));
        d.getSysDate();
        long[] retIntArr=d.months_between("12/12/2003","28/12/2003");
        System.out.println(retIntArr[0] + "*****" + retIntArr[1]);
        Date d1=new Date(d.getDateLong("29/11/2003"));
        Date d2=new Date(d.getDateLong("2/12/2003"));
        System.out.println(d1.compareTo(d2));
    }
}