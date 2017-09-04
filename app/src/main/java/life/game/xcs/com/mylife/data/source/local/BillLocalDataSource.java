package life.game.xcs.com.mylife.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.text.SimpleDateFormat;
import java.util.List;

import life.game.xcs.com.mylife.data.Bill;
import life.game.xcs.com.mylife.data.source.BillDataSource;
import life.game.xcs.com.mylife.util.schedulers.BaseSchedulerProvider;
import rx.Observable;
import rx.functions.Func1;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xcs on 2017/8/31 0031.
 */

public class BillLocalDataSource implements BillDataSource{

    @Nullable
    private static BillLocalDataSource INSTANCE;

    @Nullable
    private final BriteDatabase mDatabaseHelper;

    @Nullable
    private Func1<Cursor, Bill> mBillMapperFunction;

    private BillLocalDataSource (@NonNull Context context,
                                 @NonNull BaseSchedulerProvider schedulerProvider){
        checkNotNull(context,"context cannot be null");
        checkNotNull(schedulerProvider, "scheduleProvider cannot be null");
        BillDbHelper dbHelper = new BillDbHelper(context);
        SqlBrite sqlBrite = SqlBrite.create();
        mDatabaseHelper = sqlBrite.wrapDatabaseHelper(dbHelper, schedulerProvider.io());
        mBillMapperFunction = this::getBill;
    }

public static BillLocalDataSource getInstance(@NonNull Context context, @NonNull BaseSchedulerProvider schedulerProvider){
        if (INSTANCE == null){
            INSTANCE = new BillLocalDataSource(context, schedulerProvider);
        }
        return INSTANCE;
}

public static void destroyInstance(){
    INSTANCE = null;
}

    @Override
    public Observable<List<Bill>> getBills() {
       String[] projection = {
               BillPersistenceContract.BillEntry.COLUMN_NAME_ENTRY_ID,
               BillPersistenceContract.BillEntry.COLUMN_NAME_ACCOUNT,
               BillPersistenceContract.BillEntry.COLUMN_NAME_DATE,
               BillPersistenceContract.BillEntry.COLUMN_NAME_DESCRIPTION,
               BillPersistenceContract.BillEntry.COLUMN_NAME_MEMBER,
               BillPersistenceContract.BillEntry.COLUMN_NAME_MONEY,
               BillPersistenceContract.BillEntry.COLUMN_NAME_TITLE,
               BillPersistenceContract.BillEntry.COLUMN_NAME_TYPE
       };
       String sql = String.format("SELECT %s FROM %s", TextUtils.join(",", projection), BillPersistenceContract.BillEntry.TABLE_NAME);
       return mDatabaseHelper.createQuery(BillPersistenceContract.BillEntry.TABLE_NAME, sql)
               .mapToList(mBillMapperFunction);
    }

    @Override
    public Observable<Bill> getBill(@NonNull String billId) {
         String sql = String.format("SELECT * FROM %s WHERE %s = ?",
                 BillPersistenceContract.BillEntry.TABLE_NAME, BillPersistenceContract.BillEntry.COLUMN_NAME_ENTRY_ID);
         return mDatabaseHelper.createQuery(BillPersistenceContract.BillEntry.TABLE_NAME, sql, billId)
                 .mapToOneOrDefault(mBillMapperFunction, null);
    }

    @NonNull
    public Bill getBill(@NonNull Cursor c){
       String itemId = c.getString(c.getColumnIndexOrThrow(BillPersistenceContract.BillEntry.COLUMN_NAME_ENTRY_ID));
       String title = c.getString(c.getColumnIndexOrThrow(BillPersistenceContract.BillEntry.COLUMN_NAME_TITLE));
       String description = c.getString(c.getColumnIndexOrThrow(BillPersistenceContract.BillEntry.COLUMN_NAME_DESCRIPTION));
       String type = c.getString(c.getColumnIndexOrThrow(BillPersistenceContract.BillEntry.COLUMN_NAME_TYPE));
       Float money = c.getFloat(c.getColumnIndexOrThrow(BillPersistenceContract.BillEntry.COLUMN_NAME_MONEY));
       String member = c.getString(c.getColumnIndexOrThrow(BillPersistenceContract.BillEntry.COLUMN_NAME_MEMBER));
       String account = c.getString(c.getColumnIndexOrThrow(BillPersistenceContract.BillEntry.COLUMN_NAME_ACCOUNT));
       String dateTime = c.getString(c.getColumnIndexOrThrow(BillPersistenceContract.BillEntry.COLUMN_NAME_DATE));
       return new Bill(itemId,type,title,money,dateTime,account,member,description);
    }

    @Override
    public void saveBill(@NonNull Bill bill) {
        checkNotNull(bill);
        ContentValues values = new ContentValues();
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_ENTRY_ID, bill.getId());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_TITLE, bill.getTitle());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_ACCOUNT, bill.getAccount());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_DATE, bill.getDate());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_DESCRIPTION, bill.getDescription());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_MONEY, bill.getMoney());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_TYPE, bill.getType());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_MEMBER, bill.getMember());
        mDatabaseHelper.insert(BillPersistenceContract.BillEntry.TABLE_NAME, values, SQLiteDatabase.CONFLICT_REPLACE);
    }

    @Override
    public void deleteBill(@NonNull String billId) {
        String selection = BillPersistenceContract.BillEntry.COLUMN_NAME_ENTRY_ID + "= ?";
        String[] selectionArgs = {billId};
        mDatabaseHelper.delete(BillPersistenceContract.BillEntry.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public void updateBill(Bill bill) {
        String selection = BillPersistenceContract.BillEntry.COLUMN_NAME_ENTRY_ID + "= ?";
        checkNotNull(bill);
        ContentValues values = new ContentValues();
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_TITLE, bill.getTitle());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_ACCOUNT, bill.getAccount());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_DATE, bill.getDate());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_DESCRIPTION, bill.getDescription());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_MONEY, bill.getMoney());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_TYPE, bill.getType());
        values.put(BillPersistenceContract.BillEntry.COLUMN_NAME_MEMBER, bill.getMember());
        mDatabaseHelper.update(BillPersistenceContract.BillEntry.TABLE_NAME, values, selection, bill.getId() );
    }
}
