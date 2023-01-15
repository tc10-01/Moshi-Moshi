package UI;

import Entity.User;

public class PrivateProfileController {
    private String password;
    private String displayName;
    private ProfileUseCase profileUseCase;

    public PrivateProfileController(User user){
        profileUseCase = new ProfileUseCase(user);
        password = profileUseCase.getPassword();
        displayName = profileUseCase.getDisplayName();
    }

    public String getPassword(){
        return profileUseCase.getPassword();
    }
    public String getDisplayName(){
        return profileUseCase.getDisplayName();
    }

}
