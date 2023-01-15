PRESENTATION SLIDESHOW LINK: https://docs.google.com/presentation/d/1XN3rOhqg0ClOlGjq0Nb9WZg8lnwxaB2-0TjlpN8tNbk/edit?usp=sharing

Description of the project: This "diskawd" software is capable of sending message in chatrooms with other users, it allows new users to explore 
existing chatrooms after clicking join_chatroom button, it shows existing chatrooms stored in database and new users can join in and start making
friends from there. There will be options to add friend or to invite friend from inside chatrooms, and users can view their chatroom and friend list 
from outside chatroom window. User can also set up their public profile to allow other users to get to know them, and same goes around, users can click
on other users name under member/friend list to view their public profile. User can also change their passwords under private profile outside chatroom.
User can also create chatrooms or direct message with their friend, all of which will be stored in database after chatroom is being created.

demos of the software can be found under folder demos(numbers after the file name represents the order).
This software starts from LoginMain.

MILESTONE 4/5 PULL REQUEST EXPLANATIONS 

ISABEL
1. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/26
Created and added new tests for the User class. Tested if the methods called the appropriate variables and returned the proper objects.

2. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/22
This is a more recent pull request, however, I believe my review was significant as I ensured that our group's code is staying consistent throughout 
everyone's parts. This is in terms of method/function names. As well, I asked for reviews on code written based on what the group had previously 
discussed. This is to ensure we are all on the same page with the design of the application and that our logic is clear so there is no confusion. 

NIVEDHA

1. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/20
- most recent pull request with the most complete version of the Chatroom entity class. 
- Changed the types for userList and admin variable types to accommdate usage by the storage class and UIs
- Included code that allows every created Chatroom to be stored in Storage using abstraction
- Included a method to allow every new message sent to also be stored in the Chatroom's message storage and updates the Chatroom data in Storage

2. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/8
- first push to Chatroom class
- defined the integral structure of the Chatroom entity that would early on act as the basis for other entities and interfaces to be implemented

https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/22
- comment and approval under files changed related to UI implementing a way for a Chatroom to be hidden once number of users becomes 0 and clarifications 
regarding the structure of the Chatroom class

JEFF
1. 
2.

SAMANDAR
1. I have made the pull request https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/29. I was mainly responsible for implementing the Login System which includes the registration page and the login page. I was also responsible for implementing the private and public profile pages. The user interfaces for the login system and the profile pages all work. All of the UI's have their own controller and use case classes that help with processing numerous actions such a button press or creating an account. These classes mainly worked with the User entity class to modify/update user data (used in the private and public profiles) and the storage class to save user login info when creating an account, checking whether the information matches when logging in, and saving user data when updating the user profile. 

I have also created the tests for each of the pages. However, when it came to testing the user interfaces directly, I had some challenges and instead I decided to test the main functionalities such testing whether the new account is saved in storage when a user registers an account. Testing other functionalities include checking whether the username and password match by comparing it with the data saved in storage. Checking whether the updates have been stored when modifying the public/private profile pages. Checking whether the user data is retained when a user signs out and tries to sign back in. 

EVAN
I have made a pull request https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/27 
(2 user intefaces #27), It pulls all the UIs into the main and made sure variables names, methods names matches the ones in chatroom and user files, which completes the 
User interface part of this entire project(not counting extending the project). I have finished the UIinside and outsidechatrooms from this pull request.
It is capable of demonstrating most of the features from out initial design.


The pull request I made some review would be the same pull request as above, where I have discussed the problem with Jeff 
of having data interfering the terminal or UI in Sam's work, which allowed me to actually realize the problem in the code.
Sam actually have the data reading and outputting in terminal which go against of our design of the project. While now it is fixed,
it made us clear of how we actually want our UI designed. 

TC
1. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/23
In this pull request, I have implemented the ability to create direct message chatrooms among users, including codes that have the ability to rename a user's name to a preferred nickname. Throughout the writing process of this class, I used Discord to give me a picture on what kind of functions would be beneficial or are needed while direct messaging people. 
2. https://github.com/CSC207-2022F-UofT/course-project-hello-woooorld-119/pull/16
In this pull request, my teammate reminded me that I was heading toward the wrong direction because addmessage shouldn't be an entity. However, I wasn't really sure how to fix it at the start. However, after asking for a clearification during the tutorial, I unserstood what was the issue and got it sorted out. 
