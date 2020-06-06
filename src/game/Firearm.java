package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Item;

public abstract class Firearm extends Item {

	public Firearm(String name, char displayChar) {
		super(name, displayChar, true);
	}
	
//	public void checkAmmo() {
	//TODO IMPLEMENT THIS
//	}

	public abstract Action shoot(Actor actor, Display display);
}
