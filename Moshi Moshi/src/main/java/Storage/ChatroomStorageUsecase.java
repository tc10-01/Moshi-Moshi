package Storage;
import Entity.Chatroom;

public class ChatroomStorageUsecase implements ChatroomStorageGateway{
    Storage chatroom_storage;
    Reader reader;
    public ChatroomStorageUsecase(String name) {
        this.chatroom_storage= new ChatroomStorage(name);
        this.reader = new Reader();
    }

    @Override
    public Chatroom getData() {
        Chatroom info = (Chatroom) reader.Read(chatroom_storage.readfile(), Chatroom.class);
        return info;
    }

    @Override
    public void saveData(Chatroom new_chatroom) {
        chatroom_storage.writefile(reader.ToString(new_chatroom));
    }
}
