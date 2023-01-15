package Entity;

import java.util.ArrayList;

public class User {
    private String displayName;
    private ArrayList<Chatroom> listofChatroom;
    private ArrayList<User> friendsList;
    private String username;
    private String password;
    private String bio;
    private String status;
    private String comment;


    /**
     * Construct a User
     *
     * @param displayName the User's name as seen by other Users
     * @param username the User's username only accessible by the User themself
     */

    public User(String displayName, String username, String password) {
        this.displayName = displayName;
        this.username = username;
        this.listofChatroom = new ArrayList<Chatroom>();
        this.friendsList = new ArrayList<User>();
        this.password = password;
        this.bio = "Empty";
        this.status = "Empty";
        this.comment = "Empty";
    }

    public String getUserDisplayName(){
        return this.displayName;
    }

    public void setDisplayName(String newName){
        this.displayName = newName;
    }

    public void addUserToChatroom(Chatroom chatroom_name){
        // chatroom.adduser()
        this.listofChatroom.add(chatroom_name);
    }

    public void addUserToFriendList(User friend_username){
        this.friendsList.add(friend_username);
    }

    public void removeUserFromFriendList(User friend_username){
        this.friendsList.remove(friend_username);
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }

    public ArrayList<Chatroom> getListofChatroom(){
        return this.listofChatroom;
    }

    public ArrayList<User> getFriendsList(){
        return this.friendsList;
    }
    public String getBio(){
        return bio;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
}
