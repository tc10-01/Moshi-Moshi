package Login;

public class RegisterController {
    String displayName;
    String username;
    String password1;
    String password2;
    private RegisterUseCase registerUseCase;

    public RegisterController(String displayName, String username, String password1, String password2){
        this.displayName = displayName;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        registerUseCase = new RegisterUseCase(displayName, username, password1, password2);

    }

    public String registerUser(){
        return registerUseCase.registerUser();
    }
}
