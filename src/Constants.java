
public final class Constants {
	public static final int PORT = 6667;
	public static final String BROADCASTER = "<YOUR USERNAME HERE>"; // username of the broadcaster
	public static final String NICK = "<TWITCH NAME HERE>"; // username of Twitch account to connect
	public static final String LASTFM_USER = "<LAST.FM USERNAME HERE>";   // username of last.fm user to grab song data from
	public static final String CHANNEL = "<DESIRED TWITCH CHANNEL HERE>";	   // desired twitch channel to join (note: multiple supported)
	public static final String SERVER = "irc.twitch.tv";  
	public static final String PASSWORD = "<TWITCH OAUTH TOKEN>"; // twitch oauth token to connect to their irc network
	public static final String API_KEY = "<LAST.FM API>";	  // last.fm api key to properly query their api
	public static final int MESSAGE_DELAY = 10000;
	public static final int TIMED_MESSAGE_1 = 1800000; //time in milliseconds to delay message by; default is 1800000 (30 minutes)
	public static final int STATS_DELAY = 1200000; //time in milliseconds to delay stats by; default is 1200000 (20 minutes)
}