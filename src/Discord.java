import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Discord extends ListenerAdapter {

	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!discord") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("Interested in hanging with the community even when rays isn't live? Check out the community discord here:"
					+ " http://discord.raysfi.re/");
		}
	}
	
}
