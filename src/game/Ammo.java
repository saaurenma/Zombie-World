package game;

import edu.monash.fit2099.engine.Item;

public abstract class Ammo extends Item {

	public Ammo(String name, char displayChar) {
		super(name, displayChar, true);
	}

}
