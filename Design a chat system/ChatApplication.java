/**

*****************************
* Design an online chat     *
*****************************
Constraints and assumptions
Assume we'll focus on the following workflows:
->Text conversations only
->Users
  Add a user
  Remove a user
  Update a user
  Add to a user's friends list
    Add friend request
    Approve friend request
    Reject friend request
  Remove from a user's friends list
->Create a group chat
  Invite friends to a group chat
  Post a message to a group chat
->Private 1-1 chat
  Invite a friend to a private chat
  Post a meesage to a private chat
  
*/

/***********************************
 Approach
*/

/**
classes and their relationships:

1)User:
  Properties: id, name, friendsList, friendRequests
  Methods: addUser(), removeUser(), updateUser(), addToFriendsList(), sendFriendRequest(), approveFriendRequest(), rejectFriendRequest(), removeFromFriendsList()
2)GroupChat:
  Properties: id, participants, messages 
  Methods: createGroupChat(), inviteToGroupChat(), postMessageToGroupChat()
3)PrivateChat:
  Properties: id, participants, messages
  Methods: inviteToPrivateChat(), postMessageToPrivateChat()
4)Message:
  Properties: id, sender, content, timestamp

**/
import java.util.ArrayList;
import java.util.List;

class User{
	
	// Properties: id, name, friendsList, friendRequests
	private int id;
	private String name;
	private List<User> friendList;
	private List<User> friendRequests;
	
	//constructor
	
	private User(int id, String name){
		this.id=id;
		this.name = name;
		this.friendList= friendList;
		this.friendRequests= friendRequests;
	}
	
	//Methods: addUser(), removeUser(), updateUser(), addToFriendsList(), sendFriendRequest(), approveFriendRequest(), rejectFriendRequest(), removeFromFriendsList()
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public List<User> getFriendList(){
		return friendList;
	}
	
	public List<User> getFriendRequest(){
		return friendRequests;
	}
	
	public void addUser(User user) {
        // Add user to the system
    }

    public void removeUser(User user) {
        // Remove user from the system
    }

    public void updateUser(User user) {
        // Update user details
    }

    public void addToFriendsList(User user) {
        // Add user to the friends list
    }

    public void sendFriendRequest(User user) {
        // Send a friend request to the specified user
    }

    public void approveFriendRequest(User user) {
        // Approve the friend request from the specified user
    }

    public void rejectFriendRequest(User user) {
        // Reject the friend request from the specified user
    }

    public void removeFromFriendsList(User user) {
        // Remove user from the friends list
    }
	
}



class GroupChat{
	
	//Properties: id, participants, messages 
	private int id;
	private List<User> participants;
	private List<Message> messages;
	
	
	public GroupChat(int id){
		this.id=id;
		this.participants= new ArrayList<>();
		this.meesages=new ArrayList<>();
	}
	
    //Methods: createGroupChat(), inviteToGroupChat(), postMessageToGroupChat()
	
	 public int getId(){
		return id;
	}
	
	public List<User> getParticipants(){
		return participants;
	}
	
	public list<Message> getMessages(){
		return messages;
	} 
	
	public void createGroupChat() {
        // Create a new group chat
    }

    public void inviteToGroupChat(User user) {
        // Invite a user to the group chat
    }

    public void postMessageToGroupChat(Message message) {
        // Post a message to the group chat
    }
	
	
}


class PrivateChat{
	//Properties: id, participants, messages
    private int id;
	private List<User> participants;
	private List<User> meesages;
	
	public PrivateChat(){
		this.id= id;
		this.participants= new ArrayList<>();
		this.meesages= new ArrayList<>();
	}
	//Methods: inviteToPrivateChat(), postMessageToPrivateChat()
    
    public int getId(){
		return id;
	}
	
	public List<User> getParticipants(){
		return participants;
	}
	
	public List<Message> getMessages(){
		return meesages;
	}
	public void inviteToPrivateChat(User user) {
        // Invite a user to the private chat
    }

    public void postMessageToPrivateChat(Message message) {
        // Post a message to the private chat
    }
	
} 


class Message{
	////Properties: id, sender, content,timestamp
	private int id;
    private User sender;
    private String content;
    private long timestamp;

    public Message(int id, User sender, String content, long timestamp) {
        this.id = id;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

public class ChatApplication {
    public static void main(String[] args) {
        
        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");
        User user3 = new User(3, "Charlie");

        user1.addToFriendsList(user2);
        user2.addToFriendsList(user1);

        user1.sendFriendRequest(user3);
        user3.approveFriendRequest(user1);

        GroupChat groupChat = new GroupChat(1);
        groupChat.inviteToGroupChat(user1);
        groupChat.inviteToGroupChat(user2);
        groupChat.inviteToGroupChat(user3);

        Message message1 = new Message(1, user1, "Hello, everyone!", System.currentTimeMillis());
        groupChat.postMessageToGroupChat(message1);

        PrivateChat privateChat = new PrivateChat(1);
        privateChat.inviteToPrivateChat(user1);
        privateChat.inviteToPrivateChat(user2);

        Message message2 = new Message(2, user1, "Hi, Bob!", System.currentTimeMillis());
        privateChat.postMessageToPrivateChat(message2);
    }
}