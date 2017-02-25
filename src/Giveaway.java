import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Giveaway extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!amazon") && !event.getUser().getNick().equals(Constants.NICK) ) {
			event.getChannel().send().message("Want to win a $100 Amazon Gift Card? Check out this link for more information: http://giveaway.raysfi.re/");
		}
	}
	
}
