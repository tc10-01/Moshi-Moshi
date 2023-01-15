package Storage;
import com.google.gson.Gson;

public class UserSave {
    private String name;
    private UserStorage UserStorage;

    public UserSave(String user_name) {
        this.name = user_name;
        this.UserStorage = new UserStorage(user_name);
    }

    public void Save(UserInfo i) {
        Gson gson = new Gson();
        String info = gson.toJson(i);

        UserStorage.writefile(info);
    }
}
