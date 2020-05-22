package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
/***
 * Class defining a Farmer
 * @author Saauren
 * 
 */
public class Farmer extends Human {
	// An array of behaviours that a Famer will use
	private Behaviour[] behaviours = {
			new SowBehaviour(),
			new FertilizeBehaviour(),
			new HarvestBehaviour(),
			new WanderBehaviour()
	};
	
	/*** 
	 * Constructor for a Farmer object maintains same hitpoints as Human
	 */
	protected Farmer() {
		super("Farmer", 'F', 50);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();
	}

}
