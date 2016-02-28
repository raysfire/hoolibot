import org.apache.commons.lang3.time.StopWatch;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;


public class TimedMessage extends ListenerAdapter {

	public void onConnect(ConnectEvent event) throws InterruptedException {

		String timedMessage = "If you're enjoying the stream, consider following! You'll get a notification every time Rays goes live.";
		String timedMessage2 = "Interested in your very own raysfire zip-up hoodie? For a limited time, you can get one here: http://shirt.raysfi.re/";
		String timedMessage3 = "Want to win a $100 Amazon Gift Card? Enter now for your chance to win: http://giveaway.raysfi.re/";

		for(int i = 0; i >= 0; i++) {
			
			Thread.sleep(1200000);
			
			//cycle between three messages
			if(i % 3 == 0)
				event.respond("PRIVMSG " + Constants.CHANNEL + " :" + timedMessage);
			else if(i % 3 == 1)
				event.respond("PRIVMSG " + Constants.CHANNEL + " :" + timedMessage2);
			else if(i % 3 == 1)
				event.respond("PRIVMSG " + Constants.CHANNEL + " :" + timedMessage3);
		}
	}
}
