package mm.cme.newcomponenttest.activity;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/13
 * Email：ibelieve1210@163.com
 */
import android.graphics.Color;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import mm.cme.newcomponenttest.R;
import mm.cme.newcomponenttest.view._001_RippleView;

@EActivity(R.layout.activity_001_custom_ui_ripple_view)
public class _001_CustomUIRippleViewActivity extends AppBaseActivity {

    @ViewById(R.id.rippleView)
    _001_RippleView rippleView;

    private _001_CustomUIRippleViewActivity _activity;

    @AfterViews
    void onPageStart(){
        _activity = this;

        rippleView.setRippleColor(Color.BLACK);//设置波纹的颜色
        rippleView.setStartDiameter(70);//设置波纹开始出现时的直径140dp
        rippleView.onStart();//开始绘制
    }
}
