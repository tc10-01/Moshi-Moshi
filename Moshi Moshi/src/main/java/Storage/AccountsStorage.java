package Storage;

public class AccountsStorage extends Storage{
    public AccountsStorage() {
        super("storage/accounts.txt");
    }

    @Override
    public void writefile(String text) {
        super.writefile(text);
    }

    @Override
    public String readfile() {
        return super.readfile();
    }
}
