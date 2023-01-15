package UI;
import Login.LoginPage;
import Storage.ChatroomStorageGateway;
import Storage.ChatroomStorageJ;
import Storage.ChatroomStorageUsecase;
import Entity.Chatroom;
import Entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import UI.UIPublicProfile;
import UI.UIPrivateProfile;
//import tutorial.DirectMessage;

public class UIoutsideChatroom {
    private final User user;
    private JFrame frame;
    private final Integer button_width = 100;
    private final Integer button_length = 100;

    public UIoutsideChatroom(User user){
        this.user = user;
    }
    public void display(){
        //displays the window
        this.frame = new JFrame();
        this.frame.setSize(900, 750); //setting the size of the window
        this.frame.setTitle("Diskawd"); //setting the name for the title of the window
        display_friend_lst(); // calls to display public profile of this user's friends
        display_chatrooms(); // calls to display buttons to enter chatrooms that this user is in
        create_chatroom_button(); //calls to create a button to create chatroom
        enter_public_profile_button(this.user); //creates this user's public profile and allow edit
        enter_private_profile_button(this.user); //creates this user's private profile and allow edit
        this.frame.setLayout(null);//using no layout managers
        this.frame.setVisible(true);//making the frame visible
        this.create_sign_out_button(this.frame);
        this.create_dm_button();
        this.create_join_chatroom_button();
    }

    public JFrame getFrame(){
        return this.frame;
    }

    public void create_dm_button(){
        //user can created dm chatrooms with another user, meant to collaborates with the dm feature in inital desgin
        JButton b = new JButton();
        b.setText("DirectMessage with friend");
        b.setBounds(400, 50, 200,100);
        b.setEnabled(true);
        this.frame.add(b);
        b.addActionListener(e -> {
            String username = JOptionPane.showInputDialog("Enter username name");
            User dmuser;
            for (User user: this.user.getFriendsList()) {
                if (user.getUserDisplayName().equals(username)){
                    dmuser = user;
                    DirectMessage obj = new DirectMessage(dmuser, this.user);
                    Chatroom room = obj.getchatroomname();
                    this.frame.dispose();
                    this.display();
                }
            }
        });
    }

    public ArrayList<Chatroom> not_joined_rooms(){
        // return list of chatroom that this user not joined, meant to collaborate with join chatroom button.
        ChatroomStorageJ obj = new ChatroomStorageJ();
        ArrayList<String> joined = new ArrayList<>();
        ArrayList<Chatroom> result = new ArrayList<>();
        for (Chatroom room: this.user.getListofChatroom()){
            joined.add(room.getName());
        }
        for (Chatroom room: obj.getChatrooms()){
            System.out.println(room.getName() + " abc");
            if (!joined.contains(room.getName())){
                result.add(room);

            }
        }
        return result;
    }

    public void create_join_chatroom_button(){
        //allow user to join any existing chatrooms stored in storage, meant to allow connections between new registered user
        //and existing users. since they can add friends from there.
        JMenuBar b = new JMenuBar();
        JMenu room_lst = new JMenu();
        b.setBounds(275, 50, 100 ,100);
        room_lst.setText("join chatroom");
        b.add(room_lst);
        this.frame.add(b);
        for (Chatroom room: this.not_joined_rooms()){
                System.out.println(room.getName());
                JMenuItem item = new JMenuItem(room.getName());
                room_lst.add(item);
                item.addActionListener(e -> {
                    this.user.addUserToChatroom(room);
                    room.AddUser(this.user.getUserDisplayName());
                    this.frame.dispose();
                    this.display();
                });
        }
    }

    public JButton create_enter_chatroom_button(Chatroom chatroom, User user){
        //create a GUI button to enter this chatroom
        JButton b = new JButton(chatroom.getName());//creating instance of JButton
        b.setEnabled(true); //enables the button
        b.setSize(75, 75);
        b.addActionListener(e ->  {
                UIinsideChatroom obj = new UIinsideChatroom(chatroom, user, this);
                obj.display_current_chatroom(); // goes to the UI insidechatroom page
        });
        return b;
    }

    public void create_sign_out_button(JFrame frame){
        //allow user to sign out and return to the log in page.
        JButton button = new JButton();
        button.setEnabled(true);
        button.setText("Sign out");
        button.setBounds(750, 600 ,button_width, button_length);
        this.frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginPage obj = new LoginPage();
            }
        });
    }

    public void display_chatrooms(){
        //displays the chatroom with their icon picture
        UIoutsidechatroom_backend obj = new UIoutsidechatroom_backend();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,0));
        int y = 0;
        for (Chatroom chatroom: obj.getchatroomlst(this.user)){
            JButton chatrom = this.create_enter_chatroom_button(chatroom, this.user);
            chatrom.setBounds(0, y, 50, 50);
            panel.add(chatrom);
            y += 60;
        }
        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        container.add(panel);
        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(20, 20, 100, 500);
        this.frame.getContentPane().add(scrollPane);
    }

    public void display_friend_lst(){
        //display this user's friendlist from using backend methods
        UIoutsidechatroom_backend obj = new UIoutsidechatroom_backend();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,0));
        for (User friend: obj.getuserfriends(this.user)){
            JButton but = this.enter_friend_public_profile_button(friend);
            panel.add(but);
        }
        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        container.add(panel);
        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setBounds(750, 20, 100, 500);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.frame.getContentPane().add(scrollPane);
    }

    public void create_chatroom_button() {
        //create a GUI button to create chatroom, with current user being the admin user
        //and store the information back to storage\
        JButton b = new JButton("Create Chatroom");//creating instance of JButton
        b.setBounds(150,50,button_width, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true);
        b.addActionListener(e -> {
            String display_name = JOptionPane.showInputDialog("Enter chatroom name");
            Chatroom chatroom = new Chatroom(display_name, this.user.getUserDisplayName());//creates the chatroom
            ChatroomStorageGateway chatroom_storage = (ChatroomStorageGateway) new ChatroomStorageUsecase(display_name);
            chatroom_storage.saveData(chatroom);
            this.user.addUserToChatroom(chatroom);
            chatroom.AddUser(this.user.getUsername());
            this.frame.dispose();
            this.display();
        });

    }

    public JButton enter_friend_public_profile_button(User user){
        //creates an icon when clicked, you can go into that user's public profile
        JButton b = new JButton(user.getUserDisplayName());//creating instance of JButton
        b.setEnabled(true);
        b.setPreferredSize(new Dimension(75, 75));
        b.addActionListener(e -> {
            UIPublicProfile obj = new UIPublicProfile(user, user);
            obj.display(); // goes to the UI profileprofile page for other user, not editable
        });
        return b;
    }

    public void enter_public_profile_button(User user){
        //create a GUI page after clicking the edit public profile button, assumes it is the user himself
        JButton b = new JButton("Edit your public profile");//creating instance of JButton
        b.setBounds(0,600,250, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true);
        b.addActionListener(e -> {
            UIPublicProfile obj = new UIPublicProfile(user, user);
            obj.display(); // goes to the UI publicprofile page
        });
    }

    public void enter_private_profile_button(User user){
        //create a GUI page after clicking the edit private profile button
        JButton b = new JButton("Edit your private profile");//creating instance of JButton
        b.setBounds(370,600,250, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true);
        b.addActionListener(e -> {
                UIPrivateProfile obj = new UIPrivateProfile(this.user);
                obj.display(); // goes to the UI privateprofile page
        });
    }

    public static void main(String[] args) {
        User evan = new User("Evan", "evan", "evan");
        User Jeff = new User("Jeff", "Jeff", "Jeff");
        User tc = new User("tc", "tc", "tc1");
        User Is = new User("Is", "is", "is");
        User Nuteldha = new User("Nuteldha", "nuteldha", "nuteldha");
        User Sam = new User("Sam", "sam", "sam");
        Chatroom tut119 = new Chatroom("tut119", "evan");
        ChatroomStorageUsecase obj = new ChatroomStorageUsecase("tut119");
        evan.addUserToFriendList(Jeff);
        evan.addUserToChatroom(tut119);
        Jeff.addUserToChatroom(tut119);
        tc.addUserToChatroom(tut119);
        Is.addUserToChatroom(tut119);
        Nuteldha.addUserToChatroom(tut119);
        Sam.addUserToChatroom(tut119);
        tut119.AddUser("tc");
        tut119.AddUser("Jeff");
        tut119.AddUser("nuteldha");
        tut119.AddUser("is");
        tut119.AddUser("sam");
        obj.saveData(tut119);
        Chatroom tut119_2 = new Chatroom("tut119_2", "evan");
        evan.addUserToChatroom(tut119_2);
        UIoutsideChatroom a = new UIoutsideChatroom(evan);
        a.display();
    }

}
