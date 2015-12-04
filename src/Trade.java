import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Trade extends ListenerAdapter {
	
	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!trade") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("To donate/trade items, you can send Rays a trade request here: http://bombch.us/lCM");		
		}
	}
}