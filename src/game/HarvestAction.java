package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
/***
 * Implements HarvestAction
 * @author Saauren
 *
 */
public class HarvestAction extends Action{
	
	Item cropToBeHarvested;
	Location harvestLocation;

	/***
	 * 
	 * @param crop the crop to be harvested
	 * @param location the location of the crop
	 */
	public HarvestAction(Item crop,Location location) {
		
		this.cropToBeHarvested = crop;
		this.harvestLocation = location;

	}
	/***
	 * Harvests the crop
	 * @param actor the Actor commiting the harvest
	 * @param map the GameMap
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		
		
		cropToBeHarvested.removeCapability(CropRipeUnripe.RIPE);
		harvestLocation.removeItem(cropToBeHarvested);
		if (actor instanceof Player) {
			actor.addItemToInventory(new Food());
		}
		else {
			harvestLocation.addItem(new Food());
		}
		
		String description = actor + " harvested a crop.";
		return description;
	}

	@Override
	public String menuDescription(Actor actor) {
		String description = actor + " harvests a crop.";
		return description;
	}
	

}
