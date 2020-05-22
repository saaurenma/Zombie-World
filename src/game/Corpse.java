package game;

import java.util.Random;


import edu.monash.fit2099.engine.Location;

/**
 * Class defining Corpse PortableItem
 * 
 * @author Saauren
 *
 */
public class Corpse extends PortableItem {
	
	private int age = 0;
	private int timeToRiseFromDead;
	Random rand = new Random();

	/**
	 * Constructor for Corpse, these params are filled out for us in AttackAction.
	 * 
	 * @param name The name of the corpse
	 * @param displayChar The character used for corpse
	 */
	public Corpse(String name, char displayChar) {
		super(name, displayChar);
		setTimeToRiseFromDead();
		
	}
	
	/***
	 * sets how much time (days) there is until the corpse rises from the dead
	 * by random
	 */
	private void setTimeToRiseFromDead(){
		int randNumber;
		randNumber = Math.abs(rand.nextInt(5) + 1) + 5;
		
		this.timeToRiseFromDead = randNumber;
		
	}
	
	/***
	 *Is responsible for rising the corpse from the dead since it
	 *is called on each turn.
	 *
	 * @param currentLocation the location of the corpse
	 */
	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);
		// increase day by 1
		age++;
		
		if (this.timeToRiseFromDead == age) {
			
			currentLocation.removeItem(this);
			if (!currentLocation.containsAnActor()) {
				currentLocation.addActor(new Zombie("Aaargh"));
			}
			
		}

	}
	

}
