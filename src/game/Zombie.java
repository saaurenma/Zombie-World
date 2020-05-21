package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.Item;

/**
 * A Zombie.
 * 
 * This Zombie is pretty boring.  It needs to be made more interesting.
 * 
 * @author ram
 *
 */
public class Zombie extends ZombieActor {
	/**
	 * List of behaviours the Zombie is capable of performing normally.
	 */
	private Behaviour[] behaviours = {
			new AttackBehaviour(ZombieCapability.ALIVE),
			new PickUpBehaviour(),
			new HuntBehaviour(Human.class, 10),
			new WanderBehaviour()
	};
	
	/**
	 * List of behaviours the Zombie is capable of performing with damaged or removed legs.
	 */
	private Behaviour[] leglessBehaviours = {
			new AttackBehaviour(ZombieCapability.ALIVE),
			new PickUpBehaviour(),
	};
	
	/**
	 * Toggle to determine if the Zombie can move on a given turn.
	 */
	private Boolean slowWalk = false;
	
	/**
	 * Number of arms the Zombie has attached.
	 */
	private int zombieArms;
	
	/**
	 * Number of legs the Zombie has attached.
	 */
	private int zombieLegs;
	
/**
 * Constructor for the Zombie class.
 * @param name The name of the Zombie.
 */
	public Zombie(String name) {
		super(name, 'Z', 100, ZombieCapability.UNDEAD);
		zombieArms = 2;
		zombieLegs = 2;
	}
	

	@Override
	/**
	 * Unique IntrinsicWeapon getter for Zombie.
	 * Gives a chance of returning a Bite rather than a Punch.
	 * The bite chance increases as the Zombie loses arms.
	 */
	public IntrinsicWeapon getIntrinsicWeapon() {
		Random rand = new Random();
		if (zombieArms == 2 && rand.nextFloat() >= 0.5) {
			return new IntrinsicWeapon(10, "punches");
		}
		if (zombieArms == 1 && rand.nextFloat() >= 0.75) {
			return new IntrinsicWeapon(10, "punches");
		}
		else {
			return new IntrinsicWeapon(15, "bites");
		}
	}

	/**
	 * If a Zombie can attack, it will. If not, it will pick up any items at its feet.
	 * If not, it will chase any human within 10 spaces.  
	 * If no humans are close enough it will wander randomly.
	 * 
	 * @param actions list of possible Actions
	 * @param lastAction previous Action, if it was a multiturn action
	 * @param map the map where the current Zombie is
	 * @param display the Display where the Zombie's utterances will be displayed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		Random rand = new Random();
		
		if (rand.nextFloat() <= 0.10) {
			System.out.println(name + " moans. Rauuuurgh!");
		}
		if (zombieLegs == 0) {
			slowWalk = true;
		}
		if (zombieLegs == 1) {
			slowWalk = !slowWalk;
		}
		if (slowWalk == false) {
			for (Behaviour behaviour : behaviours) {
				Action action = behaviour.getAction(this, map);
				if (action != null)
					return action;
			} 
		}
		if (slowWalk == true) {
			for (Behaviour behaviour : leglessBehaviours) {
				Action action = behaviour.getAction(this, map);
				if (action != null)
					return action;
			} 
		}
		return new DoNothingAction();
	}
	
	/**
	 * Getter for zombieArms
	 * @return int representing the number of arms attached to this Zombie.
	 */
	public int getZombieArms() {
		return zombieArms;
	}
	
	/**
	 * Getter for zombieLegs
	 * @return int representing the number of legs attached to this Zombie.
	 */
	public int getZombieLegs() {
		return zombieLegs;
	}
	
	/**
	 * Determines which limb the Zombie loses, based on its remaining limbs.
	 * Creates and drops a ZombieArm or ZombieLeg object, depending on the limb lost.
	 * @param map the map where the current Zombie is
	 */
	public void limbLoss(GameMap map) {
		if (zombieArms == 0 && zombieLegs == 0) {
			return;
		}
		if (zombieArms > 0 && zombieLegs > 0) {
			Random rand = new Random();
			if (rand.nextBoolean()) {
				new DropItemAction(new ZombieArm()).execute(this, map);
				zombieArms -= 1;
				System.out.println(name + " loses their arm!");
				fumbleWeapons(map);
				return;
			}
			else {
				new DropItemAction(new ZombieLeg()).execute(this, map);
				zombieLegs -= 1;
				System.out.println(name + " loses their leg!");
				return;
			}
		}
		if (zombieArms > 0 && zombieLegs == 0) {
			new DropItemAction(new ZombieArm()).execute(this, map);
			zombieArms -= 1;
			System.out.println(name + " loses their arm!");
			fumbleWeapons(map);
			return;
		}
		if (zombieArms == 0 && zombieLegs > 0) {
			new DropItemAction(new ZombieLeg()).execute(this, map);
			zombieLegs -= 1;
			System.out.println(name + " loses their leg!");
			return;
		}
	}
	
	/**
	 * Drops the Zombie's weapons when it loses an arm. 
	 * 50% chance if the Zombie has one arm, 100% if it has none.
	 * @param map the map where the current Zombie is
	 */
	public void fumbleWeapons(GameMap map) {
		Random rand = new Random();
		if (zombieArms == 1) {
			if (rand.nextBoolean()) {
				return;
			}
		}
		ArrayList<Item> dropList = new ArrayList<Item>();
		for (Item i: inventory) {
			if (i.asWeapon() != null) {
				dropList.add(i);
			}
		}
		for (Item j: dropList) {
			j.getDropAction().execute(this, map);
			System.out.println(name + " drops their " + j.toString());
		}
	}
}
