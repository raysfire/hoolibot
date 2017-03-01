import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Tshirt extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!shirt") && !event.getUser().getNick().equals(Constants.NICK) ) {
			event.getChannel().send().message("Check out http://shirt.raysfi.re/ for your chance to get an exclusive, limited-edition raysfire"
					+ " zip-up hoodie!");
		}
	}
	
}
