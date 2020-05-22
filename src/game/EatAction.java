package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
/***
 * 
 * @author Saauren
 *
 * Action for when Actor wants to eat Food
 */
public class EatAction extends Action {
	
	Item foodToBeEaten;
	
	/***
	 * Constructor for EatAction
	 * @param currentItem the item to be eaten
	 * 
	 */
	public EatAction(Item currentItem) {
		this.foodToBeEaten = currentItem;
	}

	/***
	 * Perform EatAction and heal the actor. Also remove the item from inventory
	 * after they have eaten.
	 * 
	 * @param actor the actor
	 * @param map the gamemap
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		actor.removeItemFromInventory(foodToBeEaten);
		actor.heal(10);
		String result = actor + " ate some food. They were healed by 10 points.";
		return result;
	}
	
	
	@Override
	public String menuDescription(Actor actor) {
		String description = actor + " eats some food.";
		return description;
	}
	

}
