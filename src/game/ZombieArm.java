package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * Class representing a severed Zombie arm as a weapon.
 * 
 * @author Paul McIntosh, Saauren Mankad for getAllowableActions
 *
 */
public class ZombieArm extends WeaponItem {
	// TODO implement ZombieLimbWeapon enum capability, and add javadoc comments

	/**
	 * Constructor for ZombieArm
	 */
	public ZombieArm() {
		super("Zombie Arm", '-', 15, "whacks");
		this.addCapability(ZombieLimbWeapon.LIMB);
	}
	
	public ZombieArm(int damage) {
		super("Zombie Arm", '-', damage, "whacks");
		this.addCapability(ZombieLimbWeapon.LIMB);
	}

	@Override
	public List<Action> getAllowableActions() {
		Actions actions = new Actions();
		actions.add(new CraftAction(this));
		List<Action> newActions = actions.getUnmodifiableActionList();
		return newActions;
	}
	
 
	public void tick(Location currentLocation, Actor actor) {
		if (this.hasCapability(ZombieLimbWeapon.CLUB)) {
			currentLocation.removeItem(this);
			currentLocation.addItem(new ZombieArm(25));
		}
		
	}
}
