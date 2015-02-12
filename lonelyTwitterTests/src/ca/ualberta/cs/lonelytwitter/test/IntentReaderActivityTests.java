package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.R;

public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSendText(){
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text,IntentReaderActivity.NORMAL);
		assertEquals("got the text?",text,activity.getText());
	}
	
	public void testDoubleText(){
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text,IntentReaderActivity.DOUBLE);
		assertEquals("got the text?",text+text,activity.getText());
	}
	
	public void testReverse(){
		String text ="abc";
		//The following line is modified from an answer by Luchian Grigore on 
		//http://stackoverflow.com/questions/7569335/reverse-a-string-in-java
		String reversedText =new StringBuffer(text).reverse().toString(); 
		IntentReaderActivity activity = startWithText(text,IntentReaderActivity.REVERSE);
		assertEquals("text is not reversed",reversedText,activity.getText());
	}
	
	public void testDisplayText(){
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text,IntentReaderActivity.NORMAL);
		TextView view = (TextView)activity.findViewById(R.id.intentText);
		assertEquals("correct text?",text,view.getText());
	}
	
	public void testDefaultText(){
		IntentReaderActivity activity = startWithNoText(IntentReaderActivity.NORMAL);
		assertEquals("getText should return null",null,activity.getText());

	}
	
	public void testTextViewVisibility(){
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text,IntentReaderActivity.NORMAL);
		assertEquals("Textview is not visible!",View.VISIBLE, activity.findViewById(R.id.intentText).getVisibility());
	}
	
	private IntentReaderActivity startWithNoText(int mode){
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, mode);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
	}
	
	private IntentReaderActivity startWithText(String text, int mode){
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY,text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, mode);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
	}
	
	
}
