package Storage;

public class MessagesStorage extends Storage{
    public MessagesStorage(String name) {
        super("storage/messages/" + name + ".txt");
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
