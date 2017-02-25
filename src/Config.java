import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Config extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if((event.getMessage().toLowerCase().contains("!config") || event.getMessage().toLowerCase().contains("!cfg")) && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("You can download rays' config here: https://dl.dropboxusercontent.com/u/19762650/cfg/rayscfg-04212014.zip (Last updated 4/21/2014)");
		}
	}
	
}
