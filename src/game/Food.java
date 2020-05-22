package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
/***
 * Class defining Food
 * @author Saauren
 *
 */
public class Food extends PortableItem {
	/***
	 * Constructor for Food
	 */
	public Food() {
		super("food", 'o');
		// TODO Auto-generated constructor stub
	}
	/***
	 * Add EatAction to Food's allowable actions
	 */
	@Override
	public List<Action> getAllowableActions() {
		Actions actions = new Actions();
		actions.add(new EatAction(this));
		List<Action> newActions = actions.getUnmodifiableActionList();
		return newActions;
	}

}
