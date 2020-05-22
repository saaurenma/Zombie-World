package game;

import java.util.Random;

import edu.monash.fit2099.engine.Location;

public class Corpse extends PortableItem {
	
	private int age = 0;
	private int timeToRiseFromDead;
	Random rand = new Random();


	public Corpse(String name, char displayChar) {
		super(name, displayChar);
		setTimeToRiseFromDead();
		
	}
	
	
	private void setTimeToRiseFromDead(){
		int randNumber;
		randNumber = Math.abs(rand.nextInt(5) + 1) + 5;
		
		this.timeToRiseFromDead = randNumber;
		
	}
	
	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);
		// increase day by 1
		age++;
		
		if (this.timeToRiseFromDead == age) {
			
			currentLocation.removeItem(this);
			currentLocation.addActor(new Zombie("Aaargh"));
			
		}

	}
	

}
