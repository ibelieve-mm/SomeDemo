package mm.cme.newcomponenttest.activity;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/13
 * Email：ibelieve1210@163.com
 */

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import mm.cme.newcomponenttest.R;

@EActivity(R.layout.activity_002_collapsing_toolbar_layout)
public class _002_CollapsingToolbarLayout extends AppCompatActivity {

    private _002_CollapsingToolbarLayout _activity;

    @AfterViews
    void onPageStart() {
        _activity = this;

        //给页面设置工具栏
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置工具栏标题
        CollapsingToolbarLayout collapsingToolbar =  findViewById(R.id.ctl);
        collapsingToolbar.setTitle("可折叠的MD风格ToolbarLayout");
    }
}
