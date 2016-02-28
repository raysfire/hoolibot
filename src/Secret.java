import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Secret extends ListenerAdapter {
	
	public long lastCall = 0;
	
	public void onMessage(MessageEvent event) throws InterruptedException {
		
		String response = "";
		int delay = 10000; // 10 seconds in between responses minimum
		
		if(event.getMessage().equals("Bob Ross")) {
			event.getChannel().send().message("http://tf2bobross.deviantart.com/");		
		}
		
		if(event.getMessage().contains("FrankerZ")) {
			response += "FrankerZ ";
		}
		
		if(event.getMessage().contains("ZreknarF")) {
			response += "ZreknarF ";
		}
		
		if(event.getMessage().contains("LilZ")) {
			response += "LilZ ";
		}
		
		if(event.getMessage().contains("ZliL")) {
			response += "ZliL ";
		}
		
//		if(event.getMessage().toLowerCase().contains("washed taco")) {
//			event.getChannel().send().message("http://bombch.us/jb8");
//		}
		
		if(event.getMessage().contains("OhMyDog")) {
			response += "OhMyDog ";
		}
		
		if(event.getMessage().contains("RalpherZ")) {
			response += "RalpherZ ";
		}
		
		if(event.getMessage().contains("ZrehplaR")) {
			response += "ZrehplaR ";
		}
		
		if(event.getMessage().contains("CorgiDerp")) {
			response += "CorgiDerp ";
		}
		
		
		if(System.currentTimeMillis() - lastCall >= delay) {
			lastCall = System.currentTimeMillis();
			event.getChannel().send().message(response);
		}
		
	}
}
