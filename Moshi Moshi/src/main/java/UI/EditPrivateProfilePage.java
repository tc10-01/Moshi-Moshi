package UI;

import Entity.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import UI.ProfileUseCase;

public class EditPrivateProfilePage implements ActionListener {
    private String modifyDisplayName;
    private int modifyPassword;
    private User user;
    private ProfileUseCase profile;
    JFrame frame = new JFrame();
    JButton saveButton = new JButton("Save");
    JTextField userDisplayName = new JTextField();
    JPasswordField userPassword = new JPasswordField();
    JLabel userDisplayNameLabel = new JLabel("Enter new display name:");
    JLabel userPasswordLabel = new JLabel("Enter new password:");
    JLabel messageLabel = new JLabel();
    JLabel titleLabel = new JLabel("Modify Private Profile");

    public EditPrivateProfilePage(User user, String modifyDisplayName) {
        this.user = user;
        this.modifyDisplayName = modifyDisplayName;
        profile = new ProfileUseCase(user);
        modifyPassword = 0;
    }

    public EditPrivateProfilePage(User user, int modifyPassword) {
        this.user = user;
        this.modifyPassword = modifyPassword;
        profile = new ProfileUseCase(user);
        modifyDisplayName = "";
    }

    public void display() {
        if (modifyDisplayName.equals("name")) {
            userDisplayNameLabel.setBounds(50, 100, 200, 25);

            messageLabel.setBounds(50, 250, 250, 35);
            messageLabel.setFont(new Font(null, Font.ITALIC, 10));

            userDisplayName.setBounds(250, 100, 200, 25);


            saveButton.setBounds(125, 200, 100, 25);
            saveButton.addActionListener(this);

            titleLabel.setBounds(200, 50, 150, 25);

            frame.add(titleLabel);
            frame.add(saveButton);
            frame.add(userDisplayName);
            frame.add(userDisplayNameLabel);
            frame.add(messageLabel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(550, 550);
            frame.setLayout(null);
            frame.setVisible(true);
        } else {
            userPasswordLabel.setBounds(50, 100, 200, 25);

            messageLabel.setBounds(50, 250, 250, 35);
            messageLabel.setFont(new Font(null, Font.ITALIC, 10));

            userPassword.setBounds(250, 100, 200, 25);


            saveButton.setBounds(125, 200, 100, 25);
            saveButton.addActionListener(this);

            titleLabel.setBounds(200, 50, 150, 25);

            frame.add(titleLabel);
            frame.add(saveButton);
            frame.add(userPassword);
            frame.add(userPasswordLabel);
            frame.add(messageLabel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(550, 550);
            frame.setLayout(null);
            frame.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            if (modifyDisplayName.equals("name")) {
                String newName = userDisplayName.getText();
                if (newName.equals("")) {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Input fields cannot be left empty. Please try again.");
                }else{
                    profile.modifyDisplayName(newName);
                    frame.dispose();
                    UIPrivateProfile privateProfile = new UIPrivateProfile(user);
                    privateProfile.display();
                    }
            } else {
                String newPassword = String.valueOf(userPassword.getPassword());
                if (newPassword.equals("")) {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Input fields cannot be left empty. Please try again.");
                } else {
                    profile.modifyPassword(newPassword);
                    frame.dispose();
                    UIPrivateProfile privateProfile = new UIPrivateProfile(user);
                    privateProfile.display();
                }
            }

        }
    }
}
