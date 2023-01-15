package UI;

import Entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPublicProfilePage implements ActionListener {
    User userOwner;
    User userViewer;
    String modification;
    PublicProfileController profileController;
    JFrame frame = new JFrame();
    JButton saveButton = new JButton("Save");
    JLabel messageLabel = new JLabel();
    JLabel titleLabel = new JLabel("Modify Public Profile");
    JLabel modificationLabel;
    JTextField userInput = new JTextField();

    public EditPublicProfilePage(User userOwner, User userViewer, String modification){
        this.userOwner = userOwner;
        this.userViewer = userViewer;
        this.modification = modification;
        profileController = new PublicProfileController(userOwner);
        this.modificationLabel = new JLabel("Enter new " + modification + ":");
    }

    public void display(){
        modificationLabel.setBounds(50, 100, 200, 25);

        messageLabel.setBounds(50, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 10));

        userInput.setBounds(250, 100, 200, 25);


        saveButton.setBounds(125, 200, 100, 25);
        saveButton.addActionListener(this);

        titleLabel.setBounds(200, 50, 150, 25);

        frame.add(titleLabel);
        frame.add(saveButton);
        frame.add(userInput);
        frame.add(modificationLabel);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 550);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String updatedInput = userInput.getText();
            if (updatedInput.equals("")) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Input fields cannot be left empty. Please try again.");
            } else {
                profileController.modifyUserProfile(modification, updatedInput);
                frame.dispose();
                UIPublicProfile publicProfile = new UIPublicProfile(userOwner, userViewer);
                publicProfile.display();
            }
        }

    }
}
