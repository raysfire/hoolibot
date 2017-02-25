import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Youtube extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!youtube") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("http://youtube.com/raysfiyah");
		}
	}
	
}
