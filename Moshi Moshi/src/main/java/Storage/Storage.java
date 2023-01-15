package Storage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Storage {
    public String file_name;

    public Storage(String name) {
        this.file_name = name;
    }
    void writefile(String text) {
        try {
            Files.write(Paths.get(file_name), text.getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    String readfile() {
        try {
            return Files.readString(Path.of(file_name));
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    ArrayList<String> getfiles() {
        try {
            Stream<Path> result = Files.walk(Paths.get(file_name));
            return (ArrayList<String>) result.filter(Files::isRegularFile).map(x -> x.toString().replaceFirst(".txt", "").replaceFirst("storage/chatrooms/", "")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}