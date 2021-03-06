package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/***
 * Defines the behaviour of how mambo Marie will spawn (appear) into map
 * @author Saauren
 *
 */
public class MarieSpawnBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		double chance = Math.random();
		
		
				
		if (!actor.getVisible() && (chance < 0.05)) {
			return new MarieSpawnAction(getRandEdgeLocation(map),true);
		}
		
		else if (actor.getTurns() % 30 == 0 && actor.isConscious()) {
			return new MarieSpawnAction(getRandEdgeLocation(map),false);
		}

		
		return null;
	}
	
	
	/***
	 * Computes a random location on the top edge of the map where MamboMarie
	 * will spawn
	 * 
	 * @param map The gamemap that was passed into getAction
	 * @return location the random location on the edge
	 */
	private Location getRandEdgeLocation(GameMap map){
		
		boolean isValidLocation = false;
		Location location = null;

		
		while (!isValidLocation) {
		
			int xEdge = map.getXRange().min() + (int)(Math.random() * ((map.getXRange().max() -  map.getXRange().min()) + 1));
			int yEdge = map.getYRange().min();
			location = new Location(map,xEdge,yEdge);
			
			if (!map.isAnActorAt(location)) {
				isValidLocation = true;
			}
		
		}
		
		
		return location;
	}
	

}
