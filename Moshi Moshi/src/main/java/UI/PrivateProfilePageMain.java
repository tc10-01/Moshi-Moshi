package UI;

import Login.RegisterUseCase;

public class PrivateProfilePageMain {
    public static void main(String[] args){
        RegisterUseCase register = new RegisterUseCase("sam", "sam", "vijay", "vijay");
        //User user = register.createUser("sam", "sam", "vijay");
        //User user2 = register.createUser("shivam", "shivam", "pathak");
        //register.saveUser(user);
       // UserStorageUseCase userStorage = new UserStorageUseCase("sam");
        //userStorage.saveData(user);
        //User sam = userStorage.getData();
        //System.out.println(sam.getPassword());
        //sam.setPassword("miki");
        //userStorage.saveData(sam);
        //System.out.println(sam.getPassword());

        //UserStorageUseCase storage = new UserStorageUseCase("danish");
        //User danish = storage.getData();
        //String password = danish.getPassword();
        //System.out.println(password);
        //UIPrivateProfile privateProfile = new UIPrivateProfile(user);
        //privateProfile.display();
        //UIPublicProfile publicProfile = new UIPublicProfile(user, user);
        //publicProfile.display();
        //EditPublicProfilePage publicProfile = new EditPublicProfilePage(user, "display name");
        //publicProfile.display();
    }
}
