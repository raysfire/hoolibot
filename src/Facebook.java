import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Facebook extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!facebook") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("https://www.facebook.com/raysfiyah");
		}
	}
	
}
