package TestCases;

import Storage.ChatroomStorageGateway;
import Storage.ChatroomStorageUsecase;
import org.junit.Test;
import tutorial.Chatroom;
import tutorial.User;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ChatroomTests {
    @Test
    public void testAddUser(){
        User martin = new User("MART", "martin", "password123");
        User bob = new User("BOB", "bob_builds","building123");
        ChatroomStorageGateway g1 = new ChatroomStorageUsecase("CSC207");
        Chatroom c1 = new Chatroom("CSC207", bob, g1 );
        c1.addUser(martin);
        assertTrue(c1.getUserList().contains(martin));
    }

    @Test
    public void testRemoveUser(){
        User martin = new User("MART", "martin", "password123");
        User bob = new User("BOB", "bob_builds","building123");
        ChatroomStorageGateway g1 = new ChatroomStorageUsecase("CSC207");
        Chatroom c1 = new Chatroom("CSC207", bob, g1 );
        ArrayList<User> l1 = c1.getUserList();
        c1.addUser(martin);
        c1.removeUser(bob);
        assertFalse(c1.getUserList().contains(bob));
    }

    @Test
    public void testRemoveUser2(){
        User martin = new User("MART", "martin", "password123");
        User bob = new User("BOB", "bob_builds","building123");
        User jeff = new User("JEFF", "jeff_codes", "jeff123");
        ChatroomStorageGateway g1 = new ChatroomStorageUsecase("CSC207");
        Chatroom c1 = new Chatroom("CSC207", bob, g1 );
        ArrayList<User> l1 = c1.getUserList();
        c1.addUser(martin);
        c1.addUser(jeff);
        c1.removeUser(martin);
        assertFalse(c1.getUserList().contains(martin));
    }

    @Test
    public void testGetName(){
        User martin = new User("MART", "martin", "password123");
        User bob = new User("BOB", "bob_builds","building123");
        ChatroomStorageGateway g1 = new ChatroomStorageUsecase("CSC207");
        Chatroom c1 = new Chatroom("CSC207", bob, g1 );
        assertEquals("CSC207", c1.getName());
    }
    @Test
    public void testGetAdmin(){
        User martin = new User("MART", "martin", "password123");
        User bob = new User("BOB", "bob_builds","building123");
        ChatroomStorageGateway g1 = new ChatroomStorageUsecase("CSC207");
        Chatroom c1 = new Chatroom("CSC207", bob, g1 );
        assertEquals(bob, c1.getAdmin());
    }
}
