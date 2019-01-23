package mechanisms;

import mechanismsInterfaces.OrganismGrowingMechanism;
import organisms.AllFormsOfLife;

public class PassiveGrowth implements OrganismGrowingMechanism {
	
	public void grow(int growth_value, AllFormsOfLife o) {
		
		if(o.getHitPoints() < o.getMaxHitPoints()) {
			o.setHitPoints(o.getHitPoints() + growth_value);
		}
	}
}