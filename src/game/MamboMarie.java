package game;

import java.util.Arrays;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

public class MamboMarie extends Zombie{
	
	private int marieTurns = 0;
	
	// use an array to store WanderBehaviour, since we may want to add more
	// in the future. Also ensures consistency with the other ZombieActor child
	// classes
	private Behaviour[] behaviours = {new MarieSpawnBehaviour(), 
			new ChantBehaviour(),
			new WanderBehaviour()};
	
	/**
	 * Constructor for MamboMarie, starts with 30 more hitpoints than a
	 * normal zombie
	 */
	
	private boolean visible;
	
	public MamboMarie(boolean visible) {
		super("Mambo Marie", 'M', 130);
		
		this.setVisibility(visible);
		
	}
	
	public void setVisibility(boolean visible) {
		
		if (visible == false) {
			this.visible = false;
			this.displayChar = '.';
		}
		
		else if (visible == true) {
			this.visible = true;
			this.displayChar = 'M';
			
		}
		
	}
	
	public boolean getVisible() {
		return this.visible;
	}

	
	public void setTurns(int turns) {
		marieTurns = turns; 
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
