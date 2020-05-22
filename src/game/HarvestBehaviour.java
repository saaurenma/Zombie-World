package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class HarvestBehaviour implements Behaviour {

	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		Location locationOfActor = map.locationOf(actor);
		
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		Collections.shuffle(exits);
		
		
		for (Exit e: exits) {
			List<Item> items = locationOfActor.getItems();
			System.out.println(items.size());
			for (Item item: items) {
				
				if (!(item instanceof Crop)) {
					continue;
				}
				else if (item.hasCapability(CropRipeUnripe.RIPE)){
					return new HarvestAction(item,e.getDestination());
				}
				
			}
			
		}
		
		return null;
	}

}
