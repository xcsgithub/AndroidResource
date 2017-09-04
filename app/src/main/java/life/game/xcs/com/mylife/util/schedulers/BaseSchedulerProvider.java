package life.game.xcs.com.mylife.util.schedulers;

import android.support.annotation.NonNull;

import rx.Scheduler;

/**
 * Created by xcs on 2017/9/1 0001.
 */

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
