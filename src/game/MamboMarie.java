package game;

import java.util.Arrays;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

/***
 * Implements MamboMarie as a child class of Zombie
 * @author Saauren
 *
 */
public class MamboMarie extends ZombieActor{
	
	private int marieTurns = 0;
	
	// use an array to store WanderBehaviour, since we may want to add more
	// in the future. Also ensures consistency with the other ZombieActor child
	// classes
	private Behaviour[] behaviours = {new MarieSpawnBehaviour(), 
			new ChantBehaviour(),
			new WanderBehaviour()};
	private boolean visible;
	
	/**
	 * Constructor for MamboMarie, starts with 30 more hitpoints than a
	 * normal zombie
	 */
	public MamboMarie(boolean visible) {
		super("Mambo Marie", 'M', 130, ZombieCapability.UNDEAD);
		
		this.setVisibility(visible);
		
	}
	
	/***
	 * Sets the visibility of MamboMarie
	 * 
	 * @param visible Whether MamboMarie is visible or not
	 */
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
	
	/***
	 * Returns if MamboMarie is cvisible
	 * 
	 * @return visible True if visible, false if not
	 */
	public boolean getVisible() {
		return this.visible;
	}

	/***
	 * 
	 * Sets the number of turns that MamboMarie has gone through
	 * 
	 * @param turns The number of turns
	 */
	public void setTurns(int turns) {
		marieTurns = turns; 
	}
	
	/***
	 * Returns how many turns that MamboMarie has gone through
	 * 
	 * @return marieTurns The number of turns  MamboMarie has gone through
	 */
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
