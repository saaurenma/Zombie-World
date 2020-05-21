package game;

import edu.monash.fit2099.engine.WeaponItem;

/**
 * Class representing a severed Zombie arm as a weapon.
 * 
 * @author Paul McIntosh
 *
 */
public class ZombieArm extends WeaponItem {
	//TODO implement ZombieLimbWeapon enum capability, and add javadoc comments

	/**
	 * Constructor for ZombieArm
	 */
	public ZombieArm() {
		super("Zombie Arm", '-', 15, "whacks");
	}
}
