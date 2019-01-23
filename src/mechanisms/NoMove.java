package mechanisms;

import mechanismsInterfaces.MoveMechanism;
import projectLife.Position;
import organisms.AllFormsOfLife;

public class NoMove implements MoveMechanism {

	@Override
	public Position move(AllFormsOfLife o) {
		return o.getPosition();
	}

}