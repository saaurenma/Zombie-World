package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class FireShotgunAction extends Action {
	
	private String direction;
	private String hotkey;

	public FireShotgunAction(String direction, String hotkey) {
		this.direction = direction;
		this.hotkey = hotkey;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		System.out.println("DOG");
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return (actor + " fires the Shotgun " + direction);
	}
	
	@Override
	public String hotkey() {
		return this.hotkey;
	}

}
