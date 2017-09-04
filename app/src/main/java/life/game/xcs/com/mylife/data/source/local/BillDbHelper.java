package life.game.xcs.com.mylife.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xcs on 2017/8/31 0031.
 */

public class BillDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Bill.db";

    private static final String TEXT_TYPE = "TEXT";

    private static final String BOOLEAN_TYPE = "INTEGER";

    private static final String FLOAT_TYPE = "REAL";

    private static final String DATE_TYPE = "TEXT";

    private static final String CMOMA_SEP = ",";

    private static final String SQL_CREATE_ENTERS = "CREATE TABLE " +
            BillPersistenceContract.BillEntry.TABLE_NAME + " (" +
            BillPersistenceContract.BillEntry._ID + TEXT_TYPE + "PRIMARY KEY," +
            BillPersistenceContract.BillEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + CMOMA_SEP +
            BillPersistenceContract.BillEntry.COLUMN_NAME_TITLE + TEXT_TYPE + CMOMA_SEP +
            BillPersistenceContract.BillEntry.COLUMN_NAME_ACCOUNT + TEXT_TYPE + CMOMA_SEP +
            BillPersistenceContract.BillEntry.COLUMN_NAME_DATE + DATE_TYPE + CMOMA_SEP +
            BillPersistenceContract.BillEntry.COLUMN_NAME_MEMBER + TEXT_TYPE + CMOMA_SEP +
            BillPersistenceContract.BillEntry.COLUMN_NAME_TYPE + TEXT_TYPE + CMOMA_SEP +
            BillPersistenceContract.BillEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + CMOMA_SEP +
            BillPersistenceContract.BillEntry.COLUMN_NAME_MONEY + FLOAT_TYPE +
            ")";

    public BillDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
             db.execSQL(SQL_CREATE_ENTERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
