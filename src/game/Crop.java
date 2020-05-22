package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/***
 * This class implements a Crop Item object
 * @author Saauren
 *
 */
public class Crop extends Item{
	private int age;
	private int ripenTime;
	private Location location;

	/***
	 * Constructor for a Crop, with time to ripen and age initialisation
	 * @param isRipe an Enum CropRipeUnripe defining whether the crop is ripe or not
	 * 
	 */
	public Crop(CropRipeUnripe isRipe) {
		super("crop", '*', false);
		this.addCapability(isRipe);
		age = 0;
		ripenTime = 20;
	}
	/***
	 * Method to fertilize a Crop (this method is used by Actors)
	 */
	public void fertilize() {
		
		if (ripenTime > 0) {
			ripenTime -= 10;
		}
		
		else {
			this.removeCapability(CropRipeUnripe.UNRIPE);
			this.addCapability(CropRipeUnripe.RIPE);
			
		}
	}
	
	/***
	 * Responsible for tracking age and ripenTime, also switches Crops to ripe
	 * when left alone
	 * 
	 * @param location the location of the crop
	 */
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
	
	/***
	 * Returns a list of Actions for Crops, more specifically HarvestAction
	 * @return newActions the allowable actions for crops
	 */
	@Override
	public List<Action> getAllowableActions() {
		Actions actions = new Actions();
		actions.add(new HarvestAction(this, location));
		List<Action> newActions = actions.getUnmodifiableActionList();
		return newActions;
	}
}
