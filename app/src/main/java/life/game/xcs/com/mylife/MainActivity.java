package life.game.xcs.com.mylife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_PAGE_HOME = "资产";
    private static final String TAG_PAGE_CITY = "报表";
    private static final String TAG_PAGE_PUBLISH = "";
    private static final String TAG_PAGE_MESSAGE = "理财";
    private static final String TAG_PAGE_PERSON = "更多";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

}
