package maps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;

import com.sun.prism.paint.Color;

public class Parser {
	private String filename;
	private BufferedImage map;
	private int[][] map2D;
	public Parser(String filename) {
		this.filename = filename;
	}
	public void findBMP() {
		// TODO Auto-generated method stub
		try {
			//load file
			this.map = ImageIO.read(getClass().getResource(this.filename));
			loadBMP(map);
		}
		catch(IOException e) {
			System.out.println(e.toString()+":Parser");
		}
		
	}
	private void loadBMP(BufferedImage map) {
		/*
		 * Generates a 2D matrix of the map
		 */
		map2D = new int[map.getHeight()][map.getWidth()];//Rows x Columns
		for(int xPix = 0; xPix < map.getHeight(); xPix++) {
			for(int yPix = 0; yPix < map.getWidth(); yPix++) {
				int color = map.getRGB(xPix, yPix);
				if(color == Color.BLACK.getIntArgbPre()) {
					map2D[xPix][yPix] = 1;
				} else
					map2D[xPix][yPix] = 0;
			}
		}
	}
	@Override
	public String toString() {
		String s = new String();
		for(int y = 0; y < map2D.length; y++) {
			for(int x = 0; x < map2D[0].length; x++) {
				s += map2D[x][y];
			}
			s += "\n";
		}
		return s;
	}
	public BufferedImage getImage() {
		return this.map;
	}
	public int[][] getMap2D() {
		return this.map2D;
	}
	
}
