package Login;

import Storage.AccountsStorageUseCase;
import Storage.UserStorageUseCase;
import Entity.User;

import java.util.Objects;

public class RegisterUseCase {
    private AccountsStorageUseCase storageUseCase = new AccountsStorageUseCase();
    private String displayName;
    private String username;
    private String password1;
    private String password2;

    public RegisterUseCase(String displayName, String username, String password1, String password2){
        this.displayName = displayName;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    //Checks whether the username is already taken.
    public boolean checkUsername(String username){
        return storageUseCase.usernameExists(username);
    }

    //Checks whether both passwords match.
    public boolean passwordsMatch(String password1, String password2){
        return Objects.equals(password1, password2);
    }

    //Creates the user account with the specified username, password and display name.
    public User createUser(){
        User user = new User(displayName, username, password1);
        UserStorageUseCase userStorage = new UserStorageUseCase(username);
        userStorage.saveData(user);
        return user;
    }

    //Saves the user account in storage.
    public void saveUser(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        storageUseCase.save(username, password);
    }

    public String registerUser(){
        if (checkUsername(username)){
            return "exists";
        }
        if (!passwordsMatch(password1, password2)){
            return "Passwords not matching";
        }
        else{
            User user = createUser();
            saveUser(user);
            storageUseCase.save(username, password1);
            return "Successful";
        }
    }
}
