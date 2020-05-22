package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

public class Farmer extends Human {
	
	private Behaviour[] behaviours = {
			new SowBehaviour(),
			new FertilizeBehaviour(),
			new WanderBehaviour()
	};
	
	protected Farmer(int hitPoints) {
		super("farmer", 'F', hitPoints);
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
