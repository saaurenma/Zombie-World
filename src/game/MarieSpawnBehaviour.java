package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;


public class MarieSpawnBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		if (!map.contains(actor)) {
			double chance = Math.random();
			
			if (chance < 0.5) {
				map.addActor(actor,);
			}
			
		}
	}
	
	
	private ArrayList<int> getSpawnLocations(){
		ArrayList<Location> locations = new 
	}
	

}
