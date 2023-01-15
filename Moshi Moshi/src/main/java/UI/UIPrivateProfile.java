package UI;

import Entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPrivateProfile implements ActionListener {

    JFrame frame = new JFrame();
    JButton editPasswordButton = new JButton("Update Password");
    JButton editDisplayNameButton = new JButton("Update Display Name");
    JLabel password = new JLabel();
    JLabel displayName = new JLabel();
    JLabel passwordLabel = new JLabel("Current Password:");
    JLabel displayNamelabel = new JLabel("Current Display Name:");
    JLabel messageLabel = new JLabel();
    JLabel titleLabel = new JLabel("Private Profile");
    private User user;
    private PrivateProfileController privateProfile;

    public UIPrivateProfile(User user){
        this.user = user;
        privateProfile = new PrivateProfileController(user);
        password.setText(privateProfile.getPassword());
        displayName.setText(privateProfile.getDisplayName());
    }

    public void display(){
        //displays the current user's private page
        displayNamelabel.setBounds(50, 100, 175, 25);
        passwordLabel.setBounds(50, 150, 175, 25);

        messageLabel.setBounds(50, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 10));

        displayName.setBounds(200, 100, 200, 25);
        editDisplayNameButton.setBounds(300, 100, 200, 25 );

        password.setBounds(175, 150, 200, 25);
        editPasswordButton.setBounds(300, 150, 200, 25);


        editDisplayNameButton.addActionListener(this);
        editPasswordButton.addActionListener(this);


        titleLabel.setBounds(250, 50, 200, 25);


        //frame.add(imageLabel);
        frame.add(titleLabel);
        frame.add(editPasswordButton);
        frame.add(editDisplayNameButton);
        frame.add(displayName);
        frame.add(password);
        frame.add(displayNamelabel);
        frame.add(passwordLabel);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        //frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==editDisplayNameButton){
            frame.dispose();
            EditPrivateProfilePage modifyPrivateDisplayName = new EditPrivateProfilePage(user, "name");
            modifyPrivateDisplayName.display();
        }
        else{
            frame.dispose();
            EditPrivateProfilePage modifyPrivatePassword = new EditPrivateProfilePage(user, 1);
            modifyPrivatePassword.display();
        }
    }
}
