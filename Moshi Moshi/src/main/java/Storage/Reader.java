package Storage;
import com.google.gson.Gson;

public class Reader implements ReaderInterface {
    public Object Read(String text, Class obj) {
        Gson gson = new Gson();
        return gson.fromJson(text, obj);
    }

    public String ToString(Object obj) {
        Gson gson = new Gson();

        return gson.toJson(obj);
    }
}
