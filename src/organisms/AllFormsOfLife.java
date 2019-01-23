package organisms;
import projectLife.Position;
import projectLife.World;
import mechanismsInterfaces.*;


public abstract class AllFormsOfLife {
	
	protected OrganismGrowingMechanism growing;
	protected NewOrganismMechanism newOrganism;
	protected MoveMechanism movement;
	protected Position position;
	protected World universe;
	protected int hit_points;
	protected int max_hit_points;
	protected char sign;

	public AllFormsOfLife(Position position, World universe, int hit_points, int max_hit_points) {
		this.position = new Position(position);
		this.universe = universe;
		this.hit_points = hit_points;
		this.max_hit_points = max_hit_points;
	}
	
	public AllFormsOfLife(AllFormsOfLife org) {
		this.position = new Position(org.position);
		this.universe = org.universe;
		this.hit_points = org.hit_points;
		this.max_hit_points = org.max_hit_points;
	}
	public abstract AllFormsOfLife clone();
	
	public int getMaxHitPoints() {
		return max_hit_points;
	}

	public void setMaxHitPoints(int max_hit_points) {
		this.max_hit_points = max_hit_points;
	}

	public OrganismGrowingMechanism getGrowing() {
		return growing;
	}
	
	public void setGrowing(OrganismGrowingMechanism growing) {
		this.growing = growing;
	}
	
	public MoveMechanism getMovement() {
		return movement;
	}
	
	public NewOrganismMechanism getReproduction() {
		return newOrganism;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public World getUniverse() {
		return universe;
	}
	
	public void setUniverse(World universe) {
		this.universe = universe;
	}
	
	public void setHitPoints(int hit_points) {
		this.hit_points = hit_points;
	}
	
	public int getHitPoints() {
		return hit_points;
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "" + sign;
	}
}
