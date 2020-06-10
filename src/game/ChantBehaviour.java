package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;


public class ChantBehaviour implements Behaviour {

	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		ArrayList<Location> zombieLocations =  new ArrayList<Location>();

		
		for (int i = 0; i < 4; i++) {
			Location spawnLocation = null;

			boolean validCoordinate = false;
			while (!validCoordinate) {
				
				int newX = map.getXRange().min() + (int)(Math.random() * 
						((map.getXRange().max() - map.getXRange().min()) + 1));
				
				int newY = map.getYRange().min() + (int)(Math.random() * 
						((map.getYRange().max() - map.getYRange().min()) + 1));
				
				spawnLocation = new Location(map, newX, newY);
				
				if (map.isAnActorAt(spawnLocation)) {
					validCoordinate = false;
				}
				
				else {
					validCoordinate = true;
				}
			
			}
			
			zombieLocations.add(spawnLocation);
			
		}
		
		if (actor.getTurns() % 10 == 0) {
			return new ChantAction(zombieLocations);
		}
		
		else {
			return null;
		}
	}

}
