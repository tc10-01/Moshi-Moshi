package Storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AccountsStorageUseCase implements AccountsStorageGateway {
    Storage accounts_storage;
    Reader reader;

    public AccountsStorageUseCase() {
        this.accounts_storage = new AccountsStorage();
        this.reader = new Reader();
    }

    @Override
    public boolean usernameExists(String username) {
        Map<String, String> info = (Map<String, String>) this.reader.Read(accounts_storage.readfile(), Map.class);

        return info.containsKey(username);
    }

    @Override
    public boolean passwordExists(String username, String password) {
        // username must exist
        Map<String, String> info = (Map<String, String>) this.reader.Read(accounts_storage.readfile(), Map.class);
        return Objects.equals(info.get(username), password);
    }

    @Override
    public void save(String username, String password) {
        Map<String, String> map = (Map<String, String>) reader.Read(accounts_storage.readfile(), Map.class);
        map.put(username, password);

        accounts_storage.writefile(reader.ToString(map));
    }
}
