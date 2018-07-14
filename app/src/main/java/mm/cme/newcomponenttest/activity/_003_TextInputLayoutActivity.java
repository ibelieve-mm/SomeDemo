package mm.cme.newcomponenttest.activity;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/14
 * Email：ibelieve1210@163.com
 */

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import mm.cme.newcomponenttest.R;

@EActivity(R.layout.activity_003_text_input_layout)
public class _003_TextInputLayoutActivity extends AppBaseActivity {

    @ViewById(R.id.til_account)
    TextInputLayout til_account;
    @ViewById(R.id.til_password)
    TextInputLayout til_password;

    private EditText et_account;
    private EditText et_password;


    private _003_TextInputLayoutActivity _activity;

    @AfterViews
    void onPageStart() {
        _activity = this;
        initView();
    }

    private void initView() {

        //通过getEditText()方法来获取EditText控件
        et_account = til_account.getEditText();
        et_password = til_password.getEditText();

        et_account.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 3) {
                    //显示错误提示
                    til_account.setError("用户名不合法！");
                    til_account.setErrorEnabled(true);
                } else {
                    til_account.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Click(R.id.btn_login)
    void btn_loginClick(View view) {
        Snackbar.make(view, "登陆成功！", Snackbar.LENGTH_SHORT)
//                .setAction("撤销", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        Toast.makeText(Main2Activity.this, "撤销了删除", Toast.LENGTH_SHORT).show();
//
//                    }
//                })
                .show();
    }
}