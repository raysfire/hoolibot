import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Rayserver extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!rayserver") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("You can connect to rays' own server here: rayserver.game.nfoservers.com , make sure to favorite it!");
		}
	}
	
}
