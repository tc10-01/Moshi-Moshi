import Login.RegisterUseCase;
import Storage.UserStorageUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entity.User;

public class RegisterTest {
    //This test checks whether the username already exists when creating a new user. If the username is already taken,
    // the algorithm doesn't register the user.
    @Test
    void CheckUsernameExistsStorage() {
        RegisterUseCase sam = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        String status = sam.registerUser();
        RegisterUseCase samCopy = new RegisterUseCase("sam", "samandar", "123",
                "123");
        String actual = samCopy.registerUser();
        Assertions.assertEquals("exists", actual);
    }

    //This test does not register the user when both of the passwords are not matching.
    @Test
    void PasswordsNotMatching() {
        RegisterUseCase evan = new RegisterUseCase("sahil", "sahil", "vijay",
                "123");
        String actual = evan.registerUser();
        Assertions.assertEquals("Passwords not matching", actual);
    }

    //This test registers a valid user and checks whether the user was stored in the .txt file by checking if
    // the username exists in the given file.
    @Test
    void RegisterAccount() {
        RegisterUseCase neil = new RegisterUseCase("neil", "neilakshan", "sivalengam",
                "sivalengam");
        String status = neil.registerUser();
        UserStorageUseCase storageUseCase = new UserStorageUseCase("neilakshan");
        User actual = storageUseCase.getData();
        Assertions.assertEquals("neilakshan", actual.getUsername());
    }
}
