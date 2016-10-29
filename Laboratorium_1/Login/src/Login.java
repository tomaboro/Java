/**
 * Created by Tomek on 2016-10-12.
 */
public class Login {

    private String login;
    private String password;

    public Login (String _login, String _passwd){
        login = _login;
        password = _passwd;
    }

    public boolean check(String _login, String _passwd){
        if(login.equals(_login) && password.equals(_passwd)) return true;
        else return false;
    }
}
