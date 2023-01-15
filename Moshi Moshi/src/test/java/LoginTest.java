import Login.LoginUseCase;
import Login.RegisterUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {
    //This test checks whether the username exists after creating a user and storing user data.
    @Test
    void CheckUsernameExists() {
        RegisterUseCase sam = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        String status = sam.registerUser();
        LoginUseCase samLogin = new LoginUseCase("samandar", "vijay");
        boolean actual = samLogin.checkUsername();
        Assertions.assertEquals(true, actual);
    }
    //This test checks whether the password matches with the specified username after creating and storing user data.
    @Test
    void CheckPasswordExists(){
        RegisterUseCase shivam = new RegisterUseCase("shiv", "shivam", "pathak",
                "pathak");
        String status = shivam.registerUser();
        LoginUseCase shivamLogin = new LoginUseCase("shivam", "pathak");
        boolean actual = shivamLogin.checkPassword();
        Assertions.assertEquals(true, actual);
    }
    //This test should return false when a wrong username is given after creating and storing user data.
    @Test
    void UsernameDoesNotExist(){
        RegisterUseCase sam = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        String status = sam.registerUser();
        LoginUseCase samLogin = new LoginUseCase("salamandar", "vijay");
        boolean actual = samLogin.checkUsername();
        Assertions.assertEquals(false, actual);
    }
    // This test should return false when a wrong password is given after creating and storing user data.
    @Test
    void PasswordDoesNotExits(){
        RegisterUseCase shivam = new RegisterUseCase("shiv", "shivam", "pathak",
                "pathak");
        String status = shivam.registerUser();
        LoginUseCase shivamLogin = new LoginUseCase("shivam", "shivam");
        boolean actual = shivamLogin.checkPassword();
        Assertions.assertEquals(false, actual);
    }
    // This test returns true when correct username and password are provided after creating and storing user data.
    @Test
    void CheckUserExists(){
        RegisterUseCase sam = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        String status = sam.registerUser();
        LoginUseCase samLogin = new LoginUseCase("samandar", "vijay");
        boolean actual = samLogin.checkUser();
        Assertions.assertEquals(true, actual);
    }

    //This test returns false when incorrect username and password are provided after creating and storing user data.
    @Test
    void UserDoesNotExist(){
        RegisterUseCase sam = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        String status = sam.registerUser();
        LoginUseCase samLogin = new LoginUseCase("evan", "chan");
        boolean actual = samLogin.checkUser();
        Assertions.assertEquals(false, actual);
    }
}
