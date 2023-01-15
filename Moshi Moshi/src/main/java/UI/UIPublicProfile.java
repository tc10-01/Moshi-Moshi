package UI;

import Entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPublicProfile implements ActionListener, EditProfileStrategyInterface {

    private User userOwner;
    private User userViewer;
    JFrame frame = new JFrame();
    JButton editBioButton = new JButton("Update Bio");
    JButton editDisplayNameButton = new JButton("Update Display Name");
    JLabel bioCurrent = new JLabel();
    JLabel displayNameCurrent = new JLabel();
    JLabel bioLabel = new JLabel("Current Bio:");
    JLabel displayNameLabel = new JLabel("Current Display Name:");
    JLabel statusLabel = new JLabel("Current Status:");
    JLabel statusCurrent = new JLabel();
    JButton editStatusButton = new JButton("Update Status");
    JLabel commentLabel = new JLabel("Current Comment:");
    JLabel commentCurrent = new JLabel();
    JButton editCommentButton = new JButton("Update Comment");
    JButton editButton = new JButton("Edit Page");
    JLabel titleLabel = new JLabel("Public Profile");
    PublicProfileController profileController;

    public UIPublicProfile(User userOwner, User userViewer){
        this.userOwner = userOwner;
        this.userViewer = userViewer;
        profileController = new PublicProfileController(userOwner);
        displayNameCurrent.setText(profileController.getDisplayName());
        bioCurrent.setText(profileController.getBio());
        statusCurrent.setText(profileController.getStatus());
        commentCurrent.setText(profileController.getComment());
    }

    @Override
    public void display(){
        // displays the UI for this user's public profile
        displayNameLabel.setBounds(50, 100, 175, 25);
        commentLabel.setBounds(50, 150, 175, 25);
        statusLabel.setBounds(50, 200, 175, 25);
        bioLabel.setBounds(50, 250, 175, 25);

        displayNameCurrent.setBounds(200, 100, 200, 25);
        commentCurrent.setBounds(200, 150, 200, 25);
        statusCurrent.setBounds(200, 200, 200, 25);
        bioCurrent.setBounds(200, 250, 200, 25);

        editDisplayNameButton.setBounds(300, 100, 200, 25 );
        editCommentButton.setBounds(300, 150, 200, 25);
        editStatusButton.setBounds(300, 200, 200, 25);
        editBioButton.setBounds(300, 250, 200, 25);


        editDisplayNameButton.addActionListener(this);
        editCommentButton.addActionListener(this);
        editStatusButton.addActionListener(this);
        editBioButton.addActionListener(this);


        titleLabel.setBounds(250, 50, 200, 25);


        //frame.add(imageLabel);
        frame.add(titleLabel);
        frame.add(displayNameLabel);
        frame.add(displayNameCurrent);
        frame.add(commentLabel);
        frame.add(commentCurrent);
        frame.add(statusLabel);
        frame.add(statusCurrent);
        frame.add(bioLabel);
        frame.add(bioCurrent);
        frame.add(editDisplayNameButton);
        frame.add(editBioButton);
        frame.add(editStatusButton);
        frame.add(editCommentButton);

        if (userOwner.equals(userViewer)){
            editDisplayNameButton.setEnabled(true);
            editBioButton.setEnabled(true);
            editCommentButton.setEnabled(true);
            editStatusButton.setEnabled(true);

        }else{
            editDisplayNameButton.setEnabled(false);
            editBioButton.setEnabled(false);
            editStatusButton.setEnabled(false);
            editCommentButton.setEnabled(false);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        //frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==editDisplayNameButton){
            frame.dispose();
            EditPublicProfilePage publicProfileEdit = new EditPublicProfilePage(userOwner, userViewer, "name");
            publicProfileEdit.display();
        }
        else if (e.getSource()==editStatusButton){
            frame.dispose();
            EditPublicProfilePage publicProfileEdit = new EditPublicProfilePage(userOwner, userViewer, "status");
            publicProfileEdit.display();
        }
        else if (e.getSource()==editCommentButton){
            frame.dispose();
            EditPublicProfilePage publicProfileEdit = new EditPublicProfilePage(userOwner, userViewer, "comment");
            publicProfileEdit.display();
        }
        else {
            frame.dispose();
            EditPublicProfilePage publicProfileEdit = new EditPublicProfilePage(userOwner, userViewer, "bio");
            publicProfileEdit.display();
        }
    }
}
