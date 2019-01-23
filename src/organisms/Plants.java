package organisms;


import projectLife.Position;
import projectLife.World;

public abstract class Plants extends AllFormsOfLife {
	
	public Plants(Position position, World universe, int hit_points, int max_hit_points) {
		super(position, universe, hit_points, max_hit_points);

	}
	
	public abstract Plants clone();
	
	public Plants(Plants p) {
		super(p);
	}
}