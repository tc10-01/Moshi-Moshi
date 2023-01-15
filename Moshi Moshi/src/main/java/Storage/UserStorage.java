package Storage;

public class UserStorage extends Storage{
    public UserStorage(String name) {
        super("storage/profiles/" + name + ".txt");
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
