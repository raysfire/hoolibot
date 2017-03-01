import java.io.IOException;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

public class Connection {
	
	public static void main (String args[]) throws IOException {
		
		//Setup this bot		
		Configuration config = new Configuration.Builder() //create intial configuration builder
		.setName(Constants.NICK) //Set the nick of the bot
		.addServer(Constants.SERVER)
		.setServerPassword(Constants.PASSWORD)
		.setMessageDelay(2000)
		.setAutoNickChange(false) //Automatically change nick when the current one is in use
		.addAutoJoinChannel(Constants.CHANNEL) //Join the user channel
		
		.addListener(new TimedMessage())
		.addListener(new Trade())
		.addListener(new HUD())
		.addListener(new SteamGroup())
		.addListener(new Hitsound())
		.addListener(new Youtube())
		.addListener(new Twitter())
		//.addListener(new Counters()) // Not currently in use
		.addListener(new Secret())
		.addListener(new Donate())
		.addListener(new Config())
		.addListener(new Help())
		.addListener(new About())
		.addListener(new Song())
		.addListener(new JoinGame())
		.addListener(new Rayserver())
		.addListener(new Subscribe())
		.addListener(new Tshirt()) // Not currently in use
		.addListener(new Facebook())
		.addListener(new Discord())
		.addListener(new Giveaway())
		.addListener(new Marathon())
		.addListener(new Poll())
		
		.buildConfiguration();

		PircBotX bot = new PircBotX(config);
		
		//Connect to server
		try {
			bot.startBot();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}