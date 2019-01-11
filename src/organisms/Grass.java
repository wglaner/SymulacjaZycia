package organisms;

import projektZycie.Board;
import projektZycie.Position;

public class Grass extends Plants{

	private int power = 0;
	private int initiative = 0;
	private Position position;
	private int liveLength = 5;
	private int powerToReproduce = 3;
	private char sign = 'S';
	
	public Grass(int power, int initiative, Position position, int liveLength, int powerToReproduce, char sign) {
		super();
		this.power = power;
		this.initiative = initiative;
		this.position = position;
		this.liveLength = liveLength;
		this.powerToReproduce = powerToReproduce;
		this.sign = sign;
	}

	
}
