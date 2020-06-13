package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Weapon;
import edu.monash.fit2099.engine.WeaponItem;
/***
 * Defines an Action of a weapon being crafted
 * 
 * @author Saauren
 *
 */
public class CraftAction extends Action{
	WeaponItem weaponToBeCrafted;
	
	/***
	 * Constructor for CraftAction
	 * @param weapon The weapon to be crafted
	 */
	public CraftAction(WeaponItem weapon) {
		this.weaponToBeCrafted = weapon;
	}
	

	@Override
	public String execute(Actor actor, GameMap map) {
		
		if (this.weaponToBeCrafted instanceof ZombieArm) {
			weaponToBeCrafted.removeCapability(ZombieLimbWeapon.LIMB);
			weaponToBeCrafted.addCapability(ZombieLimbWeapon.CLUB);
			return actor + "crafted arm to " + "CLUB";
		}
		
		else if (this.weaponToBeCrafted instanceof ZombieLeg) {
			weaponToBeCrafted.removeCapability(ZombieLimbWeapon.LIMB);
			weaponToBeCrafted.addCapability(ZombieLimbWeapon.MACE);
			return actor + "crafted leg to " + "MACE";
		}
		return null;

	}

	@Override
	public String menuDescription(Actor actor) {
		if (this.weaponToBeCrafted instanceof ZombieArm) {
			return actor + "craft arm to " + "CLUB";
		}
		
		else if (this.weaponToBeCrafted instanceof ZombieLeg) {

			return actor + "craft leg to " + "MACE";
		}
		return null;
 
	}
	

}
