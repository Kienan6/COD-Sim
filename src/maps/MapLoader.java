package maps;

import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

public class MapLoader{
	/*
	 *Loads in all maps for use in views, gets notified on map change
	 *gets passed a map and gives the option of returning the 2d array
	 *or returning the bmp image
	 *
	 *Logic of image manipulation
	 */
	private Parser parser;
	public MapLoader(Map map) {
		parser = new Parser("/images/"+map.getMap());
		parser.findBMP();
	}
	/*
	 * parses the new map
	 */
	public void changeMap(Map map) {
		parser = new Parser("/images/"+map.getMap());
		parser.findBMP();
	}
	public int[][] getMap2D() {
		return parser.getMap2D();
	}
	public BufferedImage getMapImage() {
		return parser.getImage();
	}
	@Override
	public String toString() {
		return parser.toString();
	}
	/*
	 * Need to implement logic to split 1's into squares
	 * reasonable amount might be W*H/y where y is the number of tiles
	 * lets say we want 300x300
	 * or for each black just draw
	 */
}
