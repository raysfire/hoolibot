import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.pircbotx.Channel;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Poll extends ListenerAdapter {

	// Command that starts poll
	public static final String commandKey = "!poll";
	boolean pollEnabled = false;

	// Store options
	Map<Integer, String> pollOptions = new HashMap<>();
	
	// Store votes
	Map<UUID, Integer> userVotes = new HashMap<>();

	// Helper to send messages to the server
	public void sendMessage(MessageEvent event, String message) {
		event.getChannel().send().message(message);
	}

	public boolean shouldStartPoll(MessageEvent event) {
		if (event.getUser().getNick().equals(Constants.BROADCASTER)
				&& event.getMessage().toLowerCase().startsWith(commandKey) && !pollEnabled) {
			pollEnabled = true;
			return true;
		}
		return false;
	}

	public boolean shouldEndPoll(MessageEvent event) {
		if (event.getUser().getNick().equals(Constants.BROADCASTER)
				&& event.getMessage().toLowerCase().startsWith(commandKey) && pollEnabled) {
			pollEnabled = false;
			return true;
		}
		return false;
	}

	public void onMessage(MessageEvent event) {
		String message = event.getMessage();

		if (shouldStartPoll(event)) {
			String params = message.substring(message.indexOf(' ') + 1);
			
			if (!params.isEmpty()) {
				String[] options = params.split(", ");

				for (int i = 0; i < options.length; i++) {
					pollOptions.put(i, options[i]);
				}

				sendMessage(event, getPollOptions());
			} else {
				pollEnabled = false;
				return;
			}
		} else if (pollEnabled) {
			if (shouldEndPoll(event)) {
				sendMessage(event, getPollResults());
				pollOptions.clear();
				userVotes.clear();
			}

			int voteKey = 0;
			try {
			  voteKey = Integer.parseInt(event.getMessage());
			  
			  // decrement 1 to match the poll options keys
			  Object optionValue = pollOptions.get(voteKey - 1);
			  
			  if (optionValue != null) {
				  userVotes.put(event.getUser().getUserId(), voteKey - 1);
			  }
			} catch (NumberFormatException e) {
			  // not a valid vote
			}
		}
	}

	protected String getPollResults() {
		StringBuilder builder = new StringBuilder("Poll has ended!  Here are the results: ");
		
		for (int key : pollOptions.keySet()) {
			builder.append(" | ");
			int count = Collections.frequency(userVotes.values(), key);
			builder.append(pollOptions.get(key)).append(": ").append(count);
		}
			
		return builder.toString();
	}
	
	protected String getPollOptions() {
		StringBuilder builder = new StringBuilder("Poll Starting!  Vote on the following options: ");
		for (Map.Entry<Integer, String> entry : pollOptions.entrySet()) {
			builder.append(" | ");
			builder.append("Enter ").append(entry.getKey() + 1).append(" for ").append(entry.getValue());
		}
			
		return builder.toString();
	}
}