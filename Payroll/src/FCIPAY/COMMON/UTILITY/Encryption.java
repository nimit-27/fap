/*
 * Program Name : Encryption .java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Class for the Change password screen
 *			It does Encoding and Decoding the passwords
 *
*/


package FCIPAY.COMMON.UTILITY;

import java.io.IOException;
import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Encryption 
{
    /**
     * Encoding the Password by doing the following steps
     *   1) Changing each of the character to Ascii value
     *   2) It checks whether it is in what position whether odd or even
     *      (i)If Even
     *          Add 4 to the ASCII value
     *          Subtract the position of the character to that value
     *          Convert into Hexa value.
     *     (ii)If Odd
     *          Add 4 to the ASCII value
     *          Subtract the result with the result obtained by
     *              (subtracting the position of the character with 1 and 
     *               divide by 2 and multiply the result with 6)
     *          Convert into Hexa value.
     *   3) Do it for all the characters and store it
     */
    public String encodePassword(String password) 
    {
        String retVal="";
        char c;
        int num=0;
        for (int i=0;i<password.length();i++) 
        {
            c=password.charAt(i);//taking character by character
            num = (int)c;//getting the ascii value of that character
            if (i%2==0) //for even
                retVal = retVal+Integer.toHexString(num + 4 - i);
            else //for odd
                retVal = retVal+Integer.toHexString(num + 4 - (((i - 1) / 2) * 6)); 
        }
        return retVal;
    } 


    /**
     * Decoding the Password by doing the following steps
     *   1) Take first 2 characters from Hexa to the number
     *   2) Keep one varaible j and increment every time within the loop.
     *      (i)If j is Even
     *          Subtract 4 to the ASCII value
     *          Add the position of the character to that value
     *          Convert into Char value.
     *     (ii)If j is Odd
     *          Subtract 4 to the ASCII value
     *          Add the result with the result obtained by
     *              (subtracting the position of the character with 1 and 
     *               divide by 2 and multiply the result with 6)
     *          Convert into Hexa value.
     *   3) Do it for all the characters and store it
     */

    public String decodePassword(String password) 
    {
        String retVal="";
        int num,j=0;
        String temp;
        for(int i=0;i<password.length();i+=2) 
        {
            temp=password.charAt(i)+""+password.charAt(i+1);//taking 2 characters from the encoded password
            num=Integer.parseInt(temp,16);//getting the number from Hexadecimal value
            if(j%2==0)  //for even
                retVal=retVal+((char)(num-4+j))+"";
            else  //for odd
                retVal=retVal+((char)(num-4+(((j-1)/2)*6)))+"";
            j=j+1;
        }
        return retVal;
    }

    /**
     * Encode a string using algorithm specified in web.xml and return the
     * resulting encrypted password. If exception, the plain credentials
     * string is returned
     *
     * @param password Password or other credentials to use in authenticating
     *        this username
     * @param algorithm Algorithm used to do the digest
     *
     * @return encypted password based on the algorithm.
     */
    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = password.getBytes();

        MessageDigest md = null;

        try {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
//            log.error("Exception: " + e);
            e.printStackTrace();
            return password;
        }

        md.reset();

        // call the update method one or more times
        // (useful when you don't know the size of your data, eg. stream)
        md.update(unencodedPassword);

        // now calculate the hash
        byte[] encodedPassword = md.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < encodedPassword.length; i++) {
            if (((int) encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }

            buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
        }
        return buf.toString();
    }

    /**
     * Encode a string using Base64 encoding. Used when storing passwords
     * as cookies.
     *
     * This is weak encoding in that anyone can use the decodeString
     * routine to reverse the encoding.
     *
     * @param str
     * @return String
     * @throws IOException
     */
    public static String encodeString(String str) throws IOException {
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        String encodedStr = new String(encoder.encodeBuffer(str.getBytes()));

        return (encodedStr.trim());
    }

    /**
     * Decode a string using Base64 encoding.
     *
     * @param str
     * @return String
     * @throws IOException
     */
    public static String decodeString(String str) throws IOException {
        sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
        String value = new String(dec.decodeBuffer(str));

        return (value);
    }
}