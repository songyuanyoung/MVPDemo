package veoride.com.mvpdemo;

public class MainPresenter {
    public static final String TAG = MainPresenter.class.getSimpleName();

    private IMainView iMainView;

    public MainPresenter() {
    }

    public void register(IMainView iMainView) {
        this.iMainView = iMainView;
    }

    public void login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            iMainView.onLoginFail("User name and password can't be empty");
        } else if (username.length() < 8 || password.length() < 9) {
            iMainView.onLoginFail("User name has to be more than 8 letters and password has to be more than 9 letters");
        } else if (username.equals(MainActivity.USERNAME)) {
            if (password.endsWith(MainActivity.PASSWORD)) {
                iMainView.onLoginSuccess();
            } else {
                iMainView.onLoginFail("User name and password don't match!");
            }
        }
    }

}
