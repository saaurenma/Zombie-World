package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class QuitAction extends Action {

	@Override
	public String execute(Actor actor, GameMap map) {
		String description = " quit the game.";
		return description;
	}

	@Override
	public String menuDescription(Actor actor) {
		String description = " quit game";
		return description;
	}

}
