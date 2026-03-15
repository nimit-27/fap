package FCIPAY.COMMON.UTILITY;

import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class DateUtilities1  {

    public final int DATE  =1;
    public final int MONTH =2;
    public final int YEAR  =3;
    
    public DateUtilities1() {}
    
    public String getSysDate() {
        Calendar cal=Calendar.getInstance();
        String sysDate=lPad(String.valueOf(cal.get(cal.DATE)),2)+"/"+lPad(String.valueOf(cal.get(cal.MONTH)+1),2)+"/"+lPad(String.valueOf(cal.get(cal.YEAR)),4);
        cal=null;
        return sysDate;
    }
    
    public int dateDiff(String fromDate,String toDate) {
        Calendar cal=Calendar.getInstance();
        cal.set(Integer.parseInt(this.get(fromDate,this.YEAR)),Integer.parseInt(this.get(fromDate,this.MONTH)),Integer.parseInt(this.get(fromDate,this.DATE)));
        long fromDateInMilliSec =cal.getTime().getTime();
        cal.set(Integer.parseInt(this.get(toDate,this.YEAR)),Integer.parseInt(this.get(toDate,this.MONTH)),Integer.parseInt(this.get(toDate,this.DATE)));        
        long toDateInMilliSec   =cal.getTime().getTime();
        cal=null;
        if(fromDateInMilliSec==toDateInMilliSec) {
            return 1;
        }
        int noOfDays=(int)((toDateInMilliSec-fromDateInMilliSec)/(24*3600*1000));
        return noOfDays;
    }

    public int dateGTcurrent(String fromDate,String toDate) {
        Calendar cal=Calendar.getInstance();
        cal.set(Integer.parseInt(this.get(fromDate,this.YEAR)),Integer.parseInt(this.get(fromDate,this.MONTH)),Integer.parseInt(this.get(fromDate,this.DATE)));
        long fromDateInMilliSec = cal.getTime().getTime();
        cal.set(Integer.parseInt(this.get(toDate,this.YEAR)),Integer.parseInt(this.get(toDate,this.MONTH)),Integer.parseInt(this.get(toDate,this.DATE)));        
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

/*    public static void main(String[] args) {
        DateUtilities d=new DateUtilities();
//        d.dateDiff("12/12/2003","18/12/2003");
        d.getSysDate();
    }*/

}