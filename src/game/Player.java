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
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		for (Item item : inventory) {
			if (item.hasCapability(FirearmCapabilities.GUN)) {
				actions.add(new ReadyFirearmAction(item, display));
			}
		}
		Action playerAction = menu.showMenu(this, actions, display);
		if (playerAction.stoppedAiming()) {
			for (Item item : inventory) {
				item.clearTarget();
			}
		}
		return playerAction;
	}

	@Override
	/**
	 * Do some damage to the current Actor.
	 *
	 * If the Actor's hitpoints go down to zero, it will be knocked out. This
	 * override to the Player class also clears any held Sniper Rifle aiming on
	 * damage taken.
	 *
	 * @param points number of hitpoints to deduct.
	 */
	public void hurt(int points) {
		hitPoints -= points;
		for (Item item : inventory) {
			if (item.hasCapability(FirearmCapabilities.AIMED)) {
				item.clearTarget();
			}
		}
	}

}
