package FCIPAY.COMMON.DATAACCESSTIER.SQLQueries;

public class ReportingOfficerScreenAccessQueries 
{
    public static final String UPDATE_ACCESS= "INSERT INTO SYSADMIN_EMP_SCREEN_MAP R (R.SCREEN_EMP_ID,R.SCREEN_ID,R.EMP_NO,R.CREATED_USER,R.CREATED_SITE,R.CREATED_DATE,R.LOC_ID) "
                                        +"VALUES (GET_ID(?,'SYSADMIN_EMP_SCREEN_MAP'),?,?,?,?,SYSDATE,?) ";
}