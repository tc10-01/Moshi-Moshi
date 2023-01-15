package UI;

import Storage.AccountsStorageUseCase;
import Storage.UserStorageUseCase;
import Entity.*;

public class ProfileUseCase {
    private String username;
    private String password;
    private String displayName;
    private String bio;
    private String status;
    private String comment;
    private User user;
    private UserStorageUseCase userStorage;
    private AccountsStorageUseCase accountsStorageUseCase;

    public ProfileUseCase(User user){
        username = user.getUsername();
        password = user.getPassword();
        displayName = user.getUserDisplayName();
        bio = user.getBio();
        status = user.getStatus();
        comment = user.getComment();
        this.user = user;
        userStorage = new UserStorageUseCase(username);
        accountsStorageUseCase = new AccountsStorageUseCase();
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getDisplayName(){
        return displayName;
    }
    public String getBio(){
        return bio;
    }
    public String getStatus(){
        return status;
    }
    public String getComment(){
        return comment;
    }

    public void modifyPassword(String newPassword){
        user.setPassword(newPassword);
        accountsStorageUseCase.save(username, newPassword);
        userStorage.saveData(user);
    }
    public void modifyDisplayName(String newName){
        user.setDisplayName(newName);
        userStorage.saveData(user);
    }
    public void modifyStatus(String status){
        user.setStatus(status);
        userStorage.saveData(user);
    }
    public void modifyComment(String comment){
        user.setComment(comment);
        userStorage.saveData(user);
    }
    public void modifyBio(String bio){
        user.setBio(bio);
        userStorage.saveData(user);
    }


}
