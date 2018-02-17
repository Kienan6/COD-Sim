package model;

public enum Position {
	Player_Walking (50), Player_Sprinting (80), Player_Standing (0);
	
	private int speed;
	Position(int speed){
		this.speed = speed;
	}
	public int getSpeed() {
		return this.speed;
	}
}
