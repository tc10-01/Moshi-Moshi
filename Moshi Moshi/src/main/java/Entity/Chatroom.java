package Entity;

import java.util.ArrayList;

public class Chatroom {
    private String name;
    private ArrayList<String> user_list; // list of unique usernames of the users in the chatroom
    private String admin_name; // User who created the chatroom

    private ArrayList<String> message_list; // list of messages in the chatroom

    public Chatroom(String name, String admin_name) {
        this.name = name;
        this.user_list = new ArrayList<>();
        this.admin_name = admin_name;
        this.user_list.add(admin_name);
        this.message_list = new ArrayList<>();
    }

    public ArrayList<String> getMessage(){
        return this.message_list;
    }

    public ArrayList<String> getUserLst(){
        return this.user_list;
    }

    public void AddUser(String username){
        this.user_list.add(username);
    }

    public void RemoveUser(String username){
        this.user_list.remove(username);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String new_name){
        this.name = new_name;
    }
    public String getAdmin_name (){
        return this.admin_name;
    }

    public void setAdmin(String new_admin_name){
        this.admin_name = new_admin_name;
    }

    public void addMessage(String message_to_add){
        this.message_list.add(message_to_add);
    }

}
