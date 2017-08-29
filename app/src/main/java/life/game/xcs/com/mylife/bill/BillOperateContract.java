package life.game.xcs.com.mylife.bill;

import life.game.xcs.com.mylife.base.BasePresenter;
import life.game.xcs.com.mylife.base.BaseView;

/**
 * Created by xcs on 2017/8/29 0029.
 */

public interface BillOperateContract {
    interface View extends BaseView<Presenter>{
        void selectedBillType(int type);
       void showBillLine();
       void editBill(int billId);
       void deleteBill(int billId);
       void addBill();
    }

    interface Presenter extends BasePresenter{

    }
}
