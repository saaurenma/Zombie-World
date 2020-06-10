package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

public class MamboMarie extends ZombieActor{
	
	private int marieTurns = 0;
	
	// use an array to store WanderBehaviour, since we may want to add more
	// in the future. Also ensures consistency with the other ZombieActor child
	// classes
	private Behaviour[] behaviours = {new WanderBehaviour(), new ChantBehaviour()};
	
	/**
	 * Constructor for MamboMarie, starts with 30 more hitpoints than a
	 * normal zombie
	 */
	public MamboMarie() {
		super("Mambo Marie", 'M', 130, ZombieCapability.UNDEAD);
		
	}
	
	
	public int getTurns() {
		return marieTurns;
	}
	

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		marieTurns++;
		
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();
	}
	
	

}
