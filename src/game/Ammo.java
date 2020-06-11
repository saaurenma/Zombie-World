package game;

import edu.monash.fit2099.engine.Item;

/**
 * An abstract Item subclass, used to group all kinds of ammunition under one parent class.
 * Necessary to hold related ammunition in Player inventory to fire a Firearm.
 * 
 * @author Paul McIntosh
 *
 */
public abstract class Ammo extends Item {

	/**
	 * @param name The name of the ammo type.
	 * @param displayChar The character used to display the ammo on the world map.
	 */
	public Ammo(String name, char displayChar) {
		super(name, displayChar, true);
	}

}
