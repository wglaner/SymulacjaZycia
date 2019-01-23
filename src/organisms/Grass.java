package organisms;

import organisms.Plants;
import mechanisms.PassiveGrowth;
import mechanisms.CloneReproduction;
import mechanisms.NoMove;
import projectLife.Position;
import projectLife.World;

public class Grass extends Plants {
	
	private final int NUTRITION = 10;
	
	public Grass(Position position, World universe, int hit_points, int max_hit_points) {
		super(position, universe, hit_points, max_hit_points);
		this.sign = 'G';
		this.growing = new PassiveGrowth();
		this.newOrganism = new CloneReproduction();
		this.movement = new NoMove();
	}
	
	public Grass(Grass g) {
		super(g);
		this.sign = g.sign;
		this.growing = g.growing;
		this.newOrganism = g.newOrganism;
		this.movement = g.movement;
	}

	public int getNutrition() {
		return NUTRITION;
	}

	@Override
	public Grass clone() {
		return new Grass(this);
	}
	
}