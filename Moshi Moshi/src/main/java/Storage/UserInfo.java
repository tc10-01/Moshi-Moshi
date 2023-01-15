package Storage;

import Entity.Chatroom;

import java.util.ArrayList;
import java.util.List;

class UserInfo {
    String profilePicPath;
    String bio;
    String status;
    String comment;
}

class UserEntityInfo {
    String displayName;
    ArrayList<Chatroom> listOfChatroom;
}

class AccountsInfo {
    String username;
    String password;
}

class MessagesInfo {
    String text;
    String date;
    String to;
}

class ChatroomsInfo {
    List<String> messages;
    List<String> users;
    String adminUser;
    String name;
}