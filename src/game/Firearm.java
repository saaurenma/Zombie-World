package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public abstract class Firearm extends Item {
	private char ammoChar;

	public Firearm(String name, char displayChar, char ammoChar) {
		super(name, displayChar, true);
		this.ammoChar = ammoChar;
		this.addCapability(FirearmCapabilities.GUN);
	}

	public boolean checkAmmo(Actor actor) {
		for (Item item : actor.getInventory()) {
			if (item.getDisplayChar() == ammoChar) {
				actor.removeItemFromInventory(item);
				return true;
			}
		}
		return false;
	}

	public abstract Action shoot(Actor actor, Display display, GameMap map);
}
