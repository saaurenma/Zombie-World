package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ChantAction extends Action{

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		// do not hard code Mambo Marie actor as we may want to
		// give this action to another boss in the future for example
		
		String description = actor + " chants";
		
		return description;
	}
	
	

}
