package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
/***
 * A class defining a FertlizeAction
 * @author Saauren
 *
 */
public class FertilizeAction extends Action {
	// the crop not yet fertilized
	Item unfertilizedCrop;
	
	/**
	 * Constructor for FertilizeAction
	 * @param crop the crop to be fertilized
	 * 
	 */
	public FertilizeAction(Item crop) {
		this.unfertilizedCrop = crop;
	}

	/***
	 * Crop is fertilized here, calling the method from the Crop class
	 * 
	 * @param actor The actor fertilizing
	 * @param map The gamemap
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		unfertilizedCrop.fertilize();
		String result = actor + " fertilized the crop.";
		return result;
	}
	

	@Override
	public String menuDescription(Actor actor) {
		
		String description = actor + " fertlizes a crop";
		
		return description;
	}
	

}
