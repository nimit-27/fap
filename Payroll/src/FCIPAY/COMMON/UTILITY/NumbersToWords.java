package FCIPAY.COMMON.UTILITY;
import org.apache.commons.lang.StringUtils;
public class NumbersToWords  {

    final static String[] units = {""   ,"One"    ,"Two"      ,"Three"   ,"Four",
                                   "Five","Six"    ,"Seven"    ,"Eight"   ,"Nine",
                                    "Ten","Eleven" ,"Twelve"   ,"Thirteen","Fourteen",
                                "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    final static String[] tens =  {""   , ""      ,"Twenty"   ,"Thirty"  ,"Forty" ,
                                  "Fifty","Sixty"  ,"Seventy"  ,"Eighty"  ,"Ninety"};

    private static String twoDigits(String no) {                       
        int k=Integer.parseInt(no);
        //if 21 means
        int    u =  k % 10;             // 1       
        int    tu=  k % 100;                   
        int    t = (tu-u) / 10;        // 2
        String result=(tu < 20) ? units[tu] : tens [t] + ( u > 0 ? " " : "") + units[u];  
        return result;
    }

    private static String threeDigits(String no) {
        int k=Integer.parseInt(no);
        // if 123
        int    u =  k % 10;             //3       
        int    c =  k / 100;            //1       
        int    tu=  k % 100;                   
        int    t = (tu-u) / 10;         //2
        String result = (c == 0)  ? "" : units[c] + " Hundred" + (tu > 0 ? " And " : "");
 
        return result += (tu < 20) ? units[tu] : tens [t] + ( u > 0 ? " " : "") + units[u];
    }

    private static String numbersToWordsRegular(String noToConv1) {
        long no=Math.abs(Long.parseLong(noToConv1));
        String noToConv=String.valueOf(no);
        String retStr="";
        String Crore="";
        String Lakh="";
        String Thousand="";
        String Hundred="";

        if(no>0) {
            if(no>=1 && no<=99)
                retStr=twoDigits(noToConv) + " Only";
            else if(no>=100 && no<=999)       
                retStr=threeDigits(noToConv) + " Only";
            else if(no>=1000 && no<=99999) { 
                if(noToConv.length()==4) {
                    Thousand=twoDigits(noToConv.substring(0,1)) + " Thousand ";
                    if((Hundred=threeDigits(noToConv.substring(1))).equals(""))
                        Hundred+="Only";
                    else
                        Hundred+=" Only";
                }
                else {
                    Thousand=twoDigits(noToConv.substring(0,2)) + " Thousand ";
                    if((Hundred=threeDigits(noToConv.substring(2))).equals(""))
                        Hundred+="Only";
                    else
                        Hundred+=" Only";
                }
                retStr= Thousand + Hundred;
            }
            else if(no>=100000 && no<=9999999) {       
                if(noToConv.length()==6) {
                    Lakh=twoDigits(noToConv.substring(0,1)) + " Lakh ";
                    Thousand=twoDigits(noToConv.substring(1,3));
                    if(!"".equals(Thousand))
                        Thousand += " Thousand ";
                    if((Hundred=threeDigits(noToConv.substring(3))).equals(""))
                        Hundred+="Only";
                    else
                        Hundred+=" Only";
                }
                else {
                    Lakh=twoDigits(noToConv.substring(0,2)) + " Lakh ";
                    Thousand=twoDigits(noToConv.substring(2,4));
                    if(!"".equals(Thousand))
                        Thousand += " Thousand ";
                    if((Hundred=threeDigits(noToConv.substring(4))).equals(""))
                        Hundred+="Only";
                    else
                        Hundred+=" Only";
                }
                retStr= Lakh + Thousand + Hundred;
            }
            
        }
        return retStr;
    }

    public static String toWords(String noToConvert1) {
        boolean isCrore=false;
        String retStr="";
        int countNeg=StringUtils.countMatches(noToConvert1,"-");
        if (countNeg==1)
          noToConvert1=String.valueOf(Math.abs(Long.parseLong(noToConvert1)));
        int countDec=StringUtils.countMatches(noToConvert1,".");
        String[] retStr1=new String[2];
        String noToConvert="";
        String noToConvert2="";
        if(countDec==1) {
            retStr1=StringUtils.split(noToConvert1,".");
            noToConvert=retStr1[0];
            noToConvert2=retStr1[1];
            if(noToConvert2.length()<2)
                noToConvert2+="0";
            if(Long.parseLong(noToConvert2)==0)
                noToConvert2="";
        }
        else if(countDec<=0) {
            noToConvert=noToConvert1;
        }
        else if(countDec>1) {
            return noToConvert;
        }
        if(noToConvert.length()>7)
            isCrore=true;
        if(isCrore) {
            String last7=noToConvert.substring(noToConvert.length()-7);
            String restOfLast7=noToConvert.substring(0,(noToConvert.length()-7));
            String Crore=numbersToWordsRegular(restOfLast7);
            if(StringUtils.countMatches(Crore,"Only")>0) {
                Crore=Crore.substring(0,Crore.length()-4);
                if(Crore.charAt(Crore.length()-1)!=' ')
                    Crore += " ";
                Crore += "Crore ";
            }
            else {
                if(Crore.charAt(Crore.length()-1)!=' ')
                    Crore += " ";
                Crore += "Crore ";
            }
            retStr=Crore + numbersToWordsRegular(last7);
        }
        else {
             retStr=numbersToWordsRegular(noToConvert);
        }
        if(!"".equals(noToConvert2)) {
            retStr=StringUtils.replaceOnce(retStr,"Only","Rupees ");
            retStr += numbersToWordsRegular(noToConvert2);
            retStr = StringUtils.replaceOnce(retStr,"Only","Paise ");
            retStr += "Only";
        }
        return retStr;
    }

/*   public static void main(String[] args) {
//        DateUtilities d=new DateUtilities();
//        d.dateDiff("12/12/2003","18/12/2003");
//        d.getSysDate();
        System.out.println("1="+toWords("1"));
        System.out.println("12="+toWords("12"));
        System.out.println("23="+toWords("23"));
        System.out.println("34="+toWords("34"));
        System.out.println("45="+toWords("45"));
        System.out.println("56="+toWords("5..6"));
        System.out.println("67="+toWords("67"));
        System.out.println("78="+toWords("78"));
        System.out.println("89="+toWords("89"));
        System.out.println("90="+toWords("90"));
        System.out.println("100="+toWords("100"));
        System.out.println("111="+toWords("111"));
        System.out.println("222="+toWords("222"));
        System.out.println("333="+toWords("333"));
        System.out.println("444="+toWords("444"));
        System.out.println("555="+toWords("555"));
        System.out.println("666="+toWords("666"));
        System.out.println("777="+toWords("777"));
        System.out.println("888="+toWords("888"));
        System.out.println("999="+toWords("999"));
        System.out.println("1000="+toWords("1000"));
        System.out.println("1234="+toWords("1234"));
        System.out.println("5678="+toWords("5678"));
        System.out.println("9012="+toWords("9012"));
        System.out.println("9102="+toWords("9102"));
        System.out.println("10000="+toWords("10000"));
        System.out.println("12341="+toWords("12341"));
        System.out.println("56782="+toWords("56782"));
        System.out.println("90123="+toWords("90123"));
        System.out.println("91024="+toWords("91024"));
        System.out.println("100000="+toWords("100000"));
        System.out.println("123412="+toWords("123412"));
        System.out.println("5678233="+toWords("5678233"));
        System.out.println("901234="+toWords("901234"));
        System.out.println("9102459="+toWords("9102459"));
        
        System.out.println("---------------------------------------------------------------------");
                System.out.println("1000000="+toWords("1000000"));
        System.out.println("12341209="+toWords("12341209"));
        System.out.println("5678233098="+toWords("5678233098"));
        System.out.println("9012340987="+toWords("9012340987"));
        System.out.println("910245909876="+toWords("910245909876"));
         System.out.println("91024590987654="+toWords("91024590987654"));
         System.out.println("91594.1="+toWords("91594.1"));
         System.out.println("91594.01="+toWords("91594.01"));
         System.out.println("91594.0="+toWords("91594.0"));
         System.out.println("91594.0="+toWords("100024485"));
    }*/

    /*
             else if(no>=10000000 && no<=999999999) {       
                if(noToConv.length()==8) {
                    Crore=twoDigits(noToConv.substring(0,1)) + " Crore ";
                    Lakh=twoDigits(noToConv.substring(1,3));
                    if(!"".equals(Lakh))
                        Lakh += " Lakh ";
                    Thousand=twoDigits(noToConv.substring(3,5));
                    if(!"".equals(Thousand))
                        Thousand += " Thousand ";
                    if((Hundred=threeDigits(noToConv.substring(5))).equals(""))
                        Hundred+="Only";
                    else
                        Hundred+=" Only";
                }
                else {
                    Crore=twoDigits(noToConv.substring(0,2)) + " Crore ";
                    Lakh=twoDigits(noToConv.substring(2,4));
                    if(!"".equals(Lakh))
                        Lakh += " Lakh ";
                    Thousand=twoDigits(noToConv.substring(4,6));
                    if(!"".equals(Thousand))
                        Thousand += " Thousand ";
                    if((Hundred=threeDigits(noToConv.substring(6))).equals(""))
                        Hundred+="Only";
                    else
                        Hundred+=" Only";
                }
                retStr= Crore + Lakh + Thousand + Hundred;                    
            }

     */
}