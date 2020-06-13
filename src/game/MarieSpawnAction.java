package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class MarieSpawnAction extends Action{
	
	private Location spawnLocation;
	private boolean toSpawn;

	
	public MarieSpawnAction(Location randEdgeLocation, boolean toSpawn) {
		this.spawnLocation = randEdgeLocation;
		this.toSpawn = toSpawn;
	}

	@Override
	public String execute(Actor actor, GameMap map) {		
		String result;
		
		if (!this.toSpawn) {
			actor.setVisibility(false);
			map.moveActor(actor, spawnLocation);
			result = actor + " vanished... ";
			actor.setTurns(0);
		}
		
		else {
			actor.setVisibility(true);
			map.moveActor(actor, spawnLocation);
			result = actor + " SPAWNED IN MAP! KILL HER!";
		}
		
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		
		String description = actor + " spawns into map";
		
		return description;
	}

}
