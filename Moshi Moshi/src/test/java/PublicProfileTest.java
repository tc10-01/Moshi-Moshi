import Login.RegisterUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import UI.ProfileUseCase;
import Entity.User;

public class PublicProfileTest {
    //This test checks whether the display name is updated and stored when modified in the public profile page.
    @Test
    void UpdatePublicDisplayName() {
        RegisterUseCase registerUseCase = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        User sam = registerUseCase.createUser();
        registerUseCase.saveUser(sam);
        ProfileUseCase profileUseCase = new ProfileUseCase(sam);
        profileUseCase.modifyDisplayName("superman");
        Assertions.assertEquals("superman", sam.getUserDisplayName());
    }
    //This test checks whether status is updated and stored when modified in the public profile.
    @Test
    void UpdatePublicStatus() {
        RegisterUseCase registerUseCase = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        User sam = registerUseCase.createUser();
        registerUseCase.saveUser(sam);
        ProfileUseCase profileUseCase = new ProfileUseCase(sam);
        profileUseCase.modifyStatus("Online");
        Assertions.assertEquals("Online", sam.getStatus());
    }
    //This test checks whether comment is updated and stored when modified in the public profile.
    @Test
    void UpdatePublicComment() {
        RegisterUseCase registerUseCase = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        User sam = registerUseCase.createUser();
        registerUseCase.saveUser(sam);
        ProfileUseCase profileUseCase = new ProfileUseCase(sam);
        profileUseCase.modifyComment("In CSC207");
        Assertions.assertEquals("In CSC207", sam.getComment());
    }
    //This test checks whether Bio is updated and stored when modified in the public profile.
    @Test
    void UpdatePublicBio() {
        RegisterUseCase registerUseCase = new RegisterUseCase("sam", "samandar", "vijay",
                "vijay");
        User sam = registerUseCase.createUser();
        registerUseCase.saveUser(sam);
        ProfileUseCase profileUseCase = new ProfileUseCase(sam);
        profileUseCase.modifyBio("University of Toronto");
        Assertions.assertEquals("University of Toronto", sam.getBio());
    }
}
