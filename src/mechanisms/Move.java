package mechanisms;

import java.util.Random;

import mechanismsInterfaces.MoveMechanism;
import organisms.AllFormsOfLife;
import projectLife.Position;
import projectLife.World;

public class Move implements MoveMechanism {
		
	private final int MOVE_UP = 0;
	private final int MOVE_DOWN = 1;
	private final int MOVE_LEFT = 2;
	private final int MOVE_RIGHT = 3;
	private final int MOVE_UP_LEFT = 4;
	private final int MOVE_UP_RIGHT = 5;
	private final int MOVE_DOWN_RIGHT = 6;
	private final int MOVE_DOWN_LEFT = 7;
	
	
	public Position move(AllFormsOfLife o) {
		Random random = new Random();
		Position position = o.getPosition();
		World world = o.getUniverse();
		int direction = random.nextInt(7);
		
		int boundryX = world.getLayoutX();
		int boundryY = world.getLayoutX();
		
		
		switch (direction) {
		
		case MOVE_UP:
			if ((position.getY() - 1) >= 0) {
				position.setY(position.getY() - 1);
			}
			break;
		case MOVE_DOWN:
			if ((position.getY() + 1) <=boundryY) {
				position.setY(position.getY() + 1);
			}
			break;
		case MOVE_LEFT:
			if ((position.getX() - 1) >=0) {
				position.setY(position.getX() - 1);
			}
			break;
		case MOVE_RIGHT:
			if ((position.getX() + 1) <=boundryX) {
				position.setY(position.getX() + 1);
			}
			break;
		case MOVE_UP_RIGHT:
			if (((position.getY() - 1) <=boundryX) && ((position.getX() + 1) <=boundryX)) {
				position.setY(position.getY() - 1);
				position.setX(position.getX() + 1);
			}
			break;
		case MOVE_UP_LEFT:
			if (((position.getY() - 1) <=boundryX) && ((position.getX() - 1) <=boundryX)) {
				position.setY(position.getY() - 1);
				position.setX(position.getX() - 1);
			}
			break;
		case MOVE_DOWN_RIGHT:
			if (((position.getY() + 1) <=boundryX) && ((position.getX() + 1) <=boundryX)) {
				position.setY(position.getY() + 1);
				position.setX(position.getX() + 1);
			}
			break;
		case MOVE_DOWN_LEFT:
			if (((position.getY() + 1) <=boundryX) && ((position.getX() - 1) <=boundryX)) {
				position.setY(position.getY() + 1);
				position.setX(position.getX() - 1);
			}
			break;
		
		}
		return o.getPosition();
	}
	
}
