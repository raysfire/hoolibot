import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Secret extends ListenerAdapter {
	
	public void onMessage(MessageEvent event) {
		if(event.getMessage().equals("Bob Ross")) {
			event.getChannel().send().message("http://tf2bobross.deviantart.com/");		
		}
		
		if(event.getMessage().contains("FrankerZ")) {
			event.getChannel().send().message("FrankerZ");
		}
		
		if(event.getMessage().contains("LilZ")) {
			event.getChannel().send().message("LilZ");
		}
		
		if(event.getMessage().contains("ZliL")) {
			event.getChannel().send().message("ZliL");
		}
		
		if(event.getMessage().contains("ZreknarF")) {
			event.getChannel().send().message("ZreknarF");
		}
		
//		if(event.getMessage().contains("raysFace")) {
//			event.getChannel().send().message("anime.rayshud.com");
//		}
		
		if(event.getMessage().toLowerCase().contains("washed taco")) {
			event.getChannel().send().message("http://bombch.us/jb8");
		}
	}
}
