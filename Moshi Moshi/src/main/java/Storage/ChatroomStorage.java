package Storage;

public class
ChatroomStorage extends Storage {
    public ChatroomStorage(String name) {
        super( name + ".txt");
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
