package organisms;

import organisms.Animals;
import mechanisms.ActiveGrowth;
import mechanisms.Move;
import mechanisms.CloneReproduction;
import projectLife.Position;
import projectLife.World;

public class Lion extends Animals {

	
	public Lion(Position position, World universe, int hit_points, int max_hit_points, int attack_power) {
		super(position, universe, hit_points, max_hit_points);
		this.attack_power = attack_power;
		this.sign = 'L';
		this.growing = new ActiveGrowth();
		this.movement = new Move();
		this.newOrganism = new CloneReproduction();
	}
	
	public Lion(Lion l) {
		super(l);
		this.attack_power = l.attack_power;	
		this.growing = l.growing;
		this.movement = l.movement;
		this.sign = l.sign;
		this.newOrganism = l.newOrganism;
	}
	
	@Override
	public Lion clone() {
		return new Lion(this);
	}
}