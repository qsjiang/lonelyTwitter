package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Arrays;

public class TweetList {
	private ArrayList<LonelyTweetModel> tweetList;
	
	public TweetList(){
		tweetList = new ArrayList<LonelyTweetModel>();
	}
	
	public LonelyTweetModel[] getTweets(){
		//NOT FINISHED YET
	}
	
	public int getCounts(){
		return tweetList.size();
	}
	public void addTweet(LonelyTweetModel tweet){
		if (this.hasTweet(tweet)){
			throw new IllegalArgumentException();
		}
		tweetList.add(tweet);
	}
	public boolean hasTweet(LonelyTweetModel tweet){
		return tweetList.contains(tweet);
	}
	public void removeTweet(LonelyTweetModel tweet){
		
	}
}
