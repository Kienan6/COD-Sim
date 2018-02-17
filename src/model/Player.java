package model;

import java.awt.Point;

public class Player {
	/*
	 * creates a basic player that has the ability to move,sprint,fire,melee,throw equipment **might add jump
	 */
	private Role role;//defines players role, used in ai logic
	private Team team;
	private Position player_position;//defines the players current status
	private int speed;//speed of the player
	private int[][] path;//path that the player has taken, x and y coordinates
	private boolean isFiring;
	private Point location;//current location of the player
	private int rotation; //where the player is at out of 360 degrees
	//possibly a hide feature to reset
	/*
	 * stats
	 */
	private int kills;
	private int deaths;
	
	public Player(Role role, Team team) {
		this.role = role;
		this.team = team;
		this.player_position = Position.Player_Walking;
		this.speed = this.player_position.getSpeed();
		this.path = new int[100][100];//only keep track of last 100
		location = new Point(10,10);
		if(team == Team.Team_Ally) {
			rotation = 0;
		} else {
			rotation = 180;
		}
		kills = 0;
		deaths = 0;
	}
	/*
	 * takes an integer between 0 and 360
	 */
	public void rotate(int direction) {
		this.rotation = direction;
	}
	public void setPosition(Position pos) {
		this.player_position = pos;
		this.speed = pos.getSpeed();
		//maybe add height here
	}
	//moves the player forward at the correct angle
	public void forward() {
		//speed * 0.3
		location.setLocation((location.getX() + (this.speed*0.3)*Math.cos(Math.toRadians(this.rotation))),
							(location.getY() + (this.speed*0.3)*Math.sin(Math.toRadians(this.rotation))));
	}
	/*
	 * getters and setters
	 */
	public int getRotation() {
		return this.rotation;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Position getPosition() {
		return player_position;
	}
	public boolean isFiring() {
		return isFiring;
	}
	public void setFiring(boolean isFiring) {
		this.isFiring = isFiring;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public int getSpeed() {
		return speed;
	}
	public int[][] getPath() {
		return path;
	}
	public int getKills() {
		return kills;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
}
