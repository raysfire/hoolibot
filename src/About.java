import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class About extends ListenerAdapter {
	
	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!about") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("Hooliganmaster420 made by rays, 2014, using the PircBotX java framework.");
		}
	}
}
