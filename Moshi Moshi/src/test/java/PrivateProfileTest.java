import Login.RegisterUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import UI.ProfileUseCase;
import Entity.User;

public class PrivateProfileTest {
    //This test checks whether the display name is updated and stored when it is modified in the private profile page.
    @Test
    void UpdatePrivateDisplayName() {
        RegisterUseCase registerUseCase = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        User sam = registerUseCase.createUser();
        registerUseCase.saveUser(sam);
        ProfileUseCase profileUseCase = new ProfileUseCase(sam);
        profileUseCase.modifyDisplayName("superman");
        Assertions.assertEquals("superman", sam.getUserDisplayName());
    }

    //This test checks whether the password is updated and stored when it is modified in the private profile page.
    @Test
    void UpdatePassword() {
        RegisterUseCase registerUseCase = new RegisterUseCase("dan", "danish", "bombal",
                "bombal");
        User dan = registerUseCase.createUser();
        registerUseCase.saveUser(dan);
        ProfileUseCase profileUseCase = new ProfileUseCase(dan);
        profileUseCase.modifyPassword("singh");
        Assertions.assertEquals("singh", dan.getPassword());
    }
}
