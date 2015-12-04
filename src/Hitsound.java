import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Hitsound extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!hitsound") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("http://tf2dingalings.com/sound/details/1017");
		}
	}
	
}
