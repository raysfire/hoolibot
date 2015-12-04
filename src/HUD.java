import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class HUD extends ListenerAdapter {
	
	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!hud") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("You can get the HUD rays uses at rayshud.com. If you want his exact HUD settings, "
					+ "a download to his personal HUD is in the description below.");		
		}
	}
}
