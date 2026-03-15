package FCIPAY.COMMON.DATAACCESSTIER.SQLQueries;

public class SysadminEmpGrpQueries 
{
  public static final String sValuesQuery="select DISTINCT(grp_sdesc) grp_sdesc from sysadmin_grp_mst where loc_id=?";
  public static final String sDescQuery1="select a.grp_desc grp_desc,b.code_desc code_desc from sysadmin_grp_mst a,com_gbl_dtl b where a.module_gbl=b.gbl_code and a.grp_sdesc=?";
}


 