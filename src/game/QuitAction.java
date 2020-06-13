package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class QuitAction extends Action {

	@Override
	public String execute(Actor actor, GameMap map) {
		if (actor.hasCapability(WinStateCapability.LOSE)) {
			System.out.println(actor + " Lost");
		}
		
		else if (actor.hasCapability(WinStateCapability.WIN)) {
			System.out.println(actor + " Won");
		}
		else {
			System.out.println("Game was quit prematurely");
		}
		System.out.println();
		System.exit(0);
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		String description = "Quit game";
		return description;
	}
	
	@Override
	public String hotkey() {
		return "q";
	}
	
	private boolean checkIfHumansAlive(GameMap map) {
		int xMax = map.getXRange().max();
		int yMax = map.getYRange().max();
		
		for (int x = map.getXRange().min(); x<xMax; x++) {
			for (int y = map.getYRange().min(); y<yMax; y++) {
				
				if (!map.isAnActorAt(map.at(x, y))) {
					continue;
				}
				
				Actor actorAtLocation = (map.at(x, y)).getActor();
				if ((actorAtLocation instanceof Human) && ((map.at(x, y)).getActor().hasCapability(ZombieCapability.ALIVE))){
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkIfZombiesAlive(GameMap map) {
		int xMax = map.getXRange().max();
		int yMax = map.getYRange().max();
		
		for (int x = map.getXRange().min(); x<xMax; x++) {
			for (int y = map.getYRange().min(); y<yMax; y++) {
				
				if (!map.isAnActorAt(map.at(x, y))) {
					continue;
				}
				
				Actor actorAtLocation = (map.at(x, y)).getActor();
				if ((actorAtLocation instanceof Zombie) && ((map.at(x, y)).getActor().hasCapability(ZombieCapability.UNDEAD))){
					return true;
				}
			}
		}
		
		return false;
	}
}
