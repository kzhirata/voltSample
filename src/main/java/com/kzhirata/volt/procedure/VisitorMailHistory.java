package com.kzhirata.volt.procedure;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class VisitorMailHistory extends VoltProcedure {

	// potential return codes
	public static final long VOTE_SUCCESSFUL = 0;
	public static final long ERR_INVALID_CONTESTANT = 1;
	public static final long ERR_VOTER_OVER_VOTE_LIMIT = 2;

	public final SQLStmt selectVisitorMailHistoryByLCCode = new SQLStmt(
			"select "
			+ "visitor_name1,"
			+ "title,"
			+ "opendate_first"
			+ " from visitor v"
			+ " join mailhistory m"
			+ " on v.visitor_id = m.visitor_id and v.visitor_lccode = ?"
			+ " order by m.opendate_first desc,v.visitor_id,m.mailhistory_id;");


    public VoltTable[] run(final String lcCode) {
    	voltQueueSQL(selectVisitorMailHistoryByLCCode, lcCode);
        return voltExecuteSQL(true);
    }
    
}
