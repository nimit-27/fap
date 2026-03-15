
/*
 * Program Name : ProblemDescQueries.java
 * Author       : Jegan.V
 * Date Written : 24/05/2004
 * Description  : This is the list of queries that are for screen access
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.SQLQueries;

public class ProblemDescQueries 
{
    public static final String sql_SaveProblemDtls="insert into sysadmin_problem_report(probelm_rep_id,screen_name,problem_desc,error_cause,created_user,created_site,created_date) "
                                                        + " values(get_id(?,'sysadmin_problem_report'),?,?,?,?,?,sysdate)";
}