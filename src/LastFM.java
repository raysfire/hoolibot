import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class LastFM {

	private static final String NAME = "name";
	private static final String ALBUM = "album";
	private static final String ARTIST = "artist";

	private List<Element> track;
	private String title;
	private String artist;
	private String album;

	public LastFM() {

		SAXBuilder saxBuilder = new SAXBuilder();
		Document doc = new Document();
		try {
			doc = saxBuilder.build("http://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user=" + Constants.LASTFM_USER + "&api_key=" + Constants.API_KEY);
			Element rootNode = doc.getRootElement();
			List<Element> songNodes = rootNode.getChildren();
			track = (songNodes.get(0).getChildren("track"));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String nowPlaying() {
		
		if(!track.get(0).hasAttributes()) {
			return "I'm either not listening to my playlist or listening to no music at all. If I am listening to something and you want to know what it is, just ask me in chat!";
		}
		
		if(track.size() > 0) {
			title =	encode(track.get(0).getChildText(NAME));
			artist = encode(track.get(0).getChildText(ARTIST));
			album = encode(track.get(0).getChildText(ALBUM));
		}
		
		if(album.length() > 1) {
			return title + " - " + artist + " (Album: " + album + ")";	
		} else {
			return title + " - " + artist;
		}
	}

	public String lastPlayed() {	

		if(track.size() > 1) {
			title = encode(track.get(1).getChildText(NAME));
			artist = encode(track.get(1).getChildText(ARTIST));
			album = encode(track.get(1).getChildText(ALBUM));
		}

		if(album.length() > 1) {
			return title + " - " + artist + " (Album: " + album + ")";	
		} else {
			return title + " - " + artist;
		}
	}
	
	//encodes to utf-8 for chat display
	public String encode(String data) {
        try {
			data = new String(data.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return data;
	}
	
	
	
}
