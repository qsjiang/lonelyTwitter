package ca.ualberta.cs.lonelytwitter;

public class Reader extends User {
	@Override
	public void setUsername(String username){
		if (username.length()>8){
			throw new RuntimeException("Name too long!");
		}
		this.username = username;
	}
}
