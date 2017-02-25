import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;

public class CounterStats extends ListenerAdapter {

	public void onConnect(ConnectEvent event) throws InterruptedException {

		
		for(int i = 0; i < 1;) {
			Thread.sleep(Constants.STATS_DELAY);
			String newCounts = "Hooligan count: " + Counters.hooligans + " || Dingus count: " + Counters.dingus + " || Big play count: " + Counters.bigPlays;
			event.respond("PRIVMSG " + Constants.CHANNEL + " :" + newCounts);
		}
	}
	
}
