import java.util.TreeMap;

import org.pircbotx.Channel;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import com.google.common.collect.ImmutableSortedSet;


public class Predictions extends ListenerAdapter {

	int count = 0; 
	private String result = "";
	boolean activePreds = false;
	boolean isMod = false;
	TreeMap<String, PredsUserData> currentPredInfo = new TreeMap<String, PredsUserData>();

	public void onMessage(MessageEvent event) {
		
		if(event.getUser().getNick().equals("raysfire")) {
			isMod = true;
		}
		
		if(event.getMessage().toLowerCase().equals("!preds_on") && isMod) {
			activePreds = true;
			event.getChannel().send().message("Predictions are enabled! Please send your prediction in the following format: '!pred x:y', where x is desired kills, and y is desired deaths.");
		}

		if(event.getMessage().toLowerCase().equals("!preds_off") && isMod) {
			activePreds = false;
			event.getChannel().send().message("Predictions are now closed for the current contest.");

		}

		if(event.getMessage().toLowerCase().contains("!pred") && activePreds) {
			String[] predInfo = event.getMessage().toLowerCase().split("[^0-9]+");
			PredsUserData currUser = new PredsUserData(predInfo);
			currentPredInfo.put(event.getUser().getNick(), currUser);
		}
		
		if(event.getMessage().toLowerCase().contains("!checkpred") && isMod) {
			String[] finalInfo = event.getMessage().toLowerCase().split("[^0-9]+");
			String rawKills = finalInfo[1];
			String rawDeaths = finalInfo[2];
			
			int kills = Integer.parseInt(rawKills);
			int deaths = Integer.parseInt(rawDeaths);
			
			for(String n : currentPredInfo.keySet()) {
				if(currentPredInfo.get(n).getKills() == kills && currentPredInfo.get(n).getDeaths() == deaths) {
					event.getChannel().send().message(n + " has won the pred contest!");
				}
			}
			
			//reset for next pred contest
			count = 0;
			result = "";
			activePreds = false;
			currentPredInfo.clear();
			isMod = false;
		}

		if(event.getMessage().toLowerCase().contains("!listpreds") && currentPredInfo.size() > 0) {
			result += "Current users with predictions: ";
			for(String n : currentPredInfo.keySet()) {
				result += n;
				count++;
				if(count != currentPredInfo.size()) {
					result += ", ";
				}
			}
			event.getChannel().send().message(result);
			result = "";
		}
	}
}