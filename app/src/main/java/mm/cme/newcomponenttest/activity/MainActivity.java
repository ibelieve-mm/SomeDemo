package mm.cme.newcomponenttest.activity;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import mm.cme.newcomponenttest.R;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private MainActivity _activity;

    @AfterViews
    void onPageStart() {
        _activity = this;
    }

    @Click(R.id.acBtn_constraintLayout)
    void acBtn_constraintLayoutClick() {
        _000_ConstraintLayoutActivity_.intent(_activity).start();
    }

    @Click(R.id.acBtn_rippleView)
    void acBtn_rippleViewClick() {
        _001_CustomUIRippleViewActivity_.intent(_activity).start();
    }

    @Click(R.id.acBtn_collapsingToolbarLayout)
    void acBtn_collapsingToolbarLayoutClick() {
        _002_CollapsingToolbarLayout_.intent(_activity).start();
    }
}
