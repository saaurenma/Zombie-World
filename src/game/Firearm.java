package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public abstract class Firearm extends Item {

	public Firearm(String name, char displayChar, char ammoChar) {
		super(name, displayChar, true);
	}
	
	public void checkAmmo(Actor actor) {
		if (actor.getInventory().contains()) {
			
		}
	}

	public abstract Action shoot(Actor actor, Display display, GameMap map);
}
