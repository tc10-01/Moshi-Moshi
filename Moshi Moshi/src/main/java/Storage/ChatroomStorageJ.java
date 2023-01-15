package Storage;

import Entity.Chatroom;

import java.util.ArrayList;

public class ChatroomStorageJ {
    Storage chatroom_storage;
    public ChatroomStorageJ() {
        this.chatroom_storage = new Storage("storage/chatrooms");
    }

    public ArrayList<Chatroom> getChatrooms() {
        ArrayList<String> chatroom_names = chatroom_storage.getfiles();

        ArrayList<Chatroom> output = new ArrayList<Chatroom>();

        for (String s: chatroom_names) {
            ChatroomStorageUsecase c = new ChatroomStorageUsecase(s);
            System.out.println(c.chatroom_storage.file_name);
            output.add(c.getData());

        }

        return output;
    }
}
