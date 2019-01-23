package projectLife;
import organisms.Sheep;
import organisms.Lion;
import organisms.Grass;
import projectLife.World;
import organisms.AllFormsOfLife;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		new Game().start();
		
		World universe = new World("Testowy", 50, 25);
		
		Sheep s1 = new Sheep(new Position(1,2), universe, 10, 500, 1);
		Sheep s2 = new Sheep(new Position(3,4), universe, 10, 500, 1);
		Sheep s3 = new Sheep(new Position(14,2), universe, 10, 500, 1);
		Sheep s4 = new Sheep(new Position(27,3), universe, 10, 500, 1);
		Lion l1 = new Lion(new Position(1,3), universe, 10, 1000, 500);
		Lion l2 = new Lion(new Position(4,4), universe, 10, 1000, 500);
		
		universe.addOrganism(s1);
		universe.addOrganism(s2);
		universe.addOrganism(s3);
		universe.addOrganism(s4);
		universe.addOrganism(l1);
		universe.addOrganism(l2);

		for(int x=0; x < 1000; x++) {
			universe.makeTurn();
			System.out.print(universe);
			Thread.sleep(1000);
			System.out.print("\n\n");
			System.out.print("Owce: " + universe.getSheepCount());
			System.out.print("\nTrawa: " + universe.getGrassCount());
			System.out.print("\nLwy: " + universe.getLionCount());
			System.out.print("\n\n");
		}
	}
}













