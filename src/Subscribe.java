import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Subscribe extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if((event.getMessage().toLowerCase().contains("!subscribe") && !event.getUser().getNick().equals(Constants.NICK)) || (event.getMessage().toLowerCase().contains("!sub") && !event.getUser().getNick().equals(Constants.NICK))) {
			event.getChannel().send().message("You can subscribe to rays' stream here: https://secure.twitch.tv/products/raysfire/ticket . By subscribing, you'll get"
					+ " a unique sub icon next to your name in chat, and access to all of the sub-only emotes!");
		}
	}
	
}
