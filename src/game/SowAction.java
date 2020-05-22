package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class SowAction extends Action {
	
	Location sowLocation;

	
	public SowAction(Location location) {
		this.sowLocation = location;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		
		sowLocation.addItem(new Crop(CropRipeUnripe.UNRIPE));
		String executeDescription = actor + " sows a crop at location " + "("+sowLocation.x() + "," + sowLocation.y()+")";
		return executeDescription;
	}

	@Override
	public String menuDescription(Actor actor) {
		String executeDescription = actor + " sows a crop";
		return executeDescription;

	}

}
