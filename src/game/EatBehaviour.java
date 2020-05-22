package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
/***
 * Behaviour for Eating, is used by Humans and Player
 * @author Saauren
 *
 */
public class EatBehaviour implements Behaviour {
	/***
	 * Returns EatAction after checking if the Item is Food
	 * @param actor the actor
	 * @param map the GameMap
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		List<Item> items = map.locationOf(actor).getItems();
		
		for(int i = 0; i < items.size(); i++) {
			Item currentItem = items.get(i);
			Item possibleFood = currentItem;
			if(possibleFood instanceof Food) {
				return new EatAction(possibleFood);
				
			}
		}
		return null;	
	}

}
