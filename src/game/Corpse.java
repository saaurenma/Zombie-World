package game;

import java.util.Random;

import edu.monash.fit2099.engine.Location;

public class Corpse extends PortableItem {
	
	private int age = 0;
	private int timeToRiseFromDead;
	

	public Corpse(String name, char displayChar) {
		super(name, displayChar);
		setTimeToRiseFromDead();
		
	}
	
	
	private void setTimeToRiseFromDead(){
		Random rand = new Random();
		int randNumber;
		randNumber = Math.abs(rand.nextInt(5) + 1) + 5;
		
		this.timeToRiseFromDead = randNumber;
		
	}
	
	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);
		
		// increase day by 1
		age++;

	}
	

}
