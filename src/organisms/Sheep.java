package organisms;

import organisms.Animals;
import mechanisms.ActiveGrowth;
import mechanisms.Move;
import mechanisms.CloneReproduction;
import projectLife.Position;
import projectLife.World;

public class Sheep extends Animals {

	private final int NUTRITION = 100;

	public Sheep(Position position, World universe, int hit_points, int max_hit_points, int attack_power) {
		super(position, universe, hit_points, max_hit_points);
		this.attack_power = attack_power;
		this.sign = 'S';
		this.growing = new ActiveGrowth();
		this.movement = new Move();
		this.newOrganism = new CloneReproduction();
		
	}
	
	public Sheep(Sheep s) {
		super(s);
		this.attack_power = s.attack_power;	
		this.growing = s.growing;
		this.movement = s.movement;
		this.sign = s.sign;
		this.newOrganism = s.newOrganism;
	}
	
	public int getNUTRITION() {
		return NUTRITION;
	}
	
	@Override
	public Sheep clone() {
		return new Sheep(this);
	}
}