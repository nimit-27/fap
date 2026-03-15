package  FCIPAY.Payroll.DATAACCESSTIER.SQLQueries;

public class UploadSQLQueries  
{
    //OnLoad Queries
    public static final String sql_chkValidAccLoc="select loc_id from com_loc_mst where loc_id=? and (gl_inst_site='Y' or gl_inst_site='y')";
    public static final String sql_getAccCode="select acct_id,shrt_code from fin_acct_mst where ACCT_STATUS='A' and cb_acct_flg='B' order by acct_id";

    //Before Uploading Delete Query
    public static final String sql_selPrevValues="select * from FIN_BNK_TMP_TXN where LOC_ID=? and ACCT_ID=?";
    public static final String sql_delPrevValues="delete from FIN_BNK_TMP_TXN where LOC_ID=? and ACCT_ID=?";

    //Before Uploading Check the Payment&Receipt type and Instrument Type
    public static final String sql_chkPayRcptType="select mst.gbl_type,det.code_sdesc from com_gbl_mst mst,com_gbl_dtl det where mst.gbl_type= det.gbl_type and mst.gbl_type='PMTRCTTYPE'";
    public static final String sql_chkInstrType="select mst.gbl_type,det.code_sdesc from com_gbl_mst mst,com_gbl_dtl det where mst.gbl_type = det.gbl_type and mst.gbl_type='FINSTRTYPE'";

    //Upload Queries
    public static final String sql_saveUploadDtls="insert into fin_bnk_tmp_txn(loc_id,acct_id,pmt_rct_mode,pmt_rct_type,instr_no,instr_dt,bank_ack_dt,instr_amt) values(?,?,?,?,?,?,?,?)";

    //Upload Queries
    public static final String sql_saveData="insert into fin_bnk_tmp_txn(loc_id,acct_id,pmt_rct_mode,pmt_rct_type,instr_no,instr_dt,bank_ack_dt,instr_amt) values(?,?,?,?,?,?,?,?)";
    
}