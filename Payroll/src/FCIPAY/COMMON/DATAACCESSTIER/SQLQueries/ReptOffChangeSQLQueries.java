package FCIPAY.COMMON.DATAACCESSTIER.SQLQueries;

public class ReptOffChangeSQLQueries 
{
  //  public static final String GET_EMPNAME="SELECT A.EMP_FIRST_NAME || ' ' || A.EMP_MIDDLE_NAME || ' ' || A.EMP_LAST_NAME EMPLOYEE "
  //                                            +"FROM PAY_EMP_MAST A "
  //                                           +"WHERE A.EMP_NUM = ?";
  
  public static final String GET_EMPNAME="select a.loc_id, b.loc_desc from sysadmin_user_loc a, com_loc_mst b where EMP_NO = ? and a.loc_id = b.loc_id and a.loc_stat_flg = 'A'";

    public static final String GET_COUNT="select count(b.emp_no) as numb from  hrm_employee b where b.emp_rep_id=?";                                             
    public static final String UPDATE_REPTOFF="update hrm_employee e set e.emp_rep_id=?,e.modified_user_id=?,e.modified_site_id=?,e.modified_time_stmp=sysdate where e.emp_rep_id=? and e.emp_no!=? ";

    public static final String GET_EMP_INFO="select e.emp_no,e.emp_fst_name ||' '|| e.emp_mdl_name ||' '|| e.emp_lst_name emp_name ,g.grade_desc,s.sect_name,e.emp_grp "
                                              +"from hrm_employee e ,hrm_grade_mast g,hrm_sect_mast s "
                                              +"where e.emp_rep_id=? and e.emp_grade_id=g.grade_id and e.emp_sect_id=s.sect_id order by emp_no";
}