package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 */
public class Player extends Human {

	private Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		boolean rifleToggle = false;
		SniperRifle rifleItem = null;
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		for (Item item: inventory) {
			if (item instanceof Firearm) {
				actions.add(new ReadyFirearmAction((Firearm) item, display));
				if (item instanceof SniperRifle) {
					rifleItem = ((SniperRifle) item);
					rifleToggle = true;
				}
			}
		}
		Action playerAction = menu.showMenu(this, actions, display);
		if (rifleToggle) {
			if (!(playerAction instanceof AimSniperAction)) {
				rifleItem.clearTarget();
			}
		}
		return playerAction;
	}
	
}

