package game;

import java.util.List;

import edu.monash.fit2099.demo.mars.WindowSmashAction;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Crop extends Item{
	private int age;
	private int ripenTime;
	private Location location;

	public Crop(CropRipeUnripe isRipe) {
		super("crop", '*', false);
		this.addCapability(isRipe);
		age = 0;
		ripenTime = 20;
	}
	
	public void fertilize() {
		
		if (ripenTime > 0) {
			ripenTime -= 10;
		}
		
		else {
			this.removeCapability(CropRipeUnripe.UNRIPE);
			this.addCapability(CropRipeUnripe.RIPE);
			
		}
	}
	
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		this.location = location;
		age++;
		ripenTime--;
		
		if (ripenTime == 0){
			this.removeCapability(CropRipeUnripe.UNRIPE);
			this.addCapability(CropRipeUnripe.RIPE);
		}
		
	}
	
	@Override
	public List<Action> getAllowableActions() {
		Actions actions = new Actions();
		actions.add(new HarvestAction(this, location));
		List<Action> newActions = actions.getUnmodifiableActionList();
		return newActions;
	}
}
