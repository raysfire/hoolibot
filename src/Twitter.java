import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Twitter extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!twitter") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("http://twitter.com/raysfire");
		}
	}
	
}
