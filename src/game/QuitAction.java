package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
/**
 * Defines an Action where the user quits the game
 * @author Saauren
 *
 */
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
	
}
