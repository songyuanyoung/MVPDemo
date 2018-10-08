package veoride.com.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener{
    public static final String USERNAME = "zachzachzach";
    public static final String PASSWORD = "1234567890";

    private MainPresenter mainPresenter;
    private EditText userNameEv;
    private EditText passwordEv;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEv = (EditText) findViewById(R.id.user_name);
        passwordEv = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(this);

        mainPresenter = new MainPresenter();
        mainPresenter.register(this);
    }

    @Override
    public void onLoginSuccess() {
        Log.d(MainActivity.class.getSimpleName(), "login successful");
    }

    @Override
    public void onLoginFail(String msg) {
        Log.d(MainActivity.class.getSimpleName(), "login failed" + msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                String userName = userNameEv.getText().toString();
                String password = passwordEv.getText().toString();
                mainPresenter.login(userName, password);
        }
    }
}
