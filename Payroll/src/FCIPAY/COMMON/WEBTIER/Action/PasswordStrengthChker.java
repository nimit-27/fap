package FCIPAY.COMMON.WEBTIER.Action;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PasswordStrengthChker 
{
    private Pattern pattern;
    private Matcher matcher;
 
    /**
     * password policy to match 8 characters with alphabets in combination with numbers or special characters
     *
     * (?=.*[a-zA-Z]) means one or more alphabets, it can be small or CAPS
     * (?=.*[0-9@#$%]) means one or more numerals or special characters
     * (?=.*[@#$%]) means one or more special characters
     * {8,} means password length should be minimum 8
     */
   // Commented by abdul on 21/04/2016 to remove special characters. 
   //private String pwd_policy = "((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*!]).{8,})";
    private String pwd_policy = "((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,})";
    public PasswordStrengthChker() {
        pattern = Pattern.compile(pwd_policy);
    }

    /**
     * Verify the validity of the given client password
     * @param password
     * @return boolean if test string passed the password policy or not
     */
    public boolean verify(String password) {
        matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println(password + " matched the regexp");
        } else {
            System.out.println(password + " didnt match the regexp");
        }
        return matcher.matches();
 
    }
  
}