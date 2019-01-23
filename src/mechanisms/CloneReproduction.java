package mechanisms;

import organisms.AllFormsOfLife;
import mechanismsInterfaces.NewOrganismMechanism;
import projectLife.World;

public class CloneReproduction implements NewOrganismMechanism {
	
	@Override
	public AllFormsOfLife reproduce(AllFormsOfLife o) {
		
		AllFormsOfLife neworg = o.clone();
		World currentWorld = neworg.getUniverse();
		neworg.setPosition(currentWorld.getRandomFreePosition());
		
		return neworg;
	}

}