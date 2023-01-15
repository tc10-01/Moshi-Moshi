package Storage;
import User.PublicProfile;
import com.google.gson.Gson;

public class UserSetup {
    private String name;

    public UserSetup(String user_name) {
        this.name = user_name;
    }

    public PublicProfile Recreate() {
        Storage user_storage = new UserStorage(name);
        Gson gson = new Gson();
        UserInfo information = gson.fromJson(user_storage.readfile(), UserInfo.class);

        PublicProfile user = new PublicProfile();
        user.setBio(information.bio);
        user.setProfilePic(information.profilePicPath);
        user.setStatus(information.status);
        user.setComment(information.comment);

        return user;
    }
}

