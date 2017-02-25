import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Help extends ListenerAdapter {
	
	public void onMessage(MessageEvent event) {
		if((event.getMessage().toLowerCase().contains("!help") || event.getMessage().toLowerCase().contains("!commands")) && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("Available commands: !hud, !youtube, !donate, !about, !twitter, !cfg/!config, !ip, !song/!np, !prevsong/!lastplayed, !subscribe and !steam");
			event.getChannel().send().message("There are also a few hidden triggers for special responses.");
		}
	}
	
}
