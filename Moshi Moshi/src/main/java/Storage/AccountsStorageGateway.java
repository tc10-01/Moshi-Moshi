package Storage;
//use case layer

public interface AccountsStorageGateway {
    boolean usernameExists(String username);

    boolean passwordExists(String username, String password);

    void save(String username, String password);
}
