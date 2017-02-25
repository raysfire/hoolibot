import java.util.HashMap;
import java.util.Map;

import org.pircbotx.Channel;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class Poll extends ListenerAdapter {

	// Command that starts poll
	public static final String commandKey = "!poll";
	boolean pollEnabled = false;

	// Store options
	Map<Integer, String> pollOptions = new HashMap<>();
	int[] votes;

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

	public void displayResults(Channel channel) {
		channel.send().message("Results:");

		for(int i = 0; i < votes.length; i++) {
			channel.send().message(pollOptions.get(i) + ": " + votes[i]);
		}

		channel.send().message("Poll has ended!");
		// Reset poll options
		pollOptions.clear();
	}

	public void onMessage(MessageEvent event) {
		String message = event.getMessage();

		if (shouldStartPoll(event)) {
			String[] params = message.split(" ");

			if (params.length > 1) {
				votes = new int[params.length - 1];

				for (int i = 1; i < params.length; i++) {
					pollOptions.put(i-1, params[i]);
				}

				sendMessage(event, getPollOptions(params));
			} else {
				pollEnabled = false;
				return;
			}
		} else if (pollEnabled) {
			if (shouldEndPoll(event)) {
				sendMessage(event, getPollResults());
			}

			int voteKey = 0;
			try {
			  voteKey = Integer.parseInt(event.getMessage());
			} catch (NumberFormatException e) {
			  // not a valid vote
			}

			if (voteKey != 0) {
				votes[voteKey-1] = votes[voteKey-1] + 1;
			}
		}
	}

	protected String getPollResults() {
		StringBuilder builder = new StringBuilder("Poll has ended!  Here are the results: ");
		for (int i = 0; i < votes.length; i++) {
			builder.append(pollOptions.get(i)).append(": ").append(votes[i]);
			if (i != votes.length - 1) {
				builder.append(" | ");
			}
		}
			
		return builder.toString();
	}
	
	protected static String getPollOptions(String[] options) {
		StringBuilder builder = new StringBuilder("Poll Starting!  Vote on the following options: ");
		for (int i = 1; i < options.length; i++) {
			builder.append("Enter ").append(i).append(" for ").append(options[i]);
			if (i != options.length - 1) {
				builder.append(" | ");
			}
		}
			
		return builder.toString();
	}
}