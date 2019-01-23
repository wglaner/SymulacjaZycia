package organisms;


import projectLife.Position;
import projectLife.World;

public abstract class Animals extends AllFormsOfLife {
	
	protected int attack_power;

	public Animals(Position position, World universe, int hit_points, int max_hit_points) {
		super(position, universe, hit_points, max_hit_points);
	}
	
	public abstract Animals clone();
	
	public Animals(Animals a) {
		super(a);
	}
}