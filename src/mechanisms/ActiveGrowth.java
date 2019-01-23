package mechanisms;

import organisms.AllFormsOfLife;
import mechanismsInterfaces.OrganismGrowingMechanism;

public class ActiveGrowth implements OrganismGrowingMechanism {

	@Override
	public void grow(int growth_value, AllFormsOfLife o) {
		if (o.getMaxHitPoints() > o.getHitPoints() + growth_value) {
			o.setHitPoints(growth_value + o.getHitPoints());
		}
	}

}