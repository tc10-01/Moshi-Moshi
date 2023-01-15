package Storage;

import Entity.User;

public interface UserStorageGateway {
    User getData();
    void saveData(User new_user);
}
