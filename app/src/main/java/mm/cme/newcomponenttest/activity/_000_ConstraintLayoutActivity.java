package mm.cme.newcomponenttest.activity;

/**
 * Descriptions：ConstraintLayout 的使用方式
 * <p>
 * Author：ChenME
 * Date：2018/7/11
 * Email：ibelieve1210@163.com
 *
 * https://www.jianshu.com/p/409a0c2088dd
 */
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import mm.cme.newcomponenttest.R;

@EActivity(R.layout.activity_000_constraint_layout)
public class _000_ConstraintLayoutActivity extends AppBaseActivity {

    private _000_ConstraintLayoutActivity _activity;

    @AfterViews
    void onPageStart(){
        _activity = this;

        setTitle("ConstraintLayout的使用");
    }
}
