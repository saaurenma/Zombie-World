package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class MarieSpawnAction extends Action{
	
	Location spawnLocation;

	public MarieSpawnAction(Location randEdgeLocation) {
		this.spawnLocation = randEdgeLocation;
	}

	@Override
	public String execute(Actor actor, GameMap map) {		
		
		String result = actor + " SPAWNED IN MAP! KILL HER!";
		map.addActor(actor, spawnLocation);
		
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		
		String description = actor + " spawns into map";
		
		return description;
	}

}
