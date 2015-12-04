
public class PredsUserData {
	
	private int kills;
	private int deaths;
	
	public PredsUserData(String[] data) {
		String rawKills = data[1];
		String rawDeaths = data[2];
		kills = Integer.parseInt(rawKills);
		deaths = Integer.parseInt(rawDeaths);
	}
	
	public int getKills() {
		return kills;
	}
	
	public int getDeaths() {
		return deaths;
	}
}
