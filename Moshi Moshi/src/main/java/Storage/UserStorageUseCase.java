package Storage;

import Entity.User;

public class UserStorageUseCase implements UserStorageGateway{
    Storage user_storage;
    Reader reader;

    public UserStorageUseCase(String username) {
        this.user_storage = new UserStorage(username);
        this.reader = new Reader();
    }

    @Override
    public User getData() {
        User info = (User) reader.Read(user_storage.readfile(), User.class);
        return info;
    }

    @Override
    public void saveData(User new_user) {
        user_storage.writefile(reader.ToString(new_user));
    }
}
