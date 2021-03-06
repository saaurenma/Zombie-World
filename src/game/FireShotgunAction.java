package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * Action subclass used to fire a Shotgun, deals area damage.
 * @author Paul McIntosh
 *
 */
public class FireShotgunAction extends Action {

	/**
	 * The direction that the shotgun is to be fired in.
	 */
	private String direction;
	/**
	 * The hotkey representing the direction of fire.
	 */
	private String hotkey;
	/**
	 * Random number generator.
	 */
	private Random rand = new Random();
	/**
	 * The Shotgun item this action is being used to fire.
	 */
	private Shotgun thisGun;

	/**
	 * Constructor class
	 * 
	 * @param direction The direction that the shotgun is to be fired in.
	 * @param hotkey The hotkey representing the direction of fire.
	 * @param thisGun The Shotgun item this action is being used to fire.
	 */
	public FireShotgunAction(String direction, String hotkey, Shotgun thisGun) {
		this.direction = direction;
		this.hotkey = hotkey;
		this.thisGun = thisGun;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		ArrayList<Location> shotLocations;
		if (thisGun.checkAmmo(actor)) {
			Location actorLocation = map.locationOf(actor);
			int actorX = actorLocation.x();
			int actorY = actorLocation.y();
			shotLocations = new ArrayList<Location>();
			if (hotkey == "1") {
				for (int i = 0; i <= 3; i++) {
					for (int j = 0; j <= 3; j++) {
						if (i == 0 && j == 0) {
							continue;
						}
						shotLocations.add(new Location(map, actorX - i, actorY + j));
					}
				}
			} else if (hotkey == "2") {
				for (int i = 1; i <= 3; i++) {
					for (int j = i * -1; j <= i; j++) {
						shotLocations.add(new Location(map, actorX - j, actorY + i));
					}
				}
			} else if (hotkey == "3") {
				for (int i = 0; i <= 3; i++) {
					for (int j = 0; j <= 3; j++) {
						if (i == 0 && j == 0) {
							continue;
						} else
							shotLocations.add(new Location(map, actorX + i, actorY + j));
					}
				}
			} else if (hotkey == "4") {
				for (int i = 1; i <= 3; i++) {
					for (int j = i * -1; j <= i; j++) {
						shotLocations.add(new Location(map, actorX - i, actorY - j));
					}
				}
			} else if (hotkey == "6") {
				for (int i = 1; i <= 3; i++) {
					for (int j = i * -1; j <= i; j++) {
						shotLocations.add(new Location(map, actorX + i, actorY - j));
					}
				}
			} else if (hotkey == "7") {
				for (int i = 0; i <= 3; i++) {
					for (int j = 0; j <= 3; j++) {
						if (i == 0 && j == 0) {
							continue;
						} else
							shotLocations.add(new Location(map, actorX - i, actorY - j));
					}
				}

			} else if (hotkey == "8") {
				for (int i = 1; i <= 3; i++) {
					for (int j = i * -1; j <= i; j++) {
						shotLocations.add(new Location(map, actorX - j, actorY - i));
					}
				}
			} else if (hotkey == "9") {
				for (int i = 0; i <= 3; i++) {
					for (int j = 0; j <= 3; j++) {
						if (i == 0 && j == 0) {
							continue;
						} else
							shotLocations.add(new Location(map, actorX + i, actorY - j));
					}
				}

			} 
		}
		else {
			return "The " + thisGun + " only clicks. It's empty!";
		}
		String result = "";
		
		for (Location location: shotLocations) {
			if (rand.nextFloat() >= 0.25 && location.getActor() != null) {
				Actor target = location.getActor();
				target.hurt(75);
				result += System.lineSeparator() + actor + " blasts " + target + " for 75 damage.";
				if (!target.isConscious()) {
					Corpse corpse = new Corpse("dead " + target, '%');
					map.locationOf(target).addItem(corpse);

					Actions dropActions = new Actions();
					for (Item item : target.getInventory())
						dropActions.add(item.getDropAction());
					for (Action drop : dropActions)
						drop.execute(target, map);
					map.removeActor(target);

					result += System.lineSeparator() + target + " is killed.";
				}

				if (target instanceof Zombie && target.isConscious()) {
					if (rand.nextFloat() >= 0.75) {
						((Zombie) target).limbLoss(map);
					}
				}
			}
		}
		if (result == "") {
			result = System.lineSeparator() + actor + " missed!";				
		}
		return menuDescription(actor) + result;
	}

	@Override
	public String menuDescription(Actor actor) {
		return (actor + " fires the Shotgun " + direction);
	}

	@Override
	public String hotkey() {
		return this.hotkey;
	}

}
