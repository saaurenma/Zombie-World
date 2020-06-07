package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

public class Shotgun extends Firearm {
	
	private Actions actions = new Actions();

	public Shotgun() {
		super("Shotgun", 'S');
		actions.add(new FireShotgunAction("South-West", "1"));
		actions.add(new FireShotgunAction("South", "2"));
		actions.add(new FireShotgunAction("South-East", "3"));
		actions.add(new FireShotgunAction("West", "4"));
		actions.add(new FireShotgunAction("East", "6"));
		actions.add(new FireShotgunAction("North-West", "7"));
		actions.add(new FireShotgunAction("North", "8"));
		actions.add(new FireShotgunAction("North-East", "9"));
	}
	
	@Override
	public Action shoot(Actor actor, Display display, GameMap map) {
		Menu shotgunMenu = new Menu();
		return shotgunMenu.showMenu(actor, actions, display);
	}

}
