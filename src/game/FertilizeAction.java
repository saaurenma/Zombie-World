package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class FertilizeAction extends Action {
	
	Item unfertilizedCrop;
	
	public FertilizeAction(Item crop) {
		this.unfertilizedCrop = crop;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		unfertilizedCrop.fertilize();
	}

	@Override
	public String menuDescription(Actor actor) {
		
		String description = actor + "fertlized the crop.";
		
		return description;
	}
	

}
