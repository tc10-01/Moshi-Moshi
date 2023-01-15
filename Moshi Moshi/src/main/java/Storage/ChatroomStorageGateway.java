package Storage;

import Entity.Chatroom;

//use case
public interface ChatroomStorageGateway {
    Chatroom getData();
    void saveData(Chatroom new_chatroom);
}
