package Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageListUser {
    private final String username;
    public Map<String, ArrayList<Message>> messages; //to, message

    public MessageListUser(String username) {
        this.username = username;
        this.messages = new HashMap<String, ArrayList<Message>>();
    }

    public void AddMessage(String to, Message message) {
        if (this.messages.containsKey(to)) {
            this.messages.get(to).add(message);
        } else {
            this.messages.put(to, new ArrayList<Message>(Arrays.asList(message)));
        }
    }
}
