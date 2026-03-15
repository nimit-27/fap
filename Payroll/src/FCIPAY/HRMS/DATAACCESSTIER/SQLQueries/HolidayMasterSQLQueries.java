/*
 * Module:        HolidayMasterSQLQueries.java
 * Author:        Prem K. Barai
 * Date Written:  02/06/2004
 * Description:   SQL Queries for the Holiday Master
 * Revision Log  (mm/dd/yy initials description)
 * --------------------------------------------------------
 * mm/dd/yy xxx  What you changed
 */

package FCIPAY.HRMS.DATAACCESSTIER.SQLQueries;

public class HolidayMasterSQLQueries 
{
  public static final String INSERT_HRM_HOLIDAY_MAST = "insert into HRM_HOLIDAY_MAST (HOLIDAY_ID, LOC_CODE, WEEKLY_OFF_1, WEEKLY_OFF_2, CALENDAR_YEAR, CREATED_USER_ID, CREATED_SITE_ID, CREATED_TIME_STMP) values (?, ?, ?, ?, TO_DATE(?, 'YYYY'), ?, ?, SYSDATE)";
  public static final String INSERT_HRM_HOLIDAY_DTL = "insert into HRM_HOLIDAY_DTL (HOLIDAY_DTL_ID, HOLIDAY_MAST_ID, HOLIDAY_DATE, HOLIDAY_CODE_GBL, CREATED_USER_ID, CREATED_SITE_ID, CREATED_TIME_STMP, HOLIDAY_STATUS_FLG) values (get_id(?, 'HRM_HOLIDAY_DTL'), ?, TO_DATE(?,'DD/MM/YYYY'), ?, ?, ?, SYSDATE, ?)";
  public static final String SELECT_HRM_HOLIDAY_MAST_ID = "select get_id(? ,'HRM_HOLIDAY_MAST') as LHOLIDAYMASTID from dual";
  public static final String SELECT_HRM_YEAR_AND_LOCATION = "select a.LOC_SDESC as LOC_SDESC, b.HOLIDAY_ID as HOLIDAY_ID, b.LOC_CODE as LOC_CODE, b.WEEKLY_OFF_1 as WEEKLY_OFF_1, b.WEEKLY_OFF_2 as WEEKLY_OFF_2, TO_CHAR(b.CALENDAR_YEAR,'YYYY') as CALENDAR_YEAR from COM_LOC_MST a, HRM_HOLIDAY_MAST b where a.LOC_ID = b.LOC_CODE";
  public static final String SELECT_DETAIL_PANE = "select HOLIDAY_DTL_ID, HOLIDAY_MAST_ID, HOLIDAY_CODE_GBL, TO_CHAR(HOLIDAY_DATE,'DD/MM/YYYY') as HOLIDAY_DATE, HOLIDAY_STATUS_FLG from HRM_HOLIDAY_DTL";
  public static final String UPDATE_MASTER_PANE = "update HRM_HOLIDAY_MAST set LOC_CODE = ?, WEEKLY_OFF_1 = ?, WEEKLY_OFF_2 = ?, MODIFIED_USER_ID = ?, MODIFIED_SITE_ID = ?, MODIFIED_TIME_STMP = SYSDATE where HOLIDAY_ID = ?" ;
  public static final String UPDATE_DETAIL_PANE = "update HRM_HOLIDAY_DTL set HOLIDAY_DATE = TO_DATE(?,'DD/MM/YYYY'), HOLIDAY_CODE_GBL = ?, MODIFIED_USER_ID = ?, MODIFIED_SITE_ID = ?, MODIFIED_TIME_STMP = SYSDATE, HOLIDAY_STATUS_FLG = ? where HOLIDAY_DTL_ID = ? AND HOLIDAY_MAST_ID = ?";
  public static final String SELECT_HOLIDAYS = "SELECT A.HOLIDAY_DTL_ID, TO_CHAR(A.HOLIDAY_DATE, 'DD/MM/YYYY') AS HOLIDAY_DATE, B.CODE_DESC FROM HRM_HOLIDAY_DTL A, COM_GBL_DTL B, HRM_HOLIDAY_MAST C" +
                                                 " WHERE A.HOLIDAY_CODE_GBL = B.GBL_CODE AND C.LOC_CODE = ? AND A.HOLIDAY_MAST_ID = C.HOLIDAY_ID AND" +
                                                 " SUBSTR(TO_CHAR(A.HOLIDAY_DATE, 'DD/MM/YYYY'), 7, 4) = SUBSTR(TO_CHAR(SYSDATE, 'DD/MM/YYYY'), 7, 4) ORDER BY TO_DATE(HOLIDAY_DATE, 'DD/MM/YYYY')";
  public static final String GET_GBLDTLS_FOR_CODE="SELECT DT.GBL_CODE AS GCODE, DT.CODE_DESC AS GDESC, DT.GBL_TYPE AS GTYPE  FROM COM_GBL_DTL DT WHERE DT.GBL_TYPE LIKE ?";
  public static final String GET_UNIT_DETAILS="SELECT LOC_ID, L.LOC_DESC LOC_SDESC, l.loc_type_gbl  FROM COM_LOC_MST L WHERE loc_type_gbl NOT IN ('LOCTYPE$DEP','LOCTYPE$ZO') ORDER BY L.LOC_DESC";
}