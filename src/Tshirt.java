import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Tshirt extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!shirt") && !event.getUser().getNick().equals(Constants.NICK) ) {
			event.getChannel().send().message("Official raysFox t-shirts are available now for the next few days! You can "
					+ "check them out here: http://shirt.raysfi.re/ If you do decide to buy one, thank you so much for your support! <3");
		}
	}
	
}
