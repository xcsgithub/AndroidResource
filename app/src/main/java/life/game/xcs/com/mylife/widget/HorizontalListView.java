package life.game.xcs.com.mylife.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xcs on 2017/9/4 0004.
 */

public class HorizontalListView extends AdapterView<ListAdapter> {

    public boolean mAlwaysOverrideTouch = true;

    protected ListAdapter mAdapter;

    private int mLeftViewIndex = -1;

    private int mRightViewIndex = 0;

    protected int mCurrentX;
    protected int mNextX;

    private int mMaxX = Integer.MAX_VALUE;
    private int mDisplayOffset = 0;
    protected Scroller mScroller;
    protected GestureDetector mGesture;
    private Queue<View> mRemovedViewQueue = new LinkedList<View>();



    public HorizontalListView(Context context) {
        super(context);
    }

    public HorizontalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private synchronized void initView(){
        mLeftViewIndex = -1;
        mRightViewIndex = 0;
        mDisplayOffset = 0;
        mCurrentX = 0;
        mNextX = 0;
        mMaxX = Integer.MAX_VALUE;
        mScroller = new Scroller(getContext());
    }

    @Override
    public ListAdapter getAdapter() {
        return null;
    }

    @Override
    public void setAdapter(ListAdapter adapter) {

    }

    @Override
    public View getSelectedView() {
        return null;
    }

    @Override
    public void setSelection(int position) {

    }
}
