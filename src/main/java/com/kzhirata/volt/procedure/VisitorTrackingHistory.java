package com.kzhirata.volt.procedure;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class VisitorTrackingHistory extends VoltProcedure {

	// potential return codes
	public static final long VOTE_SUCCESSFUL = 0;
	public static final long ERR_INVALID_CONTESTANT = 1;
	public static final long ERR_VOTER_OVER_VOTE_LIMIT = 2;

	public final SQLStmt selectVisitorTrackingHistoryByLCCode = new SQLStmt(
			"select "
			+ "visitor_name1,"
			+ "title,"
			+ "create_date"
			+ " from visitor v"
			+ " join trackinghistory t"
			+ " on v.visitor_id = t.visitor_id and v.visitor_lccode = ?"
			+ " order by t.create_date desc,v.visitor_id,t.trackinghistory_id;");


    public VoltTable[] run(final String lcCode) {
    	voltQueueSQL(selectVisitorTrackingHistoryByLCCode, lcCode);
        return voltExecuteSQL(true);
    }
    
}
