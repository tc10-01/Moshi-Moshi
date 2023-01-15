package Login;

import Entity.User;

public class LoginController {
    private String username;
    private String password;
    private LoginUseCase loginUseCase;

    public LoginController(String username, String password){
        this.username = username;
        this.password = password;
        this.loginUseCase = new LoginUseCase(username, password);
    }

    public boolean checkUser(){
        return loginUseCase.checkUser();
    }

    public User getUser(){
        return loginUseCase.getUser();
    }


}
