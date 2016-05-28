package com.example.a10648.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;

/**
 * Created by 10648 on 2016/5/27 0027.
 */
public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register_back)
    ImageView registerBack;
    @BindView(R.id.center_text)
    TextView centerText;
    @BindView(R.id.user_name_edit)
    EditText userNameEdit;
    @BindView(R.id.user_name_clear)
    ImageView userNameClear;
    @BindView(R.id.user_name_error)
    TextView userNameError;
    @BindView(R.id.password_edit)
    EditText passwordEdit;
    @BindView(R.id.password_clear)
    ImageView passwordClear;
    @BindView(R.id.password_error)
    TextView passwordError;
    @BindView(R.id.confirm_password_edit)
    EditText confirmPasswordEdit;
    @BindView(R.id.confirm_password_clear)
    ImageView confirmPasswordClear;
    @BindView(R.id.confirm_password_error)
    TextView confirmPasswordError;
    @BindView(R.id.register_button)
    Button registerButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ButterKnife.bind(this);
        SysApplication.getInstance().addActivity(this);
    }

    @OnClick({R.id.register_back, R.id.center_text, R.id.user_name_edit, R.id.user_name_clear, R.id.user_name_error, R.id.password_edit, R.id.password_clear, R.id.password_error, R.id.confirm_password_edit, R.id.confirm_password_clear, R.id.confirm_password_error, R.id.register_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_back:
                this.finish();
                break;
            case R.id.center_text:
                break;
            case R.id.user_name_edit:
                break;
            case R.id.user_name_clear:
                break;
            case R.id.user_name_error:
                break;
            case R.id.password_edit:
                break;
            case R.id.password_clear:
                break;
            case R.id.password_error:
                break;
            case R.id.confirm_password_edit:
                break;
            case R.id.confirm_password_clear:
                break;
            case R.id.confirm_password_error:
                break;
            case R.id.register_button:
                RegisterUser();
                break;
        }
    }

    public void RegisterUser() {
        if (userNameEdit.getText().toString().trim().equals("")
                || userNameEdit.getText().toString().trim().length() > 20
                || userNameEdit.getText().toString().trim().length() < 4
                ){
            userNameError.setVisibility(View.VISIBLE);
        } else if (passwordEdit.getText().toString().trim().equals("")
                || passwordEdit.getText().toString().trim().length() > 16
                || passwordEdit.getText().toString().trim().length() < 6){
            passwordError.setVisibility(View.VISIBLE);
    }else if (! confirmPasswordEdit.getText().toString().trim().equals(
                passwordEdit.getText().toString().trim()
        )){
            confirmPasswordError.setVisibility(View.VISIBLE);
        }else {
            //没有错误时的处理
            String newusername = userNameEdit.getText().toString();
            String newpassword =Encrypt.md5(passwordEdit.getText().toString());
            String confirmpwd = Encrypt.md5(confirmPasswordEdit.getText().toString());
            RegisterDialogFragment registerDialogFragment = new RegisterDialogFragment();
//            registerDialogFragment.show(getFragmentManager(),"注册中");
            registerDialogFragment.show(getSupportFragmentManager(),"注册中");




        }


    }

    public class RegisterDialogFragment extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.registering).setPositiveButton(R.string.please_wait,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(),"正在注册",Toast.LENGTH_SHORT).show();
                        }
                    });
            return builder.create();

        }
    }
}
