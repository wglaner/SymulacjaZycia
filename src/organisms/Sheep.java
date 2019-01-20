package organisms;

import projektZycie.Board;
import projektZycie.Position;

public class Sheep extends Animals {
	
	private int power = 3;
	private int initiative = 3;
	private int liveLength;
	private int powerToReproduce;
	private char sign = 'S';
	private Board board;
	
	
	
	public Sheep(int power, int initiative, Position position, Position lastPosition, int liveLength,
			int powerToReproduce, char sign, Board board) {
		super();
		this.power = power;
		this.initiative = initiative;
		this.position = position;
		this.lastPosition = lastPosition;
		this.liveLength = liveLength;
		this.powerToReproduce = powerToReproduce;
		this.sign = sign;
		this.board = board;
	}
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Position getLastPosition() {
		return lastPosition;
	}
	public void setLastPosition(Position lastPosition) {
		this.lastPosition = lastPosition;
	}
	public int getLiveLength() {
		return liveLength;
	}
	public void setLiveLength(int liveLength) {
		this.liveLength = liveLength;
	}
	public int getPowerToReproduce() {
		return powerToReproduce;
	}
	public void setPowerToReproduce(int powerToReproduce) {
		this.powerToReproduce = powerToReproduce;
	}
	public char getSign() {
		return sign;
	}
	public void setSign(char sign) {
		this.sign = sign;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
			

	

}
