package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/***
 * Defines an Action of chanting and spawning Zombies
 * 
 * @author Saauren
 *
 */
public class ChantAction extends Action{
	
	ArrayList<Location> spawnLocations;
	
	public ChantAction(ArrayList<Location> zombieSpawnLocations) {
		
		this.spawnLocations = zombieSpawnLocations;
		
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		
		String[] zombieNames = {"Juaarg", "Baaaah", "Blazer", "Plunger", "Slumper"};

		
		for (int i = 0; i < 4; i++) {
			Zombie newZombie = new Zombie(zombieNames[i]);
			Location newLocation = spawnLocations.get(i);
			
			map.addActor(newZombie, newLocation);
		}
		
		String result = actor + " chanted, 5 zombies spawned!";
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		// do not hard code Mambo Marie actor as we may want to
		// give this action to another boss in the future for example
		String description = actor + " chants";
		
		return description;
	}
	
	

}
