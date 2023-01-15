package Login;
import Storage.AccountsStorageUseCase;
import Storage.UserStorageUseCase;
import Entity.User;

/*
 * This UseCase class is responsible for storing all the data from the user regarding the login information.
 * Responsible for user creation.
 * Checks whether a user already exists in the system.
 * Modifies the user list by adding or removing existing users.
 */
public class LoginUseCase {
    private String username;
    private String password;
    private AccountsStorageUseCase storageUseCase; //= new AccountsStorageUseCase();
    private UserStorageUseCase userStorage; //= new UserStorageUseCase(username);

    public LoginUseCase(String username, String password){
        this.username = username;
        this.password = password;
        this.userStorage = new UserStorageUseCase(username);
        this.storageUseCase = new AccountsStorageUseCase();
    }

/*
 * Checks whether the current user exists with the given username and password.
 * @param username
 * @param password
 * @return a dictionary of weather a user exists
 */
    public boolean checkUser() {

        if (storageUseCase.usernameExists(username)) {
            return storageUseCase.passwordExists(username, password);
        } else {
            return false;
        }
    }

    public User getUser(){
        User user = userStorage.getData();
        return user;
    }


//Checks if the user with the given username exists.

    public boolean checkUsername(){
        return storageUseCase.usernameExists(username);
    }
    public boolean checkPassword(){
        return storageUseCase.passwordExists(username, password);
    }

    public void saveLogin(String username, String password){
        storageUseCase.save(username, password);
    }

}
