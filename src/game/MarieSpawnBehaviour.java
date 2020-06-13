package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;


public class MarieSpawnBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		double chance = Math.random();
		
		
				
		if (!actor.getVisible() && (chance < 1)) {
			return new MarieSpawnAction(getRandEdgeLocation(map),true);
		}
		
		else if (actor.getTurns() % 30 == 0 && actor.isConscious()) {
			return new MarieSpawnAction(getRandEdgeLocation(map),false);
		}

		
		return null;
	}
	
	
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
