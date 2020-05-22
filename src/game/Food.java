package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;

public class Food extends PortableItem {

	public Food() {
		super("food", 'o');
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Action> getAllowableActions() {
		Actions actions = new Actions();
		actions.add(new EatAction(this));
		List<Action> newActions = actions.getUnmodifiableActionList();
		return newActions;
	}

}
