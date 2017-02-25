import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Marathon extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!marathon") && !event.getUser().getNick().equals(Constants.NICK) ) {
			event.getChannel().send().message("The Next Level Winter 2016 marathon is happening right now! Check out the "
					+ "schedule here: http://nextlevel.raysfi.re/");
		}
	}
	
}
