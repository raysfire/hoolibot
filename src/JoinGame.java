import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class JoinGame extends ListenerAdapter {
	
	public void onMessage(MessageEvent event) throws IOException {
		
		String rawIP = "";
		Document doc = Jsoup.connect("http://steamcommunity.com/id/RaysFire").get();
		Elements links = doc.select("a[href]"); // a with href
		for(Element l : links) {
			if(l.attr("href").contains("connect") && l.attr("href").contains("steam")) {
				rawIP = l.attr("href");
			}			
		}
		
		if(event.getMessage().toLowerCase().contains("!ip") && !event.getUser().getNick().equals(Constants.NICK)) {
			
			if(rawIP.length() < 1) {
				event.getChannel().send().message("I'm either not playing TF2, steam's down or I'm offline on steam. If the latter is the case, bug me so that this works!");
			} else {
				String IP = rawIP.substring(16, rawIP.length());
				event.getChannel().send().message(IP + " is the current server I'm on. If you can't connect, I might be in a passworded game! Sorry!");
			}
		}
	}
}
	