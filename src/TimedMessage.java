import org.apache.commons.lang3.time.StopWatch;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;


public class TimedMessage extends ListenerAdapter {

	public void onConnect(ConnectEvent event) throws InterruptedException {

		String timedMessage = "If you're enjoying the stream, consider following! You'll get a notification every time Rays goes live.";
		String timedMessage2 = "Interested in a limited edition raysfire t-shirt? Check it out here: http://shirt.raysfi.re/ Want to win one free? "
				+ "Enter the giveaway! http://giveaway.raysfi.re/";
		
		for(int i = 0; i >= 0; i++) {
			
			Thread.sleep(1800000);
			
			//cycle between two messages
			if(i % 2 == 0)
				event.respond("PRIVMSG " + Constants.CHANNEL + " :" + timedMessage);
			else if(i % 2 == 1)
				event.respond("PRIVMSG " + Constants.CHANNEL + " :" + timedMessage2);
		}
	}
}
