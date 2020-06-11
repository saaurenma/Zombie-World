package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Firearm abstract class, child of Item. Used to define base methods for any guns in the game.
 * @author Paul McIntosh
 *
 */
public abstract class Firearm extends Item {
	/**
	 * Character keeps track of the ammunition type used to fire this weapon.
	 */
	private char ammoChar;

	/**
	 * Constructor class
	 * @param name The name of this type of firearm.
	 * @param displayChar The character used to represent this firearm on the world map.
	 * @param ammoChar character representative of this firearm's ammunition type.
	 */
	public Firearm(String name, char displayChar, char ammoChar) {
		super(name, displayChar, true);
		this.ammoChar = ammoChar;
		this.addCapability(FirearmCapabilities.GUN);
	}

	/**
	 * Checks the user's inventory for ammunition for compatible inventory, and expends it as part of the firing process.
	 * @param actor The actor using the firearm.
	 * @return boolean True if there was ammo to use the firearm, false if not.
	 */
	public boolean checkAmmo(Actor actor) {
		for (Item item : actor.getInventory()) {
			if (item.getDisplayChar() == ammoChar) {
				actor.removeItemFromInventory(item);
				return true;
			}
		}
		return false;
	}

	/**
	 * Class used to fire the firearm.
	 * @param actor The actor using the firearm.
	 * @param display The display used to represent the results of firing.
	 * @param map The map on which the weapon is fired.
	 */
	public abstract Action shoot(Actor actor, Display display, GameMap map);
}
