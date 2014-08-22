package com.renatoalmeida.db;

import java.util.Date;

import android.provider.BaseColumns;

public final class StatsContract {

    public StatsContract() {}

    public static abstract class StatsEntry implements BaseColumns {
        public static final String TABLE_NAME = "IngressStats";
        public static final String COLUMN_NAME_STATS_ID = "StatsID"; //This will be the timestamp

        //check the rest on StatsResources.statsOrder
        
    }
}
