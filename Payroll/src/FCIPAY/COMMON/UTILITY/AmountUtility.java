package FCIPAY.COMMON.UTILITY;
import java.util.StringTokenizer;

public class AmountUtility  {
    public static String putComma(String AmtString) {
        if(AmtString.length()<=3) {
            return AmtString;
        }
        String Value=AmtString;
        int arrSize=(int)Math.ceil((((double)Value.length()-3)/2)+1);
//        System.out.println(arrSize);
        String[] valArr=new String[arrSize];
        String last3=Value.substring((Value.length()-3));
        Value=Value.substring(0,(Value.length()-3));
        valArr[0]=last3;
        int i=1;
        String retStr="";
//        System.out.println(last3 + "---" + Value);       
        while(Value.length()>0) {
            if(Value.length()==1) {
                valArr[i]=Value.substring((Value.length()-1));
                Value=Value.substring(0,(Value.length()-1));
            }
            else {
                valArr[i]=Value.substring((Value.length()-2));
                Value=Value.substring(0,(Value.length()-2));
            }
//            System.out.println(valArr[i] + "---" + Value + "---" + i);
            i++;
        }        
        i=i-1;
        StringBuffer strBuff=new StringBuffer();
        while(i>=0) {
            strBuff.append(valArr[i]);
            strBuff.append(",");
            i--;
        }
//        System.out.println(strBuff.toString() + "---" + strBuff.toString().substring(0,strBuff.length()-1));
        return strBuff.toString().substring(0,strBuff.length()-1);
    }

    public static long removeComma(String AmtString) {
        StringTokenizer strTok=new StringTokenizer(AmtString,",");
        StringBuffer strBuff=new StringBuffer();
        while(strTok.hasMoreTokens()) {
            strBuff.append(strTok.nextToken());
        }
//        System.out.println(strBuff.toString());
        return Long.parseLong(strBuff.toString());
    }
/*    public static void main(String[] args) {
//        AmountUtility amountUtility = new AmountUtility();
        System.out.println(AmountUtility.putComma("270000"));
        System.out.println(AmountUtility.putComma("2700000"));
        System.out.println(AmountUtility.putComma("270000000000000"));
        System.out.println(AmountUtility.putComma("2700000000000000000"));
        System.out.println(AmountUtility.removeComma("2,70,000"));
        System.out.println(AmountUtility.removeComma("27,00,000"));
        System.out.println(AmountUtility.removeComma("27,00,00,00,00,00,000"));
        System.out.println(AmountUtility.removeComma("27,00,00,00,00,00,00,00,000"));
	function putComma(Val) {
    if(Val.length<=3) {
        return Val;
    }
    var Value=Val;
    var arrSize=roundDecimals((Value.length-3)/2)+1;
    var valArr=new Array(arrSize);
    var last3=Value.substring((Value.length-3));
    Value=Value.substring(0,(Value.length-3));
    valArr[0]=last3;
    var i=1;
    var retStr="";
    while(Value.length>0) {
        valArr[i++]=Value.substring((Value.length-2));
        Value=Value.substring(0,(Value.length-2));
//        alert(Val + "---" + valArr[i-1] + "---" + Value);
    }
    i=i-1;
    while(i>=0) {
        retStr=retStr+valArr[i--]+",";
    }
    retStr=retStr.substring(0,retStr.length-1);
//    alert(retStr);
    return retStr;
}
function removeComma(Val) {
    var strArr=Val.split(",");
    var retStr="";
    var size=strArr.length;
    var i=0;
    while(i<size) {
        retStr+=strArr[i++];
    }
    return retStr;
}
    }*/
}