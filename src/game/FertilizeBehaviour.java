package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
/***
 * A class defining FertilizeBehaviour
 * 
 * @author Saauren
 *
 */
public class FertilizeBehaviour implements Behaviour {
	
	/**
	 * Returns a FertilizeAction, passing the crop to be fertilized.
	 * The crop to be fertilized is found after scanning that is done here
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		

		List<Item> items = map.locationOf(actor).getItems();
		
		for(int i = 0; i < items.size(); i++) {
			Item currentItem = items.get(i);
			Item possibleCrop = currentItem;
			if(possibleCrop instanceof Crop) {
				if (currentItem.hasCapability(CropRipeUnripe.UNRIPE)){
					return new FertilizeAction(possibleCrop);
				}
				
			}
		}
		return null;		
	}

}
