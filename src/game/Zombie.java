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
	private Behaviour[] behaviours = {
			new AttackBehaviour(ZombieCapability.ALIVE),
			new PickUpBehaviour(),
			new HuntBehaviour(Human.class, 10),
			new WanderBehaviour()
	};
	private Behaviour[] leglessBehaviours = {
			new AttackBehaviour(ZombieCapability.ALIVE),
			new PickUpBehaviour(),
	};
	
	private Boolean slowWalk = false;
	
	private int zombieArms;
	private int zombieLegs;

	public Zombie(String name) {
		super(name, 'Z', 100, ZombieCapability.UNDEAD);
		zombieArms = 2;
		zombieLegs = 2;
	}
	

	@Override
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
	
	//TODO javadoc
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
	
	//TODO javadoc.
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
