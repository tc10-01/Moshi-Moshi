package Messages;

import java.util.ArrayList;
import java.util.Arrays;

public class Message {
    String to;
    String from;
    String text;
    String time;

    public Message(String from, String to, String text, String time) {
        this.to = to;
        this.from = from;
        this.text = text;
        this.time = time;
    }
}
