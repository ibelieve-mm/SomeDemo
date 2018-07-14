package mm.cme.newcomponenttest.activity;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/14
 * Email：ibelieve1210@163.com
 */
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import mm.cme.newcomponenttest.R;

@EActivity(R.layout.activity_004_bottom_sheet_behavior)
public class _004_BottomSheetBehaviorActivity extends AppBaseActivity {
    @ViewById(R.id.fl_bottomSheet)
    View fl_bottomSheet;


    private _004_BottomSheetBehaviorActivity _activity;

    private BottomSheetBehavior<View> mBottomSheetBehavior;

    @AfterViews
    void onPageStart() {
        _activity = this;

        initBottomSheetBehavior();
    }

    /**
     * 初始化 BottomSheetBehavior
     */
    private void initBottomSheetBehavior() {

        mBottomSheetBehavior = BottomSheetBehavior.from(fl_bottomSheet);

        // 如果开始就显示一部分内容，可以添加一下两行代码
        mBottomSheetBehavior.setPeekHeight(120); //  app:behavior_peekHeight="60dp"
        mBottomSheetBehavior.setHideable(false); // app:behavior_hideable="false"

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //newState 有5个状态 ：
                //拖动 BottomSheetBehavior.STATE_DRAGGING 1
                //下滑 BottomSheetBehavior.STATE_SETTLING 2
                //展开 BottomSheetBehavior.STATE_EXPANDED 3
                //收起 BottomSheetBehavior.STATE_COLLAPSED 4
                // BottomSheetBehavior.STATE_HIDDEN 5
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //这里是拖拽中的回调，slideOffset为0-1 完全收起为0 完全展开为1
            }
        });
    }

    /**
     * 点击弹出 BottomSheetBehavior
     */
    @Click(R.id.btn_behavior)
    void btnClick() {
        if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    /**
     * 点击弹出 BottomSheetDialog
     */
    @Click(R.id.btn_dialog)
    void btnDialogClick() {
        BottomSheetDialog bsDialog = new BottomSheetDialog(this);
        bsDialog.setContentView(R.layout.item_004_bottom_sheet_behavior);
        bsDialog.show();
    }
}
