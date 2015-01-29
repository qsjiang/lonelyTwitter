package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSample(){
		//fail("This is a failing test");
		//assertFalse("This is a failed value",isGreaterThan(5,6));
		assertEquals("5 is equal to 5",5,5);
	}
	
	public void testEquals(){
		Date date = new Date();
		NormalTweetModel tweet1 = new NormalTweetModel("Hello",new Date(123));
		NormalTweetModel tweet2 = new NormalTweetModel("Hello",new Date(123));
		assertTrue("Different tweets are different",tweet1.equals(tweet2));
	}
	
	private boolean isGreaterThan(int i, int j){
		if(i>j){
			return true;
		}else{
			return false;
		}
	}
	
}
