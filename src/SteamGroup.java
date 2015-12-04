import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class SteamGroup extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!steam") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("If you'd like to know when I go live but don't want to have to rely on Twitch to send you an email, join my stream group here: http://steamcommunity.com/groups/raysinfo");
		}
	}
	
}
