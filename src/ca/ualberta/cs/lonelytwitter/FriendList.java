package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public abstract class FriendList {

	private ArrayList<User> friendList;
	
	public FriendList(){
		this.friendList = new ArrayList<User>();
	}
	
	public void addFriend(User newFriend){
		this.friendList.add(newFriend);
	}
	
	public ArrayList<User> getFriendList(){
		return this.friendList;
	}
	
	public abstract String getFriendListDescription();
}

