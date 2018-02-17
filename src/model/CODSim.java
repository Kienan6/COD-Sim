package model;

import java.util.Observable;

import maps.Map;
import maps.MapLoader;

public class CODSim extends Observable{
	private MapLoader map;
	private Player player;
	public CODSim(Map map_name) {
		map = new MapLoader(map_name);
		//need to generate list of players
		player = new Player(Role.AR_Anchor, Team.Team_Ally);
	}
	/*
	 * Change the games map
	 */
	public void changeMap(Map m) {
		map.changeMap(m);
		setChanged();
		notifyObservers();
	}
	//gets the player object
	public Player getPlayer() {
		return this.player;
	}
	//gets the map object
	public MapLoader getMap() {
		return map;
	}
	public void rotatePlayer(int degrees) {
		System.out.println("X:"+player.getLocation().getX());
		System.out.println("Y:"+player.getLocation().getY());
		player.forward();
		System.out.println("X:"+player.getLocation().getX());
		System.out.println("Y:"+player.getLocation().getY());
		player.rotate(degrees);
		setChanged();
		notifyObservers();
	}
}
