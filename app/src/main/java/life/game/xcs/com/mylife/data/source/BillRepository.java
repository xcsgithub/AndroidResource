package life.game.xcs.com.mylife.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import life.game.xcs.com.mylife.data.Bill;
import rx.Observable;

/**
 * Created by xcs on 2017/9/1 0001.
 */

public class BillRepository implements BillDataSource{

    @Override
    public Observable<List<Bill>> getBills() {
        return null;
    }

    @Override
    public Observable<Bill> getBill(@NonNull String billId) {
        return null;
    }

    @Override
    public void saveBill(@NonNull Bill bill) {

    }

    @Override
    public void deleteBill(@NonNull String billId) {

    }

    @Override
    public void updateBill(Bill bill) {

    }
}
