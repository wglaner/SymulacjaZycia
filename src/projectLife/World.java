package projectLife;


import java.util.ArrayList;
import java.util.Random;
import organisms.AllFormsOfLife;
import organisms.Animals;
import organisms.Coyote;
import organisms.Dandelion;
import organisms.Grass;
import organisms.Lion;
import organisms.MagicMushroom;
import organisms.Plants;
import organisms.Sheep;


public class World {
	
	private ArrayList<AllFormsOfLife> inhabitants = new ArrayList<AllFormsOfLife>();
	private ArrayList<AllFormsOfLife> spawned_organisms = new ArrayList<AllFormsOfLife>();
	private String name;
	private int layoutX;
	private int layoutY;
	private int grassCount = 0;
	private int sheepCount = 0;
	private int wolfCount = 0;
	private final String separator = " ";
	
	public World(String name, int width, int length) {
		this.name = name;
		this.layoutX = width;
		this.layoutY = length;
		
	}
	public ArrayList<AllFormsOfLife> getInhabitants() {
		return inhabitants;
	}
	public void setInhabitants(ArrayList<AllFormsOfLife> inhabitants) {
		this.inhabitants = inhabitants;
	}
	public String getName() {
		return this.name;
	}
	public int getLayoutX() {
		return layoutX;
	}
	public void setLayoutX(int width) {
		this.layoutX = width;
	}
	public int getLayoutY() {
		return layoutY;
	}
	
	public int getGrassCount() {
		return grassCount;
	}
	public void setGrassCount(int grassCount) {
		this.grassCount = grassCount;
	}
	public int getSheepCount() {
		return sheepCount;
	}
	public void setSheepCount(int sheepCount) {
		this.sheepCount = sheepCount;
	}
	public int getWolfCount() {
		return wolfCount;
	}
	public void setWolfCount(int wolfCount) {
		this.wolfCount = wolfCount;
	}
	public void setLayoutY(int length) {
		this.layoutY = length;
	}
    public String getSeparator() {
		return separator;
	}
    public void removeDeadOrganisms() {
    	inhabitants.removeIf(org -> org.getPosition().getX() == -1 && org.getPosition().getY() == -1);
    }
    public void addNewOrganisms() {
    	for (AllFormsOfLife o : spawned_organisms) {
    		this.addOrganism(o);
    	}
    }
    public Position getRandomFreePosition() {
    	ArrayList<Position> freePositions = new ArrayList<Position>();
    	for (int y = 0; y <= this.getLayoutY(); y++){
            for (int x=0; x <= this.getLayoutX(); x++){
            	if (getOrganismFromPosition(new Position (x, y)) == null) {
            		freePositions.add(new Position(x, y));
            	}
            }
    	}
    	if (freePositions.isEmpty()) { return (new Position(-1, -1)); }
    	
    	Random random = new Random();
    	Position randpos = freePositions.get(random.nextInt(freePositions.size()));
    
    	return randpos;
    }
    
    public boolean addOrganism(AllFormsOfLife org) {
        if (org.getPosition().getX() >= 0 && org.getPosition().getY() >= 0 && org.getPosition().getX() <= this.layoutX && org.getPosition().getY() <= this.layoutY) {
            inhabitants.add(org);
            return true;
        }
        else { return false; }
    }
    
    public AllFormsOfLife getOrganismFromPosition(Position position){
        AllFormsOfLife temp_organism = null;
        for(AllFormsOfLife org : this.inhabitants) {
            if (org.getPosition().equals(position)) {
                temp_organism = org;
                break;
            }
        }
        return temp_organism;
    }
    
    public ArrayList<AllFormsOfLife> getAllOrganismsFromPosition(Position position){
        ArrayList<AllFormsOfLife> all_organisms = new ArrayList<AllFormsOfLife>();
        for(AllFormsOfLife org : this.inhabitants) {
            if (org.getPosition().equals(position)) {
                all_organisms.add(org);
            }
        }
        return all_organisms;
    }
    
    public void makeTurn() {
    	for(AllFormsOfLife org : this.inhabitants) {
    		Position new_pos = org.getMovement().move(org);
    		checkCollisions(getAllOrganismsFromPosition(new_pos));
    		if (org instanceof Grass) {
    			org.getGrowing().grow(1, org);
    		}
    	}
    	updateWorldStatus();
    	balance();
    	removeDeadOrganisms();
    	addNewOrganisms();
    	updateWorldStatus();
    	balance();
    	spawned_organisms.clear();
    }
    
    public void checkCollisions(ArrayList<Organism> all_orgs){
    	switch (all_orgs.size()) {
    		case 1:
    			break;
    		case 2:
    			Organism inhabitant = all_orgs.get(0);
    			Organism intruder = all_orgs.get(1); 	
    			collision(inhabitant, intruder);
    			break;
    	}
    }   
    
    public void collision(Organism inhabitant, Organism intruder) {
		
    	if (intruder instanceof Sheep) {
			
			if (inhabitant instanceof Grass) {
				intruder.getGrowing().grow(((Grass) inhabitant).getNutrition(), intruder);
				inhabitant.setPosition(new Position(-1, -1));
			}
			else if (inhabitant instanceof Sheep) {
				spawned_organisms.add(intruder.getReproduction().reproduce(intruder));
			}
			else if (inhabitant instanceof Wolf) {
				inhabitant.getGrowing().grow(((Sheep) intruder).getNUTRITION(), inhabitant);
				intruder.setPosition(new Position(-1, -1));
			}
		}
		else if (intruder instanceof Grass) {
			
			if (inhabitant instanceof Sheep) {
				inhabitant.getGrowing().grow(((Grass) intruder).getNutrition(), inhabitant);
				intruder.setPosition(new Position(-1, -1));
			}
		}
		else if (intruder instanceof Wolf) {
			
			if (inhabitant instanceof Wolf) {
				spawned_organisms.add(intruder.getReproduction().reproduce(intruder));
			}
			else if (inhabitant instanceof Sheep) {
				intruder.getGrowing().grow(((Sheep) inhabitant).getNUTRITION(), intruder);
				inhabitant.setPosition(new Position(-1, -1));
			}
		}
    }
    public void updateWorldStatus() {
    	
    	setGrassCount(0);
    	setSheepCount(0);
    	setWolfCount(0);
    	
    	for (AllFormsOfLife o : inhabitants) {
    		if (o instanceof Grass) {
    			setGrassCount(getGrassCount() + 1);
    		}
    		else if (o instanceof Sheep) {
    			setSheepCount(getSheepCount() + 1);
    		}
    		else if (o instanceof Lion) {
    			setWolfCount(getLionCount() + 1);
    		}
    	}
    }
    
    public void balance() {
    	
    	/*DO ZROBIENIA!!!!
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 */
    }
    
	public String toString() {
		String result = "";
        for (int i=0; i < this.layoutX + 5;i++) {
        	result += '%';
        }
        result += "\n";
        for (int y=0; y <= this.getLayoutY(); y++){
        	result += "% ";
            for (int x=0; x <= this.getLayoutX(); x++){
                AllFormsOfLife org = this.getOrganismFromPosition(new Position(x, y));
                if (org != null){
                    result += org.getSign();
                }
                else {
                    result += this.getSeparator();
                }
            }
            result += " %\n";
        }
        for (int i=0; i < this.layoutX + 5;i++) {
        	result += '%';
        }
        result += "\n";
        return result;
	}
}