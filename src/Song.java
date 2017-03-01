import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Song extends ListenerAdapter {
	
	public void onMessage(MessageEvent event) {
		LastFM l = new LastFM();
		if((event.getMessage().toLowerCase().contains("!song") || event.getMessage().toLowerCase().contains("!np")) && !event.getUser().getNick().equals(Constants.NICK)) {
			event.respond(l.nowPlaying());
		}
		
		if((event.getMessage().toLowerCase().contains("!prevsong") || event.getMessage().toLowerCase().contains("!lastplayed")) && !event.getUser().getNick().equals(Constants.NICK)) {
			event.respond(l.lastPlayed());
		}
	}
}
