import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.pircbotx.Channel;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;


public class Predictions extends ListenerAdapter {
  Toolkit toolkit;
  Timer timer;

  // Threaded timer
  class EndTask extends TimerTask {
    private Channel channel;
    public EndTask(Channel c) {
      channel = c;
    }
    public void run() {
      channel.send().message("Prediction entries are now closed!  Good luck!");
      predsEnabled = false;
      waitingForFinalInput = true;
    }
  }
    
  // When predictions are accepted
  boolean predsEnabled = false;
  // When the game is waiting for final input from broadcaster
  boolean waitingForFinalInput = false;

  // Command that starts the game
  public static final String commandKey = "!preds";
  
  // Store predictions in a hash map
  Map<String, Double> userPredictions = new HashMap<>();
  
  // Pattern to match the following: minutes-seconds-subseconds, seconds-subseconds, whole numbers
  Pattern predictionPattern = Pattern.compile("(?:(?<minutes>\\d{1,2}):)?(?<seconds>\\d{1,2})(?:[:.](?<subseconds>\\d{1,3}))?");

  // Helper to send messages to the server
  public void sendMessage(MessageEvent event, String message) {
    event.getChannel().send().message(message);
  }
  
  // Match against the regex pattern, and convert all formats into seconds.subseconds format
  public Double getPrediction(String message) {
    Matcher m = predictionPattern.matcher(message);
  
    if (m.matches()) {
      String minutes = m.group("minutes");
      String seconds = m.group("seconds");
      String subseconds = m.group("subseconds");

      if(subseconds == null && minutes != null) {
        subseconds = seconds;
        seconds = minutes;
        minutes = null;
      }
      if (minutes == null)
         minutes = "0";
      if (subseconds == null)
         subseconds = "0";

      return Integer.parseInt(minutes) * 60 + Integer.parseInt(seconds) + Double.parseDouble("." + subseconds);
    }
    
    return null;
  }
  
  // Start the game if we receive the correct command from the broadcaster, and a game isn't already running
  public boolean shouldStartPreds(MessageEvent event) {
    if (event.getUser().getNick().equals(Constants.BROADCASTER) && event.getMessage().toLowerCase().startsWith(commandKey) && !predsEnabled) {
      predsEnabled = true;
      waitingForFinalInput = false;
      return true;
    }
    return false;
  }
  
  // Start the timer to stop receiving predictions
  public void endPreds(int seconds, MessageEvent event) {
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    timer.schedule(new EndTask(event.getChannel()), seconds * 1000);
  }
  
  // Determine and send message with the winning prediction and user
  public void displayWinner(Channel channel, Double finalTime) {
    double difference = Double.MAX_VALUE;
    List<String> closestUsers = new ArrayList<String>();
    double closestPrediction = 0;

    for(Map.Entry<String, Double> entry : userPredictions.entrySet()) {
      double predictionDifference = Math.abs(finalTime - entry.getValue());
      
      if (predictionDifference <= difference) {
        closestPrediction = entry.getValue();
        
        if (predictionDifference == difference) {
          closestUsers.add(entry.getKey());
        } else {
          closestUsers.clear();
          closestUsers.add(entry.getKey());
        }
        difference = predictionDifference;
      }
    }
    
    String closestPredictionMessage;
    
    if (closestPrediction > 60) {
      int minutes = (int) Math.floor(closestPrediction / 60);
      double seconds = closestPrediction - minutes * 60;
      closestPredictionMessage = String.format("%1$02d:%2$.2f", minutes, seconds);
    } else {
      closestPredictionMessage = Double.toString(closestPrediction);
    }

    
    channel.send().message("Congratulations to " + closestUsers + " with a prediction of " + closestPredictionMessage + "!");
    
    // Reset predictions
    userPredictions.clear();
    waitingForFinalInput = false;
  }

  public void onMessage(MessageEvent event) {
    String message = event.getMessage();
    
    if (shouldStartPreds(event)) {
      String[] params = message.split(" ");
      
      int predsDuration = 10;
      
      if (params.length > 1) {
        predsDuration = Integer.parseInt(params[1]);
      }
      
      sendMessage(event, "Enter your predictions now!  You have " + predsDuration + " seconds!");
      endPreds(predsDuration, event);
    } else if (predsEnabled) {
      Double prediction = getPrediction(event.getMessage());
      
      if (prediction != null) {
        userPredictions.put(event.getUser().getNick(), prediction);
      }
    } else if (waitingForFinalInput && event.getUser().getNick().equals(Constants.BROADCASTER)) {
      Double result = getPrediction(event.getMessage());
      
      if (result != null) {
        displayWinner(event.getChannel(), result);
      } 
    }
    
  }
}