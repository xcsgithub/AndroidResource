package life.game.xcs.com.mylife.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by xcs on 2017/8/31 0031.
 */

public final class BillPersistenceContract {

    private BillPersistenceContract(){}

    public static abstract class BillEntry implements BaseColumns {
        public static final String TABLE_NAME = "bill";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_MONEY = "money";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_ACCOUNT = "account";
        public static final String COLUMN_NAME_MEMBER = "member";

    }

}
