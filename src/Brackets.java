import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Brackets extends ListenerAdapter {
	
	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("!bracket") && !event.getUser().getNick().equals(Constants.NICK)) {
			event.getChannel().send().message("ESEA S18 TF2 LAN Brackets: http://play.esea.net/index.php?s=league&d=bracket&id=5795");		
		}
	}
}
