package UI;

import Entity.Chatroom;
import Entity.User;

import java.util.ArrayList;

public class UIoutsidechatroom_backend {

    public UIoutsidechatroom_backend(){
        //initlaizer
    }

    public ArrayList<Chatroom> getchatroomlst(User user){
        return user.getListofChatroom();
        //return the chatrooms this user has joined in a lst
    }

    public ArrayList<User> getuserfriends(User user){
        return user.getFriendsList();
        //return this user's all friend in a lst
    }
}
