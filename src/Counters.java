import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.MessageEvent;


public class Counters extends ListenerAdapter {
	
	static int bigPlays;
	static int hooligans;
	static int dingus;
	
	public void onMessage(MessageEvent event) {
		if(event.getMessage().toLowerCase().contains("big play")) {
			bigPlays++;
		}
		
		if(event.getMessage().toLowerCase().contains("dingus")) {
			dingus++;
		}
		
		if(event.getMessage().toLowerCase().contains("hooligan")) {
			hooligans++;
		}
	}
	
}
