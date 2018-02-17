package maps;

public enum Map {
	London ("london.bmp"), StMarie ("st_marie.bmp");
	
	private final String mapName;
	
	Map(String m) {
		this.mapName = m;
	}
	/*
	 * returns the map file name
	 */
	public String getMap() {
		return this.mapName;
	}
}
