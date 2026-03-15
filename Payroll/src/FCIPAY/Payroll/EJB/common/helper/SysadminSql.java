package FCIPAY.Payroll.EJB.common.helper;

public class SysadminSql 
{
  public SysadminSql()
  {
  }
 
  public static final String GetDate = "SELECT sysdate FROM dual"; 
  public static final String GlobalCodeHeader = "SELECT * FROM aaa_myself";
  public static final String GlobalCodeHeaderCount =  "SELECT count(*) as counter FROM aaa_myself";
  public static final String GlobalCodeHeaderName  =  "SELECT * FROM aaa_myself WHERE name = ?";
  public static final String GlobalCodeHeaderNameCount = "SELECT count(*) as counter FROM aaa_myself WHERE name = ?";
  public static final String GlobalCodeHeaderSex = "SELECT * FROM aaa_myself WHERE sex = ?";
  public static final String GlobalCodeHeaderNameSex = "SELECT * FROM aaa_myself WHERE name = ? AND sex = ?";
  
}