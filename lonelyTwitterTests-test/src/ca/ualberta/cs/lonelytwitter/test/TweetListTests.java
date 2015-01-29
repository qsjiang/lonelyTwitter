package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;
import java.util.Date;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetList;
import android.test.ActivityInstrumentationTestCase2;

public class TweetListTests extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListTests() {
		super(LonelyTwitterActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	
	public void testCounts(){
		TweetList tweetList =  new TweetList();
		NormalTweetModel tweet = new NormalTweetModel ("Hello");
		tweetList.addTweet(tweet);
		assertEquals("This should be 1",tweetList.getCounts(),1);
	}
	
	public void testEquals(){
		NormalTweetModel aNormalTweetModel = new NormalTweetModel ("Hello",new Date(123));
		ImportantTweetModel aImportantTweetModel = new ImportantTweetModel("Hello",new Date(123));
		assertFalse("aNormalTweetModel should not equal to aImportantTweetModel",aNormalTweetModel.equals(aImportantTweetModel));	
		assertFalse("aImportantTweetModel should not equal to aNormalTweetModel",aImportantTweetModel.equals(aNormalTweetModel));	
	}
	public void testHasTweet(){
		TweetList tweetList =  new TweetList();
		NormalTweetModel tweet1 = new NormalTweetModel ("Hello");
		NormalTweetModel tweet2 = new NormalTweetModel ("yolo");

		tweetList.addTweet(tweet1);
		assertTrue("Tweetlist should contain the first tweet",tweetList.hasTweet(tweet1));
		assertFalse("Tweetlist should NOT contain the second tweet",tweetList.hasTweet(tweet2));
	}
	public void testAddTweet(){
		TweetList tweetList =  new TweetList();
		NormalTweetModel tweet = new NormalTweetModel ("Hello");
		tweetList.addTweet(tweet);
		assertEquals("After 1 addTweet call, tweetlist should has 1 tweet",tweetList.getCounts(),1);
		
		try{
			tweetList.addTweet(tweet);
		}catch(IllegalArgumentException e){
			return;
		}
		fail("Did not catch IllegalArgumentException when the same tweet is added");
	}
		
	public void testGetTweets(){
		TweetList tweetList =  new TweetList();
		NormalTweetModel tweet = new NormalTweetModel ("Second",new Date(2));
		tweetList.addTweet(tweet);
		NormalTweetModel tweet2 = new NormalTweetModel ("First",new Date(1));
		tweetList.addTweet(tweet2);
		NormalTweetModel tweet3 = new NormalTweetModel ("Third",new Date(3));
		tweetList.addTweet(tweet3);	
		
		LonelyTweetModel[] tweetArray = tweetList.getTweets();
		for (int i=1;i < tweetArray.length;i++){
			LonelyTweetModel previousTweet = tweetArray[i-1];
			LonelyTweetModel currentTweet = tweetArray[i];
			if ( currentTweet.getTimestamp().before(previousTweet.getTimestamp()) ){
				fail("currentTweet should not come after the previous tweet ");
			}
		}
		
	}
	
	
	
	
	
}
