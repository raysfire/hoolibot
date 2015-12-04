import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Donate extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!donate") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("You can donate to rays here: https://streamtip.com/t/raysfire <3");
		}
	}
	
}
