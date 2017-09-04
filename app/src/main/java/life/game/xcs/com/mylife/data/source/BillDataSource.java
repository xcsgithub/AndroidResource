package life.game.xcs.com.mylife.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import life.game.xcs.com.mylife.data.Bill;
import rx.Observable;

/**
 * Created by xcs on 2017/8/31 0031.
 */

public interface BillDataSource {

    Observable<List<Bill>> getBills();
    Observable<Bill> getBill(@NonNull String billId);

    void saveBill(@NonNull Bill bill);

    void deleteBill(@NonNull String billId);

    void updateBill(Bill bill);


}
